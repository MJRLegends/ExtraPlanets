package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.mjr.mjrlegendslib.block.BlockBasic;

public class BlockFossil extends BlockBasic {

	int randomItem = 0;

	protected BlockFossil(Material material) {
		super(material);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.bone;
	}
}
