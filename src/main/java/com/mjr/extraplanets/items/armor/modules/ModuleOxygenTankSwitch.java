package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.items.ItemOxygenTank;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ModuleOxygenTankSwitch extends Module {

	public ModuleOxygenTankSwitch(String name) {
		super(name, 2, new ItemStack(GCItems.oxTankHeavy), true, 5, 25);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(ExtraPlanets_Items.MODULE_ITEMS, 6, 2));
		items.add(new ItemStack(GCItems.oxygenConcentrator, 12));
		this.setRequirements(items);
	}

	@Override
	public void tickServer(EntityPlayerMP player) {
        GCPlayerStats stats = GCPlayerStats.get(player);
		final ItemStack tankInSlot = stats.getExtendedInventory().getStackInSlot(2);
        final ItemStack tankInSlot2 = stats.getExtendedInventory().getStackInSlot(3);
        
        if(tankInSlot.getItemDamage() == tankInSlot.getMaxDamage()){
        	switchTanks(player, 2, stats);
        }
        if(tankInSlot2.getItemDamage() == tankInSlot.getMaxDamage()){
        	switchTanks(player, 3, stats);
        }
	}
	
	public void switchTanks(EntityPlayerMP player, int tankSlot, GCPlayerStats stats){
		final ItemStack tankInSlot = stats.getExtendedInventory().getStackInSlot(tankSlot);
		boolean removed = true;
		if (tankInSlot != null)
        {
			removed = player.inventory.addItemStackToInventory(tankInSlot);
            if(removed)
            	stats.getExtendedInventory().setInventorySlotContents(tankSlot, null);
        }
		if(removed){
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if(replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if(testStack != null && testStack.getItem() instanceof ItemOxygenTank && testStack.getItemDamage() != testStack.getMaxDamage()){
					stats.getExtendedInventory().setInventorySlotContents(tankSlot, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
				}
			}
		}
	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {

	}

}
