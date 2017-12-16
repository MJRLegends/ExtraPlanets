package com.mjr.extraplanets.blocks.machines;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockAdvancedOxygenCompressor;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockSolar;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockUltimateOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedFuelLoader;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedOxygenDecompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicChemicalInjector;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicCrystallizer;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecrystallizer;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDensifier;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicPurifier;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicSmasher;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicSolarEvaporationChamber;
import com.mjr.extraplanets.tileEntities.machines.TileEntitySolar;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateFuelLoader;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateRefinery;
import com.mjr.extraplanets.tileEntities.machines.TileEntityVehicleChanger;
import com.mjr.extraplanets.util.RegisterHelper;

public class ExtraPlanets_Machines {
	// Machines
	public static Block REFINERY_ADVANCED;
	public static Block REFINERY_ULTIMATE;

	public static Block OXYGEN_COMPRESSOR_ADVANCED;
	public static Block OXYGEN_COMPRESSOR_ULTIMATE;

	public static Block SOLAR_PANEL;

	public static Block FUEL_LOADER_ADVANCED;
	public static Block FUEL_LOADER_ULTIMATE;

	public static Block BASIC_DECRYSALLIZER;
	public static Block BASIC_CRYSALLIZER;
	public static Block BASIC_SMASHER;
	public static Block BASIC_CHEMICAL_INJECTOR;
	public static Block BASIC_SOLAR_EVAPORTATION_CHAMBER;
	public static Block BASIC_PURIFIER;

	public static Block VEHICLE_CHARGER;

	public static Block BASIC_DENSIFIER;

	public static void init() {
		initializeMachinesBlocks();
		try {
			registerMachines();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		registerMachineTileEntitys();
	}

	private static void initializeMachinesBlocks() {
		if (Config.REFINERY_ADVANCED)
			REFINERY_ADVANCED = new AdvancedRefinery("advanced_refinery");
		if (Config.REFINERY_ULTIMATE)
			REFINERY_ULTIMATE = new UltimateRefinery("ultimate_refinery");
		if (Config.SOLAR_PANELS)
			SOLAR_PANEL = new BlockSolar("solar");
		if (Config.OXYGEN_COMPRESSOR_ADVANCED)
			OXYGEN_COMPRESSOR_ADVANCED = new AdvancedOxygenCompressor(false, "advanced_oxygen_compressor");
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE)
			OXYGEN_COMPRESSOR_ULTIMATE = new UltimateOxygenCompressor(false, "ultimate_oxygen_compressor");
		if (Config.RADIATION) {
			if (Config.BASIC_DECRYSTALLIZER)
				BASIC_DECRYSALLIZER = new BasicDecrystallizer("basic_decrystallizer");
			if (Config.BASIC_CRYSTALLIZER)
				BASIC_CRYSALLIZER = new BasicCrystallizer("basic_crystallizer");
			if (Config.BASIC_SMASHER)
				BASIC_SMASHER = new BasicSmasher("basic_smasher");
			if (Config.BASIC_CHEMICAL_INJECTOR)
				BASIC_CHEMICAL_INJECTOR = new BasicChemicalInjector("basic_chemical_injector");
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				BASIC_SOLAR_EVAPORTATION_CHAMBER = new BasicSolarEvaporationChamber("basic_solar_evaporation_chamber");
			if (Config.BASIC_PURIFIER)
				BASIC_PURIFIER = new BasicPurifier("basic_purifier");
		}
		if (Config.FUEL_LOADER_ADVANCED)
			FUEL_LOADER_ADVANCED = new AdvancedFuelLoader("advanced_fuel_loader");
		if (Config.FUEL_LOADER_ULTIMATE)
			FUEL_LOADER_ULTIMATE = new UltimateFuelLoader("ultimate_fuel_loader");
		if (Config.BASIC_DENSIFIER)
			BASIC_DENSIFIER = new BasicDensifier("basic_densifier");
		VEHICLE_CHARGER = new VehicleCharger("vehicle_charger");
	}

