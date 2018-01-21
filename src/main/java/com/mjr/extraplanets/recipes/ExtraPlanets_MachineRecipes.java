package com.mjr.extraplanets.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.google.common.collect.ImmutableMap;

public class ExtraPlanets_MachineRecipes {
	private static HashMap<ItemStack, ItemStack> blockSmasherRecipes = new HashMap<>();

	public static ArrayList<ArrayList<ItemStack>> blockSmasherSlotValidItems = new ArrayList<>(1);

	public static void addBlockSmasherRecipe(ItemStack output, ItemStack input) {
		ExtraPlanets_MachineRecipes.blockSmasherRecipes.put(input, output);

		// Add the recipe ingred ients to the valid items for each slot
		// First initialise the ArrayList if this is the first time it's used
		if (ExtraPlanets_MachineRecipes.blockSmasherSlotValidItems.size() == 0) {
			ArrayList<ItemStack> entry = new ArrayList<ItemStack>();
			ExtraPlanets_MachineRecipes.blockSmasherSlotValidItems.add(entry);
		}
		// Now see if the recipe items are already valid for their slots, if not add them
		ItemStack inputStack = input;
		if (inputStack.isEmpty()) {
			return;
		}

		ArrayList<ItemStack> validItems = ExtraPlanets_MachineRecipes.blockSmasherSlotValidItems.get(0);
		boolean found = false;
		for (ItemStack validItem : validItems) {
			if (inputStack.isItemEqual(validItem)) {
				found = true;
				break;
			}
		}
		if (!found) {
			validItems.add(inputStack.copy());
		}
	}

	public static ItemStack getBlockSmasherOutputForInput(ItemStack input) {
		for (Entry<ItemStack, ItemStack> recipe : ExtraPlanets_MachineRecipes.blockSmasherRecipes.entrySet()) {
			boolean found = true;

				ItemStack recipeStack = recipe.getKey();
				ItemStack inputStack = input;

				if (recipeStack.isEmpty() || inputStack.isEmpty()) {
					if (!recipeStack.isEmpty() || !inputStack.isEmpty()) {
						found = false;
						break;
					}
				} else if (recipeStack.getItem() != inputStack.getItem() || recipeStack.getItemDamage() != inputStack.getItemDamage()) {
					found = false;
					break;
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
						break;
					}
				} else if (recipeStack.getItem() != inputStack.getItem() || recipeStack.getItemDamage() != inputStack.getItemDamage()) {
					found = false;
					break;
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
