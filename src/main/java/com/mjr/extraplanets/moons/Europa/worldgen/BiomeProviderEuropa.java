package com.mjr.extraplanets.moons.Europa.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderEuropa extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return EuropaBiomes.europa;
	}

}
