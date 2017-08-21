package com.mjr.extraplanets.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockSand extends BlockFalling {
	protected BlockSand(String name) {
		super(Material.sand);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

}