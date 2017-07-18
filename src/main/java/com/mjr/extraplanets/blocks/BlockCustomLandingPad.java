package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tile.blocks.TileEntityPoweredChargingPadSingle;
import com.mjr.extraplanets.tile.blocks.TileEntityRocketChargingPadSingle;
import com.mjr.extraplanets.tile.blocks.TileEntityTier2LandingPadSingle;
import com.mjr.extraplanets.tile.blocks.TileEntityTier3LandingPadSingle;

public class BlockCustomLandingPad extends BlockAdvancedTile implements IPartialSealableBlock, IShiftDescription, ISortableBlock {
	public static final PropertyEnum PAD_TYPE = PropertyEnum.create("type", EnumLandingPadType.class);
	protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0);

	public enum EnumLandingPadType implements IStringSerializable {
		TIER_2_ROCKET_PAD(0, "tier_2_rocket"), TIER_3_ROCKET_PAD(1, "tier_3_rocket"), POWER_CHARGING_PAD(2, "powered_charging_pad"), ROCKET_POWER_CHARGING_PAD(3, "rocket_powered_charging_pad");

		private final int meta;
		private final String name;

		EnumLandingPadType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumLandingPadType byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public BlockCustomLandingPad(String assetName) {
		super(Material.IRON);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs tab, NonNullList<ItemStack> par3List) {
		for (int i = 0; i < 4; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	private boolean checkAxis(World worldIn, BlockPos pos, Block block, EnumFacing facing) {
		int sameCount = 0;
		for (int i = 1; i <= 5; i++) {
			if (worldIn.getBlockState(pos.offset(facing, i)).getBlock() == block) {
				sameCount++;
			}
		}

		return sameCount < 5;
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
		final Block id = ExtraPlanets_Blocks.ADVANCED_LAUCHPAD;

		if (!checkAxis(worldIn, pos, id, EnumFacing.EAST) || !checkAxis(worldIn, pos, id, EnumFacing.WEST) || !checkAxis(worldIn, pos, id, EnumFacing.NORTH) || !checkAxis(worldIn, pos, id, EnumFacing.SOUTH)) {
			return false;
		}

		if (worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == GCBlocks.landingPad && side == EnumFacing.UP) {
			return false;
		} else {
			return this.canPlaceBlockAt(worldIn, pos);
		}
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
	public TileEntity createNewTileEntity(World world, int meta) {
		switch (meta) {
		case 0:
			return new TileEntityTier2LandingPadSingle();
		case 1:
			return new TileEntityTier3LandingPadSingle();
		case 2:
			return new TileEntityPoweredChargingPadSingle();
		case 3:
			return new TileEntityRocketChargingPadSingle();
		default:
			return null;
		}
	}

	@Override
	public boolean isSealed(World worldIn, BlockPos pos, EnumFacing direction) {
		return direction == EnumFacing.UP;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public String getShiftDescription(int meta) {
		if (meta == 0)
			return GCCoreUtil.translate(this.getUnlocalizedName() + ".tier2.desc");
		else if (meta == 1)
			return GCCoreUtil.translate(this.getUnlocalizedName() + ".tier3.desc");
		else if (meta == 2)
			return GCCoreUtil.translate(this.getUnlocalizedName() + ".powered.desc");
		else
			return "";
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(PAD_TYPE, EnumLandingPadType.byMetadata(meta));
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumLandingPadType) state.getValue(PAD_TYPE)).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, PAD_TYPE);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.PAD;
	}
}