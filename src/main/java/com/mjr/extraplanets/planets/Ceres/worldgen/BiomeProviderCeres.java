package com.mjr.extraplanets.planets.Ceres.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderCeres extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return CeresBiomes.ceres;
	}

}
