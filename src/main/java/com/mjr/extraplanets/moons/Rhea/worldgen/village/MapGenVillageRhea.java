package com.mjr.extraplanets.moons.Rhea.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.moons.Rhea.worldgen.BiomeGenRhea;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageRhea extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenRhea.rhea });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageRhea.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageRhea.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartRhea.class, "RheaVillage");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageField.class, "RheaField1");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageField2.class, "RheaField2");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageHouse.class, "RheaHouse");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageRoadPiece.class, "RheaRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillagePathGen.class, "RheaPath");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageTorch.class, "RheaTorch");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageStartPiece.class, "RheaWell");
			MapGenStructureIO.func_143031_a(StructureComponentRheaVillageWoodHut.class, "RheaWoodHut");
		}
		MapGenVillageRhea.initialized = true;
	}

	public MapGenVillageRhea() {
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
		return new StructureVillageStartRhea(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "RheaVillage";
	}
}
