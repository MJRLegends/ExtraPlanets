package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockCustomGravel extends BlockFalling
{
	public BlockCustomGravel(String name){
		super();
		setHardness(0.6F);
		setStepSound(Block.soundTypeGravel);
		setUnlocalizedName(name);
	}

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return Items.flint;
	}
}