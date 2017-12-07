package com.mjr.extraplanets.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class WorldGenHelper {
	
	public static void generateStructure(WorldGenerator worldGen, World world, Random rand, BlockPos pos) {
		int x = pos.getX() + 8;
		int z = pos.getZ() + 8;
		int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
		worldGen.generate(world, rand, new BlockPos(x, y, z));
	}

	public static void generateStructureWithRandom(WorldGenerator worldGen, World world, Random rand, BlockPos pos, int randomAmount) {
		generateStructure(worldGen, world, rand, pos.add(rand.nextInt(randomAmount), 0, rand.nextInt(randomAmount)));
	}

	public static void generateLake(World world, Random rand, BlockPos pos, Block fluid, Block block) {
		int x = pos.getX() + 8;
		int z = pos.getZ() + 8;
		int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY() - 2;
		new WorldGenCustomLake(fluid).generate(world, rand, new BlockPos(x, y, z), block);
	}

	public static void generateLake(World world, Random rand, BlockPos pos, Block fluid, IBlockState block) {
		int x = pos.getX() + 8;
		int z = pos.getZ() + 8;
		int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY() - 2;
		new WorldGenCustomLake(fluid).generate(world, rand, new BlockPos(x, y, z), block);
	}
	
	public static boolean checkValidSpawn(World world, BlockPos position, int checkSize, int loadedCheckSize) {
		if (!world.isAreaLoaded(position, loadedCheckSize))
			return false;

		for (position = position.add(0, 0, 0); position.getY() > 5 && world.isAirBlock(position) || world.getBlockState(position).getMaterial().isLiquid(); position = position.down()) {
			;
		}

		if (position.getY() <= 4) {
			return false;
		}

		for (int i = -checkSize; i <= checkSize; ++i) {
			for (int j = -checkSize; j <= checkSize; ++j) {
				if (world.isAirBlock(position.add(i, -1, j)) && world.isAirBlock(position.add(i, -2, j)) || world.getBlockState(position.add(i, -1, j)).getMaterial().isLiquid() && world.getBlockState(position.add(i, -2, j)).getMaterial().isLiquid()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkValidSpawn(World world, BlockPos position, int size) {
		return checkValidSpawn(world, position, size, size);
	}
}
