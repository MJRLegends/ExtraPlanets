package com.mjr.extraplanets.jei.vehicles.venusRover;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.VenusRoverRecipes;

public class VenusRoverRecipeMaker {
	public static List<VenusRoverRecipeWrapper> getRecipesList() {
		List<VenusRoverRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : VenusRoverRecipes.getVenusRoverRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			VenusRoverRecipeWrapper wrapper = new VenusRoverRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}