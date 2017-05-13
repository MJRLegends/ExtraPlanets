package com.mjr.extraplanets.network;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

@Sharable
public class ExtraPlanetsPacketHandler extends SimpleChannelInboundHandler<IPacket>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, IPacket msg) throws Exception
    {
        INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
        EntityPlayer player = GalacticraftCore.proxy.getPlayerFromNetHandler(netHandler);

        switch (FMLCommonHandler.instance().getEffectiveSide())
        {
        case CLIENT:
            msg.handleClientSide(player);
            break;
        case SERVER:
            msg.handleServerSide(player);
            break;
        default:
            break;
        }
    }
}