package com.mjr.extraplanets.moons.Phobos.worldgen.village;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.WorldChunkManager;

public class StructureComponentPhobosVillageStartPiece extends StructureComponentPhobosVillageWell {
	public WorldChunkManager worldChunkMngr;
	public int terrainType;
	public StructureVillagePieceWeightPhobos structVillagePieceWeight;
	public ArrayList<StructureVillagePieceWeightPhobos> structureVillageWeightedPieceList;
	public ArrayList<Object> field_74932_i = new ArrayList<Object>();
	public ArrayList<Object> field_74930_j = new ArrayList<Object>();

	public StructureComponentPhobosVillageStartPiece() {
	}

	public StructureComponentPhobosVillageStartPiece(WorldChunkManager par1WorldChunkManager, int par2, Random par3Random, int par4, int par5, ArrayList<StructureVillagePieceWeightPhobos> par6ArrayList, int par7) {
		super((StructureComponentPhobosVillageStartPiece) null, 0, par3Random, par4, par5);
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
