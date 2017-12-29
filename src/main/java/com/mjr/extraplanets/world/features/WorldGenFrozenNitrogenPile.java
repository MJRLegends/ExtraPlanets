package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;

public class WorldGenFrozenNitrogenPile extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenUtilities.checkValidSpawn(world, position, 5) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Spawning Frozen Nitrogen Pile at (x, y, z)" + position.toString());
			generateStructure(world, rand, position);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 1), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 0), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 1), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 7), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 3), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 4), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 5), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 6), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 3), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 4), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 5), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 1), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 7), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 6), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 6), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 2), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 3), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 4), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 5), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 6), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 0), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 1), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 7), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 8), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 6), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 2), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 6), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 2), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 3), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 4), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 5), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 6), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 1), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 2), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 3), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 4), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 6), ExtraPlanets_Fluids.NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 3), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 4), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 5), ExtraPlanets_Fluids.NITROGEN.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 1), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 2), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 3), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 0, z + 4), ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState(), 3);
		return true;
	}
}