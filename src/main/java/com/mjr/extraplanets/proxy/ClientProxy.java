package com.mjr.extraplanets.proxy;

import java.util.List;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import micdoodle8.mods.galacticraft.core.wrappers.ModelTransformWrapper;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import micdoodle8.mods.galacticraft.planets.asteroids.client.render.item.ItemModelRocketT3;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.IModelState;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
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
import com.mjr.extraplanets.tile.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT9TreasureChest;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		if(Config.mercury)
			addExtraPlanetsVariants("mercury", "mercury_surface", "mercury_sub_surface", "mercury_stone", "mercury_ore_iron", "mercury_ore_tin", "mercury_ore_copper", "mercury_ore_mercury", "mercury_mercury_block", "mercury_stonebricks");
		if(Config.venus)
			addExtraPlanetsVariants("venus", "venus_surface", "venus_sub_surface", "venus_stone", "venus_ore_iron", "venus_ore_tin", "venus_ore_copper", "venus_ore_carbon", "venus_carbon_block", "venus_stonebricks", "venus_dungeon_brick");
		if(Config.ceres)
			addExtraPlanetsVariants("ceres", "ceres_surface", "ceres_sub_surface", "ceres_stone", "ceres_ore_iron", "ceres_ore_tin", "ceres_ore_copper", "ceres_ore_uranium", "ceres_uranium_block", "ceres_stonebricks");
		if(Config.jupiter)	
			addExtraPlanetsVariants("jupiter", "jupiter_surface", "jupiter_sub_surface", "jupiter_stone", "jupiter_ore_iron", "jupiter_ore_tin", "jupiter_ore_copper", "jupiter_ore_red_gem", "jupiter_red_gem_block", "jupiter_stonebricks", "jupiter_dungeon_brick", "jupiter_ore_red_gem", "jupiter_red_gem_block");
		if(Config.uranus)	
			addExtraPlanetsVariants("uranus", "uranus_surface", "uranus_sub_surface", "uranus_stone", "uranus_ore_iron", "uranus_ore_tin", "uranus_ore_copper", "uranus_ore_white_gem", "uranus_white_gem_block", "uranus_stonebricks", "uranus_dungeon_brick", "uranus_ore_red_gem", "uranus_red_gem_block");
		if(Config.neptune)	
			addExtraPlanetsVariants("neptune", "neptune_surface", "neptune_sub_surface", "neptune_stone", "neptune_ore_iron", "neptune_ore_tin", "neptune_ore_copper", "neptune_ore_blue_gem", "neptune_blue_gem_block", "neptune_stonebricks", "neptune_dungeon_brick", "neptune_ore_red_gem", "neptune_red_gem_block");
		if(Config.saturn)	
			addExtraPlanetsVariants("saturn", "saturn_surface", "saturn_sub_surface", "saturn_stone", "saturn_ore_iron", "saturn_ore_tin", "saturn_ore_copper", "saturn_ore_magnesium", "saturn_magnesium_block", "saturn_stonebricks", "saturn_dungeon_brick");
		if(Config.pluto)	
			addExtraPlanetsVariants("pluto", "pluto_surface", "pluto_sub_surface", "pluto_stone", "pluto_ore_iron", "pluto_ore_tin", "pluto_ore_copper", "pluto_ore_tungsten", "pluto_tungsten_block", "pluto_stonebricks", "pluto_dungeon_brick");
		if(Config.eris)	
			addExtraPlanetsVariants("eris", "eris_surface", "eris_sub_surface", "eris_stone", "eris_ore_iron", "eris_ore_tin", "eris_ore_copper", "eris_ore_dark_iron", "eris_dark_iron_block", "eris_stonebricks", "eris_dungeon_brick");
		
		if(Config.callisto)	
			addExtraPlanetsVariants("callisto", "callisto_surface", "callisto_sub_surface", "callisto_stone", "callisto_ore_iron", "callisto_ore_tin", "callisto_ore_copper");
		if(Config.deimos)	
			addExtraPlanetsVariants("deimos", "deimos_surface", "deimos_sub_surface", "deimos_stone", "deimos_ore_iron", "deimos_ore_tin", "deimos_ore_copper");
		if(Config.europa)	
			addExtraPlanetsVariants("europa", "europa_surface", "europa_sub_surface", "europa_stone", "europa_ore_iron", "europa_ore_tin", "europa_ore_copper");
		if(Config.ganymede)
			addExtraPlanetsVariants("ganymede", "ganymede_surface", "ganymede_sub_surface", "ganymede_stone", "ganymede_ore_iron", "ganymede_ore_tin", "ganymede_ore_copper");
		if(Config.io)	
			addExtraPlanetsVariants("io", "io_surface", "io_sub_surface", "io_stone", "io_ore_iron", "io_ore_tin", "io_ore_copper");
		if(Config.phobos)
			addExtraPlanetsVariants("phobos", "phobos_surface", "phobos_sub_surface", "phobos_stone", "phobos_ore_iron", "phobos_ore_tin", "phobos_ore_copper");
		if(Config.rhea)	
			addExtraPlanetsVariants("rhea", "rhea_surface", "rhea_sub_surface", "rhea_stone", "rhea_ore_iron", "rhea_ore_tin", "rhea_ore_copper");
		if(Config.titan)
			addExtraPlanetsVariants("titan", "titan_surface", "titan_sub_surface", "titan_stone", "titan_ore_iron", "titan_ore_tin", "titan_ore_copper");
		if(Config.triton)
			addExtraPlanetsVariants("triton", "triton_surface", "triton_sub_surface", "triton_stone", "triton_ore_iron", "triton_ore_tin", "triton_ore_copper");
		if(Config.venus)
			addExtraPlanetsVariants("tier4Items", "tier4engine", "tier4booster", "tier4Fin", "tier4HeavyDutyPlate", "compressedCarbon", "ingotCarbon");
		if(Config.jupiter)
			addExtraPlanetsVariants("tier5Items", "tier5engine", "tier5booster", "tier5Fin", "tier5HeavyDutyPlate", "compressedPalladium", "ingotPalladium", "compressedNickel", "ingotNickel", "redGem");
		if(Config.saturn)	
			addExtraPlanetsVariants("tier6Items", "tier6engine", "tier6booster", "tier6Fin", "tier6HeavyDutyPlate", "compressedMagnesium", "ingotMagnesium");
		if(Config.uranus)	
			addExtraPlanetsVariants("tier7Items", "tier7engine", "tier7booster", "tier7Fin", "tier7HeavyDutyPlate", "compressedCrystal", "ingotCrystal", "compressedReinforcedCrystal", "whiteGem");
		if(Config.neptune)	
			addExtraPlanetsVariants("tier8Items", "tier8engine", "tier8booster", "tier8Fin", "tier8HeavyDutyPlate", "compressedZinc", "ingotZinc", "blueGem");
		if(Config.pluto)
			addExtraPlanetsVariants("tier9Items", "tier9engine", "tier9booster", "tier9Fin", "tier9HeavyDutyPlate", "compressedTungsten", "ingotTungsten");
		if(Config.eris)
			addExtraPlanetsVariants("tier10Items", "tier10engine", "tier10booster", "tier10Fin", "tier10HeavyDutyPlate", "compressedDarkIron", "ingotDarkIron");
		
		//addExtraPlanetsVariants("tier11Items", "blueDiamond", "redDiamond", "purpleDiamond", "yellowDiamond", "greenDiamond");

		addExtraPlanetsVariants("wafer", "diamondWafer", "carbonWafer", "titaniumWafer", "redGemWafer", "blueGemWafer", "whiteGemWafer");
		addExtraPlanetsVariants("tier2ThermalPadding", "tier2ThermalHelm", "tier2ThermalChestplate", "tier2ThermalLeggings", "tier2ThermalBoots");
		addExtraPlanetsVariants("tier3ThermalPadding", "tier3ThermalHelm", "tier3ThermalChestplate", "tier3ThermalLeggings", "tier3ThermalBoots");
		addExtraPlanetsVariants("tier4ThermalPadding", "tier4ThermalHelm", "tier4ThermalChestplate", "tier4ThermalLeggings", "tier4ThermalBoots");

		if(Config.venus)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossVenus.class, (RenderManager manager) -> new RenderCreeperBossVenus(manager));
		if(Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, (RenderManager manager) -> new RenderCreeperBossJupiter(manager));
		if(Config.saturn)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, (RenderManager manager) -> new RenderCreeperBossSaturn(manager));
		if(Config.uranus)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, (RenderManager manager) -> new RenderCreeperBossUranus(manager));
		if(Config.neptune)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, (RenderManager manager) -> new RenderCreeperBossNeptune(manager));
		if(Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, (RenderManager manager) -> new RenderCreeperBossPluto(manager));
		if(Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossEris.class, (RenderManager manager) -> new RenderCreeperBossEris(manager));
		if(Config.uranus)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, (RenderManager manager) -> new RenderEvolvedIceSlimeBoss(manager));
		if(Config.venus)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, (RenderManager manager) -> new RenderEvolvedMagmaCubeBoss(manager));
		
		if(Config.venus)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, (RenderManager manager) -> new RenderTier4Rocket(manager));
		if(Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, (RenderManager manager) -> new RenderTier5Rocket(manager));
		if(Config.saturn)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, (RenderManager manager) -> new RenderTier6Rocket(manager));
		if(Config.uranus)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, (RenderManager manager) -> new RenderTier7Rocket(manager));
		if(Config.neptune)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, (RenderManager manager) -> new RenderTier8Rocket(manager));
		if(Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, (RenderManager manager) -> new RenderTier9Rocket(manager));
		if(Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, (RenderManager manager) -> new RenderTier10Rocket(manager));

		MinecraftForge.EVENT_BUS.register(this);

		registerVariants();
		super.preInit(event);
	}

	private void addExtraPlanetsVariants(String name, String... variants) {
		Item itemBlockVariants = GameRegistry.findItem(Constants.modID, name);
		ResourceLocation[] variants0 = new ResourceLocation[variants.length];
		for (int i = 0; i < variants.length; ++i) {
			variants0[i] = new ResourceLocation(Constants.TEXTURE_PREFIX + variants[i]);
		}
		ModelBakery.registerItemVariants(itemBlockVariants, variants0);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		SkyProviderHandler clientEventHandler = new SkyProviderHandler();
		MinecraftForge.EVENT_BUS.register(clientEventHandler);
		renderBlocks();
		registerBlockRenderers();
		registerItemRenderers();
		MinecraftForge.EVENT_BUS.register(this);
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		super.postInit(event);
	}

	public void registerVariants() {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("galacticraftplanets:rocket_t3", "inventory");
		if(Config.venus){
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier4Rocket, i, modelResourceLocation);
			}
		}
		if(Config.jupiter){
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier5Rocket, i, modelResourceLocation);
			}
		}
		if(Config.saturn){
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier6Rocket, i, modelResourceLocation);
			}
		}
		if(Config.uranus){
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier7Rocket, i, modelResourceLocation);
			}
		}
		if(Config.neptune){
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier8Rocket, i, modelResourceLocation);
			}
		}
		if(Config.pluto){
			for (int i = 0; i < 5; ++i) {
				ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier9Rocket, i, modelResourceLocation);
			}
		}
		if(Config.eris){
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

	}

	public static void registerBlockJson(String texturePrefix, Block block, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}

	public static void registerBlockJson(String texturePrefix, Block block) {
		registerBlockJson(texturePrefix, block, 0, block.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item) {
		registerItemJson(texturePrefix, item, 0, item.getUnlocalizedName().substring(5));
	}
	
	public static void registerItemJson(String texturePrefix, Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}

	private void registerBlockRenderers() {
		// Planets
		
		if(Config.mercury){
			for (BlockBasicMercury.EnumBlockBasic blockBasic : BlockBasicMercury.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.mercuryBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.venus){
			for (BlockBasicVenus.EnumBlockBasic blockBasic : BlockBasicVenus.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.venusBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.ceres){
			for (BlockBasicCeres.EnumBlockBasic blockBasic : BlockBasicCeres.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ceresBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.jupiter){
			for (BlockBasicJupiter.EnumBlockBasic blockBasic : BlockBasicJupiter.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.jupiterBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.neptune){
			for (BlockBasicSaturn.EnumBlockBasic blockBasic : BlockBasicSaturn.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.saturnBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.uranus){
			for(BlockBasicUranus.EnumBlockBasic blockBasic : BlockBasicUranus.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.uranusBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.neptune){
			for (BlockBasicNeptune.EnumBlockBasic blockBasic : BlockBasicNeptune.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.neptuneBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.pluto){
			for (BlockBasicPluto.EnumBlockBasic blockBasic : BlockBasicPluto.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.plutoBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.eris){
			for (BlockBasicEris.EnumBlockBasic blockBasic : BlockBasicEris.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.erisBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		
		// Moons
		if(Config.callisto){
			for (BlockBasicCallisto.EnumBlockBasic blockBasic : BlockBasicCallisto.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.callistoBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.deimos){
			for (BlockBasicDeimos.EnumBlockBasic blockBasic : BlockBasicDeimos.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.deimosBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.europa){
			for (BlockBasicEuropa.EnumBlockBasic blockBasic : BlockBasicEuropa.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.europaBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.ganymede){
			for (BlockBasicGanymede.EnumBlockBasic blockBasic : BlockBasicGanymede.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ganymedeBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.io){
			for (BlockBasicIo.EnumBlockBasic blockBasic : BlockBasicIo.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ioBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.phobos){
			for (BlockBasicPhobos.EnumBlockBasic blockBasic : BlockBasicPhobos.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.phobosBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.rhea){
			for (BlockBasicRhea.EnumBlockBasic blockBasic : BlockBasicRhea.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.rheaBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.titan){
			for (BlockBasicTitan.EnumBlockBasic blockBasic : BlockBasicTitan.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.titanBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}
		if(Config.triton){
			for (BlockBasicTriton.EnumBlockBasic blockBasic : BlockBasicTriton.EnumBlockBasic.values()) {
				registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.tritonBlocks, blockBasic.getMeta(), blockBasic.getName());
			}
		}

		if(Config.venus)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier4);
		if(Config.jupiter)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier5);
		if(Config.saturn)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier6);
		if(Config.uranus)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier7);
		if(Config.neptune)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier8);
		if(Config.pluto)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier9);
		if(Config.eris)
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier10);
	}

	private void registerItemRenderers() {
		if(Config.venus)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T4key);
		if(Config.jupiter)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T5key);
		if(Config.saturn)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T6key);
		if(Config.uranus)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T7key);
		if(Config.neptune)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T8key);
		if(Config.pluto)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T9key);
		if(Config.eris)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.T10key);
			
		if(Config.venus)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier4);
		if(Config.jupiter)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier5);
		if(Config.saturn)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier6);
		if(Config.uranus)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier7);
		if(Config.neptune)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier8);
		if(Config.pluto)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier9);
		if(Config.eris)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.noseConeTier10);
		
		if(Config.venus)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier4);
		if(Config.jupiter)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier5);
		if(Config.saturn)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier6);
		if(Config.uranus)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier7);
		if(Config.neptune)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier8);
		if(Config.pluto)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier9);
		if(Config.eris)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.schematicTier10);
			
		registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.advancedBattery);
		registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ultimateBattery);
		if (Config.jupiter)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.nickelBattery);
		if (Config.neptune)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.zincBattery);
		if(Config.mercury){
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.mercuryBattery);
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.compressedMercury);
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ingotMercury);
		}
		if(Config.ceres)
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.ingotUranium);
		
		if(Config.venus){
			for (int i = 0; i < ItemTier4Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4Items, i, ItemTier4Items.names[i]);
			}
		}
		if(Config.jupiter){
			for (int i = 0; i < ItemTier5Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier5Items, i, ItemTier5Items.names[i]);
			}
		}
		if(Config.saturn){
			for (int i = 0; i < ItemTier6Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier6Items, i, ItemTier6Items.names[i]);
			}
		}
		if(Config.uranus){
			for (int i = 0; i < ItemTier7Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier7Items, i, ItemTier7Items.names[i]);
			}
		}
		if(Config.neptune){
			for (int i = 0; i < ItemTier8Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier8Items, i, ItemTier8Items.names[i]);
			}
		}
		if(Config.pluto){
			for (int i = 0; i < ItemTier9Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier9Items, i, ItemTier9Items.names[i]);
			}
		}
		if(Config.eris){
			for (int i = 0; i < ItemTier10Items.names.length; i++) {
				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier10Items, i, ItemTier10Items.names[i]);
			}
		}
