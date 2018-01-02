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
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.machines.BasicSolarEvaporationChamber;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class TileEntityBasicSolarEvaporationChamber extends TileBaseElectricBlockWithInventory implements ISidedInventory {
	public static final int BASE_PROCESS_TIME_REQUIRED = 50;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	public int processTime = 0;
	private ItemStack[] containingItems = new ItemStack[3];

	private ItemStack producingStack = new ItemStack(ExtraPlanets_Items.POTASSIUM, 1, 0);
	@NetworkedField(targetSide = Side.CLIENT)
	public boolean isDaylight = false;

	public TileEntityBasicSolarEvaporationChamber() {
	}

	@Override
	public void update() {
		super.update();
		if (!this.worldObj.isRemote) {
			if (this.worldObj.isDaytime())
				isDaylight = true;
			else
				isDaylight = false;
			if (this.canProcess() && canOutput() && this.hasEnoughEnergyToRun) {
				processTime = (int) (BASE_PROCESS_TIME_REQUIRED - (this.worldObj.getCelestialAngle(1.0F) * 100));
				if (processTime < 0)
					processTime = processTime * -1;
				if (this.processTicks == 0) {
					this.processTicks = processTime;
				} else {
					if (--this.processTicks <= 0) {
						this.smeltItem();
						this.processTicks = this.canProcess() ? processTime : 0;
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
		if (this.containingItems[1].getItem() != ExtraPlanets_Items.POTASH_SHARDS)
			return false;
		if (this.containingItems[1].stackSize < 12)
			return false;
		if (this.worldObj.isDaytime() == false || this.worldObj.canBlockSeeSky(pos.add(0, 1, 0)) == false) {
			return false;
		}
		return !this.getDisabled(0);
	}

	public boolean canOutput() {
		ItemStack itemstack = this.producingStack;
		if (itemstack == null) {
			return false;
		}
		if (this.containingItems[2] == null) {
			return true;
		}
		if (!this.containingItems[2].isItemEqual(itemstack)) {
			return false;
		}
		int result = this.containingItems[2].stackSize + itemstack.stackSize;
		return result <= this.getInventoryStackLimit() && result <= itemstack.getMaxStackSize();
	}

	public boolean hasInputs() {
		if (this.containingItems[1] != null && this.containingItems[1].getItem() == ExtraPlanets_Items.POTASH_SHARDS)
			if (this.containingItems[1].stackSize >= 12)
				return true;
		return false;
	}

	public void smeltItem() {
		ItemStack resultItemStack = this.producingStack;
		if (this.canProcess() && canOutput()) {
			if (this.containingItems[2] == null) {
				this.containingItems[2] = resultItemStack.copy();
			} else if (this.containingItems[2].isItemEqual(resultItemStack)) {
				if (this.containingItems[2].stackSize + resultItemStack.stackSize > 64) {
					for (int i = 0; i < this.containingItems[2].stackSize + resultItemStack.stackSize - 64; i++) {
						float var = 0.7F;
						double dx = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dy = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dz = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						EntityItem entityitem = new EntityItem(this.worldObj, this.getPos().getX() + dx, this.getPos().getY() + dy, this.getPos().getZ() + dz, new ItemStack(resultItemStack.getItem(), 1, resultItemStack.getItemDamage()));
						entityitem.setPickupDelay(10);
						this.worldObj.spawnEntityInWorld(entityitem);
					}
					this.containingItems[2].stackSize = 64;
				} else {
					this.containingItems[2].stackSize += resultItemStack.stackSize;
				}
			}
		}
		this.decrStackSize(1, 12);
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
		return GCCoreUtil.translate("container.basic.solar.evaporation.chamber.name");
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	// ISidedInventory Implementation:

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN) {
			return new int[] { 2 };
		} else if (side == EnumFacing.UP) {
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
			case 1:
				return itemstack.getItem() == ExtraPlanets_Items.POTASH_SHARDS;
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
				return itemstack.getItem() == ExtraPlanets_Items.POTASSIUM;
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
			return itemstack.getItem() == ExtraPlanets_Items.POTASH_SHARDS;
		case 2:
			return itemstack.getItem() == ExtraPlanets_Items.POTASSIUM;
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
		IBlockState state = this.worldObj.getBlockState(getPos());
		if (state.getBlock() instanceof BasicSolarEvaporationChamber) {
			return state.getValue(BasicSolarEvaporationChamber.FACING);
		}
		return EnumFacing.NORTH;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}
}
