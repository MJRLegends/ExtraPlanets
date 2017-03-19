package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;

public class BlockKepler22bMapleTreeLog2 extends BlockLog {
	public static enum EnumType implements IStringSerializable {
		MAPLE_GREEN(0, "maple_green_log", MapColor.GREEN), 
		MAPLE_BROWN(1, "maple_brown_log", MapColor.RED);

		private static final BlockKepler22bMapleTreeLog2.EnumType[] META_LOOKUP = new BlockKepler22bMapleTreeLog2.EnumType[values().length];
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

		public static BlockKepler22bMapleTreeLog2.EnumType byMetadata(int meta) {
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
			for (BlockKepler22bMapleTreeLog2.EnumType blockplanks$enumtype : values()) {
				META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
			}
		}
	}

	public static final PropertyEnum<BlockKepler22bMapleTreeLog2.EnumType> VARIANT = PropertyEnum.<BlockKepler22bMapleTreeLog2.EnumType> create("variant", BlockKepler22bMapleTreeLog2.EnumType.class, new Predicate() {
		public boolean apply(BlockKepler22bMapleTreeLog2.EnumType type) {
			return type.getMetadata() < 4;
		}

		public boolean apply(Object p_apply_1_) {
			return this.apply((BlockKepler22bMapleTreeLog2.EnumType) p_apply_1_);
		}
	});

	public BlockKepler22bMapleTreeLog2() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKepler22bMapleTreeLog2.EnumType.MAPLE_GREEN).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}

	/**
	 * Get the MapColor for this Block and the given BlockState
	 */
	public MapColor getMapColor(IBlockState state) {
		BlockKepler22bMapleTreeLog2.EnumType blockplanks$enumtype = (BlockKepler22bMapleTreeLog2.EnumType) state.getValue(VARIANT);

		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
		case X:
		case Z:
		case NONE:
		default:

			switch (blockplanks$enumtype) {
			default:
				return BlockKepler22bMapleTreeLog2.EnumType.MAPLE_GREEN.func_181070_c();
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
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLog2.EnumType.MAPLE_GREEN.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLog2.EnumType.MAPLE_BROWN.getMetadata()));
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockKepler22bMapleTreeLog2.EnumType.byMetadata((meta & 3) % 4));

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
		i = i | ((BlockKepler22bMapleTreeLog2.EnumType) state.getValue(VARIANT)).getMetadata();

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

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, LOG_AXIS });
	}

	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockKepler22bMapleTreeLog2.EnumType) state.getValue(VARIANT)).getMetadata());
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It returns the metadata of the dropped item based on the old metadata of the block.
	 */
	public int damageDropped(IBlockState state) {
		return ((BlockKepler22bMapleTreeLog2.EnumType) state.getValue(VARIANT)).getMetadata();
	}
}