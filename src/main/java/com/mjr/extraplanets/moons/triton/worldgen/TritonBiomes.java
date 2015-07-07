package com.mjr.extraplanets.moons.triton.worldgen;

import com.mjr.extraplanets.Config;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class TritonBiomes extends BiomeGenBase {

    public static final BiomeGenBase triton = new BiomeGenTriton(Config.tritonBiomeID).setBiomeName("triton");

    @SuppressWarnings("unchecked")
    TritonBiomes(int var1)
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
    public TritonBiomes setColor(int var1)
    {
	return (TritonBiomes) super.setColor(var1);
    }

    @Override
    public float getSpawningChance()
    {
	return 0.01F;
    }
}
