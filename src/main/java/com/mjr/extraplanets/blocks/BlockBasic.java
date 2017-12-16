package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasic extends Block {

	protected BlockBasic(Material material) {
		super(material);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setHarvestLevel("pickaxe", 1);
	}

}
