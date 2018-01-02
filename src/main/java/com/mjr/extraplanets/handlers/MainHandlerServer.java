package com.mjr.extraplanets.handlers;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.entities.EntityLanderBase;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler.ThermalArmorEvent;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityProviderStatsClient;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.entities.rockets.EntityElectricRocketBase;
import com.mjr.extraplanets.handlers.capabilities.CapabilityProviderStats;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.handlers.capabilities.IStatsCapability;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.network.ExtraPlanetsPacketHandler;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;
import com.mjr.extraplanets.util.DamageSourceEP;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;

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
	public void onPlayerCloned(PlayerEvent.Clone event) {
		if (event.wasDeath) {
			IStatsCapability oldStats = event.original.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
			IStatsCapability newStats = event.entityPlayer.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);

			newStats.copyFrom(oldStats, false);
		}
	}

	@SubscribeEvent
	public void onEntityDealth(LivingDeathEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			final EntityLivingBase entityLiving = event.entityLiving;
			IStatsCapability stats = null;

			if (entityLiving != null) {
				stats = entityLiving.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
			}
			if (stats.getRadiationLevel() >= 85)
				stats.setRadiationLevel(80);
			else if (stats.getRadiationLevel() >= 65 && stats.getRadiationLevel() < 85)
				stats.setRadiationLevel(60);
			else if (stats.getRadiationLevel() >= 50 && stats.getRadiationLevel() < 65)
				stats.setRadiationLevel(50);
		}
	}

	@SubscribeEvent
	public void onPlayer(PlayerTickEvent event) {
		if (Config.JUITPER_LIGHTING && event.player.worldObj.provider.getDimensionId() == Config.JUPITER_ID) {
			Random rand = new Random();
			int addX = rand.nextInt(64);
			int addZ = rand.nextInt(64);
			if (rand.nextInt(2) == 1)
				addX = -addX;
			if (rand.nextInt(2) == 1)
				addZ = -addZ;
			if (addX <= 10)
				addX = 10;
			if (addZ <= 10)
				addZ = 10;
			int lightingSpawnChance = rand.nextInt(100);
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
		if (event.armorStack.getItem() == ExtraPlanets_Items.TIER_3_THERMAL_PADDING && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.TIER_4_THERMAL_PADDING && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.TIER_5_THERMAL_PADDING && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.NOTHING);
	}

	@SubscribeEvent
	public void onAttachCapability(AttachCapabilitiesEvent.Entity event) {
		if (event.getEntity() instanceof EntityPlayerMP) {
			event.addCapability(CapabilityStatsHandler.EP_PLAYER_PROP, new CapabilityProviderStats((EntityPlayerMP) event.getEntity()));

		} else if (event.getEntity() instanceof EntityPlayer && ((EntityPlayer) event.getEntity()).worldObj.isRemote) {
			this.onAttachCapabilityClient(event);
		}
	}

	@SideOnly(Side.CLIENT)
	private void onAttachCapabilityClient(AttachCapabilitiesEvent.Entity event) {
		if (event.getEntity() instanceof EntityPlayerSP)
			event.addCapability(CapabilityStatsClientHandler.EP_PLAYER_CLIENT_PROP, new CapabilityProviderStatsClient((EntityPlayerSP) event.getEntity()));
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
		final EntityLivingBase entityLiving = event.entityLiving;
		if (entityLiving instanceof EntityPlayerMP) {
			if (isInGlowstone((EntityPlayerMP) entityLiving))
				entityLiving.addPotionEffect(new PotionEffect(Potion.nightVision.id, 500, 0));
			onPlayerUpdate((EntityPlayerMP) entityLiving);
			if (OxygenUtil.isAABBInBreathableAirBlock(entityLiving.worldObj, entityLiving.getEntityBoundingBox(), true) == false)
				runChecks(event, entityLiving);
		}
	}

	public boolean isInGlowstone(EntityPlayerMP player) {
		return player.worldObj.isMaterialInBB(player.getEntityBoundingBox().expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), ExtraPlanets_Fluids.GLOWSTONE_MATERIAL);
	}

	private void runChecks(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		if (((EntityPlayerMP) entityLiving).capabilities.isCreativeMode)
			return;
		if ((entityLiving.ridingEntity instanceof EntityLanderBase))
			return;
		if ((entityLiving.ridingEntity instanceof EntityElectricRocketBase))
			return;
		if ((entityLiving.ridingEntity instanceof EntitySpaceshipBase))
			return;
		if ((entityLiving.worldObj.provider instanceof IGalacticraftWorldProvider) && (((EntityPlayerMP) entityLiving).worldObj.provider instanceof WorldProviderRealisticSpace)) {
			if (Config.PRESSURE)
				checkPressure(event, entityLiving);
			if (Config.RADIATION)
				checkRadiation(event, entityLiving);
		} else
			return;
	}

	private void checkPressure(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP playerMP = (EntityPlayerMP) entityLiving;

		ItemStack helmet = playerMP.inventory.armorInventory[0];
		ItemStack chest = playerMP.inventory.armorInventory[1];
		ItemStack leggins = playerMP.inventory.armorInventory[2];
		ItemStack boots = playerMP.inventory.armorInventory[3];

		boolean doDamage = false;

		if (helmet == null || !(helmet.getItem() instanceof IPressureSuit))
			doDamage = true;
		else if (chest == null || !(chest.getItem() instanceof IPressureSuit))
			doDamage = true;
		else if (leggins == null || !(leggins.getItem() instanceof IPressureSuit))
			doDamage = true;
		else if (boots == null || !(boots.getItem() instanceof IPressureSuit))
			doDamage = true;

		if (doDamage) {
			float tempLevel = ((WorldProviderRealisticSpace) playerMP.worldObj.provider).getPressureLevel();
			tempLevel = (tempLevel / 100) * 8;
			playerMP.attackEntityFrom(DamageSourceEP.pressure, tempLevel);
		}
	}

	private void checkRadiation(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP playerMP = (EntityPlayerMP) entityLiving;

		WorldProviderRealisticSpace provider = (WorldProviderRealisticSpace) playerMP.worldObj.provider;
		// Tier 1 Space Suit
		// 25 Level = 36 mins
		// 50 Level = 14 mins
		// Tier 2 Space Suit
		// 25 Level = 38 mins
		// 50 Level = 15 mins

		boolean doDamage = false;
		boolean doArmorCheck = false;
		double damageModifer = 0;
		int radiationLevel = provider.getSolarRadiationLevel();
		if (playerMP.inventory.armorInventory[0] == null || playerMP.inventory.armorInventory[1] == null || playerMP.inventory.armorInventory[2] == null || playerMP.inventory.armorInventory[3] == null) {
			damageModifer = 0.1;
			doDamage = true;
		} else if (!(playerMP.inventory.armorInventory[0].getItem() instanceof IRadiationSuit) && !(playerMP.inventory.armorInventory[1].getItem() instanceof IRadiationSuit)
				&& !(playerMP.inventory.armorInventory[2].getItem() instanceof IRadiationSuit) && !(playerMP.inventory.armorInventory[3].getItem() instanceof IRadiationSuit)) {
			damageModifer = 0.1;
			doDamage = true;
		} else if (playerMP.inventory.armorInventory[0].getItem() instanceof IRadiationSuit && playerMP.inventory.armorInventory[1].getItem() instanceof IRadiationSuit && playerMP.inventory.armorInventory[2].getItem() instanceof IRadiationSuit
				&& playerMP.inventory.armorInventory[3].getItem() instanceof IRadiationSuit) {
			doArmorCheck = true;
			doDamage = false;
		} else {
			damageModifer = 0.1;
			doDamage = true;
		}
		if (doArmorCheck) {
			int helmetTier = ((IRadiationSuit) playerMP.inventory.armorInventory[0].getItem()).getArmorTier();
			int chestTier = ((IRadiationSuit) playerMP.inventory.armorInventory[1].getItem()).getArmorTier();
			int legginsTier = ((IRadiationSuit) playerMP.inventory.armorInventory[2].getItem()).getArmorTier();
			int bootsTier = ((IRadiationSuit) playerMP.inventory.armorInventory[3].getItem()).getArmorTier();

			int tierValue = (helmetTier + chestTier + legginsTier + bootsTier) / 2;
			double damageToTake = 0.005 * tierValue;
			damageModifer = 0.0075 - (damageToTake / 2) / 10;
			doDamage = true;
		}
		if (doDamage) {
			IStatsCapability stats = null;
			if (playerMP != null) {
				stats = playerMP.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
			}
			if (stats.getRadiationLevel() >= 100) {
				playerMP.attackEntityFrom(DamageSourceEP.radiation, 3F);
			} else if (stats.getRadiationLevel() >= 0)
				stats.setRadiationLevel(stats.getRadiationLevel() + (damageModifer * (radiationLevel / 10) / 6));
			else
				stats.setRadiationLevel(0);
		}
	}

	public void onPlayerUpdate(EntityPlayerMP player) {
		int tick = player.ticksExisted - 1;
		final boolean isInGCDimension = player.worldObj.provider instanceof IGalacticraftWorldProvider;
		IStatsCapability stats = player.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);

		if (isInGCDimension && Config.RADIATION) {
			if (tick % 30 == 0) {
				this.sendSolarRadiationPacket(player, stats);
			}
		}
	}

	protected void sendSolarRadiationPacket(EntityPlayerMP player, IStatsCapability stats) {
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_UPDATE_SOLAR_RADIATION_LEVEL, player.worldObj.provider.getDimensionId(), new Object[] { stats.getRadiationLevel() }), player);
	}

	@SubscribeEvent
	public void onSleepInBedEvent(PlayerWakeUpEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (player.worldObj.isRemote == false && (!event.wakeImmediatly && !event.updateWorld)) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			IStatsCapability stats = null;
			if (playerMP != null) {
				stats = playerMP.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
			}
			double temp = stats.getRadiationLevel();
			double level = (temp * 5) / 100;
			if (level <= 0)
				stats.setRadiationLevel(0);
			else {
				stats.setRadiationLevel(stats.getRadiationLevel() - level);
				player.addChatMessage(new ChatComponentText("" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + playerMP.getName() + EnumChatFormatting.GOLD + ", " + GCCoreUtil.translate("gui.radiation.reduced.message") + " 5%"));
				player.addChatMessage(new ChatComponentText("" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + playerMP.getName() + EnumChatFormatting.DARK_AQUA + ", " + GCCoreUtil.translate("gui.radiation.current.message") + ": "
						+ (int) stats.getRadiationLevel() + "%"));
			}
		}
	}

	@SubscribeEvent
	public void onWorldChange(PlayerChangedDimensionEvent event) {
		if (event.player.worldObj.isRemote == false) {
			if (event.player.worldObj.provider instanceof WorldProviderRealisticSpace) {
				EntityPlayer player = event.player;
				player.addChatMessage(new ChatComponentText("" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + player.getName() + EnumChatFormatting.DARK_RED + ", " + GCCoreUtil.translate("gui.radiation.subject.message") + " "
						+ ((WorldProviderRealisticSpace) event.player.worldObj.provider).getSolarRadiationLevel() + "% " + GCCoreUtil.translate("gui.radiation.type.message") + ""));
				player.addChatMessage(new ChatComponentText("" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + player.getName() + EnumChatFormatting.DARK_GREEN + ", " + GCCoreUtil.translate("gui.radiation.reverse.message") + "!"));
			}
		}
	}
}
