package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
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

import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicKepler22bPlanks extends Block {
	public static final PropertyEnum<BlockBasicKepler22bPlanks.EnumType> VARIANT = PropertyEnum.<BlockBasicKepler22bPlanks.EnumType> create("variant", BlockBasicKepler22bPlanks.EnumType.class);

	public BlockBasicKepler22bPlanks() {
		super(Material.WOOD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockBasicKepler22bPlanks.EnumType.MAPLE_BLUE));
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (BlockBasicKepler22bPlanks.EnumType blockplanks$enumtype : BlockBasicKepler22bPlanks.EnumType.values()) {
			list.add(new ItemStack(this, 1, blockplanks$enumtype.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, BlockBasicKepler22bPlanks.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE(0, "maple_blue_plank", MapColor.BLUE), MAPLE_RED(1, "maple_red_plank", MapColor.RED), MAPLE_PURPLE(2, "maple_purple_plank", MapColor.PURPLE), MAPLE_YELLOW(3, "maple_yellow_plank", MapColor.YELLOW), MAPLE_GREEN(4,
				"maple_green_plank", MapColor.GREEN), MAPLE_BROWN(5, "maple_brown_plank", MapColor.BROWN);

		private static final BlockBasicKepler22bPlanks.EnumType[] META_LOOKUP = new BlockBasicKepler22bPlanks.EnumType[values().length];
		private final int meta;
		private final String name;
		private final MapColor map_color;

		private EnumType(int meta, String name, MapColor map_color) {
			this.meta = meta;
			this.name = name;
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

		public static BlockBasicKepler22bPlanks.EnumType byMetadata(int meta) {
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
			for (BlockBasicKepler22bPlanks.EnumType blockplanks$enumtype : values()) {
				META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
			}
		}
	}
}