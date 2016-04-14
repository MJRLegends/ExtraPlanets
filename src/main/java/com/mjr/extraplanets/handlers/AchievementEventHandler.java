package com.mjr.extraplanets.handlers;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import com.mjr.extraplanets.Config;
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
		if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier4Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket4, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier5Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket5, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier6Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket6, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier7Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket7, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier8Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket8, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier9Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket9, 1);
	}

	@SubscribeEvent
	public void onDimensionChange(PlayerChangedDimensionEvent event) {
		if (event.toDim == Config.mercuryID)
			event.player.addStat(ExtraPlanets_Achievements.mercuryPlanet, 1);
		else if (event.toDim == Config.venusID)
			event.player.addStat(ExtraPlanets_Achievements.venusPlanet, 1);
		else if (event.toDim == Config.ceresID)
			event.player.addStat(ExtraPlanets_Achievements.ceresPlanet, 1);
		else if (event.toDim == Config.jupiterID)
			event.player.addStat(ExtraPlanets_Achievements.jupiterPlanet, 1);
		else if (event.toDim == Config.saturnID)
			event.player.addStat(ExtraPlanets_Achievements.saturnPlanet, 1);
		else if (event.toDim == Config.uranusID)
			event.player.addStat(ExtraPlanets_Achievements.uranusBoss, 1);
		else if (event.toDim == Config.neptuneID)
			event.player.addStat(ExtraPlanets_Achievements.neptunePlanet, 1);
		else if (event.toDim == Config.plutoID)
			event.player.addStat(ExtraPlanets_Achievements.plutoPlanet, 1);
		else if (event.toDim == Config.erisID)
			event.player.addStat(ExtraPlanets_Achievements.erisPlanet, 1);
	}
}
