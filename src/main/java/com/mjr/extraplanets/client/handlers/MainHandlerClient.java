package com.mjr.extraplanets.client.handlers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import micdoodle8.mods.galacticraft.planets.venus.ConfigManagerVenus;
import micdoodle8.mods.galacticraft.planets.venus.client.FakeLightningBoltRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.overlay.OverlayPressure;
import com.mjr.extraplanets.client.gui.overlay.OverlaySolarRadiation;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.client.handlers.capabilities.IStatsClientCapability;
import com.mjr.extraplanets.network.ExtraPlanetsPacketHandler;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class MainHandlerClient {

	private static List<ExtraPlanetsPacketHandler> packetHandlers = Lists.newCopyOnWriteArrayList();
	private Map<BlockPos, Integer> lightning = Maps.newHashMap();

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

	@SubscribeEvent
	public void renderLightning(ClientProxyCore.EventSpecialRender event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final EntityPlayerSP player = minecraft.thePlayer;
		if (player != null && !ConfigManagerVenus.disableAmbientLightning) {
			Iterator<Map.Entry<BlockPos, Integer>> it = lightning.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<BlockPos, Integer> entry = it.next();
				long seed = entry.getValue() / 10 + entry.getKey().getX() + entry.getKey().getZ();
				FakeLightningBoltRenderer.renderBolt(seed, entry.getKey().getX() - ClientProxyCore.playerPosX, entry.getKey().getY() - ClientProxyCore.playerPosY, entry.getKey().getZ() - ClientProxyCore.playerPosZ);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final EntityPlayerSP player = minecraft.thePlayer;

		if (player == event.player) {
			if (!ConfigManagerVenus.disableAmbientLightning) {
				Iterator<Map.Entry<BlockPos, Integer>> it = lightning.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<BlockPos, Integer> entry = it.next();
					int val = entry.getValue();
					if (val - 1 <= 0) {
						it.remove();
					} else {
						entry.setValue(val - 1);
					}
				}

				if (player.getRNG().nextInt(100) == 0 && minecraft.theWorld.provider instanceof WorldProviderJupiter) {
					double freq = player.getRNG().nextDouble() * Math.PI * 2.0F;
					double dist = 180.0F;
					double dX = dist * Math.cos(freq);
					double dZ = dist * Math.sin(freq);
					double posX = player.posX + dX;
					double posY = 70;
					double posZ = player.posZ + dZ;
					minecraft.theWorld.playSound(player, posX, posY, posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.WEATHER, 1000.0F, 1.0F + player.getRNG().nextFloat() * 0.2F);
					lightning.put(new BlockPos(posX, posY, posZ), 20);
				}
			}
		}
	}
}
