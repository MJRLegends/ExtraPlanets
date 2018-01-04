package com.mjr.extraplanets.itemBlocks.machines;

import java.util.List;

import javax.annotation.Nullable;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockBasicDecontaminationUnit extends ItemBlockDesc {
	public ItemBlockBasicDecontaminationUnit(Block block) {
		super(block);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(par1ItemStack, worldIn, tooltip, flagIn);
    }
}