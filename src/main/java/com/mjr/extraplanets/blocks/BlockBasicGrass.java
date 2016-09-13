package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

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
        this.setTickRandomly(true);
        this.setCreativeTab(ExtraPlanets.BlocksTab);
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

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		if (!p_149674_1_.isRemote) {
			if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2) {
				p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, ExtraPlanets_Blocks.kepler22bBlocks);
			} else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
					int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
					int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
					Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

					if (p_149674_1_.getBlock(i1, j1, k1) == ExtraPlanets_Blocks.kepler22bBlocks && p_149674_1_.getBlockMetadata(i1, j1, k1) == 0 && p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						p_149674_1_.setBlock(i1, j1, k1, this);
					}
				}
			}
		}
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ExtraPlanets_Blocks.kepler22bBlocks.getItemDropped(0, p_149650_2_, p_149650_3_);
	}

	public int damageDropped(int par1, Random par2Random, int par3) {
		return 0;
	}
}
