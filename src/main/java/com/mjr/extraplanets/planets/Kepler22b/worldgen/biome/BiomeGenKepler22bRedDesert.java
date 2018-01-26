package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bRedDesert extends Kepler22bBiomes {
	@SuppressWarnings("unchecked")
	public BiomeGenKepler22bRedDesert() {
		super(Config.kepler22bRedDesertBiomeID);
		this.enableRain = false;
		this.enableSnow = true;
		this.topBlock = ExtraPlanets_Blocks.redSand;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.redSand;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanets_Blocks.redSandstone;
		this.stoneMeta = 1;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));

		this.getBiomeDecorator().generateHuts = false;
	}
}