package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenCaveKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenRavineKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.village.MapGenVillageKepler22b;
import com.mjr.extraplanets.world.prefabs.ChunkProviderSpaceNormal;

public class ChunkProviderKepler22b extends ChunkProviderSpaceNormal {
	private MapGenCaveKepler22b caveGenerator = new MapGenCaveKepler22b();
	private MapGenRavineKepler22b ravineGenerator = new MapGenRavineKepler22b();
	private final MapGenVillageKepler22b villageGenerator = new MapGenVillageKepler22b();
	private final BiomeDecoratorKepler22bOres BiomeDecorator = new BiomeDecoratorKepler22bOres();

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	public ChunkProviderKepler22b(World world, long seed, boolean flag) {
		super(world, seed, flag);
	}

	@Override
	public void decoratePlanet(World world, Random rand, int x, int z) {
		this.BiomeDecorator.decorate(world, rand, x, z);
	}

	@Override
	public String func_73148_d() {
		return "Kepler22bLevelSource";
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
		this.ravineGenerator.func_151539_a(this, this.worldObj, cX, cZ, blocks);
	}
}
