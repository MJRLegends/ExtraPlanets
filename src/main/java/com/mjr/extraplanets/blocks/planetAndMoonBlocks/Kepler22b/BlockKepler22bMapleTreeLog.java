package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKepler22bMapleTreeLog extends BlockRotatedPillar {

	private final static String[] logs = { "blue_maple", "red_maple", "purple_maple", "yellow_maple" };

	@SideOnly(Side.CLIENT)
	private IIcon[] logsTextures;
	@SideOnly(Side.CLIENT)
	private IIcon[] logsTexturesTop;

	private String name;

	public BlockKepler22bMapleTreeLog(String name) {
		super(Material.wood);
		this.setHardness(1.5F);
		this.setHarvestLevel("axe", 0);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setBlockName(name);
		this.setLightOpacity(1);
		this.name = name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.logsTextures = new IIcon[logs.length];
		this.logsTexturesTop = new IIcon[logs.length];
		for (int i = 0; i < logs.length; i++) {
			this.logsTextures[i] = iconRegister.registerIcon(Constants.TEXTURE_PREFIX + name + "_log_" + logs[i] + "_side");
			this.logsTexturesTop[i] = iconRegister.registerIcon(Constants.TEXTURE_PREFIX + name + "_log_" + logs[i] + "_top");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int meta) {
		return this.logsTextures[meta % logsTextures.length];
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int meta) {
		return this.logsTexturesTop[meta % logsTexturesTop.length];
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
		return true;
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return 20;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return 5;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@Override
	public Item getItemDropped(int x, Random yRandom, int z) {
		return Item.getItemFromBlock(this);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List blockList) {
		for (int i = 0; i < logs.length; i++) {
			blockList.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess block, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isWood(IBlockAccess block, int x, int y, int z) {
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block bloque, int meta) {
		byte b0 = 4;
		int i1 = b0 + 1;

		if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)) {
			for (int j1 = -b0; j1 <= b0; ++j1) {
				for (int k1 = -b0; k1 <= b0; ++k1) {
					for (int l1 = -b0; l1 <= b0; ++l1) {
						Block block = world.getBlock(x + j1, y + k1, z + l1);
						if (block.isLeaves(world, x + j1, y + k1, z + l1)) {
							block.beginLeavesDecay(world, x + j1, y + k1, z + l1);
						}
					}
				}
			}
		}
	}
}