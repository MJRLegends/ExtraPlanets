package com.mjr.extraplanets.planets.Venus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.util.WorldGenHelper;
import com.mjr.extraplanets.world.features.WorldGenVolcano;

public class BiomeDecoratorVenus extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator carbonGen;
	private WorldGenerator gravelGen;
	private WorldGenerator volcanicRockGen;

	private World currentWorld;

	private int LakesPerChunk = 20;

	private boolean isDecorating = false;

	public BiomeDecoratorVenus() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 4, 5, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 4, 4, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 8, 3, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.carbonGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 4, 6, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusGravel, 12, 0, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.volcanicRockGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.volcanicRock, 40, 0, true, ExtraPlanets_Blocks.venusBlocks, 0);

		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta, boolean usingMetaData, Block StoneBlock, int StoneMeta);
	}

	@Override
	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	@Override
	protected World getCurrentWorld() {
		return this.currentWorld;
	}

	@Override
	protected void decorate() {
		if (isDecorating)
			return;
		isDecorating = true;
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(20, this.carbonGen, 0, 64);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(30, this.volcanicRockGen, 0, 256);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				WorldGenHelper.generateLake(this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ, Blocks.lava, ExtraPlanets_Blocks.venusBlocks);

			}
		}
		if (Config.genVenusVolcanos) {
			if (this.rand.nextInt(20) == 1) {
				WorldGenHelper.generateStructure(new WorldGenVolcano(), this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ);
			}
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		isDecorating = false;
	}
}
