package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.util.ResourceLocation;

public class ExtraPlanets_SolarSystems {

	public static SolarSystem kepler22;
	public static SolarSystem kepler47;
	public static SolarSystem kepler62;
	public static SolarSystem kepler69;

	public static void init() {
		initializeSolarSystems();
		registerSolarSystems();
	}

	@SuppressWarnings("deprecation")
	private static void initializeSolarSystems() {
		if (Config.keplerSolarSystems) {
			kepler22 = new SolarSystem("kepler22", "milkyWay").setMapPosition(new Vector3(90.0F, 30.0F));
			Star starSol = (Star) new Star("kepler22").setParentSolarSystem(kepler22).setTierRequired(-1);
			starSol.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler22.setMainStar(starSol);

			kepler47 = new SolarSystem("kepler47", "milkyWay").setMapPosition(new Vector3(-40.0F, -120.0F));
			Star starSol2 = (Star) new Star("kepler47").setParentSolarSystem(kepler47).setTierRequired(-1);
			starSol2.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler47.setMainStar(starSol2);

			kepler62 = new SolarSystem("kepler62", "milkyWay").setMapPosition(new Vector3(90.0F, -90.0F));
			Star starSol3 = (Star) new Star("kepler62").setParentSolarSystem(kepler62).setTierRequired(-1);
			starSol3.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler62.setMainStar(starSol3);

			kepler69 = new SolarSystem("kepler69", "milkyWay").setMapPosition(new Vector3(-60.0F, 0.0F));
			Star starSol4 = (Star) new Star("kepler69").setParentSolarSystem(kepler69).setTierRequired(-1);
			starSol4.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler69.setMainStar(starSol4);
		}
	}

	private static void registerSolarSystems() {
		if (Config.keplerSolarSystems) {
			GalaxyRegistry.registerSolarSystem(kepler22);
			GalaxyRegistry.registerSolarSystem(kepler47);
			GalaxyRegistry.registerSolarSystem(kepler62);
			GalaxyRegistry.registerSolarSystem(kepler69);
		}
	}
}
