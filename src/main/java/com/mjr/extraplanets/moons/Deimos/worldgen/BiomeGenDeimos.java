package com.mjr.extraplanets.moons.Deimos.worldgen;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;

public class BiomeGenDeimos extends DeimosBiomes {

	public BiomeGenDeimos(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes() {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
