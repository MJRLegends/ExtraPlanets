package com.mjr.extraplanets.api.celestialBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;

public class CelestialBodyMaterialRegistry {
	public enum AmountType {

		VERY_LOW("Very Low"), LOW("Low"), MEDIUM("Medium"), HIGH("High"), VERY_HIGH("Very High");

		public String name;

		AmountType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	public static class MaterialData {
		public String materialName;
		public AmountType amountType;

		public MaterialData(String materialName, AmountType amountType) {
			this.materialName = materialName;
			this.amountType = amountType;
		}

		public String getMaterialName() {
			return materialName;
		}

		public AmountType getAmountType() {
			return amountType;
		}

	}

	private static HashMap<CelestialBody, List<MaterialData>> bodies = new HashMap<CelestialBody, List<MaterialData>>();

	public static HashMap<CelestialBody, List<MaterialData>> getBodies() {
		return bodies;
	}

	public static List<MaterialData> getMaterialDataByCelestialBody(CelestialBody celestialBody) {
		return bodies.get(celestialBody);
	}
	
	public static List<String> getTextOutputByCelestialBody(CelestialBody celestialBody) {
		List<MaterialData> materials = bodies.get(celestialBody);
		List<String> output = new ArrayList<String>();
		for(MaterialData material : materials) {
			output.add(material.getMaterialName() + ": " + material.getAmountType().getName());
		}
		return output;
	}

	public static void registerMaterialDataForCelestialBody(CelestialBody celestialBody, List<MaterialData> data) {
		bodies.put(celestialBody, data);
	}

	public static void addMaterialDataForCelestialBody(CelestialBody celestialBody, MaterialData data) {
		bodies.get(celestialBody).add(data);
	}

	public static void removeMaterialDataForCelestialBody(CelestialBody celestialBody, MaterialData data) {
		bodies.get(celestialBody).remove(data);
	}

	public static void clearMaterialDataForCelestialBody(CelestialBody celestialBody) {
		bodies.remove(celestialBody);
	}

}
