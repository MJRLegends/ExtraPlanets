package com.mjr.extraplanets;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	private static String dimensions = "main dimensions";
	private static String dimensionsCustom = "other dimensions";
	private static String dimensionID = "dimensionID";
	private static String dimensionSettings = "dimension settings";
	private static String dimensionBlockSettings = "dimension block settings";
	private static String biomeID = "biomeID";
	private static String schematics = "schematics";
	private static String items = "items";
	private static String blocks = "blocks";

	private static String spacestationCustom = "space stations";

	private static String schematicsGUI = "schematics GUI ID";
	private static String schematicsPage = "schematics Page ID";
	
	private static String compatibility = "compatibility support";
	private static String gerenalsettings = "general settings";
	
	public static boolean mobSuffocation;

	public static boolean carbonItems;
	public static boolean palladiumItems;
	public static boolean magnesiumItems;
	public static boolean crystalItems;
	
	public static boolean solarPanels;
	public static boolean advancedRefinery;
	public static boolean slabsAndStairs;
	
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

	public static boolean makemake;
	public static boolean kuiperBelt;
	public static boolean keplerSolarSystems;

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

	public static int mercuryRocketTier;
	public static int ceresRocketTier;
	public static int erisRocketTier;

	public static boolean venusLiquid;
	public static boolean jupiterLiquid;
	public static boolean saturnLiquid;
	public static boolean uranusLiquid;
	public static boolean neptuneLiquid;
	public static boolean oreDictionary;
	
	//    public static int venusRocketTier;
	//    public static int jupiterRocketTier;
	//    public static int saturnRocketTier;
	//    public static int uranusRocketTier;
	//    public static int neptuneRocketTier;

	public static int schematicTier4GUIID;
	public static int schematicTier5GUIID;
	public static int schematicTier6GUIID;
	public static int schematicTier7GUIID;
	public static int schematicTier8GUIID;
	public static int schematicTier9GUIID;

	public static int schematicTier4PageID;
	public static int schematicTier5PageID;
	public static int schematicTier6PageID;
	public static int schematicTier7PageID;
	public static int schematicTier8PageID;
	public static int schematicTier9PageID;

	public static boolean microBlock;
	public static boolean neiSupport;
	public static boolean achievements;

	public static void load() {
		Configuration config = new Configuration(new File("config/ExtraPlanets.cfg"));
		config.load();

		config.addCustomCategoryComment(dimensionID, "Change if a dimension ID is causing conflicts!");
		config.addCustomCategoryComment(biomeID, "Change if a biome ID is causing conflicts!");
		config.addCustomCategoryComment(dimensions, "Disabling this will remove the planet with all the related items/block!");
		config.addCustomCategoryComment(dimensionSettings, "Enable/Disable dimension settings");
		config.addCustomCategoryComment(dimensionsCustom, "Disabling this will remove the planet/moon with all the related items/block!");
		config.addCustomCategoryComment(schematicsGUI, "Change if a Schematic GUI ID is causing conflicts!");
		config.addCustomCategoryComment(schematicsPage, "Change if a Schematic Page ID is causing conflicts!");
		config.addCustomCategoryComment(items, "Changing to false will disable the tool & armor");
		config.addCustomCategoryComment(blocks, "Changing to false will disable the blocks/machines");
		config.addCustomCategoryComment(dimensionBlockSettings, "Note: The " + "\"" + "Surface & Sub-Surface blocks are Liquid"+ "\"" + " option can cause lag! And It will disable the villages for that planet!");
		config.addCustomCategoryComment(spacestationCustom, "Disabling this will remove the space station from the planet");
		config.addCustomCategoryComment(compatibility,"Enable/Disable compatibility settings");
		config.addCustomCategoryComment(gerenalsettings,"Enable/Disable gerenal settings");
		
		carbonItems = config.get(items, "Carbon Tools & Armor", true).getBoolean(true);
		palladiumItems = config.get(items, "Palladium Tools & Armor", true).getBoolean(true);
		magnesiumItems = config.get(items, "Magnesium Tools & Armor", true).getBoolean(true);
		crystalItems = config.get(items, "Crystal Tools & Armor", true).getBoolean(true);

		solarPanels = config.get(blocks, "Hybrid/Ultimate Solar Panel", true).getBoolean(true);
		advancedRefinery = config.get(blocks, "Advanced Refinery", true).getBoolean(true);
		slabsAndStairs = config.get(blocks, "Slab & Stairs", true).getBoolean(true);

		mobSuffocation = config.get(dimensionSettings, "Mob Suffocation", true,"Setting this to false will make mobs not suffocate on planets but the player will").getBoolean(true);
		oreDictionary = config.get(dimensionSettings, "Add planet/moons ores to the ore dictionary", true, "").getBoolean(true);

		eris = config.get(dimensionsCustom, "Eris", true, "").getBoolean(true);
		ceres = config.get(dimensionsCustom, "Ceres", true).getBoolean(true);
		mercury = config.get(dimensionsCustom, "Mercury", true).getBoolean(true);
		//pluto = config.get(dimensionsCustom, "Pluto", true).getBoolean(true);

		triton = config.get(dimensionsCustom, "Triton", true, "").getBoolean(true);
		europa = config.get(dimensionsCustom, "Europa", true, "").getBoolean(true);
		io = config.get(dimensionsCustom, "IO", true, "").getBoolean(true);
		deimos = config.get(dimensionsCustom, "Deimos", true, "").getBoolean(true);
		phobos = config.get(dimensionsCustom, "Phobos", true, "").getBoolean(true);
		callisto = config.get(dimensionsCustom, "Callisto", true, "").getBoolean(true);
		ganymede = config.get(dimensionsCustom, "Ganymede", true, "").getBoolean(true);
		rhea = config.get(dimensionsCustom, "Rhea", true, "").getBoolean(true);
		titan = config.get(dimensionsCustom, "Titan", true, "").getBoolean(true);

		makemake = config.get(dimensionsCustom, "Makemake", true, "").getBoolean(true);
		kuiperBelt = config.get(dimensionsCustom, "Kuiper Belt", true, "").getBoolean(true);
		keplerSolarSystems = config.get(dimensionsCustom, "Kepler SolarSystems", true, "").getBoolean(true);

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

		venus = config.get(dimensions, "Venus & Tier 4 Rocket", true,"Disabling this will remove the Venus & Tier 4 Rocket with all the related items/block!").getBoolean(true);
		jupiter = config.get(dimensions, "Jupiter & Tier 5 Rocket", true,"Disabling this will remove the Jupiter & Tier 5 Rocket with all the related items/block!").getBoolean(true);
		saturn = config.get(dimensions, "Saturn & Tier 6 Rocket", true,"Disabling this will remove the Saturn & Tier 6 Rocket with all the related items/block!").getBoolean(true);
		uranus = config.get(dimensions, "Uranus & Tier 7 Rocket", true,"Disabling this will remove the Uranus & Tier 7 Rocket with all the related items/block!").getBoolean(true);
		neptune = config.get(dimensions, "Neptune & Tier 8 Rocket", true,"Disabling this will remove the Neptune & Tier 8 Rocket with all the related items/block!").getBoolean(true);
		pluto = config.get(dimensions, "Pluto & Tier 9 Rocket", true,"Disabling this will remove the Pluto & Tier 9 Rocket with all the related items/block!").getBoolean(true);

		mercuryRocketTier = config.get(dimensionSettings, "Mercury Rocket required", 4).getInt();
		ceresRocketTier = config.get(dimensionSettings, "Ceres Rocket required", 4).getInt();
		erisRocketTier = config.get(dimensionSettings, "Eris Rocket required", 9).getInt();

		//	venusRocketTier = config.get(dimensionSettings, "Venus Rocket required", 3).getInt();
		//	jupiterRocketTier = config.get(dimensionSettings, "Jupiter Rocket required", 4).getInt();
		//	saturnRocketTier = config.get(dimensionSettings, "Saturn Rocket required", 5).getInt();
		//	uranusRocketTier = config.get(dimensionSettings, "Uranus Rocket required", 6).getInt();
		//	neptuneRocketTier = config.get(dimensionSettings, "Neptune Rocket required", 7).getInt();

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

		mercuryBiomeID = config.get(biomeID, "Mercury Biome ID", 148).getInt();
		venusBiomeID = config.get(biomeID, "Venus Biome ID", 149).getInt();
		ceresBiomeID = config.get(biomeID, "Ceres Biome ID", 155).getInt();
		jupiterBiomeID = config.get(biomeID, "Jupiter Biome ID", 150).getInt();
		saturnBiomeID = config.get(biomeID, "Saturn Biome ID", 151).getInt();
		uranusBiomeID = config.get(biomeID, "Uranus Biome ID", 152).getInt();
		neptuneBiomeID = config.get(biomeID, "Neptune Biome ID", 153).getInt();
		plutoBiomeID = config.get(biomeID, "Pluto Biome ID", 154).getInt();
		erisBiomeID = config.get(biomeID, "Eris Biome ID", 156).getInt();
		europaBiomeID = config.get(biomeID, "Europa Biome ID", 157).getInt();
		ioBiomeID = config.get(biomeID, "Io Biome ID", 158).getInt();
		deimosBiomeID = config.get(biomeID, "Deimos Biome ID", 159).getInt();
		phobosBiomeID = config.get(biomeID, "Phobos Biome ID", 160).getInt();
		tritonBiomeID = config.get(biomeID, "Triton Biome ID", 161).getInt();
		callistoBiomeID = config.get(biomeID, "Callisto Biome ID", 162).getInt();
		ganymedeBiomeID = config.get(biomeID, "Ganymede Biome ID", 163).getInt();
		rheaBiomeID = config.get(biomeID, "Rhea Biome ID", 164).getInt();
		titanBiomeID = config.get(biomeID, "Titan Biome ID", 165).getInt();

		schematicTier4GUIID = config.get(schematicsGUI, "Schematic Tier 4 GUI ID", 5555).getInt();
		schematicTier5GUIID = config.get(schematicsGUI, "Schematic Tier 5 GUI ID", 5556).getInt();
		schematicTier6GUIID = config.get(schematicsGUI, "Schematic Tier 6 GUI ID", 5557).getInt();
		schematicTier7GUIID = config.get(schematicsGUI, "Schematic Tier 7 GUI ID", 5558).getInt();
		schematicTier8GUIID = config.get(schematicsGUI, "Schematic Tier 8 GUI ID", 5559).getInt();
		schematicTier9GUIID = config.get(schematicsGUI, "Schematic Tier 9 GUI ID", 5560).getInt();

		schematicTier4PageID = config.get(schematicsPage, "Schematic Tier 4 Page ID", 6666).getInt();
		schematicTier5PageID = config.get(schematicsPage, "Schematic Tier 5 Page ID", 6667).getInt();
		schematicTier6PageID = config.get(schematicsPage, "Schematic Tier 6 Page ID", 6668).getInt();
		schematicTier7PageID = config.get(schematicsPage, "Schematic Tier 7 Page ID", 6669).getInt();
		schematicTier8PageID = config.get(schematicsPage, "Schematic Tier 8 Page ID", 6670).getInt();
		schematicTier9PageID = config.get(schematicsPage, "Schematic Tier 9 Page ID", 6671).getInt();

		microBlock = config.get(compatibility, "Enable Forge Micro blocks support", true, "").getBoolean(true);
		neiSupport = config.get(compatibility, "Enable NEI Recipe support", true, "").getBoolean(true);

		achievements = config.get(gerenalsettings, "Enable achievements", true, "").getBoolean(true);

		config.save();
	}

}
