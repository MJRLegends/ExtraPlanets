package com.mjr.extraplanets.planets.Pluto;

import java.util.LinkedList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomChest;
import net.minecraft.block.Block;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.Pluto.worldgen.ChunkProviderPluto;
import com.mjr.extraplanets.planets.Pluto.worldgen.WorldChunkManagerPluto;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;

public class WorldProviderPluto extends WorldProviderRealisticSpace {

	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(182f / 255F * f, 182f / 255F * f, 182f / 255F * f);
	}

	@Override
	public Vector3 getSkyColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(156f / 255.0F * f, 156f / 255.0F * f, 156f / 255.0F * f);
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		return 90000L;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderPluto.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerPluto.class;
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
			return 0.065F;
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
		return 1.8D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= ExtraPlanets_Planets.PLUTO.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		return 0.38F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_Planets.PLUTO;
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return 1.0D;
	}

	@Override
	public int getPressureLevel() {
		return 8;
	}

	@Override
	public int getSolarRadiationLevel() {
		return 30;
	}

	@Override
	public int getDungeonSpacing() {
		return 800;
	}

	@Override
	public String getDungeonChestType() {
		return RoomChest.MOONCHEST;
	}

	@Override
	public String getInternalNameSuffix() {
		return "pluto";
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(ExtraPlanets_Blocks.PLUTO_BLOCKS);
		return list;
	}
}