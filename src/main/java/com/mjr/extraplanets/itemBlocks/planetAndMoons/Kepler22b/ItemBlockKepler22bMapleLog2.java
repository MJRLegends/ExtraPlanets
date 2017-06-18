package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockKepler22bMapleLog2 extends ItemBlockDefaults {
	public ItemBlockKepler22bMapleLog2(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0:
		case 4:
		case 8:
			name = "greenMapleLog";
			break;
		case 1:
		case 5:
		case 9:
			name = "brownMapleLog";
			break;
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}