package com.mjr.extraplanets.planets.Uranus.worldgen.biomes;

import net.minecraft.init.Blocks;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;

public class BiomeGenUranusSnowLands extends UranusBiomes {
	public BiomeGenUranusSnowLands(int par1) {
		super(par1);
		this.topBlock = Blocks.snow;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.uranusBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.uranusBlocks;
		this.stoneMeta = 2;
	}
}