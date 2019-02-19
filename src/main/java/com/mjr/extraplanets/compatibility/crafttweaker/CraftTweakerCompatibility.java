package com.mjr.extraplanets.compatibility.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.ExtraPlanets")
public class CraftTweakerCompatibility {

	@ZenMethod
	public static void addBlockSmasherRecipe(IItemStack output, IItemStack input) {
		CraftTweakerAPI.apply(new ActionAddBlockSmasherRecipe(input, output));
	}

	@ZenMethod
	public static void removeBlockSmasherRecipe(IItemStack output) {
		CraftTweakerAPI.apply(new ActionRemoveBlockSmasherRecipe(output));
	}

	@ZenMethod
	public static void addSolarEvaporationChamberRecipe(IItemStack output, IItemStack input) {
		CraftTweakerAPI.apply(new ActionAddSolarEvaporationChamberRecipe(input, output));
	}

	@ZenMethod
	public static void removeSolarEvaporationChamberRecipe(IItemStack output) {
		CraftTweakerAPI.apply(new ActionRemoveSolarEvaporationChamberRecipe(output));
	}

	@ZenMethod
	public static void removeNASATier4RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(4));
	}

	@ZenMethod
	public static void removeNASATier5RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(5));
	}

	@ZenMethod
	public static void removeNASATier6RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(6));
	}

	@ZenMethod
	public static void removeNASATier7RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(7));
	}

	@ZenMethod
	public static void removeNASATier8RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(8));
	}

	@ZenMethod
	public static void removeNASATier9RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(9));
	}

	@ZenMethod
	public static void removeNASATier10RocketRecipe() {
		CraftTweakerAPI.apply(new ActionRemoveTieredRocketRecipe(10));
	}

	@ZenMethod
	public static void addNASATieredRocketRecipe(int tier, IItemStack[] inputs) {
		CraftTweakerAPI.apply(new ActionAddNASATieredRocketRecipe(tier, inputs));
	}
}
