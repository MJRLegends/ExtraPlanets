package com.mjr.extraplanets.jei.rockets.tier9;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier9RocketRecipes;

public class Tier9RocketRecipeMaker {
	public static List<Tier9RocketRecipeWrapper> getRecipesList() {
		List<Tier9RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier9RocketRecipes.getTier9RocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier9RocketRecipeWrapper wrapper = new Tier9RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}