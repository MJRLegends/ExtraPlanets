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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicKepler22b;
import com.mjr.extraplanets.world.biome.BiomeGenBase;

public class BiomeGenBaseKepler22b extends BiomeGenBase {
	public static final Biome kepler22bPlains = new BiomeGenKepler22bPlains(new BiomeProperties("Kepler22b Plains").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome kepler22bBlueForest = new BiomeGenKepler22bBlueMapleForest(new BiomeProperties("Kepler22b Blue Maple Forest").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome kepler22bPurpleForest = new BiomeGenKepler22bPurpleMapleForest(new BiomeProperties("Kepler22b Purple Maple Forest").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome kepler22bRedForest = new BiomeGenKepler22bRedMapleForest(new BiomeProperties("Kepler22b Red Maple Forest").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome kepler22bYellowForest = new BiomeGenKepler22bYellowMapleForest(new BiomeProperties("Kepler22b Yellow Maple Forest").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome kepler22bRedDesert = new BiomeGenKepler22bRedDesert(new BiomeProperties("Kepler22b Red Desert").setBaseHeight(0.125F).setHeightVariation(0.1F).setRainfall(0.0F).setRainDisabled());
	public static final Biome kepler22bWasteLands = new BiomeGenKepler22bWasteLands(new BiomeProperties("Kepler22b WasteLands").setBaseHeight(-0.2F).setHeightVariation(0.1F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518));
	public static final Biome kepler22bCandyLand = new BiomeGenKepler22bCandyLand(new BiomeProperties("Kepler22b Candy Land").setBaseHeight(0.225F).setHeightVariation(0.02F).setRainfall(0.9F).setSnowEnabled());

	protected byte topMeta;
	protected byte fillerMeta;

	public BiomeGenBaseKepler22b(BiomeProperties properties) {
		super(properties);
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
		this.setRegistryName(Constants.TEXTURE_PREFIX + this.getBiomeName());
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorKepler22b();
	}

	protected BiomeDecoratorKepler22b getBiomeDecorator() {
		return (BiomeDecoratorKepler22b) this.decorator;
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
				chunk.setBlockState(i1, j1, l, Blocks.BEDROCK.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunk.getBlockState(i1, j1, l);
				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState().withProperty(BlockBasicKepler22b.BASIC_TYPE, BlockBasicKepler22b.EnumBlockBasic.STONE).getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState().withProperty(BlockBasicKepler22b.BASIC_TYPE, BlockBasicKepler22b.EnumBlockBasic.STONE);
						} else if (j1 >= 63 - 4 && j1 <= 63 + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
						}

						if (j1 < 63 && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
							if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
								iblockstate = Blocks.ICE.getDefaultState();
							} else {
								iblockstate = Blocks.WATER.getDefaultState();
							}
						}

						j = k;

						if (j1 >= 63 - 1) {
							chunk.setBlockState(i1, j1, l, iblockstate);
						} else if (j1 < 63 - 7 - k) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState().withProperty(BlockBasicKepler22b.BASIC_TYPE, BlockBasicKepler22b.EnumBlockBasic.STONE);
							chunk.setBlockState(i1, j1, l, Blocks.GRAVEL.getDefaultState());
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