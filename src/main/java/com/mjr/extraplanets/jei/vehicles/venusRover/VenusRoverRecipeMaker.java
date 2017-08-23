package com.mjr.extraplanets.jei.vehicles.venusRover;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.recipes.VenusRoverRecipes;

public class VenusRoverRecipeMaker {
	public static List<VenusRoverRecipeWrapper> getRecipesList() {
		List<VenusRoverRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : VenusRoverRecipes.getVenusRoverRecipes()) {
			VenusRoverRecipeWrapper wrapper = new VenusRoverRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}