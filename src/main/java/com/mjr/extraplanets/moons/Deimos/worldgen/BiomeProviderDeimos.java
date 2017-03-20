package com.mjr.extraplanets.moons.Deimos.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderDeimos extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return DeimosBiomes.deimos;
	}

}
