package com.mjr.extraplanets.moons.Titan.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class BiomeDecoratorTitan extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	//private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;

	private int LakesPerChunk = 5;

	private World currentWorld;

	public BiomeDecoratorTitan() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.TITAN_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.TITAN_BLOCKS, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.TITAN_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.TITAN_BLOCKS, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.TITAN_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.TITAN_BLOCKS, 2);
		//this.gravelGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.titanGravel, 12, 0, true, ExtraPlanetsBlocks.titanBlocks, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.FOSSIL, 1, 0, true, ExtraPlanets_Blocks.TITAN_BLOCKS, 1);

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
		//this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(1, this.fossilsGen, 0, 256);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + 8;
				int y = this.currentWorld.getHeight(new BlockPos(x, 0, z)).getY() - 2;
				new WorldGenCustomLake(ExtraPlanets_Fluids.METHANE).generate(this.currentWorld, this.rand, new BlockPos(x, y, z), ExtraPlanets_Blocks.FROZEN_NITROGEN);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int
		// minY, int maxY);
	}
}
