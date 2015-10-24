package com.mjr.extraplanets.planets.Neptune.worldgen.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.BiomeDecoratorNeptuneNew;

public class BiomeGenBaseNeptune extends BiomeGenBase {
	public static BiomeGenBase neptune = new BiomeGenNeptune().setBiomeName("Neptune").setEnableSnow().setTemperatureRainfall(0.8F, 0.9F).setHeight(new Height(0.1F, 0.2F));
	public static BiomeGenBase test = new BiomeGenTest().setBiomeName("Test").setEnableSnow().setTemperatureRainfall(0.8F, 0.9F).setHeight(new Height(0.1F, 0.2F));

	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;

	public BiomeGenBaseNeptune(int id) {
		super(id);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.rainfall = 0F;
		this.setColor(-16744448);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = ExtraPlanetsBlocks.neptuneSurface;
		this.fillerBlock = ExtraPlanetsBlocks.neptuneSubSurface;

		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));

		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorNeptuneNew();
	}

	protected BiomeDecorator getBiomeDecorator() {
		return (BiomeDecoratorNeptuneNew) this.theBiomeDecorator;
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] meta, int x, int z, double stoneNoise) {
		this.generateBiomeTerrain(world, rand, block, meta, x, z, stoneNoise);
	}

	@Override
	public boolean canSpawnLightningBolt() {
		return this.func_150559_j() ? false : this.enableRain;
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
								fillerBlock = ExtraPlanetsBlocks.neptuneStone;
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
								fillerBlock = ExtraPlanetsBlocks.neptuneStone;
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
		return (BiomeGenBase) super.setColor(var1);
	}

	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
}