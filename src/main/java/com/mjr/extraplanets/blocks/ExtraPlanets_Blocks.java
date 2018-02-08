package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
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
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicVenus;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bPlanks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bTallGrass;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves2;
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
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockCustomLandingPad;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDecorativeBlocks;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDecorativeBlocks2;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockCallisto;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockCeres;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockDeimos;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockEris;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockEuropa;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockGanymede;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockIapetus;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockIo;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockJupiter;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockKepler22b;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockMercury;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockNeptune;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockOberon;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockPhobos;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockPluto;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockRhea;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockSaturn;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockTitan;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockTitania;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockTriton;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockUranus;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.ItemBlockVenus;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLeaf;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLeaf2;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLog;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLog2;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleSapling;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bPlanks;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bTallGrass;
import com.mjr.extraplanets.planets.Eris.worldgen.dungeon.DungeonSpawnerEris;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.DungeonSpawnerJuptier;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.DungeonSpawnerNeptune;
import com.mjr.extraplanets.planets.Pluto.worldgen.dungeon.DungeonSpawnerPluto;
import com.mjr.extraplanets.planets.Saturn.worldgen.dungeon.DungeonSpawnerSaturn;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.DungeonSpawnerUranus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.DungeonSpawnerVenus;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerEris;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerJupiter;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerPluto;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerUranus;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerVenus;
import com.mjr.extraplanets.tileEntities.machines.TileEntityPoweredChargingPad;
import com.mjr.extraplanets.tileEntities.machines.TileEntityPoweredChargingPadSingle;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier2LandingPad;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier2LandingPadSingle;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier3LandingPad;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier3LandingPadSingle;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT9TreasureChest;
import com.mjr.extraplanets.util.RegisterHelper;

