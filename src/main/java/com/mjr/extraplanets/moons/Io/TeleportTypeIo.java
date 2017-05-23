package com.mjr.extraplanets.moons.Io;

import java.util.Random;

import com.mjr.extraplanets.Constants;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.player.GCCapabilities;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleportTypeIo implements ITeleportType {
	@Override
	public boolean useParachute() {
		return true;
	}

	@Override
	public Vector3 getPlayerSpawnLocation(WorldServer world, EntityPlayerMP player) {
		if (player != null) {
			GCPlayerStats stats = player.getCapability(GCCapabilities.GC_STATS_CAPABILITY, null);
			return new Vector3(stats.getCoordsTeleportedFromX(), Constants.PLANET_AND_MOON_SPAWN_HEIGHT, stats.getCoordsTeleportedFromZ());
		}

		return null;
	}

	@Override
	public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) {
		return new Vector3(entity.posX, Constants.PLANET_AND_MOON_SPAWN_HEIGHT_D, entity.posZ);
	}

	@Override
	public Vector3 getParaChestSpawnLocation(WorldServer world, EntityPlayerMP player, Random rand) {
		final double x = (rand.nextDouble() * 2 - 1.0D) * 5.0D;
		final double z = (rand.nextDouble() * 2 - 1.0D) * 5.0D;
		return new Vector3(player.posX + x, Constants.PLANET_AND_MOON_PARA_CHEST_SPAWN_HEIGHT_D, player.posZ + z);
	}

	@Override
	public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player, boolean ridingAutoRocket) {
	}

	@Override
	public void setupAdventureSpawn(EntityPlayerMP player) {
		// TODO Auto-generated method stub

	}
}
