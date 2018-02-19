package com.mjr.extraplanets.jei.rockets.tier10Electric;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier10ElectricRocketRecipes;

public class Tier10ElectricRocketRecipeMaker {
	public static List<Tier10ElectricRocketRecipeWrapper> getRecipesList() {
		List<Tier10ElectricRocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier10ElectricRocketRecipes.getTier10ElectricRocketRecipes()) {
			int chests = Tier1RocketRecipeMaker.countChests(recipe);
			if (chests == chestCount)
				continue;
			chestCount = chests;
			Tier10ElectricRocketRecipeWrapper wrapper = new Tier10ElectricRocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}