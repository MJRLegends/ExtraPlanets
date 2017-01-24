package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockErisDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockJupiterDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockNeptuneDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockPlutoDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockSaturnDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockUranusDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockVenusDungeonSpawner;
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
import com.mjr.extraplanets.tile.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT9TreasureChest;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerEris;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerJupiter;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerPluto;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerUranus;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerVenus;

public class ExtraPlanets_Blocks {

	// Planet Blocks
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

	// Dungeon Spawners
	public static Block venusSpawner;
	public static Block jupiterSpawner;
	public static Block saturnSpawner;
	public static Block uranusSpawner;
	public static Block neptuneSpawner;
	public static Block plutoSpawner;
	public static Block erisSpawner;

	// Logs
	public static Block kepler22bMapleLog;
	public static Block kepler22bMapleLog2;

	// Saplings
	public static Block kepler22bMapleSapling;

	// Leaves
	public static Block kepler22bMapleLeaf;

	// Flowers
	public static Block kepler22bGrassFlowers;

	// Planks
	public static Block kepler22bPlanks;

	public static void init() {
		initializeBlocks();
		initializeTreasureChestBlocks();

		// Need changing to meta blocks at some point
		// -----------------------------------------
		initializeSpawnerBlocks();
		// ----------------------------------------------------------------------

		registerBlocks();
		registerTileEntitys();
		if (Config.oreDictionary)
			OreDictionaryRegister();
		if (Config.kepler22b) {
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

			volcanicRock = new BlockBasic(Material.rock).setUnlocalizedName("volcanicRock").setHardness(3.0F).setResistance(6.0F).setStepSound(Block.soundTypeStone);
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
			denseIce = new BlockBasic(Material.ice).setUnlocalizedName("denseIce").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeSnow);
		}
		if (Config.neptune) {
			neptuneBlocks = new BlockBasicNeptune("neptune");
			frozenNitrogen = new BlockBasic(Material.ice).setUnlocalizedName("frozenNitrogen").setStepSound(Block.soundTypeSnow);
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
			fossil = new BlockFossil(Material.rock).setUnlocalizedName("fossil").setHardness(2.5F).setResistance(1.0F);
		if (Config.ceres)
			nuclearBomb = new BlockNuclearBomb();
		if (Config.kepler22b) {
//			 kepler22bBlocks = new BlockBasicKepler22b("kepler22b");
//			 kepler22bGrass = new BlockBasicGrass("kepler22b", "kepler22b");
//			 kepler22bBlueGrass = new BlockBasicGrass("kepler22b_blue",
//			 "kepler22b");
//			 kepler22bPurpleGrass = new BlockBasicGrass("kepler22b_purple",
//			 "kepler22b");
//			 kepler22bRedGrass = new BlockBasicGrass("kepler22b_red",
//			 "kepler22b");
//			 kepler22bYellowGrass = new BlockBasicGrass("kepler22b_yellow",
//			 "kepler22b");
//			 kepler22bGrassFlowers = newBlockBasicKepler22bTallGrass("kepler22bFlowers");
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
			treasureChestTier6 = new T6TreasureChest("treasureChestT6");
		}
		if (Config.uranus) {
			treasureChestTier7 = new T7TreasureChest("treasureChestT7");
		}
		if (Config.neptune) {
			treasureChestTier8 = new T8TreasureChest("treasureChestT8");
		}
		if (Config.pluto) {
			treasureChestTier9 = new T9TreasureChest("treasureChestT9");
		}
		if (Config.eris) {
			treasureChestTier10 = new T10TreasureChest("treasureChestT10");
		}
	}

	private static void initializeSpawnerBlocks() {
		if (Config.venus) {
			venusSpawner = new BlockVenusDungeonSpawner("bossSpawnerVenus");
		}
		if (Config.jupiter) {
			jupiterSpawner = new BlockJupiterDungeonSpawner("bossSpawnerVenus");
		}
		if (Config.saturn) {
			saturnSpawner = new BlockSaturnDungeonSpawner("bossSpawnerSaturn");
		}
		if (Config.uranus) {
			uranusSpawner = new BlockUranusDungeonSpawner("bossSpawnerUranus");
		}
		if (Config.neptune) {
			neptuneSpawner = new BlockNeptuneDungeonSpawner("bossSpawnerNeptune");
		}
		if (Config.pluto) {
			plutoSpawner = new BlockPlutoDungeonSpawner("bossSpawnerPluto");
		}
		if (Config.eris) {
			erisSpawner = new BlockErisDungeonSpawner("bossSpawnerEris");
		}
	}

