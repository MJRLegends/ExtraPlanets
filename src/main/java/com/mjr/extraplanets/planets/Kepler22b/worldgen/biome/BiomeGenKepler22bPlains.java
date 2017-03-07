package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenKepler22bPlains extends BiomeGenBaseKepler22b {
	public BiomeGenKepler22bPlains() {
		super(Config.kepler22bPlainsBiomeID);
		this.enableRain = true;
		this.enableSnow = true;
		this.setTemperatureRainfall(0.8F, 0.9F);
		this.topBlock = ExtraPlanets_Blocks.kepler22bGrass.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.kepler22bBlocks.getDefaultState();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));

		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
		
		this.getBiomeDecorator().brownTreesPerChunk = 1;
		this.getBiomeDecorator().greenTreesPerChunk = 1;
		this.getBiomeDecorator().greenShortGrassPerChunk = 90;
		this.getBiomeDecorator().greenMedGrassPerChunk = 90;
		this.getBiomeDecorator().greenTallGrassPerChunk = 90;
	}
}