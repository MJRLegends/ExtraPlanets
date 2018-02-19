package com.mjr.extraplanets.items;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.item.EnumExtendedInventorySlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.keys.ItemKeyT10;
import com.mjr.extraplanets.items.keys.ItemKeyT4;
import com.mjr.extraplanets.items.keys.ItemKeyT5;
import com.mjr.extraplanets.items.keys.ItemKeyT6;
import com.mjr.extraplanets.items.keys.ItemKeyT7;
import com.mjr.extraplanets.items.keys.ItemKeyT8;
import com.mjr.extraplanets.items.keys.ItemKeyT9;
import com.mjr.extraplanets.items.noseCones.Tier10NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier4NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier5NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier6NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier7NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier8NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier9NoseCone;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier10Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier11Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier4Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier5Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier6Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier7Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier8Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier9Items;
import com.mjr.extraplanets.items.rockets.ElectricRocket;
import com.mjr.extraplanets.items.rockets.Tier10Rocket;
import com.mjr.extraplanets.items.rockets.Tier4Rocket;
import com.mjr.extraplanets.items.rockets.Tier5Rocket;
import com.mjr.extraplanets.items.rockets.Tier6Rocket;
import com.mjr.extraplanets.items.rockets.Tier7Rocket;
import com.mjr.extraplanets.items.rockets.Tier8Rocket;
import com.mjr.extraplanets.items.rockets.Tier9Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicMarsRover;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier10Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier10ElectricRocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier4Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier5Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier6Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier7Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier8Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier9Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicVenusRover;
import com.mjr.extraplanets.items.thermalPadding.ItemThermalCloth;
import com.mjr.extraplanets.items.thermalPadding.ItemTier3ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier4ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier5ThermalPadding;
import com.mjr.extraplanets.items.vehicles.ItemMarsRover;
import com.mjr.extraplanets.items.vehicles.ItemVenusRover;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

public class ExtraPlanets_Items {
	public static Item TIER_4_ROCKET;
	public static Item TIER_5_ROCKET;
	public static Item TIER_6_ROCKET;
	public static Item TIER_7_ROCKET;
	public static Item TIER_8_ROCKET;
	public static Item TIER_9_ROCKET;
	public static Item TIER_10_ROCKET;
	public static Item TIER_10_ELECTRIC_ROCKET;

	public static Item TIER_4_SCHEMATIC;
	public static Item TIER_5_SCHEMATIC;
	public static Item TIER_6_SCHEMATIC;
	public static Item TIER_7_SCHEMATIC;
	public static Item TIER_8_SCHEMATIC;
	public static Item TIER_9_SCHEMATIC;
	public static Item TIER_10_SCHEMATIC;
	public static Item TIER_10_ELECTRIC_ROCKET_SCHEMATIC;

	public static Item TIER_4_NOSE_CONE;
	public static Item TIER_5_NOSE_CONE;
	public static Item TIER_6_NOSE_CONE;
	public static Item TIER_7_NOSE_CONE;
	public static Item TIER_8_NOSE_CONE;
	public static Item TIER_9_NOSE_CONE;
	public static Item TIER_10_NOSE_CONE;

	public static Item TIER_4_ITEMS;
	public static Item TIER_5_ITEMS;
	public static Item TIER_6_ITEMS;
	public static Item TIER_7_ITEMS;
	public static Item TIER_8_ITEMS;
	public static Item TIER_9_ITEMS;
	public static Item TIER_10_ITEMS;
	public static Item TIER_11_ITEMS;

	public static Item TIER_4_KEY;
	public static Item TIER_5_KEY;
	public static Item TIER_6_KEY;
	public static Item TIER_7_KEY;
	public static Item TIER_8_KEY;
	public static Item TIER_9_KEY;
	public static Item TIER_10_KEY;

	public static Item BATTERY_NICKEL;
	public static Item BATTERY_ZINC;
	public static Item BATTERY_MERCURY;
	public static Item BATTERY_ADVANCED;
	public static Item BATTERY_ULTIMATE;
	public static Item BATTERY_MASSIVE;

	public static Item OXYGEN_TANK_VERY_HEAVY;
	public static Item OXYGEN_TANK_EXTREMELY_HEAVY;

	public static Item CANNED_FOOD;
	public static Item DIAMOND_APPLE;
	public static Item IRON_APPLE;

	public static Item COMPRESSED_MERCURY;
	public static Item INGOT_URANIUM;
	public static Item INGOT_MERCURY;
	public static Item INGOT_LEAD;

	public static Item TOOLS;

	public static Item CLOTH;
	public static Item GRAVITY_CONTROLLER;

	public static Item TIER_1_PRESSURE_LAYER;
	public static Item TIER_2_PRESSURE_LAYER;
	public static Item TIER_3_PRESSURE_LAYER;
	public static Item TIER_4_PRESSURE_LAYER;

	public static Item TIER_1_RADIATION_LAYER;
	public static Item TIER_2_RADIATION_LAYER;
	public static Item TIER_3_RADIATION_LAYER;
	public static Item TIER_4_RADIATION_LAYER;

	public static Item TIER_1_ARMOR_LAYER;
	public static Item TIER_2_ARMOR_LAYER;
	public static Item TIER_3_ARMOR_LAYER;
	public static Item TIER_4_ARMOR_LAYER;

	public static Item THERMAL_CLOTH;

	public static Item TIER_3_THERMAL_PADDING;
	public static Item TIER_4_THERMAL_PADDING;
	public static Item TIER_5_THERMAL_PADDING;

	public static Item TIER_1_UNPREPARED_SPACE_SUIT_HELMET;
	public static Item TIER_1_UNPREPARED_SPACE_SUIT_CHEST;
	public static Item TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS;
	public static Item TIER_1_UNPREPARED_SPACE_SUIT_BOOTS;

	public static Item TIER_2_UNPREPARED_SPACE_SUIT_HELMET;
	public static Item TIER_2_UNPREPARED_SPACE_SUIT_CHEST;
	public static Item TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS;
	public static Item TIER_2_UNPREPARED_SPACE_SUIT_BOOTS;

