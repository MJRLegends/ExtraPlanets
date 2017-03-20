package com.mjr.extraplanets.planets.Neptune.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderNeptune extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return NeptuneBiomes.neptune;
	}

}
