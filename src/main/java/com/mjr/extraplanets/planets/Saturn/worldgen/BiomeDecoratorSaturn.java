package com.mjr.extraplanets.planets.Saturn.worldgen;

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
import com.mjr.extraplanets.planets.Saturn.worldgen.biomes.BiomeGenSaturn;
import com.mjr.extraplanets.util.WorldGenHelper;

public class BiomeDecoratorSaturn extends BiomeDecorator {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator iceGen;
	private WorldGenerator magnesiumGen;
	private WorldGenerator gravelGen;
	private WorldGenerator slimeGen;

	private int LakesPerChunk = 5;

	private World currentWorld;
	protected Random rand;
	protected int chunkX;
	protected int chunkZ;

	private boolean isDecorating = false;

	public BiomeDecoratorSaturn() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 4, 5, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 4, 4, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 8, 3, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.iceGen = new WorldGenMinableMeta(Blocks.ice, 18, 0, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.magnesiumGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 4, 6, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnGravel, 12, 0, true, ExtraPlanets_Blocks.saturnBlocks, 2);
		this.slimeGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.saturnBlocks, 12, 11, true, ExtraPlanets_Blocks.saturnBlocks, 9);

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
		this.generateOre(4, this.iceGen, 50, 120);
		this.generateOre(20, this.magnesiumGen, 0, 32);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.slimeGen, 60, 256);
		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		if (this.currentWorld.getBiomeGenForCoords(this.chunkX, this.chunkZ) instanceof BiomeGenSaturn)
			for (int i = 0; i < this.LakesPerChunk; i++) {
				if (this.rand.nextInt(10) == 0) {
					WorldGenHelper.generateLake(this.currentWorld, this.rand, this.chunkX, 0, this.chunkZ, ExtraPlanets_Fluids.glowstone, ExtraPlanets_Blocks.saturnBlocks);
				}
			}

		// if (this.getCurrentWorld().getBiomeGenForCoords(new BlockPos(this.posX, 0, this.posZ)) instanceof BiomeGenSaturnNuclearLand) {
		// for (int i = 0; i < LakesPerChunk * 2; i++) {
		// if (this.rand.nextInt(10) == 0) {
		// WorldGenHelper.generateLake(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ), ExtraPlanets_Fluids.METHANE,
		// ExtraPlanets_Blocks.saturnBlocks.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.BROKEN_INFECTED_STONE));
		// }
		// }
		// if (this.rand.nextInt(5) == 1) {
		// BlockPos blockpos = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(this.posX + (this.rand.nextInt(16) + 8), 0, this.posZ + (this.rand.nextInt(16) + 8)));
		// new WorldGenNuclearPile().generate(this.currentWorld, this.rand, blockpos);
		// }
		// if (this.rand.nextInt(5) == 1) {
		// BlockPos blockpos = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(this.posX + (this.rand.nextInt(16) + 8), 0, this.posZ + (this.rand.nextInt(16) + 8)));
		// new WorldGenSlimeTree().generate(this.currentWorld, this.rand, blockpos);
		// }
		// }

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
		isDecorating = false;
	}
}
