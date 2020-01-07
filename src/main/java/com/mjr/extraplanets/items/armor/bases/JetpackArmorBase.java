package com.mjr.extraplanets.items.armor.bases;

import com.mjr.extraplanets.api.item.IJetpackArmour;
import com.mjr.extraplanets.client.model.SpaceSuitJetPackFlame;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class JetpackArmorBase extends ElectricArmorBase implements IJetpackArmour {

	public JetpackArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("active") && this.getElectricityStored(stack) >= this.powerPerTick()) {
			useJetPack(player);
			if (player instanceof EntityPlayerMP && !((EntityPlayerMP) player).isCreative()) {
				if ((player.ticksExisted - 1) % 20 == 0)
					this.discharge(stack, this.powerPerTick(), true);
			} else if (world.isRemote) {
				SpaceSuitJetPackFlame.spawnFlames(world, player, stack);
			}
		}
	}

	public void useJetPack(EntityPlayer player) {
		player.motionY = Math.min(player.motionY + this.getJetpackAccelSpeed(), this.getJetpackMaxAccelSpeed());
		player.fallDistance = 0.0F;
	}

	@Override
	public abstract double getJetpackAccelSpeed();

	@Override
	public abstract double getJetpackMaxAccelSpeed();

	@Override
	public abstract float powerPerTick();
}
