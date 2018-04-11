package com.mjr.extraplanets.items.armor.bases;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mjr.extraplanets.api.IJetpackArmour;

public abstract class JetpackArmorBase extends ElectricArmorBase implements IJetpackArmour {
	public boolean activeJetPack = false;

	public JetpackArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (activeJetPack) {
			useJetPack(player);
			this.discharge(stack, this.powerPerTick(), true);
		}
	}

	public void useJetPack(EntityPlayer player) {
		player.motionY = Math.min(player.motionY + 0.5, this.getJetpackAccelSpeed());
		player.fallDistance = 0.0F;
	}

	@Override
	public abstract double getJetpackAccelSpeed();

	public abstract float powerPerTick();
}
