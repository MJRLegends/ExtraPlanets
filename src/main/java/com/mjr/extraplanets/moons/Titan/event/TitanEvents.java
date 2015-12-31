package com.mjr.extraplanets.moons.Titan.event;

import micdoodle8.mods.galacticraft.api.event.oxygen.GCCoreOxygenSuffocationEvent;
import micdoodle8.mods.galacticraft.core.event.EventWakePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import com.mjr.extraplanets.Config;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TitanEvents {
	@SubscribeEvent
	public void GCCoreOxygenSuffocationEvent(GCCoreOxygenSuffocationEvent.Pre event){
		if (event.entityLiving.worldObj.provider.dimensionId == Config.titanID)
		{
			if(event.entity instanceof EntityPlayer) {
				event.setCanceled(false);
			}
			else{
				if(Config.mobSuffocation)
					event.setCanceled(false);
				else
					event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void GCCoreEventWakePlayer(EventWakePlayer event){
		if (event.entityLiving.worldObj.provider.dimensionId == Config.titanID)
		{
			event.entityPlayer.heal(5.0F);

			for (WorldServer worldServer : MinecraftServer.getServer().worldServers)
			{
				worldServer.setWorldTime(0);
			}
		}
	}
}
