package com.mjr.extraplanets.planets.Uranus.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenUranusFrozenSea extends UranusBiomes {

	public BiomeGenUranusFrozenSea(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = null;
		this.topMeta = 0;
		this.fillerBlock = null;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.uranusBlocks;
		this.stoneMeta = 2;
	}
}