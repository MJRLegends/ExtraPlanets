package com.mjr.extraplanets.world.prefabs;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public abstract class ChunkProviderCustomSpace extends ChunkProviderGenerate {
	protected Random rand;
	protected World worldObj;
	private double[] depthBuffer;
	private BiomeGenBase[] biomesForGeneration;
	private NoiseGeneratorOctaves minLimitPerlinNoise;
	private NoiseGeneratorOctaves maxLimitPerlinNoise;
	private NoiseGeneratorOctaves mainPerlinNoise;
	private NoiseGeneratorPerlin surfaceNoise;
	public NoiseGeneratorOctaves scaleNoise;
	public NoiseGeneratorOctaves depthNoise;
	public NoiseGeneratorOctaves forestNoise;
	private double[] terrainCalcs;
	private float[] biomeWeights;
	double[] mainNoiseRegion;
	double[] minLimitRegion;
	double[] maxLimitRegion;
	double[] depthRegion;

	protected Block waterBlock;

	private List<MapGenBaseMeta> worldGenerators;

	public ChunkProviderCustomSpace(World world, long seed, boolean flag) {
		super(world, seed, flag);
		this.depthBuffer = new double[256];
		this.worldObj = world;
		this.rand = new Random(seed);
		this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
		this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
		this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
		this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
		this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
		this.forestNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.terrainCalcs = new double[825];
		this.biomeWeights = new float[25];

		for (int j = -2; j <= 2; j++) {
			for (int k = -2; k <= 2; k++) {
				float f = 10.0F / MathHelper.sqrt_float(j * j + k * k + 0.2F);
				this.biomeWeights[j + 2 + (k + 2) * 5] = f;
			}
		}
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) {
		this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
		Block[] blockStorage = new Block[65536];
		byte[] metaStorage = new byte[65536];
		this.func_147424_a(chunkX, chunkZ, blockStorage);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBlocksForBiome(chunkX, chunkZ, blockStorage, metaStorage, this.biomesForGeneration);

		if (this.worldGenerators == null) {
			this.worldGenerators = this.getWorldGenerators();
		}

		for (MapGenBaseMeta generator : this.worldGenerators) {
			generator.generate(this, this.worldObj, chunkX, chunkZ, blockStorage, metaStorage);
		}

		this.onChunkProvide(chunkX, chunkZ, blockStorage, metaStorage);

		Chunk chunk = new Chunk(this.worldObj, blockStorage, metaStorage, chunkX, chunkZ);
		byte[] abyte = chunk.getBiomeArray();
		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) this.biomesForGeneration[i].biomeID;
		}
		chunk.generateSkylightMap();
		return chunk;
	}

	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	@Override
	public void replaceBlocksForBiome(int chunkX, int chunkZ, Block[] blockStorage, byte[] metaStorage, BiomeGenBase[] biomes) {
		double d0 = 0.03125D;
		this.depthBuffer = this.surfaceNoise.func_151599_a(this.depthBuffer, chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				BiomeGenBase biomegenbase = biomes[x + z * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, blockStorage, metaStorage, chunkX * 16 + z, chunkZ * 16 + x, this.depthBuffer[x + z * 16]);
			}
		}
	}

	@Override
	public Chunk loadChunk(int x, int z) {
		return provideChunk(x, z);
	}

	@Override
	public void populate(IChunkProvider chunkProvider, int chunkX, int chunkZ) {
		BlockFalling.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		this.worldObj.getBiomeGenForCoords(x + 16, z + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
		this.decoratePlanet(this.worldObj, this.rand, x, z);
		this.onPopulate(x, z);
		BlockFalling.fallInstantly = false;
	}

	@Override
	public abstract void recreateStructures(int x, int z);

	protected abstract void decoratePlanet(World world, Random rand, int x, int z);

	protected abstract List<MapGenBaseMeta> getWorldGenerators();

	protected abstract void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata);

	protected abstract int getCraterProbability();

	public abstract void onPopulate(int cX, int cZ);
}