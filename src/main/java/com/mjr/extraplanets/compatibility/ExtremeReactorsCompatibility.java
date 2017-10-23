package com.mjr.extraplanets.compatibility;

import java.lang.reflect.Method;

public class ExtremeReactorsCompatibility {

	public static void init() {
		registerCompatibility();
	}

	private static void registerCompatibility() {
		try {
			Class<?> clazz = Class.forName("erogenousbeef.bigreactors.api.registry.ReactorInterior");
			if (clazz != null) {
				Method registerMethod = null;
				Method[] methodz = clazz.getMethods();
				for (Method m : methodz) {
					if (m.getName().equals("registerFluid")) {
						registerMethod = m;
						break;
					}
				}
				// String fluidName, float absorption, float heatEfficiency, float moderation, float heatConductivity

				registerMethod.invoke(null, "nitrogen_fluid", 0.76f, 0.90f, 6.00f, 3.5f);
				registerMethod.invoke(null, "nitrogen_ice_fluid", 0.79f, 0.95f, 6.00f, 4f);
				registerMethod.invoke(null, "frozen_water_fluid", 0.53f, 0.6f, 1.73f, 2.0f);
				registerMethod.invoke(null, "radioactive_water_fluid", 0.13f, 0.25f, 1.17f, 0.1f);
				registerMethod.invoke(null, "clean_water_fluid", 0.33f, 0.5f, 1.33f, 0.1f);
				registerMethod.invoke(null, "infected_water_fluid", 0.33f, 0.5f, 1.33f, 0.1f);
			}
		} catch (Exception e) {
		}
	}
}
