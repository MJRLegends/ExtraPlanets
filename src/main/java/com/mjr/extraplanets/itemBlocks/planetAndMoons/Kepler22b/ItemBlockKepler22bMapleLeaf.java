package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

public class ItemBlockKepler22bMapleLeaf extends ItemBlockDefaults {
	public ItemBlockKepler22bMapleLeaf(Block block) {
		super(block);
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
			name = "blue_maple_leaf";
			break;
		}
		case 5: {
			name = "red_maple_leaf";
			break;
		}
		case 6: {
			name = "purple_maple_leaf";
			break;
		}
		case 7: {
			name = "yellow_maple_leaf";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}