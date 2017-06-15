package com.mjr.extraplanets.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets_Achievements;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.tools.BasicAxe;
import com.mjr.extraplanets.items.tools.BasicHoe;
import com.mjr.extraplanets.items.tools.BasicPickaxe;
import com.mjr.extraplanets.items.tools.BasicShovel;
import com.mjr.extraplanets.items.tools.BasicSword;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;

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
		if (event.getSource().getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getSourceOfDamage();
			// if (event.getEntity() instanceof EntityCreeperBossMercury) {
			// player.addStat(ExtraPlanets_Achievements.mercury_boss, 1);
			// }
			// else
			if (event.getEntity() instanceof EntityEvolvedMagmaCubeBoss) {
				player.addStat(ExtraPlanets_Achievements.mercury_boss, 1);
			}
			// else if (event.getEntity() instanceof EntityCreeperBossJupiter) {
			// player.addStat(ExtraPlanets_Achievements.jupiter_boss, 1);
			// }
			// else if (event.getEntity() instanceof EntityCreeperBossSaturn) {
			// player.addStat(ExtraPlanets_Achievements.saturn_boss, 1);
			// }
			else if (event.getEntity() instanceof EntityEvolvedGhastBoss) {
				player.addStat(ExtraPlanets_Achievements.saturn_boss, 1);
			}
			// else if (event.getEntity() instanceof EntityCreeperBossJupiter) {
			// player.addStat(ExtraPlanets_Achievements.uranus_boss, 1);
			// }
			else if (event.getEntity() instanceof EntityEvolvedIceSlimeBoss) {
				player.addStat(ExtraPlanets_Achievements.uranus_boss, 1);
			}
			// else if (event.getEntity() instanceof EntityCreeperBossNeptune) {
			// player.addStat(ExtraPlanets_Achievements.neptune_boss, 1);
			// }
			else if (event.getEntity() instanceof EntityEvolvedSnowmanBoss) {
				player.addStat(ExtraPlanets_Achievements.neptune_boss, 1);
			}
			// else if (event.getEntity() instanceof EntityCreeperBossPluto) {
			// player.addStat(ExtraPlanets_Achievements.pluto_boss, 1);
			// }
			// else if (event.getEntity() instanceof EntityCreeperBossEris) {
			// player.addStat(ExtraPlanets_Achievements.eris_boss, 1);
			// }
		}
	}

	@SubscribeEvent
	public void onCraftingRockets(EntityItemPickupEvent event) {
		if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_4_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_4, 1);
		else if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_5_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_5, 1);
		else if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_6_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_6, 1);
		else if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_7_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_7, 1);
		else if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_8_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_8, 1);
		else if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_9_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_9, 1);
		else if (event.getItem().getEntityItem().getItem() == ExtraPlanets_Items.TIER_10_ROCKET)
			event.getEntityPlayer().addStat(ExtraPlanets_Achievements.craft_rocket_10, 1);
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
	}
}
