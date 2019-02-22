package com.mjr.extraplanets.moons.Titania.worldgen;

import com.mjr.extraplanets.Config;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenTitania extends TitaniaBiomes {

	public BiomeGenTitania(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
