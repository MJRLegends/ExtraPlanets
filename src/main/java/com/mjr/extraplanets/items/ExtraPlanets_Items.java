package com.mjr.extraplanets.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.items.keys.ItemKeyT10;
import com.mjr.extraplanets.items.keys.ItemKeyT4;
import com.mjr.extraplanets.items.keys.ItemKeyT5;
import com.mjr.extraplanets.items.keys.ItemKeyT6;
import com.mjr.extraplanets.items.keys.ItemKeyT7;
import com.mjr.extraplanets.items.keys.ItemKeyT8;
import com.mjr.extraplanets.items.keys.ItemKeyT9;
import com.mjr.extraplanets.items.keys.MPVersions.ItemKeyT4Saturn;
import com.mjr.extraplanets.items.keys.MPVersions.ItemKeyT4Uranus;
import com.mjr.extraplanets.items.keys.MPVersions.ItemKeyT5Neptune;
import com.mjr.extraplanets.items.keys.MPVersions.ItemKeyT6Eris;
import com.mjr.extraplanets.items.noseCones.Tier10NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier4NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier5NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier6NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier7NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier8NoseCone;
import com.mjr.extraplanets.items.noseCones.Tier9NoseCone;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier10Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier11Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier4Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier5Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier6Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier7Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier8Items;
import com.mjr.extraplanets.items.planetAndMoonItems.ItemTier9Items;
import com.mjr.extraplanets.items.planetAndMoonItems.MPVersions.ItemTier10ItemsMP;
import com.mjr.extraplanets.items.planetAndMoonItems.MPVersions.ItemTier6ItemsMP;
import com.mjr.extraplanets.items.planetAndMoonItems.MPVersions.ItemTier7ItemsMP;
import com.mjr.extraplanets.items.planetAndMoonItems.MPVersions.ItemTier8ItemsMP;
import com.mjr.extraplanets.items.rockets.Tier10Rocket;
import com.mjr.extraplanets.items.rockets.Tier4Rocket;
import com.mjr.extraplanets.items.rockets.Tier5Rocket;
import com.mjr.extraplanets.items.rockets.Tier6Rocket;
import com.mjr.extraplanets.items.rockets.Tier7Rocket;
import com.mjr.extraplanets.items.rockets.Tier8Rocket;
import com.mjr.extraplanets.items.rockets.Tier9Rocket;
import com.mjr.extraplanets.items.schematics.SchematicMarsRover;
import com.mjr.extraplanets.items.schematics.SchematicTier10;
import com.mjr.extraplanets.items.schematics.SchematicTier4;
import com.mjr.extraplanets.items.schematics.SchematicTier5;
import com.mjr.extraplanets.items.schematics.SchematicTier6;
import com.mjr.extraplanets.items.schematics.SchematicTier7;
import com.mjr.extraplanets.items.schematics.SchematicTier8;
import com.mjr.extraplanets.items.schematics.SchematicTier9;
import com.mjr.extraplanets.items.schematics.SchematicVenusRover;
import com.mjr.extraplanets.items.thermalPadding.ItemThermalCloth;
import com.mjr.extraplanets.items.thermalPadding.ItemTier2ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier3ThermalPadding;
import com.mjr.extraplanets.items.thermalPadding.ItemTier4ThermalPadding;
import com.mjr.extraplanets.items.vehicles.ItemMarsRover;
import com.mjr.extraplanets.items.vehicles.ItemVenusRover;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Items {
	public static Item tier4Rocket;
	public static Item tier5Rocket;
	public static Item tier6Rocket;
	public static Item tier7Rocket;
	public static Item tier8Rocket;
	public static Item tier9Rocket;
	public static Item tier10Rocket;

	public static Item schematicTier4;
	public static Item schematicTier5;
	public static Item schematicTier6;
	public static Item schematicTier7;
	public static Item schematicTier8;
	public static Item schematicTier9;
	public static Item schematicTier10;

	public static Item noseConeTier4;
	public static Item noseConeTier5;
	public static Item noseConeTier6;
	public static Item noseConeTier7;
	public static Item noseConeTier8;
	public static Item noseConeTier9;
	public static Item noseConeTier10;

	public static Item tier4Items;
	public static Item tier5Items;
	public static Item tier6Items;
	public static Item tier7Items;
	public static Item tier8Items;
	public static Item tier9Items;
	public static Item tier10Items;
	public static Item tier11Items;

	public static Item T4key;
	public static Item T5key;
	public static Item T6key;
	public static Item T7key;
	public static Item T8key;
	public static Item T9key;
	public static Item T10key;

	public static Item nickelBattery;
	public static Item zincBattery;
	public static Item mercuryBattery;
	public static Item advancedBattery;
	public static Item ultimateBattery;

	public static Item glowstone_bucket;
	public static Item magma_bucket;
	public static Item nitrogen_bucket;
	public static Item frozen_water_bucket;
	public static Item salt_bucket;

	public static Item cannedFood;
	public static Item diamondApple;
	public static Item ironApple;

	public static Item ingotUranium;
	public static Item compressedMercury;
	public static Item ingotMercury;
	public static Item ingotLead;

	public static Item thermalCloth;

	public static Item tier2ThermalPadding;
	public static Item tier3ThermalPadding;
	public static Item tier4ThermalPadding;

	public static Item wafers;

	public static Item marsRover;
	public static Item venusRover;
	public static Item electricParts;
	public static Item schematicMarsRover;
	public static Item schematicVenusRover;

	public static Item tier1EquipmentKit;
	public static Item tier2EquipmentKit;
	public static Item tier3EquipmentKit;
	public static Item tier4EquipmentKit;

	public static void init() {
		initializeItems();
		registerItems();
		registerFluidContainer();
		if (Config.oreDictionary)
			OreDictionaryRegister();
	}

	private static void initializeItems() {
		if (Config.mercury) {
			if (Config.batteries)
				mercuryBattery = new ItemBasicBattery("mercury_battery", 85000f, 2);
			ingotMercury = new ItemBasicItem("ingot_mercury");
			compressedMercury = new ItemMercuryCompressed("compressed_mercury");
		}
		if (Config.venus) {
			tier4Rocket = new Tier4Rocket("item_tier4_rocket");
			schematicTier4 = new SchematicTier4("schematic_tier4");
			noseConeTier4 = new Tier4NoseCone("nose_cone_tier4");
			tier4Items = new ItemTier4Items("tier4_items");
			T4key = new ItemKeyT4().setUnlocalizedName("T4key");
		}
		if (Config.ceres) {
			ingotUranium = new ItemBasicItem("ingot_uranium");
		}
		if (Config.jupiter) {
			if (Config.batteries)
				nickelBattery = new ItemBasicBattery("nickel_battery", 45000f, 2);
			tier5Rocket = new Tier5Rocket("item_tier5_rocket");
			schematicTier5 = new SchematicTier5("schematic_tier5");
			noseConeTier5 = new Tier5NoseCone("nose_cone_tier5");
			tier5Items = new ItemTier5Items("tier5_items");
			T5key = new ItemKeyT5().setUnlocalizedName("T5key");
		}
		if (Config.saturn) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				tier6Rocket = new Tier6Rocket("item_tier6_rocket");
				schematicTier6 = new SchematicTier6("schematic_tier6");
				noseConeTier6 = new Tier6NoseCone("nose_cone_tier6");
				tier6Items = new ItemTier6Items("tier6_items");
				T6key = new ItemKeyT6().setUnlocalizedName("T6key");
			} else {
				tier6Items = new ItemTier6ItemsMP("tier6_items");
				T6key = new ItemKeyT4Saturn().setUnlocalizedName("T6key");
			}
		}
		if (Config.uranus) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				tier7Rocket = new Tier7Rocket("item_tier7_rocket");
				schematicTier7 = new SchematicTier7("schematic_tier7");
				noseConeTier7 = new Tier7NoseCone("nose_cone_tier7");
				tier7Items = new ItemTier7Items("tier7_items");
				T7key = new ItemKeyT7().setUnlocalizedName("T7key");
			} else {
				tier7Items = new ItemTier7ItemsMP("tier7_items");
				T7key = new ItemKeyT4Uranus().setUnlocalizedName("T7key");
			}
		}
		if (Config.neptune) {
			if (Config.batteries)
				zincBattery = new ItemBasicBattery("zinc_battery", 125000f, 2);
			if (Config.morePlanetsCompatibilityAdv == false) {
				tier8Rocket = new Tier8Rocket("item_tier8_rocket");
				schematicTier8 = new SchematicTier8("schematic_tier8");
				noseConeTier8 = new Tier8NoseCone("nose_cone_tier8");
				tier8Items = new ItemTier8Items("tier8_items");
				T8key = new ItemKeyT8().setUnlocalizedName("T8key");
			} else {
				tier8Items = new ItemTier8ItemsMP("tier8_items");
				T8key = new ItemKeyT5Neptune().setUnlocalizedName("T8key");
			}
		}
		if (Config.pluto && Config.morePlanetsCompatibilityAdv == false) {
			tier9Rocket = new Tier9Rocket("item_tier9_rocket");
			schematicTier9 = new SchematicTier9("schematic_tier9");
			noseConeTier9 = new Tier9NoseCone("nose_cone_tier9");
			tier9Items = new ItemTier9Items("tier9_items");
			T9key = new ItemKeyT9().setUnlocalizedName("T9key");
		}
		if (Config.eris) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				tier10Rocket = new Tier10Rocket("item_tier10_rocket");
				schematicTier10 = new SchematicTier10("schematic_tier10");
				noseConeTier10 = new Tier10NoseCone("nose_cone_tier10");
				tier10Items = new ItemTier10Items("tier10_items");
				T10key = new ItemKeyT10().setUnlocalizedName("T10key");
			} else {
				tier10Items = new ItemTier10ItemsMP("tier10_items");
				T10key = new ItemKeyT6Eris().setUnlocalizedName("T10key");
			}
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			tier11Items = new ItemTier11Items("tier11_items");
		}
		if (Config.cannedFood)
			cannedFood = new ItemCannedFood("canned_food");
		if (Config.customApples) {
			diamondApple = new ItemAppleDiamond(8, 2.2F, false);
			ironApple = new ItemAppleIron(4, 2.2F, false);
		}
		if (Config.morePlanetsCompatibilityAdv == false && Config.thermalPaddings) {
			thermalCloth = new ItemThermalCloth("thermal_cloth");
			tier2ThermalPadding = new ItemTier2ThermalPadding("tier2_thermal_padding");
			tier3ThermalPadding = new ItemTier3ThermalPadding("tier3_thermal_padding");
			tier4ThermalPadding = new ItemTier4ThermalPadding("tier4_thermal_padding");
		}
		if (Config.batteries) {
			advancedBattery = new ItemBasicBattery("advanced_battery", 50000f, 2);
			if (Config.morePlanetsCompatibilityAdv == false)
				ultimateBattery = new ItemBasicBattery("ultimate_battery", 200000f, 2);
		}
		if (Config.marsRover)
			marsRover = new ItemMarsRover("mars_rover");
		if (Config.venusRover)
			venusRover = new ItemVenusRover("venus_rover");
		if (Config.marsRover || Config.venusRover)
			electricParts = new ItemElectricParts("electric_parts");
		if (Config.marsRover)
			schematicMarsRover = new SchematicMarsRover("schematic_mars_rover");
		if (Config.venusRover)
			schematicVenusRover = new SchematicVenusRover("schematic_venus_rover");

		wafers = new ItemWafers("wafer");
		ingotLead = new ItemBasicItem("ingot_lead");

		tier1EquipmentKit = new ItemBasicKit("tier1_kit", 1);
		tier2EquipmentKit = new ItemBasicKit("tier2_kit", 2);
		tier3EquipmentKit = new ItemBasicKit("tier3_kit", 3);
		tier4EquipmentKit = new ItemBasicKit("tier4_kit", 4);
		
		nitrogen_bucket = new ItemBasicItemBucket("bucket_nitrogen", ExtraPlanets_Fluids.nitrogen);
		frozen_water_bucket = new ItemBasicItemBucket("bucket_frozen_water", ExtraPlanets_Fluids.frozen_water);
		glowstone_bucket = new ItemBasicItemBucket("bucket_glowstone", ExtraPlanets_Fluids.glowstone);
		magma_bucket = new ItemBasicItemBucket("bucket_magma", ExtraPlanets_Fluids.magma);
		salt_bucket = new ItemBasicItemBucket("bucket_salt", ExtraPlanets_Fluids.salt);
	}

	private static void registerItems() {
		if (Config.mercury) {
			if (Config.batteries)
				GameRegistry.registerItem(mercuryBattery, "mercuryBattery");
			GameRegistry.registerItem(compressedMercury, "compressedMercury");
			GameRegistry.registerItem(ingotMercury, "ingotMercury");
		}
		if (Config.venus) {
			GameRegistry.registerItem(tier4Rocket, "itemTier4Rocket");
			GameRegistry.registerItem(schematicTier4, "schematicTier4");
			GameRegistry.registerItem(noseConeTier4, "noseConeTier4");
			GameRegistry.registerItem(tier4Items, "tier4Items");
			GameRegistry.registerItem(T4key, "T4key");
		}
		if (Config.ceres) {
			GameRegistry.registerItem(ingotUranium, "ingotUranium");
		}
		if (Config.jupiter) {
			GameRegistry.registerItem(tier5Rocket, "itemTier5Rocket");
			GameRegistry.registerItem(schematicTier5, "schematicTier5");
			GameRegistry.registerItem(noseConeTier5, "noseConeTier5");
			GameRegistry.registerItem(tier5Items, "tier5Items");
			GameRegistry.registerItem(T5key, "T5key");

			if (Config.batteries)
				GameRegistry.registerItem(nickelBattery, "nickelBattery");
		}
		if (Config.saturn) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				GameRegistry.registerItem(tier6Rocket, "itemTier6Rocket");
				GameRegistry.registerItem(schematicTier6, "schematicTier6");
				GameRegistry.registerItem(noseConeTier6, "noseConeTier6");
			}
			GameRegistry.registerItem(tier6Items, "tier6Items");
			GameRegistry.registerItem(T6key, "T6key");
		}
		if (Config.uranus) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				GameRegistry.registerItem(tier7Rocket, "itemTier7Rocket");
				GameRegistry.registerItem(schematicTier7, "schematicTier7");
				GameRegistry.registerItem(noseConeTier7, "noseConeTier7");
			}
			GameRegistry.registerItem(tier7Items, "tier7Items");
			GameRegistry.registerItem(T7key, "T7key");
		}
		if (Config.neptune) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				GameRegistry.registerItem(tier8Rocket, "itemTier8Rocket");
				GameRegistry.registerItem(schematicTier8, "schematicTier8");
				GameRegistry.registerItem(noseConeTier8, "noseConeTier8");
			}
			GameRegistry.registerItem(tier8Items, "tier8Items");
			GameRegistry.registerItem(T8key, "T8key");
			if (Config.batteries)
				GameRegistry.registerItem(zincBattery, "zincBattery");
		}
		if (Config.pluto) {
			GameRegistry.registerItem(tier9Rocket, "itemTier9Rocket");
			GameRegistry.registerItem(schematicTier9, "schematicTier9");
			GameRegistry.registerItem(noseConeTier9, "noseConeTier9");
			GameRegistry.registerItem(tier9Items, "tier9Items");
			GameRegistry.registerItem(T9key, "T9key");
		}
		if (Config.eris) {
			if (Config.morePlanetsCompatibilityAdv == false) {
				GameRegistry.registerItem(tier10Rocket, "itemTier10Rocket");
				GameRegistry.registerItem(schematicTier10, "schematicTier10");
				GameRegistry.registerItem(noseConeTier10, "noseConeTier10");
			}
			GameRegistry.registerItem(T10key, "T10key");
			GameRegistry.registerItem(tier10Items, "tier10Items");
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			GameRegistry.registerItem(tier11Items, "tier11Items");
		}
		if (Config.cannedFood)
			GameRegistry.registerItem(cannedFood, "cannedFood");
		if (Config.customApples) {
			GameRegistry.registerItem(diamondApple, "diamondApple");
			GameRegistry.registerItem(ironApple, "ironApple");
		}

		if (Config.morePlanetsCompatibilityAdv == false && Config.thermalPaddings) {
			GameRegistry.registerItem(thermalCloth, "item.thermalCloth");
			GameRegistry.registerItem(tier2ThermalPadding, "item.tier2ThermalPadding");
			GameRegistry.registerItem(tier3ThermalPadding, "item.tier3ThermalPadding");
			GameRegistry.registerItem(tier4ThermalPadding, "item.tier4ThermalPadding");
		}
		if (Config.batteries) {
			GameRegistry.registerItem(advancedBattery, "item.advancedBattery");
			if (Config.morePlanetsCompatibilityAdv == false)
				GameRegistry.registerItem(ultimateBattery, "item.ultimateBattery");
		}
		if (Config.marsRover)
			GameRegistry.registerItem(marsRover, "item.marsRover");
		if (Config.venusRover)
			GameRegistry.registerItem(venusRover, "item.venusRover");
		if (Config.marsRover || Config.venusRover)
			GameRegistry.registerItem(electricParts, "item.electricParts");
		if (Config.marsRover)
			GameRegistry.registerItem(schematicMarsRover, "item.schematicMarsRover");
		if (Config.venusRover)
			GameRegistry.registerItem(schematicVenusRover, "item.schematicVenusRover");

		GameRegistry.registerItem(wafers, wafers.getUnlocalizedName());
		GameRegistry.registerItem(ingotLead, "item.ingotLead");

		GameRegistry.registerItem(tier1EquipmentKit, tier1EquipmentKit.getUnlocalizedName());
		GameRegistry.registerItem(tier2EquipmentKit, tier2EquipmentKit.getUnlocalizedName());
		GameRegistry.registerItem(tier3EquipmentKit, tier3EquipmentKit.getUnlocalizedName());
		GameRegistry.registerItem(tier4EquipmentKit, tier4EquipmentKit.getUnlocalizedName());
		
		GameRegistry.registerItem(nitrogen_bucket, "bucket_nitrogen");
		GameRegistry.registerItem(frozen_water_bucket, "bucket_frozen_water");
		GameRegistry.registerItem(glowstone_bucket, "bucket_glowstone");
		GameRegistry.registerItem(magma_bucket, "bucket_magma");
		GameRegistry.registerItem(salt_bucket, "bucket_salt");
	}

	private static void registerFluidContainer() {
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.glowstone_fluid, new ItemStack(glowstone_bucket, 1, 0), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.magma_fluid, new ItemStack(magma_bucket, 1, 0), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.nitrogen_fluid, new ItemStack(nitrogen_bucket, 1, 0), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.frozen_water_fluid, new ItemStack(frozen_water_bucket, 1, 0), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(ExtraPlanets_Fluids.salt_fluid, new ItemStack(salt_bucket, 1, 0), new ItemStack(Items.bucket));
	}

	public static void OreDictionaryRegister() {
		if (Config.mercury)
			OreDictionary.registerOre("ingotMercury", new ItemStack(ingotMercury));
		if (Config.venus)
			OreDictionary.registerOre("ingotCarbon", new ItemStack(tier4Items, 1, 5));
		if (Config.ceres)
			OreDictionary.registerOre("ingotUranium", new ItemStack(ingotUranium));
		if (Config.jupiter) {
			OreDictionary.registerOre("ingotPalladium", new ItemStack(tier5Items, 1, 5));
			OreDictionary.registerOre("ingotNickel", new ItemStack(tier5Items, 1, 7));
			OreDictionary.registerOre("gemRedGem", new ItemStack(tier5Items, 1, 8));
		}
		if (Config.saturn)
			OreDictionary.registerOre("ingotMagnesium", new ItemStack(tier6Items, 1, 5));
		if (Config.uranus) {
			OreDictionary.registerOre("ingotCrystal", new ItemStack(tier7Items, 1, 5));
			OreDictionary.registerOre("gemWhiteGem", new ItemStack(tier7Items, 1, 7));
		}
		if (Config.neptune) {
			OreDictionary.registerOre("ingotZinc", new ItemStack(tier8Items, 1, 5));
			OreDictionary.registerOre("gemBlueGem", new ItemStack(tier8Items, 1, 6));
		}
		if (Config.pluto)
			OreDictionary.registerOre("ingotTungsten", new ItemStack(tier9Items, 1, 5));
		if (Config.eris)
			OreDictionary.registerOre("ingotDarkIron", new ItemStack(tier10Items, 1, 5));
		if (Config.kepler22b && Config.keplerSolarSystems) {
			OreDictionary.registerOre("gemBlueDiamond", new ItemStack(tier11Items, 1, 0));
			OreDictionary.registerOre("gemRedDiamond", new ItemStack(tier11Items, 1, 1));
			OreDictionary.registerOre("gemPurpleDiamond", new ItemStack(tier11Items, 1, 2));
			OreDictionary.registerOre("gemYellowDiamond", new ItemStack(tier11Items, 1, 3));
			OreDictionary.registerOre("gemGreenDiamond", new ItemStack(tier11Items, 1, 4));
			OreDictionary.registerOre("stickWood", new ItemStack(tier11Items, 1, 5));
			OreDictionary.registerOre("stickWood", new ItemStack(tier11Items, 1, 6));
			OreDictionary.registerOre("stickWood", new ItemStack(tier11Items, 1, 7));
			OreDictionary.registerOre("stickWood", new ItemStack(tier11Items, 1, 8));
			OreDictionary.registerOre("stickWood", new ItemStack(tier11Items, 1, 9));
			OreDictionary.registerOre("stickWood", new ItemStack(tier11Items, 1, 10));
		}
		OreDictionary.registerOre("ingotLead", new ItemStack(ingotLead));
	}
}
