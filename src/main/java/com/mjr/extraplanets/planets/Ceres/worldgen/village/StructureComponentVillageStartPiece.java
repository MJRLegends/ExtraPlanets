package com.mjr.extraplanets.planets.Ceres.worldgen.village;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.WorldChunkManager;

public class StructureComponentVillageStartPiece extends StructureComponentVillageWell {
	public WorldChunkManager biomeProvider;
	public int terrainType;
	public StructureVillagePieceWeightCeres structVillagePieceWeight;
	public ArrayList<StructureVillagePieceWeightCeres> structureVillageWeightedPieceList;
	public ArrayList<Object> field_74932_i = new ArrayList<Object>();
	public ArrayList<Object> field_74930_j = new ArrayList<Object>();

	public StructureComponentVillageStartPiece() {
	}

	public StructureComponentVillageStartPiece(WorldChunkManager biomeProvider, int par2, Random par3Random, int par4, int par5, ArrayList<StructureVillagePieceWeightCeres> par6ArrayList, int par7) {
		super((StructureComponentVillageStartPiece) null, 0, par3Random, par4, par5);
		this.biomeProvider = biomeProvider;
		this.structureVillageWeightedPieceList = par6ArrayList;
		this.terrainType = par7;
		this.startPiece = this;
	}

	@Override
	protected void writeStructureToNBT(NBTTagCompound nbt) {
		super.writeStructureToNBT(nbt);

		nbt.setInteger("TerrainType", this.terrainType);
	}

	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt) {
		super.readStructureFromNBT(nbt);

		this.terrainType = nbt.getInteger("TerrainType");
	}

	public WorldChunkManager getWorldChunkManager() {
		return this.biomeProvider;
	}
}
