package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSand extends BlockFalling {
	protected BlockSand(String name) {
		super(Material.SAND);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setSoundType(SoundType.SAND);
	}

}