package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.BlockCakeBlocks;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.util.MessageUtilities;
import com.mjr.extraplanets.util.WorldGenHelper;

public class WorldGenCookieRocksType1 extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenHelper.checkValidSpawn(world, position, 10) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog("Spawning Cookie Rocks Type 1 at (x, y, z)" + position.toString());
			generateStructure(world, rand, position);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
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