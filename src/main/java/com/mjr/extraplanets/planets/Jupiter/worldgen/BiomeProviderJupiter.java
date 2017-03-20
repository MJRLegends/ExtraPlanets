package com.mjr.extraplanets.planets.Jupiter.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderJupiter extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return JupiterBiomes.jupiter;
	}

}
