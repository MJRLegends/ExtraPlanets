package com.mjr.extraplanets.recipes;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;
import com.mjr.extraplanets.util.GCRecipeUtilities;
import com.mjr.mjrlegendslib.util.RecipeUtilities;

@SuppressWarnings("unused")
public class ExtraPlanets_Recipes {
	/*
	 * Galacricraft Items
	 */
	private static ItemStack COMPRESSED_COPPER;
	private static ItemStack COMPRESSED_TIN;
	private static ItemStack COMPRESSED_ALUMINUM;
	private static ItemStack COMPRESSED_STEEL;
	private static ItemStack COMPRESSED_BRONZE;
	private static ItemStack COMPRESSED_IRON;
	private static ItemStack COMPRESSED_TITANIUM;
	private static ItemStack COMPRESSED_DESH;
	private static ItemStack TIER_1_HEAVY_PLATING;
	private static ItemStack TIER_2_HEAVY_PLATING;
	private static ItemStack TIER_3_HEAVY_PLATING;
	private static ItemStack TIER_2_THERMAL_CLOTH;
	private static ItemStack TIN_CANISTER;
	private static ItemStack FUEL_CANISTER;
	private static ItemStack OXYGEN_VENT;
	private static String INGOT_DESH;
	private static String INGOT_TITANIUM;
	private static String INGOT_ALUMINUM;

	/*
	 * ExtraPlanets Items
	 */
	private static ItemStack TIER_4_ENGINE;
	private static ItemStack TIER_4_BOOSTER;
	private static ItemStack TIER_4_FIN;
	private static ItemStack TIER_4_HEAVY_PLATING;
	private static ItemStack COMPRESSED_CARBON;
	private static ItemStack INGOT_CARBON;
	private static ItemStack DIAMOND_SHARDS;

	private static ItemStack TIER_5_ENGINE;
	private static ItemStack TIER_5_BOOSTER;
	private static ItemStack TIER_5_FIN;
	private static ItemStack TIER_5_HEAVY_PLATING;
	private static ItemStack COMPRESSED_PALLADIUM;
	private static ItemStack INGOT_PALLADIUM;
	private static ItemStack COMPRESSED_NICKEL;
	private static ItemStack INGOT_NICKEL;
	private static ItemStack RED_GEM;
	private static ItemStack ASH;
	private static ItemStack ASH_SHARDS;
	private static ItemStack VOLCANIC_SHARDS;
	private static ItemStack INGOT_VOLCANIC;

	private static ItemStack TIER_6_ENGINE;
	private static ItemStack TIER_6_BOOSTER;
	private static ItemStack TIER_6_FIN;
	private static ItemStack TIER_6_HEAVY_PLATING;
	private static ItemStack COMPRESSED_MAGNESIUM;
	private static ItemStack INGOT_MAGNESIUM;

	private static ItemStack TIER_7_ENGINE;
	private static ItemStack TIER_7_BOOSTER;
	private static ItemStack TIER_7_FIN;
	private static ItemStack TIER_7_HEAVY_PLATING;
	private static ItemStack COMPRESSED_CRYSTAL;
	private static ItemStack INGOT_CRYSTAL;
	private static ItemStack COMPRESSED_REUBFORCIED_CRYSTAL;
	private static ItemStack WHITE_GEM;

	private static ItemStack TIER_8_ENGINE;
	private static ItemStack TIER_8_BOOSTER;
	private static ItemStack TIER_8_FIN;
	private static ItemStack TIER_8_HEAVY_PLATING;
	private static ItemStack COMPRESSED_ZINC;
	private static ItemStack INGOT_ZINC;
	private static ItemStack BLUE_GEM;

	private static ItemStack TIER_9_ENGINE;
	private static ItemStack TIER_9_BOOSTER;
	private static ItemStack TIER_9_FIN;
	private static ItemStack TIER_9_HEAVY_PLATING;
	private static ItemStack COMPRESSED_TUNGSTEN;
	private static ItemStack INGOT_TUNGSTEN;

	private static ItemStack TIER_10_ENGINE;
	private static ItemStack TIER_10_BOOSTER;
	private static ItemStack TIER_10_FIN;
	private static ItemStack TIER_10_HEAVY_PLATING;
	private static ItemStack COMPRESSED_DARK_IRON;
	private static ItemStack INGOT_DARK_IRON;

	private static ItemStack TIER_3_THERMAL_CLOTH;
	private static ItemStack TIER_4_THERMAL_CLOTH;
	private static ItemStack TIER_5_THERMAL_CLOTH;

	public static void init() {
		initItems();
		registerRocketCraftingRecipes();
		registerFurnaceRecipes();
		registerCraftingRecipes();
		registerCompressorRecipes();
		registerCircuitFabricatorRecipes();
		registerSatellitesRecipes();
	}

