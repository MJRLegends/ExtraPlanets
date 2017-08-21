package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeDecoratorKepler22bOres;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenCaveKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenRavineKepler22b;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomNormal;

public class ChunkProviderKepler22b extends ChunkProviderCustomNormal {
	public ChunkProviderKepler22b(World world, long seed, boolean flag) {
		super(world, seed, flag);
		ChunkProviderCustomNormal.stoneBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1);
		ChunkProviderCustomNormal.waterBlock = Blocks.water.getDefaultState();
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
		this.ravineGenerator.generate(this, this.worldObj, cX, cX, primer);
	}
}
