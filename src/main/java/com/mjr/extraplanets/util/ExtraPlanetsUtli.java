package com.mjr.extraplanets.util;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.inventory.ContainerModuleManager;
import com.mjr.extraplanets.inventory.vehicles.ContainerPoweredVehicleBase;
import com.mjr.extraplanets.inventory.vehicles.ContainerVehicleBase;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;
import com.mjr.mjrlegendslib.util.MessageUtilities;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;

public class ExtraPlanetsUtli {
	public static void openFuelVehicleInv(EntityPlayerMP player, IInventory buggyInv, int type) {
		player.getNextWindowId();
		player.closeContainer();
		int id = player.currentWindowId;
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_OPEN_PARACHEST_GUI, GCCoreUtil.getDimensionID(player.world), new Object[] { id, 0, 0 }), player);
		player.openContainer = new ContainerVehicleBase(player.inventory, buggyInv, type, player);
		player.openContainer.windowId = id;
		player.openContainer.addListener(player);
	}

	public static void openPowerVehicleInv(EntityPlayerMP player, IInventory buggyInv, int type) {
		player.getNextWindowId();
		player.closeContainer();
		int id = player.currentWindowId;
		ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(EnumSimplePacket.C_OPEN_PARACHEST_GUI, GCCoreUtil.getDimensionID(player.world), new Object[] { id, 0, 0 }), player);
		player.openContainer = new ContainerPoweredVehicleBase(player.inventory, buggyInv, type, player);
		player.openContainer.windowId = id;
		player.openContainer.addListener(player);
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

	public static int getRandom(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Min " + min + " greater than max " + max);
		}
		return (int) (min + Math.random() * ((long) max - min + 1));
	}
	
	public static boolean isClassAvailable(final String className) {
        try {
            final Class<?> clazz = Class.forName(className);
            return clazz != null;
        } catch (final ClassNotFoundException e) {
            return false;
        } catch (final Throwable e) {
            MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Unknown error when checking for class existing");
            return false;
        }
    }
}