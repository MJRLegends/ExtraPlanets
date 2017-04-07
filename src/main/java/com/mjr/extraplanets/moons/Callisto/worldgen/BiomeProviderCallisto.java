package com.mjr.extraplanets.moons.Callisto.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderCallisto extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return CallistoBiomes.callisto;
	}

}
