package com.mjr.extraplanets.planets.Pluto.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.entities.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.MapGenVillagePluto;

public class ChunkProviderPluto extends ChunkProviderSpace {
	private final BiomeDecoratorPluto BiomeDecorator = new BiomeDecoratorPluto();
	public Random randomGenerator;

	private final MapGenCavePluto caveGenerator = new MapGenCavePluto();

	private final MapGenVillagePluto villageGenerator = new MapGenVillagePluto();


	public ChunkProviderPluto(World par1World, long seed,
			boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);

	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.BiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { PlutoBiomes.pluto };
	}

	@Override
	protected int getSeaLevel() {
		return 93;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	protected BiomeGenBase.SpawnListEntry[] getMonsters()
	{
		List<BiomeGenBase.SpawnListEntry> monsters = new ArrayList<BiomeGenBase.SpawnListEntry>();
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedEnderman.class, 8, 2, 3));
		//monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedWizard.class, 8, 2, 3));
		//monsters.add(new BiomeGenBase.SpawnListEntry(EvolvedFireAllen.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedPowerSkeleton.class, 8, 2, 3));
		return monsters.toArray(new BiomeGenBase.SpawnListEntry[monsters.size()]);
	}

	@Override
	protected BiomeGenBase.SpawnListEntry[] getCreatures()
	{
		return new BiomeGenBase.SpawnListEntry[0];
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(ExtraPlanetsBlocks.plutoSurface, (byte) 1);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(ExtraPlanetsBlocks.plutoSubSurface, (byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanetsBlocks.plutoStone, (byte) 1);
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