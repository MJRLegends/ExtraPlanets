package com.mjr.extraplanets.items.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_SlabsStairsBlocks;

public class JupiterDungeonBrickStoneItemSlab extends ItemSlab{
	public JupiterDungeonBrickStoneItemSlab(Block block) {
		super(block, ((BlockSlab) (ExtraPlanets_SlabsStairsBlocks.jupiterDungeonBrickStoneBlockHalfSlab)),
				((BlockSlab) (ExtraPlanets_SlabsStairsBlocks.jupiterDungeonBrickStoneBlockDoubleSlab)), false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		setUnlocalizedName(Constants.TEXTURE_PREFIX + "jupiterDungeonBrickStone");
	}

}
