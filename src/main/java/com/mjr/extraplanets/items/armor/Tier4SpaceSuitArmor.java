package com.mjr.extraplanets.items.armor;

import micdoodle8.mods.galacticraft.api.item.IArmorGravity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;

public class Tier4SpaceSuitArmor extends ItemArmor implements IPressureSuit, IRadiationSuit, IArmorGravity {
	public String name;

	public Tier4SpaceSuitArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_HELMET || stack.getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_CHEST || stack.getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_3.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 4;
	}

	@Override
	public int gravityOverrideIfLow(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory[i] != null)
				if (p.inventory.armorInventory[i].getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS)
					return 55;
		return 0;
	}

	@Override
	public int gravityOverrideIfHigh(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory[i] != null)
				if (p.inventory.armorInventory[i].getItem() == ExtraPlanets_Armor.TIER_4_SPACE_SUIT_GRAVITY_BOOTS)
					return 75;
		return 0;
	}
}
