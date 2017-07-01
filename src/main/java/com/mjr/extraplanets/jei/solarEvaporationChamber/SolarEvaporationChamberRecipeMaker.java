package com.mjr.extraplanets.jei.solarEvaporationChamber;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class SolarEvaporationChamberRecipeMaker {
	public static List<SolarEvaporationChamberRecipeWrapper> getRecipesList() {
		List<SolarEvaporationChamberRecipeWrapper> recipes = new ArrayList<>();
		SolarEvaporationChamberRecipeWrapper wrapper = new SolarEvaporationChamberRecipeWrapper(new ItemStack(ExtraPlanets_Items.POTASH_SHARDS), new ItemStack(ExtraPlanets_Items.POTASSIUM, 1, 0));
		recipes.add(wrapper);

		return recipes;
	}
}
