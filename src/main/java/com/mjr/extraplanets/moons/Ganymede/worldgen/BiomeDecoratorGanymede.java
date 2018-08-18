package com.mjr.extraplanets.moons.Ganymede.worldgen;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;
import com.mjr.mjrlegendslib.world.features.WorldGenSphere;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeDecoratorGanymede extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;
	private WorldGenerator iceGen;
	private WorldGenerator iceSubSurfaceGen;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorGanymede() {
		if (Config.GENERATE_ORES_GANYMEDE) {
			this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 2);
			this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 2);
			this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 2);
		}
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.GANYMEDE_GRAVEL, 12, 0, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.FOSSIL, 3, 0, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1);
		this.iceGen = new WorldGenMinableMeta(Blocks.ICE, 10, 0, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 2);
		this.iceSubSurfaceGen = new WorldGenMinableMeta(Blocks.ICE, 10, 0, true, ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1);

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
		if (Config.GENERATE_ORES_GANYMEDE) {
			this.generateOre(26, this.copperGen, 0, 60);
			this.generateOre(23, this.tinGen, 0, 60);
			this.generateOre(20, this.ironGen, 0, 64);
		}
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.fossilsGen, 0, 256);
		this.generateOre(20, this.iceGen, 0, 80);
		this.generateOre(10, this.iceSubSurfaceGen, 0, 256);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));
		for (int i = 0; i < 1; i++) {
			if (this.rand.nextInt(100) == 0) {
				WorldGenUtilities.generateLake(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ), ExtraPlanets_Fluids.INFECTED_WATER, ExtraPlanets_Blocks.MERCURY_BLOCKS);
			}
		}
		if (Config.GENERATE_GANYMEDE_ICE_CHUNKS) {
			for (int i = 0; i < 3; i++) {
				if (rand.nextInt(5) == 1) {
					WorldGenUtilities.generateStructureWithRangeY(new WorldGenSphere(true, Constants.modID, Blocks.ICE.getDefaultState(), 12, 2), this.currentWorld, rand, new BlockPos(this.posX, 0, this.posZ), 6, 60);
				}
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));

		isDecorating = false;

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, intminY, int maxY);
	}
}