	public static Item TIER_3_UNPREPARED_SPACE_SUIT_HELMET;
	public static Item TIER_3_UNPREPARED_SPACE_SUIT_CHEST;
	public static Item TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS;
	public static Item TIER_3_UNPREPARED_SPACE_SUIT_BOOTS;

	public static Item TIER_4_UNPREPARED_SPACE_SUIT_HELMET;
	public static Item TIER_4_UNPREPARED_SPACE_SUIT_CHEST;
	public static Item TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS;
	public static Item TIER_4_UNPREPARED_SPACE_SUIT_BOOTS;

	public static Item WAFERS;
	public static Item IODIDE_SALT;
	public static Item POTASSIUM_IODIDE;
	public static Item POTASSIUM;
	public static Item POTASH_SHARDS;
	public static Item ANTI_RADIATION;

	public static Item MARS_ROVER;
	public static Item VENUS_ROVER;

	public static Item MARS_ROVER_SCHEMATIC;
	public static Item VENUS_ROVER_SCHEMATIC;

	public static Item ELECTRIC_PARTS;

	public static Item TIER_1_EQUIPMENT_KIT;
	public static Item TIER_2_EQUIPMENT_KIT;
	public static Item TIER_4_EQUIPMENT_KIT;
	public static Item TIER_3_EQUIPMENT_KIT;
	public static Item TIER_5_EQUIPMENT_KIT;

	public static Item GEIGER_COUNTER;

	public static Item WHITE_SUGAR_CANE;

	public static Item CHOCOLATE_BAR;
	public static Item CARAMEL_BAR;

	public static Item LIGHT_OXYGEN_TANK_BLACK;
	public static Item LIGHT_OXYGEN_TANK_RED;
	public static Item LIGHT_OXYGEN_TANK_GREEN;
	public static Item LIGHT_OXYGEN_TANK_BROWN;
	public static Item LIGHT_OXYGEN_TANK_BLUE;
	public static Item LIGHT_OXYGEN_TANK_PURPLE;
	public static Item LIGHT_OXYGEN_TANK_CYAN;
	public static Item LIGHT_OXYGEN_TANK_LIGHT_GRAY;
	public static Item LIGHT_OXYGEN_TANK_GRAY;
	public static Item LIGHT_OXYGEN_TANK_PINK;
	public static Item LIGHT_OXYGEN_TANK_YELLOW;
	public static Item LIGHT_OXYGEN_TANK_LIGHT_BLUE;
	public static Item LIGHT_OXYGEN_TANK_MAGENTA;
	public static Item LIGHT_OXYGEN_TANK_ORANGE;
	public static Item LIGHT_OXYGEN_TANK_WHITE;

	public static Item MED_OXYGEN_TANK_BLACK;
	public static Item MED_OXYGEN_TANK_RED;
	public static Item MED_OXYGEN_TANK_GREEN;
	public static Item MED_OXYGEN_TANK_BROWN;
	public static Item MED_OXYGEN_TANK_BLUE;
	public static Item MED_OXYGEN_TANK_PURPLE;
	public static Item MED_OXYGEN_TANK_CYAN;
	public static Item MED_OXYGEN_TANK_LIGHT_GRAY;
	public static Item MED_OXYGEN_TANK_GRAY;
	public static Item MED_OXYGEN_TANK_PINK;
	public static Item MED_OXYGEN_TANK_YELLOW;
	public static Item MED_OXYGEN_TANK_LIGHT_BLUE;
	public static Item MED_OXYGEN_TANK_MAGENTA;
	public static Item MED_OXYGEN_TANK_LIME;
	public static Item MED_OXYGEN_TANK_WHITE;

	public static Item HEAVY_OXYGEN_TANK_BLACK;
	public static Item HEAVY_OXYGEN_TANK_LIME;
	public static Item HEAVY_OXYGEN_TANK_GREEN;
	public static Item HEAVY_OXYGEN_TANK_BROWN;
	public static Item HEAVY_OXYGEN_TANK_BLUE;
	public static Item HEAVY_OXYGEN_TANK_PURPLE;
	public static Item HEAVY_OXYGEN_TANK_CYAN;
	public static Item HEAVY_OXYGEN_TANK_LIGHT_GRAY;
	public static Item HEAVY_OXYGEN_TANK_GRAY;
	public static Item HEAVY_OXYGEN_TANK_PINK;
	public static Item HEAVY_OXYGEN_TANK_YELLOW;
	public static Item HEAVY_OXYGEN_TANK_LIGHT_BLUE;
	public static Item HEAVY_OXYGEN_TANK_MAGENTA;
	public static Item HEAVY_OXYGEN_TANK_ORANGE;
	public static Item HEAVY_OXYGEN_TANK_WHITE;

	public static void init() {
		initializeItems();
		registerItems();
		if (Config.ORE_DICTIONARY_INGOTS)
			OreDictionaryIngotsRegister();
		if (Config.ORE_DICTIONARY_OTHER)
			OreDictionaryItemsRegister();
		registerGearItems();
	}

