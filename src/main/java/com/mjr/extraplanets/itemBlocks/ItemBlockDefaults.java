package com.mjr.extraplanets.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class ItemBlockDefaults extends ItemBlock {
	public ItemBlockDefaults(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public String getUnlocalizedName() {
		return this.field_150939_a.getUnlocalizedName() + ".0";
	}

	@Override
	public abstract String getUnlocalizedName(ItemStack itemstack);
}
