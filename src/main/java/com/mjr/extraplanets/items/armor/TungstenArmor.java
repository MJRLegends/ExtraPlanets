package com.mjr.extraplanets.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class TungstenArmor extends ItemArmor {
	public String name;

	public TungstenArmor(String name, ArmorMaterial material, int placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if (itemStack.getItem() == ExtraPlanets_Armor.TUNGSTEN_HELMET || itemStack.getItem() == ExtraPlanets_Armor.TUNGSTEN_CHEST || itemStack.getItem() == ExtraPlanets_Armor.TUNGSTEN_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (itemStack.getItem() == ExtraPlanets_Armor.TUNGSTEN_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else {
			return null;
		}
	}
}
