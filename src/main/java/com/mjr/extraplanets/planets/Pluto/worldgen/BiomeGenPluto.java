package com.mjr.extraplanets.planets.Pluto.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenPluto extends PlutoBiomes {

	public BiomeGenPluto(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
