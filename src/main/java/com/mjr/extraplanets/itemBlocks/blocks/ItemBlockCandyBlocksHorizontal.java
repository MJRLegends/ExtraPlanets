package com.mjr.extraplanets.itemBlocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCandyBlocksHorizontal extends ItemBlock {
	public ItemBlockCandyBlocksHorizontal(Block block) {
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
			name = "candy_cane_red_horizontal";
			break;
		}
		case 1: {
			name = "candy_cane_green_horizontal";
			break;
		}
		case 2: {
			name = "candy_cane_blue_horizontal";
			break;
		}
		case 3: {
			name = "candy_cane_orange_horizontal";
			break;
		}
		case 4: {
			name = "candy_cane_magenta_horizontal";
			break;
		}
		case 5: {
			name = "candy_cane_pink_horizontal";
			break;
		}
		case 6: {
			name = "candy_cane_lime_horizontal";
			break;
		}
		case 7: {
			name = "candy_cane_purple_horizontal";
			break;
		}
		case 8: {
			name = "candy_cane_brown_horizontal";
			break;
		}
		case 9: {
			name = "candy_cane_black_horizontal";
			break;
		}
		default:
			name = "null";
		}

		return this.getBlock().getUnlocalizedName() + "." + name;
	}

	@Override
	public String getUnlocalizedName() {
		return this.getBlock().getUnlocalizedName() + ".0";
	}
}