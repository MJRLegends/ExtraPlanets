package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTritonIceSea extends TritonBiomes {

	public BiomeGenTritonIceSea(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.TRITON_ICE_SEA_BIOME_ID, TritonBiomes.tritonIceSea.getBiomeName(), TritonBiomes.tritonIceSea);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OCEAN);
	}
}
