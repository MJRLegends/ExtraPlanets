package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.machines.AdvancedRefinery;
import com.mjr.extraplanets.blocks.machines.BlockSolar;
import com.mjr.extraplanets.blocks.treasureChest.T4TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T5TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T6TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T7TreasureChest;
import com.mjr.extraplanets.blocks.treasureChest.T8TreasureChest;
import com.mjr.extraplanets.items.ItemBlockSolar;
import com.mjr.extraplanets.items.slabs.CeresStoneItemSlab;
import com.mjr.extraplanets.items.slabs.ErisStoneItemSlab;
import com.mjr.extraplanets.items.slabs.JupiterDungeonBrickStoneItemSlab;
import com.mjr.extraplanets.items.slabs.JupiterStoneItemSlab;
import com.mjr.extraplanets.items.slabs.MercuryStoneItemSlab;
import com.mjr.extraplanets.items.slabs.NeptuneDungeonBrickStoneItemSlab;
import com.mjr.extraplanets.items.slabs.NeptuneStoneItemSlab;
import com.mjr.extraplanets.items.slabs.PlutoStoneItemSlab;
import com.mjr.extraplanets.items.slabs.SaturnDungeonBrickStoneItemSlab;
import com.mjr.extraplanets.items.slabs.SaturnStoneItemSlab;
import com.mjr.extraplanets.items.slabs.UranusDungeonBrickStoneItemSlab;
import com.mjr.extraplanets.items.slabs.UranusStoneItemSlab;
import com.mjr.extraplanets.items.slabs.VenusDungeonBrickStoneItemSlab;
import com.mjr.extraplanets.items.slabs.VenusStoneItemSlab;
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
    public static int treasureT4ChestID;
    public static int treasureT5ChestID;
    public static int treasureT6ChestID;
    public static int treasureT7ChestID;
    public static int treasureT8ChestID;

    public static Block mercurySurface;
    public static Block mercurySubSurface;
    public static Block mercuryStone;

    public static Block venusSurface;
    public static Block venusSubSurface;
    public static Block venusStone;

    public static Block ceresSurface;
    public static Block ceresSubSurface;
    public static Block ceresStone;

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

    public static Block plutoSurface;
    public static Block plutoSubSurface;
    public static Block plutoStone;

    public static Block erisSurface;
    public static Block erisSubSurface;
    public static Block erisStone;

    public static Block europaSurface;
    public static Block europaSubSurface;
    public static Block europaStone;

    public static Block ioSurface;
    public static Block ioSubSurface;
    public static Block ioStone;

    public static Block deimosSurface;
    public static Block deimosSubSurface;
    public static Block deimosStone;

    public static Block phobosSurface;
    public static Block phobosSubSurface;
    public static Block phobosStone;

    public static Block tritonSurface;
    public static Block tritonSubSurface;
    public static Block tritonStone;

    public static Block mercuryOreCopper;
    public static Block mercuryOreTin;
    public static Block mercuryOreIron;

    public static Block venusOreCopper;
    public static Block venusOreTin;
    public static Block venusOreIron;

    public static Block ceresOreCopper;
    public static Block ceresOreTin;
    public static Block ceresOreIron;

    public static Block jupiterOreCopper;
    public static Block jupiterOreTin;
    public static Block jupiterOreIron;

    public static Block saturnOreCopper;
    public static Block saturnOreTin;
    public static Block saturnOreIron;

    public static Block neptuneOreCopper;
    public static Block neptuneOreTin;
    public static Block neptuneOreIron;

    public static Block plutoOreCopper;
    public static Block plutoOreTin;
    public static Block plutoOreIron;

    public static Block erisOreCopper;
    public static Block erisOreTin;
    public static Block erisOreIron;

    public static Block OreCarbon;
    public static Block OreCrystal;
    public static Block OrePalladium;
    public static Block OreMagnesium;

    public static Block OreNickel;
    public static Block OreZinc;
    public static Block OreMercury;
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

    // Machines
    public static Block advancedRefinery;
    public static Block solarPanel;

    // Slabs
    public static Block mercuryStoneBlockHalfSlab;
    public static Block mercuryStoneBlockDoubleSlab;

    public static Block venusStoneBlockHalfSlab;
    public static Block venusStoneBlockDoubleSlab;

    public static Block ceresStoneBlockHalfSlab;
    public static Block ceresStoneBlockDoubleSlab;

    public static Block jupiterStoneBlockHalfSlab;
    public static Block jupiterStoneBlockDoubleSlab;

    public static Block saturnStoneBlockHalfSlab;
    public static Block saturnStoneBlockDoubleSlab;

    public static Block uranusStoneBlockHalfSlab;
    public static Block uranusStoneBlockDoubleSlab;

    public static Block neptuneStoneBlockHalfSlab;
    public static Block neptuneStoneBlockDoubleSlab;

    public static Block plutoStoneBlockHalfSlab;
    public static Block plutoStoneBlockDoubleSlab;

    public static Block erisStoneBlockHalfSlab;
    public static Block erisStoneBlockDoubleSlab;

    public static Block venusDungeonBrickStoneBlockHalfSlab;
    public static Block venusDungeonBrickStoneBlockDoubleSlab;

    public static Block jupiterDungeonBrickStoneBlockHalfSlab;
    public static Block jupiterDungeonBrickStoneBlockDoubleSlab;

    public static Block saturnDungeonBrickStoneBlockHalfSlab;
    public static Block saturnDungeonBrickStoneBlockDoubleSlab;

    public static Block uranusDungeonBrickStoneBlockHalfSlab;
    public static Block uranusDungeonBrickStoneBlockDoubleSlab;

    public static Block neptuneDungeonBrickStoneBlockHalfSlab;
    public static Block neptuneDungeonBrickStoneBlockDoubleSlab;

    // Stairs
    public static Block mercuryStoneStairs;
    public static Block venusStoneStairs;
    public static Block ceresStoneStairs;
    public static Block jupiterStoneStairs;
    public static Block saturnStoneStairs;
    public static Block uranusStoneStairs;
    public static Block neptuneStoneStairs;
    public static Block plutoStoneStairs;
    public static Block erisStoneStairs;

    public static Block venusDungeonBrickStoneStairs;
    public static Block jupiterDungeonBrickStoneStairs;
    public static Block saturnDungeonBrickStoneStairs;
    public static Block uranusDungeonBrickStoneStairs;
    public static Block neptuneDungeonBrickStoneStairs;

    public static Block mercuryGravel;
    public static Block venusGravel;
    public static Block ceresGravel;
    public static Block jupiterGravel;
    public static Block saturnGravel;
    public static Block plutoGravel;
    public static Block erisGravel;

    public static Block nuclearBomb;
    public static Block fossil;

    public static void init() {
	initializeBlocks();
	initializeOreBlocks();
	initializeDungeonBlocks();
	initializeTreasureChestBlocks();
	initializeSpawnerBlocks();
	initializeMachinesBlocks();
	initializeSlabsAndStairsBlocks();
	registerBlocks();
	registerMachines();
	registerSlabsAndStairs();
	registerTileEntitys();
	OreDictionaryRegister();
    }

    private static void initializeBlocks() {
	mercurySurface = new BlockBasic(Material.rock).setBlockName("mercurySurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "mercurySurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	mercurySurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	mercurySubSurface = new BlockBasic(Material.rock).setBlockName("mercurySubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "mercurySubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	mercurySubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	mercuryStone = new BlockBasic(Material.rock).setBlockName("mercuryStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "mercuryStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	mercuryStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	venusSurface = new BlockBasic(Material.rock).setBlockName("venusSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "venusSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	venusSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	venusSubSurface = new BlockBasic(Material.rock).setBlockName("venusSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "venusSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	venusSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	venusStone = new BlockBasic(Material.rock).setBlockName("venusStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusStone")
		.setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
	venusStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	ceresSurface = new BlockBasic(Material.rock).setBlockName("ceresSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "ceresSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	ceresSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	ceresSubSurface = new BlockBasic(Material.rock).setBlockName("ceresSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "ceresSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	ceresSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	ceresStone = new BlockBasic(Material.rock).setBlockName("ceresStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "ceresStone")
		.setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
	ceresStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	jupiterSurface = new BlockBasic(Material.rock).setBlockName("jupiterSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	jupiterSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	jupiterSubSurface = new BlockBasic(Material.rock).setBlockName("jupiterSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	jupiterSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	jupiterStone = new BlockBasic(Material.rock).setBlockName("jupiterStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	jupiterStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	saturnSurface = new BlockBasic(Material.rock).setBlockName("saturnSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	saturnSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	saturnSubSurfacee = new BlockBasic(Material.rock).setBlockName("saturnSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	saturnSubSurfacee.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	saturnStone = new BlockBasic(Material.rock).setBlockName("saturnStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	saturnStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	uranusSurface = new BlockBasic(Material.ice).setBlockName("uranusSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	uranusSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	uranusSubSurface = new BlockBasic(Material.ice).setBlockName("uranusSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	uranusSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	uranusStone = new BlockBasic(Material.ice).setBlockName("uranusStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	uranusStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	neptuneSurface = new BlockBasic(Material.rock).setBlockName("neptuneSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	neptuneSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	neptuneSubSurface = new BlockBasic(Material.rock).setBlockName("neptuneSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	neptuneSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	neptuneStone = new BlockBasic(Material.rock).setBlockName("neptuneStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	neptuneStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	plutoSurface = new BlockBasic(Material.rock).setBlockName("plutoSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	plutoSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	plutoSubSurface = new BlockBasic(Material.rock).setBlockName("plutoSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	plutoSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	plutoStone = new BlockBasic(Material.rock).setBlockName("plutoStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoStone")
		.setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
	plutoStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	erisSurface = new BlockBasic(Material.rock).setBlockName("erisSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "erisSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	erisSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	erisSubSurface = new BlockBasic(Material.rock).setBlockName("erisSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "erisSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	erisSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	erisStone = new BlockBasic(Material.rock).setBlockName("erisStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "erisStone")
		.setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
	erisStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	europaSurface = new BlockBasic(Material.rock).setBlockName("europaSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "europaSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	europaSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	europaSubSurface = new BlockBasic(Material.rock).setBlockName("europaSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "europaSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	europaSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	europaStone = new BlockBasic(Material.rock).setBlockName("europaStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "europaStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	europaStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	ioSurface = new BlockBasic(Material.rock).setBlockName("ioSurface").setBlockTextureName(Constants.TEXTURE_PREFIX + "ioSurface")
		.setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
	ioSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	ioSubSurface = new BlockBasic(Material.rock).setBlockName("ioSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "ioSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	ioSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	ioStone = new BlockBasic(Material.rock).setBlockName("ioStone").setBlockTextureName(Constants.TEXTURE_PREFIX + "ioStone")
		.setHardness(2.2F).setResistance(3.0F).setStepSound(Block.soundTypeMetal);
	ioStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	deimosSurface = new BlockBasic(Material.rock).setBlockName("deimosSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "deimosSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	deimosSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	deimosSubSurface = new BlockBasic(Material.rock).setBlockName("deimosSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "deimosSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	deimosSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	deimosStone = new BlockBasic(Material.rock).setBlockName("deimosStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "deimosStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	deimosStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	phobosSurface = new BlockBasic(Material.rock).setBlockName("phobosSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "phobosSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	phobosSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	phobosSubSurface = new BlockBasic(Material.rock).setBlockName("phobosSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "phobosSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	phobosSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	phobosStone = new BlockBasic(Material.rock).setBlockName("phobosStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "phobosStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	phobosStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	tritonSurface = new BlockBasic(Material.rock).setBlockName("tritonSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "tritonSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	tritonSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	tritonSubSurface = new BlockBasic(Material.rock).setBlockName("tritonSubSurface")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "tritonSubSurface").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	tritonSubSurface.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	tritonStone = new BlockBasic(Material.rock).setBlockName("tritonStone")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "tritonStone").setHardness(2.2F).setResistance(3.0F)
		.setStepSound(Block.soundTypeMetal);
	tritonStone.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2

	mercuryGravel = new BlockCustomGravel("mercuryGravel");
	venusGravel = new BlockCustomGravel("venusGravel");
	ceresGravel = new BlockCustomGravel("ceresGravel");
	jupiterGravel = new BlockCustomGravel("jupiterGravel");
	saturnGravel = new BlockCustomGravel("saturnGravel");
	plutoGravel = new BlockCustomGravel("plutoGravel");
	erisGravel = new BlockCustomGravel("erisGravel");

	nuclearBomb = new BlockNuclearBomb();

	fossil = new BlockFossil(Material.rock);
    }

    private static void initializeOreBlocks() {
	mercuryOreCopper = new BlockOre(Material.rock).setBlockName("mercuryOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "mercuryOreCopper").setStepSound(Block.soundTypeMetal);
	mercuryOreCopper.setHarvestLevel("pickaxe", 2);

	mercuryOreTin = new BlockOre(Material.rock).setBlockName("mercuryOreTin")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "mercuryOreTin").setStepSound(Block.soundTypeMetal);
	mercuryOreTin.setHarvestLevel("pickaxe", 2);

	mercuryOreIron = new BlockOre(Material.rock).setBlockName("mercuryOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "mercuryOreIron").setStepSound(Block.soundTypeMetal);
	mercuryOreIron.setHarvestLevel("pickaxe", 1);

	venusOreCopper = new BlockOre(Material.rock).setBlockName("venusOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "venusOreCopper").setStepSound(Block.soundTypeMetal);
	venusOreCopper.setHarvestLevel("pickaxe", 2);

	venusOreTin = new BlockOre(Material.rock).setBlockName("venusOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "venusOreTin")
		.setStepSound(Block.soundTypeMetal);
	venusOreTin.setHarvestLevel("pickaxe", 2);

	venusOreIron = new BlockOre(Material.rock).setBlockName("venusOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "venusOreIron").setStepSound(Block.soundTypeMetal);
	venusOreIron.setHarvestLevel("pickaxe", 1);

	ceresOreCopper = new BlockOre(Material.rock).setBlockName("ceresOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "ceresOreCopper").setStepSound(Block.soundTypeMetal);
	ceresOreCopper.setHarvestLevel("pickaxe", 2);

	ceresOreTin = new BlockOre(Material.rock).setBlockName("ceresOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "ceresOreTin")
		.setStepSound(Block.soundTypeMetal);
	ceresOreTin.setHarvestLevel("pickaxe", 2);

	ceresOreIron = new BlockOre(Material.rock).setBlockName("ceresOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "ceresOreIron").setStepSound(Block.soundTypeMetal);
	ceresOreIron.setHarvestLevel("pickaxe", 1);

	jupiterOreCopper = new BlockOre(Material.rock).setBlockName("jupiterOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterOreCopper").setStepSound(Block.soundTypeMetal);
	jupiterOreCopper.setHarvestLevel("pickaxe", 2);

	jupiterOreTin = new BlockOre(Material.rock).setBlockName("jupiterOreTin")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterOreTin").setStepSound(Block.soundTypeMetal);
	jupiterOreTin.setHarvestLevel("pickaxe", 2);

	jupiterOreIron = new BlockOre(Material.rock).setBlockName("jupiterOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterOreIron").setStepSound(Block.soundTypeMetal);
	jupiterOreIron.setHarvestLevel("pickaxe", 1);

	saturnOreCopper = new BlockOre(Material.rock).setBlockName("saturnOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnOreCopper").setStepSound(Block.soundTypeMetal);
	saturnOreCopper.setHarvestLevel("pickaxe", 2);

	saturnOreTin = new BlockOre(Material.rock).setBlockName("saturnOreTin")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnOreTin").setStepSound(Block.soundTypeMetal);
	saturnOreTin.setHarvestLevel("pickaxe", 2);

	saturnOreIron = new BlockOre(Material.rock).setBlockName("saturnOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnOreIron").setStepSound(Block.soundTypeMetal);
	saturnOreIron.setHarvestLevel("pickaxe", 1);

	neptuneOreCopper = new BlockOre(Material.rock).setBlockName("neptuneOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneOreCopper").setStepSound(Block.soundTypeMetal);
	neptuneOreCopper.setHarvestLevel("pickaxe", 2);

	neptuneOreTin = new BlockOre(Material.rock).setBlockName("neptuneOreTin")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneOreTin").setStepSound(Block.soundTypeMetal);
	neptuneOreTin.setHarvestLevel("pickaxe", 2);

	neptuneOreIron = new BlockOre(Material.rock).setBlockName("neptuneOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneOreIron").setStepSound(Block.soundTypeMetal);
	neptuneOreIron.setHarvestLevel("pickaxe", 1);

	plutoOreCopper = new BlockOre(Material.rock).setBlockName("plutoOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoOreCopper").setStepSound(Block.soundTypeMetal);
	plutoOreCopper.setHarvestLevel("pickaxe", 2);

	plutoOreTin = new BlockOre(Material.rock).setBlockName("plutoOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoOreTin")
		.setStepSound(Block.soundTypeMetal);
	plutoOreTin.setHarvestLevel("pickaxe", 2);

	plutoOreIron = new BlockOre(Material.rock).setBlockName("plutoOreIron")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "plutoOreIron").setStepSound(Block.soundTypeMetal);
	plutoOreIron.setHarvestLevel("pickaxe", 1);

	erisOreCopper = new BlockOre(Material.rock).setBlockName("erisOreCopper")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "erisOreCopper").setStepSound(Block.soundTypeMetal);
	erisOreCopper.setHarvestLevel("pickaxe", 2);

	erisOreTin = new BlockOre(Material.rock).setBlockName("erisOreTin").setBlockTextureName(Constants.TEXTURE_PREFIX + "erisOreTin")
		.setStepSound(Block.soundTypeMetal);
	erisOreTin.setHarvestLevel("pickaxe", 2);

	erisOreIron = new BlockOre(Material.rock).setBlockName("erisOreIron").setBlockTextureName(Constants.TEXTURE_PREFIX + "erisOreIron")
		.setStepSound(Block.soundTypeMetal);
	erisOreIron.setHarvestLevel("pickaxe", 1);

	OreCarbon = new BlockOre(Material.rock).setBlockName("OreCarbon").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreCarbon")
		.setStepSound(Block.soundTypeMetal);
	OreCarbon.setHarvestLevel("pickaxe", 2);

	OrePalladium = new BlockOre(Material.rock).setBlockName("OrePalladium")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "OrePalladium").setStepSound(Block.soundTypeMetal);
	OrePalladium.setHarvestLevel("pickaxe", 3);

	OreMagnesium = new BlockOre(Material.rock).setBlockName("OreMagnesium")
		.setBlockTextureName(Constants.TEXTURE_PREFIX + "OreMagnesium").setStepSound(Block.soundTypeMetal);
	OreMagnesium.setHarvestLevel("pickaxe", 4);

	OreCrystal = new BlockOre(Material.rock).setBlockName("OreCrystal").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreCrystal")
		.setStepSound(Block.soundTypeMetal);
	OreCrystal.setHarvestLevel("pickaxe", 5);

	OreNickel = new BlockOre(Material.rock).setBlockName("OreNickel").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreNickel")
		.setStepSound(Block.soundTypeMetal);
	OreNickel.setHarvestLevel("pickaxe", 4);

	OreZinc = new BlockOre(Material.rock).setBlockName("OreZinc").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreZinc")
		.setStepSound(Block.soundTypeMetal);
	OreZinc.setHarvestLevel("pickaxe", 6);

	OreMercury = new BlockOre(Material.rock).setBlockName("OreMercury").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreMercury")
		.setStepSound(Block.soundTypeMetal);
	OreMercury.setHarvestLevel("pickaxe", 4);

	OreUranium = new BlockOre(Material.rock).setBlockName("OreUranium").setBlockTextureName(Constants.TEXTURE_PREFIX + "OreUranium")
		.setStepSound(Block.soundTypeMetal);
	OreUranium.setHarvestLevel("pickaxe", 4);
    }

    private static void initializeDungeonBlocks() {
	if (Config.venus) {
	    veunsDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("veunsDungeonBrick")
		    .setBlockTextureName(Constants.TEXTURE_PREFIX + "veunsDungeonBrick").setHardness(4.0F).setResistance(40.0F)
		    .setStepSound(Block.soundTypeMetal);
	    veunsDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore 2
	}
	if (Config.jupiter) {
	    jupiterDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("jupiterDungeonBrick")
		    .setBlockTextureName(Constants.TEXTURE_PREFIX + "jupiterDungeonBrick").setHardness(4.0F).setResistance(40.0F)
		    .setStepSound(Block.soundTypeMetal);
	    jupiterDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
	    // // 2
	}
	if (Config.saturn) {
	    saturnDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("saturnDungeonBrick")
		    .setBlockTextureName(Constants.TEXTURE_PREFIX + "saturnDungeonBrick").setHardness(4.0f).setResistance(40.0F)
		    .setStepSound(Block.soundTypeMetal);
	    saturnDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
	}
	if (Config.uranus) {
	    uranusDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("uranusDungeonBrick")
		    .setBlockTextureName(Constants.TEXTURE_PREFIX + "uranusDungeonBrick").setHardness(4.0F).setResistance(40.0F)
		    .setStepSound(Block.soundTypeMetal);
	    uranusDungeonBrick.setHarvestLevel("pickaxe", 0); // Normal 0 | Ore
	}
	if (Config.neptune) {
	    neptuneDungeonBrick = new BlockDungeonBrick(Material.rock).setBlockName("neptuneDungeonBrick")
		    .setBlockTextureName(Constants.TEXTURE_PREFIX + "neptuneDungeonBrick").setHardness(4.0F).setResistance(40.0F)
		    .setStepSound(Block.soundTypeMetal);
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

    private static void initializeSlabsAndStairsBlocks() {
	if (Config.mercury) {
	    mercuryStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "mercuryStoneBlockhalfslab", "mercuryStone");
	    mercuryStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryStoneBlockfullslab", "mercuryStone");
	    mercuryStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.mercuryStone, 0, "mercuryStoneStairs");
	}
	if (Config.venus) {
	    venusStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "venusStoneBlockhalfslab", "venusStone");
	    venusStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryStoneBlockfullslab", "venusStone");
	    venusStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.venusStone, 0, "venusStoneStairs");

	    venusDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "venusDungeonBrickStoneBlockhalfslab",
		    "veunsDungeonBrick");
	    venusDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryDungeonBrickStoneBlockfullslab", "veunsDungeonBrick");
	    venusDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.veunsDungeonBrick, 0, "venusDungeonBrickStoneStairs");
	}
	if (Config.ceres) {
	    ceresStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "ceresStoneBlockhalfslab", "ceresStone");
	    ceresStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "ceresStoneBlockfullslab", "ceresStone");
	    ceresStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.ceresStone, 0, "ceresStoneStairs");
	}
	if (Config.jupiter) {
	    jupiterStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "jupiterStoneBlockhalfslab", "jupiterStone");
	    jupiterStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "jupiterStoneBlockfullslab", "jupiterStone");
	    jupiterStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.jupiterStone, 0, "jupiterStoneStairs");

	    jupiterDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "jupiterDungeonBrickStoneBlockhalfslab",
		    "jupiterDungeonBrick");
	    jupiterDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "jupiterDungeonBrickStoneBlockfullslab",
		    "jupiterDungeonBrick");
	    jupiterDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.jupiterDungeonBrick, 0, "jupiterDungeonBrickStoneStairs");
	}
	if (Config.saturn) {
	    saturnStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "saturnStoneBlockhalfslab", "saturnStone");
	    saturnStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "saturnStoneBlockfullslab", "saturnStone");
	    saturnStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.saturnStone, 0, "saturnStoneStairs");

	    saturnDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "saturnDungeonBrickStoneBlockhalfslab",
		    "saturnDungeonBrick");
	    saturnDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "saturnDungeonBrickStoneBlockfullslab", "saturnDungeonBrick");
	    saturnDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.saturnDungeonBrick, 0, "saturnDungeonBrickStoneStairs");
	}
	if (Config.uranus) {
	    uranusStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "uranusStoneBlockhalfslab", "uranusStone");
	    uranusStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "uranusStoneBlockfullslab", "uranusStone");
	    uranusStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.uranusStone, 0, "uranusStoneStairs");

	    uranusDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "uranusDungeonBrickStoneBlockhalfslab",
		    "uranusDungeonBrick");
	    uranusDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "uranusDungeonBrickStoneBlockfullslab", "uranusDungeonBrick");
	    uranusDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.uranusDungeonBrick, 0, "uranusDungeonBrickStoneStairs");
	}
	if (Config.neptune) {
	    neptuneStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "neptuneStoneBlockhalfslab", "neptuneStone");
	    neptuneStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "neptuneStoneBlockfullslab", "neptuneStone");
	    neptuneStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.neptuneStone, 0, "neptuneStoneStairs");

	    neptuneDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "neptuneDungeonBrickStoneBlockhalfslab",
		    "neptuneDungeonBrick");
	    neptuneDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "neptuneDungeonBrickStoneBlockfullslab",
		    "neptuneDungeonBrick");
	    neptuneDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.neptuneDungeonBrick, 0, "neptuneDungeonBrickStoneStairs");
	}
	if (Config.pluto) {
	    plutoStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "plutoStoneBlockhalfslab", "plutoStone");
	    plutoStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "plutoStoneBlockfullslab", "plutoStone");
	    plutoStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.plutoStone, 0, "plutoStoneStairs");
	}
	if (Config.eris) {
	    erisStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "erisStoneBlockhalfslab", "erisStone");
	    erisStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "erisStoneBlockfullslab", "erisStone");
	    erisStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.erisStone, 0, "erisStoneStairs");
	}
    }

    private static void registerBlocks() {
	GameRegistry.registerBlock(OreCarbon, "OreCarbon");
	GameRegistry.registerBlock(OrePalladium, "OrePalladium");
	GameRegistry.registerBlock(OreMagnesium, "OreMagnesium");
	GameRegistry.registerBlock(OreCrystal, "OreCrystal");

	GameRegistry.registerBlock(OreMercury, "OreMercury");
	GameRegistry.registerBlock(OreZinc, "OreZinc");
	GameRegistry.registerBlock(OreNickel, "OreNickel");
	GameRegistry.registerBlock(OreUranium, "OreUranium");

	if (Config.mercury) {
	    GameRegistry.registerBlock(mercurySurface, "mercurySurface");
	    GameRegistry.registerBlock(mercurySubSurface, "mercurySubSurface");
	    GameRegistry.registerBlock(mercuryStone, "mercuryStone");

	    GameRegistry.registerBlock(mercuryOreCopper, "mercuryOreCopper");
	    GameRegistry.registerBlock(mercuryOreTin, "mercuryOreTin");
	    GameRegistry.registerBlock(mercuryOreIron, "mercuryOreIron");

	    GameRegistry.registerBlock(mercuryGravel, "mercuryGravel");
	}
	if (Config.venus) {
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
	}
	if (Config.ceres) {
	    GameRegistry.registerBlock(ceresSurface, "ceresSurface");
	    GameRegistry.registerBlock(ceresSubSurface, "ceresSubSurface");
	    GameRegistry.registerBlock(ceresStone, "ceresStone");

	    GameRegistry.registerBlock(ceresOreCopper, "ceresOreCopper");
	    GameRegistry.registerBlock(ceresOreTin, "ceresOreTin");
	    GameRegistry.registerBlock(ceresOreIron, "ceresOreIron");

	    GameRegistry.registerBlock(ceresGravel, "ceresGravel");
	}
	if (Config.jupiter) {
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
	    GameRegistry.registerBlock(uranusSurface, "uranusSurface");
	    GameRegistry.registerBlock(uranusSubSurface, "uranusSubSurface");
	    GameRegistry.registerBlock(uranusStone, "uranusStone");

	    GameRegistry.registerBlock(uranusSpawner, "uranusSpawner");
	    GameRegistry.registerBlock(uranusDungeonBrick, "uranusDungeonBrick");
	    GameRegistry.registerBlock(treasureChestTier7, ItemBlockDesc.class, treasureChestTier7.getUnlocalizedName());
	}
	if (Config.neptune) {
	    GameRegistry.registerBlock(neptuneSurface, "neptuneSurface");
	    GameRegistry.registerBlock(neptuneSubSurface, "neptuneSubSurface");
	    GameRegistry.registerBlock(neptuneStone, "neptuneStone");

	    GameRegistry.registerBlock(neptuneOreCopper, "neptuneOreCopper");
	    GameRegistry.registerBlock(neptuneOreTin, "neptuneOreTin");
	    GameRegistry.registerBlock(neptuneOreIron, "neptuneOreIron");

	    GameRegistry.registerBlock(neptuneSpawner, "neptuneSpawner");
	    GameRegistry.registerBlock(neptuneDungeonBrick, "neptuneDungeonBrick");
	    GameRegistry.registerBlock(treasureChestTier8, ItemBlockDesc.class, treasureChestTier8.getUnlocalizedName());
	}
	if (Config.pluto) {
	    GameRegistry.registerBlock(plutoSurface, "plutoSurface");
	    GameRegistry.registerBlock(plutoSubSurface, "plutoSubSurface");
	    GameRegistry.registerBlock(plutoStone, "plutoStone");

	    GameRegistry.registerBlock(plutoOreCopper, "plutoOreCopper");
	    GameRegistry.registerBlock(plutoOreTin, "plutoOreTin");
	    GameRegistry.registerBlock(plutoOreIron, "plutoOreIron");

	    GameRegistry.registerBlock(plutoGravel, "plutoGravel");
	}
	if (Config.eris) {
	    GameRegistry.registerBlock(erisSurface, "erisSurface");
	    GameRegistry.registerBlock(erisSubSurface, "erisSubSurface");
	    GameRegistry.registerBlock(erisStone, "erisStone");

	    GameRegistry.registerBlock(erisOreCopper, "erisOreCopper");
	    GameRegistry.registerBlock(erisOreTin, "erisOreTin");
	    GameRegistry.registerBlock(erisOreIron, "erisOreIron");

	    GameRegistry.registerBlock(erisGravel, "erisGravel");
	}
	if (Config.europa) {
	    GameRegistry.registerBlock(europaSurface, "europaSurface");
	    GameRegistry.registerBlock(europaSubSurface, "europaSubSurface");
	    GameRegistry.registerBlock(europaStone, "europaStone");
	}
	if (Config.io) {
	    GameRegistry.registerBlock(ioSurface, "ioSurface");
	    GameRegistry.registerBlock(ioSubSurface, "ioSubSurface");
	    GameRegistry.registerBlock(ioStone, "ioStone");
	}
	if (Config.deimos) {
	    GameRegistry.registerBlock(deimosSurface, "deimosSurface");
	    GameRegistry.registerBlock(deimosSubSurface, "deimosSubSurface");
	    GameRegistry.registerBlock(deimosStone, "deimosStone");
	}
	if (Config.phobos) {
	    GameRegistry.registerBlock(phobosSurface, "phobosSurface");
	    GameRegistry.registerBlock(phobosSubSurface, "phobosSubSurface");
	    GameRegistry.registerBlock(phobosStone, "phobosStone");
	}
	// GameRegistry.registerBlock(tritonSurface, "tritonSurface");
	// GameRegistry.registerBlock(tritonSubSurface, "tritonSubSurface");
	// GameRegistry.registerBlock(tritonStone, "tritonStone");

	GameRegistry.registerBlock(nuclearBomb, "nuclearBomb");
	GameRegistry.registerBlock(fossil, "fossil");
    }

    private static void registerMachines() {
	GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
	GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
	GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
	GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
    }

    private static void registerSlabsAndStairs() {
	if (Config.mercury) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.mercuryStoneBlockHalfSlab, MercuryStoneItemSlab.class, "mercuryStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.mercuryStoneBlockDoubleSlab, MercuryStoneItemSlab.class, "mercuryStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.mercuryStoneStairs, "mercuryStoneStairs");
	}
	if (Config.venus) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.venusStoneBlockHalfSlab, VenusStoneItemSlab.class, "venusStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.venusStoneBlockDoubleSlab, VenusStoneItemSlab.class, "venusStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.venusStoneStairs, "venusStoneStairs");

	    GameRegistry.registerBlock(ExtraPlanetsBlocks.venusDungeonBrickStoneBlockHalfSlab, VenusDungeonBrickStoneItemSlab.class,
		    "venusDungeonBrickStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.venusDungeonBrickStoneBlockDoubleSlab, VenusDungeonBrickStoneItemSlab.class,
		    "venusDungeonBrickStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.venusDungeonBrickStoneStairs, "venusDungeonBrickStoneStairs");
	}
	if (Config.ceres) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.ceresStoneBlockHalfSlab, CeresStoneItemSlab.class, "ceresStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.ceresStoneBlockDoubleSlab, CeresStoneItemSlab.class, "ceresStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.ceresStoneStairs, "ceresStoneStairs");
	}
	if (Config.jupiter) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.jupiterStoneBlockHalfSlab, JupiterStoneItemSlab.class, "jupiterStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.jupiterStoneBlockDoubleSlab, JupiterStoneItemSlab.class, "jupiterStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.jupiterStoneStairs, "jupiterStoneStairs");

	    GameRegistry.registerBlock(ExtraPlanetsBlocks.jupiterDungeonBrickStoneBlockHalfSlab, JupiterDungeonBrickStoneItemSlab.class,
		    "jupiterDungeonBrickStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.jupiterDungeonBrickStoneBlockDoubleSlab, JupiterDungeonBrickStoneItemSlab.class,
		    "jupiterDungeonBrickStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.jupiterDungeonBrickStoneStairs, "jupiterDungeonBrickStoneStairs");
	}
	if (Config.saturn) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.saturnStoneBlockHalfSlab, SaturnStoneItemSlab.class, "saturnStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.saturnStoneBlockDoubleSlab, SaturnStoneItemSlab.class, "saturnStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.saturnStoneStairs, "saturnStoneStairs");

	    GameRegistry.registerBlock(ExtraPlanetsBlocks.saturnDungeonBrickStoneBlockHalfSlab, SaturnDungeonBrickStoneItemSlab.class,
		    "saturnDungeonBrickStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.saturnDungeonBrickStoneBlockDoubleSlab, SaturnDungeonBrickStoneItemSlab.class,
		    "saturnDungeonBrickStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.saturnDungeonBrickStoneStairs, "saturnDungeonBrickStoneStairs");
	}
	if (Config.uranus) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.uranusStoneBlockHalfSlab, UranusStoneItemSlab.class, "uranusStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.uranusStoneBlockDoubleSlab, UranusStoneItemSlab.class, "uranusStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.uranusStoneStairs, "uranusStoneStairs");

	    GameRegistry.registerBlock(ExtraPlanetsBlocks.uranusDungeonBrickStoneBlockHalfSlab, UranusDungeonBrickStoneItemSlab.class,
		    "uranusDungeonBrickStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.uranusDungeonBrickStoneBlockDoubleSlab, UranusDungeonBrickStoneItemSlab.class,
		    "uranusDungeonBrickStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.uranusDungeonBrickStoneStairs, "uranusDungeonBrickStoneStairs");
	}
	if (Config.neptune) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.neptuneStoneBlockHalfSlab, NeptuneStoneItemSlab.class, "neptuneStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.neptuneStoneBlockDoubleSlab, NeptuneStoneItemSlab.class, "neptuneStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.neptuneStoneStairs, "neptuneStoneStairs");

	    GameRegistry.registerBlock(ExtraPlanetsBlocks.neptuneDungeonBrickStoneBlockHalfSlab, NeptuneDungeonBrickStoneItemSlab.class,
		    "neptuneDungeonBrickStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.neptuneDungeonBrickStoneBlockDoubleSlab, NeptuneDungeonBrickStoneItemSlab.class,
		    "neptuneDungeonBrickStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.neptuneDungeonBrickStoneStairs, "neptuneDungeonBrickStoneStairs");
	}
	if (Config.pluto) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.plutoStoneBlockHalfSlab, PlutoStoneItemSlab.class, "plutoStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.plutoStoneBlockDoubleSlab, PlutoStoneItemSlab.class, "plutoStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.plutoStoneStairs, "plutoStoneStairs");
	}
	if (Config.eris) {
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.erisStoneBlockHalfSlab, ErisStoneItemSlab.class, "erisStonehalfslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.erisStoneBlockDoubleSlab, ErisStoneItemSlab.class, "erisStonefullslab");
	    GameRegistry.registerBlock(ExtraPlanetsBlocks.erisStoneStairs, "erisStoneStairs");
	}
    }

    private static void registerTileEntitys() {
	if (Config.venus) {
	    GameRegistry.registerTileEntity(TileEntityDungeonSpawnerVenus.class, "Veuns Dungeon Spawner");
	    GameRegistry.registerTileEntity(TileEntityT4TreasureChest.class, "Tier 4 Treasure Chest");
	}
	if (Config.jupiter) {
	    GameRegistry.registerTileEntity(TileEntityDungeonSpawnerJupiter.class, "Juptier Dungeon Spawner");
	    GameRegistry.registerTileEntity(TileEntityT5TreasureChest.class, "Tier 5 Treasure Chest");
	}
	if (Config.saturn) {
	    GameRegistry.registerTileEntity(TileEntityDungeonSpawnerSaturn.class, "Saturn Dungeon Spawner");
	    GameRegistry.registerTileEntity(TileEntityT6TreasureChest.class, "Tier 6 Treasure Chest");
	}
	if (Config.uranus) {
	    GameRegistry.registerTileEntity(TileEntityDungeonSpawnerUranus.class, "Uranus Dungeon Spawner");
	    GameRegistry.registerTileEntity(TileEntityT7TreasureChest.class, "Tier 7 Treasure Chest");
	}
	if (Config.neptune) {
	    GameRegistry.registerTileEntity(TileEntityDungeonSpawnerNeptune.class, "Neptune Dungeon Spawner");
	    GameRegistry.registerTileEntity(TileEntityT8TreasureChest.class, "Tier 8 Treasure Chest");
	}

	GameRegistry.registerTileEntity(TileEntitySolar.class, "ExtraPlanets Solar Panel");
	GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, "AdvancedRefinery");
    }

    public static void OreDictionaryRegister() {
	if (Config.mercury) {
	    OreDictionary.registerOre("oreCopper", new ItemStack(mercuryOreCopper));
	    OreDictionary.registerOre("oreTin", new ItemStack(mercuryOreTin));
	    OreDictionary.registerOre("oreIron", new ItemStack(mercuryOreIron));
	}
	if (Config.venus) {
	    OreDictionary.registerOre("oreCopper", new ItemStack(venusOreCopper));
	    OreDictionary.registerOre("oreTin", new ItemStack(venusOreTin));
	    OreDictionary.registerOre("oreIron", new ItemStack(venusOreIron));
	}
	if (Config.ceres) {
	    OreDictionary.registerOre("oreCopper", new ItemStack(ceresOreCopper));
	    OreDictionary.registerOre("oreTin", new ItemStack(ceresOreTin));
	    OreDictionary.registerOre("oreIron", new ItemStack(ceresOreIron));
	    OreDictionary.registerOre("OreUranium", new ItemStack(OreUranium));
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
	    OreDictionary.registerOre("oreCopper", new ItemStack(plutoOreCopper));
	    OreDictionary.registerOre("oreTin", new ItemStack(plutoOreTin));
	    OreDictionary.registerOre("oreIron", new ItemStack(plutoOreIron));
	}
	if (Config.eris) {
	    OreDictionary.registerOre("oreCopper", new ItemStack(erisOreCopper));
	    OreDictionary.registerOre("oreTin", new ItemStack(erisOreTin));
	    OreDictionary.registerOre("oreIron", new ItemStack(erisOreIron));
	}
    }
}
