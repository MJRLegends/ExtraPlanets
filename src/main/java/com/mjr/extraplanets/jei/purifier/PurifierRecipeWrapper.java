package com.mjr.extraplanets.jei.purifier;

import javax.annotation.Nonnull;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.item.ItemStack;

@SuppressWarnings("deprecation")
public class PurifierRecipeWrapper extends BlankRecipeWrapper implements ICraftingRecipeWrapper {
	@Nonnull
	private final ItemStack[] input;
	@Nonnull
	private final ItemStack[] output;

	public PurifierRecipeWrapper(@Nonnull ItemStack[] input, @Nonnull ItemStack[] output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(ItemStack.class, this.input);
		ingredients.setOutput(ItemStack.class, this.output);
	}
}
