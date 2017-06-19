package com.mjr.extraplanets.moons.Triton.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeDecoratorTritonOther extends BiomeDecorator {
	private World worldObj;
	private Random randomGenerator;

	private WorldGenerator snowGen;
	private WorldGenerator iceGen;

	public int generateSnowFeatures = 150;

	public BiomeDecoratorTritonOther() {
		this.snowGen = new WorldGenMinableMeta(Blocks.SNOW, 5, 0, false, ExtraPlanets_Blocks.FROZEN_NITROGEN, 0);
		this.iceGen = new WorldGenMinableMeta(Blocks.ICE, 5, 0, false, ExtraPlanets_Blocks.FROZEN_NITROGEN, 0);
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
		for (int var5 = 0; var5 < amountPerChunk; ++var5)
        {
            final int var6 = this.chunkPos.getX() + this.randomGenerator.nextInt(16);
            final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
            final int var8 = this.chunkPos.getZ() + this.randomGenerator.nextInt(16);
            worldGenerator.generate(currentWorld, this.randomGenerator, new BlockPos(var6, var7, var8));
        }
	}

	private void generate() {
		this.genStandardOre(this.generateSnowFeatures, this.snowGen, 0, 256);
		this.genStandardOre(this.generateSnowFeatures, this.iceGen, 0, 256);
	}
}