//		if(Config.kepler22b){
//			for (int i = 0; i < ItemTier11Items.names.length; i++) {
//				registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier11Items, i, ItemTier11Items.names[i]);
//			}
//		}
		
		for (int i = 0; i < ItemWafers.names.length; i++) {
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.wafers, i, ItemWafers.names[i]);
		}
		
		for (int i = 0; i < ItemTier2ThermalPadding.names.length /2; i++) {
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier2ThermalPadding, i, ItemTier2ThermalPadding.names[i]);
		}
		for (int i = 0; i < ItemTier3ThermalPadding.names.length /2; i++) {
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier3ThermalPadding, i, ItemTier3ThermalPadding.names[i]);
		}
		for (int i = 0; i < ItemTier4ThermalPadding.names.length /2; i++) {
			registerItemJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Items.tier4ThermalPadding, i, ItemTier4ThermalPadding.names[i]);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBakeEvent(ModelBakeEvent event) {
		if(Config.venus)
			replaceModelDefault(event, "rocket_t4", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if(Config.jupiter)
			replaceModelDefault(event, "rocket_t5", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if(Config.saturn)
			replaceModelDefault(event, "rocket_t6", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if(Config.uranus)
			replaceModelDefault(event, "rocket_t7", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if(Config.neptune)
			replaceModelDefault(event, "rocket_t8", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if(Config.pluto)
			replaceModelDefault(event, "rocket_t9", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
		if(Config.eris)
			replaceModelDefault(event, "rocket_t10", "tier3rocket.obj", ImmutableList.of("Boosters", "Cube", "NoseCone", "Rocket"), ItemModelRocketT3.class, TRSRTransformation.identity());
	}

	private void replaceModelDefault(ModelBakeEvent event, String resLoc, String objLoc, List<String> visibleGroups, Class<? extends ModelTransformWrapper> clazz, IModelState parentState) {
		ClientUtil.replaceModel(GalacticraftPlanets.ASSET_PREFIX, event, resLoc, objLoc, visibleGroups, clazz, parentState);
	}
}
