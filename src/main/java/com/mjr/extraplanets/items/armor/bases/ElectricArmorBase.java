package com.mjr.extraplanets.items.armor.bases;

import java.util.List;

import com.mjr.mjrlegendslib.util.TranslateUtilities;

import ic2.api.item.IElectricItem;
import ic2.api.item.IElectricItemManager;
import ic2.api.item.ISpecialElectricItem;
import micdoodle8.mods.galacticraft.api.item.ElectricItemHelper;
import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import micdoodle8.mods.galacticraft.api.item.IItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.EnergyConfigHandler;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.energy.item.ElectricItemManagerIC2;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.Optional.InterfaceList;

@InterfaceList({ @Optional.Interface(modid = "ic2", iface = "ic2.api.item.IElectricItem"), @Optional.Interface(modid = "ic2", iface = "ic2.api.item.ISpecialElectricItem") })
public abstract class ElectricArmorBase extends ItemArmor implements IItemElectricBase, IItemElectric, ISpecialArmor, IElectricItem, ISpecialElectricItem {

	private static Object itemManagerIC2;
	public float transferMax = 200;
	private static final int DAMAGE_RANGE = 100;

	public ElectricArmorBase(ArmorMaterial materialIn, int renderIndexIn, int placement) {
		super(materialIn, renderIndexIn, placement);
		this.setMaxStackSize(1);
		this.setMaxDamage(DAMAGE_RANGE);
		this.setNoRepair();

		if (EnergyConfigHandler.isIndustrialCraft2Loaded()) {
			itemManagerIC2 = new ElectricItemManagerIC2();
		}
	}

