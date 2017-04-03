package com.mjr.extraplanets.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.util.RegisterHelper;

public class ExtraPlanets_Tools {
	private static ToolMaterial carbonMaterial = EnumHelper.addToolMaterial("Carbon Material", 3, 40, 4.0F, 6.0F, 30);
	private static ToolMaterial palladiumMaterial = EnumHelper.addToolMaterial("Palladium Material", 4, 60, 6.0F, 8.0F, 30);
	private static ToolMaterial magnesiumMaterial = EnumHelper.addToolMaterial("Magnesium Material", 5, 80, 8.0F, 10.0F, 30);
	private static ToolMaterial crystalMaterial = EnumHelper.addToolMaterial("Crystal Material", 6, 120, 10.0F, 12.0F, 30);
	private static ToolMaterial tungstenMaterial = EnumHelper.addToolMaterial("Tungsten Material", 7, 120, 10.0F, 12.0F, 30);

	private static ToolMaterial zincMaterial = EnumHelper.addToolMaterial("Zinc Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial mercuryMaterial = EnumHelper.addToolMaterial("Mercury Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial uraniumMaterial = EnumHelper.addToolMaterial("Uranium Material", 6, 160, 10.0F, 12.0F, 30);

	private static ToolMaterial redGemMaterial = EnumHelper.addToolMaterial("Red Gem Material", 4, 80, 6.0F, 8.0F, 30);
	private static ToolMaterial blueGemMaterial = EnumHelper.addToolMaterial("Blue Gem Material", 5, 100, 8.0F, 10.0F, 30);
	private static ToolMaterial whiteGemMaterial = EnumHelper.addToolMaterial("White Gem Material", 6, 160, 10.0F, 12.0F, 30);

	private static ToolMaterial blueDiamondMaterial = EnumHelper.addToolMaterial("Blue Diamond Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial redDiamondMaterial = EnumHelper.addToolMaterial("Red Diamond Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial purpleDiamondMaterial = EnumHelper.addToolMaterial("Purple Diamond Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial yellowDiamondMaterial = EnumHelper.addToolMaterial("Yellow Diamond Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial greenDiamondMaterial = EnumHelper.addToolMaterial("Green Diamond Material", 6, 160, 10.0F, 12.0F, 30);

	public static Item carbonPickaxe;
	public static Item carbonAxe;
	public static Item carbonHoe;
	public static Item carbonShovel;
	public static Item carbonSword;

	public static Item palladiumPickaxe;
	public static Item palladiumAxe;
	public static Item palladiumHoe;
	public static Item palladiumShovel;
	public static Item palladiumSword;

	public static Item magnesiumPickaxe;
	public static Item magnesiumAxe;
	public static Item magnesiumHoe;
	public static Item magnesiumShovel;
	public static Item magnesiumSword;

	public static Item crystalPickaxe;
	public static Item crystalAxe;
	public static Item crystalHoe;
	public static Item crystalShovel;
	public static Item crystalSword;

	public static Item tungstenPickaxe;
	public static Item tungstenAxe;
	public static Item tungstenHoe;
	public static Item tungstenShovel;
	public static Item tungstenSword;

	public static Item redGemPickaxe;
	public static Item redGemAxe;
	public static Item redGemHoe;
	public static Item redGemShovel;
	public static Item redGemSword;

	public static Item blueGemPickaxe;
	public static Item blueGemAxe;
	public static Item blueGemHoe;
	public static Item blueGemShovel;
	public static Item blueGemSword;

	public static Item whiteGemPickaxe;
	public static Item whiteGemAxe;
	public static Item whiteGemHoe;
	public static Item whiteGemShovel;
	public static Item whiteGemSword;

	public static Item zincPickaxe;
	public static Item zincAxe;
	public static Item zincHoe;
	public static Item zincShovel;
	public static Item zincSword;

	public static Item mercuryPickaxe;
	public static Item mercuryAxe;
	public static Item mercuryHoe;
	public static Item mercuryShovel;
	public static Item mercurySword;

	public static Item uraniumPickaxe;
	public static Item uraniumAxe;
	public static Item uraniumHoe;
	public static Item uraniumShovel;
	public static Item uraniumSword;

	public static Item blueDiamondPickaxe;
	public static Item blueDiamondAxe;
	public static Item blueDiamondHoe;
	public static Item blueDiamondShovel;
	public static Item blueDiamondSword;

	public static Item redDiamondPickaxe;
	public static Item redDiamondAxe;
	public static Item redDiamondHoe;
	public static Item redDiamondShovel;
	public static Item redDiamondSword;

	public static Item purpleDiamondPickaxe;
	public static Item purpleDiamondAxe;
	public static Item purpleDiamondHoe;
	public static Item purpleDiamondShovel;
	public static Item purpleDiamondSword;

	public static Item yellowDiamondPickaxe;
	public static Item yellowDiamondAxe;
	public static Item yellowDiamondHoe;
	public static Item yellowDiamondShovel;
	public static Item yellowDiamondSword;

	public static Item greenDiamondPickaxe;
	public static Item greenDiamondAxe;
	public static Item greenDiamondHoe;
	public static Item greenDiamondShovel;
	public static Item greenDiamondSword;

	public static void init() {
		initializeTools();
		registerTools();
	}

	private static void initializeTools() {
		if (Config.MERCURY && Config.ITEMS_MERCURY) {
			mercuryPickaxe = new BasicPickaxe(mercuryMaterial, "mercury_pickaxe");
			mercuryAxe = new BasicAxe(mercuryMaterial, "mercury_axe");
			mercuryHoe = new BasicHoe(mercuryMaterial, "mercury_hoe");
			mercuryShovel = new BasicShovel(mercuryMaterial, "mercury_shovel");
			mercurySword = new BasicSword(mercuryMaterial, "mercury_sword");
		}
		if (Config.MERCURY && Config.ITEMS_CARBON) {
			carbonPickaxe = new BasicPickaxe(carbonMaterial, "carbon_pickaxe");
			carbonAxe = new BasicAxe(carbonMaterial, "carbon_axe");
			carbonHoe = new BasicHoe(carbonMaterial, "carbon_hoe");
			carbonShovel = new BasicShovel(carbonMaterial, "carbon_shovel");
			carbonSword = new BasicSword(carbonMaterial, "carbon_sword");
		}
		if (Config.CERES && Config.ITEMS_URANIUM) {
			uraniumPickaxe = new BasicPickaxe(uraniumMaterial, "uranium_pickaxe");
			uraniumAxe = new BasicAxe(uraniumMaterial, "uranium_axe");
			uraniumHoe = new BasicHoe(uraniumMaterial, "uranium_hoe");
			uraniumShovel = new BasicShovel(uraniumMaterial, "uranium_shovel");
			uraniumSword = new BasicSword(uraniumMaterial, "uranium_sword");
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				palladiumPickaxe = new BasicPickaxe(palladiumMaterial, "palladium_pickaxe");
				palladiumAxe = new BasicAxe(palladiumMaterial, "palladium_axe");
				palladiumHoe = new BasicHoe(palladiumMaterial, "palladium_hoe");
				palladiumShovel = new BasicShovel(palladiumMaterial, "palladium_shovel");
				palladiumSword = new BasicSword(palladiumMaterial, "palladium_sword");
			}
			if (Config.ITEMS_GEM_RED) {
				redGemPickaxe = new BasicPickaxe(redGemMaterial, "red_gem_pickaxe");
				redGemAxe = new BasicAxe(redGemMaterial, "red_gem_axe");
				redGemHoe = new BasicHoe(redGemMaterial, "red_gem_hoe");
				redGemShovel = new BasicShovel(redGemMaterial, "red_gem_shovel");
				redGemSword = new BasicSword(redGemMaterial, "red_gem_sword");
			}
		}
		if (Config.SATURN && Config.ITEMS_MAGNESIUM) {
			magnesiumPickaxe = new BasicPickaxe(magnesiumMaterial, "magnesium_pickaxe");
			magnesiumAxe = new BasicAxe(magnesiumMaterial, "magnesium_axe");
			magnesiumHoe = new BasicHoe(magnesiumMaterial, "magnesium_hoe");
			magnesiumShovel = new BasicShovel(magnesiumMaterial, "magnesium_shovel");
			magnesiumSword = new BasicSword(magnesiumMaterial, "magnesium_sword");
		}
		if (Config.URANUS) {
			if (Config.ITEMS_PALLADIUM) {
				crystalPickaxe = new BasicPickaxe(crystalMaterial, "crystal_pickaxe");
				crystalAxe = new BasicAxe(crystalMaterial, "crystal_axe");
				crystalHoe = new BasicHoe(crystalMaterial, "crystal_hoe");
				crystalShovel = new BasicShovel(crystalMaterial, "crystal_shovel");
				crystalSword = new BasicSword(crystalMaterial, "crystal_sword");
			}
			if (Config.ITEMS_GEM_WHITE) {
				whiteGemPickaxe = new BasicPickaxe(whiteGemMaterial, "white_gem_pickaxe");
				whiteGemAxe = new BasicAxe(whiteGemMaterial, "white_gem_axe");
				whiteGemHoe = new BasicHoe(whiteGemMaterial, "white_gem_hoe");
				whiteGemShovel = new BasicShovel(whiteGemMaterial, "white_gem_shovel");
				whiteGemSword = new BasicSword(whiteGemMaterial, "white_gem_sword");
			}
		}
		if (Config.NEPTUNE) {
			if (Config.ITEMS_GEM_BLUE) {
				blueGemPickaxe = new BasicPickaxe(blueGemMaterial, "blue_gem_pickaxe");
				blueGemAxe = new BasicAxe(blueGemMaterial, "blue_gem_axe");
				blueGemHoe = new BasicHoe(blueGemMaterial, "blue_gem_hoe");
				blueGemShovel = new BasicShovel(blueGemMaterial, "blue_gem_shovel");
				blueGemSword = new BasicSword(blueGemMaterial, "blue_gem_sword");
			}
			if (Config.ITEMS_ZINC) {
				zincPickaxe = new BasicPickaxe(zincMaterial, "zinc_pickaxe");
				zincAxe = new BasicAxe(zincMaterial, "zinc_axe");
				zincHoe = new BasicHoe(zincMaterial, "zinc_hoe");
				zincShovel = new BasicShovel(zincMaterial, "zinc_shovel");
				zincSword = new BasicSword(zincMaterial, "zinc_sword");
			}
		}
		if (Config.PLUTO && Config.ITEMS_TUNGSTEN) {
			tungstenPickaxe = new BasicPickaxe(tungstenMaterial, "tungsten_pickaxe");
			tungstenAxe = new BasicAxe(tungstenMaterial, "tungsten_axe");
			tungstenHoe = new BasicHoe(tungstenMaterial, "tungsten_hoe");
			tungstenShovel = new BasicShovel(tungstenMaterial, "tungsten_shovel");
			tungstenSword = new BasicSword(tungstenMaterial, "tungsten_sword");
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			blueDiamondPickaxe = new BasicPickaxe(blueDiamondMaterial, "blue_diamond_pickaxe");
			blueDiamondAxe = new BasicAxe(blueDiamondMaterial, "blue_diamond_axe");
			blueDiamondHoe = new BasicHoe(blueDiamondMaterial, "blue_diamond_hoe");
			blueDiamondShovel = new BasicShovel(blueDiamondMaterial, "blue_diamond_shovel");
			blueDiamondSword = new BasicSword(blueDiamondMaterial, "blue_diamond_sword");

			redDiamondPickaxe = new BasicPickaxe(redDiamondMaterial, "red_diamond_pickaxe");
			redDiamondAxe = new BasicAxe(redDiamondMaterial, "red_diamond_axe");
			redDiamondHoe = new BasicHoe(redDiamondMaterial, "red_diamond_hoe");
			redDiamondShovel = new BasicShovel(redDiamondMaterial, "red_diamond_shovel");
			redDiamondSword = new BasicSword(redDiamondMaterial, "red_diamond_sword");

			purpleDiamondPickaxe = new BasicPickaxe(purpleDiamondMaterial, "purple_diamond_pickaxe");
			purpleDiamondAxe = new BasicAxe(purpleDiamondMaterial, "purple_diamond_axe");
			purpleDiamondHoe = new BasicHoe(purpleDiamondMaterial, "purple_diamond_hoe");
			purpleDiamondShovel = new BasicShovel(purpleDiamondMaterial, "purple_diamond_shovel");
			purpleDiamondSword = new BasicSword(purpleDiamondMaterial, "purple_diamond_sword");

			yellowDiamondPickaxe = new BasicPickaxe(yellowDiamondMaterial, "yellow_diamond_pickaxe");
			yellowDiamondAxe = new BasicAxe(yellowDiamondMaterial, "yellow_diamond_axe");
			yellowDiamondHoe = new BasicHoe(yellowDiamondMaterial, "yellow_diamond_hoe");
			yellowDiamondShovel = new BasicShovel(yellowDiamondMaterial, "yellow_diamond_shovel");
			yellowDiamondSword = new BasicSword(yellowDiamondMaterial, "yellow_diamond_sword");

			greenDiamondPickaxe = new BasicPickaxe(greenDiamondMaterial, "green_diamond_pickaxe");
			greenDiamondAxe = new BasicAxe(greenDiamondMaterial, "green_diamond_axe");
			greenDiamondHoe = new BasicHoe(greenDiamondMaterial, "green_diamond_hoe");
			greenDiamondShovel = new BasicShovel(greenDiamondMaterial, "green_diamond_shovel");
			greenDiamondSword = new BasicSword(greenDiamondMaterial, "green_diamond_sword");
		}
	}

	private static void registerTools() {
		if (Config.MERCURY && Config.ITEMS_MERCURY) {
			RegisterHelper.registerItem(mercuryPickaxe, mercuryPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(mercuryAxe, mercuryAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(mercuryHoe, mercuryHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(mercuryShovel, mercuryShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(mercurySword, mercurySword.getUnlocalizedName().substring(5));
		}
		if (Config.MERCURY && Config.ITEMS_CARBON) {
			RegisterHelper.registerItem(carbonPickaxe, carbonPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(carbonAxe, carbonAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(carbonHoe, carbonHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(carbonShovel, carbonShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(carbonSword, carbonSword.getUnlocalizedName().substring(5));
		}
		if (Config.CERES && Config.ITEMS_URANIUM) {
			RegisterHelper.registerItem(uraniumPickaxe, uraniumPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(uraniumAxe, uraniumAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(uraniumHoe, uraniumHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(uraniumShovel, uraniumShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(uraniumSword, uraniumSword.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				RegisterHelper.registerItem(palladiumPickaxe, palladiumPickaxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(palladiumAxe, palladiumAxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(palladiumHoe, palladiumHoe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(palladiumShovel, palladiumShovel.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(palladiumSword, palladiumSword.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_RED) {
				RegisterHelper.registerItem(redGemPickaxe, redGemPickaxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(redGemAxe, redGemAxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(redGemHoe, redGemHoe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(redGemShovel, redGemShovel.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(redGemSword, redGemSword.getUnlocalizedName().substring(5));
			}
		}
		if (Config.SATURN && Config.ITEMS_MAGNESIUM) {
			RegisterHelper.registerItem(magnesiumPickaxe, magnesiumPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(magnesiumAxe, magnesiumAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(magnesiumHoe, magnesiumHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(magnesiumShovel, magnesiumShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(magnesiumSword, magnesiumSword.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			if (Config.ITEMS_CRYSTAL) {
				RegisterHelper.registerItem(crystalPickaxe, crystalPickaxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(crystalAxe, crystalAxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(crystalHoe, crystalHoe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(crystalShovel, crystalShovel.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(crystalSword, crystalSword.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_WHITE) {
				RegisterHelper.registerItem(whiteGemPickaxe, whiteGemPickaxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(whiteGemAxe, whiteGemAxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(whiteGemHoe, whiteGemHoe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(whiteGemShovel, whiteGemShovel.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(whiteGemSword, whiteGemSword.getUnlocalizedName().substring(5));
			}
		}
		if (Config.NEPTUNE) {
			if (Config.ITEMS_GEM_BLUE) {
				RegisterHelper.registerItem(blueGemPickaxe, blueGemPickaxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(blueGemAxe, blueGemAxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(blueGemHoe, blueGemHoe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(blueGemShovel, blueGemShovel.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(blueGemSword, blueGemSword.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_ZINC) {
				RegisterHelper.registerItem(zincPickaxe, zincPickaxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(zincAxe, zincAxe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(zincHoe, zincHoe.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(zincShovel, zincShovel.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(zincSword, zincSword.getUnlocalizedName().substring(5));
			}
		}
		if (Config.PLUTO && Config.ITEMS_TUNGSTEN) {
			RegisterHelper.registerItem(tungstenPickaxe, tungstenPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(tungstenAxe, tungstenAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(tungstenHoe, tungstenHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(tungstenShovel, tungstenShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(tungstenSword, tungstenSword.getUnlocalizedName().substring(5));
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterHelper.registerItem(blueDiamondPickaxe, blueDiamondPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(blueDiamondAxe, blueDiamondAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(blueDiamondHoe, blueDiamondHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(blueDiamondShovel, blueDiamondShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(blueDiamondSword, blueDiamondSword.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(redDiamondPickaxe, redDiamondPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(redDiamondAxe, redDiamondAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(redDiamondHoe, redDiamondHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(redDiamondShovel, redDiamondShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(redDiamondSword, redDiamondSword.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(purpleDiamondPickaxe, purpleDiamondPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(purpleDiamondAxe, purpleDiamondAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(purpleDiamondHoe, purpleDiamondHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(purpleDiamondShovel, purpleDiamondShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(purpleDiamondSword, purpleDiamondSword.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(yellowDiamondPickaxe, yellowDiamondPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(yellowDiamondAxe, yellowDiamondAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(yellowDiamondHoe, yellowDiamondHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(yellowDiamondShovel, yellowDiamondShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(yellowDiamondSword, yellowDiamondSword.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(greenDiamondPickaxe, greenDiamondPickaxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(greenDiamondAxe, greenDiamondAxe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(greenDiamondHoe, greenDiamondHoe.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(greenDiamondShovel, greenDiamondShovel.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(greenDiamondSword, greenDiamondSword.getUnlocalizedName().substring(5));
		}
	}
}
