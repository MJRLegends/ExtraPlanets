package com.mjr.extraplanets.proxy;

import micdoodle8.mods.galacticraft.planets.asteroids.client.render.item.ItemModelRocketT3;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.common.MinecraftForge;
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
import com.mjr.extraplanets.armor.ExtraPlanets_Armor;
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
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog2;
import com.mjr.extraplanets.client.handlers.MainHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
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
import com.mjr.extraplanets.items.ItemTier10Items;
import com.mjr.extraplanets.items.ItemTier11Items;
import com.mjr.extraplanets.items.ItemTier4Items;
import com.mjr.extraplanets.items.ItemTier5Items;
import com.mjr.extraplanets.items.ItemTier6Items;
import com.mjr.extraplanets.items.ItemTier7Items;
import com.mjr.extraplanets.items.ItemTier8Items;
import com.mjr.extraplanets.items.ItemTier9Items;
import com.mjr.extraplanets.items.ItemWafers;
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
		if (Config.mercury)
			ClientUtilities.addExtraPlanetsVariants("mercury", "mercury_surface", "mercury_sub_surface", "mercury_stone", "mercury_ore_iron", "mercury_ore_tin", "mercury_ore_copper", "mercury_ore_mercury", "mercury_mercury_block",
					"mercury_stonebricks", "mercury_dungeon_brick", "mercury_ore_carbon", "mercury_carbon_block");
		// if (Config.venus)
		// ClientUtilities.addExtraPlanetsVariants("venus", "venus_surface", "venus_sub_surface", "venus_stone", "venus_ore_iron", "venus_ore_tin", "venus_ore_copper", "venus_ore_carbon", "venus_carbon_block", "venus_stonebricks",
		// "venus_dungeon_brick");
		if (Config.ceres)
			ClientUtilities.addExtraPlanetsVariants("ceres", "ceres_surface", "ceres_sub_surface", "ceres_stone", "ceres_ore_iron", "ceres_ore_tin", "ceres_ore_copper", "ceres_ore_uranium", "ceres_uranium_block", "ceres_stonebricks");
		if (Config.jupiter)
			ClientUtilities.addExtraPlanetsVariants("jupiter", "jupiter_surface", "jupiter_sub_surface", "jupiter_stone", "jupiter_ore_iron", "jupiter_ore_tin", "jupiter_ore_copper", "jupiter_ore_palladium", "jupiter_palladium_block",
					"jupiter_stonebricks", "jupiter_dungeon_brick", "jupiter_ore_red_gem", "jupiter_red_gem_block");
		if (Config.uranus)
			ClientUtilities.addExtraPlanetsVariants("uranus", "uranus_surface", "uranus_sub_surface", "uranus_stone", "uranus_ore_crystal", "uranus_crystal_block", "uranus_stonebricks", "uranus_dungeon_brick", "uranus_ore_white_gem",
					"uranus_white_gem_block");
		if (Config.neptune)
			ClientUtilities.addExtraPlanetsVariants("neptune", "neptune_surface", "neptune_sub_surface", "neptune_stone", "neptune_ore_iron", "neptune_ore_tin", "neptune_ore_copper", "neptune_ore_zinc", "neptune_zinc_block", "neptune_stonebricks",
					"neptune_dungeon_brick", "neptune_ore_blue_gem", "neptune_blue_gem_block");
		if (Config.saturn)
			ClientUtilities.addExtraPlanetsVariants("saturn", "saturn_surface", "saturn_sub_surface", "saturn_stone", "saturn_ore_iron", "saturn_ore_tin", "saturn_ore_copper", "saturn_ore_magnesium", "saturn_magnesium_block", "saturn_stonebricks",
					"saturn_dungeon_brick");
		if (Config.pluto)
			ClientUtilities.addExtraPlanetsVariants("pluto", "pluto_surface", "pluto_sub_surface", "pluto_stone", "pluto_ore_iron", "pluto_ore_tin", "pluto_ore_copper", "pluto_ore_tungsten", "pluto_tungsten_block", "pluto_stonebricks",
					"pluto_dungeon_brick");
		if (Config.eris)
			ClientUtilities.addExtraPlanetsVariants("eris", "eris_surface", "eris_sub_surface", "eris_stone", "eris_ore_iron", "eris_ore_tin", "eris_ore_copper", "eris_ore_dark_iron", "eris_dark_iron_block", "eris_stonebricks", "eris_dungeon_brick");
		if (Config.kepler22b && Config.keplerSolarSystems)
			ClientUtilities.addExtraPlanetsVariants("kepler22b", "kepler22b_dirt", "kepler22b_stone", "kepler22b_ore_iron", "kepler22b_ore_tin", "kepler22b_ore_copper", "kepler22b_ore_dense_coal", "kepler22b_ore_blue_diamond",
					"kepler22b_ore_red_diamond", "kepler22b_ore_purple_diamond", "kepler22b_ore_yellow_diamond", "kepler22b_ore_green_diamond", "kepler22b_stonebricks", "kepler22b_cobblestone");
		if (Config.callisto)
			ClientUtilities.addExtraPlanetsVariants("callisto", "callisto_surface", "callisto_sub_surface", "callisto_stone", "callisto_ore_iron", "callisto_ore_tin", "callisto_ore_copper");
		if (Config.deimos)
			ClientUtilities.addExtraPlanetsVariants("deimos", "deimos_surface", "deimos_sub_surface", "deimos_stone", "deimos_ore_iron", "deimos_ore_tin", "deimos_ore_copper");
		if (Config.europa)
			ClientUtilities.addExtraPlanetsVariants("europa", "europa_surface", "europa_sub_surface", "europa_stone", "europa_ore_iron", "europa_ore_tin", "europa_ore_copper");
		if (Config.ganymede)
			ClientUtilities.addExtraPlanetsVariants("ganymede", "ganymede_surface", "ganymede_sub_surface", "ganymede_stone", "ganymede_ore_iron", "ganymede_ore_tin", "ganymede_ore_copper");
		if (Config.io)
			ClientUtilities.addExtraPlanetsVariants("io", "io_surface", "io_sub_surface", "io_stone", "io_ore_iron", "io_ore_tin", "io_ore_copper");
		if (Config.phobos)
			ClientUtilities.addExtraPlanetsVariants("phobos", "phobos_surface", "phobos_sub_surface", "phobos_stone", "phobos_ore_iron", "phobos_ore_tin", "phobos_ore_copper");
		if (Config.rhea)
			ClientUtilities.addExtraPlanetsVariants("rhea", "rhea_surface", "rhea_sub_surface", "rhea_stone", "rhea_ore_iron", "rhea_ore_tin", "rhea_ore_copper");
		if (Config.titan)
			ClientUtilities.addExtraPlanetsVariants("titan", "titan_surface", "titan_sub_surface", "titan_stone", "titan_ore_iron", "titan_ore_tin", "titan_ore_copper");
		if (Config.triton)
			ClientUtilities.addExtraPlanetsVariants("triton", "triton_surface", "triton_sub_surface", "triton_stone", "triton_ore_iron", "triton_ore_tin", "triton_ore_copper");
		if (Config.oberon)
			ClientUtilities.addExtraPlanetsVariants("oberon", "oberon_surface", "oberon_sub_surface", "oberon_stone", "oberon_ore_iron", "oberon_ore_tin", "oberon_ore_copper");
		if (Config.titania)
			ClientUtilities.addExtraPlanetsVariants("titania", "titania_surface", "titania_sub_surface", "titania_stone", "titania_ore_iron", "titania_ore_tin", "titania_ore_copper");
		if (Config.iapetus)
			ClientUtilities.addExtraPlanetsVariants("iapetus", "iapetus_surface", "iapetus_sub_surface", "iapetus_stone", "iapetus_ore_iron", "iapetus_ore_tin", "iapetus_ore_copper");
		if (Config.mercury)
			ClientUtilities.addExtraPlanetsVariants("tier4Items", "tier4engine", "tier4booster", "tier4Fin", "tier4HeavyDutyPlate", "compressedCarbon", "ingotCarbon");
		if (Config.jupiter)
			ClientUtilities.addExtraPlanetsVariants("tier5Items", "tier5engine", "tier5booster", "tier5Fin", "tier5HeavyDutyPlate", "compressedPalladium", "ingotPalladium", "compressedNickel", "ingotNickel", "redGem");
		if (Config.saturn)
			ClientUtilities.addExtraPlanetsVariants("tier6Items", "tier6engine", "tier6booster", "tier6Fin", "tier6HeavyDutyPlate", "compressedMagnesium", "ingotMagnesium");
		if (Config.uranus)
			ClientUtilities.addExtraPlanetsVariants("tier7Items", "tier7engine", "tier7booster", "tier7Fin", "tier7HeavyDutyPlate", "compressedCrystal", "ingotCrystal", "compressedReinforcedCrystal", "whiteGem");
		if (Config.neptune)
			ClientUtilities.addExtraPlanetsVariants("tier8Items", "tier8engine", "tier8booster", "tier8Fin", "tier8HeavyDutyPlate", "compressedZinc", "ingotZinc", "blueGem");
		if (Config.pluto)
			ClientUtilities.addExtraPlanetsVariants("tier9Items", "tier9engine", "tier9booster", "tier9Fin", "tier9HeavyDutyPlate", "compressedTungsten", "ingotTungsten");
		if (Config.eris)
			ClientUtilities.addExtraPlanetsVariants("tier10Items", "tier10engine", "tier10booster", "tier10Fin", "tier10HeavyDutyPlate", "compressedDarkIron", "ingotDarkIron");
		if (Config.kepler22b && Config.keplerSolarSystems) {
			ClientUtilities.addExtraPlanetsVariants("tier11Items", "blueDiamond", "redDiamond", "purpleDiamond", "yellowDiamond", "greenDiamond");
			ClientUtilities.addExtraPlanetsVariants("kepler22bPlanks", "maple_blue_plank", "maple_red_plank", "maple_purple_plank", "maple_yellow_plank", "maple_green_plank", "maple_brown_plank");
			ClientUtilities.addExtraPlanetsVariants("kepler22bMapleLogs", "maple_blue_log", "maple_red_log", "maple_purple_log", "maple_yellow_log");
			ClientUtilities.addExtraPlanetsVariants("kepler22bMapleLogs2", "maple_green_log", "maple_brown_log");
			ClientUtilities.addExtraPlanetsVariants("kepler22bMapleLeaves", "maple_blue_leaf", "maple_red_leaf", "maple_purple_leaf", "maple_yellow_leaf", "maple_green_leaf", "maple_brown_leaf");
		}

		ClientUtilities.addExtraPlanetsVariants("wafer", "diamondWafer", "carbonWafer", "titaniumWafer", "redGemWafer", "blueGemWafer", "whiteGemWafer");
		
		if(Config.thermalPaddings){
			ClientUtilities.addExtraPlanetsVariants("tier3ThermalPadding", "tier3ThermalHelm", "tier3ThermalChestplate", "tier3ThermalLeggings", "tier3ThermalBoots");
			ClientUtilities.addExtraPlanetsVariants("tier4ThermalPadding", "tier4ThermalHelm", "tier4ThermalChestplate", "tier4ThermalLeggings", "tier4ThermalBoots");
			ClientUtilities.addExtraPlanetsVariants("tier5ThermalPadding", "tier5ThermalHelm", "tier5ThermalChestplate", "tier5ThermalLeggings", "tier5ThermalBoots");
		}
		if (Config.solarPanels)
			ClientUtilities.addExtraPlanetsVariants("solar", "ultimate_solar", "hybrid_solar");
	}

	private void registerEntityRenders() {
		if (Config.mercury)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossMercury.class, (RenderManager manager) -> new RenderCreeperBossMercury(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, (RenderManager manager) -> new RenderEvolvedMagmaCubeBoss(manager));
		if (Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, (RenderManager manager) -> new RenderCreeperBossJupiter(manager));
		if (Config.saturn)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, (RenderManager manager) -> new RenderCreeperBossSaturn(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGhastBoss.class, (RenderManager manager) -> new RenderEvolvedGhastBoss(manager));
		if (Config.uranus)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, (RenderManager manager) -> new RenderCreeperBossUranus(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, (RenderManager manager) -> new RenderEvolvedIceSlimeBoss(manager));
		if (Config.neptune)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, (RenderManager manager) -> new RenderCreeperBossNeptune(manager));
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSnowmanBoss.class, (RenderManager manager) -> new RenderEvolvedSnowmanBoss(manager));

		if (Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, (RenderManager manager) -> new RenderCreeperBossPluto(manager));
		if (Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossEris.class, (RenderManager manager) -> new RenderCreeperBossEris(manager));

		if (Config.mercury)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, (RenderManager manager) -> new RenderTier4Rocket(manager));
		if (Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, (RenderManager manager) -> new RenderTier5Rocket(manager));
		if (Config.saturn)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, (RenderManager manager) -> new RenderTier6Rocket(manager));
		if (Config.uranus)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, (RenderManager manager) -> new RenderTier7Rocket(manager));
		if (Config.neptune)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, (RenderManager manager) -> new RenderTier8Rocket(manager));
		if (Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9Rocket(manager));
		if (Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10Rocket(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallSnowball.class, (RenderManager manager) -> new RenderSnowball(manager,Items.snowball,Minecraft.getMinecraft().getRenderItem()));
	}

	public void registerCustomModel() {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("galacticraftplanets:rocket_t3", "inventory");
		if (Config.mercury) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier4Rocket, i, modelResourceLocation);
			}
		}
		if (Config.jupiter) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier5Rocket, i, modelResourceLocation);
			}
		}
		if (Config.saturn) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier6Rocket, i, modelResourceLocation);
			}
		}
		if (Config.uranus) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier7Rocket, i, modelResourceLocation);
			}
		}
		if (Config.neptune) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier8Rocket, i, modelResourceLocation);
			}
		}
		if (Config.pluto) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier9Rocket, i, modelResourceLocation);
			}
		}
		if (Config.eris) {
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier10Rocket, i, modelResourceLocation);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static void renderBlocks() {
		if (Config.mercury)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT4TreasureChest.class, new TileEntityT4TreasureChestRenderer());
		if (Config.jupiter)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT5TreasureChest.class, new TileEntityT5TreasureChestRenderer());
		if (Config.saturn)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT6TreasureChest.class, new TileEntityT6TreasureChestRenderer());
		if (Config.uranus)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT7TreasureChest.class, new TileEntityT7TreasureChestRenderer());
		if (Config.neptune)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT8TreasureChest.class, new TileEntityT8TreasureChestRenderer());
		if (Config.pluto)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT9TreasureChest.class, new TileEntityT9TreasureChestRenderer());
		if (Config.eris)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT10TreasureChest.class, new TileEntityT10TreasureChestRenderer());
		if (Config.solarPanels)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolar.class, new TileEntitySolarPanelRenderer());
	}

	private void registerBlockJsons() {
		// Planets
		if (Config.mercury) {
			for (BlockBasicMercury.EnumBlockBasic blockBasic : BlockBasicMercury.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.mercuryBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.mercuryGravel);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier4);
		}
		// if (Config.venus) {
		// for (BlockBasicVenus.EnumBlockBasic blockBasic : BlockBasicVenus.EnumBlockBasic.values()) {
		// ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.venusBlocks, blockBasic.getMeta(), blockBasic.getName());
		// }
		// ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.venusGravel);
		// ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.volcanicRock);
		// }
		if (Config.ceres) {
			for (BlockBasicCeres.EnumBlockBasic blockBasic : BlockBasicCeres.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ceresBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ceresGravel);
			if (Config.nuclearBomb)
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.nuclearBomb);
		}
		if (Config.jupiter) {
			for (BlockBasicJupiter.EnumBlockBasic blockBasic : BlockBasicJupiter.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.jupiterBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier5);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.jupiterGravel);
		}
		if (Config.saturn) {
			for (BlockBasicSaturn.EnumBlockBasic blockBasic : BlockBasicSaturn.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.saturnBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier6);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.saturnGravel);
		}
		if (Config.uranus) {
			for (BlockBasicUranus.EnumBlockBasic blockBasic : BlockBasicUranus.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.uranusBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier7);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.denseIce);
		}
		if (Config.neptune) {
			for (BlockBasicNeptune.EnumBlockBasic blockBasic : BlockBasicNeptune.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.neptuneBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier8);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.frozenNitrogen);
		}
		if (Config.pluto) {
			for (BlockBasicPluto.EnumBlockBasic blockBasic : BlockBasicPluto.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.plutoBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier9);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.plutoGravel);
		}
		if (Config.eris) {
			for (BlockBasicEris.EnumBlockBasic blockBasic : BlockBasicEris.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.erisBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier10);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.erisGravel);
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			for (BlockBasicKepler22b.EnumBlockBasic blockBasic : BlockBasicKepler22b.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}

		// Moons
		if (Config.callisto) {
			for (BlockBasicCallisto.EnumBlockBasic blockBasic : BlockBasicCallisto.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.callistoBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.callistoGravel);
		}
		if (Config.deimos) {
			for (BlockBasicDeimos.EnumBlockBasic blockBasic : BlockBasicDeimos.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.deimosBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.deimosGravel);
		}
		if (Config.europa) {
			for (BlockBasicEuropa.EnumBlockBasic blockBasic : BlockBasicEuropa.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.europaBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.europaGravel);
		}
		if (Config.ganymede) {
			for (BlockBasicGanymede.EnumBlockBasic blockBasic : BlockBasicGanymede.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ganymedeBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ganymedeGravel);
		}
		if (Config.io) {
			for (BlockBasicIo.EnumBlockBasic blockBasic : BlockBasicIo.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ioBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ioGravel);
		}
		if (Config.phobos) {
			for (BlockBasicPhobos.EnumBlockBasic blockBasic : BlockBasicPhobos.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.phobosBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.phobosGravel);
		}
		if (Config.rhea) {
			for (BlockBasicRhea.EnumBlockBasic blockBasic : BlockBasicRhea.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.rheaBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.rheaGravel);
		}
		if (Config.titan) {
			for (BlockBasicTitan.EnumBlockBasic blockBasic : BlockBasicTitan.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.titanBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.titanGravel);
		}
		if (Config.triton) {
			for (BlockBasicTriton.EnumBlockBasic blockBasic : BlockBasicTriton.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.tritonBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.tritonGravel);
		}
		if (Config.oberon) {
			for (BlockBasicOberon.EnumBlockBasic blockBasic : BlockBasicOberon.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.oberonBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.oberonGravel);
		}
		if (Config.titania) {
			for (BlockBasicTitania.EnumBlockBasic blockBasic : BlockBasicTitania.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.titaniaBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.titaniaGravel);
		}
		if (Config.iapetus) {
			for (BlockBasicIapetus.EnumBlockBasic blockBasic : BlockBasicIapetus.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.iapetusBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.iapetusGravel);
		}
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.fossil);
		if (Config.advancedRefinery)
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.advancedRefinery, 0, "refinery");
		if (Config.ultimateRefinery)
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.ultimateRefinery, 0, "refinery");
		if (Config.solarPanels) {
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.solarPanel, 0, "advanced_solar");
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.solarPanel, 4, "advanced_solar");
		}
		if (Config.advancedCompressor) {
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.advancedOxygenCompressor, 0, "oxygen_compressor");
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.advancedOxygenCompressor, 4, "oxygen_decompressor");
		}
		if (Config.ultimateCompressor) {
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.ultimateOxygenCompressor, 0, "oxygen_compressor");
			ClientUtilities.registerBlockJson(micdoodle8.mods.galacticraft.core.Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.ultimateOxygenCompressor, 4, "oxygen_decompressor");
		}
		ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.oreLead);

		if (Config.kepler22b && Config.keplerSolarSystems) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bBlueGrass);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bRedGrass);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bPurpleGrass);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bYellowGrass);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bGrass);

			for (BlockBasicKepler22bPlanks.EnumType blockBasic : BlockBasicKepler22bPlanks.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bPlanks, blockBasic.getMetadata(), blockBasic.getName());
			}

			for (BlockKepler22bMapleTreeLog.EnumType blockBasic : BlockKepler22bMapleTreeLog.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bMapleLog, blockBasic.getMetadata(), blockBasic.getName());
			}

			for (BlockKepler22bMapleTreeLog2.EnumType blockBasic : BlockKepler22bMapleTreeLog2.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bMapleLog2, blockBasic.getMetadata(), blockBasic.getName());
			}
			for (BlockKepler22bMapleTreeLeaves.EnumType blockBasic : BlockKepler22bMapleTreeLeaves.EnumType.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.kepler22bMapleLeaf, blockBasic.getMetadata(), blockBasic.getName());
			}
		}
	}

	private void registerItemJsons() {
		if (Config.mercury) {
			if(Config.batteries)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.mercuryBattery);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.compressedMercury);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ingotMercury);
			if (Config.mercuryItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.mercuryBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.mercuryChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.mercuryHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.mercuryLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercuryShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.mercurySword);
			}

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T4key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier4);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier4);
			for (int i = 0; i < ItemTier4Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4Items, i, ItemTier4Items.names[i]);
			}
			if (Config.carbonItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.carbonBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.carbonChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.carbonHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.carbonLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.carbonSword);
			}
		}
		if (Config.ceres) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ingotUranium);
			if (Config.uraniumItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.uraniumBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.uraniumChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.uraniumHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.uraniumLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.uraniumSword);
			}
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.salt_bucket);
		}
		if (Config.jupiter) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T5key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier5);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier5);
			if(Config.batteries)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.nickelBattery);
			for (int i = 0; i < ItemTier5Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier5Items, i, ItemTier5Items.names[i]);
			}
			if (Config.palladiumItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.palladiumBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.palladiumChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.palladiumHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.palladiumLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.palladiumSword);
			}
			if (Config.redGemItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redGemBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redGemChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redGemHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redGemLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.redGemSword);
			}
		}
		if (Config.saturn) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T6key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier6);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier6);
			for (int i = 0; i < ItemTier6Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier6Items, i, ItemTier6Items.names[i]);
			}
			if (Config.magnesiumItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.magnesiumBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.magnesiumChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.magnesiumHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.magnesiumLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.magnesiumSword);
			}
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.glowstone_bucket);
		}
		if (Config.uranus) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T7key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier7);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier7);
			for (int i = 0; i < ItemTier7Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier7Items, i, ItemTier7Items.names[i]);
			}
			if (Config.crystalItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.crystalBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.crystalChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.crystalHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.crystalLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.crystalSword);
			}
			if (Config.whiteGemItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.whiteGemBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.whiteGemChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.whiteGemHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.whiteGemLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.whiteGemSword);
			}
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.frozen_water_bucket);
		}
		if (Config.neptune) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T8key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier8);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier8);
			if(Config.batteries)
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.zincBattery);
			for (int i = 0; i < ItemTier8Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier8Items, i, ItemTier8Items.names[i]);
			}
			if (Config.zincItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.zincBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.zincChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.zincHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.zincLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.zincSword);
			}
			if (Config.blueGemItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueGemBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueGemChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueGemHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueGemLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.blueGemSword);
			}
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.nitrogen_bucket);
		}
		if (Config.pluto) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T9key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier9);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier9);
			for (int i = 0; i < ItemTier9Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier9Items, i, ItemTier9Items.names[i]);
			}
			if (Config.tungstenItems) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tungstenBoots);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tungstenChest);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tungstenHelmet);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tungstenLegings);

				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenAxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenHoe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenPickaxe);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenShovel);
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Tools.tungstenSword);
			}
		}
		if (Config.eris) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T10key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier10);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier10);
			for (int i = 0; i < ItemTier10Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier10Items, i, ItemTier10Items.names[i]);
			}
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			for (int i = 0; i < ItemTier11Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier11Items, i, ItemTier11Items.names[i]);
			}
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondLegings);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondLegings);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondLegings);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondLegings);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondLegings);

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
		if(Config.customApples){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.diamondApple);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ironApple);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.diamondApple, 1);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ironApple, 1);
		}
		if(Config.batteries){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.advancedBattery);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ultimateBattery);
		}
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ingotLead);
		for (int i = 0; i < ItemWafers.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.wafers, i, ItemWafers.names[i]);
		}
		if(Config.thermalPaddings){
			for (int i = 0; i < ItemTier3ThermalPadding.names.length / 2; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3ThermalPadding, i, ItemTier3ThermalPadding.names[i]);
			}
			for (int i = 0; i < ItemTier4ThermalPadding.names.length / 2; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4ThermalPadding, i, ItemTier4ThermalPadding.names[i]);
			}
			for (int i = 0; i < ItemTier5ThermalPadding.names.length / 2; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier5ThermalPadding, i, ItemTier5ThermalPadding.names[i]);
			}
		}
		
		if(Config.oxygenTanks){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.oxygenTankExtremelyHeavy);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.oxygenTankVeryHeavy);
		}
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.magma_bucket);

		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.cloth);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.gravityController);

		if (Config.pressure || Config.radiation) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1ArmorLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1PressureLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1RadiationLayer);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2ArmorLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2PressureLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2RadiationLayer);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3ArmorLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3PressureLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3RadiationLayer);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4ArmorLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4PressureLayer);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4RadiationLayer);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1UnPreparedSpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1UnPreparedSpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1UnPreparedSpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier1UnPreparedSpaceSuitBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2UnPreparedSpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2UnPreparedSpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2UnPreparedSpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2UnPreparedSpaceSuitBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3UnPreparedSpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3UnPreparedSpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3UnPreparedSpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3UnPreparedSpaceSuitBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4UnPreparedSpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4UnPreparedSpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4UnPreparedSpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4UnPreparedSpaceSuitBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier1SpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier1SpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier1SpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier1SpaceSuitBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier1SpaceSuitGravityBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier2SpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier2SpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier2SpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier2SpaceSuitBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier2SpaceSuitGravityBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier3SpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier3SpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier3SpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier3SpaceSuitBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier3SpaceSuitGravityBoots);

			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier4SpaceSuitHelmet);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier4SpaceSuitChest);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier4SpaceSuitLegings);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier4SpaceSuitBoots);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.tier4SpaceSuitGravityBoots);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBakeEvent(ModelBakeEvent event) {
		if (Config.mercury)
			ClientUtilities.replaceModelDefault(event, "rocket_t4", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.jupiter)
			ClientUtilities.replaceModelDefault(event, "rocket_t5", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.saturn)
			ClientUtilities.replaceModelDefault(event, "rocket_t6", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.uranus)
			ClientUtilities.replaceModelDefault(event, "rocket_t7", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.neptune)
			ClientUtilities.replaceModelDefault(event, "rocket_t8", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.pluto)
			ClientUtilities.replaceModelDefault(event, "rocket_t9", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if (Config.eris)
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
	}
}
