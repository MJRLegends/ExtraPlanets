package com.mjr.extraplanets.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanetsArmor {
	private static ArmorMaterial carbon_ArmorMaterial = EnumHelper.addArmorMaterial("Carbon_Armor", 26, new int[] { 6, 11, 7, 6 }, 12);
	private static ArmorMaterial palladium_ArmorMaterial = EnumHelper
			.addArmorMaterial("Palladium_Armor", 26, new int[] { 7, 12, 7, 3 }, 12);
	private static ArmorMaterial magnesium_ArmorMaterial = EnumHelper
			.addArmorMaterial("Magnesium_Armor", 30, new int[] { 8, 13, 7, 3 }, 12);
	private static ArmorMaterial crystal_ArmorMaterial = EnumHelper.addArmorMaterial("Crystal_Armor", 40, new int[] { 9, 14, 7, 9 }, 15);

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

	public static void init() {
		initializeArmor();
		registerArmor();
	}

	private static void initializeArmor() {
		carbonHelmet = new CarbonArmor("carbon", carbon_ArmorMaterial, 0).setUnlocalizedName("carbonHelmet");
		carbonChest = new CarbonArmor("carbon", carbon_ArmorMaterial, 1).setUnlocalizedName("carbonChest");
		carbonLegings = new CarbonArmor("carbon", carbon_ArmorMaterial, 2).setUnlocalizedName("carbonLegings");
		carbonBoots = new CarbonArmor("carbon", carbon_ArmorMaterial, 3).setUnlocalizedName("carbonBoots");

		palladiumHelmet = new PalladiumArmor("palladium", palladium_ArmorMaterial, 0).setUnlocalizedName("palladiumHelmet");
		palladiumChest = new PalladiumArmor("palladium", palladium_ArmorMaterial, 1).setUnlocalizedName("palladiumChest");
		palladiumLegings = new PalladiumArmor("palladium", palladium_ArmorMaterial, 2).setUnlocalizedName("palladiumLegings");
		palladiumBoots = new PalladiumArmor("palladium", palladium_ArmorMaterial, 3).setUnlocalizedName("palladiumBoots");

		magnesiumHelmet = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 0).setUnlocalizedName("magnesiumHelmet");
		magnesiumChest = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 1).setUnlocalizedName("magnesiumChest");
		magnesiumLegings = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 2).setUnlocalizedName("magnesiumLegings");
		magnesiumBoots = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, 3).setUnlocalizedName("magnesiumBoots");

		crystalHelmet = new CrystalArmor("crystal", crystal_ArmorMaterial, 0).setUnlocalizedName("crystalHelmet");
		crystalChest = new CrystalArmor("crystal", crystal_ArmorMaterial, 1).setUnlocalizedName("crystalChest");
		crystalLegings = new CrystalArmor("crystal", crystal_ArmorMaterial, 2).setUnlocalizedName("crystalLegings");
		crystalBoots = new CrystalArmor("crystal", crystal_ArmorMaterial, 3).setUnlocalizedName("crystalBoots");
	}

	private static void registerArmor() {
		if (Config.carbonItems) {
			GameRegistry.registerItem(carbonHelmet, "carbonHelmet");
			GameRegistry.registerItem(carbonChest, "carbonChest");
			GameRegistry.registerItem(carbonLegings, "carbonLegings");
			GameRegistry.registerItem(carbonBoots, "carbonBoots");
		}
		if (Config.palladiumItems) {
			GameRegistry.registerItem(palladiumHelmet, "palladiumHelmet");
			GameRegistry.registerItem(palladiumChest, "palladiumChest");
			GameRegistry.registerItem(palladiumLegings, "palladiumLegings");
			GameRegistry.registerItem(palladiumBoots, "palladiumBoots");
		}
		if (Config.magnesiumItems) {
			GameRegistry.registerItem(magnesiumHelmet, "magnesiumHelmet");
			GameRegistry.registerItem(magnesiumChest, "magnesiumChest");
			GameRegistry.registerItem(magnesiumLegings, "magnesiumLegings");
			GameRegistry.registerItem(magnesiumBoots, "magnesiumBoots");
		}
		if (Config.crystalItems) {
			GameRegistry.registerItem(crystalHelmet, "crystalHelmet");
			GameRegistry.registerItem(crystalChest, "crystalChest");
			GameRegistry.registerItem(crystalLegings, "crystalLegings");
			GameRegistry.registerItem(crystalBoots, "crystalBoots");
		}
	}
}