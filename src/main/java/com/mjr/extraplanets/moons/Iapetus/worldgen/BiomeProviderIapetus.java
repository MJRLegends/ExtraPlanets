package com.mjr.extraplanets.moons.Iapetus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderIapetus extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return IapetusBiomes.iapetus;
	}

}
