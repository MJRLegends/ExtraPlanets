package com.mjr.extraplanets.itemBlocks.planetAndMoons.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.mjr.extraplanets.itemBlocks.blocks.ItemBlockDefaults;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockKepler22bMapleSapling extends ItemBlockDefaults {
	public ItemBlockKepler22bMapleSapling(Block block) {
		super(block);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return this.field_150939_a.getIcon(0, meta);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "blue_maple_sapling";
			break;
		}
		case 1: {
			name = "red_maple_sapling";
			break;
		}
		case 2: {
			name = "purple_maple_sapling";
			break;
		}
		case 3: {
			name = "yellow_maple_sapling";
			break;
		}
		case 4: {
			name = "green_maple_sapling";
			break;
		}
		case 5: {
			name = "brown_maple_sapling";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}
}