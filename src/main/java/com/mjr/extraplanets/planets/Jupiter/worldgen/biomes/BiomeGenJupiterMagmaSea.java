package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiterMagmaSea extends JupiterBiomes {

	public BiomeGenJupiterMagmaSea(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.JUPITER_SEA_BIOME_ID, JupiterBiomes.jupiterMagmaSea.getBiomeName(), JupiterBiomes.jupiterMagmaSea);
        BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
	}
}
