package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

public class ItemBlockSaturn extends ItemBlockDefaults {
	public ItemBlockSaturn(Block block) {
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
			name = "sub_surface";
			break;
		}
		case 2: {
			name = "stone";
			break;
		}
		case 3: {
			name = "ore_iron";
			break;
		}
		case 4: {
			name = "ore_tin";
			break;
		}
		case 5: {
			name = "ore_copper";
			break;
		}
		case 6: {
			name = "ore_magnesium";
			break;
		}
		case 7: {
			name = "magnesium_block";
			break;
		}
		case 8: {
			name = "stone_bricks";
			break;
		}
		case 9: {
			name = "broken_infected_stone";
			break;
		}
		case 10: {
			name = "infected_stone";
			break;
		}
		case 11: {
			name = "ore_slime";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}