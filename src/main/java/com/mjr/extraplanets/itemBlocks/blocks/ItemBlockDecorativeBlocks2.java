package com.mjr.extraplanets.itemBlocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDecorativeBlocks2 extends ItemBlock
{
	public ItemBlockDecorativeBlocks2(Block block)
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
		case 0: {
			name = "white_block";
			break;
		}
		case 1: {
			name = "red_block";
			break;
		}
		case 2: {
			name = "blue_block";
			break;
		}
		case 3: {
			name = "light_blue_block";
			break;
		}
		case 4: {
			name = "yellow_block";
			break;
		}
		case 5: {
			name = "green_block";
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