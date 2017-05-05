package com.mjr.extraplanets.tile;

import micdoodle8.mods.galacticraft.api.tile.ILandingPadAttachable;
import micdoodle8.mods.galacticraft.api.vector.BlockVec3;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.tile.TileEntityMulti;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.api.IPowerable;

import cpw.mods.fml.relauncher.Side;

public class TileEntityVehicleChanger extends TileBaseElectricBlockWithInventory implements ISidedInventory, ILandingPadAttachable {
	@NetworkedField(targetSide = Side.CLIENT)
	private ItemStack[] containingItems = new ItemStack[2];
	public IPowerable attachedPowerable;
	private boolean loadedPowerLastTick = false;

	public TileEntityVehicleChanger() {
		this.storage.setMaxExtract(30);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();

		if (!this.worldObj.isRemote) {
			this.loadedPowerLastTick = false;

			if (this.ticks % 100 == 0) {
				this.attachedPowerable = null;

				for (final ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
					final TileEntity pad = new BlockVec3(this).getTileEntityOnSide(this.worldObj, dir);

					if (pad instanceof TileEntityMulti) {
						final TileEntity mainTile = ((TileEntityMulti) pad).getMainBlockTile();

						if (mainTile instanceof IPowerable) {
							this.attachedPowerable = (IPowerable) mainTile;
							break;
						}
					} else if (pad instanceof IPowerable) {
						this.attachedPowerable = (IPowerable) pad;
						break;
					}
				}

			}

			if (this.storage.getEnergyStoredGC() > 10) {
				if (this.attachedPowerable != null && this.hasEnoughEnergyToRun && !this.disabled) {
					float filled = this.attachedPowerable.addPower(10, true);
					this.loadedPowerLastTick = filled == 10;
					this.storage.setEnergyStored(this.storage.getEnergyStoredGC() - filled);
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.containingItems = this.readStandardItemsFromNBT(par1NBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		this.writeStandardItemsToNBT(par1NBTTagCompound);
	}

	@Override
	protected ItemStack[] getContainingItems() {
		return this.containingItems;
	}

	@Override
	public String getInventoryName() {
		return GCCoreUtil.translate("container.vehicle.changer.name");
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return new int[] { 0, 1 };
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemstack, int side) {
		return this.isItemValidForSlot(slotID, itemstack);
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack itemstack, int side) {
		return false;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemstack) {
		return (slotID == 1 && itemstack != null && itemstack.getItem() == GCItems.fuelCanister) || (slotID == 0 ? ItemElectricBase.isElectricItem(itemstack.getItem()) : false);
	}

	@Override
	public boolean shouldUseEnergy() {
		return !this.getDisabled(0) && loadedPowerLastTick;
	}

	@Override
	public boolean canAttachToLandingPad(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}
