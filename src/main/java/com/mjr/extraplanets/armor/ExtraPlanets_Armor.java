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

	private static ArmorMaterial redGem_ArmorMaterial = EnumHelper.addArmorMaterial("Red_Gem_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial whiteGem_ArmorMaterial = EnumHelper.addArmorMaterial("White_Gem_Armor", 40, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial blueGem_ArmorMaterial = EnumHelper.addArmorMaterial("Blue_Gem_Armor", 45, new int[] { 3, 8, 6, 3 }, 7);

	private static ArmorMaterial blueDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Blue_Diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial redDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Red_Diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial purpleDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Purple_Diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial yellowDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Yellow_Diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);
	private static ArmorMaterial greenDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Green_Diamond_Armor", 28, new int[] { 3, 8, 6, 3 }, 7);

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
			mercuryHelmet = new MercuryArmor("mercury", mercury_ArmorMaterial, 0).setUnlocalizedName("mercuryHelmet");
			mercuryChest = new MercuryArmor("mercury", mercury_ArmorMaterial, 1).setUnlocalizedName("mercuryChest");
			mercuryLegings = new MercuryArmor("mercury", mercury_ArmorMaterial, 2).setUnlocalizedName("mercuryLegings");
			mercuryBoots = new MercuryArmor("mercury", mercury_ArmorMaterial, 3).setUnlocalizedName("mercuryBoots");
		}
		if (Config.carbonItems && Config.venus) {
			carbonHelmet = new CarbonArmor("carbon", carbon_ArmorMaterial, 0).setUnlocalizedName("carbonHelmet");
			carbonChest = new CarbonArmor("carbon", carbon_ArmorMaterial, 1).setUnlocalizedName("carbonChest");
			carbonLegings = new CarbonArmor("carbon", carbon_ArmorMaterial, 2).setUnlocalizedName("carbonLegings");
			carbonBoots = new CarbonArmor("carbon", carbon_ArmorMaterial, 3).setUnlocalizedName("carbonBoots");
		}
		if (Config.uraniumItems && Config.ceres) {
			uraniumHelmet = new UraniumArmor("uranium", uranium_ArmorMaterial, 0).setUnlocalizedName("uraniumHelmet");
			uraniumChest = new UraniumArmor("uranium", uranium_ArmorMaterial, 1).setUnlocalizedName("uraniumChest");
			uraniumLegings = new UraniumArmor("uranium", uranium_ArmorMaterial, 2).setUnlocalizedName("uraniumLegings");
			uraniumBoots = new UraniumArmor("uranium", uranium_ArmorMaterial, 3).setUnlocalizedName("uraniumBoots");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				palladiumHelmet = new PalladiumArmor("palladium", palladium_ArmorMaterial, 0).setUnlocalizedName("palladiumHelmet");
				palladiumChest = new PalladiumArmor("palladium", palladium_ArmorMaterial, 1).setUnlocalizedName("palladiumChest");
				palladiumLegings = new PalladiumArmor("palladium", palladium_ArmorMaterial, 2).setUnlocalizedName("palladiumLegings");
				palladiumBoots = new PalladiumArmor("palladium", palladium_ArmorMaterial, 3).setUnlocalizedName("palladiumBoots");
			}
			if (Config.redGemItems) {
				redGemHelmet = new RedGemArmor("redGem", redGem_ArmorMaterial, 0).setUnlocalizedName("redGemHelmet");
				redGemChest = new RedGemArmor("redGem", redGem_ArmorMaterial, 1).setUnlocalizedName("redGemChest");
				redGemLegings = new RedGemArmor("redGem", redGem_ArmorMaterial, 2).setUnlocalizedName("redGemLegings");
				redGemBoots = new RedGemArmor("redGem", redGem_ArmorMaterial, 3).setUnlocalizedName("redGemBoots");
			}
		}
		if (Config.magnesiumItems && Config.saturn) {
			magnesiumHelmet = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 0).setUnlocalizedName("magnesiumHelmet");
			magnesiumChest = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 1).setUnlocalizedName("magnesiumChest");
			magnesiumLegings = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 2).setUnlocalizedName("magnesiumLegings");
			magnesiumBoots = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 3).setUnlocalizedName("magnesiumBoots");
		}
		if (Config.crystalItems && Config.uranus) {
			crystalHelmet = new CrystalArmor("crystal", crystal_ArmorMaterial, 0).setUnlocalizedName("crystalHelmet");
			crystalChest = new CrystalArmor("crystal", crystal_ArmorMaterial, 1).setUnlocalizedName("crystalChest");
			crystalLegings = new CrystalArmor("crystal", crystal_ArmorMaterial, 2).setUnlocalizedName("crystalLegings");
			crystalBoots = new CrystalArmor("crystal", crystal_ArmorMaterial, 3).setUnlocalizedName("crystalBoots");
			if (Config.whiteGemItems) {
				whiteGemHelmet = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, 0).setUnlocalizedName("whiteGemHelmet");
				whiteGemChest = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, 1).setUnlocalizedName("whiteGemChest");
				whiteGemLegings = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, 2).setUnlocalizedName("whiteGemLegings");
				whiteGemBoots = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, 3).setUnlocalizedName("whiteGemBoots");
			}
		}
		if (Config.neptune) {
			if (Config.zincItems) {
				zincHelmet = new ZincArmor("zinc", zinc_ArmorMaterial, 0).setUnlocalizedName("zincHelmet");
				zincChest = new ZincArmor("zinc", zinc_ArmorMaterial, 1).setUnlocalizedName("zincChest");
				zincLegings = new ZincArmor("zinc", zinc_ArmorMaterial, 2).setUnlocalizedName("zincLegings");
				zincBoots = new ZincArmor("zinc", zinc_ArmorMaterial, 3).setUnlocalizedName("zincBoots");
			}
			if (Config.blueGemItems) {
				blueGemHelmet = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, 0).setUnlocalizedName("blueGemHelmet");
				blueGemChest = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, 1).setUnlocalizedName("blueGemChest");
				blueGemLegings = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, 2).setUnlocalizedName("blueGemLegings");
				blueGemBoots = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, 3).setUnlocalizedName("blueGemBoots");
			}
		}
		if (Config.tungstenItems && Config.pluto) {
			tungstenHelmet = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 0).setUnlocalizedName("tungstenHelmet");
			tungstenChest = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 1).setUnlocalizedName("tungstenChest");
			tungstenLegings = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 2).setUnlocalizedName("tungstenLegings");
			tungstenBoots = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 3).setUnlocalizedName("tungstenBoots");
		}
		if (Config.kepler22b && Config.kepler22bItems && Config.keplerSolarSystems) {
			blueDiamondHelmet = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, 0).setUnlocalizedName("blueDiamondHelmet");
			blueDiamondChest = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, 1).setUnlocalizedName("blueDiamondChest");
			blueDiamondLegings = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, 2).setUnlocalizedName("blueDiamondLegings");
			blueDiamondBoots = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, 3).setUnlocalizedName("blueDiamondBoots");

			redDiamondHelmet = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, 0).setUnlocalizedName("redDiamondHelmet");
			redDiamondChest = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, 1).setUnlocalizedName("redDiamondChest");
			redDiamondLegings = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, 2).setUnlocalizedName("redDiamondLegings");
			redDiamondBoots = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, 3).setUnlocalizedName("redDiamondBoots");

			purpleDiamondHelmet = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, 0).setUnlocalizedName("purpleDiamondHelmet");
			purpleDiamondChest = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, 1).setUnlocalizedName("purpleDiamondChest");
			purpleDiamondLegings = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, 2).setUnlocalizedName("purpleDiamondLegings");
			purpleDiamondBoots = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, 3).setUnlocalizedName("purpleDiamondBoots");

			yellowDiamondHelmet = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, 0).setUnlocalizedName("yellowDiamondHelmet");
			yellowDiamondChest = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, 1).setUnlocalizedName("yellowDiamondChest");
			yellowDiamondLegings = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, 2).setUnlocalizedName("yellowDiamondLegings");
			yellowDiamondBoots = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, 3).setUnlocalizedName("yellowDiamondBoots");

			greenDiamondHelmet = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, 0).setUnlocalizedName("greenDiamondHelmet");
			greenDiamondChest = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, 1).setUnlocalizedName("greenDiamondChest");
			greenDiamondLegings = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, 2).setUnlocalizedName("greenDiamondLegings");
			greenDiamondBoots = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, 3).setUnlocalizedName("greenDiamondBoots");
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