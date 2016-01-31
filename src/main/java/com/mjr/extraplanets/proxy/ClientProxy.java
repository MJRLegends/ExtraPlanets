package com.mjr.extraplanets.proxy;

import micdoodle8.mods.galacticraft.core.client.render.item.ItemRendererKey;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.model.ModelEvolvedIceSlime;
import com.mjr.extraplanets.client.model.ModelEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.render.block.BlockRendererMachine;
import com.mjr.extraplanets.client.render.block.BlockRendererTier4TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier5TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier6TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier7TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier8TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier9TreasureChest;
import com.mjr.extraplanets.client.render.block.TileEntitySolarPanelRenderer;
import com.mjr.extraplanets.client.render.entities.RenderCreeperBossJupiter;
import com.mjr.extraplanets.client.render.entities.RenderCreeperBossNeptune;
import com.mjr.extraplanets.client.render.entities.RenderCreeperBossPluto;
import com.mjr.extraplanets.client.render.entities.RenderCreeperBossSaturn;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedBlaze;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedBlueCreeper;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedEnderman;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedIceSlime;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedMagmaCube;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedPowerSkeleton;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedRedCreeper;
import com.mjr.extraplanets.client.render.entities.RenderEvolvedWitch;
import com.mjr.extraplanets.client.render.entities.RenderNuclearBombPrimed;
import com.mjr.extraplanets.client.render.entities.RenderTier4Rocket;
import com.mjr.extraplanets.client.render.entities.RenderTier5Rocket;
import com.mjr.extraplanets.client.render.entities.RenderTier6Rocket;
import com.mjr.extraplanets.client.render.entities.RenderTier7Rocket;
import com.mjr.extraplanets.client.render.entities.RenderTier8Rocket;
import com.mjr.extraplanets.client.render.entities.RenderTier9Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier4Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier5Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier6Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier7Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier8Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier9Rocket;
import com.mjr.extraplanets.client.render.tile.TileEntityT4TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT5TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT6TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT7TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT8TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT9TreasureChestRenderer;
import com.mjr.extraplanets.entities.EntityBlueCreeper;
import com.mjr.extraplanets.entities.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.EntityEvolvedIceSlime;
import com.mjr.extraplanets.entities.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.entities.EntityEvolvedRedCreeper;
import com.mjr.extraplanets.entities.EntityEvolvedWitch;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.handlers.MainHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.moons.Callisto.CallistoHandlerClient;
import com.mjr.extraplanets.moons.Deimos.DeimosHandlerClient;
import com.mjr.extraplanets.moons.Europa.EuropaHandlerClient;
import com.mjr.extraplanets.moons.Ganymede.GanymedeHandlerClient;
import com.mjr.extraplanets.moons.Io.IoHandlerClient;
import com.mjr.extraplanets.moons.Phobos.PhobosHandlerClient;
import com.mjr.extraplanets.moons.Rhea.RheaHandlerClient;
import com.mjr.extraplanets.moons.Titan.TitanHandlerClient;
import com.mjr.extraplanets.moons.triton.TritonHandlerClient;
import com.mjr.extraplanets.planets.Ceres.CeresHandlerClient;
import com.mjr.extraplanets.planets.Eris.ErisHandlerClient;
import com.mjr.extraplanets.planets.Jupiter.JupiterHandlerClient;
import com.mjr.extraplanets.planets.Mercury.MercuryHandlerClient;
import com.mjr.extraplanets.planets.Neptune.NeptuneHandlerClient;
import com.mjr.extraplanets.planets.Pluto.PlutoHandlerClient;
import com.mjr.extraplanets.planets.Saturn.SaturnHandlerClient;
import com.mjr.extraplanets.planets.Uranus.UranusHandlerClient;
import com.mjr.extraplanets.planets.Venus.VenusHandlerClient;
import com.mjr.extraplanets.tile.TileEntitySolar;
import com.mjr.extraplanets.tile.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT9TreasureChest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

	public static int renderIdMachine;
	public static int treasureT4ChestID;
	public static int treasureT5ChestID;
	public static int treasureT6ChestID;
	public static int treasureT7ChestID;
	public static int treasureT8ChestID;
	public static int treasureT9ChestID;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		renderMobEntities();
		renderNonMobEntities();
		FMLCommonHandler.instance().bus().register(new MainHandler());

		if (Config.mercury)
			FMLCommonHandler.instance().bus().register(new MercuryHandlerClient());
		if (Config.venus)
			FMLCommonHandler.instance().bus().register(new VenusHandlerClient());
		if (Config.ceres)
			FMLCommonHandler.instance().bus().register(new CeresHandlerClient());
		if (Config.jupiter)
			FMLCommonHandler.instance().bus().register(new JupiterHandlerClient());
		if (Config.saturn)
			FMLCommonHandler.instance().bus().register(new SaturnHandlerClient());
		if (Config.uranus)
			FMLCommonHandler.instance().bus().register(new UranusHandlerClient());
		if (Config.neptune)
			FMLCommonHandler.instance().bus().register(new NeptuneHandlerClient());
		if (Config.pluto)
			FMLCommonHandler.instance().bus().register(new PlutoHandlerClient());
		if (Config.eris)
			FMLCommonHandler.instance().bus().register(new ErisHandlerClient());

		if (Config.callisto)
			FMLCommonHandler.instance().bus().register(new CallistoHandlerClient());
		if (Config.deimos)
			FMLCommonHandler.instance().bus().register(new DeimosHandlerClient());
		if (Config.europa)
			FMLCommonHandler.instance().bus().register(new EuropaHandlerClient());
		if (Config.ganymede)
			FMLCommonHandler.instance().bus().register(new GanymedeHandlerClient());
		if (Config.io)
			FMLCommonHandler.instance().bus().register(new IoHandlerClient());
		if (Config.phobos)
			FMLCommonHandler.instance().bus().register(new PhobosHandlerClient());
		if (Config.triton)
			FMLCommonHandler.instance().bus().register(new TritonHandlerClient());
		if (Config.rhea)
			FMLCommonHandler.instance().bus().register(new RheaHandlerClient());
		if (Config.titan)
			FMLCommonHandler.instance().bus().register(new TitanHandlerClient());

		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearBombPrimed.class, new RenderNuclearBombPrimed());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		renderBlocks();
		renderItems();
		registerTileEntityRenderers();
	}

	@SideOnly(Side.CLIENT)
	private void renderMobEntities() {
		if (Config.venus)
			// RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossVenus.class,
			// new RenderCreeperBossVenus());
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, new RenderEvolvedMagmaCubeBoss());
		if (Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, new RenderCreeperBossJupiter());
		if (Config.saturn)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, new RenderCreeperBossSaturn());
		if (Config.uranus)
			// RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class,
			// new RenderCreeperBossUranus());
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, new RenderEvolvedIceSlimeBoss(new ModelEvolvedIceSlimeBoss(16), new ModelEvolvedIceSlimeBoss(0), 0.25F));
		if (Config.neptune)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, new RenderCreeperBossNeptune());
		if (Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, new RenderCreeperBossPluto());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCube.class, new RenderEvolvedMagmaCube());
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlime.class, new RenderEvolvedIceSlime(new ModelEvolvedIceSlime(16), new ModelEvolvedIceSlime(0), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedWitch.class, new RenderEvolvedWitch());
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedEnderman.class, new RenderEvolvedEnderman());
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedBlaze.class, new RenderEvolvedBlaze());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueCreeper.class, new RenderEvolvedBlueCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedRedCreeper.class, new RenderEvolvedRedCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedPowerSkeleton.class, new RenderEvolvedPowerSkeleton());
		// RenderingRegistry.registerEntityRenderingHandler(
		// EvolvedIceBlaze.class, new RenderEvolvedIceBlaze());
		// RenderingRegistry.registerEntityRenderingHandler(
		// EntitySmallSnowball.class, new
		// RenderEntitySmallSnowball(Items.snowball));
	}

	@SideOnly(Side.CLIENT)
	private void renderNonMobEntities() {
		if (Config.venus) {
			IModelCustom rocketModelTier4 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/tier4rocket.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, new RenderTier4Rocket(rocketModelTier4, Constants.ASSET_PREFIX, "tier4rocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier4Rocket, new ItemRendererTier4Rocket(rocketModelTier4));
		}
		if (Config.jupiter) {
			IModelCustom rocketModelTier5 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/tier4rocket.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, new RenderTier5Rocket(rocketModelTier5, Constants.ASSET_PREFIX, "tier5rocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier5Rocket, new ItemRendererTier5Rocket(rocketModelTier5));
		}
		if (Config.saturn) {
			IModelCustom rocketModelTier6 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/tier4rocket.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, new RenderTier6Rocket(rocketModelTier6, Constants.ASSET_PREFIX, "tier6rocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier6Rocket, new ItemRendererTier6Rocket(rocketModelTier6));
		}
		if (Config.uranus) {
			IModelCustom rocketModelTier7 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/tier4rocket.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, new RenderTier7Rocket(rocketModelTier7, Constants.ASSET_PREFIX, "tier7rocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier7Rocket, new ItemRendererTier7Rocket(rocketModelTier7));
		}
		if (Config.neptune) {
			IModelCustom rocketModelTier8 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/tier4rocket.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, new RenderTier8Rocket(rocketModelTier8, Constants.ASSET_PREFIX, "tier8rocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier8Rocket, new ItemRendererTier8Rocket(rocketModelTier8));
		}
		if (Config.pluto) {
			IModelCustom rocketModelTier9 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/tier4rocket.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, new RenderTier9Rocket(rocketModelTier9, Constants.ASSET_PREFIX, "tier9rocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier9Rocket, new ItemRendererTier9Rocket(rocketModelTier9));
		}
	}

	@SideOnly(Side.CLIENT)
	private static void renderBlocks() {
		if (Config.venus) {
			treasureT4ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier4TreasureChest(treasureT4ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT4TreasureChest.class, new TileEntityT4TreasureChestRenderer());
		}
		if (Config.jupiter) {
			treasureT5ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier5TreasureChest(treasureT5ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT5TreasureChest.class, new TileEntityT5TreasureChestRenderer());
		}
		if (Config.saturn) {
			treasureT6ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier6TreasureChest(treasureT6ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT6TreasureChest.class, new TileEntityT6TreasureChestRenderer());
		}
		if (Config.uranus) {
			treasureT7ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier7TreasureChest(treasureT7ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT7TreasureChest.class, new TileEntityT7TreasureChestRenderer());
		}
		if (Config.neptune) {
			treasureT8ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier8TreasureChest(treasureT8ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT8TreasureChest.class, new TileEntityT8TreasureChestRenderer());
		}
		if (Config.pluto) {
			treasureT9ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier9TreasureChest(treasureT9ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT9TreasureChest.class, new TileEntityT9TreasureChestRenderer());
		}
		ClientProxy.renderIdMachine = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRendererMachine(renderIdMachine));
	}

	@SideOnly(Side.CLIENT)
	private static void renderItems() {
		if (Config.venus) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T4key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT4.png")));
		}
		if (Config.jupiter) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T5key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT5.png")));
		}
		if (Config.saturn) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T6key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT6.png")));
		}
		if (Config.uranus) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T7key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT7.png")));
		}
		if (Config.neptune) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T8key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT8.png")));
		}
		if (Config.pluto) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T9key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT9.png")));
		}
	}

	@SideOnly(Side.CLIENT)
	public static int getBlockRender(Block blockID) {
		if (blockID == ExtraPlanets_Machines.advancedRefinery) {
			return ClientProxy.renderIdMachine;
		}
		return -1;
	}

	@SideOnly(Side.CLIENT)
	public static void registerTileEntityRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolar.class, new TileEntitySolarPanelRenderer());
	}
}
