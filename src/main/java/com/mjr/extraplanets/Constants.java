package com.mjr.extraplanets;

public class Constants {
	public static final String modID = "extraplanets";
	public static final String modName = "ExtraPlanets";

	public static final int LOCALMAJVERSION = 0;
	public static final int LOCALMINVERSION = 3;
	public static final int LOCALBUILDVERSION = 5;

	public static final String modVersion = LOCALMAJVERSION + "." + LOCALMINVERSION + "." + LOCALBUILDVERSION + "-Beta-Build";

	public static final String MCVERSION = "[1.10.2]";
	public static final String DEPENDENCIES_FORGE = "required-after:Forge@[12.18.3.2239,); "; // Keep the space at the end!
	public static final String DEPENDENCIES_MODS = "required-after:galacticraftcore; required-after:galacticraftplanets; "; // Keep the space at the end!

	public static final String ASSET_PREFIX = modID;
	public static final String TEXTURE_PREFIX = ASSET_PREFIX + ":";
	public static final String PREFIX = modID + ".";

	public static final float RADIANS_TO_DEGREES = 180F / 3.1415927F;
	public static final double RADIANS_TO_DEGREES_D = 180D / Math.PI;

	public static final float twoPI = Constants.floatPI * 2F;
	public static final float halfPI = Constants.floatPI / 2F;
	public static final float floatPI = 3.1415927F;

	public static final int GEAR_ID_OXYGEN_TANK_VERY_HEAVY = 5000;
	public static final int GEAR_ID_OXYGEN_TANK_EXTREMELY_HEAVY = 5001;
	public static final int GEAR_ID_THERMAL_PADDING_T3_HELMET = 6000;
	public static final int GEAR_ID_THERMAL_PADDING_T3_CHESTPLATE = 6001;
	public static final int GEAR_ID_THERMAL_PADDING_T3_LEGGINGS = 6002;
	public static final int GEAR_ID_THERMAL_PADDING_T3_BOOTS = 6003;
	public static final int GEAR_ID_THERMAL_PADDING_T4_HELMET = 6004;
	public static final int GEAR_ID_THERMAL_PADDING_T4_CHESTPLATE = 6005;
	public static final int GEAR_ID_THERMAL_PADDING_T4_LEGGINGS = 6006;
	public static final int GEAR_ID_THERMAL_PADDING_T4_BOOTS = 6007;
	public static final int GEAR_ID_THERMAL_PADDING_T5_HELMET = 6008;
	public static final int GEAR_ID_THERMAL_PADDING_T5_CHESTPLATE = 6009;
	public static final int GEAR_ID_THERMAL_PADDING_T5_LEGGINGS = 6010;
	public static final int GEAR_ID_THERMAL_PADDING_T5_BOOTS = 6011;

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
	public static final String CONFIG_CATEGORY_GENERAL_SETTINGS = "general settings";
}