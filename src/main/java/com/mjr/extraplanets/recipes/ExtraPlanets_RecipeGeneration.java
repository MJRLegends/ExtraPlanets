package com.mjr.extraplanets.recipes;

import java.util.List;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;
import com.mjr.mjrlegendslib.recipe.RecipeDumper;

@SuppressWarnings("deprecation")
public class ExtraPlanets_RecipeGeneration {
	public static void generateConstants() {
		RecipeDumper.generateConstants();
	}

	public static void generate() {
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), new Object[] { "XXX", "XYX", 'X', new ItemStack(AsteroidsItems.basicItem, 1, 7), 'Y',
				new ItemStack(MarsItems.marsItemBasic, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), new Object[] { "XXX", "XYX", 'X', new ItemStack(AsteroidsItems.basicItem, 1, 7), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), new Object[] { "XXX", "XYX", 'X', new ItemStack(AsteroidsItems.basicItem, 1, 7), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 0), 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 5) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 1), 'Y', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), new Object[] { "XXX", "XYX", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), new Object[] { "XYX", "XXX", "XXX", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), new Object[] { "XXX", "XYX", "X X", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), new Object[] { "XYX", "X X", 'X',
				new ItemStack(ExtraPlanets_Items.THERMAL_CLOTH, 1, 2), 'Y', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });

		// Battery
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury/batteries", new ItemStack(ExtraPlanets_Items.BATTERY_MERCURY, 1, ExtraPlanets_Items.BATTERY_MERCURY.getMaxDamage()), new Object[] { " T ", "TRT", "TCT",
				'T', new ItemStack(ExtraPlanets_Items.COMPRESSED_MERCURY, 1, 0), 'R', "dustRedstone", 'C', Items.COAL });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 8),
				new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2) });

		// Block of Mercury
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });

		// Block to Mercury
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 9, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Tools.MERCURY_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Tools.MERCURY_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Tools.MERCURY_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Tools.MERCURY_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Tools.MERCURY_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Armor.MERCURY_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Armor.MERCURY_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Armor.MERCURY_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercurytools", new ItemStack(ExtraPlanets_Armor.MERCURY_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 1, 0) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Items.TIER_4_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3),
				'Y', Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y',
				new ItemStack(AsteroidsItems.basicItem, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 1), 'Z', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4) });

		// Block of Carbon
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });

		// Block to Carbon
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Tools.CARBON_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Tools.CARBON_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Tools.CARBON_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Tools.CARBON_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Tools.CARBON_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 'S',
				"stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Armor.CARBON_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Armor.CARBON_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Armor.CARBON_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "carbontools", new ItemStack(ExtraPlanets_Armor.CARBON_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });

		// Slab's & Stairs

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercuryslabsandstairs", new ItemStack(ExtraPlanets_Blocks.MERCURY_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercuryslabsandstairs", new ItemStack(ExtraPlanets_Blocks.MERCURY_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercuryslabsandstairs", new ItemStack(ExtraPlanets_Blocks.MERCURY_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercuryslabsandstairs", new ItemStack(ExtraPlanets_Blocks.MERCURY_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 8) });

		// Nuclear Bomb
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceres", new ItemStack(ExtraPlanets_Blocks.NUCLEAR_BOMB), new Object[] { "GSG", "SUS", "GSG", 'G', Items.GUNPOWDER, 'S', Blocks.SAND, 'U',
				new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, OreDictionary.WILDCARD_VALUE) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceres", new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 2) });

		// Block of Uranium
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceres", new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });

		// Block to Uranium
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "ceres", new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 9, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Tools.URANIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Tools.URANIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Tools.URANIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Tools.URANIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Tools.URANIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Armor.URANIUM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Armor.URANIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Armor.URANIUM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uraniumtools", new ItemStack(ExtraPlanets_Armor.URANIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 1, 0) });

		// Slab's & Stairs

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceresslabsandstairs", new ItemStack(ExtraPlanets_Blocks.CERES_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceresslabsandstairs", new ItemStack(ExtraPlanets_Blocks.CERES_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceresslabsandstairs", new ItemStack(ExtraPlanets_Blocks.CERES_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "ceresslabsandstairs", new ItemStack(ExtraPlanets_Blocks.CERES_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 8) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3),
				'Y', Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 11), 'Z', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 9),
				new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 2) });

		// Block of Palladium
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });

		// Block of Red Gem
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });

		// Block to Palladium
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8) });

		// Block to Red Gem
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 8), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12) });

		// Block of Nickel
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 13), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7) });

		// Block to Nickel
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 13) });

		// Orange Sand to Orange Sandstone
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE, 1, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0),
				new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 1, 0) });

		// Ash Block to Ash Shards
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 2, 10), new Object[] { new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0),
				new ItemStack(ExtraPlanets_Blocks.ASH_ROCK, 1, 0) });

		// Ash Shards to Ash
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 9), new Object[] { new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10),
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10) });

		// Volcanic Ingot to Volcanic Shards
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 2, 11), new Object[] { new ItemStack(ExtraPlanets_Items.TOOLS, 1, 1),
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12),
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Tools.PALLADIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Tools.PALLADIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Tools.PALLADIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Tools.PALLADIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Tools.PALLADIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Armor.PALLASIUM_HELMET),
				new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Armor.PALLASIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Armor.PALLASIUM_LEGINGS),
				new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "palladiumtools", new ItemStack(ExtraPlanets_Armor.PALLASIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Tools.RED_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Tools.RED_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Tools.RED_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Tools.RED_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Tools.RED_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'S',
				"stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Armor.RED_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Armor.RED_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Armor.RED_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "redgemtools", new ItemStack(ExtraPlanets_Armor.RED_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8) });

		// Battery
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter/batteries", new ItemStack(ExtraPlanets_Items.BATTERY_NICKEL, 1, ExtraPlanets_Items.BATTERY_NICKEL.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6), 'R', "dustRedstone", 'C', Items.COAL });
		// Slab's & Stairs

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiterslabsandstairs", new ItemStack(ExtraPlanets_Blocks.JUPITER_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiterslabsandstairs", new ItemStack(ExtraPlanets_Blocks.JUPITER_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiterslabsandstairs", new ItemStack(ExtraPlanets_Blocks.JUPITER_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiterslabsandstairs", new ItemStack(ExtraPlanets_Blocks.JUPITER_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 9) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Items.TIER_6_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y',
				Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 5), 'Z', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 2) });

		// Block of Magnesium
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });

		// Block to Magnesium
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7) });

		// Fire Bomb
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.FIRE_BOMB), new Object[] { "GZG", "SVS", "GZG", 'G', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM), 'S', Blocks.SAND,
				'Z', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10), 'V', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 11) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn_not_jupiter", new ItemStack(ExtraPlanets_Blocks.FIRE_BOMB), new Object[] { "GZG", "SLS", "GLG", 'G', new ItemStack(ExtraPlanets_Items.INGOT_URANIUM), 'S',
				Blocks.SAND, 'Z', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'L', "ingotLead" });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Tools.MAGNESIUM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Tools.MAGNESIUM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Tools.MAGNESIUM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Tools.MAGNESIUM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Tools.MAGNESIUM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Armor.MAGNESIUM_HELMET),
				new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Armor.MAGNESIUM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Armor.MAGNESIUM_LEGINGS),
				new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "magnesiumtools", new ItemStack(ExtraPlanets_Armor.MAGNESIUM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });

		// Slab's & Stairs

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturnslabsandstairs", new ItemStack(ExtraPlanets_Blocks.SATURN_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturnslabsandstairs", new ItemStack(ExtraPlanets_Blocks.SATURN_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturnslabsandstairs", new ItemStack(ExtraPlanets_Blocks.SATURN_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturnslabsandstairs", new ItemStack(ExtraPlanets_Blocks.SATURN_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 8) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Items.TIER_7_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y',
				Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 2), 'Z', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 4, 5), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 2) });

		// Block of Crystal
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });

		// Block of White Gem
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });

		// Block to White Gem
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8) });

		// Block to Crystal
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4) });

		// Dense Ice to Ice
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(ExtraPlanets_Blocks.DENSE_ICE, 1), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(Blocks.ICE, 1) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "uranus", new ItemStack(Blocks.ICE, 9), new Object[] { new ItemStack(ExtraPlanets_Blocks.DENSE_ICE, 1) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Tools.CRYSTAL_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Tools.CRYSTAL_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Tools.CRYSTAL_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Tools.CRYSTAL_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Tools.CRYSTAL_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Armor.CRYSTAL_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Armor.CRYSTAL_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Armor.CRYSTAL_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "crystaltools", new ItemStack(ExtraPlanets_Armor.CRYSTAL_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 5) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Tools.WHITE_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Tools.WHITE_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Tools.WHITE_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Tools.WHITE_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Tools.WHITE_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7),
				'S', "stickWood" });

		// Armour
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Armor.WHITE_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Armor.WHITE_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Armor.WHITE_GEM_LEGINGS),
				new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "whitegemtools", new ItemStack(ExtraPlanets_Armor.WHITE_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7) });

		// Slab's & Stairs

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranusslabsandstairs", new ItemStack(ExtraPlanets_Blocks.URANUS_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranusslabsandstairs", new ItemStack(ExtraPlanets_Blocks.URANUS_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranusslabsandstairs", new ItemStack(ExtraPlanets_Blocks.URANUS_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "uranusslabsandstairs", new ItemStack(ExtraPlanets_Blocks.URANUS_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 5) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Items.TIER_8_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3),
				'Y', Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 14), 'Z', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 8),
				new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 2) });

		// Block of Zinc
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });

		// Block of Blue Gem
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });

		// Block to Blue Gem
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 6), new Object[] { new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11) });

		// Block to Zinc
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Tools.BLUE_GEM_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Tools.BLUE_GEM_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Tools.BLUE_GEM_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Tools.BLUE_GEM_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Tools.BLUE_GEM_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Armor.BLUE_GEM_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Armor.BLUE_GEM_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Armor.BLUE_GEM_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluegemtools", new ItemStack(ExtraPlanets_Armor.BLUE_GEM_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Tools.ZINC_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Tools.ZINC_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Tools.ZINC_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Tools.ZINC_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Tools.ZINC_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'S',
				"stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Armor.ZINC_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Armor.ZINC_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Armor.ZINC_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "zinctools", new ItemStack(ExtraPlanets_Armor.ZINC_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });

		// Battery
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune/batteries", new ItemStack(ExtraPlanets_Items.BATTERY_ZINC, 1, ExtraPlanets_Items.BATTERY_ZINC.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R', "dustRedstone", 'C', Items.COAL });
		// Slab's & Stairs
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptuneslabsandstairs", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptuneslabsandstairs", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptuneslabsandstairs", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptuneslabsandstairs", new ItemStack(ExtraPlanets_Blocks.NEPTUNE_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 8) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Items.TIER_9_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y',
				Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 3), 'Z', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 2) });

		// Block of Tungsten
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });

		// Block to Tungsten
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "pluto", new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7) });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Tools.TUNGSTEN_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Tools.TUNGSTEN_AXE), new Object[] { "XX ", "XS ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Tools.TUNGSTEN_HOE), new Object[] { "XX ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Tools.TUNGSTEN_SWORD), new Object[] { " X ", " X ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5),
				'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Tools.TUNGSTEN_SHOVEL), new Object[] { " X ", " S ", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5),
				'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Armor.TUNGSTEN_HELMET), new Object[] { "   ", "MMM", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Armor.TUNGSTEN_CHEST), new Object[] { "M M", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Armor.TUNGSTEN_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "tungstentools", new ItemStack(ExtraPlanets_Armor.TUNGSTEN_BOOTS), new Object[] { "   ", "M M", "M M", 'M', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });

		// Slab's & Stairs

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "plutoslabsandstairs", new ItemStack(ExtraPlanets_Blocks.PLUTO_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "plutoslabsandstairs", new ItemStack(ExtraPlanets_Blocks.PLUTO_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "plutoslabsandstairs", new ItemStack(ExtraPlanets_Blocks.PLUTO_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "plutoslabsandstairs", new ItemStack(ExtraPlanets_Blocks.PLUTO_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 8) });

		// Rocket
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Items.TIER_10_NOSE_CONE, 1), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y',
				Blocks.REDSTONE_TORCH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y',
				new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 0), new Object[] { " YV", "XWX", "XZX", 'V', Blocks.STONE_BUTTON, 'W',
				new ItemStack(GCItems.canister, 1, 0), 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y', Items.FLINT_AND_STEEL, 'Z', GCItems.oxygenVent });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), new Object[] { "ZYZ", "ZWZ", "XVX", 'V', GCItems.oxygenVent, 'W',
				new ItemStack(GCItems.fuelCanister, 1, 1), 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 'Y', new ItemStack(Blocks.WOOL, 1, 9), 'Z', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 4, 8), new Object[] { "   ", "SS ", "SS ", 'S', new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 2) });

		// Block of Dark Iron
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 5) });

		// Block to Dark Iron
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "eris", new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7) });

		// Slab's & Stairs
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "erisslabsandstairs", new ItemStack(ExtraPlanets_Blocks.ERIS_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "erisslabsandstairs", new ItemStack(ExtraPlanets_Blocks.ERIS_SUB_SURFACE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "erisslabsandstairs", new ItemStack(ExtraPlanets_Blocks.ERIS_STONE_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "erisslabsandstairs", new ItemStack(ExtraPlanets_Blocks.ERIS_STONE_BRICKS_STAIRS, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M',
				new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 8) });

		// Stone Bricks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 4, 11), new Object[] { "   ", "SS ", "SS ", 'S',
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 1) });

		// Block of Nickel
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 14), new Object[] { "XXX", "XXX", "XXX", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5) });

		// Block to Nickel
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 9, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 14) });

		// Maple Wooden Planks
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 0) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 1), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 1) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 2), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 2) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 3), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 3) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 4), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 0) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 5), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 1) });

		// Planks to Sticks(4 Sticks per 2 Planks)
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 7), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 8), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 9), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 10), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 11), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 4, 12), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

		// Planks to Pressure Plates (4 Planks per 8 Pressure Plates)
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 8, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5),
				new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

		// Planks to Buttons (2 Planks per 4 Buttons)
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Blocks.WOODEN_BUTTON, 4, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

		// Planks to Doors (6 Planks per 4 Doors)
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.OAK_DOOR, 4, 0), new Object[] { "DD ", "DD ", "DD ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5) });

		// Planks to Signs (6 Planks per 6 Signs)
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 0), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 1), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 2), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 3), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 4), 'S',
				"stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(Items.SIGN, 6, 0), new Object[] { "DDD", "DDD", " S ", 'D', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 1, 5), 'S',
				"stickWood" });

		// Tools
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Tools.BLUE_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 'S', "stickWood" });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Tools.RED_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 'S', "stickWood" });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Tools.PURPLE_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 'S', "stickWood" });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Tools.YELLOW_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 'S', "stickWood" });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_PICKAXE), new Object[] { "XXX", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_AXE), new Object[] { "XX ", "XS ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_HOE), new Object[] { "XX ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_SWORD), new Object[] { " X ", " X ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Tools.GREEN_DIAMOND_SHOVEL), new Object[] { " X ", " S ", " S ", 'X',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 'S', "stickWood" });

		// Armour
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "bluediamondtools", new ItemStack(ExtraPlanets_Armor.BLUE_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "reddiamondtools", new ItemStack(ExtraPlanets_Armor.RED_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "purplediamondtools", new ItemStack(ExtraPlanets_Armor.PURPLE_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "yellowdiamondtools", new ItemStack(ExtraPlanets_Armor.YELLOW_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_HELMET), new Object[] { "   ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_CHEST), new Object[] { "M M", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_LEGINGS), new Object[] { "MMM", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "greendiamondtools", new ItemStack(ExtraPlanets_Armor.GREEN_DIAMOND_BOOTS), new Object[] { "   ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4) });

		// Red Sand to Red Sandstone
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE, 1, 0), new Object[] { new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0),
				new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0), new ItemStack(ExtraPlanets_Blocks.RED_SAND, 1, 0) });

		// Diamond Apples
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "customapples", new ItemStack(ExtraPlanets_Items.DIAMOND_APPLE, 1, 0),
				new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.DIAMOND, 1, 0), 'A', Items.APPLE });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "customapples", new ItemStack(ExtraPlanets_Items.DIAMOND_APPLE, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.DIAMOND_BLOCK, 1, 0), 'A',
				Items.APPLE });

		// Iron Apples
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "customapples", new ItemStack(ExtraPlanets_Items.IRON_APPLE, 1, 0),
				new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Items.IRON_INGOT, 1, 0), 'A', Items.APPLE });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "customapples", new ItemStack(ExtraPlanets_Items.IRON_APPLE, 1, 1), new Object[] { "DDD", "DAD", "DDD", 'D', new ItemStack(Blocks.IRON_BLOCK, 1, 0), 'A',
				Items.APPLE });

		// Machines
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "refinery_advanced", new ItemStack(ExtraPlanets_Machines.REFINERY_ADVANCED), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', GCBlocks.refinery, 'Z',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "refinery_ultimate", new ItemStack(ExtraPlanets_Machines.REFINERY_ULTIMATE), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', ExtraPlanets_Machines.REFINERY_ADVANCED, 'Z',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "refinery_ultimate_not_advanced", new ItemStack(ExtraPlanets_Machines.REFINERY_ULTIMATE), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', GCBlocks.refinery, 'Z',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "solarpanels", new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y', new ItemStack(GCBlocks.solarPanel, 1, 4), 'Z',
				new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "solarpanels", new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(ExtraPlanets_Machines.SOLAR_PANEL, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygencompressoradvanced", new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygencompressoradvanced", new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(GCBlocks.oxygenCompressor, 1, 4), 'Z', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygencompressorultimate", new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygencompressorultimate", new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ADVANCED, 1, 4), 'Z', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygencompressorultimate_not_advanced", new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 0), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygencompressorultimate_not_advanced", new ItemStack(ExtraPlanets_Machines.OXYGEN_COMPRESSOR_ULTIMATE, 1, 4), new Object[] { "ZYZ", "YZY", "ZYZ", 'Y',
				new ItemStack(GCBlocks.oxygenCompressor, 1, 4), 'Z', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "fuelloaderadvanced", new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ADVANCED), new Object[] { "XXX", "XZX", "WYW", 'W',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 7), 'Y', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 'Z', new ItemStack(GCBlocks.fuelLoader) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "fuelloaderultimate", new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE), new Object[] { "XXX", "XZX", "WYW", 'W',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'Y', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'Z',
				new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ADVANCED) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "fuelloaderultimate_not_advanced", new ItemStack(ExtraPlanets_Machines.FUEL_LOADER_ULTIMATE), new Object[] { "XXX", "XZX", "WYW", 'W',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'X', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'Y', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 'Z', new ItemStack(GCBlocks.fuelLoader) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "vehiclecharger", new ItemStack(ExtraPlanets_Machines.VEHICLE_CHARGER), new Object[] { "WXW", "WXW", "WXW", 'W', "ingotDesh", 'X',
				new ItemStack(GCItems.battery, 1, GCItems.battery.getMaxDamage()) });

		// Launch pads
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 0), new Object[] { "   ", "BBB", "III", 'I', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'B', new ItemStack(AsteroidsItems.basicItem, 1, 6) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 1), new Object[] { "   ", "BBB", "III", 'I',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'B', new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 2), new Object[] { "   ", "BBB", "III", 'I', new ItemStack(MarsItems.marsItemBasic, 1, 2), 'B', new ItemStack(MarsBlocks.marsBlock, 1, 8) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "kepler22b", new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 5, 3), new Object[] { "   ", "BBB", "III", 'I',
				new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 5), 'B', new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6) });

		List<ItemStack> items2 = OreDictionary.getOres("ingotLead");
		int count2 = items2.size();
		for (int k = 0; k <= count2; k++) {
			ItemStack item2;
			if (k == 0)
				item2 = new ItemStack(ExtraPlanets_Items.INGOT_LEAD);
			else
				item2 = items2.get(k - 1);
			RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "rovers", new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 0), new Object[] { "XWX", "WXW", "XWX", 'W', new ItemStack(MarsItems.marsItemBasic, 1, 3), 'X',
					item2 });
			RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "rovers", new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 1), new Object[] { "XWX", "WXW", "XWX", 'W', "ingotDesh", 'X', item2 });
		}
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "rovers", new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 2), new Object[] { " W ", "WXW", " W ", 'W', new ItemStack(MarsItems.marsItemBasic, 1, 3), 'X',
				new ItemStack(GCItems.partBuggy, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "rovers", new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), new Object[] { " W ", "WXW", " W ", 'W', "ingotDesh", 'X',
				new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 2) });
		// Can of Food
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "canned_food", new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 0), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.COOKED_PORKCHOP, Items.COOKED_PORKCHOP });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "canned_food", new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 1), new Object[] { new ItemStack(GCItems.canister, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 0) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "canned_food", new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 2), new Object[] { new ItemStack(GCItems.canister, 1, 0), new ItemStack(Items.COOKED_FISH, 1, 1), new ItemStack(Items.COOKED_FISH, 1, 1) });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "canned_food", new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 3), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.COOKED_CHICKEN, Items.COOKED_CHICKEN });
		RecipeDumper.addShapelessRecipeWithCondition(Constants.modID, "recipe_enabled", "canned_food", new ItemStack(ExtraPlanets_Items.CANNED_FOOD, 1, 4), new Object[] { new ItemStack(GCItems.canister, 1, 0), Items.COOKED_BEEF, Items.COOKED_BEEF });

		// Advanced & Ultimate Battery
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "batteries", new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, ExtraPlanets_Items.BATTERY_ADVANCED.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T',
				new ItemStack(AsteroidsItems.basicItem, 1, 6), 'R', new ItemStack(GCItems.battery, 1, GCItems.battery.getMaxDamage()), 'C', new ItemStack(MarsBlocks.marsBlock, 1, 8) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "batteries", new ItemStack(ExtraPlanets_Items.BATTERY_ULTIMATE, 1, ExtraPlanets_Items.BATTERY_ULTIMATE.getMaxDamage()), new Object[] { "WRB", "CPM", "TAZ", 'W',
				new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 7), 'R', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 11), 'B', new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 10), 'C',
				new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), 'P', new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8), 'M', new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7), 'T',
				new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 5), 'A', new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, ExtraPlanets_Items.BATTERY_ADVANCED.getMaxDamage()), 'Z', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "batteries", new ItemStack(ExtraPlanets_Items.BATTERY_MASSIVE, 1, ExtraPlanets_Items.BATTERY_MASSIVE.getMaxDamage()),
				new Object[] { "PPP", "ASA", "NNN", 'P', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), 'N', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6), 'S', Items.NETHER_STAR, 'A',
						new ItemStack(ExtraPlanets_Items.BATTERY_ADVANCED, 1, ExtraPlanets_Items.BATTERY_ADVANCED.getMaxDamage()) });

		// Cloth
		RecipeDumper.addShapelessRecipe(new ItemStack(ExtraPlanets_Items.CLOTH, 8, 0), new Object[] { new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL), new ItemStack(Blocks.WOOL) });

		// Gravity Controller
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1, 0), new Object[] { "RTR", "TCT", "RTR", 'T', new ItemStack(GCItems.basicItem, 1, 14), 'R',
				new ItemStack(GCItems.battery, 1, GCItems.battery.getMaxDamage()), 'C', new ItemStack(GCItems.itemBasicMoon, 1, 0) });

		// Sledge Hammer
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), new Object[] { "XXX", "YSY", " S ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12), 'Y',
				new ItemStack(GCItems.itemBasicMoon), 'S', "stickWood" });

		// Grinding Wheel
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Items.TOOLS, 1, 1), new Object[] { "ZXZ", "XHX", "ZXZ", 'X', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 10), 'H',
				new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), 'Z', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12) });

		// Mesh
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TOOLS, 1, 2), new Object[] { "SSS", "SSS", "SSS", 'S', Items.STRING });

		// Filter
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), new Object[] { "CPC", "MMM", "CPC", 'C', new ItemStack(ExtraPlanets_Items.CLOTH), 'P', Items.PAPER, 'M', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 2) });

		// Candy Cane
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 0), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeRed" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 1), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeGreen" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeBlue" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeCyan" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLightBlue" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeOrange" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeMagenta" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePink" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLime" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 7), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePurple" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 8), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeBrown" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS, 1, 9), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeBlack" });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 0), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeRed" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 1), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeGreen" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeBlue" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeCyan" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 2), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLightBlue" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeOrange" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeMagenta" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePink" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeLime" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 7), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyePurple" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 8), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeBrown" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CANDY_BLOCKS_HORIZONTAL, 1, 9), new Object[] { " D ", "DCD", " D ", 'C', ExtraPlanets_Blocks.CANDY_BLOCKS, 'D', "dyeBlack" });

		// Cake/Icing Blocks
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), 'D', "dyeRed" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), 'D', "dyeRed" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), 'D', "dyeRed" });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), 'D', "dyeGreen" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), 'D', "dyeGreen" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), 'D', "dyeGreen" });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), 'D', "dyePink" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), 'D', "dyePink" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), 'D', "dyePink" });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 3), 'D', "dyeOrange" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 4), 'D', "dyeOrange" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 6), new Object[] { " D ", "DCD", " D ", 'C', new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 5), 'D', "dyeOrange" });

		// Cookies to Cookie Rocks
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.CAKE_BLOCKS, 1, 7), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Items.COOKIE) });

		// Tier 1 - 4 Radiation Layers
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LCL", "LCL", 'L', "ingotLead", 'C',
				ExtraPlanets_Items.CLOTH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', "ingotLead", 'C',
				ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_1_RADIATION_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', "ingotLead", 'C',
				ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_2_RADIATION_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 1, 0), new Object[] { "LCL", "LRL", "LCL", 'L', "ingotLead", 'C',
				ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_3_RADIATION_LAYER });

		// Tier 1 - 4 Pressure Layers
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "O O", "CCC", 'O', GCItems.oxygenConcentrator, 'C',
				ExtraPlanets_Items.CLOTH });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C',
				ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C',
				ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 1, 0), new Object[] { "CCC", "ORO", "CCC", 'O', GCItems.oxygenConcentrator, 'C',
				ExtraPlanets_Items.CLOTH, 'R', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER });

		// Tier 1 - 4 UnPrepared Space Suits
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { "   ", "MMM", "M M", 'M', "ingotAluminum" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "M M", "MMM", "MMM", 'M', "ingotAluminum" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "M M", "M M", 'M', "ingotAluminum" });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "   ", "M M", "M M", 'M', "ingotAluminum" });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M',
				new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M',
				new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M',
				new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M',
				new ItemStack(AsteroidsItems.basicItem, 1, 0), 'R', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET, 1, 0), new Object[] { " R ", "MMM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST, 1, 0), new Object[] { "MRM", "MMM", "MMM", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "MMM", "MRM", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, 1, 0), new Object[] { " R ", "M M", "M M", 'M',
				new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'R', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS });

		// Tier 1 - 4 Prepared Space Suits
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_HELMET, 'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_CHEST, 'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_1_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, 'C', ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_1_ARMOR_LAYER });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_HELMET, 'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_CHEST, 'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_2_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, 'C', ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_2_ARMOR_LAYER });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_HELMET, 'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_CHEST, 'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_3_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, 'C', ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_3_ARMOR_LAYER });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_HELMET, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_HELMET, 'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_CHEST, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_CHEST, 'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_LEGINGS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, 'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS, 1, 0), new Object[] { "RAC", "RPC", "RAC", 'R',
				ExtraPlanets_Items.TIER_4_RADIATION_LAYER, 'P', ExtraPlanets_Items.TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, 'C', ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 'A', ExtraPlanets_Items.TIER_4_ARMOR_LAYER });

		// Tier 1 - 4 Gravity Boots
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R',
				ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS, 'G', new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_2_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R',
				ExtraPlanets_Armor.TIER_2_SPACE_SUIT_BOOTS, 'G', new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R',
				ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS, 'G', new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "pressureandradiation", new ItemStack(ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS, 1, 0), new Object[] { " G ", "GRG", " G ", 'R',
				ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS, 'G', new ItemStack(ExtraPlanets_Items.GRAVITY_CONTROLLER, 1) });

		// Anti Radiation Drinks TODO AUTOMATE CREATION
		// RecipeDumper.addNBTRecipe(
		// new ItemStack(ExtraPlanets_Items.ANTI_RADIATION, 1, 0),
		// new ItemStack[] { new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE), new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE),
		// UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.CLEAN_WATER_FLUID), new ItemStack(Items.GLASS_BOTTLE),
		// UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.CLEAN_WATER_FLUID), new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE),
		// new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE) });

		// Machines
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_SOLAR_EVAPORTATION_CHAMBER, 1, 0), new Object[] { "SBS", "MMM", "SBS", 'S', GCBlocks.solarPanel, 'M',
				ExtraPlanets_Items.COMPRESSED_MERCURY, 'B', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_CRYSALLIZER, 1, 0), new Object[] { "SBS", "MMM", "SBS", 'S', Blocks.PISTON, 'M',
				new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), 'B', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_DECRYSALLIZER, 1, 0), new Object[] { "SBS", "MCM", "SBS", 'S', ExtraPlanets_Items.IODIDE_SALT, 'M',
				new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), 'B', new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11), 'C', ExtraPlanets_Machines.BASIC_CRYSALLIZER });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_SMASHER, 1, 0), new Object[] { "MAM", "PPP", "MAM", 'P', Blocks.PISTON, 'M',
				ExtraPlanets_Items.COMPRESSED_MERCURY, 'A', Blocks.ANVIL });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation_ceres", new ItemStack(ExtraPlanets_Machines.BASIC_CHEMICAL_INJECTOR, 1, 0), new Object[] { "UUU", "PPP", "UUU", 'P', Blocks.PISTON, 'U',
				ExtraPlanets_Items.INGOT_URANIUM });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation_not_ceres", new ItemStack(ExtraPlanets_Machines.BASIC_CHEMICAL_INJECTOR, 1, 0), new Object[] { "UUU", "PPP", "UUU", 'P', Blocks.PISTON, 'U',
				ExtraPlanets_Items.POTASSIUM });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_PURIFIER, 1, 0), new Object[] { "FMF", "ESE", "FMF", 'F', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), 'M',
				new ItemStack(ExtraPlanets_Items.TOOLS, 1, 2), 'E', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), 'S', GCBlocks.solarPanel });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_DENSIFIER, 1, 0), new Object[] { "FMF", "ESE", "FMF", 'F', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3),
				'M', new ItemStack(ExtraPlanets_Items.TOOLS, 1, 0), 'E', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4), 'S', new ItemStack(GCItems.basicItem, 1, 9) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "radiation", new ItemStack(ExtraPlanets_Machines.BASIC_DECONTAMINATION_UNIT, 1, 0), new Object[] { "EBV", "SFS", "VBE", 'F',
				new ItemStack(ExtraPlanets_Items.TOOLS, 1, 3), 'S', new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 1), 'B', new ItemStack(Blocks.LAPIS_BLOCK, 1), 'V', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12), 'E',
				new ItemStack(ExtraPlanets_Items.BATTERY_MERCURY, 1, ExtraPlanets_Items.BATTERY_MERCURY.getMaxDamage()) });

		// Oxygen Tanks
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY, 1, ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY.getMaxDamage()), new Object[] { "ZZZ", "XXX",
				"YYY", 'X', GCItems.oxTankHeavy, 'Y', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5), 'Z', new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY, 1, ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY.getMaxDamage()), new Object[] {
				"ZZZ", "XXX", "YYY", 'X', ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY, 'Y', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 5), 'Z', new ItemStack(Blocks.WOOL, 1, 4) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLACK, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLACK.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 15) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_RED, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_RED.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 14) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GREEN, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GREEN.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 13) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BROWN, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BROWN.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 12) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLUE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_BLUE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PURPLE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PURPLE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 10) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_CYAN, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_CYAN.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 9) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_GRAY, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_GRAY.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 8) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GRAY, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_GRAY.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 7) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PINK, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_PINK.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 6) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_YELLOW, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_YELLOW.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 4) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_BLUE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_LIGHT_BLUE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 3) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_MAGENTA, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_MAGENTA.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 2) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_ORANGE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_ORANGE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 1) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.LIGHT_OXYGEN_TANK_WHITE, 1, ExtraPlanets_Items.LIGHT_OXYGEN_TANK_WHITE.getMaxDamage()), new Object[] { "Z", "X", "Y", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedCopper", 'Z', new ItemStack(Blocks.WOOL, 1, 0) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_BLACK, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_BLACK.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 15) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_RED, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_RED.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y', "compressedTin",
				'Z', new ItemStack(Blocks.WOOL, 1, 14) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_GREEN, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_GREEN.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 13) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_BROWN, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_BROWN.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 12) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_BLUE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_BLUE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_PURPLE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_PURPLE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 10) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_CYAN, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_CYAN.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 9) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_GRAY, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_GRAY.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 8) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_GRAY, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_GRAY.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 7) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_PINK, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_PINK.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 6) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_YELLOW, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_YELLOW.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 4) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_BLUE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_LIGHT_BLUE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 3) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_MAGENTA, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_MAGENTA.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 2) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_LIME, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_LIME.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 5) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.MED_OXYGEN_TANK_WHITE, 1, ExtraPlanets_Items.MED_OXYGEN_TANK_WHITE.getMaxDamage()), new Object[] { "ZZ", "XX", "YY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedTin", 'Z', new ItemStack(Blocks.WOOL, 1, 0) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLACK, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLACK.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 15) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIME, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIME.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 5) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GREEN, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GREEN.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 13) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BROWN, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BROWN.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 12) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLUE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_BLUE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 11) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PURPLE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PURPLE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 10) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_CYAN, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_CYAN.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 9) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_GRAY, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_GRAY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0),
				'Y', "compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 8) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GRAY, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_GRAY.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 7) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PINK, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_PINK.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 6) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_YELLOW, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_YELLOW.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 4) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_BLUE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_LIGHT_BLUE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0),
				'Y', "compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 3) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_MAGENTA, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_MAGENTA.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 2) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_ORANGE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_ORANGE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 1) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.HEAVY_OXYGEN_TANK_WHITE, 1, ExtraPlanets_Items.HEAVY_OXYGEN_TANK_WHITE.getMaxDamage()), new Object[] { "ZZZ", "XXX", "YYY", 'X', new ItemStack(GCItems.canister, 1, 0), 'Y',
				"compressedSteel", 'Z', new ItemStack(Blocks.WOOL, 1, 0) });

		// Decorative Blocks
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 1), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 2), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(Blocks.SNOW) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 3), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(Blocks.ICE) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 5), new Object[] { "BSW", "SBS", "BSW", 'S',
				new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 2), 'B', "dyeWhite", 'W', "dyeBlack" });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 6), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 0) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 7), new Object[] { " FF", " FF", "   ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 6) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 4), new Object[] { "MMM", "MBM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK),
				'B', Items.LAVA_BUCKET });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "jupiter", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 8),
				new Object[] { "   ", "CC ", "CC ", 'C', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 5) });

		RecipeDumper
				.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "neptune", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 9), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.FROZEN_NITROGEN) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 10), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 11), new Object[] { "   ", "FF ", "FF ", 'F',
				new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "mercury", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 15), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(ExtraPlanets_Blocks.ASH_ROCK) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 12), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 11) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "saturn", new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 13),
				new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 5) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 14), new Object[] { "   ", "FF ", "FF ", 'F', new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS, 1, 13) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 0), new Object[] { " D ", "DBD", " D ", 'D', "dyeWhite", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 1), new Object[] { " D ", "DBD", " D ", 'D', "dyeRed", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 2), new Object[] { " D ", "DBD", " D ", 'D', "dyeBlue", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 3), new Object[] { " D ", "DBD", " D ", 'D', "dyeLightBlue", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 4), new Object[] { " D ", "DBD", " D ", 'D', "dyeYellow", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2, 1, 5), new Object[] { " D ", "DBD", " D ", 'D', "dyeGreen", 'B', ExtraPlanets_Blocks.DECORATIVE_BLOCKS2 });

		// Kits
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankLight), 'P', new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(GCItems.oxTankLight), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", "   ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B',
				new ItemStack(AsteroidsItems.thermalPadding, 1, 1), 'C', new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankLight), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(GCItems.oxTankLight) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_1_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", "   ", 'A', new ItemStack(AsteroidsItems.thermalPadding, 1, 0), 'B', new ItemStack(AsteroidsItems.thermalPadding, 1, 1),
				'C', new ItemStack(AsteroidsItems.thermalPadding, 1, 2), 'D', new ItemStack(AsteroidsItems.thermalPadding, 1, 3) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankMedium), 'P', new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(GCItems.oxTankMedium), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B',
				new ItemStack(VenusItems.thermalPaddingTier2, 1, 1), 'C', new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P',
				new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankMedium), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(GCItems.oxTankMedium) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_2_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A', new ItemStack(VenusItems.thermalPaddingTier2, 1, 0), 'B',
				new ItemStack(VenusItems.thermalPaddingTier2, 1, 1), 'C', new ItemStack(VenusItems.thermalPaddingTier2, 1, 2), 'D', new ItemStack(VenusItems.thermalPaddingTier2, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });

		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankHeavy), 'P', new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 5), 'A', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(GCItems.oxTankHeavy), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19),
				'A', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", " S ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'F',
				new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(GCItems.oxTankHeavy), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipe(new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G', new ItemStack(GCItems.oxygenGear), 'T',
				new ItemStack(GCItems.oxTankHeavy) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_3_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 2), 'D',
				new ItemStack(ExtraPlanets_Items.TIER_3_THERMAL_PADDING, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'F', new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'P', new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 5), 'A',
				new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19),
				'A', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "T T", " S ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'F', new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_VERY_HEAVY), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_4_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 2), 'D',
				new ItemStack(ExtraPlanets_Items.TIER_4_THERMAL_PADDING, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });

		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 0), new Object[] { "MGF", "TAT", " P ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'F', new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'P', new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 5), 'A',
				new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 1), new Object[] { "M G", "TPT", "   ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 2), new Object[] { "FPA", "BCD", " S ", 'F', new ItemStack(GCItems.basicItem, 1, 19),
				'A', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 3), new Object[] { "MGF", "TPT", " S ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'F', new ItemStack(GCItems.basicItem, 1, 19), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY), 'S', new ItemStack(VenusItems.basicItem, 1, 0), 'P',
				new ItemStack(GCItems.parachute) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "oxygentanks", new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 4), new Object[] { "M G", "T T", "   ", 'M', new ItemStack(GCItems.oxMask), 'G',
				new ItemStack(GCItems.oxygenGear), 'T', new ItemStack(ExtraPlanets_Items.OXYGEN_TANK_EXTREMELY_HEAVY) });
		RecipeDumper.addShapedRecipeWithCondition(Constants.modID, "recipe_enabled", "thermalpadding", new ItemStack(ExtraPlanets_Items.TIER_5_EQUIPMENT_KIT, 1, 5), new Object[] { "ABC", " D ", " S ", 'A',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 0), 'B', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 1), 'C', new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 2), 'D',
				new ItemStack(ExtraPlanets_Items.TIER_5_THERMAL_PADDING, 1, 3), 'S', new ItemStack(VenusItems.basicItem, 1, 0) });
	}
}
