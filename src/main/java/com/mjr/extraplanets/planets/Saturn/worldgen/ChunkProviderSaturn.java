package com.mjr.extraplanets.planets.Saturn.worldgen;

import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
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
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicSaturn;

public class ChunkProviderSaturn extends ChunkProviderSpace {
    private final MapGenVillageSaturn villageGenerator = new MapGenVillageSaturn();

	private final BiomeDecoratorSaturn saturnBiomeDecorator = new BiomeDecoratorSaturn();

	private final MapGenCaveSaturn caveGenerator = new MapGenCaveSaturn();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeonSaturn(new DungeonConfiguration(ExtraPlanets_Blocks.saturnBlocks.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.DUNGEON_BRICK), 30, 8, 16, 7, 7, RoomBossSaturn.class, RoomTreasureSaturn.class));

	public ChunkProviderSaturn(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.saturnBiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { SaturnBiomes.saturn };
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
		if(Config.saturnLiquid)
			return new BlockMetaPair(ExtraPlanets_Fluids.glowstone,(byte) 0);
		else
			return new BlockMetaPair(ExtraPlanets_Blocks.saturnBlocks,(byte) 0);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		if(Config.saturnLiquid)
			return new BlockMetaPair(ExtraPlanets_Fluids.glowstone,(byte) 0);
		else
			return new BlockMetaPair(ExtraPlanets_Blocks.saturnBlocks,(byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanets_Blocks.saturnBlocks, (byte) 2);
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
		this.dungeonGenerator.generate(this, this.worldObj, cX, cZ, primer);
	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		this.dungeonGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(cX, cZ));
		this.villageGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(cX, cZ));
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.dungeonGenerator.generate(this, this.worldObj, x, z, null);
        this.villageGenerator.generate(this, this.worldObj, x, z, null);
	}
}
