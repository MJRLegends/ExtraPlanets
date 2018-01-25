package com.mjr.extraplanets.handlers;

import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets_Achievements;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedFireBatBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGiantZombieBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSpacemanBoss;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class AchievementEventHandler {
	@SubscribeEvent
	public void onEntityDealth(LivingDeathEvent event) {
		if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			if (event.entity instanceof EntityEvolvedMagmaCubeBoss) {
				player.addStat(ExtraPlanets_Achievements.mercury_boss, 1);
			} else if (event.entity instanceof EntityEvolvedFireBatBoss) {
				player.addStat(ExtraPlanets_Achievements.jupiter_boss, 1);
			} else if (event.entity instanceof EntityEvolvedGhastBoss) {
				player.addStat(ExtraPlanets_Achievements.saturn_boss, 1);
			} else if (event.entity instanceof EntityEvolvedIceSlimeBoss) {
				player.addStat(ExtraPlanets_Achievements.uranus_boss, 1);
			} else if (event.entity instanceof EntityEvolvedSnowmanBoss) {
				player.addStat(ExtraPlanets_Achievements.neptune_boss, 1);
			} else if (event.entity instanceof EntityEvolvedSpacemanBoss) {
				player.addStat(ExtraPlanets_Achievements.pluto_boss, 1);
			} else if (event.entity instanceof EntityEvolvedGiantZombieBoss) {
				player.addStat(ExtraPlanets_Achievements.eris_boss, 1);
			}
		}
	}

	@SubscribeEvent
	public void onCraftingRockets(EntityItemPickupEvent event) {
		if (event.item.getEntityItem().getItem() == AsteroidsItems.tier3Rocket)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_3, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_4_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_4, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_5_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_5, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_6_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_6, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_7_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_7, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_8_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_8, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_9_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_9, 1);
		else if (event.item.getEntityItem().getItem() == ExtraPlanets_Items.TIER_10_ROCKET)
			event.entityPlayer.addStat(ExtraPlanets_Achievements.craft_rocket_10, 1);
	}

	@SubscribeEvent
	public void onDimensionChange(PlayerChangedDimensionEvent event) {
		if (event.toDim == Config.MERCURY_ID)
			event.player.addStat(ExtraPlanets_Achievements.mercury_planet, 1);
		else if (event.toDim == Config.CERES_ID)
			event.player.addStat(ExtraPlanets_Achievements.ceres_planet, 1);
		else if (event.toDim == Config.JUPITER_ID)
			event.player.addStat(ExtraPlanets_Achievements.jupiter_planet, 1);
		else if (event.toDim == Config.SATURN_ID)
			event.player.addStat(ExtraPlanets_Achievements.saturn_planet, 1);
		else if (event.toDim == Config.URANUS_ID)
			event.player.addStat(ExtraPlanets_Achievements.uranus_boss, 1);
		else if (event.toDim == Config.NEPTUNE_ID)
			event.player.addStat(ExtraPlanets_Achievements.neptune_planet, 1);
		else if (event.toDim == Config.PLUTO_ID)
			event.player.addStat(ExtraPlanets_Achievements.pluto_planet, 1);
		else if (event.toDim == Config.ERIS_ID)
			event.player.addStat(ExtraPlanets_Achievements.eris_planet, 1);
		else if (event.toDim == Config.KEPLER22B_ID)
			event.player.addStat(ExtraPlanets_Achievements.kepler22b_planet, 1);
	}
}
