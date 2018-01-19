package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenCaveKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenRavineKepler22b;
import com.mjr.extraplanets.world.prefabs.ChunkProviderMultiBiomeNormal;
import com.mjr.mjrlegendslib.world.gen.MapGenBaseMeta;

public class ChunkProviderKepler22b extends ChunkProviderMultiBiomeNormal {
	public ChunkProviderKepler22b(World world, long seed, boolean flag) {
		super(world, seed, flag);
		ChunkProviderMultiBiomeNormal.stoneBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState().withProperty(BlockBasicKepler22b.BASIC_TYPE, BlockBasicKepler22b.EnumBlockBasic.STONE);
		ChunkProviderMultiBiomeNormal.waterBlock = Blocks.WATER.getDefaultState();
	}

	private final MapGenCaveKepler22b caveGenerator = new MapGenCaveKepler22b();
	private final MapGenRavineKepler22b ravineGenerator = new MapGenRavineKepler22b();
	private final BiomeDecoratorKepler22bOres BiomeDecorator = new BiomeDecoratorKepler22bOres();

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
	}

	@Override
	public void decoratePlanet(World world, Random rand, int x, int z) {
		this.BiomeDecorator.decorate(world, rand, x, z);
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(worldObj, cX, cZ, primer);
	}
}