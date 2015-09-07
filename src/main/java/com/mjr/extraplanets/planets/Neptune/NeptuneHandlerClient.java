package com.mjr.extraplanets.planets.Neptune;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NeptuneHandlerClient {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event)
	{
		Minecraft minecraft = Minecraft.getMinecraft();
		WorldClient world = minecraft.theWorld;

		if (world != null)
		{
			if (world.provider instanceof WorldProviderNeptune)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderNeptune((IGalacticraftWorldProvider) world.provider));
				}

				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
		}
	}
}
