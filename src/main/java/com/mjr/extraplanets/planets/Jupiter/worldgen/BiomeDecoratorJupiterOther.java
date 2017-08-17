package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeDecoratorJupiterOther extends BiomeDecorator {
	private World worldObj;
	private Random randomGenerator;

	private WorldGenerator redSandGen;

	public int generateRedSandFeatures = 150;

	public BiomeDecoratorJupiterOther() {
		this.redSandGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.RED_SAND, 25, 0, false, ExtraPlanets_Blocks.ORANGE_SAND, 0);
		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta, boolean usingMetaData, Block StoneBlock, int StoneMeta);
	}

	@Override
	public void decorate(World worldIn, Random random, Biome p_180292_3_, BlockPos pos) {
		if (this.worldObj != null) {
			throw new RuntimeException("Already decorating!!");
		} else {
			this.worldObj = worldIn;
			this.randomGenerator = random;
			this.chunkPos = pos;
			this.generate();
			this.worldObj = null;
			this.randomGenerator = null;
		}
	}

	private void genStandardOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY) {
		World currentWorld = this.worldObj;
		for (int var5 = 0; var5 < amountPerChunk; ++var5) {
			final int var6 = this.chunkPos.getX() + this.randomGenerator.nextInt(16);
			final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkPos.getZ() + this.randomGenerator.nextInt(16);
			worldGenerator.generate(currentWorld, this.randomGenerator, new BlockPos(var6, var7, var8));
		}
	}

	private void generate() {
		this.genStandardOre(this.generateRedSandFeatures, this.redSandGen, 0, 256);
	}
}