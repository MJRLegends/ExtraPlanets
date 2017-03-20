package com.mjr.extraplanets.moons.Titania.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderTitania extends BiomeProviderSpace {

	@Override
	public Biome getBiome() {
		return TitaniaBiomes.titania;
	}

}
