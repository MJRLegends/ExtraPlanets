package com.mjr.extraplanets.planets.Jupiter.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;

public class BiomeGenJupiter extends JupiterBiomes {

	public BiomeGenJupiter(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.JUPITER_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
        BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
