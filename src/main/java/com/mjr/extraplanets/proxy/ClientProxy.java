package com.mjr.extraplanets.proxy;

import micdoodle8.mods.galacticraft.planets.asteroids.client.render.item.ItemModelRocketT3;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIo;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicJupiter;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicMercury;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicNeptune;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPhobos;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPluto;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicRhea;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicSaturn;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitan;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTriton;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicUranus;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicVenus;
import com.mjr.extraplanets.client.handlers.MainHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossEris;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossJupiter;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossNeptune;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossPluto;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossSaturn;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossUranus;
import com.mjr.extraplanets.client.render.entity.RenderCreeperBossVenus;
import com.mjr.extraplanets.client.render.entity.RenderEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.render.entity.RenderEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier10Rocket;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier4Rocket;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier5Rocket;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier6Rocket;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier7Rocket;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier8Rocket;
import com.mjr.extraplanets.client.render.entity.rockets.RenderTier9Rocket;
import com.mjr.extraplanets.client.render.tile.TileEntitySolarPanelRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT10TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT4TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT5TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT6TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT7TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT8TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT9TreasureChestRenderer;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossUranus;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossVenus;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
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
import com.mjr.extraplanets.items.thermalPadding.ItemTier2ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier3ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier4ThermalPadding;
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
		MinecraftForge.EVENT_BUS.register(this);
		registerEntityRenders();
		registerCustomModel();
		registerFluidVariants();
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		SkyProviderHandler clientEventHandler = new SkyProviderHandler();
		MinecraftForge.EVENT_BUS.register(clientEventHandler);
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
			ClientUtilities.addExtraPlanetsVariants("mercury", "mercury_surface", "mercury_sub_surface", "mercury_stone", "mercury_ore_iron", "mercury_ore_tin",
					"mercury_ore_copper", "mercury_ore_mercury", "mercury_mercury_block", "mercury_stonebricks");
		if (Config.venus)
			ClientUtilities.addExtraPlanetsVariants("venus", "venus_surface", "venus_sub_surface", "venus_stone", "venus_ore_iron", "venus_ore_tin", "venus_ore_copper",
					"venus_ore_carbon", "venus_carbon_block", "venus_stonebricks", "venus_dungeon_brick");
		if (Config.ceres)
			ClientUtilities.addExtraPlanetsVariants("ceres", "ceres_surface", "ceres_sub_surface", "ceres_stone", "ceres_ore_iron", "ceres_ore_tin", "ceres_ore_copper",
					"ceres_ore_uranium", "ceres_uranium_block", "ceres_stonebricks");
		if (Config.jupiter)
			ClientUtilities.addExtraPlanetsVariants("jupiter", "jupiter_surface", "jupiter_sub_surface", "jupiter_stone", "jupiter_ore_iron", "jupiter_ore_tin",
					"jupiter_ore_copper", "jupiter_ore_palladium", "jupiter_palladium_block", "jupiter_stonebricks", "jupiter_dungeon_brick", "jupiter_ore_red_gem",
					"jupiter_red_gem_block");
		if (Config.uranus)
			ClientUtilities.addExtraPlanetsVariants("uranus", "uranus_surface", "uranus_sub_surface", "uranus_stone", "uranus_ore_crystal", "uranus_crystal_block",
					"uranus_stonebricks", "uranus_dungeon_brick", "uranus_ore_white_gem", "uranus_white_gem_block");
		if (Config.neptune)
			ClientUtilities.addExtraPlanetsVariants("neptune", "neptune_surface", "neptune_sub_surface", "neptune_stone", "neptune_ore_iron", "neptune_ore_tin",
					"neptune_ore_copper", "neptune_ore_zinc", "neptune_zinc_block", "neptune_stonebricks", "neptune_dungeon_brick", "neptune_ore_blue_gem",
					"neptune_blue_gem_block");
		if (Config.saturn)
			ClientUtilities.addExtraPlanetsVariants("saturn", "saturn_surface", "saturn_sub_surface", "saturn_stone", "saturn_ore_iron", "saturn_ore_tin", "saturn_ore_copper",
					"saturn_ore_magnesium", "saturn_magnesium_block", "saturn_stonebricks", "saturn_dungeon_brick");
		if (Config.pluto)
			ClientUtilities.addExtraPlanetsVariants("pluto", "pluto_surface", "pluto_sub_surface", "pluto_stone", "pluto_ore_iron", "pluto_ore_tin", "pluto_ore_copper",
					"pluto_ore_tungsten", "pluto_tungsten_block", "pluto_stonebricks", "pluto_dungeon_brick");
		if (Config.eris)
			ClientUtilities.addExtraPlanetsVariants("eris", "eris_surface", "eris_sub_surface", "eris_stone", "eris_ore_iron", "eris_ore_tin", "eris_ore_copper",
					"eris_ore_dark_iron", "eris_dark_iron_block", "eris_stonebricks", "eris_dungeon_brick");
		if (Config.callisto)
			ClientUtilities.addExtraPlanetsVariants("callisto", "callisto_surface", "callisto_sub_surface", "callisto_stone", "callisto_ore_iron", "callisto_ore_tin",
					"callisto_ore_copper");
		if (Config.deimos)
			ClientUtilities.addExtraPlanetsVariants("deimos", "deimos_surface", "deimos_sub_surface", "deimos_stone", "deimos_ore_iron", "deimos_ore_tin", "deimos_ore_copper");
		if (Config.europa)
			ClientUtilities.addExtraPlanetsVariants("europa", "europa_surface", "europa_sub_surface", "europa_stone", "europa_ore_iron", "europa_ore_tin", "europa_ore_copper");
		if (Config.ganymede)
			ClientUtilities.addExtraPlanetsVariants("ganymede", "ganymede_surface", "ganymede_sub_surface", "ganymede_stone", "ganymede_ore_iron", "ganymede_ore_tin",
					"ganymede_ore_copper");
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
		if (Config.venus)
			ClientUtilities.addExtraPlanetsVariants("tier4Items", "tier4engine", "tier4booster", "tier4Fin", "tier4HeavyDutyPlate", "compressedCarbon", "ingotCarbon");
		if (Config.jupiter)
			ClientUtilities.addExtraPlanetsVariants("tier5Items", "tier5engine", "tier5booster", "tier5Fin", "tier5HeavyDutyPlate", "compressedPalladium", "ingotPalladium",
					"compressedNickel", "ingotNickel", "redGem");
		if (Config.saturn)
			ClientUtilities.addExtraPlanetsVariants("tier6Items", "tier6engine", "tier6booster", "tier6Fin", "tier6HeavyDutyPlate", "compressedMagnesium", "ingotMagnesium");
		if (Config.uranus)
			ClientUtilities.addExtraPlanetsVariants("tier7Items", "tier7engine", "tier7booster", "tier7Fin", "tier7HeavyDutyPlate", "compressedCrystal", "ingotCrystal",
					"compressedReinforcedCrystal", "whiteGem");
		if (Config.neptune)
			ClientUtilities.addExtraPlanetsVariants("tier8Items", "tier8engine", "tier8booster", "tier8Fin", "tier8HeavyDutyPlate", "compressedZinc", "ingotZinc", "blueGem");
		if (Config.pluto)
			ClientUtilities.addExtraPlanetsVariants("tier9Items", "tier9engine", "tier9booster", "tier9Fin", "tier9HeavyDutyPlate", "compressedTungsten", "ingotTungsten");
		if (Config.eris)
			ClientUtilities.addExtraPlanetsVariants("tier10Items", "tier10engine", "tier10booster", "tier10Fin", "tier10HeavyDutyPlate", "compressedDarkIron", "ingotDarkIron");
		if (Config.kepler22b)
			ClientUtilities.addExtraPlanetsVariants("tier11Items", "blueDiamond", "redDiamond", "purpleDiamond", "yellowDiamond", "greenDiamond");
		ClientUtilities.addExtraPlanetsVariants("wafer", "diamondWafer", "carbonWafer", "titaniumWafer", "redGemWafer", "blueGemWafer", "whiteGemWafer");
		ClientUtilities.addExtraPlanetsVariants("tier2ThermalPadding", "tier2ThermalHelm", "tier2ThermalChestplate", "tier2ThermalLeggings", "tier2ThermalBoots");
		ClientUtilities.addExtraPlanetsVariants("tier3ThermalPadding", "tier3ThermalHelm", "tier3ThermalChestplate", "tier3ThermalLeggings", "tier3ThermalBoots");
		ClientUtilities.addExtraPlanetsVariants("tier4ThermalPadding", "tier4ThermalHelm", "tier4ThermalChestplate", "tier4ThermalLeggings", "tier4ThermalBoots");
		if (Config.solarPanels)
			ClientUtilities.addExtraPlanetsVariants("solarEP", "ultimate_solar", "hybrid_solar");
	}

	private void registerEntityRenders() {
		if (Config.venus)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossVenus.class, (RenderManager manager) -> new RenderCreeperBossVenus(manager));
		if (Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, (RenderManager manager) -> new RenderCreeperBossJupiter(manager));
		if (Config.saturn)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, (RenderManager manager) -> new RenderCreeperBossSaturn(manager));
		if (Config.uranus)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, (RenderManager manager) -> new RenderCreeperBossUranus(manager));
		if (Config.neptune)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, (RenderManager manager) -> new RenderCreeperBossNeptune(manager));
		if (Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, (RenderManager manager) -> new RenderCreeperBossPluto(manager));
		if (Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossEris.class, (RenderManager manager) -> new RenderCreeperBossEris(manager));
		if (Config.uranus)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, (RenderManager manager) -> new RenderEvolvedIceSlimeBoss(manager));
		if (Config.venus)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, (RenderManager manager) -> new RenderEvolvedMagmaCubeBoss(manager));

		if (Config.venus)
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
	}

	public void registerCustomModel() {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("galacticraftplanets:rocket_t3", "inventory");
		if (Config.venus) {
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
		if (Config.venus)
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
		}
		if (Config.venus) {
			for (BlockBasicVenus.EnumBlockBasic blockBasic : BlockBasicVenus.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.venusBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier4);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.venusGravel);
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.volcanicRock);
		}
		if (Config.ceres) {
			for (BlockBasicCeres.EnumBlockBasic blockBasic : BlockBasicCeres.EnumBlockBasic.values()) {
				ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ceresBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ceresGravel);
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
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.fossil);
		if (Config.advancedRefinery)
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.advancedRefinery);
		if (Config.solarPanels) {
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.solarPanel, 0, "hybird_solar");
			ClientUtilities.registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Machines.solarPanel, 4, "ultimate_solar");
		}
	}

	private void registerItemJsons() {
		if (Config.mercury) {
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
		}
		if (Config.venus){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T4key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier4);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier4);
			for (int i = 0; i < ItemTier4Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4Items, i, ItemTier4Items.names[i]);
			}
			if(Config.carbonItems) {
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
		if (Config.ceres){
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
		}
		if (Config.jupiter){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T5key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier5);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier5);
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
		if (Config.saturn){
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
		}
		if (Config.uranus){
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
		}
		if (Config.neptune){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T8key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier8);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier8);
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
		}
		if (Config.pluto){
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
		if (Config.eris){
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T10key);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier10);
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier10);
			for (int i = 0; i < ItemTier10Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier10Items, i, ItemTier10Items.names[i]);
			}
		}
		if (Config.kepler22b) {
			for (int i = 0; i < ItemTier11Items.names.length; i++) {
				ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier11Items, i, ItemTier11Items.names[i]);
			}
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondBoots);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondChest);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondHelmet);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.blueDiamondLegings);
			//
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondBoots);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondChest);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondHelmet);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.greenDiamondLegings);
			//
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondBoots);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondChest);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondHelmet);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.purpleDiamondLegings);
			//
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondBoots);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondChest);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondHelmet);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.redDiamondLegings);
			//
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondBoots);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondChest);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondHelmet);
			// ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Armor.yellowDiamondLegings);
		}
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.diamondApple);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ironApple);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.diamondApple, 1);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ironApple, 1);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.advancedBattery);
		ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ultimateBattery);
		for (int i = 0; i < ItemWafers.names.length; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.wafers, i, ItemWafers.names[i]);
		}
		for (int i = 0; i < ItemTier2ThermalPadding.names.length / 2; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2ThermalPadding, i, ItemTier2ThermalPadding.names[i]);
		}
		for (int i = 0; i < ItemTier3ThermalPadding.names.length / 2; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3ThermalPadding, i, ItemTier3ThermalPadding.names[i]);
		}
		for (int i = 0; i < ItemTier4ThermalPadding.names.length / 2; i++) {
			ClientUtilities.registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4ThermalPadding, i, ItemTier4ThermalPadding.names[i]);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBakeEvent(ModelBakeEvent event) {
		if (Config.venus)
			ClientUtilities.replaceModelDefault(event, "rocket_t4", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
		if (Config.jupiter)
			ClientUtilities.replaceModelDefault(event, "rocket_t5", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
		if (Config.saturn)
			ClientUtilities.replaceModelDefault(event, "rocket_t6", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
		if (Config.uranus)
			ClientUtilities.replaceModelDefault(event, "rocket_t7", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
		if (Config.neptune)
			ClientUtilities.replaceModelDefault(event, "rocket_t8", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
		if (Config.pluto)
			ClientUtilities.replaceModelDefault(event, "rocket_t9", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
		if (Config.eris)
			ClientUtilities.replaceModelDefault(event, "rocket_t10", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class,
					TRSRTransformation.identity());
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
