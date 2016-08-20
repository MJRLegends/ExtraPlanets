package com.mjr.extraplanets.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Armor {
	private static ArmorMaterial carbon_ArmorMaterial = EnumHelper.addArmorMaterial("Carbon_Armor", 26, new int[] {3, 8, 6, 3}, 15);
	private static ArmorMaterial palladium_ArmorMaterial = EnumHelper.addArmorMaterial("Palladium_Armor", 26, new int[] {3, 8, 6, 3}, 13);
	private static ArmorMaterial magnesium_ArmorMaterial = EnumHelper.addArmorMaterial("Magnesium_Armor", 30, new int[] {3, 8, 6, 3}, 11);
	private static ArmorMaterial crystal_ArmorMaterial = EnumHelper.addArmorMaterial("Crystal_Armor", 40, new int[] {3, 8, 6, 3}, 10);
	
	private static ArmorMaterial mercury_ArmorMaterial = EnumHelper.addArmorMaterial("Mercury_Armor", 15, new int[] {3, 8, 6, 3}, 13);
	private static ArmorMaterial uranium_ArmorMaterial = EnumHelper.addArmorMaterial("Uranium_Armor", 20, new int[] {3, 8, 6, 3}, 13);
	private static ArmorMaterial zinc_ArmorMaterial = EnumHelper.addArmorMaterial("Zinc_Armor", 45, new int[] {3, 8, 6, 3}, 9);
	private static ArmorMaterial tungsten_ArmorMaterial = EnumHelper.addArmorMaterial("Tungsten_Armor", 50, new int[] {3, 8, 6, 3}, 7);

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
		if (Config.palladiumItems && Config.jupiter) {
			palladiumHelmet = new PalladiumArmor("palladium", palladium_ArmorMaterial, 0).setUnlocalizedName("palladiumHelmet");
			palladiumChest = new PalladiumArmor("palladium", palladium_ArmorMaterial, 1).setUnlocalizedName("palladiumChest");
			palladiumLegings = new PalladiumArmor("palladium", palladium_ArmorMaterial, 2).setUnlocalizedName("palladiumLegings");
			palladiumBoots = new PalladiumArmor("palladium", palladium_ArmorMaterial, 3).setUnlocalizedName("palladiumBoots");
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
		}
		if (Config.zincItems && Config.neptune) {
			zincHelmet = new ZincArmor("zinc", zinc_ArmorMaterial, 0).setUnlocalizedName("zincHelmet");
			zincChest = new ZincArmor("zinc", zinc_ArmorMaterial, 1).setUnlocalizedName("zincChest");
			zincLegings = new ZincArmor("zinc", zinc_ArmorMaterial, 2).setUnlocalizedName("zincLegings");
			zincBoots = new ZincArmor("zinc", zinc_ArmorMaterial, 3).setUnlocalizedName("zincBoots");
		}
		if (Config.tungstenItems && Config.pluto) {
			tungstenHelmet = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 0).setUnlocalizedName("tungstenHelmet");
			tungstenChest = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 1).setUnlocalizedName("tungstenChest");
			tungstenLegings = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 2).setUnlocalizedName("tungstenLegings");
			tungstenBoots = new TungstenArmor("tungsten", tungsten_ArmorMaterial, 3).setUnlocalizedName("tungstenBoots");
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
		if (Config.palladiumItems && Config.jupiter) {
			GameRegistry.registerItem(palladiumHelmet, "palladiumHelmet");
			GameRegistry.registerItem(palladiumChest, "palladiumChest");
			GameRegistry.registerItem(palladiumLegings, "palladiumLegings");
			GameRegistry.registerItem(palladiumBoots, "palladiumBoots");
		}
		if (Config.magnesiumItems && Config.saturn) {
			GameRegistry.registerItem(magnesiumHelmet, "magnesiumHelmet");
			GameRegistry.registerItem(magnesiumChest, "magnesiumChest");
			GameRegistry.registerItem(magnesiumLegings, "magnesiumLegings");
			GameRegistry.registerItem(magnesiumBoots, "magnesiumBoots");
		}
		if (Config.crystalItems && Config.uranus) {
			GameRegistry.registerItem(crystalHelmet, "crystalHelmet");
			GameRegistry.registerItem(crystalChest, "crystalChest");
			GameRegistry.registerItem(crystalLegings, "crystalLegings");
			GameRegistry.registerItem(crystalBoots, "crystalBoots");
		}
		if (Config.zincItems && Config.neptune) {
			GameRegistry.registerItem(zincHelmet, "zincHelmet");
			GameRegistry.registerItem(zincChest, "zincChest");
			GameRegistry.registerItem(zincLegings, "zincLegings");
			GameRegistry.registerItem(zincBoots, "zincBoots");
		}
		if (Config.tungstenItems && Config.pluto) {
			GameRegistry.registerItem(tungstenHelmet, "tungstenHelmet");
			GameRegistry.registerItem(tungstenChest, "tungstenChest");
			GameRegistry.registerItem(tungstenLegings, "tungstenLegings");
			GameRegistry.registerItem(tungstenBoots, "tungstenBoots");
		}
	}
}