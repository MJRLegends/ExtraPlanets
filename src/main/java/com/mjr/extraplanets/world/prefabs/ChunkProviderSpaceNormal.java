package com.mjr.extraplanets.world.prefabs;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public abstract class ChunkProviderSpaceNormal extends ChunkProviderGenerate {
	private Random rand;
	private NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves field_73214_a;
	public NoiseGeneratorOctaves field_73212_b;
	public NoiseGeneratorOctaves field_73213_c;
	protected World worldObj;
	private double[] stoneNoise;
	private BiomeGenBase[] biomesForGeneration;
	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;
	float[] squareTable;
	private NoiseGeneratorOctaves field_147431_j;
	private NoiseGeneratorOctaves field_147432_k;
	private NoiseGeneratorOctaves field_147429_l;
	private NoiseGeneratorPerlin field_147430_m;
	private double[] terrainCalcs;
	private float[] parabolicField;
	double[] field_147427_d;
	double[] field_147428_e;
	double[] field_147425_f;
	double[] field_147426_g;
	int[][] field_73219_j = new int[32][32];

	private List<MapGenBaseMeta> worldGenerators;

	private final Gradient noiseGen;

	public ChunkProviderSpaceNormal(World world, long seed, boolean flag) {
		super(world, seed, flag);
		this.stoneNoise = new double[256];
		this.worldObj = world;
		this.rand = new Random(seed);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
		this.terrainCalcs = new double[825];
		this.parabolicField = new float[25];

		for (int j = -2; j <= 2; j++) {
			for (int k = -2; k <= 2; k++) {
				float f = 10.0F / MathHelper.sqrt_float(j * j + k * k + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
		noiseGen = new Gradient(this.rand.nextLong(), 1, 0.25F);
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		Block[] blockStorage = new Block[65536];
		byte[] metaStorage = new byte[65536];
		generateTerrain(x, z, blockStorage);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		replaceBlocksForBiome(x, z, blockStorage, metaStorage, this.biomesForGeneration);
		Chunk chunk = new Chunk(this.worldObj, blockStorage, metaStorage, x, z);
		byte[] chunkBiomes = chunk.getBiomeArray();
		for (int i = 0; i < chunkBiomes.length; i++) {
			chunkBiomes[i] = ((byte) this.biomesForGeneration[i].biomeID);
		}
		if (this.worldGenerators == null) {
			this.worldGenerators = this.getWorldGenerators();
		}

		for (MapGenBaseMeta generator : this.worldGenerators) {
			generator.generate(this, this.worldObj, x, z, blockStorage, metaStorage);
		}
		this.onChunkProvide(x, z, blockStorage, metaStorage);

		chunk.generateSkylightMap();
		return chunk;
	}

	public void generateTerrain(int chunkX, int chunkZ, Block[] blockStorage) {
		byte seaLevel = 60;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		makeLandPerBiome2(chunkX * 4, 0, chunkZ * 4);
		for (int k = 0; k < 4; k++) {
			int l = k * 5;
			int i1 = (k + 1) * 5;
			for (int j1 = 0; j1 < 4; j1++) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;
				for (int k2 = 0; k2 < 32; k2++) {
					double d0 = 0.125D;
					double d1 = this.terrainCalcs[(k1 + k2)];
					double d2 = this.terrainCalcs[(l1 + k2)];
					double d3 = this.terrainCalcs[(i2 + k2)];
					double d4 = this.terrainCalcs[(j2 + k2)];
					double d5 = (this.terrainCalcs[(k1 + k2 + 1)] - d1) * d0;
					double d6 = (this.terrainCalcs[(l1 + k2 + 1)] - d2) * d0;
					double d7 = (this.terrainCalcs[(i2 + k2 + 1)] - d3) * d0;
					double d8 = (this.terrainCalcs[(j2 + k2 + 1)] - d4) * d0;
					for (int l2 = 0; l2 < 8; l2++) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for (int i3 = 0; i3 < 4; i3++) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;
							for (int k3 = 0; k3 < 4; k3++) {
								if ((d15 += d16) > 0.0D) {
									blockStorage[(j3 += short1)] = Blocks.stone;
								} else if (k2 * 8 + l2 < seaLevel) {
									blockStorage[(j3 += short1)] = Blocks.water;
								} else {
									blockStorage[(j3 += short1)] = null;
								}
							}
							d10 += d12;
							d11 += d13;
						}
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	private void makeLandPerBiome2(int x, int zero, int z) {
		this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, x, zero, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, x, zero, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, x, zero, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		int terrainIndex = 0;
		int noiseIndex = 0;
		for (int ax = 0; ax < 5; ax++) {
			for (int az = 0; az < 5; az++) {
				float totalVariation = 0.0F;
				float totalHeight = 0.0F;
				float totalFactor = 0.0F;
				byte two = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[(ax + 2 + (az + 2) * 10)];
				for (int ox = -two; ox <= two; ox++) {
					for (int oz = -two; oz <= two; oz++) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[(ax + ox + 2 + (az + oz + 2) * 10)];
						float rootHeight = biomegenbase1.rootHeight;
						float heightVariation = biomegenbase1.heightVariation;
						float heightFactor = this.parabolicField[(ox + 2 + (oz + 2) * 5)] / (rootHeight + 2.0F);
						if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {
							heightFactor /= 2.0F;
						}
						totalVariation += heightVariation * heightFactor;
						totalHeight += rootHeight * heightFactor;
						totalFactor += heightFactor;
					}
				}
				totalVariation /= totalFactor;
				totalHeight /= totalFactor;
				totalVariation = totalVariation * 0.9F + 0.1F;
				totalHeight = (totalHeight * 4.0F - 1.0F) / 8.0F;
				double terrainNoise = this.field_147426_g[noiseIndex] / 8000.0D;
				if (terrainNoise < 0.0D) {
					terrainNoise = -terrainNoise * 0.3D;
				}
				terrainNoise = terrainNoise * 3.0D - 2.0D;
				if (terrainNoise < 0.0D) {
					terrainNoise /= 2.0D;
					if (terrainNoise < -1.0D) {
						terrainNoise = -1.0D;
					}
					terrainNoise /= 1.4D;
					terrainNoise /= 2.0D;
				} else {
					if (terrainNoise > 1.0D) {
						terrainNoise = 1.0D;
					}
					terrainNoise /= 8.0D;
				}
				noiseIndex++;
				double heightCalc = totalHeight;
				double variationCalc = totalVariation;
				heightCalc += terrainNoise * 0.2D;
				heightCalc = heightCalc * 8.5D / 8.0D;
				double d5 = 8.5D + heightCalc * 4.0D;
				for (int ay = 0; ay < 33; ay++) {
					double d6 = (ay - d5) * 12.0D * 128.0D / 256.0D / variationCalc;
					if (d6 < 0.0D) {
						d6 *= 4.0D;
					}
					double d7 = this.field_147428_e[terrainIndex] / 512.0D;
					double d8 = this.field_147425_f[terrainIndex] / 512.0D;
					double d9 = (this.field_147427_d[terrainIndex] / 10.0D + 1.0D) / 2.0D;
					double terrainCalc = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
					if (ay > 29) {
						double d11 = (ay - 29) / 3.0F;
						terrainCalc = terrainCalc * (1.0D - d11) + -10.0D * d11;
					}
					this.terrainCalcs[terrainIndex] = terrainCalc;
					terrainIndex++;
				}
			}
		}
	}

	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	@Override
	public void replaceBlocksForBiome(int chunkX, int chunkZ, Block[] blockStorage, byte[] metaStorage, BiomeGenBase[] biomes) {
		double d0 = 0.03125D;
		this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				BiomeGenBase biomegenbase = biomes[x + z * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, blockStorage, metaStorage, chunkX * 16 + z, chunkZ * 16 + x, this.stoneNoise[x + z * 16]);
			}
		}
	}

	@Override
	public Chunk loadChunk(int x, int z) {
		return provideChunk(x, z);
	}

	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	@Override
	public void populate(IChunkProvider chunk, int x, int z) {
		net.minecraft.block.BlockFalling.fallInstantly = true;
		int var4 = x * 16;
		int var5 = z * 16;
		BiomeGenBase biomeGen = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(x * var7 + z * var9 ^ this.worldObj.getSeed());
		biomeGen.decorate(this.worldObj, this.rand, var4, var5);
		decoratePlanet(this.worldObj, this.rand, var4, var5);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomeGen, var4 + 8, var5 + 8, 16, 16, this.rand);
		net.minecraft.block.BlockFalling.fallInstantly = false;
	}

	public boolean func_73151_a(boolean flag, IProgressUpdate progress) {
		return true;
	}

	public boolean func_73157_c() {
		return true;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public void saveExtraData() {
	}

	@Override
	public ChunkPosition func_147416_a(World world, String string, int x, int y, int z) {
		return null;
	}

	@Override
	public abstract void recreateStructures(int par1, int par2);

	public abstract String func_73148_d();

	public abstract void decoratePlanet(World world, Random rand, int x, int z);

	protected abstract List<MapGenBaseMeta> getWorldGenerators();

	public abstract void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata);
}
