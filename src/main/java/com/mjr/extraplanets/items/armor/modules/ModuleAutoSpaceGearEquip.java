package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.items.ItemOxygenTank;
import micdoodle8.mods.galacticraft.core.items.ItemParaChute;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ModuleAutoSpaceGearEquip extends Module {

	public ModuleAutoSpaceGearEquip(String name) {
		super(name, 3, new ItemStack(GCItems.oxygenGear), true, 1, 250);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(ExtraPlanets_Items.MODULE_ITEMS, 12, 2));
		this.setRequirements(items);
	}

	@Override
	public void tickServer(EntityPlayerMP player) {
		GCPlayerStats stats = GCPlayerStats.get(player);
		boolean itemsReplaced = false;

		// Oxygen Mask
		if (stats.getExtendedInventory().getStackInSlot(0) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && ItemStack.areItemsEqual(testStack, new ItemStack(GCItems.oxMask))) {
					stats.getExtendedInventory().setInventorySlotContents(0, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		// Oxygen Gear
		if (stats.getExtendedInventory().getStackInSlot(1) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && ItemStack.areItemsEqual(testStack, new ItemStack(GCItems.oxygenGear))) {
					stats.getExtendedInventory().setInventorySlotContents(1, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		// Oxygen Tanks
		if (stats.getExtendedInventory().getStackInSlot(2) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof ItemOxygenTank) {
					stats.getExtendedInventory().setInventorySlotContents(2, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		if (stats.getExtendedInventory().getStackInSlot(3) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof ItemOxygenTank) {
					stats.getExtendedInventory().setInventorySlotContents(3, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		// Parachute
		if (stats.getExtendedInventory().getStackInSlot(4) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof ItemParaChute) {
					stats.getExtendedInventory().setInventorySlotContents(4, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		// Frequency Module
		if (stats.getExtendedInventory().getStackInSlot(5) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem().equals(GCItems.basicItem) && testStack.getItemDamage() == 19) {
					stats.getExtendedInventory().setInventorySlotContents(5, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		// Thermal Padding
		if (stats.getExtendedInventory().getStackInSlot(6) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof IItemThermal && testStack.getItemDamage() == 0) {
					stats.getExtendedInventory().setInventorySlotContents(6, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		if (stats.getExtendedInventory().getStackInSlot(7) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof IItemThermal && testStack.getItemDamage() == 1) {
					stats.getExtendedInventory().setInventorySlotContents(7, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		if (stats.getExtendedInventory().getStackInSlot(8) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof IItemThermal && testStack.getItemDamage() == 2) {
					stats.getExtendedInventory().setInventorySlotContents(8, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		if (stats.getExtendedInventory().getStackInSlot(9) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem() instanceof IItemThermal && testStack.getItemDamage() == 3) {
					stats.getExtendedInventory().setInventorySlotContents(9, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		// Shield
		if (stats.getExtendedInventory().getStackInSlot(10) != null) {
			boolean replaced = false;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				if (replaced)
					return;
				ItemStack testStack = player.inventory.getStackInSlot(i);
				if (testStack != null && testStack.getItem().equals(VenusItems.basicItem) && testStack.getItemDamage() == 0) {
					stats.getExtendedInventory().setInventorySlotContents(10, testStack);
					player.inventory.setInventorySlotContents(i, null);
					replaced = true;
					itemsReplaced = true;
				}
			}
		}
		if (itemsReplaced)
			ModuleHelper.takeArmourPower(player.inventory.armorItemInSlot(this.getSlotType()), this.getUsePowerCost());
	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {

	}
}
