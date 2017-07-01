package com.mjr.extraplanets.jei.solarEvaporationChamber;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class SolarEvaporationChamberRecipeMaker {
	public static List<SolarEvaporationChamberRecipeWrapper> getRecipesList() {
		List<SolarEvaporationChamberRecipeWrapper> recipes = new ArrayList<>();
		SolarEvaporationChamberRecipeWrapper wrapper = new SolarEvaporationChamberRecipeWrapper(new ItemStack(ExtraPlanets_Items.potash), new ItemStack(ExtraPlanets_Items.potassium, 1, 0));
		recipes.add(wrapper);

		return recipes;
	}
}
