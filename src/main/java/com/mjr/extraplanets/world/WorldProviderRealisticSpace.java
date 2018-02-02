package com.mjr.extraplanets.world;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;

import com.mjr.extraplanets.api.IPressureWorld;
import com.mjr.extraplanets.api.ISolarRadiationWorld;

public abstract class WorldProviderRealisticSpace extends WorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld, ISolarRadiationWorld {

	@Override
	public abstract int getPressureLevel();

	@Override
	public abstract int getSolarRadiationLevel();
}
