package com.mjr.extraplanets.jei.crystallizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.item.ItemStack;

public class CrystallizerRecipeWrapper extends BlankRecipeWrapper implements ICraftingRecipeWrapper {
	@Nonnull
	private final ItemStack[] input;
	@Nonnull
	private final ItemStack output;

	public CrystallizerRecipeWrapper(@Nonnull ItemStack[] input, @Nonnull ItemStack output) {
		this.input = input;
		this.output = output;
	}

	@Nonnull
	@Override
	public List<ItemStack> getInputs() {
		List<ItemStack> list = new ArrayList<>();
		list.addAll(Arrays.asList(this.input));
		return list;
	}

	@Nonnull
	@Override
	public List<ItemStack> getOutputs() {
		return Collections.singletonList(this.output);
	}
}
