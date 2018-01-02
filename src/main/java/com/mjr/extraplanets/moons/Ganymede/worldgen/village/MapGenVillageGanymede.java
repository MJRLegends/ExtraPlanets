package com.mjr.extraplanets.moons.Ganymede.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.moons.Ganymede.worldgen.BiomeGenGanymede;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageGanymede extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenGanymede.ganymede });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageGanymede.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageGanymede.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartGanymede.class, "GanymedeVillage");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageField.class, "GanymedeField1");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageField2.class, "GanymedeField2");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageHouse.class, "GanymedeHouse");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageRoadPiece.class, "GanymedeRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillagePathGen.class, "GanymedePath");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageTorch.class, "GanymedeTorch");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageStartPiece.class, "GanymedeWell");
			MapGenStructureIO.func_143031_a(StructureComponentGanymedeVillageWoodHut.class, "GanymedeWoodHut");
		}
		MapGenVillageGanymede.initialized = true;
	}

	public MapGenVillageGanymede() {
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
		return new StructureVillageStartGanymede(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "GanymedeVillage";
	}
}
