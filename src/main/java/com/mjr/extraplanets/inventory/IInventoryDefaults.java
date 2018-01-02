package com.mjr.extraplanets.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public interface IInventoryDefaults extends IInventory {
	@Override
	public default int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public default void markDirty() {
	}

	@Override
	public default boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return true;
	}

	@Override
	public default void openInventory() {
	}

	@Override
	public default void closeInventory() {
	}

	@Override
	public default boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public default boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
