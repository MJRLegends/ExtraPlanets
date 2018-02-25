package com.mjr.extraplanets.planets.Neptune.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomBoss;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerNeptune;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerNeptuneDefault;

public class RoomBossNeptune extends RoomBoss {
	public RoomBossNeptune() {
	}

	public RoomBossNeptune(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, sizeX, sizeY, sizeZ, entranceDir);
	}

	public RoomBossNeptune(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, 24, 18, 24, entranceDir);
	}

	@Override
	public boolean addComponentParts(World world, Random rand, StructureBoundingBox chunkBox) {
		for (int i = 0; i <= this.sizeX; i++) {
			for (int j = 0; j <= this.sizeY; j++) {
				for (int k = 0; k <= this.sizeZ; k++) {
					if (i == 0 || i == this.sizeX || j == 0 || k == 0 || k == this.sizeZ) {
						boolean placeBlock = true;
						if (getDirection().getAxis() == EnumFacing.Axis.Z) {
							int start = (this.boundingBox.maxX - this.boundingBox.minX) / 2 - 1;
							int end = (this.boundingBox.maxX - this.boundingBox.minX) / 2 + 1;
							if (i > start && i <= end && j < 3 && j > 0) {
								if (getDirection() == EnumFacing.SOUTH && k == 0) {
									placeBlock = false;
								} else if (getDirection() == EnumFacing.NORTH && k == this.sizeZ) {
									placeBlock = false;
								}
							}
						} else {
							int start = (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 - 1;
							int end = (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 + 1;
							if (k > start && k <= end && j < 3 && j > 0) {
								if (getDirection() == EnumFacing.EAST && i == 0) {
									placeBlock = false;
								} else if (getDirection() == EnumFacing.WEST && i == this.sizeX) {
									placeBlock = false;
								}
							}
						}
						if (placeBlock) {
							this.setBlockState(world, this.configuration.getBrickBlock(), i, j, k, chunkBox);
						} else {
							this.setBlockState(world, Blocks.air.getDefaultState(), i, j, k, chunkBox);
						}
					} else if (j == this.sizeY) {
						if ((i <= 2 || k <= 2 || i >= this.sizeX - 2 || k >= this.sizeZ - 2) && rand.nextInt(4) == 0) {
							this.setBlockState(world, Blocks.glowstone.getDefaultState(), i, j, k, chunkBox);
						} else {
							this.setBlockState(world, this.configuration.getBrickBlock(), i, j, k, chunkBox);
						}
					}
					// else if (j == 1 && (i <= 2 || k <= 2 || i >= this.sizeX - 2 || k >= this.sizeZ - 2) && rand.nextInt(6) == 0) {
					// this.setBlockState(world, MarsBlocks.creeperEgg.getDefaultState(), i, j, k, chunkBox);
					// }
					else {
						this.setBlockState(world, Blocks.air.getDefaultState(), i, j, k, chunkBox);
					}
				}
			}
		}

		int spawnerX = this.sizeX / 2;
		int spawnerY = 1;
		int spawnerZ = this.sizeZ / 2;
		BlockPos blockpos = new BlockPos(this.getXWithOffset(spawnerX, spawnerZ), this.getYWithOffset(spawnerY), this.getZWithOffset(spawnerX, spawnerZ));
		// Is this position inside the chunk currently being generated?
		if (chunkBox.isVecInside(blockpos)) {
			world.setBlockState(blockpos, ExtraPlanets_Blocks.NEPTUNE_SPAWNER.getDefaultState(), 2);
			if (Config.USE_DEFAULT_BOSSES) {
				TileEntityDungeonSpawnerNeptuneDefault spawner = (TileEntityDungeonSpawnerNeptuneDefault) world.getTileEntity(blockpos);
				if (spawner != null) {
					spawner.setRoom(new Vector3(this.boundingBox.minX + 1, this.boundingBox.minY + 1, this.boundingBox.minZ + 1), new Vector3(this.sizeX - 1, this.sizeY - 1, this.sizeZ - 1));
				}
			} else {
				TileEntityDungeonSpawnerNeptune spawner = (TileEntityDungeonSpawnerNeptune) world.getTileEntity(blockpos);
				if (spawner != null) {
					spawner.setRoom(new Vector3(this.boundingBox.minX + 1, this.boundingBox.minY + 1, this.boundingBox.minZ + 1), new Vector3(this.sizeX - 1, this.sizeY - 1, this.sizeZ - 1));
				}
			}
		}

		return true;
	}
}