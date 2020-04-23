package com.mjr.extraplanets.blocks.machines;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tileEntities.machines.TileEntitySolar;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.blocks.BlockTileGC;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;

import net.minecraft.block.Block;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSolar extends BlockTileGC implements IShiftDescription, IPartialSealableBlock, ISortableBlock {
	public static final int HYBRID_METADATA = 0;
	public static final int ULTIMATE_METADATA = 4;

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<EnumSolarType> TYPE = PropertyEnum.create("type", EnumSolarType.class);

	public enum EnumSolarType implements IStringSerializable {
		HYBRID_SOLAR(0, "hybrid_solar"), ULTIMATE_SOLAR(1, "ultimate_solar"); // 3 for backwards compatibility

		private final int meta;
		private final String name;

		EnumSolarType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumSolarType byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public BlockSolar(String name) {
		super(Material.IRON);
		this.setHardness(1.0F);
		this.setUnlocalizedName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> par3List) {
		par3List.add(new ItemStack(this, 1, BlockSolar.HYBRID_METADATA));
		par3List.add(new ItemStack(this, 1, BlockSolar.ULTIMATE_METADATA));
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side) {
		for (int y = 1; y <= 2; y++) {
			for (int x = -1; x <= 1; x++) {
				for (int z = -1; z <= 1; z++) {
					BlockPos posAt = pos.add(y == 2 ? x : 0, y, y == 2 ? z : 0);
					IBlockState bs = world.getBlockState(posAt); 

                    if (bs.getMaterial() != Material.AIR && !bs.getBlock().isReplaceable(world, pos)){
						return false;
					}
				}
			}
		}

		for (int x = -2; x <= 2; x++) {
			for (int z = -2; z <= 2; z++) {
				BlockPos posAt = pos.add(x, 0, z);
				Block block = world.getBlockState(posAt).getBlock();

				if (block == this) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack itemStack) {
		final int angle = MathHelper.floor(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		int change = EnumFacing.getHorizontal(angle).getOpposite().getHorizontalIndex();

		if (itemStack.getItemDamage() >= ULTIMATE_METADATA) {
			change += ULTIMATE_METADATA;
		} else if (itemStack.getItemDamage() >= HYBRID_METADATA) {
			change += HYBRID_METADATA;
		}

		world.setBlockState(pos, getStateFromMeta(change), 3);

		TileEntity tile = world.getTileEntity(pos);

		if (tile instanceof TileEntitySolar) {
			((TileEntitySolar) tile).onCreate(world, pos);
		}
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		final TileEntity var9 = world.getTileEntity(pos);

		if (var9 instanceof TileEntitySolar) {
			((TileEntitySolar) var9).onDestroy(var9);
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		playerIn.openGui(ExtraPlanets.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (getMetaFromState(state) >= BlockSolar.ULTIMATE_METADATA) {
			return BlockSolar.ULTIMATE_METADATA;
		} else {
			return BlockSolar.HYBRID_METADATA;
		}
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		if (getMetaFromState(state) >= BlockSolar.ULTIMATE_METADATA) {
			return new TileEntitySolar(2);
		} else {
			return new TileEntitySolar(1);
		}
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public String getShiftDescription(int meta) {
		switch (meta) {
		case HYBRID_METADATA:
			return TranslateUtilities.translate("tile.solar_hybrid.description");
		case ULTIMATE_METADATA:
			return TranslateUtilities.translate("tile.solar_ultimate.description");
		}
		return "";
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isSealed(World world, BlockPos pos, EnumFacing direction) {
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta % 4);
		EnumSolarType type = EnumSolarType.byMetadata((int) Math.floor(meta / 4.0));
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
