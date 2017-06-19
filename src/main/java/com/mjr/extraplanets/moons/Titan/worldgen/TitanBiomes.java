package com.mjr.extraplanets.moons.Titan.worldgen;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitan;
import com.mjr.extraplanets.moons.Titan.worldgen.biomes.BiomeGenTitan;
import com.mjr.extraplanets.moons.Titan.worldgen.biomes.BiomeGenTitanMethaneSea;

public class TitanBiomes extends Biome {

	public static final Biome titan = new BiomeGenTitan(new BiomeProperties("titan").setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
	public static final Biome titanMethaneSea = new BiomeGenTitanMethaneSea(new BiomeProperties("titanMethaneSea").setBaseHeight(-1.0F).setHeightVariation(0.0F).setRainfall(0.0F).setRainDisabled());

	protected TitanBiomes(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorTitanOther();
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180622_4_, int p_180622_5_, double p_180622_6_) {
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public final void generateBiomeTerrainVenus(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180628_4_, int p_180628_5_, double p_180628_6_) {
		int i = worldIn.getSeaLevel();
		IBlockState topBlock = this.topBlock;
		IBlockState fillerBlock = this.fillerBlock;
		IBlockState stoneBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState().withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.STONE);
		int j = -1;
		int k = (int) (p_180628_6_ / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int l = p_180628_4_ & 15;
		int i1 = p_180628_5_ & 15;

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 <= rand.nextInt(5)) {
				chunkPrimerIn.setBlockState(i1, j1, l, Blocks.BEDROCK.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

				if (iblockstate2.getBlock().getMaterial(iblockstate2) == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == ExtraPlanets_Blocks.TITAN_BLOCKS) {
					if (j == -1) {
						if (k <= 0) {
							topBlock = null;
							fillerBlock = stoneBlock;
						} else if (j1 >= i - 4 && j1 <= i + 1) {
							topBlock = this.topBlock;
							fillerBlock = this.fillerBlock;
						}

						j = k;

						if (j1 >= i - 1) {
							chunkPrimerIn.setBlockState(i1, j1, l, topBlock);
						} else if (j1 < i - 7 - k) {
							topBlock = null;
							fillerBlock = stoneBlock;
						} else {
							chunkPrimerIn.setBlockState(i1, j1, l, fillerBlock);
						}
					} else if (j > 0) {
						--j;
						chunkPrimerIn.setBlockState(i1, j1, l, fillerBlock);
					}
				}
			}
		}
	}
}
