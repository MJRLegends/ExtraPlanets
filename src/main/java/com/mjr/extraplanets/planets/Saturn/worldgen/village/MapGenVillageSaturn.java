package com.mjr.extraplanets.planets.Saturn.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageSaturn extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { SaturnBiomes.saturn });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageSaturn.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageSaturn.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartSaturn.class, "SaturnVillage");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageField.class, "SaturnField1");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageField2.class, "SaturnField2");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageHouse.class, "SaturnHouse");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageRoadPiece.class, "SaturnRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillagePathGen.class, "SaturnPath");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageTorch.class, "SaturnTorch");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageStartPiece.class, "SaturnWell");
			MapGenStructureIO.func_143031_a(StructureComponentSaturnVillageWoodHut.class, "SaturnWoodHut");
		}
		MapGenVillageSaturn.initialized = true;
	}

	public MapGenVillageSaturn() {
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
		if(Config.debugMode)
			MessageUtilities.debugMessageToLog("Generating Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartSaturn(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "SaturnVillage";
	}
}
