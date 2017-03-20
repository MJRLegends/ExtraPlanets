package com.mjr.extraplanets.blocks.machines;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseUniversalElectrical;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tile.machines.TileEntityBasicDecrystallizer;

public class BasicDecrystallizer extends BlockAdvancedTile implements IShiftDescription, ISortableBlock {
	private final Random crystallizerRand = new Random();

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BasicDecrystallizer(String assetName) {
		super(Material.ROCK);
		this.setHardness(1.0F);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		final TileEntity te = worldIn.getTileEntity(pos);

		if (te instanceof TileEntityBasicDecrystallizer) {
			final TileEntityBasicDecrystallizer crystallizer = (TileEntityBasicDecrystallizer) te;

			if (crystallizer.processTicks > 0) {
				final float var7 = pos.getX() + 0.5F;
				final float var8 = pos.getY() + 1.1F;
				final float var9 = pos.getZ() + 0.5F;
				final float var10 = 0.0F;
				final float var11 = 0.0F;

				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7 + var11 + i * 0.2, var8, var9 + var10 + j * 0.2, 0.0D, 0.01D, 0.0D);
						worldIn.spawnParticle(EnumParticleTypes.FLAME, var7 + var11 + i * 0.1, var8 - 0.2, var9 + var10 + j * 0.1, 0.0D, 0.0001D, 0.0D);
					}
				}
			}
		}
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entityPlayer, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		entityPlayer.openGui(ExtraPlanets.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public boolean onUseWrench(World world, BlockPos pos, EntityPlayer entityPlayer, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		int metadata = getMetaFromState(world.getBlockState(pos));
		int change = world.getBlockState(pos).getValue(FACING).rotateY().getHorizontalIndex();

		world.setBlockState(pos, this.getStateFromMeta(metadata - (metadata % 4) + change), 3);

		TileEntity te = world.getTileEntity(pos);
		if (te instanceof TileBaseUniversalElectrical) {
			((TileBaseUniversalElectrical) te).updateFacing();
		}

		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityBasicDecrystallizer();
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		final TileEntityBasicDecrystallizer var7 = (TileEntityBasicDecrystallizer) worldIn.getTileEntity(pos);

		if (var7 != null) {
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {
				final ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null) {
					final float var10 = this.crystallizerRand.nextFloat() * 0.8F + 0.1F;
					final float var11 = this.crystallizerRand.nextFloat() * 0.8F + 0.1F;
					final float var12 = this.crystallizerRand.nextFloat() * 0.8F + 0.1F;

					while (var9.stackSize > 0) {
						int var13 = this.crystallizerRand.nextInt(21) + 10;

						if (var13 > var9.stackSize) {
							var13 = var9.stackSize;
						}

						var9.stackSize -= var13;
						final EntityItem var14 = new EntityItem(worldIn, pos.getX() + var10, pos.getY() + var11, pos.getZ() + var12, new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

						if (var9.hasTagCompound()) {
							var14.getEntityItem().setTagCompound(var9.getTagCompound().copy());
						}

						final float var15 = 0.05F;
						var14.motionX = (float) this.crystallizerRand.nextGaussian() * var15;
						var14.motionY = (float) this.crystallizerRand.nextGaussian() * var15 + 0.2F;
						var14.motionZ = (float) this.crystallizerRand.nextGaussian() * var15;
						worldIn.spawnEntityInWorld(var14);
					}
				}
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		final int angle = MathHelper.floor_double(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		worldIn.setBlockState(pos, getStateFromMeta(EnumFacing.getHorizontal(angle).getOpposite().getHorizontalIndex()), 3);
	}

	@Override
	public String getShiftDescription(int meta) {
		return GCCoreUtil.translate(this.getUnlocalizedName() + ".description");
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.MACHINE;
	}
}
