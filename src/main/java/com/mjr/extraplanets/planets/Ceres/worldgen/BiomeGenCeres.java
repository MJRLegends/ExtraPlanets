package com.mjr.extraplanets.planets.Ceres.worldgen;

import net.minecraftforge.common.BiomeDictionary;


public class BiomeGenCeres extends CeresBiomes {

	public BiomeGenCeres(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
