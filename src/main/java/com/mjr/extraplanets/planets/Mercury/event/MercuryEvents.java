package com.mjr.extraplanets.planets.Mercury.event;

import com.mjr.extraplanets.Config;

import micdoodle8.mods.galacticraft.api.event.oxygen.GCCoreOxygenSuffocationEvent;
import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;

import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MercuryEvents {
	@SubscribeEvent
	public void GCCoreOxygenSuffocationEvent(GCCoreOxygenSuffocationEvent.Pre event) {
		if (event.entityLiving.worldObj.provider.getDimensionId() == Config.MERCURY_ID) {
			if (event.entity instanceof EntityPlayer) {
				event.setCanceled(false);
			} else {
				if (event.entity instanceof EntityGhast) {
					event.setCanceled(true);
					return;
				}
				else if (Config.MOB_SUFFOCATION)
					event.setCanceled(false);
				else
					event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event) {
		if (event.entityLiving.worldObj.provider.getDimensionId() == Config.MERCURY_ID) {
			event.entityPlayer.heal(5.0F);
		}
	}
}
