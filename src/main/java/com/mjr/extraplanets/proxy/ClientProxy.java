package com.mjr.extraplanets.proxy;

import micdoodle8.mods.galacticraft.core.client.render.item.ItemRendererKey;
import micdoodle8.mods.galacticraft.planets.asteroids.client.render.item.ItemRendererThermalArmor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.handlers.KeyHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.client.model.bosses.ModelEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.model.monsters.ModelEvolvedIceSlime;
import com.mjr.extraplanets.client.render.RenderPlayerExtraPlanets;
import com.mjr.extraplanets.client.render.block.BlockRendererCustomLandingPad;
import com.mjr.extraplanets.client.render.block.BlockRendererMachine;
import com.mjr.extraplanets.client.render.block.BlockRendererTier10TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier4TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier5TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier6TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier7TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier8TreasureChest;
import com.mjr.extraplanets.client.render.block.BlockRendererTier9TreasureChest;
import com.mjr.extraplanets.client.render.block.TileEntitySolarPanelRenderer;
import com.mjr.extraplanets.client.render.entities.RenderFireBombPrimed;
import com.mjr.extraplanets.client.render.entities.RenderNuclearBombPrimed;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedGhastBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.client.render.entities.bosses.RenderEvolvedSnowmanBoss;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossEris;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossJupiter;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossNeptune;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossPluto;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossSaturn;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossUranus;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.RenderCreeperBossVenus;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedBlaze;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedBlueCreeper;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedEnderman;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedGiantSpider;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedIceSlime;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedMagmaCube;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedMiniEnderman;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedPowerSkeleton;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedRedCreeper;
import com.mjr.extraplanets.client.render.entities.monsters.RenderEvolvedWitch;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier10Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier4Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier5Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier6Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier7Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier8Rocket;
import com.mjr.extraplanets.client.render.entities.rockets.RenderTier9Rocket;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderMarsRover;
import com.mjr.extraplanets.client.render.item.ItemRendererMarsRover;
import com.mjr.extraplanets.client.render.item.ItemRendererTier10Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier4Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier5Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier6Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier7Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier8Rocket;
import com.mjr.extraplanets.client.render.item.ItemRendererTier9Rocket;
import com.mjr.extraplanets.client.render.tile.TileEntityT10TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT4TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT5TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT6TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT7TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT8TreasureChestRenderer;
import com.mjr.extraplanets.client.render.tile.TileEntityT9TreasureChestRenderer;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossUranus;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossVenus;
import com.mjr.extraplanets.entities.monsters.EntityBlueCreeper;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedGiantSpider;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedIceSlime;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedMiniEnderman;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedRedCreeper;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedWitch;
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.extraplanets.handlers.MainHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tile.TileEntitySolar;
import com.mjr.extraplanets.tile.TileEntityT10TreasureChest;
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
	public static int treasureT10ChestID;
	public static int renderIdLandingPad;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		renderMobEntities();
		if (Config.morePlanetsCompatibility == false)
			renderNonMobEntities();
		FMLCommonHandler.instance().bus().register(new MainHandler());
		FMLCommonHandler.instance().bus().register(new SkyProviderHandler());

		if (Config.nuclearBomb)
			RenderingRegistry.registerEntityRenderingHandler(EntityNuclearBombPrimed.class, new RenderNuclearBombPrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBombPrimed.class, new RenderFireBombPrimed());

		FMLCommonHandler.instance().bus().register(new KeyHandlerClient());
		ClientRegistry.registerKeyBinding(KeyHandlerClient.openFuelGui);

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		renderBlocks();
		renderItems();
		registerTileEntityRenderers();
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderPlayerExtraPlanets());
	}

	@SideOnly(Side.CLIENT)
	private void renderMobEntities() {
		if (Config.venus) {
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossVenus.class, new RenderCreeperBossVenus());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, new RenderEvolvedMagmaCubeBoss());
		}
		if (Config.jupiter)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, new RenderCreeperBossJupiter());
		if (Config.saturn)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, new RenderCreeperBossSaturn());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGhastBoss.class, new RenderEvolvedGhastBoss());
		if (Config.uranus) {
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, new RenderCreeperBossUranus());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, new RenderEvolvedIceSlimeBoss(new ModelEvolvedIceSlimeBoss(16), new ModelEvolvedIceSlimeBoss(0), 0.25F));
		}
		if (Config.neptune)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, new RenderCreeperBossNeptune());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSnowmanBoss.class, new RenderEvolvedSnowmanBoss());
		if (Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, new RenderCreeperBossPluto());
		if (Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossEris.class, new RenderCreeperBossEris());

		if (Config.evolvedMagmaCube)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCube.class, new RenderEvolvedMagmaCube());
		if (Config.evolvedIceSlime)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlime.class, new RenderEvolvedIceSlime(new ModelEvolvedIceSlime(16), new ModelEvolvedIceSlime(0), 0.25F));
		if (Config.evolvedWitch)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedWitch.class, new RenderEvolvedWitch());
		if (Config.evolvedEnderman)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedEnderman.class, new RenderEvolvedEnderman());
		if (Config.evolvedBlaze)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedBlaze.class, new RenderEvolvedBlaze());
		if (Config.evolvedBlueCreeper)
			RenderingRegistry.registerEntityRenderingHandler(EntityBlueCreeper.class, new RenderEvolvedBlueCreeper());
		if (Config.evolvedRedCreeper)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedRedCreeper.class, new RenderEvolvedRedCreeper());
		if (Config.evolvedPowerSkeleton)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedPowerSkeleton.class, new RenderEvolvedPowerSkeleton());
		if (Config.evolvedGiantSpider)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGiantSpider.class, new RenderEvolvedGiantSpider());
		if (Config.evolvedMiniEnderman)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMiniEnderman.class, new RenderEvolvedMiniEnderman());

		RenderingRegistry.registerEntityRenderingHandler(EntitySmallSnowball.class, new RenderSnowball(Items.snowball));
	}

	@SideOnly(Side.CLIENT)
	private void renderNonMobEntities() {
		if (Config.venus) {
			IModelCustom rocketModelTier4 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket4Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, new RenderTier4Rocket(rocketModelTier4, Constants.ASSET_PREFIX, "blankRocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier4Rocket, new ItemRendererTier4Rocket(rocketModelTier4));
		}
		if (Config.jupiter) {
			IModelCustom rocketModelTier5 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket5Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, new RenderTier5Rocket(rocketModelTier5, Constants.ASSET_PREFIX, "blankRocketWhite"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier5Rocket, new ItemRendererTier5Rocket(rocketModelTier5));
		}
		if (Config.saturn) {
			IModelCustom rocketModelTier6 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket6Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, new RenderTier6Rocket(rocketModelTier6, Constants.ASSET_PREFIX, "blankRocket"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier6Rocket, new ItemRendererTier6Rocket(rocketModelTier6));
		}
		if (Config.uranus) {
			IModelCustom rocketModelTier7 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket7Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, new RenderTier7Rocket(rocketModelTier7, Constants.ASSET_PREFIX, "blankRocketWhite"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier7Rocket, new ItemRendererTier7Rocket(rocketModelTier7));
		}
		if (Config.neptune) {
			IModelCustom rocketModelTier8 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket8Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, new RenderTier8Rocket(rocketModelTier8, Constants.ASSET_PREFIX, "blankRocketWhite"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier8Rocket, new ItemRendererTier8Rocket(rocketModelTier8));
		}
		if (Config.pluto) {
			IModelCustom rocketModelTier9 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket9Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, new RenderTier9Rocket(rocketModelTier9, Constants.ASSET_PREFIX, "blankRocketWhite"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier9Rocket, new ItemRendererTier9Rocket(rocketModelTier9));
		}
		if (Config.eris) {
			IModelCustom rocketModelTier10 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket10Tier.obj"));
			RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, new RenderTier10Rocket(rocketModelTier10, Constants.ASSET_PREFIX, "blankRocketWhite"));
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier10Rocket, new ItemRendererTier10Rocket(rocketModelTier10));
		}
		IModelCustom marsRover = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/MarsRover.obj"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMarsRover.class, new RenderMarsRover(marsRover));
		MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.marsRover, new ItemRendererMarsRover(marsRover));
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
		if (Config.eris) {
			treasureT10ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier10TreasureChest(treasureT10ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT10TreasureChest.class, new TileEntityT10TreasureChestRenderer());
		}
		ClientProxy.renderIdMachine = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRendererMachine(renderIdMachine));
		renderIdLandingPad = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRendererCustomLandingPad(renderIdLandingPad));
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
		if (Config.eris) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T10key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasureT10.png")));
		}
		if (Config.thermalPaddings) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier2ThermalPadding, new ItemRendererThermalArmor());
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier3ThermalPadding, new ItemRendererThermalArmor());
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier4ThermalPadding, new ItemRendererThermalArmor());
		}
	}

	@SideOnly(Side.CLIENT)
	public static int getBlockRender(Block blockID) {
		if (blockID == ExtraPlanets_Machines.advancedRefinery) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Machines.advancedFuelLoader) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Blocks.advancedLaunchPadFull) {
			return ClientProxy.renderIdLandingPad;
		}
		if (blockID == ExtraPlanets_Machines.chargingBlock) {
			return ClientProxy.renderIdMachine;
		}
		return -1;
	}

	@SideOnly(Side.CLIENT)
	public static void registerTileEntityRenderers() {
		if (Config.solarPanels)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolar.class, new TileEntitySolarPanelRenderer());
	}
}
