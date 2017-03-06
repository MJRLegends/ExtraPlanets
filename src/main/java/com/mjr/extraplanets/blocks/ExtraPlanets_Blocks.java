package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCeres;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicDeimos;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEris;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEuropa;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicGanymede;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIo;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicJupiter;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicKepler22b;
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
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bPlanks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bTallGrass;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog2;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeSapling;
import com.mjr.extraplanets.blocks.treasureChest.T10TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T4TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T5TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T6TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T7TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T8TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T9TreasureChest;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockCallisto;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockCeres;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockDeimos;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockEris;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockEuropa;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockGanymede;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockIo;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockJupiter;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockKepler22b;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockMercury;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockNeptune;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockPhobos;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockPluto;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockRhea;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockSaturn;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockTitan;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockTriton;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockUranus;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockVenus;
import com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b.ItemBlockKepler22bMapleLeaf;
import com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b.ItemBlockKepler22bMapleLog;
import com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b.ItemBlockKepler22bMapleLog2;
import com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b.ItemBlockKepler22bMapleSapling;
import com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b.ItemBlockKepler22bPlanks;
import com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b.ItemBlockKepler22bTallGrass;
import com.mjr.extraplanets.planets.Eris.worldgen.dungeon.DungeonSpawnerEris;
import com.mjr.extraplanets.planets.Eris.worldgen.dungeon.TileEntityDungeonSpawnerEris;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.DungeonSpawnerJuptier;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.TileEntityDungeonSpawnerJupiter;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.DungeonSpawnerNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.planets.Pluto.worldgen.dungeon.DungeonSpawnerPluto;
import com.mjr.extraplanets.planets.Pluto.worldgen.dungeon.TileEntityDungeonSpawnerPluto;
import com.mjr.extraplanets.planets.Saturn.worldgen.dungeon.DungeonSpawnerSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.dungeon.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.DungeonSpawnerUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.TileEntityDungeonSpawnerUranus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.DungeonSpawnerVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.TileEntityDungeonSpawnerVenus;
import com.mjr.extraplanets.tile.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT9TreasureChest;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Blocks {
	
	//Planet Blocks
	public static Block mercuryBlocks;
	public static Block ceresBlocks;
	public static Block erisBlocks;

	public static Block venusBlocks;
	public static Block jupiterBlocks;
	public static Block saturnBlocks;
	public static Block uranusBlocks;
	public static Block neptuneBlocks;
	public static Block plutoBlocks;

	public static Block kepler22bBlocks;
	public static Block kepler22bGrass;
	public static Block kepler22bBlueGrass;
	public static Block kepler22bPurpleGrass;
	public static Block kepler22bRedGrass;
	public static Block kepler22bYellowGrass;
	
	public static Block callistoBlocks;
	public static Block deimosBlocks;
	public static Block europaBlocks;
	public static Block ioBlocks;
	public static Block phobosBlocks;
	public static Block tritonBlocks;
	public static Block ganymedeBlocks;
	public static Block rheaBlocks;
	public static Block titanBlocks;

	// Gravels
	public static Block mercuryGravel;
	public static Block venusGravel;
	public static Block ceresGravel;
	public static Block jupiterGravel;
	public static Block saturnGravel;
	public static Block plutoGravel;
	public static Block erisGravel;

	public static Block ioGravel;
	public static Block europaGravel;
	public static Block deimosGravel;
	public static Block phobosGravel;
	public static Block tritonGravel;
	public static Block ganymedeGravel;
	public static Block callistoGravel;
	public static Block rheaGravel;
	public static Block titanGravel;

	// Other Special Blocks
	public static Block nuclearBomb;
	public static Block fossil;
	public static Block denseIce;
	public static Block volcanicRock;
	public static Block frozenNitrogen;

	// Treasure Chests
	public static Block treasureChestTier4;
	public static Block treasureChestTier5;
	public static Block treasureChestTier6;
	public static Block treasureChestTier7;
	public static Block treasureChestTier8;
	public static Block treasureChestTier9;
	public static Block treasureChestTier10;

	// Need changing to meta blocks -----------------------------------------
	
	//Dungeon Bricks
	public static Block veunsDungeonBrick;
	public static Block jupiterDungeonBrick;
	public static Block saturnDungeonBrick;
	public static Block uranusDungeonBrick;
	public static Block neptuneDungeonBrick;
	public static Block plutoDungeonBrick;
	public static Block erisDungeonBrick;

	//Dungeon Spawners
	public static Block venusSpawner;
	public static Block jupiterSpawner;
	public static Block saturnSpawner;
	public static Block uranusSpawner;
	public static Block neptuneSpawner;
	public static Block plutoSpawner;
	public static Block erisSpawner;
	
	//Logs
	public static Block kepler22bMapleLog;
	public static Block kepler22bMapleLog2;

	//Saplings
	public static Block kepler22bMapleSapling;
	
	//Leaves
	public static Block kepler22bMapleLeaf;	
	
	//Flowers
	public static Block kepler22bGrassFlowers;
	
	//Planks
	public static Block kepler22bPlanks;

	// -----------------------------------------------------------------------

	public static void init() {
		initializeBlocks();
		initializeTreasureChestBlocks();

		// Need changing to meta blocks at some point
		// -----------------------------------------
		initializeDungeonBlocks();
		initializeSpawnerBlocks();
		// ----------------------------------------------------------------------

		registerBlocks();
		registerTileEntitys();
		if(Config.oreDictionary)
			OreDictionaryRegister();
		if(Config.kepler22b && Config.keplerSolarSystems){
			initializeTreeBlocks();
			registerTreeBlocks();
		}
	}

	private static void initializeBlocks() {
		if (Config.mercury) {
			mercuryBlocks = new BlockBasicMercury("mercury");
			mercuryGravel = new BlockCustomGravel("mercuryGravel");
		}
		if (Config.venus) {
			venusBlocks = new BlockBasicVenus("venus");
			venusGravel = new BlockCustomGravel("venusGravel");

			volcanicRock = new BlockBasic(Material.rock).setBlockName("volcanicRock").setBlockTextureName(Constants.TEXTURE_PREFIX + "volcanicRock").setHardness(3.0F).setResistance(6.0F).setStepSound(Block.soundTypeStone);
		}
		if (Config.ceres) {
			ceresBlocks = new BlockBasicCeres("ceres");
			ceresGravel = new BlockCustomGravel("ceresGravel");
		}
		if (Config.jupiter) {
			jupiterBlocks = new BlockBasicJupiter("jupiter");
			jupiterGravel = new BlockCustomGravel("jupiterGravel");
		}
		if (Config.saturn) {
			saturnBlocks = new BlockBasicSaturn("saturn");
			saturnGravel = new BlockCustomGravel("saturnGravel");
		}
		if (Config.uranus) {
			uranusBlocks = new BlockBasicUranus("uranus");
			denseIce = new BlockBasic(Material.ice).setBlockName("denseIce").setBlockTextureName(Constants.TEXTURE_PREFIX + "denseIce").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeSnow);
		}
		if (Config.neptune) {
			neptuneBlocks = new BlockBasicNeptune("neptune");
			frozenNitrogen = new BlockBasic(Material.ice).setBlockName("frozenNitrogen").setBlockTextureName(Constants.TEXTURE_PREFIX + "frozenNitrogen").setStepSound(Block.soundTypeSnow);
		}
		if (Config.pluto) {
			plutoBlocks = new BlockBasicPluto("pluto");
			plutoGravel = new BlockCustomGravel("plutoGravel");
		}
		if (Config.eris) {
			erisBlocks = new BlockBasicEris("eris");
			erisGravel = new BlockCustomGravel("erisGravel");
		}
		if (Config.europa) {
			europaBlocks = new BlockBasicEuropa("europa");
			europaGravel = new BlockCustomGravel("europaGravel");
		}
		if (Config.io) {
			ioBlocks = new BlockBasicIo("io");
			ioGravel = new BlockCustomGravel("ioGravel");
		}
		if (Config.deimos) {
			deimosBlocks = new BlockBasicDeimos("deimos");
			deimosGravel = new BlockCustomGravel("deimosGravel");
		}
		if (Config.phobos) {
			phobosBlocks = new BlockBasicPhobos("phobos");
			phobosGravel = new BlockCustomGravel("phobosGravel");
		}
		if (Config.triton) {
			tritonBlocks = new BlockBasicTriton("triton");
			tritonGravel = new BlockCustomGravel("tritonGravel");
		}
		if (Config.callisto) {
			callistoBlocks = new BlockBasicCallisto("callisto");
			callistoGravel = new BlockCustomGravel("callistoGravel");
		}
		if (Config.ganymede) {
			ganymedeBlocks = new BlockBasicGanymede("ganymede");
			ganymedeGravel = new BlockCustomGravel("ganymedeGravel");
		}
		if (Config.rhea) {
			rheaBlocks = new BlockBasicRhea("rhea");
			rheaGravel = new BlockCustomGravel("rheaGravel");
		}
		if (Config.titan) {
			titanBlocks = new BlockBasicTitan("titan");
			titanGravel = new BlockCustomGravel("titanGravel");
		}

		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			fossil = new BlockFossil(Material.rock).setBlockName("fossil").setBlockTextureName(Constants.TEXTURE_PREFIX + "fossil").setHardness(2.5F).setResistance(1.0F);
		if (Config.ceres)
			nuclearBomb = new BlockNuclearBomb();
		if(Config.kepler22b && Config.keplerSolarSystems){
			kepler22bBlocks = new BlockBasicKepler22b("kepler22b");
			kepler22bGrass = new BlockBasicGrass("kepler22b", "kepler22b");
			kepler22bBlueGrass = new BlockBasicGrass("kepler22b_blue", "kepler22b");
			kepler22bPurpleGrass = new BlockBasicGrass("kepler22b_purple", "kepler22b");
			kepler22bRedGrass = new BlockBasicGrass("kepler22b_red", "kepler22b");
			kepler22bYellowGrass = new BlockBasicGrass("kepler22b_yellow", "kepler22b");
			kepler22bGrassFlowers = new BlockBasicKepler22bTallGrass("kepler22bFlowers");
		}
	}

	private static void initializeDungeonBlocks() {
		if (Config.venus) {
			veunsDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("veunsDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "veunsDungeonBrick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			veunsDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2
		}
		if (Config.jupiter) {
			jupiterDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("jupiterDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterDungeonBrick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			jupiterDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.saturn) {
			saturnDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("saturnDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnDungeonBrick").setHardness(4.0f).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			saturnDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.uranus) {
			uranusDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("uranusDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusDungeonBrick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			uranusDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.neptune) {
			neptuneDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("neptuneDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneDungeonBrick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			neptuneDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.pluto) {
			plutoDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("plutoDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoDungeonBrick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			plutoDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.eris) {
			erisDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("erisDungeonBrick").setBlockTextureName(Constants.TEXTURE_PREFIX + "erisDungeonBrick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			erisDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
	}

	private static void initializeTreasureChestBlocks() {
		if (Config.venus) {
			treasureChestTier4 = new T4TreasureChest("treasureChestT4");
		}
		if (Config.jupiter) {
			treasureChestTier5 = new T5TreasureChest("treasureChestT5");
		}
		if (Config.saturn) {
			if(Config.morePlanetsCompatibility)
				treasureChestTier6 = new T6TreasureChest("treasureChestT4Saturn");
			else
				treasureChestTier6 = new T6TreasureChest("treasureChestT6");
		}
		if (Config.uranus) {
			if(Config.morePlanetsCompatibility)
				treasureChestTier7 = new T7TreasureChest("treasureChestT4Uranus");
			else
				treasureChestTier7 = new T7TreasureChest("treasureChestT7");
		}
		if (Config.neptune) {
			if(Config.morePlanetsCompatibility)
				treasureChestTier8 = new T8TreasureChest("treasureChestT5");
			else
				treasureChestTier8 = new T8TreasureChest("treasureChestT8");
		}
		if (Config.pluto) {
			treasureChestTier9 = new T9TreasureChest("treasureChestT9");
		}
		if (Config.eris) {
			if(Config.morePlanetsCompatibility)
				treasureChestTier10 = new T10TreasureChest("treasureChestT6");
			else
				treasureChestTier10 = new T10TreasureChest("treasureChestT10");
		}
	}

	private static void initializeSpawnerBlocks() {
		if (Config.venus) {
			venusSpawner = new DungeonSpawnerVenus();
		}
		if (Config.jupiter) {
			jupiterSpawner = new DungeonSpawnerJuptier();
		}
		if (Config.saturn) {
			saturnSpawner = new DungeonSpawnerSaturn();
		}
		if (Config.uranus) {
			uranusSpawner = new DungeonSpawnerUranus();
		}
		if (Config.neptune) {
			neptuneSpawner = new DungeonSpawnerNeptune();
		}
		if (Config.pluto) {
			plutoSpawner = new DungeonSpawnerPluto();
		}
		if (Config.eris) {
			erisSpawner = new DungeonSpawnerEris();
		}
	}
	
	private static void initializeTreeBlocks() {
		kepler22bMapleLog = new BlockKepler22bMapleTreeLog("kepler22bMapleLogs");
		kepler22bMapleLog2 = new BlockKepler22bMapleTreeLog2("kepler22bMapleLogs2");
		kepler22bMapleSapling = new BlockKepler22bMapleTreeSapling("kepler22bMapleSaplings");
		kepler22bMapleLeaf = new BlockKepler22bMapleTreeLeaves("kepler22bMapleLeaves");
		kepler22bPlanks = new BlockBasicKepler22bPlanks("kepler22bPlanks");
	}

	private static void registerBlocks() {
		if (Config.mercury) {
			GameRegistry.registerBlock(mercuryBlocks, ItemBlockMercury.class, mercuryBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(mercuryGravel, "mercuryGravel");
		}
		if (Config.venus) {
			GameRegistry.registerBlock(venusBlocks, ItemBlockVenus.class, venusBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(venusGravel, "venusGravel");

			GameRegistry.registerBlock(venusSpawner, "venusSpawner");
			GameRegistry.registerBlock(veunsDungeonBrick, "veunsDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier4, ItemBlockDesc.class, treasureChestTier4.getUnlocalizedName());
			GameRegistry.registerBlock(volcanicRock, "volcanicRock");
		}
		if (Config.ceres) {
			GameRegistry.registerBlock(ceresBlocks, ItemBlockCeres.class, ceresBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(ceresGravel, "ceresGravel");
		}
		if (Config.jupiter) {
			GameRegistry.registerBlock(jupiterBlocks, ItemBlockJupiter.class, jupiterBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(jupiterGravel, "jupiterGravel");

			GameRegistry.registerBlock(jupiterSpawner, "jupiterSpawner");
			GameRegistry.registerBlock(jupiterDungeonBrick, "jupiterDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier5, ItemBlockDesc.class, treasureChestTier5.getUnlocalizedName());
		}
		if (Config.saturn) {
			GameRegistry.registerBlock(saturnBlocks, ItemBlockSaturn.class, saturnBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(saturnGravel, "saturnGravel");

			GameRegistry.registerBlock(saturnSpawner, "saturnSpawner");
			GameRegistry.registerBlock(saturnDungeonBrick, "saturnDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier6, ItemBlockDesc.class, treasureChestTier6.getUnlocalizedName());
		}
		if (Config.uranus) {
			GameRegistry.registerBlock(uranusBlocks, ItemBlockUranus.class, uranusBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(uranusSpawner, "uranusSpawner");
			GameRegistry.registerBlock(uranusDungeonBrick, "uranusDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier7, ItemBlockDesc.class, treasureChestTier7.getUnlocalizedName());
			GameRegistry.registerBlock(denseIce, "denseIce");
		}
		if (Config.neptune) {
			GameRegistry.registerBlock(neptuneBlocks, ItemBlockNeptune.class, neptuneBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(neptuneSpawner, "neptuneSpawner");
			GameRegistry.registerBlock(neptuneDungeonBrick, "neptuneDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier8, ItemBlockDesc.class, treasureChestTier8.getUnlocalizedName());
			GameRegistry.registerBlock(frozenNitrogen, "frozenNitrogen");
		}
		if (Config.pluto) {
			GameRegistry.registerBlock(plutoBlocks, ItemBlockPluto.class, plutoBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(plutoSpawner, "plutoSpawner");
			GameRegistry.registerBlock(plutoDungeonBrick, "plutoDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier9, ItemBlockDesc.class, treasureChestTier9.getUnlocalizedName());
			GameRegistry.registerBlock(plutoGravel, "plutoGravel");
		}
		if (Config.eris) {
			GameRegistry.registerBlock(erisBlocks, ItemBlockEris.class, erisBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(erisSpawner, "erisSpawner");
			GameRegistry.registerBlock(erisDungeonBrick, "erisDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier10, ItemBlockDesc.class, treasureChestTier10.getUnlocalizedName());
			GameRegistry.registerBlock(erisGravel, "erisGravel");
		}
		if(Config.kepler22b && Config.keplerSolarSystems){
			GameRegistry.registerBlock(kepler22bBlocks, ItemBlockKepler22b.class, kepler22bBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(kepler22bGrass, "kepler22bGrass");
			GameRegistry.registerBlock(kepler22bBlueGrass, "kepler22bBlueGrass");
			GameRegistry.registerBlock(kepler22bPurpleGrass, "kepler22bPurpleGrass");
			GameRegistry.registerBlock(kepler22bRedGrass, "kepler22bRedGrass");
			GameRegistry.registerBlock(kepler22bYellowGrass, "kepler22bYellowGrass");
			GameRegistry.registerBlock(kepler22bGrassFlowers, ItemBlockKepler22bTallGrass.class, kepler22bGrassFlowers.getUnlocalizedName());
		}

		if (Config.europa) {
			GameRegistry.registerBlock(europaBlocks, ItemBlockEuropa.class, europaBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(europaGravel, "europaGravel");
		}
		if (Config.io) {
			GameRegistry.registerBlock(ioBlocks, ItemBlockIo.class, ioBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(ioGravel, "ioGravel");
		}
		if (Config.deimos) {
			GameRegistry.registerBlock(deimosBlocks, ItemBlockDeimos.class, deimosBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(deimosGravel, "deimosGravel");
		}
		if (Config.phobos) {
			GameRegistry.registerBlock(phobosBlocks, ItemBlockPhobos.class, phobosBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(phobosGravel, "phobosGravel");
		}
		if (Config.triton) {
			GameRegistry.registerBlock(tritonBlocks, ItemBlockTriton.class, tritonBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(tritonGravel, "tritonGravel");
		}
		if (Config.callisto) {
			GameRegistry.registerBlock(callistoBlocks, ItemBlockCallisto.class, callistoBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(callistoGravel, "callistoGravel");
		}
		if (Config.ganymede) {
			GameRegistry.registerBlock(ganymedeBlocks, ItemBlockGanymede.class, ganymedeBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(ganymedeGravel, "ganymedeGravel");
		}
		if (Config.rhea) {
			GameRegistry.registerBlock(rheaBlocks, ItemBlockRhea.class, rheaBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(rheaGravel, "rheaGravel");
		}
		if (Config.titan) {
			GameRegistry.registerBlock(titanBlocks, ItemBlockTitan.class, titanBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(titanGravel, "titanGravel");
		}
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			GameRegistry.registerBlock(fossil, "fossil");
		if (Config.ceres)
			GameRegistry.registerBlock(nuclearBomb, "nuclearBomb");
	}

	private static void registerTileEntitys() {
		if (Config.venus) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerVenus.class, Constants.modName + "Veuns Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT4TreasureChest.class, Constants.modName + "Tier 4 Treasure Chest");
		}
		if (Config.jupiter) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerJupiter.class, Constants.modName + "Juptier Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT5TreasureChest.class, Constants.modName + "Tier 5 Treasure Chest");
		}
		if (Config.saturn) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerSaturn.class, Constants.modName + "Saturn Dungeon Spawner");
			
			if(Config.morePlanetsCompatibility)
				GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 4 Saturn Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 6 Treasure Chest");
		}
		if (Config.uranus) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerUranus.class, Constants.modName + "Uranus Dungeon Spawner");
			
			if(Config.morePlanetsCompatibility)
				GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 4 Uranus Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 7 Treasure Chest");
		}
		if (Config.neptune) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerNeptune.class, Constants.modName + "Neptune Dungeon Spawner");
			
			if(Config.morePlanetsCompatibility)
				GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 5 Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 8 Treasure Chest");
		}
		if (Config.pluto) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerPluto.class, Constants.modName + "Pluto Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT9TreasureChest.class, Constants.modName + "Tier 9 Treasure Chest");
		}
		if (Config.eris) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerEris.class, Constants.modName + "Eris Dungeon Spawner");
			if(Config.morePlanetsCompatibility)
				GameRegistry.registerTileEntity(TileEntityT10TreasureChest.class, Constants.modName + "Tier 6 Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT10TreasureChest.class, Constants.modName + "Tier 10 Treasure Chest");
		}
	}

	public static void OreDictionaryRegister() {
		if (Config.mercury) {
			OreDictionary.registerOre("oreCopper", new ItemStack(mercuryBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(mercuryBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(mercuryBlocks, 1, 3));
			OreDictionary.registerOre("oreMercury", new ItemStack(mercuryBlocks, 1, 6));
		}
		if (Config.venus) {
			OreDictionary.registerOre("oreCopper", new ItemStack(venusBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(venusBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(venusBlocks, 1, 3));
			OreDictionary.registerOre("oreCarbon", new ItemStack(venusBlocks, 1, 6));
			OreDictionary.registerOre("blockCarbon", new ItemStack(venusBlocks, 1, 7));
		}
		if (Config.ceres) {
			OreDictionary.registerOre("oreCopper", new ItemStack(ceresBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(ceresBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(ceresBlocks, 1, 3));
			OreDictionary.registerOre("oreUranium", new ItemStack(ceresBlocks, 1, 6));
		}
		if (Config.jupiter) {
			OreDictionary.registerOre("oreCopper", new ItemStack(jupiterBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(jupiterBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(jupiterBlocks, 1, 3));
			OreDictionary.registerOre("orePalladium", new ItemStack(jupiterBlocks, 1, 6));
			OreDictionary.registerOre("oreNickel", new ItemStack(jupiterBlocks, 1, 7));
			OreDictionary.registerOre("oreRedGem", new ItemStack(jupiterBlocks, 1, 10));
			OreDictionary.registerOre("blockPalladium", new ItemStack(jupiterBlocks, 1, 8));
			OreDictionary.registerOre("blockRedGem", new ItemStack(jupiterBlocks, 1, 11));
		}
		if (Config.saturn) {
			OreDictionary.registerOre("oreCopper", new ItemStack(saturnBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(saturnBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(saturnBlocks, 1, 3));
			OreDictionary.registerOre("oreMagnesium", new ItemStack(saturnBlocks, 1, 6));
			OreDictionary.registerOre("blockMagnesium", new ItemStack(saturnBlocks, 1, 7));
		}
		if (Config.uranus) {
			OreDictionary.registerOre("oreCrystal", new ItemStack(uranusBlocks, 1, 3));
			OreDictionary.registerOre("oreWhiteGem", new ItemStack(uranusBlocks, 1, 6));
			OreDictionary.registerOre("blockCrystal", new ItemStack(uranusBlocks, 1, 4));
			OreDictionary.registerOre("blockWhiteGem", new ItemStack(uranusBlocks, 1, 7));
		}
		if (Config.neptune) {
			OreDictionary.registerOre("oreCopper", new ItemStack(neptuneBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(neptuneBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(neptuneBlocks, 1, 3));
			OreDictionary.registerOre("oreZinc", new ItemStack(neptuneBlocks, 1, 6));	
			OreDictionary.registerOre("oreBlueGem", new ItemStack(neptuneBlocks, 1, 9));
			OreDictionary.registerOre("blockZinc", new ItemStack(neptuneBlocks, 1, 7));
			OreDictionary.registerOre("blockBlueGem", new ItemStack(neptuneBlocks, 1, 10));
		}
		if (Config.pluto) {
			OreDictionary.registerOre("oreCopper", new ItemStack(plutoBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(plutoBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(plutoBlocks, 1, 3));
			OreDictionary.registerOre("oreTungsten", new ItemStack(plutoBlocks, 1, 6));
			OreDictionary.registerOre("blockTungsten", new ItemStack(plutoBlocks, 1, 7));
		}
		if (Config.eris) {
			OreDictionary.registerOre("oreCopper", new ItemStack(erisBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(erisBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(erisBlocks, 1, 3));
		}
		if (Config.callisto) {
			OreDictionary.registerOre("oreCopper", new ItemStack(callistoBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(callistoBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(callistoBlocks, 1, 3));
		}
		if (Config.deimos) {
			OreDictionary.registerOre("oreCopper", new ItemStack(deimosBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(deimosBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(deimosBlocks, 1, 3));
		}
		if (Config.europa) {
			OreDictionary.registerOre("oreCopper", new ItemStack(europaBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(europaBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(europaBlocks, 1, 3));
		}
		if (Config.ganymede) {
			OreDictionary.registerOre("oreCopper", new ItemStack(ganymedeBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(ganymedeBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(ganymedeBlocks, 1, 3));
		}
		if (Config.io) {
			OreDictionary.registerOre("oreCopper", new ItemStack(ioBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(ioBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(ioBlocks, 1, 3));
		}
		if (Config.phobos) {
			OreDictionary.registerOre("oreCopper", new ItemStack(phobosBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(phobosBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(phobosBlocks, 1, 3));
		}
		if (Config.rhea) {
			OreDictionary.registerOre("oreCopper", new ItemStack(rheaBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(rheaBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(rheaBlocks, 1, 3));
		}
		if (Config.titan) {
			OreDictionary.registerOre("oreCopper", new ItemStack(titanBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(titanBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(titanBlocks, 1, 3));
		}
		if (Config.triton) {
			OreDictionary.registerOre("oreCopper", new ItemStack(tritonBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(tritonBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(tritonBlocks, 1, 3));
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			OreDictionary.registerOre("stone", new ItemStack(kepler22bBlocks, 1, 1));
			OreDictionary.registerOre("oreIron", new ItemStack(kepler22bBlocks, 1, 2));
			OreDictionary.registerOre("oreCopper", new ItemStack(kepler22bBlocks, 1, 3));
			OreDictionary.registerOre("oreTin", new ItemStack(kepler22bBlocks, 1, 4));
			OreDictionary.registerOre("oreDenseCoal", new ItemStack(kepler22bBlocks, 1, 5));
			OreDictionary.registerOre("oreBlueDiamond", new ItemStack(kepler22bBlocks, 1, 6));
			OreDictionary.registerOre("oreRedDiamond", new ItemStack(kepler22bBlocks, 1, 7));
			OreDictionary.registerOre("orePurpleDiamond", new ItemStack(kepler22bBlocks, 1, 8));
			OreDictionary.registerOre("oreYellowDiamond", new ItemStack(kepler22bBlocks, 1, 9));
			OreDictionary.registerOre("oreGreenDiamond", new ItemStack(kepler22bBlocks, 1, 10));
			OreDictionary.registerOre("cobblestone", new ItemStack(kepler22bBlocks, 1, 16));
		}
	}
	
	private static void registerTreeBlocks() {
		GameRegistry.registerBlock(kepler22bMapleLog, ItemBlockKepler22bMapleLog.class, kepler22bMapleLog.getUnlocalizedName());
		GameRegistry.registerBlock(kepler22bMapleLog2, ItemBlockKepler22bMapleLog2.class, kepler22bMapleLog2.getUnlocalizedName());
		GameRegistry.registerBlock(kepler22bMapleSapling, ItemBlockKepler22bMapleSapling.class, kepler22bMapleSapling.getUnlocalizedName());
		GameRegistry.registerBlock(kepler22bMapleLeaf, ItemBlockKepler22bMapleLeaf.class, kepler22bMapleLeaf.getUnlocalizedName());
		GameRegistry.registerBlock(kepler22bPlanks, ItemBlockKepler22bPlanks.class, kepler22bPlanks.getUnlocalizedName());
	}
}
