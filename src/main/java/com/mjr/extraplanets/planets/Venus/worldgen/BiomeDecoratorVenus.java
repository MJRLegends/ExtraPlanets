package com.mjr.extraplanets.planets.Venus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;
import com.mjr.extraplanets.world.features.WorldGenVolcano;

public class BiomeDecoratorVenus extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator carbonGen;
	private WorldGenerator gravelGen;
	private WorldGenerator volcanicRockGen;

	private World currentWorld;

	private int LakesPerChunk = 10;

	private boolean isDecorating = false;

	public BiomeDecoratorVenus() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 4, 5, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 4, 4, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 8, 3, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.carbonGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusBlocks, 4, 6, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.venusGravel, 12, 0, true, ExtraPlanets_Blocks.venusBlocks, 2);
		this.volcanicRockGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.volcanicRock, 20, 0, true, ExtraPlanets_Blocks.venusBlocks, 0);

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
		if (isDecorating)
			return;
		isDecorating = true;
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(20, this.carbonGen, 0, 64);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(30, this.volcanicRockGen, 0, 256);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));

		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + 8;
				int y = this.currentWorld.getHeight(new BlockPos(x, 0, z)).getY() - 2;
				new WorldGenCustomLake(Blocks.lava).generate(this.currentWorld, this.rand, new BlockPos(x, y, z), ExtraPlanets_Blocks.venusBlocks);
			}
		}

		if (this.rand.nextInt(20) == 1) {
			int x = this.chunkX + 8;
			int z = this.chunkZ + 8;
			int y = this.currentWorld.getHeight(new BlockPos(x, 0, z)).getY() - 3;
			new WorldGenVolcano().generate(this.currentWorld, this.rand, new BlockPos(x, y, z));
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));
		isDecorating = false;
	}
}
