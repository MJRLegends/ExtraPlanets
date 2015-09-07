package com.mjr.extraplanets.planets.Ceres.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Jupiter.worldgen.BiomeGenJupiter;

public class CeresBiomes extends BiomeGenBase  {

	public static final BiomeGenBase ceres = new BiomeGenJupiter(Config.ceresBiomeID).setBiomeName("ceres");

	@SuppressWarnings("unchecked")
	CeresBiomes(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 10, 4, 4));
		this.rainfall = 0F;
	}

	@Override
	public CeresBiomes setColor(int var1)
	{
		return (CeresBiomes) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
