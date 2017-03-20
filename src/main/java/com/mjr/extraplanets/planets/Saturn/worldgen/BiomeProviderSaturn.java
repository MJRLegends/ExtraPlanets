package com.mjr.extraplanets.planets.Saturn.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderSaturn extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return SaturnBiomes.saturn;
	}

}
