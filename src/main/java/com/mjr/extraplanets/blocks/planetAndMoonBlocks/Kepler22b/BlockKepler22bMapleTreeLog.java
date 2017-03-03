package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;

public class BlockKepler22bMapleTreeLog extends BlockLog {
	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE(0, "maple_blue_log", MapColor.blueColor), 
		MAPLE_RED(1, "maple_red_log", MapColor.redColor), 
		MAPLE_PURPLE(2, "maple_purple_log", MapColor.purpleColor), 
		MAPLE_YELLOW(3, "maple_yellow_log", MapColor.yellowColor);

		private static final BlockKepler22bMapleTreeLog.EnumType[] META_LOOKUP = new BlockKepler22bMapleTreeLog.EnumType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;
		private final MapColor field_181071_k;

		private EnumType(int p_i46388_3_, String p_i46388_4_, MapColor p_i46388_5_) {
			this(p_i46388_3_, p_i46388_4_, p_i46388_4_, p_i46388_5_);
		}

		private EnumType(int p_i46389_3_, String p_i46389_4_, String p_i46389_5_, MapColor p_i46389_6_) {
			this.meta = p_i46389_3_;
			this.name = p_i46389_4_;
			this.unlocalizedName = p_i46389_5_;
			this.field_181071_k = p_i46389_6_;
		}

		public int getMetadata() {
			return this.meta;
		}

		public MapColor func_181070_c() {
			return this.field_181071_k;
		}

		public String toString() {
			return this.name;
		}

		public static BlockKepler22bMapleTreeLog.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		static {
			for (BlockKepler22bMapleTreeLog.EnumType blockplanks$enumtype : values()) {
				META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
			}
		}
	}

	public static final PropertyEnum<BlockKepler22bMapleTreeLog.EnumType> VARIANT = PropertyEnum.<BlockKepler22bMapleTreeLog.EnumType> create("variant", BlockKepler22bMapleTreeLog.EnumType.class, new Predicate() {
		public boolean apply(BlockKepler22bMapleTreeLog.EnumType type) {
			return type.getMetadata() < 4;
		}

		public boolean apply(Object p_apply_1_) {
			return this.apply((BlockKepler22bMapleTreeLog.EnumType) p_apply_1_);
		}
	});

	public BlockKepler22bMapleTreeLog() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKepler22bMapleTreeLog.EnumType.MAPLE_BLUE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}

	/**
	 * Get the MapColor for this Block and the given BlockState
	 */
	public MapColor getMapColor(IBlockState state) {
		BlockKepler22bMapleTreeLog.EnumType blockplanks$enumtype = (BlockKepler22bMapleTreeLog.EnumType) state.getValue(VARIANT);

		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
		case X:
		case Z:
		case NONE:
		default:

			switch (blockplanks$enumtype) {
			default:
				return BlockKepler22bMapleTreeLog.EnumType.MAPLE_BLUE.func_181070_c();
			}

		case Y:
			return blockplanks$enumtype.func_181070_c();
		}
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_BLUE.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_RED.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_PURPLE.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLog.EnumType.MAPLE_YELLOW.getMetadata()));
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
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

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@SuppressWarnings("incomplete-switch")
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((BlockKepler22bMapleTreeLog.EnumType) state.getValue(VARIANT)).getMetadata();

		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
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

	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { VARIANT, LOG_AXIS });
	}

	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockKepler22bMapleTreeLog.EnumType) state.getValue(VARIANT)).getMetadata());
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It returns the metadata of the dropped item based on the old metadata of the block.
	 */
	public int damageDropped(IBlockState state) {
		return ((BlockKepler22bMapleTreeLog.EnumType) state.getValue(VARIANT)).getMetadata();
	}
}