package com.mjr.extraplanets.jei.rockets.tier5;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier5RocketRecipes;

public class Tier5RocketRecipeMaker {
	public static List<Tier5RocketRecipeWrapper> getRecipesList() {
		List<Tier5RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier5RocketRecipes.getTier5RocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier5RocketRecipeWrapper wrapper = new Tier5RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}