package com.mjr.extraplanets.compatibility.crafttweaker;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;

public class ActionRemoveSolarEvaporationChamberRecipe implements IAction {
	
	private final IItemStack output;

	public ActionRemoveSolarEvaporationChamberRecipe(IItemStack output2) {
		this.output = output2;
	}

	@Override
	public void apply() {
		ExtraPlanets_MachineRecipes.removeSolarEvaporationChamberRecipe(CraftTweakerMC.getItemStack(this.output));

	}

	@Override
	public String describe() {
		return "Removing Solar Evaporation Chamber Recipe: Output" + this.output;
	}

}
