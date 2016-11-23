package com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bMapleLog extends ItemBlock {
	public ItemBlockKepler22bMapleLog(Block block) {
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
			name = "blueMapleLog";
			break;
		}
		case 1: {
			name = "redMapleLog";
			break;
		}
		case 2: {
			name = "purpleMapleLog";
			break;
		}
		case 3: {
			name = "yellowMapleLog";
			break;
		}
		case 4: {
			name = "greenMapleLog";
			break;
		}
		case 5: {
			name = "brownMapleLog";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}