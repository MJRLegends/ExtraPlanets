package com.mjr.extraplanets.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDecorativeBlocks extends ItemBlock
{
	public ItemBlockDecorativeBlocks(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";

		switch (itemstack.getItemDamage())
		{
		case 0:
		{
			name = "marble";
			break;
		}
		case 1:
		{
			name = "marbleBricks";
			break;
		}
		case 2:
		{
			name = "snowBricks";
			break;
		}
		case 3:
		{
			name = "iceBricks";
			break;
		}
		case 4:
		{
			name = "fireBricks";
			break;
		}
		case 5:
		{
			name = "blackWhiteFloor";
			break;
		}
		case 6:
		{
			name = "marbleTitledFloor";
			break;
		}
		case 7:
		{
			name = "marbleBrokenTitledFloor";
			break;
		}
		case 8:
		{
			name = "metalMesh";
			break;
		}
		case 9:
		{
			name = "frozenNitrogenBricks";
			break;
		}
		default:
			name = "null";
		}

		return this.field_150939_a.getUnlocalizedName() + "." + name;
	}

	@Override
	public String getUnlocalizedName()
	{
		return this.field_150939_a.getUnlocalizedName() + ".0";
	}
}