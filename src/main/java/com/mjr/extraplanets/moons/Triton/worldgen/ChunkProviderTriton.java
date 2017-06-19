package com.mjr.extraplanets.moons.Triton.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderTriton extends ChunkProviderCustomSpace {
	private final BiomeDecoratorTriton ceresBiomeDecorator = new BiomeDecoratorTriton();
	private final BiomeDecoratorTritonOther ceresBiomeDecorator2 = new BiomeDecoratorTritonOther();

	private final MapGenCaveTriton caveGenerator = new MapGenCaveTriton();

	public ChunkProviderTriton(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = ExtraPlanets_Blocks.TRITON_BLOCKS.getStateFromMeta(2);
		this.waterBlock = ExtraPlanets_Fluids.NITROGEN_ICE.getDefaultState();
		this.seaIceLayer = true;
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
		this.ceresBiomeDecorator2.decorate(world, rand, null, new BlockPos(x, 0, z));
	}

	@Override
	protected void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {

	}
}
