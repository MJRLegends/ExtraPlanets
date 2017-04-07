package com.mjr.extraplanets.moons.Deimos;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleportTypeDeimos implements ITeleportType {
	@Override
	public boolean useParachute() {
		return true;
	}

	@Override
	public Vector3 getPlayerSpawnLocation(WorldServer world, EntityPlayerMP player) {
		if (player != null) {
			GCPlayerStats stats = GCPlayerStats.get(player);
			return new Vector3(stats.coordsTeleportedFromX, 250.0D, stats.coordsTeleportedFromZ);
		}
		return null;
	}

	@Override
	public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) {
		return new Vector3(entity.posX, 250.0D, entity.posZ);
	}

	@Override
	public Vector3 getParaChestSpawnLocation(WorldServer world, EntityPlayerMP player, Random rand) {
		double x = (rand.nextDouble() * 2.0D - 1.0D) * 5.0D;
		double z = (rand.nextDouble() * 2.0D - 1.0D) * 5.0D;
		return new Vector3(player.posX + x, 230.0D, player.posZ + z);
	}

	@Override
	public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player, boolean ridingAutoRocket) {
		// player.addStat(Achievements.deimosMoon, 1);
	}

	@Override
	public void setupAdventureSpawn(EntityPlayerMP player) {
	}
}