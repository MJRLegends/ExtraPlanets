package com.mjr.extraplanets.moons;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.moons.Callisto.TeleportTypeCallisto;
import com.mjr.extraplanets.moons.Callisto.WorldProviderCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.CallistoBiomes;
import com.mjr.extraplanets.moons.Deimos.TeleportTypeDeimos;
import com.mjr.extraplanets.moons.Deimos.WorldProviderDeimos;
import com.mjr.extraplanets.moons.Deimos.worldgen.DeimosBiomes;
import com.mjr.extraplanets.moons.Europa.TeleportTypeEuropa;
import com.mjr.extraplanets.moons.Europa.WorldProviderEuropa;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;
import com.mjr.extraplanets.moons.Ganymede.TeleportTypeGanymede;
import com.mjr.extraplanets.moons.Ganymede.WorldProviderGanymede;
import com.mjr.extraplanets.moons.Ganymede.worldgen.GanymedeBiomes;
import com.mjr.extraplanets.moons.Iapetus.TeleportTypeIapetus;
import com.mjr.extraplanets.moons.Iapetus.WorldProviderIapetus;
import com.mjr.extraplanets.moons.Iapetus.worldgen.IapetusBiomes;
import com.mjr.extraplanets.moons.Io.TeleportTypeIo;
import com.mjr.extraplanets.moons.Io.WorldProviderIo;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;
import com.mjr.extraplanets.moons.Oberon.TeleportTypeOberon;
import com.mjr.extraplanets.moons.Oberon.WorldProviderOberon;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;
import com.mjr.extraplanets.moons.Phobos.TeleportTypePhobos;
import com.mjr.extraplanets.moons.Phobos.WorldProviderPhobos;
import com.mjr.extraplanets.moons.Phobos.worldgen.PhobosBiomes;
import com.mjr.extraplanets.moons.Rhea.TeleportTypeRhea;
import com.mjr.extraplanets.moons.Rhea.WorldProviderRhea;
import com.mjr.extraplanets.moons.Rhea.worldgen.RheaBiomes;
import com.mjr.extraplanets.moons.Titan.TeleportTypeTitan;
import com.mjr.extraplanets.moons.Titan.WorldProviderTitan;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;
import com.mjr.extraplanets.moons.Titania.TeleportTypeTitania;
import com.mjr.extraplanets.moons.Titania.WorldProviderTitania;
import com.mjr.extraplanets.moons.Titania.worldgen.TitaniaBiomes;
import com.mjr.extraplanets.moons.Triton.TeleportTypeTriton;
import com.mjr.extraplanets.moons.Triton.WorldProviderTriton;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.util.GCRegisterUtilities;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.entities.*;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

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
		if(Config.GENERATE_UNREACHABLEMOONS) {
			// Pluto Moons
			CHARON = GCRegisterUtilities.registerUnreachableMoon("charon", ExtraPlanets_Planets.PLUTO);
			if (CHARON != null)
				CHARON.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(25.5785754286855436F);

			NIX = GCRegisterUtilities.registerUnreachableMoon("nix", ExtraPlanets_Planets.PLUTO);
			if (NIX != null)
				NIX.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(57.415456589452485548F);

			HYDRA = GCRegisterUtilities.registerUnreachableMoon("hydra", ExtraPlanets_Planets.PLUTO);
			if (HYDRA != null)
				HYDRA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F)).setRelativeOrbitTime(123.252594612756974F);

			// Eris Moons
			DYSNOMIA = GCRegisterUtilities.registerUnreachableMoon("dysnomia", ExtraPlanets_Planets.ERIS);
			if (DYSNOMIA != null)
				DYSNOMIA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(25.5785754286855436F);
		}
	}

	private static Planet getParentPlanet(Planet possiablePlanet, String possiablePlanetName) {
		if(possiablePlanet != null)
			return possiablePlanet;
		else {
			for (Planet planet : GalaxyRegistry.getRegisteredPlanets().values()) {
				String planetName = planet.getUnlocalizedName().substring(planet.getUnlocalizedName().indexOf(".") + 1);
				if (planetName.equalsIgnoreCase(possiablePlanetName))
					return planet;
			}
		}
		return null;
	}

	private static void initializeMoons() {
		if (Config.TRITON) {
			TRITON = new Moon("triton").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.NEPTUNE, "Neptune"));
			TRITON.setPhaseShift(2.436F);
			TRITON.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			TRITON.setRelativeOrbitTime(75.0F);
			TRITON.setTierRequired(7);
			TRITON.setRelativeSize(0.3867F);
			TRITON.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			TRITON.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/triton.png"));
			TRITON.setDimensionInfo(Config.TRITON_ID, WorldProviderTriton.class);
			TRITON.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? -140.0F : 5.0F, 0.0F, 0.2F));
			TRITON.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			TRITON.setBiomeInfo(TritonBiomes.triton, TritonBiomes.tritonIceLands, TritonBiomes.tritonIceSea);
			TRITON.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			TRITON.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			TRITON.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			TRITON.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			TRITON.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.PHOBOS) {
			PHOBOS = new Moon("phobos").setParentPlanet(MarsModule.planetMars);
			PHOBOS.setPhaseShift(2.436F);
			PHOBOS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			PHOBOS.setRelativeOrbitTime(25.5785754286855436F);
			PHOBOS.setTierRequired(2);
			PHOBOS.setRelativeSize(0.3867F);
			PHOBOS.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			PHOBOS.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/phobos.png"));
			PHOBOS.setDimensionInfo(Config.PHOBOS_ID, WorldProviderPhobos.class);
			PHOBOS.setAtmosphere(new AtmosphereInfo(false, false, false, -1.0F, 0.0F, 0.2F));
			PHOBOS.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			PHOBOS.setBiomeInfo(PhobosBiomes.phobos);
			PHOBOS.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			PHOBOS.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			PHOBOS.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			PHOBOS.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			PHOBOS.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.DEIMOS) {
			DEIMOS = new Moon("deimos").setParentPlanet(MarsModule.planetMars);
			DEIMOS.setPhaseShift(2.436F);
			DEIMOS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			DEIMOS.setRelativeOrbitTime(57.415456589452485548F);
			DEIMOS.setTierRequired(2);
			DEIMOS.setRelativeSize(0.3867F);
			DEIMOS.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			DEIMOS.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/deimos.png"));
			DEIMOS.setDimensionInfo(Config.DEIMOS_ID, WorldProviderDeimos.class);
			DEIMOS.setAtmosphere(new AtmosphereInfo(false, false, false, -1.0F, 0.0F, 0.2F));
			DEIMOS.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			DEIMOS.setBiomeInfo(DeimosBiomes.deimos);
			DEIMOS.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			DEIMOS.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			DEIMOS.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			DEIMOS.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			DEIMOS.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.IO) {
			IO = new Moon("io").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.JUPITER, "Jupiter"));
			IO.setPhaseShift(2.436F);
			IO.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			IO.setRelativeOrbitTime(43.59976842345364536F);
			IO.setTierRequired(4);
			IO.setRelativeSize(0.3867F);
			IO.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			IO.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/io.png"));
			IO.setDimensionInfo(Config.IO_ID, WorldProviderIo.class);
			IO.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 100.0F : 5.0F, 0.0F, 0.2F));
			IO.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			IO.setBiomeInfo(IoBiomes.io, IoBiomes.ioAshLands, IoBiomes.ioBurningPlains);
			IO.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			IO.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			IO.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			IO.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			IO.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.EUROPA) {
			EUROPA = new Moon("europa").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.JUPITER, "Jupiter"));
			EUROPA.setPhaseShift(2.436F);
			EUROPA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			EUROPA.setRelativeOrbitTime(87.55354354345685345F);
			EUROPA.setTierRequired(4);
			EUROPA.setRelativeSize(0.3867F);
			EUROPA.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			EUROPA.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/europa.png"));
			EUROPA.setDimensionInfo(Config.EUROPA_ID, WorldProviderEuropa.class);
			EUROPA.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 100.0F : 5.0F, 0.0F, 0.2F));
			EUROPA.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			EUROPA.setBiomeInfo(EuropaBiomes.europa, EuropaBiomes.europaIceValleys, EuropaBiomes.europaSaltSea);
			EUROPA.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			EUROPA.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			EUROPA.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			EUROPA.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			EUROPA.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}

		if (Config.GANYMEDE) {
			GANYMEDE = new Moon("ganymede").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.JUPITER, "Jupiter"));
			GANYMEDE.setPhaseShift(2.436F);
			GANYMEDE.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F));
			GANYMEDE.setRelativeOrbitTime(123.252594612756974F);
			GANYMEDE.setTierRequired(4);
			GANYMEDE.setRelativeSize(0.3867F);
			GANYMEDE.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			GANYMEDE.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/ganymede.png"));
			GANYMEDE.setDimensionInfo(Config.GANYMEDE_ID, WorldProviderGanymede.class);
			GANYMEDE.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 100.0F : 5.0F, 0.0F, 0.2F));
			GANYMEDE.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			GANYMEDE.setBiomeInfo(GanymedeBiomes.ganymede);
			GANYMEDE.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			GANYMEDE.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			GANYMEDE.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			GANYMEDE.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			GANYMEDE.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.CALLISTO) {
			CALLISTO = new Moon("callisto").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.JUPITER, "Jupiter"));
			CALLISTO.setPhaseShift(2.436F);
			CALLISTO.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(36F, 36F));
			CALLISTO.setRelativeOrbitTime(157.84524858485412315F);
			CALLISTO.setTierRequired(4);
			CALLISTO.setRelativeSize(0.3867F);
			CALLISTO.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			CALLISTO.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/callisto.png"));
			CALLISTO.setDimensionInfo(Config.CALLISTO_ID, WorldProviderCallisto.class);
			CALLISTO.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 100.0F : 5.0F, 0.0F, 0.2F));
			CALLISTO.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			CALLISTO.setBiomeInfo(CallistoBiomes.callisto, CallistoBiomes.callistoShaleSmallMountains, CallistoBiomes.callistoShaleLargeMountains, CallistoBiomes.callistoSaltSea);
			CALLISTO.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			CALLISTO.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			CALLISTO.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			CALLISTO.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			CALLISTO.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.RHEA) {
			RHEA = new Moon("rhea").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.SATURN, "Saturn"));
			RHEA.setPhaseShift(1.45F);
			RHEA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			RHEA.setRelativeOrbitTime(42.74914745741246F);
			RHEA.setTierRequired(5);
			RHEA.setRelativeSize(0.3867F);
			RHEA.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			RHEA.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/rhea.png"));
			RHEA.setDimensionInfo(Config.RHEA_ID, WorldProviderRhea.class);
			RHEA.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 80.0F : 5.0F, 0.0F, 0.2F));
			RHEA.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			RHEA.setBiomeInfo(RheaBiomes.rhea);
			RHEA.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			RHEA.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			RHEA.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			RHEA.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			RHEA.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.TITAN) {
			TITAN = new Moon("titan").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.SATURN, "Saturn"));
			TITAN.setPhaseShift(1.45F);
			TITAN.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			TITAN.setRelativeOrbitTime(71.452415154621642F);
			TITAN.setTierRequired(5);
			TITAN.setRelativeSize(0.3867F);
			TITAN.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			TITAN.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/titan.png"));
			TITAN.setDimensionInfo(Config.TITAN_ID, WorldProviderTitan.class);
			TITAN.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 80.0F : 5.0F, 0.0F, 0.2F));
			TITAN.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			TITAN.setBiomeInfo(TitanBiomes.titan);
			TITAN.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			TITAN.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			TITAN.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			TITAN.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			TITAN.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.IAPETUS) {
			IAPETUS = new Moon("iapetus").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.SATURN, "Saturn"));
			IAPETUS.setPhaseShift(1.45F);
			IAPETUS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F));
			IAPETUS.setRelativeOrbitTime(68.5411941552618F);
			IAPETUS.setTierRequired(6);
			IAPETUS.setRelativeSize(0.3867F);
			IAPETUS.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			IAPETUS.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/iapetus.png"));
			IAPETUS.setDimensionInfo(Config.IAPETUS_ID, WorldProviderIapetus.class);
			IAPETUS.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 40.0F : 5.0F, 4.0F, 0.1F));
			IAPETUS.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			IAPETUS.setBiomeInfo(IapetusBiomes.iapetus);
			IAPETUS.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			IAPETUS.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			IAPETUS.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			IAPETUS.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			IAPETUS.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.OBERON) {
			OBERON = new Moon("oberon").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.URANUS, "Uranus"));
			OBERON.setPhaseShift(1.45F);
			OBERON.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
			OBERON.setRelativeOrbitTime(68.5411941552618F);
			OBERON.setTierRequired(6);
			OBERON.setRelativeSize(0.3867F);
			OBERON.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			OBERON.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/oberon.png"));
			OBERON.setDimensionInfo(Config.OBERON_ID, WorldProviderOberon.class);
			OBERON.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? -120.0F : 5.0F, 4.0F, 0.1F));
			OBERON.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			OBERON.setBiomeInfo(OberonBiomes.oberon);
			OBERON.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			OBERON.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			OBERON.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			OBERON.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			OBERON.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.TITANIA) {
			TITANIA = new Moon("titania").setParentPlanet(getParentPlanet(ExtraPlanets_Planets.URANUS, "Uranus"));
			TITANIA.setPhaseShift(1.45F);
			TITANIA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
			TITANIA.setRelativeOrbitTime(68.5411941552618F);
			TITANIA.setTierRequired(6);
			TITANIA.setRelativeSize(0.3867F);
			TITANIA.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			TITANIA.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/titania.png"));
			TITANIA.setDimensionInfo(Config.TITANIA_ID, WorldProviderTitania.class);
			TITANIA.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? -120.0F : 5.0F, 4.0F, 0.1F));
			TITANIA.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equip_oxygen_suit", "equip_parachute");
			TITANIA.setBiomeInfo(TitaniaBiomes.titania);
			TITANIA.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			TITANIA.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			TITANIA.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			TITANIA.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			TITANIA.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
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
	
	public static boolean isExtraPlanetsMoon(CelestialBody body) {
		if (body == TRITON || body == CALLISTO || body == EUROPA || body == GANYMEDE || body == IO || body == DEIMOS || body == PHOBOS || body == IAPETUS || body == RHEA || body == TITAN || body == OBERON || body == TITANIA)
			return true;
		else
			return false;

	}

	public static List<String> getMaterialsListForMoon(CelestialBody body) {
		List<String> mats = new ArrayList<String>();
		if (body == TRITON) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
			mats.add("Liquid Nitrongen Ice: Medium");
			mats.add("Frozen Nitrogen: Very High");
			mats.add("Ice: Very High");
			mats.add("Snow: Medium");
		} 
		else if (body == CALLISTO) {
			mats.add("Copper: High");
			mats.add("Tin: High");
			mats.add("Iron: Medium");
			mats.add("Crystallized Water: Very High");
		}
		else if (body == EUROPA) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: High");
			mats.add("Ice: Very High");
			mats.add("Dense Ice: High");
			mats.add("Crystallized Water: Very High");
			mats.add("Radio Active Water: Low");
		}
		else if (body == GANYMEDE) {
			mats.add("Copper: High");
			mats.add("Tin: High");
			mats.add("Iron: Medium");
			mats.add("Ice: Very High");
			mats.add("Infected Water: Low");
		}
		else if (body == IO) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
			mats.add("Magma: Very High");
			mats.add("Ash: Very High");
			mats.add("Volcanic Rock: Very High");
		}
		else if (body == DEIMOS) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
		}
		else if (body == PHOBOS) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
		}
		else if (body == IAPETUS) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
			mats.add("Iapetus Ice: Very High");
		}
		else if (body == RHEA) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
		}
		else if (body == TITAN) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
			mats.add("Liquid Methane: Very High");
			mats.add("Titan Rocks: High");
		}
		else if (body == OBERON) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
			mats.add("Ice: Very High");
			mats.add("Dense Ice: Very High");
			mats.add("Lava: Medium");
		}
		else if (body == TITANIA) {
			mats.add("Copper: Medium");
			mats.add("Tin: Medium");
			mats.add("Iron: Medium");
		}
		return mats;
	}
}
