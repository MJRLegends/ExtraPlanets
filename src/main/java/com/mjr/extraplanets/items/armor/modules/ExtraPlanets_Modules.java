package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

public class ExtraPlanets_Modules {
	public final static List<Module> modules = new ArrayList<Module>();

	public static void init() {
		modules.add(new ModuleSensorGlasses("sensor_glasses"));
		modules.add(new ModuleNoFallDamage("no_fall_damage"));
		modules.add(new ModuleGeigerCounter("geiger_counter"));
		modules.add(new ModulePreLaunchChecklist("pre_launch_checklist"));
		modules.add(new ModulePortableNASAWorkBench("nasa_workbench"));
		modules.add(new ModuleOxygenTankSwitch("oxygen_tank_switch"));
		// modules.add(new TestModule("test"));
	}

	public static List<Module> getModules() {
		return modules;
	}

	public static void addModule(Module module) {
		modules.add(module);
	}

	public static void removeModule(Module module) {
		modules.remove(module);
	}
}
