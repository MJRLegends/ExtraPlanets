package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.BlockCakeBlocks;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class WorldGenCookieRocksType1 extends WorldGenerator {

	public WorldGenCookieRocksType1() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				try {
					if (world.getBlockState(new BlockPos(x + i, y - 1, z + j)).getBlock() == Blocks.AIR)
						return false;
				} catch (Exception ex) {
					System.out.println("ExtraPlanets: " + ex.getMessage());
				}
			}
		}
		if (!world.isAreaLoaded(new BlockPos(x + 12, y, z + 12), 12))
			return false;
		else {
			if (Config.DEBUG_MODE)
				System.out.println("Spawning Cookie Rocks Type 1 at (x, y, z)" + x + " " + y + " " + z);
			generate_r0(world, rand, x, y, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 2; i++) {
			
			for (int j = 0; j < 3 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 0), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 4 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 1), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 5 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 2), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 3), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 4), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 5), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 6), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 7), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 5 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 8), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 4 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 9), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 3 - i; j++)
				world.setBlockState(new BlockPos(x + j, y + i, z + 10), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			
			for (int j = 0; j < 3 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 0), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 4 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 1), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 5 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 2), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 3), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 4), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 5), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 6), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 6 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 7), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 5 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 8), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 4 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 9), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);
			for (int j = 0; j < 3 - i; j++)
				world.setBlockState(new BlockPos(x - j, y + i, z + 10), ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.COOKIE_ROCKS), 2);

		}
		return true;

	}
}