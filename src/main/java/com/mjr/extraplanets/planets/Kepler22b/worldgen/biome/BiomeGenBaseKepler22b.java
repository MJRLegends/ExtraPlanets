package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseKepler22b extends BiomeGenBase {
	public static final BiomeGenBase kepler22bPlains = new BiomeGenKepler22bPlains().setBiomeName("Kepler22b Plains").setHeight(height_LowPlains);
	public static final BiomeGenBase kepler22bSea = (new BiomeGenKepler22bSea()).setColor(112).setBiomeName("Kepler22b Sea").setHeight(height_Oceans);

	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;

	public BiomeGenBaseKepler22b(int id) {
		super(id);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.rainfall = 0F;
		this.setColor(-16744448);
		this.enableRain = true;
		this.enableSnow = true;
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorKepler22b();
	}

	protected BiomeDecorator getBiomeDecorator() {
		return this.theBiomeDecorator;
	}

	@Override
	public boolean canSpawnLightningBolt() {
		return this.func_150559_j() ? false : this.enableRain;
	}

	@Override
	public BiomeGenBase setColor(int var1) {
		return super.setColor(var1);
	}

	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
}