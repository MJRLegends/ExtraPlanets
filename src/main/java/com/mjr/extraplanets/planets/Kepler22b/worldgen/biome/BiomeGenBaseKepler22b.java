package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenBaseKepler22b extends BiomeGenBase {
	public static final BiomeGenBase kepler22bPlains = new BiomeGenKepler22bPlains(Config.KEPLER22B_PLAINS_BIOME_ID).setBiomeName("Kepler22b Plains").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bBlueForest = new BiomeGenKepler22bBlueMapleForest(Config.KEPLER22B_BLUE_FOREST_BIOME_ID).setBiomeName("Kepler22b Blue Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bPurpleForest = new BiomeGenKepler22bPurpleMapleForest(Config.KEPLER22B_PURPLE_FOREST_BIOME_ID).setBiomeName("Kepler22b Purple Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bRedForest = new BiomeGenKepler22bRedMapleForest(Config.KEPLER22B_RED_FOREST_BIOME_ID).setBiomeName("Kepler22b Red Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bYellowForest = new BiomeGenKepler22bYellowMapleForest(Config.KEPLER22B_YELLOW_FOREST_BIOME_ID).setBiomeName("Kepler22b Yellow Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bRedDesert = new BiomeGenKepler22bRedDesert(Config.KEPLER22B_RED_DESERT_BIOME_ID).setBiomeName("Kepler22b Red Desert").setHeight(new Height(0.125F, 0.1F));

	protected byte topMeta;
	protected byte fillerMeta;

	public BiomeGenBaseKepler22b(int var1) {
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_GREEN.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();
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
		return new BiomeDecoratorKepler22b();
	}

	protected BiomeDecoratorKepler22b getBiomeDecorator() {
		return (BiomeDecoratorKepler22b) this.theBiomeDecorator;
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		generateKelper22bBiomeTerrain(rand, chunk, x, z, stoneNoise);
	}

	public final void generateKelper22bBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		IBlockState iblockstate = this.topBlock;
		IBlockState iblockstate1 = this.fillerBlock;
		int j = -1;
		int k = (int) (stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int l = x & 15;
		int i1 = z & 15;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 <= rand.nextInt(5)) {
				chunk.setBlockState(i1, j1, l, Blocks.bedrock.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunk.getBlockState(i1, j1, l);
				if (iblockstate2.getBlock().getMaterial() == Material.air) {
					j = -1;
				} else if (iblockstate2.getBlock() == ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1).getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1);
						} else if (j1 >= 63 - 4 && j1 <= 63 + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
						}

						if (j1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air)) {
							if (this.getFloatTemperature(blockpos$mutableblockpos.set(x, j1, z)) < 0.15F) {
								iblockstate = Blocks.ice.getDefaultState();
							} else {
								iblockstate = Blocks.water.getDefaultState();
							}
						}

						j = k;

						if (j1 >= 63 - 1) {
							chunk.setBlockState(i1, j1, l, iblockstate);
						} else if (j1 < 63 - 7 - k) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1);
							chunk.setBlockState(i1, j1, l, Blocks.gravel.getDefaultState());
						} else {
							chunk.setBlockState(i1, j1, l, iblockstate1);
						}
					} else if (j > 0) {
						--j;
						chunk.setBlockState(i1, j1, l, iblockstate1);
					}
				}
			}
		}
	}
}