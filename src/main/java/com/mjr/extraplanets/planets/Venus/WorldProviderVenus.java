package com.mjr.extraplanets.planets.Venus;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.planets.PlanetsMain;
import com.mjr.extraplanets.planets.Venus.worldgen.ChunkProviderVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.WorldChunkManagerVenus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVenus extends WorldProviderSpace implements
IGalacticraftWorldProvider, ISolarLevel {

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
		return ChunkProviderVenus.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerVenus.class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float f1 = this.worldObj.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}

		if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}

		return f2 * f2 * 0.75F;
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
		return 0.7D;
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
		return PlanetsMain.venus;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		if (isDaytime()) {
			return 100.0F;
		}
		return 50.0F;
	}

	@Override
	public float getWindLevel() {
		return 2.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 10.0D;
	}
}