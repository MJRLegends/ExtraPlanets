package com.mjr.extraplanets.util;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeHelper {
	public static void addOreRecipe(ItemStack result, Object[] obj) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
	}

	public static void addShapelessRecipe(ItemStack result, Object[] obj) {
		GameRegistry.addShapelessRecipe(result, obj);
	}

	public static void addRecipe(ItemStack result, Object[] obj) {
		GameRegistry.addRecipe(result, obj);
	}

	public static void addShapedRecipe(ItemStack result, Object[] obj) {
		GameRegistry.addShapedRecipe(result, obj);
	}

	public static void addNBTRecipe(ItemStack result, ItemStack[] obj) {
		GameRegistry.addRecipe(new ShapedNBTRecipe(result, obj));
	}

	public static void addSmelting(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}

	public static void addSpaceStationRecipe(int spaceStationID, int planetID, HashMap<Object, Integer> obj) {
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(spaceStationID, planetID, new SpaceStationRecipe(obj)));
	}

	public static void addCompresssorShapelessRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addShapelessRecipe(output, inputs);
	}

	public static void addCompresssorRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addRecipe(output, inputs);
	}

	public static void addCircuitFabricatorRecipe(ItemStack output, ItemStack[] inputs) {
		CircuitFabricatorRecipes.addRecipe(output, inputs);
	}
}
