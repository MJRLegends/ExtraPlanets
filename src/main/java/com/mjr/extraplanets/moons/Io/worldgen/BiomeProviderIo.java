package com.mjr.extraplanets.moons.Io.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderIo extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return IoBiomes.io;
	}

}
