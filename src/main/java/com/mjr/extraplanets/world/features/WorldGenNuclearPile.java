package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.util.WorldGenHelper;

public class WorldGenNuclearPile extends WorldGenerator {

	public WorldGenNuclearPile() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();

		if (WorldGenHelper.checkValidSpawn(world, position, 5) == false)
			return false;

		if (!world.isAreaLoaded(new BlockPos(x + 8, y, z + 8), 8))
			return false;
		else {
			if (Config.DEBUG_MODE)
				System.out.println("Spawning NuclearPile at (x, y, z)" + x + " " + y + " " + z);
			generate_r0(world, rand, x, y - 1, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int i, int j, int k) {
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 0), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 3), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 4), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 5), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 0), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 7), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 8), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 6), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 1), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 2), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 5), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 3), Blocks.slime_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 4), Blocks.slime_block.getDefaultState(), 3);
		return true;
	}
}