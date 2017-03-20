package com.mjr.extraplanets.planets.Uranus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderUranus extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return UranusBiomes.uranus;
	}

}
