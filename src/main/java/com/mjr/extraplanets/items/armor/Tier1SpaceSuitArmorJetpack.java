package com.mjr.extraplanets.items.armor;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.ElectricItemHelper;
import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.api.item.IPressureSuit;
import com.mjr.extraplanets.api.item.IRadiationSuit;
import com.mjr.extraplanets.client.model.ArmorCustomModel;
import com.mjr.extraplanets.client.model.ArmorSpaceSuitModel;
import com.mjr.extraplanets.items.armor.bases.JetpackArmorBase;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class Tier1SpaceSuitArmorJetpack extends JetpackArmorBase implements IPressureSuit, IRadiationSuit, IBreathableArmor, IModularArmor {
	public String name;

	public Tier1SpaceSuitArmorJetpack(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 1, placement);
		this.setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_JETPACK_CHEST) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else {
			return null;
		}
	}

	@Override
	public int getArmorTier() {
		return 1;
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
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4) {
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information"));
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.2"));
		list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra"));
		list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra.2"));
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.3"));
		list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.4"));
		super.addInformation(itemStack, player, list, par4);
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
		if (itemStack.getItem() instanceof Tier1SpaceSuitArmorJetpack) {
			armorModel = fillingArmorModel(armorModel, entityLiving);
			if (hasColor(itemStack) && armorModel instanceof ArmorCustomModel)
				((ArmorCustomModel) armorModel).color = getColor(itemStack);
		}
		return armorModel;
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		list.add(ElectricItemHelper.getUncharged(new ItemStack(this)));
		list.add(ElectricItemHelper.getWithCharge(new ItemStack(this), this.getMaxElectricityStored(new ItemStack(this))));
	}

	public double getJetpackAccelSpeed() {
		return 0.15D;
	}

	@Override
	public double getJetpackMaxAccelSpeed() {
		return 0.5D;
	}
	
	@Override
	public float getMaxElectricityStored(ItemStack theItem) {
		return 10000 * 5;
	}

	@Override
	public float powerPerTick() {
		return 0.035F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {
		ItemStack helmet = player.inventory.armorInventory.get(3);
		ItemStack chest = player.inventory.armorInventory.get(2);
		ItemStack leggins = player.inventory.armorInventory.get(1);
		ItemStack boots = player.inventory.armorInventory.get(0);

		if (helmet.getItem() instanceof IModularArmor)
			for (Module hemletModules : ModuleHelper.getModules(helmet)) {
				if (hemletModules.isActive())
					hemletModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (chest.getItem() instanceof IModularArmor)
			for (Module chestModules : ModuleHelper.getModules(chest)) {
				if (chestModules.isActive())
					chestModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (leggins.getItem() instanceof IModularArmor)
			for (Module legginsModules : ModuleHelper.getModules(leggins)) {
				if (legginsModules.isActive())
					legginsModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (boots.getItem() instanceof IModularArmor)
			for (Module bootsModules : ModuleHelper.getModules(boots)) {
				if (bootsModules.isActive())
					bootsModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
	}
}
