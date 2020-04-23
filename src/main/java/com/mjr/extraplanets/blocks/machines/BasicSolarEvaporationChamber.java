package com.mjr.extraplanets.blocks.machines;

import java.util.Random;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicSolarEvaporationChamber;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BasicSolarEvaporationChamber extends BlockAdvancedTile implements IShiftDescription, ISortableBlock {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BasicSolarEvaporationChamber(String name) {
		super(Material.ROCK);
		this.setHardness(1.0F);
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		final TileEntity te = world.getTileEntity(pos);

		if (te instanceof TileEntityBasicSolarEvaporationChamber) {
			final TileEntityBasicSolarEvaporationChamber crystallizer = (TileEntityBasicSolarEvaporationChamber) te;

			if (crystallizer.processTicks > 0) {
				final float var7 = pos.getX() + 0.5F;
				final float var8 = pos.getY() + 1.1F;
				final float var9 = pos.getZ() + 0.5F;
				final float var10 = 0.0F;
				final float var11 = 0.0F;

				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7 + var11 + i * 0.2, var8, var9 + var10 + j * 0.2, 0.0D, 0.01D, 0.0D);
						world.spawnParticle(EnumParticleTypes.FLAME, var7 + var11 + i * 0.1, var8 - 0.2, var9 + var10 + j * 0.1, 0.0D, 0.0001D, 0.0D);
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
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityBasicSolarEvaporationChamber();
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack itemStack) {
		final int angle = MathHelper.floor(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		world.setBlockState(pos, state.withProperty(FACING, EnumFacing.getHorizontal(angle).getOpposite()), 3);
	}

	@Override
	public String getShiftDescription(int meta) {
		return TranslateUtilities.translate(this.getUnlocalizedName() + ".description");
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
