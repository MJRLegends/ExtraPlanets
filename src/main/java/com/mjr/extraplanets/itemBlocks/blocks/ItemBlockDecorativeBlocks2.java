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
		case 0:
		{
			name = "white_block";
			break;
		}
		case 1:
		{
			name = "red_block";
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