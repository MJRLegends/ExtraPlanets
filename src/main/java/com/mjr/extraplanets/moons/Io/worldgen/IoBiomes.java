package com.mjr.extraplanets.moons.Io.worldgen;

import com.mjr.extraplanets.Config;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class IoBiomes extends BiomeGenBase {

    public static final BiomeGenBase io = new BiomeGenIo(Config.ioBiomeID).setBiomeName("io");

    @SuppressWarnings("unchecked")
    IoBiomes(int var1)
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
    public IoBiomes setColor(int var1)
    {
	return (IoBiomes) super.setColor(var1);
    }

    @Override
    public float getSpawningChance()
    {
	return 0.01F;
    }
}
