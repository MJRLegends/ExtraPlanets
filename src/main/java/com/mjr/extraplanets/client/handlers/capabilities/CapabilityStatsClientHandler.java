package com.mjr.extraplanets.client.handlers.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import com.mjr.extraplanets.Constants;

public class CapabilityStatsClientHandler
{
    @CapabilityInject(IStatsClientCapability.class)
    public static Capability<IStatsClientCapability> EP_STATS_CLIENT_CAPABILITY = null;

    public static final ResourceLocation EP_PLAYER_CLIENT_PROP = new ResourceLocation(Constants.ASSET_PREFIX, "player_stats_client");

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IStatsClientCapability.class, new Capability.IStorage<IStatsClientCapability>()
        {
            @Override
            public NBTBase writeNBT(Capability<IStatsClientCapability> capability, IStatsClientCapability instance, EnumFacing side)
            {
                return null;
            }

            @Override
            public void readNBT(Capability<IStatsClientCapability> capability, IStatsClientCapability instance, EnumFacing side, NBTBase nbt) { }
        }, StatsClientCapability::new);
    }
}
