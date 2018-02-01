package com.mjr.extraplanets.moons.Rhea;

import java.util.LinkedList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.moons.Rhea.worldgen.BiomeProviderRhea;
import com.mjr.extraplanets.moons.Rhea.worldgen.ChunkProviderRhea;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;
import com.mjr.mjrlegendslib.util.MCUtilities;

public class WorldProviderRhea extends WorldProviderRealisticSpace {
	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(192F / 255F * f, 192F / 255F * f, 192F / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(190 / 255.0F * f, 195 / 255.0F * f, 255 / 255.0F * f);
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
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderRhea.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		return BiomeProviderRhea.class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		final float var2 = this.world.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * Constants.twoPI) * 2.0F + 0.25F);

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
		if (Config.OLD_STYLE_GRAVITY)
			return 0.062F;
		else
			return 0.015F;
	}

	@Override
	public double getMeteorFrequency() {
		return 7.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.2D;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 3.5D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= ExtraPlanets_Moons.RHEA.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		if (Config.OLD_STYLE_GRAVITY)
			return 0.18F;
		else
			return 2.1F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Moons.RHEA;
	}

	@Override
	public float getThermalLevelModifier() {
		if (MCUtilities.isServer() && isDaytime()) {
			return 80.0F;
		}
		return 70.0F;
	}

	@Override
	public int getPressureLevel() {
		return 100;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 30;
	}

	@Override
	public DimensionType getDimensionType() {
		return ExtraPlanetsDimensions.RHEA;
	}

	@Override
	public int getDungeonSpacing() {
		return 0;
	}

	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(ExtraPlanets_Blocks.RHEA_BLOCKS);
		return list;
	}
}
