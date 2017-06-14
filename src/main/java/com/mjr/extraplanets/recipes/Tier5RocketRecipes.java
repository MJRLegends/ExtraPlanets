package com.mjr.extraplanets.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.recipe.NasaWorkbenchRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.inventory.rockets.InventorySchematicTier5Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class Tier5RocketRecipes {
	private static List<INasaWorkbenchRecipe> tier5RocketRecipes = new ArrayList<INasaWorkbenchRecipe>();

	public static ItemStack findMatchingTier5RocketRecipe(InventorySchematicTier5Rocket inventoryRocketBench) {
		for (INasaWorkbenchRecipe recipe : tier5RocketRecipes) {
			if (recipe.matches(inventoryRocketBench)) {
				return recipe.getRecipeOutput();
			}
		}
		return ItemStack.EMPTY;
	}

	public static void addTier5RocketRecipe(ItemStack result, HashMap<Integer, ItemStack> input) {
		addTier5RocketRecipe(new NasaWorkbenchRecipe(result, input));
	}

	public static void addTier5RocketRecipe(INasaWorkbenchRecipe recipe) {
		tier5RocketRecipes.add(recipe);
	}

	public static List<INasaWorkbenchRecipe> getTier5RocketRecipes() {
		return tier5RocketRecipes;
	}

	public static void registerRocketCraftingRecipe() {
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(ExtraPlanets_Items.TIER_5_NOSE_CONE)); // Cone
		// Body
		input.put(2, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(3, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(4, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(5, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(6, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(7, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(8, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(9, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(10, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		input.put(11, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));

		input.put(12, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1)); // Booster
		input.put(13, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2)); // Fin
		input.put(14, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2)); // Fin
		input.put(15, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 0)); // Engine
		input.put(16, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1)); // Booster
		input.put(17, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2)); // Fin
		input.put(18, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2)); // Fin
		input.put(19, ItemStack.EMPTY);
		input.put(20, ItemStack.EMPTY);
		input.put(21, ItemStack.EMPTY);
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 0), input));

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, ItemStack.EMPTY);
		input2.put(21, ItemStack.EMPTY);
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 1), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, ItemStack.EMPTY);
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, ItemStack.EMPTY);
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 1), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, ItemStack.EMPTY);
		input2.put(20, ItemStack.EMPTY);
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 1), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, ItemStack.EMPTY);
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 2), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, ItemStack.EMPTY);
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 2), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, ItemStack.EMPTY);
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 2), input2));

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.CHEST));
		input2.put(20, new ItemStack(Blocks.CHEST));
		input2.put(21, new ItemStack(Blocks.CHEST));
		Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 3), input2));
	}
}
