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
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;

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

	public void markOrGrowMarked(World world, int x, int y, int z, Random random) {
		int meta = world.getBlockMetadata(x, y, z);
		Object object = null;
		if (object == null) {
			switch (meta) {
			case 0:
				object = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
				break;
			case 1:
				object = new WorldGenKepler22bTree(false, 8, 1, 1, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
				break;
			case 2:
				object = new WorldGenKepler22bTree(false, 8, 2, 2, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
				break;
			case 3:
				object = new WorldGenKepler22bTree(false, 8, 3, 3, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
				break;
			}
		}
		if (object != null) {
			world.setBlockToAir(x, y, z);

			if (!((WorldGenerator) object).generate(world, random, x, y, z)) {
				world.setBlock(x, y, z, this, meta, 2);
			}
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