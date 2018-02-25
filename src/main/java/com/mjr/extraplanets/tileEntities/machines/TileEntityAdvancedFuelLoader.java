package com.mjr.extraplanets.tileEntities.machines;

import micdoodle8.mods.galacticraft.api.entity.IFuelable;
import micdoodle8.mods.galacticraft.api.tile.ILandingPadAttachable;
import micdoodle8.mods.galacticraft.api.transmission.NetworkType;
import micdoodle8.mods.galacticraft.api.vector.BlockVec3;
import micdoodle8.mods.galacticraft.core.GCFluids;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.tile.IMachineSides;
import micdoodle8.mods.galacticraft.core.tile.IMachineSidesProperties;
import micdoodle8.mods.galacticraft.core.tile.TileEntityMulti;
import micdoodle8.mods.galacticraft.core.util.FluidUtil;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.machines.AdvancedFuelLoader;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class TileEntityAdvancedFuelLoader extends TileBaseElectricBlockWithInventory implements ISidedInventory, IFluidHandler, ILandingPadAttachable, IMachineSides {
	private final int tankCapacity = 12000 * 2;
	@NetworkedField(targetSide = Side.CLIENT)
	public FluidTank fuelTank = new FluidTank(this.tankCapacity);
	private ItemStack[] containingItems = new ItemStack[2];
	public IFuelable attachedFuelable;
	private boolean loadedFuelLastTick = false;

	public TileEntityAdvancedFuelLoader() {
		this.storage.setMaxExtract(30 * 2);
	}

	public int getScaledFuelLevel(int i) {
		final double fuelLevel = this.fuelTank.getFluid() == null ? 0 : this.fuelTank.getFluid().amount;

		return (int) (fuelLevel * i / this.tankCapacity);
	}

	@Override
	public void update() {
		super.update();

		if (!this.worldObj.isRemote) {
			this.loadedFuelLastTick = false;

			final FluidStack liquidContained = FluidUtil.getFluidContained(this.containingItems[1]);
			if (FluidUtil.isFuel(liquidContained)) {
				FluidUtil.loadFromContainer(this.fuelTank, GCFluids.fluidFuel, this.containingItems, 1, liquidContained.amount);
			}

			if (this.ticks % 100 == 0) {
				this.attachedFuelable = null;

				for (final EnumFacing dir : EnumFacing.values()) {
					final TileEntity pad = new BlockVec3(this).getTileEntityOnSide(this.worldObj, dir);

					if (pad instanceof TileEntityMulti) {
						final TileEntity mainTile = ((TileEntityMulti) pad).getMainBlockTile();

						if (mainTile instanceof IFuelable) {
							this.attachedFuelable = (IFuelable) mainTile;
							break;
						}
					} else if (pad instanceof IFuelable) {
						this.attachedFuelable = (IFuelable) pad;
						break;
					}
				}

			}

			if (this.fuelTank != null && this.fuelTank.getFluid() != null && this.fuelTank.getFluid().amount > 0) {
				final FluidStack liquid = new FluidStack(GCFluids.fluidFuel, 5);

				if (this.attachedFuelable != null && this.hasEnoughEnergyToRun && !this.disabled) {
					int filled = this.attachedFuelable.addFuel(liquid, true);
					this.loadedFuelLastTick = filled > 0;
					this.fuelTank.drain(filled, true);
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.containingItems = this.readStandardItemsFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("fuelTank")) {
			this.fuelTank.readFromNBT(par1NBTTagCompound.getCompoundTag("fuelTank"));
		}

		this.readMachineSidesFromNBT(par1NBTTagCompound); // Needed by IMachineSides
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		this.writeStandardItemsToNBT(nbt);

		if (this.fuelTank.getFluid() != null) {
			nbt.setTag("fuelTank", this.fuelTank.writeToNBT(new NBTTagCompound()));
		}

		this.addMachineSidesToNBT(nbt); // Needed by IMachineSides
	}

	@Override
	protected ItemStack[] getContainingItems() {
		return this.containingItems;
	}

	@Override
	public String getName() {
		return TranslateUtilities.translate("container.advanced.fuelloader.name");
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[] { 0, 1 };
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemStack, EnumFacing side) {
		return this.isItemValidForSlot(slotID, itemStack);
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack itemStack, EnumFacing side) {
		if (slotID == 1 && itemStack != null) {
			return FluidUtil.isEmptyContainer(itemStack);
		}
		return false;
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemStack) {
		return (slotID == 1 && itemStack != null && itemStack.getItem() == GCItems.fuelCanister) || (slotID == 0 ? ItemElectricBase.isElectricItem(itemStack.getItem()) : false);
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
		if (this.getPipeInputDirection().equals(from)) {
			return this.fuelTank.getFluid() == null || this.fuelTank.getFluidAmount() < this.fuelTank.getCapacity();
		}
		return false;
	}

	@Override
	public int fill(EnumFacing from, FluidStack resource, boolean doFill) {
		int used = 0;

		if (this.getPipeInputDirection().equals(from) && resource != null) {
			if (FluidUtil.testFuel(FluidRegistry.getFluidName(resource))) {
				used = this.fuelTank.fill(resource, doFill);
			}
		}

		return used;
	}

	@Override
	public FluidTankInfo[] getTankInfo(EnumFacing from) {
		if (this.getPipeInputDirection().equals(from)) {
			return new FluidTankInfo[] { new FluidTankInfo(this.fuelTank) };
		}
		return null;
	}

	@Override
	public boolean shouldUseEnergy() {
		return this.fuelTank.getFluid() != null && this.fuelTank.getFluid().amount > 0 && !this.getDisabled(0) && loadedFuelLastTick;
	}

	@Override
	public boolean canAttachToLandingPad(IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public EnumFacing getFront() {
		IBlockState state = this.worldObj.getBlockState(getPos());
		if (state.getBlock() instanceof AdvancedFuelLoader) {
			return state.getValue(AdvancedFuelLoader.FACING);
		}
		return EnumFacing.NORTH;
	}

	@Override
	public boolean canConnect(EnumFacing direction, NetworkType type) {
		if (direction == null) {
			return false;
		}
		if (type == NetworkType.POWER) {
			return direction == this.getElectricInputDirection();
		}
		if (type == NetworkType.FLUID) {
			return direction == this.getPipeInputDirection();
		}
		return false;
	}

	@Override
	public EnumFacing getElectricInputDirection() {
		switch (this.getSide(MachineSide.ELECTRIC_IN)) {
		case RIGHT:
			return getFront().rotateYCCW();
		case REAR:
			return getFront().getOpposite();
		case TOP:
			return EnumFacing.UP;
		case BOTTOM:
			return EnumFacing.DOWN;
		case LEFT:
		default:
			return getFront().rotateY();
		}
	}

	@Override
	public EnumFacing getPipeInputDirection() {
		switch (this.getSide(MachineSide.PIPE_IN)) {
		case RIGHT:
		default:
			return getFront().rotateYCCW();
		case REAR:
			return getFront().getOpposite();
		case TOP:
			return EnumFacing.UP;
		case BOTTOM:
			return EnumFacing.DOWN;
		case LEFT:
			return getFront().rotateY();
		}
	}

	// ------------------
	// Added these methods and field to implement IMachineSides properly
	// ------------------
	@Override
	public MachineSide[] listConfigurableSides() {
		return new MachineSide[] { MachineSide.ELECTRIC_IN, MachineSide.PIPE_IN };
	}

	@Override
	public Face[] listDefaultFaces() {
		return new Face[] { Face.LEFT, Face.RIGHT };
	}

	private MachineSidePack[] machineSides;

	@Override
	public MachineSidePack[] getAllMachineSides() {
		if (this.machineSides == null) {
			this.initialiseSides();
		}

		return this.machineSides;
	}

	@Override
	public void setupMachineSides(int length) {
		this.machineSides = new MachineSidePack[length];
	}

	@Override
	public void onLoad() {
		this.clientOnLoad();
	}

	@Override
	public IMachineSidesProperties getConfigurationType() {
		return AdvancedFuelLoader.MACHINESIDES_RENDERTYPE;
	}
	// ------------------END OF IMachineSides implementation
}
