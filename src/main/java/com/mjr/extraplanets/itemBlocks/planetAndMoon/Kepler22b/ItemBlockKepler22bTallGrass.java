package com.mjr.extraplanets.itemBlocks.planetAndMoon.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bTallGrass extends ItemBlock {
	public ItemBlockKepler22bTallGrass(Block block) {
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
			name = "blue_maple_short_grass";
			break;
		}
		case 1: {
			name = "blue_maple_med_grass";
			break;
		}
		case 2: {
			name = "blue_maple_tall_grass";
			break;
		}
		case 3: {
			name = "red_maple_short_grass";
			break;
		}
		case 4: {
			name = "red_maple_med_grass";
			break;
		}
		case 5: {
			name = "red_maple_tall_grass";
			break;
		}
		case 6: {
			name = "purple_maple_short_grass";
			break;
		}
		case 7: {
			name = "purple_maple_med_grass";
			break;
		}
		case 8: {
			name = "purple_maple_tall_grass";
			break;
		}
		case 9: {
			name = "yellow_maple_short_grass";
			break;
		}
		case 10: {
			name = "yellow_maple_med_grass";
			break;
		}
		case 11: {
			name = "yellow_maple_tall_grass";
			break;
		}
		case 12: {
			name = "green_maple_short_grass";
			break;
		}
		case 13: {
			name = "green_maple_med_grass";
			break;
		}
		case 14: {
			name = "green_maple_tall_grass";
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