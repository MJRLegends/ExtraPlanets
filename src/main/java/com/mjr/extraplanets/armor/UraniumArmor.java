package com.mjr.extraplanets.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class UraniumArmor extends ItemArmor{
	public String name;

	public UraniumArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}
	@Override
	    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		if(stack.getItem() == ExtraPlanets_Armor.uraniumHelmet || stack.getItem() == ExtraPlanets_Armor.uraniumChest || stack.getItem() == ExtraPlanets_Armor.uraniumBoots){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		}
		else if(stack.getItem() == ExtraPlanets_Armor.uraniumLegings){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		}
		else{
			return null;
		}
	}
}
