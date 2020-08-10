package com.mjr.extraplanets.api.prefabs.world;

import micdoodle8.mods.galacticraft.api.galaxies.Moon;

public abstract class WorldProviderRealisticMoon extends WorldProviderRealisticSpace{
	
	@Override
    public float getSolarSize()
    {
        return 1.0F / ((Moon)this.getCelestialBody()).getParentPlanet().getRelativeDistanceFromCenter().unScaledDistance;
    }

}
