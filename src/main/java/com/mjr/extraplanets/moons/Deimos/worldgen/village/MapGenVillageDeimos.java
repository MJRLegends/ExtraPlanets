package com.mjr.extraplanets.moons.Deimos.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.moons.Deimos.worldgen.BiomeGenDeimos;

public class MapGenVillageDeimos extends MapGenStructure {
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenDeimos.deimos });
    private final int terrainType;
    private static boolean initialized;

    static {
	try {
	    MapGenVillageDeimos.initiateStructures();
	} catch (Throwable e) {
	}
    }

    public static void initiateStructures() throws Throwable {
	if (!MapGenVillageDeimos.initialized) {
	    MapGenStructureIO.registerStructure(StructureVillageStartDeimos.class, "DeimosVillage");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageField.class, "DeimosField1");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageField2.class, "DeimosField2");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageHouse.class, "DeimosHouse");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageRoadPiece.class, "DeimosRoadPiece");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillagePathGen.class, "DeimosPath");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageTorch.class, "DeimosTorch");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageStartPiece.class, "DeimosWell");
	    MapGenStructureIO.func_143031_a(StructureComponentDeimosVillageWoodHut.class, "DeimosWoodHut");
	}
	MapGenVillageDeimos.initialized = true;
    }

    public MapGenVillageDeimos() {
	this.terrainType = 0;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int i, int j) {
	final byte numChunks = 32; //32
	final byte offsetChunks = 8; //8
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
	return new StructureVillageStartDeimos(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

    @Override
    public String func_143025_a() {
	return "DeimosVillage";
    }
}
