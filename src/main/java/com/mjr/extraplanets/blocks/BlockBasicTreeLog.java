package com.mjr.extraplanets.blocks;

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

public class BlockBasicTreeLog extends BlockRotatedPillar {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	private String name;
	private String textureName;

	public BlockBasicTreeLog(String name, String textureName) {
		super(Material.wood);
		this.setHardness(1.5F);
		this.setHarvestLevel("axe", 0);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setBlockName(name);
		this.name = name;
		this.textureName = textureName;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
		return true;
	}

	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return 20;
	}

	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return 5;
	}

	@Override
	public int damageDropped(int damage) {
		return 20;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@Override
	public Item getItemDropped(int x, Random yRandom, int z) {
		return Item.getItemFromBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int p_149691_2_) {
		return side == 1 || side == 0 ? this.top : (side == 2 ? this.front : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(Constants.TEXTURE_PREFIX + textureName + "_log");
		this.top = p_149651_1_.registerIcon(Constants.TEXTURE_PREFIX + textureName + "_log_top");
		this.front = p_149651_1_.registerIcon(Constants.TEXTURE_PREFIX + textureName + "_log");
	}
	
    @SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List blockList)
    {
        blockList.add(new ItemStack(item, 1, 0));
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

	@Override
	protected IIcon getSideIcon(int arg0) {
		return null;
	}
}