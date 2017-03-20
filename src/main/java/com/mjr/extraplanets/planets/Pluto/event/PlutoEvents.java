package com.mjr.extraplanets.planets.Pluto.event;

import micdoodle8.mods.galacticraft.api.event.oxygen.GCCoreOxygenSuffocationEvent;
import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.mjr.extraplanets.Config;

public class PlutoEvents {
	@SubscribeEvent
	public void GCCoreOxygenSuffocationEvent(GCCoreOxygenSuffocationEvent.Pre event) {
		if (event.getEntityLiving().worldObj.provider.getDimension() == Config.plutoID) {
			if (event.getEntity() instanceof EntityPlayer) {
				event.setCanceled(false);
			} else {
				if (Config.mobSuffocation)
					event.setCanceled(false);
				else
					event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event) {
		if (event.getEntityLiving().worldObj.provider.getDimension() == Config.plutoID) {
			event.getEntityPlayer().heal(5.0F);
		}
	}
}
