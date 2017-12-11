package com.mjr.extraplanets.moons.Europa.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.moons.Europa.worldgen.BiomeGenEuropa;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageEuropa extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenEuropa.europa });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageEuropa.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageEuropa.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartEuropa.class, "EuropaVillage");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageField.class, "EuropaField1");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageField2.class, "EuropaField2");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageHouse.class, "EuropaHouse");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageRoadPiece.class, "EuropaRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillagePathGen.class, "EuropaPath");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageTorch.class, "EuropaTorch");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageStartPiece.class, "EuropaWell");
			MapGenStructureIO.func_143031_a(StructureComponentEuropaVillageWoodHut.class, "EuropaWoodHut");
		}
		MapGenVillageEuropa.initialized = true;
	}

	public MapGenVillageEuropa() {
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
		if(Config.debugMode)
			MessageUtilities.debugMessageToLog("Generating Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartEuropa(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "EuropaVillage";
	}
}
