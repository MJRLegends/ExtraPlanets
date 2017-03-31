package com.mjr.extraplanets.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class WorldGenerationOverworld implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionType().getId()) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(64);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(ExtraPlanets_Blocks.ORE_LEAD.getDefaultState(), 10)).generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
		}
	}
}