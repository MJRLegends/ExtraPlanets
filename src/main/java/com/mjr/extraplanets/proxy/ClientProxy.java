package com.mjr.extraplanets.proxy;

import micdoodle8.mods.galacticraft.api.client.IItemMeshDefinitionCustom;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.BlockCustomLandingPad;
import com.mjr.extraplanets.blocks.BlockCustomLandingPadFull;
import com.mjr.extraplanets.blocks.BlockDecorativeBlocks;
import com.mjr.extraplanets.blocks.BlockDecorativeBlocks2;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCeres;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicDeimos;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEris;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEuropa;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicGanymede;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIapetus;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIo;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicJupiter;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicKepler22b;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicMercury;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicNeptune;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicOberon;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPhobos;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPluto;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicRhea;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicSaturn;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitan;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitania;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTriton;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicUranus;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bPlanks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bTallGrass;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves2;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog2;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeSapling;
import com.mjr.extraplanets.client.handlers.KeyHandlerClient;
import com.mjr.extraplanets.client.handlers.MainHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketElectricRocket;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT10New;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT4;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT5;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT6;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT7;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT8;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT9New;
import com.mjr.extraplanets.client.model.vehicles.ItemModelMarsRover;
import com.mjr.extraplanets.client.model.vehicles.ItemModelVenusRover;
import com.mjr.extraplanets.client.render.entities.RenderFireBombPrimed;
import com.mjr.extraplanets.client.render.entities.RenderNuclearBombPrimed;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedFireBatBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedGhastBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedSnowmanBoss;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossEris;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossJupiter;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossMercury;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossNeptune;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossPluto;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossSaturn;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossUranus;
import com.mjr.extraplanets.client.render.entities.landers.RenderJupiterLander;
import com.mjr.extraplanets.client.render.entities.landers.RenderMercuryLander;
import com.mjr.extraplanets.client.render.entities.landers.RenderNeptuneLander;
import com.mjr.extraplanets.client.render.entities.landers.RenderSaturnLander;
import com.mjr.extraplanets.client.render.entities.landers.RenderUranusLander;
import com.mjr.extraplanets.client.render.entities.projectiles.RenderSmallSnowBall;
import com.mjr.extraplanets.client.render.entities.rockets.RenderElectricRocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier10RocketNew;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier4Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier5Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier6Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier7Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier8Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier9RocketNew;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderMarsRover;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderVenusRover;
import com.mjr.extraplanets.client.render.tile.TileEntitySolarPanelRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT10TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT4TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT5TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT6TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT7TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT8TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT9TreasureChestRenderer;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedFireBatBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossMercury;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossUranus;
import com.mjr.extraplanets.entities.landers.EntityJupiterLander;
import com.mjr.extraplanets.entities.landers.EntityMercuryLander;
import com.mjr.extraplanets.entities.landers.EntityNeptuneLander;
import com.mjr.extraplanets.entities.landers.EntitySaturnLander;
import com.mjr.extraplanets.entities.landers.EntityUranusLander;
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.entities.rockets.EntityElectricRocket;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.ItemBasicKit;
import com.mjr.extraplanets.items.ItemCannedFood;
import com.mjr.extraplanets.items.ItemElectricParts;
import com.mjr.extraplanets.items.ItemTools;
import com.mjr.extraplanets.items.ItemWafers;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier10Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier11Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier4Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier5Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier6Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier7Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier8Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier9Items;
import com.mjr.extraplanets.items.schematics.SchematicTier10;
import com.mjr.extraplanets.items.schematics.SchematicTier4;
import com.mjr.extraplanets.items.schematics.SchematicTier5;
import com.mjr.extraplanets.items.schematics.SchematicTier6;
import com.mjr.extraplanets.items.schematics.SchematicTier7;
import com.mjr.extraplanets.items.schematics.SchematicTier8;
import com.mjr.extraplanets.items.schematics.SchematicTier9;
import com.mjr.extraplanets.items.thermalPadding.ItemThermalCloth;
import com.mjr.extraplanets.items.thermalPadding.ItemTier3ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier4ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier5ThermalPadding;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;
import com.mjr.extraplanets.tile.machines.TileEntitySolar;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT9TreasureChest;
import com.mjr.extraplanets.util.ClientUtilities;

public class ClientProxy extends CommonProxy {

