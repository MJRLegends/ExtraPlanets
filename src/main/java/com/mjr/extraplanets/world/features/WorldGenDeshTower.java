package com.mjr.extraplanets.world.features;

import java.util.Random;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.util.WorldGenHelper;

import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDeshTower extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (WorldGenHelper.checkValidSpawn(world, x, y, z, 10) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				System.out.println("Spawning Desh Tower at (x, y, z)" + x + " " + y + " " + z);
			generatreStructure(world, rand, x, y, z);
		}
		return true;
	}

	public boolean generatreStructure(World world, Random rand, int x, int y, int z) {
		world.setBlock(x + 0, y + 0, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 0, z + 1, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 2, y + 0, z + 1, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 0, z + 1, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 0, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 2, y + 0, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 0, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 0, z + 3, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 2, y + 0, z + 3, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 0, z + 3, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 0, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 0, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 4, y + 0, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 1, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 1, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 4, y + 1, z + 0, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 1, z + 1, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 1, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 2, y + 1, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 1, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 1, z + 3, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 0, y + 1, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 1, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 1, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 4, y + 1, z + 4, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 2, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 2, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 3, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 3, z + 1, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 3, z + 2, MarsBlocks.marsBlock, 8, 3);
		world.setBlock(x + 3, y + 3, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 3, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 4, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 5, z + 2, Blocks.iron_bars, 0, 3);
		world.setBlock(x + 2, y + 6, z + 2, Blocks.iron_bars, 0, 3);
		return true;
	}
}