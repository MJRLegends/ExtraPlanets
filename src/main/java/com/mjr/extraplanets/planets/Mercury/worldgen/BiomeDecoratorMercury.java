package com.mjr.extraplanets.planets.Mercury.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.util.WorldGenHelper;

public class BiomeDecoratorMercury extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator mercuryGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorMercury() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.mercuryBlocks, 4, 5, true, ExtraPlanets_Blocks.mercuryBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.mercuryBlocks, 4, 4, true, ExtraPlanets_Blocks.mercuryBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.mercuryBlocks, 8, 3, true, ExtraPlanets_Blocks.mercuryBlocks, 2);
		this.mercuryGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.mercuryBlocks, 4, 6, true, ExtraPlanets_Blocks.mercuryBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.mercuryGravel, 12, 0, true, ExtraPlanets_Blocks.mercuryBlocks, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.fossil, 3, 0, true, ExtraPlanets_Blocks.mercuryBlocks, 1);

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
		this.generateOre(20, this.mercuryGen, 0, 64);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.fossilsGen, 0, 256);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; i < 1; i++) {
			if (this.rand.nextInt(100) == 0) {
				WorldGenHelper.generateLake(this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ, ExtraPlanets_Fluids.infected_water, ExtraPlanets_Blocks.mercuryBlocks);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		isDecorating = false;
	}

}
