package com.mjr.extraplanets;

public class Constants {
	public static final String modID = "extraplanets";
	public static final String modName = "ExtraPlanets";

	public static final int LOCALMAJVERSION = 0;
	public static final int LOCALMINVERSION = 8;
	public static final int LOCALBUILDVERSION = 5;

	public static final String modVersion = LOCALMAJVERSION + "." + LOCALMINVERSION + "." + LOCALBUILDVERSION;

	public static final String MCVERSION = "[1.10.2]";
	public static final String DEPENDENCIES_FORGE = "required-after:Forge@[12.18.3.2239,); "; // Keep the space at the end!
	public static final String DEPENDENCIES_MODS = "required-after:galacticraftcore; required-after:galacticraftplanets; required-after:mjrlegendslib; "; // Keep the space at the end!

	public static final String ASSET_PREFIX = modID;
	public static final String TEXTURE_PREFIX = ASSET_PREFIX + ":";
	public static final String PREFIX = modID + ".";

	public static final float RADIANS_TO_DEGREES = 180F / 3.1415927F;
	public static final double RADIANS_TO_DEGREES_D = 180D / Math.PI;

	public static final float twoPI = Constants.floatPI * 2F;
	public static final float halfPI = Constants.floatPI / 2F;
	public static final float quarterPI = Constants.halfPI / 2F;
	public static final float floatPI = 3.1415927F;
	
	public static final int SPACE_STATION_LOWER_Y_LIMIT = 10;
	public static final int SPACE_STATION_HIGHER_Y_LIMIT = 1200;
	
	public static final float PLANET_AND_MOON_SPAWN_HEIGHT = 900.0F;
	public static final double PLANET_AND_MOON_SPAWN_HEIGHT_D = 900.0D;
	
	public static final double SPACE_STATION_SPAWN_HEIGHT_D = 65.0D;
	
	public static final double PLANET_AND_MOON_PARA_CHEST_SPAWN_HEIGHT_D = 220.0D;
	public static final double SPACE_STATION_PARA_CHEST_SPAWN_HEIGHT_D = 90.0D;

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
	
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_BLACK = 6011;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_RED = 6012;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_GREEN = 6013;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_BROWN = 6014;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_BLUE = 6015;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_PURPLE = 6016;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_CYAN = 6017;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_LIGHT_GRAY = 6018;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_GRAY = 6019;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_PINK = 6020;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_YELLOW = 6021;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_LIGHT_BLUE = 6022;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_MAGENTA = 6023;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_ORANGE = 6024;
	public static final int GEAR_ID_LIGHT_OXYGEN_TANK_WHITE = 6025;

	public static final int GEAR_ID_MED_OXYGEN_TANK_BLACK = 6026;
	public static final int GEAR_ID_MED_OXYGEN_TANK_RED = 6027;
	public static final int GEAR_ID_MED_OXYGEN_TANK_GREEN = 6028;
	public static final int GEAR_ID_MED_OXYGEN_TANK_BROWN = 6029;
	public static final int GEAR_ID_MED_OXYGEN_TANK_BLUE = 6030;
	public static final int GEAR_ID_MED_OXYGEN_TANK_PURPLE = 6031;
	public static final int GEAR_ID_MED_OXYGEN_TANK_CYAN = 6032;
	public static final int GEAR_ID_MED_OXYGEN_TANK_LIGHT_GRAY = 6033;
	public static final int GEAR_ID_MED_OXYGEN_TANK_GRAY = 6034;
	public static final int GEAR_ID_MED_OXYGEN_TANK_PINK = 6035;
	public static final int GEAR_ID_MED_OXYGEN_TANK_YELLOW = 6036;
	public static final int GEAR_ID_MED_OXYGEN_TANK_LIGHT_BLUE = 6037;
	public static final int GEAR_ID_MED_OXYGEN_TANK_MAGENTA = 6038;
	public static final int GEAR_ID_MED_OXYGEN_TANK_LIME = 6039;
	public static final int GEAR_ID_MED_OXYGEN_TANK_WHITE = 6040;

	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_BLACK = 6041;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_LIME = 6042;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_GREEN = 6043;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_BROWN = 6044;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_BLUE = 6045;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_PURPLE = 6046;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_CYAN = 6047;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_LIGHT_GRAY = 6048;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_GRAY = 6049;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_PINK = 6050;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_YELLOW = 6051;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_LIGHT_BLUE = 6052;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_MAGENTA = 6053;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_ORANGE = 6054;
	public static final int GEAR_ID_HEAVY_OXYGEN_TANK_WHITE = 6055;

	public static final String CONFIG_FILE = "config/ExtraPlanets.cfg";

	public static final String CONFIG_CATEGORY_MAIN_DIMENSIONS = "main dimensions";
	public static final String CONFIG_CATEGORY_OTHER_DIMENSIONS = "other dimensions";
	public static final String CONFIG_CATEGORY_DIMENSION_IDS = "dimensionID";
	public static final String CONFIG_CATEGORY_DIMENSION_SETTINGS = "dimension settings";
	public static final String CONFIG_CATEGORY_BIOME_IDS = "biomeID";
	public static final String CONFIG_CATEGORY_ITEMS = "items";
	public static final String CONFIG_CATEGORY_BLOCKS = "blocks";
	public static final String CONFIG_CATEGORY_SPACE_STATIONS = "space stations";
	public static final String CONFIG_CATEGORY_SCHEMATIC_GUI_IDS = "schematics GUI ID";
	public static final String CONFIG_CATEGORY_SCHEMATIC_PAGE_IDS = "schematics Page ID";
	public static final String CONFIG_CATEGORY_COMPATIBILITY = "compatibility support";
	public static final String CONFIG_CATEGORY_GENERAL_SETTINGS = "general settings";
	public static final String CONFIG_CATEGORY_CELESTIAL_BODY_MAP_SETTINGS = "celestial body map settings";
}