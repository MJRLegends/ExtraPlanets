package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockErisDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockJupiterDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockMercuryDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockNeptuneDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockPlutoDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockSaturnDungeonSpawner;
import com.mjr.extraplanets.blocks.dungeonSpawners.BlockUranusDungeonSpawner;
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
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockCakeBlocks;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockCandyBlocks;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockCandyBlocksHorizontal;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockCustomLandingPad;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDecorativeBlocks;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDecorativeBlocks2;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDummy;
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
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLeaf;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLeaf2;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLog;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleLog2;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bMapleSapling;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bPlanks;
import com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b.ItemBlockKepler22bTallGrass;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityBasicDecontaminationUnitFake;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityPoweredChargingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityPoweredChargingPadSingle;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityRocketChargingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityRocketChargingPadSingle;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier2LandingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier2LandingPadSingle;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier3LandingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier3LandingPadSingle;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerEris;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerErisDefault;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerJupiter;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerJupiterDefault;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerMercury;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerMercuryDefault;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerNeptuneDefault;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerPluto;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerPlutoDefault;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerSaturnDefault;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerUranus;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerUranusDefault;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT9TreasureChest;
import com.mjr.extraplanets.world.WorldGenerationOverworld;
import com.mjr.mjrlegendslib.block.BlockBasic;
import com.mjr.mjrlegendslib.block.BlockBasicGravel;
import com.mjr.mjrlegendslib.block.BlockBasicStairs;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

public class ExtraPlanets_Blocks {

	// Planet Blocks
	public static Block MERCURY_BLOCKS;
	public static Block CERES_BLOCKS;
	public static Block ERIS_BLOCKS;
	public static Block JUPITER_BLOCKS;
	public static Block SATURN_BLOCKS;
	public static Block URANUS_BLOCKS;
	public static Block NEPTUNE_BLOCKS;
	public static Block PLUTO_BLOCKS;
	public static Block KEPLER22B_BLOCKS;

	public static Block CALLISTO_BLOCKS;
	public static Block DEIMOS_BLOCKS;
	public static Block EUROPA_BLOCKS;
	public static Block IO_BLOCKS;
	public static Block PHOBOS_BLOCKS;
	public static Block TRITON_BLOCKS;
	public static Block GANYMEDE_BLOCKS;
	public static Block RHEA_BLOCKS;
	public static Block TITAN_BLOCKS;
	public static Block OBERON_BLOCKS;
	public static Block TITANIA_BLOCKS;
	public static Block IAPETUS_BLOCKS;

	// Gravels
	public static Block MERCURY_GRAVEL;
	public static Block CERES_GRAVEL;
	public static Block JUPITER_GRAVEL;
	public static Block SATURN_GRAVEL;
	public static Block PLUTO_GRAVEL;
	public static Block ERIS_GRAVEL;

	public static Block IO_GRAVEL;
	public static Block EUROPA_GRAVEL;
	public static Block DEIMOS_GRAVEL;
	public static Block PHOBOS_GRAVEL;
	public static Block TRITON_GRAVEL;
	public static Block GANYMEDE_GRAVEL;
	public static Block CALLISTO_GRAVEL;
	public static Block RHEA_GRAVEL;
	public static Block TITAN_GRAVEL;
	public static Block OBERON_GRAVEL;
	public static Block TITANIA_GRAVEL;
	public static Block IAPETUS_GRAVEL;

	// Other Special Blocks
	public static Block NUCLEAR_BOMB;
	public static Block FIRE_BOMB;
	public static Block FOSSIL;
	public static Block DENSE_ICE;
	public static Block VOLCANIC_ROCK;
	public static Block ASH_ROCK;
	public static Block FROZEN_NITROGEN;
	public static Block ORE_LEAD;
	public static Block ORE_POTASH;

	// Treasure Chests
	public static Block TREASURE_CHEST_TIER_4;
	public static Block TREASURE_CHEST_TIER_5;
	public static Block TREASURE_CHEST_TIER_6;
	public static Block TREASURE_CHEST_TIER_7;
	public static Block TREASURE_CHEST_TIER_8;
	public static Block TREASURE_CHEST_TIER_9;
	public static Block TREASURE_CHEST_TIER_10;

	// Dungeon Spawners
	public static Block MERCURY_SPAWNER;
	public static Block JUIPTER_SPAWNER;
	public static Block SATURN_SPAWNER;
	public static Block URANUS_SPAWNER;
	public static Block NEPTUNE_SPAWNER;
	public static Block PLUTO_SPAWNER;
	public static Block ERIS_SPAWNER;

	// Grass
	public static Block KEPLER22B_GRASS_GREEN;
	public static Block KEPLER22B_GRASS_BLUE;
	public static Block KEPLER22B_GRASS_PURPLE;
	public static Block KEPLER22B_GRASS_RED;
	public static Block KEPLER22B_GRASS_YELLOW;
	public static Block KEPLER22B_GRASS_INFECTED;

	// Logs
	public static Block KEPLER22B_MAPLE_LOG;
	public static Block KEPLER22B_MAPLE_LOG_2;

	// Saplings
	public static Block KEPLER22B_MAPLE_SAPLING;

	// Leaves
	public static Block KEPLER22B_MAPLE_LEAF;
	public static Block KEPLER22B_MAPLE_LEAF2;

	// Flowers
	public static Block KEPLER22B_MAPLE_FLOWERS;

	// Planks
	public static Block KEPLER22B_MAPLE_PLANKS;

	public static Block ADVANCED_LAUCHPAD;
	public static Block ADVANCED_LAUCHPAD_FULL;

	public static Block FAKE_BLOCK;

	public static Block DECORATIVE_BLOCKS;
	public static Block DECORATIVE_BLOCKS2;
	public static Block RED_SAND;
	public static Block RED_SANDSTONE;
	public static Block ORANGE_SAND;
	public static Block ORANGE_SANDSTONE;

	// Stairs
	public static Block MERCURY_SURFACE_STAIRS;
	public static Block MERCURY_SUB_SURFACE_STAIRS;
	public static Block MERCURY_STONE_STAIRS;
	public static Block MERCURY_STONE_BRICKS_STAIRS;

	public static Block CERES_SURFACE_STAIRS;
	public static Block CERES_SUB_SURFACE_STAIRS;
	public static Block CERES_STONE_STAIRS;
	public static Block CERES_STONE_BRICKS_STAIRS;

	public static Block JUPITER_SURFACE_STAIRS;
	public static Block JUPITER_SUB_SURFACE_STAIRS;
	public static Block JUPITER_STONE_STAIRS;
	public static Block JUPITER_STONE_BRICKS_STAIRS;

	public static Block SATURN_SURFACE_STAIRS;
	public static Block SATURN_SUB_SURFACE_STAIRS;
	public static Block SATURN_STONE_STAIRS;
	public static Block SATURN_STONE_BRICKS_STAIRS;

