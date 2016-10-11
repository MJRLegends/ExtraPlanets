package com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return this.field_150939_a.getIcon(0, meta);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "blueMapleShortGrass";
			break;
		}
		case 1: {
			name = "blueMapleMedGrass";
			break;
		}
		case 2: {
			name = "blueMapleTallGrass";
			break;
		}
		case 3: {
			name = "redMapleShortGrass";
			break;
		}
		case 4: {
			name = "redMapleMedGrass";
			break;
		}
		case 5: {
			name = "redMapleTallGrass";
			break;
		}
		case 6: {
			name = "purpleMapleShortGrass";
			break;
		}
		case 7: {
			name = "purpleMapleMedGrass";
			break;
		}
		case 8: {
			name = "purpleMapleTallGrass";
			break;
		}
		case 9: {
			name = "yellowMapleShortGrass";
			break;
		}
		case 10: {
			name = "yellowMapleMedGrass";
			break;
		}
		case 11: {
			name = "yellowMapleTallGrass";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}

	@Override
	public String getUnlocalizedName() {
		return this.field_150939_a.getUnlocalizedName() + ".0";
	}
}