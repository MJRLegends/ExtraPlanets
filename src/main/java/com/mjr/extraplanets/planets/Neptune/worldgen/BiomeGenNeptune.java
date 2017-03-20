package com.mjr.extraplanets.planets.Neptune.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenNeptune extends NeptuneBiomes {

	public BiomeGenNeptune(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
