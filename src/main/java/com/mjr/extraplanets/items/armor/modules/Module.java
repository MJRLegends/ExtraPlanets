package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class Module {
	private String name;
	private List<ItemStack> requirements = new ArrayList<ItemStack>();
	private int slotType;
	private ResourceLocation iconTexture;

	public Module(String name, int slotType, ResourceLocation iconTexture) {
		super();
		this.name = name;
		this.slotType = slotType;
		this.setIconTexture(iconTexture);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemStack> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<ItemStack> requirements) {
		this.requirements = requirements;
	}

	public abstract void tick(EntityPlayerMP player);

	public int getSlotType() {
		return slotType;
	}

	public void setSlotType(int slotType) {
		this.slotType = slotType;
	}

	public ResourceLocation getIconTexture() {
		return iconTexture;
	}

	public void setIconTexture(ResourceLocation iconTexture) {
		this.iconTexture = iconTexture;
	}
}
