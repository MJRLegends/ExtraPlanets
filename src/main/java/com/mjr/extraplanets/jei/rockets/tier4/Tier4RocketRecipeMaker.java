package com.mjr.extraplanets.jei.rockets.tier4;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier4RocketRecipes;

public class Tier4RocketRecipeMaker {
	public static List<Tier4RocketRecipeWrapper> getRecipesList() {
		List<Tier4RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier4RocketRecipes.getTier4RocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier4RocketRecipeWrapper wrapper = new Tier4RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}