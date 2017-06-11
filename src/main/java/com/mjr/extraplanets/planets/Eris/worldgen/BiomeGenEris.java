package com.mjr.extraplanets.planets.Eris.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenEris extends ErisBiomes {

	public BiomeGenEris(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
