package com.mjr.extraplanets.moons.Iapetus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeDecoratorIapetus extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;

	private World currentWorld;

	public BiomeDecoratorIapetus() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.iapetusBlocks, 4, 5, true, ExtraPlanets_Blocks.iapetusBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.iapetusBlocks, 4, 4, true, ExtraPlanets_Blocks.iapetusBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.iapetusBlocks, 8, 3, true, ExtraPlanets_Blocks.iapetusBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.iapetusGravel, 12, 0, true, ExtraPlanets_Blocks.iapetusBlocks, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.fossil, 1, 0, true, ExtraPlanets_Blocks.iapetusBlocks, 1);

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
