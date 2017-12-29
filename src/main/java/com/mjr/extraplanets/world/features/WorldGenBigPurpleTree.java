package com.mjr.extraplanets.world.features;

import java.util.Random;

import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class WorldGenBigPurpleTree extends WorldGenerator {

	public WorldGenBigPurpleTree() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				try {
					if (world.getBlockState(new BlockPos(x + i, y - 3, z + j)) == Blocks.AIR)
						return false;
				} catch (Exception ex) {
					MessageUtilities.debugMessageToLog(Constants.modID, "ExtraPlanets: " + ex.getMessage());
				}
			}
		}
		if (!world.isAreaLoaded(new BlockPos(x + 10, y, z + 10), 10))
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Spawning BigPurpleTree at (x, y, z)" + x + " " + y + " " + z);
			generate_r0(world, rand, x, y - 1, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z) {
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 0, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 0, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 1, z + 1), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 11, y + 1, z + 4), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 1, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 1, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 11), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 2, z + 1), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 2, z + 4), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 2, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 2, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 11), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 3, z + 1), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 3, z + 4), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 3, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 11), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 4, z + 1), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 11, y + 4, z + 4), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 4, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 4, z + 11), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 1), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 5, z + 4), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 8, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 8, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 8, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 8, y + 5, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 9, y + 5, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 11), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 6, z + 1), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 6, z + 4), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 5), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 6, z + 5), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 8), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 6, z + 8), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 11), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 1), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 11, y + 7, z + 4), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 11), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 8, z + 1), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 11, y + 8, z + 4), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 5), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 8, z + 5), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 8, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 8, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 8), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 8, z + 8), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 11), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 9, z + 1), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 9, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 9, z + 4), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 8, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 9, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 9, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 8, y + 9, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 9, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 9, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 8, y + 9, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 9, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 9, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 8, y + 9, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 9, y + 9, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 9, z + 11), MarsBlocks.vine.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 10, z + 1), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 10, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 10, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 10, z + 4), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 10, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 10, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 10, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 10, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 10, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 10, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 10, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 10, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 10, z + 11), MarsBlocks.vine.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 9, y + 11, z + 1), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 11, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 11, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 11, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 11, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 11, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 11, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 11, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 11, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 11, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 9, y + 11, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 6, y + 11, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 11, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 11, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 11, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 10, y + 11, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 11, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 11, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 11, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 11, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 11, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 11, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 7, y + 11, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 3, y + 11, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 11, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 11, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 11, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 11, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 11, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 11, z + 11), MarsBlocks.vine.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 12, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 12, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 12, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 12, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 12, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 10, y + 12, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 11, y + 12, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 12, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 12, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 11, y + 12, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 12, y + 12, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 12, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 12, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 12, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 12, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 12, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 12, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 8, y + 12, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 12, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 12, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 12, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 12, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 12, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 12, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 12, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 12, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(10), 3);
		world.setBlockState(new BlockPos(x + 7, y + 12, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 12, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 12, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 12, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 7, y + 12, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 12, z + 11), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 12, z + 11), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 12, z + 11), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 11), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 13, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 13, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 9, y + 13, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 13, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 11, y + 13, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 13, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 13, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 13, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 13, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 13, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 13, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 13, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 13, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 13, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 13, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 13, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 13, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 13, z + 11), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 10, y + 14, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 9), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 10), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), 3);
		return true;

	}
}