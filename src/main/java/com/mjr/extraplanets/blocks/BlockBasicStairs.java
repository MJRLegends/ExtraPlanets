package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicStairs extends BlockStairs implements ISortableBlock {
	public BlockBasicStairs(String name, IBlockState state) {
		super(state);
		this.setUnlocalizedName(name);
		this.useNeighborBrightness = true;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.STAIRS;
	}
}