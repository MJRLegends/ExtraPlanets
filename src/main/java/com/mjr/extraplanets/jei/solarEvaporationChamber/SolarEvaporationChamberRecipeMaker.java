package com.mjr.extraplanets.jei.solarEvaporationChamber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

public class SolarEvaporationChamberRecipeMaker {
	public static List<SolarEvaporationChamberRecipeWrapper> getRecipesList() {
		List<SolarEvaporationChamberRecipeWrapper> recipes = new ArrayList<>();
		SolarEvaporationChamberRecipeWrapper wrapper;
		for (Entry<ItemStack, ItemStack> temp : ExtraPlanets_MachineRecipes.getSolarEvaporationChamberRecipes().entrySet()) {
			wrapper = new SolarEvaporationChamberRecipeWrapper(temp.getKey(), temp.getValue());
			recipes.add(wrapper);
		}

		return recipes;
	}
}
