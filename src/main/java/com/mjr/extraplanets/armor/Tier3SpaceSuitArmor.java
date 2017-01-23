package com.mjr.extraplanets.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IRadiationSuit;
import com.mjr.extraplanets.api.IItemPressure;

public class Tier3SpaceSuitArmor extends ItemArmor implements IItemPressure, IRadiationSuit{
	public String name;

	public Tier3SpaceSuitArmor(String name, ArmorMaterial material, int placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(stack.getItem() == ExtraPlanets_Armor.tier3SpaceSuitHelmet || stack.getItem() == ExtraPlanets_Armor.tier3SpaceSuitChest || stack.getItem() == ExtraPlanets_Armor.tier3SpaceSuitBoots){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		}
		else if(stack.getItem() == ExtraPlanets_Armor.tier3SpaceSuitLegings){
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		}
		else{
			return null;
		}
	}
	@Override
	public int getArmorTier() {
		return 3;
	}
}
