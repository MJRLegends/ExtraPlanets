package com.mjr.extraplanets.tile.machines;

import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.util.FluidUtil;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.BasicDecrystallizer;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class TileEntityBasicDecrystallizer extends TileBaseElectricBlockWithInventory implements ISidedInventory {
	private final int tankCapacity = 20000;
	private int amountAdded = 0;
	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank outputTank = new FluidTank(this.tankCapacity);

	public static final int PROCESS_TIME_REQUIRED = 1;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);

	public TileEntityBasicDecrystallizer() {
		this.outputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.SALT_FLUID, 0));
	}

	@Override
	public void update() {
		super.update();

		if (!this.world.isRemote) {
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
		if (this.getStackInSlot(slot) != null) {
			if (this.getStackInSlot(slot).getItem() == Items.BUCKET && tank.getFluidAmount() >= 1000 && this.getStackInSlot(slot).getCount() == 1) {
				tank.drain(1000, true);
				// this.setInventorySlotContents(slot, new ItemStack(ExtraPlanets_Items.BUCKET_SALT));
			} else
				FluidUtil.tryFillContainerFuel(tank, this.stacks, slot);
		}
	}

	public int getScaledFuelLevel(int i) {
		return this.outputTank.getFluidAmount() * i / this.outputTank.getCapacity();
	}

	public boolean canProcess() {
		if (this.outputTank.getFluidAmount() >= this.outputTank.getCapacity()) {
			return false;
		}
		if (this.stacks.get(1).isEmpty())
			return false;
		else if (this.stacks.get(1).getItem() != ExtraPlanets_Items.IODIDE_SALT)
			return false;
		return !this.getDisabled(0);

	}

	public void smeltItem() {
		if (this.canProcess()) {
			final int amountToAdd = 25;
			amountAdded = amountAdded + amountToAdd;
			this.outputTank.fill(FluidRegistry.getFluidStack("salt_fluid", amountToAdd), true);
			if (amountAdded == 1000) {
				amountAdded = 0;
				this.decrStackSize(1, 1);
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.processTicks = nbt.getInteger("smeltingTicks");
		this.stacks = this.readStandardItemsFromNBT(nbt);

		if (nbt.hasKey("outputTank")) {
			this.outputTank.readFromNBT(nbt.getCompoundTag("outputTank"));
		}
		if (this.outputTank.getFluid() != null && this.outputTank.getFluid().getFluid() != ExtraPlanets_Fluids.SALT_FLUID) {
			this.outputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.SALT_FLUID, this.outputTank.getFluidAmount()));
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("smeltingTicks", this.processTicks);
		this.writeStandardItemsToNBT(nbt, this.stacks);

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
				return itemstack.getItem() == ExtraPlanets_Items.IODIDE_SALT;
			case 2:
				return itemstack.getItem() == Items.BUCKET;
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
			case 2:
				return FluidUtil.isValidContainer(itemstack);
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
		return EnumFacing.getHorizontal(((this.getBlockMetadata() & 3) + 1) % 4);
	}

	@Override
	public EnumFacing getFront() {
		IBlockState state = this.world.getBlockState(getPos());
		if (state.getBlock() instanceof BasicDecrystallizer) {
			return state.getValue(BasicDecrystallizer.FACING);
		}
		return EnumFacing.NORTH;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}
}
