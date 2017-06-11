package com.mjr.extraplanets.moons.Triton.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenTriton extends TritonBiomes {

	public BiomeGenTriton(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
