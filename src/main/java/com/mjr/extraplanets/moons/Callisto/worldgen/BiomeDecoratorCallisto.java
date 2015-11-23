package com.mjr.extraplanets.moons.Callisto.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class BiomeDecoratorCallisto extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;

	private World currentWorld;

	public BiomeDecoratorCallisto() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.callistoBlocks, 4, 5, true, ExtraPlanetsBlocks.callistoBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.callistoBlocks, 4, 4, true, ExtraPlanetsBlocks.callistoBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.callistoBlocks, 8, 3, true, ExtraPlanetsBlocks.callistoBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.callistoGravel, 12, 0, true, ExtraPlanetsBlocks.callistoBlocks, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.fossil, 1, 0, true, ExtraPlanetsBlocks.callistoBlocks, 1);

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
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(1, this.fossilsGen, 0, 256);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int
		// minY, int maxY);
	}
}
