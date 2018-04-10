package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class Module {
	private String name;
	private List<ItemStack> requirements = new ArrayList<ItemStack>();
	private int slotType;
	private ResourceLocation iconTexture;
	private boolean active;

	public Module(String name, List<ItemStack> requirements, int slotType, ResourceLocation iconTexture, boolean active) {
		super();
		this.name = name;
		this.requirements = requirements;
		this.slotType = slotType;
		this.iconTexture = iconTexture;
		this.active = active;
	}

	public Module(String name, int slotType, ResourceLocation iconTexture, boolean active) {
		super();
		this.name = name;
		this.slotType = slotType;
		this.setIconTexture(iconTexture);
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public abstract void tickServer(EntityPlayerMP player);
	public abstract void tickClient(EntityPlayerSP player);
	public abstract void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks);
}
