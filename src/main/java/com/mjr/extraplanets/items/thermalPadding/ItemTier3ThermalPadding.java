package com.mjr.extraplanets.items.thermalPadding;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.core.entities.player.GCCapabilities;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemTier3ThermalPadding  extends Item implements IItemThermal
{
    public static String[] names = { "tier3_thermal_helm", "tier3_thermal_chestplate", "tier3_thermal_leggings", "tier3_thermal_boots", "tier3_thermal_helm0", "tier3_thermal_chestplate0", "tier3_thermal_leggings0", "tier3_thermal_boots0" };

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
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List)
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
        return 50;
    }

    @Override
    public boolean isValidForSlot(ItemStack stack, int armorSlot)
    {
        return stack.getItemDamage() == armorSlot;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        if (playerIn instanceof EntityPlayerMP)
        {
            GCPlayerStats stats = playerIn.getCapability(GCCapabilities.GC_STATS_CAPABILITY, null);
            ItemStack gear = stats.getExtendedInventory().getStackInSlot(6);
            ItemStack gear1 = stats.getExtendedInventory().getStackInSlot(7);
            ItemStack gear2 = stats.getExtendedInventory().getStackInSlot(8);
            ItemStack gear3 = stats.getExtendedInventory().getStackInSlot(9);

            if (itemStackIn.getItemDamage() == 0)
            {
                if (gear == null)
                {
                    stats.getExtendedInventory().setInventorySlotContents(6, itemStackIn.copy());
                    itemStackIn.setCount(0);

                }
            }
            else if (itemStackIn.getItemDamage() == 1)
            {
                if (gear1 == null)
                {
                    stats.getExtendedInventory().setInventorySlotContents(7, itemStackIn.copy());
                    itemStackIn.setCount(0);

                }
            }
            else if (itemStackIn.getItemDamage() == 2)
            {
                if (gear2 == null)
                {
                    stats.getExtendedInventory().setInventorySlotContents(8, itemStackIn.copy());
                    itemStackIn.setCount(0);

                }
            }
            else if (itemStackIn.getItemDamage() == 3)
            {
                if (gear3 == null)
                {
                    stats.getExtendedInventory().setInventorySlotContents(9, itemStackIn.copy());
                    itemStackIn.setCount(0);

                }
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }
}