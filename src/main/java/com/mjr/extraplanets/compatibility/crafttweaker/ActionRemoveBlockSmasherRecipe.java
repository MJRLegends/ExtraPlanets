package com.mjr.extraplanets.compatibility.crafttweaker;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;

public class ActionRemoveBlockSmasherRecipe implements IAction {

	private final IItemStack output;

	public ActionRemoveBlockSmasherRecipe(IItemStack output2) {
		this.output = output2;
	}

	@Override
	public void apply() {
		ExtraPlanets_MachineRecipes.removeBlockSmasherRecipe(CraftTweakerMC.getItemStack(this.output));

	}

	@Override
	public String describe() {
		return "Removing Block Smasher Recipe: Output" + this.output;
	}

}
