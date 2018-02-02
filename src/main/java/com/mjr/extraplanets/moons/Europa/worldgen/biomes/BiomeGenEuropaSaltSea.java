package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEuropa;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class BiomeGenEuropaSaltSea extends EuropaBiomes {
	public BiomeGenEuropaSaltSea(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.EUROPA_SALT_SEA_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OCEAN);
		this.spawnableCreatureList.clear();
		this.topBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getDefaultState().withProperty(BlockBasicEuropa.BASIC_TYPE, BlockBasicEuropa.EnumBlockBasic.SUB_SURFACE);
	}

	@Override
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Lists.<Biome.SpawnListEntry> newArrayList();
	}
}