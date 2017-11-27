package com.mjr.extraplanets.moons.Titan.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.moons.Titan.worldgen.biomes.BiomeGenTitan;

public class MapGenVillageTitan extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenTitan.titan });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageTitan.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageTitan.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartTitan.class, "TitanVillage");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageField.class, "TitanField1");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageField2.class, "TitanField2");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageHouse.class, "TitanHouse");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageRoadPiece.class, "TitanRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillagePathGen.class, "TitanPath");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageTorch.class, "TitanTorch");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageStartPiece.class, "TitanWell");
			MapGenStructureIO.func_143031_a(StructureComponentTitanVillageWoodHut.class, "TitanWoodHut");
		}
		MapGenVillageTitan.initialized = true;
	}

	public MapGenVillageTitan() {
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
		return new StructureVillageStartTitan(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "TitanVillage";
	}
}
