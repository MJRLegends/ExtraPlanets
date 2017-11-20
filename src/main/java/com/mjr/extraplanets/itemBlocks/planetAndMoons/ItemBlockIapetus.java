package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

public class ItemBlockIapetus extends ItemBlockDefaults {
	public ItemBlockIapetus(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0:
		{
			name = "surface";
			break;
		}
		case 1:
		{
			name = "sub_surface";
			break;
		}
		case 2:
		{
			name = "stone";
			break;
		}
		case 3:
		{
			name = "ore_iron";
			break;
		}
		case 4:
		{
			name = "ore_tin";
			break;
		}
		case 5:
		{
			name = "ore_copper";
			break;
		}
		case 6: {
			name = "ice";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}