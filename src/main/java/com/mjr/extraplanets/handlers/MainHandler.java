package com.mjr.extraplanets.handlers;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler.ThermalArmorEvent;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.entity.effect.EntityLightningBolt;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class MainHandler {
	@SubscribeEvent
	public void onPlayer(PlayerTickEvent event) {
		if (event.player.worldObj.provider.dimensionId == Config.jupiterID) {
			Random rand = new Random();
			int addX = rand.nextInt(25);
			int addZ = rand.nextInt(25);
			if (rand.nextInt(2) == 1)
				addX = -addX;
			if (rand.nextInt(2) == 1)
				addZ = -addZ;
			int lightingSpawnChance = rand.nextInt(50);
			//int rainingSpawnChance = rand.nextInt(100);
			if (lightingSpawnChance == 10)
				event.player.worldObj.addWeatherEffect(new EntityLightningBolt(
						event.player.worldObj, event.player.posX + addX,
						event.player.posY, event.player.posZ + addZ));
			//			if (rainingSpawnChance == 1
			//					&& event.player.worldObj.isRaining() == false)
			//				event.player.worldObj.setRainStrength(10);
		}
	}
	
	@SubscribeEvent
    public void onThermalArmorEvent(ThermalArmorEvent event)
    {
        if (event.armorStack == null)
        {
            event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.REMOVE);
            return;
        }
        if (event.armorStack.getItem() == AsteroidsItems.thermalPadding && event.armorStack.getItemDamage() == event.armorIndex)
        {
            event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
            return;
        }
        if (event.armorStack.getItem() == ExtraPlanets_Items.tier2ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex)
        {
            event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
            return;
        }
        if (event.armorStack.getItem() == ExtraPlanets_Items.tier3ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex)
        {
            event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
            return;
        }
        if (event.armorStack.getItem() == ExtraPlanets_Items.tier4ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex)
        {
            event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
            return;
        }
        event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.NOTHING);
    }
}
