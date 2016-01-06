package com.mjr.extraplanets.recipes;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.armor.ExtraPlanetsArmor;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.ExtraPlanets_Machines;
import com.mjr.extraplanets.blocks.ExtraPlanets_SlabsStairsBlocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.tools.ExtraPlanetsTools;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Recipes {

	public static void init() {
		registerRocketCraftingRecipes();
		registerFurnaceRecipes();
		registerCraftingRecipes();
		registerCompressorRecipes();
	}

	private static void registerRocketCraftingRecipes() {
		if (Config.venus)
			Tier4RocketRecipes.registerRocketCraftingRecipe();
		if (Config.jupiter)
			Tier5RocketRecipes.registerRocketCraftingRecipe();
		if (Config.saturn)
			Tier6RocketRecipes.registerRocketCraftingRecipe();
		if (Config.uranus)
			Tier7RocketRecipes.registerRocketCraftingRecipe();
		if (Config.neptune)
			Tier8RocketRecipes.registerRocketCraftingRecipe();
		if (Config.pluto)
			Tier9RocketRecipes.registerRocketCraftingRecipe();
	}

	private static void registerFurnaceRecipes() {
		if (Config.mercury) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.mercuryBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.mercuryBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.mercuryBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.mercuryBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.ingotMercury), 0.0F);
		}
		if (Config.venus) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.venusBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.venusBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.venusBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.venusBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 0.0F);
		}
		if (Config.ceres) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ceresBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ceresBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ceresBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ceresBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.ingotUranium, 1), 0.0F);
		}
		if (Config.jupiter) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 0, 7), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 7), 0.0F);
		}
		if (Config.saturn) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.saturnBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.saturnBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.saturnBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.saturnBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), 0.0F);
		}
		if (Config.uranus) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.uranusBlocks, 3), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), 0.0F);
		}
		if (Config.neptune) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.neptuneBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.neptuneBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.neptuneBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.neptuneBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.tier8Items, 1, 5), 0.0F);
		}
		if (Config.pluto) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.plutoBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.plutoBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.plutoBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.plutoBlocks, 0, 6), new ItemStack(ExtraPlanets_Items.tier9Items, 1, 5), 0.0F);
		}
		if (Config.eris) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.erisBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.erisBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.erisBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}

		if (Config.callisto) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.callistoBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.callistoBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.callistoBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.deimos) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.deimosBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.deimosBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.deimosBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.europa) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.europaBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.europaBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.europaBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.ganymede) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ganymedeBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ganymedeBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ganymedeBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.io) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ioBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ioBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ioBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.phobos) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.phobosBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.phobosBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.phobosBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.triton) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.tritonBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.tritonBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.tritonBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.rhea) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.rheaBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.rheaBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.rheaBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
		if (Config.titan) {
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.titanBlocks, 0, 5), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.titanBlocks, 0, 4), OreDictionary.getOres("ingotTin").get(0), 0.0F);
			GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.titanBlocks, 0, 3), OreDictionary.getOres("ingotIron").get(0), 0.0F);
		}
	}

	private static void registerCraftingRecipes() {
		if (Config.mercury) {
			// Battery
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.mercuryBattery, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(ExtraPlanets_Items.compressedMercury, 1, 0), 'R', Items.redstone, 'C', Items.coal });

			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.mercuryStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.mercuryBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.mercuryStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.mercuryBlocks, 1, 2) });
		}
		if (Config.venus) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.noseConeTier4, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 'Y', Blocks.redstone_torch });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 'Y', new ItemStack(AsteroidsItems.basicItem, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 0),
					new Object[] { " YV", "XWX", "XZX", 'V', Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 'Y', new ItemStack(Blocks.wool, 1, 1), 'Z',
				new ItemStack(ExtraPlanets_Items.tier4Items, 1, 4) });
			// Armour
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonHelmet), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonChest), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonLegings), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonBoots), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5) });

			// Tools
			if (Config.carbonItems) {
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonPickaxe), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonAxe), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonHoe), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonSword), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonShovel), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
			}

			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.venusStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.venusBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.venusStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.venusBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.venusDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M', ExtraPlanets_Blocks.veunsDungeonBrick });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.venusDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', ExtraPlanets_Blocks.veunsDungeonBrick });
		}
		if (Config.ceres) {
			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.ceresStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ceresBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.ceresStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ceresBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Blocks.nuclearBomb), new Object[] { "GSG", "SUS", "GSG", 'G', Items.gunpowder, 'S', Blocks.sand, 'U', new ItemStack(ExtraPlanets_Items.ingotUranium, 1, OreDictionary.WILDCARD_VALUE) });
		}
		if (Config.jupiter) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.noseConeTier5, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 'Y', Blocks.redstone_torch });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 0),
					new Object[] { " YV", "XWX", "XZX", 'V', Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 'Y', new ItemStack(Blocks.wool, 1, 11), 'Z',
				new ItemStack(ExtraPlanets_Items.tier5Items, 1, 4) });

			// Tools
			if (Config.palladiumItems) {
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumPickaxe), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumAxe), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumHoe), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumSword), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumShovel), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
			}

			// Battery
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.nickelBattery, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 6), 'R', Items.redstone, 'C', Items.coal });

			// Armour
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumHelmet), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumChest), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumLegings), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumBoots), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5) });

			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.jupiterStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.jupiterStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.jupiterBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.jupiterDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M', ExtraPlanets_Blocks.jupiterDungeonBrick });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.jupiterDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', ExtraPlanets_Blocks.jupiterDungeonBrick });

		}
		if (Config.saturn) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.noseConeTier6, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 'Y', Blocks.redstone_torch });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 0),
					new Object[] { " YV", "XWX", "XZX", 'V', Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 'Y', new ItemStack(Blocks.wool, 1, 5), 'Z',
				new ItemStack(ExtraPlanets_Items.tier6Items, 1, 4) });

			// Tools
			if (Config.magnesiumItems) {
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumPickaxe), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumAxe), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumHoe), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumSword), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumShovel), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
			}

			// Armour
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumHelmet), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumChest), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumLegings), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumBoots), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5) });

			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.saturnStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.saturnBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.saturnStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.saturnBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.saturnDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M', ExtraPlanets_Blocks.saturnDungeonBrick });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.saturnDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', ExtraPlanets_Blocks.saturnDungeonBrick });
		}
		if (Config.uranus) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.noseConeTier7, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 'Y', Blocks.redstone_torch });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 0),
					new Object[] { " YV", "XWX", "XZX", 'V', Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 'Y', new ItemStack(Blocks.wool, 1, 2), 'Z',
				new ItemStack(ExtraPlanets_Items.tier7Items, 1, 4) });
			// Tools
			if (Config.crystalItems) {
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalPickaxe), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalAxe), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalHoe), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalSword), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
				GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalShovel), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), 'S', Item.itemRegistry.getObject("stick") });
			}

			// Armour
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalHelmet), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalChest), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalLegings), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalBoots), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5) });

			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.uranusStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.uranusBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.uranusStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.uranusBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.uranusDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M', ExtraPlanets_Blocks.uranusDungeonBrick });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.uranusDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', ExtraPlanets_Blocks.uranusDungeonBrick });
		}
		if (Config.neptune) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.noseConeTier8, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 'Y', Blocks.redstone_torch });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 0),
					new Object[] { " YV", "XWX", "XZX", 'V', Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 'Y', new ItemStack(Blocks.wool, 1, 2), 'Z',
				new ItemStack(ExtraPlanets_Items.tier8Items, 1, 5) });

			// Battery
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.zincBattery, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 5), 'R', Items.redstone, 'C', Items.coal });

			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.neptuneStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.neptuneBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.neptuneStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.neptuneBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.neptuneDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M', ExtraPlanets_Blocks.neptuneDungeonBrick });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.neptuneDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', ExtraPlanets_Blocks.neptuneDungeonBrick });
		}
		if (Config.pluto) {
			// Rocket
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.noseConeTier9, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 'Y', Blocks.redstone_torch });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 'Y', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 0),
					new Object[] { " YV", "XWX", "XZX", 'V', Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 'Y', new ItemStack(Blocks.wool, 1, 2), 'Z',
				new ItemStack(ExtraPlanets_Items.tier9Items, 1, 4) });
			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.plutoStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.plutoBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.plutoStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.plutoBlocks, 1, 2) });
		}
		if (Config.eris) {
			// Slab's & Stairs
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.erisStoneBlockHalfSlab), new Object[] { "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.erisBlocks, 1, 2) });
			GameRegistry.addRecipe(new ItemStack(ExtraPlanets_SlabsStairsBlocks.erisStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.erisBlocks, 1, 2) });
		}

		// Diamond Apples
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.diamondApple, 1, 0), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.diamond, 1, 0), 'A', Items.apple });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Items.diamondApple, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.diamond_block, 1, 0), 'A', Items.apple });

		// Machines
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.advancedRefinery), new Object[] { "ZYZ", 'Y', GCBlocks.refinery, 'Z', new ItemStack(ExtraPlanets_Items.tier8Items, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.solarPanel, 1, 0), new Object[] { "ZYZ", 'Y', new ItemStack(GCBlocks.solarPanel, 1, 4), 'Z', new ItemStack(ExtraPlanets_Items.tier6Items, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(ExtraPlanets_Machines.solarPanel, 1, 4), new Object[] { "ZYZ", 'Y', new ItemStack(ExtraPlanets_Machines.solarPanel, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.tier7Items, 1, 4) });

		// Can of Food
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.cannedFood, 1, 0), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.cooked_porkchop, Items.cooked_porkchop });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.cannedFood, 1, 1), new Object[] { new ItemStack(GCItems.canister, 1, 0), new ItemStack(Items.cooked_fished, 1, 0), new ItemStack(Items.cooked_fished, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.cannedFood, 1, 2), new Object[] { new ItemStack(GCItems.canister, 1, 0), new ItemStack(Items.cooked_fished, 1, 1), new ItemStack(Items.cooked_fished, 1, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.cannedFood, 1, 3), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.cooked_chicken, Items.cooked_chicken });
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.cannedFood, 1, 4), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.cooked_beef, Items.cooked_beef });

		// Others
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 6, 15), new Object[] { new ItemStack(ExtraPlanets_Items.bodyParts, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 6, 15), new Object[] { new ItemStack(ExtraPlanets_Items.bodyParts, 1, 1) });
	}

	private static void registerCompressorRecipes() {
		if (Config.mercury) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.compressedMercury, 1, 0), new ItemStack(ExtraPlanets_Items.ingotMercury, 1, 0), new ItemStack(ExtraPlanets_Items.ingotMercury, 1, 0));
		}
		if (Config.venus) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(ExtraPlanets_Items.tier4Items, 1, 4));
		}
		if (Config.jupiter) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 6), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 7), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 7));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 4));
		}
		if (Config.saturn) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5), new ItemStack(ExtraPlanets_Items.tier6Items, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier6Items, 1, 4));
		}
		if (Config.uranus) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 6), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 4));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 6));
		}
		if (Config.neptune) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 5), new ItemStack(ExtraPlanets_Items.tier8Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier8Items, 1, 4));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier8Items, 1, 5));
		}
		if (Config.pluto) {
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 4), new ItemStack(ExtraPlanets_Items.tier9Items, 1, 5), new ItemStack(ExtraPlanets_Items.tier9Items, 1, 5));
			CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), new ItemStack(ExtraPlanets_Items.tier9Items, 1, 4));
		}
	}
}
