package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

public class ExtraPlanets_Modules {
	public static List<Module> modules = new ArrayList<Module>();

	public static void init() {
		modules.add(new ModuleSensorGlasses("sensor_glasses"));
		modules.add(new TestModule("test"));
		modules.add(new TestModule("test2"));
		modules.add(new TestModule("test3"));
		modules.add(new TestModule("test4"));
		modules.add(new TestModule("test5"));
		modules.add(new TestModule("test6"));
		modules.add(new TestModule("test7"));
		modules.add(new TestModule("test8"));
		modules.add(new TestModule("test9"));
		modules.add(new TestModule("test10"));
	}

	public static List<Module> getModules() {
		return modules;
	}

	public static void setModules(List<Module> modules) {
		ExtraPlanets_Modules.modules = modules;
	}

	public static void addModule(Module module) {
		modules.add(module);
	}

	public static void removeModule(Module module) {
		modules.remove(module);
	}
}
