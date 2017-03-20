package com.mjr.extraplanets.planets.Eris.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderEris extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return ErisBiomes.eris;
	}

}
