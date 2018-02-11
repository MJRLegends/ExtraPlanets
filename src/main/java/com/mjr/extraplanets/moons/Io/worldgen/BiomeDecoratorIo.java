package com.mjr.extraplanets.moons.Io.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.moons.Io.worldgen.biomes.BiomeGenIOBurningPlains;
import com.mjr.extraplanets.world.features.WorldGenVolcano;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;

public class BiomeDecoratorIo extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;

	private int LakesPerChunk = 5;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorIo() {
		if (Config.GENERATE_ORES_IO) {
			this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.IO_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.IO_BLOCKS, 2);
			this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.IO_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.IO_BLOCKS, 2);
			this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.IO_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.IO_BLOCKS, 2);
		}
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.IO_GRAVEL, 12, 0, true, ExtraPlanets_Blocks.IO_BLOCKS, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.FOSSIL, 3, 0, true, ExtraPlanets_Blocks.IO_BLOCKS, 1);

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
		if (Config.GENERATE_ORES_IO) {
			this.generateOre(26, this.copperGen, 0, 60);
			this.generateOre(23, this.tinGen, 0, 60);
			this.generateOre(20, this.ironGen, 0, 64);
		}
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.fossilsGen, 0, 256);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));

		if (this.getCurrentWorld().getBiome(new BlockPos(this.posX, 0, this.posZ)) instanceof BiomeGenIOBurningPlains) {
			for (int i = 0; i < LakesPerChunk * 2; i++) {
				if (this.rand.nextInt(10) == 0) {
					WorldGenUtilities.generateLake(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ), ExtraPlanets_Fluids.MAGMA, ExtraPlanets_Blocks.VOLCANIC_ROCK.getDefaultState());
				}
			}
			if (Config.GENERATE_IO_VOLCANOS && this.rand.nextInt(5) == 1) {
				WorldGenUtilities.generateStructure(new WorldGenVolcano(), this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ));
			}
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));

		isDecorating = false;

	}
}
