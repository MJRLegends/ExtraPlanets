package com.mjr.extraplanets.planets.Kepler22b.worldgen.features;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.BlockPos.MutableBlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeSapling;

public class WorldGenKepler22bTree extends WorldGenAbstractTree {
	private int minTreeHeight;
	private int metaWood;
	private int metaLeaves;
	private static Random rand = new Random();

	private Block sapling;
	private Block log;
	private Block leaf;

	public WorldGenKepler22bTree(int par2, int par3, int par4, boolean par5, Block sapling, Block log, Block leaf) {
		super(false);
		this.minTreeHeight = par2;
		this.metaWood = par3;
		this.metaLeaves = par4;
		this.sapling = sapling;
		this.log = log;
		this.leaf = leaf;
	}

	public boolean generate(World par1World, Random par2Random, BlockPos position) {
		int l = par2Random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;

		if (position.getY() >= 1 && position.getY() + l + 1 <= 256) {
			byte b0;
			int k1;
			Block block;

			for (int i1 = position.getY(); i1 <= position.getY() + 1 + l; ++i1) {
				b0 = 1;

				if (i1 == position.getY()) {
					b0 = 0;
				}

				if (i1 >= position.getY() + 1 + l - 2) {
					b0 = 2;
				}

				for (int j1 = position.getX() - b0; j1 <= position.getX() + b0 && flag; ++j1) {
					for (k1 = position.getZ() - b0; k1 <= position.getZ() + b0 && flag; ++k1) {
						if (i1 >= 0 && i1 < 256) {
							if (!this.isReplaceable(par1World, new MutableBlockPos(j1, i1, k1))) {
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
				BlockPos down = position.down();
				Block block1 = par1World.getBlockState(down).getBlock();
				boolean isSoil = block1.canSustainPlant(par1World, down, EnumFacing.UP, (BlockKepler22bMapleTreeSapling) this.sapling);
				if (isSoil && position.getY() < 256 - l - 1) {
					block1.onPlantGrow(par1World, new BlockPos(position.getX(), position.getY() - 1, position.getZ()), new BlockPos(position.getX(), position.getY(), position.getZ()));
					b0 = 3;
					byte b1 = 0;
					int l1;
					int i2;
					int j2;
					int i3;

					for (k1 = position.getY() - b0 + l; k1 <= position.getY() + l; ++k1) {
						i3 = k1 - (position.getY() + l);
						l1 = b1 + 1 - i3 / 2;

						for (i2 = position.getX() - l1; i2 <= position.getX() + l1; ++i2) {
							j2 = i2 - position.getX();

							for (int k2 = position.getZ() - l1; k2 <= position.getZ() + l1; ++k2) {
								int l2 = k2 - position.getZ();

								if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || par2Random.nextInt(2) != 0 && i3 != 0) {
									BlockPos blockpos = new BlockPos(i2, k1, k2);
									Block block2 = par1World.getBlockState(blockpos).getBlock();

									if (block2.isAir(par1World, blockpos) || block1.isLeaves(par1World, blockpos)) {
										this.setBlockAndNotifyAdequately(par1World, blockpos, this.leaf.getStateFromMeta(this.metaLeaves));
									}
								}
							}
						}
					}

					for (k1 = 0; k1 < l; ++k1) {
						BlockPos blockpos2 = position.up(k1);
						Block block2 = par1World.getBlockState(blockpos2).getBlock();

						if (block2.isAir(par1World, blockpos2) || block2.isLeaves(par1World, blockpos2)) {
							this.setBlockAndNotifyAdequately(par1World, position.up(k1), this.log.getStateFromMeta(this.metaWood));
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
}