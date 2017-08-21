package com.mjr.extraplanets.planets.Ceres.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;

public class CeresBiomes extends Biome {

	public static final Biome ceres = new BiomeGenCeres(new BiomeProperties("ceres").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	CeresBiomes(BiomeProperties properties) {
		super(properties);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}
