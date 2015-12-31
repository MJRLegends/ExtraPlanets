package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasicMercury extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] blockIcons;
	private String name;

	public BlockBasicMercury(String assetName) {
		super(Material.rock);
		this.blockHardness = 3.0F;
		this.setBlockName(assetName);
		this.name = assetName;
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcons = new IIcon[7];
		this.blockIcons[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Surface");
		this.blockIcons[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "SubSurface");
		this.blockIcons[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Stone");
		this.blockIcons[3] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreIron");
		this.blockIcons[4] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreTin");
		this.blockIcons[5] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreCopper");
		this.blockIcons[6] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreMercury");
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
	public int damageDropped(int meta)
	{
		switch (meta)
		{
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
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 4) {
			return new ItemStack(Item.getItemFromBlock(this), 1, metadata);
		}

		return super.getPickBlock(target, world, x, y, z);
	}

}