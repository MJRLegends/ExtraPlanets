package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.util.MessageUtilities;
import com.mjr.extraplanets.util.WorldGenHelper;

public class WorldGenSlimeTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenHelper.checkValidSpawn(world, position, 15) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog("Spawning Slime Tree at (x, y, z)" + position.toString());
			generateStructure(world, rand, position);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 8), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 9), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 10), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 8, z + 0), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 8, z + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 8, z + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 8, z + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 8, z + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 8, z + 9), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 8, z + 10), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 8, z + 10), Blocks.slime_block.getDefaultState(), 3);
		return true;
	}
}