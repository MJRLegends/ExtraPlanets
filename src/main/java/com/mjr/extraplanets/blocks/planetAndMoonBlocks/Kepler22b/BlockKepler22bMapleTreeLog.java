package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;

public class BlockKepler22bMapleTreeLog extends BlockLog {
	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE(0, "maple_blue_log", MapColor.BLUE), MAPLE_RED(1, "maple_red_log", MapColor.RED), MAPLE_PURPLE(2, "maple_purple_log", MapColor.PURPLE), MAPLE_YELLOW(3, "maple_yellow_log", MapColor.YELLOW);

		private static final BlockKepler22bMapleTreeLog.EnumType[] META_LOOKUP = new BlockKepler22bMapleTreeLog.EnumType[values().length];
		private final int meta;
		private final String name;
		private final MapColor map_color;
		private final String unlocalizedName;

		private EnumType(int meta, String name, MapColor map_color) {
			this(meta, name, name, map_color);
		}

		private EnumType(int meta, String name, String unlocalizedName, MapColor map_color) {
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
			this.map_color = map_color;
		}

		public int getMetadata() {
			return this.meta;
		}

		public MapColor func_181070_c() {
			return this.map_color;
		}

		@Override
		public String toString() {
			return this.name;
		}

		public static BlockKepler22bMapleTreeLog.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}

		static {
			for (BlockKepler22bMapleTreeLog.EnumType blockplanks$enumtype : values()) {
				META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
			}
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
	}

	public static final PropertyEnum<BlockKepler22bMapleTreeLog.EnumType> VARIANT = PropertyEnum.<BlockKepler22bMapleTreeLog.EnumType> create("variant", BlockKepler22bMapleTreeLog.EnumType.class, new Predicate<BlockKepler22bMapleTreeLog.EnumType>() {
		public boolean apply(BlockKepler22bMapleTreeLog.EnumType type) {
			return type.getMetadata() < 4;
		}
	});

	public BlockKepler22bMapleTreeLog() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKepler22bMapleTreeLog.EnumType.MAPLE_BLUE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		list.add(new ItemStack(this, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_BLUE.getMetadata()));
		list.add(new ItemStack(this, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_RED.getMetadata()));
		list.add(new ItemStack(this, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_PURPLE.getMetadata()));
		list.add(new ItemStack(this, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_YELLOW.getMetadata()));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockKepler22bMapleTreeLog.EnumType.byMetadata((meta & 3) % 4));

		switch (meta & 12) {
		case 0:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
			break;
		case 8:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
			break;
		default:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}

		return iblockstate;
	}

	@Override
	@SuppressWarnings("incomplete-switch")
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(VARIANT).getMetadata();

		switch (state.getValue(LOG_AXIS)) {
		case X:
			i |= 4;
			break;
		case Z:
			i |= 8;
			break;
		case NONE:
			i |= 12;
		}

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, LOG_AXIS });
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}
}