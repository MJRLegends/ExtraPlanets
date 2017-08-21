package com.mjr.extraplanets.jei.blocksmasher;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class BlockSmasherRecipeMaker {
	public static List<BlockSmasherRecipeWrapper> getRecipesList() {
		List<BlockSmasherRecipeWrapper> recipes = new ArrayList<>();
		BlockSmasherRecipeWrapper wrapper = new BlockSmasherRecipeWrapper(new ItemStack(ExtraPlanets_Blocks.ORE_POTASH), new ItemStack(ExtraPlanets_Items.POTASH_SHARDS, 3, 0));
		recipes.add(wrapper);

		return recipes;
	}
}
