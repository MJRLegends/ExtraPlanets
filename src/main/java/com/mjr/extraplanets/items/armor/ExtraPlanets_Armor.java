package com.mjr.extraplanets.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.util.RegisterHelper;

public class ExtraPlanets_Armor {
	private static ArmorMaterial CARBON_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Carbon_Armor", "Test", 26, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial PALLADIUM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Palladium_Armor", "Test", 26, new int[] { 3, 8, 6, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial MAGNESIUM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Magnesium_Armor", "Test", 30, new int[] { 3, 8, 6, 3 }, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial CRYSTAL_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Crystal_Armor", "Test", 40, new int[] { 3, 8, 6, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial MERCURY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Mercury_Armor", "Test", 15, new int[] { 3, 8, 6, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial URANIUM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Uranium_Armor", "Test", 20, new int[] { 3, 8, 6, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial ZINC_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Zinc_Armor", "Test", 45, new int[] { 3, 8, 6, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial TUNGSTEN_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Tungsten_Armor", "Test", 50, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial RED_GEM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Red_Gem_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial WHITE_GEM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("White_Gem_Armor", "Test", 40, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial BLUE_GEM_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Blue_Gem_Armor", "Test", 45, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial BLUE_DIAMOND_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Blue_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial RED_DIAMOND_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Red_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial PURPLE_DIAMOND_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Purple_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial YELLOW_DIAMOND_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Yellow_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial GREEM_DIAMOND_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Green_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial TIER_1_SPACE_SUIT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Tier1_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial TIER_2_SPACE_SUIT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Tier2_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial TIER_3_SPACE_SUIT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Tier3_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial TIER_4_SPACE_SUIT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("Tier4_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static Item CARBON_HELMET;
	public static Item CARBON_CHEST;
	public static Item CARBON_LEGINGS;
	public static Item CARBON_BOOTS;

	public static Item PALLASIUM_HELMET;
	public static Item PALLASIUM_CHEST;
	public static Item PALLASIUM_LEGINGS;
	public static Item PALLASIUM_BOOTS;

	public static Item MAGNESIUM_HELMET;
	public static Item MAGNESIUM_CHEST;
	public static Item MAGNESIUM_LEGINGS;
	public static Item MAGNESIUM_BOOTS;

	public static Item CRYSTAL_HELMET;
	public static Item CRYSTAL_CHEST;
	public static Item CRYSTAL_LEGINGS;
	public static Item CRYSTAL_BOOTS;

	public static Item ZINC_HELMET;
	public static Item ZINC_CHEST;
	public static Item ZINC_LEGINGS;
	public static Item ZINC_BOOTS;

	public static Item MERCURY_HELMET;
	public static Item MERCURY_CHEST;
	public static Item MERCURY_LEGINGS;
	public static Item MERCURY_BOOTS;

	public static Item URANIUM_HELMET;
	public static Item URANIUM_CHEST;
	public static Item URANIUM_LEGINGS;
	public static Item URANIUM_BOOTS;

	public static Item TUNGSTEN_HELMET;
	public static Item TUNGSTEN_CHEST;
	public static Item TUNGSTEN_LEGINGS;
	public static Item TUNGSTEN_BOOTS;

	public static Item RED_GEM_HELMET;
	public static Item RED_GEM_CHEST;
	public static Item RED_GEM_LEGINGS;
	public static Item RED_GEM_BOOTS;

	public static Item WHITE_GEM_HELMET;
	public static Item WHITE_GEM_CHEST;
	public static Item WHITE_GEM_LEGINGS;
	public static Item WHITE_GEM_BOOTS;

	public static Item BLUE_GEM_HELMET;
	public static Item BLUE_GEM_CHEST;
	public static Item BLUE_GEM_LEGINGS;
	public static Item BLUE_GEM_BOOTS;

	public static Item BLUE_DIAMOND_HELMET;
	public static Item BLUE_DIAMOND_CHEST;
	public static Item BLUE_DIAMOND_LEGINGS;
	public static Item BLUE_DIAMOND_BOOTS;

	public static Item RED_DIAMOND_HELMET;
	public static Item RED_DIAMOND_CHEST;
	public static Item RED_DIAMOND_LEGINGS;
	public static Item RED_DIAMOND_BOOTS;

	public static Item PURPLE_DIAMOND_HELMET;
	public static Item PURPLE_DIAMOND_CHEST;
	public static Item PURPLE_DIAMOND_LEGINGS;
	public static Item PURPLE_DIAMOND_BOOTS;

	public static Item YELLOW_DIAMOND_HELMET;
	public static Item YELLOW_DIAMOND_CHEST;
	public static Item YELLOW_DIAMOND_LEGINGS;
	public static Item YELLOW_DIAMOND_BOOTS;

	public static Item GREEN_DIAMOND_HELMET;
	public static Item GREEN_DIAMOND_CHEST;
	public static Item GREEN_DIAMOND_LEGINGS;
	public static Item GREEN_DIAMOND_BOOTS;

	public static Item TIER_1_SPACE_SUIT_HELMET;
	public static Item TIER_1_SPACE_SUIT_CHEST;
	public static Item TIER_1_SPACE_SUIT_LEGINGS;
	public static Item TIER_1_SPACE_SUIT_BOOTS;
	public static Item TIER_1_SPACE_SUIT_GRAVITY_BOOTS;

	public static Item TIER_2_SPACE_SUIT_HELMET;
	public static Item TIER_2_SPACE_SUIT_CHEST;
	public static Item TIER_2_SPACE_SUIT_LEGINGS;
	public static Item TIER_2_SPACE_SUIT_BOOTS;
	public static Item TIER_2_SPACE_SUIT_GRAVITY_BOOTS;

	public static Item TIER_3_SPACE_SUIT_HELMET;
	public static Item TIER_3_SPACE_SUIT_CHEST;
	public static Item TIER_3_SPACE_SUIT_LEGINGS;
	public static Item TIER_3_SPACE_SUIT_BOOTS;
	public static Item TIER_3_SPACE_SUIT_GRAVITY_BOOTS;

	public static Item TIER_4_SPACE_SUIT_HELMET;
	public static Item TIER_4_SPACE_SUIT_CHEST;
	public static Item TIER_4_SPACE_SUIT_LEGINGS;
	public static Item TIER_4_SPACE_SUIT_BOOTS;
	public static Item TIER_4_SPACE_SUIT_GRAVITY_BOOTS;

	public static void init() {
		initializeArmor();
		registerArmor();
	}

	private static void initializeArmor() {
		if (Config.ITEMS_MERCURY && Config.MERCURY) {
			MERCURY_HELMET = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("mercury_helmet");
			MERCURY_CHEST = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("mercury_chest");
			MERCURY_LEGINGS = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("mercury_legings");
			MERCURY_BOOTS = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("mercury_boots");
		}
		if (Config.ITEMS_CARBON && Config.MERCURY) {
			CARBON_HELMET = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("carbon_helmet");
			CARBON_CHEST = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("carbon_chest");
			CARBON_LEGINGS = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("carbon_legings");
			CARBON_BOOTS = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("carbon_boots");
		}
		if (Config.ITEMS_URANIUM && Config.CERES) {
			URANIUM_HELMET = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("uranium_helmet");
			URANIUM_CHEST = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("uranium_chest");
			URANIUM_LEGINGS = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("uranium_legings");
			URANIUM_BOOTS = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("uranium_boots");
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				PALLASIUM_HELMET = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("palladium_helmet");
				PALLASIUM_CHEST = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("palladium_chest");
				PALLASIUM_LEGINGS = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("palladium_legings");
				PALLASIUM_BOOTS = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("palladium_boots");
			}
			if (Config.ITEMS_GEM_RED) {
				RED_GEM_HELMET = new RedGemArmor("red_gem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("red_gem_helmet");
				RED_GEM_CHEST = new RedGemArmor("red_gem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("red_gem_chest");
				RED_GEM_LEGINGS = new RedGemArmor("red_gem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("red_gem_legings");
				RED_GEM_BOOTS = new RedGemArmor("red_gem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("red_gem_boots");
			}
		}
		if (Config.ITEMS_MAGNESIUM && Config.SATURN) {
			MAGNESIUM_HELMET = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("magnesium_helmet");
			MAGNESIUM_CHEST = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("magnesium_chest");
			MAGNESIUM_LEGINGS = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("magnesium_legings");
			MAGNESIUM_BOOTS = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("magnesium_boots");
		}
		if (Config.ITEMS_CRYSTAL && Config.URANUS) {
			CRYSTAL_HELMET = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("crystal_helmet");
			CRYSTAL_CHEST = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("crystal_chest");
			CRYSTAL_LEGINGS = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("crystal_legings");
			CRYSTAL_BOOTS = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("crystal_boots");
			if (Config.ITEMS_GEM_WHITE) {
				WHITE_GEM_HELMET = new WhiteGemArmor("white_gem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("white_gem_helmet");
				WHITE_GEM_CHEST = new WhiteGemArmor("white_gem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("white_gem_chest");
				WHITE_GEM_LEGINGS = new WhiteGemArmor("white_gem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("white_gem_legings");
				WHITE_GEM_BOOTS = new WhiteGemArmor("white_gem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("white_gem_boots");
			}
		}
		if (Config.ITEMS_ZINC && Config.NEPTUNE) {
			ZINC_HELMET = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("zinc_helmet");
			ZINC_CHEST = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("zinc_chest");
			ZINC_LEGINGS = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("zinc_legings");
			ZINC_BOOTS = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("zinc_boots");
			if (Config.ITEMS_GEM_BLUE) {
				BLUE_GEM_HELMET = new BlueGemArmor("blue_gem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("blue_gem_helmet");
				BLUE_GEM_CHEST = new BlueGemArmor("blue_gem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("blue_gem_chest");
				BLUE_GEM_LEGINGS = new BlueGemArmor("blue_gem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("blue_gem_legings");
				BLUE_GEM_BOOTS = new BlueGemArmor("blue_gem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("blue_gem_boots");
			}
		}
		if (Config.ITEMS_TUNGSTEN && Config.PLUTO) {
			TUNGSTEN_HELMET = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tungsten_helmet");
			TUNGSTEN_CHEST = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tungsten_chest");
			TUNGSTEN_LEGINGS = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tungsten_legings");
			TUNGSTEN_BOOTS = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tungsten_boots");
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			BLUE_DIAMOND_HELMET = new BlueDiamondArmor("blue_diamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("blue_diamond_helmet");
			BLUE_DIAMOND_CHEST = new BlueDiamondArmor("blue_diamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("blue_diamond_chest");
			BLUE_DIAMOND_LEGINGS = new BlueDiamondArmor("blue_diamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("blue_diamond_legings");
			BLUE_DIAMOND_BOOTS = new BlueDiamondArmor("blue_diamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("blue_diamond_boots");

			RED_DIAMOND_HELMET = new RedDiamondArmor("red_diamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("red_diamond_helmet");
			RED_DIAMOND_CHEST = new RedDiamondArmor("red_diamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("red_diamond_chest");
			RED_DIAMOND_LEGINGS = new RedDiamondArmor("red_diamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("red_diamond_legings");
			RED_DIAMOND_BOOTS = new RedDiamondArmor("red_diamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("red_diamond_boots");

			PURPLE_DIAMOND_HELMET = new PurpleDiamondArmor("purple_diamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("purple_diamond_helmet");
			PURPLE_DIAMOND_CHEST = new PurpleDiamondArmor("purple_diamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("purple_diamond_chest");
			PURPLE_DIAMOND_LEGINGS = new PurpleDiamondArmor("purple_diamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("purple_diamond_legings");
			PURPLE_DIAMOND_BOOTS = new PurpleDiamondArmor("purple_diamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("purple_diamond_boots");

			YELLOW_DIAMOND_HELMET = new YellowDiamondArmor("yellow_diamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("yellow_diamond_helmet");
			YELLOW_DIAMOND_CHEST = new YellowDiamondArmor("yellow_diamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("yellow_diamond_chest");
			YELLOW_DIAMOND_LEGINGS = new YellowDiamondArmor("yellow_diamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("yellow_diamond_legings");
			YELLOW_DIAMOND_BOOTS = new YellowDiamondArmor("yellow_diamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("yellow_diamond_boots");

			GREEN_DIAMOND_HELMET = new GreenDiamondArmor("green_diamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("green_diamond_helmet");
			GREEN_DIAMOND_CHEST = new GreenDiamondArmor("green_diamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("green_diamond_chest");
			GREEN_DIAMOND_LEGINGS = new GreenDiamondArmor("green_diamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("green_diamond_legings");
			GREEN_DIAMOND_BOOTS = new GreenDiamondArmor("green_diamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("green_diamond_boots");
		}
		if (Config.PRESSURE || Config.RADIATION) {
			TIER_1_SPACE_SUIT_HELMET = new Tier1SpaceSuitArmor("tier1_space_suit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier1_space_suit_helmet");
			TIER_1_SPACE_SUIT_CHEST = new Tier1SpaceSuitArmor("tier1_space_suit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier1_space_suit_chest");
			TIER_1_SPACE_SUIT_LEGINGS = new Tier1SpaceSuitArmor("tier1_space_suit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier1_space_suit_legings");
			TIER_1_SPACE_SUIT_BOOTS = new Tier1SpaceSuitArmor("tier1_space_suit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier1_space_suit_boots");
			TIER_1_SPACE_SUIT_GRAVITY_BOOTS = new Tier1SpaceSuitArmor("tier1_space_suit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier1_space_suit_gravity_boots");

			TIER_2_SPACE_SUIT_HELMET = new Tier2SpaceSuitArmor("tier1_space_suit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier2_space_suit_helmet");
			TIER_2_SPACE_SUIT_CHEST = new Tier2SpaceSuitArmor("tier1_space_suit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier2_space_suit_chest");
			TIER_2_SPACE_SUIT_LEGINGS = new Tier2SpaceSuitArmor("tier1_space_suit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier2_space_suit_legings");
			TIER_2_SPACE_SUIT_BOOTS = new Tier2SpaceSuitArmor("tier1_space_suit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier2_space_suit_boots");
			TIER_2_SPACE_SUIT_GRAVITY_BOOTS = new Tier2SpaceSuitArmor("tier2_space_suit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier2_space_suit_gravity_boots");

			TIER_3_SPACE_SUIT_HELMET = new Tier3SpaceSuitArmor("tier1_space_suit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier3_space_suit_helmet");
			TIER_3_SPACE_SUIT_CHEST = new Tier3SpaceSuitArmor("tier1_space_suit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier3_space_suit_chest");
			TIER_3_SPACE_SUIT_LEGINGS = new Tier3SpaceSuitArmor("tier1_space_suit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier3_space_suit_legings");
			TIER_3_SPACE_SUIT_BOOTS = new Tier3SpaceSuitArmor("tier1_space_suit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier3_space_suit_boots");
			TIER_3_SPACE_SUIT_GRAVITY_BOOTS = new Tier3SpaceSuitArmor("tier1_space_suit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier3_space_suit_gravity_boots");

			TIER_4_SPACE_SUIT_HELMET = new Tier4SpaceSuitArmor("tier1_space_suit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier4_space_suit_helmet");
			TIER_4_SPACE_SUIT_CHEST = new Tier4SpaceSuitArmor("tier1_space_suit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier4_space_suit_chest");
			TIER_4_SPACE_SUIT_LEGINGS = new Tier4SpaceSuitArmor("tier1_space_suit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier4_space_suit_legings");
			TIER_4_SPACE_SUIT_BOOTS = new Tier4SpaceSuitArmor("tier1_space_suit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier4_space_suit_boots");
			TIER_4_SPACE_SUIT_GRAVITY_BOOTS = new Tier4SpaceSuitArmor("tier4_space_suit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier4_space_suit_gravity_boots");
		}
	}

	private static void registerArmor() {
		if (Config.ITEMS_MERCURY && Config.MERCURY) {
			RegisterHelper.registerItem(MERCURY_HELMET, MERCURY_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MERCURY_CHEST, MERCURY_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MERCURY_LEGINGS, MERCURY_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MERCURY_BOOTS, MERCURY_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.ITEMS_CARBON && Config.MERCURY) {
			RegisterHelper.registerItem(CARBON_HELMET, CARBON_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(CARBON_CHEST, CARBON_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(CARBON_LEGINGS, CARBON_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(CARBON_BOOTS, CARBON_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.ITEMS_URANIUM && Config.CERES) {
			RegisterHelper.registerItem(URANIUM_HELMET, URANIUM_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(URANIUM_CHEST, URANIUM_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(URANIUM_LEGINGS, URANIUM_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(URANIUM_BOOTS, URANIUM_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				RegisterHelper.registerItem(PALLASIUM_HELMET, PALLASIUM_HELMET.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(PALLASIUM_CHEST, PALLASIUM_CHEST.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(PALLASIUM_LEGINGS, PALLASIUM_LEGINGS.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(PALLASIUM_BOOTS, PALLASIUM_BOOTS.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_RED) {
				RegisterHelper.registerItem(RED_GEM_HELMET, RED_GEM_HELMET.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(RED_GEM_CHEST, RED_GEM_CHEST.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(RED_GEM_LEGINGS, RED_GEM_LEGINGS.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(RED_GEM_BOOTS, RED_GEM_BOOTS.getUnlocalizedName().substring(5));
			}
		}
		if (Config.ITEMS_MAGNESIUM && Config.SATURN) {
			RegisterHelper.registerItem(MAGNESIUM_HELMET, MAGNESIUM_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MAGNESIUM_CHEST, MAGNESIUM_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MAGNESIUM_LEGINGS, MAGNESIUM_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(MAGNESIUM_BOOTS, MAGNESIUM_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.URANUS) {
			if (Config.ITEMS_CRYSTAL) {
				RegisterHelper.registerItem(CRYSTAL_HELMET, CRYSTAL_HELMET.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(CRYSTAL_CHEST, CRYSTAL_CHEST.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(CRYSTAL_LEGINGS, CRYSTAL_LEGINGS.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(CRYSTAL_BOOTS, CRYSTAL_BOOTS.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_WHITE) {
				RegisterHelper.registerItem(WHITE_GEM_HELMET, WHITE_GEM_HELMET.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(WHITE_GEM_CHEST, WHITE_GEM_CHEST.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(WHITE_GEM_LEGINGS, WHITE_GEM_LEGINGS.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(WHITE_GEM_BOOTS, WHITE_GEM_BOOTS.getUnlocalizedName().substring(5));
			}
		}
		if (Config.NEPTUNE) {
			if (Config.ITEMS_ZINC) {
				RegisterHelper.registerItem(ZINC_HELMET, ZINC_HELMET.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(ZINC_CHEST, ZINC_CHEST.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(ZINC_LEGINGS, ZINC_LEGINGS.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(ZINC_BOOTS, ZINC_BOOTS.getUnlocalizedName().substring(5));
			}
			if (Config.ITEMS_GEM_BLUE) {
				RegisterHelper.registerItem(BLUE_GEM_HELMET, BLUE_GEM_HELMET.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(BLUE_GEM_CHEST, BLUE_GEM_CHEST.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(BLUE_GEM_LEGINGS, BLUE_GEM_LEGINGS.getUnlocalizedName().substring(5));
				RegisterHelper.registerItem(BLUE_GEM_BOOTS, BLUE_GEM_BOOTS.getUnlocalizedName().substring(5));
			}
		}
		if (Config.ITEMS_TUNGSTEN && Config.PLUTO) {
			RegisterHelper.registerItem(TUNGSTEN_HELMET, TUNGSTEN_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TUNGSTEN_CHEST, TUNGSTEN_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TUNGSTEN_LEGINGS, TUNGSTEN_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TUNGSTEN_BOOTS, TUNGSTEN_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterHelper.registerItem(BLUE_DIAMOND_HELMET, BLUE_DIAMOND_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BLUE_DIAMOND_CHEST, BLUE_DIAMOND_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BLUE_DIAMOND_LEGINGS, BLUE_DIAMOND_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(BLUE_DIAMOND_BOOTS, BLUE_DIAMOND_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(RED_DIAMOND_HELMET, RED_DIAMOND_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(RED_DIAMOND_CHEST, RED_DIAMOND_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(RED_DIAMOND_LEGINGS, RED_DIAMOND_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(RED_DIAMOND_BOOTS, RED_DIAMOND_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(PURPLE_DIAMOND_HELMET, PURPLE_DIAMOND_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(PURPLE_DIAMOND_CHEST, PURPLE_DIAMOND_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(PURPLE_DIAMOND_LEGINGS, PURPLE_DIAMOND_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(PURPLE_DIAMOND_BOOTS, PURPLE_DIAMOND_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(YELLOW_DIAMOND_HELMET, YELLOW_DIAMOND_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(YELLOW_DIAMOND_CHEST, YELLOW_DIAMOND_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(YELLOW_DIAMOND_LEGINGS, YELLOW_DIAMOND_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(YELLOW_DIAMOND_BOOTS, YELLOW_DIAMOND_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(GREEN_DIAMOND_HELMET, GREEN_DIAMOND_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(GREEN_DIAMOND_CHEST, GREEN_DIAMOND_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(GREEN_DIAMOND_LEGINGS, GREEN_DIAMOND_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(GREEN_DIAMOND_BOOTS, GREEN_DIAMOND_BOOTS.getUnlocalizedName().substring(5));
		}
		if (Config.PRESSURE || Config.RADIATION) {
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_HELMET, TIER_1_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_CHEST, TIER_1_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_LEGINGS, TIER_1_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_BOOTS, TIER_1_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_GRAVITY_BOOTS, TIER_1_SPACE_SUIT_GRAVITY_BOOTS.getUnlocalizedName().substring(5));

			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_HELMET, TIER_2_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_CHEST, TIER_2_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_LEGINGS, TIER_2_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_BOOTS, TIER_2_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_GRAVITY_BOOTS, TIER_2_SPACE_SUIT_GRAVITY_BOOTS.getUnlocalizedName().substring(5));
			
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_HELMET, TIER_3_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_CHEST, TIER_3_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_LEGINGS, TIER_3_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_BOOTS, TIER_3_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_GRAVITY_BOOTS, TIER_3_SPACE_SUIT_GRAVITY_BOOTS.getUnlocalizedName().substring(5));
			
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_HELMET, TIER_4_SPACE_SUIT_HELMET.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_CHEST, TIER_4_SPACE_SUIT_CHEST.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_LEGINGS, TIER_4_SPACE_SUIT_LEGINGS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_BOOTS, TIER_4_SPACE_SUIT_BOOTS.getUnlocalizedName().substring(5));
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_GRAVITY_BOOTS, TIER_4_SPACE_SUIT_GRAVITY_BOOTS.getUnlocalizedName().substring(5));
		}
	}
}