package com.mjr.extraplanets.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets_Achievements;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.tools.BasicAxe;
import com.mjr.extraplanets.items.tools.BasicHoe;
import com.mjr.extraplanets.items.tools.BasicPickaxe;
import com.mjr.extraplanets.items.tools.BasicShovel;
import com.mjr.extraplanets.items.tools.BasicSword;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

public class AchievementEventHandler {
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		if (event.crafting.getItem() instanceof BasicPickaxe) {
			if (event.crafting.getItem() == ExtraPlanets_Tools.carbonPickaxe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.magnesiumPickaxe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.palladiumPickaxe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.crystalPickaxe) {

			}
		} else if (event.crafting.getItem() instanceof BasicAxe) {
			if (event.crafting.getItem() == ExtraPlanets_Tools.carbonAxe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.magnesiumAxe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.palladiumAxe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.crystalAxe) {

			}
		} else if (event.crafting.getItem() instanceof BasicSword) {
			if (event.crafting.getItem() == ExtraPlanets_Tools.carbonSword) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.magnesiumSword) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.palladiumSword) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.crystalSword) {

			}
		} else if (event.crafting.getItem() instanceof BasicShovel) {
			if (event.crafting.getItem() == ExtraPlanets_Tools.carbonShovel) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.magnesiumShovel) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.palladiumShovel) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.crystalShovel) {

			}
		} else if (event.crafting.getItem() instanceof BasicHoe) {
			if (event.crafting.getItem() == ExtraPlanets_Tools.carbonHoe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.magnesiumHoe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.palladiumHoe) {

			} else if (event.crafting.getItem() == ExtraPlanets_Tools.crystalHoe) {

			}
		}
	}

	@SubscribeEvent
	public void onEntityDealth(LivingDeathEvent event) {
		if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			if (event.entity instanceof EntityEvolvedMagmaCubeBoss) {
				player.addStat(ExtraPlanets_Achievements.venusBoss, 1);
			} else if (event.entity instanceof EntityCreeperBossJupiter) {
				player.addStat(ExtraPlanets_Achievements.jupiterBoss, 1);
			} else if (event.entity instanceof EntityCreeperBossSaturn) {
				player.addStat(ExtraPlanets_Achievements.saturnBoss, 1);
			} else if (event.entity instanceof EntityEvolvedIceSlimeBoss) {
				player.addStat(ExtraPlanets_Achievements.uranusBoss, 1);
			} else if (event.entity instanceof EntityCreeperBossNeptune) {
				player.addStat(ExtraPlanets_Achievements.neptuneBoss, 1);
			} else if (event.entity instanceof EntityCreeperBossPluto) {
				player.addStat(ExtraPlanets_Achievements.plutoBoss, 1);
			} else if (event.entity instanceof EntityCreeperBossEris) {
				player.addStat(ExtraPlanets_Achievements.erisBoss, 1);
			}
		}
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
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.tier10Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craftRocket10, 1);
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
