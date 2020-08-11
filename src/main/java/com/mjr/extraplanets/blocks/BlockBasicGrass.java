package com.mjr.extraplanets.blocks;

import java.util.Random;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bTallGrass;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasicGrass extends Block implements IGrowable {
	protected BlockBasicGrass() {
		super(Material.grass);
		this.setTickRandomly(true);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setSoundType(SoundType.PLANT);
		this.blockHardness = 0.6F;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote) {
			if (world.getLightFromNeighbors(pos.up()) < 4 && world.getBlockState(pos.up()).getBlock().getLightOpacity(world, pos.up()) > 2) {
				world.setBlockState(pos, ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState());
			} else {
				if (world.getLightFromNeighbors(pos.up()) >= 9) {
					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
						Block block = world.getBlockState(blockpos.up()).getBlock();
						IBlockState iblockstate = world.getBlockState(blockpos);

						if (iblockstate == ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState() && world.getLightFromNeighbors(blockpos.up()) >= 4 && block.getLightOpacity(world, blockpos.up()) <= 2) {
							world.setBlockState(blockpos, this.getDefaultState());
						}
					}
				}
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getItemDropped(ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), rand, fortune);
	}

	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		BlockPos blockpos = pos.up();

		for (int i = 0; i < 128; ++i) {
			BlockPos blockpos1 = blockpos;
			int j = 0;

			while (true) {
				if (j >= i / 16) {
					if (world.isAirBlock(blockpos1)) {
						if (rand.nextInt(8) == 0) {
							world.getBiomeGenForCoords(blockpos1).plantFlower(world, rand, blockpos1);
						} else {
							IBlockState iblockstate1;
							if (state.getBlock().equals(ExtraPlanets_Blocks.KEPLER22B_GRASS_BLUE)) {
								int type = rand.nextInt(3 + 1 - 1) + 0;
								iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS.getStateFromMeta(type);
								if (((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS).canBlockStay(world, blockpos1, iblockstate1)) {
									world.setBlockState(blockpos1, iblockstate1, 3);
								}
							} else if (state.getBlock().equals(ExtraPlanets_Blocks.KEPLER22B_GRASS_GREEN)) {
								int type = 11 + (rand.nextInt(3 + 1 - 1) + 1);
								iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS.getStateFromMeta(type);
								if (((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS).canBlockStay(world, blockpos1, iblockstate1)) {
									world.setBlockState(blockpos1, iblockstate1, 3);
								}
							} else if (state.getBlock().equals(ExtraPlanets_Blocks.KEPLER22B_GRASS_PURPLE)) {
								int type = 5 + (rand.nextInt(3 + 1 - 1) + 1);
								iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS.getStateFromMeta(type);
								if (((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS).canBlockStay(world, blockpos1, iblockstate1)) {
									world.setBlockState(blockpos1, iblockstate1, 3);
								}
							} else if (state.getBlock().equals(ExtraPlanets_Blocks.KEPLER22B_GRASS_RED)) {
								int type = 2 + (rand.nextInt(3 + 1 - 1) + 1);
								iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS.getStateFromMeta(type);
								if (((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS).canBlockStay(world, blockpos1, iblockstate1)) {
									world.setBlockState(blockpos1, iblockstate1, 3);
								}
							} else if (state.getBlock().equals(ExtraPlanets_Blocks.KEPLER22B_GRASS_YELLOW)) {
								int type = 8 + (rand.nextInt(3 + 1 - 1) + 1);
								iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS.getStateFromMeta(type);
								if (((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS).canBlockStay(world, blockpos1, iblockstate1)) {
									world.setBlockState(blockpos1, iblockstate1, 3);
								}
							}
						}
					}

					break;
				}

				blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

				if (world.getBlockState(blockpos1.down()).getBlock() != this || world.getBlockState(blockpos1).getBlock().isNormalCube()) {
					break;
				}

				++j;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT_MIPPED;
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing side, IPlantable plant) {
		Block block = plant.getPlant(world, pos).getBlock();
		return block == ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING || block == ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS;
	}
}