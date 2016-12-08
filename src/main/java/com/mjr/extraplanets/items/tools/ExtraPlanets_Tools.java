package com.mjr.extraplanets.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;

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
		if (Config.mercury && Config.mercuryItems) {
			mercuryPickaxe = new BasicPickaxe(mercuryMaterial, "mercuryPickaxe");
			mercuryAxe = new BasicAxe(mercuryMaterial, "mercuryAxe");
			mercuryHoe = new BasicHoe(mercuryMaterial, "mercuryHoe");
			mercuryShovel = new BasicShovel(mercuryMaterial, "mercuryShovel");
			mercurySword = new BasicSword(mercuryMaterial, "mercurySword");
		}
		if (Config.venus && Config.carbonItems) {
			carbonPickaxe = new BasicPickaxe(carbonMaterial, "carbonPickaxe");
			carbonAxe = new BasicAxe(carbonMaterial, "carbonAxe");
			carbonHoe = new BasicHoe(carbonMaterial, "carbonHoe");
			carbonShovel = new BasicShovel(carbonMaterial, "carbonShovel");
			carbonSword = new BasicSword(carbonMaterial, "carbonSword");
		}
		if (Config.ceres && Config.uraniumItems) {
			uraniumPickaxe = new BasicPickaxe(uraniumMaterial, "uraniumPickaxe");
			uraniumAxe = new BasicAxe(uraniumMaterial, "uraniumAxe");
			uraniumHoe = new BasicHoe(uraniumMaterial, "uraniumHoe");
			uraniumShovel = new BasicShovel(uraniumMaterial, "uraniumShovel");
			uraniumSword = new BasicSword(uraniumMaterial, "uraniumSword");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				palladiumPickaxe = new BasicPickaxe(palladiumMaterial, "palladiumPickaxe");
				palladiumAxe = new BasicAxe(palladiumMaterial, "palladiumAxe");
				palladiumHoe = new BasicHoe(palladiumMaterial, "palladiumHoe");
				palladiumShovel = new BasicShovel(palladiumMaterial, "palladiumShovel");
				palladiumSword = new BasicSword(palladiumMaterial, "palladiumSword");
			}
			if (Config.redGemItems) {
				redGemPickaxe = new BasicPickaxe(redGemMaterial, "redGemPickaxe");
				redGemAxe = new BasicAxe(redGemMaterial, "redGemAxe");
				redGemHoe = new BasicHoe(redGemMaterial, "redGemHoe");
				redGemShovel = new BasicShovel(redGemMaterial, "redGemShovel");
				redGemSword = new BasicSword(redGemMaterial, "redGemSword");
			}
		}
		if (Config.saturn && Config.magnesiumItems) {
			magnesiumPickaxe = new BasicPickaxe(magnesiumMaterial, "magnesiumPickaxe");
			magnesiumAxe = new BasicAxe(magnesiumMaterial, "magnesiumAxe");
			magnesiumHoe = new BasicHoe(magnesiumMaterial, "magnesiumHoe");
			magnesiumShovel = new BasicShovel(magnesiumMaterial, "magnesiumShovel");
			magnesiumSword = new BasicSword(magnesiumMaterial, "magnesiumSword");
		}
		if (Config.uranus) {
			if (Config.palladiumItems) {
				crystalPickaxe = new BasicPickaxe(crystalMaterial, "crystalPickaxe");
				crystalAxe = new BasicAxe(crystalMaterial, "crystalAxe");
				crystalHoe = new BasicHoe(crystalMaterial, "crystalHoe");
				crystalShovel = new BasicShovel(crystalMaterial, "crystalShovel");
				crystalSword = new BasicSword(crystalMaterial, "crystalSword");
			}
			if (Config.whiteGemItems) {
				whiteGemPickaxe = new BasicPickaxe(whiteGemMaterial, "whiteGemPickaxe");
				whiteGemAxe = new BasicAxe(whiteGemMaterial, "whiteGemAxe");
				whiteGemHoe = new BasicHoe(whiteGemMaterial, "whiteGemHoe");
				whiteGemShovel = new BasicShovel(whiteGemMaterial, "whiteGemShovel");
				whiteGemSword = new BasicSword(whiteGemMaterial, "whiteGemSword");
			}
		}
		if (Config.neptune) {
			if (Config.blueGemItems) {
				blueGemPickaxe = new BasicPickaxe(blueGemMaterial, "blueGemPickaxe");
				blueGemAxe = new BasicAxe(blueGemMaterial, "blueGemAxe");
				blueGemHoe = new BasicHoe(blueGemMaterial, "blueGemHoe");
				blueGemShovel = new BasicShovel(blueGemMaterial, "blueGemShovel");
				blueGemSword = new BasicSword(blueGemMaterial, "blueGemSword");
			}
			if (Config.zincItems) {
				zincPickaxe = new BasicPickaxe(zincMaterial, "zincPickaxe");
				zincAxe = new BasicAxe(zincMaterial, "zincAxe");
				zincHoe = new BasicHoe(zincMaterial, "zincHoe");
				zincShovel = new BasicShovel(zincMaterial, "zincShovel");
				zincSword = new BasicSword(zincMaterial, "zincSword");
			}
		}
		if (Config.pluto && Config.tungstenItems) {
			tungstenPickaxe = new BasicPickaxe(tungstenMaterial, "tungstenPickaxe");
			tungstenAxe = new BasicAxe(tungstenMaterial, "tungstenAxe");
			tungstenHoe = new BasicHoe(tungstenMaterial, "tungstenHoe");
			tungstenShovel = new BasicShovel(tungstenMaterial, "tungstenShovel");
			tungstenSword = new BasicSword(tungstenMaterial, "tungstenSword");
		}
		if (Config.kepler22b && Config.kepler22bItems) {
			blueDiamondPickaxe = new BasicPickaxe(blueDiamondMaterial, "blueDiamondPickaxe");
			blueDiamondAxe = new BasicAxe(blueDiamondMaterial, "blueDiamondAxe");
			blueDiamondHoe = new BasicHoe(blueDiamondMaterial, "blueDiamondHoe");
			blueDiamondShovel = new BasicShovel(blueDiamondMaterial, "blueDiamondShovel");
			blueDiamondSword = new BasicSword(blueDiamondMaterial, "blueDiamondSword");

			redDiamondPickaxe = new BasicPickaxe(redDiamondMaterial, "redDiamondPickaxe");
			redDiamondAxe = new BasicAxe(redDiamondMaterial, "redDiamondAxe");
			redDiamondHoe = new BasicHoe(redDiamondMaterial, "redDiamondHoe");
			redDiamondShovel = new BasicShovel(redDiamondMaterial, "redDiamondShovel");
			redDiamondSword = new BasicSword(redDiamondMaterial, "redDiamondSword");

			purpleDiamondPickaxe = new BasicPickaxe(purpleDiamondMaterial, "purpleDiamondPickaxe");
			purpleDiamondAxe = new BasicAxe(purpleDiamondMaterial, "purpleDiamondAxe");
			purpleDiamondHoe = new BasicHoe(purpleDiamondMaterial, "purpleDiamondHoe");
			purpleDiamondShovel = new BasicShovel(purpleDiamondMaterial, "purpleDiamondShovel");
			purpleDiamondSword = new BasicSword(purpleDiamondMaterial, "purpleDiamondSword");

			yellowDiamondPickaxe = new BasicPickaxe(yellowDiamondMaterial, "yellowDiamondPickaxe");
			yellowDiamondAxe = new BasicAxe(yellowDiamondMaterial, "yellowDiamondAxe");
			yellowDiamondHoe = new BasicHoe(yellowDiamondMaterial, "yellowDiamondHoe");
			yellowDiamondShovel = new BasicShovel(yellowDiamondMaterial, "yellowDiamondShovel");
			yellowDiamondSword = new BasicSword(yellowDiamondMaterial, "yellowDiamondSword");

			greenDiamondPickaxe = new BasicPickaxe(greenDiamondMaterial, "greenDiamondPickaxe");
			greenDiamondAxe = new BasicAxe(greenDiamondMaterial, "greenDiamondAxe");
			greenDiamondHoe = new BasicHoe(greenDiamondMaterial, "greenDiamondHoe");
			greenDiamondShovel = new BasicShovel(greenDiamondMaterial, "greenDiamondShovel");
			greenDiamondSword = new BasicSword(greenDiamondMaterial, "greenDiamondSword");
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
