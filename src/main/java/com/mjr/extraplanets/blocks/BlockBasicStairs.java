package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicStairs extends BlockStairs {
	public BlockBasicStairs(Block block, int par3, String name) {
		super(block, par3);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setLightOpacity(0);
		this.setHardness(2.2F);
		setBlockName(name);
	}
}
