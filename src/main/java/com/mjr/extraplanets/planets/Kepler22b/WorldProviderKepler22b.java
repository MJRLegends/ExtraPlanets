package com.mjr.extraplanets.planets.Kepler22b;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;

import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.api.IPressureWorld;
import com.mjr.extraplanets.api.ISolarRadiationWorld;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.BiomeProviderKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.ChunkProviderKepler22b;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class WorldProviderKepler22b extends CustomWorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld, ISolarRadiationWorld {

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(102 / 255.0F * f, 178 / 255.0F * f, 255 / 205.0F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(102 / 255.0F * f, 178 / 255.0F * f, 255 / 205.0F * f);
	}

	@Override
	public boolean canRainOrSnow() {
		return true;
	}

	@Override
	public boolean hasSunset() {
		return true;
	}

	@Override
	public long getDayLength() {
		return 24000L;
	}

	@Override
	public boolean shouldForceRespawn() {
		return true;
	}

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderKepler22b.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		return BiomeProviderKepler22b.class;
	}

	@Override
	public double getHorizon() {
		return 44.0D;
	}

	@Override
	public int getAverageGroundLevel() {
		return 44;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}

	@Override
	public float getGravity() {
		return 0.030F;
	}

	@Override
	public int getHeight() {
		return 800;
	}

	@Override
	public double getMeteorFrequency() {
		return 0.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.0D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= ExtraPlanets_Planets.kepler22b.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		return 0.95F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 5.0F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Planets.kepler22b;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return true;
	}

	@Override
	public float getThermalLevelModifier() {
		return 0F;
	}

	@Override
	public float getWindLevel() {
		return 3.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 8.0D;
	}

	@Override
	public int getPressureLevel() {
		return 0;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 0;
	}

	@Override
	public boolean shouldDisablePrecipitation() {
		return true;
	}

	@Override
	public boolean shouldCorrodeArmor() {
		return false;
	}

	@Override
	public DimensionType getDimensionType() {
		return ExtraPlanetsDimensions.KEPLER22B;
	}
}