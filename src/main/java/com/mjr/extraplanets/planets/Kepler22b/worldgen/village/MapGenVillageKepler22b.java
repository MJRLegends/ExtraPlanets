package com.mjr.extraplanets.planets.Kepler22b.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageKepler22b extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { Kepler22bBiomes.kepler22bPlains });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageKepler22b.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageKepler22b.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartKepler22b.class, "Kepler22bVillage");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageField.class, "Kepler22bField1");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageField2.class, "Kepler22bField2");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageHouse.class, "Kepler22bHouse");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageRoadPiece.class, "Kepler22bRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillagePathGen.class, "Kepler22bPath");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageTorch.class, "Kepler22bTorch");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageStartPiece.class, "Kepler22bWell");
			MapGenStructureIO.func_143031_a(StructureComponentKepler22bVillageWoodHut.class, "Kepler22bWoodHut");
		}
		MapGenVillageKepler22b.initialized = true;
	}

	public MapGenVillageKepler22b() {
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
		if (Config.debugMode)
			MessageUtilities.debugMessageToLog("Generating Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartKepler22b(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "Kepler22bVillage";
	}
}
