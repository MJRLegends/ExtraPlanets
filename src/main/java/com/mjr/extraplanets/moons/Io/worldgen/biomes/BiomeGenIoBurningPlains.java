package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIoBurningPlains extends IoBiomes {
	public BiomeGenIoBurningPlains(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.volcanicRock;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.ashBlock;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanets_Blocks.ioBlocks;
		this.stoneMeta = 2;
	}
}