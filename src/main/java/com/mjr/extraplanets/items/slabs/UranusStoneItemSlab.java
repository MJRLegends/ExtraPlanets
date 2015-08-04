package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class UranusStoneItemSlab extends ItemSlab {

    public UranusStoneItemSlab(Block block) {
	super(block, ((BlockSlab) (ExtraPlanetsBlocks.uranusStoneBlockHalfSlab)),
		((BlockSlab) (ExtraPlanetsBlocks.uranusStoneBlockDoubleSlab)), false);
	this.setMaxDamage(0);
	this.setHasSubtypes(true);
	setUnlocalizedName(Constants.TEXTURE_PREFIX + "uranusStone");
    }

}