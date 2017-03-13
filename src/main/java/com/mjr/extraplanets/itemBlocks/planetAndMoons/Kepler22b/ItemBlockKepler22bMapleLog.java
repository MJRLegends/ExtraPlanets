package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

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
		case 0:
		case 4:
		case 8:
			name = "blueMapleLog";
			break;
		case 1:
		case 5:
		case 9:
			name = "redMapleLog";
			break;
		case 2:
		case 6:
		case 10:
			name = "purpleMapleLog";
			break;
		case 3:
		case 7:
		case 11:
			name = "yellowMapleLog";
			break;
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}