package com.mjr.extraplanets.moons.Phobos.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;

public class PhobosBiomes extends Biome {

	public static final Biome phobos = new BiomeGenPhobos(new BiomeProperties("phobos").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	PhobosBiomes(BiomeProperties properties)
	{
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
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
