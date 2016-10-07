package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasicGrass extends Block {

	private String name, planetName;
	private IIcon[] grassIcon;

	protected BlockBasicGrass(String name, String planetName) {
		super(Material.grass);
		this.name = name;
		this.planetName = planetName;
		this.setBlockName(name + "Grass");
		this.setTickRandomly(true);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.blockHardness = 0.6F;
		this.setStepSound(soundTypeGrass);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.grassIcon = new IIcon[6];
		this.grassIcon[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.planetName + "_grass_dirt");
		this.grassIcon[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_top");
		this.grassIcon[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
		this.grassIcon[3] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
		this.grassIcon[4] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
		this.grassIcon[5] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + this.name + "_grass_side");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2) {
		if ((par1 < 0) || (par1 >= this.grassIcon.length)) {
			par1 = 1;
		}
		return this.grassIcon[par1];
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
				world.setBlock(x, y, z, ExtraPlanets_Blocks.kepler22bBlocks);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + rand.nextInt(3) - 1;
					int j1 = y + rand.nextInt(5) - 3;
					int k1 = z + rand.nextInt(3) - 1;
					if (world.getBlock(i1, j1, k1) == ExtraPlanets_Blocks.kepler22bBlocks && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						world.setBlock(i1, j1, k1, this);
					}
				}
			}
		}
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ExtraPlanets_Blocks.kepler22bBlocks.getItemDropped(0, p_149650_2_, p_149650_3_);
	}

	public int damageDropped(int par1, Random par2Random, int par3) {
		return 0;
	}

	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		Block plant = plantable.getPlant(world, x, y + 1, z);
		return (plant == ExtraPlanets_Blocks.blueSapling);
	}
}
