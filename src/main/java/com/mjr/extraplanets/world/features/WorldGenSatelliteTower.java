package com.mjr.extraplanets.world.features;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.RoomTreasureMars;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;

public class WorldGenSatelliteTower extends WorldGenerator {

	public WorldGenSatelliteTower() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenUtilities.checkValidSpawn(world, position, 10, 10) == false)
			return false;
		else {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Spawning Satellite Tower at (x, y, z)" + position.toString());
			generateStructure(world, rand, position);
			fillChests(world, rand, position);
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 3), GCBlocks.platform.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), GCBlocks.platform.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 3), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), GCBlocks.platform.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), GCBlocks.platform.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 5, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 5, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 6, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 6, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 7, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 7, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 8, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 8, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 9, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 9, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 10, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 10, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 10, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 10, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 11, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 11, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 11, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 11, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 12, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 12, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 12, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 13, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 13, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 13, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 13, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 0), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 1), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 1), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 1), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 2), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 3), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 3), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 3), GCBlocks.platform.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 3), GCBlocks.platform.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 3), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 3), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 4), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 4), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 4), GCBlocks.platform.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 4), GCBlocks.platform.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 4), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 4), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 5), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 6), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 6), GCBlocks.grating.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 6), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 1, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 6, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 7, y + 14, z + 7), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 3, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 4, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 0), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 15, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 15, z + 1), Blocks.CHEST.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 15, z + 1), Blocks.CHEST.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 15, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 15, z + 2), Blocks.CHEST.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 2, y + 15, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 15, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 15, z + 2), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 3), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 3), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 4), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 4), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 15, z + 5), Blocks.CHEST.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 2, y + 15, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 15, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 15, z + 5), Blocks.CHEST.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 15, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 15, z + 6), Blocks.CHEST.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 5, y + 15, z + 6), Blocks.CHEST.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 6, y + 15, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 0, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 3, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 4, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 7, y + 15, z + 7), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 16, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 16, z + 1), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 16, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 16, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 16, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 16, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 16, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 6, y + 16, z + 6), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 17, z + 1), GCBlocks.glowstoneTorch.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 6, y + 17, z + 1), GCBlocks.glowstoneTorch.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 2, y + 17, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 17, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 17, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 17, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 1, y + 17, z + 6), GCBlocks.glowstoneTorch.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 6, y + 17, z + 6), GCBlocks.glowstoneTorch.getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(x + 2, y + 18, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 18, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 18, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 5, y + 18, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 19, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 3, y + 19, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 19, z + 2), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 19, z + 2), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 2, y + 19, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 19, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 19, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 19, z + 3), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 19, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 3, y + 19, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 19, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 19, z + 4), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 2, y + 19, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 3, y + 19, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 4, y + 19, z + 5), AsteroidBlocks.blockBasic.getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(x + 5, y + 19, z + 5), GCBlocks.wallGC.getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(x + 3, y + 20, z + 3), GCBlocks.radioTelescope.getDefaultState(), 3);
		return true;
	}

	public boolean fillChests(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		// Determined if loot should be generated using a 1/2 chance
		TileEntityChest chest = null;
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 22, z + 4));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
		}
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 5, y + 15, z + 1));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
		}
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 2, y + 15, z + 1));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
		}
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 1, y + 15, z + 2));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
		}
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 15, z + 2));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
		}
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 1, y + 15, z + 5));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
		}
		if (rand.nextInt(10) + 1 < 5) {
			chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 6, y + 15, z + 5));

			if (chest != null) {
				for (int i = 0; i < chest.getSizeInventory(); i++) {
					chest.setInventorySlotContents(i, null);
				}

				chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
			}
			if (rand.nextInt(10) + 1 < 5) {
				chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 2, y + 15, z + 6));

				if (chest != null) {
					for (int i = 0; i < chest.getSizeInventory(); i++) {
						chest.setInventorySlotContents(i, null);
					}

					chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
				}

				chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 5, y + 15, z + 6));

				if (chest != null) {
					for (int i = 0; i < chest.getSizeInventory(); i++) {
						chest.setInventorySlotContents(i, null);
					}

					chest.setLootTable(RoomTreasureMars.TABLE_TIER_2_DUNGEON, rand.nextLong());
				}
			}
		}
		return false;
	}
}