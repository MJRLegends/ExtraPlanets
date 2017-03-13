package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.machines.AdvancedRefinery;
import com.mjr.extraplanets.blocks.machines.BlockSolar;
import com.mjr.extraplanets.itemBlocks.machines.ItemBlockSolar;
import com.mjr.extraplanets.tile.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.TileEntitySolar;

import cpw.mods.fml.common.registry.GameRegistry;

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
		if(Config.advancedRefinery)
			advancedRefinery = new AdvancedRefinery("advancedRefinery");
		if(Config.solarPanels)
			solarPanel = new BlockSolar("solar");
	}

	private static void registerMachines() {
		if(Config.advancedRefinery)
			GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		if(Config.solarPanels){
			GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
			GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
			GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
		}
	}

	private static void registerMachineTileEntitys() {
		if(Config.solarPanels)
			GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		if(Config.advancedRefinery)
			GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
	}
}
