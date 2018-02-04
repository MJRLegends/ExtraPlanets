package com.mjr.extraplanets.jei.purifier;

import java.util.List;

import javax.annotation.Nonnull;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class PurifierRecipeWrapper extends BlankRecipeWrapper implements IRecipeWrapper {
	@Nonnull
	private final List<ItemStack> input;
	@Nonnull
	private final List<ItemStack> output;

	public PurifierRecipeWrapper(@Nonnull List<ItemStack> input, @Nonnull List<ItemStack> output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(ItemStack.class, this.input);
		ingredients.setOutputs(ItemStack.class, this.output);
	}
}
