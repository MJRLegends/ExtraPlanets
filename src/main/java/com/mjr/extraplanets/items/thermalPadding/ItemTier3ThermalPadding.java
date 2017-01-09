package com.mjr.extraplanets.items.thermalPadding;

import java.util.List;

import com.mjr.extraplanets.ExtraPlanets;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTier3ThermalPadding  extends Item implements IItemThermal
{
    public static String[] names = { "tier3ThermalHelm", "tier3ThermalChestplate", "tier3ThermalLeggings", "tier3ThermalBoots", "tier3ThermalHelm0", "tier3ThermalChestplate0", "tier3ThermalLeggings0", "tier3ThermalBoots0" };

    public ItemTier3ThermalPadding(String assetName)
    {
        super();
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(assetName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public CreativeTabs getCreativeTab()
    {
        return ExtraPlanets.ArmorTab;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < ItemTier3ThermalPadding.names.length / 2; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        if (names.length > par1ItemStack.getItemDamage())
        {
            return "item." + ItemTier3ThermalPadding.names[par1ItemStack.getItemDamage()];
        }

        return "unnamed";
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }

    @Override
    public int getThermalStrength()
    {
        return 100;
    }

    @Override
    public boolean isValidForSlot(ItemStack stack, int armorSlot)
    {
        return stack.getItemDamage() == armorSlot;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (player instanceof EntityPlayerMP)
        {
            GCPlayerStats stats = GCPlayerStats.get((EntityPlayerMP) player);
            ItemStack gear = stats.extendedInventory.getStackInSlot(6);
            ItemStack gear1 = stats.extendedInventory.getStackInSlot(7);
            ItemStack gear2 = stats.extendedInventory.getStackInSlot(8);
            ItemStack gear3 = stats.extendedInventory.getStackInSlot(9);

            if (itemStack.getItemDamage() == 0)
            {
                if (gear == null)
                {
                    stats.extendedInventory.setInventorySlotContents(6, itemStack.copy());
                    itemStack.stackSize = 0;
                }
            }
            else if (itemStack.getItemDamage() == 1)
            {
                if (gear1 == null)
                {
                    stats.extendedInventory.setInventorySlotContents(7, itemStack.copy());
                    itemStack.stackSize = 0;
                }
            }
            else if (itemStack.getItemDamage() == 2)
            {
                if (gear2 == null)
                {
                    stats.extendedInventory.setInventorySlotContents(8, itemStack.copy());
                    itemStack.stackSize = 0;
                }
            }
            else if (itemStack.getItemDamage() == 3)
            {
                if (gear3 == null)
                {
                    stats.extendedInventory.setInventorySlotContents(9, itemStack.copy());
                    itemStack.stackSize = 0;
                }
            }
        }
        return itemStack;
    }
}