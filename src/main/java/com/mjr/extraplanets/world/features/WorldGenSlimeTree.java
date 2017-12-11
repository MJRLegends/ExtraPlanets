package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.util.MessageUtilities;
import com.mjr.extraplanets.util.WorldGenHelper;

public class WorldGenSlimeTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (WorldGenHelper.checkValidSpawn(world, x, y, z, 15) == false)
			return false;
		else {
			if (Config.debugMode)
				MessageUtilities.debugMessageToLog("Spawning Slime Tree at (x, y, z)" + x + " " + y + " " + z);
			generateStructure(world, rand, x, y ,z);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, int x, int y, int z) {
		world.setBlock(x + 4, y + 0, z + 3, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 0, z + 3, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 5, y + 0, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 0, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 0, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 4, y + 0, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 5, y + 0, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 0, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 0, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 8, y + 0, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 5, y + 0, z + 6, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 0, z + 6, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 0, z + 6, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 5, y + 0, z + 7, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 0, z + 7, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 1, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 2, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 3, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 4, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 5, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 6, z + 3, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 5, y + 6, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 6, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 6, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 5, y + 6, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 6, z + 5, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 6, z + 6, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 6, z + 7, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 8, y + 7, z + 1, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 9, y + 7, z + 1, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 2, y + 7, z + 2, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 7, z + 2, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 8, y + 7, z + 2, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 9, y + 7, z + 2, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 2, y + 7, z + 3, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 3, y + 7, z + 3, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 4, y + 7, z + 4, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 6, y + 7, z + 7, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 7, y + 7, z + 8, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 8, y + 7, z + 9, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 9, y + 7, z + 10, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 10, y + 8, z + 0, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 0, y + 8, z + 1, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 1, y + 8, z + 1, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 9, y + 8, z + 1, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 1, y + 8, z + 2, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 9, y + 8, z + 9, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 9, y + 8, z + 10, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		world.setBlock(x + 10, y + 8, z + 10, ExtraPlanets_Blocks.slimeBlock, 1, 3);
		return true;
	}
}