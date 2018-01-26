package com.mjr.extraplanets;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;

public class Config {
	public static Configuration config = new Configuration(new File(Constants.CONFIG_FILE));

	// Config options
	public static boolean MOB_SUFFOCATION;
	public static boolean USE_DEFAULT_BOSSES;

	public static boolean GENERATE_KEPLER22B_DUNGEONS;
	public static boolean GENERATE_KEPLER22B_SMALL_TREES;
	public static boolean GENERATE_KEPLER22B_NO_LEAF_SMALL_TREES;
	public static boolean GENERATE_KEPLER22B_NO_LEAF_BIG_TREES;
	public static boolean GENERATE_KEPLER22B_SPHERES;
	public static boolean GENERATE_KEPLER22B_MATERIAL_TREES;
	public static boolean GENERATE_KEPLER22B_CANDY_CANES;
	public static boolean GENERATE_KEPLER22B_COOKIE_ROCKS;
	public static boolean GENERATE_KEPLER22B_HUTS;
	public static boolean GENERATE_KEPLER22B_TOWERS;
	public static boolean GENERATE_KEPLER22B_BIG_TREES;
	public static boolean GENERATE_JUPITER_BASIC_HIDEOUTS;
	public static boolean GENERATE_IO_VOLCANOS;
	public static boolean GENERATE_SATURN_SLIME_TREES;
	public static boolean GENERATE_NEPTUNE_FROZEN_NITROGEN_PILES;
	public static boolean GENERATE_SATURN_NUCLEAR_PILES;
	public static boolean GENERATE_URANUS_IGLOOS;
	public static boolean GENERATE_URANUS_ICE_SPIKES;
	public static boolean GENERATE_JUITPER_SKY_FEATURE;
	public static boolean JUITPER_LIGHTING;
	public static boolean CUSTOM_FOG;

	public static boolean ITEMS_CARBON;
	public static boolean ITEMS_PALLADIUM;
	public static boolean ITEMS_MAGNESIUM;
	public static boolean ITEMS_CRYSTAL;
	public static boolean ITEMS_TUNGSTEN;
	public static boolean ITEMS_GEM_RED;
	public static boolean ITEMS_GEM_BLUE;
	public static boolean ITEMS_GEM_WHITE;
	public static boolean ITEMS_ZINC;
	public static boolean ITEMS_MERCURY;
	public static boolean ITEMS_URANIUM;
	public static boolean ITEMS_KEPLER22B;

	public static boolean THERMAL_PADDINGS;
	public static boolean BATTERIES;
	public static boolean CANNED_FOOD;
	public static boolean CUSTOM_APPLES;
	public static boolean OXYGEN_TANKS;

	public static boolean SOLAR_PANELS;
	public static boolean REFINERY_ADVANCED;
	public static boolean REFINERY_ULTIMATE;
	public static boolean FUEL_LOADER_ADVANCED;
	public static boolean FUEL_LOADER_ULTIMATE;
	public static boolean OXYGEN_COMPRESSOR_ADVANCED;
	public static boolean OXYGEN_COMPRESSOR_ULTIMATE;
	public static boolean SLABS_AND_STAIRS;
	public static boolean NUCLEAR_BOMB;
	public static boolean FIRE_BOMB;

	public static boolean BASIC_DECRYSTALLIZER;
	public static boolean BASIC_CRYSTALLIZER;
	public static boolean BASIC_SMASHER;
	public static boolean BASIC_CHEMICAL_INJECTOR;
	public static boolean BASIC_SOLAR_EVAPORTATION_CHAMBER;
	public static boolean BASIC_PURIFIER;
	public static boolean BASIC_DENSIFIER;
	public static boolean BASIC_DECONTAMINATION_UNIT;

	public static boolean MERCURY;
	public static boolean CERES;
	public static boolean JUPITER;
	public static boolean SATURN;
	public static boolean URANUS;
	public static boolean NEPTUNE;
	public static boolean PLUTO;
	public static boolean ERIS;

	public static boolean TRITON;
	public static boolean EUROPA;
	public static boolean IO;
	public static boolean DEIMOS;
	public static boolean PHOBOS;
	public static boolean CALLISTO;
	public static boolean GANYMEDE;
	public static boolean RHEA;
	public static boolean TITAN;
	public static boolean OBERON;
	public static boolean TITANIA;
	public static boolean IAPETUS;

	public static boolean MAKEMAKE;
	public static boolean HAUMEA;
	public static boolean KUIPER_BELT;
	public static boolean KEPLER_SOLAR_SYSTEMS;

	public static boolean KEPLER22B;

	public static int MERCURY_ID;
	public static int CERES_ID;
	public static int JUPITER_ID;
	public static int SATURN_ID;
	public static int URANUS_ID;
	public static int NEPTUNE_ID;
	public static int PLUTO_ID;
	public static int ERIS_ID;

	public static int TRITON_ID;
	public static int EUROPA_ID;
	public static int IO_ID;
	public static int DEIMOS_ID;
	public static int PHOBOS_ID;
	public static int CALLISTO_ID;
	public static int GANYMEDE_ID;
	public static int RHEA_ID;
	public static int TITAN_ID;
	public static int OBERON_ID;
	public static int TITANIA_ID;
	public static int IAPETUS_ID;

	public static int KEPLER22B_ID;

	public static int MERCURY_SPACE_STATION_ID;
	public static int MERCURY_SPACE_STATION_STATIC_ID;

	public static int VENUS_SPACE_STATION_ID;
	public static int VENUS_SPACE_STATION_STATIC_ID;

	public static int CERES_SPACE_STATION_ID;
	public static int CERES_SPACE_STATION_STATIC_ID;

