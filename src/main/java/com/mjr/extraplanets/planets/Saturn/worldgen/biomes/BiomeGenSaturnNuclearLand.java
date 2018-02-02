package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturnNuclearLand extends SaturnBiomes {

	public BiomeGenSaturnNuclearLand(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.BROKEN_INFECTED_STONE);
		this.fillerBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.INFECTED_STONE);
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);	}
}
