package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiter extends JupiterBiomes {
	public BiomeGenJupiter(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.jupiterBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.jupiterBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.jupiterBlocks;
		this.stoneMeta = 2;
	}
}