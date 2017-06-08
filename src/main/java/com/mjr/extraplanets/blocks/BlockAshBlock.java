package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;

import com.mjr.extraplanets.Constants;

public class BlockAshBlock extends BlockFalling {
	public BlockAshBlock(String name) {
		super();
		setHardness(0.6F);
		setStepSound(Block.soundTypeGravel);
		setBlockName(name);
		setBlockTextureName(Constants.TEXTURE_PREFIX + name);
	}
}