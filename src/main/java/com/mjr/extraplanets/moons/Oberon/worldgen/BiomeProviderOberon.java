package com.mjr.extraplanets.moons.Oberon.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderOberon extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return OberonBiomes.oberon;
	}

}