	private static void initializeItems() {
		if (Config.MERCURY) {
			if (Config.BATTERIES)
				BATTERY_MERCURY = new ItemBasicBattery("mercury_battery", 100000f, 2);
			INGOT_MERCURY = new ItemBasicItem("ingot_mercury");
			COMPRESSED_MERCURY = new ItemMercuryCompressed("compressed_mercury");
			TIER_4_ROCKET = new Tier4Rocket("item_tier4_rocket");
			TIER_4_SCHEMATIC = new ItemSchematicTier4Rocket("schematic_tier4");
			TIER_4_NOSE_CONE = new Tier4NoseCone("nose_cone_tier4");
			TIER_4_ITEMS = new ItemTier4Items("tier4_items");
			TIER_4_KEY = new ItemKeyT4("T4key");
		}
		if (Config.CERES) {
			INGOT_URANIUM = new ItemBasicItem("ingot_uranium");
		}
		if (Config.JUPITER) {
			if (Config.BATTERIES)
				BATTERY_NICKEL = new ItemBasicBattery("nickel_battery", 85000f, 2);
			TIER_5_ROCKET = new Tier5Rocket("item_tier5_rocket");
			TIER_5_SCHEMATIC = new ItemSchematicTier5Rocket("schematic_tier5");
			TIER_5_NOSE_CONE = new Tier5NoseCone("nose_cone_tier5");
			TIER_5_ITEMS = new ItemTier5Items("tier5_items");
			TIER_5_KEY = new ItemKeyT5("T5key");
		}
		if (Config.SATURN) {
			TIER_6_ROCKET = new Tier6Rocket("item_tier6_rocket");
			TIER_6_SCHEMATIC = new ItemSchematicTier6Rocket("schematic_tier6");
			TIER_6_NOSE_CONE = new Tier6NoseCone("nose_cone_tier6");
			TIER_6_ITEMS = new ItemTier6Items("tier6_items");
			TIER_6_KEY = new ItemKeyT6("T6key");
		}
		if (Config.URANUS) {
			TIER_7_ROCKET = new Tier7Rocket("item_tier7_rocket");
			TIER_7_SCHEMATIC = new ItemSchematicTier7Rocket("schematic_tier7");
			TIER_7_NOSE_CONE = new Tier7NoseCone("nose_cone_tier7");
			TIER_7_ITEMS = new ItemTier7Items("tier7_items");
			TIER_7_KEY = new ItemKeyT7("T7key");
		}
		if (Config.NEPTUNE) {
			if (Config.BATTERIES)
				BATTERY_ZINC = new ItemBasicBattery("zinc_battery", 125000f, 2);
			TIER_8_ROCKET = new Tier8Rocket("item_tier8_rocket");
			TIER_8_SCHEMATIC = new ItemSchematicTier8Rocket("schematic_tier8");
			TIER_8_NOSE_CONE = new Tier8NoseCone("nose_cone_tier8");
			TIER_8_ITEMS = new ItemTier8Items("tier8_items");
			TIER_8_KEY = new ItemKeyT8("T8key");
		}
		if (Config.PLUTO) {
			TIER_9_ROCKET = new Tier9Rocket("item_tier9_rocket");
			TIER_9_SCHEMATIC = new ItemSchematicTier9Rocket("schematic_tier9");
			TIER_9_NOSE_CONE = new Tier9NoseCone("nose_cone_tier9");
			TIER_9_ITEMS = new ItemTier9Items("tier9_items");
			TIER_9_KEY = new ItemKeyT9("T9key");
		}
		if (Config.ERIS) {
			TIER_10_ROCKET = new Tier10Rocket("item_tier10_rocket");
			TIER_10_SCHEMATIC = new ItemSchematicTier10Rocket("schematic_tier10");
			TIER_10_NOSE_CONE = new Tier10NoseCone("nose_cone_tier10");
			TIER_10_ITEMS = new ItemTier10Items("tier10_items");
			TIER_10_KEY = new ItemKeyT10("T10key");
			if (Config.KEPLER22B) {
				TIER_10_ELECTRIC_ROCKET_SCHEMATIC = new ItemSchematicTier10ElectricRocket("schematic_tier10_electric_rocket");
			}
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			TIER_11_ITEMS = new ItemTier11Items("tier11_items");
		}
		if (Config.CUSTOM_APPLES) {
			DIAMOND_APPLE = new ItemAppleDiamond(8, 2.2F, false).setUnlocalizedName("apple_diamond");
			IRON_APPLE = new ItemAppleIron(4, 2.2F, false).setUnlocalizedName("apple_iron");
		}
		if (Config.THERMAL_PADDINGS) {
			THERMAL_CLOTH = new ItemThermalCloth("thermal_cloth");
			TIER_3_THERMAL_PADDING = new ItemTier3ThermalPadding("tier3_thermal_padding");
			TIER_4_THERMAL_PADDING = new ItemTier4ThermalPadding("tier4_thermal_padding");
			TIER_5_THERMAL_PADDING = new ItemTier5ThermalPadding("tier5_thermal_padding");
		}
		if (Config.BATTERIES) {
			BATTERY_ADVANCED = new ItemBasicBattery("advanced_battery", 150000f, 2);
			BATTERY_ULTIMATE = new ItemBasicBattery("ultimate_battery", 200000f, 2);
			BATTERY_MASSIVE = new ItemBasicBattery("massive_battery", 500000f, 2);
		}
		if (Config.OXYGEN_TANKS) {
			OXYGEN_TANK_VERY_HEAVY = new ItemCustomOxygenTank(8, "oxygen_tank_very_heavy_full");
			OXYGEN_TANK_EXTREMELY_HEAVY = new ItemCustomOxygenTank(10, "oxygen_tank_extremely_heavy_full");
		}
		if (Config.PRESSURE || Config.RADIATION) {
			TIER_1_PRESSURE_LAYER = new ItemBasicItem("tier1_pressure_layer");
			TIER_2_PRESSURE_LAYER = new ItemBasicItem("tier2_pressure_layer");
			TIER_3_PRESSURE_LAYER = new ItemBasicItem("tier3_pressure_layer");
			TIER_4_PRESSURE_LAYER = new ItemBasicItem("tier4_pressure_layer");

			TIER_1_RADIATION_LAYER = new ItemBasicItem("tier1_radiation_layer");
			TIER_2_RADIATION_LAYER = new ItemBasicItem("tier2_radiation_layer");
			TIER_3_RADIATION_LAYER = new ItemBasicItem("tier3_radiation_layer");
			TIER_4_RADIATION_LAYER = new ItemBasicItem("tier4_radiation_layer");

			TIER_1_ARMOR_LAYER = new ItemBasicItem("tier1_armor_layer");
			TIER_2_ARMOR_LAYER = new ItemBasicItem("tier2_armor_layer");
			TIER_3_ARMOR_LAYER = new ItemBasicItem("tier3_armor_layer");
			TIER_4_ARMOR_LAYER = new ItemBasicItem("tier4_armor_layer");

			TIER_1_UNPREPARED_SPACE_SUIT_HELMET = new ItemBasicItem("tier1_un_prepared_space_suit_helmet");
			TIER_1_UNPREPARED_SPACE_SUIT_CHEST = new ItemBasicItem("tier1_un_prepared_space_suit_chest");
			TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS = new ItemBasicItem("tier1_un_prepared_space_suit_legings");
			TIER_1_UNPREPARED_SPACE_SUIT_BOOTS = new ItemBasicItem("tier1_un_prepared_space_suit_boots");

			TIER_2_UNPREPARED_SPACE_SUIT_HELMET = new ItemBasicItem("tier2_un_prepared_space_suit_helmet");
			TIER_2_UNPREPARED_SPACE_SUIT_CHEST = new ItemBasicItem("tier2_un_prepared_space_suit_chest");
			TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS = new ItemBasicItem("tier2_un_prepared_space_suit_legings");
			TIER_2_UNPREPARED_SPACE_SUIT_BOOTS = new ItemBasicItem("tier2_un_prepared_space_suit_boots");

			TIER_3_UNPREPARED_SPACE_SUIT_HELMET = new ItemBasicItem("tier3_un_prepared_space_suit_helmet");
			TIER_3_UNPREPARED_SPACE_SUIT_CHEST = new ItemBasicItem("tier3_un_prepared_space_suit_chest");
			TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS = new ItemBasicItem("tier3_un_prepared_space_suit_legings");
			TIER_3_UNPREPARED_SPACE_SUIT_BOOTS = new ItemBasicItem("tier3_un_prepared_space_suit_boots");

			TIER_4_UNPREPARED_SPACE_SUIT_HELMET = new ItemBasicItem("tier4_un_prepared_space_suit_helmet");
			TIER_4_UNPREPARED_SPACE_SUIT_CHEST = new ItemBasicItem("tier4_un_prepared_space_suit_chest");
			TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS = new ItemBasicItem("tier4_un_prepared_space_suit_legings");
			TIER_4_UNPREPARED_SPACE_SUIT_BOOTS = new ItemBasicItem("tier4_un_prepared_space_suit_boots");
		}
		if (Config.RADIATION) {
			IODIDE_SALT = new ItemBasicItem("iodide_salt");
			POTASSIUM_IODIDE = new ItemBasicItem("potassium_iodide");
			POTASSIUM = new ItemBasicItem("potassium");
			POTASH_SHARDS = new ItemBasicItem("potash_shards");
			ANTI_RADIATION = new ItemBasicItem("anti_radiation");
		}
		if (Config.MARS_ROVER) {
			MARS_ROVER = new ItemMarsRover("mars_rover");
			MARS_ROVER_SCHEMATIC = new ItemSchematicMarsRover("schematic_mars_rover");
		}
		if (Config.VENUS_ROVER) {
			VENUS_ROVER = new ItemVenusRover("venus_rover");
			VENUS_ROVER_SCHEMATIC = new ItemSchematicVenusRover("schematic_venus_rover");
		}
		if (Config.MARS_ROVER || Config.VENUS_ROVER)
			ELECTRIC_PARTS = new ItemElectricParts("electric_parts");

		CANNED_FOOD = new ItemCannedFood("canned_food");
		WAFERS = new ItemWafers("wafer");
		INGOT_LEAD = new ItemBasicItem("ingot_lead");
		CLOTH = new ItemBasicItem("cloth");
		TOOLS = new ItemTools("tools");
		GRAVITY_CONTROLLER = new ItemBasicItem("gravity_controller");

		TIER_1_EQUIPMENT_KIT = new ItemBasicKit("tier1_kit", 1);
		TIER_2_EQUIPMENT_KIT = new ItemBasicKit("tier2_kit", 2);
		TIER_3_EQUIPMENT_KIT = new ItemBasicKit("tier3_kit", 3);
		TIER_4_EQUIPMENT_KIT = new ItemBasicKit("tier4_kit", 4);
		TIER_5_EQUIPMENT_KIT = new ItemBasicKit("tier5_kit", 5);
		if (Config.ERIS && Config.KEPLER22B)
			TIER_10_ELECTRIC_ROCKET = new ElectricRocket("item_tier10_electric_rocket");
		GEIGER_COUNTER = new ItemGeigerCounter("geiger_counter");
		WHITE_SUGAR_CANE = new ItemBlockSpecial(ExtraPlanets_Blocks.WHITE_SUGAR_CANE).setUnlocalizedName("white_sugar_cane_item").setCreativeTab(ExtraPlanets.ItemsTab);

		CHOCOLATE_BAR = new ItemFood(1, 0.3F, false).setCreativeTab(ExtraPlanets.ItemsTab).setUnlocalizedName("chocolate_bar");
		CARAMEL_BAR = new ItemFood(1, 0.25F, false).setCreativeTab(ExtraPlanets.ItemsTab).setUnlocalizedName("caramel_bar");

		LIGHT_OXYGEN_TANK_BLACK = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "black");
		LIGHT_OXYGEN_TANK_RED = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "red");
		LIGHT_OXYGEN_TANK_GREEN = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "green");
		LIGHT_OXYGEN_TANK_BROWN = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "brown");
		LIGHT_OXYGEN_TANK_BLUE = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "blue");
		LIGHT_OXYGEN_TANK_PURPLE = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "purple");
		LIGHT_OXYGEN_TANK_CYAN = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "cyan");
		LIGHT_OXYGEN_TANK_LIGHT_GRAY = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "light_gray");
		LIGHT_OXYGEN_TANK_GRAY = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "gray");
		LIGHT_OXYGEN_TANK_PINK = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "pink");
		LIGHT_OXYGEN_TANK_YELLOW = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "yellow");
		LIGHT_OXYGEN_TANK_LIGHT_BLUE = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "light_blue");
		LIGHT_OXYGEN_TANK_MAGENTA = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "magenta");
		LIGHT_OXYGEN_TANK_ORANGE = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "orange");
		LIGHT_OXYGEN_TANK_WHITE = new ItemCustomOxygenTank(1, "oxygen_tank_light_full_" + "white");

		MED_OXYGEN_TANK_BLACK = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "black");
		MED_OXYGEN_TANK_RED = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "red");
		MED_OXYGEN_TANK_GREEN = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "green");
		MED_OXYGEN_TANK_BROWN = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "brown");
		MED_OXYGEN_TANK_BLUE = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "blue");
		MED_OXYGEN_TANK_PURPLE = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "purple");
		MED_OXYGEN_TANK_CYAN = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "cyan");
		MED_OXYGEN_TANK_LIGHT_GRAY = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "light_gray");
		MED_OXYGEN_TANK_GRAY = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "gray");
		MED_OXYGEN_TANK_PINK = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "pink");
		MED_OXYGEN_TANK_YELLOW = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "yellow");
		MED_OXYGEN_TANK_LIGHT_BLUE = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "light_blue");
		MED_OXYGEN_TANK_MAGENTA = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "magenta");
		MED_OXYGEN_TANK_LIME = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "orange");
		MED_OXYGEN_TANK_WHITE = new ItemCustomOxygenTank(2, "oxygen_tank_med_full_" + "white");

		HEAVY_OXYGEN_TANK_BLACK = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "black");
		HEAVY_OXYGEN_TANK_LIME = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "lime");
		HEAVY_OXYGEN_TANK_GREEN = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "green");
		HEAVY_OXYGEN_TANK_BROWN = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "brown");
		HEAVY_OXYGEN_TANK_BLUE = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "blue");
		HEAVY_OXYGEN_TANK_PURPLE = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "purple");
		HEAVY_OXYGEN_TANK_CYAN = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "cyan");
		HEAVY_OXYGEN_TANK_LIGHT_GRAY = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "light_gray");
		HEAVY_OXYGEN_TANK_GRAY = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "gray");
		HEAVY_OXYGEN_TANK_PINK = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "pink");
		HEAVY_OXYGEN_TANK_YELLOW = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "yellow");
		HEAVY_OXYGEN_TANK_LIGHT_BLUE = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "light_blue");
		HEAVY_OXYGEN_TANK_MAGENTA = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "magenta");
		HEAVY_OXYGEN_TANK_ORANGE = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "orange");
		HEAVY_OXYGEN_TANK_WHITE = new ItemCustomOxygenTank(3, "oxygen_tank_heavy_full_" + "white");
	}

	private static void registerItems() {
		if (Config.MERCURY) {
			if (Config.BATTERIES)
				RegisterUtilities.registerItem(BATTERY_MERCURY, BATTERY_MERCURY.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(COMPRESSED_MERCURY, COMPRESSED_MERCURY.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(INGOT_MERCURY, INGOT_MERCURY.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_4_ROCKET, TIER_4_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_SCHEMATIC, TIER_4_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_NOSE_CONE, TIER_4_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_ITEMS, TIER_4_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_KEY, TIER_4_KEY.getUnlocalizedName().substring(5));
		}
		if (Config.CERES) {
			RegisterUtilities.registerItem(INGOT_URANIUM, INGOT_URANIUM.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerItem(TIER_5_ROCKET, TIER_5_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_5_SCHEMATIC, TIER_5_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_5_NOSE_CONE, TIER_5_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_5_ITEMS, TIER_5_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_5_KEY, TIER_5_KEY.getUnlocalizedName().substring(5));

			if (Config.BATTERIES)
				RegisterUtilities.registerItem(BATTERY_NICKEL, BATTERY_NICKEL.getUnlocalizedName().substring(5));
		}
		if (Config.SATURN) {
			RegisterUtilities.registerItem(TIER_6_ROCKET, TIER_6_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_6_SCHEMATIC, TIER_6_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_6_NOSE_CONE, TIER_6_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_6_ITEMS, TIER_6_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_6_KEY, TIER_6_KEY.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			RegisterUtilities.registerItem(TIER_7_ROCKET, TIER_7_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_7_SCHEMATIC, TIER_7_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_7_NOSE_CONE, TIER_7_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_7_ITEMS, TIER_7_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_7_KEY, TIER_7_KEY.getUnlocalizedName().substring(5));
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerItem(TIER_8_ROCKET, TIER_8_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_8_SCHEMATIC, TIER_8_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_8_NOSE_CONE, TIER_8_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_8_ITEMS, TIER_8_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_8_KEY, TIER_8_KEY.getUnlocalizedName().substring(5));
			if (Config.BATTERIES)
				RegisterUtilities.registerItem(BATTERY_ZINC, BATTERY_ZINC.getUnlocalizedName().substring(5));
		}
		if (Config.PLUTO) {
			RegisterUtilities.registerItem(TIER_9_ROCKET, TIER_9_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_9_SCHEMATIC, TIER_9_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_9_NOSE_CONE, TIER_9_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_9_ITEMS, TIER_9_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_9_KEY, TIER_9_KEY.getUnlocalizedName().substring(5));
		}
		if (Config.ERIS) {
			RegisterUtilities.registerItem(TIER_10_ROCKET, TIER_10_ROCKET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_10_SCHEMATIC, TIER_10_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_10_NOSE_CONE, TIER_10_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_10_ITEMS, TIER_10_ITEMS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_10_KEY, TIER_10_KEY.getUnlocalizedName().substring(5));
			if (Config.KEPLER22B) {
				RegisterUtilities.registerItem(TIER_10_ELECTRIC_ROCKET_SCHEMATIC, TIER_10_ELECTRIC_ROCKET_SCHEMATIC.getUnlocalizedName().substring(5));
			}
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterUtilities.registerItem(TIER_11_ITEMS, TIER_11_ITEMS.getUnlocalizedName().substring(5));
		}
		if (Config.CUSTOM_APPLES) {
			RegisterUtilities.registerItem(DIAMOND_APPLE, DIAMOND_APPLE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(IRON_APPLE, IRON_APPLE.getUnlocalizedName().substring(5));
		}
		if (Config.THERMAL_PADDINGS) {
			RegisterUtilities.registerItem(THERMAL_CLOTH, THERMAL_CLOTH.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_THERMAL_PADDING, TIER_3_THERMAL_PADDING.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_THERMAL_PADDING, TIER_4_THERMAL_PADDING.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_5_THERMAL_PADDING, TIER_5_THERMAL_PADDING.getUnlocalizedName().substring(5));
		}
		if (Config.BATTERIES) {
			RegisterUtilities.registerItem(BATTERY_ADVANCED, BATTERY_ADVANCED.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(BATTERY_ULTIMATE, BATTERY_ULTIMATE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(BATTERY_MASSIVE, BATTERY_MASSIVE.getUnlocalizedName().substring(5));
		}
		if (Config.OXYGEN_TANKS) {
			RegisterUtilities.registerItem(OXYGEN_TANK_VERY_HEAVY, OXYGEN_TANK_VERY_HEAVY.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(OXYGEN_TANK_EXTREMELY_HEAVY, OXYGEN_TANK_EXTREMELY_HEAVY.getUnlocalizedName().substring(5));
		}
		if (Config.PRESSURE || Config.RADIATION) {
			RegisterUtilities.registerItem(TIER_1_PRESSURE_LAYER, TIER_1_PRESSURE_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_2_PRESSURE_LAYER, TIER_2_PRESSURE_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_PRESSURE_LAYER, TIER_3_PRESSURE_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_PRESSURE_LAYER, TIER_4_PRESSURE_LAYER.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_1_RADIATION_LAYER, TIER_1_RADIATION_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_2_RADIATION_LAYER, TIER_2_RADIATION_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_RADIATION_LAYER, TIER_3_RADIATION_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_RADIATION_LAYER, TIER_4_RADIATION_LAYER.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_1_ARMOR_LAYER, TIER_1_ARMOR_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_2_ARMOR_LAYER, TIER_2_ARMOR_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_ARMOR_LAYER, TIER_3_ARMOR_LAYER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_ARMOR_LAYER, TIER_4_ARMOR_LAYER.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_HELMET, TIER_1_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_CHEST, TIER_1_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, TIER_1_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_HELMET, TIER_2_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_CHEST, TIER_2_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, TIER_2_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_HELMET, TIER_3_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_CHEST, TIER_3_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, TIER_3_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));

			RegisterUtilities.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_HELMET, TIER_4_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_CHEST, TIER_4_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, TIER_4_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.RADIATION) {
			RegisterUtilities.registerItem(IODIDE_SALT, IODIDE_SALT.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(POTASSIUM_IODIDE, POTASSIUM_IODIDE.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(POTASSIUM, POTASSIUM.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(POTASH_SHARDS, POTASH_SHARDS.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(ANTI_RADIATION, ANTI_RADIATION.getUnlocalizedName().substring(5));
		}
		if (Config.MARS_ROVER) {
			RegisterUtilities.registerItem(MARS_ROVER, MARS_ROVER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(MARS_ROVER_SCHEMATIC, MARS_ROVER_SCHEMATIC.getUnlocalizedName().substring(5));
		}
		if (Config.VENUS_ROVER) {
			RegisterUtilities.registerItem(VENUS_ROVER, VENUS_ROVER.getUnlocalizedName().substring(5));
			RegisterUtilities.registerItem(VENUS_ROVER_SCHEMATIC, VENUS_ROVER_SCHEMATIC.getUnlocalizedName().substring(5));
		}
		if (Config.MARS_ROVER || Config.VENUS_ROVER)
			RegisterUtilities.registerItem(ELECTRIC_PARTS, ELECTRIC_PARTS.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(CANNED_FOOD, CANNED_FOOD.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(WAFERS, WAFERS.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(INGOT_LEAD, INGOT_LEAD.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(CLOTH, CLOTH.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(TOOLS, TOOLS.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(GRAVITY_CONTROLLER, GRAVITY_CONTROLLER.getUnlocalizedName().substring(5));

		RegisterUtilities.registerItem(TIER_1_EQUIPMENT_KIT, TIER_1_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(TIER_2_EQUIPMENT_KIT, TIER_2_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(TIER_3_EQUIPMENT_KIT, TIER_3_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(TIER_4_EQUIPMENT_KIT, TIER_4_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(TIER_5_EQUIPMENT_KIT, TIER_5_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		if (Config.ERIS && Config.KEPLER22B)
			RegisterUtilities.registerItem(TIER_10_ELECTRIC_ROCKET, TIER_10_ELECTRIC_ROCKET.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(GEIGER_COUNTER, GEIGER_COUNTER.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(WHITE_SUGAR_CANE, WHITE_SUGAR_CANE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(CHOCOLATE_BAR, CHOCOLATE_BAR.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(CARAMEL_BAR, CARAMEL_BAR.getUnlocalizedName().substring(5));

		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_BLACK, LIGHT_OXYGEN_TANK_BLACK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_RED, LIGHT_OXYGEN_TANK_RED.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_GREEN, LIGHT_OXYGEN_TANK_GREEN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_BROWN, LIGHT_OXYGEN_TANK_BROWN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_BLUE, LIGHT_OXYGEN_TANK_BLUE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_PURPLE, LIGHT_OXYGEN_TANK_PURPLE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_CYAN, LIGHT_OXYGEN_TANK_CYAN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_LIGHT_GRAY, LIGHT_OXYGEN_TANK_LIGHT_GRAY.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_GRAY, LIGHT_OXYGEN_TANK_GRAY.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_PINK, LIGHT_OXYGEN_TANK_PINK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_YELLOW, LIGHT_OXYGEN_TANK_YELLOW.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_LIGHT_BLUE, LIGHT_OXYGEN_TANK_LIGHT_BLUE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_MAGENTA, LIGHT_OXYGEN_TANK_MAGENTA.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_ORANGE, LIGHT_OXYGEN_TANK_ORANGE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(LIGHT_OXYGEN_TANK_WHITE, LIGHT_OXYGEN_TANK_WHITE.getUnlocalizedName().substring(5));

		RegisterUtilities.registerItem(MED_OXYGEN_TANK_BLACK, MED_OXYGEN_TANK_BLACK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_RED, MED_OXYGEN_TANK_RED.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_GREEN, MED_OXYGEN_TANK_GREEN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_BROWN, MED_OXYGEN_TANK_BROWN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_BLUE, MED_OXYGEN_TANK_BLUE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_PURPLE, MED_OXYGEN_TANK_PURPLE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_CYAN, MED_OXYGEN_TANK_CYAN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_LIGHT_GRAY, MED_OXYGEN_TANK_LIGHT_GRAY.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_GRAY, MED_OXYGEN_TANK_GRAY.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_PINK, MED_OXYGEN_TANK_PINK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_YELLOW, MED_OXYGEN_TANK_YELLOW.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_LIGHT_BLUE, MED_OXYGEN_TANK_LIGHT_BLUE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_MAGENTA, MED_OXYGEN_TANK_MAGENTA.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_LIME, MED_OXYGEN_TANK_LIME.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(MED_OXYGEN_TANK_WHITE, MED_OXYGEN_TANK_WHITE.getUnlocalizedName().substring(5));

		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_BLACK, HEAVY_OXYGEN_TANK_BLACK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_LIME, HEAVY_OXYGEN_TANK_LIME.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_GREEN, HEAVY_OXYGEN_TANK_GREEN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_BROWN, HEAVY_OXYGEN_TANK_BROWN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_BLUE, HEAVY_OXYGEN_TANK_BLUE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_PURPLE, HEAVY_OXYGEN_TANK_PURPLE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_CYAN, HEAVY_OXYGEN_TANK_CYAN.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_LIGHT_GRAY, HEAVY_OXYGEN_TANK_LIGHT_GRAY.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_GRAY, HEAVY_OXYGEN_TANK_GRAY.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_PINK, HEAVY_OXYGEN_TANK_PINK.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_YELLOW, HEAVY_OXYGEN_TANK_YELLOW.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_LIGHT_BLUE, HEAVY_OXYGEN_TANK_LIGHT_BLUE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_MAGENTA, HEAVY_OXYGEN_TANK_MAGENTA.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_ORANGE, HEAVY_OXYGEN_TANK_ORANGE.getUnlocalizedName().substring(5));
		RegisterUtilities.registerItem(HEAVY_OXYGEN_TANK_WHITE, HEAVY_OXYGEN_TANK_WHITE.getUnlocalizedName().substring(5));
	}

	public static void OreDictionaryIngotsRegister() {
		if (Config.MERCURY) {
			RegisterUtilities.registerOre("ingotMercury", new ItemStack(INGOT_MERCURY));
			RegisterUtilities.registerOre("ingotCarbon", new ItemStack(TIER_4_ITEMS, 1, 5));
		}
		if (Config.CERES)
			RegisterUtilities.registerOre("ingotUranium", new ItemStack(INGOT_URANIUM));
		if (Config.JUPITER) {
			RegisterUtilities.registerOre("ingotPalladium", new ItemStack(TIER_5_ITEMS, 1, 5));
			RegisterUtilities.registerOre("ingotNickel", new ItemStack(TIER_5_ITEMS, 1, 7));
			RegisterUtilities.registerOre("gemRedGem", new ItemStack(TIER_5_ITEMS, 1, 8));
		}
		if (Config.SATURN)
			RegisterUtilities.registerOre("ingotMagnesium", new ItemStack(TIER_6_ITEMS, 1, 5));
		if (Config.URANUS) {
			RegisterUtilities.registerOre("ingotCrystal", new ItemStack(TIER_7_ITEMS, 1, 5));
			RegisterUtilities.registerOre("gemWhiteGem", new ItemStack(TIER_7_ITEMS, 1, 7));
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerOre("ingotZinc", new ItemStack(TIER_8_ITEMS, 1, 5));
			RegisterUtilities.registerOre("gemBlueGem", new ItemStack(TIER_8_ITEMS, 1, 6));
		}
		if (Config.PLUTO)
			RegisterUtilities.registerOre("ingotTungsten", new ItemStack(TIER_9_ITEMS, 1, 5));
		if (Config.ERIS)
			RegisterUtilities.registerOre("ingotDarkIron", new ItemStack(TIER_10_ITEMS, 1, 5));
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterUtilities.registerOre("gemBlueDiamond", new ItemStack(TIER_11_ITEMS, 1, 0));
			RegisterUtilities.registerOre("gemRedDiamond", new ItemStack(TIER_11_ITEMS, 1, 1));
			RegisterUtilities.registerOre("gemPurpleDiamond", new ItemStack(TIER_11_ITEMS, 1, 2));
			RegisterUtilities.registerOre("gemYellowDiamond", new ItemStack(TIER_11_ITEMS, 1, 3));
			RegisterUtilities.registerOre("gemGreenDiamond", new ItemStack(TIER_11_ITEMS, 1, 4));
			RegisterUtilities.registerOre("ingotPlatinum", new ItemStack(TIER_11_ITEMS, 1, 5));
		}
		RegisterUtilities.registerOre("ingotLead", new ItemStack(INGOT_LEAD));
	}

	public static void OreDictionaryItemsRegister() {
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterUtilities.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 7));
			RegisterUtilities.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 8));
			RegisterUtilities.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 9));
			RegisterUtilities.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 10));
			RegisterUtilities.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 11));
			RegisterUtilities.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 12));
		}
	}

	public static void registerGearItems() {
		if (Config.OXYGEN_TANKS) {
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_VERY_HEAVY, EnumExtendedInventorySlot.LEFT_TANK, OXYGEN_TANK_VERY_HEAVY);
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_VERY_HEAVY, EnumExtendedInventorySlot.RIGHT_TANK, OXYGEN_TANK_VERY_HEAVY);

			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_EXTREMELY_HEAVY, EnumExtendedInventorySlot.LEFT_TANK, OXYGEN_TANK_EXTREMELY_HEAVY);
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_EXTREMELY_HEAVY, EnumExtendedInventorySlot.RIGHT_TANK, OXYGEN_TANK_EXTREMELY_HEAVY);
		}

		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_BLACK, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_BLACK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_RED, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_RED);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_GREEN, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_GREEN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_BROWN, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_BROWN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_BLUE, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_PURPLE, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_PURPLE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_CYAN, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_CYAN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_LIGHT_GRAY, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_LIGHT_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_GRAY, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_PINK, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_PINK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_YELLOW, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_YELLOW);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_LIGHT_BLUE, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_LIGHT_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_MAGENTA, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_MAGENTA);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_ORANGE, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_ORANGE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_WHITE, EnumExtendedInventorySlot.LEFT_TANK, LIGHT_OXYGEN_TANK_WHITE);

		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_BLACK, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_BLACK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_RED, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_RED);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_GREEN, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_GREEN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_BROWN, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_BROWN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_BLUE, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_PURPLE, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_PURPLE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_CYAN, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_CYAN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_LIGHT_GRAY, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_LIGHT_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_GRAY, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_PINK, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_PINK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_YELLOW, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_YELLOW);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_LIGHT_BLUE, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_LIGHT_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_MAGENTA, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_MAGENTA);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_LIME, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_LIME);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_WHITE, EnumExtendedInventorySlot.LEFT_TANK, MED_OXYGEN_TANK_WHITE);

		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_BLACK, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_BLACK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_LIME, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_LIME);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_GREEN, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_GREEN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_BROWN, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_BROWN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_BLUE, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_PURPLE, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_PURPLE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_CYAN, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_CYAN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_LIGHT_GRAY, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_LIGHT_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_GRAY, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_PINK, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_PINK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_YELLOW, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_YELLOW);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_LIGHT_BLUE, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_LIGHT_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_MAGENTA, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_MAGENTA);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_ORANGE, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_ORANGE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_WHITE, EnumExtendedInventorySlot.LEFT_TANK, HEAVY_OXYGEN_TANK_WHITE);

		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_BLACK, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_BLACK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_RED, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_RED);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_GREEN, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_GREEN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_BROWN, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_BROWN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_BLUE, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_PURPLE, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_PURPLE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_CYAN, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_CYAN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_LIGHT_GRAY, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_LIGHT_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_GRAY, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_PINK, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_PINK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_YELLOW, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_YELLOW);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_LIGHT_BLUE, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_LIGHT_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_MAGENTA, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_MAGENTA);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_ORANGE, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_ORANGE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_LIGHT_OXYGEN_TANK_WHITE, EnumExtendedInventorySlot.RIGHT_TANK, LIGHT_OXYGEN_TANK_WHITE);

		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_BLACK, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_BLACK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_RED, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_RED);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_GREEN, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_GREEN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_BROWN, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_BROWN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_BLUE, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_PURPLE, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_PURPLE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_CYAN, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_CYAN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_LIGHT_GRAY, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_LIGHT_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_GRAY, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_PINK, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_PINK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_YELLOW, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_YELLOW);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_LIGHT_BLUE, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_LIGHT_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_MAGENTA, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_MAGENTA);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_LIME, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_LIME);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_MED_OXYGEN_TANK_WHITE, EnumExtendedInventorySlot.RIGHT_TANK, MED_OXYGEN_TANK_WHITE);

		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_BLACK, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_BLACK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_LIME, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_LIME);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_GREEN, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_GREEN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_BROWN, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_BROWN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_BLUE, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_PURPLE, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_PURPLE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_CYAN, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_CYAN);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_LIGHT_GRAY, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_LIGHT_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_GRAY, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_GRAY);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_PINK, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_PINK);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_YELLOW, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_YELLOW);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_LIGHT_BLUE, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_LIGHT_BLUE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_MAGENTA, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_MAGENTA);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_ORANGE, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_ORANGE);
		GalacticraftRegistry.registerGear(Constants.GEAR_ID_HEAVY_OXYGEN_TANK_WHITE, EnumExtendedInventorySlot.RIGHT_TANK, HEAVY_OXYGEN_TANK_WHITE);

		if (Config.THERMAL_PADDINGS) {
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T3_HELMET, EnumExtendedInventorySlot.THERMAL_HELMET, new ItemStack(TIER_3_THERMAL_PADDING, 1, 0));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T3_CHESTPLATE, EnumExtendedInventorySlot.THERMAL_CHESTPLATE, new ItemStack(TIER_3_THERMAL_PADDING, 1, 1));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T3_LEGGINGS, EnumExtendedInventorySlot.THERMAL_LEGGINGS, new ItemStack(TIER_3_THERMAL_PADDING, 1, 2));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T3_BOOTS, EnumExtendedInventorySlot.THERMAL_BOOTS, new ItemStack(TIER_3_THERMAL_PADDING, 1, 3));

			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T4_HELMET, EnumExtendedInventorySlot.THERMAL_HELMET, new ItemStack(TIER_4_THERMAL_PADDING, 1, 0));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T4_CHESTPLATE, EnumExtendedInventorySlot.THERMAL_CHESTPLATE, new ItemStack(TIER_4_THERMAL_PADDING, 1, 1));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T4_LEGGINGS, EnumExtendedInventorySlot.THERMAL_LEGGINGS, new ItemStack(TIER_4_THERMAL_PADDING, 1, 2));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T4_BOOTS, EnumExtendedInventorySlot.THERMAL_BOOTS, new ItemStack(TIER_4_THERMAL_PADDING, 1, 3));

			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T5_HELMET, EnumExtendedInventorySlot.THERMAL_HELMET, new ItemStack(TIER_5_THERMAL_PADDING, 1, 0));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T5_CHESTPLATE, EnumExtendedInventorySlot.THERMAL_CHESTPLATE, new ItemStack(TIER_5_THERMAL_PADDING, 1, 1));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T5_LEGGINGS, EnumExtendedInventorySlot.THERMAL_LEGGINGS, new ItemStack(TIER_5_THERMAL_PADDING, 1, 2));
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_THERMAL_PADDING_T5_BOOTS, EnumExtendedInventorySlot.THERMAL_BOOTS, new ItemStack(TIER_5_THERMAL_PADDING, 1, 3));
		}
	}
}
