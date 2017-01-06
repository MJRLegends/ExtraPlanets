package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.ExtraPlanets_SpaceStations;
import com.mjr.extraplanets.proxy.CommonProxy;
import com.mjr.extraplanets.recipes.ExtraPlanets_Recipes;
import com.mjr.extraplanets.schematic.SchematicTier10Rocket;
import com.mjr.extraplanets.schematic.SchematicTier4Rocket;
import com.mjr.extraplanets.schematic.SchematicTier5Rocket;
import com.mjr.extraplanets.schematic.SchematicTier6Rocket;
import com.mjr.extraplanets.schematic.SchematicTier7Rocket;
import com.mjr.extraplanets.schematic.SchematicTier8Rocket;
import com.mjr.extraplanets.schematic.SchematicTier9Rocket;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = "required-after:GalacticraftCore;required-after:GalacticraftPlanets;;required-after:Forge@[10.13.4.1558,);")
public class ExtraPlanets {

	@SidedProxy(clientSide = "com.mjr.extraplanets.proxy.ClientProxy", serverSide = "com.mjr.extraplanets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.modID)
	public static ExtraPlanets instance;

	// Blocks Creative Tab
	public static CreativeTabs BlocksTab = new CreativeTabs("SpaceBlocksTab") {
		@Override
		public Item getTabIconItem() {
			// return Item.getItemFromBlock(ExtraPlanets_Blocks.denseIce);
			return Item.getItemFromBlock(GCBlocks.basicBlock);
		}
	};

	// Items Creative Tab
	public static CreativeTabs ItemsTab = new CreativeTabs("SpaceItemsTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.venus)
				return ExtraPlanets_Items.tier4Rocket;
			else if (Config.jupiter)
				return ExtraPlanets_Items.tier5Rocket;
			else if (Config.saturn)
				return ExtraPlanets_Items.tier6Rocket;
			else if (Config.uranus)
				return ExtraPlanets_Items.tier7Rocket;
			else if (Config.neptune)
				return ExtraPlanets_Items.tier8Rocket;
			else if (Config.pluto)
				return ExtraPlanets_Items.tier9Rocket;
			else if (Config.eris)
				return ExtraPlanets_Items.tier10Rocket;
			return GCItems.rocketTier1;
		}
	};
	// Tools Creative Tab
	public static CreativeTabs ToolsTab = new CreativeTabs("SpaceToolsTab") {
		@Override
		public Item getTabIconItem() {
			// if (Config.venus)
			// return ExtraPlanets_Tools.carbonPickaxe;
			// else if (Config.jupiter)
			// return ExtraPlanets_Tools.palladiumPickaxe;
			// else if (Config.saturn)
			// return ExtraPlanets_Tools.magnesiumPickaxe;
			// else if (Config.uranus)
			// return ExtraPlanets_Tools.crystalPickaxe;
			return GCItems.steelPickaxe;
		}
	};
	// Armour Creative Tab
	public static CreativeTabs ArmorTab = new CreativeTabs("SpaceArmorTab") {
		@Override
		public Item getTabIconItem() {
			// if (Config.venus)
			// return ExtraPlanets_Armor.carbonChest;
			// else if (Config.jupiter)
			// return ExtraPlanets_Armor.palladiumChest;
			// else if (Config.saturn)
			// return ExtraPlanets_Armor.magnesiumChest;
			// else if (Config.uranus)
			// return ExtraPlanets_Armor.crystalChest;
			return GCItems.steelChestplate;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load();
		// Initialization/Registering Methods For Blocks/Items
		ExtraPlanets_Blocks.init();
		// ExtraPlanets_Tools.init();
		// ExtraPlanets_Armor.init();
		ExtraPlanets_Items.init();

		// Proxy PreInit Method
		ExtraPlanets.proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Initialization/Registering Methods For
		// SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

		registerNonMobEntities();

		// Proxy Init Method
		ExtraPlanets.proxy.init(event);

		if (event.getSide() == Side.CLIENT)
			registerBlockRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Register Schematics Recipes
		registerSchematicsRecipes();

		// Register/Add Dungeon Loot
		addDungeonLoot();

		// Register Recipes
		ExtraPlanets_Recipes.init();

		// Initialize/Register Achievements
		if (Config.achievements)
			ExtraPlanets_Achievements.init();

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	public static void registerBlockJson(String texturePrefix, Block block, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}

	public static void registerBlockJson(String texturePrefix, Block block) {
		registerBlockJson(texturePrefix, block, 0, block.getUnlocalizedName().substring(5));
	}

	private void registerBlockRenderers() {
		// Planets
		for (BlockBasicMercury.EnumBlockBasic blockBasic : BlockBasicMercury.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.mercuryBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicVenus.EnumBlockBasic blockBasic : BlockBasicVenus.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.venusBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicCeres.EnumBlockBasic blockBasic : BlockBasicCeres.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ceresBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicJupiter.EnumBlockBasic blockBasic : BlockBasicJupiter.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.jupiterBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicSaturn.EnumBlockBasic blockBasic : BlockBasicSaturn.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.saturnBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicUranus.EnumBlockBasic blockBasic : BlockBasicUranus.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.uranusBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicNeptune.EnumBlockBasic blockBasic : BlockBasicNeptune.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.neptuneBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicPluto.EnumBlockBasic blockBasic : BlockBasicPluto.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.plutoBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicEris.EnumBlockBasic blockBasic : BlockBasicEris.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.erisBlocks, blockBasic.getMeta(), blockBasic.getName());
		}

		// Moons
		for (BlockBasicCallisto.EnumBlockBasic blockBasic : BlockBasicCallisto.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.callistoBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicDeimos.EnumBlockBasic blockBasic : BlockBasicDeimos.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.deimosBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicEuropa.EnumBlockBasic blockBasic : BlockBasicEuropa.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.europaBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicGanymede.EnumBlockBasic blockBasic : BlockBasicGanymede.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ganymedeBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicIo.EnumBlockBasic blockBasic : BlockBasicIo.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.ioBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicPhobos.EnumBlockBasic blockBasic : BlockBasicPhobos.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.phobosBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicRhea.EnumBlockBasic blockBasic : BlockBasicRhea.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.rheaBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicTitan.EnumBlockBasic blockBasic : BlockBasicTitan.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.titanBlocks, blockBasic.getMeta(), blockBasic.getName());
		}
		for (BlockBasicTriton.EnumBlockBasic blockBasic : BlockBasicTriton.EnumBlockBasic.values()) {
			registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.tritonBlocks, blockBasic.getMeta(), blockBasic.getName());
		}

		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier4);
		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier5);
		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier6);
		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier7);
		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier8);
		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier9);
		registerBlockJson(Constants.TEXTURE_PREFIX, ExtraPlanets_Blocks.treasureChestTier10);

	}

	private void registerNonMobEntities() {
		// registerExtraPlanetsNonMobEntity(EntityNuclearBombPrimed.class,
		// Constants.modName + "NuclearBombPrimed", 150, 1, true);
		if (Config.venus)
			registerExtraPlanetsNonMobEntity(EntityTier4Rocket.class, Constants.modName + "EntityTier4Rocket", 150, 1, false);
		if (Config.jupiter)
			registerExtraPlanetsNonMobEntity(EntityTier5Rocket.class, Constants.modName + "EntityTier5Rocket", 150, 1, false);
		if (Config.saturn)
			registerExtraPlanetsNonMobEntity(EntityTier6Rocket.class, Constants.modName + "EntityTier6Rocket", 150, 1, false);
		if (Config.uranus)
			registerExtraPlanetsNonMobEntity(EntityTier7Rocket.class, Constants.modName + "EntityTier7Rocket", 150, 1, false);
		if (Config.neptune)
			registerExtraPlanetsNonMobEntity(EntityTier8Rocket.class, Constants.modName + "EntityTier8Rocket", 150, 1, false);
		if (Config.pluto)
			registerExtraPlanetsNonMobEntity(EntityTier9Rocket.class, Constants.modName + "EntityTier9Rocket", 150, 1, false);
		if (Config.eris)
			registerExtraPlanetsNonMobEntity(EntityTier10Rocket.class, Constants.modName + "EntityTier10Rocket", 150, 1, false);
	}

	private void registerCreatures() {
		// // Dungeon Bosses
		// if (Config.venus)
		// if (Config.useDefaultBosses)
		// registerExtraPlanetsCreature(EntityCreeperBossVenus.class,"CreeperBossVenus",
		// 894731, 0);
		// else
		// registerExtraPlanetsCreature(EntityEvolvedMagmaCubeBoss.class,Constants.modName
		// + "EvolvedMagmaCubeBoss", 3407872, 16579584);
		// if (Config.jupiter)
		// registerExtraPlanetsCreature(EntityCreeperBossJupiter.class,Constants.modName
		// + "CreeperBossJupiter", 894731, 0);
		// if (Config.saturn)
		// registerExtraPlanetsCreature(EntityCreeperBossSaturn.class,Constants.modName
		// + "CreeperBossSaturn", 894731, 0);
		// if (Config.uranus)
		// if (Config.useDefaultBosses)
		// registerExtraPlanetsCreature(EntityCreeperBossUranus.class,"CreeperBossUranus",
		// 894731, 0);
		// else
		// registerExtraPlanetsCreature(EntityEvolvedIceSlimeBoss.class,Constants.modName
		// + "EntityEvolvedIceSlimeBoss", 16382457, 44975);
		// if (Config.neptune)
		// registerExtraPlanetsCreature(EntityCreeperBossNeptune.class,Constants.modName
		// + "CreeperBossNeptune", 894731, 0);
		// if (Config.pluto)
		// registerExtraPlanetsCreature(EntityCreeperBossPluto.class,Constants.modName
		// + "CreeperBossPluto", 894731, 0);
		// if (Config.eris)
		// registerExtraPlanetsCreature(EntityCreeperBossEris.class,Constants.modName
		// + "CreeperBossEris", 894731, 0);

		// // Entities
		// registerExtraPlanetsCreature(EntityEvolvedMagmaCube.class,Constants.modName
		// + "EvolvedMagmaCube", 3407872, 16579584);
		// registerExtraPlanetsCreature(EntityEvolvedIceSlime.class,
		// Constants.modName + "EvolvedIceSlime", 16382457, 44975);

		// registerExtraPlanetsCreature(EvolvedIceBlaze.class,"EvolvedIceBlaze",3407872,
		// 16579584);
		// registerExtraPlanetsCreature(EntityEvolvedWitch.class,Constants.modName
		// + "EvolvedWitch", 3407872, 5349438);
		// registerExtraPlanetsCreature(EntityEvolvedEnderman.class,Constants.modName
		// + "EvolvedEnderman", 1447446, 0);
		// registerExtraPlanetsCreature(EntityEvolvedBlaze.class,Constants.modName
		// + "EvolvedBlaze", 16167425, 16775294);
		// registerExtraPlanetsCreature(EntityBlueCreeper.class,Constants.modName
		// + "EvolvedBlueCreeper", 44975, 0);
		// registerExtraPlanetsCreature(EntityEvolvedRedCreeper.class,Constants.modName
		// + "EvolvedRedCreeper", 11013646, 0);
		// registerExtraPlanetsCreature(EntityEvolvedPowerSkeleton.class,Constants.modName
		// + "EvolvedPowerSkeleton", 12698049, 4802889);
		// registerExtraPlanetsCreature(EntityEvolvedGiantSpider.class,Constants.modName
		// + "EvolvedGiantSpider", 12698049, 4802889);
		// registerExtraPlanetsCreature(EntityEvolvedMiniEnderman.class,Constants.modName
		// + "EvolvedMiniEnderman", 1447446, 0);
	}

	private void registerSchematicsRecipes() {
		if (Config.venus)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier4Rocket());
		if (Config.jupiter)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier5Rocket());
		if (Config.saturn)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier6Rocket());
		if (Config.uranus)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier7Rocket());
		if (Config.neptune)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier8Rocket());
		if (Config.pluto)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier9Rocket());
		if (Config.eris)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier10Rocket());
	}

	private void addDungeonLoot() {
		if (Config.venus)
			GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.schematicTier4, 1, 0));
		if (Config.jupiter)
			GalacticraftRegistry.addDungeonLoot(5, new ItemStack(ExtraPlanets_Items.schematicTier5, 1, 0));
		if (Config.saturn)
			GalacticraftRegistry.addDungeonLoot(6, new ItemStack(ExtraPlanets_Items.schematicTier6, 1, 0));
		if (Config.uranus)
			GalacticraftRegistry.addDungeonLoot(7, new ItemStack(ExtraPlanets_Items.schematicTier7, 1, 0));
		if (Config.neptune)
			GalacticraftRegistry.addDungeonLoot(8, new ItemStack(ExtraPlanets_Items.schematicTier8, 1, 0));
		if (Config.pluto)
			GalacticraftRegistry.addDungeonLoot(9, new ItemStack(ExtraPlanets_Items.schematicTier9, 1, 0));
		if (Config.eris)
			GalacticraftRegistry.addDungeonLoot(10, new ItemStack(ExtraPlanets_Items.schematicTier10, 1, 0));
	}

	public static void registerExtraPlanetsNonMobEntity(Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		EntityRegistry.registerModEntity(var0, var1, GCCoreUtil.nextInternalID(), ExtraPlanets.instance, trackingDistance, updateFreq, sendVel);
	}

	public void registerExtraPlanetsCreature(Class<? extends Entity> var0, String var1, int back, int fore) {
		EntityRegistry.registerModEntity(var0, var1, GCCoreUtil.nextInternalID(), ExtraPlanets.instance, 80, 3, true);
	}

}
