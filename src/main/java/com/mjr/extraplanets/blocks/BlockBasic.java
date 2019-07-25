package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block {

	protected BlockBasic(Material material) {
		super(material);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setHarvestLevel("pickaxe", 1);
	}

}
