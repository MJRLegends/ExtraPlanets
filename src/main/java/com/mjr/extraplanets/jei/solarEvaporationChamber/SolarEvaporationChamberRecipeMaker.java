package com.mjr.extraplanets.jei.solarEvaporationChamber;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

import net.minecraft.item.ItemStack;

public class SolarEvaporationChamberRecipeMaker {
	public static List<SolarEvaporationChamberRecipeWrapper> getRecipesList() {
		List<SolarEvaporationChamberRecipeWrapper> recipes = new ArrayList<>();
		SolarEvaporationChamberRecipeWrapper wrapper = new SolarEvaporationChamberRecipeWrapper(new ItemStack(ExtraPlanets_Items.POTASH_SHARDS, 12, 0), new ItemStack(ExtraPlanets_Items.POTASSIUM, 1, 0));
		recipes.add(wrapper);

		return recipes;
	}
}
