package com.mjr.extraplanets.compatibility;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.compatibility.MMPowersuitsModules.PressureModule;
import com.mjr.extraplanets.compatibility.MMPowersuitsModules.RadiationModule;
import com.mjr.mjrlegendslib.util.MessageUtilities;

import net.machinemuse.powersuits.common.ModuleManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(modid = "powersuits", iface = "net.machinemuse.numina.module.IPowerModule")
public class MachineMusePowersuitsCompatibility {
	public static void init() {
		registerModules();
	}

	private static void registerModules() {
		try {
			ModuleManager.INSTANCE.addModule(new PressureModule(1));
			ModuleManager.INSTANCE.addModule(new PressureModule(2));
			ModuleManager.INSTANCE.addModule(new PressureModule(3));
			ModuleManager.INSTANCE.addModule(new PressureModule(4));
			ModuleManager.INSTANCE.addModule(new RadiationModule(1));
			ModuleManager.INSTANCE.addModule(new RadiationModule(2));
			ModuleManager.INSTANCE.addModule(new RadiationModule(3));
			ModuleManager.INSTANCE.addModule(new RadiationModule(4));
		} catch (Exception e) {
			MessageUtilities.warnErrorMessageToLog(Constants.modID, "An error occurred when setting up MachineMusePowersuits Compatibility, this is most likey intended!");
		}
	}

	public static int getHighestRadiationTierModuleInstalled(ItemStack stack) {
		int tier = 0;
		if (ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_1"))
			tier = 1;
		if (ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_2"))
			tier = 2;
		if (ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_3"))
			tier = 3;
		if (ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_4"))
			tier = 4;
		return tier;
	}

	public static boolean isPressureModuleInstalled(ItemStack stack) {
		if (ModuleManager.INSTANCE.itemHasActiveModule(stack, "pressure_module_1") || ModuleManager.INSTANCE.itemHasActiveModule(stack, "pressure_module_2") || ModuleManager.INSTANCE.itemHasActiveModule(stack, "pressure_module_3")
				|| ModuleManager.INSTANCE.itemHasActiveModule(stack, "pressure_module_4"))
			return true;
		else
			return false;
	}

	public static boolean isRadiationModuleInstalled(ItemStack stack) {
		if (ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_1") || ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_2") || ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_3")
				|| ModuleManager.INSTANCE.itemHasActiveModule(stack, "radiation_module_4"))
			return true;
		else
			return false;
	}
}
