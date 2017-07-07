package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;

public class BlockAshBlock extends BlockFalling {
	public BlockAshBlock(String name) {
		super();
		this.setHardness(0.6F);
		this.setStepSound(Block.soundTypeGravel);
		this.setUnlocalizedName(name);
	}
}