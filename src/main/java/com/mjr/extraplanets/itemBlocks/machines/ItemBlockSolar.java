package com.mjr.extraplanets.itemBlocks.machines;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.blocks.machines.BlockSolar;

public class ItemBlockSolar extends ItemBlockDesc {
	public ItemBlockSolar(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		int index = Math.min(Math.max(itemStack.getItemDamage() / 4, 0), BlockSolar.EnumSolarType.values().length);

		String name = BlockSolar.EnumSolarType.values()[index].getName();

		return this.getBlock().getUnlocalizedName() + "." + name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}
}
