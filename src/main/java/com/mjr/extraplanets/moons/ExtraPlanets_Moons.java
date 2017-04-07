package com.mjr.extraplanets.moons;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
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
	public static Moon triton;
	public static Moon callisto;
	public static Moon europa;
	public static Moon ganymede;
	public static Moon io;
	public static Moon deimos;
	public static Moon phobos;
	public static Moon iapetus;
	public static Moon rhea;
	public static Moon titan;
	public static Moon oberon;
	public static Moon titania;
	public static Moon charon;
	public static Moon nix;
	public static Moon hydra;
	public static Moon dysnomia;

	public static void init() {
		initializeMoons();
		registerMoons();
		initializeUnReachableMoons();
	}

	public static void initializeUnReachableMoons() {
		// Pluto Moons
		charon = RegisterHelper.registerUnreachableMoon("charon", ExtraPlanets_Planets.pluto);
		if (charon != null)
			charon.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(25.5785754286855436F);

		nix = RegisterHelper.registerUnreachableMoon("nix", ExtraPlanets_Planets.pluto);
		if (nix != null)
			nix.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(57.415456589452485548F);

		hydra = RegisterHelper.registerUnreachableMoon("hydra", ExtraPlanets_Planets.pluto);
		if (hydra != null)
			hydra.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F)).setRelativeOrbitTime(123.252594612756974F);

		// Eris Moons
		dysnomia = RegisterHelper.registerUnreachableMoon("dysnomia", ExtraPlanets_Planets.eris);
		if (dysnomia != null)
			dysnomia.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(25.5785754286855436F);
	}

	private static void initializeMoons() {
		if (Config.triton) {
			triton = new Moon("triton").setParentPlanet(ExtraPlanets_Planets.neptune);
			triton.setPhaseShift(2.436F);
			triton.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			triton.setRelativeOrbitTime(75.0F);
			triton.setTierRequired(7);
			triton.setRelativeSize(0.3867F);
			triton.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			triton.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/triton.png"));
			triton.setDimensionInfo(Config.tritonID, WorldProviderTriton.class);
		}
		if (Config.phobos) {
			phobos = new Moon("phobos").setParentPlanet(MarsModule.planetMars);
			phobos.setPhaseShift(2.436F);
			phobos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			phobos.setRelativeOrbitTime(25.5785754286855436F);
			phobos.setTierRequired(2);
			phobos.setRelativeSize(0.3867F);
			phobos.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			phobos.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/phobos.png"));
			phobos.setDimensionInfo(Config.phobosID, WorldProviderPhobos.class);
		}
		if (Config.deimos) {
			deimos = new Moon("deimos").setParentPlanet(MarsModule.planetMars);
			deimos.setPhaseShift(2.436F);
			deimos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			deimos.setRelativeOrbitTime(57.415456589452485548F);
			deimos.setTierRequired(2);
			deimos.setRelativeSize(0.3867F);
			deimos.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			deimos.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/deimos.png"));
			deimos.setDimensionInfo(Config.deimosID, WorldProviderDeimos.class);
		}
		if (Config.io) {
			io = new Moon("io").setParentPlanet(ExtraPlanets_Planets.jupiter);
			io.setPhaseShift(2.436F);
			io.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			io.setRelativeOrbitTime(43.59976842345364536F);
			io.setTierRequired(4);
			io.setRelativeSize(0.3867F);
			io.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			io.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/io.png"));
			io.setDimensionInfo(Config.ioID, WorldProviderIo.class);
		}
		if (Config.europa) {
			europa = new Moon("europa").setParentPlanet(ExtraPlanets_Planets.jupiter);
			europa.setPhaseShift(2.436F);
			europa.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			europa.setRelativeOrbitTime(87.55354354345685345F);
			europa.setTierRequired(4);
			europa.setRelativeSize(0.3867F);
			europa.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			europa.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/europa.png"));
			europa.setDimensionInfo(Config.europaID, WorldProviderEuropa.class);
		}

		if (Config.ganymede) {
			ganymede = new Moon("ganymede").setParentPlanet(ExtraPlanets_Planets.jupiter);
			ganymede.setPhaseShift(2.436F);
			ganymede.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F));
			ganymede.setRelativeOrbitTime(123.252594612756974F);
			ganymede.setTierRequired(4);
			ganymede.setRelativeSize(0.3867F);
			ganymede.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			ganymede.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/ganymede.png"));
			ganymede.setDimensionInfo(Config.ganymedeID, WorldProviderGanymede.class);
		}
		if (Config.callisto) {
			callisto = new Moon("callisto").setParentPlanet(ExtraPlanets_Planets.jupiter);
			callisto.setPhaseShift(2.436F);
			callisto.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(36F, 36F));
			callisto.setRelativeOrbitTime(157.84524858485412315F);
			callisto.setTierRequired(4);
			callisto.setRelativeSize(0.3867F);
			callisto.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			callisto.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/callisto.png"));
			callisto.setDimensionInfo(Config.callistoID, WorldProviderCallisto.class);
		}
		if (Config.rhea) {
			rhea = new Moon("rhea").setParentPlanet(ExtraPlanets_Planets.saturn);
			rhea.setPhaseShift(1.45F);
			rhea.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			rhea.setRelativeOrbitTime(42.74914745741246F);
			rhea.setTierRequired(5);
			rhea.setRelativeSize(0.3867F);
			rhea.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			rhea.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/rhea.png"));
			rhea.setDimensionInfo(Config.rheaID, WorldProviderRhea.class);
		}
		if (Config.titan) {
			titan = new Moon("titan").setParentPlanet(ExtraPlanets_Planets.saturn);
			titan.setPhaseShift(1.45F);
			titan.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			titan.setRelativeOrbitTime(71.452415154621642F);
			titan.setTierRequired(5);
			titan.setRelativeSize(0.3867F);
			titan.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			titan.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/titan.png"));
			titan.setDimensionInfo(Config.titanID, WorldProviderTitan.class);
		}
		if (Config.oberon) {
			oberon = new Moon("oberon").setParentPlanet(ExtraPlanets_Planets.uranus);
			oberon.setPhaseShift(1.45F);
			oberon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			oberon.setRelativeOrbitTime(68.5411941552618F);
			oberon.setTierRequired(6);
			oberon.setRelativeSize(0.3867F);
			oberon.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			oberon.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/oberon.png"));
			oberon.setDimensionInfo(Config.oberonID, WorldProviderOberon.class);
		}
		if (Config.titania) {
			titania = new Moon("titania").setParentPlanet(ExtraPlanets_Planets.uranus);
			titania.setPhaseShift(1.45F);
			titania.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			titania.setRelativeOrbitTime(68.5411941552618F);
			titania.setTierRequired(6);
			titania.setRelativeSize(0.3867F);
			titania.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			titania.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/titania.png"));
			titania.setDimensionInfo(Config.titaniaID, WorldProviderTitania.class);
		}
		if (Config.iapetus) {
			iapetus = new Moon("iapetus").setParentPlanet(ExtraPlanets_Planets.saturn);
			iapetus.setPhaseShift(1.45F);
			iapetus.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F));
			iapetus.setRelativeOrbitTime(68.5411941552618F);
			iapetus.setTierRequired(6);
			iapetus.setRelativeSize(0.3867F);
			iapetus.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			iapetus.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/iapetus.png"));
			iapetus.setDimensionInfo(Config.iapetusID, WorldProviderIapetus.class);
		}
	}

	private static void registerMoons() {
		if (Config.triton) {
			GalaxyRegistry.registerMoon(triton);
			GalacticraftRegistry.registerTeleportType(WorldProviderTriton.class, new TeleportTypeTriton());
			GalacticraftRegistry.registerRocketGui(WorldProviderTriton.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/tritonRocketGui.png"));
		}
		if (Config.europa) {
			GalaxyRegistry.registerMoon(europa);
			GalacticraftRegistry.registerTeleportType(WorldProviderEuropa.class, new TeleportTypeEuropa());
			GalacticraftRegistry.registerRocketGui(WorldProviderEuropa.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/europaRocketGui.png"));
		}
		if (Config.io) {
			GalaxyRegistry.registerMoon(io);
			GalacticraftRegistry.registerTeleportType(WorldProviderIo.class, new TeleportTypeIo());
			GalacticraftRegistry.registerRocketGui(WorldProviderIo.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/ioRocketGui.png"));
		}
		if (Config.deimos) {
			GalaxyRegistry.registerMoon(deimos);
			GalacticraftRegistry.registerTeleportType(WorldProviderDeimos.class, new TeleportTypeDeimos());
			GalacticraftRegistry.registerRocketGui(WorldProviderDeimos.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/deimosRocketGui.png"));
		}
		if (Config.phobos) {
			GalaxyRegistry.registerMoon(phobos);
			GalacticraftRegistry.registerTeleportType(WorldProviderPhobos.class, new TeleportTypePhobos());
			GalacticraftRegistry.registerRocketGui(WorldProviderPhobos.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/phobosRocketGui.png"));
		}
		if (Config.callisto) {
			GalaxyRegistry.registerMoon(callisto);
			GalacticraftRegistry.registerTeleportType(WorldProviderCallisto.class, new TeleportTypeCallisto());
			GalacticraftRegistry.registerRocketGui(WorldProviderCallisto.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/callistoRocketGui.png"));
		}
		if (Config.ganymede) {
			GalaxyRegistry.registerMoon(ganymede);
			GalacticraftRegistry.registerTeleportType(WorldProviderGanymede.class, new TeleportTypeGanymede());
			GalacticraftRegistry.registerRocketGui(WorldProviderGanymede.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/ganymedeRocketGui.png"));
		}
		if (Config.rhea) {
			GalaxyRegistry.registerMoon(rhea);
			GalacticraftRegistry.registerTeleportType(WorldProviderRhea.class, new TeleportTypeRhea());
			GalacticraftRegistry.registerRocketGui(WorldProviderRhea.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/rheaRocketGui.png"));
		}
		if (Config.titan) {
			GalaxyRegistry.registerMoon(titan);
			GalacticraftRegistry.registerTeleportType(WorldProviderTitan.class, new TeleportTypeTitan());
			GalacticraftRegistry.registerRocketGui(WorldProviderTitan.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/titanRocketGui.png"));
		}
		if (Config.oberon) {
			GalaxyRegistry.registerMoon(oberon);
			GalacticraftRegistry.registerTeleportType(WorldProviderOberon.class, new TeleportTypeOberon());
			GalacticraftRegistry.registerRocketGui(WorldProviderOberon.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/oberonRocketGui.png"));
		}
		if (Config.titania) {
			GalaxyRegistry.registerMoon(titania);
			GalacticraftRegistry.registerTeleportType(WorldProviderTitania.class, new TeleportTypeTitania());
			GalacticraftRegistry.registerRocketGui(WorldProviderTitania.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/titaniaRocketGui.png"));
		}
		if (Config.iapetus) {
			GalaxyRegistry.registerMoon(iapetus);
			GalacticraftRegistry.registerTeleportType(WorldProviderIapetus.class, new TeleportTypeIapetus());
			GalacticraftRegistry.registerRocketGui(WorldProviderIapetus.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/iapetusRocketGui.png"));
		}
	}
}
