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
	private static ToolMaterial crystalMaterial = EnumHelper.addToolMaterial("Crystal Material", 6, 100, 10.0F, 12.0F, 30);

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

	public static void init() {
		initializeTools();
		registerTools();
	}

	private static void initializeTools() {
		carbonPickaxe = new BasicPickaxe(carbonMaterial, "carbonPickaxe");
		carbonAxe = new BasicAxe(carbonMaterial, "carbonAxe");
		carbonHoe = new BasicHoe(carbonMaterial, "carbonHoe");
		carbonShovel = new BasicShovel(carbonMaterial, "carbonShovel");
		carbonSword = new BasicSword(carbonMaterial, "carbonSword");

		palladiumPickaxe = new BasicPickaxe(palladiumMaterial, "palladiumPickaxe");
		palladiumAxe = new BasicAxe(palladiumMaterial, "palladiumAxe");
		palladiumHoe = new BasicHoe(palladiumMaterial, "palladiumHoe");
		palladiumShovel = new BasicShovel(palladiumMaterial, "palladiumShovel");
		palladiumSword = new BasicSword(palladiumMaterial, "palladiumSword");

		magnesiumPickaxe = new BasicPickaxe(magnesiumMaterial, "magnesiumPickaxe");
		magnesiumAxe = new BasicAxe(magnesiumMaterial, "magnesiumAxe");
		magnesiumHoe = new BasicHoe(magnesiumMaterial, "magnesiumHoe");
		magnesiumShovel = new BasicShovel(magnesiumMaterial, "magnesiumShovel");
		magnesiumSword = new BasicSword(magnesiumMaterial, "magnesiumSword");

		crystalPickaxe = new BasicPickaxe(crystalMaterial, "crystalPickaxe");
		crystalAxe = new BasicAxe(crystalMaterial, "crystalAxe");
		crystalHoe = new BasicHoe(crystalMaterial, "crystalHoe");
		crystalShovel = new BasicShovel(crystalMaterial, "crystalShovel");
		crystalSword = new BasicSword(crystalMaterial, "crystalSword");
	}

	private static void registerTools() {
		if (Config.carbonItems) {
			GameRegistry.registerItem(carbonPickaxe, "carbonPickaxe");
			GameRegistry.registerItem(carbonAxe, "carbonAxe");
			GameRegistry.registerItem(carbonHoe, "carbonHoe");
			GameRegistry.registerItem(carbonShovel, "carbonShovel");
			GameRegistry.registerItem(carbonSword, "carbonSword");
		}
		if (Config.palladiumItems) {
			GameRegistry.registerItem(palladiumPickaxe, "palladiumPickaxe");
			GameRegistry.registerItem(palladiumAxe, "palladiumAxe");
			GameRegistry.registerItem(palladiumHoe, "palladiumHoe");
			GameRegistry.registerItem(palladiumShovel, "palladiumShovel");
			GameRegistry.registerItem(palladiumSword, "palladiumSword");
		}
		if (Config.magnesiumItems) {
			GameRegistry.registerItem(magnesiumPickaxe, "magnesiumPickaxe");
			GameRegistry.registerItem(magnesiumAxe, "magnesiumAxe");
			GameRegistry.registerItem(magnesiumHoe, "magnesiumHoe");
			GameRegistry.registerItem(magnesiumShovel, "magnesiumShovel");
			GameRegistry.registerItem(magnesiumSword, "magnesiumSword");
		}
		if (Config.crystalItems) {
			GameRegistry.registerItem(crystalPickaxe, "crystalPickaxe");
			GameRegistry.registerItem(crystalAxe, "crystalAxe");
			GameRegistry.registerItem(crystalHoe, "crystalHoe");
			GameRegistry.registerItem(crystalShovel, "crystalShovel");
			GameRegistry.registerItem(crystalSword, "crystalSword");
		}
	}
}
