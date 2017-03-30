package com.mjr.extraplanets;

import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;

import com.mjr.extraplanets.moons.Callisto.WorldProviderCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.BiomeGenCallisto;
import com.mjr.extraplanets.moons.Deimos.WorldProviderDeimos;
import com.mjr.extraplanets.moons.Deimos.worldgen.BiomeGenDeimos;
import com.mjr.extraplanets.moons.Europa.WorldProviderEuropa;
import com.mjr.extraplanets.moons.Europa.worldgen.BiomeGenEuropa;
import com.mjr.extraplanets.moons.Ganymede.WorldProviderGanymede;
import com.mjr.extraplanets.moons.Ganymede.worldgen.BiomeGenGanymede;
import com.mjr.extraplanets.moons.Iapetus.WorldProviderIapetus;
import com.mjr.extraplanets.moons.Iapetus.worldgen.BiomeGenIapetus;
import com.mjr.extraplanets.moons.Io.WorldProviderIo;
import com.mjr.extraplanets.moons.Io.worldgen.BiomeGenIo;
import com.mjr.extraplanets.moons.Oberon.WorldProviderOberon;
import com.mjr.extraplanets.moons.Oberon.worldgen.BiomeGenOberon;
import com.mjr.extraplanets.moons.Phobos.WorldProviderPhobos;
import com.mjr.extraplanets.moons.Phobos.worldgen.BiomeGenPhobos;
import com.mjr.extraplanets.moons.Rhea.WorldProviderRhea;
import com.mjr.extraplanets.moons.Rhea.worldgen.BiomeGenRhea;
import com.mjr.extraplanets.moons.Titan.WorldProviderTitan;
import com.mjr.extraplanets.moons.Titan.worldgen.BiomeGenTitan;
import com.mjr.extraplanets.moons.Titania.WorldProviderTitania;
import com.mjr.extraplanets.moons.Titania.worldgen.BiomeGenTitania;
import com.mjr.extraplanets.moons.Triton.WorldProviderTriton;
import com.mjr.extraplanets.moons.Triton.worldgen.BiomeGenTriton;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Ceres.worldgen.BiomeGenCeres;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Eris.worldgen.BiomeGenEris;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Jupiter.worldgen.BiomeGenJupiter;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.spacestation.WorldProviderKepler22bOrbit;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenBaseKepler22b;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Mercury.spacestation.WorldProviderMercuryOrbit;
import com.mjr.extraplanets.planets.Mercury.worldgen.BiomeGenMercury;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.spacestation.WorldProviderNeptuneOrbit;
import com.mjr.extraplanets.planets.Neptune.worldgen.BiomeGenNeptune;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Pluto.spacestation.WorldProviderPlutoOrbit;
import com.mjr.extraplanets.planets.Pluto.worldgen.BiomeGenPluto;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Saturn.spacestation.WorldProviderSaturnOrbit;
import com.mjr.extraplanets.planets.Saturn.worldgen.BiomeGenSaturn;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.planets.Uranus.spacestation.WorldProviderUranusOrbit;
import com.mjr.extraplanets.planets.Uranus.worldgen.BiomeGenUranus;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;
import com.mjr.extraplanets.planets.venus.spacestation.WorldProviderVenusOrbit;

public class ExtraPlanetsDimensions {
	// Planets
	public static DimensionType CERES = DimensionType.register("Ceres", "ceres", Config.ceresID, WorldProviderCeres.class, false);
	public static DimensionType ERIS = DimensionType.register("Eris", "eris", Config.erisID, WorldProviderEris.class, false);
	public static DimensionType JUPITER = DimensionType.register("Jupiter", "jupiter", Config.jupiterID, WorldProviderJupiter.class, false);
	public static DimensionType MERCURY = DimensionType.register("Mercury", "mercury", Config.mercuryID, WorldProviderMercury.class, false);
	public static DimensionType NEPTUNE = DimensionType.register("Neptune", "neptune", Config.neptuneID, WorldProviderNeptune.class, false);
	public static DimensionType PLUTO = DimensionType.register("Pluto", "pluto", Config.plutoID, WorldProviderPluto.class, false);
	public static DimensionType SATURN = DimensionType.register("Saturn", "saturn", Config.saturnID, WorldProviderSaturn.class, false);
	public static DimensionType URANUS = DimensionType.register("Uranus", "uranus", Config.uranusID, WorldProviderUranus.class, false);
	public static DimensionType KEPLER22B = DimensionType.register("Kepler22b", "kepler22b", Config.kepler22bID, WorldProviderKepler22b.class, false);

