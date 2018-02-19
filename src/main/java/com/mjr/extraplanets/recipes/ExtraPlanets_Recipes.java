package com.mjr.extraplanets.recipes;

import java.util.HashMap;
import java.util.List;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.util.GCRecipeUtilities;
import com.mjr.mjrlegendslib.util.RecipeUtilities;

public class ExtraPlanets_Recipes {
	public static void init() {
		registerRocketCraftingRecipes();
		registerFurnaceRecipes();
		registerSatellitesRecipes();
	}

	public static void initEvent() {
		registerCompressorRecipes();
		registerCircuitFabricatorRecipes();
		registerExtraPlanetMachineRecipes();
	}

	private static void registerRocketCraftingRecipes() {
		if (Config.MERCURY)
			Tier4RocketRecipes.registerRocketCraftingRecipe();
		if (Config.JUPITER)
			Tier5RocketRecipes.registerRocketCraftingRecipe();
		if (Config.SATURN)
			Tier6RocketRecipes.registerRocketCraftingRecipe();
		if (Config.URANUS)
			Tier7RocketRecipes.registerRocketCraftingRecipe();
		if (Config.NEPTUNE)
			Tier8RocketRecipes.registerRocketCraftingRecipe();
		if (Config.PLUTO)
			Tier9RocketRecipes.registerRocketCraftingRecipe();
		if (Config.ERIS)
			Tier10RocketRecipes.registerRocketCraftingRecipe();
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			Tier10ElectricRocketRecipes.registerRocketCraftingRecipe();
		if (Config.MARS_ROVER)
			MarsRoverRecipes.registerRoverCraftingRecipe();
		if (Config.VENUS_ROVER)
			VenusRoverRecipes.registerRoverCraftingRecipe();
	}

