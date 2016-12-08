package com.mjr.extraplanets.blocks.treasureChest;

import micdoodle8.mods.galacticraft.core.blocks.BlockT1TreasureChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.tile.TileEntityT5TreasureChest;

public class T5TreasureChest extends BlockT1TreasureChest {
	public T5TreasureChest(String assetName) {
		super(assetName);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityT5TreasureChest();
	}
}