package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

public class ExtraPlanets_Modules {
	public static List<Module> modules = new ArrayList<Module>();

	public static void init() {
		modules.add(new TestModule("test"));
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
