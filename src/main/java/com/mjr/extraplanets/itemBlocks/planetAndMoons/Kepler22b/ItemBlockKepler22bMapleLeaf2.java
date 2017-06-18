package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockKepler22bMapleLeaf2 extends ItemBlockDefaults {
	public ItemBlockKepler22bMapleLeaf2(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "greenMapleLeaf";
			break;
		}
		case 1: {
			name = "brownMapleLeaf";
			break;
		}
		case 8: {
			name = "greenMapleLeaf";
			break;
		}
		case 9: {
			name = "brownMapleLeaf";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}