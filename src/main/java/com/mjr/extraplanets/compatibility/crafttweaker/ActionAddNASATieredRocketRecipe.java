package com.mjr.extraplanets.compatibility.crafttweaker;

import java.util.HashMap;

import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.recipes.Tier10RocketRecipes;
import com.mjr.extraplanets.recipes.Tier4RocketRecipes;
import com.mjr.extraplanets.recipes.Tier5RocketRecipes;
import com.mjr.extraplanets.recipes.Tier6RocketRecipes;
import com.mjr.extraplanets.recipes.Tier7RocketRecipes;
import com.mjr.extraplanets.recipes.Tier8RocketRecipes;
import com.mjr.extraplanets.recipes.Tier9RocketRecipes;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import micdoodle8.mods.galacticraft.core.recipe.NasaWorkbenchRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ActionAddNASATieredRocketRecipe implements IAction {
	private final int tier;
	private final IItemStack[] inputs;
	public ActionAddNASATieredRocketRecipe(int tier, IItemStack[] inputs) {
		this.tier = tier;
		this.inputs = inputs;
	}

	@Override
	public void apply() {
		if(tier >= 4 && tier <= 10 && inputs.length != 18)
			CraftTweakerAPI.logError("Invalid Input Array for adding Tier " + tier + " Rocket Recipe! Amount of inputs needs to be 18!");
		
		HashMap<Integer, ItemStack> input = new HashMap<>();
        HashMap<Integer, ItemStack> input2;
		for(int i = 1; i < inputs.length + 1; i++) {
			input.put(i, CraftTweakerMC.getItemStack(this.inputs[i - 1]));
		}
		switch(tier) {
			case 4:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier4RocketRecipes.addTier4RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), input2));
				break;
			case 5:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier5RocketRecipes.addTier5RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), input2));
				break;
			case 6:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier6RocketRecipes.addTier6RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), input2));
				break;
			case 7:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier7RocketRecipes.addTier7RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), input2));
				break;
			case 8:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier8RocketRecipes.addTier8RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), input2));
				break;
			case 9:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier9RocketRecipes.addTier9RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), input2));
				break;
			case 10:
				input.put(19, ItemStack.EMPTY);
		        input.put(20, ItemStack.EMPTY);
		        input.put(21, ItemStack.EMPTY);
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 0), input));
		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, ItemStack.EMPTY);
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, ItemStack.EMPTY);
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, ItemStack.EMPTY);
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, ItemStack.EMPTY);
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), input2));

		        input2 = new HashMap<Integer, ItemStack>(input);
		        input2.put(19, new ItemStack(Blocks.CHEST));
		        input2.put(20, new ItemStack(Blocks.CHEST));
		        input2.put(21, new ItemStack(Blocks.CHEST));
				Tier10RocketRecipes.addTier10RocketRecipe(new NasaWorkbenchRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), input2));
				break;
		}
	}

	@Override
	public String describe() {
		return "Adding recipe for Tier " + tier + " Rocket for the NASAWorkbench";
	}

}
