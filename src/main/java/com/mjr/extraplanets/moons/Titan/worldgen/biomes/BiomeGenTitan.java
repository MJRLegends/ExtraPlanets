package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class BiomeGenTitan extends TitanBiomes {
	public BiomeGenTitan(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.titanBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.titanBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.titanBlocks;
		this.stoneMeta = 2;
	}
}