	private static void registerFurnaceRecipes() {
		if (Config.MERCURY) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 0.0F);
		}
		if (Config.CERES) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1), 0.0F);
		}
		if (Config.JUPITER) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 11), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12), 0.0F);
		}
		if (Config.SATURN) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 0.0F);
		}
		if (Config.URANUS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 0.0F);
		}
		if (Config.NEPTUNE) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 0.0F);
		}
		if (Config.PLUTO) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 0.0F);
		}
		if (Config.ERIS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5), 0.0F);
		}
		if (Config.CALLISTO) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.DEIMOS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.EUROPA) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.GANYMEDE) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.IO) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.PHOBOS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.TRITON) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.RHEA) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.TITAN) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.OBERON) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.TITANIA) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.IAPETUS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 4), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 3), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 2), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 12), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 1), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 13), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), 0.0F);

			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 5), new ItemStack(Blocks.COAL_BLOCK, 1, 1), 0.0F);

			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 8), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 9), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 0.0F);
		}
		if (Config.ORE_LEAD_GENERATION)
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ORE_LEAD, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_LEAD), 0.0F);
	}

	private static void registerCompressorRecipes() {
		if (Config.MERCURY) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), new ItemStack(AsteroidsItems.basicItem, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), new ItemStack(
					ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 3, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(Items.DIAMOND), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6),
					new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6),
					new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6));
		}
		if (Config.JUPITER) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), new ItemStack(
					ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4));
		}
		if (Config.SATURN) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(
					ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4));
		}
		if (Config.URANUS) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), new ItemStack(
					ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6));
		}
		if (Config.NEPTUNE) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5));
		}
		if (Config.PLUTO) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), new ItemStack(
					ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4));
		}
		if (Config.ERIS) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), new ItemStack(
					ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4));
		}
		if (Config.KEPLER22B) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5));
		}
		// Tier 1 - 4 Armour Layers
		if (Config.PRESSURE || Config.RADIATION) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_ARMOR_LAYER, 1, 0), "ingotAluminum", "ingotAluminum", "ingotAluminum", "ingotAluminum");
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_ARMOR_LAYER, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(
					AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_ARMOR_LAYER, 1, 0), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ARMOR_LAYER, 1, 0), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5));
		}
	}

	private static void registerCircuitFabricatorRecipes() {
		List<ItemStack> silicons = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon);
		int siliconCount = silicons.size();
		for (int j = 0; j <= siliconCount; j++) {
			ItemStack silicon;
			if (j == 0)
				silicon = new ItemStack(GCItems.basicItem, 1, 2);
			else
				silicon = silicons.get(j - 1);
			NonNullList<Object> input1 = NonNullList.create();
			input1.add(new ItemStack(Items.DIAMOND));
			input1.add(silicon);
			input1.add(silicon);
			input1.add(new ItemStack(Items.REDSTONE));
			input1.add(new ItemStack(Blocks.REDSTONE_LAMP));
			GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 0), input1);

			input1 = NonNullList.create();
			input1.add(new ItemStack(AsteroidsItems.basicItem));
			input1.add(silicon);
			input1.add(silicon);
			input1.add(new ItemStack(Items.REDSTONE));
			input1.add(new ItemStack(Blocks.REDSTONE_TORCH));
			GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 2), input1);

			if (Config.MERCURY) {
				input1 = NonNullList.create();
				input1.add(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5));
				input1.add(silicon);
				input1.add(silicon);
				input1.add(new ItemStack(Items.REDSTONE));
				input1.add(new ItemStack(Items.COMPARATOR));
				GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 1), input1);
			}
			if (Config.JUPITER) {
				input1 = NonNullList.create();
				input1.add(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8));
				input1.add(silicon);
				input1.add(silicon);
				input1.add(new ItemStack(Items.REDSTONE));
				input1.add(new ItemStack(Items.REPEATER));
				GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 3), input1);
			}
			if (Config.NEPTUNE) {
				input1 = NonNullList.create();
				input1.add(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6));
				input1.add(silicon);
				input1.add(silicon);
				input1.add(new ItemStack(Items.REDSTONE));
				input1.add(new ItemStack(Items.REPEATER));
				GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 4), input1);
			}
			if (Config.URANUS) {
				input1 = NonNullList.create();
				input1.add(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7));
				input1.add(silicon);
				input1.add(silicon);
				input1.add(new ItemStack(Items.REDSTONE));
				input1.add(new ItemStack(Items.REPEATER));
				GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 5), input1);
			}
		}
	}

	private static void registerSatellitesRecipes() {
		HashMap<Object, Integer> inputMap;
		if (Config.MERCURY_SPACE_STATION && Config.MERCURY) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.MERCURY_SPACE_STATION_ID, Config.MERCURY_ID, inputMap);
		}
		if (Config.VENUS_SPACE_STATION) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.VENUS_SPACE_STATION_ID, VenusModule.planetVenus.getDimensionID(), inputMap);
		}
		if (Config.CERES_SPACE_STATION && Config.CERES) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put("ingotUranium", 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.CERES_SPACE_STATION_ID, Config.CERES_ID, inputMap);
		}
		if (Config.MARS_SPACE_STATION && MarsModule.planetMars != null) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.MARS_SPACE_STATION_ID, MarsModule.planetMars.getDimensionID(), inputMap);
		}
		if (Config.JUPITER_SPACE_STATION && Config.JUPITER) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 3), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.JUPITER_SPACE_STATION_ID, Config.JUPITER_ID, inputMap);
		}
		if (Config.SATURN_SPACE_STATION && Config.SATURN) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.SATURN_SPACE_STATION_ID, Config.SATURN_ID, inputMap);
		}
		if (Config.URANUS_SPACE_STATION && Config.URANUS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 5), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.URANUS_SPACE_STATION_ID, Config.URANUS_ID, inputMap);
		}
		if (Config.NEPTUNE_SPACE_STATION && Config.NEPTUNE) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 4), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.NEPTUNE_SPACE_STATION_ID, Config.NEPTUNE_ID, inputMap);
		}
		if (Config.PLUTO_SPACE_STATION && Config.PLUTO) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.PLUTO_SPACE_STATION_ID, Config.PLUTO_ID, inputMap);
		}
		if (Config.ERIS_SPACE_STATION && Config.ERIS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(Items.IRON_INGOT, 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5), 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.ERIS_SPACE_STATION_ID, Config.ERIS_ID, inputMap);
		}
		if (Config.KEPLER22B_SPACE_STATION && Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.KEPLER22B_SPACE_STATION_ID, Config.KEPLER22B_ID, inputMap);
		}
	};

	private static void registerExtraPlanetMachineRecipes() {
		ExtraPlanets_MachineRecipes.addBlockSmasherRecipe(new ItemStack(ExtraPlanets_Items.POTASH_SHARDS, 3, 0), new ItemStack(ExtraPlanets_Blocks.ORE_POTASH));
		ExtraPlanets_MachineRecipes.addSolarEvaporationChamberRecipe(new ItemStack(ExtraPlanets_Items.POTASSIUM, 1, 0), new ItemStack(ExtraPlanets_Items.POTASH_SHARDS, 12, 0));
	}
}
