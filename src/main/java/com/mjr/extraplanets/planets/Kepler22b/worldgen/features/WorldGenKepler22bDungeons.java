package com.mjr.extraplanets.planets.Kepler22b.worldgen.features;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class WorldGenKepler22bDungeons extends WorldGenerator {
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int j = rand.nextInt(2) + 2;
		int k = -j - 1;
		int l = j + 1;
		int k1 = rand.nextInt(2) + 2;
		int l1 = -k1 - 1;
		int i2 = k1 + 1;
		int j2 = 0;

		for (int k2 = k; k2 <= l; ++k2) {
			for (int l2 = -1; l2 <= 4; ++l2) {
				for (int i3 = l1; i3 <= i2; ++i3) {
					BlockPos blockpos = position.add(k2, l2, i3);
					Material material = world.getBlockState(blockpos).getBlock().getMaterial();
					boolean flag = material.isSolid();

					if (l2 == -1 && !flag) {
						return false;
					}

					if (l2 == 4 && !flag) {
						return false;
					}

					if ((k2 == k || k2 == l || i3 == l1 || i3 == i2) && l2 == 0 && world.isAirBlock(blockpos) && world.isAirBlock(blockpos.up())) {
						++j2;
					}
				}
			}
		}

		if (j2 >= 1 && j2 <= 5) {
			if (Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Generating Kepler22b Dungeon at:" + position.getX() + " " + position.getY() + " " + position.getZ());
			for (int k3 = k; k3 <= l; ++k3) {
				for (int i4 = 3; i4 >= -1; --i4) {
					for (int k4 = l1; k4 <= i2; ++k4) {
						BlockPos blockpos1 = position.add(k3, i4, k4);

						if (k3 != k && i4 != -1 && k4 != l1 && k3 != l && i4 != 4 && k4 != i2) {
							if (world.getBlockState(blockpos1).getBlock() != Blocks.chest) {
								world.setBlockToAir(blockpos1);
							}
						} else if (blockpos1.getY() >= 0 && !world.getBlockState(blockpos1.down()).getBlock().getMaterial().isSolid()) {
							world.setBlockToAir(blockpos1);
						} else if (world.getBlockState(blockpos1).getBlock().getMaterial().isSolid() && world.getBlockState(blockpos1).getBlock() != Blocks.chest) {
							if (i4 == -1 && rand.nextInt(4) != 0) {
								world.setBlockState(blockpos1, ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(11), 2);
							} else {
								world.setBlockState(blockpos1, ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(12), 2);
							}
						}
					}
				}
			}

			for (int l3 = 0; l3 < 2; ++l3) {
				for (int j4 = 0; j4 < 3; ++j4) {
					int l4 = position.getX() + rand.nextInt(j * 2 + 1) - j;
					int i5 = position.getY();
					int j5 = position.getZ() + rand.nextInt(k1 * 2 + 1) - k1;
					BlockPos blockpos2 = new BlockPos(l4, i5, j5);

					if (world.isAirBlock(blockpos2)) {
						int j3 = 0;

						for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
							if (world.getBlockState(blockpos2.offset(enumfacing)).getBlock().getMaterial().isSolid()) {
								++j3;
							}
						}

						if (j3 == 1) {
							world.setBlockState(blockpos2, Blocks.chest.correctFacing(world, blockpos2, Blocks.chest.getDefaultState()), 2);
							TileEntity tileentity1 = world.getTileEntity(blockpos2);

							if (tileentity1 instanceof TileEntityChest) {
								WeightedRandomChestContent.generateChestContents(rand, net.minecraftforge.common.ChestGenHooks.getItems(net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST, rand), (TileEntityChest) tileentity1, 8);
							}

							break;
						}
					}
				}
			}

			world.setBlockState(position, Blocks.mob_spawner.getDefaultState(), 2);
			TileEntity tileentity = world.getTileEntity(position);

			if (tileentity instanceof TileEntityMobSpawner) {
				((TileEntityMobSpawner) tileentity).getSpawnerBaseLogic().setEntityName(this.pickMobSpawner(rand));
			} else {
				LOGGER.error("Failed to fetch mob spawner entity at ({}, {}, {})", new Object[] { Integer.valueOf(position.getX()), Integer.valueOf(position.getY()), Integer.valueOf(position.getZ()) });
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Randomly decides which spawner to use in a dungeon
	 */
	private String pickMobSpawner(Random rand) {
		return net.minecraftforge.common.DungeonHooks.getRandomDungeonMob(rand);
	}
}