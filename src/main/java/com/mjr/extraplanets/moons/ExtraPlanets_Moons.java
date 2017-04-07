package com.mjr.extraplanets.moons;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.moons.Callisto.TeleportTypeCallisto;
import com.mjr.extraplanets.moons.Callisto.WorldProviderCallisto;
import com.mjr.extraplanets.moons.Deimos.TeleportTypeDeimos;
import com.mjr.extraplanets.moons.Deimos.WorldProviderDeimos;
import com.mjr.extraplanets.moons.Europa.TeleportTypeEuropa;
import com.mjr.extraplanets.moons.Europa.WorldProviderEuropa;
import com.mjr.extraplanets.moons.Ganymede.TeleportTypeGanymede;
import com.mjr.extraplanets.moons.Ganymede.WorldProviderGanymede;
import com.mjr.extraplanets.moons.Iapetus.TeleportTypeIapetus;
import com.mjr.extraplanets.moons.Iapetus.WorldProviderIapetus;
import com.mjr.extraplanets.moons.Io.TeleportTypeIo;
import com.mjr.extraplanets.moons.Io.WorldProviderIo;
import com.mjr.extraplanets.moons.Oberon.TeleportTypeOberon;
import com.mjr.extraplanets.moons.Oberon.WorldProviderOberon;
import com.mjr.extraplanets.moons.Phobos.TeleportTypePhobos;
import com.mjr.extraplanets.moons.Phobos.WorldProviderPhobos;
import com.mjr.extraplanets.moons.Rhea.TeleportTypeRhea;
import com.mjr.extraplanets.moons.Rhea.WorldProviderRhea;
import com.mjr.extraplanets.moons.Titan.TeleportTypeTitan;
import com.mjr.extraplanets.moons.Titan.WorldProviderTitan;
import com.mjr.extraplanets.moons.Titania.TeleportTypeTitania;
import com.mjr.extraplanets.moons.Titania.WorldProviderTitania;
import com.mjr.extraplanets.moons.Triton.TeleportTypeTriton;
import com.mjr.extraplanets.moons.Triton.WorldProviderTriton;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.util.RegisterHelper;

public class ExtraPlanets_Moons {

	public static Moon TRITON;
	public static Moon CALLISTO;
	public static Moon EUROPA;
	public static Moon GANYMEDE;
	public static Moon IO;
	public static Moon DEIMOS;
	public static Moon PHOBOS;
	public static Moon IAPETUS;
	public static Moon RHEA;
	public static Moon TITAN;
	public static Moon OBERON;
	public static Moon TITANIA;
	public static Moon CHARON;
	public static Moon NIX;
	public static Moon HYDRA;
	public static Moon DYSNOMIA;

	public static void init() {
		initializeMoons();
		registerMoons();
		initializeUnReachableMoons();
	}

