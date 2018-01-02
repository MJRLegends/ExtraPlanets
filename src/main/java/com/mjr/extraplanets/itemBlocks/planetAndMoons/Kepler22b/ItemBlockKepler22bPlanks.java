package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

public class ItemBlockKepler22bPlanks extends ItemBlockDefaults {
	public ItemBlockKepler22bPlanks(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "plank_maple_blue";
			break;
		}
		case 1: {
			name = "plank_maple_red";
			break;
		}
		case 2: {
			name = "plank_maple_purple";
			break;
		}
		case 3: {
			name = "plank_maple_yellow";
			break;
		}
		case 4: {
			name = "plank_maple_green";
			break;
		}
		case 5: {
			name = "plank_maple_brown";
			break;
		}
		default:
			name = "null";
		}
		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}