	public static Block URANUS_SURFACE_STAIRS;
	public static Block URANUS_SUB_SURFACE_STAIRS;
	public static Block URANUS_STONE_STAIRS;
	public static Block URANUS_STONE_BRICKS_STAIRS;

	public static Block NEPTUNE_SURFACE_STAIRS;
	public static Block NEPTUNE_SUB_SURFACE_STAIRS;
	public static Block NEPTUNE_STONE_STAIRS;
	public static Block NEPTUNE_STONE_BRICKS_STAIRS;

	public static Block PLUTO_SURFACE_STAIRS;
	public static Block PLUTO_SUB_SURFACE_STAIRS;
	public static Block PLUTO_STONE_STAIRS;
	public static Block PLUTO_STONE_BRICKS_STAIRS;

	public static Block ERIS_SURFACE_STAIRS;
	public static Block ERIS_SUB_SURFACE_STAIRS;
	public static Block ERIS_STONE_STAIRS;
	public static Block ERIS_STONE_BRICKS_STAIRS;

	public static Block CANDY_BLOCKS;
	public static Block CANDY_BLOCKS_HORIZONTAL;
	public static Block CAKE_BLOCKS;

	public static BlockWhiteSugerCane WHITE_SUGAR_CANE;

	public static Block DIAMOND_GRIT;
	public static Block GOLD_GRIT;
	public static Block COAL_GRIT;
	public static Block IRON_GRIT;
	public static Block EMERALD_GRIT;

	public static Block FAKE_BLOCK_DECONTAMINATION_UNIT;

