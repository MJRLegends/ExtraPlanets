package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiter extends JupiterBiomes {

	public BiomeGenJupiter(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.JUPITER_BIOME_ID, JupiterBiomes.jupiter.getBiomeName(), JupiterBiomes.jupiter);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
