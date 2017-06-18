package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockKepler22bMapleLeaf extends ItemBlockDefaults {
	public ItemBlockKepler22bMapleLeaf(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "blueMapleLeaf";
			break;
		}
		case 1: {
			name = "redMapleLeaf";
			break;
		}
		case 2: {
			name = "purpleMapleLeaf";
			break;
		}
		case 3: {
			name = "yellowMapleLeaf";
			break;
		}
		case 4: {
			name = "blueMapleLeaf";
			break;
		}
		case 5: {
			name = "redMapleLeaf";
			break;
		}
		case 6: {
			name = "purpleMapleLeaf";
			break;
		}
		case 7: {
			name = "yellowMapleLeaf";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}