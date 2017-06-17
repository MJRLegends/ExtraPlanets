package com.mjr.extraplanets.armor;

import micdoodle8.mods.galacticraft.api.item.IArmorGravity;
import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;

public class Tier1SpaceSuitArmor extends ItemArmor implements IPressureSuit, IRadiationSuit, IArmorGravity, IBreathableArmor {
	public String name;

	public Tier1SpaceSuitArmor(String name, ArmorMaterial material, int placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.tier1SpaceSuitHelmet || stack.getItem() == ExtraPlanets_Armor.tier1SpaceSuitChest || stack.getItem() == ExtraPlanets_Armor.tier1SpaceSuitBoots) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.tier1SpaceSuitLegings) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.tier1SpaceSuitGravityBoots) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_3.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 1;
	}

	@Override
	public int gravityOverrideIfLow(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.getCurrentArmor(i) != null)
				if (p.getCurrentArmor(i).getItem() == ExtraPlanets_Armor.tier1SpaceSuitGravityBoots)
					return 55;
		return 0;
	}

	@Override
	public int gravityOverrideIfHigh(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.getCurrentArmor(i) != null)
				if (p.getCurrentArmor(i).getItem() == ExtraPlanets_Armor.tier1SpaceSuitGravityBoots)
					return 75;
		return 0;
	}

	@Override
	public boolean handleGearType(EnumGearType gearType) {
		return true;
	}

	@Override
	public boolean canBreathe(ItemStack helmetInSlot, EntityPlayer playerWearing, EnumGearType type) {
		return true;
	}
}
