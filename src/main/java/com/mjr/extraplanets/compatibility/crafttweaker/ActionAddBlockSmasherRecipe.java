package com.mjr.extraplanets.compatibility.crafttweaker;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;

public class ActionAddBlockSmasherRecipe implements IAction {
	
	private final IItemStack input;
	private final IItemStack output;

	public ActionAddBlockSmasherRecipe(IItemStack input2, IItemStack output2) {
		this.input = input2;
		this.output = output2;
	}

	@Override
	public void apply() {
		ExtraPlanets_MachineRecipes.addBlockSmasherRecipe(CraftTweakerMC.getItemStack(this.output), CraftTweakerMC.getItemStack(this.input));

	}

	@Override
	public String describe() {
		return "Adding Block Smasher Recipe: Input " + this.input + " to Output " + this.output;
	}

}
