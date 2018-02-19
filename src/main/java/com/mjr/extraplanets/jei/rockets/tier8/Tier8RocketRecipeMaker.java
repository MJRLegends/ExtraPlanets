package com.mjr.extraplanets.jei.rockets.tier8;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier8RocketRecipes;

public class Tier8RocketRecipeMaker {
	public static List<Tier8RocketRecipeWrapper> getRecipesList() {
		List<Tier8RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier8RocketRecipes.getTier8RocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier8RocketRecipeWrapper wrapper = new Tier8RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}