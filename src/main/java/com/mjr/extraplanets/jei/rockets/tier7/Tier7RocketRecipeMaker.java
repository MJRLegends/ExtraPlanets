package com.mjr.extraplanets.jei.rockets.tier7;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier7RocketRecipes;

public class Tier7RocketRecipeMaker {
	public static List<Tier7RocketRecipeWrapper> getRecipesList() {
		List<Tier7RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier7RocketRecipes.getTier7RocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier7RocketRecipeWrapper wrapper = new Tier7RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}