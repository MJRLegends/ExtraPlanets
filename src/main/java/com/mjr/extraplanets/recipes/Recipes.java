package com.mjr.extraplanets.recipes;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.armor.ExtraPlanetsArmor;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.items.ExtraPlanetsItems;
import com.mjr.extraplanets.items.tools.ExtraPlanetsTools;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

    public static void init() {
	registerRocketCraftingRecipes();
	registerFurnaceRecipes();
	registerCraftingRecipes();
	registerCompressorRecipes();
    }

    private static void registerRocketCraftingRecipes() {
	Tier4RocketRecipes.registerRocketCraftingRecipe();
	Tier5RocketRecipes.registerRocketCraftingRecipe();
	Tier6RocketRecipes.registerRocketCraftingRecipe();
	Tier7RocketRecipes.registerRocketCraftingRecipe();
	Tier8RocketRecipes.registerRocketCraftingRecipe();
    }

    private static void registerFurnaceRecipes() {
	if (Config.venus)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreCarbon, 0), new ItemStack(ExtraPlanetsItems.ingotCarbon), 0.0F);
	if (Config.jupiter)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OrePalladium, 0), new ItemStack(ExtraPlanetsItems.ingotPalladium),
		    0.0F);
	if (Config.saturn)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreMagnesium, 0), new ItemStack(ExtraPlanetsItems.ingotMagnesium),
		    0.0F);
	if (Config.uranus)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreCrystal, 0), new ItemStack(ExtraPlanetsItems.ingotCrystal), 0.0F);
	if (Config.mercury)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreMercury, 0), new ItemStack(ExtraPlanetsItems.ingotMercury), 0.0F);
	if (Config.jupiter)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreNickel, 0), new ItemStack(ExtraPlanetsItems.ingotNickel), 0.0F);
	if (Config.neptune)
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreZinc, 0), new ItemStack(ExtraPlanetsItems.ingotZinc), 0.0F);

	if (Config.mercury) {
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.mercuryOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0),
		    0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.mercuryOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.mercuryOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	if (Config.venus) {
	    GameRegistry
		    .addSmelting(new ItemStack(ExtraPlanetsBlocks.venusOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.venusOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.venusOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	if (Config.ceres) {
	    GameRegistry
		    .addSmelting(new ItemStack(ExtraPlanetsBlocks.ceresOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.ceresOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.ceresOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreUranium, 0), new ItemStack(ExtraPlanetsItems.ingotUranium), 0.0F);
	}
	if (Config.jupiter) {
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.jupiterOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0),
		    0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.jupiterOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.jupiterOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	if (Config.saturn) {
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.saturnOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0),
		    0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.saturnOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.saturnOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	if (Config.neptune) {
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.neptuneOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0),
		    0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.neptuneOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.neptuneOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	if (Config.pluto) {
	    GameRegistry
		    .addSmelting(new ItemStack(ExtraPlanetsBlocks.plutoOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.plutoOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.plutoOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	if (Config.eris) {
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.erisOreCopper, 0), OreDictionary.getOres("ingotCopper").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.erisOreTin, 0), OreDictionary.getOres("ingotTin").get(0), 0.0F);
	    GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.erisOreIron, 0), OreDictionary.getOres("ingotIron").get(0), 0.0F);
	}
	// GameRegistry.addSmelting(new ItemStack(ExtraPlanetsBlocks.OreZinc,
	// 0), new ItemStack(), 0.0F);
    }

    private static void registerCraftingRecipes() {
	if (Config.venus) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.noseConeTier4, 1), new Object[] { " Y ", " X ", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier4, 1, 0), 'Y', Blocks.redstone_torch });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.finTier4, 1), new Object[] { " Y ", "XYX", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier4, 1, 0), 'Y', new ItemStack(AsteroidsItems.basicItem, 1, 0) });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier4, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V',
		    Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier4, 1, 0), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier4, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V',
		    GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', ExtraPlanetsItems.heavyDutyPlateTier4, 'Y',
		    new ItemStack(Blocks.wool, 1, 1), 'Z', new ItemStack(ExtraPlanetsItems.compressedCarbon, 1) });
	}
	if (Config.jupiter) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.noseConeTier5, 1), new Object[] { " Y ", " X ", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier5, 1, 0), 'Y', Blocks.redstone_torch });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.finTier5, 1), new Object[] { " Y ", "XYX", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier5, 1, 0), 'Y',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier4, 1, 0) });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier5, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V',
		    Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier5, 1, 0), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier5, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V',
		    GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', ExtraPlanetsItems.heavyDutyPlateTier5, 'Y',
		    new ItemStack(Blocks.wool, 1, 11), 'Z', new ItemStack(ExtraPlanetsItems.compressedPalladium, 1) });
	}
	if (Config.saturn) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.noseConeTier6, 1), new Object[] { " Y ", " X ", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier6, 1, 0), 'Y', Blocks.redstone_torch });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.finTier6, 1), new Object[] { " Y ", "XYX", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier6, 1, 0), 'Y',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier5, 1, 0) });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier6, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V',
		    Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier6, 1, 0), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier6, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V',
		    GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', ExtraPlanetsItems.heavyDutyPlateTier6, 'Y',
		    new ItemStack(Blocks.wool, 1, 5), 'Z', new ItemStack(ExtraPlanetsItems.compressedMagnesium, 1) });
	}
	if (Config.uranus) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.noseConeTier7, 1), new Object[] { " Y ", " X ", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier7, 1, 0), 'Y', Blocks.redstone_torch });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.finTier7, 1), new Object[] { " Y ", "XYX", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier7, 1, 0), 'Y',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier6, 1, 0) });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier7, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V',
		    Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier7, 1, 0), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier7, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V',
		    GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', ExtraPlanetsItems.heavyDutyPlateTier7, 'Y',
		    new ItemStack(Blocks.wool, 1, 2), 'Z', new ItemStack(ExtraPlanetsItems.compressedCrystal, 1) });
	}
	if (Config.neptune) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.noseConeTier8, 1), new Object[] { " Y ", " X ", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier8, 1, 0), 'Y', Blocks.redstone_torch });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.finTier8, 1), new Object[] { " Y ", "XYX", "X X", 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier8, 1, 0), 'Y',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier7, 1, 0) });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier8, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V',
		    Blocks.stone_button, 'W', new ItemStack(GCItems.canister, 1, 0), 'X',
		    new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier8, 1, 0), 'Y', Items.flint_and_steel, 'Z', GCItems.oxygenVent });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.engineTier8, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V',
		    GCItems.oxygenVent, 'W', new ItemStack(GCItems.fuelCanister, 1, 1), 'X', ExtraPlanetsItems.heavyDutyPlateTier8, 'Y',
		    new ItemStack(Blocks.wool, 1, 2), 'Z', new ItemStack(ExtraPlanetsItems.compressedCrystal, 1) });
	}
	if (Config.carbonItems) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonPickaxe), new Object[] { "XXX", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCarbon, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonAxe), new Object[] { "XX ", "XS ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCarbon, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonHoe), new Object[] { "XX ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCarbon, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonSword), new Object[] { " X ", " X ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCarbon, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.carbonShovel), new Object[] { " X ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCarbon, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	}
	if (Config.palladiumItems) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumPickaxe), new Object[] { "XXX", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotPalladium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumAxe), new Object[] { "XX ", "XS ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotPalladium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumHoe), new Object[] { "XX ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotPalladium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumSword), new Object[] { " X ", " X ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotPalladium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.palladiumShovel), new Object[] { " X ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotPalladium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	}
	if (Config.magnesiumItems) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumPickaxe), new Object[] { "XXX", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotMagnesium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumAxe), new Object[] { "XX ", "XS ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotMagnesium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumHoe), new Object[] { "XX ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotMagnesium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumSword), new Object[] { " X ", " X ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotMagnesium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.magnesiumShovel), new Object[] { " X ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotMagnesium, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	}
	if (Config.crystalItems) {
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalPickaxe), new Object[] { "XXX", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCrystal, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalAxe), new Object[] { "XX ", "XS ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCrystal, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalHoe), new Object[] { "XX ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCrystal, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalSword), new Object[] { " X ", " X ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCrystal, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	    GameRegistry.addRecipe(new ItemStack(ExtraPlanetsTools.crystalShovel), new Object[] { " X ", " S ", " S ", 'X',
		    new ItemStack(ExtraPlanetsItems.ingotCrystal, 1, 0), 'S', Item.itemRegistry.getObject("stick") });
	}
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.zincBattery, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T',
		new ItemStack(ExtraPlanetsItems.compressedZinc, 1, 0), 'R', Items.redstone, 'C', Items.coal });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.nickelBattery, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T',
		new ItemStack(ExtraPlanetsItems.compressedNickel, 1, 0), 'R', Items.redstone, 'C', Items.coal });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsItems.mercuryBattery, 1, 0), new Object[] { " T ", "TRT", "TCT", 'T',
		new ItemStack(ExtraPlanetsItems.compressedMercury, 1, 0), 'R', Items.redstone, 'C', Items.coal });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonHelmet), new Object[] { "   ", "MMM", "M M", 'M',
		ExtraPlanetsItems.ingotCarbon });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonChest), new Object[] { "M M", "MMM", "MMM", 'M',
		ExtraPlanetsItems.ingotCarbon });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonLegings), new Object[] { "MMM", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotCarbon });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.carbonBoots), new Object[] { "   ", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotCarbon });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumHelmet), new Object[] { "   ", "MMM", "M M", 'M',
		ExtraPlanetsItems.ingotPalladium });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumChest), new Object[] { "M M", "MMM", "MMM", 'M',
		ExtraPlanetsItems.ingotPalladium });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumLegings), new Object[] { "MMM", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotPalladium });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.palladiumBoots), new Object[] { "   ", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotPalladium });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumHelmet), new Object[] { "   ", "MMM", "M M", 'M',
		ExtraPlanetsItems.ingotMagnesium });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumChest), new Object[] { "M M", "MMM", "MMM", 'M',
		ExtraPlanetsItems.ingotMagnesium });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumLegings), new Object[] { "MMM", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotMagnesium });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.magnesiumBoots), new Object[] { "   ", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotMagnesium });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalHelmet), new Object[] { "   ", "MMM", "M M", 'M',
		ExtraPlanetsItems.ingotCrystal });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalChest), new Object[] { "M M", "MMM", "MMM", 'M',
		ExtraPlanetsItems.ingotCrystal });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalLegings), new Object[] { "MMM", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotCrystal });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsArmor.crystalBoots), new Object[] { "   ", "M M", "M M", 'M',
		ExtraPlanetsItems.ingotCrystal });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.mercuryStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.mercuryStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.venusStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.venusStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.ceresStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.ceresStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.jupiterStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.jupiterStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.saturnStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.saturnStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.uranusStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.uranusStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.neptuneStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.neptuneStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.plutoStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.plutoStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.erisStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.erisStone });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.mercuryStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.mercuryStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.venusStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.venusStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.ceresStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.ceresStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.jupiterStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.jupiterStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.saturnStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.saturnStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.uranusStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.uranusStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.neptuneStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.neptuneStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.plutoStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.plutoStone });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.erisStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.erisStone });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.venusDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.veunsDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.jupiterDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.jupiterDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.saturnDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.saturnDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.uranusDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.uranusDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.neptuneDungeonBrickStoneBlockHalfSlab), new Object[] { "MMM", 'M',
		ExtraPlanetsBlocks.neptuneDungeonBrick });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.venusDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.veunsDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.jupiterDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.jupiterDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.saturnDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.saturnDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.uranusDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.uranusDungeonBrick });
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.neptuneDungeonBrickStoneStairs), new Object[] { "M  ", "MM ", "MMM", 'M',
		ExtraPlanetsBlocks.neptuneDungeonBrick });

	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.advancedRefinery), new Object[] { "ZYZ", 'Y', GCBlocks.refinery, 'Z', new ItemStack(ExtraPlanetsItems.compressedZinc, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.solarPanel, 1, 0), new Object[] { "ZYZ", 'Y', new ItemStack(GCBlocks.solarPanel, 1, 4), 'Z', new ItemStack(ExtraPlanetsItems.compressedMagnesium, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(ExtraPlanetsBlocks.solarPanel, 1, 4), new Object[] { "ZYZ", 'Y', new ItemStack(ExtraPlanetsBlocks.solarPanel, 1, 0), 'Z', new ItemStack(ExtraPlanetsItems.compressedCrystal, 1, 0)});
    }

    private static void registerCompressorRecipes() {
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedCarbon, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotCarbon, 1, 0), new ItemStack(ExtraPlanetsItems.ingotCarbon, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedPalladium, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotPalladium, 1, 0), new ItemStack(ExtraPlanetsItems.ingotPalladium, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedMagnesium, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotMagnesium, 1, 0), new ItemStack(ExtraPlanetsItems.ingotMagnesium, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedCrystal, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotCrystal, 1, 0), new ItemStack(ExtraPlanetsItems.ingotCrystal, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedReinforcedCrystal, 1, 0), new ItemStack(
		ExtraPlanetsItems.compressedCrystal, 1, 0), new ItemStack(ExtraPlanetsItems.compressedCrystal, 1, 0));

	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedZinc, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotZinc, 1, 0), new ItemStack(ExtraPlanetsItems.ingotZinc, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedMercury, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotMercury, 1, 0), new ItemStack(ExtraPlanetsItems.ingotMercury, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.compressedNickel, 1, 0), new ItemStack(
		ExtraPlanetsItems.ingotNickel, 1, 0), new ItemStack(ExtraPlanetsItems.ingotNickel, 1, 0));

	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier4, 1, 0), new ItemStack(
		AsteroidsItems.basicItem, 1, 0), new ItemStack(ExtraPlanetsItems.compressedCarbon, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier5, 1, 0), new ItemStack(
		ExtraPlanetsItems.heavyDutyPlateTier4, 1, 0), new ItemStack(ExtraPlanetsItems.compressedPalladium, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier6, 1, 0), new ItemStack(
		ExtraPlanetsItems.heavyDutyPlateTier5, 1, 0), new ItemStack(ExtraPlanetsItems.compressedMagnesium, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier7, 1, 0), new ItemStack(
		ExtraPlanetsItems.heavyDutyPlateTier6, 1, 0), new ItemStack(ExtraPlanetsItems.compressedReinforcedCrystal, 1, 0));
	CompressorRecipes.addShapelessRecipe(new ItemStack(ExtraPlanetsItems.heavyDutyPlateTier8, 1, 0), new ItemStack(
		ExtraPlanetsItems.heavyDutyPlateTier7, 1, 0), new ItemStack(ExtraPlanetsItems.compressedZinc, 1, 0));

    }
}
