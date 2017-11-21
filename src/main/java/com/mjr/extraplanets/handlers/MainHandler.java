package com.mjr.extraplanets.handlers;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler.ThermalArmorEvent;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.client.event.GuiOpenEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MainHandler {
	@SubscribeEvent
	public void onPlayer(PlayerTickEvent event) {
		if (event.player.worldObj.provider.dimensionId == Config.jupiterID) {
			Random rand = new Random();
			int addX = rand.nextInt(35);
			int addZ = rand.nextInt(35);
			if (rand.nextInt(2) == 1)
				addX = -addX;
			if (rand.nextInt(2) == 1)
				addZ = -addZ;
			if (addX <= 3)
				addX = 5;
			if (addZ <= 3)
				addZ = 5;
			int lightingSpawnChance = rand.nextInt(100);
			if (lightingSpawnChance == 10)
				event.player.worldObj.addWeatherEffect(new EntityLightningBolt(event.player.worldObj, event.player.posX + addX, event.player.worldObj.getHeightValue((int) event.player.posX + addX, (int) event.player.posZ + addZ), event.player.posZ
						+ addZ));
		}
	}

	@SubscribeEvent
	public void onThermalArmorEvent(ThermalArmorEvent event) {
		if (event.armorStack == null) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.REMOVE);
			return;
		}
		if (event.armorStack.getItem() == AsteroidsItems.thermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.tier2ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.tier3ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		if (event.armorStack.getItem() == ExtraPlanets_Items.tier4ThermalPadding && event.armorStack.getItemDamage() == event.armorIndex) {
			event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.ADD);
			return;
		}
		event.setArmorAddResult(ThermalArmorEvent.ArmorAddResult.NOTHING);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onGuiOpenEvent(GuiOpenEvent event) {
		// if (((event.gui instanceof GuiCelestialSelection))) {
		// if (GameSettings.isKeyDown(micdoodle8.mods.galacticraft.core.tick.KeyHandlerClient.galaxyMap) && Config.useCustomCelestaialSelection) {
		// event.gui = new CustomCelestaialSelection(true, null);
		// } else {
		// event.gui = new CustomCelestaialSelection(false, null);
		// }
		// }
	}
}
