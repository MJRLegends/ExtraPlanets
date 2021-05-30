package com.mjr.extraplanets.tileEntities.machines;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.BasicDensifier;
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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;

public class TileEntityBasicDensifier extends TileBaseElectricBlockWithInventory implements ISidedInventory, IFluidHandlerWrapper {
	private final int tankCapacity = 20000;
	private int amountDrain = 0;
	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank inputTank;

	public static final int PROCESS_TIME_REQUIRED = 5;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);

	private ItemStack producingStack = null;

	@NetworkedField(targetSide = Side.CLIENT)
	public int outputTextureOffsetX;
	@NetworkedField(targetSide = Side.CLIENT)
	public int outputTextureOffsetY;

	public TileEntityBasicDensifier() {
		inputTank = new FluidTank(this.tankCapacity);
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
			checkFluidTankTransfer(2, this.inputTank);

			if (this.canProcess() && this.hasEnoughEnergyToRun) {
				if (this.processTicks == 0) {
					this.processTicks = TileEntityBasicDensifier.PROCESS_TIME_REQUIRED;
				} else {
					if (--this.processTicks <= 0) {
						this.updateOutput();
						this.smeltItem();
						this.processTicks = this.canProcess() ? TileEntityBasicDensifier.PROCESS_TIME_REQUIRED : 0;
					}
				}
			} else {
				this.processTicks = 0;
			}
		}
	}

	private void checkFluidTankTransfer(int slot, FluidTank tank) {
		ItemStack item = this.getStackInSlot(slot);
		if (item != null) {
			FluidStack stack = FluidUtil.getFluidContained(item);
			if (item.getItem() instanceof UniversalBucket && FluidUtil.isEmptyContainer(item) == false && stack != null && stack.getFluid() != null) {
				if (stack.getFluid().equals(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("liquid_caramel_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("liquid_caramel_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				} else if (stack.getFluid().equals(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("liquid_chocolate_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("liquid_chocolate_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				} else if (stack.getFluid().equals(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("nitrogen_ice_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("nitrogen_ice_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				} else if (stack.getFluid().equals(ExtraPlanets_Fluids.GLOWSTONE_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.GLOWSTONE_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("glowstone_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("glowstone_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				} else if (stack.getFluid().equals(ExtraPlanets_Fluids.NITROGEN_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.NITROGEN_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("nitrogen_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("nitrogen_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				} else if (stack.getFluid().equals(ExtraPlanets_Fluids.FROZEN_WATER_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("frozen_water_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("frozen_water_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				} else if (stack.getFluid().equals(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID)) {
					if (this.inputTank.getFluid() == null) {
						this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, 0));
						tank.fill(FluidRegistry.getFluidStack("liquid_hydrocarbon_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					} else if (stack.getFluid() == this.inputTank.getFluid().getFluid()) {
						tank.fill(FluidRegistry.getFluidStack("liquid_hydrocarbon_fluid", 1000), true);
						this.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					}
				}
			}
		}
	}

	public void updateOutput() {
		if (this.inputTank.getFluid() == null)
			return;
		if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, 0)))
			this.producingStack = new ItemStack(ExtraPlanets_Items.CARAMEL_BAR, 6);
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, 0)))
			this.producingStack = new ItemStack(ExtraPlanets_Items.CHOCOLATE_BAR, 6);
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, 0)))
			this.producingStack = new ItemStack(Blocks.ICE, 6);
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.GLOWSTONE_FLUID, 0)))
			this.producingStack = new ItemStack(Blocks.GLOWSTONE, 1);
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.NITROGEN_FLUID, 0)))
			this.producingStack = new ItemStack(ExtraPlanets_Blocks.FROZEN_NITROGEN, 2);
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, 0)))
			this.producingStack = new ItemStack(Blocks.ICE, 3);
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, 0)))
			this.producingStack = new ItemStack(Items.COAL, 3);
	}

	public void updateTextureOffset() {
		if (this.inputTank.getFluid() == null)
			return;
		if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, 0))) {
			this.outputTextureOffsetX = 48;
			this.outputTextureOffsetY = 0;
		} else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, 0))) {
			this.outputTextureOffsetX = 16;
			this.outputTextureOffsetY = 0;
		} else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, 0))) {
			this.outputTextureOffsetX = 0;
			this.outputTextureOffsetY = 0;
		} else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.GLOWSTONE_FLUID, 0)))
			this.outputTextureOffsetX = 64;
		else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.NITROGEN_FLUID, 0))) {
			this.outputTextureOffsetX = 0;
			this.outputTextureOffsetY = 45;
		} else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, 0))) {
			this.outputTextureOffsetX = 16;
			this.outputTextureOffsetY = 45;
		} else if (this.inputTank.getFluid().equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, 0))) {
			this.outputTextureOffsetX = 32;
			this.outputTextureOffsetY = 45;
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
		if (this.canProcess() && this.canCrystallize() && hasInputs()) {
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
		if(this.producingStack == null && nbt.hasKey("producingStack")) {
	        final ItemStack itemStack = new ItemStack((NBTTagCompound) nbt.getTag("producingStack"));
	        this.producingStack = itemStack;
		}

		if (nbt.hasKey("inputTank")) {
			this.inputTank.readFromNBT(nbt.getCompoundTag("inputTank"));
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("smeltingTicks", this.processTicks);
		this.writeStandardItemsToNBT(nbt, this.stacks);
		nbt.setTag("producingStack", this.producingStack.serializeNBT());

		if (this.inputTank.getFluid() != null) {
			nbt.setTag("inputTank", this.inputTank.writeToNBT(new NBTTagCompound()));
		}
		producingStack.serializeNBT();
		return nbt;
	}

	@Override
	protected NonNullList<ItemStack> getContainingItems() {
		return this.stacks;
	}

	@Override
	public String getName() {
		return TranslateUtilities.translate("container.basic.densifier.name");
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
				return ItemElectricBase.isElectricItemCharged(itemstack);
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
				return ItemElectricBase.isElectricItemEmpty(itemstack) || !this.shouldPullEnergy();
			case 1:
				return true;
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
		if (state.getBlock() instanceof BasicDensifier) {
			return state.getValue(BasicDensifier.FACING);
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

			if (liquidName != null) {
				if (resource.equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, 0)) || resource.equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, 0))
						|| resource.equals(new FluidStack(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, 0)) || resource.equals(new FluidStack(ExtraPlanets_Fluids.GLOWSTONE_FLUID, 0)) || resource.equals(new FluidStack(ExtraPlanets_Fluids.NITROGEN_FLUID, 0))
						|| resource.equals(new FluidStack(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, 0)) || resource.equals(new FluidStack(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, 0))) {

					if (this.inputTank.getFluid() == null) {
						if (resource.getFluid().equals(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, 0));
						} else if (resource.getFluid().equals(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, 0));
						} else if (resource.getFluid().equals(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, 0));
						} else if (resource.getFluid().equals(ExtraPlanets_Fluids.GLOWSTONE_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.GLOWSTONE_FLUID, 0));
						} else if (resource.getFluid().equals(ExtraPlanets_Fluids.NITROGEN_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.NITROGEN_FLUID, 0));
						} else if (resource.getFluid().equals(ExtraPlanets_Fluids.FROZEN_WATER_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, 0));
						} else if (resource.getFluid().equals(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID)) {
							this.inputTank.setFluid(new FluidStack(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, 0));
						}
					}
					if (this.inputTank.getFluid().equals(resource))
						if (this.inputTank.getFluidAmount() == 0)
							this.inputTank.setFluid(resource);
					used = this.inputTank.fill(resource, doFill);
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
