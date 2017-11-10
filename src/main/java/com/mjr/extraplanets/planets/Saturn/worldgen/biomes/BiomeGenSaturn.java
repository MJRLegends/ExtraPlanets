package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturn extends SaturnBiomes {

	public BiomeGenSaturn(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.SATURN_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
        BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        this.topBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState();
        this.fillerBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getStateFromMeta(1);
	}
}
