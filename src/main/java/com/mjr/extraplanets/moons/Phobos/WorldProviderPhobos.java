package com.mjr.extraplanets.moons.Phobos;

import java.util.LinkedList;
import java.util.List;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.api.prefabs.world.WorldProviderRealisticMoon;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.moons.Phobos.worldgen.ChunkProviderPhobos;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderPhobos extends WorldProviderRealisticMoon {
	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(168F / 255F * f, 164F / 255F * f, 160F / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(150 / 255.0F * f, 146 / 255.0F * f, 143 / 255.0F * f);
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
		return ChunkProviderPhobos.class;
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
		return 0.062F;
	}

	@Override
	public double getMeteorFrequency() {
		return 7.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 0.9D;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 3.0D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= ExtraPlanets_Moons.PHOBOS.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		return 0.18F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Moons.PHOBOS;
	}

	@Override
	public DimensionType getDimensionType() {
		return ExtraPlanetsDimensions.PHOBOS;
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
		list.add(ExtraPlanets_Blocks.PHOBOS_BLOCKS);
		return list;
	}

	@Override
	public int getPressureLevel() {
		return 90;
	}

	@Override
	public int getSolarRadiationLevel() {
		return Config.PHOBOS_RADIATION_AMOUNT;
	}
}
