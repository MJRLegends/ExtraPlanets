package com.mjr.extraplanets.jei.rockets.tier8;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class Tier8RocketRecipeHandler implements IRecipeHandler<Tier8RocketRecipeWrapper> {
	@Nonnull
	@Override
	public Class<Tier8RocketRecipeWrapper> getRecipeClass() {
		return Tier8RocketRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.ROCKET_T8_ID;
	}

	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull Tier8RocketRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull Tier8RocketRecipeWrapper recipe) {
		if (recipe.getInputs().size() != 21) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}