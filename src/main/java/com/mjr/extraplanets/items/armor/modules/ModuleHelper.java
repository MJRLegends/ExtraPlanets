package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.items.armor.bases.ElectricArmorBase;
import com.mjr.mjrlegendslib.util.PlayerUtilties;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ModuleHelper {

	public static void setupModulesNBT(ItemStack item) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		if (item.getItem() instanceof IModularArmor) {
			final NBTTagCompound nbt = new NBTTagCompound();
			if (item != null && !item.hasTagCompound()) {
				NBTTagList tagList = new NBTTagList();
				nbt.setTag("modules", tagList);
				item.setTagCompound(nbt);
			}
		}
	}

	public static List<Module> getModules(ItemStack item) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return new ArrayList<Module>();
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
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		item.setTagCompound(new NBTTagCompound());
		for (Module module : temp) {
			addModule(item, module);
		}

	}

	public static void addModule(ItemStack item, Module module) {
		addModule(item, module, module.isActive());
	}

	public static void addModule(ItemStack item, Module module, boolean active) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		if (!item.hasTagCompound())
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
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		List<Module> temp = getModules(item);
		for (Module tempModule : temp) {
			if (tempModule.getName().equalsIgnoreCase(module.getName()))
				tempModule.setActive(active);
		}
		setModules(item, temp);
	}

	public static void removeModule(ItemStack item, Module module) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		List<Module> newModules = new ArrayList<Module>();
		for (Module tempModule : getModules(item)) {
			if (!tempModule.getName().equalsIgnoreCase(module.getName()))
				newModules.add(tempModule);
		}
		setModules(item, newModules);
	}

	public static boolean installModule(ItemStack item, Module module, EntityPlayer player) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return false;
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
						if (!takenStack) {
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
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		int slot = player.inventory.getFirstEmptyStack();
		if(slot == -1) {
			PlayerUtilties.sendMessage(player, TranslateUtilities.translate("gui.module.inventory_full.name"));
			return;
		}
		removeModule(item, module);
		for (int i = 0; i < module.getRequirements().size(); i++) {
			ItemStack itemStack = module.getRequirements().get(i).copy();
			if(slot == -1) {
				player.entityDropItem(itemStack, 0f);
				return;
			}
			player.inventory.setInventorySlotContents(slot, itemStack);
		}
	}

	public static boolean checkModuleCompact(ItemStack item, Module module) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return false;
		try {
			EntityEquipmentSlot slotTemp = EntityLiving.getSlotForItemStack(item);
			int slot = slotTemp.getIndex();
			if (slot == module.getSlotType())
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}

	}

	public static boolean hasModule(ItemStack item, Module module) {
		return hasModule(item, module.getName());
	}

	public static boolean hasModule(ItemStack item, String moduleName) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return false;
		List<Module> temp = getModules(item);
		for (Module tempModule : temp) {
			if (moduleName.equalsIgnoreCase(tempModule.getName()))
				return true;
		}
		return false;
	}

	public static boolean isModuleActive(ItemStack item, Module module) {
		return isModuleActive(item, module.getName());
	}

	public static boolean isModuleActive(ItemStack item, String moduleName) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return false;
		List<Module> temp = getModules(item);
		for (Module tempModule : temp) {
			if (moduleName.equalsIgnoreCase(tempModule.getName()))
				return tempModule.isActive();
		}
		return false;
	}

	public static int getModulePassiveCost(Module module) {
		return getModulePassiveCost(module.getName());
	}

	public static int getModulePassiveCost(String moduleName) {
		List<Module> temp = ExtraPlanets_Modules.modules;
		for (Module tempModule : temp) {
			if (moduleName.equalsIgnoreCase(tempModule.getName()))
				return tempModule.getPassivePowerCost();
		}
		return 0;
	}

	public static int getModuleUseCost(Module module) {
		return getModuleUseCost(module.getName());
	}

	public static int getModuleUseCost(String moduleName) {
		List<Module> temp = ExtraPlanets_Modules.modules;
		for (Module tempModule : temp) {
			if (moduleName.equalsIgnoreCase(tempModule.getName()))
				return tempModule.getUsePowerCost();
		}
		return 0;
	}

	public static int getArmourStoredPower(ItemStack item) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return 0;
		return (int) ((ElectricArmorBase) item.getItem()).getElectricityStored(item);
	}

	public static void takeArmourPower(ItemStack item, int power) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return;
		((ElectricArmorBase) item.getItem()).discharge(item, power, true);
	}

	public static boolean hasPower(ItemStack item, int power) {
		if (item == null || !(item.getItem() instanceof IModularArmor))
			return false;
		if (getArmourStoredPower(item) >= power)
			return true;
		return false;
	}
}
