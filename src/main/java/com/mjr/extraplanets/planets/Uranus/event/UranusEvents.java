package com.mjr.extraplanets.planets.Uranus.event;

import micdoodle8.mods.galacticraft.api.event.oxygen.GCCoreOxygenSuffocationEvent;
import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.mjr.extraplanets.Config;

public class UranusEvents {
	@SubscribeEvent
	public void GCCoreOxygenSuffocationEvent(GCCoreOxygenSuffocationEvent.Pre event) {
		if (event.getEntityLiving().world.provider.getDimension() == Config.URANUS_ID) {
			if (event.getEntity() instanceof EntityPlayer) {
				event.setCanceled(false);
			} else {
				if (Config.MOB_SUFFOCATION)
					event.setCanceled(false);
				else
					event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event) {
		if (event.getEntityLiving().world.provider.getDimension() == Config.URANUS_ID) {
			event.getEntityPlayer().heal(5.0F);
		}
	}
}
