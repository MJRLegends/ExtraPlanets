package com.mjr.extraplanets.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IArmorSuit;
import com.mjr.extraplanets.api.IItemPressure;

public class Tier4SpaceSuitArmor extends ItemArmor implements IItemPressure, IArmorSuit{
	public String name;

	public Tier4SpaceSuitArmor(String name, ArmorMaterial material, int placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(stack.getItem() == ExtraPlanets_Armor.tier4SpaceSuitHelmet || stack.getItem() == ExtraPlanets_Armor.tier4SpaceSuitChest || stack.getItem() == ExtraPlanets_Armor.tier4SpaceSuitBoots){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		}
		else if(stack.getItem() == ExtraPlanets_Armor.tier4SpaceSuitLegings){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		}
		else{
			return null;
		}
	}
	@Override
	public int getArmorTier() {
		return 4;
	}
}
