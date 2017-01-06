package com.mjr.extraplanets.blocks.treasureChest;

import micdoodle8.mods.galacticraft.core.blocks.BlockT1TreasureChest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tile.TileEntityT8TreasureChest;

public class T8TreasureChest extends BlockT1TreasureChest {
	public T8TreasureChest(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityT8TreasureChest();
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}
}