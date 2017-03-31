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
			MERCURY_HELMET = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("mercuryHelmet");
			MERCURY_CHEST = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("mercuryChest");
			MERCURY_LEGINGS = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("mercuryLegings");
			MERCURY_BOOTS = new MercuryArmor("mercury", MERCURY_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("mercuryBoots");
		}
		if (Config.ITEMS_CARBON && Config.MERCURY) {
			CARBON_HELMET = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("carbonHelmet");
			CARBON_CHEST = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("carbonChest");
			CARBON_LEGINGS = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("carbonLegings");
			CARBON_BOOTS = new CarbonArmor("carbon", CARBON_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("carbonBoots");
		}
		if (Config.ITEMS_URANIUM && Config.CERES) {
			URANIUM_HELMET = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("uraniumHelmet");
			URANIUM_CHEST = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("uraniumChest");
			URANIUM_LEGINGS = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("uraniumLegings");
			URANIUM_BOOTS = new UraniumArmor("uranium", URANIUM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("uraniumBoots");
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				PALLASIUM_HELMET = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("palladiumHelmet");
				PALLASIUM_CHEST = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("palladiumChest");
				PALLASIUM_LEGINGS = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("palladiumLegings");
				PALLASIUM_BOOTS = new PalladiumArmor("palladium", PALLADIUM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("palladiumBoots");
			}
			if (Config.ITEMS_GEM_RED) {
				RED_GEM_HELMET = new RedGemArmor("redGem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("redGemHelmet");
				RED_GEM_CHEST = new RedGemArmor("redGem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("redGemChest");
				RED_GEM_LEGINGS = new RedGemArmor("redGem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("redGemLegings");
				RED_GEM_BOOTS = new RedGemArmor("redGem", RED_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("redGemBoots");
			}
		}
		if (Config.ITEMS_MAGNESIUM && Config.SATURN) {
			MAGNESIUM_HELMET = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("magnesiumHelmet");
			MAGNESIUM_CHEST = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("magnesiumChest");
			MAGNESIUM_LEGINGS = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("magnesiumLegings");
			MAGNESIUM_BOOTS = new MagnesiumArmor("magnesium", MAGNESIUM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("magnesiumBoots");
		}
		if (Config.ITEMS_CRYSTAL && Config.URANUS) {
			CRYSTAL_HELMET = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("crystalHelmet");
			CRYSTAL_CHEST = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("crystalChest");
			CRYSTAL_LEGINGS = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("crystalLegings");
			CRYSTAL_BOOTS = new CrystalArmor("crystal", CRYSTAL_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("crystalBoots");
			if (Config.ITEMS_GEM_WHITE) {
				WHITE_GEM_HELMET = new WhiteGemArmor("whiteGem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("whiteGemHelmet");
				WHITE_GEM_CHEST = new WhiteGemArmor("whiteGem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("whiteGemChest");
				WHITE_GEM_LEGINGS = new WhiteGemArmor("whiteGem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("whiteGemLegings");
				WHITE_GEM_BOOTS = new WhiteGemArmor("whiteGem", WHITE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("whiteGemBoots");
			}
		}
		if (Config.ITEMS_ZINC && Config.NEPTUNE) {
			ZINC_HELMET = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("zincHelmet");
			ZINC_CHEST = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("zincChest");
			ZINC_LEGINGS = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("zincLegings");
			ZINC_BOOTS = new ZincArmor("zinc", ZINC_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("zincBoots");
			if (Config.ITEMS_GEM_BLUE) {
				BLUE_GEM_HELMET = new BlueGemArmor("blueGem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("blueGemHelmet");
				BLUE_GEM_CHEST = new BlueGemArmor("blueGem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("blueGemChest");
				BLUE_GEM_LEGINGS = new BlueGemArmor("blueGem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("blueGemLegings");
				BLUE_GEM_BOOTS = new BlueGemArmor("blueGem", BLUE_GEM_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("blueGemBoots");
			}
		}
		if (Config.ITEMS_TUNGSTEN && Config.PLUTO) {
			TUNGSTEN_HELMET = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tungstenHelmet");
			TUNGSTEN_CHEST = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tungstenChest");
			TUNGSTEN_LEGINGS = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tungstenLegings");
			TUNGSTEN_BOOTS = new TungstenArmor("tungsten", TUNGSTEN_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tungstenBoots");
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			BLUE_DIAMOND_HELMET = new BlueDiamondArmor("blueDiamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("blueDiamondHelmet");
			BLUE_DIAMOND_CHEST = new BlueDiamondArmor("blueDiamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("blueDiamondChest");
			BLUE_DIAMOND_LEGINGS = new BlueDiamondArmor("blueDiamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("blueDiamondLegings");
			BLUE_DIAMOND_BOOTS = new BlueDiamondArmor("blueDiamond", BLUE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("blueDiamondBoots");

			RED_DIAMOND_HELMET = new RedDiamondArmor("redDiamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("redDiamondHelmet");
			RED_DIAMOND_CHEST = new RedDiamondArmor("redDiamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("redDiamondChest");
			RED_DIAMOND_LEGINGS = new RedDiamondArmor("redDiamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("redDiamondLegings");
			RED_DIAMOND_BOOTS = new RedDiamondArmor("redDiamond", RED_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("redDiamondBoots");

			PURPLE_DIAMOND_HELMET = new PurpleDiamondArmor("purpleDiamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("purpleDiamondHelmet");
			PURPLE_DIAMOND_CHEST = new PurpleDiamondArmor("purpleDiamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("purpleDiamondChest");
			PURPLE_DIAMOND_LEGINGS = new PurpleDiamondArmor("purpleDiamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("purpleDiamondLegings");
			PURPLE_DIAMOND_BOOTS = new PurpleDiamondArmor("purpleDiamond", PURPLE_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("purpleDiamondBoots");

			YELLOW_DIAMOND_HELMET = new YellowDiamondArmor("yellowDiamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("yellowDiamondHelmet");
			YELLOW_DIAMOND_CHEST = new YellowDiamondArmor("yellowDiamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("yellowDiamondChest");
			YELLOW_DIAMOND_LEGINGS = new YellowDiamondArmor("yellowDiamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("yellowDiamondLegings");
			YELLOW_DIAMOND_BOOTS = new YellowDiamondArmor("yellowDiamond", YELLOW_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("yellowDiamondBoots");

			GREEN_DIAMOND_HELMET = new GreenDiamondArmor("greenDiamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("greenDiamondHelmet");
			GREEN_DIAMOND_CHEST = new GreenDiamondArmor("greenDiamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("greenDiamondChest");
			GREEN_DIAMOND_LEGINGS = new GreenDiamondArmor("greenDiamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("greenDiamondLegings");
			GREEN_DIAMOND_BOOTS = new GreenDiamondArmor("greenDiamond", GREEM_DIAMOND_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("greenDiamondBoots");
		}
		if (Config.PRESSURE || Config.RADIATION) {
			TIER_1_SPACE_SUIT_HELMET = new Tier1SpaceSuitArmor("tier1SpaceSuit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier1SpaceSuitHelmet");
			TIER_1_SPACE_SUIT_CHEST = new Tier1SpaceSuitArmor("tier1SpaceSuit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier1SpaceSuitChest");
			TIER_1_SPACE_SUIT_LEGINGS = new Tier1SpaceSuitArmor("tier1SpaceSuit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier1SpaceSuitLegings");
			TIER_1_SPACE_SUIT_BOOTS = new Tier1SpaceSuitArmor("tier1SpaceSuit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier1SpaceSuitBoots");
			TIER_1_SPACE_SUIT_GRAVITY_BOOTS = new Tier1SpaceSuitArmor("tier1SpaceSuit", TIER_1_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier1SpaceSuitGravityBoots");

			TIER_2_SPACE_SUIT_HELMET = new Tier2SpaceSuitArmor("tier1SpaceSuit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier2SpaceSuitHelmet");
			TIER_2_SPACE_SUIT_CHEST = new Tier2SpaceSuitArmor("tier1SpaceSuit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier2SpaceSuitChest");
			TIER_2_SPACE_SUIT_LEGINGS = new Tier2SpaceSuitArmor("tier1SpaceSuit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier2SpaceSuitLegings");
			TIER_2_SPACE_SUIT_BOOTS = new Tier2SpaceSuitArmor("tier1SpaceSuit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier2SpaceSuitBoots");
			TIER_2_SPACE_SUIT_GRAVITY_BOOTS = new Tier2SpaceSuitArmor("tier2SpaceSuit", TIER_2_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier2SpaceSuitGravityBoots");

			TIER_3_SPACE_SUIT_HELMET = new Tier3SpaceSuitArmor("tier1SpaceSuit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier3SpaceSuitHelmet");
			TIER_3_SPACE_SUIT_CHEST = new Tier3SpaceSuitArmor("tier1SpaceSuit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier3SpaceSuitChest");
			TIER_3_SPACE_SUIT_LEGINGS = new Tier3SpaceSuitArmor("tier1SpaceSuit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier3SpaceSuitLegings");
			TIER_3_SPACE_SUIT_BOOTS = new Tier3SpaceSuitArmor("tier1SpaceSuit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier3SpaceSuitBoots");
			TIER_3_SPACE_SUIT_GRAVITY_BOOTS = new Tier3SpaceSuitArmor("tier1SpaceSuit", TIER_3_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier3SpaceSuitGravityBoots");

			TIER_4_SPACE_SUIT_HELMET = new Tier4SpaceSuitArmor("tier1SpaceSuit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier4SpaceSuitHelmet");
			TIER_4_SPACE_SUIT_CHEST = new Tier4SpaceSuitArmor("tier1SpaceSuit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier4SpaceSuitChest");
			TIER_4_SPACE_SUIT_LEGINGS = new Tier4SpaceSuitArmor("tier1SpaceSuit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier4SpaceSuitLegings");
			TIER_4_SPACE_SUIT_BOOTS = new Tier4SpaceSuitArmor("tier1SpaceSuit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier4SpaceSuitBoots");
			TIER_4_SPACE_SUIT_GRAVITY_BOOTS = new Tier4SpaceSuitArmor("tier4SpaceSuit", TIER_4_SPACE_SUIT_ARMOR_MATERIAL, EntityEquipmentSlot.FEET).setUnlocalizedName("tier4SpaceSuitGravityBoots");
		}
	}

	private static void registerArmor() {
		if (Config.ITEMS_MERCURY && Config.MERCURY) {
			RegisterHelper.registerItem(MERCURY_HELMET, "mercuryHelmet");
			RegisterHelper.registerItem(MERCURY_CHEST, "mercuryChest");
			RegisterHelper.registerItem(MERCURY_LEGINGS, "mercuryLegings");
			RegisterHelper.registerItem(MERCURY_BOOTS, "mercuryBoots");
		}
		if (Config.ITEMS_CARBON && Config.MERCURY) {
			RegisterHelper.registerItem(CARBON_HELMET, "carbonHelmet");
			RegisterHelper.registerItem(CARBON_CHEST, "carbonChest");
			RegisterHelper.registerItem(CARBON_LEGINGS, "carbonLegings");
			RegisterHelper.registerItem(CARBON_BOOTS, "carbonBoots");
		}
		if (Config.ITEMS_URANIUM && Config.CERES) {
			RegisterHelper.registerItem(URANIUM_HELMET, "uraniumHelmet");
			RegisterHelper.registerItem(URANIUM_CHEST, "uraniumChest");
			RegisterHelper.registerItem(URANIUM_LEGINGS, "uraniumLegings");
			RegisterHelper.registerItem(URANIUM_BOOTS, "uraniumBoots");
		}
		if (Config.JUPITER) {
			if (Config.ITEMS_PALLADIUM) {
				RegisterHelper.registerItem(PALLASIUM_HELMET, "palladiumHelmet");
				RegisterHelper.registerItem(PALLASIUM_CHEST, "palladiumChest");
				RegisterHelper.registerItem(PALLASIUM_LEGINGS, "palladiumLegings");
				RegisterHelper.registerItem(PALLASIUM_BOOTS, "palladiumBoots");
			}
			if (Config.ITEMS_GEM_RED) {
				RegisterHelper.registerItem(RED_GEM_HELMET, "redGemHelmet");
				RegisterHelper.registerItem(RED_GEM_CHEST, "redGemChest");
				RegisterHelper.registerItem(RED_GEM_LEGINGS, "redGemLegings");
				RegisterHelper.registerItem(RED_GEM_BOOTS, "redGemBoots");
			}
		}
		if (Config.ITEMS_MAGNESIUM && Config.SATURN) {
			RegisterHelper.registerItem(MAGNESIUM_HELMET, "magnesiumHelmet");
			RegisterHelper.registerItem(MAGNESIUM_CHEST, "magnesiumChest");
			RegisterHelper.registerItem(MAGNESIUM_LEGINGS, "magnesiumLegings");
			RegisterHelper.registerItem(MAGNESIUM_BOOTS, "magnesiumBoots");
		}
		if (Config.URANUS) {
			if (Config.ITEMS_CRYSTAL) {
				RegisterHelper.registerItem(CRYSTAL_HELMET, "crystalHelmet");
				RegisterHelper.registerItem(CRYSTAL_CHEST, "crystalChest");
				RegisterHelper.registerItem(CRYSTAL_LEGINGS, "crystalLegings");
				RegisterHelper.registerItem(CRYSTAL_BOOTS, "crystalBoots");
			}
			if (Config.ITEMS_GEM_WHITE) {
				RegisterHelper.registerItem(WHITE_GEM_HELMET, "whiteGemHelmet");
				RegisterHelper.registerItem(WHITE_GEM_CHEST, "whiteGemChest");
				RegisterHelper.registerItem(WHITE_GEM_LEGINGS, "whiteGemLegings");
				RegisterHelper.registerItem(WHITE_GEM_BOOTS, "whiteGemBoots");
			}
		}
		if (Config.NEPTUNE) {
			if (Config.ITEMS_ZINC) {
				RegisterHelper.registerItem(ZINC_HELMET, "zincHelmet");
				RegisterHelper.registerItem(ZINC_CHEST, "zincChest");
				RegisterHelper.registerItem(ZINC_LEGINGS, "zincLegings");
				RegisterHelper.registerItem(ZINC_BOOTS, "zincBoots");
			}
			if (Config.ITEMS_GEM_BLUE) {
				RegisterHelper.registerItem(BLUE_GEM_HELMET, "blueGemHelmet");
				RegisterHelper.registerItem(BLUE_GEM_CHEST, "blueGemChest");
				RegisterHelper.registerItem(BLUE_GEM_LEGINGS, "blueGemLegings");
				RegisterHelper.registerItem(BLUE_GEM_BOOTS, "blueGemBoots");
			}
		}
		if (Config.ITEMS_TUNGSTEN && Config.PLUTO) {
			RegisterHelper.registerItem(TUNGSTEN_HELMET, "tungstenHelmet");
			RegisterHelper.registerItem(TUNGSTEN_CHEST, "tungstenChest");
			RegisterHelper.registerItem(TUNGSTEN_LEGINGS, "tungstenLegings");
			RegisterHelper.registerItem(TUNGSTEN_BOOTS, "tungstenBoots");
		}
		if (Config.KEPLER22B && Config.ITEMS_KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			RegisterHelper.registerItem(BLUE_DIAMOND_HELMET, "blueDiamondHelmet");
			RegisterHelper.registerItem(BLUE_DIAMOND_CHEST, "blueDiamondChest");
			RegisterHelper.registerItem(BLUE_DIAMOND_LEGINGS, "blueDiamondLegings");
			RegisterHelper.registerItem(BLUE_DIAMOND_BOOTS, "blueDiamondBoots");

			RegisterHelper.registerItem(RED_DIAMOND_HELMET, "redDiamondHelmet");
			RegisterHelper.registerItem(RED_DIAMOND_CHEST, "redDiamondChest");
			RegisterHelper.registerItem(RED_DIAMOND_LEGINGS, "redDiamondLegings");
			RegisterHelper.registerItem(RED_DIAMOND_BOOTS, "redDiamondBoots");

			RegisterHelper.registerItem(PURPLE_DIAMOND_HELMET, "purpleDiamondHelmet");
			RegisterHelper.registerItem(PURPLE_DIAMOND_CHEST, "purpleDiamondChest");
			RegisterHelper.registerItem(PURPLE_DIAMOND_LEGINGS, "purpleDiamondLegings");
			RegisterHelper.registerItem(PURPLE_DIAMOND_BOOTS, "purpleDiamondBoots");

			RegisterHelper.registerItem(YELLOW_DIAMOND_HELMET, "yellowDiamondHelmet");
			RegisterHelper.registerItem(YELLOW_DIAMOND_CHEST, "yellowDiamondChest");
			RegisterHelper.registerItem(YELLOW_DIAMOND_LEGINGS, "yellowDiamondLegings");
			RegisterHelper.registerItem(YELLOW_DIAMOND_BOOTS, "yellowDiamondBoots");

			RegisterHelper.registerItem(GREEN_DIAMOND_HELMET, "greenDiamondHelmet");
			RegisterHelper.registerItem(GREEN_DIAMOND_CHEST, "greenDiamondChest");
			RegisterHelper.registerItem(GREEN_DIAMOND_LEGINGS, "greenDiamondLegings");
			RegisterHelper.registerItem(GREEN_DIAMOND_BOOTS, "greenDiamondBoots");
		}
		if (Config.PRESSURE || Config.RADIATION) {
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_HELMET, "tier1SpaceSuitHelmet");
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_CHEST, "tier1SpaceSuitChest");
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_LEGINGS, "tier1SpaceSuitLegings");
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_BOOTS, "tier1SpaceSuitBoots");
			RegisterHelper.registerItem(TIER_1_SPACE_SUIT_GRAVITY_BOOTS, "tier1SpaceSuitGravityBoots");

			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_HELMET, "tier2SpaceSuitHelmet");
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_CHEST, "tier2SpaceSuitChest");
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_LEGINGS, "tier2SpaceSuitLegings");
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_BOOTS, "tier2SpaceSuitBoots");
			RegisterHelper.registerItem(TIER_2_SPACE_SUIT_GRAVITY_BOOTS, "tier2SpaceSuitGravityBoots");

			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_HELMET, "tier3SpaceSuitHelmet");
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_CHEST, "tier3SpaceSuitChest");
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_LEGINGS, "tier3SpaceSuitLegings");
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_BOOTS, "tier3SpaceSuitBoots");
			RegisterHelper.registerItem(TIER_3_SPACE_SUIT_GRAVITY_BOOTS, "tier3SpaceSuitGravityBoots");

			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_HELMET, "tier4SpaceSuitHelmet");
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_CHEST, "tier4SpaceSuitChest");
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_LEGINGS, "tier4SpaceSuitLegings");
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_BOOTS, "tier4SpaceSuitBoots");
			RegisterHelper.registerItem(TIER_4_SPACE_SUIT_GRAVITY_BOOTS, "tier4SpaceSuitGravityBoots");
		}
	}
}