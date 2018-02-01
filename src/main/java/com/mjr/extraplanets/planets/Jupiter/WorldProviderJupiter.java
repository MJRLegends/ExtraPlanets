package com.mjr.extraplanets.planets.Jupiter;

import java.util.LinkedList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomTreasure;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Jupiter.worldgen.BiomeProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.ChunkProviderJupiter;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;
import com.mjr.mjrlegendslib.util.MCUtilities;

public class WorldProviderJupiter extends WorldProviderRealisticSpace {

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
		return 9550L;
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
		if (Config.THERMAL_PADDINGS) {
			if (MCUtilities.isServer() && isDaytime()) {
				return 100.0F;
			}
			return 90.0F;
		}
		return 5.0F;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 4.0D;
	}

	@Override
	public int getPressureLevel() {
		return 2;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 45;
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

	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(ExtraPlanets_Blocks.JUPITER_BLOCKS);
		list.add(ExtraPlanets_Blocks.RED_SAND);
		list.add(ExtraPlanets_Blocks.ORANGE_SAND);
		list.add(ExtraPlanets_Blocks.ORANGE_SANDSTONE);
		return list;
	}
}