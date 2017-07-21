package com.mjr.extraplanets.jei.chemicalInjector;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ChemicalInjectorRecipeMaker {
	public static List<ChemicalInjectorRecipeWrapper> getRecipesList() {
		List<ChemicalInjectorRecipeWrapper> recipes = new ArrayList<>();
		List<ItemStack> inputs = new ArrayList<>();
		inputs.add(new ItemStack(ExtraPlanets_Items.IODIDE_SALT));
		inputs.add(new ItemStack(ExtraPlanets_Items.POTASSIUM));
		ChemicalInjectorRecipeWrapper wrapper = new ChemicalInjectorRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE, 1, 0));
		recipes.add(wrapper);

		return recipes;
	}
}
