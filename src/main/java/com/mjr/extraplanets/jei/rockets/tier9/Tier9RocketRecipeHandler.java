package com.mjr.extraplanets.jei.rockets.tier9;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class Tier9RocketRecipeHandler implements IRecipeHandler<Tier9RocketRecipeWrapper> {
	@Nonnull
	@Override
	public Class<Tier9RocketRecipeWrapper> getRecipeClass() {
		return Tier9RocketRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.ROCKET_T9_ID;
	}
	
	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull Tier9RocketRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull Tier9RocketRecipeWrapper recipe) {
		if (recipe.getInputs().size() != 21) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}