	public static void initItems() {
		/*
		 * Galacricraft Items
		 */
		COMPRESSED_COPPER = new ItemStack(GCItems.basicItem, 1, 6);
		COMPRESSED_TIN = new ItemStack(GCItems.basicItem, 1, 7);
		COMPRESSED_ALUMINUM = new ItemStack(GCItems.basicItem, 1, 8);
		COMPRESSED_STEEL = new ItemStack(GCItems.basicItem, 1, 9);
		COMPRESSED_BRONZE = new ItemStack(GCItems.basicItem, 1, 10);
		COMPRESSED_IRON = new ItemStack(GCItems.basicItem, 1, 11);

		COMPRESSED_TITANIUM = new ItemStack(AsteroidsItems.basicItem, 1, 6);
		COMPRESSED_DESH = new ItemStack(MarsItems.marsItemBasic, 1, 5);

		TIER_1_HEAVY_PLATING = new ItemStack(GCItems.heavyPlatingTier1);
		TIER_2_HEAVY_PLATING = new ItemStack(MarsItems.marsItemBasic, 1, 3);
		TIER_3_HEAVY_PLATING = new ItemStack(AsteroidsItems.basicItem, 1, 5);

		TIER_2_THERMAL_CLOTH = new ItemStack(AsteroidsItems.basicItem, 1, 7);
		TIN_CANISTER = new ItemStack(GCItems.canister, 1, 0);
		FUEL_CANISTER = new ItemStack(GCItems.fuelCanister, 1, 1);
		OXYGEN_VENT = new ItemStack(GCItems.oxygenVent, 1, 0);

		INGOT_DESH = "ingotDesh";
		INGOT_TITANIUM = "ingotTitanium";
		INGOT_ALUMINUM = "ingotAluminum";

		/*
		 * ExtraPlanets Items
		 */
		if (Config.MERCURY) {
			TIER_4_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 0);
			TIER_4_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1);
			TIER_4_FIN = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2);
			TIER_4_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3);
			COMPRESSED_CARBON = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4);
			INGOT_CARBON = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5);
			DIAMOND_SHARDS = new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 6);
		}
		if (Config.JUPITER) {
			TIER_5_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 0);
			TIER_5_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1);
			TIER_5_FIN = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2);
			TIER_5_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3);
			COMPRESSED_PALLADIUM = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4);
			INGOT_PALLADIUM = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5);
			COMPRESSED_NICKEL = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6);
			INGOT_NICKEL = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7);
			RED_GEM = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8);
			ASH = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 9);
			ASH_SHARDS = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10);
			VOLCANIC_SHARDS = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 11);
			INGOT_VOLCANIC = new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12);
		}
		if (Config.SATURN) {
			TIER_6_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 0);
			TIER_6_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1);
			TIER_6_FIN = new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2);
			TIER_6_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3);
			COMPRESSED_MAGNESIUM = new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4);
			INGOT_MAGNESIUM = new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5);
		}
		if (Config.URANUS) {
			TIER_7_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 0);
			TIER_7_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1);
			TIER_7_FIN = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2);
			TIER_7_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3);
			COMPRESSED_CRYSTAL = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4);
			INGOT_CRYSTAL = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5);
			COMPRESSED_REUBFORCIED_CRYSTAL = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6);
			WHITE_GEM = new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7);
		}
		if (Config.NEPTUNE) {
			TIER_8_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 0);
			TIER_8_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1);
			TIER_8_FIN = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2);
			TIER_8_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3);
			COMPRESSED_ZINC = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 4);
			INGOT_ZINC = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5);
			BLUE_GEM = new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6);
		}
		if (Config.PLUTO) {
			TIER_9_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 0);
			TIER_9_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1);
			TIER_9_FIN = new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2);
			TIER_9_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3);
			COMPRESSED_TUNGSTEN = new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4);
			INGOT_TUNGSTEN = new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5);
		}
		if (Config.ERIS) {
			TIER_10_ENGINE = new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 0);
			TIER_10_BOOSTER = new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1);
			TIER_10_FIN = new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2);
			TIER_10_HEAVY_PLATING = new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3);
			COMPRESSED_DARK_IRON = new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4);
			INGOT_DARK_IRON = new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5);
		}
		if (Config.THERMAL_PADDINGS) {
			TIER_3_THERMAL_CLOTH = new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0);
			TIER_4_THERMAL_CLOTH = new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1);
			TIER_5_THERMAL_CLOTH = new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2);
		}
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
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 10), INGOT_CARBON, 0.0F);
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
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 6), INGOT_PALLADIUM, 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 7), INGOT_NICKEL, 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 11), RED_GEM, 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK), INGOT_VOLCANIC, 0.0F);
		}
		if (Config.SATURN) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 6), INGOT_MAGNESIUM, 0.0F);
		}
		if (Config.URANUS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 3), INGOT_CRYSTAL, 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 7), WHITE_GEM, 0.0F);
		}
		if (Config.NEPTUNE) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 6), INGOT_ZINC, 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 10), BLUE_GEM, 0.0F);
		}
		if (Config.PLUTO) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 6), INGOT_TUNGSTEN, 0.0F);
		}
		if (Config.ERIS) {
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 6), INGOT_DARK_IRON, 0.0F);
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

			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 5), new ItemStack(Blocks.COAL_BLOCK, 1, 0), 0.0F);

			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 8), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 9), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 0.0F);
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 0.0F);
		}
		if (Config.ORE_LEAD_GENERATION)
			RecipeUtilities.addSmelting(new ItemStack(ExtraPlanets_Blocks.ORE_LEAD, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_LEAD), 0.0F);
	}

	@SuppressWarnings("deprecation")
	private static void registerCraftingRecipes() {
		if (Config.THERMAL_PADDINGS) {
			RecipeUtilities.addRecipe(TIER_3_THERMAL_CLOTH, new Object[] { "XXX", "XYX", 'X', TIER_2_THERMAL_CLOTH, 'Y', COMPRESSED_DESH });
			RecipeUtilities.addRecipe(TIER_4_THERMAL_CLOTH, new Object[] { "XXX", "XYX", 'X', TIER_2_THERMAL_CLOTH, 'Y', COMPRESSED_CARBON });
			RecipeUtilities.addRecipe(TIER_5_THERMAL_CLOTH, new Object[] { "XXX", "XYX", 'X', TIER_2_THERMAL_CLOTH, 'Y', COMPRESSED_MAGNESIUM });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X', TIER_3_THERMAL_CLOTH, 'Y', COMPRESSED_DESH });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X', TIER_3_THERMAL_CLOTH, 'Y', COMPRESSED_DESH });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X', TIER_3_THERMAL_CLOTH, 'Y', COMPRESSED_DESH });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X', TIER_3_THERMAL_CLOTH, 'Y', COMPRESSED_DESH });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X', TIER_4_THERMAL_CLOTH, 'Y', COMPRESSED_CARBON });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X', TIER_4_THERMAL_CLOTH, 'Y', COMPRESSED_CARBON });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X', TIER_4_THERMAL_CLOTH, 'Y', COMPRESSED_CARBON });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X', TIER_4_THERMAL_CLOTH, 'Y', COMPRESSED_CARBON });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X', TIER_5_THERMAL_CLOTH, 'Y', COMPRESSED_MAGNESIUM });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X', TIER_5_THERMAL_CLOTH, 'Y', COMPRESSED_MAGNESIUM });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X', TIER_5_THERMAL_CLOTH, 'Y', COMPRESSED_MAGNESIUM });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X', TIER_5_THERMAL_CLOTH, 'Y', COMPRESSED_MAGNESIUM });
		}
		if (Config.MERCURY) {
			// Battery
			if (Config.BATTERIES)
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_MERCURY, 1, ExtraPlanets_Items.BATTERY_MERCURY.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T',
						new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), 'R', "dustRedstone", 'C', Items.COAL });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2) });

			// Block of Mercury
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });

			// Block to Mercury
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 9, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });

			if (Config.ITEMS_MERCURY) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
			}

			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_4_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_4_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_4_HEAVY_PLATING, 'Y', new ItemStack(AsteroidsItems.basicItem, 1, 0) });
			RecipeUtilities.addRecipe(TIER_4_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_4_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			RecipeUtilities.addRecipe(TIER_4_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_4_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 1), 'Z', COMPRESSED_CARBON });

			// Block of Carbon
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_CARBON });

			// Block to Carbon
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11) });

			if (Config.ITEMS_CARBON) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', INGOT_CARBON, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_AXE), new Object[] { "XX ", "XS ", " S ", 'X', INGOT_CARBON, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_HOE), new Object[] { "XX ", " S ", " S ", 'X', INGOT_CARBON, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_SWORD), new Object[] { " X ", " X ", " S ", 'X', INGOT_CARBON, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', INGOT_CARBON, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_HELMET), new Object[] { "   ", "MMM", "M M", 'M', INGOT_CARBON });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_CARBON });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', INGOT_CARBON });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_BOOTS), new Object[] { "   ", "M M", "M M", 'M', INGOT_CARBON });
			}

			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 8) });
			}
		}
		if (Config.CERES) {
			// Nuclear Bomb
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NUCLEAR_BOMB),
					new Object[] { "GSG", "SUS", "GSG", 'G', Items.GUNPOWDER, 'S', Blocks.SAND, 'U', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, OreDictionary.WILDCARD_VALUE) });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 2) });

			// Block of Uranium
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });

			// Block to Uranium
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 9, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7) });

			if (Config.ITEMS_URANIUM) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
			}
			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 8) });
			}
		}
		if (Config.JUPITER) {
			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_5_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_5_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_5_HEAVY_PLATING, 'Y', TIER_4_HEAVY_PLATING });
			RecipeUtilities.addRecipe(TIER_5_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_5_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', OXYGEN_VENT });
			RecipeUtilities.addRecipe(TIER_5_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_5_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 11), 'Z', COMPRESSED_PALLADIUM });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 9), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 2) });

			// Block of Palladium
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_PALLADIUM });

			// Block of Red Gem
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12), new Object[] { "XXX", "XXX", "XXX", 'X', RED_GEM });

			// Block to Palladium
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8) });

			// Block to Red Gem
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 8), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12) });

			// Block of Nickel
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 13), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_NICKEL });

			// Block to Nickel
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 13) });

			// Orange Sand to Orange Sandstone
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE, 1, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0),
					new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0) });

			// Ash Block to Ash Shards
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 2, 10), new Object[] { new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), new ItemStack(ExtraPlanets_Blocks.ASH_ROCK, 1, 0) });

			// Ash Shards to Ash
			RecipeUtilities.addShapelessRecipe(ASH, new Object[] { ASH_SHARDS, ASH_SHARDS, ASH_SHARDS, ASH_SHARDS });

			// Volcanic Ingot to Volcanic Shards
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 2, 11), new Object[] { new ItemStack(ExtraPlanets_Items.TOOLS, 1, 1), INGOT_VOLCANIC, INGOT_VOLCANIC, INGOT_VOLCANIC, INGOT_VOLCANIC, INGOT_VOLCANIC });

			if (Config.ITEMS_PALLADIUM) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', INGOT_PALLADIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', INGOT_PALLADIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', INGOT_PALLADIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', INGOT_PALLADIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', INGOT_PALLADIUM, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', INGOT_PALLADIUM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_PALLADIUM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', INGOT_PALLADIUM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', INGOT_PALLADIUM });
			}

			if (Config.ITEMS_GEM_RED) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', RED_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', RED_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', RED_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', RED_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', RED_GEM, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', RED_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', RED_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', RED_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', RED_GEM });
			}

			// Battery
			if (Config.BATTERIES)
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_NICKEL, 1, ExtraPlanets_Items.BATTERY_NICKEL.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T', COMPRESSED_NICKEL, 'R', "dustRedstone", 'C', Items.COAL });
			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 9) });
			}
		}
		if (Config.SATURN) {
			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_6_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_6_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_6_HEAVY_PLATING, 'Y', TIER_5_HEAVY_PLATING });
			RecipeUtilities.addRecipe(TIER_6_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_6_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', OXYGEN_VENT });
			RecipeUtilities.addRecipe(TIER_6_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_6_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 5), 'Z', COMPRESSED_MAGNESIUM });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 2) });

			// Block of Magnesium
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_MAGNESIUM });

			// Block to Magnesium
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7) });

			// Fire Bomb
			if (Config.JUPITER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.FIRE_BOMB), new Object[] { "GZG", "SVS", "GZG", 'G', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM), 'S', Blocks.SAND, 'Z', ASH_SHARDS, 'V', VOLCANIC_SHARDS });
			else {
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.FIRE_BOMB), new Object[] { "GZG", "SLS", "GLG", 'G', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM), 'S', Blocks.SAND, 'Z', INGOT_MAGNESIUM, 'L', "ingotLead" });
			}

			if (Config.ITEMS_MAGNESIUM) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', INGOT_MAGNESIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', INGOT_MAGNESIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', INGOT_MAGNESIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', INGOT_MAGNESIUM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', INGOT_MAGNESIUM, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', INGOT_MAGNESIUM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_MAGNESIUM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', INGOT_MAGNESIUM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', INGOT_MAGNESIUM });
			}
			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 8) });
			}
		}
		if (Config.URANUS) {
			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_7_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_7_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_7_HEAVY_PLATING, 'Y', TIER_6_HEAVY_PLATING });
			RecipeUtilities.addRecipe(TIER_7_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_7_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', OXYGEN_VENT });
			RecipeUtilities.addRecipe(TIER_7_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_7_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 2), 'Z', COMPRESSED_CRYSTAL });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 4, 5), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 2) });

			// Block of Crystal
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_CRYSTAL });

			// Block of White Gem
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', WHITE_GEM });

			// Block to White Gem
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8) });

			// Block to Crystal
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4) });

			// Dense Ice to Ice
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DENSE_ICE, 1), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(Blocks.ICE, 1) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.ICE, 9), new Object[] { new ItemStack(ExtraPlanets_Blocks.DENSE_ICE, 1) });

			if (Config.ITEMS_CRYSTAL) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', INGOT_CRYSTAL, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_AXE), new Object[] { "XX ", "XS ", " S ", 'X', INGOT_CRYSTAL, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_HOE), new Object[] { "XX ", " S ", " S ", 'X', INGOT_CRYSTAL, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_SWORD), new Object[] { " X ", " X ", " S ", 'X', INGOT_CRYSTAL, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', INGOT_CRYSTAL, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_HELMET), new Object[] { "   ", "MMM", "M M", 'M', INGOT_CRYSTAL });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_CRYSTAL });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', INGOT_CRYSTAL });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_BOOTS), new Object[] { "   ", "M M", "M M", 'M', INGOT_CRYSTAL });
			}

			if (Config.ITEMS_GEM_WHITE) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', WHITE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', WHITE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', WHITE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', WHITE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', WHITE_GEM, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', WHITE_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', WHITE_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', WHITE_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', WHITE_GEM });
			}
			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 5) });
			}
		}
		if (Config.NEPTUNE) {
			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_8_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_8_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_8_HEAVY_PLATING, 'Y', TIER_7_HEAVY_PLATING });
			RecipeUtilities.addRecipe(TIER_8_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_8_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', OXYGEN_VENT });
			RecipeUtilities.addRecipe(TIER_8_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_8_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 14), 'Z', INGOT_ZINC });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 2) });

			// Block of Zinc
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_ZINC });

			// Block of Blue Gem
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11), new Object[] { "XXX", "XXX", "XXX", 'X', BLUE_GEM });

			// Block to Blue Gem
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 6), new Object[] { new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11) });

			// Block to Zinc
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7) });

			if (Config.ITEMS_GEM_BLUE) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', BLUE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', BLUE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', BLUE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', BLUE_GEM, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', BLUE_GEM, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', BLUE_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', BLUE_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', BLUE_GEM });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', BLUE_GEM });
			}

			if (Config.ITEMS_ZINC) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', INGOT_ZINC, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_AXE), new Object[] { "XX ", "XS ", " S ", 'X', INGOT_ZINC, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_HOE), new Object[] { "XX ", " S ", " S ", 'X', INGOT_ZINC, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_SWORD), new Object[] { " X ", " X ", " S ", 'X', INGOT_ZINC, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', INGOT_ZINC, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_HELMET), new Object[] { "   ", "MMM", "M M", 'M', INGOT_ZINC });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_ZINC });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', INGOT_ZINC });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_BOOTS), new Object[] { "   ", "M M", "M M", 'M', INGOT_ZINC });
			}

			// Battery
			if (Config.BATTERIES)
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_ZINC, 1, ExtraPlanets_Items.BATTERY_ZINC.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T', INGOT_ZINC, 'R', "dustRedstone", 'C', Items.COAL });

			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 8) });
			}
		}
		if (Config.PLUTO) {
			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_9_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_9_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_9_HEAVY_PLATING, 'Y', TIER_8_HEAVY_PLATING });
			RecipeUtilities.addRecipe(TIER_9_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_9_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', OXYGEN_VENT });
			RecipeUtilities.addRecipe(TIER_9_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_9_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 3), 'Z', COMPRESSED_TUNGSTEN });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 2) });

			// Block of Tungsten
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_TUNGSTEN });

			// Block to Tungsten
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7) });

			if (Config.ITEMS_TUNGSTEN) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', INGOT_TUNGSTEN, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_AXE), new Object[] { "XX ", "XS ", " S ", 'X', INGOT_TUNGSTEN, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_HOE), new Object[] { "XX ", " S ", " S ", 'X', INGOT_TUNGSTEN, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_SWORD), new Object[] { " X ", " X ", " S ", 'X', INGOT_TUNGSTEN, 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', INGOT_TUNGSTEN, 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_HELMET), new Object[] { "   ", "MMM", "M M", 'M', INGOT_TUNGSTEN });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_TUNGSTEN });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', INGOT_TUNGSTEN });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_BOOTS), new Object[] { "   ", "M M", "M M", 'M', INGOT_TUNGSTEN });
			}
			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 8) });
			}
		}
		if (Config.ERIS) {
			// Rocket
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', TIER_10_HEAVY_PLATING, 'Y', Blocks.REDSTONE_TORCH });
			RecipeUtilities.addRecipe(TIER_10_FIN, new Object[] { " Y ", "XYX", "X X", 'X', TIER_10_HEAVY_PLATING, 'Y', TIER_9_HEAVY_PLATING });
			RecipeUtilities.addRecipe(TIER_10_ENGINE, new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', TIN_CANISTER, 'X', TIER_10_HEAVY_PLATING, 'Y', Items.FLINT_AND_STEEL, 'Z', OXYGEN_VENT });
			RecipeUtilities.addRecipe(TIER_10_BOOSTER, new Object[] { "ZYZ", "ZWZ", "XVX", 'V', OXYGEN_VENT, 'W', FUEL_CANISTER, 'X', TIER_10_HEAVY_PLATING, 'Y', new ItemStack(Blocks.WOOL, 1, 9), 'Z', COMPRESSED_DARK_IRON });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 2) });

			// Block of Dark Iron
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', INGOT_DARK_IRON });

			// Block to Dark Iron
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7) });

			// Slab's & Stairs
			if (Config.SLABS_AND_STAIRS) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 8) });
			}
		}

		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			// Block of Nickel
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 14), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5) });

			// Block to Nickel
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 14) });

			// Stone Bricks
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 4, 11), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 1) });

			// Maple Wooden Planks
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 0) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 1), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 1) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 2), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 2) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 3), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 3) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 4), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 0) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 1) });

			// Planks to Sticks(4 Sticks per 2 Planks)
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 8), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 9), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 10), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 11), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 12), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Pressure Plates (4 Planks per 8 Pressure Plates)
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Buttons (2 Planks per 4 Buttons)
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			RecipeUtilities.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Doors (6 Planks per 4 Doors)
			RecipeUtilities.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			RecipeUtilities.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			RecipeUtilities.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			RecipeUtilities.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			RecipeUtilities.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			RecipeUtilities.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Signs (6 Planks per 6 Signs)
			RecipeUtilities.addOreRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), 'S', "stickWood" });
			RecipeUtilities.addOreRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), 'S', "stickWood" });
			RecipeUtilities.addOreRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), 'S', "stickWood" });
			RecipeUtilities.addOreRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), 'S', "stickWood" });
			RecipeUtilities.addOreRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), 'S', "stickWood" });
			RecipeUtilities.addOreRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), 'S', "stickWood" });

			if (Config.ITEMS_KEPLER22B) {
				// Tools
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });

				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });

				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });

				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });

				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });

				// Armour
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });

				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });

				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });

				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });

				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
			}
		}
		if (Config.JUPITER || Config.KEPLER22B) {
			// Red Sand to Red Sandstone
			RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE, 1, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0),
					new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0) });
		}
		if (Config.CUSTOM_APPLES) {
			// Diamond Apples
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.DIAMOND_APPLE, 1, 0), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.DIAMOND, 1, 0), 'A', Items.APPLE });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.DIAMOND_APPLE, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.DIAMOND_BLOCK, 1, 0), 'A', Items.APPLE });

			// Iron Apples
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.IRON_APPLE, 1, 0), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.IRON_INGOT, 1, 0), 'A', Items.APPLE });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.IRON_APPLE, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.IRON_BLOCK, 1, 0), 'A', Items.APPLE });
		}

		// Machines
		if (Config.REFINERY_ADVANCED)
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.REFINERY_ADVANCED), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', GCBlocks.refinery, 'Z', INGOT_PALLADIUM });
		if (Config.REFINERY_ULTIMATE) {
			if (Config.REFINERY_ADVANCED)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.REFINERY_ULTIMATE), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', ExtraPlanets_Machines.REFINERY_ADVANCED, 'Z', INGOT_ZINC });
			else
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.REFINERY_ULTIMATE), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', GCBlocks.refinery, 'Z', INGOT_ZINC });
		}
		if (Config.SOLAR_PANELS) {
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.solarPanel, 1, 4), 'Z', COMPRESSED_MAGNESIUM });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 0), 'Z', COMPRESSED_CRYSTAL });
		}
		if (Config.OXYGEN_COMPRESSOR_ADVANCED) {
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'Z', INGOT_MAGNESIUM });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.oxygenCompressor, 1, 4), 'Z', INGOT_MAGNESIUM });
		}
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE) {
			if (Config.OXYGEN_COMPRESSOR_ADVANCED) {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 0), 'Z', INGOT_TUNGSTEN });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 4), 'Z', INGOT_TUNGSTEN });
			} else {
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'Z', INGOT_TUNGSTEN });
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.oxygenCompressor, 1, 4), 'Z', INGOT_TUNGSTEN });
			}
		}
		if (Config.FUEL_LOADER_ADVANCED)
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ADVANCED), new Object[] { "XXX", "XZX", "WYW", 'W', INGOT_PALLADIUM, 'X', INGOT_NICKEL, 'Y', RED_GEM, 'Z', new ItemStack(GCBlocks.fuelLoader) });
		if (Config.FUEL_LOADER_ULTIMATE)
			if (Config.FUEL_LOADER_ADVANCED)
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE), new Object[] { "XXX", "XZX", "WYW", 'W', INGOT_ZINC, 'X', INGOT_TUNGSTEN, 'Y', BLUE_GEM, 'Z',
						new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ADVANCED) });
			else
				RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE), new Object[] { "XXX", "XZX", "WYW", 'W', INGOT_ZINC, 'X', INGOT_TUNGSTEN, 'Y', BLUE_GEM, 'Z', new ItemStack(GCBlocks.fuelLoader) });
		if (Config.VEHICLE_CHARGER)
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Machines.VEHICLE_CHARGER), new Object[] { "WXW", "WXW", "WXW", 'W', INGOT_DESH, 'X', new ItemStack(GCItems.battery, 1, GCItems.battery.getMaxDamage()) });

		// Launch pads
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 0), new Object[] { "   ", "BBB", "III", 'I', INGOT_TITANIUM, 'B', COMPRESSED_TITANIUM });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 1), new Object[] { "   ", "BBB", "III", 'I', INGOT_ZINC, 'B', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 2), new Object[] { "   ", "BBB", "III", 'I', INGOT_DESH, 'B', new ItemStack(MarsBlocks.marsBlock, 1, 8) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 3),
				new Object[] { "   ", "BBB", "III", 'I', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), 'B', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6) });

		if (Config.MARS_ROVER || Config.VENUS_ROVER || Config.ELECTRIC_ROCKET) {
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 0), new Object[] { "XWX", "WXW", "XWX", 'W', TIER_2_HEAVY_PLATING, 'X', "ingotLead" });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 1), new Object[] { "XWX", "WXW", "XWX", 'W', INGOT_DESH, 'X', "ingotLead" });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 2), new Object[] { " W ", "WXW", " W ", 'W', TIER_2_HEAVY_PLATING, 'X', new ItemStack(GCItems.partBuggy, 1, 0) });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), new Object[] { " W ", "WXW", " W ", 'W', INGOT_DESH, 'X', new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 2) });
		}
		// Can of Food
		RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 0), new Object[] { TIN_CANISTER, Items.COOKED_PORKCHOP, Items.COOKED_PORKCHOP });
		RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 1), new Object[] { TIN_CANISTER, new ItemStack(Items.COOKED_FISH, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0) });
		RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 2), new Object[] { TIN_CANISTER, new ItemStack(Items.COOKED_FISH, 1, 1), new ItemStack(Items.COOKED_FISH, 1, 1) });
		RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 3), new Object[] { TIN_CANISTER, Items.COOKED_CHICKEN, Items.COOKED_CHICKEN });
		RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 4), new Object[] { TIN_CANISTER, Items.COOKED_BEEF, Items.COOKED_BEEF });

		// Advanced & Ultimate Battery
		if (Config.BATTERIES) {
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, ExtraPlanets_Items.BATTERY_ADVANCED.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T', COMPRESSED_TITANIUM, 'R',
					new ItemStack(GCItems.battery, 1, GCItems.battery.getMaxDamage()), 'C', new ItemStack(MarsBlocks.marsBlock, 1, 8) });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_ULTIMATE, 1, ExtraPlanets_Items.BATTERY_ULTIMATE.getMaxDamage()), new Object[] { "WRB", "CPM", "TAZ", 'W', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 7), 'R',
					new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 11), 'B', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 10), 'C', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), 'P',
					new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8), 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7), 'T', INGOT_TUNGSTEN, 'A',
					new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, ExtraPlanets_Items.BATTERY_ADVANCED.getMaxDamage()), 'Z', INGOT_ZINC });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_MASSIVE, 1, ExtraPlanets_Items.BATTERY_MASSIVE.getMaxDamage()), new Object[] { "PPP", "ASA", "NNN", 'P', COMPRESSED_PALLADIUM, 'N', COMPRESSED_NICKEL, 'S',
					Items.NETHER_STAR, 'A', new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, ExtraPlanets_Items.BATTERY_ADVANCED.getMaxDamage()) });
		}
		// Cloth
		RecipeUtilities.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CLOTH, 8, 0), new Object[] { new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL) });

		// Gravity Controller
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1, 0), new Object[] { "RTR", "TCT", "RTR", 'T', new ItemStack(GCItems.basicItem, 1, 14), 'R', new ItemStack(GCItems.battery, 1, GCItems.battery.getMaxDamage()),
				'C', new ItemStack(GCItems.itemBasicMoon, 1, 0) });

		// Sledge Hammer
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), new Object[] { "XXX", "YSY", " S ", 'X', INGOT_VOLCANIC, 'Y', new ItemStack(GCItems.itemBasicMoon), 'S', "stickWood" });

		// Grinding Wheel
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TOOLS, 1, 1), new Object[] { "ZXZ", "XHX", "ZXZ", 'X', ASH_SHARDS, 'H', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), 'Z', INGOT_VOLCANIC });

		// Mesh
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TOOLS, 1, 2), new Object[] { "SSS", "SSS", "SSS", 'S', Items.STRING });

		// Filter
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), new Object[] { "CPC", "MMM", "CPC", 'C', new ItemStack(ExtraPlanets_Items.CLOTH), 'P', Items.PAPER, 'M', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 2) });

		// Candy Cane
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 0), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 1), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeMagenta" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeYellow" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePink" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLightBlue" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeMagenta" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePink" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLime" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 7), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLime" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 8), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLightBlue" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 9), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeWhite" });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 0), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 1), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeMagenta" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeYellow" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePink" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLightBlue" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeMagenta" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePink" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLime" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 7), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLime" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 8), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLightBlue" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 9), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeWhite" });

		// Cake/Icing Blocks
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), 'D', "dyeOrange" });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), 'D', "dyeMagenta" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), 'D', "dyeMagenta" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), 'D', "dyeMagenta" });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), 'D', "dyePink" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), 'D', "dyePink" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), 'D', "dyePink" });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), 'D', "dyeOrange" });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), 'D', "dyeOrange" });

		// Cookies to Cookie Rocks
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 7), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Items.COOKIE) });

		if (Config.PRESSURE || Config.RADIATION) {
			// Tier 1 - 4 Radiation Layers
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LCL", "LCL", 'L', "ingotLead", 'C', ExtraPlanets_Items.CLOTH });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', "ingotLead", 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', "ingotLead", 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', "ingotLead", 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER });

			// Tier 1 - 4 Pressure Layers
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "O O", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER });

			// Tier 1 - 4 UnPrepared Space Suits
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { "   ", "MMM", "M M", 'M', INGOT_ALUMINUM });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "M M", "MMM", "MMM", 'M', INGOT_ALUMINUM });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "M M", "M M", 'M', INGOT_ALUMINUM });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "   ", "M M", "M M", 'M', INGOT_ALUMINUM });

			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M', INGOT_TITANIUM, 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M', INGOT_TITANIUM, 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M', INGOT_TITANIUM, 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS });
			RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M', INGOT_TITANIUM, 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M', INGOT_PALLADIUM, 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M', INGOT_PALLADIUM, 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M', INGOT_PALLADIUM, 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M', INGOT_PALLADIUM, 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M', INGOT_ZINC, 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M', INGOT_ZINC, 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M', INGOT_ZINC, 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M', INGOT_ZINC, 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS });

			// Tier 1 - 4 Prepared Space Suits
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST,
					'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P',
					ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS,
					'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST,
					'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P',
					ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS,
					'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST,
					'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P',
					ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS,
					'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });

			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST,
					'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P',
					ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS,
					'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });

			// Tier 1 - 4 Gravity Boots
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
		}
		if (Config.RADIATION) {
			// Anti Radiation Drinks
			RecipeUtilities.addNBTRecipe(
					new ItemStack(ExtraPlanets_Items.ANTI_RADIATION, 1, 0),
					new ItemStack[] { new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE), COMPRESSED_MAGNESIUM, new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE),
							UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.CLEAN_WATER_FLUID), new ItemStack(Items.GLASS_BOTTLE),
							UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.CLEAN_WATER_FLUID), new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE), COMPRESSED_MAGNESIUM,
							new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE) });
			// Machines
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_SOLAR_EVAPORTATION_CHAMBER, 1, 0), new Object[] { "SBS", "MMM", "SBS", 'S', GCBlocks.solarPanel, 'M', ExtraPlanets_Items.COMPRESSED_MERCURY, 'B',
						new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });
			if (Config.BASIC_CRYSTALLIZER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_CRYSALLIZER, 1, 0), new Object[] { "SBS", "MMM", "SBS", 'S', Blocks.PISTON, 'M', COMPRESSED_CARBON, 'B', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });
			if (Config.BASIC_DECRYSTALLIZER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_DECRYSALLIZER, 1, 0), new Object[] { "SBS", "MCM", "SBS", 'S', ExtraPlanets_Items.IODIDE_SALT, 'M', COMPRESSED_CARBON, 'B',
						new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), 'C', ExtraPlanets_Machines.BASIC_CRYSALLIZER });
			if (Config.BASIC_SMASHER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_SMASHER, 1, 0), new Object[] { "MAM", "PPP", "MAM", 'P', Blocks.PISTON, 'M', ExtraPlanets_Items.COMPRESSED_MERCURY, 'A', Blocks.ANVIL });
			if (Config.BASIC_CHEMICAL_INJECTOR) {
				if (Config.CERES)
					RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_CHEMICAL_INJECTOR, 1, 0), new Object[] { "UUU", "PPP", "UUU", 'P', Blocks.PISTON, 'U', ExtraPlanets_Items.INGOT_URANIUM });
				else
					RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_CHEMICAL_INJECTOR, 1, 0), new Object[] { "UUU", "PPP", "UUU", 'P', Blocks.PISTON, 'U', ExtraPlanets_Items.POTASSIUM });
			}
			if (Config.BASIC_PURIFIER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_PURIFIER, 1, 0), new Object[] { "FMF", "ESE", "FMF", 'F', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), 'M', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 2), 'E',
						COMPRESSED_CARBON, 'S', GCBlocks.solarPanel });
			if (Config.BASIC_DENSIFIER)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_DENSIFIER, 1, 0), new Object[] { "FMF", "ESE", "FMF", 'F', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), 'M', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), 'E',
						COMPRESSED_CARBON, 'S', COMPRESSED_STEEL });
			if (Config.BASIC_DECONTAMINATION_UNIT)
				RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_DECONTAMINATION_UNIT, 1, 0), new Object[] { "EBV", "SFS", "VBE", 'F', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), 'S',
						new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 1), 'B', new ItemStack(Blocks.LAPIS_BLOCK, 1), 'V', INGOT_VOLCANIC, 'E', new ItemStack(ExtraPlanets_Items.BATTERY_MERCURY, 1, ExtraPlanets_Items.BATTERY_MERCURY.getMaxDamage()) });
		}

		// Oxygen Tanks
		if (Config.OXYGEN_TANKS) {
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY, 1, ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', GCItems.oxTankHeavy, 'Y', INGOT_PALLADIUM, 'Z',
					new ItemStack(Blocks.WOOL, 1, 11) });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY, 1, ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X',
					ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY, 'Y', INGOT_ZINC, 'Z', new ItemStack(Blocks.WOOL, 1, 4) });
		}

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLACK, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLACK.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 15) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_RED, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_RED.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 14) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GREEN, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GREEN.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 13) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BROWN, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BROWN.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 12) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLUE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLUE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PURPLE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PURPLE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 10) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_CYAN, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_CYAN.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 9) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_GRAY, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_GRAY.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 8) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GRAY, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GRAY.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 7) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PINK, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PINK.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 6) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_YELLOW, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_YELLOW.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 4) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_BLUE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_BLUE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 3) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_MAGENTA, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_MAGENTA.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 2) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_ORANGE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_ORANGE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 1) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_WHITE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_WHITE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', TIN_CANISTER, 'Y', "compressedCopper", 'Z',
				new ItemStack(Blocks.WOOL, 1, 0) });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_BLACK, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_BLACK.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 15) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_RED, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_RED.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 14) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_GREEN, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_GREEN.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 13) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_BROWN, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_BROWN.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 12) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_BLUE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_BLUE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_PURPLE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_PURPLE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 10) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_CYAN, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_CYAN.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 9) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_GRAY, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_GRAY.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 8) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_GRAY, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_GRAY.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 7) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_PINK, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_PINK.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 6) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_YELLOW, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_YELLOW.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 4) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_BLUE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_BLUE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 3) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_MAGENTA, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_MAGENTA.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 2) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_LIME, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_LIME.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 5) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_WHITE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_WHITE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', TIN_CANISTER, 'Y', "compressedTin", 'Z',
				new ItemStack(Blocks.WOOL, 1, 0) });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLACK, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLACK.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 15) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIME, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIME.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 5) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GREEN, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GREEN.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 13) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BROWN, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BROWN.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 12) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLUE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLUE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PURPLE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PURPLE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 10) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_CYAN, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_CYAN.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 9) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_GRAY, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_GRAY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel",
				'Z', new ItemStack(Blocks.WOOL, 1, 8) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GRAY, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GRAY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 7) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PINK, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PINK.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 6) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_YELLOW, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_YELLOW.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 4) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_BLUE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_BLUE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel",
				'Z', new ItemStack(Blocks.WOOL, 1, 3) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_MAGENTA, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_MAGENTA.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 2) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_ORANGE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_ORANGE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 1) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_WHITE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_WHITE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', TIN_CANISTER, 'Y', "compressedSteel", 'Z',
				new ItemStack(Blocks.WOOL, 1, 0) });

		// Decorative Blocks
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 1), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 0) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 2), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(Blocks.SNOW) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 3), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(Blocks.ICE) });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 5), new Object[] { "BSW", "SBS", "BSW", 'S', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2), 'B', "dyeWhite", 'W', "dyeWhite" });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 6), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 0) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 7), new Object[] { " FF", " FF", "   ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 6) });
		if (Config.JUPITER) {
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 4), new Object[] { "MMM", "MBM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK), 'B', Items.LAVA_BUCKET });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 8), new Object[] { "   ", "CC ", "CC ", 'C', INGOT_PALLADIUM });
		}
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 9), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.FROZEN_NITROGEN) });
		if (Config.MERCURY) {
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 10), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK) });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 11), new Object[] { "   ", "FF ", "FF ", 'F', INGOT_CARBON });
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 15), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ASH_ROCK) });
		}
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 12), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 11) });
		if (Config.SATURN)
			RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 13), new Object[] { "   ", "FF ", "FF ", 'F', INGOT_MAGNESIUM });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 14), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 13) });

		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 0), new Object[] { " D ", "DBD", " D ", 'D', "dyeWhite", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 1), new Object[] { " D ", "DBD", " D ", 'D', "dyeOrange", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 2), new Object[] { " D ", "DBD", " D ", 'D', "dyeYellow", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 3), new Object[] { " D ", "DBD", " D ", 'D', "dyeLightBlue", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 4), new Object[] { " D ", "DBD", " D ", 'D', "dyeYellow", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeUtilities.addOreRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 5), new Object[] { " D ", "DBD", " D ", 'D', "dyeMagenta", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });

		// Kits
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankLight), 'P', new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankLight),
				'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", "   ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B',
				new ItemStack(AsteroidsItems.thermalPadding, 1, 1), 'C', new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankLight), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities
				.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankLight) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", "   ", 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B', new ItemStack(AsteroidsItems.thermalPadding, 1, 1),
				'C', new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3) });

		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "T T", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankMedium), 'P', new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankMedium),
				'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B',
				new ItemStack(VenusItems.thermalPaddingTier2, 1, 1), 'C', new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P',
				new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankMedium), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 4),
				new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankMedium) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B', new ItemStack(VenusItems.thermalPaddingTier2, 1, 1),
				'C', new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });

		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankHeavy), 'P', new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankHeavy),
				'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0),
				'B', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankHeavy), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities
				.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankHeavy) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });

		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'P', new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0),
				'B', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });

		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'P', new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0),
				'B', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY) });
		RecipeUtilities.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });
	}

	private static void registerCompressorRecipes() {
		if (Config.MERCURY) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0));
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_CARBON, INGOT_CARBON, INGOT_CARBON);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_4_HEAVY_PLATING, TIER_3_HEAVY_PLATING, COMPRESSED_CARBON, new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0),
					new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 3, 6), INGOT_CARBON, INGOT_CARBON, new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), INGOT_CARBON, INGOT_CARBON);
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(Items.DIAMOND), DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS, DIAMOND_SHARDS);
		}
		if (Config.JUPITER) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_PALLADIUM, INGOT_PALLADIUM, INGOT_PALLADIUM);
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_NICKEL, INGOT_NICKEL, INGOT_NICKEL);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_5_HEAVY_PLATING, TIER_4_HEAVY_PLATING, COMPRESSED_PALLADIUM, COMPRESSED_PALLADIUM, COMPRESSED_PALLADIUM, COMPRESSED_PALLADIUM, COMPRESSED_PALLADIUM);
		}
		if (Config.SATURN) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_MAGNESIUM, INGOT_MAGNESIUM, INGOT_MAGNESIUM);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_6_HEAVY_PLATING, TIER_5_HEAVY_PLATING, COMPRESSED_MAGNESIUM, new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), COMPRESSED_MAGNESIUM, COMPRESSED_MAGNESIUM, COMPRESSED_MAGNESIUM);
		}
		if (Config.URANUS) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_CRYSTAL, INGOT_CRYSTAL, INGOT_CRYSTAL);
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_REUBFORCIED_CRYSTAL, COMPRESSED_CRYSTAL, COMPRESSED_CRYSTAL);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_7_HEAVY_PLATING, TIER_6_HEAVY_PLATING, COMPRESSED_REUBFORCIED_CRYSTAL, new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), COMPRESSED_REUBFORCIED_CRYSTAL,
					COMPRESSED_REUBFORCIED_CRYSTAL, COMPRESSED_REUBFORCIED_CRYSTAL);
		}
		if (Config.NEPTUNE) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_ZINC, INGOT_ZINC, INGOT_ZINC);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_8_HEAVY_PLATING, TIER_7_HEAVY_PLATING, INGOT_ZINC, INGOT_ZINC, INGOT_ZINC, INGOT_ZINC, INGOT_ZINC);
		}
		if (Config.PLUTO) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_TUNGSTEN, INGOT_TUNGSTEN, INGOT_TUNGSTEN);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_9_HEAVY_PLATING, TIER_8_HEAVY_PLATING, COMPRESSED_TUNGSTEN, new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), COMPRESSED_TUNGSTEN, COMPRESSED_TUNGSTEN, COMPRESSED_TUNGSTEN);
		}
		if (Config.ERIS) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(COMPRESSED_DARK_IRON, INGOT_DARK_IRON, INGOT_DARK_IRON);
			GCRecipeUtilities.addCompresssorShapelessRecipe(TIER_10_HEAVY_PLATING, TIER_9_HEAVY_PLATING, COMPRESSED_DARK_IRON, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), COMPRESSED_DARK_IRON, COMPRESSED_DARK_IRON, COMPRESSED_DARK_IRON);
		}
		if (Config.KEPLER22B) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5));
		}
		// Tier 1 - 4 Armour Layers
		if (Config.PRESSURE || Config.RADIATION) {
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_ARMOR_LAYER, 1, 0), INGOT_ALUMINUM, INGOT_ALUMINUM, INGOT_ALUMINUM, INGOT_ALUMINUM);
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_ARMOR_LAYER, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(
					AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0));
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_ARMOR_LAYER, 1, 0), INGOT_PALLADIUM, INGOT_PALLADIUM, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), INGOT_PALLADIUM);
			GCRecipeUtilities.addCompresssorShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ARMOR_LAYER, 1, 0), INGOT_ZINC, INGOT_ZINC, new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), INGOT_ZINC);
		}
	}

	private static void registerCircuitFabricatorRecipes() {
		ItemStack silicon = new ItemStack(GCItems.basicItem, 1, 2);
		GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 0), new ItemStack[] { new ItemStack(Items.DIAMOND), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Blocks.REDSTONE_LAMP) });
		if (Config.MERCURY)
			GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 1), new ItemStack[] { INGOT_CARBON, silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.COMPARATOR) });
		GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 2), new ItemStack[] { new ItemStack(AsteroidsItems.basicItem, 1, 0), silicon, silicon, new ItemStack(Items.REDSTONE),
				new ItemStack(Blocks.REDSTONE_TORCH) });
		if (Config.JUPITER)
			GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 3), new ItemStack[] { RED_GEM, silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.REPEATER) });
		if (Config.NEPTUNE)
			GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 4), new ItemStack[] { BLUE_GEM, silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.REPEATER) });
		if (Config.URANUS)
			GCRecipeUtilities.addCircuitFabricatorRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 5), new ItemStack[] { WHITE_GEM, silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.REPEATER) });
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
			inputMap.put(INGOT_CARBON, 24);
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
			inputMap.put(INGOT_PALLADIUM, 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 3), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.JUPITER_SPACE_STATION_ID, Config.JUPITER_ID, inputMap);
		}
		if (Config.SATURN_SPACE_STATION && Config.SATURN) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(INGOT_MAGNESIUM, 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.SATURN_SPACE_STATION_ID, Config.SATURN_ID, inputMap);
		}
		if (Config.URANUS_SPACE_STATION && Config.URANUS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(INGOT_CRYSTAL, 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 5), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.URANUS_SPACE_STATION_ID, Config.URANUS_ID, inputMap);
		}
		if (Config.NEPTUNE_SPACE_STATION && Config.NEPTUNE) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(INGOT_ZINC, 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 4), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.NEPTUNE_SPACE_STATION_ID, Config.NEPTUNE_ID, inputMap);
		}
		if (Config.PLUTO_SPACE_STATION && Config.PLUTO) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(INGOT_TUNGSTEN, 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GCRecipeUtilities.addSpaceStationRecipe(Config.PLUTO_SPACE_STATION_ID, Config.PLUTO_ID, inputMap);
		}
		if (Config.ERIS_SPACE_STATION && Config.ERIS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(Items.IRON_INGOT, 24);
			inputMap.put(INGOT_DARK_IRON, 24);
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
}
