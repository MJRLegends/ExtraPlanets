package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class BiomeGenValleys extends OberonBiomes {
	public BiomeGenValleys(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.oberonBlocks;
		this.topMeta = 1;
		this.fillerBlock = ExtraPlanets_Blocks.oberonBlocks;
		this.fillerMeta = 2;
		this.stoneBlock = ExtraPlanets_Blocks.oberonBlocks;
		this.stoneMeta = 2;
	}
}