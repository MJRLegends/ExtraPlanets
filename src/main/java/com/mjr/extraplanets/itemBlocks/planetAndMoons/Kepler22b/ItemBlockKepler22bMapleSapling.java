package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

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
			name = "blue_maple_sapling";
			break;
		}
		case 1: {
			name = "red_maple_sapling";
			break;
		}
		case 2: {
			name = "purple_maple_sapling";
			break;
		}
		case 3: {
			name = "yellow_maple_sapling";
			break;
		}
		case 4: {
			name = "green_maple_sapling";
			break;
		}
		case 5: {
			name = "brown_maple_sapling";
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