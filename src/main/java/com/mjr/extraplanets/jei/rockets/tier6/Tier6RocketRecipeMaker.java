package com.mjr.extraplanets.jei.rockets.tier6;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.recipes.Tier6RocketRecipes;

public class Tier6RocketRecipeMaker {
	public static List<Tier6RocketRecipeWrapper> getRecipesList() {
		List<Tier6RocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier6RocketRecipes.getTier6RocketRecipes()) {
			Tier6RocketRecipeWrapper wrapper = new Tier6RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}