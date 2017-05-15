package com.mjr.extraplanets.planets.Pluto;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;

import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.api.IPressureWorld;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Pluto.worldgen.BiomeProviderPluto;
import com.mjr.extraplanets.planets.Pluto.worldgen.ChunkProviderPluto;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class WorldProviderPluto extends CustomWorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld {

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(182f / 255F * f, 182f / 255F * f, 182f / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(156f / 255.0F * f, 156f / 255.0F * f, 156f / 255.0F * f);
	}

	@Override
	public boolean canRainOrSnow() {
		return false;
	}

	@Override
	public boolean hasSunset() {
		return false;
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
		return ChunkProviderPluto.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		return BiomeProviderPluto.class;
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
		return 0.058F;
	}

	@Override
	public int getHeight() {
		return 800;
	}

	@Override
	public double getMeteorFrequency() {
		return 10.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.8D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= ExtraPlanets_Planets.PLUTO.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		return 0.38F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 10.0F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Planets.PLUTO;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		if (isDaytime()) {
			return -140.0F;
		}
		return -140.0F;
	}

	@Override
	public float getWindLevel() {
		return 5.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 2.0D;
	}

	@Override
	public int getPressureLevel() {
		return 8;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 12;
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
		return ExtraPlanetsDimensions.PLUTO;
	}

	@Override
	public int getDungeonSpacing() {
		return 800;
	}
}