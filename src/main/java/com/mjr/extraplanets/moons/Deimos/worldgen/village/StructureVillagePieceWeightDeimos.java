package com.mjr.extraplanets.moons.Deimos.worldgen.village;

public class StructureVillagePieceWeightDeimos {
	public Class<? extends StructureComponentDeimosVillage> villagePieceClass;
	public final int villagePieceWeight;
	public int villagePiecesSpawned;
	public int villagePiecesLimit;

	public StructureVillagePieceWeightDeimos(Class<? extends StructureComponentDeimosVillage> par1Class, int par2, int par3) {
		this.villagePieceClass = par1Class;
		this.villagePieceWeight = par2;
		this.villagePiecesLimit = (int) (par3 / 1.5D);
	}

	public boolean canSpawnMoreVillagePiecesOfType(int par1) {
		return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
	}

	public boolean canSpawnMoreVillagePieces() {
		return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
	}
}
