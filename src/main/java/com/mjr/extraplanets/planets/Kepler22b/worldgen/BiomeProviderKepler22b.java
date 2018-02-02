package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.GenLayerKepler22b;

public class BiomeProviderKepler22b extends BiomeProvider {
	private GenLayer unzoomedBiomes;
	private GenLayer zoomedBiomes;
	private BiomeCache biomeCache;
	private List<Biome> biomesToSpawn;
	private CelestialBody body;

	protected BiomeProviderKepler22b() {
		body = ExtraPlanets_Planets.KEPLER22B;
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawn = new ArrayList<Biome>();
		this.biomesToSpawn.add(Kepler22bBiomes.kepler22bPlains);
		this.biomesToSpawn.add(Kepler22bBiomes.kepler22bBlueForest);
		this.biomesToSpawn.add(Kepler22bBiomes.kepler22bPurpleForest);
		this.biomesToSpawn.add(Kepler22bBiomes.kepler22bRedForest);
		this.biomesToSpawn.add(Kepler22bBiomes.kepler22bYellowForest);
		this.biomesToSpawn.add(Kepler22bBiomes.kepler22bRedDesert);
	}

	public BiomeProviderKepler22b(long seed) {
		this();
		GenLayer[] agenlayer;
		agenlayer = GenLayerKepler22b.makeTheWorld(seed);
		this.unzoomedBiomes = agenlayer[0];
		this.zoomedBiomes = agenlayer[1];
	}

	public BiomeProviderKepler22b(World world) {
		this(world.getSeed());
	}

	public Biome getBiome() {
		return Kepler22bBiomes.kepler22bPlains;
	}

	@Override
	public List<Biome> getBiomesToSpawnIn() {
		return this.biomesToSpawn;
	}

	@Override
	public Biome getBiome(BlockPos pos, Biome defaultBiome) {
		BiomeAdaptive.setBodyMultiBiome(body);
		return this.biomeCache.getBiome(pos.getX(), pos.getZ(), BiomeAdaptive.biomeDefault);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float par1, int par2) {
		return par1;
	}

	@Override
	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int length, int width) {
		IntCache.resetIntCache();
		BiomeAdaptive.setBodyMultiBiome(body);

		if (biomes == null || biomes.length < length * width) {
			biomes = new Biome[length * width];
		}

		int[] intArray = unzoomedBiomes.getInts(x, z, length, width);

		for (int i = 0; i < length * width; ++i) {
			if (intArray[i] >= 0) {
				biomes[i] = Biome.getBiome(intArray[i]);
			} else {
				biomes[i] = BiomeAdaptive.biomeDefault;
			}
		}

		return biomes;
	}

	@Override
	public Biome[] getBiomes(@Nullable Biome[] oldBiomeList, int x, int z, int width, int depth) {
		return getBiomes(oldBiomeList, x, z, width, depth, true);
	}

	@Override
	public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag) {
		IntCache.resetIntCache();

		if (listToReuse == null || listToReuse.length < length * width) {
			listToReuse = new Biome[width * length];
		}

		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0) {
			Biome[] cached = this.biomeCache.getCachedBiomes(x, z);
			System.arraycopy(cached, 0, listToReuse, 0, width * length);
			return listToReuse;
		}

		int[] zoomed = zoomedBiomes.getInts(x, z, width, length);

		for (int i = 0; i < width * length; ++i) {
			if (zoomed[i] >= 0) {
				listToReuse[i] = Biome.getBiome(zoomed[i]);
			} else {
				listToReuse[i] = this.getBiome();
			}
		}

		return listToReuse;
	}

	@Override
	public boolean areBiomesViable(int par1, int par2, int par3, List<Biome> par4List) {
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
	public BlockPos findBiomePosition(int par1, int par2, int par3, List<Biome> par4List, Random par5Random) {
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
