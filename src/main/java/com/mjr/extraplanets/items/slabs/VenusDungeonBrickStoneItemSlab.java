package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class VenusDungeonBrickStoneItemSlab extends ItemSlab{
    public VenusDungeonBrickStoneItemSlab(Block block) {
	super(block, ((BlockSlab) (ExtraPlanetsBlocks.venusDungeonBrickStoneBlockHalfSlab)),
		((BlockSlab) (ExtraPlanetsBlocks.venusDungeonBrickStoneBlockDoubleSlab)), false);
	this.setMaxDamage(0);
	this.setHasSubtypes(true);
	setUnlocalizedName(Constants.TEXTURE_PREFIX + "venusDungeonBrickStone");
    }

}
