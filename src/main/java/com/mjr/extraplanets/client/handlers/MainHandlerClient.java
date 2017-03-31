package com.mjr.extraplanets.client.handlers;

import java.util.List;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.overlay.OverlayPressure;
import com.mjr.extraplanets.client.gui.overlay.OverlaySolarRadiation;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.client.handlers.capabilities.IStatsClientCapability;
import com.mjr.extraplanets.network.ExtraPlanetsPacketHandler;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class MainHandlerClient {

	private static List<ExtraPlanetsPacketHandler> packetHandlers = Lists.newCopyOnWriteArrayList();

	public static void addPacketHandler(ExtraPlanetsPacketHandler handler) {
		MainHandlerClient.packetHandlers.add(handler);
	}

	@SubscribeEvent
	public void worldUnloadEvent(WorldEvent.Unload event) {
		for (ExtraPlanetsPacketHandler packetHandler : packetHandlers) {
			packetHandler.unload(event.getWorld());
		}
	}

	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final WorldClient world = minecraft.theWorld;

		if (event.phase == Phase.END) {
			if (world != null) {
				for (ExtraPlanetsPacketHandler handler : packetHandlers) {
					handler.tick(world);
				}
			}
		}
	}

	@SubscribeEvent
	public void onRenderTick(RenderTickEvent event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final EntityPlayerSP player = minecraft.thePlayer;
		final EntityPlayerSP playerBaseClient = PlayerUtil.getPlayerBaseClientFromPlayer(player, false);
		if (player != null && player.worldObj.provider instanceof IGalacticraftWorldProvider && OxygenUtil.shouldDisplayTankGui(minecraft.currentScreen) && OxygenUtil.noAtmosphericCombustion(player.worldObj.provider)
				&& !playerBaseClient.isSpectator()) {
			if ((player.worldObj.provider instanceof CustomWorldProviderSpace)) {
				CustomWorldProviderSpace provider = (CustomWorldProviderSpace) player.worldObj.provider;

				if (Config.PRESSURE) {
					int pressureLevel = provider.getPressureLevel();
					OverlayPressure.renderPressureIndicator(pressureLevel, !ConfigManagerCore.oxygenIndicatorLeft, !ConfigManagerCore.oxygenIndicatorBottom);
				}
				if (Config.RADIATION) {
					IStatsClientCapability stats = null;

					if (player != null) {
						stats = playerBaseClient.getCapability(CapabilityStatsClientHandler.EP_STATS_CLIENT_CAPABILITY, null);
					}
					int radiationLevel = (int) Math.floor(stats.getRadiationLevel());
					OverlaySolarRadiation.renderSolarRadiationIndicator(radiationLevel, !ConfigManagerCore.oxygenIndicatorLeft, !ConfigManagerCore.oxygenIndicatorBottom);
				}
			}
		}
	}
}
