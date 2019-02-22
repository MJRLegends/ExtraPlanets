package com.mjr.extraplanets.planets.Kepler22b.event;

import com.mjr.extraplanets.Config;

import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Kepler22bEvents {
	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event) {
		if (event.entityLiving.worldObj.provider.getDimensionId() == Config.KEPLER22B_ID) {
			event.entityPlayer.heal(5.0F);
		}
	}
}
