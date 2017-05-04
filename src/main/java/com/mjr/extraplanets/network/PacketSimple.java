package com.mjr.extraplanets.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStatsClient;
import micdoodle8.mods.galacticraft.core.network.IPacket;
import micdoodle8.mods.galacticraft.core.network.NetworkUtil;
import micdoodle8.mods.galacticraft.core.util.GCLog;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

import com.mjr.extraplanets.client.gui.vehicles.GuiVehicleBase;
import com.mjr.extraplanets.entities.vehicles.EntityVehicleBase;
import com.mjr.extraplanets.util.ExtraPlanetsUtli;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketSimple extends Packet implements IPacket {
	public static enum EnumSimplePacket {
		// SERVER
		S_OPEN_FUEL_GUI(Side.SERVER, String.class),

		// CLIENT
		C_OPEN_PARACHEST_GUI(Side.CLIENT, Integer.class, Integer.class, Integer.class);

		private Side targetSide;
		private Class<?>[] decodeAs;

		private EnumSimplePacket(Side targetSide, Class<?>... decodeAs) {
			this.targetSide = targetSide;
			this.decodeAs = decodeAs;
		}

		public Side getTargetSide() {
			return this.targetSide;
		}

		public Class<?>[] getDecodeClasses() {
			return this.decodeAs;
		}
	}

	private EnumSimplePacket type;
	private List<Object> data;

	public PacketSimple() {
	}

	public PacketSimple(EnumSimplePacket packetType, Object[] data) {
		this(packetType, Arrays.asList(data));
	}

	public PacketSimple(EnumSimplePacket packetType, List<Object> data) {
		if (packetType.getDecodeClasses().length != data.size()) {
			GCLog.info("Simple Packet Core found data length different than packet type");
			new RuntimeException().printStackTrace();
		}

		this.type = packetType;
		this.data = data;
	}

	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		buffer.writeInt(this.type.ordinal());

		try {
			NetworkUtil.encodeData(buffer, this.data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		this.type = EnumSimplePacket.values()[buffer.readInt()];

		try {
			if (this.type.getDecodeClasses().length > 0) {
				this.data = NetworkUtil.decodeData(this.type.getDecodeClasses(), buffer);
			}
			if (buffer.readableBytes() > 0) {
				GCLog.severe("Galacticraft packet length problem for packet type " + this.type.toString());
			}
		} catch (Exception e) {
			System.err.println("[Galacticraft] Error handling simple packet type: " + this.type.toString() + " " + buffer.toString());
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(EntityPlayer player) {
		EntityClientPlayerMP playerBaseClient = null;
		GCPlayerStatsClient stats = null;

		if (player instanceof EntityClientPlayerMP) {
			playerBaseClient = (EntityClientPlayerMP) player;
			stats = GCPlayerStatsClient.get(playerBaseClient);
		}

		switch (this.type) {
		case C_OPEN_PARACHEST_GUI:
			switch ((Integer) this.data.get(1)) {
			case 0:
				if (player.ridingEntity instanceof EntityVehicleBase) {
					FMLClientHandler.instance().getClient().displayGuiScreen(new GuiVehicleBase(player.inventory, (EntityVehicleBase) player.ridingEntity, ((EntityVehicleBase) player.ridingEntity).getType()));
					player.openContainer.windowId = (Integer) this.data.get(0);
				}
				break;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(player, false);

		if (playerBase == null) {
			return;
		}

		GCPlayerStats stats = GCPlayerStats.get(playerBase);

		switch (this.type) {
		case S_OPEN_FUEL_GUI:
			if (player.ridingEntity instanceof EntityVehicleBase) {
				ExtraPlanetsUtli.openVehicleInv(playerBase, (EntityVehicleBase) player.ridingEntity, ((EntityVehicleBase) player.ridingEntity).getType());
			}
			break;
		default:
			break;
		}
	}

	/*
	 * 
	 * BEGIN "net.minecraft.network.Packet" IMPLEMENTATION
	 * 
	 * This is for handling server->client packets before the player has joined the world
	 */

	@Override
	public void readPacketData(PacketBuffer var1) {
		this.decodeInto(null, var1);
	}

	@Override
	public void writePacketData(PacketBuffer var1) {
		this.encodeInto(null, var1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void processPacket(INetHandler var1) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			this.handleClientSide(FMLClientHandler.instance().getClientPlayerEntity());
		}
	}

	/*
	 * 
	 * END "net.minecraft.network.Packet" IMPLEMENTATION
	 * 
	 * This is for handling server->client packets before the player has joined the world
	 */
}