package com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon;

import java.util.Random;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class RoomEmptyJupiter extends SizedPieceJupiter {
	private int chanceOfMagmaBlocks = 0;
	
	public RoomEmptyJupiter() {
	}

	public RoomEmptyJupiter(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir, int chanceOfMagmaBlocks) {
		super(configuration, sizeX, sizeY, sizeZ, entranceDir.getOpposite());
        this.coordBaseMode = EnumFacing.SOUTH;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sizeZ = sizeZ;
		int yPos = configuration.getYPosition();

		this.boundingBox = new StructureBoundingBox(blockPosX, yPos, blockPosZ, blockPosX + this.sizeX, yPos + this.sizeY, blockPosZ + this.sizeZ);
		this.chanceOfMagmaBlocks = chanceOfMagmaBlocks;
	}

	@Override
	public boolean addComponentParts(World worldIn, Random random, StructureBoundingBox boundingBox) {
		for (int i = 0; i <= this.sizeX; i++) {
			for (int j = 0; j <= this.sizeY; j++) {
				for (int k = 0; k <= this.sizeZ; k++) {
					if (i == 0 || i == this.sizeX || j == 0 || j == this.sizeY || k == 0 || k == this.sizeZ) {
						boolean placeBlock = true;
						if (getDirection().getAxis() == EnumFacing.Axis.Z) {
							int start = (this.boundingBox.maxX - this.boundingBox.minX) / 2 - 1;
							int end = (this.boundingBox.maxX - this.boundingBox.minX) / 2 + 1;
							if (i > start && i <= end && j < this.configuration.getHallwayHeight() && j > 0) {
								if (getDirection() == EnumFacing.SOUTH && k == 0) {
									placeBlock = false;
								} else if (getDirection() == EnumFacing.NORTH && k == this.sizeZ) {
									placeBlock = false;
								}
							}
						} else {
							int start = (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 - 1;
							int end = (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 + 1;
							if (k > start && k <= end && j < this.configuration.getHallwayHeight() && j > 0) {
								if (getDirection() == EnumFacing.EAST && i == 0) {
									placeBlock = false;
								} else if (getDirection() == EnumFacing.WEST && i == this.sizeX) {
									placeBlock = false;
								}
							}
						}
						if (placeBlock) {
							if (j == 0) {
								if (chanceOfMagmaBlocks != 0 && random.nextInt(chanceOfMagmaBlocks) == 1)
									this.setBlockState(worldIn, Blocks.obsidian.getDefaultState(), i, j, k, boundingBox);
								else
									this.setBlockState(worldIn, ExtraPlanets_Fluids.MAGMA.getDefaultState(), i, j, k, boundingBox);
							} else

								this.setBlockState(worldIn, this.configuration.getBrickBlock(), i, j, k, boundingBox);
						} else {
							this.setBlockState(worldIn, Blocks.air.getDefaultState(), i, j, k, boundingBox);
						}
					} else {
						this.setBlockState(worldIn, Blocks.air.getDefaultState(), i, j, k, boundingBox);
					}
				}
			}
		}

		return true;
	}

	@Override
	public PieceJupiter getNextPiece(DungeonStartJupiter startPiece, Random rand) {
		if (Math.abs(startPiece.getBoundingBox().maxZ - boundingBox.minZ) > 200) {
			return null;
		}

		if (Math.abs(startPiece.getBoundingBox().maxX - boundingBox.minX) > 200) {
			return null;
		}

		return getCorridor(rand, startPiece, 10, false);
	}
}