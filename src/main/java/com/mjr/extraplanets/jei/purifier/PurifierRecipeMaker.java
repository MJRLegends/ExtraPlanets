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
		ItemStack[] inputs = new ItemStack[3];
		inputs[0] = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID);
		inputs[1] = null;
		inputs[2] = new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 6, 0);
		ItemStack[] outputs = new ItemStack[2];
		outputs[0] = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.INFECTED_WATER_FLUID);
		outputs[1] = null;
		PurifierRecipeWrapper wrapper = new PurifierRecipeWrapper(inputs, outputs);
		recipes.add(wrapper);
		
		ItemStack[] inputs2 = new ItemStack[3];
		inputs2[0] = null;
		inputs2[1] = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.INFECTED_WATER_FLUID);
		inputs2[2] = new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 6, 0);
		ItemStack[] outputs2 = new ItemStack[2];
		outputs2[0] = null;
		outputs2[1] = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.CLEAN_WATER_FLUID);
		PurifierRecipeWrapper wrapper2 = new PurifierRecipeWrapper(inputs2, outputs2);
		recipes.add(wrapper2);
		return recipes;
	}
}
