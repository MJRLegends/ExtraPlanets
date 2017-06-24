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
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockCustomLandingPad;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDecorativeBlocks;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDecorativeBlocks2;
import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDummy;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockCallisto;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockCeres;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockDeimos;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockEris;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockEuropa;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockGanymede;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockIapetus;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockIo;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockJupiter;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockKepler22b;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockMercury;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockNeptune;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockOberon;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockPhobos;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockPluto;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockRhea;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockSaturn;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockTitan;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockTitania;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockTriton;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.ItemBlockUranus;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bMapleLeaf;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bMapleLeaf2;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bMapleLog;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bMapleLog2;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bMapleSapling;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bPlanks;
import com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b.ItemBlockKepler22bTallGrass;
import com.mjr.extraplanets.tile.blocks.TileEntityPoweredChargingPad;
import com.mjr.extraplanets.tile.blocks.TileEntityPoweredChargingPadSingle;
import com.mjr.extraplanets.tile.blocks.TileEntityRocketChargingPad;
import com.mjr.extraplanets.tile.blocks.TileEntityRocketChargingPadSingle;
import com.mjr.extraplanets.tile.blocks.TileEntityTier2LandingPad;
import com.mjr.extraplanets.tile.blocks.TileEntityTier2LandingPadSingle;
import com.mjr.extraplanets.tile.blocks.TileEntityTier3LandingPad;
import com.mjr.extraplanets.tile.blocks.TileEntityTier3LandingPadSingle;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerEris;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerJupiter;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerMercury;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerPluto;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerUranus;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT10TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT8TreasureChest;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT9TreasureChest;
import com.mjr.extraplanets.util.RegisterHelper;
import com.mjr.extraplanets.world.WorldGenerationOverworld;

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

	public static void init() {
		initializeBlocks();
		initializeTreasureChestBlocks();
		initializeSpawnerBlocks();
		try {
			registerBlocks();
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
			MERCURY_GRAVEL = new BlockCustomGravel("mercury_gravel");
		}
		if (Config.CERES) {
			CERES_BLOCKS = new BlockBasicCeres("ceres");
			CERES_GRAVEL = new BlockCustomGravel("ceres_gravel");
		}
		if (Config.JUPITER) {
			JUPITER_BLOCKS = new BlockBasicJupiter("jupiter");
			JUPITER_GRAVEL = new BlockCustomGravel("jupiter_gravel");
			VOLCANIC_ROCK = new BlockBasic(Material.ROCK).setUnlocalizedName("volcanic_rock").setHardness(5.0F).setResistance(4.0F);
			ASH_ROCK = new BlockBasic(Material.ROCK).setUnlocalizedName("ash_rock").setHardness(2.0F).setResistance(1.5F);
		}
		if (Config.SATURN) {
			SATURN_BLOCKS = new BlockBasicSaturn("saturn");
			SATURN_GRAVEL = new BlockCustomGravel("saturn_gravel");
		}
		if (Config.URANUS) {
			URANUS_BLOCKS = new BlockBasicUranus("uranus");
			DENSE_ICE = new BlockBasic(Material.ICE).setUnlocalizedName("dense_ice").setHardness(2.2F).setResistance(3.0F);
		}
		if (Config.NEPTUNE) {
			NEPTUNE_BLOCKS = new BlockBasicNeptune("neptune");
			FROZEN_NITROGEN = new BlockBasic(Material.ICE).setUnlocalizedName("frozen_nitrogen");
		}
		if (Config.PLUTO) {
			PLUTO_BLOCKS = new BlockBasicPluto("pluto");
			PLUTO_GRAVEL = new BlockCustomGravel("pluto_gravel");
		}
		if (Config.ERIS) {
			ERIS_BLOCKS = new BlockBasicEris("eris");
			ERIS_GRAVEL = new BlockCustomGravel("eris_gravel");
		}
		if (Config.EUROPA) {
			EUROPA_BLOCKS = new BlockBasicEuropa("europa");
			EUROPA_GRAVEL = new BlockCustomGravel("europa_gravel");
		}
		if (Config.IO) {
			IO_BLOCKS = new BlockBasicIo("io");
			IO_GRAVEL = new BlockCustomGravel("io_gravel");
		}
		if (Config.DEIMOS) {
			DEIMOS_BLOCKS = new BlockBasicDeimos("deimos");
			DEIMOS_GRAVEL = new BlockCustomGravel("deimos_gravel");
		}
		if (Config.PHOBOS) {
			PHOBOS_BLOCKS = new BlockBasicPhobos("phobos");
			PHOBOS_GRAVEL = new BlockCustomGravel("phobos_gravel");
		}
		if (Config.TRITON) {
			TRITON_BLOCKS = new BlockBasicTriton("triton");
			TRITON_GRAVEL = new BlockCustomGravel("triton_gravel");
		}
		if (Config.CALLISTO) {
			CALLISTO_BLOCKS = new BlockBasicCallisto("callisto");
			CALLISTO_GRAVEL = new BlockCustomGravel("callisto_gravel");
		}
		if (Config.GANYMEDE) {
			GANYMEDE_BLOCKS = new BlockBasicGanymede("ganymede");
			GANYMEDE_GRAVEL = new BlockCustomGravel("ganymede_gravel");
		}
		if (Config.RHEA) {
			RHEA_BLOCKS = new BlockBasicRhea("rhea");
			RHEA_GRAVEL = new BlockCustomGravel("rhea_gravel");
		}
		if (Config.TITAN) {
			TITAN_BLOCKS = new BlockBasicTitan("titan");
			TITAN_GRAVEL = new BlockCustomGravel("titan_gravel");
		}
		if (Config.OBERON) {
			OBERON_BLOCKS = new BlockBasicOberon("oberon");
			OBERON_GRAVEL = new BlockCustomGravel("oberon_gravel");
		}
		if (Config.TITANIA) {
			TITANIA_BLOCKS = new BlockBasicTitania("titania");
			TITANIA_GRAVEL = new BlockCustomGravel("titania_gravel");
		}
		if (Config.IAPETUS) {
			IAPETUS_BLOCKS = new BlockBasicIapetus("iapetus");
			IAPETUS_GRAVEL = new BlockCustomGravel("iapetus_gravel");
		}
		if (Config.MERCURY || Config.CERES || Config.PLUTO || Config.ERIS)
			FOSSIL = new BlockFossil(Material.ROCK).setUnlocalizedName("fossil").setHardness(2.5F).setResistance(1.0F);
		if (Config.CERES && Config.NUCLEAR_BOMB)
			NUCLEAR_BOMB = new BlockNuclearBomb().setUnlocalizedName("nuclear_bomb");
		if (Config.SATURN && Config.FIRE_BOMB)
			FIRE_BOMB = new BlockFireBomb().setUnlocalizedName("fire_bomb");
		if (Config.ORE_LEAD_GENERATION)
			ORE_LEAD = new BlockBasic(Material.ROCK).setUnlocalizedName("ore_lead").setHardness(5.0F).setResistance(3.0F);
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			KEPLER22B_BLOCKS = new BlockBasicKepler22b("kepler22b");
			KEPLER22B_GRASS_GREEN = new BlockBasicGrass().setUnlocalizedName("kepler22b_grass");
			KEPLER22B_GRASS_BLUE = new BlockBasicGrass().setUnlocalizedName("kepler22b_blue_grass");
			KEPLER22B_GRASS_PURPLE = new BlockBasicGrass().setUnlocalizedName("kepler22b_purple_grass");
			KEPLER22B_GRASS_RED = new BlockBasicGrass().setUnlocalizedName("kepler22b_red_grass");
			KEPLER22B_GRASS_YELLOW = new BlockBasicGrass().setUnlocalizedName("kepler22b_yellow_grass");
			KEPLER22B_MAPLE_FLOWERS = new BlockBasicKepler22bTallGrass().setUnlocalizedName("kepler22b_flowers");
			RED_SAND = new BlockSand("red_sand").setHardness(0.6F);
			RED_SANDSTONE = new BlockBasic(Material.ROCK).setUnlocalizedName("red_sandstone").setHardness(2F).setResistance(2F);

		}
		if (Config.RADIATION)
			ORE_POTASH = new BlockBasic(Material.ROCK).setUnlocalizedName("potash").setHardness(5.0F).setResistance(3.0F);

		ADVANCED_LAUCHPAD = new BlockCustomLandingPad("advanced_launch_pad");
		ADVANCED_LAUCHPAD_FULL = new BlockCustomLandingPadFull("advanced_launch_pad_full");
		FAKE_BLOCK = new BlockCustomMulti("block_multi");
		DECORATIVE_BLOCKS = new BlockDecorativeBlocks("decorative_blocks");
		DECORATIVE_BLOCKS2 = new BlockDecorativeBlocks2("decorative_blocks2");
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
			RegisterHelper.registerBlock(MERCURY_BLOCKS, ItemBlockMercury.class, MERCURY_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(MERCURY_GRAVEL, MERCURY_GRAVEL.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(MERCURY_SPAWNER, ItemBlockGC.class, "mercury_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_4, ItemBlockDesc.class, TREASURE_CHEST_TIER_4.getUnlocalizedName().substring(5));
		}
		if (Config.CERES) {
			RegisterHelper.registerBlock(CERES_BLOCKS, ItemBlockCeres.class, CERES_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(CERES_GRAVEL, CERES_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			RegisterHelper.registerBlock(JUPITER_BLOCKS, ItemBlockJupiter.class, JUPITER_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(JUPITER_GRAVEL, JUPITER_GRAVEL.getUnlocalizedName().substring(5));

			RegisterHelper.registerBlock(JUIPTER_SPAWNER, ItemBlockGC.class, "jupiter_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_5, ItemBlockDesc.class, TREASURE_CHEST_TIER_5.getUnlocalizedName().substring(5));

			RegisterHelper.registerBlock(VOLCANIC_ROCK, VOLCANIC_ROCK.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(ASH_ROCK, ASH_ROCK.getUnlocalizedName().substring(5));

		}
		if (Config.SATURN) {
			RegisterHelper.registerBlock(SATURN_BLOCKS, ItemBlockSaturn.class, SATURN_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(SATURN_GRAVEL, SATURN_GRAVEL.getUnlocalizedName().substring(5));

			RegisterHelper.registerBlock(SATURN_SPAWNER, ItemBlockGC.class, "saturn_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_6, ItemBlockDesc.class, TREASURE_CHEST_TIER_6.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			RegisterHelper.registerBlock(URANUS_BLOCKS, ItemBlockUranus.class, URANUS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(URANUS_SPAWNER, ItemBlockGC.class, "uranus_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_7, ItemBlockDesc.class, TREASURE_CHEST_TIER_7.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(DENSE_ICE, DENSE_ICE.getUnlocalizedName().substring(5));
		}
		if (Config.NEPTUNE) {
			RegisterHelper.registerBlock(NEPTUNE_BLOCKS, ItemBlockNeptune.class, NEPTUNE_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(NEPTUNE_SPAWNER, ItemBlockGC.class, "neptune_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_8, ItemBlockDesc.class, TREASURE_CHEST_TIER_8.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(FROZEN_NITROGEN, FROZEN_NITROGEN.getUnlocalizedName().substring(5));
		}
		if (Config.PLUTO) {
			RegisterHelper.registerBlock(PLUTO_BLOCKS, ItemBlockPluto.class, PLUTO_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(PLUTO_SPAWNER, ItemBlockGC.class, "pluto_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_9, ItemBlockDesc.class, TREASURE_CHEST_TIER_9.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(PLUTO_GRAVEL, PLUTO_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.ERIS) {
			RegisterHelper.registerBlock(ERIS_BLOCKS, ItemBlockEris.class, ERIS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(ERIS_SPAWNER, ItemBlockGC.class, "eris_spawner");
			RegisterHelper.registerBlock(TREASURE_CHEST_TIER_10, ItemBlockDesc.class, TREASURE_CHEST_TIER_10.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(ERIS_GRAVEL, ERIS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterHelper.registerBlock(KEPLER22B_BLOCKS, ItemBlockKepler22b.class, KEPLER22B_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(KEPLER22B_GRASS_GREEN, KEPLER22B_GRASS_GREEN.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(KEPLER22B_GRASS_BLUE, KEPLER22B_GRASS_BLUE.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(KEPLER22B_GRASS_PURPLE, KEPLER22B_GRASS_PURPLE.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(KEPLER22B_GRASS_RED, KEPLER22B_GRASS_RED.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(KEPLER22B_GRASS_YELLOW, KEPLER22B_GRASS_YELLOW.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(KEPLER22B_MAPLE_FLOWERS, ItemBlockKepler22bTallGrass.class, KEPLER22B_MAPLE_FLOWERS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(RED_SAND, RED_SAND.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(RED_SANDSTONE, RED_SANDSTONE.getUnlocalizedName().substring(5));

		}

		if (Config.EUROPA) {
			RegisterHelper.registerBlock(EUROPA_BLOCKS, ItemBlockEuropa.class, EUROPA_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(EUROPA_GRAVEL, EUROPA_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.IO) {
			RegisterHelper.registerBlock(IO_BLOCKS, ItemBlockIo.class, IO_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(IO_GRAVEL, IO_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.DEIMOS) {
			RegisterHelper.registerBlock(DEIMOS_BLOCKS, ItemBlockDeimos.class, DEIMOS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(DEIMOS_GRAVEL, DEIMOS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.PHOBOS) {
			RegisterHelper.registerBlock(PHOBOS_BLOCKS, ItemBlockPhobos.class, PHOBOS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(PHOBOS_GRAVEL, PHOBOS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.TRITON) {
			RegisterHelper.registerBlock(TRITON_BLOCKS, ItemBlockTriton.class, TRITON_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(TRITON_GRAVEL, TRITON_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.CALLISTO) {
			RegisterHelper.registerBlock(CALLISTO_BLOCKS, ItemBlockCallisto.class, CALLISTO_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(CALLISTO_GRAVEL, CALLISTO_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.GANYMEDE) {
			RegisterHelper.registerBlock(GANYMEDE_BLOCKS, ItemBlockGanymede.class, GANYMEDE_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(GANYMEDE_GRAVEL, GANYMEDE_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.RHEA) {
			RegisterHelper.registerBlock(RHEA_BLOCKS, ItemBlockRhea.class, RHEA_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(RHEA_GRAVEL, RHEA_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.TITAN) {
			RegisterHelper.registerBlock(TITAN_BLOCKS, ItemBlockTitan.class, TITAN_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(TITAN_GRAVEL, TITAN_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.OBERON) {
			RegisterHelper.registerBlock(OBERON_BLOCKS, ItemBlockOberon.class, OBERON_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(OBERON_GRAVEL, OBERON_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.TITANIA) {
			RegisterHelper.registerBlock(TITANIA_BLOCKS, ItemBlockTitania.class, TITANIA_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(TITANIA_GRAVEL, TITANIA_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.IAPETUS) {
			RegisterHelper.registerBlock(IAPETUS_BLOCKS, ItemBlockIapetus.class, IAPETUS_BLOCKS.getUnlocalizedName().substring(5));
			RegisterHelper.registerBlock(IAPETUS_GRAVEL, IAPETUS_GRAVEL.getUnlocalizedName().substring(5));
		}
		if (Config.MERCURY || Config.CERES || Config.PLUTO || Config.ERIS)
			RegisterHelper.registerBlock(FOSSIL, FOSSIL.getUnlocalizedName().substring(5));
		if (Config.CERES && Config.NUCLEAR_BOMB)
			RegisterHelper.registerBlock(NUCLEAR_BOMB, NUCLEAR_BOMB.getUnlocalizedName().substring(5));
		if (Config.SATURN && Config.FIRE_BOMB)
			RegisterHelper.registerBlock(FIRE_BOMB, FIRE_BOMB.getUnlocalizedName().substring(5));
		if (Config.ORE_LEAD_GENERATION)
			RegisterHelper.registerBlock(ORE_LEAD, ORE_LEAD.getUnlocalizedName().substring(5));
		if (Config.RADIATION)
			RegisterHelper.registerBlock(ORE_POTASH, "potash");

		RegisterHelper.registerBlock(ADVANCED_LAUCHPAD, ItemBlockCustomLandingPad.class, ADVANCED_LAUCHPAD.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(ADVANCED_LAUCHPAD_FULL, ItemBlockGC.class, ADVANCED_LAUCHPAD_FULL.getUnlocalizedName().substring(5));

		RegisterHelper.registerBlock(FAKE_BLOCK, ItemBlockDummy.class, FAKE_BLOCK.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(DECORATIVE_BLOCKS, ItemBlockDecorativeBlocks.class, DECORATIVE_BLOCKS.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(DECORATIVE_BLOCKS2, ItemBlockDecorativeBlocks2.class, DECORATIVE_BLOCKS2.getUnlocalizedName().substring(5));
	}

	private static void registerTileEntitys() {
		if (Config.MERCURY) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerMercury.class, Constants.modName + "Mercury Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT4TreasureChest.class, Constants.modName + "Tier 4 Treasure Chest");
		}
		if (Config.JUPITER) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerJupiter.class, Constants.modName + "Juptier Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT5TreasureChest.class, Constants.modName + "Tier 5 Treasure Chest");
		}
		if (Config.SATURN) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerSaturn.class, Constants.modName + "Saturn Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, Constants.modName + "Tier 6 Treasure Chest");
		}
		if (Config.URANUS) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerUranus.class, Constants.modName + "Uranus Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, Constants.modName + "Tier 7 Treasure Chest");
		}
		if (Config.NEPTUNE) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerNeptune.class, Constants.modName + "Neptune Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, Constants.modName + "Tier 8 Treasure Chest");
		}
		if (Config.PLUTO) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerPluto.class, Constants.modName + "PLUTO Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT9TreasureChest.class, Constants.modName + "Tier 9 Treasure Chest");
		}
		if (Config.ERIS) {
			GameRegistry.registerTileEntity(TileEntityDungeonSpawnerEris.class, Constants.modName + "Eris Dungeon Spawner");
			GameRegistry.registerTileEntity(TileEntityT10TreasureChest.class, Constants.modName + "Tier 10 Treasure Chest");
		}
		GameRegistry.registerTileEntity(TileEntityTier2LandingPadSingle.class, "Tier 2 Landing Pad");
		GameRegistry.registerTileEntity(TileEntityTier2LandingPad.class, "Tier 2 Landing Pad Full");

		GameRegistry.registerTileEntity(TileEntityTier3LandingPadSingle.class, "Tier 3 Landing Pad");
		GameRegistry.registerTileEntity(TileEntityTier3LandingPad.class, "Tier 3 Landing Pad Full");

		GameRegistry.registerTileEntity(TileEntityPoweredChargingPadSingle.class, "Powered Charging Pad");
		GameRegistry.registerTileEntity(TileEntityPoweredChargingPad.class, "Powered Charging Pad Full");
		
		GameRegistry.registerTileEntity(TileEntityRocketChargingPadSingle.class, "Rocket Charging Pad");
		GameRegistry.registerTileEntity(TileEntityRocketChargingPad.class, "Rocket Charging Pad Full");
	}

	private static void setHarvestLevels() {
		if (Config.MERCURY) {
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 2, 6); // Mercury Ore
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 1, 7); // Mercury Block
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 2, 10); // Carbon Ore
			RegisterHelper.setHarvestLevel(MERCURY_BLOCKS, "pickaxe", 1, 11); // Carbon Block
		}
		if (Config.JUPITER) {
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 2, 6); // Palladium Ore
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 1, 7); // Palladium Block
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 2, 10); // Red Gem Ore
			RegisterHelper.setHarvestLevel(JUPITER_BLOCKS, "pickaxe", 1, 11); // Red Gem Block
		}
		if (Config.SATURN) {
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 2, 6); // Magnesium Ore
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 1, 7); // Magnesium Block
			RegisterHelper.setHarvestLevel(SATURN_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.URANUS) {
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 2, 3); // Crystal Ore
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 1, 4); // Crystal Block
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 1, 5); // Stone Bricks
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 2, 7); // White Gem Ore
			RegisterHelper.setHarvestLevel(URANUS_BLOCKS, "pickaxe", 1, 8); // White Gem Block
		}
		if (Config.NEPTUNE) {
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 2, 6); // Zinc Ore
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 1, 7); // Zinc Block
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 2, 10); // Blue Gem Ore
			RegisterHelper.setHarvestLevel(NEPTUNE_BLOCKS, "pickaxe", 1, 11); // Blue Gem Block
		}
		if (Config.PLUTO) {
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 2, 6); // Tungsten Ore
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 1, 7); // Tungsten Block
			RegisterHelper.setHarvestLevel(PLUTO_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.ERIS) {
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 2, 6); // Dark Iron Ore
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 1, 7); // Dark Iron Block
			RegisterHelper.setHarvestLevel(ERIS_BLOCKS, "pickaxe", 1, 8); // Stone Bricks
		}
		if (Config.CALLISTO) {
			RegisterHelper.setHarvestLevel(CALLISTO_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(CALLISTO_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(CALLISTO_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(CALLISTO_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(CALLISTO_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(CALLISTO_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.DEIMOS) {
			RegisterHelper.setHarvestLevel(DEIMOS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(DEIMOS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(DEIMOS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(DEIMOS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(DEIMOS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(DEIMOS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.EUROPA) {
			RegisterHelper.setHarvestLevel(EUROPA_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(EUROPA_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(EUROPA_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(EUROPA_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(EUROPA_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(EUROPA_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.GANYMEDE) {
			RegisterHelper.setHarvestLevel(GANYMEDE_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(GANYMEDE_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(GANYMEDE_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(GANYMEDE_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(GANYMEDE_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(GANYMEDE_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.IO) {
			RegisterHelper.setHarvestLevel(IO_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(IO_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(IO_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(IO_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(IO_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(IO_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.PHOBOS) {
			RegisterHelper.setHarvestLevel(PHOBOS_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(PHOBOS_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(PHOBOS_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(PHOBOS_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(PHOBOS_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(PHOBOS_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.RHEA) {
			RegisterHelper.setHarvestLevel(RHEA_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(RHEA_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(RHEA_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(RHEA_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(RHEA_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(RHEA_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.TITAN) {
			RegisterHelper.setHarvestLevel(TITAN_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(TITAN_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(TITAN_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(TITAN_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(TITAN_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(TITAN_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.TRITON) {
			RegisterHelper.setHarvestLevel(TRITON_BLOCKS, "pickaxe", 0, 0); // Surface
			RegisterHelper.setHarvestLevel(TRITON_BLOCKS, "pickaxe", 0, 1); // Sub Surface
			RegisterHelper.setHarvestLevel(TRITON_BLOCKS, "pickaxe", 1, 2); // Stone
			RegisterHelper.setHarvestLevel(TRITON_BLOCKS, "pickaxe", 2, 3); // Iron Ore
			RegisterHelper.setHarvestLevel(TRITON_BLOCKS, "pickaxe", 2, 4); // Tin Ore
			RegisterHelper.setHarvestLevel(TRITON_BLOCKS, "pickaxe", 2, 5); // Copper Ore
		}
		if (Config.ORE_LEAD_GENERATION)
			RegisterHelper.setHarvestLevel(ORE_LEAD, "pickaxe", 2, 0); // Lead Ore
	}

	public static void OreDictionaryRegister() {
		if (Config.MERCURY) {
			OreDictionary.registerOre("oreCopper", new ItemStack(MERCURY_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(MERCURY_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(MERCURY_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreMercury", new ItemStack(MERCURY_BLOCKS, 1, 6));
			OreDictionary.registerOre("oreCarbon", new ItemStack(MERCURY_BLOCKS, 1, 10));
			OreDictionary.registerOre("blockCarbon", new ItemStack(MERCURY_BLOCKS, 1, 11));
		}
		if (Config.CERES) {
			OreDictionary.registerOre("oreCopper", new ItemStack(CERES_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(CERES_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(CERES_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreUranium", new ItemStack(CERES_BLOCKS, 1, 6));
			OreDictionary.registerOre("blockUranium", new ItemStack(CERES_BLOCKS, 1, 7));
		}
		if (Config.JUPITER) {
			OreDictionary.registerOre("oreCopper", new ItemStack(JUPITER_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(JUPITER_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(JUPITER_BLOCKS, 1, 3));
			OreDictionary.registerOre("orePalladium", new ItemStack(JUPITER_BLOCKS, 1, 6));
			OreDictionary.registerOre("oreNickel", new ItemStack(JUPITER_BLOCKS, 1, 7));
			OreDictionary.registerOre("oreRedGem", new ItemStack(JUPITER_BLOCKS, 1, 10));
			OreDictionary.registerOre("blockPalladium", new ItemStack(JUPITER_BLOCKS, 1, 8));
			OreDictionary.registerOre("blockRedGem", new ItemStack(JUPITER_BLOCKS, 1, 11));
		}
		if (Config.SATURN) {
			OreDictionary.registerOre("oreCopper", new ItemStack(SATURN_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(SATURN_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(SATURN_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreMagnesium", new ItemStack(SATURN_BLOCKS, 1, 6));
			OreDictionary.registerOre("blockMagnesium", new ItemStack(SATURN_BLOCKS, 1, 7));
		}
		if (Config.URANUS) {
			OreDictionary.registerOre("oreCrystal", new ItemStack(URANUS_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreWhiteGem", new ItemStack(URANUS_BLOCKS, 1, 6));
			OreDictionary.registerOre("blockCrystal", new ItemStack(URANUS_BLOCKS, 1, 4));
			OreDictionary.registerOre("blockWhiteGem", new ItemStack(URANUS_BLOCKS, 1, 7));
		}
		if (Config.NEPTUNE) {
			OreDictionary.registerOre("oreCopper", new ItemStack(NEPTUNE_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(NEPTUNE_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(NEPTUNE_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreZinc", new ItemStack(NEPTUNE_BLOCKS, 1, 6));
			OreDictionary.registerOre("oreBlueGem", new ItemStack(NEPTUNE_BLOCKS, 1, 9));
			OreDictionary.registerOre("blockZinc", new ItemStack(NEPTUNE_BLOCKS, 1, 7));
			OreDictionary.registerOre("blockBlueGem", new ItemStack(NEPTUNE_BLOCKS, 1, 10));
		}
		if (Config.PLUTO) {
			OreDictionary.registerOre("oreCopper", new ItemStack(PLUTO_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(PLUTO_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(PLUTO_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreTungsten", new ItemStack(PLUTO_BLOCKS, 1, 6));
			OreDictionary.registerOre("blockTungsten", new ItemStack(PLUTO_BLOCKS, 1, 7));
		}
		if (Config.ERIS) {
			OreDictionary.registerOre("oreCopper", new ItemStack(ERIS_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(ERIS_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(ERIS_BLOCKS, 1, 3));
		}
		if (Config.CALLISTO) {
			OreDictionary.registerOre("oreCopper", new ItemStack(CALLISTO_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(CALLISTO_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(CALLISTO_BLOCKS, 1, 3));
		}
		if (Config.DEIMOS) {
			OreDictionary.registerOre("oreCopper", new ItemStack(DEIMOS_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(DEIMOS_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(DEIMOS_BLOCKS, 1, 3));
		}
		if (Config.EUROPA) {
			OreDictionary.registerOre("oreCopper", new ItemStack(EUROPA_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(EUROPA_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(EUROPA_BLOCKS, 1, 3));
		}
		if (Config.GANYMEDE) {
			OreDictionary.registerOre("oreCopper", new ItemStack(GANYMEDE_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(GANYMEDE_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(GANYMEDE_BLOCKS, 1, 3));
		}
		if (Config.IO) {
			OreDictionary.registerOre("oreCopper", new ItemStack(IO_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(IO_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(IO_BLOCKS, 1, 3));
		}
		if (Config.PHOBOS) {
			OreDictionary.registerOre("oreCopper", new ItemStack(PHOBOS_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(PHOBOS_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(PHOBOS_BLOCKS, 1, 3));
		}
		if (Config.RHEA) {
			OreDictionary.registerOre("oreCopper", new ItemStack(RHEA_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(RHEA_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(RHEA_BLOCKS, 1, 3));
		}
		if (Config.TITAN) {
			OreDictionary.registerOre("oreCopper", new ItemStack(TITAN_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(TITAN_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(TITAN_BLOCKS, 1, 3));
		}
		if (Config.TRITON) {
			OreDictionary.registerOre("oreCopper", new ItemStack(TRITON_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(TRITON_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(TRITON_BLOCKS, 1, 3));
		}
		if (Config.OBERON) {
			OreDictionary.registerOre("oreCopper", new ItemStack(OBERON_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(OBERON_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(OBERON_BLOCKS, 1, 3));
		}
		if (Config.IAPETUS) {
			OreDictionary.registerOre("oreCopper", new ItemStack(IAPETUS_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(IAPETUS_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(IAPETUS_BLOCKS, 1, 3));
		}
		if (Config.TITANIA) {
			OreDictionary.registerOre("oreCopper", new ItemStack(TITANIA_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(TITANIA_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(TITANIA_BLOCKS, 1, 3));
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			OreDictionary.registerOre("stone", new ItemStack(KEPLER22B_BLOCKS, 1, 1));
			OreDictionary.registerOre("oreIron", new ItemStack(KEPLER22B_BLOCKS, 1, 2));
			OreDictionary.registerOre("oreCopper", new ItemStack(KEPLER22B_BLOCKS, 1, 3));
			OreDictionary.registerOre("oreTin", new ItemStack(KEPLER22B_BLOCKS, 1, 4));
			OreDictionary.registerOre("oreDenseCoal", new ItemStack(KEPLER22B_BLOCKS, 1, 5));
			OreDictionary.registerOre("oreBlueDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 6));
			OreDictionary.registerOre("oreRedDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 7));
			OreDictionary.registerOre("orePurpleDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 8));
			OreDictionary.registerOre("oreYellowDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 9));
			OreDictionary.registerOre("oreGreenDiamond", new ItemStack(KEPLER22B_BLOCKS, 1, 10));
			OreDictionary.registerOre("cobblestone", new ItemStack(KEPLER22B_BLOCKS, 1, 12));
		}
		if (Config.ORE_LEAD_GENERATION) {
			OreDictionary.registerOre("oreLead", new ItemStack(ORE_LEAD, 1, 0));
			GameRegistry.registerWorldGenerator(new WorldGenerationOverworld(), 1);
		}
	}

	private static void registerTreeBlocks() throws NoSuchMethodException {
		RegisterHelper.registerBlock(KEPLER22B_MAPLE_LOG, ItemBlockKepler22bMapleLog.class, KEPLER22B_MAPLE_LOG.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(KEPLER22B_MAPLE_LOG_2, ItemBlockKepler22bMapleLog2.class, KEPLER22B_MAPLE_LOG_2.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(KEPLER22B_MAPLE_SAPLING, ItemBlockKepler22bMapleSapling.class, KEPLER22B_MAPLE_SAPLING.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(KEPLER22B_MAPLE_LEAF, ItemBlockKepler22bMapleLeaf.class, KEPLER22B_MAPLE_LEAF.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(KEPLER22B_MAPLE_LEAF2, ItemBlockKepler22bMapleLeaf2.class, KEPLER22B_MAPLE_LEAF2.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(KEPLER22B_MAPLE_PLANKS, ItemBlockKepler22bPlanks.class, KEPLER22B_MAPLE_PLANKS.getUnlocalizedName().substring(5));
	}
}