	// Event Methods
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		OBJLoader.INSTANCE.addDomain(Constants.ASSET_PREFIX);
		MinecraftForge.EVENT_BUS.register(this);
		registerVariants();
		registerEntityRenders();
		registerCustomModel();
		registerFluidVariants();
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new SkyProviderHandler());
		MinecraftForge.EVENT_BUS.register(new KeyHandlerClient());
		ClientRegistry.registerKeyBinding(KeyHandlerClient.openFuelGui);
		renderBlocks();
		registerBlockJsons();
		registerItemJsons();
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MainHandlerClient());

		// Register Schematics Textures (For Handing Enities versions)
		registerSchematicsTextures();
		super.postInit(event);
	}

	private void registerVariants() {
		if (Config.MERCURY)
			ClientUtilities.addExtraPlanetsVariants("mercury", "mercury_surface", "mercury_sub_surface", "mercury_stone", "mercury_ore_iron", "mercury_ore_tin", "mercury_ore_copper", "mercury_ore_mercury", "mercury_mercury_block",
					"mercury_stonebricks", "mercury_dungeon_brick", "mercury_ore_carbon", "mercury_carbon_block");
		if (Config.CERES)
			ClientUtilities.addExtraPlanetsVariants("ceres", "ceres_surface", "ceres_sub_surface", "ceres_stone", "ceres_ore_iron", "ceres_ore_tin", "ceres_ore_copper", "ceres_ore_uranium", "ceres_uranium_block", "ceres_stonebricks");
		if (Config.JUPITER)
			ClientUtilities.addExtraPlanetsVariants("jupiter", "jupiter_surface", "jupiter_sub_surface", "jupiter_stone", "jupiter_ore_iron", "jupiter_ore_tin", "jupiter_ore_copper", "jupiter_ore_palladium", "jupiter_ore_nickel",
					"jupiter_palladium_block", "jupiter_stonebricks", "jupiter_dungeon_brick", "jupiter_ore_red_gem", "jupiter_red_gem_block");
		if (Config.URANUS)
			ClientUtilities.addExtraPlanetsVariants("uranus", "uranus_surface", "uranus_sub_surface", "uranus_stone", "uranus_ore_crystal", "uranus_crystal_block", "uranus_stonebricks", "uranus_dungeon_brick", "uranus_ore_white_gem",
					"uranus_white_gem_block");
		if (Config.NEPTUNE)
			ClientUtilities.addExtraPlanetsVariants("neptune", "neptune_surface", "neptune_sub_surface", "neptune_stone", "neptune_ore_iron", "neptune_ore_tin", "neptune_ore_copper", "neptune_ore_zinc", "neptune_zinc_block", "neptune_stonebricks",
					"neptune_dungeon_brick", "neptune_ore_blue_gem", "neptune_blue_gem_block");
		if (Config.SATURN)
			ClientUtilities.addExtraPlanetsVariants("saturn", "saturn_surface", "saturn_sub_surface", "saturn_stone", "saturn_ore_iron", "saturn_ore_tin", "saturn_ore_copper", "saturn_ore_magnesium", "saturn_magnesium_block", "saturn_stonebricks",
					"saturn_dungeon_brick");
		if (Config.PLUTO)
			ClientUtilities.addExtraPlanetsVariants("pluto", "pluto_surface", "pluto_sub_surface", "pluto_stone", "pluto_ore_iron", "pluto_ore_tin", "pluto_ore_copper", "pluto_ore_tungsten", "pluto_tungsten_block", "pluto_stonebricks",
					"pluto_dungeon_brick");
		if (Config.ERIS)
			ClientUtilities.addExtraPlanetsVariants("eris", "eris_surface", "eris_sub_surface", "eris_stone", "eris_ore_iron", "eris_ore_tin", "eris_ore_copper", "eris_ore_dark_iron", "eris_dark_iron_block", "eris_stonebricks", "eris_dungeon_brick");
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS)
			ClientUtilities.addExtraPlanetsVariants("kepler22b", "kepler22b_dirt", "kepler22b_stone", "kepler22b_ore_iron", "kepler22b_ore_tin", "kepler22b_ore_copper", "kepler22b_ore_dense_coal", "kepler22b_ore_blue_diamond",
					"kepler22b_ore_red_diamond", "kepler22b_ore_purple_diamond", "kepler22b_ore_yellow_diamond", "kepler22b_ore_green_diamond", "kepler22b_stonebricks", "kepler22b_cobblestone", "keler22b_ore_platinum");
		if (Config.CALLISTO)
			ClientUtilities.addExtraPlanetsVariants("callisto", "callisto_surface", "callisto_sub_surface", "callisto_stone", "callisto_ore_iron", "callisto_ore_tin", "callisto_ore_copper");
		if (Config.DEIMOS)
			ClientUtilities.addExtraPlanetsVariants("deimos", "deimos_surface", "deimos_sub_surface", "deimos_stone", "deimos_ore_iron", "deimos_ore_tin", "deimos_ore_copper");
		if (Config.EUROPA)
			ClientUtilities.addExtraPlanetsVariants("europa", "europa_surface", "europa_sub_surface", "europa_stone", "europa_ore_iron", "europa_ore_tin", "europa_ore_copper");
		if (Config.GANYMEDE)
			ClientUtilities.addExtraPlanetsVariants("ganymede", "ganymede_surface", "ganymede_sub_surface", "ganymede_stone", "ganymede_ore_iron", "ganymede_ore_tin", "ganymede_ore_copper");
		if (Config.IO)
			ClientUtilities.addExtraPlanetsVariants("io", "io_surface", "io_sub_surface", "io_stone", "io_ore_iron", "io_ore_tin", "io_ore_copper");
		if (Config.PHOBOS)
			ClientUtilities.addExtraPlanetsVariants("phobos", "phobos_surface", "phobos_sub_surface", "phobos_stone", "phobos_ore_iron", "phobos_ore_tin", "phobos_ore_copper");
		if (Config.RHEA)
			ClientUtilities.addExtraPlanetsVariants("rhea", "rhea_surface", "rhea_sub_surface", "rhea_stone", "rhea_ore_iron", "rhea_ore_tin", "rhea_ore_copper");
		if (Config.TITAN)
			ClientUtilities.addExtraPlanetsVariants("titan", "titan_surface", "titan_sub_surface", "titan_stone", "titan_ore_iron", "titan_ore_tin", "titan_ore_copper");
		if (Config.TRITON)
			ClientUtilities.addExtraPlanetsVariants("triton", "triton_surface", "triton_sub_surface", "triton_stone", "triton_ore_iron", "triton_ore_tin", "triton_ore_copper");
		if (Config.OBERON)
			ClientUtilities.addExtraPlanetsVariants("oberon", "oberon_surface", "oberon_sub_surface", "oberon_stone", "oberon_ore_iron", "oberon_ore_tin", "oberon_ore_copper");
		if (Config.TITANIA)
			ClientUtilities.addExtraPlanetsVariants("titania", "titania_surface", "titania_sub_surface", "titania_stone", "titania_ore_iron", "titania_ore_tin", "titania_ore_copper");
		if (Config.IAPETUS)
			ClientUtilities.addExtraPlanetsVariants("iapetus", "iapetus_surface", "iapetus_sub_surface", "iapetus_stone", "iapetus_ore_iron", "iapetus_ore_tin", "iapetus_ore_copper", "iapetus_ice");
		if (Config.MERCURY)
			ClientUtilities.addExtraPlanetsVariants("tier4_items", "tier4engine", "tier4booster", "tier4fin", "tier4heavy_duty_plate", "compressed_carbon", "ingot_carbon");
		if (Config.JUPITER)
			ClientUtilities.addExtraPlanetsVariants("tier5_items", "tier5engine", "tier5booster", "tier5fin", "tier5heavy_duty_plate", "compressed_palladium", "ingot_palladium", "compressed_nickel", "ingot_nickel", "red_gem", "ash", "ash_shard",
					"volcanic_shard", "ingot_volcanic");
		if (Config.SATURN)
			ClientUtilities.addExtraPlanetsVariants("tier6_items", "tier6engine", "tier6booster", "tier6fin", "tier6heavy_duty_plate", "compressed_magnesium", "ingot_magnesium");
		if (Config.URANUS)
			ClientUtilities.addExtraPlanetsVariants("tier7_items", "tier7engine", "tier7booster", "tier7fin", "tier7heavy_duty_plate", "compressed_crystal", "ingot_crystal", "compressed_reinforced_crystal", "white_gem");
		if (Config.NEPTUNE)
			ClientUtilities.addExtraPlanetsVariants("tier8_items", "tier8engine", "tier8booster", "tier8fin", "tier8heavy_duty_plate", "compressed_zinc", "ingot_zinc", "blue_gem");
		if (Config.PLUTO)
			ClientUtilities.addExtraPlanetsVariants("tier9_items", "tier9engine", "tier9booster", "tier9fin", "tier9heavy_duty_plate", "compressed_tungsten", "ingot_tungsten");
		if (Config.ERIS)
			ClientUtilities.addExtraPlanetsVariants("tier10_items", "tier10engine", "tier10booster", "tier10fin", "tier10heavy_duty_plate", "compressed_dark_iron", "ingot_dark_iron");
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			ClientUtilities.addExtraPlanetsVariants("tier11_items", "blue_diamond", "red_diamond", "purple_diamond", "yellow_diamond", "green_diamond", "ingot_platinum", "compressed_platinum", "blue_sticks", "red_sticks", "purple_sticks",
					"yellow_sticks", "green_sticks", "brown_sticks");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_planks", "maple_blue_plank", "maple_red_plank", "maple_purple_plank", "maple_yellow_plank", "maple_green_plank", "maple_brown_plank");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_logs", "maple_blue_log", "maple_red_log", "maple_purple_log", "maple_yellow_log");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_logs2", "maple_green_log", "maple_brown_log");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_new_maple_leaves", "maple_blue_leaf", "maple_red_leaf", "maple_purple_leaf", "maple_yellow_leaf");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_new_maple_leaves_2", "maple_green_leaf", "maple_brown_leaf");

			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_saplings", "maple_blue_sapling", "maple_red_sapling", "maple_purple_sapling", "maple_yellow_sapling", "maple_green_sapling", "maple_brown_sapling");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_flowers", "maple_blue_short", "maple_blue_med", "maple_blue_tall", "maple_red_short", "maple_red_med", "maple_red_tall", "maple_purple_short", "maple_purple_med", "maple_purple_tall",
					"maple_yellow_short", "maple_yellow_med", "maple_yellow_tall", "maple_green_short", "maple_green_med", "maple_green_tall");
		}
		ClientUtilities.addExtraPlanetsVariants("wafer", "diamond_wafer", "carbon_wafer", "titanium_wafer", "red_gem_wafer", "blue_gem_wafer", "white_gem_wafer");
		ClientUtilities.addExtraPlanetsVariants("tools", "sledge_hammer", "grinding_wheel");
		if (Config.CANNED_FOOD)
			ClientUtilities.addExtraPlanetsVariants("canned_food", "dehydrated_porkchop", "dehydrated_fish", "dehydrated_salmon", "dehydrated_chicken", "dehydrated_beef");
		if (Config.THERMAL_PADDINGS) {
			ClientUtilities.addExtraPlanetsVariants("thermal_cloth", "tier3_thermal_cloth", "tier4_thermal_cloth", "tier5_thermal_cloth");
			ClientUtilities.addExtraPlanetsVariants("tier3_thermal_padding", "tier3_thermal_helm", "tier3_thermal_chestplate", "tier3_thermal_leggings", "tier3_thermal_boots");
			ClientUtilities.addExtraPlanetsVariants("tier4_thermal_padding", "tier4_thermal_helm", "tier4_thermal_chestplate", "tier4_thermal_leggings", "tier4_thermal_boots");
			ClientUtilities.addExtraPlanetsVariants("tier5_thermal_padding", "tier5_thermal_helm", "tier5_thermal_chestplate", "tier5_thermal_leggings", "tier5_thermal_boots");
		}
		if (Config.SOLAR_PANELS)
			ClientUtilities.addExtraPlanetsVariants("solar", "ultimate_solar", "hybrid_solar");
		ClientUtilities.addExtraPlanetsVariants("advanced_launch_pad", "tier_2_rocket", "tier_3_rocket", "powered_charging_pad", "rocket_powered_charging_pad");
		ClientUtilities.addExtraPlanetsVariants("advanced_launch_pad_full", "tier_2_rocket", "tier_3_rocket", "powered_charging_pad", "rocket_powered_charging_pad");
		if (Config.OXYGEN_COMPRESSOR_ADVANCED)
			ClientUtilities.addExtraPlanetsVariants("advanced_oxygen_compressor", "advanced_oxygen_compressor", "advanced_oxygen_decompressor");
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE)
			ClientUtilities.addExtraPlanetsVariants("ultimate_oxygen_compressor", "ultimate_oxygen_compressor", "ultimate_oxygen_decompressor");
		ClientUtilities.addExtraPlanetsVariants("decorative_blocks", "marble", "marble_bricks", "snow_bricks", "ice_bricks", "fire_bricks", "black_white_floor", "marble_titled_floor", "marble_broken_titled_floor", "metal_mesh",
				"frozen_nitrogen_bricks", "volcanic_rock_bricks", "carbon_titled_floor", "carbon_broken_titled_floor", "magnesium_titled_floor", "magnesium_broken_titled_floor", "ash_bricks");
		ClientUtilities.addExtraPlanetsVariants("decorative_blocks2", "white_block", "red_block");
		if (Config.MARS_ROVER || Config.VENUS_ROVER)
			ClientUtilities.addExtraPlanetsVariants("electric_parts", "battery_tier1", "battery_tier2", "electric_wheels_tier1", "electric_wheels_tier2");
		ClientUtilities.addExtraPlanetsVariants("tier1_kit", "tier1_kitfull", "tier1_kitbasic_setup", "tier1_kitwithout_oxygen_setup", "tier1_kitwithout_thermal_padding", "tier1_kitjust_oxygen_setup", "tier1_kitjust_protection");
		ClientUtilities.addExtraPlanetsVariants("tier2_kit", "tier2_kitfull", "tier2_kitbasic_setup", "tier2_kitwithout_oxygen_setup", "tier2_kitwithout_thermal_padding", "tier2_kitjust_oxygen_setup", "tier2_kitjust_protection");
		ClientUtilities.addExtraPlanetsVariants("tier3_kit", "tier3_kitfull", "tier3_kitbasic_setup", "tier3_kitwithout_oxygen_setup", "tier3_kitwithout_thermal_padding", "tier3_kitjust_oxygen_setup", "tier3_kitjust_protection");
		ClientUtilities.addExtraPlanetsVariants("tier4_kit", "tier4_kitfull", "tier4_kitbasic_setup", "tier4_kitwithout_oxygen_setup", "tier4_kitwithout_thermal_padding", "tier4_kitjust_oxygen_setup", "tier4_kitjust_protection");
		ClientUtilities.addExtraPlanetsVariants("tier5_kit", "tier5_kitfull", "tier5_kitbasic_setup", "tier5_kitwithout_oxygen_setup", "tier5_kitwithout_thermal_padding", "tier5_kitjust_oxygen_setup", "tier5_kitjust_protection");

	}

	private void registerEntityRenders() {
		if (Config.MERCURY) {
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossMercury.class, (RenderManager manager) -> new RenderCreeperBossMercury(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, (RenderManager manager) -> new RenderEvolvedMagmaCubeBoss(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityMercuryLander.class, (RenderManager manager) -> new RenderMercuryLander(manager));
		}
		if (Config.JUPITER) {
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, (RenderManager manager) -> new RenderCreeperBossJupiter(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedFireBatBoss.class, (RenderManager manager) -> new RenderEvolvedFireBatBoss(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityJupiterLander.class, (RenderManager manager) -> new RenderJupiterLander(manager));
		}
		if (Config.SATURN) {
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, (RenderManager manager) -> new RenderCreeperBossSaturn(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGhastBoss.class, (RenderManager manager) -> new RenderEvolvedGhastBoss(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntitySaturnLander.class, (RenderManager manager) -> new RenderSaturnLander(manager));
		}
		if (Config.URANUS) {
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, (RenderManager manager) -> new RenderCreeperBossUranus(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, (RenderManager manager) -> new RenderEvolvedIceSlimeBoss(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityUranusLander.class, (RenderManager manager) -> new RenderUranusLander(manager));
		}
		if (Config.NEPTUNE) {
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, (RenderManager manager) -> new RenderCreeperBossNeptune(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSnowmanBoss.class, (RenderManager manager) -> new RenderEvolvedSnowmanBoss(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityNeptuneLander.class, (RenderManager manager) -> new RenderNeptuneLander(manager));
		}
		if (Config.PLUTO)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, (RenderManager manager) -> new RenderCreeperBossPluto(manager));
		if (Config.ERIS)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossEris.class, (RenderManager manager) -> new RenderCreeperBossEris(manager));
		if (Config.MERCURY)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, (RenderManager manager) -> new RenderTier4Rocket(manager));
		if (Config.JUPITER)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, (RenderManager manager) -> new RenderTier5Rocket(manager));
		if (Config.SATURN)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, (RenderManager manager) -> new RenderTier6Rocket(manager));
		if (Config.URANUS)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, (RenderManager manager) -> new RenderTier7Rocket(manager));
		if (Config.NEPTUNE)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, (RenderManager manager) -> new RenderTier8Rocket(manager));
		if (Config.PLUTO)
			// RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9Rocket(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9RocketNew(manager));
		if (Config.ERIS)
			// RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10Rocket(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10RocketNew(manager));
		if (Config.ERIS && Config.KEPLER22B)
			RenderingRegistry.registerEntityRenderingHandler(EntityElectricRocket.class, (RenderManager manager) -> new RenderElectricRocket(manager));
		if (Config.CERES && Config.NUCLEAR_BOMB)
			RenderingRegistry.registerEntityRenderingHandler(EntityNuclearBombPrimed.class, (RenderManager manager) -> new RenderNuclearBombPrimed(manager));
		if (Config.CERES && Config.FIRE_BOMB)
			RenderingRegistry.registerEntityRenderingHandler(EntityFireBombPrimed.class, (RenderManager manager) -> new RenderFireBombPrimed(manager));
		if (Config.MARS_ROVER)
			RenderingRegistry.registerEntityRenderingHandler(EntityMarsRover.class, (RenderManager manager) -> new RenderMarsRover(manager));
		if (Config.VENUS_ROVER)
			RenderingRegistry.registerEntityRenderingHandler(EntityVenusRover.class, (RenderManager manager) -> new RenderVenusRover(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallSnowball.class, (RenderManager manager) -> new RenderSmallSnowBall(manager, new ItemStack(Items.SNOWBALL)));
	}

	public void registerCustomModel() {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t4", "inventory");
		if (Config.MERCURY) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_4_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.JUPITER) {
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t5", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_5_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.SATURN) {
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t6", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_6_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.URANUS) {
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t7", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_7_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.NEPTUNE) {
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t8", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_8_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.PLUTO) {
			// modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t9", "inventory");
			// for (int i = 0; i < 5; ++i) {
			// ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_9_ROCKET, i, modelResourceLocation);
			// }
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t9_new", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_9_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.ERIS) {
			// modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t10", "inventory");
			// for (int i = 0; i < 5; ++i) {
			// ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_10_ROCKET, i, modelResourceLocation);
			// }
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t10_new", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_10_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.ERIS && Config.KEPLER22B) {
			modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "electric_rocket", "inventory");
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.MARS_ROVER) {
			for (int i = 0; i < 4; ++i) {
				modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "mars_rover" + (i > 0 ? "_" + i : ""), "inventory");
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.MARS_ROVER, i, modelResourceLocation);
			}
		}
		if (Config.VENUS_ROVER) {
			for (int i = 0; i < 4; ++i) {
				modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "venus_rover" + (i > 0 ? "_" + i : ""), "inventory");
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.VENUS_ROVER, i, modelResourceLocation);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static void renderBlocks() {
		if (Config.MERCURY)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT4TreasureChest.class, new TileEntityT4TreasureChestRenderer());
		if (Config.JUPITER)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT5TreasureChest.class, new TileEntityT5TreasureChestRenderer());
		if (Config.SATURN)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT6TreasureChest.class, new TileEntityT6TreasureChestRenderer());
		if (Config.URANUS)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT7TreasureChest.class, new TileEntityT7TreasureChestRenderer());
		if (Config.NEPTUNE)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT8TreasureChest.class, new TileEntityT8TreasureChestRenderer());
		if (Config.PLUTO)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT9TreasureChest.class, new TileEntityT9TreasureChestRenderer());
		if (Config.ERIS)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT10TreasureChest.class, new TileEntityT10TreasureChestRenderer());
		if (Config.SOLAR_PANELS)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolar.class, new TileEntitySolarPanelRenderer());
	}

	private void registerBlockJsons() {
		// Planets
		if (Config.MERCURY) {
			for (BlockBasicMercury.EnumBlockBasic blockBasic : BlockBasicMercury.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.MERCURY_GRAVEL);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_4);
		}
		if (Config.CERES) {
			for (BlockBasicCeres.EnumBlockBasic blockBasic : BlockBasicCeres.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.CERES_GRAVEL);
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

		}
		if (Config.SATURN) {
			for (BlockBasicSaturn.EnumBlockBasic blockBasic : BlockBasicSaturn.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_6);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_GRAVEL);
			if (Config.FIRE_BOMB)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FIRE_BOMB);
		}
		if (Config.URANUS) {
			for (BlockBasicUranus.EnumBlockBasic blockBasic : BlockBasicUranus.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.URANUS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_7);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.DENSE_ICE);
		}
		if (Config.NEPTUNE) {
			for (BlockBasicNeptune.EnumBlockBasic blockBasic : BlockBasicNeptune.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_8);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FROZEN_NITROGEN);
		}
		if (Config.PLUTO) {
			for (BlockBasicPluto.EnumBlockBasic blockBasic : BlockBasicPluto.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_9);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.PLUTO_GRAVEL);
		}
		if (Config.ERIS) {
			for (BlockBasicEris.EnumBlockBasic blockBasic : BlockBasicEris.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_10);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ERIS_GRAVEL);
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_BLUE);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_RED);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_PURPLE);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_YELLOW);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_GREEN);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_GRASS_INFECTED);

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
		}
		if (Config.FUEL_LOADER_ADVANCED)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.FUEL_LOADER_ADVANCED);
		if (Config.FUEL_LOADER_ULTIMATE)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE);

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

		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.VEHICLE_CHARGER);
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FAKE_BLOCK);
	}

	private void registerItemJsons() {
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
			for (int i = 0; i < ItemTier4Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_ITEMS, i, ItemTier4Items.names[i]);
			}
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
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_SALT);
		}
		if (Config.JUPITER) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_SCHEMATIC);
			if (Config.BATTERIES)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_NICKEL);
			for (int i = 0; i < ItemTier5Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_ITEMS, i, ItemTier5Items.names[i]);
			}
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
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_MAGMA);
		}
		if (Config.SATURN) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_SCHEMATIC);
			for (int i = 0; i < ItemTier6Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_6_ITEMS, i, ItemTier6Items.names[i]);
			}
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
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_GLOWSTONE);
		}
		if (Config.URANUS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_SCHEMATIC);
			for (int i = 0; i < ItemTier7Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_7_ITEMS, i, ItemTier7Items.names[i]);
			}
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
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_FROZEN_WATER);
		}
		if (Config.NEPTUNE) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_SCHEMATIC);
			if (Config.BATTERIES)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BATTERY_ZINC);
			for (int i = 0; i < ItemTier8Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_8_ITEMS, i, ItemTier8Items.names[i]);
			}
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
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_NITROGEN);
		}
		if (Config.PLUTO) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_KEY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_NOSE_CONE);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_SCHEMATIC);
			for (int i = 0; i < ItemTier9Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_9_ITEMS, i, ItemTier9Items.names[i]);
			}
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
			for (int i = 0; i < ItemTier10Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_10_ITEMS, i, ItemTier10Items.names[i]);
			}
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			for (int i = 0; i < ItemTier11Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_11_ITEMS, i, ItemTier11Items.names[i]);
			}
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
		if (Config.ERIS && Config.KEPLER22B)
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
		}
		if (Config.THERMAL_PADDINGS) {
			for (int i = 0; i < ItemTier3ThermalPadding.names.length / 2; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_THERMAL_PADDING, i, ItemTier3ThermalPadding.names[i]);
			}
			for (int i = 0; i < ItemTier4ThermalPadding.names.length / 2; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_THERMAL_PADDING, i, ItemTier4ThermalPadding.names[i]);
			}
			for (int i = 0; i < ItemTier5ThermalPadding.names.length / 2; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_THERMAL_PADDING, i, ItemTier5ThermalPadding.names[i]);
			}
			for (int i = 0; i < ItemThermalCloth.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.THERMAL_CLOTH, i, ItemThermalCloth.names[i]);
			}
		}
		if (Config.OXYGEN_TANKS) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY);
		}
		if (Config.PRESSURE || Config.RADIATION) {
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
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_2_SPACE_SUIT_GRAVITY_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_HELMET);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.TIER_4_SPACE_SUIT_CHEST);
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
		}
		for (int i = 0; i < ItemWafers.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.WAFERS, i, ItemWafers.names[i]);
		}
		for (int i = 0; i < ItemTools.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TOOLS, i, ItemTools.names[i]);
		}
		if (Config.CANNED_FOOD) {
			for (int i = 0; i < ItemCannedFood.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CANNED_FOOD, i, ItemCannedFood.names[i]);
			}
		}
		for (int i = 0; i < ItemBasicKit.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, i, "tier1_kit" + ItemBasicKit.names[i]);
		}
		for (int i = 0; i < ItemBasicKit.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, i, "tier2_kit" + ItemBasicKit.names[i]);
		}
		for (int i = 0; i < ItemBasicKit.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, i, "tier3_kit" + ItemBasicKit.names[i]);
		}
		for (int i = 0; i < ItemBasicKit.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, i, "tier4_kit" + ItemBasicKit.names[i]);
		}
		for (int i = 0; i < ItemBasicKit.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, i, "tier5_kit" + ItemBasicKit.names[i]);
		}
		if (Config.MARS_ROVER || Config.VENUS_ROVER) {
			for (int i = 0; i < ItemElectricParts.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ELECTRIC_PARTS, i, ItemElectricParts.names[i]);
			}
		}
		if (Config.MARS_ROVER)
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.MARS_ROVER_SCHEMATIC);
		if (Config.VENUS_ROVER)
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.VENUS_ROVER_SCHEMATIC);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.INGOT_LEAD);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CLOTH);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.GRAVITY_CONTROLLER);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_CLEAN_WATER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_INFECTED_WATER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_RADIOACTIVE_WATER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_METHANE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_NITROGEN_ICE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_LIQUID_HYDROCARBON);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBakeEvent(ModelBakeEvent event) {
		if (Config.MERCURY)
			ClientUtilities.replaceModelDefault(event, "rocket_t4", "rocket_t4.obj", ImmutableList.of("Nozzle", "Body_Rocket", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4", "Tip", "Ring", "FrameWindow1", "FrameWindow2",
					"FrameWindow3", "FrameWindow4", "GlassWindow", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4"), ItemModelRocketT4.class, TRSRTransformation.identity());
		if (Config.JUPITER)
			ClientUtilities.replaceModelDefault(event, "rocket_t5", "rocket_t5.obj", ImmutableList.of("Nozzle", "Body_Rocket", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4", "Tip", "Ring", "FrameWindow1",
					"FrameWindow2", "FrameWindow3", "FrameWindow4", "GlassWindow", "CorrectedWind005", "CorrectedWind006", "CorrectedWind007", "CorrectedWind008", "Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004", "Cylinder005",
					"Cylinder006", "Helix001", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4"), ItemModelRocketT5.class, TRSRTransformation.identity());
		if (Config.SATURN)
			ClientUtilities.replaceModelDefault(event, "rocket_t6", "rocket_t6.obj", ImmutableList.of("Nozzle", "Body_Rocket", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4", "Rocket_stabilizer1", "Rocket_stabilizer2",
					"Rocket_stabilizer3", "Rocket_stabilizer4", "Tip", "Ring", "FrameWindow1", "FrameWindow2", "FrameWindow3", "FrameWindow4", "GlassWindow", "CorrectedWind005", "CorrectedWind006", "CorrectedWind007", "CorrectedWind008",
					"Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004", "Cylinder005", "Cylinder006", "Helix001", "SplinePathDeform", "Pipe004", "Pipe005", "Pipe006", "Pipe007", "RocketEngine", "RocketEngine001", "RocketEngine002",
					"RocketEngine003", "RocketEnginePlut", "RocketEnginePlut001", "RocketEnginePlut002", "RocketEnginePlut003"), ItemModelRocketT6.class, TRSRTransformation.identity());
		if (Config.URANUS)
			ClientUtilities.replaceModelDefault(event, "rocket_t7", "rocket_t7.obj", ImmutableList.of("Nozzle", "Body_Rocket", "CorrectedWind1", "CorrectedWind2", "CorrectedWind3", "CorrectedWind4", "Rocket_stabilizer1", "Rocket_stabilizer2",
					"Rocket_stabilizer3", "Rocket_stabilizer4", "Tip", "Ring", "FrameWindow1", "FrameWindow2", "FrameWindow3", "FrameWindow4", "GlassWindow", "CorrectedWind005", "CorrectedWind006", "CorrectedWind007", "CorrectedWind008",
					"Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004", "Cylinder005", "Cylinder006", "Helix001", "SplinePathDeform", "Pipe004", "Pipe005", "Pipe006", "Pipe007", "RocketEngine", "RocketEngine001", "RocketEngine002",
					"RocketEngine003", "RocketEngineBottom", "RocketEngineBottom001", "RocketEngineBottom002", "RocketEngineBottom003", "PathDeform2", "Wire1", "Wire2", "WireLight", "RocketEnginePlut", "RocketEnginePlut001", "RocketEnginePlut002",
					"RocketEnginePlut003"), ItemModelRocketT7.class, TRSRTransformation.identity());
		if (Config.NEPTUNE)
			ClientUtilities.replaceModelDefault(event, "rocket_t8", "rocket_t8.obj", ImmutableList.of("Nozzle", "BodyRocket", "Rocket_stabilizer1", "Rocket_stabilizer2", "Rocket_stabilizer3", "Rocket_stabilizer4", "Rocket_stabilizer007",
					"Rocket_stabilizer008", "Rocket_stabilizer009", "Rocket_stabilizer010", "SplinePathDeform", "RocketEngine", "RocketEngine001", "RocketEngine002", "RocketEngine003", "RocketEngine004", "RocketEngine005", "RocketEngine006",
					"RocketEngine007", "RocketEngineBottom", "RocketEngineBottom001", "RocketEngineBottom002", "RocketEngineBottom003", "RocketEngineBottom004", "RocketEngineBottom005", "RocketEngineBottom006", "RocketEngineBottom007",
					"FloorCockPit", "NoseRocket", "NozzleKeeper", "rotary_engine", "rotary_engine2", "rotary_engine3", "rotary_engine4", "RocketEnginePlut", "RocketEnginePlut001", "RocketEnginePlut002", "RocketEnginePlut003", "RocketEnginePlut004",
					"RocketEnginePlut005", "RocketEnginePlut006", "RocketEnginePlut007"), ItemModelRocketT8.class, TRSRTransformation.identity());
		if (Config.PLUTO)
			// ClientUtilities.replaceModelDefault(event, "rocket_t9", "rocket_t9.obj", ImmutableList.of("Nozzle", "Nozzle001", "Nozzle002", "NozzleKeeper", "NozzleKeeper001", "BodyRocket", "BodyRocket001", "Rocket_stabilizer1", "Rocket_stabilizer2",
			// "Rocket_stabilizer3", "Rocket_stabilizer4", "Rocket_stabilizer007", "Rocket_stabilizer008", "Rocket_stabilizer009", "Rocket_stabilizer010", "Rocket_stabilizer011", "Rocket_stabilizer012", "SplinePathDeform", "RocketEngine",
			// "RocketEngine002", "RocketEngine004", "RocketEngine005", "RocketEngine007", "RocketEngine008", "RocketEngineBottom", "RocketEngineBottom003", "RocketEngineBottom004", "RocketEngineBottom005", "RocketEngineBottom006",
			// "RocketEngineBottom007", "RocketEngineBottom008", "FloorCockPit", "Cockoit", "NoseRocket", "rotary_engine", "rotary_engine2", "rotary_engine3", "rotary_engine4", "rotary_engine005", "rotary_engine006", "RocketEnginePlut",
			// "RocketEnginePlut002", "RocketEnginePlut004", "RocketEnginePlut005", "RocketEnginePlut007", "RocketEnginePlut008"), ItemModelRocketT9.class, TRSRTransformation.identity());
			ClientUtilities.replaceModelDefault(event, "rocket_t9_new", "rocket_t9_new.obj",
					ImmutableList.of("BodyRocket", "Connector", "LampOnSpike", "MainNozzle", "NoseRocket", "NoseRocketMiddle", "SideEngine1", "SideEngine2", "SideEngine3", "SideEngine4", "Spike"), ItemModelRocketT9New.class,
					TRSRTransformation.identity());
		if (Config.ERIS)
			// ClientUtilities.replaceModelDefault(event, "rocket_t10", "rocket_t10.obj", ImmutableList.of("RocketCockpit", "RoofCockpit", "NoseRocket", "Nozzle001", "NozzleKeeper001", "NozzleKeeper002", "RocketEngine004", "RocketEngine005",
			// "RocketEngine006", "RocketEngine007", "RocketEngineBottom004", "RocketEngineBottom005", "RocketEngineBottom006", "RocketEngineBottom007", "FloorCockPit", "RocketEnginePlut004", "RocketEnginePlut005", "RocketEnginePlut006",
			// "RocketEnginePlut007"), ItemModelRocketT10.class, TRSRTransformation.identity());
			ClientUtilities.replaceModelDefault(event, "rocket_t10_new", "rocket_t10_new.obj", ImmutableList.of("BigSideWing1", "BigSideWing2", "BodyRocket", "Connector", "LampOnSpike", "MainNozzle", "NoseRocket", "NoseRocketMiddle", "SideEngine1",
					"SideEngine2", "SideEngine3", "SideEngine3", "SideEngine4", "SideWing1", "SideWing2", "SideWing3", "SideWing4", "Spike"), ItemModelRocketT10New.class, TRSRTransformation.identity());
		if (Config.ERIS && Config.KEPLER22B)
			ClientUtilities.replaceModelDefault(event, "electric_rocket", "electric_rocket.obj", ImmutableList.of("Cylinder001", "Cylinder002", "Cylinder003", "Cylinder004", "Cylinder005", "Cylinder006", "Cylinder007", "Cylinder008", "Cylinder009",
					"Cylinder010", "Cylinder011", "Cylinder012", "Cylinder013", "Cylinder014", "Cylinder015", "Cylinder016", "Cylinder017", "Cylinder018", "Cylinder019", "Cylinder020", "Cylinder021", "Line001", "Line002", "Torus001", "Torus002",
					"Torus003", "Torus004", "Torus005", "Torus006", "Torus007", "Torus008", "Tube001"), ItemModelRocketElectricRocket.class, TRSRTransformation.identity());

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
				ClientUtilities.replaceModelDefault(event, "mars_rover" + (i > 0 ? "_" + i : ""), "mars_rover.obj", objects, ItemModelMarsRover.class, TRSRTransformation.identity());
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
				ClientUtilities.replaceModelDefault(event, "venus_rover" + (i > 0 ? "_" + i : ""), "venus_rover.obj", objects, ItemModelVenusRover.class, TRSRTransformation.identity());
			}
		}
	}

	private void registerFluidVariants() {
		ModelResourceLocation nitrogenLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen", "fluid");
		Item nitrogen = Item.getItemFromBlock(ExtraPlanets_Fluids.NITROGEN);
		ModelBakery.registerItemVariants(nitrogen, new ResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen"));
		ModelLoader.setCustomMeshDefinition(nitrogen, IItemMeshDefinitionCustom.create((ItemStack stack) -> nitrogenLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.NITROGEN, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return nitrogenLocation;
			}
		});

		ModelResourceLocation glowstoneLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "glowstone", "fluid");
		Item glowstone = Item.getItemFromBlock(ExtraPlanets_Fluids.GLOWSTONE);
		ModelBakery.registerItemVariants(glowstone, new ResourceLocation(Constants.TEXTURE_PREFIX + "glowstone"));
		ModelLoader.setCustomMeshDefinition(glowstone, IItemMeshDefinitionCustom.create((ItemStack stack) -> glowstoneLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.GLOWSTONE, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return glowstoneLocation;
			}
		});

		ModelResourceLocation magmaLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "magma", "fluid");
		Item magma = Item.getItemFromBlock(ExtraPlanets_Fluids.MAGMA);
		ModelBakery.registerItemVariants(magma, new ResourceLocation(Constants.TEXTURE_PREFIX + "magma"));
		ModelLoader.setCustomMeshDefinition(magma, IItemMeshDefinitionCustom.create((ItemStack stack) -> magmaLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.MAGMA, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return magmaLocation;
			}
		});

		ModelResourceLocation frozen_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "frozen_water", "fluid");
		Item frozen_water = Item.getItemFromBlock(ExtraPlanets_Fluids.FROZEN_WATER);
		ModelBakery.registerItemVariants(frozen_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "frozen_water"));
		ModelLoader.setCustomMeshDefinition(frozen_water, IItemMeshDefinitionCustom.create((ItemStack stack) -> frozen_waterLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.FROZEN_WATER, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return frozen_waterLocation;
			}
		});

		ModelResourceLocation saltLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "salt", "fluid");
		Item salt = Item.getItemFromBlock(ExtraPlanets_Fluids.SALT);
		ModelBakery.registerItemVariants(salt, new ResourceLocation(Constants.TEXTURE_PREFIX + "salt"));
		ModelLoader.setCustomMeshDefinition(salt, IItemMeshDefinitionCustom.create((ItemStack stack) -> saltLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.SALT, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return saltLocation;
			}
		});

		ModelResourceLocation radioactive_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "radioactive_water", "fluid");
		Item radioactive_water = Item.getItemFromBlock(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER);
		ModelBakery.registerItemVariants(radioactive_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "radioactive_water"));
		ModelLoader.setCustomMeshDefinition(radioactive_water, IItemMeshDefinitionCustom.create((ItemStack stack) -> radioactive_waterLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return radioactive_waterLocation;
			}
		});

		ModelResourceLocation clean_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "clean_water", "fluid");
		Item clean_water = Item.getItemFromBlock(ExtraPlanets_Fluids.CLEAN_WATER);
		ModelBakery.registerItemVariants(clean_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "clean_water"));
		ModelLoader.setCustomMeshDefinition(clean_water, IItemMeshDefinitionCustom.create((ItemStack stack) -> clean_waterLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.CLEAN_WATER, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return clean_waterLocation;
			}
		});

		ModelResourceLocation infected_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "infected_water", "fluid");
		Item infected_water = Item.getItemFromBlock(ExtraPlanets_Fluids.INFECTED_WATER);
		ModelBakery.registerItemVariants(infected_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "infected_water"));
		ModelLoader.setCustomMeshDefinition(infected_water, IItemMeshDefinitionCustom.create((ItemStack stack) -> infected_waterLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.INFECTED_WATER, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return infected_waterLocation;
			}
		});

		ModelResourceLocation methaneLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "methane", "fluid");
		Item methane = Item.getItemFromBlock(ExtraPlanets_Fluids.METHANE);
		ModelBakery.registerItemVariants(methane, new ResourceLocation(Constants.TEXTURE_PREFIX + "methane"));
		ModelLoader.setCustomMeshDefinition(methane, IItemMeshDefinitionCustom.create((ItemStack stack) -> methaneLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.METHANE, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return methaneLocation;
			}
		});

		ModelResourceLocation nitrogen_iceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen_ice", "fluid");
		Item nitrogen_ice = Item.getItemFromBlock(ExtraPlanets_Fluids.NITROGEN_ICE);
		ModelBakery.registerItemVariants(nitrogen_ice, new ResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen_ice"));
		ModelLoader.setCustomMeshDefinition(nitrogen_ice, IItemMeshDefinitionCustom.create((ItemStack stack) -> nitrogen_iceLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.NITROGEN_ICE, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return nitrogen_iceLocation;
			}
		});

		ModelResourceLocation liquid_hydrocarbonLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "liquid_hydrocarbon", "fluid");
		Item liquid_hydrocarbon = Item.getItemFromBlock(ExtraPlanets_Fluids.LIQUID_HYDROCARBON);
		ModelBakery.registerItemVariants(liquid_hydrocarbon, new ResourceLocation(Constants.TEXTURE_PREFIX + "liquid_hydrocarbon"));
		ModelLoader.setCustomMeshDefinition(liquid_hydrocarbon, IItemMeshDefinitionCustom.create((ItemStack stack) -> liquid_hydrocarbonLocation));
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.LIQUID_HYDROCARBON, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return liquid_hydrocarbonLocation;
			}
		});
	}

	private void registerSchematicsTextures() {
		SchematicTier4.registerTextures();
		SchematicTier5.registerTextures();
		SchematicTier6.registerTextures();
		SchematicTier7.registerTextures();
		SchematicTier8.registerTextures();
		SchematicTier9.registerTextures();
		SchematicTier10.registerTextures();
	}
}
