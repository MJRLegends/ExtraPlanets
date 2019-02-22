package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockBasicStairs extends BlockStairs {
	public BlockBasicStairs(Block block, int par3, String name) {
		super(block, par3);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setLightOpacity(0);
		this.setHardness(2.2F);
		setBlockName(name);
	}
}
