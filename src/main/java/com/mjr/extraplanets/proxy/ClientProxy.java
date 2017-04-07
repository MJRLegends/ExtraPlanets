package com.mjr.extraplanets.proxy;

import micdoodle8.mods.galacticraft.planets.asteroids.client.render.item.ItemModelRocketT3;
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
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog2;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeSapling;
import com.mjr.extraplanets.client.handlers.MainHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.client.render.entities.RenderNuclearBombPrimed;
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
import com.mjr.extraplanets.client.render.entities.projectiles.RenderSmallSnowBall;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier10Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier4Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier5Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier6Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier7Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier8Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier9Rocket;
import com.mjr.extraplanets.client.render.tile.TileEntitySolarPanelRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT10TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT4TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT5TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT6TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT7TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT8TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT9TreasureChestRenderer;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
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
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.ItemCannedFood;
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
		registerVariants();
		registerEntityRenders();
		registerCustomModel();
		registerFluidVariants();
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new SkyProviderHandler());
		renderBlocks();
		registerBlockJsons();
		registerItemJsons();
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MainHandlerClient());
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
					"kepler22b_ore_red_diamond", "kepler22b_ore_purple_diamond", "kepler22b_ore_yellow_diamond", "kepler22b_ore_green_diamond", "kepler22b_stonebricks", "kepler22b_cobblestone");
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
			ClientUtilities.addExtraPlanetsVariants("tier5_items", "tier5engine", "tier5booster", "tier5fin", "tier5heavy_duty_plate", "compressed_palladium", "ingot_palladium", "compressed_nickel", "ingot_nickel", "red_gem");
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
			ClientUtilities.addExtraPlanetsVariants("tier11_items", "blue_diamond", "red_diamond", "purple_diamond", "yellow_diamond", "green_diamond");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_planks", "maple_blue_plank", "maple_red_plank", "maple_purple_plank", "maple_yellow_plank", "maple_green_plank", "maple_brown_plank");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_logs", "maple_blue_log", "maple_red_log", "maple_purple_log", "maple_yellow_log");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_logs2", "maple_green_log", "maple_brown_log");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_leaves", "maple_blue_leaf", "maple_red_leaf", "maple_purple_leaf", "maple_yellow_leaf", "maple_green_leaf", "maple_brown_leaf");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_maple_saplings", "maple_blue_sapling", "maple_red_sapling", "maple_purple_sapling", "maple_yellow_sapling", "maple_green_sapling", "maple_brown_sapling");
			ClientUtilities.addExtraPlanetsVariants("kepler22b_flowers", "maple_blue_short", "maple_blue_med", "maple_blue_tall", "maple_red_short", "maple_red_med", "maple_red_tall", "maple_purple_short", "maple_purple_med", "maple_purple_tall",
					"maple_yellow_short", "maple_yellow_med", "maple_yellow_tall", "maple_green_short", "maple_green_med", "maple_green_tall");
		}

		ClientUtilities.addExtraPlanetsVariants("wafer", "diamond_wafer", "carbon_wafer", "titanium_wafer", "red_gem_wafer", "blue_gem_wafer", "white_gem_wafer");
		ClientUtilities.addExtraPlanetsVariants("canned_food", "dehydrated_porkchop", "dehydrated_fish", "dehydrated_salmon", "dehydrated_chicken", "dehydrated_beef");

		if (Config.THERMAL_PADDINGS) {
			ClientUtilities.addExtraPlanetsVariants("thermal_cloth", "tier3_thermal_cloth", "tier4_thermal_cloth", "tier5_thermal_cloth");
			ClientUtilities.addExtraPlanetsVariants("tier3_thermal_padding", "tier3_thermal_helm", "tier3_thermal_chestplate", "tier3_thermal_leggings", "tier3_thermal_boots");
			ClientUtilities.addExtraPlanetsVariants("tier4_thermal_padding", "tier4_thermal_helm", "tier4_thermal_chestplate", "tier4_thermal_leggings", "tier4_thermal_boots");
			ClientUtilities.addExtraPlanetsVariants("tier5_thermal_padding", "tier5_thermal_helm", "tier5_thermal_chestplate", "tier5_thermal_leggings", "tier5_thermal_boots");
		}
		if (Config.SOLAR_PANELS)
			ClientUtilities.addExtraPlanetsVariants("solar", "ultimate_solar", "hybrid_solar");
	}

	private void registerEntityRenders() {
		if (Config.MERCURY)
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossMercury.class, (RenderManager manager) -> new RenderCreeperBossMercury(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, (RenderManager manager) -> new RenderEvolvedMagmaCubeBoss(manager));
		if (Config.JUPITER)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, (RenderManager manager) -> new RenderCreeperBossJupiter(manager));
		if (Config.SATURN)
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, (RenderManager manager) -> new RenderCreeperBossSaturn(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGhastBoss.class, (RenderManager manager) -> new RenderEvolvedGhastBoss(manager));
		if (Config.URANUS)
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, (RenderManager manager) -> new RenderCreeperBossUranus(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, (RenderManager manager) -> new RenderEvolvedIceSlimeBoss(manager));
		if (Config.NEPTUNE)
			if (Config.USE_DEFAULT_BOSSES)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, (RenderManager manager) -> new RenderCreeperBossNeptune(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSnowmanBoss.class, (RenderManager manager) -> new RenderEvolvedSnowmanBoss(manager));

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
			RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9Rocket(manager));
		if (Config.ERIS)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10Rocket(manager));
		if (Config.NUCLEAR_BOMB)
			RenderingRegistry.registerEntityRenderingHandler(EntityNuclearBombPrimed.class, (RenderManager manager) -> new RenderNuclearBombPrimed(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallSnowball.class, (RenderManager manager) -> new RenderSmallSnowBall(manager, new ItemStack(Items.SNOWBALL)));
	}

	public void registerCustomModel() {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("galacticraftplanets:rocket_t3", "inventory");
		if (Config.MERCURY) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_4_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.JUPITER) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_5_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.SATURN) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_6_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.URANUS) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_7_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.NEPTUNE) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_8_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.PLUTO) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_9_ROCKET, i, modelResourceLocation);
			}
		}
		if (Config.ERIS) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.TIER_10_ROCKET, i, modelResourceLocation);
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
		}
		if (Config.SATURN) {
			for (BlockBasicSaturn.EnumBlockBasic blockBasic : BlockBasicSaturn.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_BLOCKS, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_6);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.SATURN_GRAVEL);
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
			for (BlockKepler22bMapleTreeSapling.EnumType blockBasic : BlockKepler22bMapleTreeSapling.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, blockBasic.getMetadata(), blockBasic.getName());
			}
			for (BlockBasicKepler22bTallGrass.EnumType blockBasic : BlockBasicKepler22bTallGrass.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, blockBasic.getMeta(), blockBasic.getName());
			}
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
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.REFINERY_ADVANCED, 0, "refinery");
		if (Config.REFINERY_ULTIMATE)
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.REFINERY_ULTIMATE, 0, "refinery");
		if (Config.SOLAR_PANELS) {
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.SOLAR_PANEL, 0, "advanced_solar");
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.SOLAR_PANEL, 4, "advanced_solar");
		}
		if (Config.OXYGEN_COMPRESSOR_ADVANCED) {
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 0, "oxygen_compressor");
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 4, "oxygen_decompressor");
		}
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE) {
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 0, "oxygen_compressor");
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 4, "oxygen_decompressor");
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
		// Other Blocks
		if (Config.MERCURY || Config.CERES || Config.PLUTO || Config.ERIS)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.FOSSIL);
		if (Config.RADIATION)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ORE_POTASH);
		if(Config.ORE_LEAD_GENERATION)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ORE_LEAD);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercurySword);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonSword);
			}
		}
		if (Config.CERES) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.INGOT_URANIUM);
			if (Config.ITEMS_URANIUM) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.URANIUM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumSword);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumSword);
			}
			if (Config.ITEMS_GEM_RED) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.RED_GEM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemSword);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumSword);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalSword);
			}
			if (Config.ITEMS_GEM_WHITE) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.WHITE_GEM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemSword);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincSword);
			}
			if (Config.ITEMS_GEM_BLUE) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_BOOTS);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_CHEST);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_HELMET);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.BLUE_GEM_LEGINGS);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemSword);
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

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenSword);
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

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueDiamondAxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueDiamondHoe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueDiamondPickaxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueDiamondShovel);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueDiamondSword);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redDiamondAxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redDiamondHoe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redDiamondPickaxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redDiamondShovel);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redDiamondSword);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.purpleDiamondAxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.purpleDiamondHoe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.purpleDiamondPickaxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.purpleDiamondShovel);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.purpleDiamondSword);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.yellowDiamondAxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.yellowDiamondHoe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.yellowDiamondPickaxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.yellowDiamondShovel);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.yellowDiamondSword);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.greenDiamondAxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.greenDiamondHoe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.greenDiamondPickaxe);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.greenDiamondShovel);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.greenDiamondSword);
		}
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
		for (int i = 0; i < ItemCannedFood.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CANNED_FOOD, i, ItemCannedFood.names[i]);
		}
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.INGOT_LEAD);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.CLOTH);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.GRAVITY_CONTROLLER);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_CLEAN_WATER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_INFECTED_WATER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_RADIOACTIVE_WATER);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_METHANE);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.BUCKET_NITROGEN_ICE);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBakeEvent(ModelBakeEvent event) {
		if (Config.MERCURY)
			ClientUtilities.replaceModelDefault(event, "rocket_t4", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.JUPITER)
			ClientUtilities.replaceModelDefault(event, "rocket_t5", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.SATURN)
			ClientUtilities.replaceModelDefault(event, "rocket_t6", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.URANUS)
			ClientUtilities.replaceModelDefault(event, "rocket_t7", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.NEPTUNE)
			ClientUtilities.replaceModelDefault(event, "rocket_t8", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.PLUTO)
			ClientUtilities.replaceModelDefault(event, "rocket_t9", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.ERIS)
			ClientUtilities.replaceModelDefault(event, "rocket_t10", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
	}

	private void registerFluidVariants() {
		ModelResourceLocation nitrogenLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen", "fluid");
		Item nitrogen = Item.getItemFromBlock(ExtraPlanets_Fluids.nitrogen);
		ModelBakery.registerItemVariants(nitrogen, new ResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen"));
		ModelLoader.setCustomMeshDefinition(nitrogen, (ItemStack stack) -> nitrogenLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.nitrogen, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return nitrogenLocation;
			}
		});

		ModelResourceLocation glowstoneLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "glowstone", "fluid");
		Item glowstone = Item.getItemFromBlock(ExtraPlanets_Fluids.glowstone);
		ModelBakery.registerItemVariants(glowstone, new ResourceLocation(Constants.TEXTURE_PREFIX + "glowstone"));
		ModelLoader.setCustomMeshDefinition(glowstone, (ItemStack stack) -> glowstoneLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.glowstone, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return glowstoneLocation;
			}
		});

		ModelResourceLocation magmaLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "magma", "fluid");
		Item magma = Item.getItemFromBlock(ExtraPlanets_Fluids.magma);
		ModelBakery.registerItemVariants(magma, new ResourceLocation(Constants.TEXTURE_PREFIX + "magma"));
		ModelLoader.setCustomMeshDefinition(magma, (ItemStack stack) -> magmaLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.magma, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return magmaLocation;
			}
		});

		ModelResourceLocation frozen_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "frozen_water", "fluid");
		Item frozen_water = Item.getItemFromBlock(ExtraPlanets_Fluids.frozen_water);
		ModelBakery.registerItemVariants(frozen_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "frozen_water"));
		ModelLoader.setCustomMeshDefinition(frozen_water, (ItemStack stack) -> frozen_waterLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.frozen_water, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return frozen_waterLocation;
			}
		});

		ModelResourceLocation saltLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "salt", "fluid");
		Item salt = Item.getItemFromBlock(ExtraPlanets_Fluids.salt);
		ModelBakery.registerItemVariants(salt, new ResourceLocation(Constants.TEXTURE_PREFIX + "salt"));
		ModelLoader.setCustomMeshDefinition(salt, (ItemStack stack) -> saltLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.salt, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return saltLocation;
			}
		});

		ModelResourceLocation radioactive_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "radioactive_water", "fluid");
		Item radioactive_water = Item.getItemFromBlock(ExtraPlanets_Fluids.radioactiveWater);
		ModelBakery.registerItemVariants(radioactive_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "radioactive_water"));
		ModelLoader.setCustomMeshDefinition(radioactive_water, (ItemStack stack) -> radioactive_waterLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.radioactiveWater, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return radioactive_waterLocation;
			}
		});

		ModelResourceLocation clean_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "clean_water", "fluid");
		Item clean_water = Item.getItemFromBlock(ExtraPlanets_Fluids.cleanWater);
		ModelBakery.registerItemVariants(clean_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "clean_water"));
		ModelLoader.setCustomMeshDefinition(clean_water, (ItemStack stack) -> clean_waterLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.cleanWater, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return clean_waterLocation;
			}
		});

		ModelResourceLocation infected_waterLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "infected_water", "fluid");
		Item infected_water = Item.getItemFromBlock(ExtraPlanets_Fluids.infectedWater);
		ModelBakery.registerItemVariants(infected_water, new ResourceLocation(Constants.TEXTURE_PREFIX + "infected_water"));
		ModelLoader.setCustomMeshDefinition(infected_water, (ItemStack stack) -> infected_waterLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.infectedWater, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return infected_waterLocation;
			}
		});

		ModelResourceLocation methaneLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "methane", "fluid");
		Item methane = Item.getItemFromBlock(ExtraPlanets_Fluids.methane);
		ModelBakery.registerItemVariants(methane, new ResourceLocation(Constants.TEXTURE_PREFIX + "methane"));
		ModelLoader.setCustomMeshDefinition(methane, (ItemStack stack) -> methaneLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.methane, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return methaneLocation;
			}
		});

		ModelResourceLocation nitrogen_iceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen_ice", "fluid");
		Item nitrogen_ice = Item.getItemFromBlock(ExtraPlanets_Fluids.nitrogen_ice);
		ModelBakery.registerItemVariants(nitrogen_ice, new ResourceLocation(Constants.TEXTURE_PREFIX + "nitrogen_ice"));
		ModelLoader.setCustomMeshDefinition(nitrogen_ice, (ItemStack stack) -> nitrogen_iceLocation);
		ModelLoader.setCustomStateMapper(ExtraPlanets_Fluids.nitrogen_ice, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return nitrogen_iceLocation;
			}
		});
	}
}
