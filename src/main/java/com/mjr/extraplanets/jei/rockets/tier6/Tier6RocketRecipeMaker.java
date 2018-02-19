package com.mjr.extraplanets.jei.rockets.tier6;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier6RocketRecipes;

public class Tier6RocketRecipeMaker {
	public static List<Tier6RocketRecipeWrapper> getRecipesList() {
		List<Tier6RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier6RocketRecipes.getTier6RocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier6RocketRecipeWrapper wrapper = new Tier6RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}