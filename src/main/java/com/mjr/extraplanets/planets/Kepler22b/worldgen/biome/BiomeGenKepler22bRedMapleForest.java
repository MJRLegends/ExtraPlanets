package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenKepler22bRedMapleForest extends BiomeGenBaseKepler22b {
	public BiomeGenKepler22bRedMapleForest(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_RED.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));

		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));

		this.getBiomeDecorator().redTreesPerChunk = 5;
		this.getBiomeDecorator().redShortGrassPerChunk = 90;
		this.getBiomeDecorator().redMedGrassPerChunk = 90;
		this.getBiomeDecorator().redTallGrassPerChunk = 90;
		this.getBiomeDecorator().redBigTreesPerChunk = 50;
		this.getBiomeDecorator().generateHuts = true;
	}
}