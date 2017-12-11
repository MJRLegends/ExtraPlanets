package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.util.WorldGenHelper;
import com.mjr.extraplanets.world.features.WorldGenBasicHideout;

public class BiomeDecoratorJupiter extends BiomeDecorator {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator palladiumGen;
	private WorldGenerator nickelGen;
	private WorldGenerator gravelGen;
	private WorldGenerator redGemGen;
	private WorldGenerator skyBlocksGen;
	private WorldGenerator redSandGen;

	private int LakesPerChunk = 5;

	private World currentWorld;
	protected Random rand;
	protected int chunkX;
	protected int chunkZ;

	private boolean isDecorating = false;

	public BiomeDecoratorJupiter() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 5, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 4, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 8, 3, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.palladiumGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 6, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.nickelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 7, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterGravel, 12, 0, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.redGemGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 10, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.skyBlocksGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 3, 2, false, Blocks.air, 0);
		this.redSandGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.RED_SAND, 25, 0, false, ExtraPlanets_Blocks.ORANGE_SAND, 0);
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
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(20, this.palladiumGen, 0, 32);
		this.generateOre(20, this.nickelGen, 32, 40);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.redGemGen, 0, 10);
		this.generateOre(5, this.skyBlocksGen, 63, 256);
		this.generateOre(150, this.redSandGen, 0, 256);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				WorldGenHelper.generateLake(this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ, ExtraPlanets_Fluids.magma, ExtraPlanets_Blocks.jupiterBlocks);
			}
		}

		if (this.rand.nextInt(250) == 1) {
			WorldGenHelper.generateStructure(new WorldGenBasicHideout(), this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ);
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		isDecorating = false;
	}

}
