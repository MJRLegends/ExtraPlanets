package com.mjr.extraplanets.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class PlayerRadiationHandler {

	private static int radiationAmount = 35;

	public static int getRadiationAmount() {
		return radiationAmount;
	}

	public static void setRadiationAmount(int amount) {
		radiationAmount = amount;
	}
	
	public static void addRadiationAmount(int amount) {
		if(radiationAmount < 100)
			radiationAmount = radiationAmount + amount;
	}
	
	public static void removeRadiationAmount(int amount) {
		if(radiationAmount > 0)
			radiationAmount = radiationAmount - amount;
	}
	
	@SubscribeEvent
	public void onPlayer(PlayerTickEvent event) {
		int dimensionID = event.player.dimension;
		if(event.player.inventory.armorItemInSlot(3) != null){
			if(event.player.inventory.armorItemInSlot(3).getItem().getUnlocalizedName().contains("helmetGold")){
				addRadiationAmount(1);
			}
			else if(event.player.inventory.armorItemInSlot(3).getItem().getUnlocalizedName().contains("helmetDiamond")){
				removeRadiationAmount(1);
			}
		}
	}
}
