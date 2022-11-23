package com.mjr.extraplanets.items.armor;

import java.util.HashMap;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.item.IModularArmor;
import com.mjr.extraplanets.api.item.IPressureSuit;
import com.mjr.extraplanets.api.item.IRadiationSuit;
import com.mjr.extraplanets.client.model.ArmorCustomModel;
import com.mjr.extraplanets.client.model.ArmorSpaceSuitModel;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.api.item.IBreathableArmor;
import micdoodle8.mods.galacticraft.core.util.EnumColor;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tier0SpaceSuitArmor extends ItemArmor implements IPressureSuit, IRadiationSuit, IBreathableArmor {
	public static HashMap<EntityEquipmentSlot, ArmorSpaceSuitModel> models = new HashMap<EntityEquipmentSlot, ArmorSpaceSuitModel>();
	public String name;

	public Tier0SpaceSuitArmor(String name, ArmorMaterial material, int placement) {
		super(material, 1, placement);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ExtraPlanets_Armor.TIER_0_SPACE_SUIT_HELMET || stack.getItem() == ExtraPlanets_Armor.TIER_0_SPACE_SUIT_CHEST || stack.getItem() == ExtraPlanets_Armor.TIER_0_SPACE_SUIT_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else if (stack.getItem() == ExtraPlanets_Armor.TIER_0_SPACE_SUIT_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/tier1_space_suit_main.png";
		} else {
			return null;
		}
	}

	@Override
	public boolean isItemTool(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

	@Override
	public int getArmorTier() {
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
		list.add(EnumColor.RED + TranslateUtilities.translate("space.suit.temp.information"));
		list.add(EnumColor.DARK_GREEN + TranslateUtilities.translate("space.suit.temp.ticks") + ": " + getTicksLeft(itemStack) / 20 + " seconds left");
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.2"));
			list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra"));
			list.add(EnumColor.YELLOW + TranslateUtilities.translate("space.suit.information.extra.2"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.3"));
			list.add(EnumColor.AQUA + TranslateUtilities.translate("space.suit.information.extra.4"));
		} else
			list.add(EnumColor.YELLOW + TranslateUtilities.translateWithFormat("item_desc.spacesuit.shift.name", GameSettings.getKeyDisplayString(FMLClientHandler.instance().getClient().gameSettings.keyBindSneak.getKeyCode())));
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
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot, ModelBiped _default) {
		if(models.get(armorSlot) == null)
			models.put(armorSlot, new ArmorSpaceSuitModel(armorSlot));
		ModelBiped armorModel = models.get(armorSlot);
		if (itemStack.getItem() instanceof Tier0SpaceSuitArmor) {
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

		if (helmet != null && helmet.getItem() instanceof IModularArmor)
			for (Module hemletModules : ModuleHelper.getModules(helmet)) {
				if (hemletModules.isActive())
					if (ModuleHelper.hasPower(helmet, ModuleHelper.getModuleUseCost(hemletModules)))
						hemletModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (chest != null && chest.getItem() instanceof IModularArmor)
			for (Module chestModules : ModuleHelper.getModules(chest)) {
				if (chestModules.isActive())
					if (ModuleHelper.hasPower(chest, ModuleHelper.getModuleUseCost(chestModules)))
						chestModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (leggins != null && leggins.getItem() instanceof IModularArmor)
			for (Module legginsModules : ModuleHelper.getModules(leggins)) {
				if (legginsModules.isActive())
					if (ModuleHelper.hasPower(leggins, ModuleHelper.getModuleUseCost(legginsModules)))
						legginsModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
		if (boots != null && boots.getItem() instanceof IModularArmor)
			for (Module bootsModules : ModuleHelper.getModules(boots)) {
				if (bootsModules.isActive())
					if (ModuleHelper.hasPower(boots, ModuleHelper.getModuleUseCost(bootsModules)))
						bootsModules.renderHelmetOverlay(stack, player, resolution, partialTicks);
			}
	}

	public static int getTicksLeft(ItemStack itemStack) {
		if (itemStack.getTagCompound() == null) {
			return 6000;
		}
		return itemStack.getTagCompound().getInteger("ticksLeft");
	}

	public static void setTicksLeft(ItemStack itemStack, int ticksLeft) {
		if (itemStack.getTagCompound() == null) {
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("ticksLeft", 6000);
		}
		itemStack.getTagCompound().setInteger("ticksLeft", ticksLeft);
	}
}
