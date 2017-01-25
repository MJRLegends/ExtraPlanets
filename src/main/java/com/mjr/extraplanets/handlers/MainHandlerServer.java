package com.mjr.extraplanets.handlers;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler.ThermalArmorEvent;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IRadiationSuit;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.client.handlers.EPPlayerStatsClient;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.network.ExtraPlanetsPacketHandler;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;
import com.mjr.extraplanets.util.DamageSourceEP;
import com.mjr.extraplanets.world.EPWorldProviderSpace;

public class MainHandlerServer {

	private static List<ExtraPlanetsPacketHandler> packetHandlers = Lists.newCopyOnWriteArrayList();

	public static void addPacketHandler(ExtraPlanetsPacketHandler handler) {
		MainHandlerServer.packetHandlers.add(handler);
	}

	@SubscribeEvent
	public void worldUnloadEvent(WorldEvent.Unload event) {
		for (ExtraPlanetsPacketHandler packetHandler : packetHandlers) {
			packetHandler.unload(event.world);
		}
	}

	@SubscribeEvent
	public void onWorldTick(WorldTickEvent event) {
		if (event.phase == Phase.END) {
			final WorldServer world = (WorldServer) event.world;

			for (ExtraPlanetsPacketHandler handler : packetHandlers) {
				handler.tick(world);
			}
		}
	}

