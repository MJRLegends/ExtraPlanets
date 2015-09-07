package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockFossil extends BlockBasic {

	int randomItem = 0;
	protected BlockFossil(Material material) {
		super(material);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Items.bone;
		//	Random random = new Random();
		//	int itemRandom = random.nextInt((2 - 0) + 1) + 0;
		//	this.randomItem = itemRandom;
		//	switch (itemRandom) {
		//	case 0:
		//	    return Items.bone;
		//	case 1:
		//	    return ExtraPlanetsItems.bodyParts;
		//	case 2:
		//	    return ExtraPlanetsItems.bodyParts;
		//	default:
		//	    return Items.bone;
	}
	//    }
	//    @Override
	//    public int damageDropped(int p_149692_1_){
	//	if(randomItem == 1)
	//	    return 0;
	//	else
	//	    return 1;
	//    }
}
