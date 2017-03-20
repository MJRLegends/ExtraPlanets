package com.mjr.extraplanets.moons.Oberon.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.moons.Oberon.worldgen.BiomeGenOberon;

public class MapGenVillageOberon extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenOberon.oberon });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageOberon.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageOberon.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartOberon.class, "OberonVillage");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageField.class, "OberonField1");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageField2.class, "OberonField2");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageHouse.class, "OberonHouse");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageRoadPiece.class, "OberonRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillagePathGen.class, "OberonPath");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageTorch.class, "OberonTorch");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageStartPiece.class, "OberonWell");
			MapGenStructureIO.func_143031_a(StructureComponentOberonVillageWoodHut.class, "OberonWoodHut");
		}
		MapGenVillageOberon.initialized = true;
	}

	public MapGenVillageOberon() {
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
		return new StructureVillageStartOberon(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "OberonVillage";
	}
}
