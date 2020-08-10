package com.mjr.extraplanets.handlers;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.api.item.IPressureSuit;
import com.mjr.extraplanets.api.item.IRadiationSuit;
import com.mjr.extraplanets.api.prefabs.entity.EntityElectricRocketBase;
import com.mjr.extraplanets.api.prefabs.world.WorldProviderRealisticSpace;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.fluid.FluidBlockEP;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityProviderStatsClient;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
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
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.PlayerUtilties;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderMoon;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderSpaceStation;
import micdoodle8.mods.galacticraft.core.entities.EntityLanderBase;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler.ThermalArmorEvent;
import micdoodle8.mods.galacticraft.core.util.CompatibilityManager;
import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.dimension.WorldProviderAsteroids;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.dimension.WorldProviderMars;
import micdoodle8.mods.galacticraft.planets.venus.dimension.WorldProviderVenus;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		newStats.copyFrom(oldStats, !event.isWasDeath() || event.getOriginal().worldObj.getGameRules().getBoolean("keepInventory"));
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (event.player instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.player;
			World world = event.player.worldObj;

			IBlockState blockTest = world.getBlockState(player.getPosition());
			if (blockTest.getBlock() instanceof FluidBlockEP) {
				BlockPos block = world.getTopSolidOrLiquidBlock(player.getPosition().add(1, 1, 0));
				world.setBlockState(block, world.getBiome(block).topBlock);
				ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_MOVE_PLAYER, world.provider.getDimensionType().getId(), new Object[] { block }), player);
			}
		}
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
		if (Config.JUITPER_LIGHTING_SERVER && event.player.worldObj.provider.getDimensionType().getId() == Config.JUPITER_ID) {
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
				event.player.worldObj.addWeatherEffect(new EntityLightningBolt(event.player.worldObj, event.player.posX + addX,
						event.player.worldObj.getTopSolidOrLiquidBlock(new BlockPos(event.player.posX + addX, 0, (int) event.player.posZ + addZ)).getY(), event.player.posZ + addZ, false));
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
		} else if (event.getObject() instanceof EntityPlayer && ((EntityPlayer) event.getObject()).worldObj.isRemote) {
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
			if (OxygenUtil.isAABBInBreathableAirBlock(entityLiving.worldObj, entityLiving.getEntityBoundingBox(), true) == false
					&& !(entityLiving.worldObj.getBlockState(new BlockPos(entityLiving.posX, entityLiving.posY, entityLiving.posZ)).getBlock() instanceof BlockFluidBase))
				runChecks(event, entityLiving);
		}
	}

	private void tickModules(LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP player = (EntityPlayerMP) entityLiving;

		ItemStack helmet = player.inventory.armorInventory[3];
		ItemStack chest = player.inventory.armorInventory[2];
		ItemStack leggins = player.inventory.armorInventory[1];
		ItemStack boots = player.inventory.armorInventory[0];

		if (helmet != null && helmet.getItem() instanceof IModularArmor)
			for (Module hemletModules : ModuleHelper.getModules(helmet)) {
				if (hemletModules.isActive()) {
					int passivePower = ModuleHelper.getModulePassiveCost(hemletModules);
					if ((player.ticksExisted - 1) % 20 == 0 && ModuleHelper.hasPower(helmet, passivePower))
						ModuleHelper.takeArmourPower(helmet, passivePower);
					if (ModuleHelper.hasPower(helmet, ModuleHelper.getModuleUseCost(hemletModules)))
						hemletModules.tickServer(player);
				}
			}
		if (chest != null && chest.getItem() instanceof IModularArmor)
			for (Module chestModules : ModuleHelper.getModules(chest)) {
				if (chestModules.isActive()) {
					int passivePower = ModuleHelper.getModulePassiveCost(chestModules);
					if ((player.ticksExisted - 1) % 20 == 0 && ModuleHelper.hasPower(chest, passivePower))
						ModuleHelper.takeArmourPower(chest, passivePower);
					if (ModuleHelper.hasPower(helmet, ModuleHelper.getModuleUseCost(chestModules)))
						chestModules.tickServer(player);
				}
			}
		if (leggins != null && leggins.getItem() instanceof IModularArmor)
			for (Module legginsModules : ModuleHelper.getModules(leggins)) {
				if (legginsModules.isActive()) {
					int passivePower = ModuleHelper.getModulePassiveCost(legginsModules);
					if ((player.ticksExisted - 1) % 20 == 0 && ModuleHelper.hasPower(leggins, passivePower))
						ModuleHelper.takeArmourPower(leggins, passivePower);
					if (ModuleHelper.hasPower(helmet, ModuleHelper.getModuleUseCost(legginsModules)))
						legginsModules.tickServer(player);
				}
			}
		if (boots != null && boots.getItem() instanceof IModularArmor)
			for (Module bootsModules : ModuleHelper.getModules(boots)) {
				if (bootsModules.isActive()) {
					int passivePower = ModuleHelper.getModulePassiveCost(bootsModules);
					if ((player.ticksExisted - 1) % 20 == 0 && ModuleHelper.hasPower(boots, passivePower))
						ModuleHelper.takeArmourPower(boots, passivePower);
					if (ModuleHelper.hasPower(helmet, ModuleHelper.getModuleUseCost(bootsModules)))
						bootsModules.tickServer(player);
				}
			}
	}

	public boolean isInGlowstone(EntityPlayerMP player) {
		return player.worldObj.isMaterialInBB(player.getEntityBoundingBox().expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), ExtraPlanets_Fluids.GLOWSTONE_MATERIAL);
	}

	private void runChecks(LivingEvent.LivingUpdateEvent event, EntityLivingBase entityLiving) {
		EntityPlayerMP player = (EntityPlayerMP) entityLiving;
		if (player.capabilities.isCreativeMode)
			return;
		if (player.isSpectator())
			return;
		if ((entityLiving.getRidingEntity() instanceof EntityLanderBase))
			return;
		if ((entityLiving.getRidingEntity() instanceof EntityElectricRocketBase))
			return;
		if ((entityLiving.getRidingEntity() instanceof EntitySpaceshipBase))
			return;
		if (entityLiving.worldObj.provider instanceof IGalacticraftWorldProvider) {
			List<String> list = Lists.newArrayList(Config.SPACE_SUIT_SUPPORTED_ARMOUR);
			if (((EntityPlayerMP) entityLiving).worldObj.provider instanceof WorldProviderRealisticSpace) {
				if (Config.PRESSURE)
					checkPressure(event, player, ((WorldProviderRealisticSpace) player.worldObj.provider).getPressureLevel(), list);
				if (Config.RADIATION)
					checkRadiation(event, player, ((WorldProviderRealisticSpace) player.worldObj.provider).getSolarRadiationLevel(), list);
			} else if (player.worldObj.provider instanceof WorldProviderMoon) {
				if (Config.GC_PRESSURE && Config.PRESSURE)
					checkPressure(event, player, 80, list);
				if (Config.GC_RADIATION && Config.RADIATION)
					checkRadiation(event, player, Config.MOON_RADIATION_AMOUNT, list);
			} else if (player.worldObj.provider instanceof WorldProviderMars) {
				if (Config.GC_PRESSURE && Config.PRESSURE)
					checkPressure(event, player, 90, list);
				if (Config.GC_RADIATION && Config.RADIATION)
					checkRadiation(event, player, Config.MARS_RADIATION_AMOUNT, list);
			} else if (player.worldObj.provider instanceof WorldProviderVenus) {
				if (Config.GC_PRESSURE && Config.PRESSURE)
					checkPressure(event, player, 100, list);
				if (Config.GC_RADIATION && Config.RADIATION)
					checkRadiation(event, player, Config.VENUS_RADIATION_AMOUNT, list);
			} else if (player.worldObj.provider instanceof WorldProviderAsteroids) {
				if (Config.GC_PRESSURE && Config.PRESSURE)
					checkPressure(event, player, 100, list);
				if (Config.GC_RADIATION && Config.RADIATION)
					checkRadiation(event, player, Config.ASTEROIDS_RADIATION_AMOUNT, list);
			} else if (player.worldObj.provider instanceof WorldProviderSpaceStation) {
				if (Config.GC_PRESSURE && Config.PRESSURE)
					checkPressure(event, player, 100, list);
				if (Config.GC_RADIATION && Config.RADIATION)
					checkRadiation(event, player, Config.SPACE_STATION_RADIATION_AMOUNT, list);
			}
		}
	}

	public boolean isValidSpaceSuit(EntityPlayer player, ItemStack helmet, ItemStack chest, ItemStack leggins, ItemStack boots, List<String> list, boolean pressure) {
		// Check for slot filled
		if (helmet == null)
			return false;
		if (chest == null)
			return false;
		if (leggins == null)
			return false;
		if (boots == null)
			return false;

		boolean validHelmet = false;
		boolean validChest = false;
		boolean validLeggings = false;
		boolean validBoots = false;

		// ExtraPlanets Space Suit/Interface compact
		if (pressure) {
			if (helmet.getItem() instanceof IPressureSuit)
				validHelmet = true;
			if (chest.getItem() instanceof IPressureSuit)
				validChest = true;
			if (leggins.getItem() instanceof IPressureSuit)
				validLeggings = true;
			if (boots.getItem() instanceof IPressureSuit)
				validBoots = true;
		} else {
			if (helmet.getItem() instanceof IRadiationSuit)
				validHelmet = true;
			if (chest.getItem() instanceof IRadiationSuit)
				validChest = true;
			if (leggins.getItem() instanceof IRadiationSuit)
				validLeggings = true;
			if (boots.getItem() instanceof IRadiationSuit)
				validBoots = true;
		}
		if (validHelmet && validChest && validLeggings && validBoots)
			return true;
		else {
			// Mod Compact
			if(CompatibilityManager.isAndroid(player))
				return true;
			// Config List of armour items to be considered as a space suit compact
			for (String temp : list) {
				temp = temp.substring(0, temp.lastIndexOf(':'));
				if (temp.equalsIgnoreCase(helmet.getItem().getRegistryName().toString()))
					validHelmet = true;
			}
			for (String temp : list) {
				temp = temp.substring(0, temp.lastIndexOf(':'));
				if (temp.equalsIgnoreCase(chest.getItem().getRegistryName().toString()))
					validChest = true;
			}
			for (String temp : list) {
				temp = temp.substring(0, temp.lastIndexOf(':'));
				if (temp.equalsIgnoreCase(leggins.getItem().getRegistryName().toString()))
					validLeggings = true;
			}
			for (String temp : list) {
				temp = temp.substring(0, temp.lastIndexOf(':'));
				if (temp.equalsIgnoreCase(boots.getItem().getRegistryName().toString()))
					validBoots = true;
			}

			if (validHelmet && validChest && validLeggings && validBoots)
				return true;
			else
				return false;
		}
	}

	public int getTier(ItemStack testItem, List<String> list) {
		if (testItem.getItem() instanceof IRadiationSuit)
			return ((IRadiationSuit) testItem.getItem()).getArmorTier();

		for (String line : list) {
			if (line.substring(0, line.lastIndexOf(':')).equalsIgnoreCase(testItem.getItem().getRegistryName().toString()))
				return Integer.parseInt(line.substring(line.lastIndexOf(':') + 1));
		}
		return -1;
	}

	private void checkPressure(LivingEvent.LivingUpdateEvent event, EntityPlayerMP playerMP, int amount, List<String> list) {
		if ((playerMP.ticksExisted - 1) % 50 == 0) {
			if (amount == 0)
				return;

			if ((playerMP.ticksExisted - 1) % 300 == 0 && Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Environment Pressure Amount: " + amount);

			ItemStack helmet = playerMP.inventory.armorInventory[3];
			ItemStack chest = playerMP.inventory.armorInventory[2];
			ItemStack leggins = playerMP.inventory.armorInventory[1];
			ItemStack boots = playerMP.inventory.armorInventory[0];

			if (!isValidSpaceSuit(playerMP, helmet, chest, leggins, boots, list, true)) {
				float tempLevel = amount;
				tempLevel = (tempLevel / 100) * 8;
				if ((playerMP.ticksExisted - 1) % 100 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Damage Amount for Pressure: " + tempLevel);
				playerMP.attackEntityFrom(DamageSourceEP.pressure, tempLevel);
			}
		}
	}

	private void checkRadiation(LivingEvent.LivingUpdateEvent event, EntityPlayerMP playerMP, int amount, List<String> list) {
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

		ItemStack helmet = playerMP.inventory.armorInventory[3];
		ItemStack chest = playerMP.inventory.armorInventory[2];
		ItemStack leggins = playerMP.inventory.armorInventory[1];
		ItemStack boots = playerMP.inventory.armorInventory[0];

		if (!isValidSpaceSuit(playerMP, helmet, chest, leggins, boots, list, false)) {
			damageModifer = 0.1;
			doDamage = true;
		} else {
			doArmorCheck = true;
			doDamage = false;
		}
		if (doArmorCheck) {
			int helmetTier = getTier(helmet, list);
			int chestTier = getTier(chest, list);
			int legginsTier = getTier(leggins, list);
			int bootsTier = getTier(boots, list);

			if ((playerMP.ticksExisted - 1) % 100 == 0 && Config.DEBUG_MODE) {
				MessageUtilities.debugMessageToLog(Constants.modID, "Helmet Tier: " + helmetTier);
				MessageUtilities.debugMessageToLog(Constants.modID, "Chest Tier: " + chestTier);
				MessageUtilities.debugMessageToLog(Constants.modID, "Leggins Tier: " + legginsTier);
				MessageUtilities.debugMessageToLog(Constants.modID, "Boots Tier: " + bootsTier);
			}

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
		final boolean isInGCDimension = player.worldObj.provider instanceof IGalacticraftWorldProvider;
		IStatsCapability stats = player.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);

		if ((isInGCDimension || player.worldObj.provider instanceof WorldProviderSpaceStation) && Config.RADIATION) {
			if (tick % 30 == 0) {
				this.sendSolarRadiationPacket(player, stats);
			}
			if (tick % 30 == 0) {
				if(Config.RADIATION_SLEEPING_REDUCE_AMOUNT != 0) {
					double temp = stats.getRadiationLevel();
					double level = (temp * (Config.RADIATION_OVERTIME_REDUCE_AMOUNT * 1.5F)) / 100;
					if (level <= 0)
						stats.setRadiationLevel(0);
					else {
						stats.setRadiationLevel(stats.getRadiationLevel() - level);
					}
				}
			}
		}
		if (tick % 30 == 0) {
			if(Config.RADIATION_SLEEPING_REDUCE_AMOUNT != 0) {
				double temp = stats.getRadiationLevel();
				double level = (temp * Config.RADIATION_OVERTIME_REDUCE_AMOUNT) / 100;
				if (level <= 0)
					stats.setRadiationLevel(0);
				else {
					stats.setRadiationLevel(stats.getRadiationLevel() - level);
				}
			}
		}
	}

	protected void sendSolarRadiationPacket(EntityPlayerMP player, IStatsCapability stats) {
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_UPDATE_SOLAR_RADIATION_LEVEL, player.worldObj.provider.getDimensionType().getId(), new Object[] { stats.getRadiationLevel() }), player);
	}

	@SubscribeEvent
	public void onSleepInBedEvent(PlayerWakeUpEvent event) {
		EntityPlayer player = event.getEntityPlayer();
		if (player.worldObj.isRemote == false && (!event.wakeImmediately() && !event.updateWorld())) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			IStatsCapability stats = null;
			if (playerMP != null) {
				stats = playerMP.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
			}
			if(Config.RADIATION_SLEEPING_REDUCE_AMOUNT != 0) {
				double temp = stats.getRadiationLevel();
				double level = (temp * Config.RADIATION_SLEEPING_REDUCE_AMOUNT) / 100;
				if (level <= 0)
					stats.setRadiationLevel(0);
				else {
					stats.setRadiationLevel(stats.getRadiationLevel() - level);
					PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + playerMP.getName() + TextFormatting.GOLD + ", " + TranslateUtilities.translate("gui.radiation.reduced.message") + " "
							+ Config.RADIATION_SLEEPING_REDUCE_AMOUNT + "% " + TranslateUtilities.translate("gui.radiation.reduced.message.2"));
					PlayerUtilties.sendMessage(player,
							"" + TextFormatting.AQUA + TextFormatting.BOLD + playerMP.getName() + TextFormatting.DARK_AQUA + ", " + TranslateUtilities.translate("gui.radiation.current.message") + ": " + (int) stats.getRadiationLevel() + "/100");
				}
			}
		}
	}

	@SubscribeEvent
	public void onWorldChange(PlayerChangedDimensionEvent event) {
		if (event.player.worldObj.isRemote == false) {
			if (event.player.worldObj.provider instanceof WorldProviderRealisticSpace || event.player.worldObj.provider instanceof WorldProviderMoon || event.player.worldObj.provider instanceof WorldProviderMars
					|| event.player.worldObj.provider instanceof WorldProviderAsteroids || event.player.worldObj.provider instanceof WorldProviderVenus || event.player.worldObj.provider instanceof WorldProviderSpaceStation) {
				EntityPlayer player = event.player;
				int amount = 0;
				if (event.player.worldObj.provider instanceof WorldProviderRealisticSpace)
					amount = ((WorldProviderRealisticSpace) event.player.worldObj.provider).getSolarRadiationLevel();
				if (event.player.worldObj.provider instanceof WorldProviderMoon)
					amount = Config.MOON_RADIATION_AMOUNT;
				if (event.player.worldObj.provider instanceof WorldProviderMars)
					amount = Config.MARS_RADIATION_AMOUNT;
				if (event.player.worldObj.provider instanceof WorldProviderAsteroids)
					amount = Config.ASTEROIDS_RADIATION_AMOUNT;
				if (event.player.worldObj.provider instanceof WorldProviderVenus)
					amount = Config.VENUS_RADIATION_AMOUNT;
				if (player.worldObj.provider instanceof WorldProviderSpaceStation)
					amount = Config.SPACE_STATION_RADIATION_AMOUNT;
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.DARK_RED + ", " + TranslateUtilities.translate("gui.radiation.subject.message") + " " + amount + "/100% "
						+ TranslateUtilities.translate("gui.radiation.type.message") + "");
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.DARK_GREEN + ", " + TranslateUtilities.translate("gui.radiation.reverse.message") + "!");
				PlayerUtilties.sendMessage(player, "" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.GOLD + ", " + TranslateUtilities.translate("gui.radiation.cancel.message") + "!");
			}
		}
	}
}
