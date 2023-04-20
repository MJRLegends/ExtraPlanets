package com.mjr.extraplanets.moons.Triton;

import java.util.Random;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTriton;
import com.mjr.extraplanets.entities.landers.EntityGeneralLander;
import com.mjr.extraplanets.util.LanderUtil;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.player.GCCapabilities;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleportTypeTriton implements ITeleportType {
	@Override
	public boolean useParachute() {
		return false;
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
		return null;
	}

	@Override
	public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player, boolean ridingAutoRocket) {
		if (!ridingAutoRocket && player != null) {
			GCPlayerStats stats = GCPlayerStats.get(player);

			if (stats.getTeleportCooldown() <= 0) {
				if (player.capabilities.isFlying) {
					player.capabilities.isFlying = false;
				}

				EntityGeneralLander lander = new EntityGeneralLander(player);
	            lander.setPosition(player.posX, player.posY, player.posZ);

				if (!newWorld.isRemote) {
					lander.forceSpawn = true;
					newWorld.spawnEntityInWorld(lander);
					LanderUtil.makeSmallLandingSpot(newWorld, (int)lander.posX, (int)lander.posZ, ExtraPlanets_Blocks.TRITON_BLOCKS.getDefaultState().withProperty(BlockBasicTriton.BASIC_TYPE, BlockBasicTriton.EnumBlockBasic.STONE), false);
				}

				stats.setTeleportCooldown(10);
			}
		}
	}

	@Override
	public void setupAdventureSpawn(EntityPlayerMP player) {

	}
}
