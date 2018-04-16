package com.mjr.extraplanets.items.armor.bases;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mjr.extraplanets.api.item.IJetpackArmour;

public abstract class JetpackArmorBase extends ElectricArmorBase implements IJetpackArmour {
	public boolean activeJetPack = false;

	public JetpackArmorBase(ArmorMaterial materialIn, int renderIndexIn, int placement) {
		super(materialIn, renderIndexIn, placement);
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
