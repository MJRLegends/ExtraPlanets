package com.mjr.extraplanets.planets.Mercury.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenMercury extends MercuryBiomes {

	public BiomeGenMercury(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
