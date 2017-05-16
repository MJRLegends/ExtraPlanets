package com.mjr.extraplanets.jei.rockets.tier4;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.recipes.Tier4RocketRecipes;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

public class Tier4RocketRecipeMaker {
	public static List<Tier4RocketRecipeWrapper> getRecipesList() {
		List<Tier4RocketRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : Tier4RocketRecipes.getTier4RocketRecipes()) {
			Tier4RocketRecipeWrapper wrapper = new Tier4RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}