package com.mjr.extraplanets;

import net.minecraft.world.DimensionType;

import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Mercury.spacestation.WorldProviderMercuryOrbit;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.spacestation.WorldProviderNeptuneOrbit;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Pluto.spacestation.WorldProviderPlutoOrbit;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Saturn.spacestation.WorldProviderSaturnOrbit;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.planets.Uranus.spacestation.WorldProviderUranusOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;
import com.mjr.extraplanets.planets.venus.spacestation.WorldProviderVenusOrbit;

public class ExtraPlanetsDimensions {
	//Planets
	public static DimensionType CERES = DimensionType.register("Ceres", "ceres", Config.ceresID, WorldProviderCeres.class, false);
	public static DimensionType ERIS = DimensionType.register("Eris", "eris", Config.erisID, WorldProviderEris.class, false);
	public static DimensionType JUPITER = DimensionType.register("Jupiter", "jupiter", Config.jupiterID, WorldProviderJupiter.class, false);
	public static DimensionType MERCURY = DimensionType.register("Mercury", "mercury", Config.mercuryID, WorldProviderMercury.class, false);
	public static DimensionType NEPTUNE = DimensionType.register("Neptune", "neptune", Config.neptuneID, WorldProviderNeptune.class, false);
	public static DimensionType PLUTO = DimensionType.register("Pluto", "pluto", Config.plutoID, WorldProviderPluto.class, false);
	public static DimensionType SATURN = DimensionType.register("Saturn", "saturn", Config.saturnID, WorldProviderSaturn.class, false);
	public static DimensionType URANUS = DimensionType.register("Uranus", "uranus", Config.uranusID, WorldProviderUranus.class, false);
	public static DimensionType KEPLER22B = DimensionType.register("Kepler22b", "kepler22b", Config.kepler22bID, WorldProviderKepler22b.class, false);

	//Space Stations
	public static DimensionType CERES_ORBIT = DimensionType.register("Ceres Space Station", "_ceres_orbit", Config.ceresSpaceStationID, WorldProviderCeresOrbit.class, false);
	public static DimensionType ERIS_ORBIT = DimensionType.register("Eris Space Station", "_eris_orbit", Config.erisSpaceStationID, WorldProviderErisOrbit.class, false);
	public static DimensionType JUPITER_ORBIT = DimensionType.register("Jupiter Space Station", "_jupiter_orbit", Config.jupiterSpaceStationID, WorldProviderJupiterOrbit.class, false);
	public static DimensionType MERCURY_ORBIT = DimensionType.register("Mercury Space Station", "_mercury_orbit", Config.mercurySpaceStationID, WorldProviderMercuryOrbit.class, false);
	public static DimensionType NEPTUNE_ORBIT = DimensionType.register("Neptune Space Station", "_neptune_orbit", Config.neptuneSpaceStationID, WorldProviderNeptuneOrbit.class, false);
	public static DimensionType PLUTO_ORBIT = DimensionType.register("Pluto Space Station", "_pluto_orbit", Config.plutoSpaceStationID, WorldProviderPlutoOrbit.class, false);
	public static DimensionType SATURN_ORBIT = DimensionType.register("Saturn Space Station", "_saturn_orbit", Config.saturnSpaceStationID, WorldProviderSaturnOrbit.class, false);
	public static DimensionType URANUS_ORBIT = DimensionType.register("Uranus Space Station", "_uranus_orbit", Config.uranusSpaceStationID, WorldProviderUranusOrbit.class, false);
	//public static DimensionType KEPLER22B_ORBIT = DimensionType.register("Kepler22b Space Station", "orbit", Config.kepler22bSpaceStationID, WorldProviderKepler22bOrbit.class, false);
	public static DimensionType MARS_ORBIT = DimensionType.register("Mars Space Station", "_mars_orbit", Config.marsSpaceStationID, WorldProviderMarsOrbit.class, false);
	public static DimensionType VENUS_ORBIT = DimensionType.register("Venus Space Station", "_venus_orbit", Config.venusSpaceStationID, WorldProviderVenusOrbit.class, false);
}
