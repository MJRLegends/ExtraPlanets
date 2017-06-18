package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockKepler22bPlanks extends ItemBlockDefaults {
	public ItemBlockKepler22bPlanks(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "PlankMapleBlue";
			break;
		}
		case 1: {
			name = "PlankMapleRed";
			break;
		}
		case 2: {
			name = "PlankMaplePurple";
			break;
		}
		case 3: {
			name = "PlankMapleYellow";
			break;
		}
		case 4: {
			name = "PlankMapleGreen";
			break;
		}
		case 5: {
			name = "PlankMapleBrown";
			break;
		}
		default:
			name = "null";
		}
		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}