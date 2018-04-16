package com.mjr.extraplanets.client.handlers;

import micdoodle8.mods.galacticraft.core.client.KeyHandler;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.gameevent.TickEvent.Type;

import org.lwjgl.input.Keyboard;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.item.IJetpackArmour;
import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.api.prefabs.entity.EntityElectricRocketBase;
import com.mjr.extraplanets.api.prefabs.entity.EntityPoweredVehicleBase;
import com.mjr.extraplanets.api.prefabs.entity.EntityVehicleBase;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class KeyHandlerClient extends KeyHandler {
	public static KeyBinding openPowerGUI;
	public static KeyBinding openModuleManagerGUI;

	static {
		openPowerGUI = new KeyBinding(TranslateUtilities.translate("keybind.vehicle_inv.name"), ConfigManagerCore.keyOverrideFuelLevelI == 0 ? Keyboard.KEY_F : ConfigManagerCore.keyOverrideFuelLevelI, Constants.modName);
		openModuleManagerGUI = new KeyBinding(TranslateUtilities.translate("keybind.module.manager.name"), Keyboard.KEY_H, Constants.modName);
	}

	public static KeyBinding accelerateKey;
	public static KeyBinding decelerateKey;
	public static KeyBinding leftKey;
	public static KeyBinding rightKey;
	public static KeyBinding upKey;
	public static KeyBinding downKey;
	public static KeyBinding spaceKey;
	public static KeyBinding leftShiftKey;
	private static Minecraft mc = MCUtilities.getMinecraft();

	public KeyHandlerClient() {
		super(new KeyBinding[] { KeyHandlerClient.openPowerGUI, KeyHandlerClient.openModuleManagerGUI }, new boolean[] { false, false, false }, KeyHandlerClient.getVanillaKeyBindings(), new boolean[] { false, true, true, true, true, true, true });
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
			EntityPlayerSP playerBase = PlayerUtil.getPlayerBaseClientFromPlayer(KeyHandlerClient.mc.thePlayer, false);

			if (playerBase == null) {
				return;
			}

			if (kb.getKeyCode() == KeyHandlerClient.openPowerGUI.getKeyCode()) {
				if (playerBase.ridingEntity instanceof EntityVehicleBase) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_OPEN_FUEL_GUI, mc.theWorld.provider.getDimensionId(), new Object[] { playerBase.getGameProfile().getName() }));
				} else if (playerBase.ridingEntity instanceof EntityPoweredVehicleBase) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_OPEN_POWER_GUI, mc.theWorld.provider.getDimensionId(), new Object[] { playerBase.getGameProfile().getName() }));
				} else if (playerBase.ridingEntity instanceof EntityElectricRocketBase) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_OPEN_POWER_GUI, mc.theWorld.provider.getDimensionId(), new Object[] { playerBase.getGameProfile().getName() }));
				}
			}
			if (kb.getKeyCode() == KeyHandlerClient.spaceKey.getKeyCode() && KeyHandlerClient.mc.currentScreen == null) {
				if (playerBase.inventory.armorItemInSlot(2) != null && playerBase.inventory.armorItemInSlot(2).getItem() instanceof IJetpackArmour) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_UPDATE_JETPACK, mc.theWorld.provider.getDimensionId(), new Object[] { 1 }));
				}
			}

			if (kb.getKeyCode() == KeyHandlerClient.openModuleManagerGUI.getKeyCode()) {
				if (playerBase.inventory.armorItemInSlot(0) != null && playerBase.inventory.armorItemInSlot(0).getItem() instanceof IModularArmor || playerBase.inventory.armorItemInSlot(1) != null
						&& playerBase.inventory.armorItemInSlot(1).getItem() instanceof IModularArmor || playerBase.inventory.armorItemInSlot(2) != null && playerBase.inventory.armorItemInSlot(2).getItem() instanceof IModularArmor
						|| playerBase.inventory.armorItemInSlot(3) != null && playerBase.inventory.armorItemInSlot(3).getItem() instanceof IModularArmor)
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_OPEN_MODULE_MANANGER_GUI, mc.theWorld.provider.getDimensionId(), new Object[] { playerBase.getGameProfile().getName() }));
			}
		}
	}

	@Override
	public void keyUp(Type types, KeyBinding kb, boolean tickEnd) {
		if (KeyHandlerClient.mc.thePlayer != null && tickEnd) {
			EntityPlayerSP playerBase = PlayerUtil.getPlayerBaseClientFromPlayer(KeyHandlerClient.mc.thePlayer, false);
			if (playerBase == null) {
				return;
			}
			if (kb.getKeyCode() == KeyHandlerClient.spaceKey.getKeyCode() && KeyHandlerClient.mc.currentScreen == null) {
				if (playerBase.inventory.armorItemInSlot(2) != null && playerBase.inventory.armorItemInSlot(2).getItem() instanceof IJetpackArmour) {
					ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_UPDATE_JETPACK, mc.theWorld.provider.getDimensionId(), new Object[] { 0 }));
				}
			}
		}
	}
}