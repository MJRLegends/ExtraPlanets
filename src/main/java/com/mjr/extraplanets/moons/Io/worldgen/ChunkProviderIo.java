package com.mjr.extraplanets.moons.Io.worldgen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.IChunkProvider;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.village.MapGenVillageIo;

public class ChunkProviderIo extends ChunkProviderSpace {

	private final BiomeDecoratorIo greenPixelBiomeDecorator = new BiomeDecoratorIo();
	
	private final MapGenCaveIo caveGenerator = new MapGenCaveIo();

	private final MapGenVillageIo villageGenerator = new MapGenVillageIo();

	public ChunkProviderIo(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.greenPixelBiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { IoBiomes.io };
	}

	@Override
	protected int getSeaLevel() {
		return 64;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	protected SpawnListEntry[] getMonsters() {
		List<BiomeGenBase.SpawnListEntry> monsters = new ArrayList<BiomeGenBase.SpawnListEntry>();
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 8, 1, 3));
		return monsters.toArray(new BiomeGenBase.SpawnListEntry[monsters.size()]);
	}

	@Override
	protected SpawnListEntry[] getCreatures() {
		List<BiomeGenBase.SpawnListEntry> creatures = new ArrayList<BiomeGenBase.SpawnListEntry>();
		creatures.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 8, 2, 4));
		creatures.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 8, 2, 6));
		creatures.add(new BiomeGenBase.SpawnListEntry(EntityHorse.class, 8, 2, 4));
		creatures.add(new BiomeGenBase.SpawnListEntry(EntityPig.class, 8, 2, 6));
		creatures.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 8, 2, 6));
		return creatures.toArray(new BiomeGenBase.SpawnListEntry[creatures.size()]);
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.ioBlocks, (byte) 0);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.ioBlocks, (byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.ioBlocks, (byte) 2);
	}

	@Override
	public double getHeightModifier() {
		return 12;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 26;
	}

	@Override
	public double getMountainHeightModifier() {
		return 95;
	}

	@Override
	public double getValleyHeightModifier() {
		return 50;
	}

	@Override
	public int getCraterProbability() {
		return 2000;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
	}

}
