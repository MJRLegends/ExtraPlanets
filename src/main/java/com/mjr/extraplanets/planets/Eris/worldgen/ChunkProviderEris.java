package com.mjr.extraplanets.planets.Eris.worldgen;

import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEris;
import com.mjr.extraplanets.world.prefabs.ChunkProviderSingleBiomeSpace;
import com.mjr.mjrlegendslib.world.gen.MapGenBaseMeta;
import com.mjr.mjrlegendslib.world.gen.MapGenCaveGen;
import com.mjr.mjrlegendslib.world.gen.MapGenRavineGen;

public class ChunkProviderEris extends ChunkProviderSingleBiomeSpace {
	private final MapGenVillageEris villageGenerator = new MapGenVillageEris();

	private final BiomeDecoratorEris erisBiomeDecorator = new BiomeDecoratorEris();
	private final MapGenRavineGen ravineGenerator = new MapGenRavineGen();
	private final MapGenCaveGen caveGenerator = new MapGenCaveGen(ExtraPlanets_Blocks.ERIS_BLOCKS, 0, 1, 2);

	private final MapGenDungeon dungeonGenerator = new MapGenDungeonEris(new DungeonConfiguration(ExtraPlanets_Blocks.ERIS_BLOCKS.getDefaultState().withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.DUNGEON_BRICK), 30, 8, 16, 7,
			7, RoomBossEris.class, RoomTreasureEris.class));

	public ChunkProviderEris(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.erisBiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { ErisBiomes.eris };
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
		return new BlockMetaPair(ExtraPlanets_Blocks.ERIS_BLOCKS, (byte) 0);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.ERIS_BLOCKS, (byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.ERIS_BLOCKS, (byte) 2);
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
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(this, this.worldObj, cX, cZ, primer);
		this.dungeonGenerator.generate(this, this.worldObj, cX, cZ, primer);
	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		this.dungeonGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(cX, cZ));
		if (Config.ERIS_VILLAGES)
			this.villageGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(cX, cZ));
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.dungeonGenerator.generate(this, this.worldObj, x, z, null);
		if (Config.ERIS_VILLAGES)
			this.villageGenerator.generate(this, this.worldObj, x, z, null);
	}
}
