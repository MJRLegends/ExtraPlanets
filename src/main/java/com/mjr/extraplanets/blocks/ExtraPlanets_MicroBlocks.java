package com.mjr.extraplanets.blocks;

import java.lang.reflect.Method;

import com.mjr.extraplanets.Config;

import net.minecraft.block.Block;

public class ExtraPlanets_MicroBlocks {

	public static void init() {
		registerMicroBlocks();
	}

	private static void registerMicroBlocks() {
		try {
			Class clazz = Class.forName("codechicken.microblock.MicroMaterialRegistry");
			if (clazz != null) {
				Method registerMethod = null;
				Method[] methodz = clazz.getMethods();
				for (Method m : methodz) {
					if (m.getName().equals("registerMaterial")) {
						registerMethod = m;
						break;
					}
				}
				Class clazzbm = Class.forName("codechicken.microblock.BlockMicroMaterial");
				if (Config.mercury) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.mercuryBlocks, 0), "tile.mercury.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.mercuryBlocks, 1), "tile.mercury.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.mercuryBlocks, 2), "tile.mercury.stone");
				}
				if (Config.ceres) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.ceresBlocks, 0), "tile.ceres.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.ceresBlocks, 1), "tile.ceres.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.ceresBlocks, 2), "tile.ceres.stone");
				}
				if (Config.venus) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.venusBlocks, 0), "tile.venus.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.venusBlocks, 1), "tile.venus.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.venusBlocks, 2), "tile.venus.stone");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.venusBlocks, 7), "tile.venus.carbonBlock");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.veunsDungeonBrick, 0), "tile.veunsDungeonBrick");
				}
				if (Config.jupiter) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.jupiterBlocks, 0), "tile.jupiter.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.jupiterBlocks, 1), "tile.jupiter.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.jupiterBlocks, 2), "tile.jupiter.stone");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.jupiterBlocks, 8), "tile.jupiter.palladiumBlock");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.jupiterDungeonBrick, 0), "tile.jupiterDungeonBrick");
				}
				if (Config.saturn) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.saturnBlocks, 0), "tile.saturn.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.saturnBlocks, 1), "tile.saturn.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.saturnBlocks, 2), "tile.saturn.stone");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.saturnBlocks, 7), "tile.saturn.magnesiumBlock");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.saturnDungeonBrick, 0), "tile.saturnDungeonBrick");
				}
				if (Config.uranus) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.uranusBlocks, 0), "tile.uranus.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.uranusBlocks, 1), "tile.uranus.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.uranusBlocks, 2), "tile.uranus.stone");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.uranusBlocks, 4), "tile.uranus.crystalBlock");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.uranusBlocks, 0), "tile.uranusBlocks");
				}
				if (Config.neptune) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.neptuneBlocks, 0), "tile.neptune.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.neptuneBlocks, 1), "tile.neptune.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.neptuneBlocks, 2), "tile.neptune.stone");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.neptuneBlocks, 7), "tile.neptune.zincBlock");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.neptuneDungeonBrick, 0), "tile.neptuneDungeonBrick");
				}
				if (Config.pluto) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.plutoBlocks, 0), "tile.pluto.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.plutoBlocks, 1), "tile.pluto.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.plutoBlocks, 2), "tile.pluto.stone");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.plutoBlocks, 7), "tile.pluto.tungstenBlock");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.plutoDungeonBrick, 0), "tile.plutoDungeonBrick");
				}
				if (Config.eris) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.erisBlocks, 0), "tile.eris.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.erisBlocks, 1), "tile.eris.subSurface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.erisBlocks, 2), "tile.eris.stone");
				}
			}
		} catch (Exception e) {
		}
	}
}
