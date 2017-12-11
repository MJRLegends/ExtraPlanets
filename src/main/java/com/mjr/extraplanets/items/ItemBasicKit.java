package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicKit extends Item {
	public int tier;

	public static final String[] names = { "full", "basic_setup", "without_oxygen_setup", "without_thermal_padding", "just_oxygen_setup", "just_protection" };

	public ItemBasicKit(String assetName, int tier) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
		this.tier = tier;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + ItemBasicKit.names[itemStack.getItemDamage()];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemBasicKit.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			GCPlayerStats stats = GCPlayerStats.get((EntityPlayerMP) player);
			// Oxygen Setup
			ItemStack gear = stats.extendedInventory.getStackInSlot(0);
			ItemStack gear1 = stats.extendedInventory.getStackInSlot(1);
			ItemStack gear2 = stats.extendedInventory.getStackInSlot(2);
			ItemStack gear3 = stats.extendedInventory.getStackInSlot(3);
			// Parachute
			ItemStack gear4 = stats.extendedInventory.getStackInSlot(4);
			// Frequency Module
			ItemStack gear5 = stats.extendedInventory.getStackInSlot(5);
			// Thermal Padding
			ItemStack gear6 = stats.extendedInventory.getStackInSlot(6);
			ItemStack gear7 = stats.extendedInventory.getStackInSlot(7);
			ItemStack gear8 = stats.extendedInventory.getStackInSlot(8);
			ItemStack gear9 = stats.extendedInventory.getStackInSlot(9);
			// Shield
			ItemStack gear10 = stats.extendedInventory.getStackInSlot(10);
			ItemStack thermalPadding1 = null;
			ItemStack thermalPadding2 = null;
			ItemStack thermalPadding3 = null;
			ItemStack thermalPadding4 = null;

			ItemStack oxygenTank1 = null;
			ItemStack oxygenTank2 = null;

			// Tier 1 = Overworld Space Station, Moon, Mars, Asteroids
			// Tier 2 = Venus
			// Tier 3 = Mercury, Mercury Space Station - Tier 1 Space Suit
			// Tier 4 = Jupiter and Saturn including their moons - Tier 2 Space Suit
			// Tier 5 = Uranus, Neptune, Pluto and Eris including their moons - Tier 3 Space Suit
			// Tier 6 = Same as Tier 5 kit - Tier 4 Space Suit

			if (this.tier == 1) {
				thermalPadding1 = new ItemStack(AsteroidsItems.thermalPadding, 1, 0);
				thermalPadding2 = new ItemStack(AsteroidsItems.thermalPadding, 1, 1);
				thermalPadding3 = new ItemStack(AsteroidsItems.thermalPadding, 1, 2);
				thermalPadding4 = new ItemStack(AsteroidsItems.thermalPadding, 1, 3);
				oxygenTank1 = new ItemStack(GCItems.oxTankLight);
				oxygenTank2 = new ItemStack(GCItems.oxTankLight);
			} else if (this.tier == 2) {
				thermalPadding1 = new ItemStack(ExtraPlanets_Items.tier2ThermalPadding, 1, 0);
				thermalPadding2 = new ItemStack(ExtraPlanets_Items.tier2ThermalPadding, 1, 1);
				thermalPadding3 = new ItemStack(ExtraPlanets_Items.tier2ThermalPadding, 1, 2);
				thermalPadding4 = new ItemStack(ExtraPlanets_Items.tier2ThermalPadding, 1, 3);
				oxygenTank1 = new ItemStack(GCItems.oxTankMedium);
				oxygenTank2 = new ItemStack(GCItems.oxTankMedium);
			} else if (this.tier == 3) {
				thermalPadding1 = new ItemStack(ExtraPlanets_Items.tier3ThermalPadding, 1, 0);
				thermalPadding2 = new ItemStack(ExtraPlanets_Items.tier3ThermalPadding, 1, 1);
				thermalPadding3 = new ItemStack(ExtraPlanets_Items.tier3ThermalPadding, 1, 2);
				thermalPadding4 = new ItemStack(ExtraPlanets_Items.tier3ThermalPadding, 1, 3);
				oxygenTank1 = new ItemStack(GCItems.oxTankHeavy);
				oxygenTank2 = new ItemStack(GCItems.oxTankHeavy);
			} else if (this.tier == 4) {
				thermalPadding1 = new ItemStack(ExtraPlanets_Items.tier4ThermalPadding, 1, 0);
				thermalPadding2 = new ItemStack(ExtraPlanets_Items.tier4ThermalPadding, 1, 1);
				thermalPadding3 = new ItemStack(ExtraPlanets_Items.tier4ThermalPadding, 1, 2);
				thermalPadding4 = new ItemStack(ExtraPlanets_Items.tier4ThermalPadding, 1, 3);
				oxygenTank1 = new ItemStack(GCItems.oxTankHeavy);
				oxygenTank2 = new ItemStack(GCItems.oxTankHeavy);
			}

			// Basic Kit adding
			switch (itemStack.getMaxDamage()) {
			case 0:
				if (gear == null) {
					stats.extendedInventory.setInventorySlotContents(0, new ItemStack(GCItems.oxMask));
				}
				if (gear1 == null) {
					stats.extendedInventory.setInventorySlotContents(1, new ItemStack(GCItems.oxygenGear));
				}
				if (gear2 == null) {
					stats.extendedInventory.setInventorySlotContents(2, oxygenTank1);
				}
				if (gear3 == null) {
					stats.extendedInventory.setInventorySlotContents(3, oxygenTank2);
				}
				if (gear4 == null) {
					stats.extendedInventory.setInventorySlotContents(4, new ItemStack(GCItems.parachute));
				}
				if (gear5 == null) {
					stats.extendedInventory.setInventorySlotContents(5, new ItemStack(GCItems.basicItem, 1, 19));
				}
				if (gear6 == null) {
					stats.extendedInventory.setInventorySlotContents(6, thermalPadding1);
				}
				if (gear7 == null) {
					stats.extendedInventory.setInventorySlotContents(7, thermalPadding2);
				}
				if (gear8 == null) {
					stats.extendedInventory.setInventorySlotContents(8, thermalPadding3);
				}
				if (gear9 == null) {
					stats.extendedInventory.setInventorySlotContents(9, thermalPadding4);
				}
				break;
			case 1:
				if (gear == null) {
					stats.extendedInventory.setInventorySlotContents(0, new ItemStack(GCItems.oxMask));
				}
				if (gear1 == null) {
					stats.extendedInventory.setInventorySlotContents(1, new ItemStack(GCItems.oxygenGear));
				}
				if (gear2 == null) {
					stats.extendedInventory.setInventorySlotContents(2, oxygenTank1);
				}
				if (gear3 == null) {
					stats.extendedInventory.setInventorySlotContents(3, oxygenTank2);
				}
				if (gear4 == null) {
					stats.extendedInventory.setInventorySlotContents(4, new ItemStack(GCItems.parachute));
				}
				break;
			case 2:
				if (gear4 == null) {
					stats.extendedInventory.setInventorySlotContents(4, new ItemStack(GCItems.parachute));
				}
				if (gear5 == null) {
					stats.extendedInventory.setInventorySlotContents(5, new ItemStack(GCItems.basicItem, 1, 19));
				}
				if (gear6 == null) {
					stats.extendedInventory.setInventorySlotContents(6, thermalPadding1);
				}
				if (gear7 == null) {
					stats.extendedInventory.setInventorySlotContents(7, thermalPadding2);
				}
				if (gear8 == null) {
					stats.extendedInventory.setInventorySlotContents(8, thermalPadding3);
				}
				if (gear9 == null) {
					stats.extendedInventory.setInventorySlotContents(9, thermalPadding4);
				}
				break;
			case 3:
				if (gear == null) {
					stats.extendedInventory.setInventorySlotContents(0, new ItemStack(GCItems.oxMask));
				}
				if (gear1 == null) {
					stats.extendedInventory.setInventorySlotContents(1, new ItemStack(GCItems.oxygenGear));
				}
				if (gear2 == null) {
					stats.extendedInventory.setInventorySlotContents(2, oxygenTank1);
				}
				if (gear3 == null) {
					stats.extendedInventory.setInventorySlotContents(3, oxygenTank2);
				}
				if (gear4 == null) {
					stats.extendedInventory.setInventorySlotContents(4, new ItemStack(GCItems.parachute));
				}
				if (gear5 == null) {
					stats.extendedInventory.setInventorySlotContents(5, new ItemStack(GCItems.basicItem, 1, 19));
				}
				break;
			case 4:
				if (gear == null) {
					stats.extendedInventory.setInventorySlotContents(0, new ItemStack(GCItems.oxMask));
				}
				if (gear1 == null) {
					stats.extendedInventory.setInventorySlotContents(1, new ItemStack(GCItems.oxygenGear));
				}
				if (gear2 == null) {
					stats.extendedInventory.setInventorySlotContents(2, oxygenTank1);
				}
				if (gear3 == null) {
					stats.extendedInventory.setInventorySlotContents(3, oxygenTank2);
				}
				break;
			case 5:
				if (gear6 == null) {
					stats.extendedInventory.setInventorySlotContents(6, thermalPadding1);
				}
				if (gear7 == null) {
					stats.extendedInventory.setInventorySlotContents(7, thermalPadding2);
				}
				if (gear8 == null) {
					stats.extendedInventory.setInventorySlotContents(8, thermalPadding3);
				}
				if (gear9 == null) {
					stats.extendedInventory.setInventorySlotContents(9, thermalPadding4);
				}
				break;
			}
			itemStack.stackSize = 0;
		}
		return itemStack;
	}
}
