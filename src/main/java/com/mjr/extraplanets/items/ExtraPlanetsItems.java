package com.mjr.extraplanets.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanetsFluids;
import com.mjr.extraplanets.items.Tier4.CarbonCompressed;
import com.mjr.extraplanets.items.Tier4.CarbonIngot;
import com.mjr.extraplanets.items.Tier4.ItemKeyT4;
import com.mjr.extraplanets.items.Tier4.SchematicTier4;
import com.mjr.extraplanets.items.Tier4.Tier4Engine;
import com.mjr.extraplanets.items.Tier4.Tier4Fin;
import com.mjr.extraplanets.items.Tier4.Tier4HeavyDutyPlate;
import com.mjr.extraplanets.items.Tier4.Tier4NoseCone;
import com.mjr.extraplanets.items.Tier4.Tier4Rocket;
import com.mjr.extraplanets.items.Tier5.ItemKeyT5;
import com.mjr.extraplanets.items.Tier5.PalladiumCompressed;
import com.mjr.extraplanets.items.Tier5.PalladiumIngot;
import com.mjr.extraplanets.items.Tier5.SchematicTier5;
import com.mjr.extraplanets.items.Tier5.Tier5Engine;
import com.mjr.extraplanets.items.Tier5.Tier5Fin;
import com.mjr.extraplanets.items.Tier5.Tier5HeavyDutyPlate;
import com.mjr.extraplanets.items.Tier5.Tier5NoseCone;
import com.mjr.extraplanets.items.Tier5.Tier5Rocket;
import com.mjr.extraplanets.items.Tier6.ItemKeyT6;
import com.mjr.extraplanets.items.Tier6.MagnesiumCompressed;
import com.mjr.extraplanets.items.Tier6.MagnesiumIngot;
import com.mjr.extraplanets.items.Tier6.SchematicTier6;
import com.mjr.extraplanets.items.Tier6.Tier6Engine;
import com.mjr.extraplanets.items.Tier6.Tier6Fin;
import com.mjr.extraplanets.items.Tier6.Tier6HeavyDutyPlate;
import com.mjr.extraplanets.items.Tier6.Tier6NoseCone;
import com.mjr.extraplanets.items.Tier6.Tier6Rocket;
import com.mjr.extraplanets.items.Tier7.CrystalCompressed;
import com.mjr.extraplanets.items.Tier7.CrystalIngot;
import com.mjr.extraplanets.items.Tier7.ItemKeyT7;
import com.mjr.extraplanets.items.Tier7.ReinforcedCrystalCompressed;
import com.mjr.extraplanets.items.Tier7.SchematicTier7;
import com.mjr.extraplanets.items.Tier7.Tier7Engine;
import com.mjr.extraplanets.items.Tier7.Tier7Fin;
import com.mjr.extraplanets.items.Tier7.Tier7HeavyDutyPlate;
import com.mjr.extraplanets.items.Tier7.Tier7NoseCone;
import com.mjr.extraplanets.items.Tier7.Tier7Rocket;
import com.mjr.extraplanets.items.Tier8.ItemKeyT8;
import com.mjr.extraplanets.items.Tier8.SchematicTier8;
import com.mjr.extraplanets.items.Tier8.Tier8Engine;
import com.mjr.extraplanets.items.Tier8.Tier8Fin;
import com.mjr.extraplanets.items.Tier8.Tier8HeavyDutyPlate;
import com.mjr.extraplanets.items.Tier8.Tier8NoseCone;
import com.mjr.extraplanets.items.Tier8.Tier8Rocket;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanetsItems {
    public static Item tier4Rocket;
    public static Item tier5Rocket;
    public static Item tier6Rocket;
    public static Item tier7Rocket;
    public static Item tier8Rocket;

    public static Item schematicTier4;
    public static Item schematicTier5;
    public static Item schematicTier6;
    public static Item schematicTier7;
    public static Item schematicTier8;

    public static Item noseConeTier4;
    public static Item engineTier4;
    public static Item finTier4;
    public static Item heavyDutyPlateTier4;

    public static Item noseConeTier5;
    public static Item engineTier5;
    public static Item finTier5;
    public static Item heavyDutyPlateTier5;

    public static Item noseConeTier6;
    public static Item engineTier6;
    public static Item finTier6;
    public static Item heavyDutyPlateTier6;

    public static Item noseConeTier7;
    public static Item engineTier7;
    public static Item finTier7;
    public static Item heavyDutyPlateTier7;

    public static Item noseConeTier8;
    public static Item engineTier8;
    public static Item finTier8;
    public static Item heavyDutyPlateTier8;

    // Tier 4
    public static Item ingotCarbon;
    public static Item compressedCarbon;

    // Tier 5
    public static Item ingotPalladium;
    public static Item compressedPalladium;

    // Tier 6
    public static Item ingotMagnesium;
    public static Item compressedMagnesium;

    // Tier 7
    public static Item ingotCrystal;
    public static Item compressedCrystal;
    
    public static Item ingotUranium;

    public static Item compressedReinforcedCrystal;

    public static Item T4key;
    public static Item T5key;
    public static Item T6key;
    public static Item T7key;
    public static Item T8key;

    public static Item nickelBattery;
    public static Item zincBattery;
    public static Item mercuryBattery;

    public static Item compressedZinc;
    public static Item compressedNickel;
    public static Item compressedMercury;

    public static Item ingotZinc;
    public static Item ingotNickel;
    public static Item ingotMercury;

    public static Item glowstone_bucket;
    public static Item magma_bucket;
    public static Item nitrogen_bucket;
    public static Item frozen_water_bucket;
    public static Item salt_bucket;

    public static void init() {
	initializeItems();
	registerItems();
	registerFluidContainer();
    }

    private static void initializeItems() {
	T4key = new ItemKeyT4().setUnlocalizedName("key");
	T5key = new ItemKeyT5().setUnlocalizedName("key");
	T6key = new ItemKeyT6().setUnlocalizedName("key");
	T7key = new ItemKeyT7().setUnlocalizedName("key");
	T8key = new ItemKeyT8().setUnlocalizedName("key");

	tier4Rocket = new Tier4Rocket("itemTier4Rocket");
	tier5Rocket = new Tier5Rocket("itemTier5Rocket");
	tier6Rocket = new Tier6Rocket("itemTier6Rocket");
	tier7Rocket = new Tier7Rocket("itemTier7Rocket");
	tier8Rocket = new Tier8Rocket("itemTier8Rocket");

	schematicTier4 = new SchematicTier4("schematicTier4");
	schematicTier5 = new SchematicTier5("schematicTier5");
	schematicTier6 = new SchematicTier6("schematicTier6");
	schematicTier7 = new SchematicTier7("schematicTier7");
	schematicTier8 = new SchematicTier8("schematicTier8");

	noseConeTier4 = new Tier4NoseCone("noseConeTier4");
	engineTier4 = new Tier4Engine("engine");
	finTier4 = new Tier4Fin("rocketFinsT4");
	heavyDutyPlateTier4 = new Tier4HeavyDutyPlate("reinforcedPlateT4");

	noseConeTier5 = new Tier5NoseCone("noseConeTier5");
	engineTier5 = new Tier5Engine("engine");
	finTier5 = new Tier5Fin("rocketFinsT5");
	heavyDutyPlateTier5 = new Tier5HeavyDutyPlate("reinforcedPlateT5");

	noseConeTier6 = new Tier6NoseCone("noseConeTier6");
	engineTier6 = new Tier6Engine("engine");
	finTier6 = new Tier6Fin("rocketFinsT6");
	heavyDutyPlateTier6 = new Tier6HeavyDutyPlate("reinforcedPlateT6");

	noseConeTier7 = new Tier7NoseCone("noseConeTier7");
	engineTier7 = new Tier7Engine("engine");
	finTier7 = new Tier7Fin("rocketFinsT7");
	heavyDutyPlateTier7 = new Tier7HeavyDutyPlate("reinforcedPlateT7");

	noseConeTier8 = new Tier8NoseCone("noseConeTier8");
	engineTier8 = new Tier8Engine("engine");
	finTier8 = new Tier8Fin("rocketFinsT8");
	heavyDutyPlateTier8 = new Tier8HeavyDutyPlate("reinforcedPlateT8");

	ingotCarbon = new CarbonIngot("ingotCarbon");
	compressedCarbon = new CarbonCompressed("compressedCarbon");

	ingotPalladium = new PalladiumIngot("ingotPalladium");
	compressedPalladium = new PalladiumCompressed("compressedPalladium");

	ingotMagnesium = new MagnesiumIngot("ingotMagnesium");
	compressedMagnesium = new MagnesiumCompressed("compressedMagnesium");

	ingotCrystal = new CrystalIngot("ingotCrystal");
	compressedCrystal = new CrystalCompressed("compressedCrystal");

	ingotUranium = new CrystalIngot("ingotUranium");
	
	compressedReinforcedCrystal = new ReinforcedCrystalCompressed("compressedReinforcedCrystal");

	nickelBattery = new BasicBattery("nickelBattery", 45000f, 2);
	mercuryBattery = new BasicBattery("mercuryBattery", 85000f, 2);
	zincBattery = new BasicBattery("zincBattery", 125000f, 2);

	ingotZinc = new CrystalIngot("ingotZinc");
	compressedZinc = new ZincCompressed("compressedZinc");

	ingotNickel = new CrystalIngot("ingotNickel");
	compressedNickel = new NickelCompressed("compressedNickel");

	ingotMercury = new CrystalIngot("ingotMercury");
	compressedMercury = new MercuryCompressed("compressedMercury");

	glowstone_bucket = new BasicItemBucket("bucket_glowstone", ExtraPlanetsFluids.glowstone);
	magma_bucket = new BasicItemBucket("bucket_magma", ExtraPlanetsFluids.magma);
	nitrogen_bucket = new BasicItemBucket("bucket_nitrogen", ExtraPlanetsFluids.nitrogen);
	frozen_water_bucket = new BasicItemBucket("bucket_frozen_water", ExtraPlanetsFluids.frozen_water);
	salt_bucket = new BasicItemBucket("bucket_salt", ExtraPlanetsFluids.salt);
    }

    private static void registerItems() {
	GameRegistry.registerItem(T4key, "T4key");
	GameRegistry.registerItem(T5key, "T5key");
	GameRegistry.registerItem(T6key, "T6key");
	GameRegistry.registerItem(T7key, "T7key");
	GameRegistry.registerItem(T8key, "T8key");

	GameRegistry.registerItem(tier4Rocket, "itemTier4Rocket");
	GameRegistry.registerItem(tier5Rocket, "itemTier5Rocket");
	GameRegistry.registerItem(tier6Rocket, "itemTier6Rocket");
	GameRegistry.registerItem(tier7Rocket, "itemTier7Rocket");
	GameRegistry.registerItem(tier8Rocket, "itemTier8Rocket");

	GameRegistry.registerItem(schematicTier4, "schematicTier4");
	GameRegistry.registerItem(schematicTier5, "schematicTier5");
	GameRegistry.registerItem(schematicTier6, "schematicTier6");
	GameRegistry.registerItem(schematicTier7, "schematicTier7");
	GameRegistry.registerItem(schematicTier8, "schematicTier8");

	GameRegistry.registerItem(noseConeTier4, "noseConeTier4");
	GameRegistry.registerItem(engineTier4, "engineTier4");
	GameRegistry.registerItem(finTier4, "finTier4");
	GameRegistry.registerItem(heavyDutyPlateTier4, "heavyDutyPlateTier4");

	GameRegistry.registerItem(noseConeTier5, "noseConeTier5");
	GameRegistry.registerItem(engineTier5, "engineTier5");
	GameRegistry.registerItem(finTier5, "finTier5");
	GameRegistry.registerItem(heavyDutyPlateTier5, "heavyDutyPlateTier5");

	GameRegistry.registerItem(noseConeTier6, "noseConeTier6");
	GameRegistry.registerItem(engineTier6, "engineTier6");
	GameRegistry.registerItem(finTier6, "finTier6");
	GameRegistry.registerItem(heavyDutyPlateTier6, "heavyDutyPlateTier6");

	GameRegistry.registerItem(noseConeTier7, "noseConeTier7");
	GameRegistry.registerItem(engineTier7, "engineTier7");
	GameRegistry.registerItem(finTier7, "finTier7");
	GameRegistry.registerItem(heavyDutyPlateTier7, "heavyDutyPlateTier7");

	GameRegistry.registerItem(noseConeTier8, "noseConeTier8");
	GameRegistry.registerItem(engineTier8, "engineTier8");
	GameRegistry.registerItem(finTier8, "finTier8");
	GameRegistry.registerItem(heavyDutyPlateTier8, "heavyDutyPlateTier8");

	GameRegistry.registerItem(ingotCarbon, "ingotCarbon");
	GameRegistry.registerItem(compressedCarbon, "compressedCarbon");

	GameRegistry.registerItem(ingotPalladium, "ingotPalladium");
	GameRegistry.registerItem(compressedPalladium, "compressedPalladium");

	GameRegistry.registerItem(ingotMagnesium, "ingotMagnesium");
	GameRegistry.registerItem(compressedMagnesium, "compressedMagnesium");

	GameRegistry.registerItem(ingotCrystal, "ingotCrystal");
	GameRegistry.registerItem(compressedCrystal, "compressedCrystal");

	GameRegistry.registerItem(ingotUranium, "ingotUranium");

	GameRegistry.registerItem(compressedReinforcedCrystal, "compressedReinforcedCrystal");

	GameRegistry.registerItem(nickelBattery, "nickelBattery");
	GameRegistry.registerItem(mercuryBattery, "mercuryBattery");
	GameRegistry.registerItem(zincBattery, "zincBattery");

	GameRegistry.registerItem(compressedZinc, "compressedZinc");
	GameRegistry.registerItem(compressedNickel, "compressedNickel");
	GameRegistry.registerItem(compressedMercury, "compressedMercury");

	GameRegistry.registerItem(ingotZinc, "ingotZinc");
	GameRegistry.registerItem(ingotNickel, "ingotNickel");
	GameRegistry.registerItem(ingotMercury, "ingotMercury");

	GameRegistry.registerItem(glowstone_bucket, "bucket_glowstone");
	GameRegistry.registerItem(magma_bucket, "bucket_magma");
	GameRegistry.registerItem(nitrogen_bucket, "bucket_nitrogen");
	GameRegistry.registerItem(frozen_water_bucket, "bucket_frozen_water");
	GameRegistry.registerItem(salt_bucket, "bucket_salt");
    }

    private static void registerFluidContainer() {
	FluidContainerRegistry.registerFluidContainer(ExtraPlanetsFluids.glowstone_fluid, new ItemStack(glowstone_bucket, 1, 0),
		new ItemStack(Items.bucket));

	FluidContainerRegistry.registerFluidContainer(ExtraPlanetsFluids.magma_fluid, new ItemStack(magma_bucket, 1, 0), new ItemStack(
		Items.bucket));

	FluidContainerRegistry.registerFluidContainer(ExtraPlanetsFluids.nitrogen_fluid, new ItemStack(nitrogen_bucket, 1, 0),
		new ItemStack(Items.bucket));

	FluidContainerRegistry.registerFluidContainer(ExtraPlanetsFluids.frozen_water_fluid, new ItemStack(frozen_water_bucket, 1, 0),
		new ItemStack(Items.bucket));

	FluidContainerRegistry.registerFluidContainer(ExtraPlanetsFluids.salt_fluid, new ItemStack(salt_bucket, 1, 0), new ItemStack(
		Items.bucket));
    }
}
