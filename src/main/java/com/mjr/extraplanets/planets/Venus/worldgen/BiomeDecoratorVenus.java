package com.mjr.extraplanets.planets.Venus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorVenus extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator carbonGen;
	private WorldGenerator gravelGen;
	private WorldGenerator volcanicRockGen;

	private World currentWorld;

	private int LakesPerChunk = 10;

	public BiomeDecoratorVenus() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.venusBlocks, 4, 5, false, ExtraPlanetsBlocks.venusBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.venusBlocks, 4, 4, false, ExtraPlanetsBlocks.venusBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.venusBlocks, 8, 3, false, ExtraPlanetsBlocks.venusBlocks, 2);
		this.carbonGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.OreCarbon, 4, 0, false, ExtraPlanetsBlocks.venusBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.venusGravel, 12, 0, false, ExtraPlanetsBlocks.venusBlocks, 2);
		this.volcanicRockGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.volcanicRock, 20, 0, false, ExtraPlanetsBlocks.venusBlocks, 0);

		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta,
		// boolean usingMetaData, Block StoneBlock, int StoneMeta);
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
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(20, this.carbonGen, 0, 64);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(30, this.volcanicRockGen, 0, 256);
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + this.rand.nextInt(16) + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + this.rand.nextInt(16) + 8;
				int y = this.currentWorld.getHeightValue(x, z);
				new WorldGenCustomLake(Blocks.lava).generate(this.currentWorld, this.rand, x, y, z, ExtraPlanetsBlocks.venusBlocks);
			}
		}

		/*for (int j = 0; j < 2; j++) {
	    if (this.rand.nextInt(10) == 0) {
		int x = this.chunkX + this.rand.nextInt(16) + 8;
		int z = this.chunkZ + this.rand.nextInt(16) + 8;
		int y = this.currentWorld.getHeightValue(x, z);
		new WorldGenVolcano().generate(this.currentWorld, this.rand, x, y, z, ExtraPlanetsBlocks.venusSurface);
	    }
	}*/
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	}
}
