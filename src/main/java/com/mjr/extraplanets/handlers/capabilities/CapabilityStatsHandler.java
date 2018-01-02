package com.mjr.extraplanets.handlers.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import com.mjr.extraplanets.Constants;

public class CapabilityStatsHandler {
	@CapabilityInject(IStatsCapability.class)
	public static Capability<IStatsCapability> EP_STATS_CAPABILITY = null;

	public static final ResourceLocation EP_PLAYER_PROP = new ResourceLocation(Constants.ASSET_PREFIX, "player_stats");

	public static void register() {
		CapabilityManager.INSTANCE.register(IStatsCapability.class, new Capability.IStorage<IStatsCapability>() {
			@Override
			public NBTBase writeNBT(Capability<IStatsCapability> capability, IStatsCapability instance, EnumFacing side) {
				return null;
			}

			@Override
			public void readNBT(Capability<IStatsCapability> capability, IStatsCapability instance, EnumFacing side, NBTBase nbt) {
			}
		}, StatsCapability::new);
	}
}
