package com.mjr.extraplanets.api.prefabs.world;

import com.mjr.extraplanets.api.world.IPressureWorld;
import com.mjr.extraplanets.api.world.ISolarRadiationWorld;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;

public abstract class WorldProviderRealisticSpace extends WorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel, IPressureWorld, ISolarRadiationWorld {

	@Override
	public abstract int getPressureLevel();

	@Override
	public abstract int getSolarRadiationLevel();
}
