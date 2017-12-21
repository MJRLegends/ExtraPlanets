package com.mjr.extraplanets;

public class Constants {
	public static final String modID = "ExtraPlanets";
	public static final String modName = "ExtraPlanets";
	
    public static final int LOCALMAJVERSION = 1;
    public static final int LOCALMINVERSION = 9;
    public static final int LOCALBUILDVERSION = 1;
    
	public static final String modVersion = LOCALMAJVERSION + "." + LOCALMINVERSION + "." + LOCALBUILDVERSION;
	
    public static final String MCVERSION = "[1.7.10]";
    public static final String DEPENDENCIES_FORGE = "required-after:Forge@[10.13.4.1558,); ";  //Keep the space at the end!
    public static final String DEPENDENCIES_MODS = "required-after:GalacticraftCore;required-after:GalacticraftMars; ";  //Keep the space at the end!

	public static final String ASSET_PREFIX = "extraplanets";
	public static final String TEXTURE_PREFIX = ASSET_PREFIX + ":";
	public static final String PREFIX = modID + ".";

	public static final float RADIANS_TO_DEGREES = 180F / 3.1415927F;
	public static final double RADIANS_TO_DEGREES_D = 180D / Math.PI;

	public static final float twoPI = Constants.floatPI * 2F;
	public static final float halfPI = Constants.floatPI / 2F;
	public static final float floatPI = 3.1415927F;

	public static final String CONFIG_FILE = "config/ExtraPlanets.cfg";

	public static final String CONFIG_CATEGORY_MAIN_DIMENSIONS = "main dimensions";
	public static final String CONFIG_CATEGORY_OTHER_DIMENSIONS = "other dimensions";
	public static final String CONFIG_CATEGORY_DIMENSION_IDS = "dimensionID";
	public static final String CONFIG_CATEGORY_DIMENSION_SETTINGS = "dimension settings";
	public static final String CONFIG_CATEGORY_DIMENSION_BLOCK_SETTINGS = "dimension block settings";
	public static final String CONFIG_CATEGORY_BIOME_IDS = "biomeID";
	public static final String CONFIG_CATEGORY_ITEMS = "items";
	public static final String CONFIG_CATEGORY_BLOCKS = "blocks";
	public static final String CONFIG_CATEGORY_SPACE_STATIONS = "space stations";
	public static final String CONFIG_CATEGORY_SCHEMATIC_GUI_IDS = "schematics GUI ID";
	public static final String CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS = "schematics Page ID";
	public static final String CONFIG_CATEGORY_COMPATIBILITY = "compatibility support";
	public static final String CONFIG_CATEGORY_MOD_COMPATIBILITY = "mod compatibility support";
	public static final String CONFIG_CATEGORY_GENERAL_SETTINGS = "general settings";
	public static final String CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS = "celestial body map settings";
	public static final String CONFIG_CATEGORY_ENTITIES = "entities";
}