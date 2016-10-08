package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

import com.mjr.extraplanets.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasicKepler22bTallGrass extends BlockBush implements IShearable {
	private static final String[] flowers = { "blueMapleShortGrass", "blueMapleMedGrass", "blueMapleTallGrass", "redMapleShortGrass", "redMapleMedGrass", "redMapleTallGrass", "purpleMapleShortGrass", "purpleMapleMedGrass", "purpleMapleTallGrass", "yellowMapleShortGrass", "yellowMapleMedGrass", "yellowMapleTallGrass" };
	@SideOnly(Side.CLIENT)
	private IIcon[] flowerTextures;
	private String name;

	public BlockBasicKepler22bTallGrass(String name) {
		super(Material.vine);
		this.blockHardness = 0;
		this.setBlockName(name);
		this.name = name;
		this.setLightLevel(0.15F);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iiconRegister) {
		this.flowerTextures = new IIcon[flowers.length];
		for (int i = 0; i < this.flowerTextures.length; ++i) {
			this.flowerTextures[i] = iiconRegister.registerIcon(Constants.TEXTURE_PREFIX + name + "_" + flowers[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta >= this.flowerTextures.length) {
			meta = 0;
		}
		return this.flowerTextures[meta];
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 0:
		case 3:
		case 6:
		case 9:
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.35F, 0.9F);
			break;
		case 1:
		case 4:
		case 7:
		case 10:
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
			break;
		case 2:
		case 5:
		case 8:
		case 11:
		default:
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
			break;
		}
	}

	@Override
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
		return super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return super.canBlockStay(world, x, y, z);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return null;
	}

	@Override
	public int quantityDroppedWithBonus(int p_149679_1_, Random rand) {
		return 1 + rand.nextInt(p_149679_1_ * 2 + 1);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
		{
			super.harvestBlock(world, player, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
		}
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 1; i < flowers.length; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (world.rand.nextInt(8) != 0)
			return ret;
		ItemStack seed = ForgeHooks.getGrassSeed(world);
		if (seed != null)
			ret.add(seed);
		return ret;
	}

	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		return ret;
	}
}