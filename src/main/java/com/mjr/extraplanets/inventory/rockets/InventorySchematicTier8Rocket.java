package com.mjr.extraplanets.inventory.rockets;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

public class InventorySchematicTier8Rocket implements IInventory
{
    public NonNullList<ItemStack> stacks;
    private final int inventoryWidth;
    private final Container eventHandler;

    public InventorySchematicTier8Rocket(Container par1Container)
    {
    	this.stacks = NonNullList.withSize(1, ItemStack.EMPTY);
        this.eventHandler = par1Container;
        this.inventoryWidth = 5;
    }

    @Override
    public int getSizeInventory()
    {
		return this.stacks.size();
    }

    @Override
    public ItemStack getStackInSlot(int par1)
    {
        return this.stacks.get(par1);
    }

    public ItemStack getStackInRowAndColumn(int par1, int par2)
    {
        if (par1 >= 0 && par1 < this.inventoryWidth)
        {
            final int var3 = par1 + par2 * this.inventoryWidth;
            if (var3 >= 22)
            {
                return null;
            }
            return this.getStackInSlot(var3);
        }
        else
        {
            return null;
        }
    }

    @Override
    public String getName()
    {
        return "container.crafting";
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        ItemStack oldstack = ItemStackHelper.getAndRemove(this.stacks, index);
        if (!oldstack.isEmpty())
        {
            this.markDirty();
        }
    	return oldstack;
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.stacks, index, count);

        if (!itemstack.isEmpty())
        {
            this.markDirty();
        }

        return itemstack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.stacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty()
    {
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return false;
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value)
    {

    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public ITextComponent getDisplayName()
    {
        return null;
    }
    
    @Override
    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.stacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }
}
