package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bWasteLands extends Kepler22bBiomes {
	public BiomeGenKepler22bWasteLands(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_INFECTED.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 100, 4, 4));
		this.getBiomeDecorator().greenShortGrassPerChunk = 50;
		this.getBiomeDecorator().generateHuts = false;
		this.getBiomeDecorator().treeWithNoLeafsPerChunk = 2;
		this.getBiomeDecorator().bigTreeWithNoLeafsPerChunk = 4;
		this.getBiomeDecorator().InfectedLakesPerChunk = 2;
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}