	public static int MARS_SPACE_STATION_ID;
	public static int MARS_SPACE_STATION_STATIC_ID;

	public static int JUPITER_SPACE_STATION_ID;
	public static int JUPITER_SPACE_STATION_STATIC_ID;

	public static int SATURN_SPACE_STATION_ID;
	public static int SATURN_SPACE_STATION_STATIC_ID;

	public static int URANUS_SPACE_STATION_ID;
	public static int URANUS_SPACE_STATION_STATIC_ID;

	public static int NEPTUNE_SPACE_STATION_ID;
	public static int NEPTUNE_SPACE_STATION_STATIC_ID;

	public static int PLUTO_SPACE_STATION_ID;
	public static int PLUTO_SPACE_STATION_STATIC_ID;

	public static int ERIS_SPACE_STATION_ID;
	public static int ERIS_SPACE_STATION_STATIC_ID;

	public static int KEPLER22B_SPACE_STATION_ID;
	public static int KEPLER22B_SPACE_STATION_STATIC_ID;

	public static boolean MERCURY_SPACE_STATION;
	public static boolean VENUS_SPACE_STATION;
	public static boolean CERES_SPACE_STATION;
	public static boolean MARS_SPACE_STATION;
	public static boolean JUPITER_SPACE_STATION;
	public static boolean SATURN_SPACE_STATION;
	public static boolean URANUS_SPACE_STATION;
	public static boolean NEPTUNE_SPACE_STATION;
	public static boolean PLUTO_SPACE_STATION;
	public static boolean ERIS_SPACE_STATION;
	public static boolean KEPLER22B_SPACE_STATION;

	public static boolean ORE_DICTIONARY;
	public static boolean ORE_DICTIONARY_INGOTS;
	public static boolean ORE_DICTIONARY_OTHER;

	public static int SCHEMATIC_TIER_4_GUI_ID;
	public static int SCHEMATIC_TIER_5_GUI_ID;
	public static int SCHEMATIC_TIER_6_GUI_ID;
	public static int SCHEMATIC_TIER_7_GUI_ID;
	public static int SCHEMATIC_TIER_8_GUI_ID;
	public static int SCHEMATIC_TIER_9_GUI_ID;
	public static int SCHEMATIC_TIER_10_GUI_ID;
	public static int SCHEMATIC_TIER_10_ELECTRIC_ROCKET_GUI_ID;
	public static int SCHEMATIC_MARS_ROVER_GUI_ID;
	public static int SCHEMATIC_VENUS_ROVER_GUI_ID;

	public static int SCHEMATIC_TIER_4_PAGE_ID;
	public static int SCHEMATIC_TIER_5_PAGE_ID;
	public static int SCHEMATIC_TIER_6_PAGE_ID;
	public static int SCHEMATIC_TIER_7_PAGE_ID;
	public static int SCHEMATIC_TIER_8_PAGE_ID;
	public static int SCHEMATIC_TIER_9_PAGE_ID;
	public static int SCHEMATIC_TIER_10_PAGE_ID;
	public static int SCHEMATIC_TIER_10_ELECTRIC_ROCKET_PAGE_ID;
	public static int SCHEMATIC_MARS_ROVER_PAGE_ID;
	public static int SCHEMATIC_VENUS_ROVER_PAGE_ID;

	public static boolean NEI_SUPPORT;
	public static boolean JEI_SUPPORT;
	public static boolean ACHIEVEMENTS;
	public static boolean EXTREME_REACTORS_SUPPORT;
	public static boolean MC_MULITPART_SUPPORT;
	public static boolean GC_DECONSTRUCTOR_SUPPORT;

	public static boolean PRESSURE;
	public static boolean RADIATION;

	public static boolean ORE_LEAD_GENERATION;
	public static int ORE_LEAD_GENERATION_AMOUNT;

	public static float MERCURY_DISTANCE_OFFSET;
	public static float CERES_DISTANCE_OFFSET;
	public static float JUPITER_DISTANCE_OFFSET;
	public static float SATURN_DISTANCE_OFFSET;
	public static float URANUS_DISTANCE_OFFSET;
	public static float NEPTUNE_DISTANCE_OFFSET;
	public static float PLUTO_DISTANCE_OFFSET;
	public static float ERIS_DISTANCE_OFFSET;
	public static float MAKEMAKE_DISTANCE_OFFSET;
	public static float HAUMEA_DISTANCE_OFFSET;
	public static float KUIPER_BELT_DISTANCE_OFFSET;

	public static float KEPLER22_SYSTEM_X_OFFSET;
	public static float KEPLER22_SYSTEM_Y_OFFSET;
	public static float KEPLER22_SYSTEM_Z_OFFSET;
	public static float KEPLER47_SYSTEM_X_OFFSET;
	public static float KEPLER47_SYSTEM_Y_OFFSET;
	public static float KEPLER47_SYSTEM_Z_OFFSET;
	public static float KEPLER62_SYSTEM_X_OFFSET;
	public static float KEPLER62_SYSTEM_Y_OFFSET;
	public static float KEPLER62_SYSTEM_Z_OFFSET;
	public static float KEPLER69_SYSTEM_X_OFFSET;
	public static float KEPLER69_SYSTEM_Y_OFFSET;
	public static float KEPLER69_SYSTEM_Z_OFFSET;

	public static boolean DEBUG_MODE;

	public static boolean MARS_ROVER;
	public static boolean VENUS_ROVER;

	public static boolean OLD_STYLE_GRAVITY;
	public static boolean OLD_ROCKET_MODELS;

