package com.mjr.extraplanets.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class WorldGenHelper {

	public static void generateStructure(WorldGenerator worldGen, World world, Random rand, int x, int y, int z) {
		x = x + 8;
		z = z + 8;
		y = world.getTopSolidOrLiquidBlock(x, z);
		worldGen.generate(world, rand, x, y, z);
	}

	public static void generateStructureWithRandom(WorldGenerator worldGen, World world, Random rand, int x, int y, int z, int randomAmount) {
		generateStructure(worldGen, world, rand, rand.nextInt(randomAmount), 0, rand.nextInt(randomAmount));
	}

	public static void generateLake(World world, Random rand, int x, int y, int z, Block fluid, Block block) {
		x = x + 8;
		z = z + 8;
		y = world.getTopSolidOrLiquidBlock(x, z) - 2;
		new WorldGenCustomLake(fluid).generate(world, rand, x, y, z, block);
	}

	public static boolean checkValidSpawn(World world, int x, int y, int z, int size) {
		if (!world.checkChunksExist(x, y, z, x + size, y + size, z + size))
			return false;

		
		for (int i = y; i > 5 && world.isAirBlock(x, y, z) || world.getBlock(x, y, z).getMaterial().isLiquid(); y--) {
			;
		}
		
		if (y <= 4) {
			return false;
		}
		
		for (int i = -size; i <= size; ++i) {
			for (int j = -size; j <= size; ++j) {
				if (world.isAirBlock(x, y - 1, z) && world.isAirBlock(x, y - 2, z) || world.getBlock(x, y-1, z).getMaterial().isLiquid()
						&& world.getBlock(x, y - 2, z).getMaterial().isLiquid()) {
					return false;
				}
			}
		}
		return true;
	}
}
