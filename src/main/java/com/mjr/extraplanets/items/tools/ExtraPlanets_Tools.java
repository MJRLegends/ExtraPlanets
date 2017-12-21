package com.mjr.extraplanets.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;

import cpw.mods.fml.common.registry.GameRegistry;

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

	private static ToolMaterial blueDiamondMaterial = EnumHelper.addToolMaterial("Blue Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial redDiamondMaterial = EnumHelper.addToolMaterial("Red Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial purpleDiamondMaterial = EnumHelper.addToolMaterial("Purple Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial yellowDiamondMaterial = EnumHelper.addToolMaterial("Yellow Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial greenDiamondMaterial = EnumHelper.addToolMaterial("Green Diamond Material", 6, 250, 12.0F, 12.0F, 40);

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
		if (Config.mercury && Config.mercuryItems) {
			mercuryPickaxe = new BasicPickaxe(mercuryMaterial, "mercury_pickaxe");
			mercuryAxe = new BasicAxe(mercuryMaterial, "mercury_axe");
			mercuryHoe = new BasicHoe(mercuryMaterial, "mercury_hoe");
			mercuryShovel = new BasicShovel(mercuryMaterial, "mercury_shovel");
			mercurySword = new BasicSword(mercuryMaterial, "mercury_sword");
		}
		if (Config.venus && Config.carbonItems) {
			carbonPickaxe = new BasicPickaxe(carbonMaterial, "carbon_pickaxe");
			carbonAxe = new BasicAxe(carbonMaterial, "carbon_axe");
			carbonHoe = new BasicHoe(carbonMaterial, "carbon_hoe");
			carbonShovel = new BasicShovel(carbonMaterial, "carbon_shovel");
			carbonSword = new BasicSword(carbonMaterial, "carbon_sword");
		}
		if (Config.ceres && Config.uraniumItems) {
			uraniumPickaxe = new BasicPickaxe(uraniumMaterial, "uranium_pickaxe");
			uraniumAxe = new BasicAxe(uraniumMaterial, "uranium_axe");
			uraniumHoe = new BasicHoe(uraniumMaterial, "uranium_hoe");
			uraniumShovel = new BasicShovel(uraniumMaterial, "uranium_shovel");
			uraniumSword = new BasicSword(uraniumMaterial, "uranium_sword");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				palladiumPickaxe = new BasicPickaxe(palladiumMaterial, "palladium_pickaxe");
				palladiumAxe = new BasicAxe(palladiumMaterial, "palladium_axe");
				palladiumHoe = new BasicHoe(palladiumMaterial, "palladium_hoe");
				palladiumShovel = new BasicShovel(palladiumMaterial, "palladium_shovel");
				palladiumSword = new BasicSword(palladiumMaterial, "palladium_sword");
			}
			if (Config.redGemItems) {
				redGemPickaxe = new BasicPickaxe(redGemMaterial, "red_gem_pickaxe");
				redGemAxe = new BasicAxe(redGemMaterial, "red_gem_axe");
				redGemHoe = new BasicHoe(redGemMaterial, "red_gem_hoe");
				redGemShovel = new BasicShovel(redGemMaterial, "red_gem_shovel");
				redGemSword = new BasicSword(redGemMaterial, "red_gem_sword");
			}
		}
		if (Config.saturn && Config.magnesiumItems) {
			magnesiumPickaxe = new BasicPickaxe(magnesiumMaterial, "magnesium_pickaxe");
			magnesiumAxe = new BasicAxe(magnesiumMaterial, "magnesium_axe");
			magnesiumHoe = new BasicHoe(magnesiumMaterial, "magnesium_hoe");
			magnesiumShovel = new BasicShovel(magnesiumMaterial, "magnesium_shovel");
			magnesiumSword = new BasicSword(magnesiumMaterial, "magnesium_sword");
		}
		if (Config.uranus) {
			if (Config.palladiumItems) {
				crystalPickaxe = new BasicPickaxe(crystalMaterial, "crystal_pickaxe");
				crystalAxe = new BasicAxe(crystalMaterial, "crystal_axe");
				crystalHoe = new BasicHoe(crystalMaterial, "crystal_hoe");
				crystalShovel = new BasicShovel(crystalMaterial, "crystal_shovel");
				crystalSword = new BasicSword(crystalMaterial, "crystal_sword");
			}
			if (Config.whiteGemItems) {
				whiteGemPickaxe = new BasicPickaxe(whiteGemMaterial, "white_gem_pickaxe");
				whiteGemAxe = new BasicAxe(whiteGemMaterial, "white_gem_axe");
				whiteGemHoe = new BasicHoe(whiteGemMaterial, "white_gem_hoe");
				whiteGemShovel = new BasicShovel(whiteGemMaterial, "white_gem_shovel");
				whiteGemSword = new BasicSword(whiteGemMaterial, "white_gem_sword");
			}
		}
		if (Config.neptune) {
			if (Config.blueGemItems) {
				blueGemPickaxe = new BasicPickaxe(blueGemMaterial, "blue_gem_pickaxe");
				blueGemAxe = new BasicAxe(blueGemMaterial, "blue_gem_axe");
				blueGemHoe = new BasicHoe(blueGemMaterial, "blue_gem_hoe");
				blueGemShovel = new BasicShovel(blueGemMaterial, "blue_gem_shovel");
				blueGemSword = new BasicSword(blueGemMaterial, "blue_gem_sword");
			}
			if (Config.zincItems) {
				zincPickaxe = new BasicPickaxe(zincMaterial, "zinc_pickaxe");
				zincAxe = new BasicAxe(zincMaterial, "zinc_axe");
				zincHoe = new BasicHoe(zincMaterial, "zinc_hoe");
				zincShovel = new BasicShovel(zincMaterial, "zinc_shovel");
				zincSword = new BasicSword(zincMaterial, "zinc_sword");
			}
		}
		if (Config.pluto && Config.tungstenItems) {
			tungstenPickaxe = new BasicPickaxe(tungstenMaterial, "tungsten_pickaxe");
			tungstenAxe = new BasicAxe(tungstenMaterial, "tungsten_axe");
			tungstenHoe = new BasicHoe(tungstenMaterial, "tungsten_hoe");
			tungstenShovel = new BasicShovel(tungstenMaterial, "tungsten_shovel");
			tungstenSword = new BasicSword(tungstenMaterial, "tungsten_sword");
		}
		if (Config.kepler22b && Config.kepler22bItems) {
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
		if (Config.mercury && Config.mercuryItems) {
			GameRegistry.registerItem(mercuryPickaxe, "mercuryPickaxe");
			GameRegistry.registerItem(mercuryAxe, "mercuryAxe");
			GameRegistry.registerItem(mercuryHoe, "mercuryHoe");
			GameRegistry.registerItem(mercuryShovel, "mercuryShovel");
			GameRegistry.registerItem(mercurySword, "mercurySword");
		}
		if (Config.venus && Config.carbonItems) {
			GameRegistry.registerItem(carbonPickaxe, "carbonPickaxe");
			GameRegistry.registerItem(carbonAxe, "carbonAxe");
			GameRegistry.registerItem(carbonHoe, "carbonHoe");
			GameRegistry.registerItem(carbonShovel, "carbonShovel");
			GameRegistry.registerItem(carbonSword, "carbonSword");
		}
		if (Config.ceres && Config.uraniumItems) {
			GameRegistry.registerItem(uraniumPickaxe, "uraniumPickaxe");
			GameRegistry.registerItem(uraniumAxe, "uraniumAxe");
			GameRegistry.registerItem(uraniumHoe, "uraniumHoe");
			GameRegistry.registerItem(uraniumShovel, "uraniumShovel");
			GameRegistry.registerItem(uraniumSword, "uraniumSword");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				GameRegistry.registerItem(palladiumPickaxe, "palladiumPickaxe");
				GameRegistry.registerItem(palladiumAxe, "palladiumAxe");
				GameRegistry.registerItem(palladiumHoe, "palladiumHoe");
				GameRegistry.registerItem(palladiumShovel, "palladiumShovel");
				GameRegistry.registerItem(palladiumSword, "palladiumSword");
			}
			if (Config.redGemItems) {
				GameRegistry.registerItem(redGemPickaxe, "redGemPickaxe");
				GameRegistry.registerItem(redGemAxe, "redGemAxe");
				GameRegistry.registerItem(redGemHoe, "redGemHoe");
				GameRegistry.registerItem(redGemShovel, "redGemShovel");
				GameRegistry.registerItem(redGemSword, "redGemSword");
			}
		}
		if (Config.saturn && Config.magnesiumItems) {
			GameRegistry.registerItem(magnesiumPickaxe, "magnesiumPickaxe");
			GameRegistry.registerItem(magnesiumAxe, "magnesiumAxe");
			GameRegistry.registerItem(magnesiumHoe, "magnesiumHoe");
			GameRegistry.registerItem(magnesiumShovel, "magnesiumShovel");
			GameRegistry.registerItem(magnesiumSword, "magnesiumSword");
		}
		if (Config.uranus) {
			if (Config.crystalItems) {
				GameRegistry.registerItem(crystalPickaxe, "crystalPickaxe");
				GameRegistry.registerItem(crystalAxe, "crystalAxe");
				GameRegistry.registerItem(crystalHoe, "crystalHoe");
				GameRegistry.registerItem(crystalShovel, "crystalShovel");
				GameRegistry.registerItem(crystalSword, "crystalSword");
			}
			if (Config.whiteGemItems) {
				GameRegistry.registerItem(whiteGemPickaxe, "whiteGemPickaxe");
				GameRegistry.registerItem(whiteGemAxe, "whiteGemAxe");
				GameRegistry.registerItem(whiteGemHoe, "whiteGemHoe");
				GameRegistry.registerItem(whiteGemShovel, "whiteGemShovel");
				GameRegistry.registerItem(whiteGemSword, "whiteGemSword");
			}
		}
		if (Config.neptune) {
			if (Config.blueGemItems) {
				GameRegistry.registerItem(blueGemPickaxe, "blueGemPickaxe");
				GameRegistry.registerItem(blueGemAxe, "blueGemAxe");
				GameRegistry.registerItem(blueGemHoe, "blueGemHoe");
				GameRegistry.registerItem(blueGemShovel, "blueGemShovel");
				GameRegistry.registerItem(blueGemSword, "blueGemSword");
			}
			if (Config.zincItems) {
				GameRegistry.registerItem(zincPickaxe, "zincPickaxe");
				GameRegistry.registerItem(zincAxe, "zincAxe");
				GameRegistry.registerItem(zincHoe, "zincHoe");
				GameRegistry.registerItem(zincShovel, "zincShovel");
				GameRegistry.registerItem(zincSword, "zincSword");
			}
		}
		if (Config.pluto && Config.tungstenItems) {
			GameRegistry.registerItem(tungstenPickaxe, "tungstenPickaxe");
			GameRegistry.registerItem(tungstenAxe, "tungstenAxe");
			GameRegistry.registerItem(tungstenHoe, "tungstenHoe");
			GameRegistry.registerItem(tungstenShovel, "tungstenShovel");
			GameRegistry.registerItem(tungstenSword, "tungstenSword");
		}
		if (Config.kepler22b && Config.kepler22bItems) {
			GameRegistry.registerItem(blueDiamondPickaxe, "blueDiamondPickaxe");
			GameRegistry.registerItem(blueDiamondAxe, "blueDiamondAxe");
			GameRegistry.registerItem(blueDiamondHoe, "blueDiamondHoe");
			GameRegistry.registerItem(blueDiamondShovel, "blueDiamondShovel");
			GameRegistry.registerItem(blueDiamondSword, "blueDiamondSword");

			GameRegistry.registerItem(redDiamondPickaxe, "redDiamondPickaxe");
			GameRegistry.registerItem(redDiamondAxe, "redDiamondAxe");
			GameRegistry.registerItem(redDiamondHoe, "redDiamondHoe");
			GameRegistry.registerItem(redDiamondShovel, "redDiamondShovel");
			GameRegistry.registerItem(redDiamondSword, "redDiamondSword");

			GameRegistry.registerItem(purpleDiamondPickaxe, "purpleDiamondPickaxe");
			GameRegistry.registerItem(purpleDiamondAxe, "purpleDiamondAxe");
			GameRegistry.registerItem(purpleDiamondHoe, "purpleDiamondHoe");
			GameRegistry.registerItem(purpleDiamondShovel, "purpleDiamondShovel");
			GameRegistry.registerItem(purpleDiamondSword, "purpleDiamondSword");

			GameRegistry.registerItem(yellowDiamondPickaxe, "yellowDiamondPickaxe");
			GameRegistry.registerItem(yellowDiamondAxe, "yellowDiamondAxe");
			GameRegistry.registerItem(yellowDiamondHoe, "yellowDiamondHoe");
			GameRegistry.registerItem(yellowDiamondShovel, "yellowDiamondShovel");
			GameRegistry.registerItem(yellowDiamondSword, "yellowDiamondSword");

			GameRegistry.registerItem(greenDiamondPickaxe, "greenDiamondPickaxe");
			GameRegistry.registerItem(greenDiamondAxe, "greenDiamondAxe");
			GameRegistry.registerItem(greenDiamondHoe, "greenDiamondHoe");
			GameRegistry.registerItem(greenDiamondShovel, "greenDiamondShovel");
			GameRegistry.registerItem(greenDiamondSword, "greenDiamondSword");
		}
	}
}
