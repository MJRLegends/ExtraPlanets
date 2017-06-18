package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockOberon extends ItemBlockDefaults {
	public ItemBlockOberon(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "surface";
			break;
		}
		case 1: {
			name = "subSurface";
			break;
		}
		case 2: {
			name = "stone";
			break;
		}
		case 3: {
			name = "oreIron";
			break;
		}
		case 4: {
			name = "oreTin";
			break;
		}
		case 5: {
			name = "oreCopper";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}