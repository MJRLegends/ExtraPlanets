package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class BiomeGenOberonValleys extends OberonBiomes {

	public BiomeGenOberonValleys(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(1);
		this.fillerBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(2);
	}
}
