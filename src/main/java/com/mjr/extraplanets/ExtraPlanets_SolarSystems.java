package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.ResourceLocation;

public class ExtraPlanets_SolarSystems {

	// Milky Way
	public static SolarSystem kepler22;
	public static SolarSystem kepler47;
	public static SolarSystem kepler62;
	public static SolarSystem kepler69;
	
	// Whirlpool
	public static SolarSystem xenos157;
	
	//Andromeda
	public static SolarSystem deltiri10;

	// Black Eye
	public static SolarSystem vendrizi161;

	// Proxima Centauri
	public static SolarSystem epsilonSolaria;

	public static void init() {
		initializeSolarSystems();
		registerSolarSystems();
	}

	private static void initializeSolarSystems() {
		if (Config.KEPLER_SOLAR_SYSTEMS) {
			kepler22 = new SolarSystem("kepler22", "milky_way").setMapPosition(new Vector3(0.8F + Config.KEPLER22_SYSTEM_X_OFFSET, -0.6F + Config.KEPLER22_SYSTEM_Y_OFFSET, 0.0F + Config.KEPLER22_SYSTEM_Z_OFFSET));
			Star starSol = (Star) new Star("kepler22").setParentSolarSystem(kepler22).setTierRequired(-1);
			starSol.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler22.setMainStar(starSol);

			kepler47 = new SolarSystem("kepler47", "milky_way").setMapPosition(new Vector3(-0.40F + Config.KEPLER47_SYSTEM_X_OFFSET, -0.8F + Config.KEPLER47_SYSTEM_Y_OFFSET, 0.0F+ Config.KEPLER47_SYSTEM_Z_OFFSET));
			Star starSol2 = (Star) new Star("kepler47").setParentSolarSystem(kepler47).setTierRequired(-1);
			starSol2.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler47.setMainStar(starSol2);

			kepler62 = new SolarSystem("kepler62", "milky_way").setMapPosition(new Vector3(-0.65F + Config.KEPLER62_SYSTEM_X_OFFSET, 0.9F + Config.KEPLER62_SYSTEM_Y_OFFSET, 0.0F + Config.KEPLER62_SYSTEM_Z_OFFSET));
			Star starSol3 = (Star) new Star("kepler62").setParentSolarSystem(kepler62).setTierRequired(-1);
			starSol3.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler62.setMainStar(starSol3);

			kepler69 = new SolarSystem("kepler69", "milky_way").setMapPosition(new Vector3(-0.90F + Config.KEPLER69_SYSTEM_X_OFFSET, 0.0F + Config.KEPLER69_SYSTEM_Y_OFFSET, 0.0F + Config.KEPLER69_SYSTEM_Z_OFFSET));
			Star starSol4 = (Star) new Star("kepler69").setParentSolarSystem(kepler69).setTierRequired(-1);
			starSol4.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			kepler69.setMainStar(starSol4);
		}
		if(Config.CUSTOM_GALAXIES){
			xenos157 = new SolarSystem("xenos157", "whirlpool").setMapPosition(new Vector3(0F, 0.0F, 0.0F));
			Star starSol5 = (Star) new Star("xenos157").setParentSolarSystem(xenos157).setTierRequired(-1);
			starSol5.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			xenos157.setMainStar(starSol5);
			
//			deltiri10 = new SolarSystem("deltiri10", "andromeda").setMapPosition(new Vector3(0F, 0.0F, 0.0F));
//			Star starSol6 = (Star) new Star("deltiri10").setParentSolarSystem(deltiri10).setTierRequired(-1);
//			starSol6.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
//			deltiri10.setMainStar(starSol6);
			
			vendrizi161 = new SolarSystem("vendrizi161", "black_eye").setMapPosition(new Vector3(0F, 0.0F, 0.0F));
			Star starSol7 = (Star) new Star("vendrizi161").setParentSolarSystem(vendrizi161).setTierRequired(-1);
			starSol7.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			vendrizi161.setMainStar(starSol7);
			
			epsilonSolaria = new SolarSystem("epsilonSolaria", "proxima_centauri").setMapPosition(new Vector3(0F, 0.0F, 0.0F));
			Star starSol8 = (Star) new Star("epsilonSolaria").setParentSolarSystem(epsilonSolaria).setTierRequired(-1);
			starSol8.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
			epsilonSolaria.setMainStar(starSol8);
		}
	}

	private static void registerSolarSystems() {
		if (Config.KEPLER_SOLAR_SYSTEMS) {
			GalaxyRegistry.registerSolarSystem(kepler22);
			GalaxyRegistry.registerSolarSystem(kepler47);
			GalaxyRegistry.registerSolarSystem(kepler62);
			GalaxyRegistry.registerSolarSystem(kepler69);
		}
		if(Config.CUSTOM_GALAXIES){
			GalaxyRegistry.registerSolarSystem(xenos157);
			//GalaxyRegistry.registerSolarSystem(deltiri10);
			GalaxyRegistry.registerSolarSystem(vendrizi161);
			GalaxyRegistry.registerSolarSystem(epsilonSolaria);
		}
	}
}
