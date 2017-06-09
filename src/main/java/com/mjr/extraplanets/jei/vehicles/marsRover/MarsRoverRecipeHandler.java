package com.mjr.extraplanets.jei.vehicles.marsRover;

import javax.annotation.Nonnull;

import com.mjr.extraplanets.jei.RecipeCategories;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

public class MarsRoverRecipeHandler implements IRecipeHandler<MarsRoverRecipeWrapper> {
	@Nonnull
	@Override
	public Class<MarsRoverRecipeWrapper> getRecipeClass() {
		return MarsRoverRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.MARS_ROVER_ID;
	}

	@Override
	public String getRecipeCategoryUid(MarsRoverRecipeWrapper recipe) {
		return this.getRecipeCategoryUid();
	}

	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull MarsRoverRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull MarsRoverRecipeWrapper recipe) {
		if (recipe.getInputs().size() < 17 || recipe.getInputs().size() > 19) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}