package com.mjr.extraplanets.moons.Rhea.worldgen;

import com.mjr.extraplanets.Config;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenRhea extends RheaBiomes {

	public BiomeGenRhea(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
