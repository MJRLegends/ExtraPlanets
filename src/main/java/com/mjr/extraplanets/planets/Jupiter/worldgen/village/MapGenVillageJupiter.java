package com.mjr.extraplanets.planets.Jupiter.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class MapGenVillageJupiter extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { JupiterBiomes.jupiter });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageJupiter.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageJupiter.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartJupiter.class, "JupiterVillage");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageField.class, "JupiterField1");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageField2.class, "JupiterField2");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageHouse.class, "JupiterHouse");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageRoadPiece.class, "JupiterRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillagePathGen.class, "JupiterPath");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageTorch.class, "JupiterTorch");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageStartPiece.class, "JupiterWell");
			MapGenStructureIO.func_143031_a(StructureComponentJupiterVillageWoodHut.class, "JupiterWoodHut");
		}
		MapGenVillageJupiter.initialized = true;
	}

	public MapGenVillageJupiter() {
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
		return new StructureVillageStartJupiter(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "JupiterVillage";
	}
}
