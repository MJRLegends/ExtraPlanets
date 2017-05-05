package com.mjr.extraplanets.blocks.machines;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockSolar;
import com.mjr.extraplanets.tile.TileEntityAdvancedFuelLoader;
import com.mjr.extraplanets.tile.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.TileEntitySolar;
import com.mjr.extraplanets.tile.TileEntityVehicleChanger;

import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanets_Machines {
	// Machines
	public static Block advancedRefinery;
	public static Block solarPanel;
	public static Block advancedFuelLoader;
	public static Block chargingBlock;

	public static void init() {
		initializeMachinesBlocks();
		registerMachines();
		registerMachineTileEntitys();
	}

	private static void initializeMachinesBlocks() {
		if (Config.advancedRefinery)
			advancedRefinery = new AdvancedRefinery("advancedRefinery");
		if (Config.solarPanels)
			solarPanel = new BlockSolar("solar");
		advancedFuelLoader = new AdvancedFuelLoader("advancedFuelLoader");
		chargingBlock = new VehicleCharger("chargingBlock");
	}

	private static void registerMachines() {
		if (Config.advancedRefinery)
			GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		if (Config.solarPanels) {
			GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
			GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
			GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
		}
		GameRegistry.registerBlock(advancedFuelLoader, "advancedFuelLoader");
		GameRegistry.registerBlock(chargingBlock, "chargingBlock");
	}

	private static void registerMachineTileEntitys() {
		if (Config.solarPanels)
			GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		if (Config.advancedRefinery)
			GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
		GameRegistry.registerTileEntity(TileEntityAdvancedFuelLoader.class, Constants.modName + "AdvancedFuelLoader");
		GameRegistry.registerTileEntity(TileEntityVehicleChanger.class, Constants.modName + "VehicleChanger");
	}
}
