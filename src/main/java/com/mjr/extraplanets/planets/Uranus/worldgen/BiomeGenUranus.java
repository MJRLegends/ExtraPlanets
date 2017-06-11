package com.mjr.extraplanets.planets.Uranus.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenUranus extends UranusBiomes {

	public BiomeGenUranus(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
