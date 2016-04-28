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
	private static ToolMaterial tungstenMaterial = EnumHelper.addToolMaterial("Tungsten Material", 7, 120, 10.0F, 12.0F, 30);
	private static ToolMaterial redGemMaterial = EnumHelper.addToolMaterial("Red Gem Material", 4, 60, 6.0F, 8.0F, 30);
	private static ToolMaterial blueGemMaterial = EnumHelper.addToolMaterial("Blue Gem Material", 5, 80, 8.0F, 10.0F, 30);
	private static ToolMaterial whiteGemMaterial = EnumHelper.addToolMaterial("White Gem Material", 6, 100, 10.0F, 12.0F, 30);

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
		
		tungstenPickaxe = new BasicPickaxe(tungstenMaterial, "tungstenPickaxe");
		tungstenAxe = new BasicAxe(tungstenMaterial, "tungstenAxe");
		tungstenHoe = new BasicHoe(tungstenMaterial, "tungstenHoe");
		tungstenShovel = new BasicShovel(tungstenMaterial, "tungstenShovel");
		tungstenSword = new BasicSword(tungstenMaterial, "tungstenSword");
		
		redGemPickaxe = new BasicPickaxe(redGemMaterial, "redGemPickaxe");
		redGemAxe = new BasicAxe(redGemMaterial, "redGemAxe");
		redGemHoe = new BasicHoe(redGemMaterial, "redGemHoe");
		redGemShovel = new BasicShovel(redGemMaterial, "redGemShovel");
		redGemSword = new BasicSword(redGemMaterial, "redGemSword");
		
		blueGemPickaxe = new BasicPickaxe(blueGemMaterial, "blueGemPickaxe");
		blueGemAxe = new BasicAxe(blueGemMaterial, "blueGemAxe");
		blueGemHoe = new BasicHoe(blueGemMaterial, "blueGemHoe");
		blueGemShovel = new BasicShovel(blueGemMaterial, "blueGemShovel");
		blueGemSword = new BasicSword(blueGemMaterial, "blueGemSword");
		
		whiteGemPickaxe = new BasicPickaxe(whiteGemMaterial, "whiteGemPickaxe");
		whiteGemAxe = new BasicAxe(whiteGemMaterial, "whiteGemAxe");
		whiteGemHoe = new BasicHoe(whiteGemMaterial, "whiteGemHoe");
		whiteGemShovel = new BasicShovel(whiteGemMaterial, "whiteGemShovel");
		whiteGemSword = new BasicSword(whiteGemMaterial, "whiteGemSword");
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
		if (Config.tungstenItems) {
			GameRegistry.registerItem(tungstenPickaxe, "tungstenPickaxe");
			GameRegistry.registerItem(tungstenAxe, "tungstenAxe");
			GameRegistry.registerItem(tungstenHoe, "tungstenHoe");
			GameRegistry.registerItem(tungstenShovel, "tungstenShovel");
			GameRegistry.registerItem(tungstenSword, "tungstenSword");
		}
		if (Config.redGemItems) {
			GameRegistry.registerItem(redGemPickaxe, "redGemPickaxe");
			GameRegistry.registerItem(redGemAxe, "redGemAxe");
			GameRegistry.registerItem(redGemHoe, "redGemHoe");
			GameRegistry.registerItem(redGemShovel, "redGemShovel");
			GameRegistry.registerItem(redGemSword, "redGemSword");
		}
		if (Config.blueGemItems) {
			GameRegistry.registerItem(blueGemPickaxe, "blueGemPickaxe");
			GameRegistry.registerItem(blueGemAxe, "blueGemAxe");
			GameRegistry.registerItem(blueGemHoe, "blueGemHoe");
			GameRegistry.registerItem(blueGemShovel, "blueGemShovel");
			GameRegistry.registerItem(blueGemSword, "blueGemSword");
		}
		if (Config.whiteGemItems) {
			GameRegistry.registerItem(whiteGemPickaxe, "whiteGemPickaxe");
			GameRegistry.registerItem(whiteGemAxe, "whiteGemAxe");
			GameRegistry.registerItem(whiteGemHoe, "whiteGemHoe");
			GameRegistry.registerItem(whiteGemShovel, "whiteGemShovel");
			GameRegistry.registerItem(whiteGemSword, "whiteGemSword");
		}
	}
}
