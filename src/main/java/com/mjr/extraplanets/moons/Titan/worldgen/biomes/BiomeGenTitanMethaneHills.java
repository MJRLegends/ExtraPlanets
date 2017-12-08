package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitan;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class BiomeGenTitanMethaneHills extends TitanBiomes {
	public BiomeGenTitanMethaneHills(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.TITAN_METHANE_HILLS_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState().withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.METHANE_INFECTED_SURFACE_ROCK);
		this.fillerBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState().withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.METHANE_INFECTED_SUB_SURFACE_ROCK);
	}
}
