package com.mjr.extraplanets.inventory.machines;

import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import micdoodle8.mods.galacticraft.core.energy.EnergyUtil;
import micdoodle8.mods.galacticraft.core.inventory.SlotSpecific;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecontaminationUnit;

public class ContainerBasicDecontaminationUnit extends Container {
	private final TileEntityBasicDecontaminationUnit tileEntity;

	public ContainerBasicDecontaminationUnit(InventoryPlayer par1InventoryPlayer, TileEntityBasicDecontaminationUnit tileEntity, EntityPlayer player) {
		this.tileEntity = tileEntity;

		// Electric Input Slot
		this.addSlotToContainer(new SlotSpecific(tileEntity, 0, 153, 7, IItemElectric.class));

		int var3;

		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 104 + var3 * 18 - 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 144));
		}

		tileEntity.openInventory(player);
	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer) {
		super.onContainerClosed(entityplayer);
		this.tileEntity.closeInventory(entityplayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.tileEntity.isUsableByPlayer(par1EntityPlayer);
	}

	/**
	 * Called to transfer a stack from one inventory to the other eg. when shift clicking.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par1) {
		ItemStack var2 = null;
		final Slot slot = (Slot) this.inventorySlots.get(par1);
		final int b = this.inventorySlots.size();

		if (slot != null && slot.getHasStack()) {
			final ItemStack stack = slot.getStack();
			var2 = stack.copy();

			if (par1 == 0) {
				if (!this.mergeItemStack(stack, b - 36, b, true)) {
					return null;
				}
			} else {
				if (EnergyUtil.isElectricItem(stack.getItem())) {
					if (!this.mergeItemStack(stack, 0, 1, false)) {
						return null;
					}
				} else {
					if (par1 < b - 9) {
						if (!this.mergeItemStack(stack, b - 9, b, false)) {
							return null;
						}
					} else if (!this.mergeItemStack(stack, b - 36, b - 9, false)) {
						return null;
					}
				}
			}
			if (stack.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (stack.getCount() == var2.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(par1EntityPlayer, stack);
		}

		return var2;
	}
}