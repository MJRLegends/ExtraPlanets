package com.mjr.extraplanets.planets.Mercury;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.PlanetsMain;
import com.mjr.extraplanets.planets.Mercury.worldgen.ChunkProviderMercury;
import com.mjr.extraplanets.planets.Mercury.worldgen.WorldChunkManagerMercury;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderMercury extends WorldProviderSpace implements
IGalacticraftWorldProvider, ISolarLevel {

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
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1) {
	float f1 = this.worldObj.getCelestialAngle(par1);
	float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

	if (f2 < 0.0F) {
	    f2 = 1.0F;
	}

	if (f2 > 1.0F) {
	    f2 = 1.0F;
	}

	return f2 * f2 * 0.7F;
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
	return tier >= Config.mercuryRocketTier;
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
	return PlanetsMain.mercury;
    }

    @Override
    public boolean hasBreathableAtmosphere() {
	return false;
    }

    @Override
    public float getThermalLevelModifier() {
	if (isDaytime()) {
	    return 150.0F;
	}
	return 100.0F;
    }

    @Override
    public float getWindLevel() {
	return 0.0F;
    }

    @Override
    public double getSolarEnergyMultiplier() {
	return 12.0D;
    }
}