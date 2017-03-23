package com.mjr.extraplanets.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class WorldGenerationOverworld implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0:
			generateSurface(world, rand, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(64);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(ExtraPlanets_Blocks.oreLead.getDefaultState(), 10)).generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
		}
	}
}