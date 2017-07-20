package com.mjr.extraplanets.jei.rockets.tier10Electric;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.recipes.Tier10ElectricRocketRecipes;

public class Tier10ElectricRocketRecipeMaker {
	public static List<Tier10ElectricRocketRecipeWrapper> getRecipesList() {
		List<Tier10ElectricRocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier10ElectricRocketRecipes.getTier10ElectricRocketRecipes()) {
			Tier10ElectricRocketRecipeWrapper wrapper = new Tier10ElectricRocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}