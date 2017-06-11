package com.mjr.extraplanets.planets.Pluto.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;

public class BiomeGenPluto extends PlutoBiomes {

	public BiomeGenPluto(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.PLUTO_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
