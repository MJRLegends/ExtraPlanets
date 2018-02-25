package com.mjr.extraplanets.blocks.treasureChest;

import micdoodle8.mods.galacticraft.core.blocks.BlockTier1TreasureChest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT7TreasureChest;

public class T7TreasureChest extends BlockTier1TreasureChest {
	public T7TreasureChest(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityT7TreasureChest();
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}
}