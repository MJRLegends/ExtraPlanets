package com.mjr.extraplanets.jei.rockets.tier10;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.client.jei.tier1rocket.Tier1RocketRecipeMaker;

import com.mjr.extraplanets.recipes.Tier10RocketRecipes;

public class Tier10RocketRecipeMaker {
	public static List<Tier10RocketRecipeWrapper> getRecipesList() {
		List<Tier10RocketRecipeWrapper> recipes = new ArrayList<>();

		int chestCount = -1;
		for (INasaWorkbenchRecipe recipe : Tier10RocketRecipes.getTier10RocketRecipes()) {
            int chests = Tier1RocketRecipeMaker.countChests(recipe); 
            if (chests == chestCount)
                continue;
            chestCount = chests;
			Tier10RocketRecipeWrapper wrapper = new Tier10RocketRecipeWrapper(recipe);
			recipes.add(wrapper);
		}

		return recipes;
	}
}