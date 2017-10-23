package com.mjr.extraplanets.compatibility;

import java.lang.reflect.Method;

import net.minecraft.block.Block;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class MCMultiPartCompatibility {

	public static void init() {
		registerMicroBlocks();
	}

	private static void registerMicroBlocks() {
		try {
			Class<?> clazz = Class.forName("mcmultipart.microblock.MicroMaterialRegistry");
			if (clazz != null) {
				Method registerMethod = null;
				Method[] methodz = clazz.getMethods();
				for (Method m : methodz) {
					if (m.getName().equals("registerMaterial")) {
						registerMethod = m;
						break;
					}
				}
				Class<?> clazzbm = Class.forName("mcmultipart.microblock.BlockMicroMaterial");
				if (Config.MERCURY) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.MERCURY_BLOCKS, 0), "tile.mercury.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1), "tile.mercury.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.MERCURY_BLOCKS, 2), "tile.mercury.stone");
				}
				if (Config.CERES) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.CERES_BLOCKS, 0), "tile.ceres.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.CERES_BLOCKS, 1), "tile.ceres.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.CERES_BLOCKS, 2), "tile.ceres.stone");
				}
				if (Config.JUPITER) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.JUPITER_BLOCKS, 0), "tile.jupiter.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1), "tile.jupiter.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.JUPITER_BLOCKS, 2), "tile.jupiter.stone");
				}
				if (Config.SATURN) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.SATURN_BLOCKS, 0), "tile.saturn.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.SATURN_BLOCKS, 1), "tile.saturn.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.SATURN_BLOCKS, 2), "tile.saturn.stone");
				}
				if (Config.URANUS) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.URANUS_BLOCKS, 0), "tile.uranus.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.URANUS_BLOCKS, 1), "tile.uranus.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.URANUS_BLOCKS, 2), "tile.uranus.stone");
				}
				if (Config.NEPTUNE) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 0), "tile.neptune.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1), "tile.neptune.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 2), "tile.neptune.stone");
				}
				if (Config.PLUTO) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.PLUTO_BLOCKS, 0), "tile.pluto.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1), "tile.pluto.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.PLUTO_BLOCKS, 2), "tile.pluto.stone");
				}
				if (Config.ERIS) {
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.ERIS_BLOCKS, 0), "tile.eris.surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.ERIS_BLOCKS, 1), "tile.eris.sub_surface");
					registerMethod.invoke(null, clazzbm.getConstructor(Block.class, int.class).newInstance(ExtraPlanets_Blocks.ERIS_BLOCKS, 2), "tile.eris.stone");
				}
			}
		} catch (Exception e) {

		}
	}
}
