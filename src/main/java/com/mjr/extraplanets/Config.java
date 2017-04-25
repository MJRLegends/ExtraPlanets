package com.mjr.extraplanets;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	// Sections/Groups
	private static String MAIN_DIMENSIONS = "main dimensions";
	private static String OTHER_DIMENSIONS = "other dimensions";
	private static String DIMENSION_IDS = "dimensionID";
	private static String DIMENSION_SETTINGS = "dimension settings";
	private static String DIMENSION_BLOCK_SETTINGS = "dimension block settings";
	private static String BIOME_IDS = "biomeID";
	private static String ITEMS = "items";
	private static String BLOCKS = "blocks";
	private static String SPACE_STATIONS = "space stations";
	private static String SCHEMATIC_GUI_IDS = "schematics GUI ID";
	private static String SCHEMATIC_PAGE_IDS = "schematics Page ID";
	private static String COMPATIBILITY = "compatibility support";
	private static String GENERAL_SETTINGS = "general settings";

	// Config options
	public static boolean MOB_SUFFOCATION;
	public static boolean USE_DEFAULT_BOSSES;

	public static int ROCKET_TIER_CERES;

	public static boolean GENERATE_URANUS_IGLOOS;
	public static boolean GENERATE_URANUS_ICE_SPIKES;

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
	public static int SATURN_BIOME_ID;
	public static int URANUS_BIOME_ID;
	public static int NEPTUNE_BIOME_ID;
	public static int PLUTO_BIOME_ID;
	public static int ERIS_BIOME_ID;

	public static int TRITON_BIOME_ID;
	public static int EUROPA_BIOME_ID;
	public static int IO_BIOME_ID;
	public static int DEIMOS_BIOME_ID;
	public static int PHOBOS_BIOME_ID;
	public static int CALLISTO_BIOME_ID;
	public static int GANTMEDE_BIOME_ID;
	public static int RHEA_BIOME_ID;
	public static int TITAN_BIOME_ID;
	public static int OBERON_BIOME_ID;
	public static int TITANIA_BIOME_ID;
	public static int IAPETUS_BIOME_ID;

	public static int KEPLER22B_PLAINS_BIOME_ID;
	public static int KEPLER22B_BLUE_FOREST_BIOME_ID;
	public static int KEPLER22B_PURPLE_FOREST_BIOME_ID;
	public static int KEPLER22B_RED_FOREST_BIOME_ID;
	public static int KEPLER22B_YELLOW_FOREST_BIOME_ID;

	public static boolean JUPITER_LIQUID;
	public static boolean SATURN_LIQUID;
	public static boolean URANUS_LIQUID;
	public static boolean NEPTUNE_LIQUID;
	public static boolean ORE_DICTIONARY;

	public static int SCHEMATIC_TIER_4_GUI_ID;
	public static int SCHEMATIC_TIER_5_GUI_ID;
	public static int SCHEMATIC_TIER_6_GUI_ID;
	public static int SCHEMATIC_TIER_7_GUI_ID;
	public static int SCHEMATIC_TIER_8_GUI_ID;
	public static int SCHEMATIC_TIER_9_GUI_ID;
	public static int SCHEMATIC_TIER_10_GUI_ID;

	public static int SCHEMATIC_TIER_4_PAGE_ID;
	public static int SCHEMATIC_TIER_5_PAGE_ID;
	public static int SCHEMATIC_TIER_6_PAGE_ID;
	public static int SCHEMATIC_TIER_7_PAGE_ID;
	public static int SCHEMATIC_TIER_8_PAGE_ID;
	public static int SCHEMATIC_TIER_9_PAGE_ID;
	public static int SCHEMATIC_TIER_10_PAGE_ID;

	public static boolean NEI_SUPPORT;
	public static boolean ACHIEVEMENTS;

	public static boolean PRESSURE;
	public static boolean RADIATION;

	public static boolean ORE_LEAD_GENERATION;

	public static void load() {
		Configuration config = new Configuration(new File("config/ExtraPlanets.cfg"));
		config.load();

		config.addCustomCategoryComment(DIMENSION_IDS, "Change if a dimension ID is causing conflicts!");
		config.addCustomCategoryComment(BIOME_IDS, "Change if a biome ID is causing conflicts!");
		config.addCustomCategoryComment(MAIN_DIMENSIONS, "Disabling this will remove the planet with all the related items/block!");
		config.addCustomCategoryComment(DIMENSION_SETTINGS, "Enable/Disable dimension settings");
		config.addCustomCategoryComment(OTHER_DIMENSIONS, "Disabling this will remove the planet/moon with all the related items/block//space stations!");
		config.addCustomCategoryComment(SCHEMATIC_GUI_IDS, "Change if a Schematic GUI ID is causing conflicts!");
		config.addCustomCategoryComment(SCHEMATIC_PAGE_IDS, "Change if a Schematic Page ID is causing conflicts!");
		config.addCustomCategoryComment(ITEMS, "Changing to false will disable the tool & armor or items (Note: Tools & Armors will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(BLOCKS, "Changing to false will disable the blocks/machines");
		config.addCustomCategoryComment(DIMENSION_BLOCK_SETTINGS, "Note: The " + "\"" + "Surface & Sub-Surface blocks are Liquid" + "\"" + " option can cause lag! And It will disable the villages for that planet!");
		config.addCustomCategoryComment(SPACE_STATIONS, "Disabling this will remove the space station from the planet (Note: Will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(COMPATIBILITY, "Enable/Disable compatibility settings");
		config.addCustomCategoryComment(GENERAL_SETTINGS, "Enable/Disable general settings");

		ITEMS_CARBON = config.get(ITEMS, "Carbon Tools & Armor", true).getBoolean(true);
		ITEMS_PALLADIUM = config.get(ITEMS, "Palladium Tools & Armor", true).getBoolean(true);
		ITEMS_MAGNESIUM = config.get(ITEMS, "Magnesium Tools & Armor", true).getBoolean(true);
		ITEMS_CRYSTAL = config.get(ITEMS, "Crystal Tools & Armor", true).getBoolean(true);
		ITEMS_TUNGSTEN = config.get(ITEMS, "Tungsten Tools & Armor", true).getBoolean(true);
		ITEMS_GEM_RED = config.get(ITEMS, "Red Gem Tools & Armor", true).getBoolean(true);
		ITEMS_GEM_BLUE = config.get(ITEMS, "Blue Gem Tools & Armor", true).getBoolean(true);
		ITEMS_GEM_WHITE = config.get(ITEMS, "White Gem Tools & Armor", true).getBoolean(true);
		ITEMS_ZINC = config.get(ITEMS, "Zinc Tools & Armor", true).getBoolean(true);
		ITEMS_MERCURY = config.get(ITEMS, "Mercury Tools & Armor", true).getBoolean(true);
		ITEMS_URANIUM = config.get(ITEMS, "Uranium Tools & Armor", true).getBoolean(true);
		ITEMS_KEPLER22B = config.get(ITEMS, "Kepler22b Tools & Armor", true).getBoolean(true);

		THERMAL_PADDINGS = config.get(ITEMS, "Tier 3 - 4 Thermal Padding", true, "This option will change planet thermal levels to support this feature!").getBoolean(true);
		BATTERIES = config.get(ITEMS, "Custom Batteries", true, "This option will disable all Custom Batteries!").getBoolean(true);
		CANNED_FOOD = config.get(ITEMS, "Custom Canned Food", true, "This option will disable all Custom Canned Food!").getBoolean(true);
		CUSTOM_APPLES = config.get(ITEMS, "Custom Iron & Diamomd Normal/Notch Apples", true, "This option will disable all Custom Normal/Notch Apples!").getBoolean(true);
		OXYGEN_TANKS = config.get(ITEMS, "Custom Oxygen Tanks", true, "This option will disable Extremely Heavy & Very Heavy Oxygen Tanks").getBoolean(true);

		SOLAR_PANELS = config.get(BLOCKS, "Hybrid/Ultimate Solar Panel", true).getBoolean(true);
		REFINERY_ADVANCED = config.get(BLOCKS, "Advanced Refinery", true).getBoolean(true);
		REFINERY_ULTIMATE = config.get(BLOCKS, "Ultimate Refinery", true).getBoolean(true);
		OXYGEN_COMPRESSOR_ADVANCED = config.get(BLOCKS, "Advanced Compressor/Decompressor", true).getBoolean(true);
		OXYGEN_COMPRESSOR_ULTIMATE = config.get(BLOCKS, "Ultimate Compressor/Decompressor", true).getBoolean(true);
		NUCLEAR_BOMB = config.get(BLOCKS, "Nuclear Bomb", true).getBoolean(true);

		BASIC_DECRYSTALLIZER = config.get(BLOCKS, "Basic Decrystallizer", true).getBoolean(true);
		BASIC_CRYSTALLIZER = config.get(BLOCKS, "Basic Crystallizer", true).getBoolean(true);
		BASIC_SMASHER = config.get(BLOCKS, "Basic Block Smasher", true).getBoolean(true);
		BASIC_CHEMICAL_INJECTOR = config.get(BLOCKS, "Basic Chemical Injector", true).getBoolean(true);
		BASIC_SOLAR_EVAPORTATION_CHAMBER = config.get(BLOCKS, "Basic Solar Evaporation Chamber", true).getBoolean(true);

		MOB_SUFFOCATION = config.get(DIMENSION_SETTINGS, "Mob Suffocation", true, "Setting this to false will make mobs not suffocate on planets but the player will!").getBoolean(true);
		USE_DEFAULT_BOSSES = config.get(DIMENSION_SETTINGS, "Use default bosses for all planets", false, "Will disable all custom bosses and will replace them with Creeper Bosses!").getBoolean(false);

		ROCKET_TIER_CERES = config.get(DIMENSION_SETTINGS, "Ceres Rocket required", 4).getInt();

		GENERATE_URANUS_IGLOOS = config.get(DIMENSION_SETTINGS, "Generate Igloos on Uranus", true, "Will disable Igloos from generating on Uranus").getBoolean(true);
		GENERATE_URANUS_ICE_SPIKES = config.get(DIMENSION_SETTINGS, "Generate Ice Spikes on Uranus", true, "Will disable Ice Spikes from generating on Uranus").getBoolean(true);

		CERES = config.get(OTHER_DIMENSIONS, "Ceres", true).getBoolean(true);

		TRITON = config.get(OTHER_DIMENSIONS, "Triton", true, "").getBoolean(true);
		EUROPA = config.get(OTHER_DIMENSIONS, "Europa", true, "").getBoolean(true);
		IO = config.get(OTHER_DIMENSIONS, "IO", true, "").getBoolean(true);
		DEIMOS = config.get(OTHER_DIMENSIONS, "Deimos", true, "").getBoolean(true);
		PHOBOS = config.get(OTHER_DIMENSIONS, "Phobos", true, "").getBoolean(true);
		CALLISTO = config.get(OTHER_DIMENSIONS, "Callisto", true, "").getBoolean(true);
		GANYMEDE = config.get(OTHER_DIMENSIONS, "Ganymede", true, "").getBoolean(true);
		RHEA = config.get(OTHER_DIMENSIONS, "Rhea", true, "").getBoolean(true);
		TITAN = config.get(OTHER_DIMENSIONS, "Titan", true, "").getBoolean(true);
		OBERON = config.get(OTHER_DIMENSIONS, "Oberon", true, "").getBoolean(true);
		TITANIA = config.get(OTHER_DIMENSIONS, "Titania", true, "").getBoolean(true);
		IAPETUS = config.get(OTHER_DIMENSIONS, "Iapetus", true, "").getBoolean(true);

		HAUMEA = config.get(OTHER_DIMENSIONS, "Haumea", true, "").getBoolean(true);
		MAKEMAKE = config.get(OTHER_DIMENSIONS, "Makemake", true, "").getBoolean(true);
		KUIPER_BELT = config.get(OTHER_DIMENSIONS, "Kuiper Belt", true, "").getBoolean(true);
		KEPLER_SOLAR_SYSTEMS = config.get(OTHER_DIMENSIONS, "Kepler SolarSystems", true, "").getBoolean(true);

		KEPLER22B = config.get(OTHER_DIMENSIONS, "Kepler 22b", true, "").getBoolean(true);

		MERCURY_SPACE_STATION = config.get(SPACE_STATIONS, "Mercury SpaceStation", true, "").getBoolean(true);
		VENUS_SPACE_STATION = config.get(SPACE_STATIONS, "Venus SpaceStation", true, "").getBoolean(true);
		CERES_SPACE_STATION = config.get(SPACE_STATIONS, "Ceres SpaceStation", true, "").getBoolean(true);
		MARS_SPACE_STATION = config.get(SPACE_STATIONS, "Mars SpaceStation", true, "").getBoolean(true);
		JUPITER_SPACE_STATION = config.get(SPACE_STATIONS, "Jupiter SpaceStation", true, "").getBoolean(true);
		SATURN_SPACE_STATION = config.get(SPACE_STATIONS, "Saturn SpaceStation", true, "").getBoolean(true);
		URANUS_SPACE_STATION = config.get(SPACE_STATIONS, "Uranus SpaceStation", true, "").getBoolean(true);
		NEPTUNE_SPACE_STATION = config.get(SPACE_STATIONS, "Neptune SpaceStation", true, "").getBoolean(true);
		PLUTO_SPACE_STATION = config.get(SPACE_STATIONS, "Pluto SpaceStation", true, "").getBoolean(true);
		ERIS_SPACE_STATION = config.get(SPACE_STATIONS, "Eris SpaceStation", true, "").getBoolean(true);
		KEPLER22B_SPACE_STATION = config.get(SPACE_STATIONS, "Kepler22b SpaceStation", true, "").getBoolean(true);

		MERCURY = config.get(MAIN_DIMENSIONS, "Mercury & Tier 4 Rocket", true, "Disabling this will remove the Mercury & Tier 4 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		JUPITER = config.get(MAIN_DIMENSIONS, "Jupiter & Tier 5 Rocket", true, "Disabling this will remove the Jupiter & Tier 5 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		SATURN = config.get(MAIN_DIMENSIONS, "Saturn & Tier 6 Rocket", true, "Disabling this will remove the Saturn & Tier 6 Rocket with all the related items/block/tools/armour!/space stations").getBoolean(true);
		URANUS = config.get(MAIN_DIMENSIONS, "Uranus & Tier 7 Rocket", true, "Disabling this will remove the Uranus & Tier 7 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		NEPTUNE = config.get(MAIN_DIMENSIONS, "Neptune & Tier 8 Rocket", true, "Disabling this will remove the Neptune & Tier 8 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		PLUTO = config.get(MAIN_DIMENSIONS, "Pluto & Tier 9 Rocket", true, "Disabling this will remove the Pluto & Tier 9 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		ERIS = config.get(MAIN_DIMENSIONS, "Eris & Tier 10 Rocket", true, "Disabling this will remove the Eris & Tier 10 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);

		JUPITER_LIQUID = config.get(DIMENSION_BLOCK_SETTINGS, "Jupiter's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		SATURN_LIQUID = config.get(DIMENSION_BLOCK_SETTINGS, "Saturn's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		URANUS_LIQUID = config.get(DIMENSION_BLOCK_SETTINGS, "Uranus's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		NEPTUNE_LIQUID = config.get(DIMENSION_BLOCK_SETTINGS, "Neptune's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);

		MERCURY_ID = config.get(DIMENSION_IDS, "Mercury Dimension ID", -13).getInt();
		CERES_ID = config.get(DIMENSION_IDS, "Ceres Dimension ID", -20).getInt();
		JUPITER_ID = config.get(DIMENSION_IDS, "Jupiter Dimension ID", -15).getInt();
		SATURN_ID = config.get(DIMENSION_IDS, "Saturn Dimension ID", -16).getInt();
		URANUS_ID = config.get(DIMENSION_IDS, "Uranus Dimension ID", -17).getInt();
		NEPTUNE_ID = config.get(DIMENSION_IDS, "Neptune Dimension ID", -18).getInt();
		PLUTO_ID = config.get(DIMENSION_IDS, "Pluto Dimension ID", -19).getInt();
		ERIS_ID = config.get(DIMENSION_IDS, "Eris Dimension ID", -21).getInt();

		IO_ID = config.get(DIMENSION_IDS, "Io Dimension ID", -32).getInt();
		EUROPA_ID = config.get(DIMENSION_IDS, "Europa Dimension ID", -34).getInt();
		PHOBOS_ID = config.get(DIMENSION_IDS, "Phobos Dimension ID", -33).getInt();
		DEIMOS_ID = config.get(DIMENSION_IDS, "Deimos Dimension ID", -35).getInt();
		TRITON_ID = config.get(DIMENSION_IDS, "Triton Dimension ID", -36).getInt();
		CALLISTO_ID = config.get(DIMENSION_IDS, "Callisto Dimension ID", -37).getInt();
		GANYMEDE_ID = config.get(DIMENSION_IDS, "Ganymede Dimension ID", -38).getInt();
		RHEA_ID = config.get(DIMENSION_IDS, "Rhea Dimension ID", -39).getInt();
		TITAN_ID = config.get(DIMENSION_IDS, "Titan Dimension ID", -40).getInt();
		OBERON_ID = config.get(DIMENSION_IDS, "Oberon Dimension ID", -41).getInt();
		TITANIA_ID = config.get(DIMENSION_IDS, "Titania Dimension ID", -42).getInt();
		IAPETUS_ID = config.get(DIMENSION_IDS, "Iapetus Dimension ID", -43).getInt();

		KEPLER22B_ID = config.get(DIMENSION_IDS, "Kepler 22b Dimension ID", -22).getInt();

		MERCURY_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Mercury SpaceStation Dimension ID", -61).getInt();
		MERCURY_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Mercury SpaceStation Static Dimension ID", -60).getInt();

		VENUS_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Venus SpaceStation Dimension ID", -63).getInt();
		VENUS_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Venus SpaceStation Static Dimension ID", -62).getInt();

		CERES_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Ceres SpaceStation Dimension ID", -65).getInt();
		CERES_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Ceres SpaceStation Static Dimension ID", -64).getInt();

		MARS_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Mars SpaceStation Dimension ID", -67).getInt();
		MARS_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Mars SpaceStation Static Dimension ID", -66).getInt();

		JUPITER_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Jupiter SpaceStation Dimension ID", -69).getInt();
		JUPITER_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Jupiter SpaceStation Static Dimension ID", -68).getInt();

		SATURN_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Saturn SpaceStation Dimension ID", -71).getInt();
		SATURN_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Saturn SpaceStation Static Dimension ID", -70).getInt();

		URANUS_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Uranus SpaceStation Dimension ID", -73).getInt();
		URANUS_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Uranus SpaceStation Static Dimension ID", -72).getInt();

		NEPTUNE_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Neptune SpaceStation Dimension ID", -75).getInt();
		NEPTUNE_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Neptune SpaceStation Static Dimension ID", -74).getInt();

		PLUTO_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Pluto SpaceStation Dimension ID", -77).getInt();
		PLUTO_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Pluto SpaceStation Static Dimension ID", -76).getInt();

		ERIS_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Eris SpaceStation Dimension ID", -79).getInt();
		ERIS_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Eris SpaceStation Static Dimension ID", -78).getInt();

		KEPLER22B_SPACE_STATION_ID = config.get(DIMENSION_IDS, "Kepler 22b SpaceStation Dimension ID", -81).getInt();
		KEPLER22B_SPACE_STATION_STATIC_ID = config.get(DIMENSION_IDS, "Kepler 22b SpaceStation Static Dimension ID", -80).getInt();

		MERCURY_BIOME_ID = config.get(BIOME_IDS, "Mercury Biome ID", 148).getInt();
		CERES_BIOME_ID = config.get(BIOME_IDS, "Ceres Biome ID", 155).getInt();
		JUPITER_BIOME_ID = config.get(BIOME_IDS, "Jupiter Biome ID", 150).getInt();
		SATURN_BIOME_ID = config.get(BIOME_IDS, "Saturn Biome ID", 147).getInt();
		URANUS_BIOME_ID = config.get(BIOME_IDS, "Uranus Biome ID", 152).getInt();
		NEPTUNE_BIOME_ID = config.get(BIOME_IDS, "Neptune Biome ID", 153).getInt();
		PLUTO_BIOME_ID = config.get(BIOME_IDS, "Pluto Biome ID", 154).getInt();
		ERIS_BIOME_ID = config.get(BIOME_IDS, "Eris Biome ID", 184).getInt();
		EUROPA_BIOME_ID = config.get(BIOME_IDS, "Europa Biome ID", 183).getInt();
		IO_BIOME_ID = config.get(BIOME_IDS, "Io Biome ID", 182).getInt();
		DEIMOS_BIOME_ID = config.get(BIOME_IDS, "Deimos Biome ID", 159).getInt();
		PHOBOS_BIOME_ID = config.get(BIOME_IDS, "Phobos Biome ID", 168).getInt();
		TRITON_BIOME_ID = config.get(BIOME_IDS, "Triton Biome ID", 169).getInt();
		CALLISTO_BIOME_ID = config.get(BIOME_IDS, "Callisto Biome ID", 170).getInt();
		GANTMEDE_BIOME_ID = config.get(BIOME_IDS, "Ganymede Biome ID", 171).getInt();
		RHEA_BIOME_ID = config.get(BIOME_IDS, "Rhea Biome ID", 172).getInt();
		TITAN_BIOME_ID = config.get(BIOME_IDS, "Titan Biome ID", 173).getInt();
		KEPLER22B_PLAINS_BIOME_ID = config.get(BIOME_IDS, "Kepler22b Plains Biome ID", 174).getInt();
		KEPLER22B_BLUE_FOREST_BIOME_ID = config.get(BIOME_IDS, "Kepler22b Blue Maple Forest Biome ID", 175).getInt();
		KEPLER22B_PURPLE_FOREST_BIOME_ID = config.get(BIOME_IDS, "Kepler22b Purple Maple Forest Biome ID", 176).getInt();
		KEPLER22B_RED_FOREST_BIOME_ID = config.get(BIOME_IDS, "Kepler22b Blue Red Forest Biome ID", 177).getInt();
		KEPLER22B_YELLOW_FOREST_BIOME_ID = config.get(BIOME_IDS, "Kepler22b Yellow Maple Forest Biome ID", 178).getInt();
		OBERON_BIOME_ID = config.get(BIOME_IDS, "Oberon Biome ID", 179).getInt();
		TITANIA_BIOME_ID = config.get(BIOME_IDS, "Titania Biome ID", 180).getInt();
		IAPETUS_BIOME_ID = config.get(BIOME_IDS, "Iapetus Biome ID", 181).getInt();

		SCHEMATIC_TIER_4_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 4 GUI ID", 5555).getInt();
		SCHEMATIC_TIER_5_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 5 GUI ID", 5556).getInt();
		SCHEMATIC_TIER_6_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 6 GUI ID", 5557).getInt();
		SCHEMATIC_TIER_7_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 7 GUI ID", 5558).getInt();
		SCHEMATIC_TIER_8_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 8 GUI ID", 5559).getInt();
		SCHEMATIC_TIER_9_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 9 GUI ID", 5560).getInt();
		SCHEMATIC_TIER_10_GUI_ID = config.get(SCHEMATIC_GUI_IDS, "Schematic Tier 10 GUI ID", 5561).getInt();

		SCHEMATIC_TIER_4_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 4 Page ID", 6666).getInt();
		SCHEMATIC_TIER_5_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 5 Page ID", 6667).getInt();
		SCHEMATIC_TIER_6_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 6 Page ID", 6668).getInt();
		SCHEMATIC_TIER_7_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 7 Page ID", 6669).getInt();
		SCHEMATIC_TIER_8_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 8 Page ID", 6670).getInt();
		SCHEMATIC_TIER_9_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 9 Page ID", 6671).getInt();
		SCHEMATIC_TIER_10_PAGE_ID = config.get(SCHEMATIC_PAGE_IDS, "Schematic Tier 10 Page ID", 6672).getInt();

		NEI_SUPPORT = config.get(COMPATIBILITY, "Enable NEI Recipe support", true, "").getBoolean(true);
		ORE_DICTIONARY = config.get(COMPATIBILITY, "Add planet/moons ores to the ore dictionary", true, "Setting this to false will disable all Ore Dictionary Support for Items and Blocks!").getBoolean(true);

		ACHIEVEMENTS = config.get(GENERAL_SETTINGS, "Enable achievements", true, "").getBoolean(true);

		PRESSURE = config.get(GENERAL_SETTINGS, "Enable pressure", true, "").getBoolean(true);
		RADIATION = config.get(GENERAL_SETTINGS, "Enable radiation", true, "").getBoolean(true);

		ORE_LEAD_GENERATION = config.get(GENERAL_SETTINGS, "Enable generation of Lead Ore in the Overworld", true, "").getBoolean(true);

		config.save();
	}

}
