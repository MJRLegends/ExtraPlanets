package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.entity.monster.EntityCaveSpider;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenKepler22bWasteLands extends BiomeGenBaseKepler22b {
	public BiomeGenKepler22bWasteLands() {
		super(Config.kepler22bWasteLandsBiomeID);
		this.enableRain = true;
		this.enableSnow = true;
		this.setTemperatureRainfall(0.8F, 0.9F);
		this.topBlock = ExtraPlanets_Blocks.kepler22bInfectedGrass;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.kepler22bBlocks;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanets_Blocks.kepler22bBlocks;
		this.stoneMeta = 1;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 100, 4, 4));
		this.getBiomeDecorator().greenShortGrassPerChunk = 50;
		this.getBiomeDecorator().generateHuts = false;
		this.getBiomeDecorator().treeWithNoLeafsPerChunk = 2;
		this.getBiomeDecorator().bigTreeWithNoLeafsPerChunk = 4;
		this.getBiomeDecorator().InfectedLakesPerChunk = 2;
	}
}