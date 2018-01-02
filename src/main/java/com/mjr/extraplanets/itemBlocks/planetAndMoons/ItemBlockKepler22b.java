package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

public class ItemBlockKepler22b extends ItemBlockDefaults {
	public ItemBlockKepler22b(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "dirt";
			break;
		}
		case 1: {
			name = "stone";
			break;
		}
		case 2: {
			name = "ore_iron";
			break;
		}
		case 3: {
			name = "ore_tin";
			break;
		}
		case 4: {
			name = "ore_copper";
			break;
		}
		case 5: {
			name = "ore_dense_coal";
			break;
		}
		case 6: {
			name = "ore_blue_diamonds";
			break;
		}
		case 7: {
			name = "ore_red_diamonds";
			break;
		}
		case 8: {
			name = "ore_purple_diamonds";
			break;
		}
		case 9: {
			name = "ore_yellow_diamonds";
			break;
		}
		case 10: {
			name = "ore_green_diamonds";
			break;
		}
		case 11: {
			name = "stone_bricks";
			break;
		}
		case 12: {
			name = "cobblestone";
			break;
		}
		case 13: {
			name = "ore_platinum";
			break;
		}
		default:
			name = "null";
		}
		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}