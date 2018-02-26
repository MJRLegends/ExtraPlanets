package com.mjr.extraplanets.moons.Callisto.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.biomes.BiomeGenCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.biomes.BiomeGenCallistoSaltSea;
import com.mjr.extraplanets.moons.Callisto.worldgen.biomes.BiomeGenCallistoShaleMountains;

public class CallistoBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase callisto = new BiomeGenCallisto(Config.CALLISTO_BIOME_ID).setBiomeName("Callisto").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase callistoShaleLargeMountains = new BiomeGenCallistoShaleMountains(Config.CALLISTO_LARGE_SHALE_MOUNTAINS_BIOME_ID).setBiomeName("Callisto Shale Small Mountains").setHeight(new Height(1.0F, 1.5F));
	public static final BiomeGenBase callistoShaleSmallMountains = new BiomeGenCallistoShaleMountains(Config.CALLISTO_SMALL_SHALE_MOUNTAINS_BIOME_ID).setBiomeName("Callisto Shale Large Mountains").setHeight(new Height(3.0F, 3.0F));
	public static final BiomeGenBase callistoSaltSea = new BiomeGenCallistoSaltSea(Config.CALLISTO_SALT_SEA_BIOME_ID).setBiomeName("Callisto Salt Sea").setHeight(new Height(-1.0F, 0.0F));

	protected CallistoBiomes(int var1) {
		super(var1);
		this.rainfall = 0F;
	}

	@Override
	public BiomeDecoratorCallistoOther createBiomeDecorator() {
		return new BiomeDecoratorCallistoOther();
	}

	protected BiomeDecoratorCallistoOther getBiomeDecorator() {
		return (BiomeDecoratorCallistoOther) this.theBiomeDecorator;
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
				chunk.setBlockState(i1, j1, l, Blocks.bedrock.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunk.getBlockState(i1, j1, l);
				if (iblockstate2.getBlock().getMaterial() == Material.air) {
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
							iblockstate1 = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE);
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
