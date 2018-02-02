package com.mjr.extraplanets.moons.Callisto.worldgen;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;

public class BiomeGenCallisto extends CallistoBiomes {

	public BiomeGenCallisto(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes() {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
