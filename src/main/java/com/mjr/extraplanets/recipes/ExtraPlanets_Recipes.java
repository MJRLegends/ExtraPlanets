package com.mjr.extraplanets.recipes;

import java.util.HashMap;
import java.util.List;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;

public class ExtraPlanets_Recipes {
	public static void init() {
		registerRocketCraftingRecipes();
		registerFurnaceRecipes();
		registerCraftingRecipes();
		registerCompressorRecipes();
		registerCircuitFabricatorRecipes();
		registerSatellitesRecipes();
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
		if (Config.ERIS && Config.KEPLER22B)
			Tier10ElectricRocketRecipes.registerRocketCraftingRecipe();
		if (Config.MARS_ROVER)
			MarsRoverRecipes.registerRoverCraftingRecipe();
		if (Config.VENUS_ROVER)
			VenusRoverRecipes.registerRoverCraftingRecipe();
	}

	private static void registerFurnaceRecipes() {
		if (Config.MERCURY) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 0.0F);
		}
		if (Config.CERES) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1), 0.0F);
		}
		if (Config.JUPITER) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 11), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 0.0F);
		}
		if (Config.SATURN) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 0.0F);
		}
		if (Config.URANUS) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 0.0F);
		}
		if (Config.NEPTUNE) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 0.0F);
		}
		if (Config.PLUTO) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 0.0F);
		}
		if (Config.ERIS) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5), 0.0F);
		}
		if (Config.CALLISTO) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.DEIMOS) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.EUROPA) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.GANYMEDE) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.IO) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.PHOBOS) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.TRITON) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.RHEA) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.TITAN) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.OBERON) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.TITANIA) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.IAPETUS) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 4), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 3), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 2), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 12), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 1), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 13), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), 0.0F);

			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 5), new ItemStack(Blocks.COAL_BLOCK, 1, 1), 0.0F);

			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 8), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 9), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 0.0F);
		}
		if (Config.ORE_LEAD_GENERATION)
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ORE_LEAD, 1, 0), OreDictionary.getOres("ingotLead").get(0), 0.0F);
	}

	public static void addRecipe(ItemStack result, Object[] obj) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
	}

	private static void registerCraftingRecipes() {
		if (Config.THERMAL_PADDINGS) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), new Object[] { "XXX", "XYX", 'X', new ItemStack(AsteroidsItems.basicItem, 1, 7), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), new Object[] { "XXX", "XYX", 'X', new ItemStack(AsteroidsItems.basicItem, 1, 7), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), new Object[] { "XXX", "XYX", 'X', new ItemStack(AsteroidsItems.basicItem, 1, 7), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
		}
		if (Config.MERCURY) {
			// Battery
			if (Config.BATTERIES)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_MERCURY, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), 'R', Items.REDSTONE, 'C', Items.COAL });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2) });

			// Block of Mercury
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });

			// Block to Mercury
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 9, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });

			if (Config.ITEMS_MERCURY) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MERCURY_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MERCURY_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
			}

			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y', new ItemStack(AsteroidsItems.basicItem, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 1), 'Z', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });

			// Block of Carbon
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });

			// Block to Carbon
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11) });

			if (Config.ITEMS_CARBON) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CARBON_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CARBON_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
			}
		}
		if (Config.CERES) {
			// Nuclear Bomb
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.NUCLEAR_BOMB), new Object[] { "GSG", "SUS", "GSG", 'G', Items.GUNPOWDER, 'S', Blocks.SAND, 'U', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, OreDictionary.WILDCARD_VALUE) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 2) });

			// Block of Uranium
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });

			// Block to Uranium
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 9, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7) });

			if (Config.ITEMS_URANIUM) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.URANIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.URANIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
			}
		}
		if (Config.JUPITER) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 11), 'Z', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 9), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 2) });

			// Block of Palladium
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });

			// Block of Red Gem
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });

			// Block to Palladium
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8) });

			// Block to Red Gem
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 8), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12) });

			// Orange Sand to Orange Sandstone
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE, 1, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0),
					new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0) });

			if (Config.ITEMS_PALLADIUM) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.PALLADIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PALLASIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
			}

			if (Config.ITEMS_GEM_RED) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.RED_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
			}

			// Battery
			if (Config.BATTERIES)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_NICKEL, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6), 'R', Items.REDSTONE, 'C', Items.COAL });
		}
		if (Config.SATURN) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 5), 'Z', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 2) });

			// Block of Magnesium
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });

			// Block to Magnesium
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7) });

			// Fire Bomb
			List<ItemStack> items = OreDictionary.getOres("ingotLead");
			int count = items.size();
			for (int j = 0; j <= count; j++) {
				ItemStack item;
				if (j == 0)
					item = new ItemStack(ExtraPlanets_Items.INGOT_LEAD);
				else
					item = items.get(j - 1);
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.FIRE_BOMB), new Object[] { "GZG", "SLS", "GLG", 'G', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM), 'S', Blocks.SAND, 'Z',
						new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'L', item });
			}

			if (Config.ITEMS_MAGNESIUM) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.MAGNESIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.MAGNESIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
			}
		}
		if (Config.URANUS) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 2), 'Z', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 4, 5), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 2) });

			// Block of Crystal
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });

			// Block of White Gem
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });

			// Block to White Gem
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8) });

			// Block to Crystal
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4) });

			if (Config.ITEMS_CRYSTAL) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.CRYSTAL_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.CRYSTAL_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
			}

			if (Config.ITEMS_GEM_WHITE) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.WHITE_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.WHITE_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
			}
		}
		if (Config.NEPTUNE) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 14), 'Z', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 2) });

			// Block of Zinc
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });

			// Block of Blue Gem
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });

			// Block to Blue Gem
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 6), new Object[] { new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11) });

			// Block to Zinc
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7) });

			if (Config.ITEMS_GEM_BLUE) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
			}

			if (Config.ITEMS_ZINC) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.ZINC_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.ZINC_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
			}

			// Battery
			if (Config.BATTERIES)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_ZINC, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R', Items.REDSTONE, 'C', Items.COAL });
		}
		if (Config.PLUTO) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 3), 'Z', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 2) });

			// Block of Tungsten
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });

			// Block to Tungsten
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7) });

			if (Config.ITEMS_TUNGSTEN) {
				// Tools
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S', Items.STICK });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Tools.TUNGSTEN_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S', Items.STICK });

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TUNGSTEN_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
			}
		}
		if (Config.ERIS) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y', Blocks.REDSTONE_TORCH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X',
					new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 9), 'Z', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4) });

			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 2) });

			// Block of Dark Iron
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5) });

			// Block to Dark Iron
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7) });
		}

		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			// Stone Bricks
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 4, 11), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 1) });

			// Maple Wooden Planks
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 1), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 2), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 3), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 4), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 1) });

			// Planks to Sticks(4 Sticks per 2 Planks)
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 8), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 9), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 10), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 11), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 12), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Pressure Plates (4 Planks per 8 Pressure Plates)
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5),
					new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Buttons (2 Planks per 4 Buttons)
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Doors (6 Planks per 4 Doors)
			GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
			GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
			GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

			// Planks to Signs (6 Planks per 6 Signs)
			GameRegistry.addRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), 'S', new ItemStack(Items.STICK) });
			GameRegistry.addRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), 'S', new ItemStack(Items.STICK) });
			GameRegistry.addRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), 'S', new ItemStack(Items.STICK) });
			GameRegistry.addRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), 'S', new ItemStack(Items.STICK) });
			GameRegistry.addRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), 'S', new ItemStack(Items.STICK) });
			GameRegistry.addRecipe(new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), 'S', new ItemStack(Items.STICK) });

			if (Config.ITEMS_KEPLER22B) {
				// Tools
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" }));

				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" }));

				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" }));

				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" }));

				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" }));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" }));

				// Armour
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });

				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });

				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });

				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });

				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
			}
		}
		if (Config.JUPITER || Config.KEPLER22B) {
			// Red Sand to Red Sandstone
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE, 1, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0),
					new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0) });
		}
		if (Config.CUSTOM_APPLES) {
			// Diamond Apples
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.DIAMOND_APPLE, 1, 0), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.DIAMOND, 1, 0), 'A', Items.APPLE });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.DIAMOND_APPLE, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.DIAMOND_BLOCK, 1, 0), 'A', Items.APPLE });

			// Iron Apples
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.IRON_APPLE, 1, 0), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.IRON_INGOT, 1, 0), 'A', Items.APPLE });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.IRON_APPLE, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.IRON_BLOCK, 1, 0), 'A', Items.APPLE });
		}

		// Machines
		if (Config.REFINERY_ADVANCED)
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.REFINERY_ADVANCED), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', GCBlocks.refinery, 'Z', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
		if (Config.REFINERY_ULTIMATE)
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.REFINERY_ULTIMATE), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', ExtraPlanets_Machines.REFINERY_ADVANCED, 'Z', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		if (Config.SOLAR_PANELS)
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.solarPanel, 1, 4), 'Z', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
		if (Config.SOLAR_PANELS)
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4) });
		if (Config.OXYGEN_COMPRESSOR_ADVANCED) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'Z',
					new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.oxygenCompressor, 1, 4), 'Z',
					new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		}
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 0), 'Z',
					new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 4), 'Z',
					new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		}
		if (Config.FUEL_LOADER_ADVANCED)
			addRecipe(new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ADVANCED), new Object[] { "XXX", "XZX", "WYW", 'W', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7), 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'Z', new ItemStack(GCBlocks.fuelLoader) });
		if (Config.FUEL_LOADER_ULTIMATE)
			addRecipe(new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE), new Object[] { "XXX", "XZX", "WYW", 'W', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'Z', new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ADVANCED) });

		// Launch pads
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 0), new Object[] { "   ", "BBB", "III", 'I', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'B', new ItemStack(AsteroidsItems.basicItem, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 1), new Object[] { "   ", "BBB", "III", 'I', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'B', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 2), new Object[] { "   ", "BBB", "III", 'I', new ItemStack(MarsItems.marsItemBasic, 1, 2), 'B', new ItemStack(MarsBlocks.marsBlock, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 3), new Object[] { "   ", "BBB", "III", 'I', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), 'B', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6) });

		// Vehicle Charger
		addRecipe(new ItemStack(ExtraPlanets_Machines.VEHICLE_CHARGER), new Object[] { "WXW", "WXW", "WXW", 'W', "ingotDesh", 'X', new ItemStack(GCItems.battery, 1, 1) });

		if (Config.MARS_ROVER || Config.VENUS_ROVER) {
			List<ItemStack> items = OreDictionary.getOres("ingotLead");
			int count = items.size();
			for (int j = 0; j <= count; j++) {
				ItemStack item;
				if (j == 0)
					item = new ItemStack(ExtraPlanets_Items.INGOT_LEAD);
				else
					item = items.get(j - 1);
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 0), new Object[] { "XWX", "WXW", "XWX", 'W', new ItemStack(MarsItems.marsItemBasic, 1, 3), 'X', item });
				addRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 1), new Object[] { "XWX", "WXW", "XWX", 'W', "ingotDesh", 'X', item });
			}
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 2), new Object[] { " W ", "WXW", " W ", 'W', new ItemStack(MarsItems.marsItemBasic, 1, 3), 'X', new ItemStack(GCItems.partBuggy, 1, 0) });
			addRecipe(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), new Object[] { " W ", "WXW", " W ", 'W', "ingotDesh", 'X', new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3) });
		}
		// Can of Food
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 0), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.COOKED_PORKCHOP, Items.COOKED_PORKCHOP });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 1), new Object[] { new ItemStack(GCItems.canister, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 2), new Object[] { new ItemStack(GCItems.canister, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 1), new ItemStack(Items.COOKED_FISH, 1, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 3), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.COOKED_CHICKEN, Items.COOKED_CHICKEN });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 4), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.COOKED_BEEF, Items.COOKED_BEEF });

		// Advanced & Ultimate Battery
		if (Config.BATTERIES) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, 0),
					new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(AsteroidsItems.basicItem, 1, 6), 'R', GCItems.battery, 'C', new ItemStack(MarsBlocks.marsBlock, 1, 8) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BATTERY_ULTIMATE, 1, 0), new Object[] { "WRB", "CPM", "TAZ", 'W', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 7), 'R',
					new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 11), 'B', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 10), 'C', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), 'P',
					new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8), 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7), 'T', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'A',
					new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		}
		// Cloth
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CLOTH, 8, 0), new Object[] { new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL) });

		// Gravity Controller
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1, 0), new Object[] { "RTR", "TCT", "RTR", 'T', new ItemStack(GCItems.basicItem, 1, 14), 'R', GCItems.battery, 'C', new ItemStack(GCItems.itemBasicMoon, 1, 0) });

		if (Config.PRESSURE || Config.RADIATION) {
			// Tier 1 - 4 Radiation Layers
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LCL", "LCL", 'L', OreDictionary.getOres("ingotLead").get(0), 'C', ExtraPlanets_Items.CLOTH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', OreDictionary.getOres("ingotLead").get(0), 'C', ExtraPlanets_Items.CLOTH, 'R',
					ExtraPlanets_Items.TIER_1_RADIATION_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', OreDictionary.getOres("ingotLead").get(0), 'C', ExtraPlanets_Items.CLOTH, 'R',
					ExtraPlanets_Items.TIER_2_RADIATION_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', OreDictionary.getOres("ingotLead").get(0), 'C', ExtraPlanets_Items.CLOTH, 'R',
					ExtraPlanets_Items.TIER_3_RADIATION_LAYER });

			// Tier 1 - 4 Pressure Layers
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C', ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER });

			// Tier 1 - 4 UnPrepared Space Suits
			addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { "   ", "MMM", "M M", 'M', "ingotAluminum" });
			addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "M M", "MMM", "MMM", 'M', "ingotAluminum" });
			addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "M M", "M M", 'M', "ingotAluminum" });
			addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "   ", "M M", "M M", 'M', "ingotAluminum" });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R',
					ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R',
					ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R',
					ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R',
					ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R',
					ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS });

			// Tier 1 - 4 Prepared Space Suits
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST, 'C',
					ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS,
					'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, 'C',
					ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST, 'C',
					ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS,
					'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, 'C',
					ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST, 'C',
					ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS,
					'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, 'C',
					ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });

			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET,
					'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST, 'C',
					ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS,
					'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R', ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, 'C',
					ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });

			// Tier 1 - 4 Gravity Boots
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 'G', new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R', ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS, 'G',
					new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
		}
		if (Config.RADIATION) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.ANTI_RADIATION, 1, 0), new Object[] { "PPP", "WGW", "PPP", 'P', ExtraPlanets_Items.POTASSIUM_IODIDE, 'W', ExtraPlanets_Items.BUCKET_CLEAN_WATER, 'G', Items.GLASS_BOTTLE });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BUCKET_CLEAN_WATER, 1, 0), new Object[] { "SSS", "SBS", "SSS", 'S', ExtraPlanets_Items.IODIDE_SALT, 'B', ExtraPlanets_Items.BUCKET_INFECTED_WATER });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.BUCKET_INFECTED_WATER, 1, 0), new Object[] { "SSS", "SBS", "SSS", 'S', ExtraPlanets_Items.IODIDE_SALT, 'B', ExtraPlanets_Items.BUCKET_RADIOACTIVE_WATER });
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_SOLAR_EVAPORTATION_CHAMBER, 1, 0), new Object[] { "SBS", "MMM", "SBS", 'S', GCBlocks.solarPanel, 'M', ExtraPlanets_Items.COMPRESSED_MERCURY, 'B',
						new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });
			if (Config.BASIC_CRYSTALLIZER)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_CRYSALLIZER, 1, 0), new Object[] { "SBS", "MMM", "SBS", 'S', Blocks.PISTON, 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), 'B',
						new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });
			if (Config.BASIC_DECRYSTALLIZER)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_DECRYSALLIZER, 1, 0), new Object[] { "SBS", "MCM", "SBS", 'S', ExtraPlanets_Items.IODIDE_SALT, 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), 'B',
						new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), 'C', ExtraPlanets_Machines.BASIC_CRYSALLIZER });
			if (Config.BASIC_SMASHER)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_SMASHER, 1, 0), new Object[] { "MAM", "PPP", "MAM", 'P', Blocks.PISTON, 'M', ExtraPlanets_Items.COMPRESSED_MERCURY, 'A', Blocks.ANVIL });
			if (Config.BASIC_CHEMICAL_INJECTOR)
				GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.BASIC_CHEMICAL_INJECTOR, 1, 0), new Object[] { "UUU", "PPP", "UUU", 'P', Blocks.PISTON, 'U', ExtraPlanets_Items.INGOT_URANIUM });
		}
		if (Config.OXYGEN_TANKS) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY, 1, ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', GCItems.oxTankHeavy, 'Y',
					new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'Z', new ItemStack(Blocks.WOOL, 1, 11) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY, 1, ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY,
					'Y', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'Z', new ItemStack(Blocks.WOOL, 1, 4) });
		}

		// Decorative Blocks
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 1), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 2), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(Blocks.SNOW) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 3), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(Blocks.ICE) });
		addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 5), new Object[] { "BSW", "SBS", "BSW", 'S', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2), 'B', "dyeWhite", 'W', "dyeBlack" });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 6), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 7), new Object[] { " FF", " FF", "   ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 6) });
		if (Config.JUPITER) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 4), new Object[] { "MMM", "MBM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK), 'B', new ItemStack(ExtraPlanets_Items.BUCKET_MAGMA) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 8), new Object[] { "   ", "CC ", "CC ", 'C', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
		}
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 9), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.FROZEN_NITROGEN) });
		if (Config.MERCURY) {
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 10), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 11), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 15), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ASH_ROCK) });
		}
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 12), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 11) });
		if (Config.SATURN)
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 13), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 14), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 13) });

		// Kits
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TTA", "BCD", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankLight), 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B', new ItemStack(AsteroidsItems.thermalPadding, 1, 1), 'C',
				new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankLight) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 2), new Object[] { "F A", "BCD", "   ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B',
				new ItemStack(AsteroidsItems.thermalPadding, 1, 1), 'C', new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankLight) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankLight) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", "   ", 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B', new ItemStack(AsteroidsItems.thermalPadding, 1, 1), 'C',
				new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3) });

		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TTA", "BCD", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankMedium), 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B', new ItemStack(VenusItems.thermalPaddingTier2, 1, 1), 'C',
				new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankMedium) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 2), new Object[] { "F A", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B',
				new ItemStack(VenusItems.thermalPaddingTier2, 1, 1), 'C', new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankMedium), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankMedium) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B', new ItemStack(VenusItems.thermalPaddingTier2, 1, 1), 'C',
				new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TTA", "BCD", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankHeavy), 'A', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankHeavy) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 2), new Object[] { "F A", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankHeavy), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(GCItems.oxTankHeavy) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TTA", "BCD", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'A', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 2), new Object[] { "F A", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TTA", "BCD", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'A', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 2), new Object[] { "F A", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), 'B',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), 'S',
				new ItemStack(VenusItems.basicItem, 1, 0) });
	}

	private static void registerCompressorRecipes() {
		if (Config.MERCURY) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4));
		}
		if (Config.JUPITER) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4));
		}
		if (Config.SATURN) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4));
		}
		if (Config.URANUS) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6));
		}
		if (Config.NEPTUNE) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5));
		}
		if (Config.PLUTO) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4));
		}
		if (Config.ERIS) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4));
		}
		if (Config.KEPLER22B) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5));
		}
		// Tier 1 - 4 Armour Layers
		if (Config.PRESSURE || Config.RADIATION) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_ARMOR_LAYER, 1, 0), "ingotAluminum", "ingotAluminum", "ingotAluminum", "ingotAluminum");
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_ARMOR_LAYER, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 0),
					new ItemStack(AsteroidsItems.basicItem, 1, 0));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_ARMOR_LAYER, 1, 0), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(
					ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.TIER_4_ARMOR_LAYER, 1, 0), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), new ItemStack(
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
			CircuitFabricatorRecipes.addRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 0), new ItemStack[] { new ItemStack(Items.DIAMOND), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Blocks.REDSTONE_LAMP) });
			if (Config.MERCURY)
				CircuitFabricatorRecipes.addRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 1), new ItemStack[] { new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), silicon, silicon, new ItemStack(Items.REDSTONE),
						new ItemStack(Items.COMPARATOR) });
			CircuitFabricatorRecipes.addRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 2), new ItemStack[] { new ItemStack(AsteroidsItems.basicItem, 1, 0), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Blocks.REDSTONE_TORCH) });
			if (Config.JUPITER)
				CircuitFabricatorRecipes.addRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 3),
						new ItemStack[] { new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.REPEATER) });
			if (Config.NEPTUNE)
				CircuitFabricatorRecipes.addRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 4),
						new ItemStack[] { new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.REPEATER) });
			if (Config.URANUS)
				CircuitFabricatorRecipes.addRecipe(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 5),
						new ItemStack[] { new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(Items.REPEATER) });
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
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.MERCURY_SPACE_STATION_ID, Config.MERCURY_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.VENUS_SPACE_STATION) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.VENUS_SPACE_STATION_ID, VenusModule.planetVenus.getDimensionID(), new SpaceStationRecipe(inputMap)));
		}
		if (Config.CERES_SPACE_STATION && Config.CERES) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put("ingotUranium", 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.CERES_SPACE_STATION_ID, Config.CERES_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.MARS_SPACE_STATION && MarsModule.planetMars != null) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.MARS_SPACE_STATION_ID, MarsModule.planetMars.getDimensionID(), new SpaceStationRecipe(inputMap)));
		}
		if (Config.JUPITER_SPACE_STATION && Config.JUPITER) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 3), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.JUPITER_SPACE_STATION_ID, Config.JUPITER_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.SATURN_SPACE_STATION && Config.SATURN) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.SATURN_SPACE_STATION_ID, Config.SATURN_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.URANUS_SPACE_STATION && Config.URANUS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 5), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.URANUS_SPACE_STATION_ID, Config.URANUS_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.NEPTUNE_SPACE_STATION && Config.NEPTUNE) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.WAFERS, 1, 4), 3);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.NEPTUNE_SPACE_STATION_ID, Config.NEPTUNE_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.PLUTO_SPACE_STATION && Config.PLUTO) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 24);
			inputMap.put(Items.IRON_INGOT, 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.PLUTO_SPACE_STATION_ID, Config.PLUTO_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.ERIS_SPACE_STATION && Config.ERIS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put("ingotTin", 32);
			inputMap.put("waferAdvanced", 1);
			inputMap.put(Items.IRON_INGOT, 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5), 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.ERIS_SPACE_STATION_ID, Config.ERIS_ID, new SpaceStationRecipe(inputMap)));
		}
		if (Config.KEPLER22B_SPACE_STATION && Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			inputMap = new HashMap<Object, Integer>();
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 24);
			inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 24);
			GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.KEPLER22B_SPACE_STATION_ID, Config.KEPLER22B_ID, new SpaceStationRecipe(inputMap)));
		}
	};
}
