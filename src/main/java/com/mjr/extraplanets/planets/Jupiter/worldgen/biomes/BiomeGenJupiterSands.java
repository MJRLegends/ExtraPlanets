package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiterSands extends JupiterBiomes {
	public BiomeGenJupiterSands(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.orangeSand;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.orangeSandstone;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanets_Blocks.jupiterBlocks;
		this.stoneMeta = 2;
	}
}