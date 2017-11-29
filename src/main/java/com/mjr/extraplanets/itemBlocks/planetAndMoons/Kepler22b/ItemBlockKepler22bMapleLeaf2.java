package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bMapleLeaf2 extends ItemBlock {
	public ItemBlockKepler22bMapleLeaf2(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "green_maple_leaf";
			break;
		}
		case 1: {
			name = "brown_maple_leaf";
			break;
		}
		case 8: {
			name = "green_maple_leaf";
			break;
		}
		case 9: {
			name = "brown_maple_leaf";
			break;
		}
		default:
			name = "null";
		}

		return this.block.getUnlocalizedName() + "." + name;
	}
}