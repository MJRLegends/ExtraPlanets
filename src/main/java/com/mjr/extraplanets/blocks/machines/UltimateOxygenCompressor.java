package com.mjr.extraplanets.blocks.machines;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class UltimateOxygenCompressor extends BlockAdvancedTile implements IShiftDescription, ISortableBlock {
	public static final int OXYGEN_COMPRESSOR_METADATA = 0;
	public static final int OXYGEN_DECOMPRESSOR_METADATA = 4;

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<EnumCompressorType> TYPE = PropertyEnum.create("type", EnumCompressorType.class);

	public enum EnumCompressorType implements IStringSerializable {
		COMPRESSOR(0, "compressor"), DECOMPRESSOR(1, "decompressor");

		private final int meta;
		private final String name;

		EnumCompressorType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumCompressorType byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public UltimateOxygenCompressor(boolean isActive, String name) {
		super(Material.ROCK);
		this.setHardness(1.0F);
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entityPlayer, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		entityPlayer.openGui(ExtraPlanets.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		int metadata = getMetaFromState(state);
		if (metadata >= UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA) {
			return new TileEntityUltimateOxygenDecompressor();
		} else if (metadata >= UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA) {
			return new TileEntityUltimateOxygenCompressor();
		} else {
			return null;
		}
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack itemStack) {
		final int angle = MathHelper.floor(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		int change = EnumFacing.getHorizontal(angle).getOpposite().getHorizontalIndex();

		if (itemStack.getItemDamage() >= UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA) {
			change += UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA;
		} else if (itemStack.getItemDamage() >= UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA) {
			change += UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA;
		}

		world.setBlockState(pos, getStateFromMeta(change), 3);
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (!(this.getCreativeTabToDisplayOn() == tab))
			return;
		list.add(new ItemStack(this, 1, UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA));
		list.add(new ItemStack(this, 1, UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA));
	}

	@Override
	public int damageDropped(IBlockState state) {
		int metadata = getMetaFromState(state);
		if (metadata >= UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA) {
			return UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA;
		} else if (metadata >= UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA) {
			return UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA;
		} else {
			return 0;
		}
	}

	@Override
	public String getShiftDescription(int meta) {
		switch (meta) {
		case OXYGEN_COMPRESSOR_METADATA:
			return TranslateUtilities.translate("tile.oxygen_compressor.description");
		case OXYGEN_DECOMPRESSOR_METADATA:
			return TranslateUtilities.translate("tile.oxygen_decompressor.description");
		}
		return "";
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta % 4);
		EnumCompressorType type = EnumCompressorType.byMetadata((int) Math.floor(meta / 4.0));
		return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(TYPE, type);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex() + state.getValue(TYPE).getMeta() * 4;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING, TYPE);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.MACHINE;
	}
}