	public static boolean MERCURY_VILLAGES;
	public static boolean CERES_VILLAGES;
	public static boolean JUPITER_VILLAGES;
	public static boolean SATURN_VILLAGES;
	public static boolean URANUS_VILLAGES;
	public static boolean NEPTUNE_VILLAGES;
	public static boolean PLUTO_VILLAGES;
	public static boolean ERIS_VILLAGES;

	public static boolean MORE_PLANETS_COMPATIBILITY;

	public static boolean USE_CUSTOM_CELESTAIAL_SELECTION;
	public static boolean CUSTOM_GALAXIES;

	public static void load() {
		config.load();

		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Change if a dimension ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Setting this option to false will remove the planet with all the related items/block!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable/Disable dimension settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Setting this option to false will remove the planet/moon with all the related items/block//space stations!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Change if a Schematic GUI ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Change if a Schematic Page ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_ITEMS,
				"Changing to false will disable & remove the tool & armor or items (Note: Tools & Armors will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_BLOCKS, "Changing to false will disable & remove the blocks/machines");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SPACE_STATIONS,
				"Setting this option to false will remove the space station from the planet (Note: Will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable/Disable compatibility settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable/Disable general settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Advanced options for Celestial Body Map to change locations of planets and solar systems! (For Advanced Users ONLY!)");

		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_DIMENSION_IDS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_ITEMS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_BLOCKS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_SPACE_STATIONS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_COMPATIBILITY, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, true);
		config.setCategoryRequiresMcRestart(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, true);

		ITEMS_CARBON = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Carbon Tools & Armor", true, "This option will disable & remove all Carbon Tools & Armour").getBoolean(true);
		ITEMS_PALLADIUM = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Palladium Tools & Armor", true, "This option will disable & remove all Palladium Tools & Armour").getBoolean(true);
		ITEMS_MAGNESIUM = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Magnesium Tools & Armor", true, "This option will disable & remove all Magnesium Tools & Armour").getBoolean(true);
		ITEMS_CRYSTAL = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Crystal Tools & Armor", true, "This option will disable & remove all Crystal Tools & Armour").getBoolean(true);
		ITEMS_TUNGSTEN = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Tungsten Tools & Armor", true, "This option will disable & remove all Tungsten Tools & Armour").getBoolean(true);
		ITEMS_GEM_RED = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Red Gem Tools & Armor", true, "This option will disable & remove all Red Gem Tools & Armour").getBoolean(true);
		ITEMS_GEM_BLUE = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Blue Gem Tools & Armor", true, "This option will disable & remove all Blue Gem Tools & Armour").getBoolean(true);
		ITEMS_GEM_WHITE = config.get(Constants.CONFIG_CATEGORY_ITEMS, "White Gem Tools & Armor", true, "This option will disable & remove all White Gem Tools & Armour").getBoolean(true);
		ITEMS_ZINC = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Zinc Tools & Armor", true, "This option will disable & remove all Zinc Tools & Armour").getBoolean(true);
		ITEMS_MERCURY = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Mercury Tools & Armor", true, "This option will disable & remove all Mercury Tools & Armour").getBoolean(true);
		ITEMS_URANIUM = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Uranium Tools & Armor", true, "This option will disable & remove all Uranium Tools & Armour").getBoolean(true);
		ITEMS_KEPLER22B = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Kepler22b Tools & Armor", true, "This option will disable & remove all Kepler22b Tools & Armour").getBoolean(true);

		THERMAL_PADDINGS = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Tier 3 - 4 Thermal Padding", true, "This option will change planet thermal levels to support this feature!").getBoolean(true);
		BATTERIES = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Batteries", true, "This option will disable & remove all Custom Batteries!").getBoolean(true);
		CANNED_FOOD = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Canned Food", true, "This option will disable & remove all Custom Canned Food!").getBoolean(true);
		CUSTOM_APPLES = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Iron & Diamomd Normal/Notch Apples", true, "This option will disable & remove all Custom Normal/Notch Apples!").getBoolean(true);
		OXYGEN_TANKS = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Oxygen Tanks", true, "This option will disable & remove Extremely Heavy & Very Heavy Oxygen Tanks").getBoolean(true);

		SOLAR_PANELS = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Hybrid/Ultimate Solar Panel", true, "This option will disable & remove the Hybrid/Ulimate Solar Panels").getBoolean(true);
		REFINERY_ADVANCED = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Advanced Refinery", true, "This option will disable & remove the Advanced Refinery").getBoolean(true);
		REFINERY_ULTIMATE = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Ultimate Refinery", true, "This option will disable & remove the Ultimate Refinery").getBoolean(true);
		FUEL_LOADER_ADVANCED = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Advanced Fuel Loader", true, "This option will disable & remove the Advanced Fuel Loader").getBoolean(true);
		FUEL_LOADER_ULTIMATE = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Ultimate Fuel Loader", true, "This option will disable & remove the Ultimate Fuel Loader").getBoolean(true);
		OXYGEN_COMPRESSOR_ADVANCED = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Advanced Compressor/Decompressor", true, "This option will disable & remove the Advanced Compressor/Decompressor").getBoolean(true);
		OXYGEN_COMPRESSOR_ULTIMATE = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Ultimate Compressor/Decompressor", true, "This option will disable & remove the Ultimate Compressor/Decompressor").getBoolean(true);
		NUCLEAR_BOMB = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Nuclear Bomb", true, "This option will disable & remove the Nuclear Bomb").getBoolean(true);
		FIRE_BOMB = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Fire Bomb", true, "This option will disable & remove the Fire Bomb").getBoolean(true);

		BASIC_DECRYSTALLIZER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Decrystallizer", true, "This option will disable & remove the Basic Decrystallizer").getBoolean(true);
		BASIC_CRYSTALLIZER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Crystallizer", true, "This option will disable & remove the Basic Crystallizer").getBoolean(true);
		BASIC_SMASHER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Block Smasher", true, "This option will disable & remove the Basic Block Smasher").getBoolean(true);
		BASIC_CHEMICAL_INJECTOR = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Chemical Injector", true, "This option will disable & remove the Basic Chemical Injector").getBoolean(true);
		BASIC_SOLAR_EVAPORTATION_CHAMBER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Solar Evaporation Chamber", true, "This option will disable & remove the Basic Solar Evaporation Chamber").getBoolean(true);
		BASIC_PURIFIER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Purifier", true, "This option will disable & remove the Basic Purifier").getBoolean(true);
		BASIC_DENSIFIER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Densifier", true, "This option will disable & remove the Basic Densifier").getBoolean(true);
		BASIC_DECONTAMINATION_UNIT = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Decontamination Unit", true, "This option will disable & remove the Basic Decontamination Unit").getBoolean(true);

		MOB_SUFFOCATION = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Mob Suffocation", true, "Setting this to false will make mobs not suffocate on planets but the player will!").getBoolean(true);
		USE_DEFAULT_BOSSES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Use default bosses for all planets", false, "Setting this option to false will disable & remove all custom bosses and will replace them with Creeper Bosses!").getBoolean(
				false);

		GENERATE_KEPLER22B_DUNGEONS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Vanilla Style Dungeons on Kepler22b", true, "Setting this option to false will disable & remove Vanilla Style Dungeons from generating on Kepler22b")
				.getBoolean(true);
		GENERATE_KEPLER22B_SMALL_TREES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Small Trees on Kepler22b", true, "Setting this option to false will disable & remove Small Trees from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_NO_LEAF_SMALL_TREES = config
				.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate No Leaf Small Trees on Kepler22b", true, "Setting this option to false will disable & remove No Leaf Small Trees from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_NO_LEAF_BIG_TREES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate No Leaf Big Trees on Kepler22b", true, "Setting this option to false will disable & remove No Leaf Big Trees from generating on Kepler22b")
				.getBoolean(true);
		GENERATE_KEPLER22B_SPHERES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Material Spheres on Kepler22b", true, "Setting this option to false will disable & remove Material Spheres from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_MATERIAL_TREES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Material Trees on Kepler22b", true, "Setting this option to false will disable & remove Material Trees from generating on Kepler22b").getBoolean(
				true);
		GENERATE_KEPLER22B_CANDY_CANES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Candy Canes on Kepler22b", true, "Setting this option to false will disable & remove Candy Canes from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_COOKIE_ROCKS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Cookie Rocks on Kepler22b", true, "Setting this option to false will disable & remove Cookie Rocks from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_HUTS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Huts on Kepler22b", true, "Setting this option to false will disable & remove Huts from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_TOWERS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Towers on Kepler22b", true, "Setting this option to false will disable & remove Towers from generating on Kepler22b").getBoolean(true);
		GENERATE_KEPLER22B_BIG_TREES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Big Trees on Kepler22b", true, "Setting this option to false will disable & remove Big Trees from generating on Kepler22b").getBoolean(true);
		GENERATE_JUPITER_BASIC_HIDEOUTS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Basic Hideouts on Jupiter", true, "Setting this option to false will disable & remove Basic Hideouts from generating on Jupiter").getBoolean(true);
		GENERATE_IO_VOLCANOS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Volcanos on Io", true, "Setting this option to false will disable & remove Volcanos from generating on Io").getBoolean(true);
		GENERATE_NEPTUNE_FROZEN_NITROGEN_PILES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Frozen Nitrongen Piles on Neptune", true,
				"Setting this option to false will disable & remove Frozen Nitrongen Piles from generating on Neptune").getBoolean(true);
		GENERATE_SATURN_NUCLEAR_PILES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Nuclear Piles on Saturn", true, "Setting this option to false will disable & remove Nuclear Piles from generating on Saturn").getBoolean(true);
		GENERATE_SATURN_SLIME_TREES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Slime Trees on Saturn", true, "Setting this option to false will disable & remove Slime Trees from generating on Saturn").getBoolean(true);
		GENERATE_URANUS_IGLOOS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Igloos on Uranus", true, "Setting this option to false will disable & remove Igloos from generating on Uranus").getBoolean(true);
		GENERATE_URANUS_ICE_SPIKES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Ice Spikes on Uranus", true, "Setting this option to false will disable & remove Ice Spikes from generating on Uranus").getBoolean(true);
		GENERATE_JUITPER_SKY_FEATURE = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Sky Feature on Jupiter", true, "Setting this option to false will disable & remove the Sky Feature on Jupiter").getBoolean(true);
		JUITPER_LIGHTING = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Lighting & Lighting Effects on Jupiter", true, "Setting this option to false will disable & remove Lighting & Lighting Effects on Jupiter").getBoolean(true);
		CUSTOM_FOG = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Custom Fog Effect on Jupiter, Uranus, Saturn, Neptune", true, "Setting this option to false will disable & remove Fog Effects on Jupiter, Uranus, Saturn, Neptune")
				.getBoolean(true);

		TRITON = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Triton", true, "Setting this option to false will remove Triton & all the related items/block/tools/armour/space stations!").getBoolean(true);
		EUROPA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Europa", true, "Setting this option to false will remove Europa & all the related items/block/tools/armour/space stations!").getBoolean(true);
		IO = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "IO", true, "Setting this option to false will remove IO & all the related items/block/tools/armour/space stations!").getBoolean(true);
		DEIMOS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Deimos", true, "Setting this option to false will remove Deimos & all the related items/block/tools/armour/space stations!").getBoolean(true);
		PHOBOS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Phobos", true, "Setting this option to false will remove Phobos & all the related items/block/tools/armour/space stations!").getBoolean(true);
		CALLISTO = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Callisto", true, "Setting this option to false will remove Callisto & all the related items/block/tools/armour/space stations!").getBoolean(true);
		GANYMEDE = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Ganymede", true, "Setting this option to false will remove Ganymede & all the related items/block/tools/armour/space stations!").getBoolean(true);
		RHEA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Rhea", true, "Setting this option to false will remove Rhea & all the related items/block/tools/armour/space stations!").getBoolean(true);
		TITAN = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Titan", true, "Setting this option to false will remove Titan & all the related items/block/tools/armour/space stations!").getBoolean(true);
		OBERON = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Oberon", true, "Setting this option to false will remove Oberon & all the related items/block/tools/armour/space stations!").getBoolean(true);
		TITANIA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Titania", true, "Setting this option to false will remove Titania & all the related items/block/tools/armour/space stations!").getBoolean(true);
		IAPETUS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Iapetus", true, "Setting this option to false will remove Iapetus & all the related items/block/tools/armour/space stations!").getBoolean(true);

		CERES = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Ceres", true, "Setting this option to false will remove Ceres & all the related items/block/tools/armour/space stations!").getBoolean(true);
		KEPLER22B = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Kepler 22b", true, "Setting this option to false will remove Kepler 22b & all the related items/block/tools/armour/space stations!").getBoolean(true);

		HAUMEA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Haumea", true, "Setting this option to false will remove Haumea").getBoolean(true);
		MAKEMAKE = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Makemake", true, "Setting this option to false will remove Makemake").getBoolean(true);
		KUIPER_BELT = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Kuiper Belt", true, "Setting this option to false will remove Kuiper Belt").getBoolean(true);
		KEPLER_SOLAR_SYSTEMS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Kepler SolarSystems", true, "Setting this option to false will remove all Kepler Solar Systems and their Planets/Moons!").getBoolean(true);

		MERCURY_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Mercury SpaceStation", true, "Setting this option to false will disable & remove the Mercury Space Station").getBoolean(true);
		VENUS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Venus SpaceStation", true, "Setting this option to false will disable & remove the Venus Space Station").getBoolean(true);
		CERES_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Ceres SpaceStation", true, "Setting this option to false will disable & remove the Ceres Space Station").getBoolean(true);
		MARS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Mars SpaceStation", true, "Setting this option to false will disable & remove the Mars Space Station").getBoolean(true);
		JUPITER_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Jupiter SpaceStation", true, "Setting this option to false will disable & remove the Jupiter Space Station").getBoolean(true);
		SATURN_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Saturn SpaceStation", true, "Setting this option to false will disable & remove the Saturn Space Station").getBoolean(true);
		URANUS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Uranus SpaceStation", true, "Setting this option to false will disable & remove the Uranus Space Station").getBoolean(true);
		NEPTUNE_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Neptune SpaceStation", true, "Setting this option to false will disable & remove the Neptune Space Station").getBoolean(true);
		PLUTO_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Pluto SpaceStation", true, "Setting this option to false will disable & remove the Pluto Space Station").getBoolean(true);
		ERIS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Eris SpaceStation", true, "Setting this option to false will disable & remove the Eris Space Station").getBoolean(true);
		KEPLER22B_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Kepler22b SpaceStation", true, "Setting this option to false will disable & remove the Kepler22b Space Station").getBoolean(true);

		MERCURY = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Mercury & Tier 4 Rocket", true, "Setting this option to false will remove the Mercury & Tier 4 Rocket with all the related items/block/tools/armour/space stations!")
				.getBoolean(true);
		JUPITER = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Jupiter & Tier 5 Rocket", true, "Setting this option to false will remove the Jupiter & Tier 5 Rocket with all the related items/block/tools/armour/space stations!")
				.getBoolean(true);
		SATURN = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Saturn & Tier 6 Rocket", true, "Setting this option to false will remove the Saturn & Tier 6 Rocket with all the related items/block/tools/armour!/space stations").getBoolean(
				true);
		URANUS = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Uranus & Tier 7 Rocket", true, "Setting this option to false will remove the Uranus & Tier 7 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(
				true);
		NEPTUNE = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Neptune & Tier 8 Rocket", true, "Setting this option to false will remove the Neptune & Tier 8 Rocket with all the related items/block/tools/armour/space stations!")
				.getBoolean(true);
		PLUTO = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Pluto & Tier 9 Rocket", true, "Setting this option to false will remove the Pluto & Tier 9 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		ERIS = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Eris & Tier 10 Rocket", true, "Setting this option to false will remove the Eris & Tier 10 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);

		MERCURY_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mercury Dimension ID", -13, "[range: -2147483647 ~ 2147483647, default: -13]").getInt();
		CERES_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ceres Dimension ID", -20, "[range: -2147483647 ~ 2147483647, default: -20]").getInt();
		JUPITER_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Jupiter Dimension ID", -15, "[range: -2147483647 ~ 2147483647, default: -15]").getInt();
		SATURN_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Saturn Dimension ID", -16, "[range: -2147483647 ~ 2147483647, default: -16]").getInt();
		URANUS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Uranus Dimension ID", -17, "[range: -2147483647 ~ 2147483647, default: -17]").getInt();
		NEPTUNE_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Neptune Dimension ID", -18, "[range: -2147483647 ~ 2147483647, default: -18]").getInt();
		PLUTO_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Pluto Dimension ID", -19, "[range: -2147483647 ~ 2147483647, default: -19]").getInt();
		ERIS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Eris Dimension ID", -21, "[range: -2147483647 ~ 2147483647, default: -21]").getInt();

		IO_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Io Dimension ID", -32, "[range: -2147483647 ~ 2147483647, default: -32]").getInt();
		EUROPA_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Europa Dimension ID", -34, "[range: -2147483647 ~ 2147483647, default: -34]").getInt();
		PHOBOS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Phobos Dimension ID", -33, "[range: -2147483647 ~ 2147483647, default: -33]").getInt();
		DEIMOS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Deimos Dimension ID", -35, "[range: -2147483647 ~ 2147483647, default: -35]").getInt();
		TRITON_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Triton Dimension ID", -36, "[range: -2147483647 ~ 2147483647, default: -36]").getInt();
		CALLISTO_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Callisto Dimension ID", -37, "[range: -2147483647 ~ 2147483647, default: -37]").getInt();
		GANYMEDE_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ganymede Dimension ID", -38, "[range: -2147483647 ~ 2147483647, default: -38]").getInt();
		RHEA_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Rhea Dimension ID", -39, "[range: -2147483647 ~ 2147483647, default: -39]").getInt();
		TITAN_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Titan Dimension ID", -40, "[range: -2147483647 ~ 2147483647, default: -40]").getInt();
		OBERON_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Oberon Dimension ID", -41, "[range: -2147483647 ~ 2147483647, default: -41]").getInt();
		TITANIA_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Titania Dimension ID", -42, "[range: -2147483647 ~ 2147483647, default: -42]").getInt();
		IAPETUS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Iapetus Dimension ID", -43, "[range: -2147483647 ~ 2147483647, default: -43]").getInt();

		KEPLER22B_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Kepler 22b Dimension ID", -22, "[range: -2147483647 ~ 2147483647, default: -22]").getInt();

		MERCURY_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mercury SpaceStation Dimension ID", -61, "[range: -2147483647 ~ 2147483647, default: -61]").getInt();
		MERCURY_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mercury SpaceStation Static Dimension ID", -60, "[range: -2147483647 ~ 2147483647, default: -60]").getInt();

		VENUS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Venus SpaceStation Dimension ID", -63, "[range: -2147483647 ~ 2147483647, default: -63]").getInt();
		VENUS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Venus SpaceStation Static Dimension ID", -62, "[range: -2147483647 ~ 2147483647, default: -62]").getInt();

		CERES_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ceres SpaceStation Dimension ID", -65, "[range: -2147483647 ~ 2147483647, default: -65]").getInt();
		CERES_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ceres SpaceStation Static Dimension ID", -64, "[range: -2147483647 ~ 2147483647, default: -64]").getInt();

		MARS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mars SpaceStation Dimension ID", -67, "[range: -2147483647 ~ 2147483647, default: -67]").getInt();
		MARS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mars SpaceStation Static Dimension ID", -66, "[range: -2147483647 ~ 2147483647, default: -66]").getInt();

		JUPITER_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Jupiter SpaceStation Dimension ID", -69, "[range: -2147483647 ~ 2147483647, default: -69]").getInt();
		JUPITER_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Jupiter SpaceStation Static Dimension ID", -68, "[range: -2147483647 ~ 2147483647, default: -68]").getInt();

		SATURN_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Saturn SpaceStation Dimension ID", -71, "[range: -2147483647 ~ 2147483647, default: -71]").getInt();
		SATURN_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Saturn SpaceStation Static Dimension ID", -70, "[range: -2147483647 ~ 2147483647, default: -70]").getInt();

		URANUS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Uranus SpaceStation Dimension ID", -73, "[range: -2147483647 ~ 2147483647, default: -73]").getInt();
		URANUS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Uranus SpaceStation Static Dimension ID", -72, "[range: -2147483647 ~ 2147483647, default: -72]").getInt();

		NEPTUNE_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Neptune SpaceStation Dimension ID", -75, "[range: -2147483647 ~ 2147483647, default: -75]").getInt();
		NEPTUNE_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Neptune SpaceStation Static Dimension ID", -74, "[range: -2147483647 ~ 2147483647, default: -74]").getInt();

		PLUTO_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Pluto SpaceStation Dimension ID", -77, "[range: -2147483647 ~ 2147483647, default: -77]").getInt();
		PLUTO_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Pluto SpaceStation Static Dimension ID", -76, "[range: -2147483647 ~ 2147483647, default: -76]").getInt();

		ERIS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Eris SpaceStation Dimension ID", -79, "[range: -2147483647 ~ 2147483647, default: -79]").getInt();
		ERIS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Eris SpaceStation Static Dimension ID", -78, "[range: -2147483647 ~ 2147483647, default: -78]").getInt();

		KEPLER22B_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Kepler 22b SpaceStation Dimension ID", -81, "[range: -2147483647 ~ 2147483647, default: -81]").getInt();
		KEPLER22B_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Kepler 22b SpaceStation Static Dimension ID", -80, "[range: -2147483647 ~ 2147483647, default: -80]").getInt();

		SCHEMATIC_TIER_4_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 4 GUI ID", 5555, "[range: -2147483647 ~ 2147483647, default: 5555]").getInt();
		SCHEMATIC_TIER_5_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 5 GUI ID", 5556, "[range: -2147483647 ~ 2147483647, default: 5556]").getInt();
		SCHEMATIC_TIER_6_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 6 GUI ID", 5557, "[range: -2147483647 ~ 2147483647, default: 5557]").getInt();
		SCHEMATIC_TIER_7_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 7 GUI ID", 5558, "[range: -2147483647 ~ 2147483647, default: 5558]").getInt();
		SCHEMATIC_TIER_8_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 8 GUI ID", 5559, "[range: -2147483647 ~ 2147483647, default: 5559]").getInt();
		SCHEMATIC_TIER_9_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 9 GUI ID", 5560, "[range: -2147483647 ~ 2147483647, default: 5560]").getInt();
		SCHEMATIC_TIER_10_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 10 GUI ID", 5561, "[range: -2147483647 ~ 2147483647, default: 5561]").getInt();
		SCHEMATIC_TIER_10_ELECTRIC_ROCKET_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 10 Electric Rocket GUI ID", 5564, "[range: -2147483647 ~ 2147483647, default: 5564]").getInt();
		SCHEMATIC_MARS_ROVER_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Mars Rover GUI ID", 5562, "[range: -2147483647 ~ 2147483647, default: 5562]").getInt();
		SCHEMATIC_VENUS_ROVER_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Venus Rover GUI ID", 5563, "[range: -2147483647 ~ 2147483647, default: 5563]").getInt();

		SCHEMATIC_TIER_4_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 4 Page ID", 6666, "[range: -2147483647 ~ 2147483647, default: 6666]").getInt();
		SCHEMATIC_TIER_5_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 5 Page ID", 6667, "[range: -2147483647 ~ 2147483647, default: 6667]").getInt();
		SCHEMATIC_TIER_6_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 6 Page ID", 6668, "[range: -2147483647 ~ 2147483647, default: 6668]").getInt();
		SCHEMATIC_TIER_7_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 7 Page ID", 6669, "[range: -2147483647 ~ 2147483647, default: 6669]").getInt();
		SCHEMATIC_TIER_8_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 8 Page ID", 6670, "[range: -2147483647 ~ 2147483647, default: 6670]").getInt();
		SCHEMATIC_TIER_9_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 9 Page ID", 6671, "[range: -2147483647 ~ 2147483647, default: 6671]").getInt();
		SCHEMATIC_TIER_10_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 10 Page ID", 6672, "[range: -2147483647 ~ 2147483647, default: 6672]").getInt();
		SCHEMATIC_TIER_10_ELECTRIC_ROCKET_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 10  Electric Rocket Page ID", 6675, "[range: -2147483647 ~ 2147483647, default: 6675]").getInt();
		SCHEMATIC_MARS_ROVER_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Mars Rover Page ID", 6673, "[range: -2147483647 ~ 2147483647, default: 6673]").getInt();
		SCHEMATIC_VENUS_ROVER_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Venus Rover Page ID", 6674, "[range: -2147483647 ~ 2147483647, default: 6674]").getInt();

		NEI_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable NEI Recipe support", true, "Setting this to false will disable & remove the JEI Support for Custom Machines/Rockets/Vehicles").getBoolean(true);
		JEI_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable JEI Recipe support", true, "Setting this to false will disable & remove the NEI Support for Custom Machines/Rockets/Vehicles").getBoolean(true);

		ORE_DICTIONARY = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Adding of All Planet/Moons Ores to the Ore Dictionary", true, "Setting this to false will disable & remove all Ore Dictionary Support for Planet and Moon Ores!").getBoolean(
				true);
		ORE_DICTIONARY_INGOTS = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Adding of all Ingots to the Ore Dictionary", true, "Setting this to false will disable & remove all Ore Dictionary Support for All Ingots!").getBoolean(true);
		ORE_DICTIONARY_OTHER = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Adding of all Items excluding Ingots to the Ore Dictionary", true,
				"Setting this to false will disable & remove all Ore Dictionary Support for All needed Items excluding Ingots!").getBoolean(true);

		MORE_PLANETS_COMPATIBILITY = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable More Planets Compatibility", false,
				"FOR THIS TO WORK YOU WILL NEED TO DISABLED ALL CONFIG OPTIONS IN THE MORE PLANETS CONFIG UNDER THE 'config_moreplanets_gc_addon_compat' SECTION!").getBoolean(false);

		EXTREME_REACTORS_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Extreme Reactors Compatibility", true, "Setting this to false will disable & remove Extreme Reactors Compatibility!").getBoolean(true);
		MC_MULITPART_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable MC MultiPart Compatibility", true, "Setting this to false will disable & remove MC MultiPart Compatibility!").getBoolean(true);
		GC_DECONSTRUCTOR_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Galacticraft Deconstuctor Machine Compatibility", true, "Setting this to false will disable & remove Galacticraft Deconstuctor Machine Compatibility!").getBoolean(
				true);

		SLABS_AND_STAIRS = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Enable Slab & Stairs", true, "Setting this option to false will remove all Slabs and Stairs").getBoolean(true);

		ACHIEVEMENTS = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Achievements", true, "Setting this option to false will disable & remove Achievements for ExtraPlanets").getBoolean(true);

		PRESSURE = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Pressure", true, "Setting this option to false will disable & remove the Presssure System").getBoolean(true);
		RADIATION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Radiation", true, "Setting this option to false will disable & remove the Radiation System").getBoolean(true);

		ORE_LEAD_GENERATION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable generation of Lead Ore in the Overworld", true, "Setting this option to false will completely remove Lead Ore/Ingot from the world").getBoolean(true);
		ORE_LEAD_GENERATION_AMOUNT = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Amount of Lead Ore Generation per chunk", 5, "This option is used for changing the Lead Ore Spawn Rate [range: 0 ~ 2147483647, default: 5]").getInt();

		USE_CUSTOM_CELESTAIAL_SELECTION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Use Custom Galaxy Map/Celestaial Selection Screen", true,
				"Setting this option to false, will change it back to be using the Galacticraft Galaxy Map/Celestaial Selection Screen").getBoolean(true);

		CUSTOM_GALAXIES = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Custom Galaxies on Celestaial Selection Screen", true,
				"Setting this option to false will disable & remove the Custom Galaxies on Celestaial Selection Screen (Note: Will get disabled by the 'Use Custom Galaxy Map/Celestaial Selection Screen' option)").getBoolean(true);

		MERCURY_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Mercury Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		CERES_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Ceres Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		JUPITER_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Jupiter Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		SATURN_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Saturn Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		URANUS_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Uranus Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		NEPTUNE_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Neptune Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		PLUTO_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Pluto Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		ERIS_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Eris Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		MAKEMAKE_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Makemake Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		HAUMEA_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Haumea Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		KUIPER_BELT_DISTANCE_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kuiper Belt Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();

		KEPLER22_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler22 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER22_SYSTEM_Y_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler22 Planet Map Y Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER22_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler22 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER47_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler47 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER47_SYSTEM_Y_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler47 Planet Map Y Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER47_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler47 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER62_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler62 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER62_SYSTEM_Y_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler62 Planet Map Y Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER62_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler62 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER69_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler69 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER69_SYSTEM_Y_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler69 Planet Map Y Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER69_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler69 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();

		DEBUG_MODE = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Debug Mode (For testing purposes and debugging bugs)", false, "Setting this option to false will enable debug messages in to the console").getBoolean(false);

		MARS_ROVER = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Enable Mars Rover & Its Parts", true, "Setting this option to false will remove the Mars Rover Entity & Schematic & Parts needed to Craft it").getBoolean(true);
		VENUS_ROVER = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Enable Venus Rover & Its Parts", true, "Setting this option to false will remove the Venus Rover Entity & Schematic & Parts needed to Craft it").getBoolean(true);

		OLD_STYLE_GRAVITY = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Old Style Gravity", false, "This option will change all the gravity of Planets & Moons back to the old style of gravity").getBoolean(false);
		OLD_ROCKET_MODELS = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Old Models for Tier 9 & 10 Rockets", false, "This option will change all the Tier 9 & 10 Rockets models to the old type").getBoolean(false);

		MERCURY_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Mercury Villages", true, "Setting this option to false will disable & remove the Mercury Villages generation").getBoolean(true);
		CERES_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Ceres Villages", true, "Setting this option to false will disable & remove the Ceres Villages generation").getBoolean(true);
		JUPITER_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Jupiter Villages", true, "Setting this option to false will disable & remove the Jupiter Villages generation").getBoolean(true);
		SATURN_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Saturn Villages", true, "Setting this option to false will disable & remove the Saturn Villages generation").getBoolean(true);
		URANUS_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Uranus Villages", true, "Setting this option to false will disable & remove the Uranus Villages generation").getBoolean(true);
		NEPTUNE_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Neptune Villages", true, "Setting this option to false will disable & remove the Neptune Villages generation").getBoolean(true);
		PLUTO_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Pluto Villages", true, "Setting this option to false will disable & remove the Pluto Villages generation").getBoolean(true);
		ERIS_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Eris Villages", true, "Setting this option to false will disable & remove the Eris Villages generation").getBoolean(true);

		if (MORE_PLANETS_COMPATIBILITY) {
			KEPLER62_SYSTEM_X_OFFSET = 0.40F;
			KEPLER62_SYSTEM_Y_OFFSET = 0.8F;
		}
		config.save();
	}

	public static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		ConfigCategory configMainDimensions = config.getCategory(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS);
		configMainDimensions.setComment("Planet & Moon Settings");
		list.add(new ConfigElement(configMainDimensions));

		ConfigCategory configOtherDimensions = config.getCategory(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS);
		configOtherDimensions.setComment("Other Dimension Settings");
		list.add(new ConfigElement(configOtherDimensions));

		ConfigCategory configDimenisonIDs = config.getCategory(Constants.CONFIG_CATEGORY_DIMENSION_IDS);
		configDimenisonIDs.setComment("Dimension IDs");
		list.add(new ConfigElement(configDimenisonIDs));

		ConfigCategory configDimensionSettings = config.getCategory(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS);
		configDimensionSettings.setComment("Dimension Settings");
		list.add(new ConfigElement(configDimensionSettings));

		ConfigCategory configItems = config.getCategory(Constants.CONFIG_CATEGORY_ITEMS);
		configItems.setComment("Item Settings");
		list.add(new ConfigElement(configItems));

		ConfigCategory configBlocks = config.getCategory(Constants.CONFIG_CATEGORY_BLOCKS);
		configBlocks.setComment("Blocks Settings");
		list.add(new ConfigElement(configBlocks));

		ConfigCategory configSpaceStations = config.getCategory(Constants.CONFIG_CATEGORY_SPACE_STATIONS);
		configSpaceStations.setComment("Space Stations Settings");
		list.add(new ConfigElement(configSpaceStations));

		ConfigCategory configSchematicGUIIDs = config.getCategory(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS);
		configSchematicGUIIDs.setComment("Schematic GUI IDs");
		list.add(new ConfigElement(configSchematicGUIIDs));

		ConfigCategory configSchematicPageIDs = config.getCategory(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS);
		configSchematicPageIDs.setComment("Schematic Page IDs");
		list.add(new ConfigElement(configSchematicPageIDs));

		ConfigCategory configCompatibility = config.getCategory(Constants.CONFIG_CATEGORY_COMPATIBILITY);
		configCompatibility.setComment("Compatibility Settings");
		list.add(new ConfigElement(configCompatibility));

		ConfigCategory configGeneralSettings = config.getCategory(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS);
		configGeneralSettings.setComment("General Settings");
		list.add(new ConfigElement(configGeneralSettings));

		ConfigCategory configCelestialMapSettings = config.getCategory(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS);
		configCelestialMapSettings.setComment("Celestial Map Settings");
		list.add(new ConfigElement(configCelestialMapSettings));
		return list;
	}
}
