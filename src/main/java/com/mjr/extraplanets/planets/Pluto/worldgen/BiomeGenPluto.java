package com.mjr.extraplanets.planets.Pluto.worldgen;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenPluto extends PlutoBiomes {

	public BiomeGenPluto(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.PLUTO_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
