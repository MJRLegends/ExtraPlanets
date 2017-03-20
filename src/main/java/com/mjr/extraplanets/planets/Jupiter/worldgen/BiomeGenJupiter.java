package com.mjr.extraplanets.planets.Jupiter.worldgen;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenJupiter extends JupiterBiomes {

	public BiomeGenJupiter(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
