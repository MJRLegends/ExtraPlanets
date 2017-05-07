package com.mjr.extraplanets.worldGen.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;

public class WorldGenFrozenNitrogenPile extends WorldGenerator {

	public WorldGenFrozenNitrogenPile() {

	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					if (world.getBlock(x + i, y - 1, z + j) == Blocks.air)
						return false;
				} catch (Exception ex) {
					System.out.println("ExtraPlanets: " + ex.getMessage());
				}
			}
		}
		if (!world.checkChunksExist(x - 8, y, z - 8, x + 8, y, z + 8))
			return false;
		else {
			// System.out.println("Spawning BigPurpleTree at (x, y, z)" + x + " " + y
			// + " " + z, 3);
			generate_r0(world, rand, x, y - 1, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 0, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 0, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 0, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 1, j + 0, k + 1, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 1, j + 0, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 1, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 1, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 1, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 0, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 1, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 6, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 0, k + 7, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 1, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 1, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 1, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 2, j + 1, k + 5, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 2, j + 2, k + 2, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 2, j + 2, k + 3, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 2, j + 2, k + 4, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 2, j + 2, k + 5, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 2, j + 2, k + 6, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 2, j + 3, k + 3, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 2, j + 3, k + 4, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 2, j + 3, k + 5, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 3, j + 0, k + 1, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 0, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 0, k + 6, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 0, k + 7, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 1, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 1, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 1, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 1, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 1, k + 6, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 2, k + 2, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 3, j + 2, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 2, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 2, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 3, j + 2, k + 6, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 3, j + 3, k + 2, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 3, j + 3, k + 3, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 3, j + 3, k + 4, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 3, j + 3, k + 5, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 3, j + 3, k + 6, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 4, j + 0, k + 0, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 1, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 6, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 7, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 0, k + 8, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 1, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 1, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 1, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 1, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 1, k + 6, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 2, k + 2, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 4, j + 2, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 2, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 2, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 4, j + 2, k + 6, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 4, j + 3, k + 2, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 4, j + 3, k + 3, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 4, j + 3, k + 4, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 4, j + 3, k + 5, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 4, j + 3, k + 6, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 5, j + 0, k + 1, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 0, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 0, k + 6, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 1, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 1, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 1, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 1, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 5, j + 1, k + 6, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 5, j + 2, k + 2, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 5, j + 2, k + 3, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 5, j + 2, k + 4, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 5, j + 2, k + 5, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 5, j + 2, k + 6, ExtraPlanets_Fluids.nitrogen, 0, 3);
		world.setBlock(i + 5, j + 3, k + 3, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 5, j + 3, k + 4, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 5, j + 3, k + 5, ExtraPlanets_Fluids.nitrogen, 1, 3);
		world.setBlock(i + 6, j + 0, k + 1, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 6, j + 0, k + 2, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 6, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 6, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 6, j + 0, k + 5, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 7, j + 0, k + 3, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		world.setBlock(i + 7, j + 0, k + 4, ExtraPlanets_Blocks.frozenNitrogen, 0, 3);
		return true;
	}
}