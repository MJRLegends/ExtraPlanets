package com.mjr.extraplanets.world.prefabs;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderOverworld;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public abstract class ChunkProviderCustomSpace extends ChunkProviderOverworld {
	protected Random rand;
	protected World worldObj;
	private double[] depthBuffer;
	private Biome[] biomesForGeneration;
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

	private final Gradient craterGen;
	private final int CRATER_PROB = this.getCraterProbability();

	protected IBlockState stoneBlock;
	protected IBlockState waterBlock;

	private static final int CHUNK_SIZE_X = 16;
	private static final int CHUNK_SIZE_Z = 16;

	protected int seaLevel = 63;
	protected boolean seaIceLayer = false;

	private List<MapGenBaseMeta> worldGenerators;

	public ChunkProviderCustomSpace(World world, long seed, boolean flag) {
		super(world, seed, flag, "");
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
		this.craterGen = new Gradient(this.rand.nextLong(), 1, 0.25F);

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
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(chunkX, chunkZ, chunkprimer);
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBlocksForBiome(chunkX, chunkZ, chunkprimer, this.biomesForGeneration);

		if (this.worldGenerators == null) {
			this.worldGenerators = this.getWorldGenerators();
		}

		for (MapGenBaseMeta generator : this.worldGenerators) {
			generator.generate(this.worldObj, chunkX, chunkZ, chunkprimer);
		}

		this.onChunkProvide(chunkX, chunkZ, chunkprimer);
		// this.createCraters(chunkX, chunkX, chunkprimer);

		Chunk chunk = new Chunk(this.worldObj, chunkprimer, chunkX, chunkZ);
		byte[] abyte = chunk.getBiomeArray();
		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}
		chunk.generateSkylightMap();
		return chunk;
	}

	public void createCraters(int chunkX, int chunkZ, ChunkPrimer primer) {
		this.craterGen.setFrequency(0.015F);
		for (int cx = chunkX - 2; cx <= chunkX + 2; cx++) {
			for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++) {
				for (int x = 0; x < ChunkProviderCustomSpace.CHUNK_SIZE_X; x++) {
					for (int z = 0; z < ChunkProviderCustomSpace.CHUNK_SIZE_Z; z++) {
						if (Math.abs(this.randFromPoint(cx * 16 + x, (cz * 16 + z) * 1000)) < this.craterGen.getNoise(cx * 16 + x, cz * 16 + z) / this.CRATER_PROB) {
							final Random random = new Random(cx * 16 + x + (cz * 16 + z) * 5000);
							final EnumCraterSize cSize = EnumCraterSize.sizeArray[random.nextInt(EnumCraterSize.sizeArray.length)];
							final int size = random.nextInt(cSize.MAX_SIZE - cSize.MIN_SIZE) + cSize.MIN_SIZE + 15;
							this.makeCrater(cx * 16 + x, cz * 16 + z, chunkX * 16, chunkZ * 16, size, primer);
						}
					}
				}
			}
		}
	}

	public void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ, int size, ChunkPrimer primer) {
		for (int x = 0; x < ChunkProviderCustomSpace.CHUNK_SIZE_X; x++) {
			for (int z = 0; z < ChunkProviderCustomSpace.CHUNK_SIZE_Z; z++) {
				double xDev = craterX - (chunkX + x);
				double zDev = craterZ - (chunkZ + z);
				if (xDev * xDev + zDev * zDev < size * size) {
					xDev /= size;
					zDev /= size;
					final double sqrtY = xDev * xDev + zDev * zDev;
					double yDev = sqrtY * sqrtY * 6;
					yDev = 5 - yDev;
					int helper = 0;
					for (int y = 127; y > 0; y--) {
						if (Blocks.AIR != primer.getBlockState(x, y, z).getBlock() && helper <= yDev) {
							primer.setBlockState(x, y, z, Blocks.AIR.getDefaultState());
							helper++;
						}

						if (helper > yDev) {
							break;
						}
					}
				}
			}
		}
	}

	private double randFromPoint(int x, int z) {
		int n;
		n = x + z * 57;
		n = n << 13 ^ n;
		return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
	}

	@Override
	public void setBlocksInChunk(int p_180518_1_, int p_180518_2_, ChunkPrimer p_180518_3_) {
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, p_180518_1_ * 4 - 2, p_180518_2_ * 4 - 2, 10, 10);
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
									p_180518_3_.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, this.stoneBlock);
								} else if (i2 * 8 + j2 == (this.seaLevel - 1) && this.seaIceLayer) {
									p_180518_3_.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.ICE.getDefaultState());
								} else if (i2 * 8 + j2 < (this.seaLevel - 1)) {
									p_180518_3_.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, this.waterBlock);
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
		this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, chunkX, chunkZ, 5, 5, 200.0F, 200.0F, 0.5F);
		float f = 684.412F;
		float f1 = 684.412F;
		this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, chunkX, chunkY, chunkZ, 5, 33, 5, f / 80.0F, f1 / 160.0F, f / 80.0F);
		this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, chunkX, chunkY, chunkZ, 5, 33, 5, f, f1, f);
		this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, chunkX, chunkY, chunkZ, 5, 33, 5, f, f1, f);
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
				Biome biomegenbase = this.biomesForGeneration[k + 2 + (l + 2) * 10];

				for (int j1 = -i1; j1 <= i1; ++j1) {
					for (int k1 = -i1; k1 <= i1; ++k1) {
						Biome biomegenbase1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
						float f5 = 0.0F + biomegenbase1.getBaseHeight() * 1.0F;
						float f6 = 0.0F + biomegenbase1.getHeightVariation() * 1.0F;
						float f7 = this.biomeWeights[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);

						if (biomegenbase1.getBaseHeight() > biomegenbase.getBaseHeight()) {
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
				double d7 = this.depthRegion[j] / 8000.0D;

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
				double d8 = f3;
				double d9 = f2;
				d8 = d8 + d7 * 0.2D;
				d8 = d8 * 8.5F / 8.0D;
				double d0 = 8.5F + d8 * 4.0D;

				for (int l1 = 0; l1 < 33; ++l1) {
					double d1 = (l1 - d0) * 12.0F * 128.0D / 256.0D / d9;

					if (d1 < 0.0D) {
						d1 *= 4.0D;
					}

					double d2 = this.minLimitRegion[i] / 512.0F;
					double d3 = this.maxLimitRegion[i] / 512.0F;
					double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
					double d5 = MathHelper.denormalizeClamp(d2, d3, d4) - d1;

					if (l1 > 29) {
						double d6 = (l1 - 29) / 3.0F;
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
	public void replaceBlocksForBiome(int chunkX, int chunkZ, ChunkPrimer chunk, Biome[] biomeGen) {
		double d0 = 0.03125D;
		this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				Biome biomegenbase = biomeGen[x + z * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, chunk, chunkX * 16 + z, chunkZ * 16 + x, this.depthBuffer[x + z * 16]);
			}
		}
	}

	public Chunk loadChunk(int x, int z) {
		return provideChunk(x, z);
	}

	@Override
	public void populate(int x, int z) {
		BlockFalling.fallInstantly = true;
		int var4 = x * 16;
		int var5 = z * 16;
		this.worldObj.getBiome(new BlockPos(var4 + 16, 0, var5 + 16));
		this.rand.setSeed(this.worldObj.getSeed());
		final long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		final long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(x * var7 + z * var9 ^ this.worldObj.getSeed());
		this.decoratePlanet(this.worldObj, this.rand, var4, var5);
		this.onPopulate(x, z);

		BlockFalling.fallInstantly = false;
	}
    
    @Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}
	
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        Biome biomegenbase = this.worldObj.getBiome(pos);
        return biomegenbase.getSpawnableList(creatureType);
    }
	
	@Override
	public abstract void recreateStructures(Chunk chunk, int x, int z);

	protected abstract void decoratePlanet(World world, Random rand, int x, int z);

	protected abstract List<MapGenBaseMeta> getWorldGenerators();

	protected abstract void onChunkProvide(int cX, int cZ, ChunkPrimer primer);

	protected abstract int getCraterProbability();

	public abstract void onPopulate(int cX, int cZ);
}
