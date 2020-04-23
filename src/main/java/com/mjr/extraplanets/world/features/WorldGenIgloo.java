package com.mjr.extraplanets.world.features;

import java.util.Random;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockGlowstoneTorch;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.storage.loot.LootTableList;

public class WorldGenIgloo extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenUtilities.checkValidSpawn(world, position, 10) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Spawning Igloo at (x, y, z)" + position.toString());
			if ((rand.nextInt(50) + 1) != 50) {
				return generateBasic(world, rand, position.down());
			} else {
				return generateAdvanced(world, rand, position.down(2));
			}
		}
	}

	public boolean generateBasic(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), Blocks.BED.getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), Blocks.BED.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 5), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 1, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 2), GCBlocks.glowstoneTorch.getDefaultState().withProperty(BlockGlowstoneTorch.FACING, EnumFacing.SOUTH), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 8), Blocks.SNOW.getDefaultState(), 3);

		// Determined if loot should be generated using a 1/2 chance
		int random = rand.nextInt(10) + 1;
		if (random < 5) {
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 9, y + 1, z + 5));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				// Determined how many times loot should be generated. Range: 1 - 2
				int lootTimes = rand.nextInt(2) + 1;
				for (int i = 0; i < lootTimes; i++) {
					chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
				}
			}
		}
		return true;
	}

	public boolean generateAdvanced(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 2, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 5), GCBlocks.machineBase.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 5), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 3, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 7), Blocks.SNOW.getDefaultState(), 3);

		world.setBlockState(new BlockPos(x + 10, y + 3, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 8), Blocks.SNOW.getDefaultState(), 3);

		world.setBlockState(new BlockPos(x + 6, y + 3, z + 8), GCBlocks.oxygenDistributor.getDefaultState(), 3);

		world.setBlockState(new BlockPos(x + 10, y + 3, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 10), Blocks.SNOW.getDefaultState(), 3);

		world.setBlockState(new BlockPos(x + 4, y + 4, z + 1), Blocks.SNOW.getDefaultState(), 3);

		world.setBlockState(new BlockPos(x + 8, y + 4, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 4, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 10), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 1), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 2), GCBlocks.glowstoneTorch.getDefaultState().withProperty(BlockGlowstoneTorch.FACING, EnumFacing.SOUTH), 3);
		world.setBlockState(new BlockPos(x + 8, y + 5, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 5, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 5, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 10, y + 5, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 5, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 9), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 2), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 3), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 6, z + 4), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 6, z + 5), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 6, z + 6), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 7), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 8), Blocks.SNOW.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 8), Blocks.SNOW.getDefaultState(), 3);

		// Determined if loot should be generated using a 1/2 chance
		int random = rand.nextInt(10) + 1;
		if (random < 5) {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Loot Spawned!");
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 9, y + 3, z + 5));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				// Determined how many times loot should be generated. Range: 1 - 4
				int lootTimes = rand.nextInt(4) + 1;
				for (int i = 0; i < lootTimes; i++) {
					chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
				}
			}
		} else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "No loot spawned!");
		}
		return true;
	}
}