	private static void registerMachines() throws NoSuchMethodException {
		if (Config.REFINERY_ADVANCED)
			RegisterHelper.registerBlock(REFINERY_ADVANCED, REFINERY_ADVANCED.getUnlocalizedName().substring(5));
		if (Config.REFINERY_ULTIMATE)
			RegisterHelper.registerBlock(REFINERY_ULTIMATE, REFINERY_ULTIMATE.getUnlocalizedName().substring(5));
		if (Config.SOLAR_PANELS)
			RegisterHelper.registerBlock(SOLAR_PANEL, ItemBlockSolar.class, SOLAR_PANEL.getUnlocalizedName().substring(5));
		if (Config.OXYGEN_COMPRESSOR_ADVANCED)
			RegisterHelper.registerBlock(OXYGEN_COMPRESSOR_ADVANCED, ItemBlockAdvancedOxygenCompressor.class, OXYGEN_COMPRESSOR_ADVANCED.getUnlocalizedName().substring(5));
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE)
			RegisterHelper.registerBlock(OXYGEN_COMPRESSOR_ULTIMATE, ItemBlockUltimateOxygenCompressor.class, OXYGEN_COMPRESSOR_ULTIMATE.getUnlocalizedName().substring(5));
		if (Config.RADIATION) {
			if (Config.BASIC_DECRYSTALLIZER)
				RegisterHelper.registerBlock(BASIC_DECRYSALLIZER, BASIC_DECRYSALLIZER.getUnlocalizedName().substring(5));
			if (Config.BASIC_CRYSTALLIZER)
				RegisterHelper.registerBlock(BASIC_CRYSALLIZER, BASIC_CRYSALLIZER.getUnlocalizedName().substring(5));
			if (Config.BASIC_SMASHER)
				RegisterHelper.registerBlock(BASIC_SMASHER, BASIC_SMASHER.getUnlocalizedName().substring(5));
			if (Config.BASIC_CHEMICAL_INJECTOR)
				RegisterHelper.registerBlock(BASIC_CHEMICAL_INJECTOR, BASIC_CHEMICAL_INJECTOR.getUnlocalizedName().substring(5));
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				RegisterHelper.registerBlock(BASIC_SOLAR_EVAPORTATION_CHAMBER, BASIC_SOLAR_EVAPORTATION_CHAMBER.getUnlocalizedName().substring(5));
			if (Config.BASIC_PURIFIER)
				RegisterHelper.registerBlock(BASIC_PURIFIER, BASIC_PURIFIER.getUnlocalizedName().substring(5));
		}
		if (Config.FUEL_LOADER_ADVANCED)
			RegisterHelper.registerBlock(FUEL_LOADER_ADVANCED, FUEL_LOADER_ADVANCED.getUnlocalizedName().substring(5));
		if (Config.FUEL_LOADER_ULTIMATE)
			RegisterHelper.registerBlock(FUEL_LOADER_ULTIMATE, FUEL_LOADER_ULTIMATE.getUnlocalizedName().substring(5));
		if (Config.BASIC_DENSIFIER)
			RegisterHelper.registerBlock(BASIC_DENSIFIER, BASIC_DENSIFIER.getUnlocalizedName().substring(5));
		RegisterHelper.registerBlock(VEHICLE_CHARGER, VEHICLE_CHARGER.getUnlocalizedName().substring(5));
	}

	private static void registerMachineTileEntitys() {
		if (Config.REFINERY_ADVANCED)
			GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
		if (Config.REFINERY_ULTIMATE)
			GameRegistry.registerTileEntity(TileEntityUltimateRefinery.class, Constants.modName + "UltimateRefinery");
		if (Config.SOLAR_PANELS)
			GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		if (Config.OXYGEN_COMPRESSOR_ADVANCED) {
			GameRegistry.registerTileEntity(TileEntityAdvancedOxygenCompressor.class, Constants.modName + "Advanced Oxygen Compressor");
			GameRegistry.registerTileEntity(TileEntityAdvancedOxygenDecompressor.class, Constants.modName + "Advanced Oxygen Decompressor");
		}
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE) {
			GameRegistry.registerTileEntity(TileEntityUltimateOxygenCompressor.class, Constants.modName + "Ultimate Oxygen Compressor");
			GameRegistry.registerTileEntity(TileEntityUltimateOxygenDecompressor.class, Constants.modName + "Ultimate Oxygen Decompressor");
		}
		if (Config.RADIATION) {
			if (Config.BASIC_DECRYSTALLIZER)
				GameRegistry.registerTileEntity(TileEntityBasicDecrystallizer.class, Constants.modName + "Basic Decrystallizer");
			if (Config.BASIC_CRYSTALLIZER)
				GameRegistry.registerTileEntity(TileEntityBasicCrystallizer.class, Constants.modName + "Basic Crystallizer");
			if (Config.BASIC_SMASHER)
				GameRegistry.registerTileEntity(TileEntityBasicSmasher.class, Constants.modName + "Basic Smasher");
			if (Config.BASIC_CHEMICAL_INJECTOR)
				GameRegistry.registerTileEntity(TileEntityBasicChemicalInjector.class, Constants.modName + "Basic Chemical Injector");
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				GameRegistry.registerTileEntity(TileEntityBasicSolarEvaporationChamber.class, Constants.modName + "Basic Solar Evaporation Chamber");
			if (Config.BASIC_PURIFIER)
				GameRegistry.registerTileEntity(TileEntityBasicPurifier.class, Constants.modName + "Basic Purifier");
		}
		if (Config.FUEL_LOADER_ADVANCED)
			GameRegistry.registerTileEntity(TileEntityAdvancedFuelLoader.class, Constants.modName + "AdvancedFuelLoader");
		if (Config.FUEL_LOADER_ULTIMATE)
			GameRegistry.registerTileEntity(TileEntityUltimateFuelLoader.class, Constants.modName + "UltimateFuelLoader");
		if (Config.BASIC_DENSIFIER)
			GameRegistry.registerTileEntity(TileEntityBasicDensifier.class, Constants.modName + "Basic Densifier");
		GameRegistry.registerTileEntity(TileEntityVehicleChanger.class, Constants.modName + "VehicleChanger");
	}
}
