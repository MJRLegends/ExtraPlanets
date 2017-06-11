package com.mjr.extraplanets.moons.Callisto.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenCallisto extends CallistoBiomes {

	public BiomeGenCallisto(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
