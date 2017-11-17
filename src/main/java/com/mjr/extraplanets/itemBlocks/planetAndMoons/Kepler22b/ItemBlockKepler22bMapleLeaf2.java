package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

public class ItemBlockKepler22bMapleLeaf2 extends ItemBlockDefaults {
	public ItemBlockKepler22bMapleLeaf2(Block block) {
		super(block);
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

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}