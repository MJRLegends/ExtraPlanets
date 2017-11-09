package com.mjr.extraplanets.itemBlocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCakeBlocks extends ItemBlock
{
	public ItemBlockCakeBlocks(Block block)
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
			name = "cake_block";
			break;
		}
		case 1:
		{
			name = "cake_block_red_velvet";
			break;
		}
		case 2:
		{
			name = "cake_block_chocolate";
			break;
		}
		case 3:
		{
			name = "white_icing_red_dots";
			break;
		}
		case 4:
		{
			name = "white_icing_green_dots";
			break;
		}
		case 5:
		{
			name = "white_icing_pink_dots";
			break;
		}
		case 6:
		{
			name = "white_icing_orange_dots";
			break;
		}
		case 7:
		{
			name = "cookie_rocks";
			break;
		}
		default:
			name = "null";
		}

		return this.getBlock().getUnlocalizedName() + "." + name;
	}

    @Override
    public String getUnlocalizedName()
    {
        return this.getBlock().getUnlocalizedName() + ".0";
    }
}