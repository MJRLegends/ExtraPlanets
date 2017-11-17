package com.mjr.extraplanets;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	// Config options
	public static boolean MOB_SUFFOCATION;
	public static boolean USE_DEFAULT_BOSSES;

	public static int ROCKET_TIER_CERES;

	public static boolean GENERATE_URANUS_IGLOOS;
	public static boolean GENERATE_URANUS_ICE_SPIKES;
	public static boolean GENERATE_JUITPER_SKY_FEATURE;

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

	public static int MERCURY_BIOME_ID;
	public static int VENUS_BIOME_ID;
	public static int CERES_BIOME_ID;
	public static int JUPITER_BIOME_ID;
	public static int JUPITER_SEA_BIOME_ID;
	public static int JUPITER_SANDS_BIOME_ID;
	public static int SATURN_BIOME_ID;
	public static int SATURN_HYDROCARBON_SEA_BIOME_ID;
	public static int SATURN_NUCLEAR_LAND_BIOME_ID;
	public static int URANUS_BIOME_ID;
	public static int URANUS_FROZEN_SEA_BIOME_ID;
	public static int URANUS_SNOW_LANDS_BIOME_ID;
	public static int NEPTUNE_BIOME_ID;
	public static int NEPTUNE_RADIO_ACTIVE_WATER_SEA_BIOME_ID;
	public static int NEPTUNE_LAYERED_HILLS_BIOME_ID;
	public static int PLUTO_BIOME_ID;
	public static int ERIS_BIOME_ID;

	public static int TRITON_BIOME_ID;
	public static int TRITON_ICE_LANDS_BIOME_ID;
	public static int TRITON_ICE_SEA_BIOME_ID;
	public static int EUROPA_BIOME_ID;
	public static int IO_BIOME_ID;
	public static int IO_ASH_LANDS_BIOME_ID;
	public static int DEIMOS_BIOME_ID;
	public static int PHOBOS_BIOME_ID;
	public static int CALLISTO_BIOME_ID;
	public static int GANTMEDE_BIOME_ID;
	public static int RHEA_BIOME_ID;
	public static int TITAN_BIOME_ID;
	public static int TITAN_SEA_BIOME_ID;
	public static int OBERON_BIOME_ID;
	public static int OBERON_LARGE_MOUNTAIN_BIOME_ID;
	public static int OBERON_VALLEYS_BIOME_ID;
	public static int TITANIA_BIOME_ID;
	public static int IAPETUS_BIOME_ID;
	public static int KEPLER22B_CANDY_LAND_BIOME_ID;
	
	public static int KEPLER22B_PLAINS_BIOME_ID;
	public static int KEPLER22B_BLUE_FOREST_BIOME_ID;
	public static int KEPLER22B_PURPLE_FOREST_BIOME_ID;
	public static int KEPLER22B_RED_FOREST_BIOME_ID;
	public static int KEPLER22B_YELLOW_FOREST_BIOME_ID;
	public static int KEPLER22B_RED_DESERT_BIOME_ID;
	public static int KEPLER22B_WASTE_LANDS_BIOME_ID;

	public static boolean ORE_DICTIONARY;
	public static boolean ORE_DICTIONARY_INGOTS;

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
	public static float KEPLER22_SYSTEM_Z_OFFSET;
	public static float KEPLER47_SYSTEM_X_OFFSET;
	public static float KEPLER47_SYSTEM_Z_OFFSET;
	public static float KEPLER62_SYSTEM_X_OFFSET;
	public static float KEPLER62_SYSTEM_Z_OFFSET;
	public static float KEPLER69_SYSTEM_X_OFFSET;
	public static float KEPLER69_SYSTEM_Z_OFFSET;

	public static boolean DEBUG_MODE;

	public static boolean MARS_ROVER;
	public static boolean VENUS_ROVER;

	public static boolean OLD_STYLE_GRAVITY;

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

	public static void load() {
		Configuration config = new Configuration(new File(Constants.CONFIG_FILE));
		config.load();

		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Change if a dimension ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_BIOME_IDS, "Change if a biome ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Setting this option to false will remove the planet with all the related items/block!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable/Disable dimension settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Setting this option to false will remove the planet/moon with all the related items/block//space stations!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Change if a Schematic GUI ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Change if a Schematic Page ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_ITEMS,
				"Changing to false will disable the tool & armor or items (Note: Tools & Armors will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_BLOCKS, "Changing to false will disable the blocks/machines");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SPACE_STATIONS,
				"Setting this option to false will remove the space station from the planet (Note: Will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable/Disable compatibility settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable/Disable general settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Advanced options for Celestial Body Map to change locations of planets and solar systems! (For Advanced Users ONLY!)");

		ITEMS_CARBON = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Carbon Tools & Armor", true).getBoolean(true);
		ITEMS_PALLADIUM = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Palladium Tools & Armor", true).getBoolean(true);
		ITEMS_MAGNESIUM = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Magnesium Tools & Armor", true).getBoolean(true);
		ITEMS_CRYSTAL = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Crystal Tools & Armor", true).getBoolean(true);
		ITEMS_TUNGSTEN = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Tungsten Tools & Armor", true).getBoolean(true);
		ITEMS_GEM_RED = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Red Gem Tools & Armor", true).getBoolean(true);
		ITEMS_GEM_BLUE = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Blue Gem Tools & Armor", true).getBoolean(true);
		ITEMS_GEM_WHITE = config.get(Constants.CONFIG_CATEGORY_ITEMS, "White Gem Tools & Armor", true).getBoolean(true);
		ITEMS_ZINC = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Zinc Tools & Armor", true).getBoolean(true);
		ITEMS_MERCURY = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Mercury Tools & Armor", true).getBoolean(true);
		ITEMS_URANIUM = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Uranium Tools & Armor", true).getBoolean(true);
		ITEMS_KEPLER22B = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Kepler22b Tools & Armor", true).getBoolean(true);

		THERMAL_PADDINGS = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Tier 3 - 4 Thermal Padding", true, "This option will change planet thermal levels to support this feature!").getBoolean(true);
		BATTERIES = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Batteries", true, "This option will disable all Custom Batteries!").getBoolean(true);
		CANNED_FOOD = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Canned Food", true, "This option will disable all Custom Canned Food!").getBoolean(true);
		CUSTOM_APPLES = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Iron & Diamomd Normal/Notch Apples", true, "This option will disable all Custom Normal/Notch Apples!").getBoolean(true);
		OXYGEN_TANKS = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Custom Oxygen Tanks", true, "This option will disable Extremely Heavy & Very Heavy Oxygen Tanks").getBoolean(true);

		SOLAR_PANELS = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Hybrid/Ultimate Solar Panel", true).getBoolean(true);
		REFINERY_ADVANCED = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Advanced Refinery", true).getBoolean(true);
		REFINERY_ULTIMATE = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Ultimate Refinery", true).getBoolean(true);
		FUEL_LOADER_ADVANCED = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Advanced Fuel Loader", true).getBoolean(true);
		FUEL_LOADER_ULTIMATE = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Ultimate Fuel Loader", true).getBoolean(true);
		OXYGEN_COMPRESSOR_ADVANCED = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Advanced Compressor/Decompressor", true).getBoolean(true);
		OXYGEN_COMPRESSOR_ULTIMATE = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Ultimate Compressor/Decompressor", true).getBoolean(true);
		NUCLEAR_BOMB = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Nuclear Bomb", true).getBoolean(true);
		FIRE_BOMB = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Fire Bomb", true).getBoolean(true);

		BASIC_DECRYSTALLIZER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Decrystallizer", true).getBoolean(true);
		BASIC_CRYSTALLIZER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Crystallizer", true).getBoolean(true);
		BASIC_SMASHER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Block Smasher", true).getBoolean(true);
		BASIC_CHEMICAL_INJECTOR = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Chemical Injector", true).getBoolean(true);
		BASIC_SOLAR_EVAPORTATION_CHAMBER = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Basic Solar Evaporation Chamber", true).getBoolean(true);

		MOB_SUFFOCATION = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Mob Suffocation", true, "Setting this to false will make mobs not suffocate on planets but the player will!").getBoolean(true);
		USE_DEFAULT_BOSSES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Use default bosses for all planets", false, "Setting this option to false will disable all custom bosses and will replace them with Creeper Bosses!").getBoolean(false);

		ROCKET_TIER_CERES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Ceres Rocket required", 4, "[range: 0 ~ 2147483647, default: 4]").getInt();

		GENERATE_URANUS_IGLOOS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Igloos on Uranus", true, "Setting this option to false will disable Igloos from generating on Uranus").getBoolean(true);
		GENERATE_URANUS_ICE_SPIKES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Ice Spikes on Uranus", true, "Setting this option to false will disable Ice Spikes from generating on Uranus").getBoolean(true);
		GENERATE_JUITPER_SKY_FEATURE = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Sky Feature on Juitper", true, "Setting this option to false will disable the Sky Feature on Juitper").getBoolean(true);

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

		MERCURY_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Mercury SpaceStation", true, "").getBoolean(true);
		VENUS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Venus SpaceStation", true, "").getBoolean(true);
		CERES_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Ceres SpaceStation", true, "").getBoolean(true);
		MARS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Mars SpaceStation", true, "").getBoolean(true);
		JUPITER_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Jupiter SpaceStation", true, "").getBoolean(true);
		SATURN_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Saturn SpaceStation", true, "").getBoolean(true);
		URANUS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Uranus SpaceStation", true, "").getBoolean(true);
		NEPTUNE_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Neptune SpaceStation", true, "").getBoolean(true);
		PLUTO_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Pluto SpaceStation", true, "").getBoolean(true);
		ERIS_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Eris SpaceStation", true, "").getBoolean(true);
		KEPLER22B_SPACE_STATION = config.get(Constants.CONFIG_CATEGORY_SPACE_STATIONS, "Kepler22b SpaceStation", true, "").getBoolean(true);

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

		MERCURY_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Mercury Biome ID", 148, "[range: 0 ~ 255, default: 148]").getInt();
		CERES_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Ceres Biome ID", 155, "[range: 0 ~ 255, default: 155]").getInt();
		JUPITER_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Jupiter Biome ID", 150, "[range: 0 ~ 255, default: 150]").getInt();
		SATURN_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Saturn Biome ID", 147, "[range: 0 ~ 255, default: 147]").getInt();
		URANUS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Uranus Biome ID", 152, "[range: 0 ~ 255, default: 152]").getInt();
		NEPTUNE_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Neptune Biome ID", 153, "[range: 0 ~ 255, default: 153]").getInt();
		PLUTO_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Pluto Biome ID", 154, "[range: 0 ~ 255, default: 154]").getInt();
		ERIS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Eris Biome ID", 184, "[range: 0 ~ 255, default: 184]").getInt();
		EUROPA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Europa Biome ID", 183, "[range: 0 ~ 255, default: 183]").getInt();
		IO_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Io Biome ID", 182, "[range: 0 ~ 255, default: 182]").getInt();
		DEIMOS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Deimos Biome ID", 159, "[range: 0 ~ 255, default: 159]").getInt();
		PHOBOS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Phobos Biome ID", 168, "[range: 0 ~ 255, default: 168]").getInt();
		TRITON_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Triton Biome ID", 169, "[range: 0 ~ 255, default: 169]").getInt();
		CALLISTO_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Callisto Biome ID", 170, "[range: 0 ~ 255, default: 170]").getInt();
		GANTMEDE_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Ganymede Biome ID", 171, "[range: 0 ~ 255, default: 171]").getInt();
		RHEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Rhea Biome ID", 172, "[range: 0 ~ 255, default: 172]").getInt();
		TITAN_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Titan Biome ID", 173, "[range: 0 ~ 255, default: 173]").getInt();
		KEPLER22B_PLAINS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Plains Biome ID", 174, "[range: 0 ~ 255, default: 174]").getInt();
		KEPLER22B_BLUE_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Blue Maple Forest Biome ID", 175, "[range: 0 ~ 255, default: 175]").getInt();
		KEPLER22B_PURPLE_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Purple Maple Forest Biome ID", 176, "[range: 0 ~ 255, default: 176]").getInt();
		KEPLER22B_RED_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Blue Red Forest Biome ID", 177, "[range: 0 ~ 255, default: 177]").getInt();
		KEPLER22B_YELLOW_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Yellow Maple Forest Biome ID", 178, "[range: 0 ~ 255, default: 178]").getInt();
		OBERON_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Oberon Biome ID", 179, "[range: 0 ~ 255, default: 179]").getInt();
		TITANIA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Titania Biome ID", 180, "[range: 0 ~ 255, default: 180]").getInt();
		IAPETUS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Iapetus Biome ID", 181, "[range: 0 ~ 255, default: 181]").getInt();
		KEPLER22B_RED_DESERT_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Red Desert Biome ID", 185, "[range: 0 ~ 255, default: 185]").getInt();
		TITAN_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Titan Sea Biome ID", 186, "[range: 0 ~ 255, default: 186]").getInt();
		TRITON_ICE_LANDS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Triton Ice Lands Biome ID", 187, "[range: 0 ~ 255, default: 187]").getInt();
		TRITON_ICE_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Triton Ice Sea Biome ID", 188, "[range: 0 ~ 255, default: 188]").getInt();
		JUPITER_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Jupiter Sea Biome ID", 189, "[range: 0 ~ 255, default: 189]").getInt();
		IO_ASH_LANDS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Io Ash Lands Biome ID", 190, "[range: 0 ~ 255, default: 190]").getInt();
		URANUS_FROZEN_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Uranus Frozen Sea Biome ID", 191, "[range: 0 ~ 255, default: 191]").getInt();
		URANUS_SNOW_LANDS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Uranus Snow Lands Biome ID", 192, "[range: 0 ~ 255, default: 192]").getInt();
		OBERON_LARGE_MOUNTAIN_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Oberon Large Mountain Biome ID", 193, "[range: 0 ~ 255, default: 193]").getInt();
		OBERON_VALLEYS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Oberon Valleys Biome ID", 194, "[range: 0 ~ 255, default: 194]").getInt();
		KEPLER22B_WASTE_LANDS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Waste Lands Biome ID", 195, "[range: 0 ~ 255, default: 195]").getInt();
		JUPITER_SANDS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Jupiter Sands Biome ID", 196, "[range: 0 ~ 255, default: 196]").getInt();
		KEPLER22B_CANDY_LAND_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Candy Land Biome ID", 197, "[range: 0 ~ 255, default: 197]").getInt();
		SATURN_HYDROCARBON_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Saturn HydroCarbon Sea Biome ID", 198, "[range: 0 ~ 255, default: 198]").getInt();
		NEPTUNE_RADIO_ACTIVE_WATER_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Neptune Radio Active Water Sea Biome ID", 199, "[range: 0 ~ 255, default: 199]").getInt();
		NEPTUNE_LAYERED_HILLS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Neptune Layered Hills Biome ID", 200, "[range: 0 ~ 255, default: 200]").getInt();
		SATURN_NUCLEAR_LAND_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Saturn Nuclear Land Biome ID", 201, "[range: 0 ~ 255, default: 201]").getInt();
		
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

		NEI_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable NEI Recipe support", true, "Setting this to false will disable the JEI Support for Custom Machines/Rockets/Vehicles").getBoolean(true);
		JEI_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable JEI Recipe support", true, "Setting this to false will disable the NEI Support for Custom Machines/Rockets/Vehicles").getBoolean(true);

		ORE_DICTIONARY = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Adding of All Planet/Moons Ores to the Ore Dictionary", true, "Setting this to false will disable all Ore Dictionary Support for Planet and Moon Ores!").getBoolean(
				true);
		ORE_DICTIONARY_INGOTS = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable Adding of all Ingots to the Ore Dictionary", true, "Setting this to false will disable all Ore Dictionary Support for All Ingots!").getBoolean(true);

		MORE_PLANETS_COMPATIBILITY = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable More Planets Compatibility", false, "FOR THIS TO WORK YOU WILL NEED TO DISABLED ALL CONFIG OPTIONS IN THE MORE PLANETS CONFIG UNDER THE 'config_moreplanets_gc_addon_compat' SECTION!").getBoolean(false);
		
		SLABS_AND_STAIRS = config.get(Constants.CONFIG_CATEGORY_BLOCKS, "Enable Slab & Stairs", true, "Setting this option to false will remove all Slabs and Stairs").getBoolean(true);

		ACHIEVEMENTS = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Achievements", true, "Setting this option to false will disable Achievements for ExtraPlanets").getBoolean(true);

		PRESSURE = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Pressure", true, "Setting this option to false will disable the Presssure System").getBoolean(true);
		RADIATION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Radiation", true, "Setting this option to false will disable the Radiation System").getBoolean(true);

		ORE_LEAD_GENERATION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable generation of Lead Ore in the Overworld", true, "Setting this option to false will completely remove Lead Ore from the world").getBoolean(true);
		ORE_LEAD_GENERATION_AMOUNT = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Amount of Lead Ore Generation per chunk", 5, "This option is used for changing the Lead Ore Spawn Rate [range: 0 ~ 2147483647, default: 5]").getInt();

		USE_CUSTOM_CELESTAIAL_SELECTION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Use Custom Galaxy Map/Celestaial Selection Screen", true, "Setting this option to false make it use the Galacticraft Galaxy Map/Celestaial Selection Screen").getBoolean(true);
		
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
		KEPLER22_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler22 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER47_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler47 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER47_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler47 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER62_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler62 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER62_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler62 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER69_SYSTEM_X_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler69 Planet Map X Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		KEPLER69_SYSTEM_Z_OFFSET = (float) config.get(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Kepler69 Planet Map Z Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();

		DEBUG_MODE = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Debug Mode (For testing purposes and debugging bugs)", false, "Setting this option to false will enable debug messages in to the console").getBoolean(false);

		MARS_ROVER = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Enable Mars Rover & Its Parts", true, "Setting this option to false will remove the Mars Rover Entity & Schematic & Parts needed to Craft it").getBoolean(true);
		VENUS_ROVER = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Enable Venus Rover & Its Parts", true, "Setting this option to false will remove the Venus Rover Entity & Schematic & Parts needed to Craft it").getBoolean(true);

		OLD_STYLE_GRAVITY = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Old Style Gravity", false, "This option will change all the gravity of Planets & Moons back to the old style of gravity").getBoolean(false);

		MERCURY_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Mercury Villages", true, "").getBoolean(true);
		CERES_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Ceres Villages", true, "").getBoolean(true);
		JUPITER_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Jupiter Villages", true, "").getBoolean(true);
		SATURN_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Saturn Villages", true, "").getBoolean(true);
		URANUS_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Uranus Villages", true, "").getBoolean(true);
		NEPTUNE_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Neptune Villages", true, "").getBoolean(true);
		PLUTO_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Pluto Villages", true, "").getBoolean(true);
		ERIS_VILLAGES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable Eris Villages", true, "").getBoolean(true);

		if(MORE_PLANETS_COMPATIBILITY){
			KEPLER62_SYSTEM_Z_OFFSET = -0.5F;
		}
		config.save();
	}

}
