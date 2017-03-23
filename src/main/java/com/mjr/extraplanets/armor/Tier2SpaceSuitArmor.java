package com.mjr.extraplanets.armor;

import micdoodle8.mods.galacticraft.api.item.IArmorGravity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;

public class Tier2SpaceSuitArmor extends ItemArmor implements IPressureSuit, IRadiationSuit, IArmorGravity {
	public String name;

	public Tier2SpaceSuitArmor(String name, ArmorMaterial material, int placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.tier2SpaceSuitHelmet || stack.getItem() == ExtraPlanets_Armor.tier2SpaceSuitChest || stack.getItem() == ExtraPlanets_Armor.tier2SpaceSuitBoots) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.tier2SpaceSuitLegings) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.tier2SpaceSuitGravityBoots) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_3.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 2;
	}

	@Override
	public int gravityOverrideIfLow(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.getCurrentArmor(i) != null)
				if (p.getCurrentArmor(i).getItem() == ExtraPlanets_Armor.tier2SpaceSuitGravityBoots)
					return 55;
		return 0;
	}

	@Override
	public int gravityOverrideIfHigh(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.getCurrentArmor(i) != null)
				if (p.getCurrentArmor(i).getItem() == ExtraPlanets_Armor.tier2SpaceSuitGravityBoots)
					return 75;
		return 0;
	}
}
