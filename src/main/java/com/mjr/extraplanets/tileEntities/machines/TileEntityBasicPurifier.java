package com.mjr.extraplanets.tileEntities.machines;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.BasicPurifier;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.api.transmission.NetworkType;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.util.FluidUtil;
import micdoodle8.mods.galacticraft.core.wrappers.FluidHandlerWrapper;
import micdoodle8.mods.galacticraft.core.wrappers.IFluidHandlerWrapper;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;

public class TileEntityBasicPurifier extends TileBaseElectricBlockWithInventory implements ISidedInventory, IFluidHandlerWrapper {
	private final int tankCapacity = 20000;
	private int amountDrain = 0;
	private int amountDrain2 = 0;

	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank inputTank = new FluidTank(this.tankCapacity);

	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank inputTank2 = new FluidTank(this.tankCapacity);

	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank outputTank = new FluidTank(this.tankCapacity);

	public static final int PROCESS_TIME_REQUIRED = 5;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(5, ItemStack.EMPTY);

	public TileEntityBasicPurifier() {
		this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID, 0));
		this.inputTank2.setFluid(new FluidStack(ExtraPlanets_Fluids.INFECTED_WATER_FLUID, 0));
		this.outputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.CLEAN_WATER_FLUID, 0));
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return (T) new FluidHandlerWrapper(this, facing);
		}
        return super.getCapability(capability, facing);
	}

	@Override
	public void update() {
		super.update();

		if (!this.world.isRemote) {
			checkFluidTankTransfer(1, this.inputTank);
			checkFluidTankTransfer(2, this.inputTank2);
			checkFluidTankTransfer(3, this.outputTank);

			if (this.canProcess() && this.hasEnoughEnergyToRun) {
				if (this.processTicks == 0) {
					this.processTicks = TileEntityBasicPurifier.PROCESS_TIME_REQUIRED;
				} else {
					if (--this.processTicks <= 0) {
						this.smeltItem();
						this.processTicks = this.canProcess() ? TileEntityBasicPurifier.PROCESS_TIME_REQUIRED : 0;
					}
				}
			} else {
				this.processTicks = 0;
			}
		}
	}

	private void checkFluidTankTransfer(int slot, FluidTank tank) {
		ItemStack item = this.getStackInSlot(slot);
		FluidStack stack = FluidUtil.getFluidContained(item);
		if (item != null && FluidUtil.isValidContainer(item)) {
			if (FluidUtil.isEmptyContainer(item) == false && stack != null && stack.getFluid() != null) {
				if (slot == 1 && stack.getFluid().equals(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID) && tank.getFluidAmount() <= tank.getCapacity()) {
					FluidUtil.loadFromContainer(tank, ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID, stacks, slot, stack.amount);
				}
				if (slot == 2 && stack.getFluid().equals(ExtraPlanets_Fluids.INFECTED_WATER_FLUID) && tank.getFluidAmount() <= tank.getCapacity()) {
					FluidUtil.loadFromContainer(tank, ExtraPlanets_Fluids.INFECTED_WATER_FLUID, stacks, slot, stack.amount);
				}
			}
			if (slot == 3) {
				if (item.getItem() == Items.BUCKET && tank.getFluidAmount() >= 1000 && item.getCount() == 1) {
					if (FluidUtil.isValidContainer(item)) {
						final FluidStack liquid = tank.getFluid();

						if (liquid != null) {
							FluidUtil.tryFillContainer(tank, liquid, this.stacks, slot, ForgeModContainer.getInstance().universalBucket);
						}
					}
				}
			}
		}
	}

	public int getScaledLevelInputTank(int i) {
		return this.inputTank.getFluidAmount() * i / this.inputTank.getCapacity();
	}

	public int getScaledLevelInputTank2(int i) {
		return this.inputTank2.getFluidAmount() * i / this.inputTank2.getCapacity();
	}

	public int getScaledLevelOutputTank(int i) {
		return this.outputTank.getFluidAmount() * i / this.outputTank.getCapacity();
	}

	public boolean canProcess() {
		if (this.inputTank.getFluidAmount() <= 0 && this.inputTank2.getFluidAmount() <= 0) {
			if (amountDrain <= 0 & amountDrain2 <= 0)
				return false;
		}
		if (this.outputTank.getFluidAmount() >= this.outputTank.getCapacity())
			return false;
		return !this.getDisabled(0);
	}

	public boolean canPurify() {
		if (this.stacks.get(4).isEmpty())
			return false;
		else if (this.stacks.get(4).getItem() != ExtraPlanets_Items.IODIDE_SALT)
			return false;
		else if (this.stacks.get(4).getCount() < 6)
			return false;
		else
			return true;
	}

	public boolean hasInputs() {
		if (this.inputTank.getFluidAmount() >= 50 || this.inputTank2.getFluidAmount() >= 50)
			if (!this.stacks.get(4).isEmpty() && this.stacks.get(4).getItem() == ExtraPlanets_Items.IODIDE_SALT)
				if (this.stacks.get(4).getCount() >= 6)
					return true;
		return false;
	}

	public void smeltItem() {
		if (this.canProcess() && canPurify() && hasInputs()) {
			final int amountToDrain = 50;
			if (this.inputTank.getFluidAmount() >= amountToDrain) {
				this.inputTank.drain(amountToDrain, true);
				amountDrain = amountDrain + amountToDrain;
				if (amountDrain >= 1000) {
					this.inputTank2.fill(FluidRegistry.getFluidStack("infected_water_fluid", 1000), true);
					amountDrain = 0;
					this.decrStackSize(4, 6);
				}
			}
			if (this.inputTank2.getFluidAmount() >= amountToDrain) {
				this.inputTank2.drain(amountToDrain, true);
				amountDrain2 = amountDrain2 + amountToDrain;
				if (amountDrain2 >= 1000) {
					this.outputTank.fill(FluidRegistry.getFluidStack("clean_water_fluid", 1000), true);
					amountDrain2 = 0;
					this.decrStackSize(4, 6);
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.processTicks = nbt.getInteger("smeltingTicks");
		this.stacks = this.readStandardItemsFromNBT(nbt);

		if (nbt.hasKey("inputTank")) {
			this.inputTank.readFromNBT(nbt.getCompoundTag("inputTank"));
		}
		if (nbt.hasKey("inputTank2")) {
			this.inputTank2.readFromNBT(nbt.getCompoundTag("inputTank2"));
		}
		if (nbt.hasKey("outputTank")) {
			this.outputTank.readFromNBT(nbt.getCompoundTag("outputTank"));
		}
		if (this.inputTank.getFluid() != null && this.inputTank.getFluid().getFluid() != ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID) {
			this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.SALT_FLUID, this.inputTank.getFluidAmount()));
		}
		if (this.inputTank2.getFluid() != null && this.inputTank2.getFluid().getFluid() != ExtraPlanets_Fluids.INFECTED_WATER_FLUID) {
			this.inputTank2.setFluid(new FluidStack(ExtraPlanets_Fluids.INFECTED_WATER_FLUID, this.inputTank2.getFluidAmount()));
		}
		if (this.outputTank.getFluid() != null && this.outputTank.getFluid().getFluid() != ExtraPlanets_Fluids.CLEAN_WATER_FLUID) {
			this.outputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.CLEAN_WATER_FLUID, this.outputTank.getFluidAmount()));
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("smeltingTicks", this.processTicks);
		this.writeStandardItemsToNBT(nbt, this.stacks);

		if (this.inputTank.getFluid() != null) {
			nbt.setTag("inputTank", this.inputTank.writeToNBT(new NBTTagCompound()));
		}
		if (this.inputTank2.getFluid() != null) {
			nbt.setTag("inputTank2", this.inputTank2.writeToNBT(new NBTTagCompound()));
		}
		if (this.outputTank.getFluid() != null) {
			nbt.setTag("outputTank", this.outputTank.writeToNBT(new NBTTagCompound()));
		}
		return nbt;
	}

	@Override
	protected NonNullList<ItemStack> getContainingItems() {
		return this.stacks;
	}

	@Override
	public String getName() {
		return TranslateUtilities.translate("container.basic.purifier.name");
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.NORTH) {
			return new int[] { 4 };
		}
		return new int[] { 0, 1, 2, 3, 4 };
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemstack, EnumFacing side) {
		if (itemstack != null && this.isItemValidForSlot(slotID, itemstack)) {
			switch (slotID) {
			case 0:
				return ItemElectricBase.isElectricItemCharged(itemstack);
			case 4:
				return itemstack.getItem() == ExtraPlanets_Items.IODIDE_SALT;
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
				return ItemElectricBase.isElectricItemEmpty(itemstack) || !this.shouldPullEnergy();
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
		case 3:
			return FluidUtil.isValidContainer(itemstack);
		case 4:
			return itemstack.getItem() == ExtraPlanets_Items.IODIDE_SALT;
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
		IBlockState state = this.world.getBlockState(getPos());
		if (state.getBlock() instanceof BasicPurifier) {
			return state.getValue(BasicPurifier.FACING);
		}
		return EnumFacing.NORTH;
	}

	@Override
	public boolean canConnect(EnumFacing direction, NetworkType type) {
		if (type == NetworkType.POWER) {
			return direction == this.getElectricInputDirection();
		}
		if (type == NetworkType.FLUID) {
			EnumFacing pipeSide = getInputPipe();
			return direction == pipeSide || direction == pipeSide.getOpposite() || direction == EnumFacing.DOWN;
		}
		return false;
	}

	private EnumFacing getInputPipe() {
		return getFront().rotateY();
	}

	private EnumFacing getInput2Pipe() {
		return getFront().rotateYCCW();
	}

	@Override
	public boolean canDrain(EnumFacing from, Fluid fluid) {
		getFront().rotateY();
		if (from == EnumFacing.DOWN) {
			return this.outputTank.getFluid() != null && this.outputTank.getFluidAmount() > 0;
		}

		return false;
	}

	@Override
	public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain) {
		getFront().rotateY();
		if (from == EnumFacing.DOWN && resource != null) {
			return this.outputTank.drain(resource.amount, doDrain);
		}

		return null;
	}

	@Override
	public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain) {
		getFront().rotateY();
		if (from == EnumFacing.DOWN) {
			return this.drain(from, new FluidStack(ExtraPlanets_Fluids.CLEAN_WATER_FLUID, maxDrain), doDrain);
		}

		return null;
	}

	@Override
	public boolean canFill(EnumFacing from, Fluid fluid) {
		if (from == getInputPipe()) {
			return this.inputTank.getFluid() == null || this.inputTank.getFluidAmount() < this.inputTank.getCapacity();
		}
		if (from == getInput2Pipe()) {
			return this.inputTank2.getFluid() == null || this.inputTank2.getFluidAmount() < this.inputTank2.getCapacity();
		}

		return false;
	}

	@Override
	public int fill(EnumFacing from, FluidStack resource, boolean doFill) {
		int used = 0;

		if (from == getInputPipe() && resource != null) {
			final String liquidName = FluidRegistry.getFluidName(resource);

			if (liquidName != null && liquidName.contains("radioactive_water")) {
				if (liquidName.equals("radioactive_water")) {
					used = this.inputTank.fill(resource, doFill);
				} else {
					used = this.inputTank.fill(new FluidStack(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID, resource.amount), doFill);
				}
			}
		}
		if (from == getInput2Pipe() && resource != null) {
			final String liquidName = FluidRegistry.getFluidName(resource);

			if (liquidName != null && liquidName.contains("infected_water")) {
				if (liquidName.equals("infected_water")) {
					used = this.inputTank2.fill(resource, doFill);
				} else {
					used = this.inputTank2.fill(new FluidStack(ExtraPlanets_Fluids.INFECTED_WATER_FLUID, resource.amount), doFill);
				}
			}
		}
		return used;
	}

	@Override
	public FluidTankInfo[] getTankInfo(EnumFacing from) {
		if (from == getInputPipe())
			return new FluidTankInfo[] { new FluidTankInfo(this.inputTank) };
		else
			return new FluidTankInfo[] { new FluidTankInfo(this.inputTank2) };
	}
}
