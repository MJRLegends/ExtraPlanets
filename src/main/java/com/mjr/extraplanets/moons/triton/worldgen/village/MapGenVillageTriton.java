package com.mjr.extraplanets.moons.triton.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.moons.triton.worldgen.BiomeGenTriton;

public class MapGenVillageTriton extends MapGenStructure {
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenTriton.triton });
    private final int terrainType;
    private static boolean initialized;

    static {
	try {
	    MapGenVillageTriton.initiateStructures();
	} catch (Throwable e) {
	}
    }

    public static void initiateStructures() throws Throwable {
	if (!MapGenVillageTriton.initialized) {
	    MapGenStructureIO.registerStructure(StructureVillageStartTriton.class, "TritonVillage");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageField.class, "TritonField1");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageField2.class, "TritonField2");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageHouse.class, "TritonHouse");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageRoadPiece.class, "TritonRoadPiece");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillagePathGen.class, "TritonPath");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageTorch.class, "TritonTorch");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageStartPiece.class, "TritonWell");
	    MapGenStructureIO.func_143031_a(StructureComponentTritonVillageWoodHut.class, "TritonWoodHut");
	}
	MapGenVillageTriton.initialized = true;
    }

    public MapGenVillageTriton() {
	this.terrainType = 0;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int i, int j) {
	final byte numChunks = 32; // 32
	final byte offsetChunks = 8; // 8
	final int oldi = i;
	final int oldj = j;

	if (i < 0) {
	    i -= numChunks - 1;
	}

	if (j < 0) {
	    j -= numChunks - 1;
	}

	int randX = i / numChunks;
	int randZ = j / numChunks;
	final Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
	randX *= numChunks;
	randZ *= numChunks;
	randX += var7.nextInt(numChunks - offsetChunks);
	randZ += var7.nextInt(numChunks - offsetChunks);
	return oldi == randX && oldj == randZ;
    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2) {
	System.out.println("Generating Village at x" + par1 * 16 + " z" + par2 * 16);
	return new StructureVillageStartTriton(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

    @Override
    public String func_143025_a() {
	return "TritonVillage";
    }
}
