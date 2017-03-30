package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeDecoratorKepler22bOres;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenCaveKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenRavineKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.MapGenVillageKepler22b;

public class ChunkProviderKepler22b extends ChunkProviderGenerate {
	private Random rand;
	private World worldObj;
	private double[] stoneNoise;
	private final MapGenVillageKepler22b villageGenerator = new MapGenVillageKepler22b();
	private final MapGenCaveKepler22b caveGenerator = new MapGenCaveKepler22b();
	private final MapGenRavineKepler22b ravineGenerator = new MapGenRavineKepler22b();
	private final BiomeDecoratorKepler22bOres BiomeDecorator = new BiomeDecoratorKepler22bOres();
	private BiomeGenBase[] biomesForGeneration;
	private NoiseGeneratorOctaves noiseGen4;
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
	private final Gradient noiseGen;

	public ChunkProviderKepler22b(World world, long seed, boolean flag) {
		super(world, seed, flag, "");
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
	public Chunk provideChunk(int chunkX, int chunkZ) {
		this.rand.setSeed((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(chunkX, chunkZ, chunkprimer);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBlocksForBiome(chunkX, chunkZ, chunkprimer, this.biomesForGeneration);
		this.villageGenerator.generate(this, this.worldObj, chunkX, chunkZ, chunkprimer);
		this.caveGenerator.generate(this, this.worldObj, chunkX, chunkZ, chunkprimer);
		this.ravineGenerator.generate(this, this.worldObj, chunkX, chunkZ, chunkprimer);

		Chunk chunk = new Chunk(this.worldObj, chunkprimer, chunkX, chunkZ);
		byte[] abyte = chunk.getBiomeArray();
		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) this.biomesForGeneration[i].biomeID;
		}
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void setBlocksInChunk(int p_180518_1_, int p_180518_2_, ChunkPrimer p_180518_3_) {
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_180518_1_ * 4 - 2, p_180518_2_ * 4 - 2, 10, 10);
		this.generateHeightMap(p_180518_1_ * 4, 0, p_180518_2_ * 4);

		for (int i = 0; i < 4; ++i) {
			int j = i * 5;
			int k = (i + 1) * 5;

			for (int l = 0; l < 4; ++l) {
				int i1 = (j + l) * 33;
				int j1 = (j + l + 1) * 33;
				int k1 = (k + l) * 33;
				int l1 = (k + l + 1) * 33;

				for (int i2 = 0; i2 < 32; ++i2) {
					double d0 = 0.125D;
					double d1 = this.terrainCalcs[i1 + i2];
					double d2 = this.terrainCalcs[j1 + i2];
					double d3 = this.terrainCalcs[k1 + i2];
					double d4 = this.terrainCalcs[l1 + i2];
					double d5 = (this.terrainCalcs[i1 + i2 + 1] - d1) * d0;
					double d6 = (this.terrainCalcs[j1 + i2 + 1] - d2) * d0;
					double d7 = (this.terrainCalcs[k1 + i2 + 1] - d3) * d0;
					double d8 = (this.terrainCalcs[l1 + i2 + 1] - d4) * d0;

					for (int j2 = 0; j2 < 8; ++j2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int k2 = 0; k2 < 4; ++k2) {
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double lvt_45_1_ = d10 - d16;

							for (int l2 = 0; l2 < 4; ++l2) {
								if ((lvt_45_1_ += d16) > 0.0D) {
									p_180518_3_.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, ExtraPlanets_Blocks.kepler22bBlocks.getStateFromMeta(1));
								} else if (i2 * 8 + j2 < 63) {
									p_180518_3_.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.water.getDefaultState());
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

	private void generateHeightMap(int chunkX, int chunkY, int chunkZ) {
		this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, chunkX, chunkZ, 5, 5, 200.0F, 200.0F, 0.5F);
		float f = 684.412F;
		float f1 = 684.412F;
		this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, chunkX, chunkY, chunkZ, 5, 33, 5, f / 80.0F, f1 / 160.0F, f / 80.0F);
		this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, chunkX, chunkY, chunkZ, 5, 33, 5, (double) f, (double) f1, (double) f);
		this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, chunkX, chunkY, chunkZ, 5, 33, 5, (double) f, (double) f1, (double) f);
		chunkZ = 0;
		chunkX = 0;
		int i = 0;
		int j = 0;

		for (int k = 0; k < 5; ++k) {
			for (int l = 0; l < 5; ++l) {
				float f2 = 0.0F;
				float f3 = 0.0F;
				float f4 = 0.0F;
				int i1 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[k + 2 + (l + 2) * 10];

				for (int j1 = -i1; j1 <= i1; ++j1) {
					for (int k1 = -i1; k1 <= i1; ++k1) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
						float f5 = 0.0F + biomegenbase1.minHeight * 1.0F;
						float f6 = 0.0F + biomegenbase1.maxHeight * 1.0F;
						float f7 = this.parabolicField[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);

						if (biomegenbase1.minHeight > biomegenbase.minHeight) {
							f7 /= 2.0F;
						}

						f2 += f6 * f7;
						f3 += f5 * f7;
						f4 += f7;
					}
				}

				f2 = f2 / f4;
				f3 = f3 / f4;
				f2 = f2 * 0.9F + 0.1F;
				f3 = (f3 * 4.0F - 1.0F) / 8.0F;
				double d7 = this.field_147426_g[j] / 8000.0D;

				if (d7 < 0.0D) {
					d7 = -d7 * 0.3D;
				}

				d7 = d7 * 3.0D - 2.0D;

				if (d7 < 0.0D) {
					d7 = d7 / 2.0D;

					if (d7 < -1.0D) {
						d7 = -1.0D;
					}

					d7 = d7 / 1.4D;
					d7 = d7 / 2.0D;
				} else {
					if (d7 > 1.0D) {
						d7 = 1.0D;
					}

					d7 = d7 / 8.0D;
				}

				++j;
				double d8 = (double) f3;
				double d9 = (double) f2;
				d8 = d8 + d7 * 0.2D;
				d8 = d8 * 8.5F / 8.0D;
				double d0 = 8.5F + d8 * 4.0D;

				for (int l1 = 0; l1 < 33; ++l1) {
					double d1 = ((double) l1 - d0) * 12.0F * 128.0D / 256.0D / d9;

					if (d1 < 0.0D) {
						d1 *= 4.0D;
					}

					double d2 = this.field_147428_e[i] / 512.0F;
					double d3 = this.field_147425_f[i] / 512.0F;
					double d4 = (this.field_147427_d[i] / 10.0D + 1.0D) / 2.0D;
					double d5 = MathHelper.denormalizeClamp(d2, d3, d4) - d1;

					if (l1 > 29) {
						double d6 = (double) ((float) (l1 - 29) / 3.0F);
						d5 = d5 * (1.0D - d6) + -10.0D * d6;
					}

					this.terrainCalcs[i] = d5;
					++i;
				}
			}
		}
	}

	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	public void replaceBlocksForBiome(int chunkX, int chunkZ, ChunkPrimer chunk, BiomeGenBase[] biomeGen) {
		double d0 = 0.03125D;
		this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				BiomeGenBase biomegenbase = biomeGen[x + z * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, chunk, chunkX * 16 + z, chunkZ * 16 + x, this.stoneNoise[x + z * 16]);
			}
		}
	}

	public Chunk loadChunk(int x, int z) {
		return provideChunk(x, z);
	}

	@Override
	public void populate(IChunkProvider chunk, int chunkX, int chunkZ) {
		BlockFalling.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BlockPos pos = new BlockPos(x, 0, z);
		BiomeGenBase biomeGen = this.worldObj.getBiomeGenForCoords(pos.add(16, 0, 16));
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
		this.villageGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(x, z));
		biomeGen.decorate(this.worldObj, this.rand, pos);
		decoratePlanet(this.worldObj, this.rand, x, z);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomeGen, x + 8, z + 8, 16, 16, this.rand);
		BlockFalling.fallInstantly = false;
	}

	public void decoratePlanet(World world, Random rand, int x, int z) {
		this.BiomeDecorator.decorate(world, rand, x, z);
	}

	@Override
	public String makeString() {
		return "Kepler22bLevelSource";
	}

	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	@Override
	public Chunk provideChunk(BlockPos pos) {
		return this.provideChunk(pos.getX() >> 4, pos.getZ() >> 4);
	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate progressCallback) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void saveExtraData() {
	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		return false;
	}

	public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return this.worldObj.getBiomeGenForCoords(pos).getSpawnableList(creatureType);
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.villageGenerator.generate(this, this.worldObj, x, z, null);
	}
}
