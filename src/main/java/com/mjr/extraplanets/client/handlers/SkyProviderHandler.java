package com.mjr.extraplanets.client.handlers;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.api.prefabs.client.SkyProviderCustomOrbit;
import com.mjr.extraplanets.moons.Callisto.SkyProviderCallisto;
import com.mjr.extraplanets.moons.Callisto.WorldProviderCallisto;
import com.mjr.extraplanets.moons.Deimos.SkyProviderDeimos;
import com.mjr.extraplanets.moons.Deimos.WorldProviderDeimos;
import com.mjr.extraplanets.moons.Europa.WorldProviderEuropa;
import com.mjr.extraplanets.moons.Ganymede.SkyProviderGanymede;
import com.mjr.extraplanets.moons.Ganymede.WorldProviderGanymede;
import com.mjr.extraplanets.moons.Iapetus.SkyProviderIapetus;
import com.mjr.extraplanets.moons.Iapetus.WorldProviderIapetus;
import com.mjr.extraplanets.moons.Io.SkyProviderIo;
import com.mjr.extraplanets.moons.Io.WorldProviderIo;
import com.mjr.extraplanets.moons.Oberon.SkyProviderOberon;
import com.mjr.extraplanets.moons.Oberon.WorldProviderOberon;
import com.mjr.extraplanets.moons.Phobos.SkyProviderPhobos;
import com.mjr.extraplanets.moons.Phobos.WorldProviderPhobos;
import com.mjr.extraplanets.moons.Rhea.SkyProviderRhea;
import com.mjr.extraplanets.moons.Rhea.WorldProviderRhea;
import com.mjr.extraplanets.moons.Titan.WorldProviderTitan;
import com.mjr.extraplanets.moons.Titania.SkyProviderTitania;
import com.mjr.extraplanets.moons.Titania.WorldProviderTitania;
import com.mjr.extraplanets.moons.Triton.SkyProviderTriton;
import com.mjr.extraplanets.moons.Triton.WorldProviderTriton;
import com.mjr.extraplanets.planets.Ceres.SkyProviderCeres;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.SkyProviderEris;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.CloudRenderJupiter;
import com.mjr.extraplanets.planets.Jupiter.SkyProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Kepler22b.SkyProviderKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.spacestation.WorldProviderKepler22bOrbit;
import com.mjr.extraplanets.planets.Mercury.SkyProviderMercury;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Mercury.spacestation.WorldProviderMercuryOrbit;
import com.mjr.extraplanets.planets.Neptune.SkyProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.spacestation.WorldProviderNeptuneOrbit;
import com.mjr.extraplanets.planets.Pluto.SkyProviderPluto;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Pluto.spacestation.WorldProviderPlutoOrbit;
import com.mjr.extraplanets.planets.Saturn.SkyProviderSaturn;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Saturn.spacestation.WorldProviderSaturnOrbit;
import com.mjr.extraplanets.planets.Uranus.SkyProviderUranus;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.planets.Uranus.spacestation.WorldProviderUranusOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;
import com.mjr.extraplanets.planets.venus.spacestation.WorldProviderVenusOrbit;
import com.mjr.mjrlegendslib.util.MCUtilities;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.client.SkyProviderOrbit;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOverworldOrbit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkyProviderHandler {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		final Minecraft minecraft = MCUtilities.getClient();
		final WorldClient world = minecraft.world;
		final EntityPlayerSP player = minecraft.player;

		if (event.phase == Phase.START && player != null && world != null) {
			// Planets
			if (world.provider instanceof WorldProviderMercury) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderMercury((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderCeres) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderCeres((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderJupiter) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderJupiter((IGalacticraftWorldProvider) world.provider));
				}
				if (Config.JUPITER_CLOUDS) {
					if (world.provider.getCloudRenderer() == null) {
						world.provider.setCloudRenderer(new CloudRenderJupiter());
					} else {
						if (!MCUtilities.getClient().isGamePaused()) {
							CloudRenderJupiter.cloudTickCounter += Config.JUPITER_CLOUDS_SPEED;
						}
					}
				}
			}
			if (world.provider instanceof WorldProviderSaturn) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderSaturn((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderUranus) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderUranus((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderNeptune) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderNeptune((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderPluto) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderPluto((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderEris) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderEris((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderKepler22b) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderKepler22b((IGalacticraftWorldProvider) world.provider));
				}

//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
			}
			// Moons
			if (world.provider instanceof WorldProviderCallisto) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderCallisto((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderDeimos) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderDeimos((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderEuropa) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderGanymede((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderGanymede) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderGanymede((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderIo) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderIo((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderPhobos) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderPhobos((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderRhea) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderRhea((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderTitan) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderEris((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderTriton) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderTriton((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderIapetus) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderIapetus((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderOberon) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOberon((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderTitania) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderTitania((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}

			// Space Stations
			if (world.provider instanceof WorldProviderMercuryOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mercury.png"), false, true, WorldProviderMercuryOrbit.getSunSize());
					WorldProviderMercuryOrbit provider = (WorldProviderMercuryOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderVenusOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/venus.png"), false, true, WorldProviderVenusOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderVenusOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderCeresOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"), false, true, WorldProviderCeresOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderCeresOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderMarsOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mars.png"), false, true, WorldProviderMarsOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderMarsOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderJupiterOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"), false, true, WorldProviderJupiterOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderJupiterOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderSaturnOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/saturn.png"), false, true, WorldProviderSaturnOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderSaturnOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderUranusOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/uranus.png"), false, true, WorldProviderUranusOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderUranusOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderNeptuneOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/neptune.png"), false, true, WorldProviderNeptuneOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderNeptuneOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderPlutoOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/pluto.png"), false, true, WorldProviderPlutoOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderPlutoOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderErisOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/eris.png"), false, true, WorldProviderErisOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderErisOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderKepler22bOrbit) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderCustomOrbit sky = new SkyProviderCustomOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler22b.png"), false, true, WorldProviderKepler22bOrbit.getSunSize());
					WorldProviderOverworldOrbit provider = (WorldProviderKepler22bOrbit) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
		}
	}
}
