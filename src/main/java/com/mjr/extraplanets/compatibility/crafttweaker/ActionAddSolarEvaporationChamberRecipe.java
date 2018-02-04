package com.mjr.extraplanets.compatibility.crafttweaker;

import com.mjr.extraplanets.recipes.ExtraPlanets_MachineRecipes;

import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;

public class ActionAddSolarEvaporationChamberRecipe implements IAction {

	private final IItemStack input;
	private final IItemStack output;

	public ActionAddSolarEvaporationChamberRecipe(IItemStack input2, IItemStack output2) {
		this.input = input2;
		this.output = output2;
	}

	@Override
	public void apply() {
		ExtraPlanets_MachineRecipes.addSolarEvaporationChamberRecipe(CraftTweakerMC.getItemStack(this.output), CraftTweakerMC.getItemStack(this.input));

	}

	@Override
	public String describe() {
		return "Adding Solar Evaporation Chamber Recipe: Input " + this.input + " to Output " + this.output;
	}

}
