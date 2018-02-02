package com.mjr.extraplanets.planets.Ceres.worldgen;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;

public class BiomeGenCeres extends CeresBiomes {

	public BiomeGenCeres(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
