package com.mjr.extraplanets.moons.Europa.worldgen;

import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.mjrlegendslib.world.ChunkProviderMultiBiomeSpace;
import com.mjr.mjrlegendslib.world.gen.MapGenBaseMeta;
import com.mjr.mjrlegendslib.world.gen.MapGenCaveGen;
import com.mjr.mjrlegendslib.world.gen.MapGenFilledCaveGen;
import com.mjr.mjrlegendslib.world.gen.MapGenRavineGen;

public class ChunkProviderEuropa extends ChunkProviderMultiBiomeSpace {
	private final BiomeDecoratorEuropa ioBiomeDecorator = new BiomeDecoratorEuropa();
	@SuppressWarnings("unused")
	private final BiomeDecoratorEuropaOther ioBiomeDecorator2 = new BiomeDecoratorEuropaOther();
	private final MapGenRavineGen ravineGenerator = new MapGenRavineGen();
	private final MapGenCaveGen caveGenerator = new MapGenCaveGen(ExtraPlanets_Blocks.EUROPA_BLOCKS, 0, 1, 2);
	private final MapGenFilledCaveGen caveGenerator2 = new MapGenFilledCaveGen(ExtraPlanets_Blocks.EUROPA_BLOCKS, 0, 1, 2, ExtraPlanets_Fluids.SALT.getDefaultState());

	public ChunkProviderEuropa(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getStateFromMeta(2);
		this.waterBlock = Blocks.air.getDefaultState();
		this.seaLevel = 50;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		generators.add(this.caveGenerator2);
		return generators;
	}

	@Override
	public int getCraterProbability() {
		return 0;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(this, this.worldObj, cX, cZ, primer);
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
	}

	@Override
	protected void decoratePlanet(World world, Random rand, int x, int z) {
		this.ioBiomeDecorator.decorate(world, rand, x, z);
		// this.ioBiomeDecorator2.decorate(world, rand, null, new BlockPos(x, 0, z));
	}

	@Override
	public void onPopulate(int cX, int cZ) {
	}
}