	// Moons
	public static DimensionType CALLISTO = DimensionType.register("Callisto", "callisto", Config.callistoID, WorldProviderCallisto.class, false);
	public static DimensionType DEIMOS = DimensionType.register("Deimos", "deimos", Config.deimosID, WorldProviderDeimos.class, false);
	public static DimensionType EUROPA = DimensionType.register("Europa", "europa", Config.europaID, WorldProviderEuropa.class, false);
	public static DimensionType GANYMEDE = DimensionType.register("Ganymede", "ganymede", Config.ganymedeID, WorldProviderGanymede.class, false);
	public static DimensionType IAPETUS = DimensionType.register("Iapetus", "iapetus", Config.iapetusID, WorldProviderIapetus.class, false);
	public static DimensionType IO = DimensionType.register("Io", "io", Config.ioID, WorldProviderIo.class, false);
	public static DimensionType OBERON = DimensionType.register("Oberon", "oberon", Config.oberonID, WorldProviderOberon.class, false);
	public static DimensionType PHOBOS = DimensionType.register("Phobos", "phobos", Config.phobosID, WorldProviderPhobos.class, false);
	public static DimensionType RHEA = DimensionType.register("Rhea", "rhea", Config.rheaID, WorldProviderRhea.class, false);
	public static DimensionType TITAN = DimensionType.register("Titan", "titan", Config.titanID, WorldProviderTitan.class, false);
	public static DimensionType TITANIA = DimensionType.register("Titania", "titania", Config.titaniaID, WorldProviderTitania.class, false);
	public static DimensionType TRITION = DimensionType.register("Triton", "triton", Config.tritonID, WorldProviderTriton.class, false);

	// Space Stations
	public static DimensionType CERES_ORBIT = DimensionType.register("Ceres Space Station", "_ceres_orbit", Config.ceresSpaceStationID, WorldProviderCeresOrbit.class, false);
	public static DimensionType ERIS_ORBIT = DimensionType.register("Eris Space Station", "_eris_orbit", Config.erisSpaceStationID, WorldProviderErisOrbit.class, false);
	public static DimensionType JUPITER_ORBIT = DimensionType.register("Jupiter Space Station", "_jupiter_orbit", Config.jupiterSpaceStationID, WorldProviderJupiterOrbit.class, false);
	public static DimensionType MERCURY_ORBIT = DimensionType.register("Mercury Space Station", "_mercury_orbit", Config.mercurySpaceStationID, WorldProviderMercuryOrbit.class, false);
	public static DimensionType NEPTUNE_ORBIT = DimensionType.register("Neptune Space Station", "_neptune_orbit", Config.neptuneSpaceStationID, WorldProviderNeptuneOrbit.class, false);
	public static DimensionType PLUTO_ORBIT = DimensionType.register("Pluto Space Station", "_pluto_orbit", Config.plutoSpaceStationID, WorldProviderPlutoOrbit.class, false);
	public static DimensionType SATURN_ORBIT = DimensionType.register("Saturn Space Station", "_saturn_orbit", Config.saturnSpaceStationID, WorldProviderSaturnOrbit.class, false);
	public static DimensionType URANUS_ORBIT = DimensionType.register("Uranus Space Station", "_uranus_orbit", Config.uranusSpaceStationID, WorldProviderUranusOrbit.class, false);
	public static DimensionType KEPLER22B_ORBIT = DimensionType.register("Kepler22b Space Station", "orbit", Config.kepler22bSpaceStationID, WorldProviderKepler22bOrbit.class, false);
	public static DimensionType MARS_ORBIT = DimensionType.register("Mars Space Station", "_mars_orbit", Config.marsSpaceStationID, WorldProviderMarsOrbit.class, false);
	public static DimensionType VENUS_ORBIT = DimensionType.register("Venus Space Station", "_venus_orbit", Config.venusSpaceStationID, WorldProviderVenusOrbit.class, false);
	
