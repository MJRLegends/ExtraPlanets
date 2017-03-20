package com.mjr.extraplanets.moons.Europa.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import com.mjr.extraplanets.Config;

public class EuropaBiomes extends BiomeGenBase {

	public static final BiomeGenBase europa = new BiomeGenEuropa(Config.europaBiomeID).setBiomeName("europa");

	@SuppressWarnings("unchecked")
	EuropaBiomes(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		this.rainfall = 0F;
	}

	@Override
	public EuropaBiomes setColor(int var1)
	{
		return (EuropaBiomes) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
