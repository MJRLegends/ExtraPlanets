package com.mjr.extraplanets.moons.Titan.worldgen;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitan;
import com.mjr.mjrlegendslib.world.ChunkProviderMultiBiomeSpace;
import com.mjr.mjrlegendslib.world.gen.MapGenBaseMeta;
import com.mjr.mjrlegendslib.world.gen.MapGenCaveGen;
import com.mjr.mjrlegendslib.world.gen.MapGenRavineGen;

import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class ChunkProviderTitan extends ChunkProviderMultiBiomeSpace {
	private final BiomeDecoratorTitan ceresBiomeDecorator = new BiomeDecoratorTitan();
	private final MapGenRavineGen ravineGenerator = new MapGenRavineGen();
	private final MapGenCaveGen caveGenerator = new MapGenCaveGen(ExtraPlanets_Blocks.TITAN_BLOCKS, 0, 1, 2);

	public ChunkProviderTitan(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);

		this.stoneBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState().withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.STONE);
		this.waterBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	public int getCraterProbability() {
		return 0;
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
	}

	@Override
	protected void decoratePlanet(World world, Random rand, int x, int z) {
		this.ceresBiomeDecorator.decorate(world, rand, x, z);
	}

	@Override
	protected void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(this.worldObj, cX, cZ, primer);
	}

	@Override
	public void onPopulate(int cX, int cZ) {
	}
}
