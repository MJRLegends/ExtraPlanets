package com.mjr.extraplanets.jei.rockets.tier7;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.recipes.Tier7RocketRecipes;

public class Tier7RocketRecipeMaker {
	public static List<Tier7RocketRecipeWrapper> getRecipesList() {
		List<Tier7RocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier7RocketRecipes.getTier7RocketRecipes()) {
			Tier7RocketRecipeWrapper wrapper = new Tier7RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}