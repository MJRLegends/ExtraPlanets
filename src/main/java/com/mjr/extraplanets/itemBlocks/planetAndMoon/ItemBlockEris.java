package com.mjr.extraplanets.itemBlocks.planetAndMoon;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEris extends ItemBlock
{
	public ItemBlockEris(Block block)
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
		case 6:
		{
			name = "oreDarkIron";
			break;
		}
		case 7:
		{
			name = "darkIron_block";
			break;
		}
		case 8:
		{
			name = "stone_bricks";
			break;
		}
		case 9:
		{
			name = "dungeonBrick";
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