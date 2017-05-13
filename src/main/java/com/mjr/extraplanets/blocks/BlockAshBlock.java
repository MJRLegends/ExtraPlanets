package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class BlockAshBlock extends BlockFalling {
	public BlockAshBlock(String name) {
		super();
		setHardness(0.6F);
		setStepSound(Block.soundTypeGravel);
		setBlockName(name);
		setBlockTextureName(Constants.TEXTURE_PREFIX + name);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return new ItemStack(ExtraPlanets_Items.tier4Items, 1, 10).getItem();
	}
}