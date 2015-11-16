package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.machines.AdvancedRefinery;
import com.mjr.extraplanets.blocks.machines.BlockSolar;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCeres;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicDeimos;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEris;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEuropa;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIo;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicMercury;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPhobos;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPluto;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTriton;
import com.mjr.extraplanets.blocks.treasureChest.T4TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T5TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T6TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T7TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T8TreasureChest;
import com.mjr.extraplanets.items.ItemBlockSolar;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockCeres;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockDeimos;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockEris;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockEuropa;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockIo;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockMercury;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockPhobos;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockPluto;
import com.mjr.extraplanets.items.planetAndMoonBlocks.ItemBlockTriton;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.DungeonSpawnerJuptier;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.TileEntityDungeonSpawnerJupiter;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.DungeonSpawnerNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.planets.Saturn.worldgen.dungeon.DungeonSpawnerSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.dungeon.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.DungeonSpawnerUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.TileEntityDungeonSpawnerUranus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.DungeonSpawnerVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.TileEntityDungeonSpawnerVenus;
import com.mjr.extraplanets.tile.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.TileEntitySolar;
import com.mjr.extraplanets.tile.TileEntityT4TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT5TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT7TreasureChest;
import com.mjr.extraplanets.tile.TileEntityT8TreasureChest;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanetsBlocks {
	public static Block mercuryBlocks;
	public static Block ceresBlocks;
	public static Block plutoBlocks;
	public static Block erisBlocks;

	public static Block callistoBlocks;
	public static Block deimosBlocks;
	public static Block europaBlocks;
	public static Block ioBlocks;
	public static Block phobosBlocks;
	public static Block tritonBlocks;
	public static Block ganymedeBlocks;

	// Machines
	public static Block advancedRefinery;
	public static Block solarPanel;

	// Gravel
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

	// Other Special Blocks
	public static Block nuclearBomb;
	public static Block fossil;
	public static Block denseIce;
	public static Block volcanicRock;
	public static Block frozenNitrogen;

	// Need Changing to meta block -----------------------------------------
	public static Block venusSurface;
	public static Block venusSubSurface;
	public static Block venusStone;

	public static Block jupiterSurface;
	public static Block jupiterSubSurface;
	public static Block jupiterStone;

	public static Block saturnSurface;
	public static Block saturnSubSurfacee;
	public static Block saturnStone;

	public static Block uranusSurface;
	public static Block uranusSubSurface;
	public static Block uranusStone;

	public static Block neptuneSurface;
	public static Block neptuneSubSurface;
	public static Block neptuneStone;

	public static Block venusOreCopper;
	public static Block venusOreTin;
	public static Block venusOreIron;

	public static Block jupiterOreCopper;
	public static Block jupiterOreTin;
	public static Block jupiterOreIron;

	public static Block saturnOreCopper;
	public static Block saturnOreTin;
	public static Block saturnOreIron;

	public static Block neptuneOreCopper;
	public static Block neptuneOreTin;
	public static Block neptuneOreIron;

	public static Block OreCarbon;
	public static Block OreCrystal;
	public static Block OrePalladium;
	public static Block OreMagnesium;

	public static Block OreNickel;
	public static Block OreZinc;
	public static Block OreUranium;

	public static Block veunsDungeonBrick;
	public static Block jupiterDungeonBrick;
	public static Block saturnDungeonBrick;
	public static Block uranusDungeonBrick;
	public static Block neptuneDungeonBrick;

	public static Block treasureChestTier4;
	public static Block treasureChestTier5;
	public static Block treasureChestTier6;
	public static Block treasureChestTier7;
	public static Block treasureChestTier8;

	public static Block venusSpawner;
	public static Block jupiterSpawner;
	public static Block saturnSpawner;
	public static Block uranusSpawner;
	public static Block neptuneSpawner;

	// ----------------------------------------------------------------------

	public static void init() {
		initializeBlocks();
		initializeOreBlocks();
		initializeDungeonBlocks();
		initializeTreasureChestBlocks();
		initializeSpawnerBlocks();
		initializeMachinesBlocks();

		registerBlocks();
		registerMachines();

		registerTileEntitys();
		OreDictionaryRegister();
		ExtraPlanetsSlabsStairsBlocks.init();
	}

	private static void initializeBlocks() {
		if (Config.mercury) {
			mercuryBlocks = new BlockBasicMercury("mercury");
			mercuryGravel = new BlockCustomGravel("mercuryGravel");
		}
		if (Config.venus) {
			venusSurface = new BlockBasic(Material.rock).setBlockName("venusSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			venusSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			venusSubSurface = new BlockBasic(Material.rock).setBlockName("venusSubSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusSubSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			venusSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			venusStone = new BlockBasic(Material.rock).setBlockName("venusStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusStone").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			venusStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			venusGravel = new BlockCustomGravel("venusGravel");

			volcanicRock = new BlockBasic(Material.rock).setBlockName("volcanicRock").setBlockTextureName(Constants.TEXTURE_PREFIX + "volcanicRock").setHardness(3.0F).setResistance(6.0F).setStepSound(Block.soundTypeStone);
		}
		if (Config.ceres) {
			ceresBlocks = new BlockBasicCeres("ceres");
			ceresGravel = new BlockCustomGravel("ceresGravel");
		}
		if (Config.jupiter) {
			jupiterSurface = new BlockBasic(Material.rock).setBlockName("jupiterSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			jupiterSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			jupiterSubSurface = new BlockBasic(Material.rock).setBlockName("jupiterSubSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterSubSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			jupiterSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			jupiterStone = new BlockBasic(Material.rock).setBlockName("jupiterStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterStone").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			jupiterStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			jupiterGravel = new BlockCustomGravel("jupiterGravel");
		}
		if (Config.saturn) {
			saturnSurface = new BlockBasic(Material.rock).setBlockName("saturnSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			saturnSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			saturnSubSurfacee = new BlockBasic(Material.rock).setBlockName("saturnSubSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnSubSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			saturnSubSurfacee.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			saturnStone = new BlockBasic(Material.rock).setBlockName("saturnStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnStone").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			saturnStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			saturnGravel = new BlockCustomGravel("saturnGravel");
		}
		if (Config.uranus) {
			uranusSurface = new BlockBasic(Material.ice).setBlockName("uranusSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			uranusSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			uranusSubSurface = new BlockBasic(Material.ice).setBlockName("uranusSubSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusSubSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			uranusSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			uranusStone = new BlockBasic(Material.ice).setBlockName("uranusStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusStone").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			uranusStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			denseIce = new BlockBasic(Material.ice).setBlockName("denseIce").setBlockTextureName(Constants.TEXTURE_PREFIX + "denseIce").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeSnow);
		}
		if (Config.neptune) {
			neptuneSurface = new BlockBasic(Material.rock).setBlockName("neptuneSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			neptuneSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			neptuneSubSurface = new BlockBasic(Material.rock).setBlockName("neptuneSubSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneSubSurface").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			neptuneSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

			neptuneStone = new BlockBasic(Material.rock).setBlockName("neptuneStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneStone").setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
			neptuneStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

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
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			fossil = new BlockFossil(Material.rock).setBlockName("fossil").setBlockTextureName(Constants.TEXTURE_PREFIX + "fossil").setHardness(2.5F).setResistance(1.0F);
		if (Config.ceres)
			nuclearBomb = new BlockNuclearBomb();
	}

	private static void initializeOreBlocks() {
		if (Config.venus) {
			venusOreCopper = new BlockOre(Material.rock).setBlockName("venusOreCopper").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusOreCopper").setStepSound(Block.soundTypeMetal);
			venusOreCopper.setHarvestLevel("pickaxe", 2);

			venusOreTin = new BlockOre(Material.rock).setBlockName("venusOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusOreTin").setStepSound(Block.soundTypeMetal);
			venusOreTin.setHarvestLevel("pickaxe", 2);

			venusOreIron = new BlockOre(Material.rock).setBlockName("venusOreIron").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusOreIron").setStepSound(Block.soundTypeMetal);
			venusOreIron.setHarvestLevel("pickaxe", 1);

			OreCarbon = new BlockOre(Material.rock).setBlockName("OreCarbon").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreCarbon").setStepSound(Block.soundTypeMetal);
			OreCarbon.setHarvestLevel("pickaxe", 2);
		}
		if (Config.ceres) {
			OreUranium = new BlockOre(Material.rock).setBlockName("OreUranium").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreUranium").setStepSound(Block.soundTypeMetal);
			OreUranium.setHarvestLevel("pickaxe", 4);
		}
		if (Config.jupiter) {
			jupiterOreCopper = new BlockOre(Material.rock).setBlockName("jupiterOreCopper").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterOreCopper").setStepSound(Block.soundTypeMetal);
			jupiterOreCopper.setHarvestLevel("pickaxe", 2);

			jupiterOreTin = new BlockOre(Material.rock).setBlockName("jupiterOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterOreTin").setStepSound(Block.soundTypeMetal);
			jupiterOreTin.setHarvestLevel("pickaxe", 2);

			jupiterOreIron = new BlockOre(Material.rock).setBlockName("jupiterOreIron").setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterOreIron").setStepSound(Block.soundTypeMetal);
			jupiterOreIron.setHarvestLevel("pickaxe", 1);

			OrePalladium = new BlockOre(Material.rock).setBlockName("OrePalladium").setBlockTextureName(Constants.TEXTURE_PREFIX + "OrePalladium").setStepSound(Block.soundTypeMetal);
			OrePalladium.setHarvestLevel("pickaxe", 3);

			OreNickel = new BlockOre(Material.rock).setBlockName("OreNickel").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreNickel").setStepSound(Block.soundTypeMetal);
			OreNickel.setHarvestLevel("pickaxe", 4);
		}
		if (Config.saturn) {
			saturnOreCopper = new BlockOre(Material.rock).setBlockName("saturnOreCopper").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnOreCopper").setStepSound(Block.soundTypeMetal);
			saturnOreCopper.setHarvestLevel("pickaxe", 2);

			saturnOreTin = new BlockOre(Material.rock).setBlockName("saturnOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnOreTin").setStepSound(Block.soundTypeMetal);
			saturnOreTin.setHarvestLevel("pickaxe", 2);

			saturnOreIron = new BlockOre(Material.rock).setBlockName("saturnOreIron").setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnOreIron").setStepSound(Block.soundTypeMetal);
			saturnOreIron.setHarvestLevel("pickaxe", 1);

			OreMagnesium = new BlockOre(Material.rock).setBlockName("OreMagnesium").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreMagnesium").setStepSound(Block.soundTypeMetal);
			OreMagnesium.setHarvestLevel("pickaxe", 4);

		}
		if (Config.neptune) {
			neptuneOreCopper = new BlockOre(Material.rock).setBlockName("neptuneOreCopper").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneOreCopper").setStepSound(Block.soundTypeMetal);
			neptuneOreCopper.setHarvestLevel("pickaxe", 2);

			neptuneOreTin = new BlockOre(Material.rock).setBlockName("neptuneOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneOreTin").setStepSound(Block.soundTypeMetal);
			neptuneOreTin.setHarvestLevel("pickaxe", 2);

			neptuneOreIron = new BlockOre(Material.rock).setBlockName("neptuneOreIron").setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneOreIron").setStepSound(Block.soundTypeMetal);
			neptuneOreIron.setHarvestLevel("pickaxe", 1);

			OreCrystal = new BlockOre(Material.rock).setBlockName("OreCrystal").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreCrystal").setStepSound(Block.soundTypeMetal);
			OreCrystal.setHarvestLevel("pickaxe", 5);

			OreZinc = new BlockOre(Material.rock).setBlockName("OreZinc").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreZinc").setStepSound(Block.soundTypeMetal);
			OreZinc.setHarvestLevel("pickaxe", 6);
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
			// // 2
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
	}

	private static void initializeMachinesBlocks() {
		advancedRefinery = new AdvancedRefinery("advancedRefinery");
		solarPanel = new BlockSolar("solar");
	}

	private static void registerBlocks() {
		if (Config.mercury) {
			GameRegistry.registerBlock(mercuryBlocks, ItemBlockMercury.class, mercuryBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(mercuryGravel, "mercuryGravel");
		}
		if (Config.venus) {
			GameRegistry.registerBlock(OreCarbon, "OreCarbon");
			GameRegistry.registerBlock(venusSurface, "venusSurface");
			GameRegistry.registerBlock(venusSubSurface, "venusSubSurface");
			GameRegistry.registerBlock(venusStone, "venusStone");

			GameRegistry.registerBlock(venusOreCopper, "venusOreCopper");
			GameRegistry.registerBlock(venusOreTin, "venusOreTin");
			GameRegistry.registerBlock(venusOreIron, "venusOreIron");

			GameRegistry.registerBlock(venusGravel, "venusGravel");

			GameRegistry.registerBlock(venusSpawner, "venusSpawner");
			GameRegistry.registerBlock(veunsDungeonBrick, "veunsDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier4, ItemBlockDesc.class, treasureChestTier4.getUnlocalizedName());
			GameRegistry.registerBlock(volcanicRock, "volcanicRock");
		}
		if (Config.ceres) {
			GameRegistry.registerBlock(OreUranium, "OreUranium");
			GameRegistry.registerBlock(ceresBlocks, ItemBlockCeres.class, ceresBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(ceresGravel, "ceresGravel");
		}
		if (Config.jupiter) {
			GameRegistry.registerBlock(OreNickel, "OreNickel");
			GameRegistry.registerBlock(OrePalladium, "OrePalladium");
			GameRegistry.registerBlock(jupiterSurface, "jupiterSurface");
			GameRegistry.registerBlock(jupiterSubSurface, "jupiterSubSurface");
			GameRegistry.registerBlock(jupiterStone, "jupiterStone");

			GameRegistry.registerBlock(jupiterOreCopper, "jupiterOreCopper");
			GameRegistry.registerBlock(jupiterOreTin, "jupiterOreTin");
			GameRegistry.registerBlock(jupiterOreIron, "jupiterOreIron");

			GameRegistry.registerBlock(jupiterGravel, "jupiterGravel");

			GameRegistry.registerBlock(jupiterSpawner, "jupiterSpawner");
			GameRegistry.registerBlock(jupiterDungeonBrick, "jupiterDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier5, ItemBlockDesc.class, treasureChestTier5.getUnlocalizedName());
		}
		if (Config.saturn) {
			GameRegistry.registerBlock(OreMagnesium, "OreMagnesium");
			GameRegistry.registerBlock(saturnSurface, "saturnSurface");
			GameRegistry.registerBlock(saturnSubSurfacee, "saturnSubSurface");
			GameRegistry.registerBlock(saturnStone, "saturnStone");

			GameRegistry.registerBlock(saturnOreCopper, "saturnOreCopper");
			GameRegistry.registerBlock(saturnOreTin, "saturnOreTin");
			GameRegistry.registerBlock(saturnOreIron, "saturnOreIron");

			GameRegistry.registerBlock(saturnGravel, "saturnGravel");

			GameRegistry.registerBlock(saturnSpawner, "saturnSpawner");
			GameRegistry.registerBlock(saturnDungeonBrick, "saturnDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier6, ItemBlockDesc.class, treasureChestTier6.getUnlocalizedName());
		}
		if (Config.uranus) {
			GameRegistry.registerBlock(OreCrystal, "OreCrystal");
			GameRegistry.registerBlock(uranusSurface, "uranusSurface");
			GameRegistry.registerBlock(uranusSubSurface, "uranusSubSurface");
			GameRegistry.registerBlock(uranusStone, "uranusStone");

			GameRegistry.registerBlock(uranusSpawner, "uranusSpawner");
			GameRegistry.registerBlock(uranusDungeonBrick, "uranusDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier7, ItemBlockDesc.class, treasureChestTier7.getUnlocalizedName());
			GameRegistry.registerBlock(denseIce, "denseIce");
		}
		if (Config.neptune) {
			GameRegistry.registerBlock(OreZinc, "OreZinc");
			GameRegistry.registerBlock(neptuneSurface, "neptuneSurface");
			GameRegistry.registerBlock(neptuneSubSurface, "neptuneSubSurface");
			GameRegistry.registerBlock(neptuneStone, "neptuneStone");

			GameRegistry.registerBlock(neptuneOreCopper, "neptuneOreCopper");
			GameRegistry.registerBlock(neptuneOreTin, "neptuneOreTin");
			GameRegistry.registerBlock(neptuneOreIron, "neptuneOreIron");

			GameRegistry.registerBlock(neptuneSpawner, "neptuneSpawner");
			GameRegistry.registerBlock(neptuneDungeonBrick, "neptuneDungeonBrick");
			GameRegistry.registerBlock(treasureChestTier8, ItemBlockDesc.class, treasureChestTier8.getUnlocalizedName());
			GameRegistry.registerBlock(frozenNitrogen, "frozenNitrogen");
		}
		if (Config.pluto) {
			GameRegistry.registerBlock(plutoBlocks, ItemBlockPluto.class, plutoBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(plutoGravel, "plutoGravel");
		}
		if (Config.eris) {
			GameRegistry.registerBlock(erisBlocks, ItemBlockEris.class, erisBlocks.getUnlocalizedName());
			GameRegistry.registerBlock(erisGravel, "erisGravel");
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
		if (Config.mercury || Config.ceres || Config.pluto || Config.eris)
			GameRegistry.registerBlock(fossil, "fossil");
		if (Config.ceres)
			GameRegistry.registerBlock(nuclearBomb, "nuclearBomb");
	}

	private static void registerMachines() {
		GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
		GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
		GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
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

		GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
	}

	public static void OreDictionaryRegister() {
		if (Config.mercury) {
			OreDictionary.registerOre("oreCopper", new ItemStack(mercuryBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(mercuryBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(mercuryBlocks, 1, 3));
		}
		if (Config.venus) {
			OreDictionary.registerOre("oreCopper", new ItemStack(venusOreCopper));
			OreDictionary.registerOre("oreTin", new ItemStack(venusOreTin));
			OreDictionary.registerOre("oreIron", new ItemStack(venusOreIron));
		}
		if (Config.ceres) {
			OreDictionary.registerOre("oreCopper", new ItemStack(ceresBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(ceresBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(ceresBlocks, 1, 3));
			OreDictionary.registerOre("oreUranium", new ItemStack(OreUranium));
		}
		if (Config.jupiter) {
			OreDictionary.registerOre("oreCopper", new ItemStack(jupiterOreCopper));
			OreDictionary.registerOre("oreTin", new ItemStack(jupiterOreTin));
			OreDictionary.registerOre("oreIron", new ItemStack(jupiterOreIron));
		}
		if (Config.saturn) {
			OreDictionary.registerOre("oreCopper", new ItemStack(saturnOreCopper));
			OreDictionary.registerOre("oreTin", new ItemStack(saturnOreTin));
			OreDictionary.registerOre("oreIron", new ItemStack(saturnOreIron));
		}
		if (Config.neptune) {
			OreDictionary.registerOre("oreCopper", new ItemStack(neptuneOreCopper));
			OreDictionary.registerOre("oreTin", new ItemStack(neptuneOreTin));
			OreDictionary.registerOre("oreIron", new ItemStack(neptuneOreIron));
		}
		if (Config.pluto) {
			OreDictionary.registerOre("oreCopper", new ItemStack(plutoBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(plutoBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(plutoBlocks, 1, 3));
		}
		if (Config.eris) {
			OreDictionary.registerOre("oreCopper", new ItemStack(erisBlocks, 1, 5));
			OreDictionary.registerOre("oreTin", new ItemStack(erisBlocks, 1, 4));
			OreDictionary.registerOre("oreIron", new ItemStack(erisBlocks, 1, 3));
		}
	}
}
