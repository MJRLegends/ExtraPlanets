package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.storage.loot.LootTableList;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.BlockDecorativeBlocks2;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.util.WorldGenHelper;

public class WorldGenBasicHideout extends WorldGenerator {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenHelper.checkValidSpawn(world, position, 10) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				System.out.println("Spawning Basic Hideout at (x, y, z)" + position.toString());
			generateStructure(world, rand, position);
			fillChests(world, rand, position);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 0, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 0, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 0, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 0, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 0, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 1), Blocks.CHEST.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 2), Blocks.JUKEBOX.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 3), Blocks.QUARTZ_STAIRS.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), Blocks.QUARTZ_STAIRS.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 4), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 4), Blocks.OAK_STAIRS.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 1, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), Blocks.FURNACE.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 5), Blocks.BED.getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 5), Blocks.BED.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 1, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 6), Blocks.FURNACE.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 6), Blocks.BED.getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 6), Blocks.BED.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 1, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 7), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 7), Blocks.OAK_STAIRS.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 1, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 8), Blocks.QUARTZ_STAIRS.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 8), Blocks.QUARTZ_STAIRS.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 9), Blocks.JUKEBOX.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 1, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 10), Blocks.CHEST.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 4), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 2, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 5), Blocks.FURNACE.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 2, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 6), Blocks.FURNACE.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 2, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 7), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 2, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 2, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 0), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 1), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 1), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 2), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 2), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 3), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 3), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 4), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 4), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 3, z + 4), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 5), Blocks.FURNACE.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 5), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 3, z + 5), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 6), Blocks.FURNACE.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 6), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 3, z + 6), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 7), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 7), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 13, y + 3, z + 7), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 8), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 8), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 9), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 12, y + 3, z + 9), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 10), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 10), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 11), ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.RED_BLOCK), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 1), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 1), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 1), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 2), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 3), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 3), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 3), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 3), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 3), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 3), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 3), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 3), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 3), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 3), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 3), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 4), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 4), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 4), Blocks.REDSTONE_LAMP.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 4), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 4), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 4), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 4), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 4), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 4), Blocks.REDSTONE_LAMP.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 4), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 4), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 12, y + 4, z + 4), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 5), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 5), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 5), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 5), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 5), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 5), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 12, y + 4, z + 5), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 6), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 6), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 6), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 6), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 6), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 6), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 12, y + 4, z + 6), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 7), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 7), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 7), Blocks.REDSTONE_LAMP.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 7), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 7), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 7), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 7), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 7), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 7), Blocks.REDSTONE_LAMP.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 7), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 7), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 12, y + 4, z + 7), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 8), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 8), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 8), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 8), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 8), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 8), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 8), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 8), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 8), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 8), Blocks.DOUBLE_STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 8), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 9), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 10), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 10), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 10), Blocks.STONE_SLAB.getStateFromMeta(7), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 4), Blocks.LEVER.getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 4), Blocks.LEVER.getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 7), Blocks.LEVER.getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 7), Blocks.LEVER.getStateFromMeta(0), 3);
		return true;

	}

	public boolean fillChests(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		int random = rand.nextInt(15) + 1;
		if (random < 5) {
			if (Config.DEBUG_MODE)
				System.out.println("Loot Spawned!");
			int lastNumber = 0;
			for (int i = 0; i < rand.nextInt(4); i++) {
				int randomChests;
				do {
					randomChests = rand.nextInt(9);
				} while (lastNumber == randomChests);
				lastNumber = randomChests;
				if (Config.DEBUG_MODE)
					System.out.println("Chest " + randomChests);
				TileEntityChest chest;
				switch (randomChests) {
				case 1:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 1, z + 1));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}
						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 2:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 1, z + 4));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 3:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 1, z + 7));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 4:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 1, z + 10));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 5:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 2, z + 4));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 6:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 2, z + 7));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 7:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 3, z + 4));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				case 8:
					chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 3, z + 7));

					if (chest != null) {
						for (int j = 0; j < chest.getSizeInventory(); j++) {
							chest.setInventorySlotContents(j, ItemStack.EMPTY);
						}

						chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
					}
					break;
				}
			}
		} else {
			if (Config.DEBUG_MODE)
				System.out.println("No loot spawned!");
		}
		return false;
	}
}