	@SubscribeEvent
	public void onEntityDealth(LivingDeathEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			final EntityLivingBase entityLiving = event.entityLiving;
			final EPPlayerStats EPPlayer = EPPlayerStats.get((EntityPlayerMP) entityLiving);
			EPPlayer.radiationLevel = 0;
		}
	}

	@SubscribeEvent
	public void onPlayer(PlayerTickEvent event) {
		if (event.player.worldObj.provider.getDimensionId() == Config.jupiterID) {
			Random rand = new Random();
			int addX = rand.nextInt(25);
			int addZ = rand.nextInt(25);
			if (rand.nextInt(2) == 1)
				addX = -addX;
			if (rand.nextInt(2) == 1)
				addZ = -addZ;
			int lightingSpawnChance = rand.nextInt(50);
			if (lightingSpawnChance == 10) {
				event.player.worldObj.addWeatherEffect(new EntityLightningBolt(event.player.worldObj, event.player.posX + addX, event.player.worldObj.getHeight(new BlockPos(event.player.posX + addX, 0, (int) event.player.posZ + addZ)).getY(),
						event.player.posZ + addZ));
			}
		}
	}

	@SubscribeEvent
	public void onThermalArmorEvent(ThermalArmorEvent event) {
		if (event.armorStack == null) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.REMOVE);
			return;
		}
		if (event.armorStack.getItem() == AsteroidsItems.thermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.tier2ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.tier3ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.tier4ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.NOTHING);
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayerMP && EPPlayerStats.get((EntityPlayerMP) event.entity) == null) {
			EPPlayerStats.register((EntityPlayerMP) event.entity);
		}
		if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			this.onEntityConstructingClient(event);
		}
	}

	@SideOnly(Side.CLIENT)
	public void onEntityConstructingClient(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayerSP) {
			if (EPPlayerStatsClient.get((EntityPlayerSP) event.entity) == null) {
				EPPlayerStatsClient.register((EntityPlayerSP) event.entity);
			}

			Minecraft.getMinecraft().gameSettings.sendSettingsToServer();
		}
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
		final EntityLivingBase entityLiving = event.entityLiving;
		if (entityLiving instanceof EntityPlayerMP) {
			if (Config.pressure)
				checkPressure(event, entityLiving);
			if (Config.radiation)
				checkRadiation(event, entityLiving);
			onPlayerUpdate((EntityPlayerMP) entityLiving);
		}
	}

	private void checkPressure(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP playerMP = (EntityPlayerMP) entityLiving;
		if (entityLiving.worldObj.provider instanceof IGalacticraftWorldProvider && !playerMP.capabilities.isCreativeMode) {
			if ((playerMP.worldObj.provider instanceof EPWorldProviderSpace)) {
				EPWorldProviderSpace provider = (EPWorldProviderSpace) playerMP.worldObj.provider;
				int pressureLevel = provider.getPressureLevel();
				for (int i = 0; i < 4; i++) {
					ItemStack stack = playerMP.getCurrentArmor(i);
					if ((stack == null) || (!(stack.getItem() instanceof IPressureSuit))) {
						if (pressureLevel >= 8 && pressureLevel < 25)
							playerMP.attackEntityFrom(DamageSourceEP.pressure, 1.5F);
						else if (pressureLevel > 25 && pressureLevel < 50)
							playerMP.attackEntityFrom(DamageSourceEP.pressure, 2F);
						else if (pressureLevel >= 50 && pressureLevel < 75)
							playerMP.attackEntityFrom(DamageSourceEP.pressure, 2.5F);
						else if (pressureLevel >= 75)
							playerMP.attackEntityFrom(DamageSourceEP.pressure, 3.5F);
					}
				}
			}
		}
	}

	private void checkRadiation(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP playerMP = (EntityPlayerMP) entityLiving;
		if (entityLiving.worldObj.provider instanceof IGalacticraftWorldProvider && !playerMP.capabilities.isCreativeMode) {
			if ((playerMP.worldObj.provider instanceof EPWorldProviderSpace)) {
				EPWorldProviderSpace provider = (EPWorldProviderSpace) playerMP.worldObj.provider;
				// Normal/Nothing 0.005
				// Tier 1 0.0045
				// Tier 2 0.004
				// Tier 3 0.0035
				// Tier 4 0.00325
				boolean doDamage = false;
				boolean doArmorCheck = false;
				double damageModifer = 0;
				int radiationLevel = provider.getSolarRadiationLevel();
				if (playerMP.getCurrentArmor(0) == null || playerMP.getCurrentArmor(1) == null || playerMP.getCurrentArmor(2) == null || playerMP.getCurrentArmor(3) == null) {
					damageModifer = 0.005;
					doDamage = true;
				} else if (!(playerMP.getCurrentArmor(0).getItem() instanceof IRadiationSuit) && !(playerMP.getCurrentArmor(1).getItem() instanceof IRadiationSuit) && !(playerMP.getCurrentArmor(2).getItem() instanceof IRadiationSuit)
						&& !(playerMP.getCurrentArmor(3).getItem() instanceof IRadiationSuit)) {
					damageModifer = 0.005;
					doDamage = true;
				} else if (playerMP.getCurrentArmor(0).getItem() instanceof IRadiationSuit) {
					doArmorCheck = true;
					doDamage = false;
				}
				if (doArmorCheck) {
					int helmetTier = ((IRadiationSuit) playerMP.getCurrentArmor(0).getItem()).getArmorTier();
					int chestTier = ((IRadiationSuit) playerMP.getCurrentArmor(1).getItem()).getArmorTier();
					int legginsTier = ((IRadiationSuit) playerMP.getCurrentArmor(2).getItem()).getArmorTier();
					int bootsTier = ((IRadiationSuit) playerMP.getCurrentArmor(3).getItem()).getArmorTier();

					int tierValue = (helmetTier + chestTier + legginsTier + bootsTier) / 2;
					double damageToTake = 0.005 * tierValue;
					damageModifer = 0.005 - (damageToTake / 2) / 10;

					doDamage = true;
				}
				if (doDamage) {
					final EPPlayerStats EPPlayer = EPPlayerStats.get(playerMP);
					if (EPPlayer.radiationLevel >= 100)
						playerMP.attackEntityFrom(DamageSourceEP.radiation, 3F);
					else if (EPPlayer.radiationLevel >= 0)
						EPPlayer.radiationLevel = EPPlayer.radiationLevel + (damageModifer * (radiationLevel / 10));
					else
						EPPlayer.radiationLevel = 0;

				}
			}
		}
	}

	public void onPlayerUpdate(EntityPlayerMP player) {
		int tick = player.ticksExisted - 1;

		// This will speed things up a little
		final EPPlayerStats GCPlayer = EPPlayerStats.get(player);
		final boolean isInGCDimension = player.worldObj.provider instanceof IGalacticraftWorldProvider;

		if (isInGCDimension && Config.radiation) {
			if (tick % 30 == 0) {
				this.sendSolarRadiationPacket(player, GCPlayer);
			}

		}
	}

	protected void sendSolarRadiationPacket(EntityPlayerMP player, EPPlayerStats playerStats) {
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_UPDATE_SOLAR_RADIATION_LEVEL, player.worldObj.provider.getDimensionId(), new Object[] { playerStats.radiationLevel }), player);
	}

}
