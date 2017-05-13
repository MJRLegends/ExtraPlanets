package com.mjr.extraplanets.client.handlers;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.client.KeyHandler;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStatsClient;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.entities.vehicles.EntityPoweredVehicleBase;
import com.mjr.extraplanets.entities.vehicles.EntityVehicleBase;
import com.mjr.extraplanets.network.PacketSimple;
import com.mjr.extraplanets.network.PacketSimple.EnumSimplePacket;

import cpw.mods.fml.common.gameevent.TickEvent.Type;

public class KeyHandlerClient extends KeyHandler {
	public static KeyBinding openFuelGui;

	static {
		openFuelGui = new KeyBinding(GCCoreUtil.translate("keybind.vehicleInv.name"), ConfigManagerCore.keyOverrideFuelLevelI == 0 ? Keyboard.KEY_F : ConfigManagerCore.keyOverrideFuelLevelI, Constants.MOD_NAME_SIMPLE);
	}

	public static KeyBinding accelerateKey;
	public static KeyBinding decelerateKey;
	public static KeyBinding leftKey;
	public static KeyBinding rightKey;
	public static KeyBinding upKey;
	public static KeyBinding downKey;
	public static KeyBinding spaceKey;
	public static KeyBinding leftShiftKey;
	private static Minecraft mc = Minecraft.getMinecraft();

	public KeyHandlerClient() {
		super(new KeyBinding[] { KeyHandlerClient.openFuelGui }, new boolean[] { false, false, false }, KeyHandlerClient.getVanillaKeyBindings(), new boolean[] { false, true, true, true, true, true, true });
	}

	private static KeyBinding[] getVanillaKeyBindings() {
		KeyBinding invKey = KeyHandlerClient.mc.gameSettings.keyBindInventory;
		KeyHandlerClient.accelerateKey = KeyHandlerClient.mc.gameSettings.keyBindForward;
		KeyHandlerClient.decelerateKey = KeyHandlerClient.mc.gameSettings.keyBindBack;
		KeyHandlerClient.leftKey = KeyHandlerClient.mc.gameSettings.keyBindLeft;
		KeyHandlerClient.rightKey = KeyHandlerClient.mc.gameSettings.keyBindRight;
		KeyHandlerClient.upKey = KeyHandlerClient.mc.gameSettings.keyBindForward;
		KeyHandlerClient.downKey = KeyHandlerClient.mc.gameSettings.keyBindBack;
		KeyHandlerClient.spaceKey = KeyHandlerClient.mc.gameSettings.keyBindJump;
		KeyHandlerClient.leftShiftKey = KeyHandlerClient.mc.gameSettings.keyBindSneak;
		return new KeyBinding[] { invKey, KeyHandlerClient.accelerateKey, KeyHandlerClient.decelerateKey, KeyHandlerClient.leftKey, KeyHandlerClient.rightKey, KeyHandlerClient.spaceKey, KeyHandlerClient.leftShiftKey };
	}

	@Override
	public void keyDown(Type types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (KeyHandlerClient.mc.thePlayer != null && tickEnd) {
			EntityClientPlayerMP playerBase = PlayerUtil.getPlayerBaseClientFromPlayer(KeyHandlerClient.mc.thePlayer, false);

			if (playerBase == null) {
				return;
			}

			GCPlayerStatsClient stats = GCPlayerStatsClient.get(playerBase);

			if (kb.getKeyCode() == KeyHandlerClient.openFuelGui.getKeyCode()) {
				if (playerBase.ridingEntity instanceof EntityVehicleBase) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimple(EnumSimplePacket.S_OPEN_FUEL_GUI, new Object[] { playerBase.getGameProfile().getName() }));
				} else if (playerBase.ridingEntity instanceof EntityPoweredVehicleBase) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimple(EnumSimplePacket.S_OPEN_POWER_GUI, new Object[] { playerBase.getGameProfile().getName() }));
				}
			}
		}
	}

	@Override
	public void keyUp(Type types, KeyBinding kb, boolean tickEnd) {
	}
}