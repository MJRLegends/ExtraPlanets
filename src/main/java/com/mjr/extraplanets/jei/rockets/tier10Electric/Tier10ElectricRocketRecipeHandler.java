package com.mjr.extraplanets.jei.rockets.tier10Electric;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class Tier10ElectricRocketRecipeHandler implements IRecipeHandler<Tier10ElectricRocketRecipeWrapper> {
	@Nonnull
	@Override
	public Class<Tier10ElectricRocketRecipeWrapper> getRecipeClass() {
		return Tier10ElectricRocketRecipeWrapper.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return RecipeCategories.ROCKET_T10_ELECTRIC_ID;
	}

	@Override
	public String getRecipeCategoryUid(Tier10ElectricRocketRecipeWrapper recipe) {
		return this.getRecipeCategoryUid();
	}

	@Nonnull
	@Override
	public IRecipeWrapper getRecipeWrapper(@Nonnull Tier10ElectricRocketRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull Tier10ElectricRocketRecipeWrapper recipe) {
		if (recipe.getInputs().size() != 21) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
		}
		if (recipe.getOutputs().size() != 1) {
			GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
		}
		return true;
	}
}