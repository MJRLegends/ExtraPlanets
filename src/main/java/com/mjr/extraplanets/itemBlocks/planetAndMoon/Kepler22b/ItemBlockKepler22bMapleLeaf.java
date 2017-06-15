package com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bMapleLeaf extends ItemBlock {
	public ItemBlockKepler22bMapleLeaf(Block block) {
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
			name = "blue_maple_leaf";
			break;
		}
		case 1: {
			name = "red_maple_leaf";
			break;
		}
		case 2: {
			name = "purple_maple_leaf";
			break;
		}
		case 3: {
			name = "yellow_maple_leaf";
			break;
		}
		case 4: {
			name = "green_maple_leaf";
			break;
		}
		case 5: {
			name = "brown_maple_leaf";
			break;
		}
		case 8: {
			name = "blue_maple_leaf";
			break;
		}
		case 9: {
			name = "red_maple_leaf";
			break;
		}
		case 10: {
			name = "purple_maple_leaf";
			break;
		}
		case 11: {
			name = "yellow_maple_leaf";
			break;
		}
		case 12: {
			name = "green_maple_leaf";
			break;
		}
		case 13: {
			name = "brown_maple_leaf";
			break;
		}
		default:
			name = "null";
		}

		return this.block.getUnlocalizedName() + "." + name;
	}
}