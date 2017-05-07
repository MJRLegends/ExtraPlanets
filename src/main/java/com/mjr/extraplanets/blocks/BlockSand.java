package com.mjr.extraplanets.blocks;

import net.minecraft.block.material.Material;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class BlockSand extends BlockFalling {
	protected BlockSand(String name) {
		super(Material.sand);
		this.setBlockName(name);
		this.setBlockTextureName(Constants.TEXTURE_PREFIX + name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

}
