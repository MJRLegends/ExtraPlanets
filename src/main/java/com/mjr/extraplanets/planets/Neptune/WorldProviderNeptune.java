package com.mjr.extraplanets.planets.Neptune;

import java.util.LinkedList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomTreasure;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.api.IPressureWorld;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Neptune.worldgen.BiomeProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.ChunkProviderNeptune;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;
import com.mjr.mjrlegendslib.util.MCUtilities;

public class WorldProviderNeptune extends WorldProviderRealisticSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld {

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(100f / 255F * f, 210f / 255F * f, 222f / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(24f / 255.0F * f, 154f / 255.0F * f, 253f / 255.0F * f);
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		return 16660L;
	}

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderNeptune.class;
	}

	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		return BiomeProviderNeptune.class;
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
			return 0.010F;
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
		return 1.6D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= ExtraPlanets_Planets.NEPTUNE.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		if (Config.OLD_STYLE_GRAVITY)
			return 0.38F;
		else
			return 3.2F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Planets.NEPTUNE;
	}

	@Override
	public float getThermalLevelModifier() {
		if (Config.THERMAL_PADDINGS) {
			if (MCUtilities.isServer() && isDaytime()) {
				return -140.0F;
			}
			return -130.0F;
		}
		return 5.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 2.0D;
	}

	@Override
	public int getPressureLevel() {
		return 100;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 42;
	}

	@Override
	public DimensionType getDimensionType() {
		return ExtraPlanetsDimensions.NEPTUNE;
	}

	@Override
	public int getDungeonSpacing() {
		return 800;
	}

	@Override
	public ResourceLocation getDungeonChestType() {
		return RoomTreasure.MOONCHEST;
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(ExtraPlanets_Blocks.NEPTUNE_BLOCKS);
		list.add(ExtraPlanets_Blocks.DECORATIVE_BLOCKS2);
		return list;
	}
}