	public static void init() {
		initializeBlocks();
		if (Config.SLABS_AND_STAIRS)
			initializeStairs();
		initializeTreasureChestBlocks();
		initializeSpawnerBlocks();
		try {
			registerBlocks();
			if (Config.SLABS_AND_STAIRS)
				registerStairs();
			registerTileEntitys();
			setHarvestLevels();
			if (Config.ORE_DICTIONARY)
				OreDictionaryRegister();
			if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
				initializeTreeBlocks();
				registerTreeBlocks();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	private static void initializeBlocks() {
		if (Config.MERCURY) {
			MERCURY_BLOCKS = new BlockBasicMercury("mercury");
			MERCURY_GRAVEL = new BlockBasicGravel("mercury_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.CERES) {
			CERES_BLOCKS = new BlockBasicCeres("ceres");
			CERES_GRAVEL = new BlockBasicGravel("ceres_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.JUPITER) {
			JUPITER_BLOCKS = new BlockBasicJupiter("jupiter");
			JUPITER_GRAVEL = new BlockBasicGravel("jupiter_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
			VOLCANIC_ROCK = new BlockBasic(Material.ROCK).setUnlocalizedName("volcanic_rock").setHardness(5.0F).setResistance(4.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			ASH_ROCK = new BlockBasic(Material.ROCK).setUnlocalizedName("ash_rock").setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab).setResistance(1.5F).setCreativeTab(ExtraPlanets.BlocksTab);
			ORANGE_SAND = new BlockSand("orange_sand").setHardness(0.6F);
			ORANGE_SANDSTONE = new BlockBasic(Material.ROCK).setUnlocalizedName("orange_sandstone").setHardness(2F).setResistance(2F).setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.SATURN) {
			SATURN_BLOCKS = new BlockBasicSaturn("saturn");
			SATURN_GRAVEL = new BlockBasicGravel("saturn_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.URANUS) {
			URANUS_BLOCKS = new BlockBasicUranus("uranus");
			DENSE_ICE = new BlockBasic(Material.ICE).setUnlocalizedName("dense_ice").setHardness(2.2F).setResistance(3.0F).setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.NEPTUNE) {
			NEPTUNE_BLOCKS = new BlockBasicNeptune("neptune");
			FROZEN_NITROGEN = new BlockBasic(Material.ICE).setUnlocalizedName("frozen_nitrogen").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.PLUTO) {
			PLUTO_BLOCKS = new BlockBasicPluto("pluto");
			PLUTO_GRAVEL = new BlockBasicGravel("pluto_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.ERIS) {
			ERIS_BLOCKS = new BlockBasicEris("eris");
			ERIS_GRAVEL = new BlockBasicGravel("eris_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.EUROPA) {
			EUROPA_BLOCKS = new BlockBasicEuropa("europa");
			EUROPA_GRAVEL = new BlockBasicGravel("europa_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.IO) {
			IO_BLOCKS = new BlockBasicIo("io");
			IO_GRAVEL = new BlockBasicGravel("io_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.DEIMOS) {
			DEIMOS_BLOCKS = new BlockBasicDeimos("deimos");
			DEIMOS_GRAVEL = new BlockBasicGravel("deimos_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.PHOBOS) {
			PHOBOS_BLOCKS = new BlockBasicPhobos("phobos");
			PHOBOS_GRAVEL = new BlockBasicGravel("phobos_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.TRITON) {
			TRITON_BLOCKS = new BlockBasicTriton("triton");
			TRITON_GRAVEL = new BlockBasicGravel("triton_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.CALLISTO) {
			CALLISTO_BLOCKS = new BlockBasicCallisto("callisto");
			CALLISTO_GRAVEL = new BlockBasicGravel("callisto_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.GANYMEDE) {
			GANYMEDE_BLOCKS = new BlockBasicGanymede("ganymede");
			GANYMEDE_GRAVEL = new BlockBasicGravel("ganymede_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.RHEA) {
			RHEA_BLOCKS = new BlockBasicRhea("rhea");
			RHEA_GRAVEL = new BlockBasicGravel("rhea_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.TITAN) {
			TITAN_BLOCKS = new BlockBasicTitan("titan");
			TITAN_GRAVEL = new BlockBasicGravel("titan_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.OBERON) {
			OBERON_BLOCKS = new BlockBasicOberon("oberon");
			OBERON_GRAVEL = new BlockBasicGravel("oberon_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.TITANIA) {
			TITANIA_BLOCKS = new BlockBasicTitania("titania");
			TITANIA_GRAVEL = new BlockBasicGravel("titania_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.IAPETUS) {
			IAPETUS_BLOCKS = new BlockBasicIapetus("iapetus");
			IAPETUS_GRAVEL = new BlockBasicGravel("iapetus_gravel").setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.MERCURY || Config.CERES || Config.PLUTO || Config.ERIS)
			FOSSIL = new BlockFossil(Material.ROCK).setUnlocalizedName("fossil").setHardness(2.5F).setResistance(1.0F);
		if (Config.CERES && Config.NUCLEAR_BOMB)
			NUCLEAR_BOMB = new BlockNuclearBomb().setUnlocalizedName("nuclear_bomb");
		if (Config.SATURN && Config.FIRE_BOMB)
			FIRE_BOMB = new BlockFireBomb().setUnlocalizedName("fire_bomb");
		if (Config.ORE_LEAD_GENERATION)
			ORE_LEAD = new BlockBasic(Material.ROCK).setUnlocalizedName("ore_lead").setHardness(5.0F).setResistance(3.0F).setCreativeTab(ExtraPlanets.BlocksTab);
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			KEPLER22B_BLOCKS = new BlockBasicKepler22b("kepler22b");
			KEPLER22B_GRASS_GREEN = new BlockBasicGrass().setUnlocalizedName("kepler22b_grass");
			KEPLER22B_GRASS_BLUE = new BlockBasicGrass().setUnlocalizedName("kepler22b_blue_grass");
			KEPLER22B_GRASS_PURPLE = new BlockBasicGrass().setUnlocalizedName("kepler22b_purple_grass");
			KEPLER22B_GRASS_RED = new BlockBasicGrass().setUnlocalizedName("kepler22b_red_grass");
			KEPLER22B_GRASS_YELLOW = new BlockBasicGrass().setUnlocalizedName("kepler22b_yellow_grass");
			KEPLER22B_GRASS_INFECTED = new BlockBasicGrass().setUnlocalizedName("kepler22b_infected_grass");
			KEPLER22B_MAPLE_FLOWERS = new BlockBasicKepler22bTallGrass().setUnlocalizedName("kepler22b_flowers");
		}
		if (Config.JUPITER || Config.KEPLER22B) {
			RED_SAND = new BlockSand("red_sand").setHardness(0.6F);
			RED_SANDSTONE = new BlockBasic(Material.ROCK).setUnlocalizedName("red_sandstone").setHardness(2F).setResistance(2F).setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.RADIATION)
			ORE_POTASH = new BlockBasic(Material.ROCK).setUnlocalizedName("potash").setHardness(5.0F).setResistance(3.0F).setCreativeTab(ExtraPlanets.BlocksTab);

		ADVANCED_LAUCHPAD = new BlockCustomLandingPad("advanced_launch_pad");
		ADVANCED_LAUCHPAD_FULL = new BlockCustomLandingPadFull("advanced_launch_pad_full");
		FAKE_BLOCK = new BlockCustomMulti("block_multi");
		DECORATIVE_BLOCKS = new BlockDecorativeBlocks("decorative_blocks");
		DECORATIVE_BLOCKS2 = new BlockDecorativeBlocks2("decorative_blocks2");
		CANDY_BLOCKS = new BlockCandyBlocks("candy_blocks");
		CANDY_BLOCKS_HORIZONTAL = new BlockCandyBlocksHorizontal("candy_blocks_horizontal");
		CAKE_BLOCKS = new BlockCakeBlocks("cake_blocks");
		WHITE_SUGAR_CANE = new BlockWhiteSugerCane("white_sugar_cane");
		if (Config.RADIATION && Config.BASIC_DECONTAMINATION_UNIT)
			FAKE_BLOCK_DECONTAMINATION_UNIT = new BlockDecontaminationUnitFake("basic_decontamination_unit_fake_block");
		DIAMOND_GRIT = new BlockBasicGravel("diamond_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		GOLD_GRIT = new BlockBasicGravel("gold_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		COAL_GRIT = new BlockBasicGravel("coal_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		IRON_GRIT = new BlockBasicGravel("iron_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
		EMERALD_GRIT = new BlockBasicGravel("emerald_grit").setCreativeTab(ExtraPlanets.BlocksTab).setLightLevel(0.5F);
	}

	public static void initializeStairs() {
		if (Config.MERCURY) {
			MERCURY_SURFACE_STAIRS = new BlockBasicStairs("mercury_stairs_surface", MERCURY_BLOCKS.getDefaultState().withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			MERCURY_SUB_SURFACE_STAIRS = new BlockBasicStairs("mercury_stairs_sub_surface", MERCURY_BLOCKS.getDefaultState().withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			MERCURY_STONE_STAIRS = new BlockBasicStairs("mercury_stairs_stone", MERCURY_BLOCKS.getDefaultState().withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			MERCURY_STONE_BRICKS_STAIRS = new BlockBasicStairs("mercury_stairs_stone_bricks", MERCURY_BLOCKS.getDefaultState().withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F)
					.setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.CERES) {
			CERES_SURFACE_STAIRS = new BlockBasicStairs("ceres_stairs_surface", CERES_BLOCKS.getDefaultState().withProperty(BlockBasicCeres.BASIC_TYPE, BlockBasicCeres.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			CERES_SUB_SURFACE_STAIRS = new BlockBasicStairs("ceres_stairs_sub_surface", CERES_BLOCKS.getDefaultState().withProperty(BlockBasicCeres.BASIC_TYPE, BlockBasicCeres.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			CERES_STONE_STAIRS = new BlockBasicStairs("ceres_stairs_stone", CERES_BLOCKS.getDefaultState().withProperty(BlockBasicCeres.BASIC_TYPE, BlockBasicCeres.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			CERES_STONE_BRICKS_STAIRS = new BlockBasicStairs("ceres_stairs_stone_bricks", CERES_BLOCKS.getDefaultState().withProperty(BlockBasicCeres.BASIC_TYPE, BlockBasicCeres.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
		}
		if (Config.JUPITER) {
			JUPITER_SURFACE_STAIRS = new BlockBasicStairs("jupiter_stairs_surface", JUPITER_BLOCKS.getDefaultState().withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			JUPITER_SUB_SURFACE_STAIRS = new BlockBasicStairs("jupiter_stairs_sub_surface", JUPITER_BLOCKS.getDefaultState().withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			JUPITER_STONE_STAIRS = new BlockBasicStairs("jupiter_stairs_stone", JUPITER_BLOCKS.getDefaultState().withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			JUPITER_STONE_BRICKS_STAIRS = new BlockBasicStairs("jupiter_stairs_stone_bricks", JUPITER_BLOCKS.getDefaultState().withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F)
					.setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.SATURN) {
			SATURN_SURFACE_STAIRS = new BlockBasicStairs("saturn_stairs_surface", SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			SATURN_SUB_SURFACE_STAIRS = new BlockBasicStairs("saturn_stairs_sub_surface", SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			SATURN_STONE_STAIRS = new BlockBasicStairs("saturn_stairs_stone", SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			SATURN_STONE_BRICKS_STAIRS = new BlockBasicStairs("saturn_stairs_stone_bricks", SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
		}
		if (Config.URANUS) {
			URANUS_SURFACE_STAIRS = new BlockBasicStairs("uranus_stairs_surface", URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			URANUS_SUB_SURFACE_STAIRS = new BlockBasicStairs("uranus_stairs_sub_surface", URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			URANUS_STONE_STAIRS = new BlockBasicStairs("uranus_stairs_stone", URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			URANUS_STONE_BRICKS_STAIRS = new BlockBasicStairs("uranus_stairs_stone_bricks", URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
		}
		if (Config.NEPTUNE) {
			NEPTUNE_SURFACE_STAIRS = new BlockBasicStairs("neptune_stairs_surface", NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			NEPTUNE_SUB_SURFACE_STAIRS = new BlockBasicStairs("neptune_stairs_sub_surface", NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			NEPTUNE_STONE_STAIRS = new BlockBasicStairs("neptune_stairs_stone", NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			NEPTUNE_STONE_BRICKS_STAIRS = new BlockBasicStairs("neptune_stairs_stone_bricks", NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F)
					.setCreativeTab(ExtraPlanets.BlocksTab);
		}
		if (Config.PLUTO) {
			PLUTO_SURFACE_STAIRS = new BlockBasicStairs("pluto_stairs_surface", PLUTO_BLOCKS.getDefaultState().withProperty(BlockBasicPluto.BASIC_TYPE, BlockBasicPluto.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			PLUTO_SUB_SURFACE_STAIRS = new BlockBasicStairs("pluto_stairs_sub_surface", PLUTO_BLOCKS.getDefaultState().withProperty(BlockBasicPluto.BASIC_TYPE, BlockBasicPluto.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			PLUTO_STONE_STAIRS = new BlockBasicStairs("pluto_stairs_stone", PLUTO_BLOCKS.getDefaultState().withProperty(BlockBasicPluto.BASIC_TYPE, BlockBasicPluto.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			PLUTO_STONE_BRICKS_STAIRS = new BlockBasicStairs("pluto_stairs_stone_bricks", PLUTO_BLOCKS.getDefaultState().withProperty(BlockBasicPluto.BASIC_TYPE, BlockBasicPluto.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
		}
		if (Config.ERIS) {
			ERIS_SURFACE_STAIRS = new BlockBasicStairs("eris_stairs_surface", ERIS_BLOCKS.getDefaultState().withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.SURFACE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			ERIS_SUB_SURFACE_STAIRS = new BlockBasicStairs("eris_stairs_sub_surface", ERIS_BLOCKS.getDefaultState().withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.SUB_SURFACE)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
			ERIS_STONE_STAIRS = new BlockBasicStairs("eris_stairs_stone", ERIS_BLOCKS.getDefaultState().withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.STONE)).setHardness(2.0F).setCreativeTab(ExtraPlanets.BlocksTab);
			ERIS_STONE_BRICKS_STAIRS = new BlockBasicStairs("eris_stairs_stone_bricks", ERIS_BLOCKS.getDefaultState().withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.STONEBRICKS)).setHardness(2.0F).setCreativeTab(
					ExtraPlanets.BlocksTab);
		}
	}

	private static void initializeTreasureChestBlocks() {
		if (Config.MERCURY) {
			TREASURE_CHEST_TIER_4 = new T4TreasureChest("treasure_chest_t4");
		}
		if (Config.JUPITER) {
			TREASURE_CHEST_TIER_5 = new T5TreasureChest("treasure_chest_t5");
		}
		if (Config.SATURN) {
			TREASURE_CHEST_TIER_6 = new T6TreasureChest("treasure_chest_t6");
		}
		if (Config.URANUS) {
			TREASURE_CHEST_TIER_7 = new T7TreasureChest("treasure_chest_t7");
		}
		if (Config.NEPTUNE) {
			TREASURE_CHEST_TIER_8 = new T8TreasureChest("treasure_chest_t8");
		}
		if (Config.PLUTO) {
			TREASURE_CHEST_TIER_9 = new T9TreasureChest("treasure_chest_t9");
		}
		if (Config.ERIS) {
			TREASURE_CHEST_TIER_10 = new T10TreasureChest("treasure_chest_t10");
		}
	}

	private static void initializeSpawnerBlocks() {
		if (Config.MERCURY) {
			MERCURY_SPAWNER = new BlockMercuryDungeonSpawner("boss_spawner_venus");
		}
		if (Config.JUPITER) {
			JUIPTER_SPAWNER = new BlockJupiterDungeonSpawner("boss_spawner_jupiter");
		}
		if (Config.SATURN) {
			SATURN_SPAWNER = new BlockSaturnDungeonSpawner("boss_spawner_saturn");
		}
		if (Config.URANUS) {
			URANUS_SPAWNER = new BlockUranusDungeonSpawner("boss_spawner_uranus");
		}
		if (Config.NEPTUNE) {
			NEPTUNE_SPAWNER = new BlockNeptuneDungeonSpawner("boss_spawner_neptune");
		}
		if (Config.PLUTO) {
			PLUTO_SPAWNER = new BlockPlutoDungeonSpawner("boss_spawner_pluto");
		}
		if (Config.ERIS) {
			ERIS_SPAWNER = new BlockErisDungeonSpawner("boss_spawner_eris");
		}
	}

	private static void initializeTreeBlocks() {
		KEPLER22B_MAPLE_LOG = new BlockKepler22bMapleTreeLog().setUnlocalizedName("kepler22b_maple_logs").setCreativeTab(ExtraPlanets.BlocksTab);
		KEPLER22B_MAPLE_LOG_2 = new BlockKepler22bMapleTreeLog2().setUnlocalizedName("kepler22b_maple_logs2").setCreativeTab(ExtraPlanets.BlocksTab);
		KEPLER22B_MAPLE_SAPLING = new BlockKepler22bMapleTreeSapling().setUnlocalizedName("kepler22b_maple_saplings");
		KEPLER22B_MAPLE_LEAF = new BlockKepler22bMapleTreeLeaves().setUnlocalizedName("kepler22b_new_maple_leaves");
		KEPLER22B_MAPLE_LEAF2 = new BlockKepler22bMapleTreeLeaves2().setUnlocalizedName("kepler22b_new_maple_leaves_2");
		KEPLER22B_MAPLE_PLANKS = new BlockBasicKepler22bPlanks().setUnlocalizedName("kepler22b_planks");
	}

	private static void registerBlocks() throws NoSuchMethodException {
		if (Config.MERCURY) {
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_BLOCKS, ItemBlockMercury.class, MERCURY_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_GRAVEL, MERCURY_GRAVEL.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_SPAWNER, ItemBlockGC.class, "mercury_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_4, ItemBlockDesc.class, TREASURE_CHEST_TIER_4.getUnlocalizedName().substring(5));
		}
		if (Config.CERES) {
			RegisterUtilities.registerBlock(Constants.modID, CERES_BLOCKS, ItemBlockCeres.class, CERES_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, CERES_GRAVEL, CERES_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerBlock(Constants.modID, JUPITER_BLOCKS, ItemBlockJupiter.class, JUPITER_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, JUPITER_GRAVEL, JUPITER_GRAVEL.getUnlocalizedName().substring(5));

			RegisterUtilities.registerBlock(Constants.modID, JUIPTER_SPAWNER, ItemBlockGC.class, "jupiter_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_5, ItemBlockDesc.class, TREASURE_CHEST_TIER_5.getUnlocalizedName().substring(5));

			RegisterUtilities.registerBlock(Constants.modID, VOLCANIC_ROCK, VOLCANIC_ROCK.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ASH_ROCK, ASH_ROCK.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ORANGE_SAND, ORANGE_SAND.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ORANGE_SANDSTONE, ORANGE_SANDSTONE.getUnlocalizedName().substring(5));
		}
		if (Config.SATURN) {
			RegisterUtilities.registerBlock(Constants.modID, SATURN_BLOCKS, ItemBlockSaturn.class, SATURN_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, SATURN_GRAVEL, SATURN_GRAVEL.getUnlocalizedName().substring(5));

			RegisterUtilities.registerBlock(Constants.modID, SATURN_SPAWNER, ItemBlockGC.class, "saturn_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_6, ItemBlockDesc.class, TREASURE_CHEST_TIER_6.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			RegisterUtilities.registerBlock(Constants.modID, URANUS_BLOCKS, ItemBlockUranus.class, URANUS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, URANUS_SPAWNER, ItemBlockGC.class, "uranus_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_7, ItemBlockDesc.class, TREASURE_CHEST_TIER_7.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, DENSE_ICE, DENSE_ICE.getUnlocalizedName().substring(5));
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerBlock(Constants.modID, NEPTUNE_BLOCKS, ItemBlockNeptune.class, NEPTUNE_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, NEPTUNE_SPAWNER, ItemBlockGC.class, "neptune_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_8, ItemBlockDesc.class, TREASURE_CHEST_TIER_8.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, FROZEN_NITROGEN, FROZEN_NITROGEN.getUnlocalizedName().substring(5));
		}
		if (Config.PLUTO) {
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_BLOCKS, ItemBlockPluto.class, PLUTO_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_SPAWNER, ItemBlockGC.class, "pluto_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_9, ItemBlockDesc.class, TREASURE_CHEST_TIER_9.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_GRAVEL, PLUTO_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.ERIS) {
			RegisterUtilities.registerBlock(Constants.modID, ERIS_BLOCKS, ItemBlockEris.class, ERIS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ERIS_SPAWNER, ItemBlockGC.class, "eris_spawner");
			RegisterUtilities.registerBlock(Constants.modID, TREASURE_CHEST_TIER_10, ItemBlockDesc.class, TREASURE_CHEST_TIER_10.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ERIS_GRAVEL, ERIS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_BLOCKS, ItemBlockKepler22b.class, KEPLER22B_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_GRASS_GREEN, KEPLER22B_GRASS_GREEN.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_GRASS_BLUE, KEPLER22B_GRASS_BLUE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_GRASS_PURPLE, KEPLER22B_GRASS_PURPLE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_GRASS_RED, KEPLER22B_GRASS_RED.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_GRASS_YELLOW, KEPLER22B_GRASS_YELLOW.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_GRASS_INFECTED, KEPLER22B_GRASS_INFECTED.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_FLOWERS, ItemBlockKepler22bTallGrass.class, KEPLER22B_MAPLE_FLOWERS.getUnlocalizedName().substring(5));
		}
		if (Config.KEPLER22B || Config.JUPITER) {
			RegisterUtilities.registerBlock(Constants.modID, RED_SAND, RED_SAND.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, RED_SANDSTONE, RED_SANDSTONE.getUnlocalizedName().substring(5));
		}

		if (Config.EUROPA) {
			RegisterUtilities.registerBlock(Constants.modID, EUROPA_BLOCKS, ItemBlockEuropa.class, EUROPA_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, EUROPA_GRAVEL, EUROPA_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.IO) {
			RegisterUtilities.registerBlock(Constants.modID, IO_BLOCKS, ItemBlockIo.class, IO_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, IO_GRAVEL, IO_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.DEIMOS) {
			RegisterUtilities.registerBlock(Constants.modID, DEIMOS_BLOCKS, ItemBlockDeimos.class, DEIMOS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, DEIMOS_GRAVEL, DEIMOS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.PHOBOS) {
			RegisterUtilities.registerBlock(Constants.modID, PHOBOS_BLOCKS, ItemBlockPhobos.class, PHOBOS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, PHOBOS_GRAVEL, PHOBOS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.TRITON) {
			RegisterUtilities.registerBlock(Constants.modID, TRITON_BLOCKS, ItemBlockTriton.class, TRITON_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, TRITON_GRAVEL, TRITON_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.CALLISTO) {
			RegisterUtilities.registerBlock(Constants.modID, CALLISTO_BLOCKS, ItemBlockCallisto.class, CALLISTO_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, CALLISTO_GRAVEL, CALLISTO_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.GANYMEDE) {
			RegisterUtilities.registerBlock(Constants.modID, GANYMEDE_BLOCKS, ItemBlockGanymede.class, GANYMEDE_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, GANYMEDE_GRAVEL, GANYMEDE_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.RHEA) {
			RegisterUtilities.registerBlock(Constants.modID, RHEA_BLOCKS, ItemBlockRhea.class, RHEA_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, RHEA_GRAVEL, RHEA_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.TITAN) {
			RegisterUtilities.registerBlock(Constants.modID, TITAN_BLOCKS, ItemBlockTitan.class, TITAN_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, TITAN_GRAVEL, TITAN_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.OBERON) {
			RegisterUtilities.registerBlock(Constants.modID, OBERON_BLOCKS, ItemBlockOberon.class, OBERON_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, OBERON_GRAVEL, OBERON_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.TITANIA) {
			RegisterUtilities.registerBlock(Constants.modID, TITANIA_BLOCKS, ItemBlockTitania.class, TITANIA_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, TITANIA_GRAVEL, TITANIA_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.IAPETUS) {
			RegisterUtilities.registerBlock(Constants.modID, IAPETUS_BLOCKS, ItemBlockIapetus.class, IAPETUS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, IAPETUS_GRAVEL, IAPETUS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.MERCURY || Config.CERES || Config.PLUTO || Config.ERIS)
			RegisterUtilities.registerBlock(Constants.modID, FOSSIL, FOSSIL.getUnlocalizedName().substring(5));
		if (Config.CERES && Config.NUCLEAR_BOMB)
			RegisterUtilities.registerBlock(Constants.modID, NUCLEAR_BOMB, NUCLEAR_BOMB.getUnlocalizedName().substring(5));
		if (Config.SATURN && Config.FIRE_BOMB)
			RegisterUtilities.registerBlock(Constants.modID, FIRE_BOMB, FIRE_BOMB.getUnlocalizedName().substring(5));
		if (Config.ORE_LEAD_GENERATION)
			RegisterUtilities.registerBlock(Constants.modID, ORE_LEAD, ORE_LEAD.getUnlocalizedName().substring(5));
		if (Config.RADIATION)
			RegisterUtilities.registerBlock(Constants.modID, ORE_POTASH, "potash");

		RegisterUtilities.registerBlock(Constants.modID, ADVANCED_LAUCHPAD, ItemBlockCustomLandingPad.class, ADVANCED_LAUCHPAD.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, ADVANCED_LAUCHPAD_FULL, ItemBlockGC.class, ADVANCED_LAUCHPAD_FULL.getUnlocalizedName().substring(5));

		RegisterUtilities.registerBlock(Constants.modID, FAKE_BLOCK, ItemBlockDummy.class, FAKE_BLOCK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, DECORATIVE_BLOCKS, ItemBlockDecorativeBlocks.class, DECORATIVE_BLOCKS.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, DECORATIVE_BLOCKS2, ItemBlockDecorativeBlocks2.class, DECORATIVE_BLOCKS2.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, CANDY_BLOCKS, ItemBlockCandyBlocks.class, CANDY_BLOCKS.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, CANDY_BLOCKS_HORIZONTAL, ItemBlockCandyBlocksHorizontal.class, CANDY_BLOCKS_HORIZONTAL.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, CAKE_BLOCKS, ItemBlockCakeBlocks.class, CAKE_BLOCKS.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, WHITE_SUGAR_CANE, WHITE_SUGAR_CANE.getUnlocalizedName().substring(5));
		if (Config.RADIATION && Config.BASIC_DECONTAMINATION_UNIT)
			RegisterUtilities.registerBlock(Constants.modID, FAKE_BLOCK_DECONTAMINATION_UNIT, FAKE_BLOCK_DECONTAMINATION_UNIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, DIAMOND_GRIT, DIAMOND_GRIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, GOLD_GRIT, GOLD_GRIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, COAL_GRIT, COAL_GRIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, IRON_GRIT, IRON_GRIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, EMERALD_GRIT, EMERALD_GRIT.getUnlocalizedName().substring(5));
	}

	private static void registerStairs() throws NoSuchMethodException {
		if (Config.MERCURY) {
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_SURFACE_STAIRS, ItemBlockGC.class, MERCURY_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_SUB_SURFACE_STAIRS, ItemBlockGC.class, MERCURY_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_STONE_STAIRS, ItemBlockGC.class, MERCURY_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, MERCURY_STONE_BRICKS_STAIRS, ItemBlockGC.class, MERCURY_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.CERES) {
			RegisterUtilities.registerBlock(Constants.modID, CERES_SURFACE_STAIRS, ItemBlockGC.class, CERES_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, CERES_SUB_SURFACE_STAIRS, ItemBlockGC.class, CERES_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, CERES_STONE_STAIRS, ItemBlockGC.class, CERES_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, CERES_STONE_BRICKS_STAIRS, ItemBlockGC.class, CERES_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerBlock(Constants.modID, JUPITER_SURFACE_STAIRS, ItemBlockGC.class, JUPITER_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, JUPITER_SUB_SURFACE_STAIRS, ItemBlockGC.class, JUPITER_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, JUPITER_STONE_STAIRS, ItemBlockGC.class, JUPITER_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, JUPITER_STONE_BRICKS_STAIRS, ItemBlockGC.class, JUPITER_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.SATURN) {
			RegisterUtilities.registerBlock(Constants.modID, SATURN_SURFACE_STAIRS, ItemBlockGC.class, SATURN_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, SATURN_SUB_SURFACE_STAIRS, ItemBlockGC.class, SATURN_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, SATURN_STONE_STAIRS, ItemBlockGC.class, SATURN_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, SATURN_STONE_BRICKS_STAIRS, ItemBlockGC.class, SATURN_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			RegisterUtilities.registerBlock(Constants.modID, URANUS_SURFACE_STAIRS, ItemBlockGC.class, URANUS_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, URANUS_SUB_SURFACE_STAIRS, ItemBlockGC.class, URANUS_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, URANUS_STONE_STAIRS, ItemBlockGC.class, URANUS_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, URANUS_STONE_BRICKS_STAIRS, ItemBlockGC.class, URANUS_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerBlock(Constants.modID, NEPTUNE_SURFACE_STAIRS, ItemBlockGC.class, NEPTUNE_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, NEPTUNE_SUB_SURFACE_STAIRS, ItemBlockGC.class, NEPTUNE_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, NEPTUNE_STONE_STAIRS, ItemBlockGC.class, NEPTUNE_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, NEPTUNE_STONE_BRICKS_STAIRS, ItemBlockGC.class, NEPTUNE_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.PLUTO) {
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_SURFACE_STAIRS, ItemBlockGC.class, PLUTO_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_SUB_SURFACE_STAIRS, ItemBlockGC.class, PLUTO_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_STONE_STAIRS, ItemBlockGC.class, PLUTO_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, PLUTO_STONE_BRICKS_STAIRS, ItemBlockGC.class, PLUTO_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
		if (Config.ERIS) {
			RegisterUtilities.registerBlock(Constants.modID, ERIS_SURFACE_STAIRS, ItemBlockGC.class, ERIS_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ERIS_SUB_SURFACE_STAIRS, ItemBlockGC.class, ERIS_SUB_SURFACE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ERIS_STONE_STAIRS, ItemBlockGC.class, ERIS_STONE_STAIRS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerBlock(Constants.modID, ERIS_STONE_BRICKS_STAIRS, ItemBlockGC.class, ERIS_STONE_BRICKS_STAIRS.getUnlocalizedName().substring(5));
		}
	}

	private static void registerTileEntitys() {
		if (Config.MERCURY) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerMercuryDefault.class, Constants.modName + "Mercury Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerMercury.class, Constants.modName + "Mercury Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT4TreasureChest.class, Constants.modName + "Tier 4 Treasure Chest");
		}
		if (Config.JUPITER) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerJupiterDefault.class, Constants.modName + "Juptier Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerJupiter.class, Constants.modName + "Juptier Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT5TreasureChest.class, Constants.modName + "Tier 5 Treasure Chest");
		}
		if (Config.SATURN) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerSaturnDefault.class, Constants.modName + "Saturn Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerSaturn.class, Constants.modName + "Saturn Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 6 Treasure Chest");
		}
		if (Config.URANUS) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerUranusDefault.class, Constants.modName + "Uranus Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerUranus.class, Constants.modName + "Uranus Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 7 Treasure Chest");
		}
		if (Config.NEPTUNE) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerNeptuneDefault.class, Constants.modName + "Neptune Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerNeptune.class, Constants.modName + "Neptune Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 8 Treasure Chest");
		}
		if (Config.PLUTO) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerPlutoDefault.class, Constants.modName + "Pluto Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerPluto.class, Constants.modName + "Pluto Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT9TreasureChest.class, Constants.modName + "Tier 9 Treasure Chest");
		}
		if (Config.ERIS) {
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerErisDefault.class, Constants.modName + "Eris Dungeon Default Spawner");
			else
				RegisterUtilities.registerTileEntity(TileEntityDungeonSpawnerEris.class, Constants.modName + "Eris Dungeon Spawner");
			RegisterUtilities.registerTileEntity(TileEntityT10TreasureChest.class, Constants.modName + "Tier 10 Treasure Chest");
		}
		RegisterUtilities.registerTileEntity(TileEntityTier2LandingPadSingle.class, "Tier 2 Landing Pad");
		RegisterUtilities.registerTileEntity(TileEntityTier2LandingPad.class, "Tier 2 Landing Pad Full");

		RegisterUtilities.registerTileEntity(TileEntityTier3LandingPadSingle.class, "Tier 3 Landing Pad");
		RegisterUtilities.registerTileEntity(TileEntityTier3LandingPad.class, "Tier 3 Landing Pad Full");

		RegisterUtilities.registerTileEntity(TileEntityPoweredChargingPadSingle.class, "Powered Charging Pad");
		RegisterUtilities.registerTileEntity(TileEntityPoweredChargingPad.class, "Powered Charging Pad Full");

		RegisterUtilities.registerTileEntity(TileEntityRocketChargingPadSingle.class, "Rocket Charging Pad");
		RegisterUtilities.registerTileEntity(TileEntityRocketChargingPad.class, "Rocket Charging Pad Full");
		if (Config.RADIATION && Config.BASIC_DECONTAMINATION_UNIT)
			RegisterUtilities.registerTileEntity(TileEntityBasicDecontaminationUnitFake.class, Constants.modName + "Basic Decontamination Unit Fake");
	}

	private static void setHarvestLevels() {
		if (Config.MERCURY) {
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 2, 6); // Mercury Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 1, 7); // Mercury Block
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 2, 10); // Carbon Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, MERCURY_BLOCKS, "pickaxe", 1, 11); // Carbon Block
		}
		if (Config.CERES) {
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 2, 6); // Uranium Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 1, 7); // Uranium Block
			RegisterUtilities.setHarvestLevel(Constants.modID, CERES_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.JUPITER) {
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 2, 6); // Palladium Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 2, 7); // Nickel Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 1, 8); // Palladium Block
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 1, 9); // Stone Bricks
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 2, 11); // Red Gem Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, JUPITER_BLOCKS, "pickaxe", 1, 12); // Red Gem Block
		}
		if (Config.SATURN) {
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 6); // Magnesium Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 1, 7); // Magnesium Block
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 10); // Broken Infected Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 11); // Infected Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, SATURN_BLOCKS, "pickaxe", 2, 12); // Slime Ore
		}
		if (Config.URANUS) {
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 2, 3); // Crystal Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 1, 4); // Crystal Block
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 1, 5); // Stone Bricks
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 2, 7); // White Gem Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, URANUS_BLOCKS, "pickaxe", 1, 8); // White Gem Block
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 2, 6); // Zinc Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 1, 7); // Zinc Block
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 2, 10); // Blue Gem Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, NEPTUNE_BLOCKS, "pickaxe", 1, 11); // Blue Gem Block
		}
		if (Config.PLUTO) {
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 2, 6); // Tungsten Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 1, 7); // Tungsten Block
			RegisterUtilities.setHarvestLevel(Constants.modID, PLUTO_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.ERIS) {
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 2, 6); // Dark Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 1, 7); // Dark Iron Block
			RegisterUtilities.setHarvestLevel(Constants.modID, ERIS_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.KEPLER22B) {
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "shovel", 0, 0); // Dirt
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 1, 1); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 2); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 3); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 4); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 5); // Dense Coal Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 6); // Blue Diamond Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 7); // Red Diamond Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 8); // Purple Diamond Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 9); // Yellow Diamond Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 10); // Green Diamond Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 1, 11); // Stone Bricks
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 1, 12); // Cobblestone
			RegisterUtilities.setHarvestLevel(Constants.modID, KEPLER22B_BLOCKS, "pickaxe", 2, 13); // Platinum Ore
		}
		if (Config.CALLISTO) {
			RegisterUtilities.setHarvestLevel(Constants.modID, CALLISTO_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, CALLISTO_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, CALLISTO_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, CALLISTO_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, CALLISTO_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, CALLISTO_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.DEIMOS) {
			RegisterUtilities.setHarvestLevel(Constants.modID, DEIMOS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, DEIMOS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, DEIMOS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, DEIMOS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, DEIMOS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, DEIMOS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.EUROPA) {
			RegisterUtilities.setHarvestLevel(Constants.modID, EUROPA_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, EUROPA_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, EUROPA_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, EUROPA_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, EUROPA_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, EUROPA_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.GANYMEDE) {
			RegisterUtilities.setHarvestLevel(Constants.modID, GANYMEDE_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, GANYMEDE_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, GANYMEDE_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, GANYMEDE_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, GANYMEDE_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, GANYMEDE_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.IO) {
			RegisterUtilities.setHarvestLevel(Constants.modID, IO_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, IO_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, IO_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, IO_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, IO_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, IO_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.PHOBOS) {
			RegisterUtilities.setHarvestLevel(Constants.modID, PHOBOS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, PHOBOS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, PHOBOS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, PHOBOS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, PHOBOS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, PHOBOS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.RHEA) {
			RegisterUtilities.setHarvestLevel(Constants.modID, RHEA_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, RHEA_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, RHEA_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, RHEA_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, RHEA_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, RHEA_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.TITAN) {
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 1, 6); // Methane Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 1, 7); // Methane Sub-Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TITAN_BLOCKS, "pickaxe", 2, 8); // Rocks
		}
		if (Config.TRITON) {
			RegisterUtilities.setHarvestLevel(Constants.modID, TRITON_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TRITON_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TRITON_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, TRITON_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TRITON_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TRITON_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.IAPETUS) {
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, IAPETUS_BLOCKS, "pickaxe", 1, 6); // Ice
		}
		if (Config.OBERON) {
			RegisterUtilities.setHarvestLevel(Constants.modID, OBERON_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, OBERON_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, OBERON_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, OBERON_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, OBERON_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, OBERON_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.TITANIA) {
			RegisterUtilities.setHarvestLevel(Constants.modID, TITANIA_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TITANIA_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterUtilities.setHarvestLevel(Constants.modID, TITANIA_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterUtilities.setHarvestLevel(Constants.modID, TITANIA_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TITANIA_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterUtilities.setHarvestLevel(Constants.modID, TITANIA_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.ORE_LEAD_GENERATION)
			RegisterUtilities.setHarvestLevel(Constants.modID, ORE_LEAD, "pickaxe", 2, 0); // Lead Ore
	}

	public static void OreDictionaryRegister() {
		if (Config.MERCURY) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(MERCURY_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(MERCURY_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(MERCURY_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreMercury", new ItemStack(MERCURY_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("blockMercury", new ItemStack(MERCURY_BLOCKS, 1, 7));
			RegisterUtilities.registerOre("oreCarbon", new ItemStack(MERCURY_BLOCKS, 1, 10));
			RegisterUtilities.registerOre("blockCarbon", new ItemStack(MERCURY_BLOCKS, 1, 11));
		}
		if (Config.CERES) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(CERES_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(CERES_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(CERES_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreUranium", new ItemStack(CERES_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("blockUranium", new ItemStack(CERES_BLOCKS, 1, 7));
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(JUPITER_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(JUPITER_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(JUPITER_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("orePalladium", new ItemStack(JUPITER_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("oreNickel", new ItemStack(JUPITER_BLOCKS, 1, 7));
			RegisterUtilities.registerOre("oreRedGem", new ItemStack(JUPITER_BLOCKS, 1, 11));
			RegisterUtilities.registerOre("blockPalladium", new ItemStack(JUPITER_BLOCKS, 1, 8));
			RegisterUtilities.registerOre("blockRedGem", new ItemStack(JUPITER_BLOCKS, 1, 12));
		}
		if (Config.SATURN) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(SATURN_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(SATURN_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(SATURN_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreMagnesium", new ItemStack(SATURN_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("blockMagnesium", new ItemStack(SATURN_BLOCKS, 1, 7));
			RegisterUtilities.registerOre("oreSlime", new ItemStack(SATURN_BLOCKS, 1, 12));
		}
		if (Config.URANUS) {
			RegisterUtilities.registerOre("oreCrystal", new ItemStack(URANUS_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreWhiteGem", new ItemStack(URANUS_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("blockCrystal", new ItemStack(URANUS_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("blockWhiteGem", new ItemStack(URANUS_BLOCKS, 1, 7));
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(NEPTUNE_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(NEPTUNE_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(NEPTUNE_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreZinc", new ItemStack(NEPTUNE_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("oreBlueGem", new ItemStack(NEPTUNE_BLOCKS, 1, 10));
			RegisterUtilities.registerOre("blockZinc", new ItemStack(NEPTUNE_BLOCKS, 1, 7));
			RegisterUtilities.registerOre("blockBlueGem", new ItemStack(NEPTUNE_BLOCKS, 1, 11));
		}
		if (Config.PLUTO) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(PLUTO_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(PLUTO_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(PLUTO_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreTungsten", new ItemStack(PLUTO_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("blockTungsten", new ItemStack(PLUTO_BLOCKS, 1, 7));
		}
		if (Config.ERIS) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(ERIS_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(ERIS_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(ERIS_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreDarkIron", new ItemStack(ERIS_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("blockDarkIron", new ItemStack(ERIS_BLOCKS, 1, 7));
		}
		if (Config.CALLISTO) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(CALLISTO_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(CALLISTO_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(CALLISTO_BLOCKS, 1, 3));
		}
		if (Config.DEIMOS) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(DEIMOS_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(DEIMOS_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(DEIMOS_BLOCKS, 1, 3));
		}
		if (Config.EUROPA) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(EUROPA_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(EUROPA_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(EUROPA_BLOCKS, 1, 3));
		}
		if (Config.GANYMEDE) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(GANYMEDE_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(GANYMEDE_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(GANYMEDE_BLOCKS, 1, 3));
		}
		if (Config.IO) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(IO_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(IO_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(IO_BLOCKS, 1, 3));
		}
		if (Config.PHOBOS) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(PHOBOS_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(PHOBOS_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(PHOBOS_BLOCKS, 1, 3));
		}
		if (Config.RHEA) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(RHEA_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(RHEA_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(RHEA_BLOCKS, 1, 3));
		}
		if (Config.TITAN) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(TITAN_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(TITAN_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(TITAN_BLOCKS, 1, 3));
		}
		if (Config.TRITON) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(TRITON_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(TRITON_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(TRITON_BLOCKS, 1, 3));
		}
		if (Config.OBERON) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(OBERON_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(OBERON_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(OBERON_BLOCKS, 1, 3));
		}
		if (Config.IAPETUS) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(IAPETUS_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(IAPETUS_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(IAPETUS_BLOCKS, 1, 3));
		}
		if (Config.TITANIA) {
			RegisterUtilities.registerOre("oreCopper", new ItemStack(TITANIA_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreTin", new ItemStack(TITANIA_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreIron", new ItemStack(TITANIA_BLOCKS, 1, 3));
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterUtilities.registerOre("stone", new ItemStack(KEPLER22B_BLOCKS, 1, 1));
			RegisterUtilities.registerOre("oreIron", new ItemStack(KEPLER22B_BLOCKS, 1, 2));
			RegisterUtilities.registerOre("oreCopper", new ItemStack(KEPLER22B_BLOCKS, 1, 3));
			RegisterUtilities.registerOre("oreTin", new ItemStack(KEPLER22B_BLOCKS, 1, 4));
			RegisterUtilities.registerOre("oreDenseCoal", new ItemStack(KEPLER22B_BLOCKS, 1, 5));
			RegisterUtilities.registerOre("oreBlueDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 6));
			RegisterUtilities.registerOre("oreRedDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 7));
			RegisterUtilities.registerOre("orePurpleDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 8));
			RegisterUtilities.registerOre("oreYellowDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 9));
			RegisterUtilities.registerOre("oreGreenDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 10));
			RegisterUtilities.registerOre("cobblestone", new ItemStack(KEPLER22B_BLOCKS, 1, 12));
			RegisterUtilities.registerOre("orePlatinum", new ItemStack(KEPLER22B_BLOCKS, 1, 13));
		}
		if (Config.ORE_LEAD_GENERATION) {
			RegisterUtilities.registerOre("oreLead", new ItemStack(ORE_LEAD, 1, 0));
			GameRegistry.registerWorldGenerator(new WorldGenerationOverworld(), 1);
		}
	}

	private static void registerTreeBlocks() throws NoSuchMethodException {
		RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_LOG, ItemBlockKepler22bMapleLog.class, KEPLER22B_MAPLE_LOG.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_LOG_2, ItemBlockKepler22bMapleLog2.class, KEPLER22B_MAPLE_LOG_2.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_SAPLING, ItemBlockKepler22bMapleSapling.class, KEPLER22B_MAPLE_SAPLING.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_LEAF, ItemBlockKepler22bMapleLeaf.class, KEPLER22B_MAPLE_LEAF.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_LEAF2, ItemBlockKepler22bMapleLeaf2.class, KEPLER22B_MAPLE_LEAF2.getUnlocalizedName().substring(5));
		RegisterUtilities.registerBlock(Constants.modID, KEPLER22B_MAPLE_PLANKS, ItemBlockKepler22bPlanks.class, KEPLER22B_MAPLE_PLANKS.getUnlocalizedName().substring(5));
	}
}
