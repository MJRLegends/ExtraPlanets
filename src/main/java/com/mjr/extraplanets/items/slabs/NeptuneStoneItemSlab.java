package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class NeptuneStoneItemSlab extends ItemSlab {

	public NeptuneStoneItemSlab(Block block) {
		super(block, ((BlockSlab) (ExtraPlanetsBlocks.neptuneStoneBlockHalfSlab)),
				((BlockSlab) (ExtraPlanetsBlocks.neptuneStoneBlockDoubleSlab)), false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setUnlocalizedName(Constants.TEXTURE_PREFIX + "neptuneStone");
	}

}