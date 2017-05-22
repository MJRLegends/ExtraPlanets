package com.mjr.extraplanets;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	// Sections/Groups
	private static String dimensions = "main dimensions";
	private static String dimensionsCustom = "other dimensions";
	private static String dimensionID = "dimensionID";
	private static String dimensionSettings = "dimension settings";
	private static String dimensionBlockSettings = "dimension block settings";
	private static String biomeID = "biomeID";
	private static String items = "items";
	private static String blocks = "blocks";
	private static String entities = "entities";
	private static String modCompatibility = "mod compatibility";

	private static String spacestationCustom = "space stations";

	private static String schematicsGUI = "schematics GUI ID";
	private static String schematicsPage = "schematics Page ID";

	private static String compatibility = "compatibility support";
	private static String generalsettings = "general settings";
	private static String celestialBodyMapSettings = "celestial body map settings";

	// Config options
	public static boolean mobSuffocation;
	public static boolean useDefaultBosses;

	public static int mercuryRocketTier;
	public static int ceresRocketTier;
	public static int erisRocketTier;

	public static boolean genVenusVolcanos;
	public static boolean genUranusIgloos;
	public static boolean genUranusIceSpikes;

	public static boolean carbonItems;
	public static boolean palladiumItems;
	public static boolean magnesiumItems;
	public static boolean crystalItems;
	public static boolean tungstenItems;
	public static boolean redGemItems;
	public static boolean blueGemItems;
	public static boolean whiteGemItems;
	public static boolean zincItems;
	public static boolean mercuryItems;
	public static boolean uraniumItems;
	public static boolean kepler22bItems;

	public static boolean thermalPaddings;
	public static boolean batteries;
	public static boolean cannedFood;
	public static boolean customApples;

	public static boolean ultimateRefinery;
	public static boolean advancedFuelLoader;
	public static boolean ultimateFuelLoader;
	public static boolean advancedOxygenCompressor;
	public static boolean ultimateOxygenCompressor;
	public static boolean chargingBlock;
	public static boolean solarPanels;
	public static boolean advancedRefinery;
	public static boolean slabsAndStairs;
	public static boolean nuclearBomb;

	public static boolean mercury;
	public static boolean venus;
	public static boolean ceres;
	public static boolean jupiter;
	public static boolean saturn;
	public static boolean uranus;
	public static boolean neptune;
	public static boolean pluto;
	public static boolean eris;

	public static boolean triton;
	public static boolean europa;
	public static boolean io;
	public static boolean deimos;
	public static boolean phobos;
	public static boolean callisto;
	public static boolean ganymede;
	public static boolean rhea;
	public static boolean titan;
	public static boolean oberon;
	public static boolean titania;
	public static boolean iapetus;

	public static boolean makemake;
	public static boolean haumea;
	public static boolean kuiperBelt;
	public static boolean keplerSolarSystems;

	public static boolean kepler22b;

	public static int mercuryID;
	public static int venusID;
	public static int ceresID;
	public static int jupiterID;
	public static int saturnID;
	public static int uranusID;
	public static int neptuneID;
	public static int plutoID;
	public static int erisID;

	public static int tritonID;
	public static int europaID;
	public static int ioID;
	public static int deimosID;
	public static int phobosID;
	public static int callistoID;
	public static int ganymedeID;
	public static int rheaID;
	public static int titanID;
	public static int oberonID;
	public static int titaniaID;
	public static int iapetusID;

	public static int kepler22bID;

	public static int mercurySpaceStationID;
	public static int mercurySpaceStationStaticID;

	public static int venusSpaceStationID;
	public static int venusSpaceStationStaticID;

	public static int ceresSpaceStationID;
	public static int ceresSpaceStationStaticID;

	public static int marsSpaceStationID;
	public static int marsSpaceStationStaticID;

	public static int jupiterSpaceStationID;
	public static int jupiterSpaceStationStaticID;

	public static int saturnSpaceStationID;
	public static int saturnSpaceStationStaticID;

	public static int uranusSpaceStationID;
	public static int uranusSpaceStationStaticID;

	public static int neptuneSpaceStationID;
	public static int neptuneSpaceStationStaticID;

	public static int plutoSpaceStationID;
	public static int plutoSpaceStationStaticID;

	public static int erisSpaceStationID;
	public static int erisSpaceStationStaticID;

	public static int kepler22bSpaceStationID;
	public static int kepler22bSpaceStationStaticID;

	public static boolean mercurySpaceStation;
	public static boolean venusSpaceStation;
	public static boolean ceresSpaceStation;
	public static boolean marsSpaceStation;
	public static boolean jupiterSpaceStation;
	public static boolean saturnSpaceStation;
	public static boolean uranusSpaceStation;
	public static boolean neptuneSpaceStation;
	public static boolean plutoSpaceStation;
	public static boolean erisSpaceStation;
	public static boolean kepler22bSpaceStation;

	public static int mercuryBiomeID;
	public static int venusBiomeID;
	public static int ceresBiomeID;
	public static int jupiterBiomeID;
	public static int saturnBiomeID;
	public static int uranusBiomeID;
	public static int neptuneBiomeID;
	public static int plutoBiomeID;
	public static int erisBiomeID;

	public static int tritonBiomeID;
	public static int europaBiomeID;
	public static int ioBiomeID;
	public static int deimosBiomeID;
	public static int phobosBiomeID;
	public static int callistoBiomeID;
	public static int ganymedeBiomeID;
	public static int rheaBiomeID;
	public static int titanBiomeID;
	public static int oberonBiomeID;
	public static int titaniaBiomeID;
	public static int iapetusBiomeID;

	public static int kepler22bPlainsBiomeID;
	public static int kepler22bBlueForestBiomeID;
	public static int kepler22bPurpleForestBiomeID;
	public static int kepler22bRedForestBiomeID;
	public static int kepler22bYellowForestBiomeID;
	public static int kepler22bRedDesertBiomeID;

	public static boolean venusLiquid;
	public static boolean jupiterLiquid;
	public static boolean saturnLiquid;
	public static boolean uranusLiquid;
	public static boolean neptuneLiquid;
	public static boolean oreDictionary;

	public static int schematicTier4GUIID;
	public static int schematicTier5GUIID;
	public static int schematicTier6GUIID;
	public static int schematicTier7GUIID;
	public static int schematicTier8GUIID;
	public static int schematicTier9GUIID;
	public static int schematicTier10GUIID;

	public static int schematicMarsRoverGUIID;
	public static int schematicVenusRoverGUIID;

	public static int schematicTier4PageID;
	public static int schematicTier5PageID;
	public static int schematicTier6PageID;
	public static int schematicTier7PageID;
	public static int schematicTier8PageID;
	public static int schematicTier9PageID;
	public static int schematicTier10PageID;

	public static int schematicMarsRoverPageID;
	public static int schematicVenusRoverPageID;

	public static boolean microBlock;
	public static boolean neiSupport;
	public static boolean achievements;

	public static boolean evolvedMagmaCube;
	public static boolean evolvedIceSlime;
	public static boolean evolvedWitch;
	public static boolean evolvedEnderman;
	public static boolean evolvedBlaze;
	public static boolean evolvedBlueCreeper;
	public static boolean evolvedRedCreeper;
	public static boolean evolvedPowerSkeleton;
	public static boolean evolvedGiantSpider;
	public static boolean evolvedMiniEnderman;

	public static boolean morePlanetsCompatibilityAdv;
	//public static boolean amunRaCompatibility;
	public static boolean galaxySpaceCompatibility;
	public static boolean galaxySpaceCompatibilityAdv;
	
	public static float kepler22SystemYawOffset;
	public static float kepler22SystemPitchOffset;
	public static float kepler47SystemYawOffset;
	public static float kepler47SystemPitchOffset;
	public static float kepler62SystemYawOffset;
	public static float kepler62SystemPitchOffset;
	public static float kepler69SystemYawOffset;
	public static float kepler69SystemPitchOffset;
	
	public static float mercuryDistanceOffset;
	public static float venusDistanceOffset;
	public static float ceresDistanceOffset;
	public static float jupiterDistanceOffset;
	public static float saturnDistanceOffset;
	public static float uranusDistanceOffset;
	public static float neptuneDistanceOffset;
	public static float plutoDistanceOffset;
	public static float haumeaDistanceOffset;
	public static float erisDistanceOffset;
	public static float kuiperBeltDistanceOffset;
	public static float makemakeDistanceOffset;
	
	public static boolean marsRover;
	public static boolean venusRover;

	public static void init() {
		load();
		checkCompatibility();
	}

	private static void load() {
		Configuration config = new Configuration(new File("config/ExtraPlanets.cfg"));
		config.load();

		config.addCustomCategoryComment(dimensionID, "Change if a dimension ID is causing conflicts!");
		config.addCustomCategoryComment(biomeID, "Change if a biome ID is causing conflicts!");
		config.addCustomCategoryComment(dimensions, "Disabling this will remove the planet with all the related items/block!");
		config.addCustomCategoryComment(dimensionSettings, "Enable/Disable dimension settings");
		config.addCustomCategoryComment(dimensionsCustom, "Disabling this will remove the planet/moon with all the related items/block//space stations!");
		config.addCustomCategoryComment(schematicsGUI, "Change if a Schematic GUI ID is causing conflicts!");
		config.addCustomCategoryComment(schematicsPage, "Change if a Schematic Page ID is causing conflicts!");
		config.addCustomCategoryComment(items, "Changing to false will disable the tool & armor or items (Note: Tools & Armors will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(blocks, "Changing to false will disable the blocks/machines");
		config.addCustomCategoryComment(dimensionBlockSettings, "Note: The " + "\"" + "Surface & Sub-Surface blocks are Liquid" + "\"" + " option can cause lag! And It will disable the villages for that planet!");
		config.addCustomCategoryComment(spacestationCustom, "Disabling this will remove the space station from the planet (Note: Will be auto disbled when disabling a planet, so you dont need to disable them when disabling a planets)");
		config.addCustomCategoryComment(compatibility, "Enable/Disable compatibility settings");
		config.addCustomCategoryComment(generalsettings, "Enable/Disable general settings");
		config.addCustomCategoryComment(entities, "Enable/Disable entities");
		config.addCustomCategoryComment(modCompatibility, "Enable/Disable Mod Compatibility, This will change and disable anything require to make it compatibility with enabled mods!");
		config.addCustomCategoryComment(celestialBodyMapSettings, "Advanced options for Celestial Body Map tp change locations of planets and solar systems! (For Advanced Users ONLY!)");

		carbonItems = config.get(items, "Carbon Tools & Armor", true).getBoolean(true);
		palladiumItems = config.get(items, "Palladium Tools & Armor", true).getBoolean(true);
		magnesiumItems = config.get(items, "Magnesium Tools & Armor", true).getBoolean(true);
		crystalItems = config.get(items, "Crystal Tools & Armor", true).getBoolean(true);
		tungstenItems = config.get(items, "Tungsten Tools & Armor", true).getBoolean(true);
		redGemItems = config.get(items, "Red Gem Tools & Armor", true).getBoolean(true);
		blueGemItems = config.get(items, "Blue Gem Tools & Armor", true).getBoolean(true);
		whiteGemItems = config.get(items, "White Gem Tools & Armor", true).getBoolean(true);
		zincItems = config.get(items, "Zinc Tools & Armor", true).getBoolean(true);
		mercuryItems = config.get(items, "Mercury Tools & Armor", true).getBoolean(true);
		uraniumItems = config.get(items, "Uranium Tools & Armor", true).getBoolean(true);
		kepler22bItems = config.get(items, "Kepler22b Tools & Armor", true).getBoolean(true);

		thermalPaddings = config.get(items, "Tier 2 - 4 Thermal Padding", true, "This option will change planet thermal levels to support this feature!").getBoolean(true);
		batteries = config.get(items, "Custom Batteries", true, "This option will disable all Custom Batteries!").getBoolean(true);
		cannedFood = config.get(items, "Custom Canned Food", true, "This option will disable all Custom Canned Food!").getBoolean(true);
		customApples = config.get(items, "Custom Iron & Diamomd Normal/Notch Apples", true, "This option will disable all Custom Normal/Notch Apples!").getBoolean(true);

		advancedRefinery = config.get(blocks, "Advanced Refinery", true).getBoolean(true);
		ultimateRefinery = config.get(blocks, "Ultimate Refinery", true).getBoolean(true);

		advancedFuelLoader = config.get(blocks, "Advanced Fuel Loader", true).getBoolean(true);
		ultimateFuelLoader = config.get(blocks, "Ultimate Fuel Loader", true).getBoolean(true);

		advancedOxygenCompressor = config.get(blocks, "Advanced Oxygen Compressor/Decomperssor", true).getBoolean(true);
		ultimateOxygenCompressor = config.get(blocks, "Ultimate Oxygen Compressor/Decomperssor", true).getBoolean(true);
		
		chargingBlock = config.get(blocks, "Vehicle Charger", true).getBoolean(true);
		solarPanels = config.get(blocks, "Hybrid/Ultimate Solar Panel", true).getBoolean(true);
		slabsAndStairs = config.get(blocks, "Slab & Stairs", true).getBoolean(true);

		nuclearBomb = config.get(blocks, "Nuclear Bomb", true).getBoolean(true);

		mobSuffocation = config.get(dimensionSettings, "Mob Suffocation", true, "Setting this to false will make mobs not suffocate on planets but the player will!").getBoolean(true);
		useDefaultBosses = config.get(dimensionSettings, "Use default bosses for all planets", false, "Will disable all custom bosses and will replace them with Creeper Bosses!").getBoolean(false);

		mercuryRocketTier = config.get(dimensionSettings, "Mercury Rocket required", 4, "Changing this will change the Tier required to go to Mercury").getInt();
		ceresRocketTier = config.get(dimensionSettings, "Ceres Rocket required", 4, "Changing this will change the Tier required to go to Ceres").getInt();

		genVenusVolcanos = config.get(dimensionSettings, "Generate Volcanos on Venus", true, "Will disable Volcanos from generating on Venus").getBoolean(true);
		genUranusIgloos = config.get(dimensionSettings, "Generate Igloos on Uranus", true, "Will disable Igloos from generating on Uranus").getBoolean(true);
		genUranusIceSpikes = config.get(dimensionSettings, "Generate Ice Spikes on Uranus", true, "Will disable Ice Spikes from generating on Uranus").getBoolean(true);

		ceres = config.get(dimensionsCustom, "Ceres", true).getBoolean(true);
		mercury = config.get(dimensionsCustom, "Mercury", true).getBoolean(true);

		triton = config.get(dimensionsCustom, "Triton", true, "").getBoolean(true);
		europa = config.get(dimensionsCustom, "Europa", true, "").getBoolean(true);
		io = config.get(dimensionsCustom, "IO", true, "").getBoolean(true);
		deimos = config.get(dimensionsCustom, "Deimos", true, "").getBoolean(true);
		phobos = config.get(dimensionsCustom, "Phobos", true, "").getBoolean(true);
		callisto = config.get(dimensionsCustom, "Callisto", true, "").getBoolean(true);
		ganymede = config.get(dimensionsCustom, "Ganymede", true, "").getBoolean(true);
		rhea = config.get(dimensionsCustom, "Rhea", true, "").getBoolean(true);
		titan = config.get(dimensionsCustom, "Titan", true, "").getBoolean(true);
		oberon = config.get(dimensionsCustom, "Oberon", true, "").getBoolean(true);
		titania = config.get(dimensionsCustom, "Titania", true, "").getBoolean(true);
		iapetus = config.get(dimensionsCustom, "Iapetus", true, "").getBoolean(true);

		haumea = config.get(dimensionsCustom, "Haumea", true, "").getBoolean(true);
		makemake = config.get(dimensionsCustom, "Makemake", true, "").getBoolean(true);
		kuiperBelt = config.get(dimensionsCustom, "Kuiper Belt", true, "").getBoolean(true);
		keplerSolarSystems = config.get(dimensionsCustom, "Kepler SolarSystems", true, "").getBoolean(true);

		kepler22b = config.get(dimensionsCustom, "Kepler 22b", true, "").getBoolean(true);

		mercurySpaceStation = config.get(spacestationCustom, "Mercury SpaceStation", true, "").getBoolean(true);
		venusSpaceStation = config.get(spacestationCustom, "Venus SpaceStation", true, "").getBoolean(true);
		ceresSpaceStation = config.get(spacestationCustom, "Ceres SpaceStation", true, "").getBoolean(true);
		marsSpaceStation = config.get(spacestationCustom, "Mars SpaceStation", true, "").getBoolean(true);
		jupiterSpaceStation = config.get(spacestationCustom, "Jupiter SpaceStation", true, "").getBoolean(true);
		saturnSpaceStation = config.get(spacestationCustom, "Saturn SpaceStation", true, "").getBoolean(true);
		uranusSpaceStation = config.get(spacestationCustom, "Uranus SpaceStation", true, "").getBoolean(true);
		neptuneSpaceStation = config.get(spacestationCustom, "Neptune SpaceStation", true, "").getBoolean(true);
		plutoSpaceStation = config.get(spacestationCustom, "Pluto SpaceStation", true, "").getBoolean(true);
		erisSpaceStation = config.get(spacestationCustom, "Eris SpaceStation", true, "").getBoolean(true);
		kepler22bSpaceStation = config.get(spacestationCustom, "Kepler22b SpaceStation", true, "").getBoolean(true);

		venus = config.get(dimensions, "Venus & Tier 4 Rocket", true, "Disabling this will remove the Venus & Tier 4 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		jupiter = config.get(dimensions, "Jupiter & Tier 5 Rocket", true, "Disabling this will remove the Jupiter & Tier 5 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		saturn = config.get(dimensions, "Saturn & Tier 6 Rocket", true, "Disabling this will remove the Saturn & Tier 6 Rocket with all the related items/block/tools/armour!/space stations").getBoolean(true);
		uranus = config.get(dimensions, "Uranus & Tier 7 Rocket", true, "Disabling this will remove the Uranus & Tier 7 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		neptune = config.get(dimensions, "Neptune & Tier 8 Rocket", true, "Disabling this will remove the Neptune & Tier 8 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		pluto = config.get(dimensions, "Pluto & Tier 9 Rocket", true, "Disabling this will remove the Pluto & Tier 9 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);
		eris = config.get(dimensions, "Eris & Tier 10 Rocket", true, "Disabling this will remove the Eris & Tier 10 Rocket with all the related items/block/tools/armour/space stations!").getBoolean(true);

		venusLiquid = config.get(dimensionBlockSettings, "Venus's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		jupiterLiquid = config.get(dimensionBlockSettings, "Jupiter's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		saturnLiquid = config.get(dimensionBlockSettings, "Saturn's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		uranusLiquid = config.get(dimensionBlockSettings, "Uranus's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);
		neptuneLiquid = config.get(dimensionBlockSettings, "Neptune's Surface & Sub-Surface blocks are Liquid", false, "").getBoolean(false);

		mercuryID = config.get(dimensionID, "Mercury Dimension ID", -13).getInt();
		venusID = config.get(dimensionID, "Venus Dimension ID", -14).getInt();
		ceresID = config.get(dimensionID, "Ceres Dimension ID", -20).getInt();
		jupiterID = config.get(dimensionID, "Jupiter Dimension ID", -15).getInt();
		saturnID = config.get(dimensionID, "Saturn Dimension ID", -16).getInt();
		uranusID = config.get(dimensionID, "Uranus Dimension ID", -17).getInt();
		neptuneID = config.get(dimensionID, "Neptune Dimension ID", -18).getInt();
		plutoID = config.get(dimensionID, "Pluto Dimension ID", -19).getInt();
		erisID = config.get(dimensionID, "Eris Dimension ID", -21).getInt();

		ioID = config.get(dimensionID, "Io Dimension ID", -31).getInt();
		europaID = config.get(dimensionID, "Europa Dimension ID", -34).getInt();
		phobosID = config.get(dimensionID, "Phobos Dimension ID", -33).getInt();
		deimosID = config.get(dimensionID, "Deimos Dimension ID", -35).getInt();
		tritonID = config.get(dimensionID, "Triton Dimension ID", -36).getInt();
		callistoID = config.get(dimensionID, "Callisto Dimension ID", -37).getInt();
		ganymedeID = config.get(dimensionID, "Ganymede Dimension ID", -38).getInt();
		rheaID = config.get(dimensionID, "Rhea Dimension ID", -39).getInt();
		titanID = config.get(dimensionID, "Titan Dimension ID", -40).getInt();
		oberonID = config.get(dimensionID, "Oberon Dimension ID", -41).getInt();
		titaniaID = config.get(dimensionID, "Titania Dimension ID", -42).getInt();
		iapetusID = config.get(dimensionID, "Iapetus Dimension ID", -43).getInt();

		kepler22bID = config.get(dimensionID, "Kepler 22b Dimension ID", -22).getInt();

		mercurySpaceStationID = config.get(dimensionID, "Mercury SpaceStation Dimension ID", -61).getInt();
		mercurySpaceStationStaticID = config.get(dimensionID, "Mercury SpaceStation Static Dimension ID", -60).getInt();

		venusSpaceStationID = config.get(dimensionID, "Venus SpaceStation Dimension ID", -63).getInt();
		venusSpaceStationStaticID = config.get(dimensionID, "Venus SpaceStation Static Dimension ID", -62).getInt();

		ceresSpaceStationID = config.get(dimensionID, "Ceres SpaceStation Dimension ID", -65).getInt();
		ceresSpaceStationStaticID = config.get(dimensionID, "Ceres SpaceStation Static Dimension ID", -64).getInt();

		marsSpaceStationID = config.get(dimensionID, "Mars SpaceStation Dimension ID", -67).getInt();
		marsSpaceStationStaticID = config.get(dimensionID, "Mars SpaceStation Static Dimension ID", -66).getInt();

		jupiterSpaceStationID = config.get(dimensionID, "Jupiter SpaceStation Dimension ID", -69).getInt();
		jupiterSpaceStationStaticID = config.get(dimensionID, "Jupiter SpaceStation Static Dimension ID", -68).getInt();

		saturnSpaceStationID = config.get(dimensionID, "Saturn SpaceStation Dimension ID", -71).getInt();
		saturnSpaceStationStaticID = config.get(dimensionID, "Saturn SpaceStation Static Dimension ID", -70).getInt();

		uranusSpaceStationID = config.get(dimensionID, "Uranus SpaceStation Dimension ID", -73).getInt();
		uranusSpaceStationStaticID = config.get(dimensionID, "Uranus SpaceStation Static Dimension ID", -72).getInt();

		neptuneSpaceStationID = config.get(dimensionID, "Neptune SpaceStation Dimension ID", -75).getInt();
		neptuneSpaceStationStaticID = config.get(dimensionID, "Neptune SpaceStation Static Dimension ID", -74).getInt();

		plutoSpaceStationID = config.get(dimensionID, "Pluto SpaceStation Dimension ID", -77).getInt();
		plutoSpaceStationStaticID = config.get(dimensionID, "Pluto SpaceStation Static Dimension ID", -76).getInt();

		erisSpaceStationID = config.get(dimensionID, "Eris SpaceStation Dimension ID", -79).getInt();
		erisSpaceStationStaticID = config.get(dimensionID, "Eris SpaceStation Static Dimension ID", -78).getInt();

		kepler22bSpaceStationID = config.get(dimensionID, "Kepler 22b SpaceStation Dimension ID", -81).getInt();
		kepler22bSpaceStationStaticID = config.get(dimensionID, "Kepler 22b SpaceStation Static Dimension ID", -80).getInt();

		mercuryBiomeID = config.get(biomeID, "Mercury Biome ID", 148).getInt();
		venusBiomeID = config.get(biomeID, "Venus Biome ID", 149).getInt();
		ceresBiomeID = config.get(biomeID, "Ceres Biome ID", 155).getInt();
		jupiterBiomeID = config.get(biomeID, "Jupiter Biome ID", 150).getInt();
		saturnBiomeID = config.get(biomeID, "Saturn Biome ID", 147).getInt();
		uranusBiomeID = config.get(biomeID, "Uranus Biome ID", 152).getInt();
		neptuneBiomeID = config.get(biomeID, "Neptune Biome ID", 153).getInt();
		plutoBiomeID = config.get(biomeID, "Pluto Biome ID", 154).getInt();
		erisBiomeID = config.get(biomeID, "Eris Biome ID", 184).getInt();
		europaBiomeID = config.get(biomeID, "Europa Biome ID", 183).getInt();
		ioBiomeID = config.get(biomeID, "Io Biome ID", 182).getInt();
		deimosBiomeID = config.get(biomeID, "Deimos Biome ID", 159).getInt();
		phobosBiomeID = config.get(biomeID, "Phobos Biome ID", 168).getInt();
		tritonBiomeID = config.get(biomeID, "Triton Biome ID", 169).getInt();
		callistoBiomeID = config.get(biomeID, "Callisto Biome ID", 170).getInt();
		ganymedeBiomeID = config.get(biomeID, "Ganymede Biome ID", 171).getInt();
		rheaBiomeID = config.get(biomeID, "Rhea Biome ID", 172).getInt();
		titanBiomeID = config.get(biomeID, "Titan Biome ID", 173).getInt();
		kepler22bPlainsBiomeID = config.get(biomeID, "Kepler22b Plains Biome ID", 174).getInt();
		kepler22bBlueForestBiomeID = config.get(biomeID, "Kepler22b Blue Maple Forest Biome ID", 175).getInt();
		kepler22bPurpleForestBiomeID = config.get(biomeID, "Kepler22b Purple Maple Forest Biome ID", 176).getInt();
		kepler22bRedForestBiomeID = config.get(biomeID, "Kepler22b Blue Red Forest Biome ID", 177).getInt();
		kepler22bYellowForestBiomeID = config.get(biomeID, "Kepler22b Yellow Maple Forest Biome ID", 178).getInt();
		oberonBiomeID = config.get(biomeID, "Oberon Biome ID", 179).getInt();
		titaniaBiomeID = config.get(biomeID, "Titania Biome ID", 180).getInt();
		iapetusBiomeID = config.get(biomeID, "Iapetus Biome ID", 181).getInt();
		kepler22bRedDesertBiomeID = config.get(biomeID, "Kepler22b Red Desert Biome ID", 185).getInt();
		
		schematicTier4GUIID = config.get(schematicsGUI, "Schematic Tier 4 GUI ID", 5555).getInt();
		schematicTier5GUIID = config.get(schematicsGUI, "Schematic Tier 5 GUI ID", 5556).getInt();
		schematicTier6GUIID = config.get(schematicsGUI, "Schematic Tier 6 GUI ID", 5557).getInt();
		schematicTier7GUIID = config.get(schematicsGUI, "Schematic Tier 7 GUI ID", 5558).getInt();
		schematicTier8GUIID = config.get(schematicsGUI, "Schematic Tier 8 GUI ID", 5559).getInt();
		schematicTier9GUIID = config.get(schematicsGUI, "Schematic Tier 9 GUI ID", 5560).getInt();
		schematicTier10GUIID = config.get(schematicsGUI, "Schematic Tier 10 GUI ID", 5561).getInt();

		schematicMarsRoverGUIID = config.get(schematicsGUI, "Schematic Mars Rover GUI ID", 5562).getInt();
		schematicVenusRoverGUIID = config.get(schematicsGUI, "Schematic Venus Rover GUI ID", 5563).getInt();

		schematicTier4PageID = config.get(schematicsPage, "Schematic Tier 4 Page ID", 6666).getInt();
		schematicTier5PageID = config.get(schematicsPage, "Schematic Tier 5 Page ID", 6667).getInt();
		schematicTier6PageID = config.get(schematicsPage, "Schematic Tier 6 Page ID", 6668).getInt();
		schematicTier7PageID = config.get(schematicsPage, "Schematic Tier 7 Page ID", 6669).getInt();
		schematicTier8PageID = config.get(schematicsPage, "Schematic Tier 8 Page ID", 6670).getInt();
		schematicTier9PageID = config.get(schematicsPage, "Schematic Tier 9 Page ID", 6671).getInt();
		schematicTier10PageID = config.get(schematicsPage, "Schematic Tier 10 Page ID", 6672).getInt();

		schematicMarsRoverPageID = config.get(schematicsPage, "Schematic Mars Rover Page ID", 6673).getInt();
		schematicVenusRoverPageID = config.get(schematicsPage, "Schematic Venus Rover Page ID", 6674).getInt();

		microBlock = config.get(compatibility, "Enable Forge Micro blocks support", true, "").getBoolean(true);
		neiSupport = config.get(compatibility, "Enable NEI Recipe support", true, "").getBoolean(true);
		oreDictionary = config.get(compatibility, "Add planet/moons ores to the ore dictionary", true, "Setting this to false will disable all Ore Dictionary Support for Items and Blocks!").getBoolean(true);

		achievements = config.get(generalsettings, "Enable achievements", true, "").getBoolean(true);

		evolvedMagmaCube = config.get(entities, "Enable spawning of Evolved Magma Cube", true, "").getBoolean(true);
		evolvedIceSlime = config.get(entities, "Enable spawning of Evolved Ice Slime", true, "").getBoolean(true);
		evolvedWitch = config.get(entities, "Enable spawning of Evolved Witch", true, "").getBoolean(true);
		evolvedEnderman = config.get(entities, "Enable spawning of Evolved Enderman", true, "").getBoolean(true);
		evolvedBlaze = config.get(entities, "Enable spawning of Evolved Blaze", true, "").getBoolean(true);
		evolvedBlueCreeper = config.get(entities, "Enable spawning of Evolved Blue Creeper", true, "").getBoolean(true);
		evolvedRedCreeper = config.get(entities, "Enable spawning of Evolved Red Creeper", true, "").getBoolean(true);
		evolvedPowerSkeleton = config.get(entities, "Enable spawning of Evolved Power Skeleton", true, "").getBoolean(true);
		evolvedGiantSpider = config.get(entities, "Enable spawning of Evolved Giant Spider", true, "").getBoolean(true);
		evolvedMiniEnderman = config.get(entities, "Enable spawning of Evolved Mini Enderman", true, "").getBoolean(true);

		morePlanetsCompatibilityAdv = config.get(modCompatibility, "Enable Advanced More Planets Compatibility", false, "").getBoolean(false);
		//amunRaCompatibility = config.get(modCompatibility, "Enable AmunRa Compatibility", false, "").getBoolean(false);
		galaxySpaceCompatibility = config.get(modCompatibility, "Enable Basic Galaxy Space Compatibility", false, "").getBoolean(false);
		//galaxySpaceCompatibilityAdv = config.get(modCompatibility, "Enable Advanced Galaxy Space Compatibility", false, "").getBoolean(false);
		
		kepler22SystemYawOffset = (float) config.get(celestialBodyMapSettings, "Kepler22 Planet Map Yaw Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler22SystemPitchOffset = (float) config.get(celestialBodyMapSettings, "Kepler22 Planet Map Pitch Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler47SystemYawOffset = (float) config.get(celestialBodyMapSettings, "Kepler47 Planet Map Yaw Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler47SystemPitchOffset = (float) config.get(celestialBodyMapSettings, "Kepler47 Planet Map Pitch Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler62SystemYawOffset = (float) config.get(celestialBodyMapSettings, "Kepler62 Planet Map Yaw Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler62SystemPitchOffset = (float) config.get(celestialBodyMapSettings, "Kepler62 Planet Map Pitch Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler69SystemYawOffset = (float) config.get(celestialBodyMapSettings, "Kepler69 Planet Map Yaw Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		kepler69SystemPitchOffset = (float) config.get(celestialBodyMapSettings, "Kepler69 Planet Map Pitch Offset", 0.0, "[range: -1000 ~ 1000, default: 0]").getDouble();
		
		mercuryDistanceOffset = (float) config.get(celestialBodyMapSettings, "Mercury Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		venusDistanceOffset = (float) config.get(celestialBodyMapSettings, "Venus Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		ceresDistanceOffset = (float) config.get(celestialBodyMapSettings, "Ceres Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		jupiterDistanceOffset = (float) config.get(celestialBodyMapSettings, "Jupiter Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		saturnDistanceOffset = (float) config.get(celestialBodyMapSettings, "Saturn Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		uranusDistanceOffset = (float) config.get(celestialBodyMapSettings, "Uranus Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		neptuneDistanceOffset = (float) config.get(celestialBodyMapSettings, "Neptune Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		plutoDistanceOffset = (float) config.get(celestialBodyMapSettings, "Pluto Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		haumeaDistanceOffset = (float) config.get(celestialBodyMapSettings, "Haumea Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		erisDistanceOffset = (float) config.get(celestialBodyMapSettings, "Eris Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		kuiperBeltDistanceOffset = (float) config.get(celestialBodyMapSettings, "Kuiper Belt Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		makemakeDistanceOffset = (float) config.get(celestialBodyMapSettings, "Makemake Planet Map Relative Distance From Center Offset", 0.0, "[range: -100 ~ 100, default: 0]").getDouble();
		
		marsRover = config.get(items, "Enable Mars Rover & Its Parts", true, "").getBoolean(true);
		venusRover = config.get(items, "Enable Venus Rover & Its Parts", true, "").getBoolean(true);
		
		config.save();
	}
	
	private static void checkCompatibility() {
		if (morePlanetsCompatibilityAdv) {
			pluto = false;
			mercury = false;
			venus = false;
			jupiter = false;
			deimos = false;
			phobos = false;
			mercurySpaceStation = false;
			venusSpaceStation = false;
			marsSpaceStation = false;
			jupiterSpaceStation = false;
			plutoSpaceStation = false;
			thermalPaddings = false;
		}
		if(galaxySpaceCompatibility || galaxySpaceCompatibilityAdv){
			pluto = false;
			titan = false;
			callisto = false;
			io = false;
			europa = false;
			deimos = false;
			makemake = false;
			phobos = false;
			oberon = false;
			triton = false;
			mercury = false;
			venus = false;
			ceres = false;
			haumea = false;
			ganymede = false;
			kuiperBelt = false;
			marsSpaceStation = false;
			venusSpaceStation = false;
			if(kepler47SystemYawOffset == 0)
				kepler47SystemYawOffset = 40.0F;
			iapetusID = -44;
			titaniaID = -45;
		}
	}

}
