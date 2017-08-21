package com.mjr.extraplanets.blocks.machines;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockAdvancedOxygenCompressor;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockSolar;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedFuelLoader;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.machines.TileEntityBasicChemicalInjector;
import com.mjr.extraplanets.tile.machines.TileEntityBasicCrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicDecrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicSmasher;
import com.mjr.extraplanets.tile.machines.TileEntityBasicSolarEvaporationChamber;
import com.mjr.extraplanets.tile.machines.TileEntitySolar;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateFuelLoader;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateRefinery;
import com.mjr.extraplanets.tile.machines.TileEntityVehicleChanger;

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

	public static Block VEHICLE_CHARGER;

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
		}
		FUEL_LOADER_ADVANCED = new AdvancedFuelLoader("advanced_fuel_loader");
		FUEL_LOADER_ULTIMATE = new UltimateFuelLoader("ultimate_fuel_loader");

		VEHICLE_CHARGER = new VehicleCharger("vehicle_charger");
	}

	private static void registerMachines() throws NoSuchMethodException {
		if (Config.REFINERY_ADVANCED)
			GameRegistry.registerBlock(REFINERY_ADVANCED, REFINERY_ADVANCED.getUnlocalizedName().substring(5));
		if (Config.REFINERY_ULTIMATE)
			GameRegistry.registerBlock(REFINERY_ULTIMATE, REFINERY_ULTIMATE.getUnlocalizedName().substring(5));
		if (Config.SOLAR_PANELS)
			GameRegistry.registerBlock(SOLAR_PANEL, ItemBlockSolar.class, SOLAR_PANEL.getUnlocalizedName().substring(5));
		if (Config.OXYGEN_COMPRESSOR_ADVANCED)
			GameRegistry.registerBlock(OXYGEN_COMPRESSOR_ADVANCED, ItemBlockAdvancedOxygenCompressor.class, OXYGEN_COMPRESSOR_ADVANCED.getUnlocalizedName().substring(5));
		if (Config.OXYGEN_COMPRESSOR_ULTIMATE)
			GameRegistry.registerBlock(OXYGEN_COMPRESSOR_ULTIMATE, ItemBlockUltimateOxygenCompressor.class, OXYGEN_COMPRESSOR_ULTIMATE.getUnlocalizedName().substring(5));
		if (Config.RADIATION) {
			if (Config.BASIC_DECRYSTALLIZER)
				GameRegistry.registerBlock(BASIC_DECRYSALLIZER, BASIC_DECRYSALLIZER.getUnlocalizedName().substring(5));
			if (Config.BASIC_CRYSTALLIZER)
				GameRegistry.registerBlock(BASIC_CRYSALLIZER, BASIC_CRYSALLIZER.getUnlocalizedName().substring(5));
			if (Config.BASIC_SMASHER)
				GameRegistry.registerBlock(BASIC_SMASHER, BASIC_SMASHER.getUnlocalizedName().substring(5));
			if (Config.BASIC_CHEMICAL_INJECTOR)
				GameRegistry.registerBlock(BASIC_CHEMICAL_INJECTOR, BASIC_CHEMICAL_INJECTOR.getUnlocalizedName().substring(5));
			if (Config.BASIC_SOLAR_EVAPORTATION_CHAMBER)
				GameRegistry.registerBlock(BASIC_SOLAR_EVAPORTATION_CHAMBER, BASIC_SOLAR_EVAPORTATION_CHAMBER.getUnlocalizedName().substring(5));
		}
		GameRegistry.registerBlock(FUEL_LOADER_ADVANCED, FUEL_LOADER_ADVANCED.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(FUEL_LOADER_ULTIMATE, FUEL_LOADER_ULTIMATE.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(VEHICLE_CHARGER, VEHICLE_CHARGER.getUnlocalizedName().substring(5));
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
		}
		GameRegistry.registerTileEntity(TileEntityAdvancedFuelLoader.class, Constants.modName + "AdvancedFuelLoader");
		GameRegistry.registerTileEntity(TileEntityUltimateFuelLoader.class, Constants.modName + "UltimateFuelLoader");

		GameRegistry.registerTileEntity(TileEntityVehicleChanger.class, Constants.modName + "VehicleChanger");
	}
}
