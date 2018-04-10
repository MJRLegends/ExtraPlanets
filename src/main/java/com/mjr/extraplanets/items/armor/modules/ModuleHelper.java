package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.mjr.extraplanets.api.IModularArmor;

public class ModuleHelper {

	public static void setupModulesNBT(ItemStack item) {
		if (item.getItem() instanceof IModularArmor) {
			final NBTTagCompound nbt = new NBTTagCompound();
			if (!item.hasTagCompound()) {
				NBTTagList tagList = new NBTTagList();
				nbt.setTag("modules", tagList);
				item.setTagCompound(nbt);
			}
		}
	}

	public static List<Module> getModules(ItemStack item) {
		List<Module> temp = new ArrayList<Module>();
		if (item.hasTagCompound()) {
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagList tagList = nbt.getTagList("modules", 10);
			for (int i = 0; i < tagList.tagCount(); i++) {
				for (int j = 0; j < ExtraPlanets_Modules.modules.size(); j++) {
					final NBTTagCompound nbttagcompound = tagList.getCompoundTagAt(i);
					if (ExtraPlanets_Modules.modules.get(j).getName().equalsIgnoreCase(nbttagcompound.getString("module"))) {
						temp.add(ExtraPlanets_Modules.modules.get(j));
					}
				}
			}
			return temp;
		}
		return new ArrayList<Module>();
	}

	public static void setModules(ItemStack item, ArrayList<Module> modules) {
		item.setTagCompound(new NBTTagCompound());
		for (Module module : modules) {
			addModule(item, module);
		}
	}

	public static void addModule(ItemStack item, Module module) {
		if (!item.hasTagCompound())
			setupModulesNBT(item);

		final NBTTagCompound nbt = item.getTagCompound();
		NBTTagList tagList = nbt.getTagList("modules", 10);
		NBTTagCompound moduleNBT = new NBTTagCompound();
		moduleNBT.setString("module", module.getName());
		tagList.appendTag(moduleNBT);
		nbt.setTag("modules", tagList);
		item.setTagCompound(nbt);
	}

	public static void removeModule(ItemStack item, Module module) {

	}
}
