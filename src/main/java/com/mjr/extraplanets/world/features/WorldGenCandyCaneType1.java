package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.util.MessageUtilities;
import com.mjr.extraplanets.util.WorldGenHelper;

public class WorldGenCandyCaneType1 extends WorldGenerator {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenHelper.checkValidSpawn(world, position, 1) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog("Spawning Candy Cane Type 1 at (x, y, z)" + position.toString());
			generateStructure(world, rand, position);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		int randomNum = rand.nextInt(11) + 0;
		int metaNumber = 0;
		if (randomNum != 0)
			metaNumber = randomNum - 1;

		world.setBlockState(new BlockPos(x + 0, y + 0, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 5, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 6, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 7, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 0), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 8, z + 1), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 8, z + 2), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 8, z + 3), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 7, z + 4), ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 6, z + 5), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		world.setBlockState(new BlockPos(x + 0, y + 5, z + 5), ExtraPlanets_Blocks.CANDY_BLOCKS.getStateFromMeta(metaNumber), 2);
		return true;
	}
}