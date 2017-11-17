package com.mjr.extraplanets.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Armor {
	private static ArmorMaterial carbon_ArmorMaterial = EnumHelper.addArmorMaterial("Carbon_Armor", 26, new int[] { 3, 8, 6, 3 }, 15);
	private static ArmorMaterial palladium_ArmorMaterial = EnumHelper.addArmorMaterial("Palladium_Armor", 26, new int[] { 3, 8, 6, 3 }, 13);
	private static ArmorMaterial magnesium_ArmorMaterial = EnumHelper.addArmorMaterial("Magnesium_Armor", 30, new int[] { 3, 8, 6, 3 }, 11);
	private static ArmorMaterial crystal_ArmorMaterial = EnumHelper.addArmorMaterial("Crystal_Armor", 40, new int[] { 3, 8, 6, 3 }, 10);

	private static ArmorMaterial mercury_ArmorMaterial = EnumHelper.addArmorMaterial("Mercury_Armor", 15, new int[] { 3, 8, 6, 3 }, 13);
	private static ArmorMaterial uranium_ArmorMaterial = EnumHelper.addArmorMaterial("Uranium_Armor", 20, new int[] { 3, 8, 6, 3 }, 13);
	private static ArmorMaterial zinc_ArmorMaterial = EnumHelper.addArmorMaterial("Zinc_Armor", 45, new int[] { 3, 8, 6, 3 }, 9);
	private static ArmorMaterial tungsten_ArmorMaterial = EnumHelper.addArmorMaterial("Tungsten_Armor", 50, new int[] { 3, 8, 6, 3 }, 7);

	private static ArmorMaterial red_gem_ArmorMaterial = EnumHelper.addArmorMaterial("Red__gem_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial white_gem_ArmorMaterial = EnumHelper.addArmorMaterial("White__gem_Armor", 40, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial blue_gem_ArmorMaterial = EnumHelper.addArmorMaterial("Blue__gem_Armor", 45, new int[] { 3, 8, 6, 3 }, 7);

	private static ArmorMaterial blue_diamond_ArmorMaterial = EnumHelper.addArmorMaterial("Blue__diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial red_diamond_ArmorMaterial = EnumHelper.addArmorMaterial("Red__diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial purple_diamond_ArmorMaterial = EnumHelper.addArmorMaterial("Purple__diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial yellow_diamond_ArmorMaterial = EnumHelper.addArmorMaterial("Yellow__diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial green_diamond_ArmorMaterial = EnumHelper.addArmorMaterial("Green__diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);

	public static Item carbonHelmet;
	public static Item carbonChest;
	public static Item carbonLegings;
	public static Item carbonBoots;

	public static Item palladiumHelmet;
	public static Item palladiumChest;
	public static Item palladiumLegings;
	public static Item palladiumBoots;

	public static Item magnesiumHelmet;
	public static Item magnesiumChest;
	public static Item magnesiumLegings;
	public static Item magnesiumBoots;

	public static Item crystalHelmet;
	public static Item crystalChest;
	public static Item crystalLegings;
	public static Item crystalBoots;

	public static Item zincHelmet;
	public static Item zincChest;
	public static Item zincLegings;
	public static Item zincBoots;

	public static Item mercuryHelmet;
	public static Item mercuryChest;
	public static Item mercuryLegings;
	public static Item mercuryBoots;

	public static Item uraniumHelmet;
	public static Item uraniumChest;
	public static Item uraniumLegings;
	public static Item uraniumBoots;

	public static Item tungstenHelmet;
	public static Item tungstenChest;
	public static Item tungstenLegings;
	public static Item tungstenBoots;

	public static Item redGemHelmet;
	public static Item redGemChest;
	public static Item redGemLegings;
	public static Item redGemBoots;

	public static Item whiteGemHelmet;
	public static Item whiteGemChest;
	public static Item whiteGemLegings;
	public static Item whiteGemBoots;

	public static Item blueGemHelmet;
	public static Item blueGemChest;
	public static Item blueGemLegings;
	public static Item blueGemBoots;

	public static Item blueDiamondHelmet;
	public static Item blueDiamondChest;
	public static Item blueDiamondLegings;
	public static Item blueDiamondBoots;

	public static Item redDiamondHelmet;
	public static Item redDiamondChest;
	public static Item redDiamondLegings;
	public static Item redDiamondBoots;

	public static Item purpleDiamondHelmet;
	public static Item purpleDiamondChest;
	public static Item purpleDiamondLegings;
	public static Item purpleDiamondBoots;

	public static Item yellowDiamondHelmet;
	public static Item yellowDiamondChest;
	public static Item yellowDiamondLegings;
	public static Item yellowDiamondBoots;

	public static Item greenDiamondHelmet;
	public static Item greenDiamondChest;
	public static Item greenDiamondLegings;
	public static Item greenDiamondBoots;

	public static void init() {
		initializeArmor();
		registerArmor();
	}

	private static void initializeArmor() {
		if (Config.mercuryItems && Config.mercury) {
			mercuryHelmet = new MercuryArmor("mercury", mercury_ArmorMaterial, 0).setUnlocalizedName("mercury_helmet");
			mercuryChest = new MercuryArmor("mercury", mercury_ArmorMaterial, 1).setUnlocalizedName("mercury_chest");
			mercuryLegings = new MercuryArmor("mercury", mercury_ArmorMaterial, 2).setUnlocalizedName("mercury_legings");
			mercuryBoots = new MercuryArmor("mercury", mercury_ArmorMaterial, 3).setUnlocalizedName("mercury_boots");
		}
		if (Config.carbonItems && Config.venus) {
			carbonHelmet = new CarbonArmor("carbon", carbon_ArmorMaterial, 0).setUnlocalizedName("carbon_helmet");
			carbonChest = new CarbonArmor("carbon", carbon_ArmorMaterial, 1).setUnlocalizedName("carbon_chest");
			carbonLegings = new CarbonArmor("carbon", carbon_ArmorMaterial, 2).setUnlocalizedName("carbon_legings");
			carbonBoots = new CarbonArmor("carbon", carbon_ArmorMaterial, 3).setUnlocalizedName("carbon_boots");
		}
		if (Config.uraniumItems && Config.ceres) {
			uraniumHelmet = new UraniumArmor("uranium", uranium_ArmorMaterial, 0).setUnlocalizedName("uranium_helmet");
			uraniumChest = new UraniumArmor("uranium", uranium_ArmorMaterial, 1).setUnlocalizedName("uranium_chest");
			uraniumLegings = new UraniumArmor("uranium", uranium_ArmorMaterial, 2).setUnlocalizedName("uranium_legings");
			uraniumBoots = new UraniumArmor("uranium", uranium_ArmorMaterial, 3).setUnlocalizedName("uranium_boots");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				palladiumHelmet = new PalladiumArmor("palladium", palladium_ArmorMaterial, 0).setUnlocalizedName("palladium_helmet");
				palladiumChest = new PalladiumArmor("palladium", palladium_ArmorMaterial, 1).setUnlocalizedName("palladium_chest");
				palladiumLegings = new PalladiumArmor("palladium", palladium_ArmorMaterial, 2).setUnlocalizedName("palladium_legings");
				palladiumBoots = new PalladiumArmor("palladium", palladium_ArmorMaterial, 3).setUnlocalizedName("palladium_boots");
			}
			if (Config.redGemItems) {
				redGemHelmet = new RedGemArmor("red_gem",red_gem_ArmorMaterial, 0).setUnlocalizedName("red_gem_helmet");
				redGemChest = new RedGemArmor("red_gem",red_gem_ArmorMaterial, 1).setUnlocalizedName("red_gem_chest");
				redGemLegings = new RedGemArmor("red_gem",red_gem_ArmorMaterial, 2).setUnlocalizedName("red_gem_legings");
				redGemBoots = new RedGemArmor("red_gem",red_gem_ArmorMaterial, 3).setUnlocalizedName("red_gem_boots");
			}
		}
		if (Config.magnesiumItems && Config.saturn) {
			magnesiumHelmet = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 0).setUnlocalizedName("magnesium_helmet");
			magnesiumChest = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 1).setUnlocalizedName("magnesium_chest");
			magnesiumLegings = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 2).setUnlocalizedName("magnesium_legings");
			magnesiumBoots = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 3).setUnlocalizedName("magnesium_boots");
		}
		if (Config.crystalItems && Config.uranus) {
			crystalHelmet = new CrystalArmor("crystal", crystal_ArmorMaterial, 0).setUnlocalizedName("crystal_helmet");
			crystalChest = new CrystalArmor("crystal", crystal_ArmorMaterial, 1).setUnlocalizedName("crystal_chest");
			crystalLegings = new CrystalArmor("crystal", crystal_ArmorMaterial, 2).setUnlocalizedName("crystal_legings");
			crystalBoots = new CrystalArmor("crystal", crystal_ArmorMaterial, 3).setUnlocalizedName("crystal_boots");
			if (Config.whiteGemItems) {
				whiteGemHelmet = new WhiteGemArmor("white_gem",white_gem_ArmorMaterial, 0).setUnlocalizedName("white_gem_helmet");
				whiteGemChest = new WhiteGemArmor("white_gem",white_gem_ArmorMaterial, 1).setUnlocalizedName("white_gem_chest");
				whiteGemLegings = new WhiteGemArmor("white_gem",white_gem_ArmorMaterial, 2).setUnlocalizedName("white_gem_legings");
				whiteGemBoots = new WhiteGemArmor("white_gem",white_gem_ArmorMaterial, 3).setUnlocalizedName("white_gem_boots");
			}
		}
		if (Config.neptune) {
			if (Config.zincItems) {
				zincHelmet = new ZincArmor("zinc", zinc_ArmorMaterial, 0).setUnlocalizedName("zinc_helmet");
				zincChest = new ZincArmor("zinc", zinc_ArmorMaterial, 1).setUnlocalizedName("zinc_chest");
				zincLegings = new ZincArmor("zinc", zinc_ArmorMaterial, 2).setUnlocalizedName("zinc_legings");
				zincBoots = new ZincArmor("zinc", zinc_ArmorMaterial, 3).setUnlocalizedName("zinc_boots");
			}
			if (Config.blueGemItems) {
				blueGemHelmet = new BlueGemArmor("blue_gem",blue_gem_ArmorMaterial, 0).setUnlocalizedName("blue_gem_helmet");
				blueGemChest = new BlueGemArmor("blue_gem",blue_gem_ArmorMaterial, 1).setUnlocalizedName("blue_gem_chest");
				blueGemLegings = new BlueGemArmor("blue_gem",blue_gem_ArmorMaterial, 2).setUnlocalizedName("blue_gem_legings");
				blueGemBoots = new BlueGemArmor("blue_gem",blue_gem_ArmorMaterial, 3).setUnlocalizedName("blue_gem_boots");
			}
		}
		if (Config.tungstenItems && Config.pluto) {
			tungstenHelmet = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 0).setUnlocalizedName("tungsten_helmet");
			tungstenChest = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 1).setUnlocalizedName("tungsten_chest");
			tungstenLegings = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 2).setUnlocalizedName("tungsten_legings");
			tungstenBoots = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 3).setUnlocalizedName("tungsten_boots");
		}
		if (Config.kepler22b && Config.kepler22bItems && Config.keplerSolarSystems) {
			blueDiamondHelmet = new BlueDiamondArmor("blue_diamond",blue_diamond_ArmorMaterial, 0).setUnlocalizedName("blue_diamond_helmet");
			blueDiamondChest = new BlueDiamondArmor("blue_diamond",blue_diamond_ArmorMaterial, 1).setUnlocalizedName("blue_diamond_chest");
			blueDiamondLegings = new BlueDiamondArmor("blue_diamond",blue_diamond_ArmorMaterial, 2).setUnlocalizedName("blue_diamond_legings");
			blueDiamondBoots = new BlueDiamondArmor("blue_diamond",blue_diamond_ArmorMaterial, 3).setUnlocalizedName("blue_diamond_boots");

			redDiamondHelmet = new RedDiamondArmor("red_diamond",red_diamond_ArmorMaterial, 0).setUnlocalizedName("red_diamond_helmet");
			redDiamondChest = new RedDiamondArmor("red_diamond",red_diamond_ArmorMaterial, 1).setUnlocalizedName("red_diamond_chest");
			redDiamondLegings = new RedDiamondArmor("red_diamond",red_diamond_ArmorMaterial, 2).setUnlocalizedName("red_diamond_legings");
			redDiamondBoots = new RedDiamondArmor("red_diamond",red_diamond_ArmorMaterial, 3).setUnlocalizedName("red_diamond_boots");

			purpleDiamondHelmet = new PurpleDiamondArmor("purple_diamond",purple_diamond_ArmorMaterial, 0).setUnlocalizedName("purple_diamond_helmet");
			purpleDiamondChest = new PurpleDiamondArmor("purple_diamond",purple_diamond_ArmorMaterial, 1).setUnlocalizedName("purple_diamond_chest");
			purpleDiamondLegings = new PurpleDiamondArmor("purple_diamond",purple_diamond_ArmorMaterial, 2).setUnlocalizedName("purple_diamond_legings");
			purpleDiamondBoots = new PurpleDiamondArmor("purple_diamond",purple_diamond_ArmorMaterial, 3).setUnlocalizedName("purple_diamond_boots");

			yellowDiamondHelmet = new YellowDiamondArmor("yellow_diamond",yellow_diamond_ArmorMaterial, 0).setUnlocalizedName("yellow_diamond_helmet");
			yellowDiamondChest = new YellowDiamondArmor("yellow_diamond",yellow_diamond_ArmorMaterial, 1).setUnlocalizedName("yellow_diamond_chest");
			yellowDiamondLegings = new YellowDiamondArmor("yellow_diamond",yellow_diamond_ArmorMaterial, 2).setUnlocalizedName("yellow_diamond_legings");
			yellowDiamondBoots = new YellowDiamondArmor("yellow_diamond",yellow_diamond_ArmorMaterial, 3).setUnlocalizedName("yellow_diamond_boots");

			greenDiamondHelmet = new GreenDiamondArmor("green_diamond",green_diamond_ArmorMaterial, 0).setUnlocalizedName("green_diamond_helmet");
			greenDiamondChest = new GreenDiamondArmor("green_diamond",green_diamond_ArmorMaterial, 1).setUnlocalizedName("green_diamond_chest");
			greenDiamondLegings = new GreenDiamondArmor("green_diamond",green_diamond_ArmorMaterial, 2).setUnlocalizedName("green_diamond_legings");
			greenDiamondBoots = new GreenDiamondArmor("green_diamond",green_diamond_ArmorMaterial, 3).setUnlocalizedName("green_diamond_boots");
		}
	}

	private static void registerArmor() {
		if (Config.mercuryItems && Config.mercury) {
			GameRegistry.registerItem(mercuryHelmet, "mercuryHelmet");
			GameRegistry.registerItem(mercuryChest, "mercuryChest");
			GameRegistry.registerItem(mercuryLegings, "mercuryLegings");
			GameRegistry.registerItem(mercuryBoots, "mercuryBoots");
		}
		if (Config.carbonItems && Config.venus) {
			GameRegistry.registerItem(carbonHelmet, "carbonHelmet");
			GameRegistry.registerItem(carbonChest, "carbonChest");
			GameRegistry.registerItem(carbonLegings, "carbonLegings");
			GameRegistry.registerItem(carbonBoots, "carbonBoots");
		}
		if (Config.uraniumItems && Config.ceres) {
			GameRegistry.registerItem(uraniumHelmet, "uraniumHelmet");
			GameRegistry.registerItem(uraniumChest, "uraniumChest");
			GameRegistry.registerItem(uraniumLegings, "uraniumLegings");
			GameRegistry.registerItem(uraniumBoots, "uraniumBoots");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				GameRegistry.registerItem(palladiumHelmet, "palladiumHelmet");
				GameRegistry.registerItem(palladiumChest, "palladiumChest");
				GameRegistry.registerItem(palladiumLegings, "palladiumLegings");
				GameRegistry.registerItem(palladiumBoots, "palladiumBoots");
			}
			if (Config.redGemItems) {
				GameRegistry.registerItem(redGemHelmet, "redGemHelmet");
				GameRegistry.registerItem(redGemChest, "redGemChest");
				GameRegistry.registerItem(redGemLegings, "redGemLegings");
				GameRegistry.registerItem(redGemBoots, "redGemBoots");
			}
		}
		if (Config.magnesiumItems && Config.saturn) {
			GameRegistry.registerItem(magnesiumHelmet, "magnesiumHelmet");
			GameRegistry.registerItem(magnesiumChest, "magnesiumChest");
			GameRegistry.registerItem(magnesiumLegings, "magnesiumLegings");
			GameRegistry.registerItem(magnesiumBoots, "magnesiumBoots");
		}
		if (Config.uranus) {
			if (Config.crystalItems) {
				GameRegistry.registerItem(crystalHelmet, "crystalHelmet");
				GameRegistry.registerItem(crystalChest, "crystalChest");
				GameRegistry.registerItem(crystalLegings, "crystalLegings");
				GameRegistry.registerItem(crystalBoots, "crystalBoots");
			}
			if (Config.whiteGemItems) {
				GameRegistry.registerItem(whiteGemHelmet, "whiteGemHelmet");
				GameRegistry.registerItem(whiteGemChest, "whiteGemChest");
				GameRegistry.registerItem(whiteGemLegings, "whiteGemLegings");
				GameRegistry.registerItem(whiteGemBoots, "whiteGemBoots");
			}
		}
		if (Config.neptune) {
			if (Config.zincItems) {
				GameRegistry.registerItem(zincHelmet, "zincHelmet");
				GameRegistry.registerItem(zincChest, "zincChest");
				GameRegistry.registerItem(zincLegings, "zincLegings");
				GameRegistry.registerItem(zincBoots, "zincBoots");
			}
			if (Config.blueGemItems) {
				GameRegistry.registerItem(blueGemHelmet, "blueGemHelmet");
				GameRegistry.registerItem(blueGemChest, "blueGemChest");
				GameRegistry.registerItem(blueGemLegings, "blueGemLegings");
				GameRegistry.registerItem(blueGemBoots, "blueGemBoots");
			}
		}
		if (Config.tungstenItems && Config.pluto) {
			GameRegistry.registerItem(tungstenHelmet, "tungstenHelmet");
			GameRegistry.registerItem(tungstenChest, "tungstenChest");
			GameRegistry.registerItem(tungstenLegings, "tungstenLegings");
			GameRegistry.registerItem(tungstenBoots, "tungstenBoots");
		}
		if (Config.kepler22b && Config.kepler22bItems && Config.keplerSolarSystems) {
			GameRegistry.registerItem(blueDiamondHelmet, "blueDiamondHelmet");
			GameRegistry.registerItem(blueDiamondChest, "blueDiamondChest");
			GameRegistry.registerItem(blueDiamondLegings, "blueDiamondLegings");
			GameRegistry.registerItem(blueDiamondBoots, "blueDiamondBoots");

			GameRegistry.registerItem(redDiamondHelmet, "redDiamondHelmet");
			GameRegistry.registerItem(redDiamondChest, "redDiamondChest");
			GameRegistry.registerItem(redDiamondLegings, "redDiamondLegings");
			GameRegistry.registerItem(redDiamondBoots, "redDiamondBoots");

			GameRegistry.registerItem(purpleDiamondHelmet, "purpleDiamondHelmet");
			GameRegistry.registerItem(purpleDiamondChest, "purpleDiamondChest");
			GameRegistry.registerItem(purpleDiamondLegings, "purpleDiamondLegings");
			GameRegistry.registerItem(purpleDiamondBoots, "purpleDiamondBoots");

			GameRegistry.registerItem(yellowDiamondHelmet, "yellowDiamondHelmet");
			GameRegistry.registerItem(yellowDiamondChest, "yellowDiamondChest");
			GameRegistry.registerItem(yellowDiamondLegings, "yellowDiamondLegings");
			GameRegistry.registerItem(yellowDiamondBoots, "yellowDiamondBoots");

			GameRegistry.registerItem(greenDiamondHelmet, "greenDiamondHelmet");
			GameRegistry.registerItem(greenDiamondChest, "greenDiamondChest");
			GameRegistry.registerItem(greenDiamondLegings, "greenDiamondLegings");
			GameRegistry.registerItem(greenDiamondBoots, "greenDiamondBoots");
		}
	}
}