package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import java.util.Collections;
import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturnHydroCarbonSea extends SaturnBiomes {

	public BiomeGenSaturnHydroCarbonSea(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.SATURN_HYDROCARBON_SEA_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getStateFromMeta(1);
	}

	@Override
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Collections.<Biome.SpawnListEntry> emptyList();
	}
}
