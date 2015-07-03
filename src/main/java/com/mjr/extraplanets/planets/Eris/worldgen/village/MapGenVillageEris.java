package com.mjr.extraplanets.planets.Eris.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.planets.Eris.worldgen.BiomeGenEris;

public class MapGenVillageEris extends MapGenStructure {
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenEris.eris });
    private final int terrainType;
    private static boolean initialized;

    static {
	try {
	    MapGenVillageEris.initiateStructures();
	} catch (Throwable e) {
	}
    }

    public static void initiateStructures() throws Throwable {
	if (!MapGenVillageEris.initialized) {
	    MapGenStructureIO.registerStructure(StructureVillageStartEris.class, "ErisVillage");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageField.class, "ErisField1");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageField2.class, "ErisField2");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageHouse.class, "ErisHouse");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageRoadPiece.class, "ErisRoadPiece");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillagePathGen.class, "ErisPath");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageTorch.class, "ErisTorch");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageStartPiece.class, "ErisWell");
	    MapGenStructureIO.func_143031_a(StructureComponentErisVillageWoodHut.class, "ErisWoodHut");
	}
	MapGenVillageEris.initialized = true;
    }

    public MapGenVillageEris() {
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
	return new StructureVillageStartEris(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

    @Override
    public String func_143025_a() {
	return "ErisVillage";
    }
}
