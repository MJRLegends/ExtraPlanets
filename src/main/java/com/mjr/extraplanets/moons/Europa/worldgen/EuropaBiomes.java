package com.mjr.extraplanets.moons.Europa.worldgen;

import com.mjr.extraplanets.Config;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class EuropaBiomes extends BiomeGenBase {

    public static final BiomeGenBase europa = new BiomeGenEuropa(Config.europaBiomeID).setBiomeName("europa");

    @SuppressWarnings("unchecked")
    EuropaBiomes(int var1)
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
