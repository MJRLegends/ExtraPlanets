package com.mjr.extraplanets.moons.Rhea.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderRhea extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return RheaBiomes.rhea;
	}

}
