package com.mjr.extraplanets.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.mjrlegendslib.item.BasicAxe;
import com.mjr.mjrlegendslib.item.BasicHoe;
import com.mjr.mjrlegendslib.item.BasicPickaxe;
import com.mjr.mjrlegendslib.item.BasicShovel;
import com.mjr.mjrlegendslib.item.BasicSword;

public class ExtraPlanets_Tools {
	private static ToolMaterial CARBON_MATERIAL = EnumHelper.addToolMaterial("Carbon Material", 3, 40, 4.0F, 6.0F, 30);
	private static ToolMaterial PALLADIUM_MATERIAL = EnumHelper.addToolMaterial("Palladium Material", 4, 60, 6.0F, 8.0F, 30);
	private static ToolMaterial MAGNESIUM_MATERIAL = EnumHelper.addToolMaterial("Magnesium Material", 5, 80, 8.0F, 10.0F, 30);
	private static ToolMaterial CRYSTAL_MATERIAL = EnumHelper.addToolMaterial("Crystal Material", 6, 120, 10.0F, 12.0F, 30);
	private static ToolMaterial TUNGSTEN_MATERIAL = EnumHelper.addToolMaterial("Tungsten Material", 7, 120, 10.0F, 12.0F, 30);

	private static ToolMaterial ZINC_MATERIAL = EnumHelper.addToolMaterial("Zinc Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial MERCURY_MATERIAL = EnumHelper.addToolMaterial("Mercury Material", 6, 160, 10.0F, 12.0F, 30);
	private static ToolMaterial URANIUM_MATERIAL = EnumHelper.addToolMaterial("Uranium Material", 6, 160, 10.0F, 12.0F, 30);

	private static ToolMaterial RED_GEM_MATERIAL = EnumHelper.addToolMaterial("Red Gem Material", 4, 80, 6.0F, 8.0F, 30);
	private static ToolMaterial BLUE_GEM_MATERIAL = EnumHelper.addToolMaterial("Blue Gem Material", 5, 100, 8.0F, 10.0F, 30);
	private static ToolMaterial WHITE_GEM_MATERIAL = EnumHelper.addToolMaterial("White Gem Material", 6, 160, 10.0F, 12.0F, 30);

	private static ToolMaterial BLUE_DIAMOND_MATERIAL = EnumHelper.addToolMaterial("Blue Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial RED_DIAMOND_MATERIAL = EnumHelper.addToolMaterial("Red Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial PURPLE_DIAMOND_MATERIAL = EnumHelper.addToolMaterial("Purple Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial YELLOW_DIAMOND_MATERIAL = EnumHelper.addToolMaterial("Yellow Diamond Material", 6, 250, 12.0F, 12.0F, 40);
	private static ToolMaterial GREEN_DIAMOND_MATERIAL = EnumHelper.addToolMaterial("Green Diamond Material", 6, 250, 12.0F, 12.0F, 40);

	public static Item CARBON_PICKAXE;
	public static Item CARBON_AXE;
	public static Item CARBON_HOE;
	public static Item CARBON_SHOVEL;
	public static Item CARBON_SWORD;

	public static Item PALLADIUM_PICKAXE;
	public static Item PALLADIUM_AXE;
	public static Item PALLADIUM_HOE;
	public static Item PALLADIUM_SHOVEL;
	public static Item PALLADIUM_SWORD;

	public static Item MAGNESIUM_PICKAXE;
	public static Item MAGNESIUM_AXE;
	public static Item MAGNESIUM_HOE;
	public static Item MAGNESIUM_SHOVEL;
	public static Item MAGNESIUM_SWORD;

	public static Item CRYSTAL_PICKAXE;
	public static Item CRYSTAL_AXE;
	public static Item CRYSTAL_HOE;
	public static Item CRYSTAL_SHOVEL;
	public static Item CRYSTAL_SWORD;

	public static Item TUNGSTEN_PICKAXE;
	public static Item TUNGSTEN_AXE;
	public static Item TUNGSTEN_HOE;
	public static Item TUNGSTEN_SHOVEL;
	public static Item TUNGSTEN_SWORD;

	public static Item RED_GEM_PICKAXE;
	public static Item RED_GEM_AXE;
	public static Item RED_GEM_HOE;
	public static Item RED_GEM_SHOVEL;
	public static Item RED_GEM_SWORD;

	public static Item BLUE_GEM_PICKAXE;
	public static Item BLUE_GEM_AXE;
	public static Item BLUE_GEM_HOE;
	public static Item BLUE_GEM_SHOVEL;
	public static Item BLUE_GEM_SWORD;

	public static Item WHITE_GEM_PICKAXE;
	public static Item WHITE_GEM_AXE;
	public static Item WHITE_GEM_HOE;
	public static Item WHITE_GEM_SHOVEL;
	public static Item WHITE_GEM_SWORD;

	public static Item ZINC_PICKAXE;
	public static Item ZINC_AXE;
	public static Item ZINC_HOE;
	public static Item ZINC_SHOVEL;
	public static Item ZINC_SWORD;

	public static Item MERCURY_PICKAXE;
	public static Item MERCURY_AXE;
	public static Item MERCURY_HOE;
	public static Item MERCURY_SHOVEL;
	public static Item MERCURY_SWORD;

	public static Item URANIUM_PICKAXE;
	public static Item URANIUM_AXE;
	public static Item URANIUM_HOE;
	public static Item URANIUM_SHOVEL;
	public static Item URANIUM_SWORD;

	public static Item BLUE_DIAMOND_PICKAXE;
	public static Item BLUE_DIAMOND_AXE;
	public static Item BLUE_DIAMOND_HOE;
	public static Item BLUE_DIAMOND_SHOVEL;
	public static Item BLUE_DIAMOND_SWORD;

	public static Item RED_DIAMOND_PICKAXE;
	public static Item RED_DIAMOND_AXE;
	public static Item RED_DIAMOND_HOE;
	public static Item RED_DIAMOND_SHOVEL;
	public static Item RED_DIAMOND_SWORD;

	public static Item PURPLE_DIAMOND_PICKAXE;
	public static Item PURPLE_DIAMOND_AXE;
	public static Item PURPLE_DIAMOND_HOE;
	public static Item PURPLE_DIAMOND_SHOVEL;
	public static Item PURPLE_DIAMOND_SWORD;

	public static Item YELLOW_DIAMOND_PICKAXE;
	public static Item YELLOW_DIAMOND_AXE;
	public static Item YELLOW_DIAMOND_HOE;
	public static Item YELLOW_DIAMOND_SHOVEL;
	public static Item YELLOW_DIAMOND_SWORD;

	public static Item GREEN_DIAMOND_PICKAXE;
	public static Item GREEN_DIAMOND_AXE;
	public static Item GREEN_DIAMOND_HOE;
	public static Item GREEN_DIAMOND_SHOVEL;
	public static Item GREEN_DIAMOND_SWORD;

	public static void init() {
		initializeTools();
		registerTools();
	}

	private static void initializeTools() {
		if (Config.MERCURY && Config.ITEMS_MERCURY) {
			MERCURY_PICKAXE = new BasicPickaxe(MERCURY_MATERIAL, "mercury_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			MERCURY_AXE = new BasicAxe(MERCURY_MATERIAL, "mercury_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			MERCURY_HOE = new BasicHoe(MERCURY_MATERIAL, "mercury_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			MERCURY_SHOVEL = new BasicShovel(MERCURY_MATERIAL, "mercury_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			MERCURY_SWORD = new BasicSword(MERCURY_MATERIAL, "mercury_sword").setCreativeTab(ExtraPlanets.ItemsTab);
		}
		if (Config.MERCURY && Config.ITEMS_CARBON) {
			CARBON_PICKAXE = new BasicPickaxe(CARBON_MATERIAL, "carbon_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			CARBON_AXE = new BasicAxe(CARBON_MATERIAL, "carbon_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			CARBON_HOE = new BasicHoe(CARBON_MATERIAL, "carbon_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			CARBON_SHOVEL = new BasicShovel(CARBON_MATERIAL, "carbon_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			CARBON_SWORD = new BasicSword(CARBON_MATERIAL, "carbon_sword").setCreativeTab(ExtraPlanets.ItemsTab);
		}
		if (Config.CERES && Config.ITEMS_URANIUM) {
			URANIUM_PICKAXE = new BasicPickaxe(URANIUM_MATERIAL, "uranium_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			URANIUM_AXE = new BasicAxe(URANIUM_MATERIAL, "uranium_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			URANIUM_HOE = new BasicHoe(URANIUM_MATERIAL, "uranium_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			URANIUM_SHOVEL = new BasicShovel(URANIUM_MATERIAL, "uranium_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			URANIUM_SWORD = new BasicSword(URANIUM_MATERIAL, "uranium_sword").setCreativeTab(ExtraPlanets.ItemsTab);
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				PALLADIUM_PICKAXE = new BasicPickaxe(PALLADIUM_MATERIAL, "palladium_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
				PALLADIUM_AXE = new BasicAxe(PALLADIUM_MATERIAL, "palladium_axe").setCreativeTab(ExtraPlanets.ItemsTab);
				PALLADIUM_HOE = new BasicHoe(PALLADIUM_MATERIAL, "palladium_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
				PALLADIUM_SHOVEL = new BasicShovel(PALLADIUM_MATERIAL, "palladium_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
				PALLADIUM_SWORD = new BasicSword(PALLADIUM_MATERIAL, "palladium_sword").setCreativeTab(ExtraPlanets.ItemsTab);
			}
			if (Config.ITEMS_GEM_RED) {
				RED_GEM_PICKAXE = new BasicPickaxe(RED_GEM_MATERIAL, "red_gem_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
				RED_GEM_AXE = new BasicAxe(RED_GEM_MATERIAL, "red_gem_axe").setCreativeTab(ExtraPlanets.ItemsTab);
				RED_GEM_HOE = new BasicHoe(RED_GEM_MATERIAL, "red_gem_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
				RED_GEM_SHOVEL = new BasicShovel(RED_GEM_MATERIAL, "red_gem_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
				RED_GEM_SWORD = new BasicSword(RED_GEM_MATERIAL, "red_gem_sword").setCreativeTab(ExtraPlanets.ItemsTab);
			}
		}
		if (Config.SATURN && Config.ITEMS_MAGNESIUM) {
			MAGNESIUM_PICKAXE = new BasicPickaxe(MAGNESIUM_MATERIAL, "magnesium_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			MAGNESIUM_AXE = new BasicAxe(MAGNESIUM_MATERIAL, "magnesium_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			MAGNESIUM_HOE = new BasicHoe(MAGNESIUM_MATERIAL, "magnesium_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			MAGNESIUM_SHOVEL = new BasicShovel(MAGNESIUM_MATERIAL, "magnesium_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			MAGNESIUM_SWORD = new BasicSword(MAGNESIUM_MATERIAL, "magnesium_sword").setCreativeTab(ExtraPlanets.ItemsTab);
		}
		if (Config.URANUS) {
			if (Config.ITEMS_PALLADIUM) {
				CRYSTAL_PICKAXE = new BasicPickaxe(CRYSTAL_MATERIAL, "crystal_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
				CRYSTAL_AXE = new BasicAxe(CRYSTAL_MATERIAL, "crystal_axe").setCreativeTab(ExtraPlanets.ItemsTab);
				CRYSTAL_HOE = new BasicHoe(CRYSTAL_MATERIAL, "crystal_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
				CRYSTAL_SHOVEL = new BasicShovel(CRYSTAL_MATERIAL, "crystal_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
				CRYSTAL_SWORD = new BasicSword(CRYSTAL_MATERIAL, "crystal_sword").setCreativeTab(ExtraPlanets.ItemsTab);
			}
			if (Config.ITEMS_GEM_WHITE) {
				WHITE_GEM_PICKAXE = new BasicPickaxe(WHITE_GEM_MATERIAL, "white_gem_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
				WHITE_GEM_AXE = new BasicAxe(WHITE_GEM_MATERIAL, "white_gem_axe").setCreativeTab(ExtraPlanets.ItemsTab);
				WHITE_GEM_HOE = new BasicHoe(WHITE_GEM_MATERIAL, "white_gem_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
				WHITE_GEM_SHOVEL = new BasicShovel(WHITE_GEM_MATERIAL, "white_gem_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
				WHITE_GEM_SWORD = new BasicSword(WHITE_GEM_MATERIAL, "white_gem_sword").setCreativeTab(ExtraPlanets.ItemsTab);
			}
		}
		if (Config.NEPTUNE) {
			if (Config.ITEMS_GEM_BLUE) {
				BLUE_GEM_PICKAXE = new BasicPickaxe(BLUE_GEM_MATERIAL, "blue_gem_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
				BLUE_GEM_AXE = new BasicAxe(BLUE_GEM_MATERIAL, "blue_gem_axe").setCreativeTab(ExtraPlanets.ItemsTab);
				BLUE_GEM_HOE = new BasicHoe(BLUE_GEM_MATERIAL, "blue_gem_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
				BLUE_GEM_SHOVEL = new BasicShovel(BLUE_GEM_MATERIAL, "blue_gem_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
				BLUE_GEM_SWORD = new BasicSword(BLUE_GEM_MATERIAL, "blue_gem_sword").setCreativeTab(ExtraPlanets.ItemsTab);
			}
			if (Config.ITEMS_ZINC) {
				ZINC_PICKAXE = new BasicPickaxe(ZINC_MATERIAL, "zinc_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
				ZINC_AXE = new BasicAxe(ZINC_MATERIAL, "zinc_axe").setCreativeTab(ExtraPlanets.ItemsTab);
				ZINC_HOE = new BasicHoe(ZINC_MATERIAL, "zinc_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
				ZINC_SHOVEL = new BasicShovel(ZINC_MATERIAL, "zinc_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
				ZINC_SWORD = new BasicSword(ZINC_MATERIAL, "zinc_sword").setCreativeTab(ExtraPlanets.ItemsTab);
			}
		}
		if (Config.PLUTO && Config.ITEMS_TUNGSTEN) {
			TUNGSTEN_PICKAXE = new BasicPickaxe(TUNGSTEN_MATERIAL, "tungsten_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			TUNGSTEN_AXE = new BasicAxe(TUNGSTEN_MATERIAL, "tungsten_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			TUNGSTEN_HOE = new BasicHoe(TUNGSTEN_MATERIAL, "tungsten_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			TUNGSTEN_SHOVEL = new BasicShovel(TUNGSTEN_MATERIAL, "tungsten_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			TUNGSTEN_SWORD = new BasicSword(TUNGSTEN_MATERIAL, "tungsten_sword").setCreativeTab(ExtraPlanets.ItemsTab);
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			BLUE_DIAMOND_PICKAXE = new BasicPickaxe(BLUE_DIAMOND_MATERIAL, "blue_diamond_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			BLUE_DIAMOND_AXE = new BasicAxe(BLUE_DIAMOND_MATERIAL, "blue_diamond_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			BLUE_DIAMOND_HOE = new BasicHoe(BLUE_DIAMOND_MATERIAL, "blue_diamond_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			BLUE_DIAMOND_SHOVEL = new BasicShovel(BLUE_DIAMOND_MATERIAL, "blue_diamond_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			BLUE_DIAMOND_SWORD = new BasicSword(BLUE_DIAMOND_MATERIAL, "blue_diamond_sword").setCreativeTab(ExtraPlanets.ItemsTab);

			RED_DIAMOND_PICKAXE = new BasicPickaxe(RED_DIAMOND_MATERIAL, "red_diamond_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			RED_DIAMOND_AXE = new BasicAxe(RED_DIAMOND_MATERIAL, "red_diamond_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			RED_DIAMOND_HOE = new BasicHoe(RED_DIAMOND_MATERIAL, "red_diamond_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			RED_DIAMOND_SHOVEL = new BasicShovel(RED_DIAMOND_MATERIAL, "red_diamond_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			RED_DIAMOND_SWORD = new BasicSword(RED_DIAMOND_MATERIAL, "red_diamond_sword").setCreativeTab(ExtraPlanets.ItemsTab);

			PURPLE_DIAMOND_PICKAXE = new BasicPickaxe(PURPLE_DIAMOND_MATERIAL, "purple_diamond_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			PURPLE_DIAMOND_AXE = new BasicAxe(PURPLE_DIAMOND_MATERIAL, "purple_diamond_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			PURPLE_DIAMOND_HOE = new BasicHoe(PURPLE_DIAMOND_MATERIAL, "purple_diamond_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			PURPLE_DIAMOND_SHOVEL = new BasicShovel(PURPLE_DIAMOND_MATERIAL, "purple_diamond_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			PURPLE_DIAMOND_SWORD = new BasicSword(PURPLE_DIAMOND_MATERIAL, "purple_diamond_sword").setCreativeTab(ExtraPlanets.ItemsTab);

			YELLOW_DIAMOND_PICKAXE = new BasicPickaxe(YELLOW_DIAMOND_MATERIAL, "yellow_diamond_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			YELLOW_DIAMOND_AXE = new BasicAxe(YELLOW_DIAMOND_MATERIAL, "yellow_diamond_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			YELLOW_DIAMOND_HOE = new BasicHoe(YELLOW_DIAMOND_MATERIAL, "yellow_diamond_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			YELLOW_DIAMOND_SHOVEL = new BasicShovel(YELLOW_DIAMOND_MATERIAL, "yellow_diamond_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			YELLOW_DIAMOND_SWORD = new BasicSword(YELLOW_DIAMOND_MATERIAL, "yellow_diamond_sword").setCreativeTab(ExtraPlanets.ItemsTab);

			GREEN_DIAMOND_PICKAXE = new BasicPickaxe(GREEN_DIAMOND_MATERIAL, "green_diamond_pickaxe").setCreativeTab(ExtraPlanets.ItemsTab);
			GREEN_DIAMOND_AXE = new BasicAxe(GREEN_DIAMOND_MATERIAL, "green_diamond_axe").setCreativeTab(ExtraPlanets.ItemsTab);
			GREEN_DIAMOND_HOE = new BasicHoe(GREEN_DIAMOND_MATERIAL, "green_diamond_hoe").setCreativeTab(ExtraPlanets.ItemsTab);
			GREEN_DIAMOND_SHOVEL = new BasicShovel(GREEN_DIAMOND_MATERIAL, "green_diamond_shovel").setCreativeTab(ExtraPlanets.ItemsTab);
			GREEN_DIAMOND_SWORD = new BasicSword(GREEN_DIAMOND_MATERIAL, "green_diamond_sword").setCreativeTab(ExtraPlanets.ItemsTab);
		}
	}

	private static void registerTools() {
		if (Config.MERCURY && Config.ITEMS_MERCURY) {
			ExtraPlanets_Items.registerItem(MERCURY_PICKAXE, MERCURY_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MERCURY_AXE, MERCURY_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MERCURY_HOE, MERCURY_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MERCURY_SHOVEL, MERCURY_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MERCURY_SWORD, MERCURY_SWORD.getUnlocalizedName().substring(5));
		}
		if (Config.MERCURY && Config.ITEMS_CARBON) {
			ExtraPlanets_Items.registerItem(CARBON_PICKAXE, CARBON_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(CARBON_AXE, CARBON_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(CARBON_HOE, CARBON_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(CARBON_SHOVEL, CARBON_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(CARBON_SWORD, CARBON_SWORD.getUnlocalizedName().substring(5));
		}
		if (Config.CERES && Config.ITEMS_URANIUM) {
			ExtraPlanets_Items.registerItem(URANIUM_PICKAXE, URANIUM_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(URANIUM_AXE, URANIUM_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(URANIUM_HOE, URANIUM_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(URANIUM_SHOVEL, URANIUM_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(URANIUM_SWORD, URANIUM_SWORD.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				ExtraPlanets_Items.registerItem(PALLADIUM_PICKAXE, PALLADIUM_PICKAXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(PALLADIUM_AXE, PALLADIUM_AXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(PALLADIUM_HOE, PALLADIUM_HOE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(PALLADIUM_SHOVEL, PALLADIUM_SHOVEL.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(PALLADIUM_SWORD, PALLADIUM_SWORD.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_RED) {
				ExtraPlanets_Items.registerItem(RED_GEM_PICKAXE, RED_GEM_PICKAXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(RED_GEM_AXE, RED_GEM_AXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(RED_GEM_HOE, RED_GEM_HOE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(RED_GEM_SHOVEL, RED_GEM_SHOVEL.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(RED_GEM_SWORD, RED_GEM_SWORD.getUnlocalizedName().substring(5));
			}
		}
		if (Config.SATURN && Config.ITEMS_MAGNESIUM) {
			ExtraPlanets_Items.registerItem(MAGNESIUM_PICKAXE, MAGNESIUM_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MAGNESIUM_AXE, MAGNESIUM_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MAGNESIUM_HOE, MAGNESIUM_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MAGNESIUM_SHOVEL, MAGNESIUM_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(MAGNESIUM_SWORD, MAGNESIUM_SWORD.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			if (Config.ITEMS_CRYSTAL) {
				ExtraPlanets_Items.registerItem(CRYSTAL_PICKAXE, CRYSTAL_PICKAXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(CRYSTAL_AXE, CRYSTAL_AXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(CRYSTAL_HOE, CRYSTAL_HOE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(CRYSTAL_SHOVEL, CRYSTAL_SHOVEL.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(CRYSTAL_SWORD, CRYSTAL_SWORD.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_WHITE) {
				ExtraPlanets_Items.registerItem(WHITE_GEM_PICKAXE, WHITE_GEM_PICKAXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(WHITE_GEM_AXE, WHITE_GEM_AXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(WHITE_GEM_HOE, WHITE_GEM_HOE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(WHITE_GEM_SHOVEL, WHITE_GEM_SHOVEL.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(WHITE_GEM_SWORD, WHITE_GEM_SWORD.getUnlocalizedName().substring(5));
			}
		}
		if (Config.NEPTUNE) {
			if (Config.ITEMS_GEM_BLUE) {
				ExtraPlanets_Items.registerItem(BLUE_GEM_PICKAXE, BLUE_GEM_PICKAXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(BLUE_GEM_AXE, BLUE_GEM_AXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(BLUE_GEM_HOE, BLUE_GEM_HOE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(BLUE_GEM_SHOVEL, BLUE_GEM_SHOVEL.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(BLUE_GEM_SWORD, BLUE_GEM_SWORD.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_ZINC) {
				ExtraPlanets_Items.registerItem(ZINC_PICKAXE, ZINC_PICKAXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(ZINC_AXE, ZINC_AXE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(ZINC_HOE, ZINC_HOE.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(ZINC_SHOVEL, ZINC_SHOVEL.getUnlocalizedName().substring(5));
				ExtraPlanets_Items.registerItem(ZINC_SWORD, ZINC_SWORD.getUnlocalizedName().substring(5));
			}
		}
		if (Config.PLUTO && Config.ITEMS_TUNGSTEN) {
			ExtraPlanets_Items.registerItem(TUNGSTEN_PICKAXE, TUNGSTEN_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(TUNGSTEN_AXE, TUNGSTEN_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(TUNGSTEN_HOE, TUNGSTEN_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(TUNGSTEN_SHOVEL, TUNGSTEN_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(TUNGSTEN_SWORD, TUNGSTEN_SWORD.getUnlocalizedName().substring(5));
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			ExtraPlanets_Items.registerItem(BLUE_DIAMOND_PICKAXE, BLUE_DIAMOND_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(BLUE_DIAMOND_AXE, BLUE_DIAMOND_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(BLUE_DIAMOND_HOE, BLUE_DIAMOND_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(BLUE_DIAMOND_SHOVEL, BLUE_DIAMOND_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(BLUE_DIAMOND_SWORD, BLUE_DIAMOND_SWORD.getUnlocalizedName().substring(5));

			ExtraPlanets_Items.registerItem(RED_DIAMOND_PICKAXE, RED_DIAMOND_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(RED_DIAMOND_AXE, RED_DIAMOND_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(RED_DIAMOND_HOE, RED_DIAMOND_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(RED_DIAMOND_SHOVEL, RED_DIAMOND_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(RED_DIAMOND_SWORD, RED_DIAMOND_SWORD.getUnlocalizedName().substring(5));

			ExtraPlanets_Items.registerItem(PURPLE_DIAMOND_PICKAXE, PURPLE_DIAMOND_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(PURPLE_DIAMOND_AXE, PURPLE_DIAMOND_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(PURPLE_DIAMOND_HOE, PURPLE_DIAMOND_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(PURPLE_DIAMOND_SHOVEL, PURPLE_DIAMOND_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(PURPLE_DIAMOND_SWORD, PURPLE_DIAMOND_SWORD.getUnlocalizedName().substring(5));

			ExtraPlanets_Items.registerItem(YELLOW_DIAMOND_PICKAXE, YELLOW_DIAMOND_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(YELLOW_DIAMOND_AXE, YELLOW_DIAMOND_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(YELLOW_DIAMOND_HOE, YELLOW_DIAMOND_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(YELLOW_DIAMOND_SHOVEL, YELLOW_DIAMOND_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(YELLOW_DIAMOND_SWORD, YELLOW_DIAMOND_SWORD.getUnlocalizedName().substring(5));

			ExtraPlanets_Items.registerItem(GREEN_DIAMOND_PICKAXE, GREEN_DIAMOND_PICKAXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(GREEN_DIAMOND_AXE, GREEN_DIAMOND_AXE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(GREEN_DIAMOND_HOE, GREEN_DIAMOND_HOE.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(GREEN_DIAMOND_SHOVEL, GREEN_DIAMOND_SHOVEL.getUnlocalizedName().substring(5));
			ExtraPlanets_Items.registerItem(GREEN_DIAMOND_SWORD, GREEN_DIAMOND_SWORD.getUnlocalizedName().substring(5));
		}
	}
}
