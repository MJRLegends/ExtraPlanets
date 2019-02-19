package com.mjr.extraplanets.compatibility.crafttweaker;

import com.mjr.extraplanets.recipes.Tier10RocketRecipes;
import com.mjr.extraplanets.recipes.Tier4RocketRecipes;
import com.mjr.extraplanets.recipes.Tier5RocketRecipes;
import com.mjr.extraplanets.recipes.Tier6RocketRecipes;
import com.mjr.extraplanets.recipes.Tier7RocketRecipes;
import com.mjr.extraplanets.recipes.Tier8RocketRecipes;
import com.mjr.extraplanets.recipes.Tier9RocketRecipes;

import crafttweaker.IAction;

public class ActionRemoveTieredRocketRecipe implements IAction {
	private final int tier;

	public ActionRemoveTieredRocketRecipe(int tier) {
		this.tier = tier;
	}

	@Override
	public void apply() {
		switch (tier) {
		case 4:
			Tier4RocketRecipes.removeAllTier4RocketRecipes();
			break;
		case 5:
			Tier5RocketRecipes.removeAllTier5RocketRecipes();
			break;
		case 6:
			Tier6RocketRecipes.removeAllTier6RocketRecipes();
			break;
		case 7:
			Tier7RocketRecipes.removeAllTier7RocketRecipes();
			break;
		case 8:
			Tier8RocketRecipes.removeAllTier8RocketRecipes();
			break;
		case 9:
			Tier9RocketRecipes.removeAllTier9RocketRecipes();
			break;
		case 10:
			Tier10RocketRecipes.removeAllTier10RocketRecipes();
			break;

		}
	}

	@Override
	public String describe() {
		return "Removing Tier " + tier + " Rocket recipe from NASA Workbench";
	}

}
