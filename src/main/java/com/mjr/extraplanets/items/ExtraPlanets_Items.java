package com.mjr.extraplanets.items;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.item.EnumExtendedInventorySlot;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
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
import com.mjr.extraplanets.items.schematics.SchematicMarsRover;
import com.mjr.extraplanets.items.schematics.SchematicTier10;
import com.mjr.extraplanets.items.schematics.SchematicTier10ElectricRocket;
import com.mjr.extraplanets.items.schematics.SchematicTier4;
import com.mjr.extraplanets.items.schematics.SchematicTier5;
import com.mjr.extraplanets.items.schematics.SchematicTier6;
import com.mjr.extraplanets.items.schematics.SchematicTier7;
import com.mjr.extraplanets.items.schematics.SchematicTier8;
import com.mjr.extraplanets.items.schematics.SchematicTier9;
import com.mjr.extraplanets.items.schematics.SchematicVenusRover;
import com.mjr.extraplanets.items.thermalPadding.ItemThermalCloth;
import com.mjr.extraplanets.items.thermalPadding.ItemTier3ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier4ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier5ThermalPadding;
import com.mjr.extraplanets.items.vehicles.ItemMarsRover;
import com.mjr.extraplanets.items.vehicles.ItemVenusRover;
import com.mjr.extraplanets.util.RegisterHelper;

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

	public static Item OXYGEN_TANK_VERY_HEAVY;
	public static Item OXYGEN_TANK_EXTREMELY_HEAVY;

	public static Item BUCKET_GLOWSTONE;
	public static Item BUCKET_MAGMA;
	public static Item BUCKET_NITROGEN;
	public static Item BUCKET_FROZEN_WATER;
	public static Item BUCKET_SALT;
	public static Item BUCKET_CLEAN_WATER;
	public static Item BUCKET_INFECTED_WATER;
	public static Item BUCKET_RADIOACTIVE_WATER;
	public static Item BUCKET_METHANE;
	public static Item BUCKET_NITROGEN_ICE;
	public static Item BUCKET_LIQUID_HYDROCARBON;

	public static Item CANNED_FOOD;
	public static Item DIAMOND_APPLE;
	public static Item IRON_APPLE;

	public static Item COMPRESSED_MERCURY;
	public static Item INGOT_URANIUM;
	public static Item INGOT_MERCURY;
	public static Item INGOT_LEAD;

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

	public static void init() {
		initializeItems();
		registerItems();
		registerFluidContainer();
		if (Config.ORE_DICTIONARY_INGOTS)
			OreDictionaryIngotsRegister();
		OreDictionaryItemsRegister();
		registerGearItems();
	}

	private static void initializeItems() {
		if (Config.MERCURY) {
			if (Config.BATTERIES)
				BATTERY_MERCURY = new ItemBasicBattery("mercury_battery", 85000f, 2);
			INGOT_MERCURY = new ItemBasicItem("ingot_mercury");
			COMPRESSED_MERCURY = new ItemMercuryCompressed("compressed_mercury");
			TIER_4_ROCKET = new Tier4Rocket("item_tier4_rocket");
			TIER_4_SCHEMATIC = new SchematicTier4("schematic_tier4");
			TIER_4_NOSE_CONE = new Tier4NoseCone("nose_cone_tier4");
			TIER_4_ITEMS = new ItemTier4Items("tier4_items");
			TIER_4_KEY = new ItemKeyT4("T4key");
		}
		if (Config.CERES) {
			INGOT_URANIUM = new ItemBasicItem("ingot_uranium");
			BUCKET_SALT = new ItemBasicItemBucket("bucket_salt", ExtraPlanets_Fluids.SALT);
		}
		if (Config.JUPITER) {
			if (Config.BATTERIES)
				BATTERY_NICKEL = new ItemBasicBattery("nickel_battery", 45000f, 2);
			BUCKET_MAGMA = new ItemBasicItemBucket("bucket_magma", ExtraPlanets_Fluids.MAGMA);
			TIER_5_ROCKET = new Tier5Rocket("item_tier5_rocket");
			TIER_5_SCHEMATIC = new SchematicTier5("schematic_tier5");
			TIER_5_NOSE_CONE = new Tier5NoseCone("nose_cone_tier5");
			TIER_5_ITEMS = new ItemTier5Items("tier5_items");
			TIER_5_KEY = new ItemKeyT5("T5key");
		}
		if (Config.SATURN) {
			BUCKET_GLOWSTONE = new ItemBasicItemBucket("bucket_glowstone", ExtraPlanets_Fluids.GLOWSTONE);
			TIER_6_ROCKET = new Tier6Rocket("item_tier6_rocket");
			TIER_6_SCHEMATIC = new SchematicTier6("schematic_tier6");
			TIER_6_NOSE_CONE = new Tier6NoseCone("nose_cone_tier6");
			TIER_6_ITEMS = new ItemTier6Items("tier6_items");
			TIER_6_KEY = new ItemKeyT6("T6key");
		}
		if (Config.URANUS) {
			BUCKET_FROZEN_WATER = new ItemBasicItemBucket("bucket_frozen_water", ExtraPlanets_Fluids.FROZEN_WATER);
			TIER_7_ROCKET = new Tier7Rocket("item_tier7_rocket");
			TIER_7_SCHEMATIC = new SchematicTier7("schematic_tier7");
			TIER_7_NOSE_CONE = new Tier7NoseCone("nose_cone_tier7");
			TIER_7_ITEMS = new ItemTier7Items("tier7_items");
			TIER_7_KEY = new ItemKeyT7("T7key");
		}
		if (Config.NEPTUNE) {
			if (Config.BATTERIES)
				BATTERY_ZINC = new ItemBasicBattery("zinc_battery", 125000f, 2);
			BUCKET_NITROGEN = new ItemBasicItemBucket("bucket_nitrogen", ExtraPlanets_Fluids.NITROGEN);
			TIER_8_ROCKET = new Tier8Rocket("item_tier8_rocket");
			TIER_8_SCHEMATIC = new SchematicTier8("schematic_tier8");
			TIER_8_NOSE_CONE = new Tier8NoseCone("nose_cone_tier8");
			TIER_8_ITEMS = new ItemTier8Items("tier8_items");
			TIER_8_KEY = new ItemKeyT8("T8key");
		}
		if (Config.PLUTO) {
			TIER_9_ROCKET = new Tier9Rocket("item_tier9_rocket");
			TIER_9_SCHEMATIC = new SchematicTier9("schematic_tier9");
			TIER_9_NOSE_CONE = new Tier9NoseCone("nose_cone_tier9");
			TIER_9_ITEMS = new ItemTier9Items("tier9_items");
			TIER_9_KEY = new ItemKeyT9("T9key");
		}
		if (Config.ERIS) {
			TIER_10_ROCKET = new Tier10Rocket("item_tier10_rocket");
			TIER_10_SCHEMATIC = new SchematicTier10("schematic_tier10");
			TIER_10_NOSE_CONE = new Tier10NoseCone("nose_cone_tier10");
			TIER_10_ITEMS = new ItemTier10Items("tier10_items");
			TIER_10_KEY = new ItemKeyT10("T10key");
			if (Config.KEPLER22B) {
				TIER_10_ELECTRIC_ROCKET_SCHEMATIC = new SchematicTier10ElectricRocket("schematic_tier10_electric_rocket");
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
			BATTERY_ADVANCED = new ItemBasicBattery("advanced_battery", 50000f, 2);
			BATTERY_ULTIMATE = new ItemBasicBattery("ultimate_battery", 200000f, 2);
		}
		if (Config.OXYGEN_TANKS) {
			OXYGEN_TANK_VERY_HEAVY = new ItemCustomOxygenTank(4, "oxygen_tank_very_heavy_full");
			OXYGEN_TANK_EXTREMELY_HEAVY = new ItemCustomOxygenTank(5, "oxygen_tank_extremely_heavy_full");
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
			MARS_ROVER_SCHEMATIC = new SchematicMarsRover("schematic_mars_rover");
		}
		if (Config.VENUS_ROVER) {
			VENUS_ROVER = new ItemVenusRover("venus_rover");
			VENUS_ROVER_SCHEMATIC = new SchematicVenusRover("schematic_venus_rover");
		}
		if (Config.MARS_ROVER || Config.VENUS_ROVER)
			ELECTRIC_PARTS = new ItemElectricParts("electric_parts");
		BUCKET_CLEAN_WATER = new ItemBasicItemBucket("bucket_clean_water", ExtraPlanets_Fluids.CLEAN_WATER);
		BUCKET_INFECTED_WATER = new ItemBasicItemBucket("bucket_infected_water", ExtraPlanets_Fluids.INFECTED_WATER);
		BUCKET_RADIOACTIVE_WATER = new ItemBasicItemBucket("bucket_radioactive_water", ExtraPlanets_Fluids.RADIO_ACTIVE_WATER);
		BUCKET_METHANE = new ItemBasicItemBucket("bucket_methane", ExtraPlanets_Fluids.METHANE);
		BUCKET_NITROGEN_ICE = new ItemBasicItemBucket("bucket_nitrogen_ice", ExtraPlanets_Fluids.NITROGEN_ICE);
		BUCKET_LIQUID_HYDROCARBON = new ItemBasicItemBucket("bucket_liquid_hydrocarbon", ExtraPlanets_Fluids.LIQUID_HYDROCARBON);

		CANNED_FOOD = new ItemCannedFood("canned_food");
		WAFERS = new ItemWafers("wafer");
		INGOT_LEAD = new ItemBasicItem("ingot_lead");
		CLOTH = new ItemBasicItem("cloth");
		GRAVITY_CONTROLLER = new ItemBasicItem("gravity_controller");

		TIER_1_EQUIPMENT_KIT = new ItemBasicKit("tier1_kit", 1);
		TIER_2_EQUIPMENT_KIT = new ItemBasicKit("tier2_kit", 2);
		TIER_3_EQUIPMENT_KIT = new ItemBasicKit("tier3_kit", 3);
		TIER_4_EQUIPMENT_KIT = new ItemBasicKit("tier4_kit", 4);
		TIER_5_EQUIPMENT_KIT = new ItemBasicKit("tier5_kit", 5);
		if (Config.ERIS && Config.KEPLER22B)
			TIER_10_ELECTRIC_ROCKET = new ElectricRocket("item_tier10_electric_rocket");
	}

	private static void registerItems() {
		if (Config.MERCURY) {
			if (Config.BATTERIES)
				RegisterHelper.registerItem(BATTERY_MERCURY, BATTERY_MERCURY.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(COMPRESSED_MERCURY, COMPRESSED_MERCURY.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(INGOT_MERCURY, INGOT_MERCURY.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_4_ROCKET, TIER_4_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_SCHEMATIC, TIER_4_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_NOSE_CONE, TIER_4_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_ITEMS, TIER_4_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_KEY, TIER_4_KEY.getUnlocalizedName().substring(5));
		}
		if (Config.CERES) {
			RegisterHelper.registerItem(INGOT_URANIUM, INGOT_URANIUM.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BUCKET_SALT, "bucket_salt");
		}
		if (Config.JUPITER) {
			RegisterHelper.registerItem(TIER_5_ROCKET, TIER_5_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_5_SCHEMATIC, TIER_5_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_5_NOSE_CONE, TIER_5_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_5_ITEMS, TIER_5_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_5_KEY, TIER_5_KEY.getUnlocalizedName().substring(5));

			if (Config.BATTERIES)
				RegisterHelper.registerItem(BATTERY_NICKEL, BATTERY_NICKEL.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BUCKET_MAGMA, "bucket_magma");
		}
		if (Config.SATURN) {
			RegisterHelper.registerItem(TIER_6_ROCKET, TIER_6_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_6_SCHEMATIC, TIER_6_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_6_NOSE_CONE, TIER_6_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_6_ITEMS, TIER_6_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_6_KEY, TIER_6_KEY.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(BUCKET_GLOWSTONE, "bucket_glowstone");
		}
		if (Config.URANUS) {
			RegisterHelper.registerItem(TIER_7_ROCKET, TIER_7_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_7_SCHEMATIC, TIER_7_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_7_NOSE_CONE, TIER_7_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_7_ITEMS, TIER_7_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_7_KEY, TIER_7_KEY.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BUCKET_FROZEN_WATER, "bucket_frozen_water");
		}
		if (Config.NEPTUNE) {
			RegisterHelper.registerItem(TIER_8_ROCKET, TIER_8_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_8_SCHEMATIC, TIER_8_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_8_NOSE_CONE, TIER_8_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_8_ITEMS, TIER_8_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_8_KEY, TIER_8_KEY.getUnlocalizedName().substring(5));
			if (Config.BATTERIES)
				RegisterHelper.registerItem(BATTERY_ZINC, BATTERY_ZINC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BUCKET_NITROGEN, "bucket_nitrogen");
		}
		if (Config.PLUTO) {
			RegisterHelper.registerItem(TIER_9_ROCKET, TIER_9_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_9_SCHEMATIC, TIER_9_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_9_NOSE_CONE, TIER_9_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_9_ITEMS, TIER_9_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_9_KEY, TIER_9_KEY.getUnlocalizedName().substring(5));
		}
		if (Config.ERIS) {
			RegisterHelper.registerItem(TIER_10_ROCKET, TIER_10_ROCKET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_10_SCHEMATIC, TIER_10_SCHEMATIC.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_10_NOSE_CONE, TIER_10_NOSE_CONE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_10_ITEMS, TIER_10_ITEMS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_10_KEY, TIER_10_KEY.getUnlocalizedName().substring(5));
			if (Config.KEPLER22B) {
				RegisterHelper.registerItem(TIER_10_ELECTRIC_ROCKET_SCHEMATIC, TIER_10_ELECTRIC_ROCKET_SCHEMATIC.getUnlocalizedName().substring(5));
			}
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterHelper.registerItem(TIER_11_ITEMS, TIER_11_ITEMS.getUnlocalizedName().substring(5));
		}
		if (Config.CUSTOM_APPLES) {
			RegisterHelper.registerItem(DIAMOND_APPLE, DIAMOND_APPLE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(IRON_APPLE, IRON_APPLE.getUnlocalizedName().substring(5));
		}
		if (Config.THERMAL_PADDINGS) {
			RegisterHelper.registerItem(THERMAL_CLOTH, THERMAL_CLOTH.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_THERMAL_PADDING, TIER_3_THERMAL_PADDING.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_THERMAL_PADDING, TIER_4_THERMAL_PADDING.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_5_THERMAL_PADDING, TIER_5_THERMAL_PADDING.getUnlocalizedName().substring(5));
		}
		if (Config.BATTERIES) {
			RegisterHelper.registerItem(BATTERY_ADVANCED, BATTERY_ADVANCED.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BATTERY_ULTIMATE, BATTERY_ULTIMATE.getUnlocalizedName().substring(5));
		}
		if (Config.OXYGEN_TANKS) {
			RegisterHelper.registerItem(OXYGEN_TANK_VERY_HEAVY, OXYGEN_TANK_VERY_HEAVY.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(OXYGEN_TANK_EXTREMELY_HEAVY, OXYGEN_TANK_EXTREMELY_HEAVY.getUnlocalizedName().substring(5));
		}
		if (Config.PRESSURE || Config.RADIATION) {
			RegisterHelper.registerItem(TIER_1_PRESSURE_LAYER, TIER_1_PRESSURE_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_PRESSURE_LAYER, TIER_2_PRESSURE_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_PRESSURE_LAYER, TIER_3_PRESSURE_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_PRESSURE_LAYER, TIER_4_PRESSURE_LAYER.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_1_RADIATION_LAYER, TIER_1_RADIATION_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_RADIATION_LAYER, TIER_2_RADIATION_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_RADIATION_LAYER, TIER_3_RADIATION_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_RADIATION_LAYER, TIER_4_RADIATION_LAYER.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_1_ARMOR_LAYER, TIER_1_ARMOR_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_ARMOR_LAYER, TIER_2_ARMOR_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_ARMOR_LAYER, TIER_3_ARMOR_LAYER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_ARMOR_LAYER, TIER_4_ARMOR_LAYER.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_HELMET, TIER_1_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_CHEST, TIER_1_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_1_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_UNPREPARED_SPACE_SUIT_BOOTS, TIER_1_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_HELMET, TIER_2_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_CHEST, TIER_2_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_2_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_UNPREPARED_SPACE_SUIT_BOOTS, TIER_2_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_HELMET, TIER_3_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_CHEST, TIER_3_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_3_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_UNPREPARED_SPACE_SUIT_BOOTS, TIER_3_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_HELMET, TIER_4_UNPREPARED_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_CHEST, TIER_4_UNPREPARED_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS, TIER_4_UNPREPARED_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_UNPREPARED_SPACE_SUIT_BOOTS, TIER_4_UNPREPARED_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.RADIATION) {
			RegisterHelper.registerItem(IODIDE_SALT, IODIDE_SALT.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(POTASSIUM_IODIDE, POTASSIUM_IODIDE.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(POTASSIUM, POTASSIUM.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(POTASH_SHARDS, POTASH_SHARDS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(ANTI_RADIATION, ANTI_RADIATION.getUnlocalizedName().substring(5));
		}
		if (Config.MARS_ROVER) {
			RegisterHelper.registerItem(MARS_ROVER, MARS_ROVER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MARS_ROVER_SCHEMATIC, MARS_ROVER_SCHEMATIC.getUnlocalizedName().substring(5));
		}
		if (Config.VENUS_ROVER) {
			RegisterHelper.registerItem(VENUS_ROVER, VENUS_ROVER.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(VENUS_ROVER_SCHEMATIC, VENUS_ROVER_SCHEMATIC.getUnlocalizedName().substring(5));
		}
		if (Config.MARS_ROVER || Config.VENUS_ROVER)
			RegisterHelper.registerItem(ELECTRIC_PARTS, ELECTRIC_PARTS.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(CANNED_FOOD, CANNED_FOOD.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(WAFERS, WAFERS.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(INGOT_LEAD, INGOT_LEAD.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(CLOTH, CLOTH.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(GRAVITY_CONTROLLER, GRAVITY_CONTROLLER.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(BUCKET_CLEAN_WATER, "bucket_clean_water");
		RegisterHelper.registerItem(BUCKET_INFECTED_WATER, "bucket_infected_water");
		RegisterHelper.registerItem(BUCKET_RADIOACTIVE_WATER, "bucket_radioactive_water");
		RegisterHelper.registerItem(BUCKET_METHANE, "bucket_methane");
		RegisterHelper.registerItem(BUCKET_NITROGEN_ICE, "bucket_nitrogen_ice");
		RegisterHelper.registerItem(BUCKET_LIQUID_HYDROCARBON, "bucket_liquid_hydrocarbon");

		RegisterHelper.registerItem(TIER_1_EQUIPMENT_KIT, TIER_1_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(TIER_2_EQUIPMENT_KIT, TIER_2_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(TIER_3_EQUIPMENT_KIT, TIER_3_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(TIER_4_EQUIPMENT_KIT, TIER_4_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		RegisterHelper.registerItem(TIER_5_EQUIPMENT_KIT, TIER_5_EQUIPMENT_KIT.getUnlocalizedName().substring(5));
		if (Config.ERIS && Config.KEPLER22B)
			RegisterHelper.registerItem(TIER_10_ELECTRIC_ROCKET, TIER_10_ELECTRIC_ROCKET.getUnlocalizedName().substring(5));
	}

	private static void registerFluidContainer() {
		if (Config.SATURN) {
			FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.GLOWSTONE_FLUID, new ItemStack(BUCKET_GLOWSTONE, 1, 0), new ItemStack(Items.BUCKET));
		}
		if (Config.JUPITER) {
			FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.MAGMA_FLUID, new ItemStack(BUCKET_MAGMA, 1, 0), new ItemStack(Items.BUCKET));
		}
		if (Config.NEPTUNE) {
			FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.NITROGEN_FLUID, new ItemStack(BUCKET_NITROGEN, 1, 0), new ItemStack(Items.BUCKET));
		}
		if (Config.URANUS) {
			FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, new ItemStack(BUCKET_FROZEN_WATER, 1, 0), new ItemStack(Items.BUCKET));
		}
		if (Config.CERES) {
			FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.SALT_FLUID, new ItemStack(BUCKET_SALT, 1, 0), new ItemStack(Items.BUCKET));
		}
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.CLEAN_WATER_FLUID, new ItemStack(BUCKET_CLEAN_WATER, 1, 0), new ItemStack(Items.BUCKET));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.INFECTED_WATER_FLUID, new ItemStack(BUCKET_INFECTED_WATER, 1, 0), new ItemStack(Items.BUCKET));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID, new ItemStack(BUCKET_RADIOACTIVE_WATER, 1, 0), new ItemStack(Items.BUCKET));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.METHANE_FLUID, new ItemStack(BUCKET_METHANE, 1, 0), new ItemStack(Items.BUCKET));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, new ItemStack(BUCKET_NITROGEN_ICE, 1, 0), new ItemStack(Items.BUCKET));
	}

	public static void OreDictionaryIngotsRegister() {
		if (Config.MERCURY) {
			OreDictionary.registerOre("ingotMercury", new ItemStack(INGOT_MERCURY));
			OreDictionary.registerOre("ingotCarbon", new ItemStack(TIER_4_ITEMS, 1, 5));
		}
		if (Config.CERES)
			OreDictionary.registerOre("ingotUranium", new ItemStack(INGOT_URANIUM));
		if (Config.JUPITER) {
			OreDictionary.registerOre("ingotPalladium", new ItemStack(TIER_5_ITEMS, 1, 5));
			OreDictionary.registerOre("ingotNickel", new ItemStack(TIER_5_ITEMS, 1, 7));
			OreDictionary.registerOre("gemRedGem", new ItemStack(TIER_5_ITEMS, 1, 8));
		}
		if (Config.SATURN)
			OreDictionary.registerOre("ingotMagnesium", new ItemStack(TIER_6_ITEMS, 1, 5));
		if (Config.URANUS) {
			OreDictionary.registerOre("ingotCrystal", new ItemStack(TIER_7_ITEMS, 1, 5));
			OreDictionary.registerOre("gemWhiteGem", new ItemStack(TIER_7_ITEMS, 1, 7));
		}
		if (Config.NEPTUNE) {
			OreDictionary.registerOre("ingotZinc", new ItemStack(TIER_8_ITEMS, 1, 5));
			OreDictionary.registerOre("gemBlueGem", new ItemStack(TIER_8_ITEMS, 1, 6));
		}
		if (Config.PLUTO)
			OreDictionary.registerOre("ingotTungsten", new ItemStack(TIER_9_ITEMS, 1, 5));
		if (Config.ERIS)
			OreDictionary.registerOre("ingotDarkIron", new ItemStack(TIER_10_ITEMS, 1, 5));
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			OreDictionary.registerOre("gemBlueDiamond", new ItemStack(TIER_11_ITEMS, 1, 0));
			OreDictionary.registerOre("gemRedDiamond", new ItemStack(TIER_11_ITEMS, 1, 1));
			OreDictionary.registerOre("gemPurpleDiamond", new ItemStack(TIER_11_ITEMS, 1, 2));
			OreDictionary.registerOre("gemYellowDiamond", new ItemStack(TIER_11_ITEMS, 1, 3));
			OreDictionary.registerOre("gemGreenDiamond", new ItemStack(TIER_11_ITEMS, 1, 4));
			OreDictionary.registerOre("ingotPlatinum", new ItemStack(TIER_11_ITEMS, 1, 5));
		}
		OreDictionary.registerOre("ingotLead", new ItemStack(INGOT_LEAD));
	}
	
	public static void OreDictionaryItemsRegister() {
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			OreDictionary.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 7));
			OreDictionary.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 8));
			OreDictionary.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 9));
			OreDictionary.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 10));
			OreDictionary.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 11));
			OreDictionary.registerOre("stickWood", new ItemStack(TIER_11_ITEMS, 1, 12));
		}
	}

	public static void registerGearItems() {
		if (Config.OXYGEN_TANKS) {
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_VERY_HEAVY, EnumExtendedInventorySlot.LEFT_TANK, OXYGEN_TANK_VERY_HEAVY);
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_VERY_HEAVY, EnumExtendedInventorySlot.RIGHT_TANK, OXYGEN_TANK_VERY_HEAVY);

			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_EXTREMELY_HEAVY, EnumExtendedInventorySlot.LEFT_TANK, OXYGEN_TANK_EXTREMELY_HEAVY);
			GalacticraftRegistry.registerGear(Constants.GEAR_ID_OXYGEN_TANK_EXTREMELY_HEAVY, EnumExtendedInventorySlot.RIGHT_TANK, OXYGEN_TANK_EXTREMELY_HEAVY);
		}
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
