package com.mjr.extraplanets.moons.Oberon.worldgen;

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
import com.mjr.extraplanets.moons.Oberon.worldgen.biomes.BiomeGenOberonLargeMountain;
import com.mjr.extraplanets.moons.Oberon.worldgen.biomes.BiomeGenOberonValleys;

public class OberonBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase oberon = new BiomeGenOberon(Config.OBERON_BIOME_ID).setBiomeName("Oberon").setHeight(new Height(2.5F, 0.4F));
	public static final BiomeGenBase oberonLargeIceMountain = new BiomeGenOberonLargeMountain(Config.OBERON_LARGE_MOUNTAIN_BIOME_ID).setBiomeName("Oberon Large Ice Mountain").setHeight(new Height(3.0F, 2.5F));
	public static final BiomeGenBase oberonValleys = new BiomeGenOberonValleys(Config.OBERON_VALLEYS_BIOME_ID).setBiomeName("Oberon Valleys").setHeight(new Height(-0.4F, 0.2F));

	protected OberonBiomes(int var1) {
		super(var1);
		this.rainfall = 0F;
	}

	@Override
	public BiomeDecoratorOberonOther createBiomeDecorator() {
		return new BiomeDecoratorOberonOther();
	}

	protected BiomeDecoratorOberonOther getBiomeDecorator() {
		return (BiomeDecoratorOberonOther) this.theBiomeDecorator;
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		generateOberonBiomeTerrain(rand, chunk, x, z, stoneNoise);
	}

	public final void generateOberonBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
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
				} else if (iblockstate2.getBlock() == ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(2).getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(2);
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
							iblockstate1 = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(2);
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
