package com.mjr.extraplanets.blocks.machines;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedRefinery;

public class ExtraPlanets_Machines {
	// Machines
	public static Block advancedRefinery;
	public static Block solarPanel;

	public static void init() {
		initializeMachinesBlocks();
		registerMachines();
		registerMachineTileEntitys();
	}

	private static void initializeMachinesBlocks() {
		if (Config.advancedRefinery)
			advancedRefinery = new AdvancedRefinery("advancedRefinery");
		// if(Config.solarPanels)
		// solarPanel = new BlockSolar("solar");
	}

	private static void registerMachines() {
		GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		// if(Config.solarPanels){
		// GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
		// GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
		// GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
		// }
	}

	private static void registerMachineTileEntitys() {
		if (Config.advancedRefinery)
			GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
		// if(Config.solarPanels)
		// GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
	}
}
