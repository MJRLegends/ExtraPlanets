package com.mjr.extraplanets.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class MercuryArmor extends ItemArmor{
	public String name;

	public MercuryArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}
	@Override
	    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		if(stack.getItem() == ExtraPlanets_Armor.mercuryHelmet || stack.getItem() == ExtraPlanets_Armor.mercuryChest || stack.getItem() == ExtraPlanets_Armor.mercuryBoots){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		}
		else if(stack.getItem() == ExtraPlanets_Armor.mercuryLegings){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		}
		else{
			return null;
		}
	}
}
