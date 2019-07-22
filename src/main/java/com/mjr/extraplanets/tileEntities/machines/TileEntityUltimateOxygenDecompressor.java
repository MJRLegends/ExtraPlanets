package com.mjr.extraplanets.tileEntities.machines;

import java.util.EnumSet;

import com.mjr.extraplanets.blocks.machines.UltimateOxygenCompressor;

import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.items.ItemOxygenTank;
import micdoodle8.mods.galacticraft.core.tile.TileEntityOxygen;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;

public class TileEntityUltimateOxygenDecompressor extends TileEntityOxygen {
	public static final int OUTPUT_PER_TICK = 500;
	private boolean usingEnergy = false;

	public TileEntityUltimateOxygenDecompressor() {
		super("container.ultimateoxygendecompressor.name", 3600, 0);
		this.inventory = NonNullList.withSize(2, ItemStack.EMPTY);
	}

	@Override
	public void update() {
		super.update();

		if (!this.world.isRemote) {
			this.usingEnergy = false;
			ItemStack tank1 = this.getInventory().get(0);

			if (tank1 != null && this.hasEnoughEnergyToRun && this.getOxygenStored() < this.getMaxOxygenStored()) {
				if (tank1.getItem() instanceof ItemOxygenTank && tank1.getItemDamage() < tank1.getMaxDamage()) {
					tank1.setItemDamage(tank1.getItemDamage() + 1);
					this.receiveOxygen(1, true);
					this.usingEnergy = true;
				}
			}

			this.produceOxygen();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
		return this.world.getTileEntity(this.getPos()) == this && entityPlayer.getDistanceSq(this.getPos().getX() + 0.5D, this.getPos().getY() + 0.5D, this.getPos().getZ() + 0.5D) <= 64.0D;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[] { 0, 1 };
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemStack, EnumFacing side) {
		if (this.isItemValidForSlot(slotID, itemStack)) {
			switch (slotID) {
			case 0:
				return itemStack.getItemDamage() < itemStack.getMaxDamage();
			case 1:
				return ItemElectricBase.isElectricItemCharged(itemStack);
			default:
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack itemStack, EnumFacing side) {
		if (this.isItemValidForSlot(slotID, itemStack)) {
			switch (slotID) {
			case 0:
				return itemStack.getItemDamage() == itemStack.getMaxDamage();
			case 1:
				return ItemElectricBase.isElectricItemEmpty(itemStack);
			default:
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemStack) {
		switch (slotID) {
		case 0:
			return itemStack.getItem() instanceof ItemOxygenTank;
		case 1:
			return ItemElectricBase.isElectricItem(itemStack.getItem());
		}

		return false;
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public boolean shouldUseEnergy() {
		return this.usingEnergy;
	}

	@Override
	public EnumFacing getFront() {
		IBlockState state = this.world.getBlockState(getPos());
		if (state.getBlock() instanceof UltimateOxygenCompressor) {
			return state.getValue(UltimateOxygenCompressor.FACING).rotateY();
		}
		return EnumFacing.NORTH;
	}

	@Override
	public EnumFacing getElectricInputDirection() {
		return getFront();
	}

	@Override
	public ItemStack getBatteryInSlot() {
		return this.getStackInSlot(1);
	}

	public EnumFacing getOxygenOutputDirection() {
		return this.getElectricInputDirection().getOpposite();
	}

	@Override
	public EnumSet<EnumFacing> getOxygenInputDirections() {
		return EnumSet.noneOf(EnumFacing.class);
	}

	@Override
	public EnumSet<EnumFacing> getOxygenOutputDirections() {
		return EnumSet.of(this.getElectricInputDirection().getOpposite());
	}

	@Override
	public boolean shouldPullOxygen() {
		return false;
	}

	@Override
	public boolean shouldUseOxygen() {
		return false;
	}

	@Override
	public int getOxygenProvide(EnumFacing direction) {
		return this.getOxygenOutputDirections().contains(direction) ? Math.min(TileEntityUltimateOxygenDecompressor.OUTPUT_PER_TICK, this.getOxygenStored()) : 0;
	}
}
