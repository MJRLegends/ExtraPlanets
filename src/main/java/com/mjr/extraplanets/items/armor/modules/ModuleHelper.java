package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.mjr.extraplanets.api.item.IModularArmor;

public class ModuleHelper {

	public static void setupModulesNBT(ItemStack item) {
		if (item != null && item.getItem() instanceof IModularArmor) {
			final NBTTagCompound nbt = new NBTTagCompound();
			if (item != null && !item.hasTagCompound()) {
				NBTTagList tagList = new NBTTagList();
				nbt.setTag("modules", tagList);
				item.setTagCompound(nbt);
			}
		}
	}

	public static List<Module> getModules(ItemStack item) {
		List<Module> temp = new ArrayList<Module>();
		if (item != null && item.hasTagCompound()) {
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagList tagList = nbt.getTagList("modules", 10);
			for (int i = 0; i < tagList.tagCount(); i++) {
				for (int j = 0; j < ExtraPlanets_Modules.modules.size(); j++) {
					final NBTTagCompound nbttagcompound = tagList.getCompoundTagAt(i);
					if (ExtraPlanets_Modules.modules.get(j).getName().equalsIgnoreCase(nbttagcompound.getString("module"))) {
						Module tempModule = ExtraPlanets_Modules.modules.get(j);
						tempModule.setActive(nbttagcompound.getBoolean("active"));
						temp.add(tempModule);
					}
				}
			}
			return temp;
		}
		return new ArrayList<Module>();
	}

	public static void setModules(ItemStack item, List<Module> temp) {
		item.setTagCompound(new NBTTagCompound());
		for (Module module : temp) {
			addModule(item, module);
		}

	}

	public static void addModule(ItemStack item, Module module) {
		if (item != null && !item.hasTagCompound())
			setupModulesNBT(item);

		final NBTTagCompound nbt = item.getTagCompound();
		NBTTagList tagList = nbt.getTagList("modules", 10);
		NBTTagCompound moduleNBT = new NBTTagCompound();
		moduleNBT.setString("module", module.getName());
		moduleNBT.setBoolean("active", module.isActive());
		tagList.appendTag(moduleNBT);
		nbt.setTag("modules", tagList);
		item.setTagCompound(nbt);
	}

	public static void addModule(ItemStack item, Module module, boolean active) {
		if (item != null && !item.hasTagCompound())
			setupModulesNBT(item);

		final NBTTagCompound nbt = item.getTagCompound();
		NBTTagList tagList = nbt.getTagList("modules", 10);
		NBTTagCompound moduleNBT = new NBTTagCompound();
		moduleNBT.setString("module", module.getName());
		moduleNBT.setBoolean("active", active);
		tagList.appendTag(moduleNBT);
		nbt.setTag("modules", tagList);
		item.setTagCompound(nbt);
	}

	public static void updateModuleActiveState(ItemStack item, Module module, boolean active) {
		List<Module> temp = getModules(item);
		for (Module tempModule : temp) {
			if (tempModule.getName().equalsIgnoreCase(module.getName()))
				tempModule.setActive(active);
		}
		setModules(item, temp);
	}

	public static void removeModule(ItemStack item, Module module) {
		List<Module> newModules = new ArrayList<Module>();
		for (Module tempModule : getModules(item)) {
			if (!tempModule.getName().equalsIgnoreCase(module.getName()))
				newModules.add(tempModule);
		}
		setModules(item, newModules);
	}

	public static boolean installModule(ItemStack item, Module module, EntityPlayer player) {
		if (!checkModuleCompact(item, module))
			return false;
		boolean hadRequirements = true;
		for (ItemStack itemTemp : module.getRequirements())
			if (!player.inventory.hasItemStack(itemTemp))
				hadRequirements = false;
		if (hadRequirements) {
			for (ItemStack itemTemp : module.getRequirements()) {
				boolean takenStack = false;
				if (player.inventory.hasItemStack(itemTemp)) {
					for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
						if(!takenStack){
							ItemStack testStack = player.inventory.getStackInSlot(i);
							if (ItemStack.areItemsEqual(testStack, itemTemp)) {
								ItemStack newStack = player.inventory.getStackInSlot(i);
								if (testStack.stackSize > itemTemp.stackSize) {
									newStack.stackSize = newStack.stackSize - itemTemp.stackSize;
									takenStack = true;
									player.inventory.setInventorySlotContents(i, newStack);
								} else if (testStack.stackSize == itemTemp.stackSize) {
									player.inventory.setInventorySlotContents(i, null);
									takenStack = true;
								}
							}
						}
					}
				}
			}
			addModule(item, module);
			return true;
		} else
			return false;
	}

	public static void uninstallModule(ItemStack item, Module module, EntityPlayer player) {
		removeModule(item, module);
		for (int i = 0; i < module.getRequirements().size(); i++) {
			player.inventory.setInventorySlotContents(player.inventory.getFirstEmptyStack(), module.getRequirements().get(i));
		}
	}

	public static boolean checkModuleCompact(ItemStack item, Module module) {
		try {
			int slot = EntityLiving.getArmorPosition(item)-1;
			if (slot == module.getSlotType())
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}

	}
	
	public static boolean hasModule(ItemStack item, Module module){
		List<Module> temp = getModules(item);
		for (Module tempModule : temp) {
			if(module.getName().equalsIgnoreCase(tempModule.getName()))
				return true;
		}
		return false;
	}
}
