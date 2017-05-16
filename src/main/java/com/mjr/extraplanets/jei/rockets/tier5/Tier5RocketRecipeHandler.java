package com.mjr.extraplanets.jei.rockets.tier5;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class Tier5RocketRecipeHandler implements IRecipeHandler<Tier5RocketRecipeWrapper> {
	@Nonnull
	@Override
	public Class<Tier5RocketRecipeWrapper> getRecipeClass() {
		return Tier5RocketRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.ROCKET_T5_ID;
	}

	@Override
	public String getRecipeCategoryUid(Tier5RocketRecipeWrapper recipe) {
		return this.getRecipeCategoryUid();
	}

	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull Tier5RocketRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull Tier5RocketRecipeWrapper recipe) {
		if (recipe.getInputs().size() != 21) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}