	@Override
	public void setDamage(ItemStack stack, int damage) {
		if (damage != stack.getMaxDamage() - 1)
			super.setDamage(stack, damage);
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
	public boolean showDurabilityBar(ItemStack stack) {
		return false;
	}

	@Override
	public float getMaxTransferGC(ItemStack itemStack) {
		return this.transferMax;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> tooltip, boolean par4) {
		String color = "";
		float joules = this.getElectricityStored(itemStack);

		if (joules <= this.getMaxElectricityStored(itemStack) / 3) {
			color = "\u00a74";
		} else if (joules > this.getMaxElectricityStored(itemStack) * 2 / 3) {
			color = "\u00a72";
		} else {
			color = "\u00a76";
		}

		tooltip.add(color + EnergyDisplayHelper.getEnergyDisplayS(joules) + "/" + EnergyDisplayHelper.getEnergyDisplayS(this.getMaxElectricityStored(itemStack)));
		tooltip.add(EnumColor.RED + TranslateUtilities.translate("space.suit.power.info"));
		tooltip.add(EnumColor.RED + TranslateUtilities.translate("space.suit.power.info.2"));
	}

	/**
	 * Makes sure the item is uncharged when it is crafted and not charged. Change this if you do not want this to happen!
	 */
	@Override
	public void onCreated(ItemStack itemStack, World par2World, EntityPlayer par3EntityPlayer) {
		this.setElectricity(itemStack, 0);
	}

	@Override
	public float recharge(ItemStack itemStack, float energy, boolean doReceive) {
		float rejectedElectricity = Math.max(this.getElectricityStored(itemStack) + energy - this.getMaxElectricityStored(itemStack), 0);
		float energyToReceive = energy - rejectedElectricity;
		if (energyToReceive > this.transferMax) {
			rejectedElectricity += energyToReceive - this.transferMax;
			energyToReceive = this.transferMax;
		}

		if (doReceive) {
			this.setElectricity(itemStack, this.getElectricityStored(itemStack) + energyToReceive);
		}

		return energyToReceive;
	}

	@Override
	public float discharge(ItemStack itemStack, float energy, boolean doTransfer) {
		float thisEnergy = this.getElectricityStored(itemStack);
		float energyToTransfer = Math.min(Math.min(thisEnergy, energy), this.transferMax);

		if (doTransfer) {
			this.setElectricity(itemStack, thisEnergy - energyToTransfer);
		}

		return energyToTransfer;
	}

	@Override
	public int getTierGC(ItemStack itemStack) {
		return 1;
	}

	@Override
	public void setElectricity(ItemStack itemStack, float joules) {
		// Saves the frequency in the ItemStack
		if (itemStack.getTagCompound() == null) {
			itemStack.setTagCompound(new NBTTagCompound());
		}

		float electricityStored = Math.max(Math.min(joules, this.getMaxElectricityStored(itemStack)), 0);
		if (itemStack.getTagCompound().hasKey("electricity")) {
			itemStack.getTagCompound().setFloat("electricity", joules);
		}

		/** Sets the damage as a percentage to render the bar properly. */
		itemStack.setItemDamage(DAMAGE_RANGE - (int) (joules / this.getMaxElectricityStored(itemStack) * DAMAGE_RANGE));
	}

	@Override
	public float getTransfer(ItemStack itemStack) {
		return Math.min(this.transferMax, this.getMaxElectricityStored(itemStack) - this.getElectricityStored(itemStack));
	}

	/**
	 * Gets the energy stored in the item. Energy is stored using item NBT
	 */
	@Override
	public float getElectricityStored(ItemStack itemStack) {
		if (itemStack.getTagCompound() == null) {
			itemStack.setTagCompound(new NBTTagCompound());
		}
		float energyStored = 0f;
		if (itemStack.getTagCompound().hasKey("electricity")) {
			NBTBase obj = itemStack.getTagCompound().getTag("electricity");
			if (obj instanceof NBTTagDouble) {
				energyStored = ((NBTTagDouble) obj).getFloat();
			} else if (obj instanceof NBTTagFloat) {
				energyStored = ((NBTTagFloat) obj).getFloat();
			}
		} else // First time check item - maybe from addInformation() in a JEI recipe display?
		{
			if (itemStack.getItemDamage() == DAMAGE_RANGE)
				return 0F;

			energyStored = this.getMaxElectricityStored(itemStack) * (DAMAGE_RANGE - itemStack.getItemDamage()) / DAMAGE_RANGE;
			itemStack.getTagCompound().setFloat("electricity", energyStored);
		}

		/** Sets the damage as a percentage to render the bar properly. */
		itemStack.setItemDamage(DAMAGE_RANGE - (int) (energyStored / this.getMaxElectricityStored(itemStack) * DAMAGE_RANGE));
		return energyStored;

	}

	@Override
	public void getSubItems(Item par1, CreativeTabs tab, List<ItemStack> list) {
		if (tab == this.getCreativeTab()) {
			list.add(ElectricItemHelper.getUncharged(new ItemStack(this)));
			list.add(ElectricItemHelper.getWithCharge(new ItemStack(this), this.getMaxElectricityStored(new ItemStack(this))));
		}
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		discharge(stack, 2.5F * damage, true);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {

		return new ArmorProperties(1, 0.20D, Integer.MAX_VALUE);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 5;
	}

	public static boolean isElectricItem(Item item) {
		if (item instanceof IItemElectricBase) {
			return true;
		}

		if (EnergyConfigHandler.isIndustrialCraft2Loaded()) {
			if (item instanceof ic2.api.item.ISpecialElectricItem) {
				return true;
			}
		}

		return false;
	}

	public static boolean isElectricItemEmpty(ItemStack itemstack) {
		if (itemstack == null) {
			return false;
		}
		Item item = itemstack.getItem();

		if (item instanceof IItemElectricBase) {
			return ((IItemElectricBase) item).getElectricityStored(itemstack) <= 0;
		}

		if (EnergyConfigHandler.isIndustrialCraft2Loaded()) {
			if (item instanceof ic2.api.item.IElectricItem) {
				return !((ic2.api.item.IElectricItem) item).canProvideEnergy(itemstack);
			}
		}

		return false;
	}

	public static boolean isElectricItemCharged(ItemStack itemstack) {
		if (itemstack == null)
			return false;
		Item item = itemstack.getItem();

		if (item instanceof IItemElectricBase) {
			return ((IItemElectricBase) item).getElectricityStored(itemstack) > 0;
		}

		if (EnergyConfigHandler.isIndustrialCraft2Loaded()) {
			if (item instanceof ic2.api.item.IElectricItem) {
				return ((ic2.api.item.IElectricItem) item).canProvideEnergy(itemstack);
			}
		}

		return false;
	}

	// IC2 Compact
	@Override
	public IElectricItemManager getManager(ItemStack itemstack) {
		return (IElectricItemManager) ElectricArmorBase.itemManagerIC2;
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return true;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 1;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack) {
		return this.getMaxElectricityStored(itemStack) / EnergyConfigHandler.IC2_RATIO;
	}

	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return this.transferMax * EnergyConfigHandler.TO_IC2_RATIO;
	}
}
