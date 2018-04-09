package com.mjr.extraplanets.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;
import com.mjr.extraplanets.client.model.ArmorCustomModel;
import com.mjr.extraplanets.client.model.ArmorSpaceSuitModel;
import com.mjr.extraplanets.items.armor.bases.JetpackArmorBase;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class Tier3SpaceSuitArmorJetpack extends JetpackArmorBase implements IPressureSuit, IRadiationSuit, IBreathableArmor {
	public String name;

	public Tier3SpaceSuitArmorJetpack(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 1, placement);
		setCreativeTab(ExtraPlanets.ItemsTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_3_SPACE_SUIT_JETPACK_CHEST) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 3;
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
	public void addInformation(ItemStack itemStack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information"));
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.2"));
		list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra"));
		list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra.2"));
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.3"));
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.4"));
		super.addInformation(itemStack, worldIn, list, flagIn);
	}

	public static ModelBiped fillingArmorModel(ModelBiped model, EntityLivingBase entityLiving) {
		if (model == null)
			return model;
		model.bipedHead.showModel = model.bipedHeadwear.showModel = model.bipedBody.showModel = model.bipedRightArm.showModel = model.bipedLeftArm.showModel = model.bipedRightLeg.showModel = model.bipedLeftLeg.showModel = false;
		model.isSneak = entityLiving.isSneaking();
		model.isRiding = entityLiving.isRiding();
		model.isChild = entityLiving.isChild();
		return model;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		ModelBiped armorModel = new ArmorSpaceSuitModel(armorSlot);
		if (itemStack.getItem() instanceof Tier3SpaceSuitArmorJetpack) {
			armorModel = fillingArmorModel(armorModel, entityLiving);
			if (hasColor(itemStack) && armorModel instanceof ArmorCustomModel)
				((ArmorCustomModel) armorModel).color = getColor(itemStack);
		}
		return armorModel;
	}

	public double getJetpackAccelSpeed() {
		return 0.8;
	}

	@Override
	public float getMaxElectricityStored(ItemStack theItem) {
		return 10000*4;
	}

	@Override
	public float powerPerTick() {
		return 0.8F;
	}
}
