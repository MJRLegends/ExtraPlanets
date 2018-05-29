package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bPlanks extends ItemBlock {
	public ItemBlockKepler22bPlanks(Block block) {
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
		return this.block.getUnlocalizedName() + "." + name;
	}

	@Override
	public String getUnlocalizedName() {
		return this.block.getUnlocalizedName() + ".0";
	}
}