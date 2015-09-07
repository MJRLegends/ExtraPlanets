package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class ErisStoneItemSlab extends ItemSlab {

	public ErisStoneItemSlab(Block block) {
		super(block, ((BlockSlab) (ExtraPlanetsBlocks.erisStoneBlockHalfSlab)),
				((BlockSlab) (ExtraPlanetsBlocks.erisStoneBlockDoubleSlab)), false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setUnlocalizedName(Constants.TEXTURE_PREFIX + "erisStone");
	}

}