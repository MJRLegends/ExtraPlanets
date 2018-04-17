package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class ModulePortableNASAWorkBench extends Module {

	public ModulePortableNASAWorkBench(String name) {
		super(name, 1, new ItemStack(GCBlocks.nasaWorkbench), false, 0, 5000);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(GCBlocks.nasaWorkbench));
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