import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Block kepler22bInfectedGrass;

	public static Block callistoBlocks;
	public static Block deimosBlocks;
	public static Block europaBlocks;
	public static Block ioBlocks;
	public static Block phobosBlocks;
	public static Block tritonBlocks;
	public static Block ganymedeBlocks;
	public static Block rheaBlocks;
	public static Block titanBlocks;
	public static Block oberonBlocks;
	public static Block titaniaBlocks;
	public static Block iapetusBlocks;

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
	public static Block oberonGravel;
	public static Block titaniaGravel;
	public static Block iapetusGravel;

	// Other Special Blocks
	public static Block nuclearBomb;
	public static Block fireBomb;
	public static Block fossil;
	public static Block denseIce;
	public static Block volcanicRock;
	public static Block frozenNitrogen;
	public static Block ashBlock;

	// Treasure Chests
	public static Block treasureChestTier4;
	public static Block treasureChestTier5;
	public static Block treasureChestTier6;
	public static Block treasureChestTier7;
	public static Block treasureChestTier8;
	public static Block treasureChestTier9;
	public static Block treasureChestTier10;

	// Dungeon Bricks
	public static Block veunsDungeonBrick;
	public static Block jupiterDungeonBrick;
	public static Block saturnDungeonBrick;
	public static Block uranusDungeonBrick;
	public static Block neptuneDungeonBrick;
	public static Block plutoDungeonBrick;
	public static Block erisDungeonBrick;

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
	public static Block kepler22bMapleLeaf2;

	// Flowers
	public static Block kepler22bGrassFlowers;

	// Planks
	public static Block kepler22bPlanks;

	public static Block advancedLaunchPad;
	public static Block advancedLaunchPadFull;

	public static Block decorativeBlocks;
	public static Block decorativeBlocks2;

	public static Block redSand;
	public static Block redSandstone;

	public static Block orangeSand;
	public static Block orangeSandstone;

	public static Block slimeBlock;

	public static Block diamondGrit;
	public static Block goldGrit;
	public static Block ironGrit;
	public static Block coalGrit;
	public static Block emeraldGrit;

	public static void init() {
		initializeBlocks();
		initializeTreasureChestBlocks();
		initializeDungeonBlocks();
		initializeSpawnerBlocks();
		registerBlocks();
		registerTileEntitys();
		setHarvestLevels();
		if (Config.oreDictionary)
			OreDictionaryRegister();
		if (Config.kepler22b && Config.keplerSolarSystems) {
			initializeTreeBlocks();
			registerTreeBlocks();
		}
	}

	private static void initializeBlocks() {
		if (Config.mercury) {
			mercuryBlocks = new BlockBasicMercury("mercury");
			mercuryGravel = new BlockCustomGravel("mercury_gravel");
		}
		if (Config.venus) {
			venusBlocks = new BlockBasicVenus("venus");
			venusGravel = new BlockCustomGravel("venus_gravel");
			ashBlock = new BlockBasic(Material.rock).setBlockName("ash_rock").setHardness(2.0F).setResistance(1.5F).setBlockTextureName(Constants.TEXTURE_PREFIX + "ash_rock");
			volcanicRock = new BlockBasic(Material.rock).setBlockName("volcanic_rock").setBlockTextureName(Constants.TEXTURE_PREFIX + "volcanic_rock").setHardness(3.0F).setResistance(6.0F).setStepSound(Block.soundTypeStone);
		}
		if (Config.ceres) {
			ceresBlocks = new BlockBasicCeres("ceres");
			ceresGravel = new BlockCustomGravel("ceres_gravel");
		}
		if (Config.jupiter) {
			jupiterBlocks = new BlockBasicJupiter("jupiter");
			jupiterGravel = new BlockCustomGravel("jupiter_gravel");
			orangeSand = new BlockSand("orange_sand").setHardness(0.6F);
			orangeSandstone = new BlockBasic(Material.rock).setBlockName("orange_sandstone").setHardness(2F).setResistance(2F).setBlockTextureName(Constants.TEXTURE_PREFIX + "orange_sandstone");
		}
		if (Config.saturn) {
			saturnBlocks = new BlockBasicSaturn("saturn");
			saturnGravel = new BlockCustomGravel("saturn_gravel");
		}
		if (Config.uranus) {
			uranusBlocks = new BlockBasicUranus("uranus");
			denseIce = new BlockBasic(Material.ice).setBlockName("dense_ice").setBlockTextureName(Constants.TEXTURE_PREFIX + "dense_ice").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeSnow);
		}
		if (Config.neptune) {
			neptuneBlocks = new BlockBasicNeptune("neptune");
			frozenNitrogen = new BlockBasic(Material.ice).setBlockName("frozen_nitrogen").setBlockTextureName(Constants.TEXTURE_PREFIX + "frozen_nitrogen").setStepSound(Block.soundTypeSnow);
		}
		if (Config.pluto) {
			plutoBlocks = new BlockBasicPluto("pluto");
			plutoGravel = new BlockCustomGravel("pluto_gravel");
		}
		if (Config.eris) {
			erisBlocks = new BlockBasicEris("eris");
			erisGravel = new BlockCustomGravel("eris_gravel");
		}
		if (Config.europa) {
			europaBlocks = new BlockBasicEuropa("europa");
			europaGravel = new BlockCustomGravel("europa_gravel");
		}
		if (Config.io) {
			ioBlocks = new BlockBasicIo("io");
			ioGravel = new BlockCustomGravel("io_gravel");
		}
		if (Config.deimos) {
			deimosBlocks = new BlockBasicDeimos("deimos");
			deimosGravel = new BlockCustomGravel("deimos_gravel");
		}
		if (Config.phobos) {
			phobosBlocks = new BlockBasicPhobos("phobos");
			phobosGravel = new BlockCustomGravel("phobos_gravel");
		}
		if (Config.triton) {
			tritonBlocks = new BlockBasicTriton("triton");
			tritonGravel = new BlockCustomGravel("triton_gravel");
		}
		if (Config.callisto) {
			callistoBlocks = new BlockBasicCallisto("callisto");
			callistoGravel = new BlockCustomGravel("callisto_gravel");
		}
		if (Config.ganymede) {
			ganymedeBlocks = new BlockBasicGanymede("ganymede");
			ganymedeGravel = new BlockCustomGravel("ganymede_gravel");
		}
		if (Config.rhea) {
			rheaBlocks = new BlockBasicRhea("rhea");
			rheaGravel = new BlockCustomGravel("rhea_gravel");
		}
		if (Config.titan) {
			titanBlocks = new BlockBasicTitan("titan");
			titanGravel = new BlockCustomGravel("titan_gravel");
		}
		if (Config.oberon) {
			oberonBlocks = new BlockBasicOberon("oberon");
			oberonGravel = new BlockCustomGravel("oberon_gravel");
		}
		if (Config.titania) {
			titaniaBlocks = new BlockBasicTitania("titania");
			titaniaGravel = new BlockCustomGravel("titania_gravel");
		}
		if (Config.iapetus) {
			iapetusBlocks = new BlockBasicIapetus("iapetus");
			iapetusGravel = new BlockCustomGravel("iapetus_gravel");
		}
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			fossil = new BlockFossil(Material.rock).setBlockName("fossil").setBlockTextureName(Constants.TEXTURE_PREFIX + "fossil").setHardness(2.5F).setResistance(1.0F);
		if (Config.ceres && Config.nuclearBomb)
			nuclearBomb = new BlockNuclearBomb();
		if (Config.saturn && Config.fireBomb)
			fireBomb = new BlockFireBomb();
		if (Config.kepler22b && Config.keplerSolarSystems) {
			kepler22bBlocks = new BlockBasicKepler22b("kepler22b");
			kepler22bGrass = new BlockBasicGrass("kepler22b", "kepler22b");
			kepler22bBlueGrass = new BlockBasicGrass("kepler22b_blue", "kepler22b");
			kepler22bPurpleGrass = new BlockBasicGrass("kepler22b_purple", "kepler22b");
			kepler22bRedGrass = new BlockBasicGrass("kepler22b_red", "kepler22b");
			kepler22bYellowGrass = new BlockBasicGrass("kepler22b_yellow", "kepler22b");
			kepler22bInfectedGrass = new BlockBasicGrass("kepler22b_infected", "kepler22b");
			kepler22bGrassFlowers = new BlockBasicKepler22bTallGrass("kepler22b_flowers");
			redSand = new BlockSand("red_sand").setHardness(0.6F);
			redSandstone = new BlockBasic(Material.rock).setBlockName("red_sandstone").setBlockTextureName(Constants.TEXTURE_PREFIX + "red_sandstone").setHardness(2F).setResistance(2F);
		}
		advancedLaunchPad = new BlockCustomLandingPad("advanced_launch_pad");
		advancedLaunchPadFull = new BlockCustomLandingPadFull("advanced_launch_pad_full");

		decorativeBlocks = new BlockDecorativeBlocks("decorative_blocks");
		decorativeBlocks2 = new BlockDecorativeBlocks2("decorative_blocks2");

		slimeBlock = new BlockSlime("slime_block");

		diamondGrit = new BlockCustomGravel("diamond_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		goldGrit = new BlockCustomGravel("gold_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		ironGrit = new BlockCustomGravel("iron_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		coalGrit = new BlockCustomGravel("coal_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		emeraldGrit = new BlockCustomGravel("emerald_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
	}

	private static void initializeDungeonBlocks() {
		if (Config.venus) {
			veunsDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("veuns.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "veuns_dungeon_brick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			veunsDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2
		}
		if (Config.jupiter) {
			jupiterDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("jupiter.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiter_dungeon_brick").setHardness(4.0F).setResistance(40.0F)
					.setStepSound(Block.soundTypeMetal);
			jupiterDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.saturn) {
			saturnDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("saturn.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturn_dungeon_brick").setHardness(4.0f).setResistance(40.0F)
					.setStepSound(Block.soundTypeMetal);
			saturnDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.uranus) {
			uranusDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("uranus.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "uranus_dungeon_brick").setHardness(4.0F).setResistance(40.0F)
					.setStepSound(Block.soundTypeMetal);
			uranusDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.neptune) {
			neptuneDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("neptune.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptune_dungeon_brick").setHardness(4.0F).setResistance(40.0F)
					.setStepSound(Block.soundTypeMetal);
			neptuneDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.pluto) {
			plutoDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("pluto.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "pluto_dungeon_brick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			plutoDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
		if (Config.eris) {
			erisDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("eris.dungeon_brick").setBlockTextureName(Constants.TEXTURE_PREFIX + "eris_dungeon_brick").setHardness(4.0F).setResistance(40.0F).setStepSound(Block.soundTypeMetal);
			erisDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
		}
	}

	private static void initializeTreasureChestBlocks() {
		if (Config.venus) {
			treasureChestTier4 = new T4TreasureChest("treasure_chest_t4");
		}
		if (Config.jupiter) {
			treasureChestTier5 = new T5TreasureChest("treasure_chest_t5");
		}
		if (Config.saturn) {
			if (Config.morePlanetsCompatibilityAdv)
				treasureChestTier6 = new T6TreasureChest("treasure_chest_t4_saturn");
			else
				treasureChestTier6 = new T6TreasureChest("treasure_chest_t6");
		}
		if (Config.uranus) {
			if (Config.morePlanetsCompatibilityAdv)
				treasureChestTier7 = new T7TreasureChest("treasure_chest_t4_uranus");
			else
				treasureChestTier7 = new T7TreasureChest("treasure_chest_t7");
		}
		if (Config.neptune) {
			if (Config.morePlanetsCompatibilityAdv)
				treasureChestTier8 = new T8TreasureChest("treasure_chest_t5_neptune");
			else
				treasureChestTier8 = new T8TreasureChest("treasure_chest_t8");
		}
		if (Config.pluto) {
			treasureChestTier9 = new T9TreasureChest("treasure_chest_t9");
		}
		if (Config.eris) {
			if (Config.morePlanetsCompatibilityAdv)
				treasureChestTier10 = new T10TreasureChest("treasure_chest_t6_eris");
			else
				treasureChestTier10 = new T10TreasureChest("treasure_chest_t10");
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
		kepler22bMapleLog = new BlockKepler22bMapleTreeLog("kepler22b_maple_logs");
		kepler22bMapleLog2 = new BlockKepler22bMapleTreeLog2("kepler22b_maple_logs2");
		kepler22bMapleSapling = new BlockKepler22bMapleTreeSapling("kepler22b_maple_saplings");
		kepler22bMapleLeaf = new BlockKepler22bMapleTreeLeaves("kepler22b_new_maple_leaves");
		kepler22bMapleLeaf2 = new BlockKepler22bMapleTreeLeaves2("kepler22b_new_maple_leaves_2");
		kepler22bPlanks = new BlockBasicKepler22bPlanks("kepler22b_planks");
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
			GameRegistry.registerBlock(treasureChestTier4, ItemBlockDesc.class, "tile.treasureChestT4");

			GameRegistry.registerBlock(ashBlock, "ashBlock");
			GameRegistry.registerBlock(volcanicRock, "volcanicRock");
		}
		if (Config.ceres) {
			GameRegistry.registerBlock(ceresBlocks, ItemBlockCeres.class, ceresBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(ceresGravel, "ceresGravel");
		}
		if (Config.jupiter) {
			GameRegistry.registerBlock(jupiterBlocks, ItemBlockJupiter.class, jupiterBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(jupiterGravel, "jupiterGravel");

			GameRegistry.registerBlock(orangeSand, "orangeSand");
			GameRegistry.registerBlock(orangeSandstone, "orangeSandstone");

			GameRegistry.registerBlock(jupiterSpawner, "jupiterSpawner");
			GameRegistry.registerBlock(jupiterDungeonBrick, "jupiterDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier5, ItemBlockDesc.class, "tile.treasureChestT5");
		}
		if (Config.saturn) {
			GameRegistry.registerBlock(saturnBlocks, ItemBlockSaturn.class, saturnBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(saturnGravel, "saturnGravel");

			GameRegistry.registerBlock(saturnSpawner, "saturnSpawner");
			GameRegistry.registerBlock(saturnDungeonBrick, "saturnDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier6, ItemBlockDesc.class, "tile.treasureChestT6");
		}
		if (Config.uranus) {
			GameRegistry.registerBlock(uranusBlocks, ItemBlockUranus.class, uranusBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(uranusSpawner, "uranusSpawner");
			GameRegistry.registerBlock(uranusDungeonBrick, "uranusDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier7, ItemBlockDesc.class, "tile.treasureChestT7");
			GameRegistry.registerBlock(denseIce, "denseIce");
		}
		if (Config.neptune) {
			GameRegistry.registerBlock(neptuneBlocks, ItemBlockNeptune.class, neptuneBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(neptuneSpawner, "neptuneSpawner");
			GameRegistry.registerBlock(neptuneDungeonBrick, "neptuneDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier8, ItemBlockDesc.class, "tile.treasureChestT8");
			GameRegistry.registerBlock(frozenNitrogen, "frozenNitrogen");
		}
		if (Config.pluto) {
			GameRegistry.registerBlock(plutoBlocks, ItemBlockPluto.class, plutoBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(plutoSpawner, "plutoSpawner");
			GameRegistry.registerBlock(plutoDungeonBrick, "plutoDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier9, ItemBlockDesc.class, "tile.treasureChestT9");
			GameRegistry.registerBlock(plutoGravel, "plutoGravel");
		}
		if (Config.eris) {
			GameRegistry.registerBlock(erisBlocks, ItemBlockEris.class, erisBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(erisSpawner, "erisSpawner");
			GameRegistry.registerBlock(erisDungeonBrick, "erisDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier10, ItemBlockDesc.class, "tile.treasureChestT10");
			GameRegistry.registerBlock(erisGravel, "erisGravel");
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			GameRegistry.registerBlock(kepler22bBlocks, ItemBlockKepler22b.class, kepler22bBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(kepler22bGrass, "kepler22bGrass");
			GameRegistry.registerBlock(kepler22bBlueGrass, "kepler22bBlueGrass");
			GameRegistry.registerBlock(kepler22bPurpleGrass, "kepler22bPurpleGrass");
			GameRegistry.registerBlock(kepler22bRedGrass, "kepler22bRedGrass");
			GameRegistry.registerBlock(kepler22bYellowGrass, "kepler22bYellowGrass");
			GameRegistry.registerBlock(kepler22bInfectedGrass, "kepler22bInfectedGrass");
			GameRegistry.registerBlock(kepler22bGrassFlowers, ItemBlockKepler22bTallGrass.class, "tile.kepler22bFlowers");
			GameRegistry.registerBlock(redSand, "redSand");
			GameRegistry.registerBlock(redSandstone, "redSandstone");
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
		if (Config.oberon) {
			GameRegistry.registerBlock(oberonBlocks, ItemBlockOberon.class, oberonBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(oberonGravel, "oberonGravel");
		}
		if (Config.titania) {
			GameRegistry.registerBlock(titaniaBlocks, ItemBlockTitania.class, titaniaBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(titaniaGravel, "titaniaGravel");
		}
		if (Config.iapetus) {
			GameRegistry.registerBlock(iapetusBlocks, ItemBlockIapetus.class, iapetusBlocks.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(iapetusGravel, "iapetusGravel");
		}
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			GameRegistry.registerBlock(fossil, "fossil");
		if (Config.ceres && Config.nuclearBomb)
			GameRegistry.registerBlock(nuclearBomb, "nuclearBomb");
		if (Config.saturn && Config.fireBomb)
			GameRegistry.registerBlock(fireBomb, "fireBomb");

		GameRegistry.registerBlock(advancedLaunchPad, ItemBlockCustomLandingPad.class, "tile.advancedLaunchPad");
		GameRegistry.registerBlock(advancedLaunchPadFull, ItemBlockGC.class, "tile.advancedLaunchPadFull");

		GameRegistry.registerBlock(decorativeBlocks, ItemBlockDecorativeBlocks.class, "tile.decorativeBlocks");
		GameRegistry.registerBlock(decorativeBlocks2, ItemBlockDecorativeBlocks2.class, "tile.decorativeBlocks2");

		GameRegistry.registerBlock(slimeBlock, "slimeBlock");

		GameRegistry.registerBlock(diamondGrit, diamondGrit.getUnlocalizedName());
		GameRegistry.registerBlock(goldGrit, goldGrit.getUnlocalizedName());
		GameRegistry.registerBlock(ironGrit, ironGrit.getUnlocalizedName());
		GameRegistry.registerBlock(coalGrit, coalGrit.getUnlocalizedName());
		GameRegistry.registerBlock(emeraldGrit, emeraldGrit.getUnlocalizedName());
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

			if (Config.morePlanetsCompatibilityAdv)
				GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 4 Saturn Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 6 Treasure Chest");
		}
		if (Config.uranus) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerUranus.class, Constants.modName + "Uranus Dungeon Spawner");

			if (Config.morePlanetsCompatibilityAdv)
				GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 4 Uranus Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 7 Treasure Chest");
		}
		if (Config.neptune) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerNeptune.class, Constants.modName + "Neptune Dungeon Spawner");

			if (Config.morePlanetsCompatibilityAdv)
				GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 5 Neptune Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 8 Treasure Chest");
		}
		if (Config.pluto) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerPluto.class, Constants.modName + "Pluto Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT9TreasureChest.class, Constants.modName + "Tier 9 Treasure Chest");
		}
		if (Config.eris) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerEris.class, Constants.modName + "Eris Dungeon Spawner");
			if (Config.morePlanetsCompatibilityAdv)
				GameRegistry.registerTileEntity(TileEntityT10TreasureChest.class, Constants.modName + "Tier 6 Eris Treasure Chest");
			else
				GameRegistry.registerTileEntity(TileEntityT10TreasureChest.class, Constants.modName + "Tier 10 Treasure Chest");
		}
		GameRegistry.registerTileEntity(TileEntityTier2LandingPadSingle.class, "Tier 2 Landing Pad");
		GameRegistry.registerTileEntity(TileEntityTier2LandingPad.class, "Tier 2 Landing Pad Full");

		GameRegistry.registerTileEntity(TileEntityTier3LandingPadSingle.class, "Tier 3 Landing Pad");
		GameRegistry.registerTileEntity(TileEntityTier3LandingPad.class, "Tier 3 Landing Pad Full");

		GameRegistry.registerTileEntity(TileEntityPoweredChargingPadSingle.class, "Powered Charging Pad");
		GameRegistry.registerTileEntity(TileEntityPoweredChargingPad.class, "Powered Charging Pad Full");
	}

	private static void setHarvestLevels() {
		if (Config.mercury) {
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 2, 6); // Mercury Ore
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 1, 7); // Stone Bricks
			RegisterHelper.setHarvestLevel(mercuryBlocks, "pickaxe", 1, 8); // Mercury Block
		}
		if (Config.venus) {
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 2, 6); // Carbon Ore
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 1, 7); // Carbon Block
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 1, 8); // Stone Bricks
			RegisterHelper.setHarvestLevel(venusBlocks, "pickaxe", 1, 9); // Titanium Block
		}
		if (Config.ceres) {
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 2, 6); // Uranium Ore
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 1, 7); // Stone Bricks
			RegisterHelper.setHarvestLevel(ceresBlocks, "pickaxe", 1, 8); // Uranium Block
		}
		if (Config.jupiter) {
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 2, 6); // Palladium Ore
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 2, 6); // Nickel Ore
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 1, 9); // Palladium Block
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 1, 9); // Stone Bricks
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 2, 10); // Red Gem Ore
			RegisterHelper.setHarvestLevel(jupiterBlocks, "pickaxe", 1, 11); // Red Gem Block
		}
		if (Config.saturn) {
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 2, 6); // Magnesium Ore
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 1, 7); // Magnesium Block
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 1, 9); // Broken Infected Stone
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 1, 10); // Infected Stone
			RegisterHelper.setHarvestLevel(saturnBlocks, "pickaxe", 2, 11); // Slime Ore
		}
		if (Config.uranus) {
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 2, 3); // Crystal Ore
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 1, 4); // Crystal Block
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 1, 5); // Stone Bricks
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 2, 7); // White Gem Ore
			RegisterHelper.setHarvestLevel(uranusBlocks, "pickaxe", 1, 8); // White Gem Block
		}
		if (Config.neptune) {
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 2, 6); // Zinc Ore
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 1, 7); // Zinc Block
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 1, 8); // Stone Bricks
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 2, 9); // Blue Gem Ore
			RegisterHelper.setHarvestLevel(neptuneBlocks, "pickaxe", 1, 10); // Blue Gem Block
		}
		if (Config.pluto) {
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 2, 6); // Tungsten Ore
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 1, 7); // Tungsten Block
			RegisterHelper.setHarvestLevel(plutoBlocks, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.eris) {
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 2, 6); // Dark Iron Ore
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 1, 7); // Dark Iron Block
			RegisterHelper.setHarvestLevel(erisBlocks, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.kepler22b) {
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "shovel", 0, 0); // Dirt
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 1, 1); // Stone
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 2); // Iron Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 3); // Tin Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 4); // Copper Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 5); // Dense Coal Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 6); // Blue Diamond Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 7); // Red Diamond Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 8); // Purple Diamond Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 9); // Yellow Diamond Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 10); // Green Diamond Ore
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 1, 11); // Stone Bricks
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 1, 12); // Cobblestone
			RegisterHelper.setHarvestLevel(kepler22bBlocks, "pickaxe", 2, 13); // Platinum Ore
		}
		if (Config.callisto) {
			RegisterHelper.setHarvestLevel(callistoBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(callistoBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(callistoBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(callistoBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(callistoBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(callistoBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.deimos) {
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(deimosBlocks, "pickaxe", 2, 6); // Lead Ore
		}
		if (Config.europa) {
			RegisterHelper.setHarvestLevel(europaBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(europaBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(europaBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(europaBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(europaBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(europaBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.ganymede) {
			RegisterHelper.setHarvestLevel(ganymedeBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(ganymedeBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(ganymedeBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(ganymedeBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(ganymedeBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(ganymedeBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.io) {
			RegisterHelper.setHarvestLevel(ioBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(ioBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(ioBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(ioBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(ioBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(ioBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.phobos) {
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(phobosBlocks, "pickaxe", 2, 6); // Lead Ore
		}
		if (Config.rhea) {
			RegisterHelper.setHarvestLevel(rheaBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(rheaBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(rheaBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(rheaBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(rheaBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(rheaBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.titan) {
			RegisterHelper.setHarvestLevel(titanBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(titanBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(titanBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(titanBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(titanBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(titanBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.triton) {
			RegisterHelper.setHarvestLevel(tritonBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(tritonBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(tritonBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(tritonBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(tritonBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(tritonBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.iapetus) {
			RegisterHelper.setHarvestLevel(iapetusBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(iapetusBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(iapetusBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(iapetusBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(iapetusBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(iapetusBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.oberon) {
			RegisterHelper.setHarvestLevel(oberonBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(oberonBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(oberonBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(oberonBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(oberonBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(oberonBlocks, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.titania) {
			RegisterHelper.setHarvestLevel(titaniaBlocks, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(titaniaBlocks, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(titaniaBlocks, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(titaniaBlocks, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(titaniaBlocks, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(titaniaBlocks, "pickaxe", 2, 5); // Copper Ore
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
			OreDictionary.registerOre("blockUranium", new ItemStack(ceresBlocks, 1, 8));
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
			OreDictionary.registerOre("blockNickel", new ItemStack(jupiterBlocks, 1, 12));
		}
		if (Config.saturn) {
			OreDictionary.registerOre("oreCopper", new ItemStack(saturnBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(saturnBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(saturnBlocks, 1, 3));
			OreDictionary.registerOre("oreMagnesium", new ItemStack(saturnBlocks, 1, 6));
			OreDictionary.registerOre("blockMagnesium", new ItemStack(saturnBlocks, 1, 7));
			OreDictionary.registerOre("oreSlime", new ItemStack(saturnBlocks, 1, 11));
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
			OreDictionary.registerOre("oreDarkIron", new ItemStack(erisBlocks, 1, 7));
			OreDictionary.registerOre("blockDarkIron", new ItemStack(erisBlocks, 1, 8));
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
			OreDictionary.registerOre("oreLead", new ItemStack(deimosBlocks, 1, 6));
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
			OreDictionary.registerOre("oreLead", new ItemStack(phobosBlocks, 1, 6));
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
		if (Config.oberon) {
			OreDictionary.registerOre("oreCopper", new ItemStack(oberonBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(oberonBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(oberonBlocks, 1, 3));
		}
		if (Config.iapetus) {
			OreDictionary.registerOre("oreCopper", new ItemStack(iapetusBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(iapetusBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(iapetusBlocks, 1, 3));
		}
		if (Config.titania) {
			OreDictionary.registerOre("oreCopper", new ItemStack(titaniaBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(titaniaBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(titaniaBlocks, 1, 3));
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
			OreDictionary.registerOre("cobblestone", new ItemStack(kepler22bBlocks, 1, 12));
			OreDictionary.registerOre("orePlatinum", new ItemStack(kepler22bBlocks, 1, 13));
			OreDictionary.registerOre("blockPlatinum", new ItemStack(kepler22bBlocks, 1, 14));
		}
	}

	private static void registerTreeBlocks() {
		GameRegistry.registerBlock(kepler22bMapleLog, ItemBlockKepler22bMapleLog.class, "tile.kepler22bMapleLogs");
		GameRegistry.registerBlock(kepler22bMapleLog2, ItemBlockKepler22bMapleLog2.class, "tile.kepler22bMapleLogs2");
		GameRegistry.registerBlock(kepler22bMapleSapling, ItemBlockKepler22bMapleSapling.class, "tile.kepler22bMapleSaplings");
		GameRegistry.registerBlock(kepler22bMapleLeaf, ItemBlockKepler22bMapleLeaf.class, "tile.kepler22bNewMapleLeaves");
		GameRegistry.registerBlock(kepler22bMapleLeaf2, ItemBlockKepler22bMapleLeaf2.class, "tile.kepler22bNewMapleLeaves2");
		GameRegistry.registerBlock(kepler22bPlanks, ItemBlockKepler22bPlanks.class, "tile.kepler22bPlanks");
	}
}
