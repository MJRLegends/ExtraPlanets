package com.mjr.extraplanets.jei.blocksmasher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

public class BlockSmasherRecipeMaker {
	public static List<BlockSmasherRecipeWrapper> getRecipesList() {
		List<BlockSmasherRecipeWrapper> recipes = new ArrayList<>();
		BlockSmasherRecipeWrapper wrapper;
		for (Entry<ItemStack, ItemStack> temp : ExtraPlanets_MachineRecipes.getBlockSmasherRecipes().entrySet()) {
			wrapper = new BlockSmasherRecipeWrapper(temp.getKey(), temp.getValue());
			recipes.add(wrapper);
		}

		return recipes;
	}
}
