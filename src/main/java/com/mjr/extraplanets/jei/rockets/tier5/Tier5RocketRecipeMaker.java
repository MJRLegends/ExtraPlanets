package com.mjr.extraplanets.jei.rockets.tier5;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.recipes.Tier5RocketRecipes;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

public class Tier5RocketRecipeMaker {
	public static List<Tier5RocketRecipeWrapper> getRecipesList() {
		List<Tier5RocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier5RocketRecipes.getTier5RocketRecipes()) {
			Tier5RocketRecipeWrapper wrapper = new Tier5RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}