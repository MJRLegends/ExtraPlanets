package com.mjr.extraplanets.itemBlocks.machines;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.blocks.machines.UltimateOxygenCompressor;

public class ItemBlockUltimateOxygenCompressor extends ItemBlockDesc {
	public ItemBlockUltimateOxygenCompressor(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int metadata = 0;

		if (itemstack.getItemDamage() >= UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA) {
			metadata = 1;
		} else if (itemstack.getItemDamage() >= UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA) {
			metadata = 0;
		}

		return this.getBlock().getUnlocalizedName() + "." + metadata;
	}

	@Override
	public String getUnlocalizedName() {
		return this.getBlock().getUnlocalizedName() + ".0";
	}
}
