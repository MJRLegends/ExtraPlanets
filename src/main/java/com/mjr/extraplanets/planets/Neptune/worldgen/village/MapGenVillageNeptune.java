package com.mjr.extraplanets.planets.Neptune.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Neptune.worldgen.biomes.BiomeGenNeptune;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageNeptune extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenNeptune.neptune });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageNeptune.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageNeptune.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartNeptune.class, "NeptuneVillage");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageField.class, "NeptuneField1");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageField2.class, "NeptuneField2");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageHouse.class, "NeptuneHouse");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageRoadPiece.class, "NeptuneRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillagePathGen.class, "NeptunePath");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageTorch.class, "NeptuneTorch");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageStartPiece.class, "NeptuneWell");
			MapGenStructureIO.func_143031_a(StructureComponentNeptuneVillageWoodHut.class, "NeptuneWoodHut");
		}
		MapGenVillageNeptune.initialized = true;
	}

	public MapGenVillageNeptune() {
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
		return new StructureVillageStartNeptune(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "NeptuneVillage";
	}
}
