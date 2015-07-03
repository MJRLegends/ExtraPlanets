package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.mjr.extraplanets.ExtraPlanets;

public class OreBlock extends Block {
    protected OreBlock(Material p_i45394_1_) {
	super(p_i45394_1_);
	this.setCreativeTab(ExtraPlanets.BlocksTab);
	this.setHardness(3F);
    }
}
