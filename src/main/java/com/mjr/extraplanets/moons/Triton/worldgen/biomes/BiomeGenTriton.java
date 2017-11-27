package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTriton extends TritonBiomes {
	public BiomeGenTriton(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.tritonBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.tritonBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.tritonBlocks;
		this.stoneMeta = 2;
	}
}