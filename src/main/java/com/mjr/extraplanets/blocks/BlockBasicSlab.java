package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;

public class BlockBasicSlab extends BlockSlab {
    String name;
    String texturename;

    public BlockBasicSlab(boolean isFullBlock, CreativeTabs tab, String blockName, String texturename) {
	super(isFullBlock, Material.wood);

	if (tab != null) {
	    setCreativeTab(tab);
	}

	name = blockName;
	setBlockName(Constants.modID + "_" + blockName);
	setLightOpacity(0);
	setHardness(2.2F);
	this.texturename = texturename;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
	this.blockIcon = iconRegister.registerIcon(Constants.TEXTURE_PREFIX + texturename);
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
	return getUnlocalizedName();
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
	return Item.getItemFromBlock(this);
    }
    @Override
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
	return Item.getItemFromBlock(this);
    }
}