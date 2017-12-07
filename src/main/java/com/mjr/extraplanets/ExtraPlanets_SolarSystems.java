package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.ResourceLocation;

public class ExtraPlanets_SolarSystems {

	public static SolarSystem kepler22;
	public static SolarSystem kepler47;
	public static SolarSystem kepler62;
	public static SolarSystem kepler69;
	public static SolarSystem test;

	public static void init() {
		initializeSolarSystems();
		registerSolarSystems();
	}

	private static void initializeSolarSystems() {
		if (Config.KEPLER_SOLAR_SYSTEMS) {
			kepler22 = new SolarSystem("kepler22", "milky_way").setMapPosition(new Vector3(0.60F + Config.KEPLER22_SYSTEM_X_OFFSET, 0.0F, 0.30F + Config.KEPLER22_SYSTEM_Z_OFFSET));
			Star starSol = (Star) new Star("kepler22").setParentSolarSystem(kepler22).setTierRequired(-1);
			starSol.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler22.setMainStar(starSol);

			kepler47 = new SolarSystem("kepler47", "milky_way").setMapPosition(new Vector3(-0.40F + Config.KEPLER47_SYSTEM_X_OFFSET, 0.0F, -0.80F + Config.KEPLER47_SYSTEM_Z_OFFSET));
			Star starSol2 = (Star) new Star("kepler47").setParentSolarSystem(kepler47).setTierRequired(-1);
			starSol2.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler47.setMainStar(starSol2);

			kepler62 = new SolarSystem("kepler62", "milky_way").setMapPosition(new Vector3(1.0F + Config.KEPLER62_SYSTEM_X_OFFSET, 0.0F, -1.0F + Config.KEPLER62_SYSTEM_Z_OFFSET));
			Star starSol3 = (Star) new Star("kepler62").setParentSolarSystem(kepler62).setTierRequired(-1);
			starSol3.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler62.setMainStar(starSol3);

			kepler69 = new SolarSystem("kepler69", "milky_way").setMapPosition(new Vector3(-0.90F + Config.KEPLER69_SYSTEM_X_OFFSET, 0.0F, 0.0F + Config.KEPLER69_SYSTEM_Z_OFFSET));
			Star starSol4 = (Star) new Star("kepler69").setParentSolarSystem(kepler69).setTierRequired(-1);
			starSol4.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler69.setMainStar(starSol4);
		}
		
		test = new SolarSystem("test", "whirlpool").setMapPosition(new Vector3(0F, 0.0F, 0.0F));
		Star starSol5 = (Star) new Star("test").setParentSolarSystem(test).setTierRequired(-1);
		starSol5.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
		test.setMainStar(starSol5);
	}

	private static void registerSolarSystems() {
		if (Config.KEPLER_SOLAR_SYSTEMS) {
			GalaxyRegistry.registerSolarSystem(kepler22);
			GalaxyRegistry.registerSolarSystem(kepler47);
			GalaxyRegistry.registerSolarSystem(kepler62);
			GalaxyRegistry.registerSolarSystem(kepler69);
		}
		GalaxyRegistry.registerSolarSystem(test);
	}
}
