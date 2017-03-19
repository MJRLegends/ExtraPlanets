package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.layer.GenLayerKepler22b;

public class WorldChunkManagerKepler22b extends WorldChunkManagerSpace {
	private GenLayer unzoomedBiomes;
	private GenLayer zoomedBiomes;
	private BiomeCache biomeCache;
	private List<Biome> biomesToSpawn;

	protected WorldChunkManagerKepler22b() {
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawn = new ArrayList();
		this.biomesToSpawn.add(BiomeKepler22b.kepler22bPlains);
		this.biomesToSpawn.add(BiomeKepler22b.kepler22bBlueForest);
		this.biomesToSpawn.add(BiomeKepler22b.kepler22bPurpleForest);
		this.biomesToSpawn.add(BiomeKepler22b.kepler22bRedForest);
		this.biomesToSpawn.add(BiomeKepler22b.kepler22bYellowForest);
	}

	public WorldChunkManagerKepler22b(long seed) {
		this();
		GenLayer[] agenlayer;
		agenlayer = GenLayerKepler22b.makeTheWorld(seed);
		this.unzoomedBiomes = agenlayer[0];
		this.zoomedBiomes = agenlayer[1];
	}

	public WorldChunkManagerKepler22b(World world) {
		this(world.getSeed());
	}

	@Override
	public Biome getBiome() {
		return BiomeKepler22b.kepler22bPlains;
	}

	@Override
	public List getBiomesToSpawnIn() {
		return this.biomesToSpawn;
	}

	@Override
	public Biome func_180300_a(BlockPos pos, Biome biomeGen) {
		Biome biome = this.biomeCache.func_180284_a(pos.getX(), pos.getZ(), biomeGen);

		if (biome == null) {
			return BiomeKepler22b.kepler22bPlains;
		}
		return biome;
	}

	@Override
	public float[] getRainfall(float[] par1, int x, int z, int width, int depth) {
		IntCache.resetIntCache();
		int[] aint = this.zoomedBiomes.getInts(x, z, width, depth);

		if (par1 == null || par1.length < width * depth) {
			par1 = new float[width * depth];
		}
		for (int i1 = 0; i1 < width * depth; ++i1) {
			float f = Biome.getBiome(aint[i1]).getIntRainfall() / 65536.0F;

			if (f > 1.0F) {
				f = 1.0F;
			}
			par1[i1] = f;
		}
		return par1;
	}

	@Override
	public float getTemperatureAtHeight(float par1, int par2) {
		return par1;
	}

	@Override
	public Biome[] getBiomesForGeneration(Biome[] par1ArrayOfBiome, int x, int z, int length, int width) {
		int[] arrayOfInts = this.unzoomedBiomes.getInts(x, z, length, width);

		if (par1ArrayOfBiome == null || par1ArrayOfBiome.length < length * width) {
			par1ArrayOfBiome = new Biome[length * width];
		}
		for (int i = 0; i < length * width; i++) {
			if (arrayOfInts[i] >= 0) {
				par1ArrayOfBiome[i] = Biome.getBiome(arrayOfInts[i]);
			} else {
				par1ArrayOfBiome[i] = BiomeKepler22b.kepler22bPlains;
			}
		}
		return par1ArrayOfBiome;
	}

	@Override
	public Biome[] loadBlockGeneratorData(Biome[] par1ArrayOfBiome, int par2, int par3, int par4, int par5) {
		return this.getBiomeGenAt(par1ArrayOfBiome, par2, par3, par4, par5, true);
	}

	@Override
	public Biome[] getBiomeGenAt(Biome[] par1ArrayOfBiome, int x, int y, int width, int length, boolean cacheFlag) {
		int[] ai = this.zoomedBiomes.getInts(x, y, width, length);

		if (par1ArrayOfBiome == null || par1ArrayOfBiome.length < width * length) {
			par1ArrayOfBiome = new Biome[width * length];
		}
		if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0 && (y & 0xF) == 0) {
			Biome[] abiomegenbase = this.biomeCache.getCachedBiomes(x, y);
			System.arraycopy(abiomegenbase, 0, par1ArrayOfBiome, 0, width * length);
			return par1ArrayOfBiome;
		}
		for (int i = 0; i < width * length; i++) {
			if (ai[i] >= 0) {
				par1ArrayOfBiome[i] = Biome.getBiome(ai[i]);
			} else {
				par1ArrayOfBiome[i] = BiomeKepler22b.kepler22bPlains;
			}
		}
		return par1ArrayOfBiome;
	}

	@Override
	public boolean areBiomesViable(int par1, int par2, int par3, List par4List) {
		int i = par1 - par3 >> 2;
		int j = par2 - par3 >> 2;
		int k = par1 + par3 >> 2;
		int l = par2 + par3 >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		int[] ai = this.unzoomedBiomes.getInts(i, j, i1, j1);

		for (int k1 = 0; k1 < i1 * j1; k1++) {
			Biome biomegenbase = Biome.getBiome(ai[k1]);

			if (!par4List.contains(biomegenbase)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public BlockPos findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random) {
		int i = par1 - par3 >> 2;
		int j = par2 - par3 >> 2;
		int k = par1 + par3 >> 2;
		int l = par2 + par3 >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		int[] ai = this.unzoomedBiomes.getInts(i, j, i1, j1);
		BlockPos chunkposition = null;
		int k1 = 0;

		for (int l1 = 0; l1 < ai.length; l1++) {
			int i2 = i + l1 % i1 << 2;
			int j2 = j + l1 / i1 << 2;
			Biome biomegenbase = Biome.getBiome(ai[l1]);

			if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k1 + 1) == 0)) {
				chunkposition = new BlockPos(i2, 0, j2);
				k1++;
			}
		}
		return chunkposition;
	}

	@Override
	public void cleanupCache() {
		this.biomeCache.cleanupCache();
	}
}
