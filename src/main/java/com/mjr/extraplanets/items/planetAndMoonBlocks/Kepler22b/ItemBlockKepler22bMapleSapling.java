package com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bMapleSapling extends ItemBlock {
	public ItemBlockKepler22bMapleSapling(Block block) {
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
			name = "blueMapleSapling";
			break;
		}
		case 1: {
			name = "redMapleSapling";
			break;
		}
		case 2: {
			name = "purpleMapleSapling";
			break;
		}
		case 3: {
			name = "yellowMapleSapling";
			break;
		}
		case 4: {
			name = "greenMapleSapling";
			break;
		}
		case 5: {
			name = "brownMapleSapling";
			break;
		}
		default:
			name = "null";
		}

		return this.block.getUnlocalizedName() + "." + name;
	}

	@Override
	public String getUnlocalizedName() {
		return this.block.getUnlocalizedName() + ".0";
	}
}