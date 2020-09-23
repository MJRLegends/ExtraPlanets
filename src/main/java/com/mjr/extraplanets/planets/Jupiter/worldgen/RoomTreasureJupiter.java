package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.Random;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomTreasureJupiterBase;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.blocks.BlockTier1TreasureChest;
import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class RoomTreasureJupiter extends RoomTreasureJupiterBase {
	public RoomTreasureJupiter() {
	}

	public RoomTreasureJupiter(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, rand.nextInt(4) + 6, configuration.getRoomHeight(), rand.nextInt(4) + 6, entranceDir);
	}

	public RoomTreasureJupiter(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, sizeX, sizeY, sizeZ, entranceDir);
	}

	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox boundingBox) {
		for (int i = 0; i <= this.sizeX; i++) {
			for (int j = 0; j <= this.sizeY; j++) {
				for (int k = 0; k <= this.sizeZ; k++) {
					if (i == 0 || i == this.sizeX || j == 0 || j == this.sizeY || k == 0 || k == this.sizeZ) {
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
							this.setBlockState(world, this.configuration.getBrickBlock(), i, j, k, boundingBox);
						} else {
							this.setBlockState(world, Blocks.AIR.getDefaultState(), i, j, k, boundingBox);
						}
					} else if ((i == 1 && k == 1) || (i == 1 && k == this.sizeZ - 1) || (i == this.sizeX - 1 && k == 1) || (i == this.sizeX - 1 && k == this.sizeZ - 1)) {
						this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), i, j, k, boundingBox);
					} else if (i == this.sizeX / 2 && j == 1 && k == this.sizeZ / 2) {
						BlockPos blockpos = new BlockPos(this.getXWithOffset(i, k), this.getYWithOffset(j), this.getZWithOffset(i, k));
						if (boundingBox.isVecInside(blockpos)) {
							world.setBlockState(blockpos, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_5.getDefaultState().withProperty(BlockTier1TreasureChest.FACING, this.getDirection().getOpposite()), 2);
							TileEntityTreasureChest treasureChest = (TileEntityTreasureChest) world.getTileEntity(blockpos);
							if (treasureChest != null) {
								ResourceLocation chesttype = RoomTreasureJupiterBase.TABLE_TIER_1_DUNGEON;
								if (world.provider instanceof IGalacticraftWorldProvider) {
									chesttype = ((IGalacticraftWorldProvider) world.provider).getDungeonChestType();
								}
								treasureChest.setLootTable(chesttype, random.nextLong());
							}
						}
					} else {
						this.setBlockState(world, Blocks.AIR.getDefaultState(), i, j, k, boundingBox);
					}
				}
			}
		}

		return true;
	}
}