	private static void initializeTreeBlocks() {
		// kepler22bMapleLog = new
		// BlockKepler22bMapleTreeLog("kepler22bMapleLogs");
		// kepler22bMapleLog2 = new
		// BlockKepler22bMapleTreeLog2("kepler22bMapleLogs2");
		// kepler22bMapleSapling = new
		// BlockKepler22bMapleTreeSapling("kepler22bMapleSaplings");
		// kepler22bMapleLeaf = new
		// BlockKepler22bMapleTreeLeaves("kepler22bMapleLeaves");
		// kepler22bPlanks = new BlockBasicKepler22bPlanks("kepler22bPlanks");
	}

	private static void registerBlocks() {
		if (Config.mercury) {
			GameRegistry.registerBlock(mercuryBlocks, ItemBlockMercury.class, mercuryBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(mercuryGravel, "mercuryGravel");
		}
		if (Config.venus) {
			GameRegistry.registerBlock(venusBlocks, ItemBlockVenus.class, venusBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(venusGravel, "venusGravel");

			GameRegistry.registerBlock(venusSpawner, ItemBlockGC.class, "venusSpawner");
			GameRegistry.registerBlock(treasureChestTier4, ItemBlockDesc.class, treasureChestTier4.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(volcanicRock, volcanicRock.getUnlocalizedName().substring(5));
		}
		if (Config.ceres) {
			GameRegistry.registerBlock(ceresBlocks, ItemBlockCeres.class, ceresBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(ceresGravel, "ceresGravel");
		}
		if (Config.jupiter) {
			GameRegistry.registerBlock(jupiterBlocks, ItemBlockJupiter.class, jupiterBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(jupiterGravel, "jupiterGravel");

			GameRegistry.registerBlock(jupiterSpawner, ItemBlockGC.class, "jupiterSpawner");
			GameRegistry.registerBlock(treasureChestTier5, ItemBlockDesc.class, treasureChestTier5.getUnlocalizedName().substring(5));
		}
		if (Config.saturn) {
			GameRegistry.registerBlock(saturnBlocks, ItemBlockSaturn.class, saturnBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(saturnGravel, "saturnGravel");

			GameRegistry.registerBlock(saturnSpawner, ItemBlockGC.class, "saturnSpawner");
			GameRegistry.registerBlock(treasureChestTier6, ItemBlockDesc.class, treasureChestTier6.getUnlocalizedName().substring(5));
		}
		if (Config.uranus) {
			GameRegistry.registerBlock(uranusBlocks, ItemBlockUranus.class, uranusBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(uranusSpawner, ItemBlockGC.class, "uranusSpawner");
			GameRegistry.registerBlock(treasureChestTier7, ItemBlockDesc.class, treasureChestTier7.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(denseIce, denseIce.getUnlocalizedName().substring(5));
		}
		if (Config.neptune) {
			GameRegistry.registerBlock(neptuneBlocks, ItemBlockNeptune.class, neptuneBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(neptuneSpawner, ItemBlockGC.class, "neptuneSpawner");
			GameRegistry.registerBlock(treasureChestTier8, ItemBlockDesc.class, treasureChestTier8.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(frozenNitrogen, frozenNitrogen.getUnlocalizedName().substring(5));
		}
		if (Config.pluto) {
			GameRegistry.registerBlock(plutoBlocks, ItemBlockPluto.class, plutoBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(plutoSpawner, ItemBlockGC.class, "plutoSpawner");
			GameRegistry.registerBlock(treasureChestTier9, ItemBlockDesc.class, treasureChestTier9.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(plutoGravel, "plutoGravel");
		}
		if (Config.eris) {
			GameRegistry.registerBlock(erisBlocks, ItemBlockEris.class, erisBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(erisSpawner, ItemBlockGC.class, "erisSpawner");
			GameRegistry.registerBlock(treasureChestTier10, ItemBlockDesc.class, treasureChestTier10.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(erisGravel, "erisGravel");
		}
		if (Config.kepler22b) {
			// GameRegistry.registerBlock(kepler22bBlocks,
			// ItemBlockKepler22b.class,
			// kepler22bBlocks.getUnlocalizedName().substring(5));
			// GameRegistry.registerBlock(kepler22bGrass, "kepler22bGrass");
			// GameRegistry.registerBlock(kepler22bBlueGrass,
			// "kepler22bBlueGrass");
			// GameRegistry.registerBlock(kepler22bPurpleGrass,
			// "kepler22bPurpleGrass");
			// GameRegistry.registerBlock(kepler22bRedGrass,
			// "kepler22bRedGrass");
			// GameRegistry.registerBlock(kepler22bYellowGrass,
			// "kepler22bYellowGrass");
			// GameRegistry.registerBlock(kepler22bGrassFlowers,
			// ItemBlockKepler22bTallGrass.class,
			// kepler22bGrassFlowers.getUnlocalizedName().substring(5));
		}

		if (Config.europa) {
			GameRegistry.registerBlock(europaBlocks, ItemBlockEuropa.class, europaBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(europaGravel, "europaGravel");
		}
		if (Config.io) {
			GameRegistry.registerBlock(ioBlocks, ItemBlockIo.class, ioBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(ioGravel, "ioGravel");
		}
		if (Config.deimos) {
			GameRegistry.registerBlock(deimosBlocks, ItemBlockDeimos.class, deimosBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(deimosGravel, "deimosGravel");
		}
		if (Config.phobos) {
			GameRegistry.registerBlock(phobosBlocks, ItemBlockPhobos.class, phobosBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(phobosGravel, "phobosGravel");
		}
		if (Config.triton) {
			GameRegistry.registerBlock(tritonBlocks, ItemBlockTriton.class, tritonBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(tritonGravel, "tritonGravel");
		}
		if (Config.callisto) {
			GameRegistry.registerBlock(callistoBlocks, ItemBlockCallisto.class, callistoBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(callistoGravel, "callistoGravel");
		}
		if (Config.ganymede) {
			GameRegistry.registerBlock(ganymedeBlocks, ItemBlockGanymede.class, ganymedeBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(ganymedeGravel, "ganymedeGravel");
		}
		if (Config.rhea) {
			GameRegistry.registerBlock(rheaBlocks, ItemBlockRhea.class, rheaBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(rheaGravel, "rheaGravel");
		}
		if (Config.titan) {
			GameRegistry.registerBlock(titanBlocks, ItemBlockTitan.class, titanBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(titanGravel, "titanGravel");
		}
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			GameRegistry.registerBlock(fossil, fossil.getUnlocalizedName().substring(5));
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
			GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 6 Treasure Chest");
		}
		if (Config.uranus) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerUranus.class, Constants.modName + "Uranus Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 7 Treasure Chest");
		}
		if (Config.neptune) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerNeptune.class, Constants.modName + "Neptune Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 8 Treasure Chest");
		}
		if (Config.pluto) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerPluto.class, Constants.modName + "Pluto Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT9TreasureChest.class, Constants.modName + "Tier 9 Treasure Chest");
		}
		if (Config.eris) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerEris.class, Constants.modName + "Eris Dungeon Spawner");
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
		if (Config.kepler22b) {
			// OreDictionary.registerOre("stone", new ItemStack(kepler22bBlocks,
			// 1, 1));
			// OreDictionary.registerOre("oreIron", new
			// ItemStack(kepler22bBlocks, 1, 2));
			// OreDictionary.registerOre("oreCopper", new
			// ItemStack(kepler22bBlocks, 1, 3));
			// OreDictionary.registerOre("oreTin", new
			// ItemStack(kepler22bBlocks, 1, 4));
			// OreDictionary.registerOre("oreDenseCoal", new
			// ItemStack(kepler22bBlocks, 1, 5));
			// OreDictionary.registerOre("oreBlueDiamond", new
			// ItemStack(kepler22bBlocks, 1, 6));
			// OreDictionary.registerOre("oreRedDiamond", new
			// ItemStack(kepler22bBlocks, 1, 7));
			// OreDictionary.registerOre("orePurpleDiamond", new
			// ItemStack(kepler22bBlocks, 1, 8));
			// OreDictionary.registerOre("oreYellowDiamond", new
			// ItemStack(kepler22bBlocks, 1, 9));
			// OreDictionary.registerOre("oreGreenDiamond", new
			// ItemStack(kepler22bBlocks, 1, 10));
			// OreDictionary.registerOre("cobblestone", new
			// ItemStack(kepler22bBlocks, 1, 16));
		}
	}

	private static void registerTreeBlocks() {
		// GameRegistry.registerBlock(kepler22bMapleLog,
		// ItemBlockKepler22bMapleLog.class,
		// kepler22bMapleLog.getUnlocalizedName().substring(5));
		// GameRegistry.registerBlock(kepler22bMapleLog2,
		// ItemBlockKepler22bMapleLog2.class,
		// kepler22bMapleLog2.getUnlocalizedName().substring(5));
		// GameRegistry.registerBlock(kepler22bMapleSapling,
		// ItemBlockKepler22bMapleSapling.class,
		// kepler22bMapleSapling.getUnlocalizedName().substring(5));
		// GameRegistry.registerBlock(kepler22bMapleLeaf,
		// ItemBlockKepler22bMapleLeaf.class,
		// kepler22bMapleLeaf.getUnlocalizedName().substring(5));
		// GameRegistry.registerBlock(kepler22bPlanks,
		// ItemBlockKepler22bPlanks.class,
		// kepler22bPlanks.getUnlocalizedName().substring(5));
	}
}
