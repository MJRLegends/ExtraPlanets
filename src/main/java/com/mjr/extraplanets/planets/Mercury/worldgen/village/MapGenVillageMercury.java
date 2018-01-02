package com.mjr.extraplanets.planets.Mercury.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Mercury.worldgen.BiomeGenMercury;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageMercury extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenMercury.mercury });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageMercury.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageMercury.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartMercury.class, "MercuryVillage");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageField.class, "MercuryField1");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageField2.class, "MercuryField2");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageHouse.class, "MercuryHouse");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageRoadPiece.class, "MercuryRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillagePathGen.class, "MercuryPath");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageTorch.class, "MercuryTorch");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageStartPiece.class, "MercuryWell");
			MapGenStructureIO.func_143031_a(StructureComponentMercuryVillageWoodHut.class, "MercuryWoodHut");
		}
		MapGenVillageMercury.initialized = true;
	}

	public MapGenVillageMercury() {
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
		return new StructureVillageStartMercury(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "MercuryVillage";
	}
}
