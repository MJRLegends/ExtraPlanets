package com.mjr.extraplanets.planets.Kepler22b.worldgen.features;

import java.util.Random;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeSapling;

import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenKepler22bTree extends WorldGenAbstractTree {
	private final int minTreeHeight;
	private final boolean vinesGrow;
	private final IBlockState log;
	private final IBlockState leaves;

	public WorldGenKepler22bTree(boolean doBlockNotify, int minTreeHeight, IBlockState log, IBlockState leaves, boolean vinesGrow) {
		super(doBlockNotify);
		this.minTreeHeight = minTreeHeight;
		this.log = log;
		this.leaves = leaves;
		this.vinesGrow = vinesGrow;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int i = rand.nextInt(3) + this.minTreeHeight;
		boolean flag = true;

		if (position.getY() >= 1 && position.getY() + i + 1 <= 256) {
			for (int j = position.getY(); j <= position.getY() + i; ++j) {
				int k = 1;

				if (j == position.getY()) {
					k = 0;
				}

				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}

				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

				for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < world.getHeight()) {
							if (!this.isReplaceable(world, blockpos$mutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}

			if (!flag) {
				return false;
			} else {
				IBlockState state = world.getBlockState(position.down());

				if ((state.getBlock().canSustainPlant(state, world, position.down(), net.minecraft.util.EnumFacing.UP, (BlockKepler22bMapleTreeSapling) ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING)
						|| state.equals(ExtraPlanets_Blocks.DIAMOND_GRIT.getDefaultState()) || state.equals(ExtraPlanets_Blocks.GOLD_GRIT.getDefaultState()) || state.equals(ExtraPlanets_Blocks.COAL_GRIT.getDefaultState())
						|| state.equals(ExtraPlanets_Blocks.IRON_GRIT.getDefaultState()) || state.equals(ExtraPlanets_Blocks.EMERALD_GRIT.getDefaultState())) && position.getY() < world.getHeight() - i - 1) {
					this.setDirtAt(world, position.down());

					for (int i3 = position.getY() - 3 + i; i3 <= position.getY() + i; ++i3) {
						int i4 = i3 - (position.getY() + i);
						int j1 = 1 - i4 / 2;

						for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
							int l1 = k1 - position.getX();

							for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
								int j2 = i2 - position.getZ();

								if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
									BlockPos blockpos = new BlockPos(k1, i3, i2);
									state = world.getBlockState(blockpos);

									if (state.getBlock().isAir(state, world, blockpos) || state.getBlock().isLeaves(state, world, blockpos) || state.getMaterial() == Material.VINE) {
										this.setBlockAndNotifyAdequately(world, blockpos, this.leaves);
									}
								}
							}
						}
					}

					for (int j3 = 0; j3 < i; ++j3) {
						BlockPos upN = position.up(j3);
						state = world.getBlockState(upN);

						if (state.getBlock().isAir(state, world, upN) || state.getBlock().isLeaves(state, world, upN) || state.getMaterial() == Material.VINE) {
							this.setBlockAndNotifyAdequately(world, position.up(j3), this.log);

							if (this.vinesGrow && j3 > 0) {
								if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(-1, j3, 0))) {
									this.addVine(world, position.add(-1, j3, 0), BlockVine.EAST);
								}

								if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(1, j3, 0))) {
									this.addVine(world, position.add(1, j3, 0), BlockVine.WEST);
								}

								if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(0, j3, -1))) {
									this.addVine(world, position.add(0, j3, -1), BlockVine.SOUTH);
								}

								if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(0, j3, 1))) {
									this.addVine(world, position.add(0, j3, 1), BlockVine.NORTH);
								}
							}
						}
					}

					if (this.vinesGrow) {
						for (int k3 = position.getY() - 3 + i; k3 <= position.getY() + i; ++k3) {
							int j4 = k3 - (position.getY() + i);
							int k4 = 2 - j4 / 2;
							BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

							for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4) {
								for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5) {
									blockpos$mutableblockpos1.setPos(l4, k3, i5);

									state = world.getBlockState(blockpos$mutableblockpos1);
									if (state.getBlock().isLeaves(state, world, blockpos$mutableblockpos1)) {
										BlockPos blockpos2 = blockpos$mutableblockpos1.west();
										BlockPos blockpos3 = blockpos$mutableblockpos1.east();
										BlockPos blockpos4 = blockpos$mutableblockpos1.north();
										BlockPos blockpos1 = blockpos$mutableblockpos1.south();

										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos2)) {
											this.addHangingVine(world, blockpos2, BlockVine.EAST);
										}

										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos3)) {
											this.addHangingVine(world, blockpos3, BlockVine.WEST);
										}

										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos4)) {
											this.addHangingVine(world, blockpos4, BlockVine.SOUTH);
										}

										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos1)) {
											this.addHangingVine(world, blockpos1, BlockVine.NORTH);
										}
									}
								}
							}
						}

						if (rand.nextInt(5) == 0 && i > 5) {
							for (int l3 = 0; l3 < 2; ++l3) {
								for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
									if (rand.nextInt(4 - l3) == 0) {
										EnumFacing enumfacing1 = enumfacing.getOpposite();
										this.placeCocoa(world, rand.nextInt(3), position.add(enumfacing1.getFrontOffsetX(), i - 5 + l3, enumfacing1.getFrontOffsetZ()), enumfacing);
									}
								}
							}
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private void placeCocoa(World world, int p_181652_2_, BlockPos pos, EnumFacing side) {
		this.setBlockAndNotifyAdequately(world, pos, Blocks.COCOA.getDefaultState().withProperty(BlockCocoa.AGE, Integer.valueOf(p_181652_2_)).withProperty(BlockHorizontal.FACING, side));
	}

	private void addVine(World world, BlockPos pos, PropertyBool prop) {
		this.setBlockAndNotifyAdequately(world, pos, Blocks.VINE.getDefaultState().withProperty(prop, Boolean.valueOf(true)));
	}

	private void addHangingVine(World world, BlockPos pos, PropertyBool prop) {
		this.addVine(world, pos, prop);
		int i = 4;

		for (BlockPos blockpos = pos.down(); world.isAirBlock(blockpos) && i > 0; --i) {
			this.addVine(world, blockpos, prop);
			blockpos = blockpos.down();
		}
	}
}