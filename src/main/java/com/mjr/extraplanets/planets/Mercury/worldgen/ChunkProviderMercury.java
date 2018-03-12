package com.mjr.extraplanets.planets.Mercury.worldgen;

import java.util.ArrayList;
import java.util.List;

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
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedWitch;
import com.mjr.extraplanets.planets.Mercury.worldgen.village.MapGenVillageMercury;

public class ChunkProviderMercury extends ChunkProviderSpace {

	private final BiomeDecoratorMercury biomeDecorator = new BiomeDecoratorMercury();

	private final MapGenCaveMercury caveGenerator = new MapGenCaveMercury();

	private final MapGenRavineMercury ravineGenerator = new MapGenRavineMercury();

	private final MapGenVillageMercury villageGenerator = new MapGenVillageMercury();

	public ChunkProviderMercury(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);

	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.biomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { MercuryBiomes.mercury };
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
	protected BiomeGenBase.SpawnListEntry[] getMonsters() {
		List<BiomeGenBase.SpawnListEntry> monsters = new ArrayList<BiomeGenBase.SpawnListEntry>();
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		if (Config.evolvedWitch)
			monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedWitch.class, 8, 2, 3));
		if (Config.evolvedEnderman)
			monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedEnderman.class, 8, 2, 3));
		if (Config.evolvedBlaze)
			monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedBlaze.class, 8, 2, 3));
		return monsters.toArray(new BiomeGenBase.SpawnListEntry[monsters.size()]);
	}

	@Override
	protected BiomeGenBase.SpawnListEntry[] getCreatures() {
		return new BiomeGenBase.SpawnListEntry[0];
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.mercuryBlocks, (byte) 0);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.mercuryBlocks, (byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.mercuryBlocks, (byte) 2);
	}

	@Override
	public double getHeightModifier() {
		return 24;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 40;
	}

	@Override
	public double getMountainHeightModifier() {
		return 160;
	}

	@Override
	public double getValleyHeightModifier() {
		return 75;
	}

	@Override
	public int getCraterProbability() {
		return 75;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
		this.ravineGenerator.func_151539_a(this, this.worldObj, cX, cZ, blocks);
	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		if (Config.mercuryVillages)
			this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		if (Config.mercuryVillages)
			this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
	}
}
