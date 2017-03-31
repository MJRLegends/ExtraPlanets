package com.mjr.extraplanets.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.recipe.NasaWorkbenchRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.inventory.rockets.InventorySchematicTier10Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class Tier10RocketRecipes {
	private static List<INasaWorkbenchRecipe> tier10RocketRecipes = new ArrayList();

	public static ItemStack findMatchingTier10RocketRecipe(InventorySchematicTier10Rocket inventoryRocketBench) {
		for (INasaWorkbenchRecipe recipe : tier10RocketRecipes) {
			if (recipe.matches(inventoryRocketBench)) {
				return recipe.getRecipeOutput();
			}
		}
		return null;
	}

	public static void addTier10RocketRecipe(ItemStack result, HashMap<Integer, ItemStack> input) {
		addTier10RocketRecipe(new NasaWorkbenchRecipe(result, input));
	}

	public static void addTier10RocketRecipe(INasaWorkbenchRecipe recipe) {
		tier10RocketRecipes.add(recipe);
	}

	public static List<INasaWorkbenchRecipe> getTier10RocketRecipes() {
		return tier10RocketRecipes;
	}

	public static void registerRocketCraftingRecipe() {
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(ExtraPlanets_Items.TIER_10_NOSE_CONE)); // Cone
		// Body
		input.put(2, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(3, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(4, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(5, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(6, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(7, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(8, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(9, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(10, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		input.put(11, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));

		input.put(12, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1)); // Booster
		input.put(13, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2)); // Fin
		input.put(14, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2)); // Fin
		input.put(15, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 0)); // Engine
		input.put(16, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1)); // Booster
		input.put(17, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2)); // Fin
		input.put(18, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2)); // Fin
		input.put(19, null);
		input.put(20, null);
		input.put(21, null);
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 0), input));

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, null);
		input2.put(21, null);
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 1), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, null);
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 1), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 1), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, null);
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 2), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 2), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 2), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 3), input2));
	}
}
