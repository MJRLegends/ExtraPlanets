package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;

public class WorldGenWhiteSugerCane extends WorldGenerator {
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 20; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));

			if (worldIn.isAirBlock(blockpos)) {
				BlockPos blockpos1 = blockpos.down();

				if (worldIn.getBlockState(blockpos1.west()).getBlock().getMaterial() == ExtraPlanets_Fluids.CHOCOLATE_MATERIAL || worldIn.getBlockState(blockpos1.east()).getBlock().getMaterial() == ExtraPlanets_Fluids.CHOCOLATE_MATERIAL
						|| worldIn.getBlockState(blockpos1.north()).getBlock().getMaterial() == ExtraPlanets_Fluids.CHOCOLATE_MATERIAL || worldIn.getBlockState(blockpos1.south()).getBlock().getMaterial() == ExtraPlanets_Fluids.CHOCOLATE_MATERIAL) {
					int j = 2 + rand.nextInt(rand.nextInt(3) + 1);

					for (int k = 0; k < j; ++k) {
						if (ExtraPlanets_Blocks.WHITE_SUGAR_CANE.canBlockStay(worldIn, blockpos)) {
							worldIn.setBlockState(blockpos.up(k), ExtraPlanets_Blocks.WHITE_SUGAR_CANE.getDefaultState(), 2);
						}
					}
				}
			}
		}

		return true;
	}
}