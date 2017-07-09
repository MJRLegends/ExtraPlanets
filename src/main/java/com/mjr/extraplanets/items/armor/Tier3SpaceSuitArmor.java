package com.mjr.extraplanets.items.armor;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IArmorGravity;
import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;

public class Tier3SpaceSuitArmor extends ItemArmor implements IPressureSuit, IRadiationSuit, IArmorGravity, IBreathableArmor  {
	public String name;

	public Tier3SpaceSuitArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_HELMET || stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_CHEST || stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_3.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 3;
	}

	@Override
	public int gravityOverrideIfLow(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory.get(i) != null)
				if (p.inventory.armorInventory.get(i).getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS)
					return 55;
		return 0;
	}

	@Override
	public int gravityOverrideIfHigh(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory.get(i) != null)
				if (p.inventory.armorInventory.get(i).getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_GRAVITY_BOOTS)
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (player.world.isRemote) {
			list.add(EnumColor.AQUA + GCCoreUtil.translate("tier3.space.suit.information"));
		}
	}
}
