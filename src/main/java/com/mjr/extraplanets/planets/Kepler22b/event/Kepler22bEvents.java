package com.mjr.extraplanets.planets.Kepler22b.event;

import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.mjr.extraplanets.Config;

public class Kepler22bEvents {
	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event) {
		if (event.getEntityLiving().worldObj.provider.getDimension() == Config.KEPLER22B_ID) {
			event.getEntityPlayer().heal(5.0F);
		}
	}
}
