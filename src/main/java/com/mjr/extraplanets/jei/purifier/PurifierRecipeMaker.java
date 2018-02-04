package com.mjr.extraplanets.jei.purifier;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.UniversalBucket;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class PurifierRecipeMaker {
	public static List<PurifierRecipeWrapper> getRecipesList() {
		List<PurifierRecipeWrapper> recipes = new ArrayList<>();
		List<ItemStack> inputs = new ArrayList<>();
		inputs.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID));
		inputs.add(ItemStack.EMPTY);
		inputs.add(new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 6, 0));
		List<ItemStack> outputs = new ArrayList<>();
		outputs.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.INFECTED_WATER_FLUID));
		outputs.add(ItemStack.EMPTY);
		PurifierRecipeWrapper wrapper = new PurifierRecipeWrapper(inputs, outputs);
		recipes.add(wrapper);

		List<ItemStack> inputs2 = new ArrayList<>();
		inputs2.add(ItemStack.EMPTY);
		inputs2.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.INFECTED_WATER_FLUID));
		inputs2.add(new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 6, 0));
		List<ItemStack> outputs2 = new ArrayList<>();
		outputs2.add(ItemStack.EMPTY);
		outputs2.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.CLEAN_WATER_FLUID));
		PurifierRecipeWrapper wrapper2 = new PurifierRecipeWrapper(inputs2, outputs2);
		recipes.add(wrapper2);
		return recipes;
	}
}
