package com.mjr.extraplanets.planets.Pluto.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderPluto extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return PlutoBiomes.pluto;
	}

}
