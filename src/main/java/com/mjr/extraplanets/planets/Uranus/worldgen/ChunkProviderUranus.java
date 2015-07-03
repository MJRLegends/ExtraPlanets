package com.mjr.extraplanets.planets.Uranus.worldgen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.util.ForgeDirection;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanetsFluids;
import com.mjr.extraplanets.entities.EntityBlueCreeper;
import com.mjr.extraplanets.entities.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.EntityEvolvedIceSlime;
import com.mjr.extraplanets.entities.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.MapGenDungeon;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomBossUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomChestsUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomEmptyUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomSpawnerUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomTreasureUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.MapGenVillageUranus;

public class ChunkProviderUranus extends ChunkProviderSpace {

    private final BiomeDecoratorUranus greenPixelBiomeDecorator = new BiomeDecoratorUranus();

    private final MapGenCaveUranus caveGenerator = new MapGenCaveUranus();

    private final MapGenVillageUranus villageGenerator = new MapGenVillageUranus();

    private final MapGenDungeon dungeonGenerator = new MapGenDungeon(ExtraPlanetsBlocks.uranusDungeonBrick, 14, 8, 16, 3);

    public ChunkProviderUranus(World par1World, long seed, boolean mapFeaturesEnabled) {
	super(par1World, seed, mapFeaturesEnabled);
	this.dungeonGenerator.otherRooms.add(new RoomEmptyUranus(null, 0, 0, 0,
		ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
			RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0,
			0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
				RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
			this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0,
				0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
					RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
				this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0,
					0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
						RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
					this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0,
						0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
							RoomChestsUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
						this.dungeonGenerator.otherRooms.add(new RoomChestsUranus(null, 0, 0,
							0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.bossRooms.add(new
								RoomBossUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
							this.dungeonGenerator.treasureRooms.add(new RoomTreasureUranus(null, 0,
								0, 0, ForgeDirection.UNKNOWN));
    }

    @Override
    protected BiomeDecoratorSpace getBiomeGenerator() {
	return this.greenPixelBiomeDecorator;
    }

    @Override
    protected BiomeGenBase[] getBiomesForGeneration() {
	return new BiomeGenBase[] { UranusBiomes.uranus };
    }

    @Override
    protected int getSeaLevel() {
	return 64;
    }

    @Override
    protected List<MapGenBaseMeta> getWorldGenerators() {
	List<MapGenBaseMeta> generators = Lists.newArrayList();
	generators.add(this.caveGenerator);
	return generators;
    }

    @Override
    protected BiomeGenBase.SpawnListEntry[] getMonsters()
    {
	List<BiomeGenBase.SpawnListEntry> monsters = new ArrayList<BiomeGenBase.SpawnListEntry>();
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedIceSlime.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedEnderman.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityBlueCreeper.class, 8, 2, 3));
	//monsters.add(new BiomeGenBase.SpawnListEntry(EvolvedIceAllen.class, 8, 2, 3));
	monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedPowerSkeleton.class, 8, 2, 3));
	return monsters.toArray(new BiomeGenBase.SpawnListEntry[monsters.size()]);
    }

    @Override
    protected BiomeGenBase.SpawnListEntry[] getCreatures()
    {
	return new BiomeGenBase.SpawnListEntry[0];
    }

    @Override
    protected BlockMetaPair getGrassBlock() {
	if(Config.uranusLiquid)
	    return new BlockMetaPair(ExtraPlanetsFluids.frozen_water,(byte) 0);
	else
	    return new BlockMetaPair(ExtraPlanetsBlocks.uranusSurface,(byte) 1);
    }

    @Override
    protected BlockMetaPair getDirtBlock() {
	if(Config.uranusLiquid)
	    return new BlockMetaPair(ExtraPlanetsFluids.frozen_water,(byte) 0);
	else
	    return new BlockMetaPair(ExtraPlanetsBlocks.uranusSubSurface,(byte) 1);
    }

    @Override
    protected BlockMetaPair getStoneBlock() {
	return new BlockMetaPair(ExtraPlanetsBlocks.uranusStone,(byte) 1);
    }

    @Override
    public double getHeightModifier() {
	return 12;
    }

    @Override
    public double getSmallFeatureHeightModifier() {
	return 26;
    }

    @Override
    public double getMountainHeightModifier() {
	return 95;
    }

    @Override
    public double getValleyHeightModifier() {
	return 50;
    }

    @Override
    public int getCraterProbability() {
	return 2000;
    }

    @Override
    public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
	this.dungeonGenerator.generateUsingArrays(this.worldObj,
		this.worldObj.getSeed(), cX * 16, 25, cZ * 16, cX, cZ, blocks,metadata);
    }

    @Override
    public void onPopulate(IChunkProvider provider, int cX, int cZ) {
	if(!Config.uranusLiquid)
	    this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
	this.dungeonGenerator.handleTileEntities(this.rand);
    }
    @Override
    public void recreateStructures(int par1, int par2) {
	if(!Config.uranusLiquid)
	    this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
    }

}
