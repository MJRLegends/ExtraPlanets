package com.mjr.extraplanets.items.planetAndMoonBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockJupiter extends ItemBlock
{
	public ItemBlockJupiter(Block block)
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
			name = "subSurface";
			break;
		}
		case 2:
		{
			name = "stone";
			break;
		}
		case 3:
		{
			name = "oreIron";
			break;
		}
		case 4:
		{
			name = "oreTin";
			break;
		}
		case 5:
		{
			name = "oreCopper";
			break;
		}
		case 6:
		{
			name = "orePalladium";
			break;
		}
		case 7:
		{
			name = "palladiumBlock";
			break;
		}
		case 8:
		{
			name = "stoneBricks";
			break;
		}
		case 9:
		{
			name = "dungeonBrick";
			break;
		}
		case 10:
		{
			name = "oreRedGem";
			break;
		}
		case 11:
		{
			name = "redGemBlock";
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