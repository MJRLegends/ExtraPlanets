package com.mjr.extraplanets.itemBlocks.machines;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.blocks.machines.UltimateOxygenCompressor;
import com.mjr.extraplanets.itemBlocks.ItemBlockDescDefaults;

public class ItemBlockUltimateOxygenCompressor extends ItemBlockDescDefaults {
	public ItemBlockUltimateOxygenCompressor(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int metadata = 0;

		if (itemstack.getItemDamage() >= UltimateOxygenCompressor.OXYGEN_DECOMPRESSOR_METADATA) {
			metadata = 1;
		} else if (itemstack.getItemDamage() >= UltimateOxygenCompressor.OXYGEN_COMPRESSOR_METADATA) {
			metadata = 0;
		}

		return this.field_150939_a.getUnlocalizedName() + "." + metadata;
	}
}