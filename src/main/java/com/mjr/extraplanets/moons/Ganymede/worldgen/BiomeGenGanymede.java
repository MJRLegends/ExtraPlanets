package com.mjr.extraplanets.moons.Ganymede.worldgen;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;

public class BiomeGenGanymede extends GanymedeBiomes {

	public BiomeGenGanymede(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
