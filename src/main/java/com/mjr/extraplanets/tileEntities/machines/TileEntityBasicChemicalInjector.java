package com.mjr.extraplanets.tileEntities.machines;

import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.machines.BasicChemicalInjector;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class TileEntityBasicChemicalInjector extends TileBaseElectricBlockWithInventory implements ISidedInventory {
	public static final int PROCESS_TIME_REQUIRED = 100;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(4, ItemStack.EMPTY);

	private ItemStack producingStack = new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE, 1, 0);

	public TileEntityBasicChemicalInjector() {
	}

	@Override
	public void update() {
		super.update();

		if (!this.world.isRemote) {
			if (this.canProcess() && canOutput() && this.hasEnoughEnergyToRun) {
				if (this.processTicks == 0) {
					this.processTicks = TileEntityBasicChemicalInjector.PROCESS_TIME_REQUIRED;
				} else {
					if (--this.processTicks <= 0) {
						this.smeltItem();
						this.processTicks = this.canProcess() ? TileEntityBasicChemicalInjector.PROCESS_TIME_REQUIRED : 0;
					}
				}
			} else {
				this.processTicks = 0;
			}
		}
	}

	public boolean canProcess() {
		if (this.stacks.get(1).isEmpty())
			return false;
		if (this.stacks.get(2).isEmpty())
			return false;
		if (this.stacks.get(1).getItem() != ExtraPlanets_Items.IODIDE_SALT)
			return false;
		if (this.stacks.get(2).getItem() != ExtraPlanets_Items.POTASSIUM)
			return false;
		if (this.stacks.get(1).getCount() < 3)
			return false;
		if (this.stacks.get(2).getCount() < 6)
			return false;
		return !this.getDisabled(0);
	}

	public boolean canOutput() {
		ItemStack itemstack = this.producingStack;
		if (this.stacks.get(3).isEmpty()) {
			return true;
		}
		if (!this.stacks.get(3).isItemEqual(itemstack)) {
			return false;
		}
		int result = this.getStackInSlot(3).getCount() + itemstack.getCount();
		System.out.println(result);
		return result <= this.getInventoryStackLimit() && result <= itemstack.getMaxStackSize();
	}

	public boolean hasInputs() {
		if (!this.stacks.get(1).isEmpty() && !this.stacks.get(2).isEmpty() && this.stacks.get(1).getItem() == ExtraPlanets_Items.IODIDE_SALT && this.stacks.get(2).getItem() == ExtraPlanets_Items.POTASSIUM)
			if (this.stacks.get(1).getCount() >= 3 && this.stacks.get(2).getCount() >= 6)
				return true;
		return false;
	}

	public void smeltItem() {
		ItemStack resultItemStack = this.producingStack;
		if (this.canProcess() && canOutput()) {
			if (this.stacks.get(3).isEmpty()) {
				this.stacks.set(3, resultItemStack.copy());
			} else if (this.stacks.get(3).isItemEqual(resultItemStack)) {
				if (this.stacks.get(3).getCount() + resultItemStack.getCount() > 64) {
					for (int i = 0; i < this.stacks.get(3).getCount() + resultItemStack.getCount() - 64; i++) {
						float var = 0.7F;
						double dx = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dy = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dz = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						EntityItem entityitem = new EntityItem(this.world, this.getPos().getX() + dx, this.getPos().getY() + dy, this.getPos().getZ() + dz, new ItemStack(resultItemStack.getItem(), 1, resultItemStack.getItemDamage()));
						entityitem.setPickupDelay(10);
						this.world.spawnEntity(entityitem);
					}
					this.stacks.get(3).setCount(64);
				} else {
					this.stacks.get(3).grow(resultItemStack.getCount());
				}
			}
		}
		this.decrStackSize(1, 3);
		this.decrStackSize(2, 6);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.processTicks = nbt.getInteger("smeltingTicks");
		this.stacks = this.readStandardItemsFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("smeltingTicks", this.processTicks);
		this.writeStandardItemsToNBT(nbt, this.stacks);
		return nbt;
	}

	@Override
	protected NonNullList<ItemStack> getContainingItems() {
		return this.stacks;
	}

	@Override
	public String getName() {
		return GCCoreUtil.translate("container.basic.chemical_injector.name");
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.WEST) {
			return new int[] { 1 };
		} else if (side == EnumFacing.EAST) {
			return new int[] { 2 };
		} else if (side == EnumFacing.DOWN) {
			return new int[] { 3 };
		}
		return new int[] { 0, 1, 2, 3 };
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
				return itemstack.getItem() == ExtraPlanets_Items.POTASSIUM;
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
			case 3:
				return itemstack.getItem() == ExtraPlanets_Items.POTASSIUM_IODIDE;
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
			return itemstack.getItem() == ExtraPlanets_Items.POTASSIUM;
		case 3:
			return itemstack.getItem() == ExtraPlanets_Items.POTASSIUM_IODIDE;
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
		if (state.getBlock() instanceof BasicChemicalInjector) {
			return (state.getValue(BasicChemicalInjector.FACING));
		}
		return EnumFacing.NORTH;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}
}
