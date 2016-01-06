package com.mjr.extraplanets.moons.Io;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.moons.Io.worldgen.ChunkProviderIo;
import com.mjr.extraplanets.moons.Io.worldgen.WorldChunkManagerIo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderIo extends WorldProviderSpace implements
IGalacticraftWorldProvider, ISolarLevel {
	@Override
	public float getGravity() {
		return 0F;
	}

	@Override
	public double getMeteorFrequency() {
		return 0;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.0;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 4;
	}

	@Override
	public float getFallDamageModifier() {
		return 1;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 1;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		return -10;
	}

	@Override
	public float getWindLevel() {
		return 10.0F;
	}

	@Override
	public float getSolarSize() {
		return 1.0f;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Moons.io;
	}

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(247F / 255F * f, 215F / 255F * f, 72F / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(247 / 255.0F * f, 212 / 255.0F * f, 52 / 255.0F * f);
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
		return 24000;
	}

	@Override
	public boolean shouldForceRespawn() {
		return true;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderIo.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerIo.class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1)
	{
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
	public double getSolarEnergyMultiplier() {
		return 0.8D;
	}

}
