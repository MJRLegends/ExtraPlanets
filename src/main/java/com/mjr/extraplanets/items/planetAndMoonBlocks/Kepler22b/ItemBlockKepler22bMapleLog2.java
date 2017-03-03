package com.mjr.extraplanets.items.planetAndMoonBlocks.Kepler22b;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog2;

public class ItemBlockKepler22bMapleLog2 extends ItemBlock {
	public ItemBlockKepler22bMapleLog2(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

    @Override
    public int getMetadata(int meta)
    {
        return meta & 3;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return super.getUnlocalizedName() + "." + BlockKepler22bMapleTreeLog2.EnumType.byMetadata(itemStack.getMetadata()).getUnlocalizedName();
    }
}