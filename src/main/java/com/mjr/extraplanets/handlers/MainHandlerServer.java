package com.mjr.extraplanets.handlers;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderMoon;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderSpaceStation;
import micdoodle8.mods.galacticraft.core.entities.EntityLanderBase;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler.ThermalArmorEvent;
import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.dimension.WorldProviderAsteroids;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.dimension.WorldProviderMars;
import micdoodle8.mods.galacticraft.planets.venus.dimension.WorldProviderVenus;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
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
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IModularArmor;
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
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.extraplanets.network.ExtraPlanetsPacketHandler;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;
import com.mjr.extraplanets.util.DamageSourceEP;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.PlayerUtilties;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class MainHandlerServer {

	private static List<ExtraPlanetsPacketHandler> packetHandlers = Lists.newCopyOnWriteArrayList();

	public static void addPacketHandler(ExtraPlanetsPacketHandler handler) {
		MainHandlerServer.packetHandlers.add(handler);
	}

	@SubscribeEvent
	public void worldUnloadEvent(WorldEvent.Unload event) {
		for (ExtraPlanetsPacketHandler packetHandler : packetHandlers) {
			packetHandler.unload(event.getWorld());
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
		IStatsCapability oldStats = event.getOriginal().getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
		IStatsCapability newStats = event.getEntityPlayer().getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
		newStats.copyFrom(oldStats, !event.isWasDeath() || event.getOriginal().world.getGameRules().getBoolean("keepInventory"));
	}

	@SubscribeEvent
	public void onEntityDealth(LivingDeathEvent event) {
		if (event.getEntity() instanceof EntityPlayerMP) {
			final EntityLivingBase entityLiving = event.getEntityLiving();
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
		if (Config.JUITPER_LIGHTING && event.player.world.provider.getDimensionType().getId() == Config.JUPITER_ID) {
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
				event.player.world.addWeatherEffect(new EntityLightningBolt(event.player.world, event.player.posX + addX, event.player.world.getTopSolidOrLiquidBlock(new BlockPos(event.player.posX + addX, 0, (int) event.player.posZ + addZ)).getY(),
						event.player.posZ + addZ, false));
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
	public void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayerMP) {
			event.addCapability(CapabilityStatsHandler.EP_PLAYER_PROP, new CapabilityProviderStats((EntityPlayerMP) event.getObject()));
		} else if (event.getObject() instanceof EntityPlayer && ((EntityPlayer) event.getObject()).world.isRemote) {
			this.onAttachCapabilityClient(event);
		}
	}

	@SideOnly(Side.CLIENT)
	private void onAttachCapabilityClient(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayerSP)
			event.addCapability(CapabilityStatsClientHandler.EP_PLAYER_CLIENT_PROP, new CapabilityProviderStatsClient((EntityPlayerSP) event.getObject()));
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
		final EntityLivingBase entityLiving = event.getEntityLiving();
		if (entityLiving instanceof EntityPlayerMP) {
			tickModules(event, entityLiving);
			if (isInGlowstone((EntityPlayerMP) entityLiving))
				entityLiving.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 500, 0));
			onPlayerUpdate((EntityPlayerMP) entityLiving);
			if (OxygenUtil.isAABBInBreathableAirBlock(entityLiving.world, entityLiving.getEntityBoundingBox(), true) == false)
				runChecks(event, entityLiving);
		}
	}

	private void tickModules(LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP player = (EntityPlayerMP) entityLiving;

		ItemStack helmet = player.inventory.armorInventory.get(3);
		ItemStack chest = player.inventory.armorInventory.get(1);
		ItemStack leggins = player.inventory.armorInventory.get(2);
		ItemStack boots = player.inventory.armorInventory.get(0);

		if (helmet.getItem() instanceof IModularArmor)
			for (Module hemletModules : ModuleHelper.getModules(helmet)) {
				hemletModules.tick(player);
			}
		if (chest.getItem() instanceof IModularArmor)
			for (Module chestModules : ModuleHelper.getModules(chest)) {
				chestModules.tick(player);
			}
		if (leggins.getItem() instanceof IModularArmor)
			for (Module legginsModules : ModuleHelper.getModules(leggins)) {
				legginsModules.tick(player);
			}
		if (boots.getItem() instanceof IModularArmor)
			for (Module bootsModules : ModuleHelper.getModules(boots)) {
				bootsModules.tick(player);
			}
	}

	public boolean isInGlowstone(EntityPlayerMP player) {
		return player.world.isMaterialInBB(player.getEntityBoundingBox().expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), ExtraPlanets_Fluids.GLOWSTONE_MATERIAL);
	}

	private void runChecks(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP player = (EntityPlayerMP) entityLiving;
		if (player.capabilities.isCreativeMode)
			return;
		if ((entityLiving.getRidingEntity() instanceof EntityLanderBase))
			return;
		if ((entityLiving.getRidingEntity() instanceof EntityElectricRocketBase))
			return;
		if ((entityLiving.getRidingEntity() instanceof EntitySpaceshipBase))
			return;
		if (entityLiving.world.provider instanceof IGalacticraftWorldProvider) {
			if (((EntityPlayerMP) entityLiving).world.provider instanceof WorldProviderRealisticSpace) {
				if (Config.PRESSURE)
					checkPressure(event, player, ((WorldProviderRealisticSpace) player.world.provider).getPressureLevel());
				if (Config.RADIATION)
					checkRadiation(event, player, ((WorldProviderRealisticSpace) player.world.provider).getSolarRadiationLevel());
			} else if (player.world.provider instanceof WorldProviderMoon) {
				if (Config.GC_PRESSURE)
					checkPressure(event, player, 80);
				if (Config.GC_RADIATION)
					checkRadiation(event, player, Config.MOON_RADIATION_AMOUNT);
			} else if (player.world.provider instanceof WorldProviderMars) {
				if (Config.GC_PRESSURE)
					checkPressure(event, player, 90);
				if (Config.GC_RADIATION)
					checkRadiation(event, player, Config.MARS_RADIATION_AMOUNT);
			} else if (player.world.provider instanceof WorldProviderVenus) {
				if (Config.GC_PRESSURE)
					checkPressure(event, player, 100);
				if (Config.GC_RADIATION)
					checkRadiation(event, player, Config.VENUS_RADIATION_AMOUNT);
			} else if (player.world.provider instanceof WorldProviderAsteroids) {
				if (Config.GC_PRESSURE)
					checkPressure(event, player, 100);
				if (Config.GC_RADIATION)
					checkRadiation(event, player, Config.ASTEROIDS_RADIATION_AMOUNT);
			} else if (player.world.provider instanceof WorldProviderSpaceStation) {
				if (Config.GC_PRESSURE || Config.PRESSURE)
					checkPressure(event, player, 100);
				if (Config.GC_RADIATION || Config.RADIATION)
					checkRadiation(event, player, Config.SPACE_STATION_RADIATION_AMOUNT);
			}
		}
	}

	private void checkPressure(LivingEvent.LivingUpdateEvent event, EntityPlayerMP playerMP, int amount) {
		if ((playerMP.ticksExisted - 1) % 50 == 0) {
			if (amount == 0)
				return;
			if ((playerMP.ticksExisted - 1) % 300 == 0 && Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Environment Pressure Amount: " + amount);
			ItemStack helmet = playerMP.inventory.armorInventory.get(0);
			ItemStack chest = playerMP.inventory.armorInventory.get(1);
			ItemStack leggins = playerMP.inventory.armorInventory.get(2);
			ItemStack boots = playerMP.inventory.armorInventory.get(3);

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
				float tempLevel = amount;
				tempLevel = (tempLevel / 100) * 8;
				if ((playerMP.ticksExisted - 1) % 100 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Damage Amount for Pressure: " + tempLevel);
				playerMP.attackEntityFrom(DamageSourceEP.pressure, tempLevel);
			}
		}
	}

	private void checkRadiation(LivingEvent.LivingUpdateEvent event, EntityPlayerMP playerMP, int amount) {
		// Tier 1 Space Suit
		// 25 Level = 36 mins
		// 50 Level = 14 mins
		// Tier 2 Space Suit
		// 25 Level = 38 mins
		// 50 Level = 15 mins

		if (amount == 0)
			return;
		if ((playerMP.ticksExisted - 1) % 300 == 0 && Config.DEBUG_MODE)
			MessageUtilities.debugMessageToLog(Constants.modID, "Environment Radiation Amount: " + amount);
		boolean doDamage = false;
		boolean doArmorCheck = false;
		double damageModifer = 0;
		if (playerMP.inventory.armorInventory.get(0) == null || playerMP.inventory.armorInventory.get(1) == null || playerMP.inventory.armorInventory.get(2) == null || playerMP.inventory.armorInventory.get(3) == null) {
			damageModifer = 0.1;
			doDamage = true;
		} else if (!(playerMP.inventory.armorInventory.get(0).getItem() instanceof IRadiationSuit) && !(playerMP.inventory.armorInventory.get(1).getItem() instanceof IRadiationSuit)
				&& !(playerMP.inventory.armorInventory.get(2).getItem() instanceof IRadiationSuit) && !(playerMP.inventory.armorInventory.get(3).getItem() instanceof IRadiationSuit)) {
			damageModifer = 0.1;
			doDamage = true;
		} else if (playerMP.inventory.armorInventory.get(0).getItem() instanceof IRadiationSuit && playerMP.inventory.armorInventory.get(1).getItem() instanceof IRadiationSuit
				&& playerMP.inventory.armorInventory.get(2).getItem() instanceof IRadiationSuit && playerMP.inventory.armorInventory.get(3).getItem() instanceof IRadiationSuit) {
			doArmorCheck = true;
			doDamage = false;
		} else {
			damageModifer = 0.1;
			doDamage = true;
		}
		if (doArmorCheck) {
			int helmetTier = ((IRadiationSuit) playerMP.inventory.armorInventory.get(0).getItem()).getArmorTier();
			int chestTier = ((IRadiationSuit) playerMP.inventory.armorInventory.get(1).getItem()).getArmorTier();
			int legginsTier = ((IRadiationSuit) playerMP.inventory.armorInventory.get(2).getItem()).getArmorTier();
			int bootsTier = ((IRadiationSuit) playerMP.inventory.armorInventory.get(3).getItem()).getArmorTier();

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
			if ((playerMP.ticksExisted - 1) % 100 == 0 && Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Player Current Radiation Amount: " + stats.getRadiationLevel());
			if (stats.getRadiationLevel() >= 100) {
				if ((playerMP.ticksExisted - 1) % 50 == 0)
					playerMP.attackEntityFrom(DamageSourceEP.radiation, 3F);
			} else if (stats.getRadiationLevel() >= 0) {
				double tempLevel = 0.0;
				if (amount < 10)
					tempLevel = (damageModifer * amount) / 100;
				else
					tempLevel = damageModifer * (amount / 10) / 6;
				if ((playerMP.ticksExisted - 1) % 100 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Gained amount of Radiation: " + tempLevel);
				stats.setRadiationLevel(stats.getRadiationLevel() + tempLevel);
			} else
				stats.setRadiationLevel(0);
		}
	}

	public void onPlayerUpdate(EntityPlayerMP player) {
		int tick = player.ticksExisted - 1;
		final boolean isInGCDimension = player.world.provider instanceof IGalacticraftWorldProvider;
		IStatsCapability stats = player.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);

		if (isInGCDimension && Config.RADIATION) {
			if (tick % 30 == 0) {
				this.sendSolarRadiationPacket(player, stats);
			}
		}
	}

	protected void sendSolarRadiationPacket(EntityPlayerMP player, IStatsCapability stats) {
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_UPDATE_SOLAR_RADIATION_LEVEL, player.world.provider.getDimensionType().getId(), new Object[] { stats.getRadiationLevel() }), player);
	}

	@SubscribeEvent
	public void onSleepInBedEvent(PlayerWakeUpEvent event) {
		EntityPlayer player = event.getEntityPlayer();
		if (player.world.isRemote == false && (!event.wakeImmediately() && !event.updateWorld())) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			IStatsCapability stats = null;
			if (playerMP != null) {
				stats = playerMP.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
			}
			double temp = stats.getRadiationLevel();
			double level = (temp * Config.RADIATION_SLEEPING_REDUCE_AMOUNT) / 100;
			if (level <= 0)
				stats.setRadiationLevel(0);
			else {
				stats.setRadiationLevel(stats.getRadiationLevel() - level);
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + playerMP.getName() + TextFormatting.GOLD + ", " + TranslateUtilities.translate("gui.radiation.reduced.message") + " "
						+ Config.RADIATION_SLEEPING_REDUCE_AMOUNT + "%");
				PlayerUtilties.sendMessage(player,
						"" + TextFormatting.AQUA + TextFormatting.BOLD + playerMP.getName() + TextFormatting.DARK_AQUA + ", " + TranslateUtilities.translate("gui.radiation.current.message") + ": " + (int) stats.getRadiationLevel() + "%");
			}
		}
	}

	@SubscribeEvent
	public void onWorldChange(PlayerChangedDimensionEvent event) {
		if (event.player.world.isRemote == false) {
			if (event.player.world.provider instanceof WorldProviderRealisticSpace || event.player.world.provider instanceof WorldProviderMoon || event.player.world.provider instanceof WorldProviderMars
					|| event.player.world.provider instanceof WorldProviderAsteroids || event.player.world.provider instanceof WorldProviderVenus || event.player.world.provider instanceof WorldProviderSpaceStation) {
				EntityPlayer player = event.player;
				int amount = 0;
				if (event.player.world.provider instanceof WorldProviderRealisticSpace)
					amount = ((WorldProviderRealisticSpace) event.player.world.provider).getSolarRadiationLevel();
				if (event.player.world.provider instanceof WorldProviderMoon)
					amount = Config.MOON_RADIATION_AMOUNT;
				if (event.player.world.provider instanceof WorldProviderMars)
					amount = Config.MARS_RADIATION_AMOUNT;
				if (event.player.world.provider instanceof WorldProviderAsteroids)
					amount = Config.ASTEROIDS_RADIATION_AMOUNT;
				if (event.player.world.provider instanceof WorldProviderVenus)
					amount = Config.VENUS_RADIATION_AMOUNT;
				if (player.world.provider instanceof WorldProviderSpaceStation)
					amount = Config.SPACE_STATION_RADIATION_AMOUNT;
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.DARK_RED + ", " + TranslateUtilities.translate("gui.radiation.subject.message") + " " + amount + "% "
						+ TranslateUtilities.translate("gui.radiation.type.message") + "");
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.DARK_GREEN + ", " + TranslateUtilities.translate("gui.radiation.reverse.message") + "!");
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.GOLD + ", " + TranslateUtilities.translate("gui.radiation.cancel.message") + "!");
			}
		}
	}

	/*
	 * Debug use for changing dimensions since /dimensiontp screen is broke in dev workspace
	 */
	// @SubscribeEvent(priority = EventPriority.LOWEST)
	// public void onPlayerJoin(PlayerLoggedInEvent event) {
	// if (event.player instanceof EntityPlayer) {
	// final WorldServer world = (WorldServer) ((EntityPlayerMP) event.player).world;
	// WorldUtil.transferEntityToDimension((EntityPlayerMP) event.player, Config.KEPLER22B_ID, world);
	// }
	// }
}
