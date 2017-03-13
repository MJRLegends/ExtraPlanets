package com.mjr.extraplanets.tile.machines;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.util.FluidUtil;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.AdvancedRefinery;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class TileEntityBasicDecrystallizer extends TileBaseElectricBlockWithInventory implements ISidedInventory, IFluidHandler{
	private final int tankCapacity = 20000;
	private int amountAdded = 0;
	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank outputTank = new FluidTank(this.tankCapacity);

	public static final int PROCESS_TIME_REQUIRED = 1;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private ItemStack[] containingItems = new ItemStack[3];

	public TileEntityBasicDecrystallizer() {
		this.outputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.salt_fluid, 0));
	}

	@Override
	public void update() {
		super.update();

		if (!this.worldObj.isRemote) {
			checkFluidTankTransfer(2, this.outputTank);

			if (this.canProcess() && this.hasEnoughEnergyToRun) {
				if (this.processTicks == 0) {
					this.processTicks = TileEntityBasicDecrystallizer.PROCESS_TIME_REQUIRED;
				} else {
					if (--this.processTicks <= 0) {
						this.smeltItem();
						this.processTicks = this.canProcess() ? TileEntityBasicDecrystallizer.PROCESS_TIME_REQUIRED : 0;
					}
				}
			} else {
				this.processTicks = 0;
			}
		}
	}

	private void checkFluidTankTransfer(int slot, FluidTank tank) {
		FluidUtil.tryFillContainerFuel(tank, this.containingItems, slot);
	}

	public int getScaledFuelLevel(int i) {
		return this.outputTank.getFluidAmount() * i / this.outputTank.getCapacity();
	}

	public boolean canProcess() {
		if (this.outputTank.getFluidAmount() >= this.outputTank.getCapacity()) {
			return false;
		}
		if (this.containingItems[1] == null)
			return false;
		else if (this.containingItems[1].getItem() == new ItemStack(ExtraPlanets_Items.antiRadationParts, 1, 0).getItem())
			return true;
		return !this.getDisabled(0);

	}

	public void smeltItem() {
		if (this.canProcess()) {
			final int amountToAdd = 25;
			amountAdded = amountAdded + amountToAdd;
			this.outputTank.fill(FluidRegistry.getFluidStack("salt_fluid", amountToAdd), true);
			if (amountAdded == 1000)
			{
				amountAdded = 0;
				this.decrStackSize(1, 1);
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.processTicks = nbt.getInteger("smeltingTicks");
		this.containingItems = this.readStandardItemsFromNBT(nbt);

		if (nbt.hasKey("outputTank")) {
			this.outputTank.readFromNBT(nbt.getCompoundTag("outputTank"));
		}
		if (this.outputTank.getFluid() != null && this.outputTank.getFluid().getFluid() != ExtraPlanets_Fluids.salt_fluid) {
			this.outputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.salt_fluid, this.outputTank.getFluidAmount()));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("smeltingTicks", this.processTicks);
		this.writeStandardItemsToNBT(nbt);

		if (this.outputTank.getFluid() != null) {
			nbt.setTag("outputTank", this.outputTank.writeToNBT(new NBTTagCompound()));
		}
	}

	@Override
	protected ItemStack[] getContainingItems() {
		return this.containingItems;
	}

	@Override
	public String getName() {
		return GCCoreUtil.translate("container.basic.decrystallizer.name");
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[] { 0, 1, 2 };
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemstack, EnumFacing side) {
		if (itemstack != null && this.isItemValidForSlot(slotID, itemstack)) {
			switch (slotID) {
			case 0:
				return itemstack.getItem() instanceof ItemElectricBase && ((ItemElectricBase) itemstack.getItem()).getElectricityStored(itemstack) > 0;
			case 1:
				return FluidUtil.isOilContainerAny(itemstack);
			case 2:
				return FluidUtil.isEmptyContainer(itemstack, GCItems.fuelCanister);
			default:
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack itemstack, EnumFacing side) {
		if (itemstack != null && this.isItemValidForSlot(slotID, itemstack)) {
			switch (slotID) {
			case 0:
				return itemstack.getItem() instanceof ItemElectricBase && ((ItemElectricBase) itemstack.getItem()).getElectricityStored(itemstack) <= 0 || !this.shouldPullEnergy();
			case 1:
				return FluidUtil.isEmptyContainer(itemstack);
			case 2:
				return FluidUtil.isFullContainer(itemstack);
			default:
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemstack) {
		switch (slotID) {
		case 0:
			return itemstack != null && ItemElectricBase.isElectricItem(itemstack.getItem());
		case 1:
		case 2:
			return FluidUtil.isValidContainer(itemstack);
		}

		return false;
	}

	@Override
	public boolean shouldUseEnergy() {
		return this.canProcess();
	}

	@Override
	public EnumFacing getElectricInputDirection() {
		return EnumFacing.UP;
	}

	@Override
	public EnumFacing getFront() {
		return (this.worldObj.getBlockState(getPos()).getValue(AdvancedRefinery.FACING));
	}

	@Override
	public boolean canDrain(EnumFacing from, Fluid fluid) {
		if (from.equals(getFront())) {
			return this.outputTank.getFluid() != null && this.outputTank.getFluidAmount() > 0;
		}

		return false;
	}

	@Override
	public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain) {
		if (from.equals(getFront())) {
			return this.outputTank.drain(resource.amount, doDrain);
		}

		return null;
	}

	@Override
	public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain) {
		if (from.equals(getFront())) {
			return this.drain(from, new FluidStack(ExtraPlanets_Fluids.salt_fluid, maxDrain), doDrain);
		}

		return null;
	}

	@Override
	public FluidTankInfo[] getTankInfo(EnumFacing from) {
		FluidTankInfo[] tankInfo = new FluidTankInfo[] {};

		if (from.equals(getFront())) {
			tankInfo = new FluidTankInfo[] { new FluidTankInfo(this.outputTank) };
		}

		return tankInfo;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}

	@Override
	public int fill(EnumFacing from, FluidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public boolean canFill(EnumFacing from, Fluid fluid) {
		return false;
	}
}
