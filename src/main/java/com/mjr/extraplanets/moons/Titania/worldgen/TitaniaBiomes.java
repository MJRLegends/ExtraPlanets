package com.mjr.extraplanets.moons.Titania.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.moons.Ganymede.worldgen.BiomeGenGanymede;

public class TitaniaBiomes extends BiomeGenBase {
	public static final BiomeGenBase titania = new BiomeGenGanymede(Config.TITANIA_BIOME_ID).setBiomeName("titania").setHeight(new Height(2.5F, 0.4F));

	TitaniaBiomes(int par1) {
		super(par1);
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
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
