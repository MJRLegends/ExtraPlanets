package com.mjr.extraplanets.jei.rockets.tier10;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.recipes.Tier10RocketRecipes;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

public class Tier10RocketRecipeMaker {
	public static List<Tier10RocketRecipeWrapper> getRecipesList() {
		List<Tier10RocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier10RocketRecipes.getTier10RocketRecipes()) {
			Tier10RocketRecipeWrapper wrapper = new Tier10RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}