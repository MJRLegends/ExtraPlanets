package com.mjr.extraplanets.blocks;

import java.util.Random;

import com.mjr.extraplanets.ExtraPlanets;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDecorativeBlocks2 extends Block implements IDetectableResource, ISortableBlock {
	public static final PropertyEnum<EnumBlockBasic> BASIC_TYPE = PropertyEnum.create("basictypedecorativeblocks", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		WHITE_BLOCK(0, "white_block"), RED_BLOCK(1, "red_block"), BLUE_BLOCK(2, "blue_block"), LIGHT_BLUE_BLOCK(3, "light_blue_block"), YELLOW_BLOCK(4, "yellow_block"), GREEN_BLOCK(5, "green_block");

		private final int meta;
		private final String name;

		private EnumBlockBasic(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumBlockBasic byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public BlockDecorativeBlocks2(String name) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World world, BlockPos pos) {
		return 1.5F;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = state.getBlock().getMetaFromState(state);
		return meta;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (EnumBlockBasic blockBasic : EnumBlockBasic.values()) {
			list.add(new ItemStack(this, 1, blockBasic.getMeta()));
		}
	}

	@Override
	public boolean isValueable(IBlockState state) {
		return false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BASIC_TYPE, EnumBlockBasic.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BASIC_TYPE).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, BASIC_TYPE);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.DECORATION;
	}
}
