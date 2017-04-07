package com.mjr.extraplanets.moons.Titania.worldgen.village;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.WorldChunkManager;

public class StructureComponentTitaniaVillageStartPiece extends StructureComponentTitaniaVillageWell {
	public WorldChunkManager worldChunkMngr;
	public int terrainType;
	public StructureVillagePieceWeightTitania structVillagePieceWeight;
	public ArrayList<StructureVillagePieceWeightTitania> structureVillageWeightedPieceList;
	public ArrayList<Object> field_74932_i = new ArrayList<Object>();
	public ArrayList<Object> field_74930_j = new ArrayList<Object>();

	public StructureComponentTitaniaVillageStartPiece() {
	}

	public StructureComponentTitaniaVillageStartPiece(WorldChunkManager par1WorldChunkManager, int par2, Random par3Random, int par4, int par5, ArrayList<StructureVillagePieceWeightTitania> par6ArrayList, int par7) {
		super((StructureComponentTitaniaVillageStartPiece) null, 0, par3Random, par4, par5);
		this.worldChunkMngr = par1WorldChunkManager;
		this.structureVillageWeightedPieceList = par6ArrayList;
		this.terrainType = par7;
		this.startPiece = this;
	}

	@Override
	protected void func_143012_a(NBTTagCompound nbt) {
		super.func_143012_a(nbt);

		nbt.setInteger("TerrainType", this.terrainType);
	}

	@Override
	protected void func_143011_b(NBTTagCompound nbt) {
		super.func_143011_b(nbt);

		this.terrainType = nbt.getInteger("TerrainType");
	}

	public WorldChunkManager getWorldChunkManager() {
		return this.worldChunkMngr;
	}
}
