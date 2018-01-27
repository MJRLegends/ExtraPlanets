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
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;

import com.mjr.extraplanets.blocks.machines.BasicSolarEvaporationChamber;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class TileEntityBasicSolarEvaporationChamber extends TileBaseElectricBlockWithInventory implements ISidedInventory {
	public static final int BASE_PROCESS_TIME_REQUIRED = 50;
	@NetworkedField(targetSide = Side.CLIENT)
	public int processTicks = 0;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);
	public int processTime = 0;

	private ItemStack producingStack = new ItemStack(ExtraPlanets_Items.POTASSIUM, 1, 0);
	@NetworkedField(targetSide = Side.CLIENT)
	public boolean isDaylight = false;

	public TileEntityBasicSolarEvaporationChamber() {
	}

	@Override
	public void update() {
		super.update();
		if (!this.world.isRemote) {
			if (this.world.isDaytime())
				isDaylight = true;
			else
				isDaylight = false;
			if (this.canProcess() && canOutput() && this.hasEnoughEnergyToRun) {
				processTime = (int) (BASE_PROCESS_TIME_REQUIRED - (this.world.getCelestialAngle(1.0F) * 100));
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
		if (this.stacks.get(1).isEmpty())
			return false;
		if (this.stacks.get(1).getItem() != ExtraPlanets_Items.POTASH_SHARDS)
			return false;
		if (this.stacks.get(1).getCount() < 12)
			return false;
		if (this.world.isDaytime() == false || this.world.canBlockSeeSky(pos.add(0, 1, 0)) == false) {
			return false;
		}
		return !this.getDisabled(0);
	}

	public boolean canOutput() {
		ItemStack itemstack = this.producingStack;
		if (itemstack.isEmpty()) {
			return false;
		}
		if (this.stacks.get(2).isEmpty()) {
			return true;
		}
		if (!this.stacks.get(2).isItemEqual(itemstack)) {
			return false;
		}
		int result = this.stacks.get(2).isEmpty() ? 0 : this.stacks.get(2).getCount() + this.producingStack.getCount();
		return result <= this.getInventoryStackLimit() && result <= this.producingStack.getMaxStackSize();
	}

	public boolean hasInputs() {
		if (!this.stacks.get(1).isEmpty() && this.stacks.get(1).getItem() == ExtraPlanets_Items.POTASH_SHARDS)
			if (this.stacks.get(1).getCount() >= 12)
				return true;
		return false;
	}

	public void smeltItem() {
		ItemStack resultItemStack = this.producingStack;
		if (this.canProcess() && canOutput() && hasInputs()) {
			if (this.stacks.get(2).isEmpty()) {
				this.stacks.set(2, resultItemStack.copy());
			} else if (this.stacks.get(2).isItemEqual(resultItemStack)) {
				if (this.stacks.get(2).getCount() + resultItemStack.getCount() > 64) {
					for (int i = 0; i < this.stacks.get(1).getCount() + resultItemStack.getCount() - 64; i++) {
						float var = 0.7F;
						double dx = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dy = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dz = this.world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						EntityItem entityitem = new EntityItem(this.world, this.getPos().getX() + dx, this.getPos().getY() + dy, this.getPos().getZ() + dz, new ItemStack(resultItemStack.getItem(), 1, resultItemStack.getItemDamage()));
						entityitem.setPickupDelay(10);
						this.world.spawnEntity(entityitem);
					}
					this.stacks.get(2).setCount(64);
				} else {
					this.stacks.get(2).grow(resultItemStack.getCount());
				}
			}
			this.decrStackSize(1, 12);
		}
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
		return TranslateUtilities.translate("container.basic.solar.evaporation.chamber.name");
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
				return ItemElectricBase.isElectricItemCharged(itemstack);
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
				return ItemElectricBase.isElectricItemEmpty(itemstack) || !this.shouldPullEnergy();
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
		IBlockState state = this.world.getBlockState(getPos());
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
