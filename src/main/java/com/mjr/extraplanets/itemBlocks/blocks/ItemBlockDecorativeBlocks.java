package com.mjr.extraplanets.itemBlocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDecorativeBlocks extends ItemBlock {
	public ItemBlockDecorativeBlocks(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		String name = "";

		switch (itemStack.getItemDamage()) {
		case 0: {
			name = "marble";
			break;
		}
		case 1: {
			name = "marble_bricks";
			break;
		}
		case 2: {
			name = "snow_bricks";
			break;
		}
		case 3: {
			name = "ice_bricks";
			break;
		}
		case 4: {
			name = "fire_bricks";
			break;
		}
		case 5: {
			name = "black_white_floor";
			break;
		}
		case 6: {
			name = "marble_titled_floor";
			break;
		}
		case 7: {
			name = "marble_broken_titled_floor";
			break;
		}
		case 8: {
			name = "metal_mesh";
			break;
		}
		case 9: {
			name = "frozen_nitrogen_bricks";
			break;
		}
		case 10: {
			name = "volcanic_rock_bricks";
			break;
		}
		case 11: {
			name = "carbon_titled_floor";
			break;
		}
		case 12: {
			name = "carbon_broken_titled_floor";
			break;
		}
		case 13: {
			name = "magnesium_titled_floor";
			break;
		}
		case 14: {
			name = "magnesium_broken_titled_floor";
			break;
		}
		case 15: {
			name = "ash_bricks";
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