package com.mjr.extraplanets.planets.Kepler22b.event;

import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import com.mjr.extraplanets.Config;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Kepler22bEvents {
	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event) {
		if (event.entityLiving.worldObj.provider.dimensionId == Config.kepler22bID) {
			event.entityPlayer.heal(5.0F);

			for (WorldServer worldServer : MinecraftServer.getServer().worldServers) {
				worldServer.setWorldTime(0);
			}
		}
	}
}
