package com.mjr.extraplanets.tileEntities.machines;

import micdoodle8.mods.galacticraft.api.transmission.NetworkType;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.util.FluidUtil;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.wrappers.FluidHandlerWrapper;
import micdoodle8.mods.galacticraft.core.wrappers.IFluidHandlerWrapper;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.BasicCrystallizer;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class TileEntityBasicCrystallizer extends TileBaseElectricBlockWithInventory implements ISidedInventory, IFluidHandlerWrapper {
	private final int tankCapacity = 20000;
	private int amountDrain = 0;
	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank inputTank = new FluidTank(this.tankCapacity);

	public static final int PROCESS_TIME_REQUIRED = 5;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);

	private ItemStack producingStack = new ItemStack(ExtraPlanets_Items.IODIDE_SALT, 6, 0);

	public TileEntityBasicCrystallizer() {
		this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.SALT_FLUID, 0));
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return (T) new FluidHandlerWrapper(this, facing);
		}
		return null;
	}

	@Override
	public void update() {
		super.update();

		if (!this.world.isRemote) {
			checkFluidTankTransfer(2, this.inputTank);

			if (this.canProcess() && this.hasEnoughEnergyToRun) {
				if (this.processTicks == 0) {
					this.processTicks = TileEntityBasicCrystallizer.PROCESS_TIME_REQUIRED;
				} else {
					if (--this.processTicks <= 0) {
						this.smeltItem();
						this.processTicks = this.canProcess() ? TileEntityBasicCrystallizer.PROCESS_TIME_REQUIRED : 0;
					}
				}
			} else {
				this.processTicks = 0;
			}
		}
	}

	private void checkFluidTankTransfer(int slot, FluidTank tank) {
		if (this.getStackInSlot(slot) != null) {
			if (FluidUtil.isEmptyContainer(this.getStackInSlot(slot)) == false && FluidUtil.getFluidContained(this.getStackInSlot(slot)) != null && FluidUtil.getFluidContained(this.getStackInSlot(slot)).getFluid() != null
					&& FluidUtil.getFluidContained(this.getStackInSlot(slot)).getFluid().equals(ExtraPlanets_Fluids.SALT_FLUID)) {
				tank.fill(FluidRegistry.getFluidStack("salt_fluid", 1000), true);
				this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
			}
		}
	}

	public int getScaledFuelLevel(int i) {
		return this.inputTank.getFluidAmount() * i / this.inputTank.getCapacity();
	}

	public boolean canProcess() {
		if (this.inputTank.getFluidAmount() <= 0 && amountDrain <= 0) {
			return false;
		}
		return !this.getDisabled(0);

	}

	public boolean canCrystallize() {
		if (this.producingStack.isEmpty()) {
			return false;
		}
		if (this.stacks.get(1).isEmpty()) {
			return true;
		}
		if (!this.stacks.get(1).isEmpty() && !this.stacks.get(1).isItemEqual(this.producingStack)) {
			return false;
		}
		int result = this.stacks.get(1).isEmpty() ? 0 : this.stacks.get(1).getCount() + this.producingStack.getCount();
		return result <= this.getInventoryStackLimit() && result <= this.producingStack.getMaxStackSize();
	}

	public boolean hasInputs() {
		if (this.inputTank.getFluidAmount() >= 50)
			return true;
		return false;
	}

	public void smeltItem() {
		ItemStack resultItemStack = this.producingStack;
		if (this.canProcess() && canCrystallize()) {
			final int amountToDrain = 50;
			amountDrain = amountDrain + amountToDrain;
			this.inputTank.drain(amountToDrain, true);
			if (amountDrain >= 1000) {
				amountDrain = 0;
				if (this.stacks.get(1).isEmpty()) {
					this.stacks.set(1, resultItemStack.copy());
				} else if (this.stacks.get(1).isItemEqual(resultItemStack)) {
					if (this.stacks.get(1).getCount() + resultItemStack.getCount() > 64) {
						for (int i = 0; i < this.stacks.get(1).getCount() + resultItemStack.getCount() - 64; i++) {
							float var = 0.7F;
							double dx = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
							double dy = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
							double dz = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
							EntityItem entityitem = new EntityItem(this.world, this.getPos().getX() + dx, this.getPos().getY() + dy, this.getPos().getZ() + dz, new ItemStack(resultItemStack.getItem(), 1, resultItemStack.getItemDamage()));
							entityitem.setPickupDelay(10);
							this.world.spawnEntity(entityitem);
						}
						this.stacks.get(1).setCount(64);
					} else {
						this.stacks.get(1).grow(resultItemStack.getCount());
					}
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
		if (this.inputTank.getFluid() != null && this.inputTank.getFluid().getFluid() != ExtraPlanets_Fluids.SALT_FLUID) {
			this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.SALT_FLUID, this.inputTank.getFluidAmount()));
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
		return nbt;
	}

	@Override
	protected NonNullList<ItemStack> getContainingItems() {
		return this.stacks;
	}

	@Override
	public String getName() {
		return GCCoreUtil.translate("container.basic.crystallizer.name");
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN) {
			return new int[] { 1 };
		}
		return new int[] { 0, 1, 2 };
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemstack, EnumFacing side) {
		if (itemstack != null && this.isItemValidForSlot(slotID, itemstack)) {
			switch (slotID) {
			case 0:
				return itemstack.getItem() instanceof ItemElectricBase && ((ItemElectricBase) itemstack.getItem()).getElectricityStored(itemstack) > 0;
			case 2:
				return true;
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
				return itemstack.getItem() == ExtraPlanets_Items.IODIDE_SALT;
			case 2:
				return itemstack == new ItemStack(Items.BUCKET);
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
			return itemstack.getItem() == ExtraPlanets_Items.IODIDE_SALT;
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
		return getFront().rotateYCCW();
	}

	@Override
	public EnumFacing getFront() {
		IBlockState state = this.world.getBlockState(getPos());
		if (state.getBlock() instanceof BasicCrystallizer) {
			return state.getValue(BasicCrystallizer.FACING);
		}
		return EnumFacing.NORTH;
	}

	@Override
	public boolean canConnect(EnumFacing direction, NetworkType type) {
		if (type == NetworkType.POWER) {
			return direction == this.getElectricInputDirection();
		}
		if (type == NetworkType.FLUID) {
			return direction == this.getInputPipe();
		}
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}

	private EnumFacing getInputPipe() {
		return getFront().rotateY();
	}

	@Override
	public boolean canDrain(EnumFacing from, Fluid fluid) {
		return false;
	}

	@Override
	public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain) {
		return null;
	}

	@Override
	public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain) {
		return null;
	}

	@Override
	public boolean canFill(EnumFacing from, Fluid fluid) {
		if (from == getInputPipe()) {
			return this.inputTank.getFluid() == null || this.inputTank.getFluidAmount() < this.inputTank.getCapacity();
		}

		return false;
	}

	@Override
	public int fill(EnumFacing from, FluidStack resource, boolean doFill) {
		int used = 0;

		if (from == getInputPipe() && resource != null) {
			final String liquidName = FluidRegistry.getFluidName(resource);

			if (liquidName != null && liquidName.contains("salt")) {
				if (liquidName.equals("salt")) {
					used = this.inputTank.fill(resource, doFill);
				} else {
					used = this.inputTank.fill(new FluidStack(ExtraPlanets_Fluids.SALT_FLUID, resource.amount), doFill);
				}
			}
		}

		return used;
	}

	@Override
	public FluidTankInfo[] getTankInfo(EnumFacing from) {
		return new FluidTankInfo[] { new FluidTankInfo(this.inputTank) };
	}
}
