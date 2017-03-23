package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_SlabsStairsBlocks;

public class CeresStoneItemSlab extends ItemSlab {

	public CeresStoneItemSlab(Block block) {
		super(block, ((BlockSlab) (ExtraPlanets_SlabsStairsBlocks.ceresStoneBlockHalfSlab)), ((BlockSlab) (ExtraPlanets_SlabsStairsBlocks.ceresStoneBlockDoubleSlab)), false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setUnlocalizedName(Constants.TEXTURE_PREFIX + "ceresStone");
	}

}