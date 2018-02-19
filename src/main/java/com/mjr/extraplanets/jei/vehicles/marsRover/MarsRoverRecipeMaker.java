package com.mjr.extraplanets.jei.vehicles.marsRover;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.MarsRoverRecipes;

public class MarsRoverRecipeMaker {
	public static List<MarsRoverRecipeWrapper> getRecipesList() {
		List<MarsRoverRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : MarsRoverRecipes.getMarsRoverRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			MarsRoverRecipeWrapper wrapper = new MarsRoverRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}