package com.mjr.extraplanets.planets.Jupiter;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomTreasure;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.api.IPressureWorld;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Jupiter.worldgen.BiomeProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.ChunkProviderJupiter;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class WorldProviderJupiter extends CustomWorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld {

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(250 / 255F * f, 192 / 255F * f, 115 / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(240 / 255.0F * f, 160 / 255.0F * f, 55 / 255.0F * f);
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
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderJupiter.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		return BiomeProviderJupiter.class;
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
		if (Config.OLD_STYLE_GRAVITY)
			return 0.058F;
		else
			return 0.015F;
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
		return tier >= ExtraPlanets_Planets.JUPITER.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		if (Config.OLD_STYLE_GRAVITY)
			return 0.38F;
		else
			return 2.1F;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Planets.JUPITER;
	}

	@Override
	public float getThermalLevelModifier() {
		if (isDaytime()) {
			return 100.0F;
		}
		return 90.0F;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 8.0D;
	}

	@Override
	public int getPressureLevel() {
		return 2;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 35;
	}

	@Override
	public DimensionType getDimensionType() {
		return ExtraPlanetsDimensions.JUPITER;
	}

	@Override
	public int getDungeonSpacing() {
		return 800;
	}

	@Override
	public ResourceLocation getDungeonChestType() {
        return RoomTreasure.MOONCHEST;
	}
}