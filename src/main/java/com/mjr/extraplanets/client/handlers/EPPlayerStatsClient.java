package com.mjr.extraplanets.client.handlers;

import java.lang.ref.WeakReference;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EPPlayerStatsClient implements IExtendedEntityProperties {
	public static final String EP_PLAYER_PROP = "EPPlayerStatsClient";

	public WeakReference<EntityPlayerSP> player;

	public Double radiationLevel;

	public EPPlayerStatsClient(EntityPlayerSP player) {
		this.player = new WeakReference<EntityPlayerSP>(player);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
	}

	@Override
	public void init(Entity entity, World world) {
	}

	public static void register(EntityPlayerSP player) {
		player.registerExtendedProperties(EPPlayerStatsClient.EP_PLAYER_PROP, new EPPlayerStatsClient(player));
	}

	public static EPPlayerStatsClient get(EntityPlayerSP player) {
		return (EPPlayerStatsClient) player.getExtendedProperties(EPPlayerStatsClient.EP_PLAYER_PROP);
	}
}
