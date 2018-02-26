package com.mjr.extraplanets.moons.Callisto.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.biomes.BiomeGenCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.biomes.BiomeGenCallistoSaltSea;
import com.mjr.extraplanets.moons.Callisto.worldgen.biomes.BiomeGenCallistoShaleMountains;

public class CallistoBiomes extends BiomeGenBaseGC {

	public static final Biome callisto = new BiomeGenCallisto(new BiomeProperties("Callisto").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome callistoShaleLargeMountains = new BiomeGenCallistoShaleMountains(new BiomeProperties("Callisto Shale Small Mountains").setBaseHeight(1.0F).setHeightVariation(1.5F).setRainfall(0.0F).setRainDisabled());
	public static final Biome callistoShaleSmallMountains = new BiomeGenCallistoShaleMountains(new BiomeProperties("Callisto Shale Large Mountains").setBaseHeight(3.0F).setHeightVariation(3.0F).setRainfall(0.0F).setRainDisabled());
	public static final Biome callistoSaltSea = new BiomeGenCallistoSaltSea(new BiomeProperties("Callisto Salt Sea").setBaseHeight(-1.0F).setHeightVariation(0.0F).setRainfall(0.0F).setRainDisabled());

	protected CallistoBiomes(BiomeProperties properties) {
		super(properties, true);
	}

	@Override
	public BiomeDecoratorCallistoOther createBiomeDecorator() {
		return new BiomeDecoratorCallistoOther();
	}

	protected BiomeDecoratorCallistoOther getBiomeDecorator() {
		return (BiomeDecoratorCallistoOther) this.decorator;
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		generateCallistoBiomeTerrain(rand, chunk, x, z, stoneNoise);
	}

	public final void generateCallistoBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
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
				} else if (iblockstate2.getBlock() == ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE).getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE);
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
							iblockstate1 = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE);
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
