package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockUranus extends ItemBlockDefaults {
	public ItemBlockUranus(Block block) {
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
			name = "oreCrystal";
			break;
		}
		case 4: {
			name = "crystalBlock";
			break;
		}
		case 5: {
			name = "stoneBricks";
			break;
		}
		case 6: {
			name = "oreWhiteGem";
			break;
		}
		case 7: {
			name = "whiteGemBlock";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}