package com.mjr.extraplanets.moons.Phobos.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderPhobos extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return PhobosBiomes.phobos;
	}

}
