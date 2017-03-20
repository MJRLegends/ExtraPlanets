package com.mjr.extraplanets.moons.Titan.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderTitan extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return TitanBiomes.titan;
	}

}
