package com.mjr.extraplanets.jei.vehicles.venusRover;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class VenusRoverRecipeHandler implements IRecipeHandler<VenusRoverRecipeWrapper> {
	@Nonnull
	@Override
	public Class<VenusRoverRecipeWrapper> getRecipeClass() {
		return VenusRoverRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.VENUS_ROVER_ID;
	}

	@Override
	public String getRecipeCategoryUid(VenusRoverRecipeWrapper recipe) {
		return this.getRecipeCategoryUid();
	}

	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull VenusRoverRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull VenusRoverRecipeWrapper recipe) {
		if (recipe.getInputs().size() < 22 || recipe.getInputs().size() > 24) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}