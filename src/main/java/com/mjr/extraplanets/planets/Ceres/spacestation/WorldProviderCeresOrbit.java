package com.mjr.extraplanets.planets.Ceres.spacestation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanetsDimensions;
import com.mjr.extraplanets.api.prefabs.client.SkyProviderCustomOrbit;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.ExtraPlanets_SpaceStations;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOverworldOrbit;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.world.gen.ChunkProviderOrbit;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderCeresOrbit extends WorldProviderOverworldOrbit {
	@Override
	public CelestialBody getCelestialBody() {
		return ExtraPlanets_SpaceStations.CERES_SPACE_STATION;
	}

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
		return 24000L;
	}

	@Override
	public boolean shouldForceRespawn() {
		return true;
	}

	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderOrbit.class;
	}

	@Override
	public boolean isDaytime() {
		final float a = this.worldObj.getCelestialAngle(0F);
		return a < 0.42F || a > 0.58F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		final float var2 = this.worldObj.getCelestialAngle(par1);
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
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}

	@Override
	public float getGravity() {
		return 0.073F;// 0.073F;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public double getMeteorFrequency() {
		return 0;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.0D;
	}

	@Override
	public String getPlanetToOrbit() {
		return "planet.Ceres";
	}
	
	@Override
	public int getPlanetIdToOrbit() {
		return Config.CERES_ID;
	}


	@Override
	public int getYCoordToTeleportToPlanet() {
		return Constants.SPACE_STATION_LOWER_Y_LIMIT;
	}

	@Override
	public String getSaveFolder() {
		return "DIM_SPACESTATION_Ceres_" + this.getDimension();
	}

	@Override
	public double getSolarEnergyMultiplier() {
		return ConfigManagerCore.spaceStationEnergyScalar;
	}

	@Override
	public double getYCoordinateToTeleport() {
		return Constants.SPACE_STATION_HIGHER_Y_LIMIT;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier > ExtraPlanets_Planets.CERES.getTierRequirement();
	}

	@Override
	public float getFallDamageModifier() {
		return 0.4F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 50.0F;
	}

	@Override
	public float getThermalLevelModifier() {
		return 0;
	}

	@Override
	public float getWindLevel() {
		return 0.1F;
	}

	@Override
	public DimensionType getDimensionType() {
		return ExtraPlanetsDimensions.CERES_ORBIT;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void setSpinDeltaPerTick(float angle)
    {
		SkyProviderCustomOrbit skyProvider = ((SkyProviderCustomOrbit)this.getSkyRenderer());
		if (skyProvider != null)
			skyProvider.spinDeltaPerTick = angle;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getSkyRotation() {
		SkyProviderCustomOrbit skyProvider = ((SkyProviderCustomOrbit) this.getSkyRenderer());
		return skyProvider.spinAngle;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void createSkyProvider()
    {
        this.setSkyRenderer(new SkyProviderCustomOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"), false, true, getSunSize()));
        this.setSpinDeltaPerTick(this.getSpinManager().getSpinRate());
        
        if (this.getCloudRenderer() == null)
            this.setCloudRenderer(new CloudRenderer());
    }
    
    public static float getSunSize() {
    	return 17.5F * (1.0F / ExtraPlanets_Planets.CERES.getRelativeDistanceFromCenter().unScaledDistance);
    }
}