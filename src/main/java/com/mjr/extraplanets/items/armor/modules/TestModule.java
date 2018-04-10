package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TestModule extends Module {

	public TestModule(String name) {
		super(name, 0, new ResourceLocation("minecraft:", "textures/items/arrow.png"));
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(Items.DIAMOND));
		this.setRequirements(items);
	}

	@Override
	public void tick(EntityPlayerMP player) {
		// System.out.println("test");
	}
}
