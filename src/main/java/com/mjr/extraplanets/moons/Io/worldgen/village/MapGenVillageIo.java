package com.mjr.extraplanets.moons.Io.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.moons.Io.worldgen.BiomeGenIo;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageIo extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenIo.io });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageIo.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageIo.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartIo.class, "IoVillage");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageField.class, "IoField1");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageField2.class, "IoField2");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageHouse.class, "IoHouse");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageRoadPiece.class, "IoRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillagePathGen.class, "IoPath");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageTorch.class, "IoTorch");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageStartPiece.class, "IoWell");
			MapGenStructureIO.func_143031_a(StructureComponentIoVillageWoodHut.class, "IoWoodHut");
		}
		MapGenVillageIo.initialized = true;
	}

	public MapGenVillageIo() {
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
		return new StructureVillageStartIo(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "IoVillage";
	}
}
