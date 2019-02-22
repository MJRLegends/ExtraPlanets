package com.mjr.extraplanets.jei.solarEvaporationChamber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

import net.minecraft.item.ItemStack;

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
