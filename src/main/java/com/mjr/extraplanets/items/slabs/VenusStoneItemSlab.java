package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class VenusStoneItemSlab extends ItemSlab {

    public VenusStoneItemSlab(Block block) {
	super(block, ((BlockSlab) (ExtraPlanetsBlocks.venusStoneBlockHalfSlab)),
		((BlockSlab) (ExtraPlanetsBlocks.venusStoneBlockDoubleSlab)), false);
	this.setMaxDamage(0);
	this.setHasSubtypes(true);
	setUnlocalizedName(Constants.TEXTURE_PREFIX + "venusStone");
    }

}