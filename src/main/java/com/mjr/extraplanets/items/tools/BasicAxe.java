package com.mjr.extraplanets.items.tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;
import com.mjr.extraplanets.ExtraPlanets;

public class BasicAxe extends ItemTool{
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});

	protected BasicAxe(ToolMaterial p_i45347_1_, String name) {
		super(p_i45347_1_,EFFECTIVE_ON);
		this.setCreativeTab(ExtraPlanets.ToolsTab);
		this.setUnlocalizedName(name);
	}
}
