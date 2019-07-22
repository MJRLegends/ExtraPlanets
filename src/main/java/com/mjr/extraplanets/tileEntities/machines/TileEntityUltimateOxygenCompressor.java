package com.mjr.extraplanets.tileEntities.machines;

import java.util.EnumSet;

import com.mjr.extraplanets.blocks.machines.UltimateOxygenCompressor;

import micdoodle8.mods.galacticraft.api.item.IItemOxygenSupply;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.items.ItemOxygenTank;
import micdoodle8.mods.galacticraft.core.tile.TileEntityOxygen;
import micdoodle8.mods.galacticraft.core.util.FluidUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;

public class TileEntityUltimateOxygenCompressor extends TileEntityOxygen {
	public static final int TANK_TRANSFER_SPEED = 6;
	private boolean usingEnergy = false;

	public TileEntityUltimateOxygenCompressor() {
		super("container.ultimateoxygencompressor.name", 3600, 32);
		this.storage.setMaxExtract(35);
		this.inventory = NonNullList.withSize(3, ItemStack.EMPTY);
	}

	@Override
	public void update() {
		if (!this.world.isRemote) {
			ItemStack oxygenItemStack = this.getStackInSlot(2);
			if (oxygenItemStack != null && oxygenItemStack.getItem() instanceof IItemOxygenSupply) {
				IItemOxygenSupply oxygenItem = (IItemOxygenSupply) oxygenItemStack.getItem();
				int oxygenDraw = (int) Math.floor(Math.min(this.oxygenPerTick * 2.5F, this.getMaxOxygenStored() - this.getOxygenStored()));
				this.setOxygenStored(getOxygenStored() + oxygenItem.discharge(oxygenItemStack, oxygenDraw));
				if (this.getOxygenStored() > this.getMaxOxygenStored()) {
					this.setOxygenStored(this.getOxygenStored());
				}
			}
		}

		super.update();

		if (!this.world.isRemote) {
			this.usingEnergy = false;
			if (this.getOxygenStored() > 0 && this.hasEnoughEnergyToRun) {
				ItemStack tank0 = this.getInventory().get(0);

				if (tank0 != null) {
					if (tank0.getItem() instanceof ItemOxygenTank && tank0.getItemDamage() > 0) {
						tank0.setItemDamage(tank0.getItemDamage() - TileEntityUltimateOxygenCompressor.TANK_TRANSFER_SPEED);
						this.setOxygenStored(this.getOxygenStored() - TileEntityUltimateOxygenCompressor.TANK_TRANSFER_SPEED);
						this.usingEnergy = true;
					}
				}
			}
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
		return new int[] { 0, 1, 2 };
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean canInsertItem(int slotID, ItemStack itemStack, EnumFacing side) {
		if (this.isItemValidForSlot(slotID, itemStack)) {
			switch (slotID) {
			case 0:
				return itemStack.getItemDamage() > 1;
			case 1:
				return ItemElectricBase.isElectricItemCharged(itemStack);
			case 2:
				return itemStack.getItemDamage() < itemStack.getItem().getMaxDamage();
			default:
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack itemStack, EnumFacing side) {
		switch (slotID) {
		case 0:
			return itemStack.getItem() instanceof ItemOxygenTank && itemStack.getItemDamage() == 0;
		case 1:
			return ItemElectricBase.isElectricItemEmpty(itemStack);
		case 2:
			return FluidUtil.isEmptyContainer(itemStack);
		default:
			return false;
		}
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemStack) {
		switch (slotID) {
		case 0:
			return itemStack.getItem() instanceof ItemOxygenTank;
		case 1:
			return ItemElectricBase.isElectricItem(itemStack.getItem());
		case 2:
			return itemStack.getItem() instanceof IItemOxygenSupply;
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

	@Override
	public boolean shouldUseOxygen() {
		return false;
	}

	@Override
	public EnumSet<EnumFacing> getOxygenInputDirections() {
		return EnumSet.of(this.getElectricInputDirection().getOpposite());
	}

	@Override
	public EnumSet<EnumFacing> getOxygenOutputDirections() {
		return EnumSet.noneOf(EnumFacing.class);
	}
}
