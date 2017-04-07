package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasicKepler22b extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] blockIcons;
	private String name;

	public BlockBasicKepler22b(String assetName) {
		super(Material.rock);
		this.setBlockName(assetName);
		this.name = assetName;
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcons = new IIcon[13];
		this.blockIcons[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Dirt");
		this.blockIcons[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Stone");
		this.blockIcons[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreIron");
		this.blockIcons[3] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreCopper");
		this.blockIcons[4] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreTin");
		this.blockIcons[5] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreDenseCoal");
		this.blockIcons[6] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreBlueDiamonds");
		this.blockIcons[7] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreRedDiamonds");
		this.blockIcons[8] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OrePurpleDiamonds");
		this.blockIcons[9] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreYellowDiamonds");
		this.blockIcons[10] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "OreGreenDiamonds");
		this.blockIcons[11] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "StoneBricks");
		this.blockIcons[12] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "Cobblestone");
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
		case 1:
			return 0;
		default:
			return meta;
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		switch (metadata) {
		case 1:
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			items.add(new ItemStack(ExtraPlanets_Blocks.kepler22bBlocks, 1, 12));
			return items;
		default:
			return super.getDrops(world, x, y, z, metadata, fortune);
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

	/**
	 * Returns the block hardness at a location. Args: world, x, y, z
	 */
	@Override
	public float getBlockHardness(World world, int x, int y, int z) {
		final int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 0:
			return 0.6F;
		case 1:
			return 1.5F;
		default:
			return 0.0F;
		}
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		final int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 11:
		case 12:
		case 13:
		case 14:
			return 20;
		default:
			return 0;
		}
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		final int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 11:
		case 12:
		case 13:
		case 14:
			return 5;
		default:
			return 0;
		}
	}
}