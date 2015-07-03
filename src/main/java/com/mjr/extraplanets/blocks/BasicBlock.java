package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.mjr.extraplanets.ExtraPlanets;

public class BasicBlock extends Block{

    protected BasicBlock(Material material) {
	super(material);
	this.setCreativeTab(ExtraPlanets.BlocksTab);
    }

}
