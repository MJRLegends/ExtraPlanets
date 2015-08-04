package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.mjr.extraplanets.Constants;


public class BlockCustomGravel extends BlockFalling
{
    public BlockCustomGravel(String name){
	super();
	setHardness(0.6F);
	setStepSound(Block.soundTypeGravel);
	setBlockName(name);
	setBlockTextureName(Constants.TEXTURE_PREFIX + name);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
	return Items.flint;
    }
}