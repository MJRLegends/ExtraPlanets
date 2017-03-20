package com.mjr.extraplanets.moons.Triton.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderTriton extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return TritonBiomes.triton;
	}

}
