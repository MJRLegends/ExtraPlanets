package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.ItemBlockDefaults;

public class ItemBlockNeptune extends ItemBlockDefaults {
	public ItemBlockNeptune(Block block) {
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
		case 6: {
			name = "oreZinc";
			break;
		}
		case 7: {
			name = "zincBlock";
			break;
		}
		case 8: {
			name = "stoneBricks";
			break;
		}
		case 9: {
			name = "oreBlueGem";
			break;
		}
		case 10: {
			name = "blueGemBlock";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}