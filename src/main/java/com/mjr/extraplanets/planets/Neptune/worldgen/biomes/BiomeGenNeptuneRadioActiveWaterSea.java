package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptuneRadioActiveWaterSea extends NeptuneBiomes {

	public BiomeGenNeptuneRadioActiveWaterSea(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = null;
		this.topMeta = 0;
		this.fillerBlock = null;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.stoneMeta = 2;
	}
}