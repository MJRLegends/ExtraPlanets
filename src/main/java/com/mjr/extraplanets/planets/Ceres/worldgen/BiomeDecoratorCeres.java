package com.mjr.extraplanets.planets.Ceres.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanetsFluids;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorCeres extends BiomeDecoratorSpace {

    private WorldGenerator copperGen;
    private WorldGenerator tinGen;
    private WorldGenerator ironGen;
    private WorldGenerator gravelGen;
    private WorldGenerator uraniumGen;
    private WorldGenerator fossilsGen;

    private int LakesPerChunk = 5;

    private World currentWorld;

    public BiomeDecoratorCeres() {
	this.copperGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.ceresOreCopper, 4, 0, false, ExtraPlanetsBlocks.ceresStone, 1);
	this.tinGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.ceresOreTin, 4, 0, false, ExtraPlanetsBlocks.ceresStone, 1);
	this.ironGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.ceresOreIron, 8, 0, false, ExtraPlanetsBlocks.ceresStone, 1);
	this.uraniumGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.OreUranium, 2, 0, false, ExtraPlanetsBlocks.ceresStone, 1);
	this.gravelGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.ceresGravel, 12, 0, false, ExtraPlanetsBlocks.ceresStone, 1);
	this.fossilsGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.fossil, 1, 0, false, ExtraPlanetsBlocks.ceresSubSurface, 1);

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
	this.generateOre(5, this.uraniumGen, 0, 64);
	this.generateOre(15, this.gravelGen, 0, 80);
	this.generateOre(1, this.fossilsGen, 0, 256);

	MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	for (int i = 0; i < this.LakesPerChunk; i++) {
	    if (this.rand.nextInt(10) == 0) {
		int x = this.chunkX + this.rand.nextInt(16) + 8;
		// int y = this.rand.nextInt(16) + 16;
		int z = this.chunkZ + this.rand.nextInt(16) + 8;
		int y = this.currentWorld.getHeightValue(x, z);
		new WorldGenCustomLake(ExtraPlanetsFluids.salt).generate(this.currentWorld, this.rand, x, y, z,
			ExtraPlanetsBlocks.ceresStone);
	    }
	}
	MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

	// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int
	// minY, int maxY);
    }
}
