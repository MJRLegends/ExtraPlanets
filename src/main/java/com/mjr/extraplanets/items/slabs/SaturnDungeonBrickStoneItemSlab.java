package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanetsSlabsStairsBlocks;

public class SaturnDungeonBrickStoneItemSlab extends ItemSlab{
	public SaturnDungeonBrickStoneItemSlab(Block block) {
		super(block, ((BlockSlab) (ExtraPlanetsSlabsStairsBlocks.saturnDungeonBrickStoneBlockHalfSlab)),
				((BlockSlab) (ExtraPlanetsSlabsStairsBlocks.saturnDungeonBrickStoneBlockDoubleSlab)), false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setUnlocalizedName(Constants.TEXTURE_PREFIX + "saturnDungeonBrickStone");
	}

}
