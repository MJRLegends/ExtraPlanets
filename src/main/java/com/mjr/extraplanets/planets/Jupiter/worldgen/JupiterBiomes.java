package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.biomes.BiomeGenJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.biomes.BiomeGenJupiterMagmaSea;

public class JupiterBiomes extends BiomeGenBase {
	public static BiomeGenBase jupiter = new BiomeGenJupiter(Config.jupiterBiomeID).setBiomeName("Jupiter").setHeight(BiomeGenBase.height_LowPlains);
	public static BiomeGenBase jupiterMagma = new BiomeGenJupiterMagmaSea(201).setBiomeName("JupiterMagma").setHeight(BiomeGenBase.height_Oceans);

	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;

	protected JupiterBiomes(int id) {
		super(id);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.rainfall = 0F;
		this.enableRain = false;
		this.enableSnow = false;

		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 10, 4, 4));
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorJupiter();
	}

	protected BiomeDecorator getBiomeDecorator() {
		return this.theBiomeDecorator;
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] meta, int x, int z, double stoneNoise) {
		this.generateBiomeTerrain(world, rand, block, meta, x, z, stoneNoise);
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
		int seaLevel = 63;

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
								fillerMeta = 1;
							} else if (y >= seaLevel - 5 && y <= seaLevel) {
								topBlock = this.topBlock;
								topMeta = this.topMeta;
								fillerBlock = this.fillerBlock;
								fillerMeta = 0;
							}
							if (y < seaLevel && (topBlock == null || topBlock.getMaterial() == Material.air)) {
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
								fillerMeta = 1;
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
}