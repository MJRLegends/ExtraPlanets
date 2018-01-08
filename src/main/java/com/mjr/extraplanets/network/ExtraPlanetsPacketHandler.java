package com.mjr.extraplanets.network;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.IPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.mjr.extraplanets.client.handlers.MainHandlerClient;
import com.mjr.extraplanets.handlers.MainHandlerServer;
import com.mjr.mjrlegendslib.util.MCUtilities;

@Sharable
public class ExtraPlanetsPacketHandler extends SimpleChannelInboundHandler<IPacket> {
	private final Map<Side, Map<Integer, Queue<PacketPlayerPair>>> packetMap;
	private static volatile int livePacketCount = 0;

	public ExtraPlanetsPacketHandler() {
		Map<Side, Map<Integer, Queue<PacketPlayerPair>>> map = Maps.newHashMap();
		for (Side side : Side.values()) {
			Map<Integer, Queue<PacketPlayerPair>> sideMap = new ConcurrentHashMap<Integer, Queue<PacketPlayerPair>>();
			map.put(side, sideMap);
		}

		packetMap = ImmutableMap.copyOf(map);
		if (MCUtilities.isClient()) {
			MainHandlerClient.addPacketHandler(this);
		}
		MainHandlerServer.addPacketHandler(this);
	}

	public void unload(World world) {
		Side side = world.isRemote ? Side.CLIENT : Side.SERVER;
		int dimId = world.provider.getDimension();
		Queue<PacketPlayerPair> queue = getQueue(side, dimId);
		queue.clear();
	}

	public void tick(World world) {
		PacketPlayerPair pair;
		Side side = world.isRemote ? Side.CLIENT : Side.SERVER;
		int dimID = world.provider.getDimension();
		Queue<PacketPlayerPair> queue = getQueue(side, dimID);
		while ((pair = queue.poll()) != null) {
			switch (side) {
			case CLIENT:
				pair.getPacket().handleClientSide(pair.getPlayer());
				break;
			case SERVER:
				pair.getPacket().handleServerSide(pair.getPlayer());
				break;
			}
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg) throws Exception {
		INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
		Side side = ctx.channel().attr(NetworkRegistry.CHANNEL_SOURCE).get();
		EntityPlayer player = GalacticraftCore.proxy.getPlayerFromNetHandler(netHandler);

		if (player == null) {
			return;
		}

		if (side != null) {
			getQueue(side, msg.getDimensionID()).add(new PacketPlayerPair(msg, player));
			setLivePacketCount(getLivePacketCount() + 1);
		}
	}

	private Queue<PacketPlayerPair> getQueue(Side side, int dimID) {
		Map<Integer, Queue<PacketPlayerPair>> map = packetMap.get(side);
		if (!map.containsKey(dimID)) {
			map.put(dimID, Queues.<PacketPlayerPair> newConcurrentLinkedQueue());
		}
		return map.get(dimID);
	}

	public static int getLivePacketCount() {
		return livePacketCount;
	}

	public static void setLivePacketCount(int livePacketCount) {
		ExtraPlanetsPacketHandler.livePacketCount = livePacketCount;
	}

	private final class PacketPlayerPair {
		private IPacket packet;
		private EntityPlayer player;

		public PacketPlayerPair(IPacket packet, EntityPlayer player) {
			this.packet = packet;
			this.player = player;
		}

		public IPacket getPacket() {
			return packet;
		}

		@SuppressWarnings("unused")
		public void setPacket(IPacket packet) {
			this.packet = packet;
		}

		public EntityPlayer getPlayer() {
			return player;
		}

		@SuppressWarnings("unused")
		public void setPlayer(EntityPlayer player) {
			this.player = player;
		}
	}
}
