package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTriton extends TritonBiomes {

	public BiomeGenTriton(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.TRITON_BIOME_ID, TritonBiomes.triton.getBiomeName(), TritonBiomes.triton);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.TRITON_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.TRITON_BLOCKS.getStateFromMeta(1);
	}
}
