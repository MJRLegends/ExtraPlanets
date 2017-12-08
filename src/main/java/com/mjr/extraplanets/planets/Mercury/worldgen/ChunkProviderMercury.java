package com.mjr.extraplanets.planets.Mercury.worldgen;

import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicMercury;
import com.mjr.extraplanets.world.MapGenRavinePlanet;

public class ChunkProviderMercury extends ChunkProviderSpace {
	private final MapGenVillageMercury villageGenerator = new MapGenVillageMercury();

	private final BiomeDecoratorMercury mercuryBiomeDecorator = new BiomeDecoratorMercury();
	private final MapGenRavinePlanet ravineGenerator = new MapGenRavinePlanet();
	private final MapGenCaveMercury caveGenerator = new MapGenCaveMercury();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeonMercury(new DungeonConfiguration(ExtraPlanets_Blocks.MERCURY_BLOCKS.getDefaultState().withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.DUNGEON_BRICK), 30,
			8, 16, 7, 7, RoomBossMercury.class, RoomTreasureMercury.class));

	public ChunkProviderMercury(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.mercuryBiomeDecorator;
	}

	@Override
	protected Biome[] getBiomesForGeneration() {
		return new Biome[] { MercuryBiomes.mercury };
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
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.MERCURY_BLOCKS, (byte) 0);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.MERCURY_BLOCKS, (byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.MERCURY_BLOCKS, (byte) 2);
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
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(this.worldObj, cX, cZ, primer);
		this.dungeonGenerator.generate(this.world, cX, cZ, primer);
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		this.dungeonGenerator.generateStructure(this.world, this.rand, new ChunkPos(cX, cZ));
		if (Config.MERCURY_VILLAGES)
			this.villageGenerator.generateStructure(this.world, this.rand, new ChunkPos(cX, cZ));
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.dungeonGenerator.generate(this.world, x, z, null);
		if (Config.MERCURY_VILLAGES)
			this.villageGenerator.generate(this.world, x, z, null);
	}
}
