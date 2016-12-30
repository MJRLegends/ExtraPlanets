package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasicCeres extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] blockIcons;
	private String name;

	public BlockBasicCeres(String assetName) {
		super(Material.rock);
		this.blockHardness = 3.0F;
		this.setBlockName(assetName);
		this.name = assetName;
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcons = new IIcon[9];
		this.blockIcons[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Surface");
		this.blockIcons[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "SubSurface");
		this.blockIcons[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Stone");
		this.blockIcons[3] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreIron");
		this.blockIcons[4] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreTin");
		this.blockIcons[5] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreCopper");
		this.blockIcons[6] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreUranium");
		this.blockIcons[7] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "StoneBricks");
		this.blockIcons[8] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "uraniumBlock");
		this.blockIcon = this.blockIcons[0];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta < 0 || meta >= this.blockIcons.length) {
			return this.blockIcon;
		}

		return this.blockIcons[meta];
	}

	@Override
	public Item getItemDropped(int meta, Random random, int par3) {
		switch (meta) {
		default:
			return super.getItemDropped(meta, random, par3);
		}
	}

	@Override
	public int damageDropped(int meta) {
		switch (meta) {
		default:
			return meta;
		}
	}

	@Override
	public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
		return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		int var4;

		for (var4 = 0; var4 < this.blockIcons.length; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 8) {
			return new ItemStack(Item.getItemFromBlock(this), 1, metadata);
		}

		return super.getPickBlock(target, world, x, y, z, player);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta == 6) {
			EntityPlayer entity = world.getClosestPlayer(x + 0.5D, y + 0.5D, z + 0.5D, 10.0);
			if (entity != null) {
				EntityPlayerMP player = (EntityPlayerMP) entity;
				GCPlayerStats playerStats = GCPlayerStats.get(player);

				final ItemStack thermalPaddingHelm = playerStats.extendedInventory.getStackInSlot(6);
				final ItemStack thermalPaddingChestplate = playerStats.extendedInventory.getStackInSlot(7);
				final ItemStack thermalPaddingLeggings = playerStats.extendedInventory.getStackInSlot(8);
				final ItemStack thermalPaddingBoots = playerStats.extendedInventory.getStackInSlot(9);
				
				boolean giveEffect = false;
				
				if (thermalPaddingHelm == null && thermalPaddingChestplate == null && thermalPaddingLeggings == null && thermalPaddingBoots == null)
					giveEffect = true;
				else if (thermalPaddingHelm.getItem() != ExtraPlanets_Items.tier2ThermalPadding && thermalPaddingChestplate.getItem() != ExtraPlanets_Items.tier2ThermalPadding && thermalPaddingLeggings.getItem() != ExtraPlanets_Items.tier2ThermalPadding && thermalPaddingBoots.getItem() != ExtraPlanets_Items.tier2ThermalPadding
						&& thermalPaddingHelm.getItem() != ExtraPlanets_Items.tier3ThermalPadding && thermalPaddingChestplate.getItem() != ExtraPlanets_Items.tier3ThermalPadding && thermalPaddingLeggings.getItem() != ExtraPlanets_Items.tier3ThermalPadding && thermalPaddingBoots.getItem() != ExtraPlanets_Items.tier3ThermalPadding)
					giveEffect = true;

				if (giveEffect)
					entity.addPotionEffect(new PotionEffect(Potion.poison.getId(), 50, 1));
			}

		}
	}
}