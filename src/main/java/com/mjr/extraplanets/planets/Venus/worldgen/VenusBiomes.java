package com.mjr.extraplanets.planets.Venus.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class VenusBiomes extends BiomeGenBase {

    public static final BiomeGenBase venus = new BiomeGenVenus(Config.venusBiomeID).setBiomeName("venus");

    @SuppressWarnings("unchecked")
    VenusBiomes(int var1)
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
    public VenusBiomes setColor(int var1)
    {
	return (VenusBiomes) super.setColor(var1);
    }

    @Override
    public float getSpawningChance()
    {
	return 0.01F;
    }
}
