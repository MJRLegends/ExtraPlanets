package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.mjr.extraplanets.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasicGrass extends Block {

	private String name, planetName;
	private IIcon[] grassIcon;

	protected BlockBasicGrass(String name, String planetName) {
		super(Material.grass);
		this.name = name;
		this.planetName = planetName;
		this.setBlockName(name + "Grass");
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.grassIcon = new IIcon[6];
		this.grassIcon[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.planetName + "_grass_dirt");
		this.grassIcon[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_top");
		this.grassIcon[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
		this.grassIcon[3] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
		this.grassIcon[4] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
		this.grassIcon[5] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2) {
		if ((par1 < 0) || (par1 >= this.grassIcon.length)) {
			par1 = 1;
		}
		return this.grassIcon[par1];
	}
}
