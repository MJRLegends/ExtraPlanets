package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.items.armor.bases.ElectricArmorBase;
import com.mjr.mjrlegendslib.util.MessageUtilities;

import micdoodle8.mods.galacticraft.core.GCBlocks;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class ModuleSolarPanel extends Module {

	private int tier;

	public ModuleSolarPanel(String name, int tier) {
		super(name, 3, tier == 0 ? new ItemStack(GCBlocks.solarPanel) : new ItemStack(GCBlocks.solarPanel, 1, 4), true, 0, 0);
		this.tier = tier;
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(tier == 0 ? new ItemStack(GCBlocks.solarPanel) : new ItemStack(GCBlocks.solarPanel, 1, 4));
		this.setRequirements(items);
	}

	@Override
	public void tickServer(EntityPlayerMP player) {
		if (player.getEntityWorld().isDaytime()) {
			ItemStack helmet = player.inventory.armorInventory[0];
			ItemStack chest = player.inventory.armorInventory[1];
			ItemStack leggins = player.inventory.armorInventory[2];
			ItemStack boots = player.inventory.armorInventory[3];

			float basePowerToAdd = tier == 0 ? 0.005f : 0.01f;

			if ((player.ticksExisted - 1) % 60 == 0 && Config.DEBUG_MODE)
				MessageUtilities.debugMessageToLog(Constants.modID, "Recharging Full Space Suit with power: " + basePowerToAdd);

			if (helmet.getItem() instanceof ElectricArmorBase) {
				ElectricArmorBase temp = (ElectricArmorBase) helmet.getItem();
				temp.recharge(helmet, basePowerToAdd, true);
				if ((player.ticksExisted - 1) % 60 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Helmet Space Suit Power: " + temp.getElectricityStored(helmet));
			}
			if (chest.getItem() instanceof ElectricArmorBase) {
				ElectricArmorBase temp = (ElectricArmorBase) chest.getItem();
				temp.recharge(chest, basePowerToAdd, true);
				if ((player.ticksExisted - 1) % 60 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Chest Space Suit Power: " + temp.getElectricityStored(helmet));
			}
			if (leggins.getItem() instanceof ElectricArmorBase) {
				ElectricArmorBase temp = (ElectricArmorBase) leggins.getItem();
				temp.recharge(leggins, basePowerToAdd, true);
				if ((player.ticksExisted - 1) % 60 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Leggings Space Suit Power: " + temp.getElectricityStored(helmet));
			}
			if (boots.getItem() instanceof ElectricArmorBase) {
				ElectricArmorBase temp = (ElectricArmorBase) boots.getItem();
				temp.recharge(boots, basePowerToAdd, true);
				if ((player.ticksExisted - 1) % 60 == 0 && Config.DEBUG_MODE)
					MessageUtilities.debugMessageToLog(Constants.modID, "Boots Space Suit Power: " + temp.getElectricityStored(helmet));
			}
		}
	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {

	}

}
