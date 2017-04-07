package com.mjr.extraplanets.moons.Europa.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenEuropa extends EuropaBiomes {

	public BiomeGenEuropa(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
