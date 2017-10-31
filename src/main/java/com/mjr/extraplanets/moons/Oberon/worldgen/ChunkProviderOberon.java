package com.mjr.extraplanets.moons.Oberon.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderOberon extends ChunkProviderCustomSpace {
	private final BiomeDecoratorOberon ioBiomeDecorator = new BiomeDecoratorOberon();
	private final BiomeDecoratorOberonOther ioBiomeDecorator2 = new BiomeDecoratorOberonOther();

	private final MapGenCaveOberon caveGenerator = new MapGenCaveOberon();

	public ChunkProviderOberon(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(2);
		this.waterBlock = Blocks.air.getDefaultState();
		this.seaLevel = 50;
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
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
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
