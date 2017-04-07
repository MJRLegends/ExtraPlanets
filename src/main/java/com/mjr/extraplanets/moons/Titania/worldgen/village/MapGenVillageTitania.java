package com.mjr.extraplanets.moons.Titania.worldgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.moons.Titania.worldgen.BiomeGenTitania;

public class MapGenVillageTitania extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenTitania.titania });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageTitania.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageTitania.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartTitania.class, "TitaniaVillage");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageField.class, "TitaniaField1");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageField2.class, "TitaniaField2");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageHouse.class, "TitaniaHouse");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageRoadPiece.class, "TitaniaRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillagePathGen.class, "TitaniaPath");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageTorch.class, "TitaniaTorch");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageStartPiece.class, "TitaniaWell");
			MapGenStructureIO.func_143031_a(StructureComponentTitaniaVillageWoodHut.class, "TitaniaWoodHut");
		}
		MapGenVillageTitania.initialized = true;
	}

	public MapGenVillageTitania() {
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
		return new StructureVillageStartTitania(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "TitaniaVillage";
	}
}
