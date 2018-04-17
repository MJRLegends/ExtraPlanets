package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ModuleNoFallDamage extends Module {

	public ModuleNoFallDamage(String name) {
		super(name, 3, new ItemStack(ExtraPlanets_Items.MODULE_ITEMS), true, 10, 100);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(ExtraPlanets_Items.MODULE_ITEMS, 1, 0));
		this.setRequirements(items);
	}

	@Override
	public void tickServer(EntityPlayerMP player) {
		if (player.fallDistance != 0F) {
			ModuleHelper.takeArmourPower(player.inventory.armorItemInSlot(this.getSlotType()), this.getUsePowerCost());
			player.fallDistance = 0F;
		}
	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {

	}
}
