package com.mjr.extraplanets.planets.Uranus.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class UranusBiomes extends BiomeGenBase {

    public static final BiomeGenBase uranus = new BiomeGenUranus(Config.uranusBiomeID).setBiomeName("uranus");

    @SuppressWarnings("unchecked")
    UranusBiomes(int var1)
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
    public UranusBiomes setColor(int var1)
    {
	return (UranusBiomes) super.setColor(var1);
    }

    @Override
    public float getSpawningChance()
    {
	return 0.01F;
    }
}
