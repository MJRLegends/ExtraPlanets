package com.mjr.extraplanets.moons.Callisto.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.moons.Callisto.worldgen.BiomeGenCallisto;

public class MapGenVillageCallisto extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenCallisto.callisto });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageCallisto.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageCallisto.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartCallisto.class, "CallistoVillage");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageField.class, "CallistoField1");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageField2.class, "CallistoField2");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageHouse.class, "CallistoHouse");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageRoadPiece.class, "CallistoRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillagePathGen.class, "CallistoPath");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageTorch.class, "CallistoTorch");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageStartPiece.class, "CallistoWell");
			MapGenStructureIO.func_143031_a(StructureComponentCallistoVillageWoodHut.class, "CallistoWoodHut");
		}
		MapGenVillageCallisto.initialized = true;
	}

	public MapGenVillageCallisto() {
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
		System.out.println("Generating Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartCallisto(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "CallistoVillage";
	}
}