	public static void initializeUnReachableMoons() {
		// Pluto Moons
		CHARON = RegisterHelper.registerUnreachableMoon("charon", ExtraPlanets_Planets.PLUTO);
		if (CHARON != null)
			CHARON.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(25.5785754286855436F);

		NIX = RegisterHelper.registerUnreachableMoon("nix", ExtraPlanets_Planets.PLUTO);
		if (NIX != null)
			NIX.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(57.415456589452485548F);

		HYDRA = RegisterHelper.registerUnreachableMoon("hydra", ExtraPlanets_Planets.PLUTO);
		if (HYDRA != null)
			HYDRA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F)).setRelativeOrbitTime(123.252594612756974F);

		// Eris Moons
		DYSNOMIA = RegisterHelper.registerUnreachableMoon("dysnomia", ExtraPlanets_Planets.ERIS);
		if (DYSNOMIA != null)
			DYSNOMIA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(25.5785754286855436F);
	}

	private static void initializeMoons() {
		if (Config.TRITON) {
			TRITON = new Moon("triton").setParentPlanet(ExtraPlanets_Planets.NEPTUNE);
			TRITON.setPhaseShift(2.436F);
			TRITON.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			TRITON.setRelativeOrbitTime(75.0F);
			TRITON.setTierRequired(7);
			TRITON.setRelativeSize(0.3867F);
			TRITON.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			TRITON.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/triton.png"));
			TRITON.setDimensionInfo(Config.TRITON_ID, WorldProviderTriton.class);
		}
		if (Config.PHOBOS) {
			PHOBOS = new Moon("phobos").setParentPlanet(MarsModule.planetMars);
			PHOBOS.setPhaseShift(2.436F);
			PHOBOS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			PHOBOS.setRelativeOrbitTime(25.5785754286855436F);
			PHOBOS.setTierRequired(2);
			PHOBOS.setRelativeSize(0.3867F);
			PHOBOS.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			PHOBOS.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/phobos.png"));
			PHOBOS.setDimensionInfo(Config.PHOBOS_ID, WorldProviderPhobos.class);
		}
		if (Config.DEIMOS) {
			DEIMOS = new Moon("deimos").setParentPlanet(MarsModule.planetMars);
			DEIMOS.setPhaseShift(2.436F);
			DEIMOS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			DEIMOS.setRelativeOrbitTime(57.415456589452485548F);
			DEIMOS.setTierRequired(2);
			DEIMOS.setRelativeSize(0.3867F);
			DEIMOS.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			DEIMOS.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/deimos.png"));
			DEIMOS.setDimensionInfo(Config.DEIMOS_ID, WorldProviderDeimos.class);
		}
		if (Config.IO) {
			IO = new Moon("io").setParentPlanet(ExtraPlanets_Planets.JUPITER);
			IO.setPhaseShift(2.436F);
			IO.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			IO.setRelativeOrbitTime(43.59976842345364536F);
			IO.setTierRequired(4);
			IO.setRelativeSize(0.3867F);
			IO.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			IO.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/io.png"));
			IO.setDimensionInfo(Config.IO_ID, WorldProviderIo.class);
		}
		if (Config.EUROPA) {
			EUROPA = new Moon("europa").setParentPlanet(ExtraPlanets_Planets.JUPITER);
			EUROPA.setPhaseShift(2.436F);
			EUROPA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			EUROPA.setRelativeOrbitTime(87.55354354345685345F);
			EUROPA.setTierRequired(4);
			EUROPA.setRelativeSize(0.3867F);
			EUROPA.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			EUROPA.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/europa.png"));
			EUROPA.setDimensionInfo(Config.EUROPA_ID, WorldProviderEuropa.class);
		}

		if (Config.GANYMEDE) {
			GANYMEDE = new Moon("ganymede").setParentPlanet(ExtraPlanets_Planets.JUPITER);
			GANYMEDE.setPhaseShift(2.436F);
			GANYMEDE.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F));
			GANYMEDE.setRelativeOrbitTime(123.252594612756974F);
			GANYMEDE.setTierRequired(4);
			GANYMEDE.setRelativeSize(0.3867F);
			GANYMEDE.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			GANYMEDE.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/ganymede.png"));
			GANYMEDE.setDimensionInfo(Config.GANYMEDE_ID, WorldProviderGanymede.class);
		}
		if (Config.CALLISTO) {
			CALLISTO = new Moon("callisto").setParentPlanet(ExtraPlanets_Planets.JUPITER);
			CALLISTO.setPhaseShift(2.436F);
			CALLISTO.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(36F, 36F));
			CALLISTO.setRelativeOrbitTime(157.84524858485412315F);
			CALLISTO.setTierRequired(4);
			CALLISTO.setRelativeSize(0.3867F);
			CALLISTO.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			CALLISTO.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/callisto.png"));
			CALLISTO.setDimensionInfo(Config.CALLISTO_ID, WorldProviderCallisto.class);
		}
		if (Config.RHEA) {
			RHEA = new Moon("rhea").setParentPlanet(ExtraPlanets_Planets.SATURN);
			RHEA.setPhaseShift(1.45F);
			RHEA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			RHEA.setRelativeOrbitTime(42.74914745741246F);
			RHEA.setTierRequired(5);
			RHEA.setRelativeSize(0.3867F);
			RHEA.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			RHEA.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/rhea.png"));
			RHEA.setDimensionInfo(Config.RHEA_ID, WorldProviderRhea.class);
		}
		if (Config.TITAN) {
			TITAN = new Moon("titan").setParentPlanet(ExtraPlanets_Planets.SATURN);
			TITAN.setPhaseShift(1.45F);
			TITAN.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			TITAN.setRelativeOrbitTime(71.452415154621642F);
			TITAN.setTierRequired(5);
			TITAN.setRelativeSize(0.3867F);
			TITAN.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			TITAN.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/titan.png"));
			TITAN.setDimensionInfo(Config.TITAN_ID, WorldProviderTitan.class);
		}
		if (Config.OBERON) {
			OBERON = new Moon("oberon").setParentPlanet(ExtraPlanets_Planets.URANUS);
			OBERON.setPhaseShift(1.45F);
			OBERON.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			OBERON.setRelativeOrbitTime(68.5411941552618F);
			OBERON.setTierRequired(6);
			OBERON.setRelativeSize(0.3867F);
			OBERON.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			OBERON.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/oberon.png"));
			OBERON.setDimensionInfo(Config.OBERON_ID, WorldProviderOberon.class);
		}
		if (Config.TITANIA) {
			TITANIA = new Moon("titania").setParentPlanet(ExtraPlanets_Planets.URANUS);
			TITANIA.setPhaseShift(1.45F);
			TITANIA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			TITANIA.setRelativeOrbitTime(68.5411941552618F);
			TITANIA.setTierRequired(6);
			TITANIA.setRelativeSize(0.3867F);
			TITANIA.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			TITANIA.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/titania.png"));
			TITANIA.setDimensionInfo(Config.TITANIA_ID, WorldProviderTitania.class);
		}
		if (Config.IAPETUS) {
			IAPETUS = new Moon("iapetus").setParentPlanet(ExtraPlanets_Planets.SATURN);
			IAPETUS.setPhaseShift(1.45F);
			IAPETUS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F));
			IAPETUS.setRelativeOrbitTime(68.5411941552618F);
			IAPETUS.setTierRequired(6);
			IAPETUS.setRelativeSize(0.3867F);
			IAPETUS.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			IAPETUS.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/iapetus.png"));
			IAPETUS.setDimensionInfo(Config.IAPETUS_ID, WorldProviderIapetus.class);
		}
	}

	private static void registerMoons() {
		if (Config.TRITON) {
			GalaxyRegistry.registerMoon(TRITON);
			GalacticraftRegistry.registerTeleportType(WorldProviderTriton.class, new TeleportTypeTriton());
			GalacticraftRegistry.registerRocketGui(WorldProviderTriton.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/triton_rocket_gui.png"));
		}
		if (Config.EUROPA) {
			GalaxyRegistry.registerMoon(EUROPA);
			GalacticraftRegistry.registerTeleportType(WorldProviderEuropa.class, new TeleportTypeEuropa());
			GalacticraftRegistry.registerRocketGui(WorldProviderEuropa.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/europa_rocket_gui.png"));
		}
		if (Config.IO) {
			GalaxyRegistry.registerMoon(IO);
			GalacticraftRegistry.registerTeleportType(WorldProviderIo.class, new TeleportTypeIo());
			GalacticraftRegistry.registerRocketGui(WorldProviderIo.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/io_rocket_gui.png"));
		}
		if (Config.DEIMOS) {
			GalaxyRegistry.registerMoon(DEIMOS);
			GalacticraftRegistry.registerTeleportType(WorldProviderDeimos.class, new TeleportTypeDeimos());
			GalacticraftRegistry.registerRocketGui(WorldProviderDeimos.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/deimos_rocket_gui.png"));
		}
		if (Config.PHOBOS) {
			GalaxyRegistry.registerMoon(PHOBOS);
			GalacticraftRegistry.registerTeleportType(WorldProviderPhobos.class, new TeleportTypePhobos());
			GalacticraftRegistry.registerRocketGui(WorldProviderPhobos.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/phobos_rocket_gui.png"));
		}
		if (Config.CALLISTO) {
			GalaxyRegistry.registerMoon(CALLISTO);
			GalacticraftRegistry.registerTeleportType(WorldProviderCallisto.class, new TeleportTypeCallisto());
			GalacticraftRegistry.registerRocketGui(WorldProviderCallisto.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/callisto_rocket_gui.png"));
		}
		if (Config.GANYMEDE) {
			GalaxyRegistry.registerMoon(GANYMEDE);
			GalacticraftRegistry.registerTeleportType(WorldProviderGanymede.class, new TeleportTypeGanymede());
			GalacticraftRegistry.registerRocketGui(WorldProviderGanymede.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/ganymede_rocket_gui.png"));
		}
		if (Config.RHEA) {
			GalaxyRegistry.registerMoon(RHEA);
			GalacticraftRegistry.registerTeleportType(WorldProviderRhea.class, new TeleportTypeRhea());
			GalacticraftRegistry.registerRocketGui(WorldProviderRhea.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/rhea_rocket_gui.png"));
		}
		if (Config.TITAN) {
			GalaxyRegistry.registerMoon(TITAN);
			GalacticraftRegistry.registerTeleportType(WorldProviderTitan.class, new TeleportTypeTitan());
			GalacticraftRegistry.registerRocketGui(WorldProviderTitan.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/titan_rocket_gui.png"));
		}
		if (Config.OBERON) {
			GalaxyRegistry.registerMoon(OBERON);
			GalacticraftRegistry.registerTeleportType(WorldProviderOberon.class, new TeleportTypeOberon());
			GalacticraftRegistry.registerRocketGui(WorldProviderOberon.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/oberon_rocket_gui.png"));
		}
		if (Config.TITANIA) {
			GalaxyRegistry.registerMoon(TITANIA);
			GalacticraftRegistry.registerTeleportType(WorldProviderTitania.class, new TeleportTypeTitania());
			GalacticraftRegistry.registerRocketGui(WorldProviderTitania.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/titania_rocket_gui.png"));
		}
		if (Config.IAPETUS) {
			GalaxyRegistry.registerMoon(IAPETUS);
			GalacticraftRegistry.registerTeleportType(WorldProviderIapetus.class, new TeleportTypeIapetus());
			GalacticraftRegistry.registerRocketGui(WorldProviderIapetus.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/iapetus_rocket_gui.png"));
		}
	}
}
