package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TestModule extends Module {

	public TestModule(String name) {
		super(name, 3, new ItemStack(Items.arrow), true);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(Items.diamond));
		this.setRequirements(items);
	}

	@Override
	public void tickServer(EntityPlayerMP player) {
		// System.out.println("test");
	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {

	}
}
