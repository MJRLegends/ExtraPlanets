package com.mjr.extraplanets.itemBlocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public abstract class ItemBlockDescDefaults extends ItemBlockDesc {
	public ItemBlockDescDefaults(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName() {
		return this.field_150939_a.getUnlocalizedName() + ".0";
	}
	
	@Override
	public abstract String getUnlocalizedName(ItemStack itemstack);
}
