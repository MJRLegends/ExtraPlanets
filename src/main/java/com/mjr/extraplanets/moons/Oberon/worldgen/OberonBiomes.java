package com.mjr.extraplanets.moons.Oberon.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class OberonBiomes extends BiomeGenBase {

	public static final BiomeGenBase oberon = new BiomeGenOberon(Config.oberonBiomeID).setBiomeName("oberon");

	@SuppressWarnings("unchecked")
	OberonBiomes(int var1)
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
	public OberonBiomes setColor(int var1)
	{
		return (OberonBiomes) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
