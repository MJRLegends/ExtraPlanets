package com.mjr.extraplanets.jei.solarEvaporationChamber;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class SolarEvaporationChamberRecipeHandler implements IRecipeHandler<SolarEvaporationChamberRecipeWrapper> {
	@Nonnull
	@Override
	public Class<SolarEvaporationChamberRecipeWrapper> getRecipeClass() {
		return SolarEvaporationChamberRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.SOLAR_EVAPORTATION_CHAMBER_ID;
	}

	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull SolarEvaporationChamberRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull SolarEvaporationChamberRecipeWrapper recipe) {
		if (recipe.getInputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}
