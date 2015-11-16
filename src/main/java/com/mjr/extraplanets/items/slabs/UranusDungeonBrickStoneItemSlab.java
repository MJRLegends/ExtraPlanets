package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsSlabsStairsBlocks;

public class UranusDungeonBrickStoneItemSlab extends ItemSlab{
	public UranusDungeonBrickStoneItemSlab(Block block) {
		super(block, ((BlockSlab) (ExtraPlanetsSlabsStairsBlocks.uranusDungeonBrickStoneBlockHalfSlab)),
				((BlockSlab) (ExtraPlanetsSlabsStairsBlocks.uranusDungeonBrickStoneBlockDoubleSlab)), false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setUnlocalizedName(Constants.TEXTURE_PREFIX + "uranusDungeonBrickStone");
	}

}
