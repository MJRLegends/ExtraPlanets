package com.mjr.extraplanets.blocks.machines;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockAdvancedOxygenCompressor;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockSolar;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedFuelLoader;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.machines.TileEntitySolar;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateFuelLoader;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateRefinery;
import com.mjr.extraplanets.tile.machines.TileEntityVehicleChanger;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Machines {
	// Machines
	public static Block advancedRefinery;
	public static Block ultimateRefinery;

	public static Block advancedFuelLoader;
	public static Block ultimateFuelLoader;

	public static Block advancedOxygenCompressor;
	public static Block ultimateOxygenCompressor;
	
	public static Block solarPanel;
	public static Block chargingBlock;

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
		if (Config.advancedFuelLoader)
			advancedFuelLoader = new AdvancedFuelLoader("advancedFuelLoader");
		if (Config.ultimateFuelLoader)
			ultimateFuelLoader = new UltimateFuelLoader("ultimateFuelLoader");
		advancedOxygenCompressor = new AdvancedOxygenCompressor(false, "advancedOxygenCompressor");
		ultimateOxygenCompressor = new UltimateOxygenCompressor(false, "ultimateOxygenCompressor");
		if (Config.solarPanels)
			solarPanel = new BlockSolar("solar");
		if (Config.chargingBlock)
			chargingBlock = new VehicleCharger("chargingBlock");
	}

	private static void registerMachines() {
		if (Config.advancedRefinery)
			GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		if (Config.ultimateRefinery)
			GameRegistry.registerBlock(ultimateRefinery, "ultimateRefinery");
		if (Config.advancedFuelLoader)
			GameRegistry.registerBlock(advancedFuelLoader, "advancedFuelLoader");
		if (Config.ultimateFuelLoader)
			GameRegistry.registerBlock(ultimateFuelLoader, "ultimateFuelLoader");
		if (Config.advancedOxygenCompressor)
			GameRegistry.registerBlock(advancedOxygenCompressor, ItemBlockAdvancedOxygenCompressor.class, "advancedOxygenCompressor");
		if (Config.ultimateOxygenCompressor)
			GameRegistry.registerBlock(ultimateOxygenCompressor, ItemBlockUltimateOxygenCompressor.class, "ultimateOxygenCompressor");
		if (Config.solarPanels) {
			GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
			GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
			GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
		}
		if (Config.chargingBlock)
			GameRegistry.registerBlock(chargingBlock, "chargingBlock");
	}

	private static void registerMachineTileEntitys() {
		if (Config.advancedRefinery)
			GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
		if (Config.ultimateRefinery)
			GameRegistry.registerTileEntity(TileEntityUltimateRefinery.class, Constants.modName + "UltimateRefinery");
		if (Config.advancedFuelLoader)
			GameRegistry.registerTileEntity(TileEntityAdvancedFuelLoader.class, Constants.modName + "AdvancedFuelLoader");
		if (Config.ultimateFuelLoader)
			GameRegistry.registerTileEntity(TileEntityUltimateFuelLoader.class, Constants.modName + "UltimateFuelLoader");
		if (Config.advancedOxygenCompressor){
			GameRegistry.registerTileEntity(TileEntityAdvancedOxygenCompressor.class, Constants.modName + "AdvancedOxygenCompressor");
			GameRegistry.registerTileEntity(TileEntityAdvancedOxygenDecompressor.class, Constants.modName + "AdvancedOxygenDecompressor");
		}
		if (Config.ultimateOxygenCompressor){
			GameRegistry.registerTileEntity(TileEntityUltimateOxygenCompressor.class, Constants.modName + "UltimateOxygenCompressor");
			GameRegistry.registerTileEntity(TileEntityUltimateOxygenDecompressor.class, Constants.modName + "UltimateOxygenDecompressor");
		}
		if (Config.solarPanels)
			GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		if (Config.chargingBlock)
			GameRegistry.registerTileEntity(TileEntityVehicleChanger.class, Constants.modName + "VehicleChanger");
	}
}
