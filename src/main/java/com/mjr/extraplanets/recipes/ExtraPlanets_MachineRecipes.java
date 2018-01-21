package com.mjr.extraplanets.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.google.common.collect.ImmutableMap;

public class ExtraPlanets_MachineRecipes {
	private static HashMap<ItemStack, ItemStack> blockSmasherRecipes = new HashMap<>();

	public static ArrayList<ItemStack> blockSmasherSlotValidItems = new ArrayList<>(1);

	public static void addBlockSmasherRecipe(ItemStack output, ItemStack input) {
		ExtraPlanets_MachineRecipes.blockSmasherRecipes.put(input, output);

		ItemStack inputStack = input;
		if (inputStack.isEmpty()) {
			return;
		}

		if (!ExtraPlanets_MachineRecipes.blockSmasherSlotValidItems.contains(inputStack))
			ExtraPlanets_MachineRecipes.blockSmasherSlotValidItems.add(inputStack);
	}

	public static ItemStack getBlockSmasherOutputForInput(ItemStack input) {
		for (Entry<ItemStack, ItemStack> recipe : ExtraPlanets_MachineRecipes.blockSmasherRecipes.entrySet()) {
			boolean found = true;

			ItemStack recipeStack = recipe.getKey();
			ItemStack inputStack = input;

			if (recipeStack.isEmpty() || inputStack.isEmpty()) {
				if (!recipeStack.isEmpty() || !inputStack.isEmpty()) {
					found = false;
				}
			} else if (recipeStack.getItem() != inputStack.getItem() || recipeStack.getItemDamage() != inputStack.getItemDamage()) {
				found = false;
			}

			if (!found) {
				continue;
			}

			return recipe.getValue();
		}

		return ItemStack.EMPTY;
	}

	public static ItemStack getBlockSmasherInputForOutput(ItemStack output) {
		for (Entry<ItemStack, ItemStack> recipe : ExtraPlanets_MachineRecipes.blockSmasherRecipes.entrySet()) {
			boolean found = true;

			ItemStack recipeStack = recipe.getValue();
			ItemStack inputStack = output;

			if (recipeStack.isEmpty() || inputStack.isEmpty()) {
				if (!recipeStack.isEmpty() || !inputStack.isEmpty()) {
					found = false;
				}
			} else if (recipeStack.getItem() != inputStack.getItem() || recipeStack.getItemDamage() != inputStack.getItemDamage()) {
				found = false;
			}

			if (!found) {
				continue;
			}

			return recipe.getKey();
		}

		return ItemStack.EMPTY;
	}

	public static void removeBlockSmasherRecipe(ItemStack match) {
		ExtraPlanets_MachineRecipes.blockSmasherRecipes.entrySet().removeIf(recipe -> ItemStack.areItemStacksEqual(match, recipe.getValue()));
	}

	public static ImmutableMap<ItemStack, ItemStack> getBlockSmasherRecipes() {
		return ImmutableMap.copyOf(blockSmasherRecipes);
	}

}
