package com.mjr.extraplanets.planets.Saturn.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenSaturn extends SaturnBiomes {

	public BiomeGenSaturn(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
