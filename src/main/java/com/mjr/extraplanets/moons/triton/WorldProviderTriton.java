package com.mjr.extraplanets.moons.triton;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.moons.MoonsMain;
import com.mjr.extraplanets.moons.triton.worldgen.ChunkProviderTriton;
import com.mjr.extraplanets.moons.triton.worldgen.WorldChunkManagerTriton;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderTriton extends WorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel {
    @Override
    public Vector3 getFogColor() {
	return new Vector3(0, 0, 0);
    }

    @Override
    public Vector3 getSkyColor() {
	return new Vector3(0, 0, 0);
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
	return 192000L;
    }

    @Override
    public boolean shouldForceRespawn() {
	return !ConfigManagerCore.forceOverworldRespawn;
    }

    @Override
    public Class<? extends IChunkProvider> getChunkProviderClass() {
	return ChunkProviderTriton.class;
    }

    @Override
    public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
	return WorldChunkManagerTriton.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1) {
	final float var2 = this.worldObj.getCelestialAngle(par1);
	float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

	if (var3 < 0.0F) {
	    var3 = 0.0F;
	}

	if (var3 > 1.0F) {
	    var3 = 1.0F;
	}

	return var3 * var3 * 0.5F + 0.3F;
    }

    @Override
    public boolean isSkyColored() {
	return false;
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
	return 0.062F;
    }

    @Override
    public double getMeteorFrequency() {
	return 7.0D;
    }

    @Override
    public double getFuelUsageMultiplier() {
	return 0.7D;
    }

    @Override
    public double getSolarEnergyMultiplier() {
	return 1.4D;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier) {
	return tier > 0;
    }

    @Override
    public float getFallDamageModifier() {
	return 0.18F;
    }

    @Override
    public float getSoundVolReductionAmount() {
	return 20.0F;
    }

    @Override
    public CelestialBody getCelestialBody() {
	return MoonsMain.triton;
    }

    @Override
    public boolean hasBreathableAtmosphere() {
	return false;
    }

    @Override
    public float getThermalLevelModifier() {
	return 0;
    }

    @Override
    public float getWindLevel() {
	return 0;
    }
}
