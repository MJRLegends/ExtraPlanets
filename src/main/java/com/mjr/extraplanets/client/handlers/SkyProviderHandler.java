package com.mjr.extraplanets.client.handlers;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.client.SkyProviderOrbit;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOrbit;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStatsClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.planets.Ceres.SkyProviderCeres;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.SkyProviderEris;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.SkyProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
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
import com.mjr.extraplanets.planets.Venus.SkyProviderVenus;
import com.mjr.extraplanets.planets.Venus.WorldProviderVenus;
import com.mjr.extraplanets.planets.Venus.spacestation.WorldProviderVenusOrbit;

public class SkyProviderHandler {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final WorldClient world = minecraft.theWorld;
        final EntityPlayerSP player = minecraft.thePlayer;

		if (world != null) {
			// Planets
			if (world.provider instanceof WorldProviderMercury) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderMercury((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderVenus) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderVenus((IGalacticraftWorldProvider) world.provider));
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

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
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
//			if (world.provider instanceof WorldProviderKepler22b) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderKepler22b((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			// Moons
//			if (world.provider instanceof WorldProviderCallisto) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderCallisto((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderDeimos) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderDeimos((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderEuropa) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderGanymede((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderGanymede) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderGanymede((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderIo) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderIo((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderPhobos) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderPhobos((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderRhea) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderRhea((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderTitan) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderEris((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//			if (world.provider instanceof WorldProviderTriton) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderTriton((IGalacticraftWorldProvider) world.provider));
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
//
			// Space Stations
			if (world.provider instanceof WorldProviderMercuryOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mercury.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderVenusOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/venus.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderCeresOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderJupiterOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderSaturnOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/saturn.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderUranusOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/uranus.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderNeptuneOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/neptune.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderPlutoOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/pluto.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			if (world.provider instanceof WorldProviderErisOrbit) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/eris.png"), false, true));
					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
				}

				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
//			if (world.provider instanceof WorldProviderKepler22bOrbit) {
//				if (world.provider.getSkyRenderer() == null) {
//					world.provider.setSkyRenderer(new SkyProviderOrbit(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler22b.png"), false, true));
//					((SkyProviderOrbit) world.provider.getSkyRenderer()).spinDeltaPerTick = ((WorldProviderOrbit) world.provider).getSpinRate();
//					GCPlayerStatsClient.get(player).inFreefallFirstCheck = false;
//				}
//
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
//			}
		}
	}
}
