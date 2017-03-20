package com.mjr.extraplanets.moons.Callisto.worldgen;

import net.minecraft.world.biome.Biome;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;

public class BiomeProviderCallisto extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return CallistoBiomes.callisto;
	}

}
