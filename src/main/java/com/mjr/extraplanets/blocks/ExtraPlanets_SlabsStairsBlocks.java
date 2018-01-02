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

public class ExtraPlanets_SlabsStairsBlocks {
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

	public static Block mercuryStoneBrickStairs;
	public static Block venusStoneBrickStairs;
	public static Block ceresStoneBrickStairs;
	public static Block jupiterStoneBrickStairs;
	public static Block saturnStoneBrickStairs;
	public static Block uranusStoneBrickStairs;
	public static Block neptuneStoneBrickStairs;
	public static Block plutoStoneBrickStairs;
	public static Block erisStoneBrickStairs;

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
			mercuryStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "mercuryStoneBlockhalfslab", "mercury_stone");
			mercuryStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryStoneBlockfullslab", "mercury_stone");
			mercuryStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.mercuryBlocks, 2, "mercuryStoneStairs");
			mercuryStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.mercuryBlocks, 7, "mercuryStoneBrickStairs");
		}
		if (Config.venus) {
			venusStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "venusStoneBlockhalfslab", "venus_stone");
			venusStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryStoneBlockfullslab", "venus_stone");
			venusStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.venusBlocks, 2, "venusStoneStairs");
			venusStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.venusBlocks, 8, "venusStoneBrickStairs");

			venusDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "venusDungeonBrickStoneBlockhalfslab", "veuns_dungeon_brick");
			venusDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "mercuryDungeonBrickStoneBlockfullslab", "veuns_dungeon_brick");
			venusDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.veunsDungeonBrick, 0, "venusDungeonBrickStoneStairs");
		}
		if (Config.ceres) {
			ceresStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "ceresStoneBlockhalfslab", "ceres_stone");
			ceresStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "ceresStoneBlockfullslab", "ceres_stone");
			ceresStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.ceresBlocks, 2, "ceresStoneStairs");
			ceresStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.ceresBlocks, 7, "ceresStoneBrickStairs");
		}
		if (Config.jupiter) {
			jupiterStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "jupiterStoneBlockhalfslab", "jupiter_stone");
			jupiterStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "jupiterStoneBlockfullslab", "jupiter_stone");
			jupiterStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.jupiterBlocks, 2, "jupiterStoneStairs");
			jupiterStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.jupiterBlocks, 9, "jupiterStoneBrickStairs");

			jupiterDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "jupiterDungeonBrickStoneBlockhalfslab", "jupiter_dungeon_brick");
			jupiterDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "jupiterDungeonBrickStoneBlockfullslab", "jupiter_dungeon_brick");
			jupiterDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.jupiterDungeonBrick, 0, "jupiterDungeonBrickStoneStairs");
		}
		if (Config.saturn) {
			saturnStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "saturnStoneBlockhalfslab", "saturn_stone");
			saturnStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "saturnStoneBlockfullslab", "saturn_stone");
			saturnStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.saturnBlocks, 2, "saturnStoneStairs");
			saturnStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.saturnBlocks, 8, "saturnStoneBrickStairs");

			saturnDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "saturnDungeonBrickStoneBlockhalfslab", "saturn_dungeon_brick");
			saturnDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "saturnDungeonBrickStoneBlockfullslab", "saturn_dungeon_brick");
			saturnDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.saturnDungeonBrick, 0, "saturnDungeonBrickStoneStairs");
		}
		if (Config.uranus) {
			uranusStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "uranusStoneBlockhalfslab", "uranus_stone");
			uranusStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "uranusStoneBlockfullslab", "uranus_stone");
			uranusStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.uranusBlocks, 2, "uranusStoneStairs");
			uranusStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.uranusBlocks, 5, "uranusStoneBrickStairs");

			uranusDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "uranusDungeonBrickStoneBlockhalfslab", "uranus_dungeon_brick");
			uranusDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "uranusDungeonBrickStoneBlockfullslab", "uranus_dungeon_brick");
			uranusDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.uranusDungeonBrick, 0, "uranusDungeonBrickStoneStairs");
		}
		if (Config.neptune) {
			neptuneStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "neptuneStoneBlockhalfslab", "neptune_stone");
			neptuneStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "neptuneStoneBlockfullslab", "neptune_stone");
			neptuneStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.neptuneBlocks, 2, "neptuneStoneStairs");
			neptuneStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.neptuneBlocks, 8, "neptuneStoneBrickStairs");

			neptuneDungeonBrickStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "neptuneDungeonBrickStoneBlockhalfslab", "neptune_dungeon_brick");
			neptuneDungeonBrickStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "neptuneDungeonBrickStoneBlockfullslab", "neptune_dungeon_brick");
			neptuneDungeonBrickStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.neptuneDungeonBrick, 0, "neptuneDungeonBrickStoneStairs");
		}
		if (Config.pluto) {
			plutoStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "plutoStoneBlockhalfslab", "pluto_stone");
			plutoStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "plutoStoneBlockfullslab", "pluto_stone");
			plutoStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.plutoBlocks, 2, "plutoStoneStairs");
			plutoStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.plutoBlocks, 8, "plutoStoneBrickStairs");
		}
		if (Config.eris) {
			erisStoneBlockHalfSlab = new BlockBasicSlab(false, ExtraPlanets.BlocksTab, "erisStoneBlockhalfslab", "eris_stone");
			erisStoneBlockDoubleSlab = new BlockBasicSlab(true, null, "erisStoneBlockfullslab", "eris_stone");
			erisStoneStairs = new BlockBasicStairs(ExtraPlanets_Blocks.erisBlocks, 2, "erisStoneStairs");
			erisStoneBrickStairs = new BlockBasicStairs(ExtraPlanets_Blocks.erisBlocks, 6, "erisStoneBrickStairs");
		}
	}

	private static void registerSlabsAndStairs() {
		if (Config.mercury) {
			GameRegistry.registerBlock(mercuryStoneBlockHalfSlab, MercuryStoneItemSlab.class, "mercuryStonehalfslab");
			GameRegistry.registerBlock(mercuryStoneBlockDoubleSlab, MercuryStoneItemSlab.class, "mercuryStonefullslab");
			GameRegistry.registerBlock(mercuryStoneStairs, "mercuryStoneStairs");
			GameRegistry.registerBlock(mercuryStoneBrickStairs, "mercuryStoneBrickStairs");
		}
		if (Config.venus) {
			GameRegistry.registerBlock(venusStoneBlockHalfSlab, VenusStoneItemSlab.class, "venusStonehalfslab");
			GameRegistry.registerBlock(venusStoneBlockDoubleSlab, VenusStoneItemSlab.class, "venusStonefullslab");
			GameRegistry.registerBlock(venusStoneStairs, "venusStoneStairs");
			GameRegistry.registerBlock(venusStoneBrickStairs, "venusStoneBrickStairs");

			GameRegistry.registerBlock(venusDungeonBrickStoneBlockHalfSlab, VenusDungeonBrickStoneItemSlab.class, "venusDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(venusDungeonBrickStoneBlockDoubleSlab, VenusDungeonBrickStoneItemSlab.class, "venusDungeonBrickStonefullslab");
			GameRegistry.registerBlock(venusDungeonBrickStoneStairs, "venusDungeonBrickStoneStairs");
		}
		if (Config.ceres) {
			GameRegistry.registerBlock(ceresStoneBlockHalfSlab, CeresStoneItemSlab.class, "ceresStonehalfslab");
			GameRegistry.registerBlock(ceresStoneBlockDoubleSlab, CeresStoneItemSlab.class, "ceresStonefullslab");
			GameRegistry.registerBlock(ceresStoneStairs, "ceresStoneStairs");
			GameRegistry.registerBlock(ceresStoneBrickStairs, "ceresStoneBrickStairs");
		}
		if (Config.jupiter) {
			GameRegistry.registerBlock(jupiterStoneBlockHalfSlab, JupiterStoneItemSlab.class, "jupiterStonehalfslab");
			GameRegistry.registerBlock(jupiterStoneBlockDoubleSlab, JupiterStoneItemSlab.class, "jupiterStonefullslab");
			GameRegistry.registerBlock(jupiterStoneStairs, "jupiterStoneStairs");
			GameRegistry.registerBlock(jupiterStoneBrickStairs, "jupiterStoneBrickStairs");

			GameRegistry.registerBlock(jupiterDungeonBrickStoneBlockHalfSlab, JupiterDungeonBrickStoneItemSlab.class, "jupiterDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(jupiterDungeonBrickStoneBlockDoubleSlab, JupiterDungeonBrickStoneItemSlab.class, "jupiterDungeonBrickStonefullslab");
			GameRegistry.registerBlock(jupiterDungeonBrickStoneStairs, "jupiterDungeonBrickStoneStairs");
		}
		if (Config.saturn) {
			GameRegistry.registerBlock(saturnStoneBlockHalfSlab, SaturnStoneItemSlab.class, "saturnStonehalfslab");
			GameRegistry.registerBlock(saturnStoneBlockDoubleSlab, SaturnStoneItemSlab.class, "saturnStonefullslab");
			GameRegistry.registerBlock(saturnStoneStairs, "saturnStoneStairs");
			GameRegistry.registerBlock(saturnStoneBrickStairs, "saturnStoneBrickStairs");

			GameRegistry.registerBlock(saturnDungeonBrickStoneBlockHalfSlab, SaturnDungeonBrickStoneItemSlab.class, "saturnDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(saturnDungeonBrickStoneBlockDoubleSlab, SaturnDungeonBrickStoneItemSlab.class, "saturnDungeonBrickStonefullslab");
			GameRegistry.registerBlock(saturnDungeonBrickStoneStairs, "saturnDungeonBrickStoneStairs");
		}
		if (Config.uranus) {
			GameRegistry.registerBlock(uranusStoneBlockHalfSlab, UranusStoneItemSlab.class, "uranusStonehalfslab");
			GameRegistry.registerBlock(uranusStoneBlockDoubleSlab, UranusStoneItemSlab.class, "uranusStonefullslab");
			GameRegistry.registerBlock(uranusStoneStairs, "uranusStoneStairs");
			GameRegistry.registerBlock(uranusStoneBrickStairs, "uranusStoneBrickStairs");

			GameRegistry.registerBlock(uranusDungeonBrickStoneBlockHalfSlab, UranusDungeonBrickStoneItemSlab.class, "uranusDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(uranusDungeonBrickStoneBlockDoubleSlab, UranusDungeonBrickStoneItemSlab.class, "uranusDungeonBrickStonefullslab");
			GameRegistry.registerBlock(uranusDungeonBrickStoneStairs, "uranusDungeonBrickStoneStairs");
		}
		if (Config.neptune) {
			GameRegistry.registerBlock(neptuneStoneBlockHalfSlab, NeptuneStoneItemSlab.class, "neptuneStonehalfslab");
			GameRegistry.registerBlock(neptuneStoneBlockDoubleSlab, NeptuneStoneItemSlab.class, "neptuneStonefullslab");
			GameRegistry.registerBlock(neptuneStoneStairs, "neptuneStoneStairs");
			GameRegistry.registerBlock(neptuneStoneBrickStairs, "neptuneStoneBrickStairs");

			GameRegistry.registerBlock(neptuneDungeonBrickStoneBlockHalfSlab, NeptuneDungeonBrickStoneItemSlab.class, "neptuneDungeonBrickStonehalfslab");
			GameRegistry.registerBlock(neptuneDungeonBrickStoneBlockDoubleSlab, NeptuneDungeonBrickStoneItemSlab.class, "neptuneDungeonBrickStonefullslab");
			GameRegistry.registerBlock(neptuneDungeonBrickStoneStairs, "neptuneDungeonBrickStoneStairs");
		}
		if (Config.pluto) {
			GameRegistry.registerBlock(plutoStoneBlockHalfSlab, PlutoStoneItemSlab.class, "plutoStonehalfslab");
			GameRegistry.registerBlock(plutoStoneBlockDoubleSlab, PlutoStoneItemSlab.class, "plutoStonefullslab");
			GameRegistry.registerBlock(plutoStoneStairs, "plutoStoneStairs");
			GameRegistry.registerBlock(plutoStoneBrickStairs, "plutoStoneBrickStairs");
		}
		if (Config.eris) {
			GameRegistry.registerBlock(erisStoneBlockHalfSlab, ErisStoneItemSlab.class, "erisStonehalfslab");
			GameRegistry.registerBlock(erisStoneBlockDoubleSlab, ErisStoneItemSlab.class, "erisStonefullslab");
			GameRegistry.registerBlock(erisStoneStairs, "erisStoneStairs");
			GameRegistry.registerBlock(erisStoneBrickStairs, "erisStoneBrickStairs");
		}
	}
}
