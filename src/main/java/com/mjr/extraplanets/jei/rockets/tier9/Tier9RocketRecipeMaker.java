package com.mjr.extraplanets.jei.rockets.tier9;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.recipes.Tier9RocketRecipes;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

public class Tier9RocketRecipeMaker {
	public static List<Tier9RocketRecipeWrapper> getRecipesList() {
		List<Tier9RocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier9RocketRecipes.getTier9RocketRecipes()) {
			Tier9RocketRecipeWrapper wrapper = new Tier9RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}