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
	public static boolean OXYGEN_COMPRESSOR_ADVANCED;
	public static boolean OXYGEN_COMPRESSOR_ULTIMATE;
	public static boolean SLABS_AND_STAIRS = false;
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
	public static int SATURN_BIOME_ID;
	public static int URANUS_BIOME_ID;
	public static int NEPTUNE_BIOME_ID;
	public static int PLUTO_BIOME_ID;
	public static int ERIS_BIOME_ID;

	public static int TRITON_BIOME_ID;
	public static int TRITON_ICE_LANDS_BIOME_ID;
	public static int TRITON_ICE_SEA_BIOME_ID;
	public static int EUROPA_BIOME_ID;
	public static int IO_BIOME_ID;
	public static int DEIMOS_BIOME_ID;
	public static int PHOBOS_BIOME_ID;
	public static int CALLISTO_BIOME_ID;
	public static int GANTMEDE_BIOME_ID;
	public static int RHEA_BIOME_ID;
	public static int TITAN_BIOME_ID;
	public static int TITAN_SEA_BIOME_ID;
	public static int OBERON_BIOME_ID;
	public static int TITANIA_BIOME_ID;
	public static int IAPETUS_BIOME_ID;

	public static int KEPLER22B_PLAINS_BIOME_ID;
	public static int KEPLER22B_BLUE_FOREST_BIOME_ID;
	public static int KEPLER22B_PURPLE_FOREST_BIOME_ID;
	public static int KEPLER22B_RED_FOREST_BIOME_ID;
	public static int KEPLER22B_YELLOW_FOREST_BIOME_ID;
	public static int KEPLER22B_RED_DESERT_BIOME_ID;
	
	public static boolean JUPITER_LIQUID;
	public static boolean SATURN_LIQUID;
	public static boolean URANUS_LIQUID;
	public static boolean NEPTUNE_LIQUID;
	public static boolean ORE_DICTIONARY;
	public static boolean ORE_DICTIONARY_INGOTS;
	
	public static int SCHEMATIC_TIER_4_GUI_ID;
	public static int SCHEMATIC_TIER_5_GUI_ID;
	public static int SCHEMATIC_TIER_6_GUI_ID;
	public static int SCHEMATIC_TIER_7_GUI_ID;
	public static int SCHEMATIC_TIER_8_GUI_ID;
	public static int SCHEMATIC_TIER_9_GUI_ID;
	public static int SCHEMATIC_TIER_10_GUI_ID;
	public static int SCHEMATIC_MARS_ROVER_GUI_ID;
	public static int SCHEMATIC_VENUS_ROVER_GUI_ID;

	public static int SCHEMATIC_TIER_4_PAGE_ID;
	public static int SCHEMATIC_TIER_5_PAGE_ID;
	public static int SCHEMATIC_TIER_6_PAGE_ID;
	public static int SCHEMATIC_TIER_7_PAGE_ID;
	public static int SCHEMATIC_TIER_8_PAGE_ID;
	public static int SCHEMATIC_TIER_9_PAGE_ID;
	public static int SCHEMATIC_TIER_10_PAGE_ID;
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
	
	public static void load() {
		Configuration config = new Configuration(new File(Constants.CONFIG_FILE));
		config.load();

		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Change if a dimension ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_BIOME_IDS, "Change if a biome ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Disabling this will remove the planet with all the related items/block!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Enable/Disable dimension settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Disabling this will remove the planet/moon with all the related items/block//space stations!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Change if a Schematic GUI ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Change if a Schematic Page ID is causing conflicts!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_ITEMS,
				"Changing to false will disable the tool & armor or items (Note: Tools & Armors will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_BLOCKS, "Changing to false will disable the blocks/machines");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_DIMENSION_BLOCK_SETTINGS, "Note: The " + "\"" + "Surface & Sub-Surface blocks are Liquid" + "\"" + " option can cause lag! And It will disable the villages for that planet!");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_SPACE_STATIONS,
				"Disabling this will remove the space station from the planet (Note: Will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable/Disable compatibility settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable/Disable general settings");
		config.addCustomCategoryComment(Constants.CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS, "Advanced options for Celestial Body Map tp change locations of planets and solar systems! (For Advanced Users ONLY!)");

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
		USE_DEFAULT_BOSSES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Use default bosses for all planets", false, "Will disable all custom bosses and will replace them with Creeper Bosses!").getBoolean(false);

		ROCKET_TIER_CERES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Ceres Rocket required", 4).getInt();

		GENERATE_URANUS_IGLOOS = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Igloos on Uranus", true, "Will disable Igloos from generating on Uranus").getBoolean(true);
		GENERATE_URANUS_ICE_SPIKES = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Ice Spikes on Uranus", true, "Will disable Ice Spikes from generating on Uranus").getBoolean(true);
		GENERATE_JUITPER_SKY_FEATURE = config.get(Constants.CONFIG_CATEGORY_DIMENSION_SETTINGS, "Generate Sky Feature on Juitper", true, "Will disable the Sky Feature on Juitper").getBoolean(true);

		CERES = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Ceres", true).getBoolean(true);

		TRITON = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Triton", true, "").getBoolean(true);
		EUROPA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Europa", true, "").getBoolean(true);
		IO = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "IO", true, "").getBoolean(true);
		DEIMOS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Deimos", true, "").getBoolean(true);
		PHOBOS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Phobos", true, "").getBoolean(true);
		CALLISTO = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Callisto", true, "").getBoolean(true);
		GANYMEDE = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Ganymede", true, "").getBoolean(true);
		RHEA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Rhea", true, "").getBoolean(true);
		TITAN = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Titan", true, "").getBoolean(true);
		OBERON = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Oberon", true, "").getBoolean(true);
		TITANIA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Titania", true, "").getBoolean(true);
		IAPETUS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Iapetus", true, "").getBoolean(true);

		HAUMEA = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Haumea", true, "").getBoolean(true);
		MAKEMAKE = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Makemake", true, "").getBoolean(true);
		KUIPER_BELT = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Kuiper Belt", true, "").getBoolean(true);
		KEPLER_SOLAR_SYSTEMS = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Kepler SolarSystems", true, "").getBoolean(true);

		KEPLER22B = config.get(Constants.CONFIG_CATEGORY_OTHER_DIMENSIONS, "Kepler 22b", true, "").getBoolean(true);

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

		MERCURY = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Mercury & Tier 4 Rocket", true, "Disabling this will remove the Mercury & Tier 4 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		JUPITER = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Jupiter & Tier 5 Rocket", true, "Disabling this will remove the Jupiter & Tier 5 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		SATURN = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Saturn & Tier 6 Rocket", true, "Disabling this will remove the Saturn & Tier 6 Rocket with all the related items/block/tools/armour!/space stations").getBoolean(true);
		URANUS = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Uranus & Tier 7 Rocket", true, "Disabling this will remove the Uranus & Tier 7 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		NEPTUNE = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Neptune & Tier 8 Rocket", true, "Disabling this will remove the Neptune & Tier 8 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		PLUTO = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Pluto & Tier 9 Rocket", true, "Disabling this will remove the Pluto & Tier 9 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		ERIS = config.get(Constants.CONFIG_CATEGORY_MAIN_DIMENSIONS, "Eris & Tier 10 Rocket", true, "Disabling this will remove the Eris & Tier 10 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);

		JUPITER_LIQUID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_BLOCK_SETTINGS, "Jupiter's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		SATURN_LIQUID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_BLOCK_SETTINGS, "Saturn's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		URANUS_LIQUID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_BLOCK_SETTINGS, "Uranus's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		NEPTUNE_LIQUID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_BLOCK_SETTINGS, "Neptune's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);

		MERCURY_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mercury Dimension ID", -13).getInt();
		CERES_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ceres Dimension ID", -20).getInt();
		JUPITER_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Jupiter Dimension ID", -15).getInt();
		SATURN_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Saturn Dimension ID", -16).getInt();
		URANUS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Uranus Dimension ID", -17).getInt();
		NEPTUNE_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Neptune Dimension ID", -18).getInt();
		PLUTO_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Pluto Dimension ID", -19).getInt();
		ERIS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Eris Dimension ID", -21).getInt();

		IO_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Io Dimension ID", -32).getInt();
		EUROPA_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Europa Dimension ID", -34).getInt();
		PHOBOS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Phobos Dimension ID", -33).getInt();
		DEIMOS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Deimos Dimension ID", -35).getInt();
		TRITON_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Triton Dimension ID", -36).getInt();
		CALLISTO_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Callisto Dimension ID", -37).getInt();
		GANYMEDE_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ganymede Dimension ID", -38).getInt();
		RHEA_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Rhea Dimension ID", -39).getInt();
		TITAN_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Titan Dimension ID", -40).getInt();
		OBERON_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Oberon Dimension ID", -41).getInt();
		TITANIA_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Titania Dimension ID", -42).getInt();
		IAPETUS_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Iapetus Dimension ID", -43).getInt();

		KEPLER22B_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Kepler 22b Dimension ID", -22).getInt();

		MERCURY_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mercury SpaceStation Dimension ID", -61).getInt();
		MERCURY_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mercury SpaceStation Static Dimension ID", -60).getInt();

		VENUS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Venus SpaceStation Dimension ID", -63).getInt();
		VENUS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Venus SpaceStation Static Dimension ID", -62).getInt();

		CERES_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ceres SpaceStation Dimension ID", -65).getInt();
		CERES_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Ceres SpaceStation Static Dimension ID", -64).getInt();

		MARS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mars SpaceStation Dimension ID", -67).getInt();
		MARS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Mars SpaceStation Static Dimension ID", -66).getInt();

		JUPITER_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Jupiter SpaceStation Dimension ID", -69).getInt();
		JUPITER_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Jupiter SpaceStation Static Dimension ID", -68).getInt();

		SATURN_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Saturn SpaceStation Dimension ID", -71).getInt();
		SATURN_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Saturn SpaceStation Static Dimension ID", -70).getInt();

		URANUS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Uranus SpaceStation Dimension ID", -73).getInt();
		URANUS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Uranus SpaceStation Static Dimension ID", -72).getInt();

		NEPTUNE_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Neptune SpaceStation Dimension ID", -75).getInt();
		NEPTUNE_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Neptune SpaceStation Static Dimension ID", -74).getInt();

		PLUTO_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Pluto SpaceStation Dimension ID", -77).getInt();
		PLUTO_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Pluto SpaceStation Static Dimension ID", -76).getInt();

		ERIS_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Eris SpaceStation Dimension ID", -79).getInt();
		ERIS_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Eris SpaceStation Static Dimension ID", -78).getInt();

		KEPLER22B_SPACE_STATION_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Kepler 22b SpaceStation Dimension ID", -81).getInt();
		KEPLER22B_SPACE_STATION_STATIC_ID = config.get(Constants.CONFIG_CATEGORY_DIMENSION_IDS, "Kepler 22b SpaceStation Static Dimension ID", -80).getInt();

		MERCURY_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Mercury Biome ID", 148).getInt();
		CERES_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Ceres Biome ID", 155).getInt();
		JUPITER_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Jupiter Biome ID", 150).getInt();
		SATURN_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Saturn Biome ID", 147).getInt();
		URANUS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Uranus Biome ID", 152).getInt();
		NEPTUNE_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Neptune Biome ID", 153).getInt();
		PLUTO_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Pluto Biome ID", 154).getInt();
		ERIS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Eris Biome ID", 184).getInt();
		EUROPA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Europa Biome ID", 183).getInt();
		IO_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Io Biome ID", 182).getInt();
		DEIMOS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Deimos Biome ID", 159).getInt();
		PHOBOS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Phobos Biome ID", 168).getInt();
		TRITON_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Triton Biome ID", 169).getInt();
		CALLISTO_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Callisto Biome ID", 170).getInt();
		GANTMEDE_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Ganymede Biome ID", 171).getInt();
		RHEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Rhea Biome ID", 172).getInt();
		TITAN_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Titan Biome ID", 173).getInt();
		KEPLER22B_PLAINS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Plains Biome ID", 174).getInt();
		KEPLER22B_BLUE_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Blue Maple Forest Biome ID", 175).getInt();
		KEPLER22B_PURPLE_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Purple Maple Forest Biome ID", 176).getInt();
		KEPLER22B_RED_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Blue Red Forest Biome ID", 177).getInt();
		KEPLER22B_YELLOW_FOREST_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Yellow Maple Forest Biome ID", 178).getInt();
		OBERON_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Oberon Biome ID", 179).getInt();
		TITANIA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Titania Biome ID", 180).getInt();
		IAPETUS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Iapetus Biome ID", 181).getInt();
		KEPLER22B_RED_DESERT_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Kepler22b Red Desert Biome ID", 185).getInt();
		TITAN_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Titan Sea Biome ID", 186).getInt();
		TRITON_ICE_LANDS_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Triton Ice Lands Biome ID", 187).getInt();
		TRITON_ICE_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Triton Ice Sea Biome ID", 188).getInt();
		JUPITER_SEA_BIOME_ID = config.get(Constants.CONFIG_CATEGORY_BIOME_IDS, "Jupiter SEA Biome ID", 189).getInt();

		SCHEMATIC_TIER_4_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 4 GUI ID", 5555).getInt();
		SCHEMATIC_TIER_5_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 5 GUI ID", 5556).getInt();
		SCHEMATIC_TIER_6_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 6 GUI ID", 5557).getInt();
		SCHEMATIC_TIER_7_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 7 GUI ID", 5558).getInt();
		SCHEMATIC_TIER_8_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 8 GUI ID", 5559).getInt();
		SCHEMATIC_TIER_9_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 9 GUI ID", 5560).getInt();
		SCHEMATIC_TIER_10_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Tier 10 GUI ID", 5561).getInt();
		SCHEMATIC_MARS_ROVER_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Mars Rover GUI ID", 5562).getInt();
		SCHEMATIC_VENUS_ROVER_GUI_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Venus Rover GUI ID", 5563).getInt();

		SCHEMATIC_TIER_4_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 4 Page ID", 6666).getInt();
		SCHEMATIC_TIER_5_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 5 Page ID", 6667).getInt();
		SCHEMATIC_TIER_6_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 6 Page ID", 6668).getInt();
		SCHEMATIC_TIER_7_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 7 Page ID", 6669).getInt();
		SCHEMATIC_TIER_8_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 8 Page ID", 6670).getInt();
		SCHEMATIC_TIER_9_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 9 Page ID", 6671).getInt();
		SCHEMATIC_TIER_10_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS, "Schematic Tier 10 Page ID", 6672).getInt();
		SCHEMATIC_MARS_ROVER_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Mars Rover Page ID", 6673).getInt();
		SCHEMATIC_VENUS_ROVER_PAGE_ID = config.get(Constants.CONFIG_CATEGORY_SCHEMATIC_GUI_IDS, "Schematic Venus Rover Page ID", 6674).getInt();
		
		NEI_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable NEI Recipe support", true, "").getBoolean(true);
		JEI_SUPPORT = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Enable JEI Recipe support", true, "").getBoolean(true);

		ORE_DICTIONARY = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Add planet/moons ores to the ore dictionary", true, "Setting this to false will disable all Ore Dictionary Support for Planet and Moon Ores!").getBoolean(true);
		ORE_DICTIONARY_INGOTS = config.get(Constants.CONFIG_CATEGORY_COMPATIBILITY, "Add all ingots to the ore dictionary", true, "Setting this to false will disable all Ore Dictionary Support for All Ingots!").getBoolean(true);

		ACHIEVEMENTS = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable achievements", true, "").getBoolean(true);

		PRESSURE = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable pressure", true, "").getBoolean(true);
		RADIATION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable radiation", true, "").getBoolean(true);

		ORE_LEAD_GENERATION = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable generation of Lead Ore in the Overworld", true, "").getBoolean(true);
		ORE_LEAD_GENERATION_AMOUNT = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Amount of Lead Ore Generation per chunk", 5).getInt();
		
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
		
		DEBUG_MODE = config.get(Constants.CONFIG_CATEGORY_GENERAL_SETTINGS, "Enable Debug Mode (For testing purposes and debugging bugs)", false, "").getBoolean(false);
		
		MARS_ROVER = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Enable Mars Rover & Its Parts", true, "").getBoolean(true);
		VENUS_ROVER = config.get(Constants.CONFIG_CATEGORY_ITEMS, "Enable Venus Rover & Its Parts", true, "").getBoolean(true);
		
		config.save();
	}

}
