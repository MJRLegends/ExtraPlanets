package com.mjr.extraplanets.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWhiteSugerCane extends Block implements net.minecraftforge.common.IPlantable {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
	protected static final AxisAlignedBB REED_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);

	protected BlockWhiteSugerCane(String name) {
		super(Material.PLANTS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.setTickRandomly(true);
		this.setHardness(0.0F);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName(name);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return REED_AABB;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (world.getBlockState(pos.down()).getBlock() == ExtraPlanets_Blocks.WHITE_SUGAR_CANE || this.checkForDrop(world, pos, state)) {
			if (world.isAirBlock(pos.up())) {
				int i;

				for (i = 1; world.getBlockState(pos.down(i)).getBlock() == this; ++i) {
					;
				}

				if (i < 3) {
					int j = state.getValue(AGE).intValue();

					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
						if (j == 15) {
							world.setBlockState(pos.up(), this.getDefaultState());
							world.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 4);
						} else {
							world.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
						}
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
					}
				}
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos.down());
		Block block = state.getBlock();
		if (block.canSustainPlant(state, world, pos.down(), EnumFacing.UP, this))
			return true;

		if (block == this) {
			return true;
		} else if (state != ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.CAKE_BLOCK)) {
			return false;
		} else {
			BlockPos blockpos = pos.down();

			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
				IBlockState iblockstate = world.getBlockState(blockpos.offset(enumfacing));

				if (iblockstate.getMaterial() == ExtraPlanets_Fluids.CHOCOLATE_MATERIAL) {
					return true;
				}
			}

			return false;
		}
	}

	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
		this.checkForDrop(world, pos, state);
	}

	protected final boolean checkForDrop(World world, BlockPos pos, IBlockState state) {
		if (this.canBlockStay(world, pos)) {
			return true;
		} else {
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
			return false;
		}
	}

	public boolean canBlockStay(World world, BlockPos pos) {
		return this.canPlaceBlockAt(world, pos);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World world, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
		return new ItemStack(ExtraPlanets_Items.WHITE_SUGAR_CANE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AGE).intValue();
	}

	@Override
	public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return net.minecraftforge.common.EnumPlantType.Beach;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.getDefaultState();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE });
	}
}