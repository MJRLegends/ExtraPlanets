package com.mjr.extraplanets.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class BlockWhiteSugerCane extends Block implements net.minecraftforge.common.IPlantable {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);

	protected BlockWhiteSugerCane(String name) {
		super(Material.plants);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        float f = 0.375F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
		this.setTickRandomly(true);
		this.setHardness(0.0F);
		this.setUnlocalizedName(name);
	}


	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.reeds || this.checkForDrop(worldIn, pos, state))
        {
            if (worldIn.isAirBlock(pos.up()))
            {
                int i;

                for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i)
                {
                    ;
                }

                if (i < 3)
                {
                    int j = state.getValue(AGE).intValue();

                    if (j == 15)
                    {
                        worldIn.setBlockState(pos.up(), this.getDefaultState());
                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 4);
                    }
                    else
                    {
                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
                    }
                }
            }
        }
    }

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos.down());
		Block block = state.getBlock();
        if (block.canSustainPlant(worldIn, pos.down(), EnumFacing.UP, this)) return true;

		if (block == this) {
			return true;
		} else if (state != ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.CAKE_BLOCK)) {
			return false;
		} else {
			BlockPos blockpos = pos.down();

			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos.offset(enumfacing));

				if (iblockstate.getBlock().getMaterial() == ExtraPlanets_Fluids.CHOCOLATE_MATERIAL) {
					return true;
				}
			}

			return false;
		}
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid block, etc.
	 */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		this.checkForDrop(worldIn, pos, state);
	}

	protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
		if (this.canBlockStay(worldIn, pos)) {
			return true;
		} else {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
			return false;
		}
	}

	public boolean canBlockStay(World worldIn, BlockPos pos) {
		return this.canPlaceBlockAt(worldIn, pos);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return null;
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ExtraPlanets_Items.WHITE_SUGAR_CANE);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	@Override
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

	/**
	 * Convert the BlockState into the correct metadata value
	 */
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
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {AGE});
    }
}