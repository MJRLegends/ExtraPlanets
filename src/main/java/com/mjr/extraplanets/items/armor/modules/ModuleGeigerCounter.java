package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.client.gui.overlay.OverlayGeigerCounter;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ModuleGeigerCounter extends Module {

	public ModuleGeigerCounter(String name) {
		super(name, 1, new ItemStack(ExtraPlanets_Items.GEIGER_COUNTER), true, 0, 2);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(ExtraPlanets_Items.GEIGER_COUNTER));
		this.setRequirements(items);
	}

	@Override
	public void tickServer(EntityPlayerMP player) {

	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {
		if ((player.ticksExisted - 1) % 20 == 0)ModuleHelper.takeArmourPower(player.inventory.armorItemInSlot(this.getSlotType()), this.getUsePowerCost());
		OverlayGeigerCounter.render();
	}
}
