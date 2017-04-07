package com.mjr.extraplanets;

import net.minecraft.world.DimensionType;

import com.mjr.extraplanets.moons.Callisto.WorldProviderCallisto;
import com.mjr.extraplanets.moons.Deimos.WorldProviderDeimos;
import com.mjr.extraplanets.moons.Europa.WorldProviderEuropa;
import com.mjr.extraplanets.moons.Ganymede.WorldProviderGanymede;
import com.mjr.extraplanets.moons.Iapetus.WorldProviderIapetus;
import com.mjr.extraplanets.moons.Io.WorldProviderIo;
import com.mjr.extraplanets.moons.Oberon.WorldProviderOberon;
import com.mjr.extraplanets.moons.Phobos.WorldProviderPhobos;
import com.mjr.extraplanets.moons.Rhea.WorldProviderRhea;
import com.mjr.extraplanets.moons.Titan.WorldProviderTitan;
import com.mjr.extraplanets.moons.Titania.WorldProviderTitania;
import com.mjr.extraplanets.moons.Triton.WorldProviderTriton;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.spacestation.WorldProviderKepler22bOrbit;
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
	// Planets
	public static DimensionType CERES = DimensionType.register("Ceres", "ceres", Config.CERES_ID, WorldProviderCeres.class, false);
	public static DimensionType ERIS = DimensionType.register("Eris", "eris", Config.ERIS_ID, WorldProviderEris.class, false);
	public static DimensionType JUPITER = DimensionType.register("Jupiter", "jupiter", Config.JUPITER_ID, WorldProviderJupiter.class, false);
	public static DimensionType MERCURY = DimensionType.register("Mercury", "mercury", Config.MERCURY_ID, WorldProviderMercury.class, false);
	public static DimensionType NEPTUNE = DimensionType.register("Neptune", "neptune", Config.NEPTUNE_ID, WorldProviderNeptune.class, false);
	public static DimensionType PLUTO = DimensionType.register("Pluto", "pluto", Config.PLUTO_ID, WorldProviderPluto.class, false);
	public static DimensionType SATURN = DimensionType.register("Saturn", "saturn", Config.SATURN_ID, WorldProviderSaturn.class, false);
	public static DimensionType URANUS = DimensionType.register("Uranus", "uranus", Config.URANUS_ID, WorldProviderUranus.class, false);
	public static DimensionType KEPLER22B = DimensionType.register("Kepler22b", "kepler22b", Config.KEPLER22B_ID, WorldProviderKepler22b.class, false);

	// Moons
	public static DimensionType CALLISTO = DimensionType.register("Callisto", "callisto", Config.CALLISTO_ID, WorldProviderCallisto.class, false);
	public static DimensionType DEIMOS = DimensionType.register("Deimos", "deimos", Config.DEIMOS_ID, WorldProviderDeimos.class, false);
	public static DimensionType EUROPA = DimensionType.register("Europa", "europa", Config.EUROPA_ID, WorldProviderEuropa.class, false);
	public static DimensionType GANYMEDE = DimensionType.register("Ganymede", "ganymede", Config.GANYMEDE_ID, WorldProviderGanymede.class, false);
	public static DimensionType IAPETUS = DimensionType.register("Iapetus", "iapetus", Config.IAPETUS_ID, WorldProviderIapetus.class, false);
	public static DimensionType IO = DimensionType.register("Io", "io", Config.IO_ID, WorldProviderIo.class, false);
	public static DimensionType OBERON = DimensionType.register("Oberon", "oberon", Config.OBERON_ID, WorldProviderOberon.class, false);
	public static DimensionType PHOBOS = DimensionType.register("Phobos", "phobos", Config.PHOBOS_ID, WorldProviderPhobos.class, false);
	public static DimensionType RHEA = DimensionType.register("Rhea", "rhea", Config.RHEA_ID, WorldProviderRhea.class, false);
	public static DimensionType TITAN = DimensionType.register("Titan", "titan", Config.TITAN_ID, WorldProviderTitan.class, false);
	public static DimensionType TITANIA = DimensionType.register("Titania", "titania", Config.TITANIA_ID, WorldProviderTitania.class, false);
	public static DimensionType TRITION = DimensionType.register("Triton", "triton", Config.TRITON_ID, WorldProviderTriton.class, false);

	// Space Stations
	public static DimensionType CERES_ORBIT = DimensionType.register("Ceres Space Station", "_ceres_orbit", Config.CERES_SPACE_STATION_ID, WorldProviderCeresOrbit.class, false);
	public static DimensionType ERIS_ORBIT = DimensionType.register("Eris Space Station", "_eris_orbit", Config.ERIS_SPACE_STATION_ID, WorldProviderErisOrbit.class, false);
	public static DimensionType JUPITER_ORBIT = DimensionType.register("Jupiter Space Station", "_jupiter_orbit", Config.JUPITER_SPACE_STATION_ID, WorldProviderJupiterOrbit.class, false);
	public static DimensionType MERCURY_ORBIT = DimensionType.register("Mercury Space Station", "_mercury_orbit", Config.MERCURY_SPACE_STATION_ID, WorldProviderMercuryOrbit.class, false);
	public static DimensionType NEPTUNE_ORBIT = DimensionType.register("Neptune Space Station", "_neptune_orbit", Config.NEPTUNE_SPACE_STATION_ID, WorldProviderNeptuneOrbit.class, false);
	public static DimensionType PLUTO_ORBIT = DimensionType.register("Pluto Space Station", "_pluto_orbit", Config.PLUTO_SPACE_STATION_ID, WorldProviderPlutoOrbit.class, false);
	public static DimensionType SATURN_ORBIT = DimensionType.register("Saturn Space Station", "_saturn_orbit", Config.SATURN_SPACE_STATION_ID, WorldProviderSaturnOrbit.class, false);
	public static DimensionType URANUS_ORBIT = DimensionType.register("Uranus Space Station", "_uranus_orbit", Config.URANUS_SPACE_STATION_ID, WorldProviderUranusOrbit.class, false);
	public static DimensionType KEPLER22B_ORBIT = DimensionType.register("Kepler22b Space Station", "orbit", Config.KEPLER22B_SPACE_STATION_ID, WorldProviderKepler22bOrbit.class, false);
	public static DimensionType MARS_ORBIT = DimensionType.register("Mars Space Station", "_mars_orbit", Config.MARS_SPACE_STATION_ID, WorldProviderMarsOrbit.class, false);
	public static DimensionType VENUS_ORBIT = DimensionType.register("Venus Space Station", "_venus_orbit", Config.VENUS_SPACE_STATION_ID, WorldProviderVenusOrbit.class, false);
}
