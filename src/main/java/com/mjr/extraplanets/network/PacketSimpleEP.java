package com.mjr.extraplanets.network;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.netty.buffer.ByteBuf;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.api.prefabs.entity.EntityElectricRocketBase;
import com.mjr.extraplanets.api.prefabs.entity.EntityPoweredVehicleBase;
import com.mjr.extraplanets.api.prefabs.entity.EntityVehicleBase;
import com.mjr.extraplanets.client.gui.GUIModuleManager;
import com.mjr.extraplanets.client.gui.vehicles.GuiPoweredVehicleBase;
import com.mjr.extraplanets.client.gui.vehicles.GuiVehicleBase;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.client.handlers.capabilities.IStatsClientCapability;
import com.mjr.extraplanets.items.armor.modules.ExtraPlanets_Modules;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.extraplanets.util.ExtraPlanetsUtli;
import com.mjr.mjrlegendslib.network.PacketSimpleBase;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.PlayerUtilties;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase.EnumLaunchPhase;
import micdoodle8.mods.galacticraft.core.client.gui.GuiIdsCore;
import micdoodle8.mods.galacticraft.core.entities.EntityLanderBase;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.items.ItemParaChute;
import micdoodle8.mods.galacticraft.core.network.NetworkUtil;
import micdoodle8.mods.galacticraft.core.tick.KeyHandlerClient;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetHandler;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketSimpleEP extends PacketSimpleBase {
	public enum EnumSimplePacket {
		// SERVER
		S_OPEN_FUEL_GUI(Side.SERVER, String.class), S_OPEN_POWER_GUI(Side.SERVER, String.class), S_IGNITE_ROCKET(Side.SERVER), S_UPDATE_JETPACK(Side.SERVER, Integer.class), S_OPEN_MODULE_MANANGER_GUI(Side.SERVER,
				String.class), S_UNINSTALL_MODULE(Side.SERVER, String.class), S_INSTALL_MODULE(Side.SERVER, String.class), S_UPDATE_MODULE_STATE(Side.SERVER, String.class),

		// CLIENT
		C_DISPLAY_ROCKET_CONTROLS(Side.CLIENT), C_OPEN_PARACHEST_GUI(Side.CLIENT, Integer.class, Integer.class, Integer.class), C_UPDATE_SOLAR_RADIATION_LEVEL(Side.CLIENT, Double.class), C_OPEN_MODULE_MANANGER_GUI(Side.CLIENT, Integer.class,
				Integer.class, Integer.class), C_MOVE_PLAYER(Side.CLIENT, BlockPos.class);

		private Side targetSide;
		private Class<?>[] decodeAs;

		EnumSimplePacket(Side targetSide, Class<?>... decodeAs) {
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
	@SuppressWarnings("unused")
	static private String spamCheckString;

	public PacketSimpleEP() {
		super();
	}

	public PacketSimpleEP(EnumSimplePacket packetType, int dimID, Object[] data) {
		this(packetType, dimID, Arrays.asList(data));
	}

	public PacketSimpleEP(EnumSimplePacket packetType, int dimID, List<Object> data) {
		super(dimID);
		if (packetType.getDecodeClasses().length != data.size()) {
			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Simple Packet Core found data length different than packet type");
			new RuntimeException().printStackTrace();
		}

		this.type = packetType;
		this.data = data;
	}

	@Override
	public void encodeInto(ByteBuf buffer) {
		super.encodeInto(buffer);
		buffer.writeInt(this.type.ordinal());

		try {
			NetworkUtil.encodeData(buffer, this.data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void decodeInto(ByteBuf buffer) {
		super.decodeInto(buffer);
		this.type = EnumSimplePacket.values()[buffer.readInt()];

		try {
			if (this.type.getDecodeClasses().length > 0) {
				this.data = NetworkUtil.decodeData(this.type.getDecodeClasses(), buffer);
			}
			if (buffer.readableBytes() > 0) {
				MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Packet length problem for packet type " + this.type.toString());
			}
		} catch (Exception e) {
			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Error handling simple packet type: " + this.type.toString() + " " + buffer.toString());
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(EntityPlayer player) {
		EntityPlayerSP playerBaseClient = null;
		IStatsClientCapability stats = null;

		if (player instanceof EntityPlayerSP) {
			playerBaseClient = (EntityPlayerSP) player;
			stats = playerBaseClient.getCapability(CapabilityStatsClientHandler.EP_STATS_CLIENT_CAPABILITY, null);
		}

		switch (this.type) {
		case C_OPEN_PARACHEST_GUI:
			switch ((Integer) this.data.get(1)) {
			case 0:
				if (playerBaseClient.ridingEntity instanceof EntityVehicleBase) {
					MCUtilities.getClient().displayGuiScreen(new GuiVehicleBase(playerBaseClient.inventory, (EntityVehicleBase) playerBaseClient.ridingEntity, ((EntityVehicleBase) playerBaseClient.ridingEntity).getType()));
					playerBaseClient.openContainer.windowId = (Integer) this.data.get(0);
				} else if (playerBaseClient.ridingEntity instanceof EntityPoweredVehicleBase) {
					MCUtilities.getClient().displayGuiScreen(new GuiPoweredVehicleBase(playerBaseClient.inventory, (EntityPoweredVehicleBase) playerBaseClient.ridingEntity, ((EntityPoweredVehicleBase) playerBaseClient.ridingEntity).getType()));
					playerBaseClient.openContainer.windowId = (Integer) this.data.get(0);
				}
				break;
			}
			break;
		case C_UPDATE_SOLAR_RADIATION_LEVEL:
			stats.setRadiationLevel((double) this.data.get(0));
			break;
		case C_DISPLAY_ROCKET_CONTROLS:
			PlayerUtilties.sendMessage(playerBaseClient, GameSettings.getKeyDisplayString(KeyHandlerClient.spaceKey.getKeyCode()) + "  - " + GCCoreUtil.translate("gui.rocket.launch.name"));
			PlayerUtilties.sendMessage(playerBaseClient,
					GameSettings.getKeyDisplayString(KeyHandlerClient.leftKey.getKeyCode()) + " / " + GameSettings.getKeyDisplayString(KeyHandlerClient.rightKey.getKeyCode()) + "  - " + GCCoreUtil.translate("gui.rocket.turn.name"));
			PlayerUtilties.sendMessage(playerBaseClient,
					GameSettings.getKeyDisplayString(KeyHandlerClient.accelerateKey.getKeyCode()) + " / " + GameSettings.getKeyDisplayString(KeyHandlerClient.decelerateKey.getKeyCode()) + "  - " + GCCoreUtil.translate("gui.rocket.updown.name"));
			PlayerUtilties.sendMessage(playerBaseClient, GameSettings.getKeyDisplayString(com.mjr.extraplanets.client.handlers.KeyHandlerClient.openPowerGUI.getKeyCode()) + "       - " + GCCoreUtil.translate("gui.powered.inv.name"));
			break;
		case C_OPEN_MODULE_MANANGER_GUI:
			switch ((Integer) this.data.get(1)) {
			case 0:
				MCUtilities.getClient().displayGuiScreen(new GUIModuleManager(playerBaseClient.inventory));
				playerBaseClient.openContainer.windowId = (Integer) this.data.get(0);
				break;
			}
			break;
		case C_MOVE_PLAYER:
			BlockPos pos = (BlockPos) this.data.get(0);
			playerBaseClient.setPosition(pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5);
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
			if (playerBase.ridingEntity instanceof EntityVehicleBase) {
				ExtraPlanetsUtli.openFuelVehicleInv(playerBase, (EntityVehicleBase) playerBase.ridingEntity, ((EntityVehicleBase) playerBase.ridingEntity).getType());
			}
			break;
		case S_OPEN_POWER_GUI:
			if (playerBase.ridingEntity instanceof EntityPoweredVehicleBase) {
				ExtraPlanetsUtli.openPowerVehicleInv(playerBase, (EntityPoweredVehicleBase) playerBase.ridingEntity, ((EntityPoweredVehicleBase) playerBase.ridingEntity).getType());
			} else if (playerBase.ridingEntity instanceof EntityElectricRocketBase) {
				playerBase.openGui(ExtraPlanets.instance, GuiIdsCore.ROCKET_INVENTORY, playerBase.worldObj, (int) playerBase.posX, (int) playerBase.posY, (int) playerBase.posZ);
			}
			break;
		case S_IGNITE_ROCKET:
			if (!playerBase.worldObj.isRemote && !playerBase.isDead && playerBase.ridingEntity != null && !playerBase.ridingEntity.isDead && playerBase.ridingEntity instanceof EntityElectricRocketBase) {
				final EntityElectricRocketBase ship = (EntityElectricRocketBase) playerBase.ridingEntity;

				if (ship.launchPhase != EnumLaunchPhase.LANDING.ordinal()) {
					if (ship.hasValidPower()) {
						ItemStack itemStack2 = GCPlayerStats.get(playerBase).getExtendedInventory().getStackInSlot(4);

						if (itemStack2 != null && itemStack2.getItem() instanceof ItemParaChute || stats.getLaunchAttempts() > 0) {
							ship.igniteCheckingCooldown();
							GCPlayerStats.get(playerBase).setLaunchAttempts(0);
						} else if (stats.getChatCooldown() == 0 && GCPlayerStats.get(playerBase).getLaunchAttempts() == 0) {
							PlayerUtilties.sendMessage(playerBase, TranslateUtilities.translate("gui.rocket.warning.noparachute"));
							stats.setChatCooldown(250);
							GCPlayerStats.get(playerBase).setLaunchAttempts(1);
						}
					} else if (stats.getChatCooldown() == 0) {
						PlayerUtilties.sendMessage(playerBase, TranslateUtilities.translate("gui.rocket.warning.nofuel"));
						stats.setChatCooldown(250);
					}
				}
			}
			break;
		case S_UPDATE_JETPACK:
			if ((int) this.data.get(0) == 1) {
				ItemStack jetpack = playerBase.inventory.armorInventory[1];
				NBTTagCompound tag = new NBTTagCompound();
				if (playerBase.getRidingEntity() instanceof EntityLanderBase || playerBase.getRidingEntity() instanceof EntityElectricRocketBase || playerBase.getRidingEntity() instanceof EntitySpaceshipBase) {
					tag.setBoolean("active", false);
					jetpack.setTagCompound(tag);
				} else {
					tag.setBoolean("active", true);
					jetpack.setTagCompound(tag);
				}
			} else if ((int) this.data.get(0) == 0) {
				ItemStack jetpack = playerBase.inventory.armorInventory[1];
				NBTTagCompound tag = new NBTTagCompound();
				tag.setBoolean("active", false);
				jetpack.setTagCompound(tag);
			}
			break;
		case S_OPEN_MODULE_MANANGER_GUI:
			ExtraPlanetsUtli.openModuleManagerGUI(playerBase);
			break;
		case S_UNINSTALL_MODULE:
			Module uninstallModule = null;
			for (Module temp : ExtraPlanets_Modules.getModules()) {
				if (temp.getName().equalsIgnoreCase((String) this.data.get(0)))
					uninstallModule = temp;
			}
			if (uninstallModule != null) {
				ItemStack stack = playerBase.inventory.armorInventory[3];
				if (stack.getItem() instanceof IModularArmor && ModuleHelper.checkModuleCompact(stack, uninstallModule))
					ModuleHelper.uninstallModule(stack, uninstallModule, playerBase);
				stack = playerBase.inventory.armorInventory[2];
				if (stack.getItem() instanceof IModularArmor && ModuleHelper.checkModuleCompact(stack, uninstallModule))
					ModuleHelper.uninstallModule(stack, uninstallModule, playerBase);
				stack = playerBase.inventory.armorInventory[1];
				if (stack.getItem() instanceof IModularArmor && ModuleHelper.checkModuleCompact(stack, uninstallModule))
					ModuleHelper.uninstallModule(stack, uninstallModule, playerBase);
				stack = playerBase.inventory.armorInventory[0];
				if (stack.getItem() instanceof IModularArmor && ModuleHelper.checkModuleCompact(stack, uninstallModule))
					ModuleHelper.uninstallModule(stack, uninstallModule, playerBase);
			}
			break;
		case S_INSTALL_MODULE:
			Module installModule = null;
			for (Module temp : ExtraPlanets_Modules.getModules()) {
				if (temp.getName().equalsIgnoreCase((String) this.data.get(0)))
					installModule = temp;
			}
			if (installModule != null) {
				boolean missingArmour = true;
				boolean meetRequirements = true;
				boolean alreadyHas = false;
				ItemStack stack = playerBase.inventory.armorInventory[3];
				if (ModuleHelper.checkModuleCompact(stack, installModule)) {
					if (stack.getItem() instanceof IModularArmor) {
						missingArmour = false;
						if (!ModuleHelper.hasModule(stack, installModule))
							if (playerBase.capabilities.isCreativeMode)
								ModuleHelper.addModule(stack, installModule);
							else
								meetRequirements = ModuleHelper.installModule(stack, installModule, playerBase);
						else
							alreadyHas = true;
					} else
						meetRequirements = false;
				}
				stack = playerBase.inventory.armorInventory[2];
				if (ModuleHelper.checkModuleCompact(stack, installModule)) {
					if (stack.getItem() instanceof IModularArmor) {
						missingArmour = false;
						if (!ModuleHelper.hasModule(stack, installModule))
							if (playerBase.capabilities.isCreativeMode)
								ModuleHelper.addModule(stack, installModule);
							else
								meetRequirements = ModuleHelper.installModule(stack, installModule, playerBase);
						else
							alreadyHas = true;

					} else
						meetRequirements = false;
				}
				stack = playerBase.inventory.armorInventory[1];
				if (ModuleHelper.checkModuleCompact(stack, installModule)) {
					if (stack.getItem() instanceof IModularArmor) {
						missingArmour = false;
						if (!ModuleHelper.hasModule(stack, installModule))
							if (playerBase.capabilities.isCreativeMode)
								ModuleHelper.addModule(stack, installModule);
							else
								meetRequirements = ModuleHelper.installModule(stack, installModule, playerBase);
						else
							alreadyHas = true;

					} else
						meetRequirements = false;
				}
				stack = playerBase.inventory.armorInventory[0];
				if (ModuleHelper.checkModuleCompact(stack, installModule)) {
					if (stack.getItem() instanceof IModularArmor) {
						missingArmour = false;
						if (!ModuleHelper.hasModule(stack, installModule))
							if (playerBase.capabilities.isCreativeMode)
								ModuleHelper.addModule(stack, installModule);
							else
								meetRequirements = ModuleHelper.installModule(stack, installModule, playerBase);
						else
							alreadyHas = true;

					} else
						meetRequirements = false;
				}
				if (missingArmour)
					PlayerUtilties.sendMessage(playerBase, TranslateUtilities.translate("gui.module.missing_armour.name"));
				else if (!meetRequirements && !alreadyHas)
					PlayerUtilties.sendMessage(playerBase, TranslateUtilities.translate("gui.module.missing_requirements.name"));
				else if (alreadyHas)
					PlayerUtilties.sendMessage(playerBase, TranslateUtilities.translate("gui.module.already_installed.name"));
				else
					PlayerUtilties.sendMessage(playerBase, TranslateUtilities.translate("gui.module.installed.name"));
			}
			break;
		case S_UPDATE_MODULE_STATE:
			Module installModule2 = null;
			for (Module temp : ExtraPlanets_Modules.getModules()) {
				if (temp.getName().equalsIgnoreCase((String) this.data.get(0)))
					installModule2 = temp;
			}
			if (installModule2 != null) {
				ItemStack temp = playerBase.inventory.armorInventory[installModule2.getSlotType()];
				ModuleHelper.updateModuleActiveState(temp, installModule2, !installModule2.isActive());
			}
			break;
		default:
			break;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void processPacket(INetHandler var1) {
		if (MCUtilities.isClient()) {
			this.handleClientSide(FMLClientHandler.instance().getClientPlayerEntity());
		}
	}
}
