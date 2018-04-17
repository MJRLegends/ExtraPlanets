package com.mjr.extraplanets.items.armor.bases;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mjr.extraplanets.api.item.IJetpackArmour;

public abstract class JetpackArmorBase extends ElectricArmorBase implements IJetpackArmour {

	public JetpackArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("active") && this.getElectricityStored(stack) >= this.powerPerTick()) {
			useJetPack(player);
			if (player instanceof EntityPlayerMP && !((EntityPlayerMP) player).isCreative())
				this.discharge(stack, this.powerPerTick(), true);
		}
	}

	public void useJetPack(EntityPlayer player) {
		player.motionY = Math.min(player.motionY + this.getJetpackAccelSpeed(), this.getJetpackMaxAccelSpeed());
		player.fallDistance = 0.0F;
	}

	@Override
	public abstract double getJetpackAccelSpeed();

	public abstract double getJetpackMaxAccelSpeed();

	public abstract float powerPerTick();
}
