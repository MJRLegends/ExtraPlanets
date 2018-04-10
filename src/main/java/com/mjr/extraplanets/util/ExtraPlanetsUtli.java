package com.mjr.extraplanets.util;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.inventory.ContainerModuleManager;
import com.mjr.extraplanets.inventory.vehicles.ContainerPoweredVehicleBase;
import com.mjr.extraplanets.inventory.vehicles.ContainerVehicleBase;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;

public class ExtraPlanetsUtli {
	public static void openFuelVehicleInv(EntityPlayerMP player, IInventory buggyInv, int type) {
		player.getNextWindowId();
		player.closeContainer();
		int id = player.currentWindowId;
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_OPEN_PARACHEST_GUI, GCCoreUtil.getDimensionID(player.worldObj), new Object[] { id, 0, 0 }), player);
		player.openContainer = new ContainerVehicleBase(player.inventory, buggyInv, type, player);
		player.openContainer.windowId = id;
		player.openContainer.onCraftGuiOpened(player);
	}

	public static void openPowerVehicleInv(EntityPlayerMP player, IInventory buggyInv, int type) {
		player.getNextWindowId();
		player.closeContainer();
		int id = player.currentWindowId;
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_OPEN_PARACHEST_GUI, GCCoreUtil.getDimensionID(player.worldObj), new Object[] { id, 0, 0 }), player);
		player.openContainer = new ContainerPoweredVehicleBase(player.inventory, buggyInv, type, player);
		player.openContainer.windowId = id;
		player.openContainer.onCraftGuiOpened(player);
	}

	public static void openModuleManagerGUI(EntityPlayerMP player) {
		player.getNextWindowId();
		player.closeContainer();
		int id = player.currentWindowId;
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_OPEN_MODULE_MANANGER_GUI, GCCoreUtil.getDimensionID(player.world), new Object[] { id, 0, 0 }), player);
		player.openContainer = new ContainerModuleManager(player.inventory, player);
		player.openContainer.windowId = id;
		player.openContainer.addListener(player);
	}
}