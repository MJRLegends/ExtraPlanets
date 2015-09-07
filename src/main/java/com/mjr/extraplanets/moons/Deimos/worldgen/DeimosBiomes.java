package com.mjr.extraplanets.moons.Deimos.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class DeimosBiomes extends BiomeGenBase {

	public static final BiomeGenBase deimos = new BiomeGenDeimos(Config.deimosBiomeID).setBiomeName("deimos");

	@SuppressWarnings("unchecked")
	DeimosBiomes(int var1)
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
	public DeimosBiomes setColor(int var1)
	{
		return (DeimosBiomes) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
