package com.mjr.extraplanets.blocks;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.machines.AdvancedRefinery;
import com.mjr.extraplanets.blocks.machines.BlockSolar;
import com.mjr.extraplanets.items.ItemBlockSolar;
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
		advancedRefinery = new AdvancedRefinery("advancedRefinery");
		solarPanel = new BlockSolar("solar");
	}

	private static void registerMachines() {
		GameRegistry.registerBlock(advancedRefinery, "advancedRefinery");
		GCCoreUtil.registerGalacticraftBlock("solarPanelHybrid", solarPanel, 0);
		GCCoreUtil.registerGalacticraftBlock("solarPanelUltimate", solarPanel, 4);
		GameRegistry.registerBlock(solarPanel, ItemBlockSolar.class, solarPanel.getUnlocalizedName());
	}

	private static void registerMachineTileEntitys() {
		GameRegistry.registerTileEntity(TileEntitySolar.class, Constants.modName + "Solar Panel");
		GameRegistry.registerTileEntity(TileEntityAdvancedRefinery.class, Constants.modName + "AdvancedRefinery");
	}
}
