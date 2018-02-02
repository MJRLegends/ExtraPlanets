package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bBlueMapleForest;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bCandyLand;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bCoalPlains;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bDiamondPlains;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bEmeraldPlains;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bGoldPlains;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bIronPlains;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bPlains;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bPurpleMapleForest;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bRedDesert;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bRedMapleForest;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenKepler22bYellowMapleForest;

public class Kepler22bBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase kepler22bPlains = new BiomeGenKepler22bPlains(Config.KEPLER22B_PLAINS_BIOME_ID).setBiomeName("Kepler22b Plains").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bBlueForest = new BiomeGenKepler22bBlueMapleForest(Config.KEPLER22B_BLUE_FOREST_BIOME_ID).setBiomeName("Kepler22b Blue Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bPurpleForest = new BiomeGenKepler22bPurpleMapleForest(Config.KEPLER22B_PURPLE_FOREST_BIOME_ID).setBiomeName("Kepler22b Purple Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bRedForest = new BiomeGenKepler22bRedMapleForest(Config.KEPLER22B_RED_FOREST_BIOME_ID).setBiomeName("Kepler22b Red Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bYellowForest = new BiomeGenKepler22bYellowMapleForest(Config.KEPLER22B_YELLOW_FOREST_BIOME_ID).setBiomeName("Kepler22b Yellow Maple Forest").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bRedDesert = new BiomeGenKepler22bRedDesert(Config.KEPLER22B_RED_DESERT_BIOME_ID).setBiomeName("Kepler22b Red Desert").setHeight(new Height(0.125F, 0.1F));
	public static final BiomeGenBase kepler22bWasteLands = new BiomeGenKepler22bRedDesert(Config.KEPLER22B_WASTE_LANDS_BIOME_ID).setBiomeName("Kepler22b WasteLands").setHeight(new Height(-0.2F, 0.1F));
	public static final BiomeGenBase kepler22bCandyLand = new BiomeGenKepler22bCandyLand(Config.KEPLER22B_CANDY_LAND_BIOME_ID).setBiomeName("Kepler22b Candy Land").setHeight(new Height(0.225F, 0.02F));
	public static final BiomeGenBase kepler22bDiamondPlains = new BiomeGenKepler22bDiamondPlains(Config.KEPLER22B_DIAMOND_PLAINS_BIOME_ID).setBiomeName("Kepler22b Diamond Plains").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bCoalPlains = new BiomeGenKepler22bCoalPlains(Config.KEPLER22B_COAL_PLAINS_BIOME_ID).setBiomeName("Kepler22b Coal Plains").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bIronPlains = new BiomeGenKepler22bIronPlains(Config.KEPLER22B_IRON_PLAINS_BIOME_ID).setBiomeName("Kepler22b Iron Plains").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bGoldPlains = new BiomeGenKepler22bGoldPlains(Config.KEPLER22B_GOLD_PLAINS_BIOME_ID).setBiomeName("Kepler22b Gold Plains").setHeight(new Height(0.125F, 0.05F));
	public static final BiomeGenBase kepler22bEmeraldPlains = new BiomeGenKepler22bEmeraldPlains(Config.KEPLER22B_EMERALD_PLAINS_BIOME_ID).setBiomeName("Kepler22b Emerald Plains").setHeight(new Height(0.125F, 0.05F));

	protected byte topMeta;
	protected byte fillerMeta;

	public Kepler22bBiomes(int var1) {
		super(var1);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_GREEN.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();
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