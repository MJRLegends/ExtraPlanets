package com.mjr.extraplanets.planets.Uranus.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.util.WorldGenHelper;
import com.mjr.extraplanets.world.features.WorldGenCustomIceSpike;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;
import com.mjr.extraplanets.world.features.WorldGenIgloo;

public class BiomeDecoratorUranus extends BiomeDecorator {

	private WorldGenerator iceGen;
	private WorldGenerator crystalGen;
	private WorldGenerator denseIceGen;
	private WorldGenerator whiteGemGen;

	private World currentWorld;
	protected Random rand;
	protected int chunkX;
	protected int chunkZ;

	private int iceSpikesPerChunk = 5;
	private int LakesPerChunk = 5;

	private boolean isDecorating = false;

	public BiomeDecoratorUranus() {
		this.iceGen = new WorldGenMinableMeta(Blocks.ice, 18, 0, true, ExtraPlanets_Blocks.uranusBlocks, 2);
		this.crystalGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.uranusBlocks, 4, 3, true, ExtraPlanets_Blocks.uranusBlocks, 2);
		this.denseIceGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.denseIce, 8, 0, true, ExtraPlanets_Blocks.uranusBlocks, 0);
		this.whiteGemGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.uranusBlocks, 4, 6, true, ExtraPlanets_Blocks.uranusBlocks, 2);

		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta, boolean usingMetaData, Block StoneBlock, int StoneMeta);
	}

	protected void generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY) {
		for (int var5 = 0; var5 < amountPerChunk; ++var5) {
			final int var6 = this.chunkX + this.rand.nextInt(16);
			final int var7 = this.rand.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkZ + this.rand.nextInt(16);
			worldGenerator.generate(this.currentWorld, this.rand, var6, var7, var8);
		}
	}

	@Override
	public void decorateChunk(World world, Random rand, BiomeGenBase biome, int xChunk, int zChunk) {
		this.currentWorld = world;
		this.rand = rand;
		this.chunkX = xChunk;
		this.chunkZ = zChunk;

		if (isDecorating)
			return;
		isDecorating = true;
		this.generateOre(8, this.iceGen, 50, 120);
		this.generateOre(20, this.crystalGen, 0, 32);
		this.generateOre(20, this.denseIceGen, 0, 256);
		this.generateOre(5, this.whiteGemGen, 0, 10);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
		
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				WorldGenHelper.generateLake(this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ, ExtraPlanets_Fluids.frozen_water, ExtraPlanets_Blocks.uranusBlocks);
			}
		}
		if (Config.genUranusIceSpikes) {
			for (int i = 0; i < this.iceSpikesPerChunk; i++) {
				if (this.rand.nextInt(20) == 0) {
					int x = this.chunkX + 6;
					int z = this.chunkZ + 6;
					int y = this.currentWorld.getHeightValue(x, z);
					new WorldGenCustomIceSpike().generate(this.currentWorld, this.rand, x, y, z, ExtraPlanets_Blocks.uranusBlocks);
				}
			}
		}
		if (Config.genUranusIgloos) {
			if (this.rand.nextInt(300) == 1) {
				WorldGenHelper.generateStructure(new WorldGenIgloo(), this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ);
			}
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		isDecorating = false;
	}
}