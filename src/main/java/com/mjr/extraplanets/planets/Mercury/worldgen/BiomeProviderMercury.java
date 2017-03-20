package com.mjr.extraplanets.planets.Mercury.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderMercury extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return MercuryBiomes.mercury;
	}

}
