package com.mjr.extraplanets;

import net.minecraft.world.DimensionType;

import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;

public class ExtraPlanetsDimensions {
	public static DimensionType CERES = DimensionType.register("Ceres", "ceres", Config.ceresID, WorldProviderCeres.class, false);
	public static DimensionType ERIS = DimensionType.register("Eris", "eris", Config.erisID, WorldProviderEris.class, false);
	public static DimensionType JUPITER = DimensionType.register("Jupiter", "jupiter", Config.jupiterID, WorldProviderJupiter.class, false);
	public static DimensionType MERCURY = DimensionType.register("Mercury", "mercury", Config.mercuryID, WorldProviderMercury.class, false);
	public static DimensionType NEPTUNE = DimensionType.register("Neptune", "neptune", Config.neptuneID, WorldProviderNeptune.class, false);
	public static DimensionType PLUTO = DimensionType.register("Pluto", "pluto", Config.plutoID, WorldProviderPluto.class, false);
	public static DimensionType SATURN = DimensionType.register("Saturn", "saturn", Config.saturnID, WorldProviderSaturn.class, false);
	public static DimensionType URANUS = DimensionType.register("Uranus", "uranus", Config.uranusID, WorldProviderUranus.class, false);
	public static DimensionType KEPLER22B = DimensionType.register("Kepler22b", "kepler22b", Config.kepler22bID, WorldProviderKepler22b.class, false);

}
