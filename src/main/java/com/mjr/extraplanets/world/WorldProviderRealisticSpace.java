package com.mjr.extraplanets.world;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;

public abstract class WorldProviderRealisticSpace extends WorldProviderSpace {

	public abstract int getPressureLevel();

	public abstract int getSolarRadiationLevel();
}
