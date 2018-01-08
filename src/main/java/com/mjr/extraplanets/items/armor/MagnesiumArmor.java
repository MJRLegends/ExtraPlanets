package com.mjr.extraplanets.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class MagnesiumArmor extends ItemArmor {
	public String name;

	public MagnesiumArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ItemsTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.MAGNESIUM_HELMET || stack.getItem() == ExtraPlanets_Armor.MAGNESIUM_CHEST || stack.getItem() == ExtraPlanets_Armor.MAGNESIUM_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.MAGNESIUM_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else {
			return null;
		}
	}
}
