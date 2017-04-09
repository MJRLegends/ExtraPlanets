package com.mjr.extraplanets.planets.Jupiter.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.worldGen.features.WorldGenBasicHideout;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorJupiter extends BiomeDecoratorSpace {

	private WorldGenerator deshGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator palladiumGen;
	private WorldGenerator nickelGen;
	private WorldGenerator gravelGen;
	private WorldGenerator redGemGen;

	private int LakesPerChunk = 50;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorJupiter()
	{
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 5, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 4, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 8, 3, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.palladiumGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 6, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.nickelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 7, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterGravel, 12, 0, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
		this.redGemGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.jupiterBlocks, 4, 10, true, ExtraPlanets_Blocks.jupiterBlocks, 2);
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
		this.generateOre(20, this.palladiumGen, 0, 32);
		this.generateOre(20, this.nickelGen, 32, 40);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.redGemGen, 0, 10);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(5) == 0) {
                int x = this.chunkX + this.rand.nextInt(16) + 8;
                int y = this.rand.nextInt(this.rand.nextInt(248) + 8);
                int z = this.chunkZ + this.rand.nextInt(16) + 8;
				new WorldGenCustomLake(ExtraPlanets_Fluids.magma).generate(this.currentWorld, this.rand, x, y, z, ExtraPlanets_Blocks.jupiterBlocks);
			}
		}
		if (this.rand.nextInt(200) == 1) {
			int x = this.chunkX + 8;
			int z = this.chunkZ + 8;
			int y = this.currentWorld.getHeightValue(x, z);
			new WorldGenBasicHideout().generate(this.currentWorld, this.rand, x, y, z);
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		isDecorating = false;
		//generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
	}

}
