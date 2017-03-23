package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
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

import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicGrass extends Block implements IGrowable {
	protected BlockBasicGrass() {
		super(Material.grass);
		this.setTickRandomly(true);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.blockHardness = 0.6F;
		this.setStepSound(soundTypeGrass);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getBlock().getLightOpacity(worldIn, pos.up()) > 2) {
				worldIn.setBlockState(pos, ExtraPlanets_Blocks.kepler22bBlocks.getDefaultState());
			} else {
				if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
						Block block = worldIn.getBlockState(blockpos.up()).getBlock();
						IBlockState iblockstate = worldIn.getBlockState(blockpos);

						if (iblockstate.getBlock() == ExtraPlanets_Blocks.kepler22bBlocks && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && block.getLightOpacity(worldIn, blockpos.up()) <= 2) {
							worldIn.setBlockState(blockpos, this.getDefaultState());
						}
					}
				}
			}
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ExtraPlanets_Blocks.kepler22bBlocks.getItemDropped(ExtraPlanets_Blocks.kepler22bBlocks.getDefaultState(), rand, fortune);
	}

	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		BlockPos blockpos = pos.up();

		for (int i = 0; i < 128; ++i) {
			BlockPos blockpos1 = blockpos;
			int j = 0;

			while (true) {
				if (j >= i / 16) {
					if (worldIn.isAirBlock(blockpos1)) {
						// if (rand.nextInt(8) == 0)
						// {
						// BlockFlower.EnumFlowerType blockflower$enumflowertype = worldIn.getBiomeGenForCoords(blockpos1).pickRandomFlower(rand, blockpos1);
						// BlockFlower blockflower = blockflower$enumflowertype.getBlockType().getBlock();
						// IBlockState iblockstate = blockflower.getDefaultState().withProperty(blockflower.getTypeProperty(), blockflower$enumflowertype);
						//
						// if (blockflower.canBlockStay(worldIn, blockpos1, iblockstate))
						// {
						// worldIn.setBlockState(blockpos1, iblockstate, 3);
						// }
						// }
						// else
						// {
						// IBlockState iblockstate1 = Blocks.tallgrass.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
						//
						// if (Blocks.tallgrass.canBlockStay(worldIn, blockpos1, iblockstate1))
						// {
						// worldIn.setBlockState(blockpos1, iblockstate1, 3);
						// }
						// }
					}

					break;
				}

				blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

				if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).getBlock().isNormalCube()) {
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
		return block == ExtraPlanets_Blocks.kepler22bMapleSapling || block == ExtraPlanets_Blocks.kepler22bGrassFlowers;
	}
}