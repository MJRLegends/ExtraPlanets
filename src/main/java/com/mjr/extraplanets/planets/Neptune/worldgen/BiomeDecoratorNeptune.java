package com.mjr.extraplanets.planets.Neptune.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanetsFluids;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorNeptune extends BiomeDecoratorSpace {

    private WorldGenerator copperGen;
    private WorldGenerator tinGen;
    private WorldGenerator ironGen;
    private WorldGenerator zincGen;
    private WorldGenerator frozenNitrogenGen;
    private int LakesPerChunk = 5;

    private World currentWorld;

    public BiomeDecoratorNeptune()
    {
	this.copperGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.neptuneOreCopper, 4, 0, false, ExtraPlanetsBlocks.neptuneStone, 1);
	this.tinGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.neptuneOreTin, 4, 0, false, ExtraPlanetsBlocks.neptuneStone, 1);
	this.ironGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.neptuneOreIron, 8, 0, false, ExtraPlanetsBlocks.neptuneStone, 1);
	this.zincGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.OreZinc, 8, 0, false, ExtraPlanetsBlocks.neptuneStone, 1);
	this.frozenNitrogenGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.frozenNitrogen, 8, 0, false, ExtraPlanetsBlocks.neptuneSurface, 1);

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
	this.generateOre(26, this.copperGen, 0, 60);
	this.generateOre(23, this.tinGen, 0, 60);
	this.generateOre(20, this.ironGen, 0, 64);
	this.generateOre(20, this.zincGen, 0, 64);
	this.generateOre(5, this.frozenNitrogenGen, 0, 256);

	MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	for (int i = 0; i < this.LakesPerChunk; i++) {
	    if (this.rand.nextInt(10) == 0) {
		int x = this.chunkX + this.rand.nextInt(16) + 8;
		// int y = this.rand.nextInt(16) + 16;
		int z = this.chunkZ + this.rand.nextInt(16) + 8;
		int y = this.currentWorld.getHeightValue(x, z);
		new WorldGenCustomLake(ExtraPlanetsFluids.nitrogen).generate(this.currentWorld, this.rand, x, y, z, ExtraPlanetsBlocks.neptuneStone);
	    }
	}
	MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

	//generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
    }
}
