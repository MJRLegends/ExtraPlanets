package com.mjr.extraplanets.planets.Mercury;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.api.IPressureWorld;
import com.mjr.extraplanets.api.ISolarRadiationWorld;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Mercury.worldgen.ChunkProviderMercury;
import com.mjr.extraplanets.planets.Mercury.worldgen.WorldChunkManagerMercury;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class WorldProviderMercury extends CustomWorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld, ISolarRadiationWorld {

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(119 / 255F * f, 119 / 255F * f, 119 / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(0 / 255.0F * f, 0 / 255.0F * f, 0 / 255.0F * f);
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
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderMercury.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerMercury.class;
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
		return 1.0D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 3;
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
		return ExtraPlanets_Planets.mercury;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		if (isDaytime()) {
			return 50.0F;
		}
		return -50.0F;
	}

	@Override
	public float getWindLevel() {
		return 0.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 12.0D;
	}

	@Override
	public String getDimensionName() {
		return "Mercury";
	}

	@Override
	public String getInternalNameSuffix() {
		return "_mercury";
	}

	@Override
	public int getPressureLevel() {
		return 20;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 100;
	}
	
	@Override
	public boolean shouldDisablePrecipitation() {
		return true;
	}

	@Override
	public boolean shouldCorrodeArmor() {
		return false;
	}
}