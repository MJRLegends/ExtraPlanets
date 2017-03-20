package com.mjr.extraplanets.blocks.machines;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockAdvancedOxygenCompressor;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockSolar;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.machines.TileEntityBasicChemicalInjector;
import com.mjr.extraplanets.tile.machines.TileEntityBasicCrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicDecrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicSmasher;
import com.mjr.extraplanets.tile.machines.TileEntityBasicSolarEvaporationChamber;
import com.mjr.extraplanets.tile.machines.TileEntitySolar;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateRefinery;

public class ExtraPlanets_Machines {
	// Machines
	public static Block advancedRefinery;
	public static Block ultimateRefinery;

	public static Block advancedOxygenCompressor;
	public static Block ultimateOxygenCompressor;

	public static Block solarPanel;

	public static Block basicDecrystallizer;
	public static Block basicCrystallizer;
	public static Block basicSmasher;
	public static Block basicChemicalInjector;
	public static Block basicSolarEvaporationChamber;

	public static void init() {
		initializeMachinesBlocks();
		registerMachines();
		registerMachineTileEntitys();
	}

	private static void initializeMachinesBlocks() {
		if (Config.advancedRefinery)
			advancedRefinery = new AdvancedRefinery("advancedRefinery");
		if (Config.ultimateRefinery)
			ultimateRefinery = new UltimateRefinery("ultimateRefinery");
		if (Config.solarPanels)
			solarPanel = new BlockSolar("solar");
		if (Config.advancedCompressor)
			advancedOxygenCompressor = new AdvancedOxygenCompressor(false, "advancedOxygenCompressor");
		if (Config.ultimateCompressor)
			ultimateOxygenCompressor = new UltimateOxygenCompressor(false, "ultimateOxygenCompressor");
		
		if(Config.radiation){
			if (Config.basicDecrystallizer)
				basicDecrystallizer = new BasicDecrystallizer("basicDecrystallizer");
			if (Config.basicCrystallizer)
				basicCrystallizer = new BasicCrystallizer("basicCrystallizer");
			if (Config.basicSmasher)
				basicSmasher = new BasicSmasher("basicSmasher");
			if (Config.basicChemicalInjector)
				basicChemicalInjector = new BasicChemicalInjector("basicChemicalInjector");
			if (Config.basicSolarEvaporationChamber)
				basicSolarEvaporationChamber = new BasicSolarEvaporationChamber("basicSolarEvaporationChamber");
		}
	}

	private static void registerMachines() {
		if (Config.advancedRefinery)
			GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		if (Config.ultimateRefinery)
			GameRegistry.registerBlock(ultimateRefinery, "ultimateRefinery");
		if (Config.solarPanels)
			GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName().substring(5));
		if (Config.advancedCompressor)
			GameRegistry.registerBlock(advancedOxygenCompressor, ItemBlockAdvancedOxygenCompressor.class, advancedOxygenCompressor.getUnlocalizedName().substring(5));
		if (Config.ultimateCompressor)
			GameRegistry.registerBlock(ultimateOxygenCompressor, ItemBlockUltimateOxygenCompressor.class, ultimateOxygenCompressor.getUnlocalizedName().substring(5));
		if(Config.radiation){
			if (Config.basicCrystallizer)if (Config.basicCrystallizer)
				GameRegistry.registerBlock(basicDecrystallizer, basicDecrystallizer.getUnlocalizedName().substring(5));
			if (Config.basicCrystallizer)
				GameRegistry.registerBlock(basicCrystallizer, basicCrystallizer.getUnlocalizedName().substring(5));
			if (Config.basicSmasher)
				GameRegistry.registerBlock(basicSmasher, basicSmasher.getUnlocalizedName().substring(5));
			if (Config.basicChemicalInjector)
				GameRegistry.registerBlock(basicChemicalInjector, basicChemicalInjector.getUnlocalizedName().substring(5));
			if (Config.basicSolarEvaporationChamber)
				GameRegistry.registerBlock(basicSolarEvaporationChamber, basicSolarEvaporationChamber.getUnlocalizedName().substring(5));
		}
	}

	private static void registerMachineTileEntitys() {
		if (Config.advancedRefinery)
			GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
		if (Config.ultimateRefinery)
			GameRegistry.registerTileEntity(TileEntityUltimateRefinery.class, Constants.modName + "UltimateRefinery");
		if (Config.solarPanels)
			GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		if (Config.advancedCompressor) {
			GameRegistry.registerTileEntity(TileEntityAdvancedOxygenCompressor.class, Constants.modName + "Advanced Oxygen Compressor");
			GameRegistry.registerTileEntity(TileEntityAdvancedOxygenDecompressor.class, Constants.modName + "Advanced Oxygen Decompressor");
		}
		if (Config.ultimateCompressor) {
			GameRegistry.registerTileEntity(TileEntityUltimateOxygenCompressor.class, Constants.modName + "Ultimate Oxygen Compressor");
			GameRegistry.registerTileEntity(TileEntityUltimateOxygenDecompressor.class, Constants.modName + "Ultimate Oxygen Decompressor");
		}
		if(Config.radiation){
			if (Config.basicCrystallizer)
				GameRegistry.registerTileEntity(TileEntityBasicDecrystallizer.class, Constants.modName + "Basic Decrystallizer");
			if (Config.basicCrystallizer)
				GameRegistry.registerTileEntity(TileEntityBasicCrystallizer.class, Constants.modName + "Basic Crystallizer");
			if (Config.basicSmasher)
				GameRegistry.registerTileEntity(TileEntityBasicSmasher.class, Constants.modName + "Basic Smasher");
			if (Config.basicChemicalInjector)
				GameRegistry.registerTileEntity(TileEntityBasicChemicalInjector.class, Constants.modName + "Basic Chemical Injector");
			if (Config.basicSolarEvaporationChamber)
				GameRegistry.registerTileEntity(TileEntityBasicSolarEvaporationChamber.class, Constants.modName + "Basic Solar Evaporation Chamber");
		}
	}
}
