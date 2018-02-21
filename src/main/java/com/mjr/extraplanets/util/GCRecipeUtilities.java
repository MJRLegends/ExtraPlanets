package com.mjr.extraplanets.util;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.item.ItemStack;

public class GCRecipeUtilities {
	public static void addSpaceStationRecipe(int spaceStationID, int planetID, HashMap<Object, Integer> obj) {
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(spaceStationID, planetID, new SpaceStationRecipe(obj)));
	}

	public static void addCompresssorShapelessRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addShapelessRecipe(output, inputs);
	}

	public static void addCompresssorRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addRecipe(output, inputs);
	}

	public static void addCircuitFabricatorRecipe(ItemStack output, Object[] inputs) {
		CircuitFabricatorRecipes.addRecipe(output, inputs);
	}
}
