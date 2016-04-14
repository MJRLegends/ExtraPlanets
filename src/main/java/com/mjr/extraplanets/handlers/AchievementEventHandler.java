package com.mjr.extraplanets.handlers;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import com.mjr.extraplanets.ExtraPlanets_Achievements;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

public class AchievementEventHandler {
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {

	}

	@SubscribeEvent
	public void onCraftingRockets(EntityItemPickupEvent event) {
		if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier4Rocket) {
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket4, 1);
		} else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier5Rocket) {
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket5, 1);
		} else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier6Rocket) {
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket6, 1);
		} else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier7Rocket) {
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket7, 1);
		} else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier8Rocket) {
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket8, 1);
		} else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier9Rocket) {
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket9, 1);
		}
	}
	
	@SubscribeEvent
	public void onDimensionChange(PlayerChangedDimensionEvent event)
	{
		
	}
}
