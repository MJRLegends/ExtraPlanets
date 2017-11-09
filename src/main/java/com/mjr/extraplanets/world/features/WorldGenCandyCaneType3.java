package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class WorldGenCandyCaneType3 extends WorldGenerator {

	public WorldGenCandyCaneType3() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					if (world.getBlockState(new BlockPos(x + i, y - 1, z + j)).getBlock() == Blocks.AIR)
						return false;
				} catch (Exception ex) {
					System.out.println("ExtraPlanets: " + ex.getMessage());
				}
			}
		}
		if (!world.isAreaLoaded(new BlockPos(x + 10, y, z + 10), 10))
			return false;
		else {
			if (Config.DEBUG_MODE)
				System.out.println("Spawning Candy Cane Type 3 at (x, y, z)" + x + " " + y + " " + z);
			generate_r0(world, rand, x, y, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z) {
		int randomNum = rand.nextInt(11) + 0;
		int metaNumber = 0;
		if(randomNum != 0)
			metaNumber = randomNum - 1;

		world.setBlockState(new BlockPos(x + 0, y + 0, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 5, z + 1), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 6, z + 2), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 6, z + 3), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 5, z + 4), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 5), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 5), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		return true;

	}
}