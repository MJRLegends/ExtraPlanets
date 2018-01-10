package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIoAshLands extends IoBiomes {
	public BiomeGenIoAshLands(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.ashBlock;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.ioBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.ioBlocks;
		this.stoneMeta = 2;
	}
}