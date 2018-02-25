package com.mjr.extraplanets.moons.Titan.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.moons.Titan.worldgen.biomes.GenLayerTitan;

public class WorldChunkManagerTitan extends WorldChunkManager {
	private GenLayer unzoomedBiomes;
	private GenLayer zoomedBiomes;
	private BiomeCache biomeCache;
	private List<BiomeGenBase> biomesToSpawnIn;

	protected WorldChunkManagerTitan() {
		biomeCache = new BiomeCache(this);
		biomesToSpawnIn = new ArrayList<>();
	}

	public WorldChunkManagerTitan(long seed, WorldType type) {
		this();
		GenLayer[] genLayers = GenLayerTitan.createWorld(seed);
		this.unzoomedBiomes = genLayers[0];
		this.zoomedBiomes = genLayers[1];
	}

	public WorldChunkManagerTitan(World world) {
		this(world.getSeed(), world.getWorldInfo().getTerrainType());
	}

	@Override
	public List<BiomeGenBase> getBiomesToSpawnIn() {
		return this.biomesToSpawnIn;
	}

	@Override
	public float[] getRainfall(float[] par1, int x, int z, int width, int depth) {
		IntCache.resetIntCache();
		int[] aint = this.zoomedBiomes.getInts(x, z, width, depth);

		if (par1 == null || par1.length < width * depth) {
			par1 = new float[width * depth];
		}
		for (int i1 = 0; i1 < width * depth; ++i1) {
			float f = BiomeGenBase.getBiome(aint[i1]).getIntRainfall() / 65536.0F;

			if (f > 1.0F) {
				f = 1.0F;
			}
			par1[i1] = f;
		}
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float par1, int par2) {
		return par1;
	}

	@Override
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int x, int z, int length, int width) {
		IntCache.resetIntCache();

		if (biomes == null || biomes.length < length * width) {
			biomes = new BiomeGenBase[length * width];
		}

		int[] intArray = unzoomedBiomes.getInts(x, z, length, width);

		for (int i = 0; i < length * width; ++i) {
			if (intArray[i] >= 0) {
				biomes[i] = BiomeGenBase.getBiome(intArray[i]);
			} else {
				biomes[i] = TitanBiomes.titan;
			}
		}

		return biomes;
	}

	@Override
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] oldBiomeList, int x, int z, int length, int width) {
		return getBiomeGenAt(oldBiomeList, x, z, length, width, true);
	}

	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse, int x, int z, int length, int width, boolean cacheFlag) {
		IntCache.resetIntCache();

		if (listToReuse == null || listToReuse.length < length * width) {
			listToReuse = new BiomeGenBase[width * length];
		}

		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0) {
			BiomeGenBase[] cached = this.biomeCache.getCachedBiomes(x, z);
			System.arraycopy(cached, 0, listToReuse, 0, width * length);
			return listToReuse;
		}

		int[] zoomed = zoomedBiomes.getInts(x, z, width, length);

		for (int i = 0; i < width * length; ++i) {
			if (zoomed[i] >= 0) {
				listToReuse[i] = BiomeGenBase.getBiome(zoomed[i]);
			} else {
				listToReuse[i] = TitanBiomes.titan;
			}
		}

		return listToReuse;
	}

	@Override
	public boolean areBiomesViable(int x, int z, int range, List<BiomeGenBase> viables) {
		int i = x - range >> 2;
		int j = z - range >> 2;
		int k = x + range >> 2;
		int l = z + range >> 2;
		int diffX = (k - i) + 1;
		int diffZ = (l - j) + 1;
		int[] unzoomed = this.unzoomedBiomes.getInts(i, j, diffX, diffZ);

		for (int a = 0; a < diffX * diffZ; ++a) {
			BiomeGenBase biome = BiomeGenBase.getBiome(unzoomed[a]);

			if (!viables.contains(biome)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<BiomeGenBase> biomes, Random rand) {
		int i = x - range >> 2;
		int j = z - range >> 2;
		int k = x + range >> 2;
		int l = z + range >> 2;
		int diffX = (k - i) + 1;
		int diffZ = (l - j) + 1;
		int[] unzoomed = this.unzoomedBiomes.getInts(i, j, diffX, diffZ);
		BlockPos blockPos = null;
		int count = 0;

		for (int a = 0; a < unzoomed.length; ++a) {
			int x0 = i + a % diffX << 2;
			int z0 = j + a / diffX << 2;
			BiomeGenBase biome = BiomeGenBase.getBiome(unzoomed[a]);

			if (biomes.contains(biome) && (blockPos == null || rand.nextInt(count + 1) == 0)) {
				blockPos = new BlockPos(x0, 0, z0);
				count++;
			}
		}

		return blockPos;
	}

	@Override
	public void cleanupCache() {
		this.biomeCache.cleanupCache();
	}
}
