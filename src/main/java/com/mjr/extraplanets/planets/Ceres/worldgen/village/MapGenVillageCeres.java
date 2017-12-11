package com.mjr.extraplanets.planets.Ceres.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Ceres.worldgen.BiomeGenCeres;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageCeres extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenCeres.ceres });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageCeres.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageCeres.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartCeres.class, "CeresVillage");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageField.class, "CeresField1");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageField2.class, "CeresField2");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageHouse.class, "CeresHouse");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageRoadPiece.class, "CeresRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillagePathGen.class, "CeresPath");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageTorch.class, "CeresTorch");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageStartPiece.class, "CeresWell");
			MapGenStructureIO.func_143031_a(StructureComponentCeresVillageWoodHut.class, "CeresWoodHut");
		}
		MapGenVillageCeres.initialized = true;
	}

	public MapGenVillageCeres() {
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
		return new StructureVillageStartCeres(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "CeresVillage";
	}
}
