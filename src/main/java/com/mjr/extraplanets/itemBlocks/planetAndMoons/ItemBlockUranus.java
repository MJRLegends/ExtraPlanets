package com.mjr.extraplanets.itemBlocks.planetAndMoons;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockUranus extends ItemBlock
{
	public ItemBlockUranus(Block block)
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
			name = "ore_crystal";
			break;
		}
		case 4:
		{
			name = "crystal_block";
			break;
		}
		case 5:
		{
			name = "stone_bricks";
			break;
		}		
		case 6:
		{
			name = "dungeon_brick";
			break;
		}
		case 7:
		{
			name = "ore_white_gem";
			break;
		}
		case 8:
		{
			name = "white_gem_block";
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