	public static void registerBiomes(){
		// Planets
		Biome.registerBiome(Config.mercuryBiomeID, BiomeGenMercury.mercury.getBiomeName(), BiomeGenMercury.mercury);
		Biome.registerBiome(Config.ceresBiomeID, BiomeGenCeres.ceres.getBiomeName(), BiomeGenCeres.ceres);
		Biome.registerBiome(Config.jupiterBiomeID, BiomeGenJupiter.jupiter.getBiomeName(), BiomeGenJupiter.jupiter);
		Biome.registerBiome(Config.saturnBiomeID, BiomeGenSaturn.saturn.getBiomeName(), BiomeGenSaturn.saturn);
		Biome.registerBiome(Config.uranusBiomeID, BiomeGenUranus.uranus.getBiomeName(), BiomeGenUranus.uranus);
		Biome.registerBiome(Config.neptuneBiomeID, BiomeGenNeptune.neptune.getBiomeName(), BiomeGenNeptune.neptune);
		Biome.registerBiome(Config.plutoBiomeID, BiomeGenPluto.pluto.getBiomeName(), BiomeGenPluto.pluto);
		Biome.registerBiome(Config.erisBiomeID, BiomeGenEris.eris.getBiomeName(), BiomeGenEris.eris);
		Biome.registerBiome(Config.tritonBiomeID, BiomeGenTriton.triton.getBiomeName(), BiomeGenTriton.triton);
		
		Biome.registerBiome(Config.kepler22bPlainsBiomeID, BiomeGenBaseKepler22b.kepler22bPlains.getBiomeName(), BiomeGenBaseKepler22b.kepler22bPlains);
		Biome.registerBiome(Config.kepler22bBlueForestBiomeID, BiomeGenBaseKepler22b.kepler22bBlueForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bBlueForest);
		Biome.registerBiome(Config.kepler22bRedForestBiomeID, BiomeGenBaseKepler22b.kepler22bRedForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bRedForest);
		Biome.registerBiome(Config.kepler22bPurpleForestBiomeID, BiomeGenBaseKepler22b.kepler22bPurpleForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bPurpleForest);
		Biome.registerBiome(Config.kepler22bYellowForestBiomeID, BiomeGenBaseKepler22b.kepler22bYellowForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bYellowForest);
		
		// Moons
		Biome.registerBiome(Config.callistoBiomeID, BiomeGenCallisto.callisto.getBiomeName(), BiomeGenCallisto.callisto);
		Biome.registerBiome(Config.deimosBiomeID, BiomeGenDeimos.deimos.getBiomeName(), BiomeGenDeimos.deimos);
		Biome.registerBiome(Config.europaBiomeID, BiomeGenEuropa.europa.getBiomeName(), BiomeGenEuropa.europa);
		Biome.registerBiome(Config.ganymedeBiomeID, BiomeGenGanymede.ganymede.getBiomeName(), BiomeGenGanymede.ganymede);
		Biome.registerBiome(Config.iapetusBiomeID, BiomeGenIapetus.iapetus.getBiomeName(), BiomeGenIapetus.iapetus);
		Biome.registerBiome(Config.ioBiomeID, BiomeGenIo.io.getBiomeName(), BiomeGenIo.io);
		Biome.registerBiome(Config.oberonBiomeID, BiomeGenOberon.oberon.getBiomeName(), BiomeGenOberon.oberon);
		Biome.registerBiome(Config.phobosBiomeID, BiomeGenPhobos.phobos.getBiomeName(), BiomeGenPhobos.phobos);
		Biome.registerBiome(Config.rheaBiomeID, BiomeGenRhea.rhea.getBiomeName(), BiomeGenRhea.rhea);
		Biome.registerBiome(Config.titanBiomeID, BiomeGenTitan.titan.getBiomeName(), BiomeGenTitan.titan);
		Biome.registerBiome(Config.titaniaBiomeID, BiomeGenTitania.titania.getBiomeName(), BiomeGenTitania.titania);
	}
}
