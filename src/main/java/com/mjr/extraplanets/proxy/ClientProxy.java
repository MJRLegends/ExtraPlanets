package com.mjr.extraplanets.proxy;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.*;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.*;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.*;
import com.mjr.extraplanets.client.handlers.KeyHandlerClient;
import com.mjr.extraplanets.client.handlers.MainHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.client.model.ItemModelDecontaminationUnit;
import com.mjr.extraplanets.client.model.rockets.*;
import com.mjr.extraplanets.client.model.vehicles.ItemModelMarsRover;
import com.mjr.extraplanets.client.model.vehicles.ItemModelVenusRover;
import com.mjr.extraplanets.client.render.entities.RenderFireBombPrimed;
import com.mjr.extraplanets.client.render.entities.RenderNuclearBombPrimed;
import com.mjr.extraplanets.client.render.entities.bosses.*;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.*;
import com.mjr.extraplanets.client.render.entities.landers.*;
import com.mjr.extraplanets.client.render.entities.mobs.RenderEvolvedAncientMagmaCube;
import com.mjr.extraplanets.client.render.entities.mobs.RenderEvolvedMagmaCube;
import com.mjr.extraplanets.client.render.entities.projectiles.RenderSmallSnowBall;
import com.mjr.extraplanets.client.render.entities.rockets.*;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderMarsRover;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderVenusRover;
import com.mjr.extraplanets.client.render.tile.*;
import com.mjr.extraplanets.compatibility.MMPowersuitsModules.ModuleIcons;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.*;
import com.mjr.extraplanets.entities.bosses.defaultBosses.*;
import com.mjr.extraplanets.entities.landers.*;
import com.mjr.extraplanets.entities.mobs.EntityEvolvedAncientMagmaCube;
import com.mjr.extraplanets.entities.mobs.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.entities.rockets.*;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;
import com.mjr.extraplanets.items.*;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.planetAndMoonItems.*;
import com.mjr.extraplanets.items.schematics.*;
import com.mjr.extraplanets.items.thermalPadding.ItemThermalCloth;
import com.mjr.extraplanets.items.thermalPadding.ItemTier3ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier4ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier5ThermalPadding;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecontaminationUnit;
import com.mjr.extraplanets.tileEntities.machines.TileEntitySolar;
import com.mjr.extraplanets.tileEntities.treasureChests.*;
import com.mjr.mjrlegendslib.util.ClientUtilities;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

	// Event Methods
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RegisterUtilities.registerEventHandler(this);

		// Register OBJ Domain
		ClientUtilities.registerOBJInstance(Constants.modID);

		// Register Entity Renders
		registerEntityRenders();

		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		// Register Client Sky Provider Handler
		RegisterUtilities.registerEventHandler(new SkyProviderHandler());

		// Register Client Key Handler
		RegisterUtilities.registerEventHandler(new KeyHandlerClient());
		ClientUtilities.registerKeyBinding(KeyHandlerClient.openPowerGUI);
		ClientUtilities.registerKeyBinding(KeyHandlerClient.openModuleManagerGUI);
		ClientUtilities.registerKeyBinding(KeyHandlerClient.openPreLaunchChecklistGUI);
		ClientUtilities.registerKeyBinding(KeyHandlerClient.openNASAWorkBenchGUI);

		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		// Register Client Main Handler
		RegisterUtilities.registerEventHandler(new MainHandlerClient());

		// Register Schematics Textures (For Handing Entities versions)
		registerSchematicsTextures();
		super.postInit(event);
	}

	@Override
	public void registerVariants() {
		if (Config.MERCURY)
			ClientUtilities.addVariants(Constants.modID, "mercury", "mercury_surface", "mercury_sub_surface", "mercury_stone", "mercury_ore_iron", "mercury_ore_tin", "mercury_ore_copper", "mercury_ore_mercury", "mercury_mercury_block",
					"mercury_stonebricks", "mercury_dungeon_brick", "mercury_ore_carbon", "mercury_carbon_block");
		if (Config.CERES)
			ClientUtilities.addVariants(Constants.modID, "ceres", "ceres_surface", "ceres_sub_surface", "ceres_stone", "ceres_ore_iron", "ceres_ore_tin", "ceres_ore_copper", "ceres_ore_uranium", "ceres_uranium_block", "ceres_stonebricks");
		if (Config.JUPITER)
			ClientUtilities.addVariants(Constants.modID, "jupiter", "jupiter_surface", "jupiter_sub_surface", "jupiter_stone", "jupiter_ore_iron", "jupiter_ore_tin", "jupiter_ore_copper", "jupiter_ore_palladium", "jupiter_ore_nickel",
					"jupiter_palladium_block", "jupiter_stonebricks", "jupiter_dungeon_brick", "jupiter_ore_red_gem", "jupiter_red_gem_block", "jupiter_nickel_block");
		if (Config.URANUS)
			ClientUtilities.addVariants(Constants.modID, "uranus", "uranus_surface", "uranus_sub_surface", "uranus_stone", "uranus_ore_crystal", "uranus_crystal_block", "uranus_stonebricks", "uranus_dungeon_brick", "uranus_ore_white_gem",
					"uranus_white_gem_block");
		if (Config.NEPTUNE)
			ClientUtilities.addVariants(Constants.modID, "neptune", "neptune_surface", "neptune_sub_surface", "neptune_stone", "neptune_ore_iron", "neptune_ore_tin", "neptune_ore_copper", "neptune_ore_zinc", "neptune_zinc_block",
					"neptune_stonebricks", "neptune_dungeon_brick", "neptune_ore_blue_gem", "neptune_blue_gem_block");
		if (Config.SATURN)
			ClientUtilities.addVariants(Constants.modID, "saturn", "saturn_surface", "saturn_sub_surface", "saturn_stone", "saturn_ore_iron", "saturn_ore_tin", "saturn_ore_copper", "saturn_ore_magnesium", "saturn_magnesium_block",
					"saturn_stonebricks", "saturn_dungeon_brick", "broken_infected_stone", "infected_stone", "saturn_ore_slime");
		if (Config.PLUTO)
			ClientUtilities.addVariants(Constants.modID, "pluto", "pluto_surface", "pluto_sub_surface", "pluto_stone", "pluto_ore_iron", "pluto_ore_tin", "pluto_ore_copper", "pluto_ore_tungsten", "pluto_tungsten_block", "pluto_stonebricks",
					"pluto_dungeon_brick");
		if (Config.ERIS)
			ClientUtilities.addVariants(Constants.modID, "eris", "eris_surface", "eris_sub_surface", "eris_stone", "eris_ore_iron", "eris_ore_tin", "eris_ore_copper", "eris_ore_dark_iron", "eris_dark_iron_block", "eris_stonebricks",
					"eris_dungeon_brick");
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS)
			ClientUtilities.addVariants(Constants.modID, "kepler22b", "kepler22b_dirt", "kepler22b_stone", "kepler22b_ore_iron", "kepler22b_ore_tin", "kepler22b_ore_copper", "kepler22b_ore_dense_coal", "kepler22b_ore_blue_diamond",
					"kepler22b_ore_red_diamond", "kepler22b_ore_purple_diamond", "kepler22b_ore_yellow_diamond", "kepler22b_ore_green_diamond", "kepler22b_stonebricks", "kepler22b_cobblestone", "kepler22b_ore_platinum", "kepler22b_platinum_block");
		if (Config.CALLISTO)
			ClientUtilities.addVariants(Constants.modID, "callisto", "callisto_surface", "callisto_sub_surface", "callisto_stone", "callisto_ore_iron", "callisto_ore_tin", "callisto_ore_copper", "callisto_dried_oil", "callisto_shale_oil");
		if (Config.DEIMOS)
			ClientUtilities.addVariants(Constants.modID, "deimos", "deimos_surface", "deimos_sub_surface", "deimos_stone", "deimos_ore_iron", "deimos_ore_tin", "deimos_ore_copper");
		if (Config.EUROPA)
			ClientUtilities.addVariants(Constants.modID, "europa", "europa_surface", "europa_sub_surface", "europa_stone", "europa_ore_iron", "europa_ore_tin", "europa_ore_copper");
		if (Config.GANYMEDE)
			ClientUtilities.addVariants(Constants.modID, "ganymede", "ganymede_surface", "ganymede_sub_surface", "ganymede_stone", "ganymede_ore_iron", "ganymede_ore_tin", "ganymede_ore_copper");
		if (Config.IO)
			ClientUtilities.addVariants(Constants.modID, "io", "io_surface", "io_sub_surface", "io_stone", "io_ore_iron", "io_ore_tin", "io_ore_copper");
		if (Config.PHOBOS)
			ClientUtilities.addVariants(Constants.modID, "phobos", "phobos_surface", "phobos_sub_surface", "phobos_stone", "phobos_ore_iron", "phobos_ore_tin", "phobos_ore_copper");
		if (Config.RHEA)
			ClientUtilities.addVariants(Constants.modID, "rhea", "rhea_surface", "rhea_sub_surface", "rhea_stone", "rhea_ore_iron", "rhea_ore_tin", "rhea_ore_copper");
		if (Config.TITAN)
			ClientUtilities.addVariants(Constants.modID, "titan", "titan_surface", "titan_sub_surface", "titan_stone", "titan_ore_iron", "titan_ore_tin", "titan_ore_copper", "titan_methane_surface", "titan_methane_sub_surface", "titan_rocks");
		if (Config.TRITON)
			ClientUtilities.addVariants(Constants.modID, "triton", "triton_surface", "triton_sub_surface", "triton_stone", "triton_ore_iron", "triton_ore_tin", "triton_ore_copper");
		if (Config.OBERON)
			ClientUtilities.addVariants(Constants.modID, "oberon", "oberon_surface", "oberon_sub_surface", "oberon_stone", "oberon_ore_iron", "oberon_ore_tin", "oberon_ore_copper");
		if (Config.TITANIA)
			ClientUtilities.addVariants(Constants.modID, "titania", "titania_surface", "titania_sub_surface", "titania_stone", "titania_ore_iron", "titania_ore_tin", "titania_ore_copper");
		if (Config.IAPETUS)
			ClientUtilities.addVariants(Constants.modID, "iapetus", "iapetus_surface", "iapetus_sub_surface", "iapetus_stone", "iapetus_ore_iron", "iapetus_ore_tin", "iapetus_ore_copper", "iapetus_ice");
		if (Config.MERCURY)
			ClientUtilities.addVariants(Constants.modID, "tier4_items", "tier4engine", "tier4booster", "tier4fin", "tier4heavy_duty_plate", "compressed_carbon", "ingot_carbon", "diamond_shard");
		if (Config.JUPITER)
			ClientUtilities.addVariants(Constants.modID, "tier5_items", "tier5engine", "tier5booster", "tier5fin", "tier5heavy_duty_plate", "compressed_palladium", "ingot_palladium", "compressed_nickel", "ingot_nickel", "red_gem", "ash", "ash_shard",
					"volcanic_shard", "ingot_volcanic");
		if (Config.SATURN)
			ClientUtilities.addVariants(Constants.modID, "tier6_items", "tier6engine", "tier6booster", "tier6fin", "tier6heavy_duty_plate", "compressed_magnesium", "ingot_magnesium");
		if (Config.URANUS)
			ClientUtilities.addVariants(Constants.modID, "tier7_items", "tier7engine", "tier7booster", "tier7fin", "tier7heavy_duty_plate", "compressed_crystal", "ingot_crystal", "compressed_reinforced_crystal", "white_gem");
		if (Config.NEPTUNE)
			ClientUtilities.addVariants(Constants.modID, "tier8_items", "tier8engine", "tier8booster", "tier8fin", "tier8heavy_duty_plate", "compressed_zinc", "ingot_zinc", "blue_gem");
		if (Config.PLUTO)
			ClientUtilities.addVariants(Constants.modID, "tier9_items", "tier9engine", "tier9booster", "tier9fin", "tier9heavy_duty_plate", "compressed_tungsten", "ingot_tungsten");
		if (Config.ERIS)
			ClientUtilities.addVariants(Constants.modID, "tier10_items", "tier10engine", "tier10booster", "tier10fin", "tier10heavy_duty_plate", "compressed_dark_iron", "ingot_dark_iron");
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			ClientUtilities.addVariants(Constants.modID, "tier11_items", "blue_diamond", "red_diamond", "purple_diamond", "yellow_diamond", "green_diamond", "ingot_platinum", "compressed_platinum", "blue_sticks", "red_sticks", "purple_sticks",
					"yellow_sticks", "green_sticks", "brown_sticks");
			ClientUtilities.addVariants(Constants.modID, "kepler22b_planks", "maple_blue_plank", "maple_red_plank", "maple_purple_plank", "maple_yellow_plank", "maple_green_plank", "maple_brown_plank");
			ClientUtilities.addVariants(Constants.modID, "kepler22b_maple_logs", "maple_blue_log", "maple_red_log", "maple_purple_log", "maple_yellow_log");
			ClientUtilities.addVariants(Constants.modID, "kepler22b_maple_logs2", "maple_green_log", "maple_brown_log");
			ClientUtilities.addVariants(Constants.modID, "kepler22b_new_maple_leaves", "maple_blue_leaf", "maple_red_leaf", "maple_purple_leaf", "maple_yellow_leaf");
			ClientUtilities.addVariants(Constants.modID, "kepler22b_new_maple_leaves_2", "maple_green_leaf", "maple_brown_leaf");

			ClientUtilities.addVariants(Constants.modID, "kepler22b_maple_saplings", "maple_blue_sapling", "maple_red_sapling", "maple_purple_sapling", "maple_yellow_sapling", "maple_green_sapling", "maple_brown_sapling");
			ClientUtilities.addVariants(Constants.modID, "kepler22b_flowers", "maple_blue_short", "maple_blue_med", "maple_blue_tall", "maple_red_short", "maple_red_med", "maple_red_tall", "maple_purple_short", "maple_purple_med",
					"maple_purple_tall", "maple_yellow_short", "maple_yellow_med", "maple_yellow_tall", "maple_green_short", "maple_green_med", "maple_green_tall");
		}
		ClientUtilities.addVariants(Constants.modID, "wafer", "diamond_wafer", "carbon_wafer", "titanium_wafer", "red_gem_wafer", "blue_gem_wafer", "white_gem_wafer");
		ClientUtilities.addVariants(Constants.modID, "tools", "sledge_hammer", "grinding_wheel", "mesh", "filter");
		if (Config.CANNED_FOOD)
			ClientUtilities.addVariants(Constants.modID, "canned_food", "dehydrated_porkchop", "dehydrated_fish", "dehydrated_salmon", "dehydrated_chicken");
		if (Config.THERMAL_PADDINGS) {
			ClientUtilities.addVariants(Constants.modID, "thermal_cloth", "tier3_thermal_cloth", "tier4_thermal_cloth", "tier5_thermal_cloth");
			ClientUtilities.addVariants(Constants.modID, "tier3_thermal_padding", "tier3_thermal_helm", "tier3_thermal_chestplate", "tier3_thermal_leggings", "tier3_thermal_boots");
			ClientUtilities.addVariants(Constants.modID, "tier4_thermal_padding", "tier4_thermal_helm", "tier4_thermal_chestplate", "tier4_thermal_leggings", "tier4_thermal_boots");
			ClientUtilities.addVariants(Constants.modID, "tier5_thermal_padding", "tier5_thermal_helm", "tier5_thermal_chestplate", "tier5_thermal_leggings", "tier5_thermal_boots");
		}
		if (Config.SOLAR_PANELS)
			ClientUtilities.addVariants(Constants.modID, "solar", "ultimate_solar", "hybrid_solar");
		ClientUtilities.addVariants(Constants.modID, "advanced_launch_pad", "tier_2_rocket", "tier_3_rocket", "powered_charging_pad", "rocket_powered_charging_pad");
		ClientUtilities.addVariants(Constants.modID, "advanced_launch_pad_full", "tier_2_rocket", "tier_3_rocket", "powered_charging_pad", "rocket_powered_charging_pad");
		if (Config.OXYGEN_COMPRESSOR_ADVANCED)
			ClientUtilities.addVariants(Constants.modID, "advanced_oxygen_compressor", "advanced_oxygen_compressor", "advanced_oxygen_decompressor");
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE)
			ClientUtilities.addVariants(Constants.modID, "ultimate_oxygen_compressor", "ultimate_oxygen_compressor", "ultimate_oxygen_decompressor");
		ClientUtilities.addVariants(Constants.modID, "decorative_blocks", "marble", "marble_bricks", "snow_bricks", "ice_bricks", "fire_bricks", "black_white_floor", "marble_titled_floor", "marble_broken_titled_floor", "metal_mesh",
				"frozen_nitrogen_bricks", "volcanic_rock_bricks", "carbon_titled_floor", "carbon_broken_titled_floor", "magnesium_titled_floor", "magnesium_broken_titled_floor", "ash_bricks");
		ClientUtilities.addVariants(Constants.modID, "decorative_blocks2", "white_block", "red_block", "blue_block", "light_blue_block", "yellow_block", "green_block");
		if (Config.MARS_ROVER || Config.VENUS_ROVER || Config.ELECTRIC_ROCKET)
			ClientUtilities.addVariants(Constants.modID, "electric_parts", "battery_tier1", "battery_tier2", "electric_wheels_tier1", "electric_wheels_tier2");
		ClientUtilities.addVariants(Constants.modID, "tier1_kit", "tier1_kitfull", "tier1_kitbasic_setup", "tier1_kitwithout_oxygen_setup", "tier1_kitwithout_thermal_padding", "tier1_kitjust_oxygen_setup", "tier1_kitjust_protection");
		ClientUtilities.addVariants(Constants.modID, "tier2_kit", "tier2_kitfull", "tier2_kitbasic_setup", "tier2_kitwithout_oxygen_setup", "tier2_kitwithout_thermal_padding", "tier2_kitjust_oxygen_setup", "tier2_kitjust_protection");
		ClientUtilities.addVariants(Constants.modID, "tier3_kit", "tier3_kitfull", "tier3_kitbasic_setup", "tier3_kitwithout_oxygen_setup", "tier3_kitwithout_thermal_padding", "tier3_kitjust_oxygen_setup", "tier3_kitjust_protection");
		ClientUtilities.addVariants(Constants.modID, "tier4_kit", "tier4_kitfull", "tier4_kitbasic_setup", "tier4_kitwithout_oxygen_setup", "tier4_kitwithout_thermal_padding", "tier4_kitjust_oxygen_setup", "tier4_kitjust_protection");
		ClientUtilities.addVariants(Constants.modID, "tier5_kit", "tier5_kitfull", "tier5_kitbasic_setup", "tier5_kitwithout_oxygen_setup", "tier5_kitwithout_thermal_padding", "tier5_kitjust_oxygen_setup", "tier5_kitjust_protection");
		ClientUtilities.addVariants(Constants.modID, "candy_blocks", "candy_cane_red", "candy_cane_green", "candy_cane_blue", "candy_cane_orange", "candy_cane_magenta", "candy_cane_pink", "candy_cane_lime", "candy_cane_purple", "candy_cane_brown",
				"candy_cane_black");
		ClientUtilities.addVariants(Constants.modID, "candy_blocks_horizontal", "candy_cane_red_horizontal", "candy_cane_green_horizontal", "candy_cane_blue_horizontal", "candy_cane_orange_horizontal", "candy_cane_magenta_horizontal",
				"candy_cane_pink_horizontal", "candy_cane_lime_horizontal", "candy_cane_purple_horizontal", "candy_cane_brown_horizontal", "candy_cane_black_horizontal");
		ClientUtilities.addVariants(Constants.modID, "cake_blocks", "cake_block", "cake_block_red_velvet", "cake_block_chocolate", "white_icing_red_dots", "white_icing_green_dots", "white_icing_pink_dots", "white_icing_orange_dots", "cookie_rocks");
		if (Config.PRESSURE || Config.RADIATION)
			ClientUtilities.addVariants(Constants.modID, "module_items", "no_fall_boots", "oxygen_controller", "space_gear_controller");
	}

	private void registerEntityRenders() {
		if (Config.MERCURY) {
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossMercury.class, (RenderManager manager) -> new RenderCreeperBossMercury(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedMagmaCubeBoss.class, (RenderManager manager) -> new RenderEvolvedMagmaCubeBoss(manager));
			ClientUtilities.registerEntityRenderer(EntityMercuryLander.class, (RenderManager manager) -> new RenderMercuryLander(manager));
			ClientUtilities.registerEntityRenderer(EntityEvolvedMagmaCube.class, (RenderManager manager) -> new RenderEvolvedMagmaCube(manager));
		}
		if (Config.JUPITER) {
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossJupiter.class, (RenderManager manager) -> new RenderCreeperBossJupiter(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedFireBatBoss.class, (RenderManager manager) -> new RenderEvolvedFireBatBoss(manager));
			ClientUtilities.registerEntityRenderer(EntityJupiterLander.class, (RenderManager manager) -> new RenderJupiterLander(manager));
			ClientUtilities.registerEntityRenderer(EntityEvolvedAncientMagmaCube.class, (RenderManager manager) -> new RenderEvolvedAncientMagmaCube(manager));
		}
		if (Config.SATURN) {
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossSaturn.class, (RenderManager manager) -> new RenderCreeperBossSaturn(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedGhastBoss.class, (RenderManager manager) -> new RenderEvolvedGhastBoss(manager));
			ClientUtilities.registerEntityRenderer(EntitySaturnLander.class, (RenderManager manager) -> new RenderSaturnLander(manager));
		}
		if (Config.URANUS) {
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossUranus.class, (RenderManager manager) -> new RenderCreeperBossUranus(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedIceSlimeBoss.class, (RenderManager manager) -> new RenderEvolvedIceSlimeBoss(manager));
			ClientUtilities.registerEntityRenderer(EntityUranusLander.class, (RenderManager manager) -> new RenderUranusLander(manager));
		}
		if (Config.NEPTUNE) {
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossNeptune.class, (RenderManager manager) -> new RenderCreeperBossNeptune(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedSnowmanBoss.class, (RenderManager manager) -> new RenderEvolvedSnowmanBoss(manager));
			ClientUtilities.registerEntityRenderer(EntityNeptuneLander.class, (RenderManager manager) -> new RenderNeptuneLander(manager));
		}
		if (Config.PLUTO)
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossPluto.class, (RenderManager manager) -> new RenderCreeperBossPluto(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedSpacemanBoss.class, (RenderManager manager) -> new RenderEvolvedSpacemanBoss(manager));

		if (Config.ERIS) {
			if (Config.USE_DEFAULT_BOSSES)
				ClientUtilities.registerEntityRenderer(EntityCreeperBossEris.class, (RenderManager manager) -> new RenderCreeperBossEris(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityEvolvedGiantZombieBoss.class, (RenderManager manager) -> new RenderEvolvedGiantZombieBoss(manager));
		}
		if (Config.MERCURY)
			ClientUtilities.registerEntityRenderer(EntityTier4Rocket.class, (RenderManager manager) -> new RenderTier4Rocket(manager));
		if (Config.JUPITER)
			ClientUtilities.registerEntityRenderer(EntityTier5Rocket.class, (RenderManager manager) -> new RenderTier5Rocket(manager));
		if (Config.SATURN)
			ClientUtilities.registerEntityRenderer(EntityTier6Rocket.class, (RenderManager manager) -> new RenderTier6Rocket(manager));
		if (Config.URANUS)
			ClientUtilities.registerEntityRenderer(EntityTier7Rocket.class, (RenderManager manager) -> new RenderTier7Rocket(manager));
		if (Config.NEPTUNE)
			ClientUtilities.registerEntityRenderer(EntityTier8Rocket.class, (RenderManager manager) -> new RenderTier8Rocket(manager));
		if (Config.PLUTO)
			if (Config.OLD_ROCKET_MODELS)
				ClientUtilities.registerEntityRenderer(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9Rocket(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9RocketNew(manager));
		if (Config.ERIS)
			if (Config.OLD_ROCKET_MODELS)
				ClientUtilities.registerEntityRenderer(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10Rocket(manager));
			else
				ClientUtilities.registerEntityRenderer(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10RocketNew(manager));
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			ClientUtilities.registerEntityRenderer(EntityElectricRocket.class, (RenderManager manager) -> new RenderElectricRocket(manager));
		if (Config.CERES && Config.NUCLEAR_BOMB)
			ClientUtilities.registerEntityRenderer(EntityNuclearBombPrimed.class, (RenderManager manager) -> new RenderNuclearBombPrimed(manager));
		if (Config.CERES && Config.FIRE_BOMB)
			ClientUtilities.registerEntityRenderer(EntityFireBombPrimed.class, (RenderManager manager) -> new RenderFireBombPrimed(manager));
		if (Config.MARS_ROVER)
			ClientUtilities.registerEntityRenderer(EntityMarsRover.class, (RenderManager manager) -> new RenderMarsRover(manager));
		if (Config.VENUS_ROVER)
			ClientUtilities.registerEntityRenderer(EntityVenusRover.class, (RenderManager manager) -> new RenderVenusRover(manager));
		ClientUtilities.registerEntityRenderer(EntitySmallSnowball.class, (RenderManager manager) -> new RenderSmallSnowBall(manager, new ItemStack(Items.SNOWBALL)));
		ClientUtilities.registerEntityRenderer(EntityGeneralLander.class, (RenderManager manager) -> new RenderGeneralLander(manager));
	}

	@Override
	public void registerCustomModel() {
		if (Config.MERCURY) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_ROCKET, "rocket_t4", 5);
		}
		if (Config.JUPITER) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_ROCKET, "rocket_t5", 5);
		}
		if (Config.SATURN) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_ROCKET, "rocket_t6", 5);
		}
		if (Config.URANUS) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_ROCKET, "rocket_t7", 5);
		}
		if (Config.NEPTUNE) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_ROCKET, "rocket_t8", 5);
		}
		if (Config.PLUTO) {
			if (Config.OLD_ROCKET_MODELS) {
				ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_ROCKET, "rocket_t9", 5);
			} else {
				ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_ROCKET, "rocket_t9_new", 5);
			}
		}
		if (Config.ERIS) {
			if (Config.OLD_ROCKET_MODELS) {
				ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_ROCKET, "rocket_t10", 5);
			} else {
				ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_ROCKET, "rocket_t10_new", 5);
			}
		}
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET, "electric_rocket", 5);
		}
		if (Config.MARS_ROVER) {
			for (int i = 0; i < 4; ++i) {
				ClientUtilities.registerModel(ExtraPlanets_Items.MARS_ROVER, i, new ModelResourceLocation(Constants.TEXTURE_PREFIX + "mars_rover" + (i > 0 ? "_" + i : ""), "inventory"));
			}
		}
		if (Config.VENUS_ROVER) {
			for (int i = 0; i < 4; ++i) {
				ClientUtilities.registerModel(ExtraPlanets_Items.VENUS_ROVER, i, new ModelResourceLocation(Constants.TEXTURE_PREFIX + "venus_rover" + (i > 0 ? "_" + i : ""), "inventory"));
			}
		}
		if (Config.RADIATION && Config.BASIC_DECONTAMINATION_UNIT) {
			ClientUtilities.registerModel(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_DECONTAMINATION_UNIT, "basic_decontamination_unit");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderBlocksTileEntitySpecialRenderers() {
		if (Config.MERCURY)
			ClientUtilities.registerTileEntityRenderer(TileEntityT4TreasureChest.class, new TileEntityT4TreasureChestRenderer());
		if (Config.JUPITER)
			ClientUtilities.registerTileEntityRenderer(TileEntityT5TreasureChest.class, new TileEntityT5TreasureChestRenderer());
		if (Config.SATURN)
			ClientUtilities.registerTileEntityRenderer(TileEntityT6TreasureChest.class, new TileEntityT6TreasureChestRenderer());
		if (Config.URANUS)
			ClientUtilities.registerTileEntityRenderer(TileEntityT7TreasureChest.class, new TileEntityT7TreasureChestRenderer());
		if (Config.NEPTUNE)
			ClientUtilities.registerTileEntityRenderer(TileEntityT8TreasureChest.class, new TileEntityT8TreasureChestRenderer());
		if (Config.PLUTO)
			ClientUtilities.registerTileEntityRenderer(TileEntityT9TreasureChest.class, new TileEntityT9TreasureChestRenderer());
		if (Config.ERIS)
			ClientUtilities.registerTileEntityRenderer(TileEntityT10TreasureChest.class, new TileEntityT10TreasureChestRenderer());
		if (Config.SOLAR_PANELS)
			ClientUtilities.registerTileEntityRenderer(TileEntitySolar.class, new TileEntitySolarPanelRenderer());
		if (Config.RADIATION && Config.BASIC_DECONTAMINATION_UNIT)
			ClientUtilities.registerTileEntityRenderer(TileEntityBasicDecontaminationUnit.class, new TileEntityBasicDecontaminationUnitRenderer());
	}

	@Override
	public void registerBlockJsons() {
		// Planets
		if (Config.MERCURY) {
			for (BlockBasicMercury.EnumBlockBasic blockBasic : BlockBasicMercury.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_GRAVEL);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_4);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_SPAWNER);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.CERES) {
			for (BlockBasicCeres.EnumBlockBasic blockBasic : BlockBasicCeres.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_GRAVEL);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_STONE_BRICKS_STAIRS);
			}
			if (Config.NUCLEAR_BOMB)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NUCLEAR_BOMB);
		}
		if (Config.JUPITER) {
			for (BlockBasicJupiter.EnumBlockBasic blockBasic : BlockBasicJupiter.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUPITER_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_5);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUPITER_GRAVEL);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.VOLCANIC_ROCK);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ASH_ROCK);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ORANGE_SAND);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ORANGE_SANDSTONE);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUIPTER_SPAWNER);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUPITER_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUPITER_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUPITER_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.JUPITER_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.SATURN) {
			for (BlockBasicSaturn.EnumBlockBasic blockBasic : BlockBasicSaturn.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_6);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_GRAVEL);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_SPAWNER);
			if (Config.FIRE_BOMB)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FIRE_BOMB);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.URANUS) {
			for (BlockBasicUranus.EnumBlockBasic blockBasic : BlockBasicUranus.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_7);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DENSE_ICE);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_SPAWNER);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.NEPTUNE) {
			for (BlockBasicNeptune.EnumBlockBasic blockBasic : BlockBasicNeptune.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_8);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FROZEN_NITROGEN);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_SPAWNER);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.PLUTO) {
			for (BlockBasicPluto.EnumBlockBasic blockBasic : BlockBasicPluto.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_9);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_GRAVEL);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_SPAWNER);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.ERIS) {
			for (BlockBasicEris.EnumBlockBasic blockBasic : BlockBasicEris.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_10);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_GRAVEL);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_SPAWNER);
			if (Config.SLABS_AND_STAIRS) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_SUB_SURFACE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_STONE_STAIRS);
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_STONE_BRICKS_STAIRS);
			}
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_BLUE);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_RED);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_PURPLE);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_YELLOW);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_GREEN);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_INFECTED);

			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.RED_SAND);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.RED_SANDSTONE);

			for (BlockBasicKepler22b.EnumBlockBasic blockBasic : BlockBasicKepler22b.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			for (BlockBasicKepler22bPlanks.EnumType blockBasic : BlockBasicKepler22bPlanks.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, blockBasic.getMetadata(), blockBasic.getName());
			}

			for (BlockKepler22bMapleTreeLog.EnumType blockBasic : BlockKepler22bMapleTreeLog.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, blockBasic.getMetadata(), blockBasic.getName());
			}

			for (BlockKepler22bMapleTreeLog2.EnumType blockBasic : BlockKepler22bMapleTreeLog2.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, blockBasic.getMetadata(), blockBasic.getName());
			}
			for (BlockKepler22bMapleTreeLeaves.EnumType blockBasic : BlockKepler22bMapleTreeLeaves.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF, blockBasic.getMetadata(), blockBasic.getName());
			}
			for (BlockKepler22bMapleTreeLeaves2.EnumType blockBasic : BlockKepler22bMapleTreeLeaves2.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2, blockBasic.getMetadata(), blockBasic.getName());
			}
			for (BlockKepler22bMapleTreeSapling.EnumType blockBasic : BlockKepler22bMapleTreeSapling.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, blockBasic.getMetadata(), blockBasic.getName());
			}
			for (BlockBasicKepler22bTallGrass.EnumType blockBasic : BlockBasicKepler22bTallGrass.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if (Config.KEPLER22B || Config.JUPITER) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.RED_SAND);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.RED_SANDSTONE);
		}
		// Moons
		if (Config.CALLISTO) {
			for (BlockBasicCallisto.EnumBlockBasic blockBasic : BlockBasicCallisto.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CALLISTO_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CALLISTO_GRAVEL);
		}
		if (Config.DEIMOS) {
			for (BlockBasicDeimos.EnumBlockBasic blockBasic : BlockBasicDeimos.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DEIMOS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DEIMOS_GRAVEL);
		}
		if (Config.EUROPA) {
			for (BlockBasicEuropa.EnumBlockBasic blockBasic : BlockBasicEuropa.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.EUROPA_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.EUROPA_GRAVEL);
		}
		if (Config.GANYMEDE) {
			for (BlockBasicGanymede.EnumBlockBasic blockBasic : BlockBasicGanymede.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.GANYMEDE_GRAVEL);
		}
		if (Config.IO) {
			for (BlockBasicIo.EnumBlockBasic blockBasic : BlockBasicIo.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.IO_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.IO_GRAVEL);
		}
		if (Config.PHOBOS) {
			for (BlockBasicPhobos.EnumBlockBasic blockBasic : BlockBasicPhobos.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PHOBOS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PHOBOS_GRAVEL);
		}
		if (Config.RHEA) {
			for (BlockBasicRhea.EnumBlockBasic blockBasic : BlockBasicRhea.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.RHEA_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.RHEA_GRAVEL);
		}
		if (Config.TITAN) {
			for (BlockBasicTitan.EnumBlockBasic blockBasic : BlockBasicTitan.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TITAN_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TITAN_GRAVEL);
		}
		if (Config.TRITON) {
			for (BlockBasicTriton.EnumBlockBasic blockBasic : BlockBasicTriton.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TRITON_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TRITON_GRAVEL);
		}
		if (Config.OBERON) {
			for (BlockBasicOberon.EnumBlockBasic blockBasic : BlockBasicOberon.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.OBERON_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.OBERON_GRAVEL);
		}
		if (Config.TITANIA) {
			for (BlockBasicTitania.EnumBlockBasic blockBasic : BlockBasicTitania.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TITANIA_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TITANIA_GRAVEL);
		}
		if (Config.IAPETUS) {
			for (BlockBasicIapetus.EnumBlockBasic blockBasic : BlockBasicIapetus.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.IAPETUS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.IAPETUS_GRAVEL);
		}

		// Machines
		if (Config.REFINERY_ADVANCED)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.REFINERY_ADVANCED, 0, "advanced_refinery");
		if (Config.REFINERY_ULTIMATE)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.REFINERY_ULTIMATE, 0, "ultimate_refinery");
		if (Config.SOLAR_PANELS) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.SOLAR_PANEL, 0, "hybrid_solar");
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.SOLAR_PANEL, 4, "ultimate_solar");
		}
		if (Config.OXYGEN_COMPRESSOR_ADVANCED) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 0, "advanced_oxygen_compressor");
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 4, "advanced_oxygen_decompressor");
		}
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 0, "ultimate_oxygen_compressor");
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 4, "ultimate_oxygen_decompressor");
		}
		if (Config.RADIATION) {
			if (Config.BASIC_CHEMICAL_INJECTOR)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_CHEMICAL_INJECTOR);
			if (Config.BASIC_CRYSTALLIZER)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_CRYSALLIZER);
			if (Config.BASIC_DECRYSTALLIZER)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_DECRYSALLIZER);
			if (Config.BASIC_SMASHER)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_SMASHER);
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_SOLAR_EVAPORTATION_CHAMBER);
			if (Config.BASIC_PURIFIER)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_PURIFIER);
		}
		if (Config.FUEL_LOADER_ADVANCED)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.FUEL_LOADER_ADVANCED);
		if (Config.FUEL_LOADER_ULTIMATE)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE);
		if (Config.BASIC_DENSIFIER)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.BASIC_DENSIFIER);
		if (Config.VEHICLE_CHARGER)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.VEHICLE_CHARGER);

		// Other Blocks
		if (Config.MERCURY || Config.CERES || Config.PLUTO || Config.ERIS)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FOSSIL);
		if (Config.RADIATION)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ORE_POTASH);
		if (Config.ORE_LEAD_GENERATION)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ORE_LEAD);
		for (BlockCustomLandingPad.EnumLandingPadType blockBasic : BlockCustomLandingPad.EnumLandingPadType.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockCustomLandingPadFull.EnumLandingPadFullType blockBasic : BlockCustomLandingPadFull.EnumLandingPadFullType.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockDecorativeBlocks.EnumBlockBasic blockBasic : BlockDecorativeBlocks.EnumBlockBasic.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DECORATIVE_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockDecorativeBlocks2.EnumBlockBasic blockBasic : BlockDecorativeBlocks2.EnumBlockBasic.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockCandyBlocks.EnumBlockBasic blockBasic : BlockCandyBlocks.EnumBlockBasic.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CANDY_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockCandyBlocksHorizontal.EnumBlockBasic blockBasic : BlockCandyBlocksHorizontal.EnumBlockBasic.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockCakeBlocks.EnumBlockBasic blockBasic : BlockCakeBlocks.EnumBlockBasic.values()) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CAKE_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
		}
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FAKE_BLOCK);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.WHITE_SUGAR_CANE);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DIAMOND_GRIT);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.GOLD_GRIT);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.COAL_GRIT);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.EMERALD_GRIT);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.IRON_GRIT);
	}

	@Override
	public void registerItemJsons() {
		if (Config.MERCURY) {
			if (Config.BATTERIES)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_MERCURY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.COMPRESSED_MERCURY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.INGOT_MERCURY);
			if (Config.ITEMS_MERCURY) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MERCURY_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MERCURY_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MERCURY_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MERCURY_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MERCURY_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MERCURY_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MERCURY_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MERCURY_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MERCURY_SWORD);
			}

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_SCHEMATIC);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_ITEMS, ItemTier4Items.getItemList());
			if (Config.ITEMS_CARBON) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CARBON_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CARBON_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CARBON_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CARBON_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CARBON_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CARBON_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CARBON_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CARBON_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CARBON_SWORD);
			}
		}
		if (Config.CERES) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.INGOT_URANIUM);
			if (Config.ITEMS_URANIUM) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.URANIUM_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.URANIUM_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.URANIUM_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.URANIUM_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.URANIUM_SWORD);
			}
		}
		if (Config.JUPITER) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_SCHEMATIC);
			if (Config.BATTERIES)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_NICKEL);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_ITEMS, ItemTier5Items.getItemList());
			if (Config.ITEMS_PALLADIUM) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PALLASIUM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PALLASIUM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PALLASIUM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PALLASIUM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PALLADIUM_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PALLADIUM_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PALLADIUM_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PALLADIUM_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PALLADIUM_SWORD);
			}
			if (Config.ITEMS_GEM_RED) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_GEM_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_GEM_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_GEM_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_GEM_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_GEM_SWORD);
			}
		}
		if (Config.SATURN) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_SCHEMATIC);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_ITEMS, ItemTier6Items.getItemList());
			if (Config.ITEMS_MAGNESIUM) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MAGNESIUM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MAGNESIUM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MAGNESIUM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.MAGNESIUM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MAGNESIUM_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MAGNESIUM_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MAGNESIUM_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MAGNESIUM_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.MAGNESIUM_SWORD);
			}
		}
		if (Config.URANUS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_SCHEMATIC);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_ITEMS, ItemTier7Items.getItemList());
			if (Config.ITEMS_CRYSTAL) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CRYSTAL_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CRYSTAL_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CRYSTAL_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.CRYSTAL_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CRYSTAL_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CRYSTAL_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CRYSTAL_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CRYSTAL_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.CRYSTAL_SWORD);
			}
			if (Config.ITEMS_GEM_WHITE) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.WHITE_GEM_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.WHITE_GEM_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.WHITE_GEM_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.WHITE_GEM_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.WHITE_GEM_SWORD);
			}
		}
		if (Config.NEPTUNE) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_SCHEMATIC);
			if (Config.BATTERIES)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_ZINC);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_ITEMS, ItemTier8Items.getItemList());
			if (Config.ITEMS_ZINC) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.ZINC_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.ZINC_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.ZINC_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.ZINC_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.ZINC_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.ZINC_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.ZINC_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.ZINC_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.ZINC_SWORD);
			}
			if (Config.ITEMS_GEM_BLUE) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_GEM_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_GEM_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_GEM_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_GEM_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_GEM_SWORD);
			}
		}
		if (Config.PLUTO) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_SCHEMATIC);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_ITEMS, ItemTier9Items.getItemList());
			if (Config.ITEMS_TUNGSTEN) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TUNGSTEN_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TUNGSTEN_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TUNGSTEN_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TUNGSTEN_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.TUNGSTEN_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.TUNGSTEN_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.TUNGSTEN_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.TUNGSTEN_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.TUNGSTEN_SWORD);
			}
		}
		if (Config.ERIS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_SCHEMATIC);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_ITEMS, ItemTier10Items.getItemList());
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_11_ITEMS, ItemTier11Items.getItemList());
			if (Config.ITEMS_KEPLER22B) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_DIAMOND_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_DIAMOND_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_DIAMOND_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_DIAMOND_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.GREEN_DIAMOND_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.GREEN_DIAMOND_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.GREEN_DIAMOND_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.GREEN_DIAMOND_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PURPLE_DIAMOND_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PURPLE_DIAMOND_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PURPLE_DIAMOND_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.PURPLE_DIAMOND_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_DIAMOND_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_DIAMOND_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_DIAMOND_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_DIAMOND_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.YELLOW_DIAMOND_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.YELLOW_DIAMOND_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.YELLOW_DIAMOND_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.YELLOW_DIAMOND_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_DIAMOND_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_DIAMOND_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_DIAMOND_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_DIAMOND_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.BLUE_DIAMOND_SWORD);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_DIAMOND_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_DIAMOND_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_DIAMOND_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_DIAMOND_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.RED_DIAMOND_SWORD);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PURPLE_DIAMOND_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PURPLE_DIAMOND_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PURPLE_DIAMOND_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PURPLE_DIAMOND_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.PURPLE_DIAMOND_SWORD);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.YELLOW_DIAMOND_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.YELLOW_DIAMOND_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.YELLOW_DIAMOND_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.YELLOW_DIAMOND_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.YELLOW_DIAMOND_SWORD);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.GREEN_DIAMOND_AXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.GREEN_DIAMOND_HOE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.GREEN_DIAMOND_PICKAXE);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.GREEN_DIAMOND_SHOVEL);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.GREEN_DIAMOND_SWORD);
			}
		}
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET_SCHEMATIC);
		if (Config.CUSTOM_APPLES) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.DIAMOND_APPLE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.IRON_APPLE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.DIAMOND_APPLE, 1);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.IRON_APPLE, 1);
		}
		if (Config.BATTERIES) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_ADVANCED);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_ULTIMATE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_MASSIVE);
		}
		if (Config.THERMAL_PADDINGS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_THERMAL_PADDING, ItemTier3ThermalPadding.names);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_THERMAL_PADDING, ItemTier4ThermalPadding.names);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_THERMAL_PADDING, ItemTier5ThermalPadding.names);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.THERMAL_CLOTH, ItemThermalCloth.names);
		}
		if (Config.OXYGEN_TANKS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY);
		}
		if (Config.PRESSURE || Config.RADIATION) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ENVIRO_EMERGENCY_KIT);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_ARMOR_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_PRESSURE_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_RADIATION_LAYER);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_ARMOR_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_PRESSURE_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_RADIATION_LAYER);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_ARMOR_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_PRESSURE_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_RADIATION_LAYER);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_ARMOR_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_PRESSURE_LAYER);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_RADIATION_LAYER);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_JETPACK_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS);
			
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_0_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_0_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_0_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_0_SPACE_SUIT_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_JETPACK_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_GRAVITY_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_JETPACK_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_JETPACK_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS);
		}
		if (Config.RADIATION) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.IODIDE_SALT);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.POTASH_SHARDS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.POTASSIUM);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.POTASSIUM_IODIDE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ANTI_RADIATION);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MODULE_ITEMS, ItemModuleItems.getItemList());
		}
		if (Config.CANNED_FOOD) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CANNED_FOOD, ItemCannedFood.getItemList());
		}
		if (Config.MARS_ROVER || Config.VENUS_ROVER || Config.ELECTRIC_ROCKET) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ELECTRIC_PARTS, ItemElectricParts.getItemList());
		}
		if (Config.MARS_ROVER)
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MARS_ROVER_SCHEMATIC);
		if (Config.VENUS_ROVER)
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.VENUS_ROVER_SCHEMATIC);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.WAFERS, ItemWafers.getItemList());
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TOOLS, ItemTools.names);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, "tier1_kit", ItemBasicKit.getItemList());
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, "tier2_kit", ItemBasicKit.getItemList());
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, "tier3_kit", ItemBasicKit.getItemList());
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, "tier4_kit", ItemBasicKit.getItemList());
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, "tier5_kit", ItemBasicKit.getItemList());
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.INGOT_LEAD);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CLOTH);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.GRAVITY_CONTROLLER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.GEIGER_COUNTER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.WHITE_SUGAR_CANE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CARAMEL_BAR);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CHOCOLATE_BAR);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLACK);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_RED);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GREEN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BROWN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLUE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PURPLE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_CYAN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_GRAY);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GRAY);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PINK);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_YELLOW);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_BLUE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_MAGENTA);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_ORANGE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_WHITE);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_BLACK);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_RED);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_GREEN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_BROWN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_BLUE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_PURPLE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_CYAN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_GRAY);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_GRAY);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_PINK);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_YELLOW);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_BLUE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_MAGENTA);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_LIME);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MED_OXYGEN_TANK_WHITE);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLACK);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIME);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GREEN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BROWN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLUE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PURPLE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_CYAN);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_GRAY);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GRAY);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PINK);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_YELLOW);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_BLUE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_MAGENTA);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_ORANGE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_WHITE);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBakeEvent(ModelBakeEvent event) {
		if (Config.MERCURY)
			ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t4", ImmutableList.of("Nozzle", "Body_Rocket", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4", "Tip", "Ring", "FrameWindow1", "FrameWindow2",
					"FrameWindow3", "FrameWindow4", "GlassWindow", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4"), ItemModelRocketT4.class);
		if (Config.JUPITER)
			ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t5",
					ImmutableList.of("Nozzle", "Body_Rocket", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4", "Tip", "Ring", "FrameWindow1", "FrameWindow2", "FrameWindow3", "FrameWindow4", "GlassWindow",
							"CorrectedWind005", "CorrectedWind006", "CorrectedWind007", "CorrectedWind008", "Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004", "Cylinder005", "Cylinder006", "Helix001", "CorrectedWind1", "CorrectedWind2",
							"CorrectedWind3", "CorrectedWind4"),
					ItemModelRocketT5.class);
		if (Config.SATURN)
			ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t6",
					ImmutableList.of("Nozzle", "Body_Rocket", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4", "Tip", "Ring",
							"FrameWindow1", "FrameWindow2", "FrameWindow3", "FrameWindow4", "GlassWindow", "CorrectedWind005", "CorrectedWind006", "CorrectedWind007", "CorrectedWind008", "Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004",
							"Cylinder005", "Cylinder006", "Helix001", "SplinePathDeform", "Pipe004", "Pipe005", "Pipe006", "Pipe007", "RocketEngine", "RocketEngine001", "RocketEngine002", "RocketEngine003", "RocketEnginePlut", "RocketEnginePlut001",
							"RocketEnginePlut002", "RocketEnginePlut003"),
					ItemModelRocketT6.class);
		if (Config.URANUS)
			ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t7",
					ImmutableList.of("Nozzle", "Body_Rocket", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4", "Tip", "Ring",
							"FrameWindow1", "FrameWindow2", "FrameWindow3", "FrameWindow4", "GlassWindow", "CorrectedWind005", "CorrectedWind006", "CorrectedWind007", "CorrectedWind008", "Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004",
							"Cylinder005", "Cylinder006", "Helix001", "SplinePathDeform", "Pipe004", "Pipe005", "Pipe006", "Pipe007", "RocketEngine", "RocketEngine001", "RocketEngine002", "RocketEngine003", "RocketEngineBottom",
							"RocketEngineBottom001", "RocketEngineBottom002", "RocketEngineBottom003", "PathDeform2", "Wire1", "Wire2", "WireLight", "RocketEnginePlut", "RocketEnginePlut001", "RocketEnginePlut002", "RocketEnginePlut003"),
					ItemModelRocketT7.class);
		if (Config.NEPTUNE)
			ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t8",
					ImmutableList.of("Nozzle", "BodyRocket", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4", "Rocket_stabilizer007", "Rocket_stabilizer008", "Rocket_stabilizer009", "Rocket_stabilizer010",
							"SplinePathDeform", "RocketEngine", "RocketEngine001", "RocketEngine002", "RocketEngine003", "RocketEngine004", "RocketEngine005", "RocketEngine006", "RocketEngine007", "RocketEngineBottom", "RocketEngineBottom001",
							"RocketEngineBottom002", "RocketEngineBottom003", "RocketEngineBottom004", "RocketEngineBottom005", "RocketEngineBottom006", "RocketEngineBottom007", "FloorCockPit", "NoseRocket", "NozzleKeeper", "rotary_engine",
							"rotary_engine2", "rotary_engine3", "rotary_engine4", "RocketEnginePlut", "RocketEnginePlut001", "RocketEnginePlut002", "RocketEnginePlut003", "RocketEnginePlut004", "RocketEnginePlut005", "RocketEnginePlut006",
							"RocketEnginePlut007"),
					ItemModelRocketT8.class);
		if (Config.PLUTO)
			if (Config.OLD_ROCKET_MODELS) {
				ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t9",
						ImmutableList.of("Nozzle", "Nozzle001", "Nozzle002", "NozzleKeeper", "NozzleKeeper001", "BodyRocket", "BodyRocket001", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4",
								"Rocket_stabilizer007", "Rocket_stabilizer008", "Rocket_stabilizer009", "Rocket_stabilizer010", "Rocket_stabilizer011", "Rocket_stabilizer012", "SplinePathDeform", "RocketEngine", "RocketEngine002", "RocketEngine004",
								"RocketEngine005", "RocketEngine007", "RocketEngine008", "RocketEngineBottom", "RocketEngineBottom003", "RocketEngineBottom004", "RocketEngineBottom005", "RocketEngineBottom006", "RocketEngineBottom007",
								"RocketEngineBottom008", "FloorCockPit", "Cockoit", "NoseRocket", "rotary_engine", "rotary_engine2", "rotary_engine3", "rotary_engine4", "rotary_engine005", "rotary_engine006", "RocketEnginePlut",
								"RocketEnginePlut002", "RocketEnginePlut004", "RocketEnginePlut005", "RocketEnginePlut007", "RocketEnginePlut008"),
						ItemModelRocketT9.class);
			} else {
				ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t9_new",
						ImmutableList.of("BodyRocket", "Connector", "LampOnSpike", "MainNozzle", "NoseRocket", "NoseRocketMiddle", "SideEngine1", "SideEngine2", "SideEngine3", "SideEngine4", "Spike"), ItemModelRocketT9New.class);
			}
		if (Config.ERIS)
			if (Config.OLD_ROCKET_MODELS) {
				ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t10",
						ImmutableList.of("RocketCockpit", "RoofCockpit", "NoseRocket", "Nozzle001", "NozzleKeeper001", "NozzleKeeper002", "RocketEngine004", "RocketEngine005", "RocketEngine006", "RocketEngine007", "RocketEngineBottom004",
								"RocketEngineBottom005", "RocketEngineBottom006", "RocketEngineBottom007", "FloorCockPit", "RocketEnginePlut004", "RocketEnginePlut005", "RocketEnginePlut006", "RocketEnginePlut007"),
						ItemModelRocketT10.class);
			} else {
				ClientUtilities.replaceModelDefault(Constants.modID, event, "rocket_t10_new", ImmutableList.of("BigSideWing1", "BigSideWing2", "BodyRocket", "Connector", "LampOnSpike", "MainNozzle", "NoseRocket", "NoseRocketMiddle", "SideEngine1",
						"SideEngine2", "SideEngine3", "SideEngine3", "SideEngine4", "SideWing1", "SideWing2", "SideWing3", "SideWing4", "Spike"), ItemModelRocketT10New.class);
			}
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			ClientUtilities.replaceModelDefault(Constants.modID, event, "electric_rocket",
					ImmutableList.of("Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004", "Cylinder005", "Cylinder006", "Cylinder007", "Cylinder008", "Cylinder009", "Cylinder010", "Cylinder011", "Cylinder012", "Cylinder013", "Cylinder014",
							"Cylinder015", "Cylinder016", "Cylinder017", "Cylinder018", "Cylinder019", "Cylinder020", "Cylinder021", "Line001", "Line002", "Torus001", "Torus002", "Torus003", "Torus004", "Torus005", "Torus006", "Torus007", "Torus008",
							"Tube001"),
					ItemModelRocketElectricRocket.class);

		if (Config.MARS_ROVER) {
			for (int i = 0; i < 4; ++i) {
				ImmutableList<String> objects = ImmutableList.of("RoofRover", "FloorRover", "Clip1", "Clip2", "AxisBack", "AxisFront", "AxisFront001", "AxisMiddle", "FrameSegment010", "FrameSegment011", "FrameSegment012", "FrameSegment013",
						"FrameSegment014", "FrameSegment015", "FrameSegment021", "FrameSegment022", "FrameSegment023", "FrameSegment024", "FrameSegment025", "FrameSegment026", "FrameSegment027", "FrameSegment028", "FrameSegment029",
						"FrameSegment030", "FrameSegment031", "FrameSegment032", "FrameSegment033", "FrameSegment044", "FrameSegment045", "FrameSegment046", "FrameSegment047", "FrameSegment048", "FrameSegment049", "FrameSegment050",
						"FrameSegment051", "FrameSegment052", "FrameSegment053", "FrameSegment054", "FrameSegment055", "FrameSegment056", "FrameSegment057", "FrameSegment058", "FrameSegment059", "Line001", "HelmKeeper", "Helm", "Seat", "Seat001",
						"SolarPanel", "PoleSolarPanel", "SolarPanelBlock", "Wire", "Battery", "Line002", "WindowBack", "WindowFragment3", "Lightning", "Lightning2", "WindowFront1", "WindowFront2", "WheelBackLeft", "WheelMiddleLeft",
						"WheelFrontRight", "WheelBackRight", "WheelMiddleRight", "WheelFrontLeft", "SolarPlane", "CaseBack1", "CaseBack2", "CaseBack3");
				switch (i) {
				case 0:
					break;
				case 1:
					objects = ImmutableList.of("RoofRover", "FloorRover", "Clip1", "Clip2", "AxisBack", "AxisFront", "AxisFront001", "AxisMiddle", "FrameSegment010", "FrameSegment011", "FrameSegment012", "FrameSegment013", "FrameSegment014",
							"FrameSegment015", "FrameSegment021", "FrameSegment022", "FrameSegment023", "FrameSegment024", "FrameSegment025", "FrameSegment026", "FrameSegment027", "FrameSegment028", "FrameSegment029", "FrameSegment030",
							"FrameSegment031", "FrameSegment032", "FrameSegment033", "FrameSegment044", "FrameSegment045", "FrameSegment046", "FrameSegment047", "FrameSegment048", "FrameSegment049", "FrameSegment050", "FrameSegment051",
							"FrameSegment052", "FrameSegment053", "FrameSegment054", "FrameSegment055", "FrameSegment056", "FrameSegment057", "FrameSegment058", "FrameSegment059", "Line001", "HelmKeeper", "Helm", "Seat", "Seat001", "SolarPanel",
							"PoleSolarPanel", "SolarPanelBlock", "Wire", "Battery", "Line002", "WindowBack", "WindowFragment3", "Lightning", "Lightning2", "WindowFront1", "WindowFront2", "WheelBackLeft", "WheelMiddleLeft", "WheelFrontRight",
							"WheelBackRight", "WheelMiddleRight", "WheelFrontLeft", "SolarPlane", "CaseBack1", "CaseBack2", "CaseBack3", "Container");
					break;
				case 2:
					objects = ImmutableList.of("RoofRover", "FloorRover", "Clip1", "Clip2", "AxisBack", "AxisFront", "AxisFront001", "AxisMiddle", "FrameSegment010", "FrameSegment011", "FrameSegment012", "FrameSegment013", "FrameSegment014",
							"FrameSegment015", "FrameSegment021", "FrameSegment022", "FrameSegment023", "FrameSegment024", "FrameSegment025", "FrameSegment026", "FrameSegment027", "FrameSegment028", "FrameSegment029", "FrameSegment030",
							"FrameSegment031", "FrameSegment032", "FrameSegment033", "FrameSegment044", "FrameSegment045", "FrameSegment046", "FrameSegment047", "FrameSegment048", "FrameSegment049", "FrameSegment050", "FrameSegment051",
							"FrameSegment052", "FrameSegment053", "FrameSegment054", "FrameSegment055", "FrameSegment056", "FrameSegment057", "FrameSegment058", "FrameSegment059", "Line001", "HelmKeeper", "Helm", "Seat", "Seat001", "SolarPanel",
							"PoleSolarPanel", "SolarPanelBlock", "Wire", "Battery", "Line002", "WindowBack", "WindowFragment3", "Lightning", "Lightning2", "WindowFront1", "WindowFront2", "WheelBackLeft", "WheelMiddleLeft", "WheelFrontRight",
							"WheelBackRight", "WheelMiddleRight", "WheelFrontLeft", "SolarPlane", "CaseBack1", "CaseBack2", "CaseBack3", "Container", "Container2");
					break;
				case 3:
					objects = ImmutableList.of("RoofRover", "FloorRover", "Clip1", "Clip2", "AxisBack", "AxisFront", "AxisFront001", "AxisMiddle", "FrameSegment010", "FrameSegment011", "FrameSegment012", "FrameSegment013", "FrameSegment014",
							"FrameSegment015", "FrameSegment021", "FrameSegment022", "FrameSegment023", "FrameSegment024", "FrameSegment025", "FrameSegment026", "FrameSegment027", "FrameSegment028", "FrameSegment029", "FrameSegment030",
							"FrameSegment031", "FrameSegment032", "FrameSegment033", "FrameSegment044", "FrameSegment045", "FrameSegment046", "FrameSegment047", "FrameSegment048", "FrameSegment049", "FrameSegment050", "FrameSegment051",
							"FrameSegment052", "FrameSegment053", "FrameSegment054", "FrameSegment055", "FrameSegment056", "FrameSegment057", "FrameSegment058", "FrameSegment059", "Line001", "HelmKeeper", "Helm", "Seat", "Seat001", "SolarPanel",
							"PoleSolarPanel", "SolarPanelBlock", "Wire", "Battery", "Line002", "WindowBack", "WindowFragment3", "Lightning", "Lightning2", "WindowFront1", "WindowFront2", "WheelBackLeft", "WheelMiddleLeft", "WheelFrontRight",
							"WheelBackRight", "WheelMiddleRight", "WheelFrontLeft", "SolarPlane", "CaseBack1", "CaseBack2", "CaseBack3", "Container", "Container2", "Container3");
					break;
				}
				ClientUtilities.replaceModelDefault(Constants.modID, event, "mars_rover" + (i > 0 ? "_" + i : ""), "mars_rover.obj", objects, ItemModelMarsRover.class);
			}
		}
		if (Config.VENUS_ROVER) {
			for (int i = 0; i < 4; ++i) {
				ImmutableList<String> objects = ImmutableList.of("Battery", "Battery2", "BraceFrontWheelLeft", "BraceFrontWheelLeft2", "BraceFrontWheelLeft003", "BraceFrontWheelLeft004", "BraceFrontWheelRight", "BraceFrontWheelRight2",
						"BraceFrontWheelRight003", "BraceFrontWheelRight004", "BraceFrontWheelRight005", "BraceFrontWheelRight006", "Clip1", "Clip2", "door", "doorhandle", "Doorhinge1", "Doorhinge2", "Floor", "Frame2", "Frame003", "RTG", "Seat",
						"Spinka", "Helm", "PoleHelm", "RTGPart1", "RtGPart2", "TRGPart3", "TRGPart4", "TRGPart5", "Line001", "Box002", "Box003", "RightWheel", "RightWheel001", "LeftWheel", "LeftWheel001");
				switch (i) {
				case 0:
					break;
				case 1:
					objects = ImmutableList.of("Battery", "Battery2", "BraceFrontWheelLeft", "BraceFrontWheelLeft2", "BraceFrontWheelLeft003", "BraceFrontWheelLeft004", "BraceFrontWheelRight", "BraceFrontWheelRight2", "BraceFrontWheelRight003",
							"BraceFrontWheelRight004", "BraceFrontWheelRight005", "BraceFrontWheelRight006", "Clip1", "Clip2", "door", "doorhandle", "Doorhinge1", "Doorhinge2", "Floor", "Frame2", "Frame003", "RTG", "Seat", "Spinka", "Helm",
							"PoleHelm", "RTGPart1", "RtGPart2", "TRGPart3", "TRGPart4", "TRGPart5", "Line001", "Box002", "Box003", "RightWheel", "RightWheel001", "LeftWheel", "LeftWheel001", "Container");
					break;
				case 2:
					objects = ImmutableList.of("Battery", "Battery2", "BraceFrontWheelLeft", "BraceFrontWheelLeft2", "BraceFrontWheelLeft003", "BraceFrontWheelLeft004", "BraceFrontWheelRight", "BraceFrontWheelRight2", "BraceFrontWheelRight003",
							"BraceFrontWheelRight004", "BraceFrontWheelRight005", "BraceFrontWheelRight006", "Clip1", "Clip2", "door", "doorhandle", "Doorhinge1", "Doorhinge2", "Floor", "Frame2", "Frame003", "RTG", "Seat", "Spinka", "Helm",
							"PoleHelm", "RTGPart1", "RtGPart2", "TRGPart3", "TRGPart4", "TRGPart5", "Line001", "Box002", "Box003", "RightWheel", "RightWheel001", "LeftWheel", "LeftWheel001", "Container", "Container2");
					break;
				case 3:
					objects = ImmutableList.of("Battery", "Battery2", "BraceFrontWheelLeft", "BraceFrontWheelLeft2", "BraceFrontWheelLeft003", "BraceFrontWheelLeft004", "BraceFrontWheelRight", "BraceFrontWheelRight2", "BraceFrontWheelRight003",
							"BraceFrontWheelRight004", "BraceFrontWheelRight005", "BraceFrontWheelRight006", "Clip1", "Clip2", "door", "doorhandle", "Doorhinge1", "Doorhinge2", "Floor", "Frame2", "Frame003", "RTG", "Seat", "Spinka", "Helm",
							"PoleHelm", "RTGPart1", "RtGPart2", "TRGPart3", "TRGPart4", "TRGPart5", "Line001", "Box002", "Box003", "RightWheel", "RightWheel001", "LeftWheel", "LeftWheel001", "Container", "Container2", "Container3");
					break;
				}
				ClientUtilities.replaceModelDefault(Constants.modID, event, "venus_rover" + (i > 0 ? "_" + i : ""), "venus_rover.obj", objects, ItemModelVenusRover.class);
			}
		}
		if (Config.RADIATION && Config.BASIC_DECONTAMINATION_UNIT) {
			ClientUtilities.replaceModelDefaultBlock(Constants.modID, event, "basic_decontamination_unit",
					ImmutableList.of("Body", "Water_Baloons", "AtomizersOne", "AtomizersThree", "AtomizersFive", "AtomizersSix", "AtomizersFour", "The_back_wall", "AtomaziersTwo"), ItemModelDecontaminationUnit.class);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void loadTextures(TextureStitchEvent.Pre event) {
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_black");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_blue_textured");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_blue");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_dark_grey");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_dark_red");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_grey");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_light_blue_textured");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_orange_textured");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_textured");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_white");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "blank_rocket_yellow");
		ClientUtilities.registerTexture(Constants.TEXTURE_PREFIX, event, "solar_panel");

		if (event.getMap().equals(Minecraft.getMinecraft().getTextureMapBlocks())) {
			ModuleIcons.pressureModule1 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier1_pressure_layer"));
			ModuleIcons.pressureModule2 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier2_pressure_layer"));
			ModuleIcons.pressureModule3 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier3_pressure_layer"));
			ModuleIcons.pressureModule4 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier4_pressure_layer"));

			ModuleIcons.radiationModule1 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier1_radiation_layer"));
			ModuleIcons.radiationModule2 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier2_radiation_layer"));
			ModuleIcons.radiationModule3 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier3_radiation_layer"));
			ModuleIcons.radiationModule4 = event.getMap().registerSprite(new ResourceLocation(Constants.modID, "items/tier4_radiation_layer"));
		}
	}

	@Override
	public void registerFluidVariants() {
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "nitrogen", ExtraPlanets_Fluids.NITROGEN);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "glowstone", ExtraPlanets_Fluids.GLOWSTONE);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "magma", ExtraPlanets_Fluids.MAGMA);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "frozen_water", ExtraPlanets_Fluids.FROZEN_WATER);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "salt", ExtraPlanets_Fluids.SALT);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "radioactive_water", ExtraPlanets_Fluids.RADIO_ACTIVE_WATER);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "clean_water", ExtraPlanets_Fluids.CLEAN_WATER);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "infected_water", ExtraPlanets_Fluids.INFECTED_WATER);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "methane", ExtraPlanets_Fluids.METHANE);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "nitrogen_ice", ExtraPlanets_Fluids.NITROGEN_ICE);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "liquid_hydrocarbon", ExtraPlanets_Fluids.LIQUID_HYDROCARBON);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "liquid_chocolate", ExtraPlanets_Fluids.LIQUID_CHOCOLATE);
		ClientUtilities.registerFluidVariant(Constants.TEXTURE_PREFIX + "liquid_caramel", ExtraPlanets_Fluids.LIQUID_CARAMEL);
	}

	private void registerSchematicsTextures() {
		ItemSchematicTier4Rocket.registerTextures();
		ItemSchematicTier5Rocket.registerTextures();
		ItemSchematicTier6Rocket.registerTextures();
		ItemSchematicTier7Rocket.registerTextures();
		ItemSchematicTier8Rocket.registerTextures();
		ItemSchematicTier9Rocket.registerTextures();
		ItemSchematicTier10Rocket.registerTextures();
		ItemSchematicTier10ElectricRocket.registerTextures();
		ItemSchematicVenusRover.registerTextures();
		ItemSchematicMarsRover.registerTextures();
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event) {
		// Register Variants
		registerVariants();

		// Register Custom Models
		registerCustomModel();

		// Register Fluid Variants/Renders
		registerFluidVariants();

		// Register TileEntity Special Renderers
		renderBlocksTileEntitySpecialRenderers();

		// Register Block Json Files
		registerBlockJsons();

		// Register Item Json Files
		registerItemJsons();
	}
}
