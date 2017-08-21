package com.mjr.extraplanets.moons.Phobos.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenPhobos extends PhobosBiomes {

	public BiomeGenPhobos(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
