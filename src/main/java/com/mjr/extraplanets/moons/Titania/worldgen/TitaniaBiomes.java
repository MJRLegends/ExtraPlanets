package com.mjr.extraplanets.moons.Titania.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import com.mjr.extraplanets.Config;

public class TitaniaBiomes extends BiomeGenBase {

	public static final BiomeGenBase titania = new BiomeGenTitania(Config.titaniaBiomeID).setBiomeName("titania");

	@SuppressWarnings("unchecked")
	TitaniaBiomes(int var1)
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
	public TitaniaBiomes setColor(int var1)
	{
		return (TitaniaBiomes) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
