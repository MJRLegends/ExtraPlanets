package com.mjr.extraplanets.jei.crystallizer;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class CrystallizerRecipeMaker {
	public static List<CrystallizerRecipeWrapper> getRecipesList() {
		List<CrystallizerRecipeWrapper> recipes = new ArrayList<>();
		ItemStack[] inputs = new ItemStack[2];
		inputs[0] = (new ItemStack(ExtraPlanets_Items.BUCKET_SALT));
		CrystallizerRecipeWrapper wrapper = new CrystallizerRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 6, 0));
		recipes.add(wrapper);
		return recipes;
	}
}
