package com.mjr.extraplanets.items.armor;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IArmorGravity;
import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IModularArmor;
import com.mjr.extraplanets.api.IPressureSuit;
import com.mjr.extraplanets.api.IRadiationSuit;
import com.mjr.extraplanets.client.model.ArmorCustomModel;
import com.mjr.extraplanets.client.model.ArmorSpaceSuitModel;
import com.mjr.extraplanets.items.armor.modules.ExtraPlanets_Modules;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class Tier1SpaceSuitArmor extends ItemArmor implements IPressureSuit, IRadiationSuit, IArmorGravity, IBreathableArmor, IModularArmor {
	public String name;

	public Tier1SpaceSuitArmor(String name, ArmorMaterial material, EntityEquipmentSlot placement) {
		super(material, 1, placement);
		this.setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_HELMET || stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_CHEST || stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS) {
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
	public int gravityOverrideIfLow(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory[i] != null)
				if (p.inventory.armorInventory[i].getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS)
					return 55;
		return 0;
	}

	@Override
	public int gravityOverrideIfHigh(EntityPlayer p) {
		for (int i = 0; i < 4; i++)
			if (p.inventory.armorInventory[i] != null)
				if (p.inventory.armorInventory[i].getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_GRAVITY_BOOTS)
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
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4) {
		if (player.worldObj.isRemote) {
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.2"));
			list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra"));
			list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra.2"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.3"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.4"));
		}
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
		if (itemStack.getItem() instanceof Tier1SpaceSuitArmor) {
			armorModel = fillingArmorModel(armorModel, entityLiving);
			if (hasColor(itemStack) && armorModel instanceof ArmorCustomModel)
				((ArmorCustomModel) armorModel).color = getColor(itemStack);
		}
		return armorModel;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {
		ItemStack helmet = player.inventory.armorInventory[3];
		ItemStack chest = player.inventory.armorInventory[2];
		ItemStack leggins = player.inventory.armorInventory[1];
		ItemStack boots = player.inventory.armorInventory[0];

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

	/*
	 * Testing Purposes
	 */

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_1_SPACE_SUIT_HELMET && !stack.hasTagCompound()) {
			ModuleHelper.setupModulesNBT(stack);
			ModuleHelper.addModule(stack, ExtraPlanets_Modules.getModules().get(0), true);
			ModuleHelper.addModule(stack, ExtraPlanets_Modules.getModules().get(1), true);
		}
	}
}
