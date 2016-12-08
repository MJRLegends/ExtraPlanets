package com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockKepler22bPlanks extends ItemBlock
{
	public ItemBlockKepler22bPlanks(Block block)
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
			name = "PlankMapleBlue";
			break;
		}
		case 1:
		{
			name = "PlankMapleRed";
			break;
		}
		case 2:
		{
			name = "PlankMaplePurple";
			break;
		}
		case 3:
		{
			name = "PlankMapleYellow";
			break;
		}
		case 4:
		{
			name = "PlankMapleGreen";
			break;
		}
		case 5:
		{
			name = "PlankMapleBrown";
			break;
		}
		default:
			name = "null";
		}
		return this.block.getUnlocalizedName() + "." + name;
	}

	@Override
	public String getUnlocalizedName()
	{
		return this.block.getUnlocalizedName() + ".0";
	}
}