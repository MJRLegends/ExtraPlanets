package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKepler22bMapleTreeSapling extends BlockFlower {

	private static String[] saplings = { "blue_maple", "red_maple", "purple_maple", "yellow_maple" };
	@SideOnly(Side.CLIENT)
	private IIcon[] saplingsTextures;
	private String name;

	public BlockKepler22bMapleTreeSapling(String name) {
		super(0);
		this.setHardness(0.0F);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setBlockName(name);
		this.name = name;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.saplingsTextures = new IIcon[saplings.length];
		for (int i = 0; i < saplings.length; i++) {
			this.saplingsTextures[i] = iconRegister.registerIcon(Constants.TEXTURE_PREFIX + name + "_sapling_" + saplings[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if ((meta < 0) || (meta >= saplings.length)) {
			meta = 0;
		}
		return this.saplingsTextures[meta];
	}

	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
		return par1World.getBlock(par2, par3, par4) == this && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List listSaplings) {
		for (int i = 0; i < saplings.length; i++) {
			listSaplings.add(new ItemStack(item, 1, i));
		}
	}

	public void markOrGrowMarked(World world, int x, int y, int z, Random par1Random) {
		int l = world.getBlockMetadata(x, y, z);

		if ((l & 8) == 0) {
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		} else {
			this.growTree(world, x, y, z, par1Random);
		}
	}

	public void growTree(World world, int x, int y, int z, Random par1Random) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, par1Random, x, y, z))
			return;
		int l = world.getBlockMetadata(x, y, z) & 7;
		Object object = null;
		int i1 = 0;
		int j1 = 0;
		object = new WorldGenTrees(true, (2 + par1Random.nextInt(4)) * 2, 0, 0, false);
		world.setBlock(x, y, z, Blocks.air, 0, 4);
		if (!((WorldGenerator) object).generate(world, par1Random, x + i1, y, z + j1)) {
			world.setBlock(x, y, z, this, l, 4);
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random par1Random) {
		if (!world.isRemote) {
			super.updateTick(world, x, y, z, par1Random);

			if (world.getBlockLightValue(x, y + 1, z) >= 9 && par1Random.nextInt(7) == 0) {
				this.markOrGrowMarked(world, x, y, z, par1Random);
			}
		}
	}

}