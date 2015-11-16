package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets;
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

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanetsSlabsStairsBlocks {
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

	public static void init() {
		initializeSlabsAndStairsBlocks();
		registerSlabsAndStairs();
	}

	private static void initializeSlabsAndStairsBlocks() {
		if (Config.mercury) {
			mercuryStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "mercuryStoneBlockhalfslab", "mercuryStone");
			mercuryStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryStoneBlockfullslab", "mercuryStone");
			mercuryStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.mercuryBlocks, 2, "mercuryStoneStairs");
		}
		if (Config.venus) {
			venusStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "venusStoneBlockhalfslab", "venusStone");
			venusStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryStoneBlockfullslab", "venusStone");
			venusStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.venusStone, 0, "venusStoneStairs");

			venusDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "venusDungeonBrickStoneBlockhalfslab", "veunsDungeonBrick");
			venusDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryDungeonBrickStoneBlockfullslab", "veunsDungeonBrick");
			venusDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.veunsDungeonBrick, 0, "venusDungeonBrickStoneStairs");
		}
		if (Config.ceres) {
			ceresStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "ceresStoneBlockhalfslab", "ceresStone");
			ceresStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "ceresStoneBlockfullslab", "ceresStone");
			ceresStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.ceresBlocks, 2, "ceresStoneStairs");
		}
		if (Config.jupiter) {
			jupiterStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "jupiterStoneBlockhalfslab", "jupiterStone");
			jupiterStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "jupiterStoneBlockfullslab", "jupiterStone");
			jupiterStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.jupiterStone, 0, "jupiterStoneStairs");

			jupiterDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "jupiterDungeonBrickStoneBlockhalfslab", "jupiterDungeonBrick");
			jupiterDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "jupiterDungeonBrickStoneBlockfullslab", "jupiterDungeonBrick");
			jupiterDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.jupiterDungeonBrick, 0, "jupiterDungeonBrickStoneStairs");
		}
		if (Config.saturn) {
			saturnStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "saturnStoneBlockhalfslab", "saturnStone");
			saturnStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "saturnStoneBlockfullslab", "saturnStone");
			saturnStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.saturnStone, 0, "saturnStoneStairs");

			saturnDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "saturnDungeonBrickStoneBlockhalfslab", "saturnDungeonBrick");
			saturnDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "saturnDungeonBrickStoneBlockfullslab", "saturnDungeonBrick");
			saturnDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.saturnDungeonBrick, 0, "saturnDungeonBrickStoneStairs");
		}
		if (Config.uranus) {
			uranusStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "uranusStoneBlockhalfslab", "uranusStone");
			uranusStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "uranusStoneBlockfullslab", "uranusStone");
			uranusStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.uranusStone, 0, "uranusStoneStairs");

			uranusDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "uranusDungeonBrickStoneBlockhalfslab", "uranusDungeonBrick");
			uranusDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "uranusDungeonBrickStoneBlockfullslab", "uranusDungeonBrick");
			uranusDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.uranusDungeonBrick, 0, "uranusDungeonBrickStoneStairs");
		}
		if (Config.neptune) {
			neptuneStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "neptuneStoneBlockhalfslab", "neptuneStone");
			neptuneStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "neptuneStoneBlockfullslab", "neptuneStone");
			neptuneStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.neptuneStone, 0, "neptuneStoneStairs");

			neptuneDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "neptuneDungeonBrickStoneBlockhalfslab", "neptuneDungeonBrick");
			neptuneDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "neptuneDungeonBrickStoneBlockfullslab", "neptuneDungeonBrick");
			neptuneDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.neptuneDungeonBrick, 0, "neptuneDungeonBrickStoneStairs");
		}
		if (Config.pluto) {
			plutoStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "plutoStoneBlockhalfslab", "plutoStone");
			plutoStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "plutoStoneBlockfullslab", "plutoStone");
			plutoStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.plutoBlocks, 2, "plutoStoneStairs");
		}
		if (Config.eris) {
			erisStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "erisStoneBlockhalfslab", "erisStone");
			erisStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "erisStoneBlockfullslab", "erisStone");
			erisStoneStairs = new BlockBasicStairs(ExtraPlanetsBlocks.erisBlocks, 2, "erisStoneStairs");
		}
	}

	private static void registerSlabsAndStairs() {
		if (Config.mercury) {
			GameRegistry.registerBlock(mercuryStoneBlockHalfSlab, MercuryStoneItemSlab.class, "mercuryStonehalfslab");
			GameRegistry.registerBlock(mercuryStoneBlockDoubleSlab, MercuryStoneItemSlab.class, "mercuryStonefullslab");
			GameRegistry.registerBlock(mercuryStoneStairs, "mercuryStoneStairs");
		}
		if (Config.venus) {
			GameRegistry.registerBlock(venusStoneBlockHalfSlab, VenusStoneItemSlab.class, "venusStonehalfslab");
			GameRegistry.registerBlock(venusStoneBlockDoubleSlab, VenusStoneItemSlab.class, "venusStonefullslab");
			GameRegistry.registerBlock(venusStoneStairs, "venusStoneStairs");

			GameRegistry.registerBlock(venusDungeonBrickStoneBlockHalfSlab, VenusDungeonBrickStoneItemSlab.class, "venusDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(venusDungeonBrickStoneBlockDoubleSlab, VenusDungeonBrickStoneItemSlab.class, "venusDungeonBrickStonefullslab");
			GameRegistry.registerBlock(venusDungeonBrickStoneStairs, "venusDungeonBrickStoneStairs");
		}
		if (Config.ceres) {
			GameRegistry.registerBlock(ceresStoneBlockHalfSlab, CeresStoneItemSlab.class, "ceresStonehalfslab");
			GameRegistry.registerBlock(ceresStoneBlockDoubleSlab, CeresStoneItemSlab.class, "ceresStonefullslab");
			GameRegistry.registerBlock(ceresStoneStairs, "ceresStoneStairs");
		}
		if (Config.jupiter) {
			GameRegistry.registerBlock(jupiterStoneBlockHalfSlab, JupiterStoneItemSlab.class, "jupiterStonehalfslab");
			GameRegistry.registerBlock(jupiterStoneBlockDoubleSlab, JupiterStoneItemSlab.class, "jupiterStonefullslab");
			GameRegistry.registerBlock(jupiterStoneStairs, "jupiterStoneStairs");

			GameRegistry.registerBlock(jupiterDungeonBrickStoneBlockHalfSlab, JupiterDungeonBrickStoneItemSlab.class, "jupiterDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(jupiterDungeonBrickStoneBlockDoubleSlab, JupiterDungeonBrickStoneItemSlab.class, "jupiterDungeonBrickStonefullslab");
			GameRegistry.registerBlock(jupiterDungeonBrickStoneStairs, "jupiterDungeonBrickStoneStairs");
		}
		if (Config.saturn) {
			GameRegistry.registerBlock(saturnStoneBlockHalfSlab, SaturnStoneItemSlab.class, "saturnStonehalfslab");
			GameRegistry.registerBlock(saturnStoneBlockDoubleSlab, SaturnStoneItemSlab.class, "saturnStonefullslab");
			GameRegistry.registerBlock(saturnStoneStairs, "saturnStoneStairs");

			GameRegistry.registerBlock(saturnDungeonBrickStoneBlockHalfSlab, SaturnDungeonBrickStoneItemSlab.class, "saturnDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(saturnDungeonBrickStoneBlockDoubleSlab, SaturnDungeonBrickStoneItemSlab.class, "saturnDungeonBrickStonefullslab");
			GameRegistry.registerBlock(saturnDungeonBrickStoneStairs, "saturnDungeonBrickStoneStairs");
		}
		if (Config.uranus) {
			GameRegistry.registerBlock(uranusStoneBlockHalfSlab, UranusStoneItemSlab.class, "uranusStonehalfslab");
			GameRegistry.registerBlock(uranusStoneBlockDoubleSlab, UranusStoneItemSlab.class, "uranusStonefullslab");
			GameRegistry.registerBlock(uranusStoneStairs, "uranusStoneStairs");

			GameRegistry.registerBlock(uranusDungeonBrickStoneBlockHalfSlab, UranusDungeonBrickStoneItemSlab.class, "uranusDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(uranusDungeonBrickStoneBlockDoubleSlab, UranusDungeonBrickStoneItemSlab.class, "uranusDungeonBrickStonefullslab");
			GameRegistry.registerBlock(uranusDungeonBrickStoneStairs, "uranusDungeonBrickStoneStairs");
		}
		if (Config.neptune) {
			GameRegistry.registerBlock(neptuneStoneBlockHalfSlab, NeptuneStoneItemSlab.class, "neptuneStonehalfslab");
			GameRegistry.registerBlock(neptuneStoneBlockDoubleSlab, NeptuneStoneItemSlab.class, "neptuneStonefullslab");
			GameRegistry.registerBlock(neptuneStoneStairs, "neptuneStoneStairs");

			GameRegistry.registerBlock(neptuneDungeonBrickStoneBlockHalfSlab, NeptuneDungeonBrickStoneItemSlab.class, "neptuneDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(neptuneDungeonBrickStoneBlockDoubleSlab, NeptuneDungeonBrickStoneItemSlab.class, "neptuneDungeonBrickStonefullslab");
			GameRegistry.registerBlock(neptuneDungeonBrickStoneStairs, "neptuneDungeonBrickStoneStairs");
		}
		if (Config.pluto) {
			GameRegistry.registerBlock(plutoStoneBlockHalfSlab, PlutoStoneItemSlab.class, "plutoStonehalfslab");
			GameRegistry.registerBlock(plutoStoneBlockDoubleSlab, PlutoStoneItemSlab.class, "plutoStonefullslab");
			GameRegistry.registerBlock(plutoStoneStairs, "plutoStoneStairs");
		}
		if (Config.eris) {
			GameRegistry.registerBlock(erisStoneBlockHalfSlab, ErisStoneItemSlab.class, "erisStonehalfslab");
			GameRegistry.registerBlock(erisStoneBlockDoubleSlab, ErisStoneItemSlab.class, "erisStonefullslab");
			GameRegistry.registerBlock(erisStoneStairs, "erisStoneStairs");
		}
	}
}
