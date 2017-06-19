package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTritonIceLands extends TritonBiomes {

	public BiomeGenTritonIceLands(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.TRITON_ICE_LANDS_BIOME_ID, TritonBiomes.tritonIceLands.getBiomeName(), TritonBiomes.tritonIceLands);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.FROZEN_NITROGEN.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.TRITON_BLOCKS.getStateFromMeta(1);
	}
}
