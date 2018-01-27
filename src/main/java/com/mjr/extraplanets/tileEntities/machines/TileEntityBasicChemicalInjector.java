package com.mjr.extraplanets.tileEntities.machines;

import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlockWithInventory;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.machines.BasicChemicalInjector;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class TileEntityBasicChemicalInjector extends TileBaseElectricBlockWithInventory implements ISidedInventory {
	public static final int PROCESS_TIME_REQUIRED = 100;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private ItemStack[] containingItems = new ItemStack[4];

	private ItemStack producingStack = new ItemStack(ExtraPlanets_Items.POTASSIUM_IODIDE, 1, 0);

	public TileEntityBasicChemicalInjector() {
	}

	@Override
	public void update() {
		super.update();

		if (!this.worldObj.isRemote) {
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
		if (this.containingItems[1] == null)
			return false;
		if (this.containingItems[2] == null)
			return false;
		if (this.containingItems[1].getItem() != ExtraPlanets_Items.IODIDE_SALT)
			return false;
		if (this.containingItems[2].getItem() != ExtraPlanets_Items.POTASSIUM)
			return false;
		if (this.containingItems[1].stackSize < 3)
			return false;
		if (this.containingItems[2].stackSize < 6)
			return false;
		return !this.getDisabled(0);
	}

	public boolean canOutput() {
		ItemStack itemstack = this.producingStack;
		if (itemstack == null) {
			return false;
		}
		if (this.containingItems[3] == null) {
			return true;
		}
		if (!this.containingItems[3].isItemEqual(itemstack)) {
			return false;
		}
		int result = this.containingItems[3].stackSize + itemstack.stackSize;
		return result <= this.getInventoryStackLimit() && result <= itemstack.getMaxStackSize();
	}

	public boolean hasInputs() {
		if (this.containingItems[1] != null && this.containingItems[2] != null && this.containingItems[1].getItem() == ExtraPlanets_Items.IODIDE_SALT && this.containingItems[2].getItem() == ExtraPlanets_Items.POTASSIUM)
			if (this.containingItems[1].stackSize >= 3 && this.containingItems[2].stackSize >= 6)
				return true;
		return false;
	}

	public void smeltItem() {
		ItemStack resultItemStack = this.producingStack;
		if (this.canProcess() && canOutput() && hasInputs()) {
			if (this.containingItems[3] == null) {
				this.containingItems[3] = resultItemStack.copy();
			} else if (this.containingItems[3].isItemEqual(resultItemStack)) {
				if (this.containingItems[3].stackSize + resultItemStack.stackSize > 64) {
					for (int i = 0; i < this.containingItems[3].stackSize + resultItemStack.stackSize - 64; i++) {
						float var = 0.7F;
						double dx = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dy = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dz = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						EntityItem entityitem = new EntityItem(this.worldObj, this.getPos().getX() + dx, this.getPos().getY() + dy, this.getPos().getZ() + dz, new ItemStack(resultItemStack.getItem(), 1, resultItemStack.getItemDamage()));
						entityitem.setPickupDelay(10);
						this.worldObj.spawnEntityInWorld(entityitem);
					}
					this.containingItems[3].stackSize = 64;
				} else {
					this.containingItems[3].stackSize += resultItemStack.stackSize;
				}
			}
			this.decrStackSize(1, 3);
			this.decrStackSize(2, 6);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.processTicks = nbt.getInteger("smeltingTicks");
		this.containingItems = this.readStandardItemsFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("smeltingTicks", this.processTicks);
		this.writeStandardItemsToNBT(nbt);
		return nbt;
	}

	@Override
	protected ItemStack[] getContainingItems() {
		return this.containingItems;
	}

	@Override
	public String getName() {
		return TranslateUtilities.translate("container.basic.chemical_injector.name");
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
				return ItemElectricBase.isElectricItemCharged(itemstack);
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
				return ItemElectricBase.isElectricItemEmpty(itemstack) || !this.shouldPullEnergy();
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
		IBlockState state = this.worldObj.getBlockState(getPos());
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
