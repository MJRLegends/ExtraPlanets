package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class ModulePreLaunchChecklist extends Module {

	public ModulePreLaunchChecklist(String name) {
		super(name, 2, new ItemStack(GCItems.prelaunchChecklist), false, 0, 50);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(GCItems.prelaunchChecklist, 1, 0));
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

	}

}
