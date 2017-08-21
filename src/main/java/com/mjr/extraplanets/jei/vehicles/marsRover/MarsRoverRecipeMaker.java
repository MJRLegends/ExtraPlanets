package com.mjr.extraplanets.jei.vehicles.marsRover;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.recipes.MarsRoverRecipes;

public class MarsRoverRecipeMaker {
	public static List<MarsRoverRecipeWrapper> getRecipesList() {
		List<MarsRoverRecipeWrapper> recipes = new ArrayList<>();

		for (INasaWorkbenchRecipe recipe : MarsRoverRecipes.getmarsRoverRecipes()) {
			MarsRoverRecipeWrapper wrapper = new MarsRoverRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}