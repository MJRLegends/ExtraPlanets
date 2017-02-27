package com.mjr.extraplanets.planets.Saturn.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorSaturn extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator iceGen;
	private WorldGenerator magnesiumGen;
	private WorldGenerator gravelGen;

	private int LakesPerChunk = 5;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorSaturn()
	{
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 4, 5, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 4, 4, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 8, 3, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.iceGen = new WorldGenMinableMeta(Blocks.ice, 18, 0, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.magnesiumGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 4, 6, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnGravel, 12, 0, true, ExtraPlanets_Blocks.saturnBlocks, 2);

		//WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta, boolean usingMetaData, Block StoneBlock, int StoneMeta);
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
		if (isDecorating) return;
		isDecorating = true;
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(4, this.iceGen, 50, 120);
		this.generateOre(20, this.magnesiumGen, 0, 32);
		this.generateOre(15, this.gravelGen, 0, 80);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + 8;
				int y = this.currentWorld.getHeightValue(x, z);
				new WorldGenCustomLake(ExtraPlanets_Fluids.glowstone).generate(this.currentWorld, this.rand, x, y, z, ExtraPlanets_Blocks.saturnBlocks);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		//generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
		isDecorating = false;
	}
}
