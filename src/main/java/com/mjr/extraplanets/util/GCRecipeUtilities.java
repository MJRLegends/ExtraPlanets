package com.mjr.extraplanets.util;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class GCRecipeUtilities {
	public static void addSpaceStationRecipe(int spaceStationID, int planetID, HashMap<Object, Integer> obj) {
		SpaceStationType newType = new SpaceStationType(spaceStationID, planetID, new SpaceStationRecipe(obj));
		for (SpaceStationType type1 : GalacticraftRegistry.getSpaceStationData())
        {
            if (type1.getWorldToOrbitID() == newType.getWorldToOrbitID())
            {
                throw new RuntimeException("You have a double version of the same space station, station for planet ID: " + newType.getWorldToOrbitID() + " You will most likely fix this by checking out compatibility guide over at https://docs.mjrlegends.com/ExtraPlanets/1.12.2compact/");
            }
        }
		GalacticraftRegistry.registerSpaceStation(newType);
	}

	public static void addCompresssorShapelessRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addShapelessRecipe(output, inputs);
	}

	public static void addCompresssorRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addRecipe(output, inputs);
	}

	public static void addCircuitFabricatorRecipe(ItemStack output, NonNullList<Object> inputs) {
		CircuitFabricatorRecipes.addRecipe(output, inputs);
	}
}
