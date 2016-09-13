package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenBaseKepler22b extends BiomeGenBase {
	public static final BiomeGenBase kepler22bPlains = new BiomeGenKepler22bPlains().setColor(112).setBiomeName("Kepler22b Plains").setHeight(height_LowPlains);
	public static final BiomeGenBase kepler22bSea = new BiomeGenKepler22bSea().setColor(112).setBiomeName("Kepler22b Sea").setHeight(height_Oceans);
	public static final BiomeGenBase kepler22bBlueForest = new BiomeGenKepler22bBlueMapleForest().setColor(112).setBiomeName("Kepler22b Blue Maple Forest").setHeight(height_LowPlains);
	public static final BiomeGenBase kepler22bPurpleForest = new BiomeGenKepler22bPurpleMapleForest().setColor(112).setBiomeName("Kepler22b Purple Maple Forest").setHeight(height_LowPlains);
	public static final BiomeGenBase kepler22bRedForest = new BiomeGenKepler22bRedMapleForest().setColor(112).setBiomeName("Kepler22b Red Maple Forest").setHeight(height_LowPlains);
	public static final BiomeGenBase kepler22bYellowForest = new BiomeGenKepler22bYellowMapleForest().setColor(112).setBiomeName("Kepler22b Yellow Maple Forest").setHeight(height_LowPlains);

	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;

	public BiomeGenBaseKepler22b(int id) {
		super(id);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.rainfall = 0F;
		this.setColor(-16744448);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = ExtraPlanets_Blocks.kepler22bGrass;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.kepler22bBlocks;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanets_Blocks.kepler22bBlocks;
		this.stoneMeta = 1;
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorKepler22b();
	}

	protected BiomeDecorator getBiomeDecorator() {
		return this.theBiomeDecorator;
	}

	@Override
	public boolean canSpawnLightningBolt() {
		return this.func_150559_j() ? false : this.enableRain;
	}

	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] meta, int x, int z, double stoneNoise) {
		generateBiomeTerrain(world, rand, block, meta, x, z, stoneNoise);
	}

	public void generateBiomeTerrain(World world, Random rand, Block[] block, byte[] meta, int x, int z, double stoneNoise) {
		Block topBlock = this.topBlock;
		byte topMeta = this.topMeta;
		Block fillerBlock = this.fillerBlock;
		byte fillerMeta = this.fillerMeta;
		int currentFillerDepth = -1;
		int maxFillerDepth = (int) (stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int maskX = x & 15;
		int maskZ = z & 15;
		int worldHeight = block.length / 256;
		int seaLevel = 32;

		for (int y = 255; y >= 0; y--) {
			int index = (maskZ * 16 + maskX) * worldHeight + y;

			if (y <= 0 + rand.nextInt(5)) {
				block[index] = Blocks.bedrock;
			} else {
				Block currentBlock = block[index];

				if (currentBlock != null && currentBlock.getMaterial() != Material.air) {
					if (currentBlock == Blocks.stone) {
						if (this.stoneBlock != null) {
							block[index] = this.stoneBlock;
							meta[index] = this.stoneMeta;
						}
						if (currentFillerDepth == -1) {
							if (maxFillerDepth <= 0) {
								topBlock = null;
								topMeta = 0;
								fillerBlock = ExtraPlanets_Blocks.jupiterBlocks;
								fillerMeta = 0;
							} else if (y >= seaLevel - 5 && y <= seaLevel) {
								topBlock = this.topBlock;
								topMeta = this.topMeta;
								fillerBlock = this.fillerBlock;
								fillerMeta = 0;
							}
							if (y < seaLevel - 1 && (topBlock == null || topBlock.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(x, y, z) < 0.15F) {
									topBlock = Blocks.ice;
									topMeta = 0;
								} else {
									topBlock = Blocks.water;
									topMeta = 0;
								}
							}

							currentFillerDepth = maxFillerDepth;

							if (y >= seaLevel - 2) {
								block[index] = topBlock;
								meta[index] = topMeta;
							} else if (y < seaLevel - 8 - maxFillerDepth) {
								topBlock = null;
								fillerBlock = ExtraPlanets_Blocks.jupiterBlocks;
								fillerMeta = 0;
								block[index] = Blocks.gravel;
							} else {
								block[index] = fillerBlock;
								meta[index] = fillerMeta;
							}
						} else if (currentFillerDepth > 0) {
							currentFillerDepth--;
							block[index] = fillerBlock;
							meta[index] = fillerMeta;

							if (currentFillerDepth == 0 && fillerBlock == Blocks.sand) {
								currentFillerDepth = rand.nextInt(4) + Math.max(0, y - (seaLevel - 1));
								fillerBlock = Blocks.sandstone;
								fillerMeta = 0;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public BiomeGenBase setColor(int var1) {
		return super.setColor(var1);
	}

	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
}