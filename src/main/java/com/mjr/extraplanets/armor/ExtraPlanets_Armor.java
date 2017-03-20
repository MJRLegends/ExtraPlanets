package com.mjr.extraplanets.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;

public class ExtraPlanets_Armor {
	private static ArmorMaterial carbon_ArmorMaterial = EnumHelper.addArmorMaterial("Carbon_Armor", "Test", 26, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial palladium_ArmorMaterial = EnumHelper.addArmorMaterial("Palladium_Armor", "Test", 26, new int[] { 3, 8, 6, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial magnesium_ArmorMaterial = EnumHelper.addArmorMaterial("Magnesium_Armor", "Test", 30, new int[] { 3, 8, 6, 3 }, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial crystal_ArmorMaterial = EnumHelper.addArmorMaterial("Crystal_Armor", "Test", 40, new int[] { 3, 8, 6, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial mercury_ArmorMaterial = EnumHelper.addArmorMaterial("Mercury_Armor", "Test", 15, new int[] { 3, 8, 6, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial uranium_ArmorMaterial = EnumHelper.addArmorMaterial("Uranium_Armor", "Test", 20, new int[] { 3, 8, 6, 3 }, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial zinc_ArmorMaterial = EnumHelper.addArmorMaterial("Zinc_Armor", "Test", 45, new int[] { 3, 8, 6, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial tungsten_ArmorMaterial = EnumHelper.addArmorMaterial("Tungsten_Armor", "Test", 50, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial redGem_ArmorMaterial = EnumHelper.addArmorMaterial("Red_Gem_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial whiteGem_ArmorMaterial = EnumHelper.addArmorMaterial("White_Gem_Armor", "Test", 40, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial blueGem_ArmorMaterial = EnumHelper.addArmorMaterial("Blue_Gem_Armor", "Test", 45, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial blueDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Blue_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial redDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Red_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial purpleDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Purple_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial yellowDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Yellow_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial greenDiamond_ArmorMaterial = EnumHelper.addArmorMaterial("Green_Diamond_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	private static ArmorMaterial tier1SpaceSuit_ArmorMaterial = EnumHelper.addArmorMaterial("Tier1_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial tier2SpaceSuit_ArmorMaterial = EnumHelper.addArmorMaterial("Tier2_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial tier3SpaceSuit_ArmorMaterial = EnumHelper.addArmorMaterial("Tier3_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	private static ArmorMaterial tier4SpaceSuit_ArmorMaterial = EnumHelper.addArmorMaterial("Tier4_SpaceSuit_Armor", "Test", 28, new int[] { 3, 8, 6, 3 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

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

	public static Item tier1SpaceSuitHelmet;
	public static Item tier1SpaceSuitChest;
	public static Item tier1SpaceSuitLegings;
	public static Item tier1SpaceSuitBoots;
	public static Item tier1SpaceSuitGravityBoots;

	public static Item tier2SpaceSuitHelmet;
	public static Item tier2SpaceSuitChest;
	public static Item tier2SpaceSuitLegings;
	public static Item tier2SpaceSuitBoots;
	public static Item tier2SpaceSuitGravityBoots;

	public static Item tier3SpaceSuitHelmet;
	public static Item tier3SpaceSuitChest;
	public static Item tier3SpaceSuitLegings;
	public static Item tier3SpaceSuitBoots;
	public static Item tier3SpaceSuitGravityBoots;

	public static Item tier4SpaceSuitHelmet;
	public static Item tier4SpaceSuitChest;
	public static Item tier4SpaceSuitLegings;
	public static Item tier4SpaceSuitBoots;
	public static Item tier4SpaceSuitGravityBoots;

	public static void init() {
		initializeArmor();
		registerArmor();
	}

	private static void initializeArmor() {
		if (Config.mercuryItems && Config.mercury) {
			mercuryHelmet = new MercuryArmor("mercury", mercury_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("mercuryHelmet");
			mercuryChest = new MercuryArmor("mercury", mercury_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("mercuryChest");
			mercuryLegings = new MercuryArmor("mercury", mercury_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("mercuryLegings");
			mercuryBoots = new MercuryArmor("mercury", mercury_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("mercuryBoots");
		}
		if (Config.carbonItems && Config.mercury) {
			carbonHelmet = new CarbonArmor("carbon", carbon_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("carbonHelmet");
			carbonChest = new CarbonArmor("carbon", carbon_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("carbonChest");
			carbonLegings = new CarbonArmor("carbon", carbon_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("carbonLegings");
			carbonBoots = new CarbonArmor("carbon", carbon_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("carbonBoots");
		}
		if (Config.uraniumItems && Config.ceres) {
			uraniumHelmet = new UraniumArmor("uranium", uranium_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("uraniumHelmet");
			uraniumChest = new UraniumArmor("uranium", uranium_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("uraniumChest");
			uraniumLegings = new UraniumArmor("uranium", uranium_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("uraniumLegings");
			uraniumBoots = new UraniumArmor("uranium", uranium_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("uraniumBoots");
		}
		if (Config.jupiter) {
			if (Config.palladiumItems) {
				palladiumHelmet = new PalladiumArmor("palladium", palladium_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("palladiumHelmet");
				palladiumChest = new PalladiumArmor("palladium", palladium_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("palladiumChest");
				palladiumLegings = new PalladiumArmor("palladium", palladium_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("palladiumLegings");
				palladiumBoots = new PalladiumArmor("palladium", palladium_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("palladiumBoots");
			}
			if (Config.redGemItems) {
				redGemHelmet = new RedGemArmor("redGem", redGem_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("redGemHelmet");
				redGemChest = new RedGemArmor("redGem", redGem_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("redGemChest");
				redGemLegings = new RedGemArmor("redGem", redGem_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("redGemLegings");
				redGemBoots = new RedGemArmor("redGem", redGem_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("redGemBoots");
			}
		}
		if (Config.magnesiumItems && Config.saturn) {
			magnesiumHelmet = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("magnesiumHelmet");
			magnesiumChest = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("magnesiumChest");
			magnesiumLegings = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("magnesiumLegings");
			magnesiumBoots = new MagnesiumArmor("magnesium", magnesium_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("magnesiumBoots");
		}
		if (Config.crystalItems && Config.uranus) {
			crystalHelmet = new CrystalArmor("crystal", crystal_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("crystalHelmet");
			crystalChest = new CrystalArmor("crystal", crystal_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("crystalChest");
			crystalLegings = new CrystalArmor("crystal", crystal_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("crystalLegings");
			crystalBoots = new CrystalArmor("crystal", crystal_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("crystalBoots");
			if (Config.whiteGemItems) {
				whiteGemHelmet = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("whiteGemHelmet");
				whiteGemChest = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("whiteGemChest");
				whiteGemLegings = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("whiteGemLegings");
				whiteGemBoots = new WhiteGemArmor("whiteGem", whiteGem_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("whiteGemBoots");
			}
		}
		if (Config.zincItems && Config.neptune) {
			zincHelmet = new ZincArmor("zinc", zinc_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("zincHelmet");
			zincChest = new ZincArmor("zinc", zinc_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("zincChest");
			zincLegings = new ZincArmor("zinc", zinc_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("zincLegings");
			zincBoots = new ZincArmor("zinc", zinc_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("zincBoots");
			if (Config.blueGemItems) {
				blueGemHelmet = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("blueGemHelmet");
				blueGemChest = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("blueGemChest");
				blueGemLegings = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("blueGemLegings");
				blueGemBoots = new BlueGemArmor("blueGem", blueGem_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("blueGemBoots");
			}
		}
		if (Config.tungstenItems && Config.pluto) {
			tungstenHelmet = new TungstenArmor("tungsten", tungsten_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("tungstenHelmet");
			tungstenChest = new TungstenArmor("tungsten", tungsten_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("tungstenChest");
			tungstenLegings = new TungstenArmor("tungsten", tungsten_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("tungstenLegings");
			tungstenBoots = new TungstenArmor("tungsten", tungsten_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tungstenBoots");
		}
		if (Config.kepler22b && Config.kepler22bItems && Config.keplerSolarSystems) {
			blueDiamondHelmet = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("blueDiamondHelmet");
			blueDiamondChest = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("blueDiamondChest");
			blueDiamondLegings = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("blueDiamondLegings");
			blueDiamondBoots = new BlueDiamondArmor("blueDiamond", blueDiamond_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("blueDiamondBoots");

			redDiamondHelmet = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("redDiamondHelmet");
			redDiamondChest = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("redDiamondChest");
			redDiamondLegings = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("redDiamondLegings");
			redDiamondBoots = new RedDiamondArmor("redDiamond", redDiamond_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("redDiamondBoots");

			purpleDiamondHelmet = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("purpleDiamondHelmet");
			purpleDiamondChest = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("purpleDiamondChest");
			purpleDiamondLegings = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("purpleDiamondLegings");
			purpleDiamondBoots = new PurpleDiamondArmor("purpleDiamond", purpleDiamond_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("purpleDiamondBoots");

			yellowDiamondHelmet = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("yellowDiamondHelmet");
			yellowDiamondChest = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("yellowDiamondChest");
			yellowDiamondLegings = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("yellowDiamondLegings");
			yellowDiamondBoots = new YellowDiamondArmor("yellowDiamond", yellowDiamond_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("yellowDiamondBoots");

			greenDiamondHelmet = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("greenDiamondHelmet");
			greenDiamondChest = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("greenDiamondChest");
			greenDiamondLegings = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("greenDiamondLegings");
			greenDiamondBoots = new GreenDiamondArmor("greenDiamond", greenDiamond_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("greenDiamondBoots");
		}
		if(Config.pressure || Config.radiation){
			tier1SpaceSuitHelmet = new Tier1SpaceSuitArmor("tier1SpaceSuit", tier1SpaceSuit_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier1SpaceSuitHelmet");
			tier1SpaceSuitChest = new Tier1SpaceSuitArmor("tier1SpaceSuit", tier1SpaceSuit_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier1SpaceSuitChest");
			tier1SpaceSuitLegings = new Tier1SpaceSuitArmor("tier1SpaceSuit", tier1SpaceSuit_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier1SpaceSuitLegings");
			tier1SpaceSuitBoots = new Tier1SpaceSuitArmor("tier1SpaceSuit", tier1SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier1SpaceSuitBoots");
			tier1SpaceSuitGravityBoots = new Tier1SpaceSuitArmor("tier1SpaceSuit", tier1SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier1SpaceSuitGravityBoots");
	
			tier2SpaceSuitHelmet = new Tier2SpaceSuitArmor("tier1SpaceSuit", tier2SpaceSuit_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier2SpaceSuitHelmet");
			tier2SpaceSuitChest = new Tier2SpaceSuitArmor("tier1SpaceSuit", tier2SpaceSuit_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier2SpaceSuitChest");
			tier2SpaceSuitLegings = new Tier2SpaceSuitArmor("tier1SpaceSuit", tier2SpaceSuit_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier2SpaceSuitLegings");
			tier2SpaceSuitBoots = new Tier2SpaceSuitArmor("tier1SpaceSuit", tier2SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier2SpaceSuitBoots");
			tier2SpaceSuitGravityBoots = new Tier2SpaceSuitArmor("tier2SpaceSuit", tier2SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier2SpaceSuitGravityBoots");
	
			tier3SpaceSuitHelmet = new Tier3SpaceSuitArmor("tier1SpaceSuit", tier3SpaceSuit_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier3SpaceSuitHelmet");
			tier3SpaceSuitChest = new Tier3SpaceSuitArmor("tier1SpaceSuit", tier3SpaceSuit_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier3SpaceSuitChest");
			tier3SpaceSuitLegings = new Tier3SpaceSuitArmor("tier1SpaceSuit", tier3SpaceSuit_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier3SpaceSuitLegings");
			tier3SpaceSuitBoots = new Tier3SpaceSuitArmor("tier1SpaceSuit", tier3SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier3SpaceSuitBoots");
			tier3SpaceSuitGravityBoots = new Tier3SpaceSuitArmor("tier1SpaceSuit", tier3SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier3SpaceSuitGravityBoots");
	
			tier4SpaceSuitHelmet = new Tier4SpaceSuitArmor("tier1SpaceSuit", tier4SpaceSuit_ArmorMaterial, EntityEquipmentSlot.HEAD).setUnlocalizedName("tier4SpaceSuitHelmet");
			tier4SpaceSuitChest = new Tier4SpaceSuitArmor("tier1SpaceSuit", tier4SpaceSuit_ArmorMaterial, EntityEquipmentSlot.CHEST).setUnlocalizedName("tier4SpaceSuitChest");
			tier4SpaceSuitLegings = new Tier4SpaceSuitArmor("tier1SpaceSuit", tier4SpaceSuit_ArmorMaterial, EntityEquipmentSlot.LEGS).setUnlocalizedName("tier4SpaceSuitLegings");
			tier4SpaceSuitBoots = new Tier4SpaceSuitArmor("tier1SpaceSuit", tier4SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier4SpaceSuitBoots");
			tier4SpaceSuitGravityBoots = new Tier4SpaceSuitArmor("tier4SpaceSuit", tier4SpaceSuit_ArmorMaterial, EntityEquipmentSlot.FEET).setUnlocalizedName("tier4SpaceSuitGravityBoots");
		}
	}

	private static void registerArmor() {
		if (Config.mercuryItems && Config.mercury) {
			GameRegistry.registerItem(mercuryHelmet, "mercuryHelmet");
			GameRegistry.registerItem(mercuryChest, "mercuryChest");
			GameRegistry.registerItem(mercuryLegings, "mercuryLegings");
			GameRegistry.registerItem(mercuryBoots, "mercuryBoots");
		}
		if (Config.carbonItems && Config.mercury) {
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
		if(Config.pressure || Config.radiation){
			GameRegistry.registerItem(tier1SpaceSuitHelmet, "tier1SpaceSuitHelmet");
			GameRegistry.registerItem(tier1SpaceSuitChest, "tier1SpaceSuitChest");
			GameRegistry.registerItem(tier1SpaceSuitLegings, "tier1SpaceSuitLegings");
			GameRegistry.registerItem(tier1SpaceSuitBoots, "tier1SpaceSuitBoots");
			GameRegistry.registerItem(tier1SpaceSuitGravityBoots, "tier1SpaceSuitGravityBoots");
	
			GameRegistry.registerItem(tier2SpaceSuitHelmet, "tier2SpaceSuitHelmet");
			GameRegistry.registerItem(tier2SpaceSuitChest, "tier2SpaceSuitChest");
			GameRegistry.registerItem(tier2SpaceSuitLegings, "tier2SpaceSuitLegings");
			GameRegistry.registerItem(tier2SpaceSuitBoots, "tier2SpaceSuitBoots");
			GameRegistry.registerItem(tier2SpaceSuitGravityBoots, "tier2SpaceSuitGravityBoots");
	
			GameRegistry.registerItem(tier3SpaceSuitHelmet, "tier3SpaceSuitHelmet");
			GameRegistry.registerItem(tier3SpaceSuitChest, "tier3SpaceSuitChest");
			GameRegistry.registerItem(tier3SpaceSuitLegings, "tier3SpaceSuitLegings");
			GameRegistry.registerItem(tier3SpaceSuitBoots, "tier3SpaceSuitBoots");
			GameRegistry.registerItem(tier3SpaceSuitGravityBoots, "tier3SpaceSuitGravityBoots");
	
			GameRegistry.registerItem(tier4SpaceSuitHelmet, "tier4SpaceSuitHelmet");
			GameRegistry.registerItem(tier4SpaceSuitChest, "tier4SpaceSuitChest");
			GameRegistry.registerItem(tier4SpaceSuitLegings, "tier4SpaceSuitLegings");
			GameRegistry.registerItem(tier4SpaceSuitBoots, "tier4SpaceSuitBoots");
			GameRegistry.registerItem(tier4SpaceSuitGravityBoots, "tier4SpaceSuitGravityBoots");
		}
	}
}