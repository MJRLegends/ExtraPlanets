package com.mjr.extraplanets.worldGen.features;

import java.util.Random;

import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDeshTower extends WorldGenerator {

	public WorldGenDeshTower() {

	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					if (world.getBlock(x + i, y - 1, z + j) == Blocks.air)
						return false;
				} catch (Exception ex) {
					System.out.println("ExtraPlanets: " + ex.getMessage());
				}
			}
		}
		if (!world.checkChunksExist(x - 8, y, z - 8, x + 8, y, z + 8))
			return false;
		else {
			System.out.println("Spawning Desh Tower at (x, y, z)" + x + " " + y + " " + z);
			generate_r0(world, rand, x, y - 1, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z) {
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