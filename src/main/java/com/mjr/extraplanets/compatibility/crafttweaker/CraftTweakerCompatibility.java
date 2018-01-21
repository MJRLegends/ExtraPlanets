package com.mjr.extraplanets.compatibility.crafttweaker;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;

@ZenRegister
@ZenClass("mods.ExtraPlanets")
public class CraftTweakerCompatibility {
	
	@ZenMethod
	public static void addBlockSmasherRecipe(IItemStack input, IItemStack output){
        CraftTweakerAPI.apply(new ActionAddBlockSmasherRecipe(input, output));
	}
	
	@ZenMethod
	public static void removeBlockSmasherRecipe(IItemStack output){
        CraftTweakerAPI.apply(new ActionRemoveBlockSmasherRecipe(output));
	}
	
	@ZenMethod
	public static void addSolarEvaporationChamberRecipe(IItemStack input, IItemStack output){
        CraftTweakerAPI.apply(new ActionAddSolarEvaporationChamberRecipe(input, output));
	}
	
	@ZenMethod
	public static void removeSolarEvaporationChamberRecipe(IItemStack output){
        CraftTweakerAPI.apply(new ActionRemoveSolarEvaporationChamberRecipe(output));
	}
}
